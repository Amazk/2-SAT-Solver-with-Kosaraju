public class GraphImplication extends Graph<String>{


    public GraphImplication(int size) {
        super(size);
    }

    @Override
    public void addArc(int source, int dest, String s) throws Exception {
        source--;dest--;                         // Permet de se mettre sur la plage [0,card-1]
        if(source<0) source += this.order()+1;   // Transforme les literaux opposés tq 0->card-1 , 1->card-2 ...
        if(dest<0) dest += this.order()+1;
        super.addArc(source, dest, s);
    }
}
