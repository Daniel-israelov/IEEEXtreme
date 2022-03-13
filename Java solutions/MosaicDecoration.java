package CSacademy;

import java.util.HashMap;
import java.util.Scanner;

/* --->>>>>  COMPLETED  100/100 <<<<<---- */
public class MosaicDecoration {
    public static int calcCost(int bathRoomsAmount, int blackCost, int pinkCost, HashMap<Integer, int[]> tilesPerRoom){
        int total;
        int blackSum = 0, pinkSum = 0, remainder;

        for(int i = 0; i < bathRoomsAmount; i++){
            blackSum += tilesPerRoom.get(i+1)[0];
            pinkSum += tilesPerRoom.get(i+1)[1];
        }

        //checking if a room has num of tiles != 10
        remainder = blackSum % 10;
        blackSum = blackSum / 10;
        if(remainder>0)
            blackSum += 1;
        blackSum *= blackCost;

        remainder = pinkSum % 10;
        pinkSum = pinkSum / 10;
        if(remainder>0)
            pinkSum += 1;
        pinkSum *= pinkCost;

        total = pinkSum + blackSum;
        return total;
    }
}
