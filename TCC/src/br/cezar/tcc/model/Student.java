/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cezar.tcc.model;

import java.util.Random;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author cezar
 */
public class Student extends Person {
    
    private static int cont;
    private StringProperty reg; 
    private int ID;
    private StringProperty TCCtitle;
    private Teacher advisor;         

    /** construtor padrão**/
    public Student(){
        cont++;
        this.ID = cont;
    }
    
    /**Construtor com parametros 
     * @param firstName 
     * @param lastName 
     * @param genre 
     * @param TCCtitle 
     * @param advisor 
     */
    public Student(String firstName, String lastName, String genre, String TCCtitle, Teacher advisor) {
        super(firstName, lastName, genre);
        ++cont;
        this.reg = new SimpleStringProperty("00000000000");
        this.ID = cont;
        this.TCCtitle = new SimpleStringProperty(TCCtitle);
        this.advisor = advisor;
    }
    
    

    //Get and Set    
    public StringProperty getRegProperty() {
        return reg;
    }
    public void setRegProperty(StringProperty reg) {
        this.reg = reg;
    }

    public int getID() {
        return ID;
    }
    
    public StringProperty getIDStringProperty(){
        return new SimpleStringProperty(Integer.toString(ID));
    }

    public void setID(int ID) {
        this.ID = ID;
    } 
    
    public static int getCont() {
        return cont;
    }

    public static void setCont(int cont) {
        Student.cont = cont;
    }

    public StringProperty getTCCtitle() {
        return TCCtitle;
    }

    /*Get Set*/
    public void setTCCtitle(StringProperty TCCtitle) {
        this.TCCtitle = TCCtitle;
    }

    public StringProperty getTCCtitleProperty() {
        return TCCtitle;
    }

    public void setTCCtitle(String TCCtitle) {
        this.TCCtitle.set(TCCtitle);
    }

    public Teacher getAdvisor() {
        return advisor;
    }
    
    public StringProperty getAdvisorProperty(){
        return advisor.getFirstNameProperty();
    }

    /**
     *
     * @param advisor
     */
    public void setAdvisor(Teacher advisor) {
        this.advisor = advisor;
    }
    
}
