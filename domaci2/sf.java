
public class Main {
    public static void main(String[] args) {
        Funkcija f1 = new StepenaFunkcija(2, 3); 
        Funkcija f2 = new EksponencijalnaFunkcija();

        double tacka = 2.5;
        System.out.println("Vrednost f1 u tacki " + tacka + ": " + f1.vrednost(tacka));
        System.out.println("Izvod f1 u tacki " + tacka + ": " + f1.izvod(tacka));
        System.out.println("Integral f1 u tacki " + tacka + ": " + f1.integral(tacka));

        System.out.println("Vrednost f2 u tacki " + tacka + ": " + f2.vrednost(tacka));
        System.out.println("Izvod f2 u tacki " + tacka + ": " + f2.izvod(tacka));
        System.out.println("Integral f2 u tacki " + tacka + ": " + f2.integral(tacka));
    }
}
public interface Funkcija {
    double izvod(double x);
    double integral(double x);
    double vrednost(double x);
}

public class StepenaFunkcija implements Funkcija {
    private double a;
    private double n;

    public StepenaFunkcija(double a, double n) {
        this.a = a;
        this.n = n;
    }

    public double izvod(double x) {
        return n * a * Math.pow(x, n - 1);
    }

    public double integral(double x) {
        if (n == -1) {
            return a * Math.log(Math.abs(x));
        } else {
            return a / (n + 1) * Math.pow(x, n + 1);
        }
    }

    public double vrednost(double x) {
        return a * Math.pow(x, n);
    }
}

public class EksponencijalnaFunkcija implements Funkcija {
    public double izvod(double x) {
        return Math.exp(x);
    }

    public double integral(double x) {
        return Math.exp(x);
    }

    public double vrednost(double x) {
        return Math.exp(x);
    }
}


