package com.WorkshopJava.app;

import org.jetbrains.annotations.NotNull;

public class Vector {
    private double x;
    private double y;

    public Vector(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Vector(@NotNull Vector other) {
        this.x = other.x;
        this.y = other.y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return String.format("Vector {%f, %f}", this.x, this.y);
    }

    public void add(double x, double y) {
        this.x += x;
        this.y += y;
    }

    public double length() {
        return Math.sqrt(dot(this));
    }

    public void normalize() {
        double l = length();
        this.x /= l;
        this.y /= l;
    }

    public double dot(@NotNull Vector other) {
        return (this.x * other.x) + (this.y * other.y);
    }

}
