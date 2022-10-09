import java.util.ArrayList;

public class MapGenerator {
    public ArrayList<ArrayList<TwoDTile>> generateMap(int w, int h, ArrayList<TwoDTile> tiles){
        ArrayList<TwoDTile> newTiles= tiles;
        ArrayList<ArrayList<TwoDTile>> map = new ArrayList<>();
        for(int y = 0; y<h; y++){
            map.add(new ArrayList<TwoDTile>());
            for(int x = 0; x<w; x++){
                ArrayList<TwoDTile> candidates = candidateTiles(map,x,w, y,h,newTiles);
                map.get(y).add(getRandom(candidates));
            }
        }

        return map;
    }
    public TwoDTile getRandom(ArrayList<TwoDTile> candidates){
        int index = (int)(Math.random()* candidates.size());
        return candidates.get(index);
    }

    public ArrayList<TwoDTile> candidateTiles(ArrayList<ArrayList<TwoDTile>> map, int x, int maxX, int y, int maxY, ArrayList<TwoDTile> tiles){
        ArrayList<TwoDTile> candidates = new ArrayList<>(tiles);
        ArrayList<TwoDTile> newCandidates = new ArrayList<>();
        ArrayList<TwoDTile> left = new ArrayList<>(tiles);
        //y=0 or x=0 or y=max or x=max must have outer walls. everything else is free. basically I'm setting the crust, the filling is free.
        if((x>0 && x<maxX) && (y>0 && y<maxY)){
            newCandidates=tilesUp(map, x, y, tilesLeft(map,x,y,left));

        }
        else if(y==0 && x==0){
            for(int i=0; i<tiles.size(); i++){
                if(candidates.get(i).myConstraints.get(0)==1){
                    newCandidates.add(candidates.get(i));
                }
                else if(candidates.get(i).myConstraints.get(1)==1){
                    newCandidates.add(candidates.get(i));
                }
            }
        }
        else if(y==maxY && x==maxX){
            for(int i=0; i<candidates.size(); i++){
                if(candidates.get(i).myConstraints.get(2)==1){
                    newCandidates.add(candidates.get(i));;
                }
                else if(candidates.get(i).myConstraints.get(3)==1){
                    newCandidates.add(candidates.get(i));
                }
            }
        }
        else if(y==maxY && x==0){
            for(int i=0; i<tiles.size(); i++){
                if(candidates.get(i).myConstraints.get(0)==1){
                    newCandidates.add(candidates.get(i));
                }
                else if(candidates.get(i).myConstraints.get(3)==1){
                    newCandidates.add(candidates.get(i));
                }
            }
        }
        else if(y==0 && x==maxX){
            for(int i=0; i<tiles.size(); i++){
                if(candidates.get(i).myConstraints.get(1)==1){
                    newCandidates.add(candidates.get(i));
                }
                else if(candidates.get(i).myConstraints.get(2)==1){
                    newCandidates.add(candidates.get(i));
                }
            }
        }
        else if(x==0 && y>0 && y<maxY){
            for(int i=0; i<tiles.size(); i++){
                if(candidates.get(i).myConstraints.get(0)==1){
                    newCandidates.add(candidates.get(i));
                }
            }
        }
        else if(x==maxX && y>0 && y<maxY){
            for(int i=0; i<tiles.size(); i++){
                if(candidates.get(i).myConstraints.get(2)==1){
                    newCandidates.add(candidates.get(i));
                }
            }
        }
        else if(y==0 && x>0 && x<maxX){
            for(int i=0; i<tiles.size(); i++){
                if(candidates.get(i).myConstraints.get(1)==1){
                    newCandidates.add(candidates.get(i));
                }
            }
        }
        else if(y==maxY && x>0 && x<maxX){
            for(int i=0; i<tiles.size(); i++){
                if(candidates.get(i).myConstraints.get(3)==1){
                    newCandidates.add(candidates.get(i));
                }
            }
        }
        return newCandidates;
    }
    public ArrayList<TwoDTile> tilesLeft(ArrayList<ArrayList<TwoDTile>> map, int x, int y, ArrayList<TwoDTile> tiles){
        TwoDTile tileLeft = map.get(y).get(x-1);
        ArrayList<TwoDTile> newCandidates = new ArrayList<>();
        if(tileLeft.myConstraints.get(2)==1){

            for(int i=0; i<tiles.size(); i++){

                if(tiles.get(i).myConstraints.get(0)==1){
                    newCandidates.add(tiles.get(i));
                }
            }
        }
        if(tileLeft.myConstraints.get(2)==0){
            for(int i=0; i<tiles.size(); i++){

                if(tiles.get(i).myConstraints.get(0)==0){
                    newCandidates.add(tiles.get(i));
                }
            }
        }
        return newCandidates;
    }

    public ArrayList<TwoDTile> tilesUp(ArrayList<ArrayList<TwoDTile>> map, int x, int y, ArrayList<TwoDTile> tiles){
        TwoDTile tileUp = map.get(y-1).get(x);
        ArrayList<TwoDTile> newCandidates = new ArrayList<>();
        if(tileUp.myConstraints.get(3)==1){

            for(int i=0; i<tiles.size(); i++){

                if(tiles.get(i).myConstraints.get(1)==1){
                    newCandidates.add(tiles.get(i));
                }
            }
        }
        if(tileUp.myConstraints.get(3)==0){
            for(int i=0; i<tiles.size(); i++){

                if(tiles.get(i).myConstraints.get(1)==0){
                    newCandidates.add(tiles.get(i));
                }
            }
        }
        return newCandidates;
    }
}
