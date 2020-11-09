package com.teachmeskills.figuresfx.figures;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

import java.util.Objects;

public class Flag extends Figure {
    private double height;
    private double width;

    public Flag(double cx, double cy, double lineWidth, Color color) {
        super(FIGURE_TYPE_FLAG, cx, cy, lineWidth, color);
    }

    public Flag(double cx, double cy, double lineWidth, Color color, double height, double width) {
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
        Flag flag = (Flag) o;
        return Double.compare(flag.height, height) == 0 &&
                Double.compare(flag.width, width) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(height, width);
    }

    @Override
    public String toString() {
        return "Flag{" +
                "height=" + height +
                ", width=" + width +
                ", cx=" + cx +
                ", cy=" + cy +
                ", lineWidth=" + lineWidth +
                ", color=" + color +
                '}';
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setLineWidth(lineWidth);
        gc.setStroke(Color.RED);
        gc.setFill(Color.WHITE);
        gc.strokeRect(cx - width / 2, cy - height / 2, width, height);
        gc.setFill(Color.RED);
        gc.strokeRect(cx - width / 2, cy - (height / 3) / 2, width, height / 3);
        gc.fillRect(cx - width / 2, cy - (height / 3) / 2, width, height / 3);
        gc.drawImage(new Image("/pictures/gerb.jpg", width / 3, height / 2, true, true),
                cx - (width / 3) / 4, cy - (height / 2) / 2);
    }
}
