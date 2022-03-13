#include <iostream>
#include <set>
#include <vector>
#include <iterator>

using namespace std;

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
