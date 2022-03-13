package CSacademy;

import java.util.*;

/* --->>>>>  COMPLETED  100/100 <<<<<---- */
public class HotelWiring {
    /*
     * M --> # of floors
     * N --> # of rooms on each floor, each floor has master switch to control power of the floor
     * On each floor, power is supplied to all room IF AND ONLY IF the switch is ON.
     * However, the stupid electrician made a mistake and some rooms get power if switch is OFF
     *
     * input:
     * T --> # of test cases
     * M N K --> K = EXACT # of switches that will be turned OFF
     * num1
     * num2  --> num_i is the amount of correctly wired rooms on the i'th floor
     * ...   --> out of M floors
     * numM
     *
     * output:
     * T integers (1 int per line) that show the max num of room that will receive power
     * */
    public static void main(String[] args) {
        System.out.println(hotelWiring(2,1, new int[]{2,0})); // = 4
        System.out.println(hotelWiring(4,2, new int[]{0,3})); // = 5
    }

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
