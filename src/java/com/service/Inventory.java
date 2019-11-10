/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

/**
 *
 * @author holah
 */
public class Inventory {

    public Inventory() {
    }

    
    public Inventory(int id, String brand, String model, String functions, String quantity) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.functions = functions;
        this.quantity = quantity;
    }   
    
    private int id;

    /**
     * Get the value of id
     *
     * @return the value of id
     */
    public int getId() {
        return id;
    }

    /**
     * Set the value of id
     *
     * @param id new value of id
     */
    public void setId(int id) {
        this.id = id;
    }

    private String brand;

    /**
     * Get the value of brand
     *
     * @return the value of brand
     */
    public String getBrand() {
        return brand;
    }

    /**
     * Set the value of brand
     *
     * @param brand new value of brand
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    private String model;

    /**
     * Get the value of model
     *
     * @return the value of model
     */
    public String getModel() {
        return model;
    }

    /**
     * Set the value of model
     *
     * @param model new value of model
     */
    public void setModel(String model) {
        this.model = model;
    }

    private String functions;

    /**
     * Get the value of functions
     *
     * @return the value of functions
     */
    public String getFunctions() {
        return functions;
    }

    /**
     * Set the value of functions
     *
     * @param functions new value of functions
     */
    public void setFunctions(String functions) {
        this.functions = functions;
    }

    private String quantity;

    /**
     * Get the value of quantity
     *
     * @return the value of quantity
     */
    public String getQuantity() {
        return quantity;
    }

    /**
     * Set the value of quantity
     *
     * @param quantity new value of quantity
     */
    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

}
