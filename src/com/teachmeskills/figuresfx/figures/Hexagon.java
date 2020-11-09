package com.teachmeskills.figuresfx.figures;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.Objects;

public class Hexagon extends Figure {
    private double height;
    private double width;

    public Hexagon( double cx, double cy, double lineWidth, Color color) {
        super(FIGURE_TYPE_HEXAGON, cx, cy, lineWidth, color);
    }

    public Hexagon(double cx, double cy, double lineWidth, Color color, double width, double height) {
        this(cx, cy, lineWidth, color);
        this.width = width < 10 ? 10 : width;
        this.height = height < 10 ? 10 : height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hexagon hexagon = (Hexagon) o;
        return Double.compare(hexagon.height, height) == 0 &&
                Double.compare(hexagon.width, width) == 0;
    }

    @Override
    public String toString() {
        return "Hexagon{" +
                "height=" + height +
                ", width=" + width +
                ", cx=" + cx +
                ", cy=" + cy +
                ", lineWidth=" + lineWidth +
                ", color=" + color +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(height, width);
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setLineWidth(lineWidth);
        gc.setFill(color);
        gc.fillPolygon(new double[]{cx - width, cx - width / 2, cx + width / 2, cx + width, cx + width / 2, cx - width / 2},
                        new double[]{cy, cy + height / 2, cy + height / 2, cy, cy - height / 2, cy - height / 2}, 6);
    }
}
