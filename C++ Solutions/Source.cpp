#include <iostream>

//MAX_RECS - max rectangles in the worst case 
//according to the Efficient Approach Hint
#define MAX_RECS 5000

using namespace std;

int rows, cols, n;
void set_inputs();
void blockArt(int const&, int const&, int);

int main() {
    set_inputs();
    blockArt(rows, cols, n);
    return 0;
}

void blockArt(int const& rows, int const& cols, int n) {
    char op; //operation
    //x, y are the coordiantes
    //rem_it, add_it --> index iterator for 'removes' & 'adds' matrices respectively
    int x1, y1, x2, y2, rem_it, add_it, sum;
    int maxLcol, minRcol, maxUrow, minDrow;
    int width, length;
    int** adds = new int* [MAX_RECS]{};    //matrix that holds the coordinates of the add operation
    int** removes = new int* [MAX_RECS]{}; //matrix that holds the coordinates of the remove operation

    add_it = rem_it = sum =  0;

    while (n > 0) {
        cin >> op >> x1 >> y1 >> x2 >> y2;
        x1 -= 1;
        y1 -= 1;

        if (op == 'a') {
            //allocating new row and adding the coordinates
            adds[add_it] = new int[4];
            adds[add_it][0] = x1;
            adds[add_it][1] = y1;
            adds[add_it][2] = x2;
            adds[add_it][3] = y2;
            add_it++;
        }
        else if (op == 'r') {
            //allocating new row and adding the coordinates
            removes[rem_it] = new int[4];
            removes[rem_it][0] = x1;
            removes[rem_it][1] = y1;
            removes[rem_it][2] = x2;
            removes[rem_it][3] = y2;
            rem_it++;
        }
        else {//if op == 'q'
            sum = 0;

            for (int i = 0; i < add_it; i++) {
                //summing all matrices of add operation
                maxLcol = max(adds[i][1], y1);
                minRcol = min(adds[i][3], y2);
                maxUrow = max(adds[i][0], x1);
                minDrow = min(adds[i][2], x2);
                width = max(minRcol - maxLcol, 0);
                length = max(minDrow - maxUrow, 0);
                sum += (width * length);
            }

            for (int j = 0; j < rem_it; j++) {
                //subtracting all matrices of remove operation
                maxLcol = max(removes[j][1], y1);
                minRcol = min(removes[j][3], y2);
                maxUrow = max(removes[j][0], x1);
                minDrow = min(removes[j][2], x2);
                width = max(minRcol - maxLcol, 0);
                length = max(minDrow - maxUrow, 0);
                sum -= (width * length);
            }
            cout << sum << endl;
        }
        n--;
    }
    delete[] adds;
    delete[] removes;
}

void set_inputs() {
    //inputs of main matrix size and num of queries
    cin >> rows >> cols;
    cin >> n;
}