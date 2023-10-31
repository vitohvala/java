/*9. Napisati program kojim se za date prirodne brojeve m i n određuje suma m poslednjih cifara broja n.*/

import java.util.Scanner;

public class domaci {
    static int faktorijel(int n){
        int f = 1;
        for(int i = 1; i <= n; ++i)
            f *= i;

        return f;
    }

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
        int n, s = 0;

        System.out.println("Unesite n: ");
        n = scan.nextInt();

        for(int i = 1; i <= n; ++i){
            s += faktorijel(i);
        }
        
        System.out.printf("suma faktorijela %d je %d\n", n, s);
	}

}
