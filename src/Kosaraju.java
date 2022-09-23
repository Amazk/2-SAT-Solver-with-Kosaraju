import java.util.List;

public class Kosaraju {

    private final Graph<String> graph;
    public Kosaraju(Graph<String> graph) {
        this.graph=graph;
    }

    public List<List<Integer>> sccs() throws Exception {
        Parcours parcours = new Parcours();
        parcours.profondeurItereG(graph);
        parcours.profondeurItereGrev(graph.createGrev());
        return parcours.getComposantes();
    }


}
