/*Pr5ProcitajSaURL

Klasa Scanner omogućava i čitanje datoteka sa veba, tj. sa neke URL adrese. 

Primer listing klase Pr5ProcitajSaURL pita korisnika da unese URL i prikazuje veličinu datoteke.

 Program pita korisnika da unese URL string i kreira URL objekat. Konstruktor izbacuje izuzetak java.net.MalformedURLException 

 ako URL adresa nije dobro definisana.

*/

import java.util.Scanner;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URI;
import java.net.URISyntaxException;

public class Pr5ProcitajSaURL{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);  
        System.out.print("Unesite URL: ");
        String url_string = scan.next();
        int brojac = 0;

        try {
            URI url = new URI(url_string);
            URL url2 = url.toURL();
            Scanner www = new Scanner(url2.openStream());
            while(www.hasNext()){
                String linija = www.nextLine();
                System.out.println(linija);
                brojac += linija.length();
            }
            System.out.println("Velicina: " + brojac);
        }catch(MalformedURLException m){
            m.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }catch(URISyntaxException e){
            e.printStackTrace();
        }finally {
            scan.close();
        }
    }
}
