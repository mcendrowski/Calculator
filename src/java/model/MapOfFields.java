/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Map;

/**
 *
 * @author mcendrowski
 */
public class MapOfFields {
    private Map<String,String> fieldsMap;

    public MapOfFields() {
    }

    public Map<String, String> getFieldsMap() {
        return fieldsMap;
    }

    public void setFieldsMap(Map<String, String> fieldsMap) {
        this.fieldsMap = fieldsMap;
    }
    public void changeItem(String attribute,String parameter){
        this.fieldsMap.put(attribute, parameter);
        
    }
    
    public void changeAll(Map<String,String> map){
        this.fieldsMap.putAll(map);
    }
    
}
