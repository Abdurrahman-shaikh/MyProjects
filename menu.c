// Menu driven program in C
#include <stdio.h>
#include <math.h>
int matrix();
int prime();
void printValueOfPi();
int palindrome();
// Driver code
int main() {
    // Choice variable
    int choice = -1;

    // Menu display
    printf("\e[1;46m***********************************************************************************************************************\e[0m");
    printf("\n");
    printf("\e[1;43m                                                          MENU                                                         \e[0m");
    printf("\e[1;31m \n1. MATRIX ADDITION  \t \t \t \t \t \t\t \t \t \t \t 2.CHECK PRIME \e[0m");
    printf("\e[1;32m3. VALUE OF PIE \t \t \t \t \t \t \t \t \t \t \t 4.PALIDROME \e[0m");
    printf("\e[1;33m \n5. NULL \t \t  \t \t \t \t \t \t \t \t \t \t 6.EXIT \e[0m\n");
    printf("\e[1;46m***********************************************************************************************************************\e[0m");
    printf("\n");
    // Infinite Loop for choice input
    while(1){
	printf("\n");
        printf(" \e[1;45m Enter your choice: \e[0m");
        scanf("%d", &choice);

        // If-else ladder
        if(choice == 1){
            matrix();
        }
        else if (choice == 2){
            prime();
        }
        else if (choice == 3){
            printValueOfPi();
        }
        else if (choice == 4){
            palindrome();
        }
        else if (choice == 6){
            printf("\e[1;31m > BYE!!!\e[0m\n");
            // Termination of the Loop using break statement
	    break;
        }
        else{
            printf("\e[1;31m > Invalid Input\e[0m\n");
        }
    }
    return 0;
}


int matrix()
{
   int m, n, c, d, first[10][10], second[10][10], sum[10][10];

   printf("\e[1;31m Enter the number of rows and columns of matrix\e[0m \n");
   scanf("%d%d", &m, &n);
   printf("\e[1;31m Enter the elements of first matrix\e[0m \n");

   for (c = 0; c < m; c++)
      for (d = 0; d < n; d++)
         scanf("%d", &first[c][d]);

   printf("\e[1;31m Enter the elements of second matrix\e[0m \n");

   for (c = 0; c < m; c++)
      for (d = 0 ; d < n; d++)
         scanf("%d", &second[c][d]);

   printf("\e[1;31m Sum of entered matrices:-\e[0m \n");

   for (c = 0; c < m; c++) {
      for (d = 0 ; d < n; d++) {
         sum[c][d] = first[c][d] + second[c][d];
         printf("\e[1;31m %d \e[0m \t", sum[c][d]);
      }
      printf("\n");
   }

   return 0;
}

int prime() {

  int n, i, flag = 0;
  printf("\e[1;31m Enter a positive integer:\e[0m ");
  scanf("%d", &n);

  // 0 and 1 are not prime numbers
  // change flag to 1 for non-prime number
  if (n == 0 || n == 1)
    flag = 1;

  for (i = 2; i <= n / 2; ++i) {

    // if n is divisible by i, then n is not prime
    // change flag to 1 for non-prime number
    if (n % i == 0) {
      flag = 1;
      break;
    }
  }

  // flag is 0 for prime numbers
  if (flag == 0)
    printf("\e[1;31m %d is a prime number.\e[0m ", n);
  else
    printf("\e[1;31m %d is not a prime number.\e[0m ", n);

  return 0;
}


void printValueOfPi()
{

    int n;
    printf("\e[1;31m Enter the number\e[0m ");
    scanf("%d",&n);
    // Find value of pi upto
    // using acos() function
    double pi = 2 * acos(0.0);

    // Print value of pi upto
    // N decimal places
    printf("\e[1;31m %.*lf \e[0m \n", n, pi);
}


int palindrome() {
  int n, reversed = 0, remainder, original;
    printf("\e[1;31m Enter an integer: \e[0m ");
    scanf("%d", &n);
    original = n;

    // reversed integer is stored in reversed variable
    while (n != 0) {
        remainder = n % 10;
        reversed = reversed * 10 + remainder;
        n /= 10;
    }

    // palindrome if orignal and reversed are equal
    if (original == reversed)
        printf("\e[1;31m %d is a palindrome.\e[0m ", original);
    else
        printf("\e[1;31m %d is not a palindrome.\e[0m ", original);

    return 0;
}
