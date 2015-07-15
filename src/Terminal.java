/**
 * Created by Orens on 7/15/2015.
 */
public class Terminal {
    public static void main(String[] args) {
        //Use this as a text-based interface for the engine. Do not refer to this class in your implementation
        System.out.println("Welcome to THE MAZE ENGINE");
        System.out.println("Developed by Orens Xhagolli and Noah Rubin");
        Maze maze = new Maze(10, 10);
        for(int x = 0; x < 10; x++){
            for(int y = 0; y < 10; y++){
                System.out.print(maze.getBoard()[x][y].isWall() ? "x" : ".");
            }
            System.out.println();
        }
    }
}
