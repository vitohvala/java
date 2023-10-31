/*9. Napisati program kojim se za date prirodne brojeve m i n određuje suma m poslednjih cifara broja n.*/

import java.util.Scanner;

public class domaci {
   
    static int suma_posledjih_cifara(int m, int n){
        if (m > n) return -1;

        int sum = 0;
        for(int i = 0; i < m; ++i){
            sum += (n % 10);
            n /= 10;
        }
        return sum;
    }

	public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
        int m, n;

        System.out.println("Unesite n: ");
        n = scan.nextInt();

        System.out.println("Unesite m: ");
        m = scan.nextInt();

        System.out.println("suma je " + suma_posledjih_cifara(m , n));

	}

}
