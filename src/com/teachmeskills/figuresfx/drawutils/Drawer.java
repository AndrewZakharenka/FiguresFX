package com.teachmeskills.figuresfx.drawutils;

import com.teachmeskills.figuresfx.figures.Figure;
import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;

public class Drawer<T extends Figure & Drawable> {
    private ArrayList<T> figures;

    public Drawer(ArrayList<T> figures) {
        this.figures = figures;
    }

    public void draw(GraphicsContext gc) {
        for (T figure : figures){
            if (figure != null){
                figure.draw(gc);
            }
        }
    }

}
