

public class  Main {
    public static void main(String args[]){
        Tacka Nis, NoviSad, Beograd, Subotica;
        Mapa mapa = new Mapa(4);
        try {
            Nis = new Tacka(261, 350, "Nis");
            Beograd = new Tacka(144, 175, "Beograd");
            NoviSad = new Tacka(90, 120, "NoviSad");
            Subotica = new Tacka(77, 20, "Subotica");
            mapa.postaviKtacku(0, Nis);
            mapa.postaviKtacku(1, Beograd);
            mapa.postaviKtacku(2, NoviSad);
            mapa.postaviKtacku(3, Subotica);
        } catch(Exception e){
            System.out.println("Izuzetak: " + e);
        }
        double prosecnaBrzina = 100.0;

        System.out.println("Rastojanje izmedju Nisa i Subotica: " + mapa.RastojanjeTacaka());
        System.out.println("vreme: " + mapa.vreme(prosecnaBrzina));
    }
}

public class Mapa{
    int brojtacaka;
    Tacka[] nizTacaka;

    public Mapa(int brojTacaka){
        this.brojtacaka = brojTacaka;
        nizTacaka = new Tacka[brojTacaka];
    }

    public void postaviKtacku(int index, Tacka A){
        nizTacaka[index] = A;
    }
    public double RastojanjeTacaka(){
        double ur = 0;
        for (int i = 0; i < brojtacaka - 1; i++){
            ur += nizTacaka[i].Rastojanje(nizTacaka[i + 1]);
        } 
        return ur;
    }

    public double vreme(double pb) throws ArithmeticException{
        if(pb == 0){
            throw new ArithmeticException("Ne moze se deliti sa nulom");
        } else {
            return RastojanjeTacaka() / pb;
        }
    }
}

public class Tacka {
    private int x;
    private int y;
    private String naziv;
    
    public Tacka(int x, int y, String naziv) throws Exception{
        if (x < 0 || y < 0) {
            throw new Exception("Koordinate moraju biti pozitivne!");
        }
        this.x = x;
        this.y = y;
        this.naziv = naziv;
    }
    
    public double Rastojanje(Tacka A){
        return Math.sqrt((Math.pow(A.x - this.x, 2)) + (Math.pow(A.y - this.y, 2)));
    }

    public void ispisi(){
        System.out.println(this.naziv + " " + this.x + " " + this.y);
    }
}
