/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cezar.tcc.model;

import java.util.ArrayList;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author cezar
 */
public abstract class Person {
    private StringProperty firstName;
    private StringProperty lastName;
    private StringProperty genre;
    
    /**Construtor padrão**/
    public Person() {
        this.firstName = null;
        this.genre = null;
    }
    /** Construtor com atributo
     * @param firstName
     * @param lastName 
     * @param genre 
     */
    public Person(String firstName, String lastName, String genre) {
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);
        this.genre = new SimpleStringProperty(genre);
    }
    

    //Get and set

    public StringProperty getGenreProperty() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre.set(genre);
    }  

    public StringProperty getFirstNameProperty() {
        return firstName;
    }

    public void setFirstName(StringProperty firstName) {
        this.firstName = firstName;
    }

    public StringProperty getLastNameProperty() {
        return lastName;
    }

    public void setLastNameProperty(StringProperty lastName) {
        this.lastName = lastName;
    }

    public StringProperty getGenre() {
        return genre;
    }

    public void setGenre(StringProperty genre) {
        this.genre = genre;
    }
    
}

    

