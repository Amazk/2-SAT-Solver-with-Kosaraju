import java.util.List;
import static java.lang.System.exit;

public class Main {

    public static void main(String[] args) throws Exception {

        String filename = "formulas/formula.txt";
        if (0 < args.length) {
            filename = args[0];
        }
        Parser parser = new Parser();
        Graph<String> graph = parser.parse(filename);
        Kosaraju k = new Kosaraju(graph);
        List<List<Integer>> composantes = k.sccs();
        System.out.println(composantes);

        if (TwoSat.checkConsistency(composantes)) {
            System.out.println("Formula " + filename + ": Satisfiable");
            exit(0);
        } else {
            System.out.println("Formula " + filename + ": Unsatisfiable");
            exit(-1);
        }
        exit(0);
    }
}
