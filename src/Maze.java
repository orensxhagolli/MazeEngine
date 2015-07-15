import java.util.LinkedList;

/**
 * Created by Orens on 7/15/2015.
 */
public class Maze {
    public static Coordinate playerLocation;
    private Node [][] board;

    public Maze(int width, int height){
        board = new Node[width][height];
        makeMap(width, height);
        generateWalls(width, height);
        generateNeighbors(width, height);
        while(!canReachDFS(board[0][0], board[width-1][height-1], new LinkedList<>())) {
            makeMap(width, height);
            generateWalls(width, height);
            generateNeighbors(width, height);
        }
    }

    private void generateWalls(int width, int height){
        for(int x = 0; x < width; x++){
            for(int y = 0; y < height; y++){
                if (Math.random() < 0.25) board[x][y].setWall(true);
            }
        }
    }

    private void generateNeighbors(int width, int height){
        for(int x = 0; x < width; x++){
            for(int y = 0; y < height; y++){
                if(board[x][y].isWall())continue;
                if(x+1< width && !board[x+1][y].isWall()) board[x][y].addNeighbor(board[x+1][y]);
                if(x-1> 0&& !board[x-1][y].isWall()) board[x][y].addNeighbor(board[x-1][y]);
                if(y+1< height && !board[x][y+1].isWall()) board[x][y].addNeighbor(board[x][y+1]);
                if(y-1> 0&& !board[x][y-1].isWall()) board[x][y].addNeighbor(board[x][y - 1]);
            }
        }
    }

    private boolean canReachDFS(Node start, Node end, LinkedList<Node> visited){
        if(start.equals(end)){
            return true;
        }
        LinkedList<Node> visits = new LinkedList<>(visited);
        visits.add(start);
        for(Node node: start.getNeighbors()){
            if(visited.contains(node)){
                continue;
            }
            if (canReachDFS(node, end, visits)){
                return true;
            }
        }
        return false;
    }

    private void makeMap(int width, int height){
        for(int x = 0; x < width; x++){
            for(int y = 0; y < height; y++){
                board[x][y] = new Node(x, y);
            }
        }
    }

    public Node[][] getBoard() {
        return board;
    }
}
