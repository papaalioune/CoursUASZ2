package com.uasz.pacisse.coursuasz2.model.webservices;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.Serializable;

/**
 * Créé par Dr Cissé, le 22/05/2023 à 02:45
 */
@SuppressWarnings("serial") //With this annotation we are going to hide compiler warnings
public class RetoursOperationsGEDT implements Serializable {
    private int valeurRetourOperationsGEDT;
    private String messageRetourOperationsGEDT;
    private JSONObject dataAsObject;
    private JSONArray dataAsArray;

    public RetoursOperationsGEDT() {
    }

    public RetoursOperationsGEDT(int valeurRetourOperationsGEDT, String messageRetourOperationsGEDT, JSONObject dataAsObject, JSONArray dataAsArray) {
        this.valeurRetourOperationsGEDT = valeurRetourOperationsGEDT;
        this.messageRetourOperationsGEDT = messageRetourOperationsGEDT;
        this.dataAsObject = dataAsObject;
        this.dataAsArray = dataAsArray;
    }

    public RetoursOperationsGEDT(int valeurRetourOperationsGEDT, String messageRetourOperationsGEDT, JSONArray dataAsArray) {
        this.valeurRetourOperationsGEDT = valeurRetourOperationsGEDT;
        this.messageRetourOperationsGEDT = messageRetourOperationsGEDT;
        this.dataAsArray = dataAsArray;
    }

    public int getValeurRetourOperationsGEDT() {
        return valeurRetourOperationsGEDT;
    }

    public void setValeurRetourOperationsGEDT(int valeurRetourOperationsGEDT) {
        this.valeurRetourOperationsGEDT = valeurRetourOperationsGEDT;
    }

    public String getMessageRetourOperationsGEDT() {
        return messageRetourOperationsGEDT;
    }

    public void setMessageRetourOperationsGEDT(String messageRetourOperationsGEDT) {
        this.messageRetourOperationsGEDT = messageRetourOperationsGEDT;
    }

    public JSONObject getDataAsObject() {
        return dataAsObject;
    }

    public void setDataAsObject(JSONObject dataAsObject) {
        this.dataAsObject = dataAsObject;
    }

    public JSONArray getDataAsArray() {
        return dataAsArray;
    }

    public void setDataAsArray(JSONArray dataAsArray) {
        this.dataAsArray = dataAsArray;
    }
}
