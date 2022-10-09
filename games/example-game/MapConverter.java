import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class MapConverter {
    public void mapConverter(ArrayList<ArrayList<TwoDTile>> map) throws IOException {
        //convert the map to the TMX format (XML file)
        //create random for 331 and 332
        Random r = new Random();
        BufferedWriter br = new BufferedWriter(new FileWriter(new File("C:\\Users\\hopog\\Documents\\VisualStudioCode\\Files\\A4Engine2.3-win64\\games\\example-game\\map.xml")));
        br.write("<map version=\"A4\" orientation=\"orthogonal\" width=\"15\" height=\"15\" tilewidth=\"32\" tileheight=\"32\">");
        br.newLine();
        br.write("\t<properties>");
        br.newLine();
        br.write("\t\t<property name=\"name\" value=\"Blackrock\"/>");
        br.newLine();
        br.write("\t</properties>");
        br.newLine();
        br.write("\t<tileset firstgid=\"1\" name=\"graphics\" tilewidth=\"32\" tileheight=\"32\">");
        br.newLine();
        br.write("\t\t<image source=\"graphics.png\" width=\"320\" height=\"1184\"/>");
        br.newLine();
        br.write("\t</tileset>");
        br.newLine();
        br.write("\t<layer name=\"Tile Layer 1\" width=\"15\" height=\"15\">");
        br.newLine();
        br.write("\t\t<data>");
        br.newLine();
        int b = map.size()*map.get(0).get(0).myPattern.size();
        for(int i=0; i<map.size(); i++){
            for(int y=0; y<3; y++) {

                for (int j = 0; j < map.get(0).size(); j++) {

                    for (int x = 0; x < 3; x++) {
                        if (((i == 0 && j == 0) && (x == 0 && y == 0) && map.get(i).get(j).myPattern.get(y).get(x) == 1)) {
                            br.write("\t\t\t<tile gid=\"261\"/>");
                            br.newLine();
                        } else if ((i == 0 && j == map.get(0).size() - 1) && (x == 2 && y == 0) && map.get(i).get(j).myPattern.get(y).get(x) == 1) {
                            br.write("\t\t\t<tile gid=\"302\"/>");
                            br.newLine();
                        } else if ((i == map.size() - 1 && j == 0) && (x == 0 && y == 2) && map.get(i).get(j).myPattern.get(y).get(x) == 1) {
                            br.write("\t\t\t<tile gid=\"271\"/>");
                            br.newLine();
                        } else if ((i == map.size() - 1 && j == map.get(0).size() - 1) && (x == 2 && y == 2) && map.get(i).get(j).myPattern.get(y).get(x) == 1) {
                            br.write("\t\t\t<tile gid=\"311\"/>");
                            br.newLine();
                        } else if (((i == 0 && y == 0) || (i == map.size() && y == 2)) && map.get(i).get(j).myPattern.get(y).get(x) == 1) {
                            int low = 331;
                            int high = 332;
                            int result = r.nextInt(high - low + 1) + low;
                            br.write("\t\t\t<tile gid=\"" + result + "\"/>");
                            br.newLine();
                        } else if (((j == 0 && x == 0) || (j == map.get(0).size() - 1 && x == 2)) && map.get(i).get(j).myPattern.get(y).get(x) == 1) {
                            int low = 241;
                            int high = 242;
                            int result = r.nextInt(high - low + 1) + low;
                            br.write("\t\t\t<tile gid=\"" + result + "\"/>");
                            br.newLine();
                        } else if (map.get(i).get(j).myPattern.get(y).get(x) == 1) {
                            int low = 241;
                            int high = 242;
                            int result = r.nextInt(high - low + 1) + low;
                            br.write("\t\t\t<tile gid=\"" + result + "\"/>");
                            br.newLine();
                        } else if (map.get(i).get(j).myPattern.get(y).get(x) == 0) {
                            br.write("\t\t\t<tile gid=\"57\"/>");
                            br.newLine();
                        }
                    }
                }
            }
        }
        br.write("\t\t</data>");
        br.newLine();
        br.write("\t</layer>");
        br.newLine();
        br.write("</map>");
        br.close();

    }
    public String determineGID(TwoDTile tile, int x,int  y){
        if(tile.myPattern.get(y).get(x)==0 && ((x==0 && y==0) || (x==tile.myWidth && y==tile.myHeight))){
            return "";
        }
        return null;
    }
}
