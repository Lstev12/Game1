package Visual;

import Utilities.Tools;
import Utilities.Tools.Tool;
import java.time.Clock;
import java.time.Instant;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

public class Tile extends Parent{
    
    public enum State {
        EMPTY ('E'), RAKED ('R'), PLANTED ('P'), FENCE ('F');
        
        public final char initial;
        State (char i){
            initial = i;
        }
    };
    
    public enum Planted {
        NOTHING ('N'), TREE ('T'), FLOWER ('F'), CROP ('C');
        
        public final char initial;
        Planted (char i){
            initial = i;
        }
    };
    
    public Polygon tile = new Polygon();
    public State currentState;
    public Planted currentlyPlanted = Planted.NOTHING;
    public int x_coord, y_coord;
    public Instant lastPlanted;
    public Clock clock;
    
    
    public Tile(Double width, int x, int y){
        
        x_coord = x;
        y_coord = y;
        
        // Centre is 0.0,0.0
        double height = width/4;
        tile.getPoints().addAll(new Double[]{
            0.0     , height/2 ,
            width/2 , 0.0      ,
            0.0     , -height/2,
            -width/2, 0.0
            });

        tile.relocate(((width / 2) * (x - y)), ((height / 2) * (x + y)));
        
        currentState = State.EMPTY;
        this.setStyle(currentState);
        
        this.getChildren().addAll(tile);
        
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
    
    public void moveBy(double midX, double midY){
        double oldX = tile.getLayoutX(), oldY = tile.getLayoutY();
        this.tile.relocate(oldX+midX, oldY+midY);
    }
    
    public void setStyle(State s){
        switch (s){
            case EMPTY:
                this.tile.setFill(Color.GREEN);
                this.tile.setStroke(Color.DARKGREEN);
                break;
            case RAKED:
                this.tile.setFill(Color.BROWN);
                this.tile.setStroke(Color.BROWN);
                break;
                
        }
    }
    
}
