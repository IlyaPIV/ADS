package hw7;

import lesson7.Graph;

public class MyTest {
    public static void main(String[] args) {
        testGraph();
    }

    private static void testGraph(){
        myGraph graph = new myGraph(10);

        graph.addVertex("Москва");
        graph.addVertex("Тула"); //1
        graph.addVertex("Липецк");
        graph.addVertex("Воронеж");
        graph.addVertex("Рязань"); //4
        graph.addVertex("Тамбов");
        graph.addVertex("Саратов");
        graph.addVertex("Калуга"); //7
        graph.addVertex("Орел");
        graph.addVertex("Курск");

        graph.addEdge("Москва","Тула",180);
        graph.addEdge("Москва","Рязань",200);
        graph.addEdge("Москва","Калуга",190);
        graph.addEdge("Тула","Липецк",295);
        graph.addEdge("Липецк","Воронеж",125);
        graph.addEdge("Рязань","Тамбов",260);
        graph.addEdge("Тамбов","Саратов",385);
        graph.addEdge("Саратов","Воронеж",515);
        graph.addEdge("Калуга","Орел",210);
        graph.addEdge("Орел","Курск",160);
        graph.addEdge("Курск","Воронеж",225);
        //доп ветви
        graph.addEdge("Рязань","Орел",385);
        graph.addEdge("Тамбов","Липецк",225);
        graph.addEdge("Рязань","Липецк",270);

        System.out.println("Size of graph is " + graph.getSize());
        graph.display();


       // graph.bfs("Москва");
        graph.findRoute("Москва", "Воронеж");
    }
}
