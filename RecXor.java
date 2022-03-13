package CSacademy;


/* -->>>>>>  COMPLETED USING C++ <<<<<---- */
/* -->>>>>>  COMPLETED USING Py  <<<<<---- */
/* -->>>>>>      CODE BELOW      <<<<<---- */
/* --->>>>>  COMPLETED  100/100  <<<<<---- */
public class RecXor {
    public static void main(String[] args) {

    }
    /*
      Python code:
      ------------
      def recXor(cols, rows, n, d1, d2):
          #because the matrix is sorted and starts with 'n',
          #we can find the indices of d1, d2 using the following calculations
          d1_c = ((d1 - n) % cols) + 1  # d1 current col index
          d2_c = ((d2 - n) % cols) + 1  # d2 current col index

          if d1_c > d2_c: #if d1 is top-right & d2 bottom-left
              d1_c, d2_c = d2_c, d1_c #swap
              d1 -= d2_c - d1_c #new d1 value
              d2 += d2_c - d1_c #new d2 value

          cols_diff = d2_c - d1_c

          xor_head = xor_range(n-1, d1-1)
          xor_tail = xor_range(d2, rows*cols+n-1)
          xor_mid = 0

          while d1 < d2-cols_diff:
              xor_mid = xor_mid ^ xor_range(d1+cols_diff, d1 + cols-1)
              d1 = d1 + cols

          x = xor_head^xor_mid^xor_tail
          print(x) #result

      def xor1(num):
          if num%4==0:
              return num
          elif num%4==1:
              return 1;
          elif num%4==2:
              return num+1
          else:
              return 0

      def xor_range(start, end):
          return xor1(start)^xor1(end)
     */


    /*
      CPP Code:
      ---------
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
    */
}
