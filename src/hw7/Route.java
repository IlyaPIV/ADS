package hw7;

import java.util.ArrayList;
import java.util.List;

public class Route {
    private int distance;
    private List<Integer> parentVertices;

    public Route(int distance) {
        this.distance = distance;
        this.parentVertices = new ArrayList<>();
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public List<Integer> getParentVertices() {
        return parentVertices;
    }

    public void setParentVertices(List<Integer> parentVertices) {
        this.parentVertices = parentVertices;
    }
}
