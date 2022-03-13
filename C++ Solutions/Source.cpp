#include <iostream>

using namespace std;
typedef long long ll;

ll recXor(ll, ll, ll, ll, ll);
ll xor_range(ll, ll);
ll xor1(ll);

int main() {
    int t;
    ll col, row, n;
    ll d1, d2;
    cin >> t;

    for (int i = 0; i < t; i++) {
        cin >> col >> row >> n >> d1 >> d2;

        cout << recXor(col, row, n, d1, d2) << endl;
    }
}

ll recXor(ll cols, ll rows, ll n, ll d1, ll d2) {
    ll d1_c = ((d1 - n) % cols) + 1;  //d1 current col index
    ll d2_c = ((d2 - n) % cols) + 1;  //d2 current col index

    if (d1_c > d2_c) {
        ll temp = d1_c;
        d1_c = d2_c;
        d2_c = temp;

        d1 -= d2_c - d1_c;
        d2 += d2_c - d1_c;
    }
    ll cols_diff = d2_c - d1_c;

    ll start = n - 1;
    ll end = d1 - 1;
    
    ll xor_head = xor_range(start, end);
    ll xor_tail = xor_range(d2, rows * cols + n - 1);
    ll xor_mid = 0;

    while (d1 < d2 - cols_diff) {
        xor_mid ^= xor_range(d1 + cols_diff, d1 + cols - 1);
        d1 += cols;
    }

    return xor_head ^ xor_mid ^ xor_tail;
}

ll xor_range(ll start, ll end) {
    return xor1(start) ^ xor1(end);
}

ll xor1(ll num) {
    if (num % 4 == 0)
        return num;
    else if (num % 4 == 1)
        return 1;
    else if (num % 4 == 2)
        return num + 1;
    else
        return 0;
}