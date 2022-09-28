import java.util.*;

public class Parcours {

    private int nbEqClass=0;
    private final List<Integer> parcouru = new ArrayList<>();
    private final List<Integer> order = new ArrayList<>();
    private final List<List<Integer>> composantes = new ArrayList<>();

    public void profondeurItereG(Graph<String> graph) {
        for(int source=0;source<graph.order();source++) {
            if(parcouru.contains(source)) continue;
            parcouru.add(source);
            for(int indexDest=0; indexDest<graph.getArcNumber(source); indexDest++) {
                explore(graph,graph.getDest(source,indexDest));
            }
            order.add(source);
        }
        parcouru.clear();
    }

    public void profondeurItereGrev(Graph<String> graph) {
        for(int i=order.size()-1; i>=0; i--) {
            if(parcouru.contains(order.get(i))) continue;
            parcouru.add(-1);
            nbEqClass++;
            parcouru.add(order.get(i));
            for(int indexDest=0; indexDest<graph.getArcNumber(order.get(i)); indexDest++) {
                explore(graph,graph.getDest(order.get(i),indexDest));
            }
        }
    }

    private void explore(Graph<String> graph, int dest) {
        if(parcouru.contains(dest)) return;
        parcouru.add(dest);
        for(int otherDest=0; otherDest<graph.getArcNumber(dest); otherDest++) {
            explore(graph, graph.getDest(dest,otherDest));
        }
        order.add(dest);
    }

    public List<List<Integer>> getComposantes() {
        int k=0;
        for(int i=0; i<nbEqClass; i++) composantes.add(new ArrayList<>());
        for(int i=1; i<parcouru.size(); i++) {
            if(parcouru.get(i)==-1) {
                k++;
            } else {
                composantes.get(k).add(parcouru.get(i));
            }
        }
        return composantes;
    }
}
