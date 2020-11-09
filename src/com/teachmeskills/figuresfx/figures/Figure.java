package com.teachmeskills.figuresfx.figures;

import com.teachmeskills.figuresfx.drawutils.Drawable;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public abstract class Figure implements Drawable {
    public static final String FIGURE_TYPE_CIRCLE = "Круг";
    public static final String FIGURE_TYPE_RECTANGLE = "Прямоугольник";
    public static final String FIGURE_TYPE_TRIANGLE = "Треугольник";
    public static final String FIGURE_TYPE_HEXAGON = "Многоугольник";
    public static final String FIGURE_TYPE_FLAG = "Флаг";

    private String type;

    protected double cx;
    protected double cy;
    protected double lineWidth;
    protected Color color;

    public Figure(String type, double cx, double cy, double lineWidth, Color color) {
        this.type = type;
        this.cx = cx;
        this.cy = cy;
        this.lineWidth = lineWidth;
        this.color = color;
    }

    public double getCx() {
        return cx;
    }

    public void setCx(double cx) {
        this.cx = cx;
    }

    public double getCy() {
        return cy;
    }

    public void setCy(double cy) {
        this.cy = cy;
    }

    public double getLineWidth() {
        return lineWidth;
    }

    public void setLineWidth(double lineWidth) {
        this.lineWidth = lineWidth;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public String getType() {
        return type;
    }

    public abstract void draw(GraphicsContext gc);
}
