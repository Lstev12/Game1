package Visual;

import Utilities.Coord;
import java.util.HashMap;

public class Field {
    public HashMap<Coord, Tile> field = new HashMap();
    public int x_size, y_size;
    public final double size;
    
    public Field(int x, int y, double s){
        x_size = x;
        y_size = y;
        size = s;
        createField();
    }
    
    public void createField(){
        for (int i = 0; i < x_size; i++){
            for (int j = 0;j < y_size; j++){
                field.put(new Coord(i,j), new Tile(size, i, j));
            }
        }
    }
    
}
