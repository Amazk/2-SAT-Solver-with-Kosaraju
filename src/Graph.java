import java.util.ArrayList;
import java.util.LinkedList;

public class Graph<Label>  {

    private class Edge {
        public int source;
        public int destination;
        public Label label;

        public Edge(int from, int to, Label label) {
            this.source = from;
            this.destination = to;
            this.label = label;
        }
    }
    private final int cardinal;
    private final ArrayList<LinkedList<Edge>> incidency;

    public int getDest(int source, int index) {
        return incidency.get(source).get(index).destination;
    }
    public int getArcNumber(int source) {
        return incidency.get(source).size();
    }
    public Graph(int size) {
        cardinal = size;
        incidency = new ArrayList<>(size + 1);
        for (int i = 0;i<cardinal;i++) {
            incidency.add(i, new LinkedList<>());
        }
    }
    public int order() {
        return cardinal;
    }

    public void addArc(int source, int dest, Label label) throws Exception {
	    if (Math.max(source,dest) >= this.cardinal){
	        throw new Exception("Sommets trop gros pour la taille du graphe");
	    }
        incidency.get(source).addLast(new Edge(source,dest,label));
    }
    public String toString() {
        String result = "";
        result = result.concat("Nombre sommets : " + cardinal + "\n");
        result = result.concat("Sommets : \n");
        for (int i = 0; i<cardinal;i++) {
	    result = result.concat(i + " ");
		}
        result = result.concat("\nArcs : \n");
        for (int i = 0; i<cardinal;i++) {
            for (Edge e : incidency.get(i)) {
                result = result.concat(e.source + " -> " + e.destination + ", étiquette : "
				       + e.label.toString() + "\n");
            }
        }
        return result;
    }

    public Graph<String> createGrev() throws Exception {
        Graph<String> graphRev = new Graph<>(cardinal);
        for(int source=0; source<cardinal; source++) {
            for(Edge edge : incidency.get(source)) {
                graphRev.addArc(edge.destination, source, "");
            }
        }
        return graphRev;
    }
}
