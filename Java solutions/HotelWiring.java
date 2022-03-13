package CSacademy;

import java.util.*;

/* --->>>>>  COMPLETED  100/100 <<<<<---- */
public class HotelWiring {
    public static long hotelWiring(int roomsInFloor, int numOfOffSwitches, int[] correctlyWired){
        long result = 0;
        int i;

        //sorting the array of floors so the floors with the least powered rooms
        //will be the first ones to switch their power OFF and by that we'll get
        //max powered on rooms
        Arrays.sort(correctlyWired);

        for(i = 0; i < numOfOffSwitches; i++){
            //loop K times and 'turning off' the switch
            //we subtract the amount of rooms w/out power on a floor from the total
            //amount of rooms, this will give us the amount of powered room after turning the switch off
            correctlyWired[i] = roomsInFloor - correctlyWired[i];
            result += correctlyWired[i];
        }

        for(; i < correctlyWired.length ; i++ ){
            //if there are unvisited floors
            result += correctlyWired[i];
        }

        return result;
    }
}
