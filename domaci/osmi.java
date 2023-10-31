
/* 8. Napisati program kojim se za dati prirodan broj X formira broj Y sastavljen od istih cifara ali u
 obrnutom poretku, a zatim ispituje da li je broj X+Y potpun kvadrat.
*/
import java.util.Scanner;

public class domaci {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
        int x, y;

        System.out.println("Unesite X: ");
        x = scan.nextInt();

        y = reverse_int(x);

        System.out.printf("Broj %d + %d %s potpuni kvadrat\n", x, y, potpun_kvadrat(x+y));

	}

    static int reverse_int(int x){
        int r = 0;
        while(x > 0){
            r *= 10;
            r = r + x % 10;
            x /= 10;
        }
        return r;
    }
    static String potpun_kvadrat(int x){
        int koren = (int)Math.sqrt(x);
        return (x == koren * koren) ? "jeste" : "nije";
    }
}
