import java.sql.Date;
import java.util.Scanner;

public class Main {
    public static void main(String args[]){
        Datum prvi;
        Scanner scan = new Scanner(System.in);
        int dan, mesec, godina;
        try {
            System.out.println("Unesite dan: ");
            dan = scan.nextInt();
            System.out.println("Unesite mesec ");
            mesec = scan.nextInt();
            System.out.println("Unesite godinu: ");
            godina = scan.nextInt();
            prvi = new Datum(dan, mesec, godina);
            prvi.IspisiDatum();
            System.out.println("dan u godini: " + prvi.danPoRedu());
            prvi.datumPre87Dana();
            System.out.println("Datum dan pre: ");
            prvi.smanjiDatum();
            prvi.IspisiDatum();
        } catch(Exception e){
            System.out.println("Izuzetak: "+ e);
        }
    }

}

public class Datum {
    private int dan;
    private int mesec;
    private int godina;
    final int brojdana = 30;

    public Datum(int dan, int mesec, int godina) throws Exception{
        if(dan <= 0 || mesec <= 0 || mesec > 12 || dan > brojdana){
            throw new Exception("Nedozvoljene granice!");
        } else {
            this.dan = dan;
            this.mesec = mesec;
            this.godina = godina;
        }
    }

    public void datumPre87Dana(){
        Datum dat;
        try{
            dat = new Datum(this.dan, this.mesec, this.godina);
            for(int i = 0; i < 87; i++)
                dat.smanjiDatum();
            System.out.println("datum pre 87 dana: ");
            dat.IspisiDatum();
        } catch (Exception e){
            System.out.println("Izuzetak: " + e);
        }
    }

    //metoda za prikaz datuma na standardni izlaz
    public void IspisiDatum(){
        System.out.println("Dan: " + this.dan);    
        System.out.println("Mesec: " + this.mesec);    
        System.out.println("Godina: " + this.godina);    
    }
    //metoda koja izračunava koji je to dan po redu u godini,
    public int danPoRedu(){
        return ((mesec - 1) * brojdana) + dan; 
    }
    //metoda koja smanjuje datum za jedan dan (ukoliko se ovim smanjenjem prelazi na u doba
    //“Pre nove ere”, prijaviti izuzetak).
    public void smanjiDatum() throws Exception{
        if(dan > 1) dan--;
        else if (dan == 1 && mesec > 1) {
            mesec--;
            dan = 30;
        } else if(godina > 1){
            godina--;
            mesec = 12;
            dan = 30;
        } else {
            throw new Exception("Prelazi se  u doba nove ere!");
        }
    }
}
