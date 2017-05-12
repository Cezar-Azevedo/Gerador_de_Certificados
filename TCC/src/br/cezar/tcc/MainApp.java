/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cezar.tcc;

import br.cezar.tcc.model.Board;
import br.cezar.tcc.model.Student;
import br.cezar.tcc.model.Teacher;
import br.cezar.tcc.view.Details.BoardDetailsController;
import br.cezar.tcc.view.Details.StudentDetailsController;
import br.cezar.tcc.view.Details.TeacherDetailsController;
import br.cezar.tcc.view.HomeScreenController;
import java.io.IOException;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author cezar
 */
public class MainApp extends Application {
    
    private Stage primaryStage;
    private BorderPane homeScreen;
  
    private ObservableList<Student> studentstable = FXCollections.observableArrayList();
    private ObservableList<Teacher> teachersstable = FXCollections.observableArrayList();
    private ObservableList<Board> boardstable = FXCollections.observableArrayList();
    

    public MainApp(){
        boardstable.add(new Board());
        teachersstable.add(new Teacher());
        studentstable.add(new Student("cezar", "azevedo", "M", "gerador", new Teacher()));
        studentstable.add(new Student("chico", "doido", "F", "nada", new Teacher()));
        teachersstable.get(0).getTargetedStudents().add(
                studentstable.get(0));
        teachersstable.get(0).getTargetedStudents().add(
                studentstable.get(1));
 
       
    }
    
    @Override
    public void start(Stage primaryStage) {
        
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Gerador de certificados");
        
        initRootLayout();
        showTables();
        
        
    }

    private void initRootLayout() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/FXMLRootLayout.fxml"));
            homeScreen = (BorderPane) loader.load();
            
            Scene scene = new Scene(homeScreen);
            primaryStage.setScene(scene);
            primaryStage.show();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Mostra as tabelas na cena principal
     */
    private void showTables() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/FXMLHomeScreen.fxml"));
            AnchorPane tables = (AnchorPane) loader.load();
            
            homeScreen.setCenter(tables);
            
            HomeScreenController controller = loader.getController();
            controller.setMainApp(this);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Configura a tela de detalhes
     */
    private void configWindowdetails(Object object, AnchorPane page, 
            FXMLLoader loader, Stage objectDetailsStage){
        
        objectDetailsStage.initModality(Modality.WINDOW_MODAL);
        objectDetailsStage.initOwner(primaryStage);
        Scene scene = new Scene(page);
        objectDetailsStage.setScene(scene);
        
        if(object instanceof Student){
            StudentDetailsController controller = loader.getController();
            controller.setStudentDetails(objectDetailsStage);
            controller.getStudent((Student) object);
        }else if(object instanceof Teacher){
            TeacherDetailsController controller = loader.getController();
            controller.setTeacherDetails(objectDetailsStage);
            controller.getTeacher((Teacher) object);
        }else if(object instanceof Board){
            BoardDetailsController controller = loader.getController();
            controller.setBoardDetails(objectDetailsStage);
            controller.getBoard((Board) object);
        }
        
        objectDetailsStage.showAndWait();
                
    }
    
    /**
     * Mostra a janela de Detalhes do elemento selecionado
     * @param object 
     */
    public void showDetails(Object object){
        try{
            AnchorPane page;
            
            if(object instanceof Student){
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(MainApp.class.getResource("view/Details/FXMLStudentDetails.fxml"));
                page = (AnchorPane) loader.load();
                
                Stage studentDetailsStage = new Stage();
                studentDetailsStage.setTitle("Detalhes do Aluno");
                configWindowdetails(object, page, loader, studentDetailsStage);
                
            }else if(object instanceof Teacher){
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(MainApp.class.getResource("view/Details/FXMLTeacherDetails.fxml"));
                page = (AnchorPane) loader.load();
                
                Stage teacherDetailsStage = new Stage();                
                teacherDetailsStage.setTitle("Detalhes do Professor");
                configWindowdetails(object, page, loader, teacherDetailsStage);
                
           }else if(object instanceof Board){
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(MainApp.class.getResource("view/Details/FXMLBoardDetails.fxml"));
                page = (AnchorPane) loader.load();
                
                Stage boardDetailsStage = new Stage();
                boardDetailsStage.setTitle("Detalhes da Banca");
                configWindowdetails(object, page, loader, boardDetailsStage);
            }

        }catch(IOException e){
            e.printStackTrace();
        }
        
    }
    
    public ObservableList<Teacher> getTeachersstable() {
        return teachersstable;
    }

    public void setTeachersstable(ObservableList<Teacher> teachersstable) {
        this.teachersstable = teachersstable;
    }

    public ObservableList<Board> getBoardstable() {
        return boardstable;
    }

    public void setBoardstable(ObservableList<Board> boardstable) {
        this.boardstable = boardstable;
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public BorderPane getRootLayout() {
        return homeScreen;
    }

    public void setRootLayout(BorderPane rootLayout) {
        this.homeScreen = rootLayout;
    }

    public ObservableList<Student> getStudentstable() {
        return studentstable;
    }

    public void setStudentstable(ObservableList<Student> studentstable) {
        this.studentstable = studentstable;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
