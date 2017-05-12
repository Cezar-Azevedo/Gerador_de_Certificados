/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cezar.tcc.view;

import br.cezar.tcc.MainApp;
import br.cezar.tcc.model.Board;
import br.cezar.tcc.model.Student;
import br.cezar.tcc.model.Teacher;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 *
 * @author cezar
 */
public class HomeScreenController implements Initializable{
   
    private MainApp mainApp; // referencia à classe main app
    
    //Variáveis da Tab Pane
    @FXML
    private TabPane tablesPane;
    
    @FXML
    private Tab studentsTab;
    @FXML
    private Tab teachersTab;
    @FXML
    private Tab boardsTab;
    

    //Variáveis da tabela "Alunos"
    @FXML
    private TableView<Student> studentstTableView;
    
    @FXML
    private TableColumn<Student,String> studentNameColumn;
    @FXML
    private TableColumn<Student,String> studentGenreColumn;
    @FXML
    private TableColumn<Student,String> studentTccColumn;
    @FXML
    private TableColumn<Student,String> studentAdvisorColumn;
    @FXML
    private TableColumn<Student,String> studentRegColumn;
    
    //variáveis da tabela "Professores"
    @FXML
    private TableView teachersTableView;
    
    @FXML
    private TableColumn<Teacher, String> teacherRegColumn;
    @FXML
    private TableColumn<Teacher, String> teacherNameColumn;
    @FXML
    private TableColumn<Teacher, String> teacherGenreColumn;
    
    //variáveis da tabela "Bancas"    
    @FXML
    private TableView boardsTableView;
    
    @FXML
    private TableColumn<Board, String> boardRegColumn;
    @FXML
    private TableColumn<Board, String> boardTitleColumn;
    @FXML
    private TableColumn<Board, String> boardPlaceColumn;
    @FXML
    private TableColumn<Board, String> boardHalfColumn;
    
    
    /**
    * seta todas as abas do tab pane
    */
    public void setTabs(){
        studentsTab.setContent(studentstTableView);
        teachersTab.setContent(teachersTableView);
        boardsTab.setContent(boardsTableView);
    }
     
    
    /**
     * Seta todas as células da tabela "Bancas" na table view
     */
    public void setCellsBoards(){
        boardRegColumn.setCellValueFactory(cell -> cell.getValue().getIDStringProperty());
        boardTitleColumn.setCellValueFactory(cell -> cell.getValue().getTitleProperty());
        boardPlaceColumn.setCellValueFactory(cell -> cell.getValue().getPlaceProperty());
        boardHalfColumn.setCellValueFactory(cell -> cell.getValue().getHalfStringProperty());
    }
    
    /**
     * Seta todas as células da tabela "Professor" na table view
     */
    public void setCellsTeachers(){
        teacherRegColumn.setCellValueFactory(cell -> cell.getValue().getIDStringProperty());
        teacherNameColumn.setCellValueFactory(cell -> cell.getValue().getFirstNameProperty());
        teacherGenreColumn.setCellValueFactory(cell -> cell.getValue().getGenreProperty());
    }
    
    
    /**
     * Seta todas as células da tabela "Alunos" na table view
     */
    public void setCellsStudents(){
        studentRegColumn.setCellValueFactory(cell -> cell.getValue().getIDStringProperty());
        studentNameColumn.setCellValueFactory(cell -> cell.getValue().getFirstNameProperty());
        studentGenreColumn.setCellValueFactory(cell -> cell.getValue().getGenreProperty());
        studentTccColumn.setCellValueFactory(cell -> cell.getValue().getTCCtitleProperty());
        studentAdvisorColumn.setCellValueFactory(cell -> cell.getValue().getAdvisorProperty());
        
    }
    
    /**
     * Ação realizada pelo Botão "Detalhes", que mostra os detalhes do dado 
     * selecionado na Table View corrente.
     */
    @FXML
    public void handleDetails(){
        
        if(tablesPane.getSelectionModel().getSelectedItem() == studentsTab){
            mainApp.showDetails(studentstTableView.getSelectionModel().getSelectedItem());
        }else if(tablesPane.getSelectionModel().getSelectedItem() == teachersTab){
            mainApp.showDetails(teachersTableView.getSelectionModel().getSelectedItem());
        }else if(tablesPane.getSelectionModel().getSelectedItem() == boardsTab){
            mainApp.showDetails(boardsTableView.getSelectionModel().getSelectedItem());
        }
        
    }
    
   
    /**
     * Obtém acesso aos métodos da classe MainApp, obtendo os dados das 
     * observables lists e atribuindo-os às Tables Views da innterface
     * @param mainApp 
     */
    public void setMainApp(MainApp mainApp){
       this.mainApp = mainApp;
       
       //setando as listas
       studentstTableView.setItems(mainApp.getStudentstable());
       teachersTableView.setItems(mainApp.getTeachersstable());
       boardsTableView.setItems(mainApp.getBoardstable());
       
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
       setTabs();
       setCellsStudents();
       setCellsTeachers();
       setCellsBoards();
    }
}
