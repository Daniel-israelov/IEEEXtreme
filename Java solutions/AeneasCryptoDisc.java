package CSacademy;

import java.util.HashMap;
import java.util.Scanner;

/* --->>>>>  COMPLETED  100/100 <<<<<---- */
public class AeneasCryptoDisc {
    public static int length(String phrase, int thread, HashMap<String, Double> letterDegree){
        double totalLength = thread, tempLength;

        //removing non-alphabetic characters & spaces
        //Also, setting all letters to upper case
        String tPhrase = phrase.replaceAll("[^A-Za-z]+", "").toUpperCase();
        StringBuilder noDups = new StringBuilder();

        for(int i = 0; i < tPhrase.length()-1 ; i++){// loop to remove consecutive duplicates --> IEEEXTREME will be IEXTREME
            if(tPhrase.charAt(i) != tPhrase.charAt(i+1))
                noDups.append(tPhrase.charAt(i));
        }
        if(tPhrase.charAt(tPhrase.length()-1) != tPhrase.charAt(tPhrase.length()-2))
            noDups.append(tPhrase.charAt(tPhrase.length()-1));

        tPhrase = noDups.toString();

        /*------------------>>> CALCULATING THREAD TOTAL LENGTH <<<------------------*/
        double smallDeg, bigDeg, degreeA, degreeB;
        for(int k=0, j=1; j<tPhrase.length(); k++, j++){
            degreeA = letterDegree.get(String.valueOf(tPhrase.charAt(k))); // degree of current letter
            degreeB = letterDegree.get(String.valueOf(tPhrase.charAt(j))); // degree of next letter
            smallDeg = Math.min(degreeA, degreeB);
            bigDeg = Math.max(degreeA, degreeB);

            //finding the degree between two letters and using it to
            //calculate the length of the thread
            if(bigDeg - smallDeg <= 180 && bigDeg - smallDeg >= 0)
                tempLength = calcLengthAB(thread, Math.abs(bigDeg - smallDeg));
            else
                tempLength = calcLengthAB(thread, Math.abs(360 - (bigDeg - smallDeg)));

            if(tempLength <= thread*2)
                //if the length from current letter to next letter is smaller than
                //returning to the center of the disc and then going to the next letter
                totalLength += tempLength;
            else
                //meaning - returning to center and then going to the next letter
                //is shorter than going straight from current letter to next letter
                totalLength += thread*2;
        }
        return (int) Math.ceil(totalLength);
    }

    public static double calcLengthAB(int radius, double degHead){
        // calculating the length from point A to B
        // without returning to the center of the disc
        double degRad = Math.toRadians(degHead); //need to convert to radians 'cause Math.cos() expecting radian
        double res = (Math.pow(radius,2) + Math.pow(radius,2)) - (2*Math.pow(radius, 2)*Math.cos(degRad));
        return Math.sqrt(res);
    }
}
