package Visual;

import Utilities.Tools;
import Utilities.Tools.Tool;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

public class Tile extends Parent{
    
    public enum State {
        EMPTY, RAKED
    };
    
    public Polygon tile = new Polygon();
    public State currentState;
    
    public Tile(Double width, int x, int y){
        
        // Centre is 0.0,0.0
        double height = width/4;
        tile.getPoints().addAll(new Double[]{
            0.0     , height/2 ,
            width/2 , 0.0      ,
            0.0     , -height/2,
            -width/2, 0.0
            });
        
        this.tile.setLayoutX(((width / 2) * (x - y)) + 500);
        this.tile.setLayoutY(((height / 2) * (x + y)) + 500);
        currentState = State.EMPTY;
        this.tile.setFill(Color.GREEN);
        this.tile.setStroke(Color.BLACK);
        
        this.getChildren().add(tile);
        
        tile.setOnMouseClicked(e -> {
            if (Tools.currentTool != Tool.NULL) useTool();
        });
    
    }
    
    public void useTool(){
        switch (Tools.currentTool){
            case RAKE: 
                
                if (currentState == State.EMPTY){
                    currentState = State.RAKED;
                    this.tile.setFill(Color.BROWN);
                }
                break;
        }
    }
}
