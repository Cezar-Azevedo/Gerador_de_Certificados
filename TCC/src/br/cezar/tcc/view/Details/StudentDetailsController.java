/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cezar.tcc.view.Details;

import br.cezar.tcc.model.Student;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 *  Controller da janela de detalhes de um Aluno
 * @author cezar
 */
public class StudentDetailsController implements Initializable{
    
    private Stage studentDetailsStage;
    
    @FXML
    private Label IDLabel;
    @FXML
    private Label regLabel;
    @FXML
    private Label firstNameLabel;
    @FXML
    private Label lastNameLabel;
    @FXML
    private Label tccTitleLabel;
    @FXML
    private Label genreLabel;
    @FXML
    private Label advisorlabel;

    
    /**
     * Define o Aluno do qual vão ser mostradas as informações
     * @param student 
     */
    public void getStudent(Student student){
       if(student != null){
            IDLabel.setText(Integer.toString(student.getID()));
            regLabel.setText(student.getRegProperty().get());
            firstNameLabel.setText(student.getFirstNameProperty().get());
            lastNameLabel.setText(student.getLastNameProperty().get());
            tccTitleLabel.setText(student.getTCCtitleProperty().get());
            genreLabel.setText(student.getGenre().get());
            advisorlabel.setText(student.getAdvisor().getFirstNameProperty().get());
        }else{
            IDLabel.setText("");
            regLabel.setText("");
            firstNameLabel.setText("");
            lastNameLabel.setText("");
            tccTitleLabel.setText("");
            genreLabel.setText("");
            advisorlabel.setText("");
       }
    }
    
    /**
     * Define o palco da classe {@link StudentDetailsController}
     * @param studentDetails 
     */
    public void setStudentDetails(Stage studentDetails){
        this.studentDetailsStage = studentDetails;
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }
    
}
