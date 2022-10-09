import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        MapGenerator newMap = new MapGenerator();
        MapConverter createFile = new MapConverter();
        //Create Width and Height
        int width = 5;
        int height = 5;
        //Create The Tiles That I Want To Add
        ArrayList<List<Integer>> values1 = new ArrayList<>(Arrays.asList(Arrays.asList(1,1,1),Arrays.asList(1,0,0), Arrays.asList(1,0,0))); //topLeft (Open right and down)
        ArrayList<List<Integer>> values2 = new ArrayList<>(Arrays.asList(Arrays.asList(1,1,1),Arrays.asList(0,0,0), Arrays.asList(0,0,0))); //Top middle (Open left right and down)
        ArrayList<List<Integer>> values3 = new ArrayList<>(Arrays.asList(Arrays.asList(1,1,1),Arrays.asList(0,0,1), Arrays.asList(0,0,1))); //top right (Open left and down)
        ArrayList<List<Integer>> values4 = new ArrayList<>(Arrays.asList(Arrays.asList(0,0,0),Arrays.asList(0,0,0), Arrays.asList(0,0,0))); // open completely
        ArrayList<List<Integer>> values5 = new ArrayList<>(Arrays.asList(Arrays.asList(1,0,0),Arrays.asList(1,0,0), Arrays.asList(1,0,0))); // middle left (Open up right and down)
        ArrayList<List<Integer>> values6 = new ArrayList<>(Arrays.asList(Arrays.asList(0,0,1),Arrays.asList(0,0,1), Arrays.asList(0,0,1))); //middle right (Open left up and down)
        ArrayList<List<Integer>> values7 = new ArrayList<>(Arrays.asList(Arrays.asList(1,0,0),Arrays.asList(1,0,0), Arrays.asList(1,1,1))); // bottom left (Open right and up)
        ArrayList<List<Integer>> values8 = new ArrayList<>(Arrays.asList(Arrays.asList(0,0,0),Arrays.asList(0,0,0), Arrays.asList(1,1,1))); //bottom middle (Open left up and right)
        ArrayList<List<Integer>> values9 = new ArrayList<>(Arrays.asList(Arrays.asList(0,0,1),Arrays.asList(0,0,1), Arrays.asList(1,1,1))); //bottom right (Open left and up)
        ArrayList<List<Integer>> values10 = new ArrayList<>(Arrays.asList(Arrays.asList(1,1,1),Arrays.asList(1,0,0), Arrays.asList(1,1,1))); //random 1 (Open right)
        ArrayList<List<Integer>> values11 = new ArrayList<>(Arrays.asList(Arrays.asList(1,1,1),Arrays.asList(0,0,1), Arrays.asList(1,1,1))); //random 2 (Open left)
        ArrayList<List<Integer>> values12 = new ArrayList<>(Arrays.asList(Arrays.asList(1,1,1),Arrays.asList(0,0,0), Arrays.asList(1,1,1))); //random 3 (Open left and right)
        ArrayList<List<Integer>> values13 = new ArrayList<>(Arrays.asList(Arrays.asList(1,0,1),Arrays.asList(1,0,1), Arrays.asList(1,1,1))); //random 4 (open up)
        ArrayList<List<Integer>> values14 = new ArrayList<>(Arrays.asList(Arrays.asList(1,1,1),Arrays.asList(1,0,1), Arrays.asList(1,0,1))); //random 5 (Open down)
        ArrayList<List<Integer>> values15 = new ArrayList<>(Arrays.asList(Arrays.asList(1,0,1),Arrays.asList(1,0,1), Arrays.asList(1,0,1))); //random 6 (Open up and down)
        ArrayList<List<Integer>> values16 = new ArrayList<>(Arrays.asList(Arrays.asList(1,0,1),Arrays.asList(1,0,0), Arrays.asList(1,1,1))); //random 6 (Open up and right)
        ArrayList<List<Integer>> values17 = new ArrayList<>(Arrays.asList(Arrays.asList(1,0,1),Arrays.asList(0,0,1), Arrays.asList(1,1,1))); //random 6 (Open up and left)
        ArrayList<List<Integer>> values18 = new ArrayList<>(Arrays.asList(Arrays.asList(1,1,1),Arrays.asList(0,0,1), Arrays.asList(1,0,1))); //random 6 (Open left and down)
        ArrayList<List<Integer>> values19 = new ArrayList<>(Arrays.asList(Arrays.asList(1,1,1),Arrays.asList(1,0,0), Arrays.asList(1,0,1))); //random 6 (Open right and down)



        //Create the possible constraints
        //(Left, Up, Right, Down) 0 is nothing 1 is wall
        List<Integer> constraints1 = Arrays.asList(0,0,0,0);
        List<Integer> constraints2 = Arrays.asList(1,0,0,0);
        List<Integer> constraints3 = Arrays.asList(0,1,0,0);
        List<Integer> constraints4 = Arrays.asList(0,0,1,0);
        List<Integer> constraints5 = Arrays.asList(0,0,0,1);
        List<Integer> constraints6 = Arrays.asList(1,0,0,1);
        List<Integer> constraints7 = Arrays.asList(1,0,1,0);
        List<Integer> constraints8 = Arrays.asList(1,1,0,0);
        List<Integer> constraints12 = Arrays.asList(0,1,0,1);
        List<Integer> constraints13 = Arrays.asList(0,0,1,1);
        List<Integer> constraints16 = Arrays.asList(0,1,1,0);
        List<Integer> constraints9 = Arrays.asList(1,1,1,0);
        List<Integer> constraints10 = Arrays.asList(1,1,0,1);
        List<Integer> constraints11 = Arrays.asList(1,0,1,1);
        List<Integer> constraints14 = Arrays.asList(0,1,1,1);


        ArrayList<TwoDTile> tiles = new ArrayList<>();
        TwoDTile tileOne=new TwoDTile(3,3,values1, constraints8);
        TwoDTile tileTwo=new TwoDTile(3,3,values2, constraints3);
        TwoDTile tileThree=new TwoDTile(3,3,values3, constraints16);
        TwoDTile tileFour=new TwoDTile(3,3,values4, constraints1);
        TwoDTile tileFive=new TwoDTile(3,3,values5, constraints2);
        TwoDTile tileSix=new TwoDTile(3,3,values6, constraints4);
        TwoDTile tileSeven=new TwoDTile(3,3,values7, constraints6);
        TwoDTile tileEight=new TwoDTile(3,3,values8, constraints5);
        TwoDTile tileNine=new TwoDTile(3,3,values9, constraints13);
        TwoDTile tileTen=new TwoDTile(3,3,values10, constraints10);
        TwoDTile tileEleven=new TwoDTile(3,3,values11, constraints14);
        TwoDTile tileTwelve=new TwoDTile(3,3,values12, constraints12);
        TwoDTile tileThirteen=new TwoDTile(3,3,values13, constraints11);
        TwoDTile tileFourteen=new TwoDTile(3,3,values14, constraints9);
        TwoDTile tileFifteen=new TwoDTile(3,3,values15, constraints7);
        TwoDTile tileSixteen=new TwoDTile(3,3,values16, constraints6);
        TwoDTile tileSeventeen=new TwoDTile(3,3,values17, constraints13);
        TwoDTile tileEighteen=new TwoDTile(3,3,values18, constraints16);
        TwoDTile tileNineteen=new TwoDTile(3,3,values19, constraints8);
        tiles.add(tileOne);
        tiles.add(tileTwo);
        tiles.add(tileThree);
        tiles.add(tileFour);
        tiles.add(tileFive);
        tiles.add(tileSix);
        tiles.add(tileSeven);
        tiles.add(tileEight);
        tiles.add(tileNine);
        tiles.add(tileTen);
        tiles.add(tileEleven);
        tiles.add(tileTwelve);
        tiles.add(tileThirteen);
        tiles.add(tileFourteen);
        tiles.add(tileFifteen);
        tiles.add(tileSixteen);
        tiles.add(tileSeventeen);
        tiles.add(tileEighteen);
        tiles.add(tileNineteen);
        //Set up the map for use
        ArrayList<ArrayList<TwoDTile>> myMap = newMap.generateMap(width,height,tiles);
        //Create the XML/TMX file and do the silly conversions.
        createFile.mapConverter(myMap);
    }
}