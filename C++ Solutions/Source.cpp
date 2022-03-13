#include <iostream>
#include <set>
#include <vector>
#include <iterator>

using namespace std;

vector<int> minimumPermutation(vector<int>, set<int>);

int main() {
	int N, M;

	N = 3;
	M = 3;

	vector<int> result;
	vector<int> a;
	set<int> s;

	a.push_back(3);
	a.push_back(1);
	a.push_back(5);

	s.insert(4);
	s.insert(2);
	s.insert(6);

	result = minimumPermutation(a, s);

	for (auto res : result)
		cout << res << " ";

	return 0;
}

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