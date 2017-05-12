/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cezar.tcc.model;

import br.cezar.tcc.util.DateUtil;
import java.time.LocalDate;
import java.util.ArrayList;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author cezar
 */
public class Board {
    private static int reg; // contador de registros
    private int ID;
    private StringProperty place;
    private StringProperty title;
    private ArrayList<Teacher> teachersEvaluators;
    private ObjectProperty<LocalDate> date;
    private IntegerProperty half; /** Semestre **/

    /**Construtor padrão**/
    public Board() {
        ++reg;
        this.ID = reg;
        this.title = new SimpleStringProperty("default");
        this.place = new SimpleStringProperty("casa do caralho");
        this.half = new SimpleIntegerProperty(2);
        this.date = new SimpleObjectProperty<>(DateUtil.toLocalDate("10/01/1996"));
    }

    /**Construtor com parâmetros
     * 
     * @param place
     * @param title
     * @param teacher
     * @param date
     * @param half 
     */
    public Board(String place, String title, 
            Teacher teacher, String date, 
            int half) {
        ++reg;
        this.place = new SimpleStringProperty(place);
        this.title = new SimpleStringProperty(title);
        this.teachersEvaluators.add(teacher);
        this.date = new SimpleObjectProperty(DateUtil.toLocalDate(date));
        this.half = new SimpleIntegerProperty(half);
    }
    
    /**
     * Recupera uma String com os nomes dos professores que compõem a
     * banca avaliadora
     * @return String com lista de alunos
     */
    public String getTeachersEvaluatorsString(){
        if(teachersEvaluators == null) return "Nenhum";
        String aux = "";
        for(Teacher s : teachersEvaluators){
            aux += s.getFirstNameProperty().get() + " " + s.getLastNameProperty().get();
            aux += ",\n";
        }
        return aux;
    }

    //get and set
    public int getID() {
        return ID;
    }
    /**
     * Recupera a ID da Banca em fomrato String Property
     * @return {@link StringProperty} 
     */
    public StringProperty getIDStringProperty(){
        return new SimpleStringProperty(Integer.toString(ID));
    }
    
    public void setID(int ID) {
        this.ID = ID;
    }
    
    public static int getReg() {
        return reg;
    }

    public static void setReg(int reg) {
        Board.reg = reg;
    }
    

    public StringProperty getPlaceProperty() {
        return place;
    }
    
    public String getPlace(){
        return place.get();
    }

    public void setPlace(String place) {
        this.place.set(place);
    }

    public StringProperty getTitleProperty() {
        return title;
    }
    
    public String getTitle(){
        return title.get();
    }

    public void setTitle(String title) {
        this.title.set(title);
    }

    public ArrayList<Teacher> getTeachersEvaluators() {
        return teachersEvaluators;
    }

    public void setTeachersEvaluators(ArrayList<Teacher> teachersEvaluators) {
        this.teachersEvaluators = teachersEvaluators;
    }

    public ObjectProperty<LocalDate> getDate() {
        return date;
    }

    public void setDate(ObjectProperty<LocalDate> date) {
        this.date = date;
    }

    public IntegerProperty getHalfProperty() {
        return half;
    }
    
    
    public StringProperty getHalfStringProperty(){
        return new SimpleStringProperty(Integer.toString(half.get()));
    }
    
    public int getHalf(){
        return half.get();
    }

    
    public void setHalf(int half) {
        this.half.set(half);
    }
    
}
