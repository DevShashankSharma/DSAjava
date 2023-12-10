public class Recursion {
    public static void PrintN(int n){
        if (n==0){
            return;
        }
        System.out.println(n);
        PrintN(n-1);
    }

    public static int SumNaturalNo(int n) {
        if (n==0){
            return 0;
        }
        int sum_natural = n + (SumNaturalNo(n-1));
        return sum_natural;
    }

    public static int Factorial(int n){
        if(n==0||n==1){
            return 1;
        }
        int factNm1 = Factorial(n-1);
        int factN = n*factNm1;
        
        return factN;
    }

    public static void fibonacci(int a , int b , int n){
        if (n == 0){
            return;
        }
        int c = a+b;
        System.out.println(c);
        fibonacci(b, c, n-1);
    }

    // public static int XtoPowerN(int x , int n){
    //     if(n==1){
    //         return x;
    //     }
    //     if (x==0){
    //         return 0;
    //     }
    //     return x*XtoPowerN(x, n-1);
    // }
    public static int XtoPowerN(int x , int n){
        if(n==1){
            return x;
        }
        if (x==0){
            return 0;
        }
        // if n is even 
        if(n%2==0){
            return XtoPowerN(x, n/2)*XtoPowerN(x, n/2);
        } else{
            return XtoPowerN(x, n/2)*XtoPowerN(x, n/2)*x;
        }
    }
    public static void main(String[] args) {
        int n = 5 ;

        // PrintN(n);

        // System.out.println("Sum of natural number upto "+n+" is : "+ SumNaturalNo(n));

        // System.out.println(Factorial(n)); 

        /* 
        int a=0,b=1;
        System.out.println(a+"\n"+b);
        fibonacci(a, b, n-2);
        */

        int x=3;
        System.out.println(XtoPowerN(x, n)); 

    }
}
