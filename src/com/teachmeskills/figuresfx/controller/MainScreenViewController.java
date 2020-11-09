package com.teachmeskills.figuresfx.controller;

import com.teachmeskills.figuresfx.customExceptions.IsEmptyArrayListException;
import com.teachmeskills.figuresfx.customExceptions.IsUnknownFigureTypeException;
import com.teachmeskills.figuresfx.drawutils.Drawer;
import com.teachmeskills.figuresfx.figures.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import org.apache.log4j.Logger;
import javafx.scene.control.ComboBox;

import java.io.IOError;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;

public class MainScreenViewController implements Initializable {
    private ArrayList<Figure> figures;
    private Random random;
    private ObservableList<String> typeFigure;

    private static final Logger logger = Logger.getLogger(MainScreenViewController.class);

    @FXML
    private ComboBox comboBoxFigure;
    @FXML
    private Canvas canvas;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        figures = new ArrayList<>();
        random = new Random(System.currentTimeMillis());
        ObservableList<String> typeFigure = FXCollections.observableArrayList(Figure.FIGURE_TYPE_CIRCLE,
                Figure.FIGURE_TYPE_RECTANGLE, Figure.FIGURE_TYPE_TRIANGLE, Figure.FIGURE_TYPE_HEXAGON, Figure.FIGURE_TYPE_FLAG);
        comboBoxFigure.setItems(typeFigure);
        comboBoxFigure.setValue("Круг");
    }

    private void addFigure(Figure figure) {
        figures.add(figure);
    }

    private Figure createFigure(double x, double y) throws IsUnknownFigureTypeException {
        Figure figure = null;
        switch ((String) comboBoxFigure.getValue()) {
            case Figure.FIGURE_TYPE_CIRCLE:
                try {
                    figure = new Circle(x, y, Math.max(random.nextInt(3), 10), Color.BLUE, random.nextInt(50));
                    logger.warn("Фигура круг добавлена!");
                } catch (IOError err) {
                    logger.error(err.getMessage() + "Фигура круг не была создана!");
                }
                break;
            case Figure.FIGURE_TYPE_TRIANGLE:
                try {
                    figure = new Triangle(x, y, Math.max(random.nextInt(3), 10), Color.RED, random.nextInt(100), random.nextInt(50));
                    logger.warn("Фигура треугольник добавлена!");
                } catch (IOError err) {
                    logger.error(err.getMessage() + "Фигура треугольник не была создана!");
                }
                break;
            case Figure.FIGURE_TYPE_RECTANGLE:
                try {
                    figure = new Rectangle(x, y, Math.max(random.nextInt(3), 10), Color.GREEN, random.nextInt(100), random.nextInt(50));
                    logger.warn("Фигура прямоугольник добавлена!");
                } catch (IOError err) {
                    logger.error(err.getMessage() + "Фигура прямоугольник не была создана!");
                }
                break;
            case Figure.FIGURE_TYPE_HEXAGON:
                try {
                    figure = new Hexagon(x, y, Math.max(random.nextInt(3), 10), Color.PURPLE, random.nextInt(100), random.nextInt(100));
                    logger.warn("Фигура многоугольник добавлена!");
                } catch (IOError err) {
                    logger.error(err.getMessage() + "Фигура многоулгольник не была создана!");
                }
                break;
            case Figure.FIGURE_TYPE_FLAG:
                try {
                    figure = new Flag(x, y, Math.max(random.nextInt(3), 10), Color.RED, 100, 200);
                    logger.warn("Фигура флаг добавлена!");
                } catch (IOError err) {
                    logger.error(err.getMessage() + "Фигура флаг не была создана!");
                }
                break;
            default:
                throw new IsUnknownFigureTypeException("Неизвестный тип фигуры!");
        }
        return figure;
    }

    private void repaint() {
        canvas.getGraphicsContext2D().clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

        Drawer<Figure> drawer = new Drawer<>(figures);
        drawer.draw(canvas.getGraphicsContext2D());
    }

    @FXML
    private void onMouseClicked(MouseEvent mouseEvent) {
        try {
            addFigure(createFigure(mouseEvent.getX(), mouseEvent.getY()));
        } catch (IsUnknownFigureTypeException err) {
            logger.error(err.getMessage());
        }
        repaint();
    }

    @FXML
    public void onMouseClickedBtnClearCanvas(MouseEvent mouseEvent) {
        canvas.getGraphicsContext2D().clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        figures.clear();
    }

    @FXML
    public void onMouseClickBtnBack(MouseEvent mouseEvent) throws IsEmptyArrayListException {
        try {
            if (figures.isEmpty()) {
                throw new IsEmptyArrayListException();
            } else {
                figures.remove(figures.size() - 1);
                repaint();
            }
        } catch (IsEmptyArrayListException err) {
            logger.error(err.getMessage());
        }
    }
}
