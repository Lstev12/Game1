package Utilities;

public class Coord {
    public int x, y;
    
    public Coord(int x_coord, int y_coord){
        x = x_coord;
        y = y_coord;
    }
    
    @Override
    public String toString(){
        return x+", "+y;
    }
    
    public Coord[] findNeighbours(){
        Coord[] c = new Coord[8];
        
        c[0] = new Coord(x+1, y-1); // Top Left
        c[1] = new Coord(x+1, y  ); // Top
        c[2] = new Coord(x+1, y+1); // Top Right
        c[3] = new Coord(x  , y+1); // Right
        c[4] = new Coord(x-1, y+1); // Bottom Right
        c[5] = new Coord(x-1, y  ); // Bottom
        c[6] = new Coord(x-1, y-1); // Bottom Left
        c[7] = new Coord(x  , y-1); // Left
        
        return c;
    }
}
