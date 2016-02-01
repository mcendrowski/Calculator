/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author mcendrowski
 */
public class Circle implements AreaStrategy {
    private Double radius;
    

    public Circle() {
    }

    public Circle(Double radius) {
        this.radius = radius;     
        
    }

    public Double getRadius() {
        return this.radius;
    }

    public void setRadius(Double radius) {
        this.radius = radius;
    }

   
    public double area(Double radius){
        return Math.PI*radius*radius;
    }
    
    @Override
    public Double area(){
        return Math.PI*this.radius*this.radius;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + (int) (Double.doubleToLongBits(this.radius) ^ (Double.doubleToLongBits(this.radius) >>> 32));
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
        final Circle other = (Circle) obj;
        if (Double.doubleToLongBits(this.radius) != Double.doubleToLongBits(other.radius)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Circle{" + "radius=" + radius + '}';
    }

   
   
}
