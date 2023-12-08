/*Pr4ZamenaTeksta

Pretpostavimo da treba da napišete program Pr4ZamenaTeksta koji treba da 

zameni sva javljanja nekog stringa u tekstualnoj datoteci sa novim stringom.

 Ime datoteke, kao i nazivi stringova unose se kao argumenti komandne linije,

  u sledećoj formi:

        java ZamenaTeksta izvorniFajl odredisniFajl stariString noviString

Na primer, ako se unese sledeća komandna linija:

java ZamenaTeksta Test.java t.txt StringBuilder StringBuffer

zamenjuje sve pojave stringa: StringBuilder stringom StringBuffer u datoteci 

Test.java i tako izmenjen sadržaj smešta u datoteku t.txt.*/

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import java.io.FileNotFoundException;  
import java.io.IOException;

public class Main{
    
    public static void main(String[] args){
        if(args.length != 4){
            System.out.println("Unesite u formatu 'java ZamenaTeksta Test.java t.txt StringBuilder StringBuffer'");
            System.exit(1);
        }
        
        try{
            File fp = new File(args[0]);
            FileWriter txt = new FileWriter(args[1]);
            Scanner scan = new Scanner(fp);

            while(scan.hasNextLine()){
                String data = scan.nextLine();
                String[] spl = data.split(" ");
                for(String a : spl){
                    if(a.equals(args[2])) a = args[3];
                    txt.write(a + " ");
                }
                txt.write("\n");
            }
            txt.close();
            scan.close();
        } catch(FileNotFoundException e){
            e.printStackTrace();
        } catch(IOException e){
            e.printStackTrace();
        } 
    }
}
