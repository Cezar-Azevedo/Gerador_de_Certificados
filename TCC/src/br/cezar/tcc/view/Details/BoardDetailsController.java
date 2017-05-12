/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cezar.tcc.view.Details;

import br.cezar.tcc.model.Board;
import br.cezar.tcc.util.DateUtil;
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
public class BoardDetailsController implements Initializable {
    
    Stage boardDetailsStage;
        
    @FXML
    private Label IDLabel;
    @FXML
    private Label titleLabel;
    @FXML
    private Label placeLabel;
    @FXML
    private Label dateLabel;
    @FXML
    private TextArea teachersEvaluatorsArea;
    @FXML
    private Label halfLabel;
    
    
    /**
     * Define o palco da classe{@link BoardDetailsController}
     * @param boardDetailsStage 
     */
    public void setBoardDetails(Stage boardDetailsStage) {
        
       this.boardDetailsStage = boardDetailsStage;

    }
    
    /**
     * seta os atributos de um {@link Board} na tela de detalhes
     * @param board 
     */
    public void getBoard(Board board) {
        
        IDLabel.setText(Integer.toString(board.getID()));
        dateLabel.setText(DateUtil.toString(board.getDate().get()));
        halfLabel.setText(Integer.toString(board.getHalf()));
        placeLabel.setText(board.getPlaceProperty().get());
        titleLabel.setText(board.getTitleProperty().get());
        teachersEvaluatorsArea.setText(board.getTeachersEvaluatorsString());
        
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
}
