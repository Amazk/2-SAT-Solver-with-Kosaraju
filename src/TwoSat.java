import java.util.List;

public class TwoSat {

    private static int cardinal;

    private static void setCardinal(List<List<Integer>> composantes) {
        for(List<Integer> eqClass : composantes) cardinal+=eqClass.size();
    }
    public static boolean checkConsistency(List<List<Integer>> composantes) {
        setCardinal(composantes);
        for(List<Integer> eqClass : composantes) {
            if(eqClass.size()<=1) continue;
            for(int i=0; i<eqClass.size(); i++) {
                for (int k=0; k<eqClass.size(); k++) {
                    if(i==k) continue;
                    if(eqClass.get(i)+eqClass.get(k)==cardinal-1) return false;
                }
            }
        }
        return true;
    }
}
