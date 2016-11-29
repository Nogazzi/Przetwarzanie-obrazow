/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spam;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nogaz
 */
public class Spam {

    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        File obraz1;
        File obraz2;
        BMPHeader fileInfo;
        BMPInfoHeader pictureInfo;
        //int i;
        int j;
        char szary;
        short padding;
        Pixel[][] pixmapa;
        
        //wczytanie pliku
        Path sciezkaPlikuWczytanego = Paths.get("star_32_mn.bmp");      
        byte[] daneObrazuWczytanego = null;
        try {
            daneObrazuWczytanego = Files.readAllBytes(sciezkaPlikuWczytanego);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        /*
        //tworzenie nowego niezmienionego pliku
        File nowyObraz = new File("newUnchanged.bmp");
        FileOutputStream fos;
        try {
            fos = new FileOutputStream(nowyObraz);
            fos.write(daneObrazuWczytanego);
            fos.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }*/
        
        System.out.println("dlugosc tablicy: " + daneObrazuWczytanego.length + " bajtów");
        
        
        System.out.println("Obraz wypisany bajt po bajcie: ");
        for( int i = 0 ; i < daneObrazuWczytanego.length ; ++i ){
            if( i == 0 ){
                System.out.println("\nNaglowek pliku BMP:");
                System.out.println("(2 BAJTY) pole służy do sprawdzenia, czy plik jest zapisany w formacie BMP i powinno zawierać napis 'BM', tj 66, 77");
                System.out.println(":::");
            }
            if( i == 2 ){
                System.out.println(":::");
                System.out.println("(4 BAJTY) określenie długości pliku w bajtach:");
                System.out.println(":::");
            }
            if( i == 6 ){
                System.out.println(":::");
                System.out.println("(2 BAJTY) zarezerwowane0 (zera):");
                System.out.println(":::");
            }
            if( i == 8 ){
                System.out.println(":::");
                System.out.println("(2 BAJTY) zarezerwowane1 (zera)");
                System.out.println(":::");
            }
            if( i == 10 ){
                System.out.println(":::");
                System.out.println("(4 BAJTY) położenie obszaru danych względem początku pliku:");
                System.out.println(":::");
            }
            if( i == 14 ){
                System.out.println(":::");
                System.out.println("\nNaglowek rysunku:");
                System.out.println("(4 BAJTY) długość nagłówka rysunku (40)");
                System.out.println(":::");
            }
            if( i == 18 ){
                System.out.println(":::");
                System.out.println("(4 BAJTY) szerokość rysunku w punktach");
                System.out.println(":::");
            }
            if( i == 22 ){
                System.out.println(":::");
                System.out.println("(4 BAJTY) wysokość rysunku w punktach");
                System.out.println(":::");
            }
            if( i == 26 ){
                System.out.println(":::");
                System.out.println("(2 BAJTY) liczba planów w urządzeniu docelowym, zawsze równa 1");
                System.out.println(":::");
            }
            if( i == 28 ){
                System.out.println(":::");
                System.out.println("(2 BAJTY) pole określa ile kolejnych bitów z obszaru danych opisuje kolor jednego punktu rysunku. Jednocześnie informuje ono, ile maksymalnie kolorów zawiera paleta kolorów.");
                System.out.println(" 1 - obrazek jest dwubarwny, paleta kolorów zawiera opis maksymalnie dwóch barw, każdy bit obszaru danych określa kolor jednego punktu rysunku");
                System.out.println(" 4 - obrazek może mieć maksimum 16 kolorów i taka jest maksymalna liczba barw w palecie kolorów, każde cztery bity obszaru danych określają barwę jednego punktu");
                System.out.println(" 8 - obrazek może mieć maksimum 256 kolorów, paleta zawiera opis maksimum 256 barw, każdy punkt rysunku opisywany jest przez 8 bitów");
                System.out.println(" 24 - rysunek może mieć maksimum 2^24 = 16.777.216 kolorów (True Color), w tym przypadku nie ma palety kolorów tylko każde trzy bajty obszaru danych określają odpowiednio natężenie koloru czerwonego, zielonego i niebieskiego");
                System.out.println(" 32 - rysunek może mieć maksimum 2^24 = 16.777.216 kolorów (True Color), w tym przypadku nie ma palety kolorów tylko każde cztery bajty obszaru danych określają odpowiednio natężenie koloru czerwonego, zielonego i niebieskiego zaś ostatni bajt może służyć do przechowywania składowej A (Alpha), bądź nie jest wykorzystany");
                System.out.println(":::");
            }
            if( i == 30 ){
                System.out.println(":::");
                System.out.println("(4 BAJTY) Pole określa sposób kompresji obszaru danych pliku i może przyjmować jedną z trzech wartości:");
                System.out.println(" 0 - brak kodowania");
                System.out.println(" 1 - kodowanie RLE8 (Run Length Encoding 8-Bits)");
                System.out.println(" 2 - kodowanie RLE4 (Run Length Encoding 4-Bits)");
                System.out.println(":::");
            }
            if( i == 34 ){
                System.out.println(":::");
                System.out.println("(4 BAJTY) długość obszaru danych w bajtach");
                System.out.println(":::");
            }
            if( i == 38 ){
                System.out.println(":::");
                System.out.println("(4 BAJTY) rozdzielczość pozioma obrazka w punktach na metr");
                System.out.println(":::");
            }
            if( i == 42 ){
                System.out.println(":::");
                System.out.println("(4 BAJTY) rozdzielczość pionowa obrazka w punktach na metr");
                System.out.println(":::");
            }
            if( i == 46 ){
                System.out.println(":::");
                System.out.println("(4 BAJTY) pole określa ile kolorów z palety jest wykorzystywanych w rysunku, wartość zero oznacza, że wykorzystywana jest cała paleta, w trybie True Color (24-bitowym) zmienna ta określa wielkość tabeli kolorów, która wystarcza, aby program wczytujący rysunek mógł pomieścić użyte w rysunku kolory");
                System.out.println(":::");
            }
            if( i == 50 ){
                System.out.println(":::");
                System.out.println("(4 BAJTY) pole określa ile kolorów wystarcza, aby możliwie poprawnie wyświetlić rysunek, zaleca się aby kolory w palecie były uszeregowane według malejącego znaczenia w rysunku, zero oznacza, że cała paleta jest istotna");
                System.out.println(":::");
            }
            if( i == 54 ){
                System.out.println("\nDane obrazu:");
            }
            System.out.println(daneObrazuWczytanego[i] + "  ### " + Byte.toUnsignedInt(daneObrazuWczytanego[i]));
            
        }
        /*
        //DZIALA TYLKO Z BITMAPA 24
        System.out.println("Wypisanie danych obrazu(kolorow pixeli:");
        int licznikPixli = 0;
        int licznikWypisania = 0;
        int x = 0;
        int y = 0;
        for( int i = 54; i < daneObrazuWczytanego.length ; ++i ){
            if( licznikWypisania == 3 ){
                licznikWypisania = 0;
            }
            if( licznikWypisania == 0 ){
                System.out.print("R: ");
            }else if( licznikWypisania == 1 ){
                System.out.print("G: ");
            }else if( licznikWypisania == 2 ){
                System.out.print("B: ");
            }
            System.out.print(Byte.toUnsignedInt(daneObrazuWczytanego[i]) + "\n");
            licznikPixli++;
            licznikWypisania++;
        }
        System.out.println("liczba pixli: " + licznikPixli);
        */
        System.out.println("Bajt nr 3 = " + Byte.toUnsignedInt(daneObrazuWczytanego[2]));
        System.out.println("Bajt nr 11 = " + Byte.toUnsignedInt(daneObrazuWczytanego[10]));
    }
    
    
}
