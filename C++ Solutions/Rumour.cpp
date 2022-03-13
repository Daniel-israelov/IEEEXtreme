#include <iostream>
#include <vector>

using namespace std;
typedef long long llong;

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
