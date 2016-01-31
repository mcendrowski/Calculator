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
public class CalculatorService implements CalculatorStrategy {

    private AreaStrategy areaObject;

    public CalculatorService(AreaStrategy areaObject) {
        this.areaObject = areaObject;
    }

    public CalculatorService() {
    }
    

    public AreaStrategy getAreaObject() {
        return areaObject;
    }

    public void setAreaObject(AreaStrategy areaObject) {
        this.areaObject = areaObject;
    }
    
    
    @Override
    public double calculateArea() {
        return this.getAreaObject().area();
    }
    
}
