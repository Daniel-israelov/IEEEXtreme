#include <iostream>
#include <vector>

using namespace std;
typedef long long llong;

llong rumour(llong a, llong b) {
	if (a == b)
		return 0;
	
	//vectors of vertices from a,b to root
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
	//the last index of the vectors of a and b
	int aIndex = aRoots.size() - 1;
	int bIndex = bRoots.size() - 1;

	while (aIndex >= 0 && bIndex >= 0 && aRoots.at(aIndex) == bRoots.at(bIndex)) {
		//calculating the distance from a,b to the lowest common ancestor
		//for example:
		//aRoots --> [10, 5, 2, 1]
		//bRoots -->	 [6, 3, 1]
		//then the lowest common ancestor is 1
		//a distance is 3
		//b distance is 2
		//Min dist. from a to be is 2+3=5
		aIndex--;
		bIndex--;
	}
	return (llong)aIndex + (llong)bIndex + 2;
}
