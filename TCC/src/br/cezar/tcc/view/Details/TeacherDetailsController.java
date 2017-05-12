/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cezar.tcc.view.Details;

import br.cezar.tcc.model.Teacher;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

/**
 *
 * @author cezar
 */
public class TeacherDetailsController implements Initializable{
    private Stage teacherDetailsStage;
    
    private Label IDLabel;
    private Label siapeLabel;
    private Label firstNameLabel;
    private Label lastNameLabel;
    private Label genreLabel;
    @FXML
    private TextArea assignedBoarsLabel;
    @FXML
    private TextArea targetedStudentsLabel;

    /**
     * Define o palco da classe{@link TeacherDetailsController}
     * @param teacherDetailsStage 
     */
    public void setTeacherDetails(Stage teacherDetailsStage){
        this.teacherDetailsStage = teacherDetailsStage;
    }
    
    /**
     * seta os atributos de um {@link Teacher} na tela de detalhes
     * @param teacher 
     */
    public void getTeacher(Teacher teacher){
        IDLabel.setText(Integer.toString(teacher.getID()));
        siapeLabel.setText(teacher.getSiapeProperty().get());
        firstNameLabel.setText(teacher.getFirstNameProperty().get());
        lastNameLabel.setText(teacher.getLastNameProperty().get());
        genreLabel.setText(teacher.getSiapeProperty().get());
        targetedStudentsLabel.setText(teacher.getArrayTargetedStudentsString());
        assignedBoarsLabel.setText(teacher.getArrayBoardString());
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

}
