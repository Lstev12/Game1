package Utilities;

import Visual.Tile;
import Visual.Tile.Planted;
import java.util.HashMap;

public class GameEncoder {
    
    public String encode(HashMap<Coord, Tile> field){
        String game = "";
        
        for (Tile t : field.values()){
            String s = "";
            s+=t.x_coord;
            s+=t.y_coord;
            s+=t.currentState.initial;
            s+="#";
            if (t.currentlyPlanted != Planted.NOTHING){
                s+=t.currentlyPlanted.initial;
                
            }
        }
        
        return game;
    }
            
}
