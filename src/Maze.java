import sun.awt.image.ImageWatched;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by Orens on 7/14/2015.
 */
public class Maze {
    private HashMap<Coordinate, Node> board; //Coordinate - Where? + LinkedList - Possible Neighbors

    /**
     *
     * @param x width
     * @param y length
     */
    public Maze(int x, int y){
        board = new HashMap<>();
        Node.setOccupied(new Coordinate(0, 0));
        //Generate a minimalistic board with no neighbors:
        for (int i = 0; i < x; i++){
            for (int j = 0; j < y; j++){
                board.put(new Coordinate(i, j), new Node(i, j));
            }
        }
        //Complete the board:
        makeWalls();
        addNeighbors();
        System.out.println(getBoard().get(new Coordinate(5, 5)).toString());
        if(canReachDFS(getBoard().get(Node.getOccupied()), getBoard().get(new Coordinate(5, 5)), new LinkedList<>())){
            System.out.println(true);
        }
        else {
            System.out.println(false);
        }
    }

    public HashMap<Coordinate, Node> getBoard() {
        return board;
    }

    public void setBoard(HashMap<Coordinate, Node> board) {
        this.board = board;
    }

    private void makeWalls() {
        //Generate randomly placed walls
        for (Coordinate coordinate : getBoard().keySet()) {
            if (coordinate.equals(new Coordinate(0, 0))) {
                continue;
            }
            if (Math.random() < 0.25) {
                getBoard().get(coordinate).setWall(true);
            }
        }
    }
    public void addNeighbors(){
        for(Coordinate coordinate: getBoard().keySet()){
            for(Coordinate coordinate1: getBoard().keySet()){
                if (Math.abs(coordinate.getX()-coordinate1.getX()) == 1 &&
                        Math.abs(coordinate.getY()-coordinate1.getY()) == 0 &&
                        !getBoard().get(coordinate).isWall() &&
                        !getBoard().get(coordinate1).isWall()){
                    getBoard().get(coordinate).addNeighbor(getBoard().get(coordinate1));
                    getBoard().get(coordinate).addNeighbor(getBoard().get(coordinate1));
                }
                if (Math.abs(coordinate.getX()-coordinate1.getX()) == 0 &&
                        Math.abs(coordinate.getY()-coordinate1.getY()) == 1 &&
                        !getBoard().get(coordinate).isWall() &&
                        !getBoard().get(coordinate1).isWall()){
                    getBoard().get(coordinate).addNeighbor(getBoard().get(coordinate1));
                    getBoard().get(coordinate).addNeighbor(getBoard().get(coordinate1));
                }
            }
        }
    }

    public boolean canReachDFS(Node start, Node finish, LinkedList<Node> visited){
        System.out.println(start);
        if (start.equals(finish))
            return true;
        LinkedList<Node> old = new LinkedList<>(visited);
        old.add(start);
        for (Node node:start.getNeighbors()){
            if (visited.contains(node)) continue;
            return canReachDFS(node, finish, old);
        }
        return false;
    }

    public void clearWalls(int x, int y){
        board.clear();
        //Re-generate minimalistic board
        for (int i = 0; i < x; i++){
            for (int j = 0; j < y; j++){
                board.put(new Coordinate(i, j), new Node(i, j));
            }
        }
    }
}
