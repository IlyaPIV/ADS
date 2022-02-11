package hw7;

import lesson7.Graph;
import lesson7.Vertex;

import java.util.*;


public class myGraph implements Graph {

    private final List<Vertex> vertexList;
    private final int[][] adjMatrix;
    private List<Route> shortestRoutes;

    private static final int INFINITY = 1000000;

    public myGraph(int maxVertexCount) {
        this.vertexList = new ArrayList<>(maxVertexCount);
        this.adjMatrix = new int[maxVertexCount][maxVertexCount];
        this.shortestRoutes = new ArrayList<>();
    }

    @Override
    public void addVertex(String label) {
        vertexList.add(new Vertex(label));
    }


    public boolean addEdge(String startLabel, String secondLabel, int value) {
        int startIndex = indexOf(startLabel);
        int endIndex = indexOf(secondLabel);

        if (startIndex == -1 || endIndex == -1) {
            return false;
        }

        adjMatrix[startIndex][endIndex] = value;

        return true;
    }

    private int indexOf(String label) {
        for (int i = 0; i < vertexList.size(); i++) {
            if (vertexList.get(i).getLabel().equals(label)) {
                return i;
            }
        }
        return -1;
    }



    @Override
    public boolean addEdge(String startLabel, String secondLabel, String... others) {
        return false;
    }

    @Override
    public boolean addEdge(String startLabel, String secondLabel) {
        return false;
    }

    @Override
    public int getSize() {
        return vertexList.size();
    }

    @Override
    public void display() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < getSize(); i++) {
            sb.append(vertexList.get(i));
            for (int j = 0; j < getSize(); j++) {
                if (adjMatrix[i][j]!=0) {
                    sb.append(" -> ").append(vertexList.get(j)).append(" ( ").append(adjMatrix[i][j]).append(" )");
                }
            }
            sb.append("\n");
        }

        return sb.toString();
    }

    @Override
    public void dfs(String startLabel) {
        int startIndex = indexOf(startLabel);
        if (startIndex == -1) {
            throw new IllegalArgumentException("Неверная вершина" + startLabel);
        }

        Stack<Vertex> stack = new Stack<>();
        Vertex vertex = vertexList.get(startIndex);

        visitVertex(stack, vertex);
        while (!stack.isEmpty()) {
            vertex = getNearUnvisitedVertex(stack.peek());
            if (vertex != null) {
                visitVertex(stack, vertex);
            } else {
                stack.pop();
            }
        }
        System.out.println();
    }

    private Vertex getNearUnvisitedVertex(Vertex vertex) {
        int currentIndex = vertexList.indexOf(vertex);
        for (int i = 0; i < getSize(); i++) {
            if (adjMatrix[currentIndex][i]!=0 && !vertexList.get(i).isVisited() ) {
                return vertexList.get(i);
            }
        }

        return null;
    }

    private void visitVertex(Stack<Vertex> stack, Vertex vertex) {
        System.out.print(vertex.getLabel() + " ");
        stack.push(vertex);
        vertex.setVisited(true);
    }

    private void visitVertex(Queue<Vertex> stack, Vertex vertex) {
        System.out.print(vertex.getLabel() + " ");
        stack.add(vertex);
        vertex.setVisited(true);
    }


    @Override
    public void bfs(String startLabel) {
        int startIndex = indexOf(startLabel);
        if (startIndex == -1) {
            throw new IllegalArgumentException("Неверная вершина" + startLabel);
        }

        Queue<Vertex> stack = new LinkedList<>();
        Vertex vertex = vertexList.get(startIndex);

        visitVertex(stack, vertex);
        while (!stack.isEmpty()) {
            vertex = getNearUnvisitedVertex(stack.peek());
            if (vertex != null) {
                visitVertex(stack, vertex);
            } else {
                stack.remove();
            }
        }
        System.out.println();
    }


    //ДОМАШНЕЕ ЗАДАНИЕ

    public void findRoute(String startLabel, String finishLabel){

        for (int i = 0; i < vertexList.size(); i++) {
            for (int j = 0; j < vertexList.size(); j++) {
                if (adjMatrix[i][j]==0) adjMatrix[i][j]=INFINITY;
            }
        }

        int currentVertex = 0;
        int distanceToCurrent = 0;

        int startIndex = indexOf(startLabel);
        if (startIndex == -1) {
            throw new IllegalArgumentException("Неверная начальная вершина" + startLabel);
        }
        int finishIndex = indexOf(finishLabel);
        if (finishIndex == -1) {
            throw new IllegalArgumentException("Неверная конечная вершина" + finishLabel);
        }

        vertexList.get(startIndex).setVisited(true);

        int countOfVisited = 1;

        for (int i = 0; i < vertexList.size(); i++) {
            int tempDist = adjMatrix[startIndex][i];
//            if (tempDist!=0) {
                Route route = new Route(tempDist);
                route.getParentVertices().add(startIndex);
                shortestRoutes.add(route);
           // }
        }

        while (countOfVisited < vertexList.size()) {
            int indexMin = getMin();
            int minDist = shortestRoutes.get(indexMin).getDistance();

            if (minDist==INFINITY) {
                System.out.println("остались только недостижимые вершины");
                break;
            } else
            {
                currentVertex = indexMin;
                distanceToCurrent = shortestRoutes.get(indexMin).getDistance();
            }

            vertexList.get(currentVertex).setVisited(true);
            countOfVisited++;
            updateShortestRoutes(currentVertex, distanceToCurrent);
        }

        displayRoutes();
        System.out.println();
        showShortestRoute(finishIndex,finishLabel);
    }

    private void updateShortestRoutes(int currentVertex, int startToCurrent) {
        int vertexIndex = 0;
        while (vertexIndex < vertexList.size()) {

            if (vertexList.get(vertexIndex).isVisited()) {
                vertexIndex++;
                continue;
            }

            int currentToFringe = adjMatrix[currentVertex][vertexIndex];
            // суммирование всех расстояний
            int startToFringe = startToCurrent + currentToFringe;

            int shortPathDistance = shortestRoutes.get(vertexIndex).getDistance();


            if (startToFringe < shortPathDistance || shortPathDistance==0) {
                List<Integer> newParents = new ArrayList<>(shortestRoutes.get(currentVertex).getParentVertices());
                newParents.add(currentVertex);
                shortestRoutes.get(vertexIndex).setParentVertices(newParents);
                shortestRoutes.get(vertexIndex).setDistance(startToFringe);
            }
            vertexIndex++;
        }
    }

    private void displayRoutes() { // метод для вывода кратчайших путей на экран
        for (int i = 0; i < vertexList.size(); i++) {
            System.out.print(vertexList.get(i).getLabel() + " = ");
            if (shortestRoutes.get(i).getDistance() == INFINITY) {
                System.out.println("0");
            } else {
                String result = shortestRoutes.get(i).getDistance() + " (";
                List<Integer> parents = shortestRoutes.get(i).getParentVertices();
                for (int j = 0; j < parents.size(); j++) {
                    result += vertexList.get(parents.get(j)).getLabel() + " -> ";
                }
                System.out.println(result + vertexList.get(i).getLabel() + ")");
            }
        }
    }

    private int getMin(){
        int minDist = INFINITY; // за точку старта взята "бесконечная" длина
        int indexMin = 0;
        for (int i = 0; i < vertexList.size(); i++) {
            if (!vertexList.get(i).isVisited() && shortestRoutes.get(i).getDistance() < minDist) {
                minDist = shortestRoutes.get(i).getDistance();
                indexMin = i;
            }
        }
        return indexMin;
    }

    private void showShortestRoute(int finishPoint, String finishLabel){
        System.out.println("Кратчайший маршрут до "+finishLabel+":");
        Route route = shortestRoutes.get(finishPoint);
        String result = route.getDistance() + " (";
        List<Integer> parents = route.getParentVertices();
        for (int j = 0; j < parents.size(); j++) {
            result += vertexList.get(parents.get(j)).getLabel() + " -> ";
        }
        System.out.println(result + finishLabel + ")");

    }

}
