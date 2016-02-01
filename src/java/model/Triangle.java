/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author MCENDROWSKI
 */
public class Triangle implements AreaStrategy {

    private double sideA;
    private double sideB;
    private double sideC;

    public Triangle() {
    }

    public Triangle(double sideA, double sideB, double sideC) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    public double getSideA() {
        return sideA;
    }

    public void setSideA(double sideA) {
        this.sideA = sideA;
    }

    public double getSideB() {
        return sideB;
    }

    public void setSideB(double sideB) {
        this.sideB = sideB;
    }

    public double getSideC() {
        return sideC;
    }

    public void setSideC(double sideC) {
        this.sideC = sideC;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + (int) (Double.doubleToLongBits(this.sideA) ^ (Double.doubleToLongBits(this.sideA) >>> 32));
        hash = 17 * hash + (int) (Double.doubleToLongBits(this.sideB) ^ (Double.doubleToLongBits(this.sideB) >>> 32));
        hash = 17 * hash + (int) (Double.doubleToLongBits(this.sideC) ^ (Double.doubleToLongBits(this.sideC) >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Triangle other = (Triangle) obj;
        if (Double.doubleToLongBits(this.sideA) != Double.doubleToLongBits(other.sideA)) {
            return false;
        }
        if (Double.doubleToLongBits(this.sideB) != Double.doubleToLongBits(other.sideB)) {
            return false;
        }
        if (Double.doubleToLongBits(this.sideC) != Double.doubleToLongBits(other.sideC)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Triangle{" + "sideA=" + sideA + ", sideB=" + sideB + ", sideC=" + sideC + '}';
    }

    private double semiperimeter() {
        return (this.sideA + this.sideB + this.sideC) * 0.5;
    }

    @Override
    public double area() {
        return Math.sqrt(this.semiperimeter() * (this.semiperimeter() - sideA) * (this.semiperimeter() - sideB) * (this.semiperimeter() - sideC));
    }

}
