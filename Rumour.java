package CSacademy;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/* -->>>>>>  COMPLETED USING C++ <<<<<---- */
/* -->>>>>>  CPP CODE BELOW      <<<<<---- */
/* --->>>>>  COMPLETED  100/100  <<<<<---- */
public class Rumour {
    /*
     * Tags:
     * 1. Bitwise operation
     * 2. Lowest common ancestor
     * 3. Full binary tree
     *
     * XOR(^) --> if the bits are different, then the result is 1, else 0
     * AND(&)
     * OR(|)
     * ShiftLeft(<<) --> multiply the number by 2
     * ShiftRight(>>) --> divide the number by 2
     *
     * q --> # of queries
     * a, b --> vertices, need 2 find min distance from a to b
     *
     * 1 <= q <= 10^6
     * 1 <= a,b <= 10^18  (BigInteger)
     * */
    public static void main(String[] args) {
        long start = System.nanoTime();
        System.out.println(rumour(BigInteger.ONE, BigInteger.ONE)); //0
        System.out.println(rumour(BigInteger.ONE, BigInteger.TWO)); //1
        System.out.println(rumour(BigInteger.TWO, new BigInteger("3"))); //2
        System.out.println(rumour(BigInteger.TEN, new BigInteger("6")));//5
        System.out.println(rumour(new BigInteger("15"), new BigInteger("8")));//6
        System.out.println(rumour(new BigInteger("12"), new BigInteger("13")));//2
        System.out.println(rumour(new BigInteger("1024"), new BigInteger("2047")));//20
        System.out.println(rumour(new BigInteger("1048576"), new BigInteger("2097151")));//40
        System.out.println(rumour(new BigInteger("8589934592"), new BigInteger("17179869180")));//66
        System.out.println(System.nanoTime() - start);
    }

    public static long rumour(BigInteger a, BigInteger b){
        if(a.compareTo(b) == 0) return 0;

        //lists of vertices from a,b to the root
        List<BigInteger> aRoots = new ArrayList<>();
        List<BigInteger> bRoots = new ArrayList<>();
        BigInteger zero = BigInteger.ZERO;
        BigInteger two = BigInteger.TWO;

        //creating a list of vertices from a to the root
        while(a.compareTo(zero) > 0){ //while a>0
            aRoots.add(a);
            a = a.divide(two);
        }
        //creating a list of vertices from b to the root
        while(b.compareTo(zero) > 0){ //while b>0
            bRoots.add(b);
            b = b.divide(two);
        }

        int aIndx = aRoots.size() - 1;
        int bIndx = bRoots.size() - 1;
        //looping through the lists, starting from the end.
        //while the values are equal, it means that a,b are children of that vertex
        //when the values are different, the loop stops and the distance from a and b to their closest
        //common ancestor is aIndx and bIndx.
        while(aIndx>=0 && bIndx>=0 && aRoots.get(aIndx).compareTo(bRoots.get(bIndx)) == 0){
            aIndx--;
            bIndx--;
        }
        //adding 2 because we subtracted 1 from aIndx and 1 from bIndx
        return  aIndx + bIndx + 2;
    }

    /*
    CPP solution --> same code as above

    llong rumour(llong a, llong b) {
	if (a == b)
		return 0;

	vector<llong> aRoots;
	vector<llong> bRoots;

	while (a > 0) {
		aRoots.push_back(a);
		a /= 2;
	}
	while (b > 0) {
		bRoots.push_back(b);
		b /= 2;
	}
	int aIndex = aRoots.size() - 1;
	int bIndex = bRoots.size() - 1;
	while (aIndex >= 0 && bIndex >= 0 && aRoots.at(aIndex) == bRoots.at(bIndex)) {
		aIndex--;
		bIndex--;
	}
	return (llong)aIndex + (llong)bIndex + 2;
    }
     */
}
