import java.util.ArrayList;
import java.util.List;

public class TwoDTile{
    int myWidth;
    int myHeight;
    ArrayList<List<Integer>> myPattern;
    List<Integer> myConstraints;

    public TwoDTile(int width, int height, ArrayList<List<Integer>> pattern, List<Integer> constraints){
        myWidth=width;
        myHeight=height;
        myPattern=pattern;
        myConstraints=constraints;
    }
}