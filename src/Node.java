import java.util.LinkedList;

/**
 * Created by Orens on 7/14/2015.
 */
public class Node {
    private int hashCode;
    private LinkedList<Node> neighbors;
    private boolean wall;
    private static Coordinate occupied;

    public Node(int x, int y){
        neighbors = new LinkedList<>();
        wall = false;
        this.hashCode = 1024*x + y;
    }

    public void addNeighbor(Node neighbor){
        if (!neighbors.contains(neighbor)) {
            neighbors.add(neighbor);
        }
    }

    public void removeNeighbor(Node neighbor){
        neighbors.remove(neighbor);
    }

    public boolean isWall() {
        return wall;
    }

    public void setWall(boolean wall) {
        this.wall = wall;
    }

    public static Coordinate getOccupied() {
        return occupied;
    }

    public static void setOccupied(Coordinate occupied) {
        Node.occupied = occupied;
    }

    @Override
    public String toString() {
        return "Node{" +
                "hashCode=" + hashCode  +
                ", wall=" + wall +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        return o.hashCode() == hashCode;

    }

    public LinkedList<Node> getNeighbors() {
        return neighbors;
    }

    @Override
    public int hashCode() {
        return hashCode;
    }
}
