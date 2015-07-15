import java.util.LinkedList;

/**
 * Created by Orens on 7/15/2015.
 */
public class Node {
    private Coordinate location;

    private LinkedList<Node> neighbors;
    private boolean wall;

    public Node(int x, int y){
        location = new Coordinate(x, y);
        neighbors = new LinkedList<>();
    }

    public void addNeighbor(Node neighbor){
        neighbors.add(neighbor);
    }

    public void removeNeighbor(Node neighbor){
        neighbors.remove(neighbor);
    }

    public Coordinate getLocation() {
        return location;
    }

    public LinkedList<Node> getNeighbors() {
        return neighbors;
    }

    public boolean isWall() {
        return wall;
    }

    public void setWall(boolean wall) {
        this.wall = wall;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Node node = (Node) o;

        return getLocation().equals(node.getLocation());

    }

    @Override
    public int hashCode() {
        return getLocation().hashCode();
    }

    @Override
    public String toString() {
        String str = "";
        for(Node node: neighbors){
            str += node.location.toString() + "; ";
        }
        return "Node{" +
                "location=" + location +
                ", neighbors=" + str +
                '}';
    }
}
