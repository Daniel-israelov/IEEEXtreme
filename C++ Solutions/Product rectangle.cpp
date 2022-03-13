#include <iostream>
#include <limits.h>

using namespace std;

long kadane_arr(long* const&, long);
long* flipSign(long*, long);

int main() {
    long n, m;
    long ttl_res = 0;
    long resN, resM;
    long negative_in_n = 0;
    long negative_in_m = 0;
    long min_in_n = LONG_MAX;
    long min_in_m = LONG_MAX;

    cin >> n >> m;

    long* arrN = new long[n];
    long* arrM = new long[m];

    for (long i = 0; i < n; i++) {
        cin >> arrN[i];
        if (arrN[i] < 0)//counting the amount of negative values
            negative_in_n++;

        //saving the number closest to 0
        if (abs(min_in_n) > abs(arrN[i]))
            min_in_n = arrN[i];
    }

    for (long i = 0; i < m; i++) {
        cin >> arrM[i];
        if (arrM[i] < 0)//counting the amount of negative values
            negative_in_m++;

        //saving the number closest to 0
        if (abs(min_in_m) > abs(arrM[i]))
            min_in_m = arrM[i];
    }

    //if both arrays are negative
    //then all elements in the matrix will be posive
    if (negative_in_n == n && negative_in_m == m) {
        arrN = flipSign(arrN, n);
        arrM = flipSign(arrM, m);

        resN = kadane_arr(arrN, n);
        resM = kadane_arr(arrM, m);
        ttl_res = resN * resM;
    }
    //if exactly 1 array is negative
    else if ((negative_in_n == n && negative_in_m == 0) || (negative_in_n == 0 && negative_in_m == m)) {
        ttl_res = min_in_n * min_in_m;
    }
    //if both arrays are positive
    else if (negative_in_n == 0 && negative_in_m == 0) {
        resN = kadane_arr(arrN, n);
        resM = kadane_arr(arrM, m);
        ttl_res = resN * resM;
    }
    //if arrays has midex signs (positive & negative)
    else {
        //calculating the result of the original input
        resN = kadane_arr(arrN, n);
        resM = kadane_arr(arrM, m);
        ttl_res = resN * resM;

        //fliping signs 
        arrN = flipSign(arrN, n);
        arrM = flipSign(arrM, m);

        //results of the flipped arrays
        resN = kadane_arr(arrN, n);
        resM = kadane_arr(arrM, m);

        //the final result will be the maximum between
        //the original result and the flipped result
        ttl_res = max(ttl_res, resN * resM);
    }

    delete[] arrN;
    delete[] arrM;

    cout << ttl_res << endl;
    return 0;
}

long* flipSign(long* arr, long size) {
    //multiplying all elements of arr by -1
    //making all negative numbers - positive and vice versa
    for (int i = 0; i < size; i++){
        arr[i] = -1 * arr[i];
    }
    return arr;
}

long kadane_arr(long* const& arr, long size) {
    long sum = 0, max_sum = LONG_MIN;
    long neg_sum = arr[0];
    int i;

    for (i = 0; i < size; i++) {
        sum += arr[i];

        if (arr[i] > neg_sum && arr[i] < 0)
            neg_sum = arr[i];

        if (sum < 0)
            sum = 0;
        else if (sum > max_sum) {
            max_sum = sum;
        }
    }
    //if all numbers are negative, the func. returns neg_sum
    //which is the highest negative number in the current array
    if (neg_sum > max_sum)
        return neg_sum;
    return max_sum;
}
