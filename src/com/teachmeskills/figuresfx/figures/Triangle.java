package com.teachmeskills.figuresfx.figures;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.Objects;

public class Triangle extends Figure {
    private double footing;
    private double height;


    public Triangle(double cx, double cy, double lineWidth, Color color) {
        super(FIGURE_TYPE_TRIANGLE, cx, cy, lineWidth, color);
    }

    public Triangle(double cx, double cy, double lineWidth, Color color, double footing, double height) {
        this(cx, cy, lineWidth, color);
        this.footing = footing < 10 ? 10 : footing;
        this.height = height < 10 ? 10 : height;
    }

    public double getFooting() {
        return footing;
    }

    public void setFooting(double footing) {
        this.footing = footing;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        return Double.compare(triangle.footing, footing) == 0 &&
                Double.compare(triangle.height, height) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(footing, height);
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "footing=" + footing +
                ", height=" + height +
                ", cx=" + cx +
                ", cy=" + cy +
                ", lineWidth=" + lineWidth +
                ", color=" + color +
                '}';
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setLineWidth(lineWidth);
        gc.setFill(color);
        gc.fillPolygon(new double[]{cx - footing / 2, cx, cx + footing / 2}, new double[]{cy + height / 2, cy - height / 2, cy + height / 2}, 3);
    }
}
