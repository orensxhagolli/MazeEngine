/**
 * Created by Orens on 7/14/2015.
 */
public class Terminal {
    public static void main(String[] args) {
        Maze m = new Maze(6, 6);
        String[][] brd = new String[6][6];
        for (Coordinate coordinate: m.getBoard().keySet()){
            if(m.getBoard().get(coordinate).isWall()){
                brd[coordinate.getX()][coordinate.getY()] = "x";
            }
            else {
                brd[coordinate.getX()][coordinate.getY()] = ".";
            }
            System.out.println(m.getBoard().get(coordinate).getNeighbors());
        }
        for (int i = 0; i < brd.length; i ++){
            for (int j = 0; j < brd[i].length; j ++){
                System.out.print(brd[i][j]);
            }
            System.out.println();
        }
    }
}
