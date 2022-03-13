package CSacademy;

import java.util.*;

/* -->>>>>>  COMPLETED USING C++ <<<<<---- */
/* -->>>>>>  CPP CODE BELOW      <<<<<---- */
/* --->>>>>  COMPLETED  100/100  <<<<<---- */

// https://csacademy.com/ieeextreme-practice/task/minimum-permutation/
public class MinimumPermutation {
    /*
     מקבלים מערך A בגודל N וסט S בגודל M
     בשניהם, כל מספר מופיע רק פעם אחת.
     המטרה היא להכניס את המספרים של S לתוך A בצורה הכי ממויינת שאפשר
     אסור למיין את מערך A !!!
     כי מי שממיין...

     גישה שונה לתרגיל -->  להכניס את הערכים של S לתוך A כך שיתקבל המספר הקטן ביותר
    */

    public static void main(String[] args) {
        int N, M;
        List<Integer> A = new ArrayList<>();
        TreeSet<Integer> S = new TreeSet<>();

        A.add(3);
        A.add(1);
        A.add(5);

        S.add(4);
        S.add(2);
        S.add(6);

        System.out.println(minPermutation(A, S));
    }

    public static String minPermutation(List<Integer> a, TreeSet<Integer> s){
        ArrayList<Integer> set = new ArrayList<>(s);
        String result;
        int i = 0;

        while(!set.isEmpty() && i < a.size()){
            if(set.get(0) < a.get(i)) {
                a.add(i, set.get(0));
                set.remove(0);
            }
            i++;
        }

        if(i == a.size() && !set.isEmpty())
            a.addAll(set);

        result = Arrays.toString(a.toArray())
                .replace(",", " ")
                .replace("[", "")
                .replace("]", "");

        return result;
    }

    /*
    vector<int> minimumPermutation(vector<int> A, set<int> S) {
	    string result;
	    int i = 0, num;
	    set<int>::iterator it; //used to iterate over set S

	    while (!S.empty() && i < A.size()) {
	    	//iterating over elements of S & inserting them into the correct
	    	//position in vector A
	    	it = S.begin();
	    	num = *it;

	    	if (num < A.at(i)) {
	    		A.insert(A.begin() + i, num); // inserting element from S to the i'th position of A
	    		S.erase(num);//removes element from the set
	    	}
	    	i++;
	    }
	    if (i == A.size() && !S.empty()) {
	    	//if we reached the end of A and there are still elements left in S
	    	for (auto s : S)
	    		A.push_back(s);
	    }
	    return A;
    }
*/
}
