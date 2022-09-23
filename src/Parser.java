import java.io.FileInputStream;
import java.util.Scanner;

public class Parser {

    private GraphImplication graph;
    public Graph<String> parse(String filename) {
        try {
            FileInputStream file = new FileInputStream(filename);
            Scanner scanner = new Scanner(file);
            scanner.nextLine();
            String fLine = scanner.nextLine();
            graph = new GraphImplication(2*Integer.parseInt(fLine.substring(6,8).trim())); // 6->8 pour le cas ou nbVariable > 9
            scanner.useDelimiter(" 0");
            while(scanner.hasNext()) {
                String line = scanner.next();
                String src = line.substring(0,line.indexOf(" "));   // Possible erreur ici si il y a une ligne vide a la fin de formula.txt
                String dst = line.substring(line.indexOf(" ")+1);
                int source = Integer.parseInt(src.trim());  // trim() permet de retirer les espaces
                int dest = Integer.parseInt(dst.trim());
                graph.addArc(-source,dest,"-s => d");
                graph.addArc(-dest,source,"-d => s");
            }
            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return graph;
    }
}
