/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visual;

import Utilities.Tools;
import Utilities.Tools.Tool;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author LACHY
 */
public class GameArea extends Application {
    Pane root = new Pane(), board = new Pane();
    ScrollPane boardArea = new ScrollPane();
    Field field;
    Boolean pannable = true;
    
    @Override
    public void start(Stage primaryStage) {
        
        field = new Field(20,20,100.0);
        
        board.setPrefSize(1000, 1000);
        board.getChildren().addAll(field.field.values());
        
        Tools.currentTool = Tool.RAKE;
        
        boardArea.setContent(board);
        boardArea.setPrefSize(700, 700);
        boardArea.setPannable(pannable);
        boardArea.setHbarPolicy(ScrollBarPolicy.NEVER);
        boardArea.setVbarPolicy(ScrollBarPolicy.NEVER);
        
        this.root.getChildren().add(boardArea);
        
        Scene scene = new Scene(root, 700, 700);
        
        primaryStage.setTitle("Test");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        beginEventHandling();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    public void beginEventHandling(){
        
        root.setOnKeyPressed(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent ke) {
                switch (ke.getCode()){
                    case S: //Pressing S enables or disables moving the screen
                        pannable = !pannable;
                        boardArea.setPannable(pannable);
                        System.out.println("Pannable: "+pannable);
                        break;
                        
                    case R: //Pressing R enables or disables raking
                        switch (Tools.currentTool){
                            case RAKE:
                                Tools.currentTool = Tool.NULL;
                                System.out.println("Current Tool: None");
                                break;
                            default:
                                Tools.currentTool = Tool.RAKE;
                                System.out.println("Current Tool: Rake");
                                break;   
                        }
                }
            }
        });
    }
                
}
