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
 * Objeto "Professor" com seus atributos e métodos
 * @author cezar
 */
public class Teacher extends Person{
    private static int cont;
    
    private StringProperty siape;
    private int ID;

    /**Lista de bancas atribuidas**/
    private ArrayList<Board> assignedBoars; 
    /**Lista de alunos orientados**/
    private ArrayList<Student> targetedStudents; 
    
    /**Construtor Padrão**/
    public Teacher() {
        super("padrao", "xulambis", "MF");
        ++cont;
        this.siape = new SimpleStringProperty("1111111111111");
        this.ID = cont;
        this.assignedBoars = new ArrayList<>();
        this.targetedStudents = new ArrayList<>();
    }
    
    /**Construtor com atributos 
     * @param firstName 
     * @param lastName 
     * @param genre 
     * @param assignedBoard
     * @param student
     */
    public Teacher(String firstName, String lastName, String genre, 
            Board assignedBoard, Student student) {
        super(firstName, lastName, genre);
        ++cont;
        this.assignedBoars.add(assignedBoard);
        this.targetedStudents.add(student);
    }
    
    /**
     * Recupera uma lista de "Bancas" atribuidas à determinado "Professor"
     * @return String de Bancas
     */
    
    public String getArrayBoardString(){
        if(assignedBoars == null) return "";
        String aux = "";
        for(Board b : assignedBoars){
            aux = b.getTitle() + " ";
            aux += ",\n";
        }
        return aux;
    }
    
    /**
     * Recupera uma String com os nomes dos alunos orientados
     * @return String com lista de alunos
     */
    public String getArrayTargetedStudentsString(){
        if(targetedStudents == null) return "Nenhum ";
        String aux = "";
        for(Student s : targetedStudents){
            aux += s.getFirstNameProperty().get() + " " + s.getLastNameProperty().get();
            aux += ",\n";
        }
        return aux;
    }
    
    //getters and setters

    public StringProperty getSiapeProperty() {
        return siape;
    }

    public void setSiape(StringProperty siape) {
        this.siape = siape;
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
       
    public ArrayList<Board> getAssignedBoards() {
        return assignedBoars;
    }

    public void setAssignedBoards(ArrayList<Board> boards) {
        this.assignedBoars = boards;
    }

    public ArrayList<Student> getTargetedStudents() {
        return targetedStudents;
    }

    public void setTargetedStudents(ArrayList<Student> targetedStudents) {
        this.targetedStudents = targetedStudents;
    }

    public ArrayList<Board> getAssignedBoars() {
        return assignedBoars;
    }

    public void setAssignedBoars(ArrayList<Board> assignedBoars) {
        this.assignedBoars = assignedBoars;
    }
    public static int getCont() {
        return cont;
    }

    public static void setCont(int aReg) {
        cont = aReg;
    }
}
