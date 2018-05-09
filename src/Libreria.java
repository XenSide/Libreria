import java.io.*;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.ListIterator;

public class Libreria {
   static private ArrayList<Libro> lib = new ArrayList<>();

     static String addLibro (String titolo,String autore, Double prezzo){
         Libro a = new Libro(titolo, autore, prezzo);
         lib.add(a);
         return a.toString();
    }

    static private void saveOnFile(ArrayList<Libro>lib){
        FileWriter f = null;
        try {
            f = new FileWriter("Lib.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        PrintWriter fOUT = new PrintWriter(f);
        ListIterator<Libro> libItr = lib.listIterator();

        if (lib.get(0)!=null) {
            do {
                fOUT.println(lib.get(0));
                fOUT.flush();
                lib.remove(0);
            }while (libItr.hasNext());
        }
     }

    public static void main(String[] args){
        BufferedReader tastiera = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Inserisci i dati del libro 1");
        String titolo="Errore", autore="Errore";
        Double prezzo=0.0;
        boolean isDone;
        int menu=0;
        do{
        System.out.println("Decidi cosa fare:\n 1 Aggiungere un libro \n 2 Salvare");
        try {
            menu=Integer.valueOf(tastiera.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        switch(menu){
            case 1:
                try {
                    titolo=tastiera.readLine();
                    autore=tastiera.readLine();
                    prezzo=Double.valueOf(tastiera.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Libro a = new Libro(titolo, autore, prezzo);
                lib.add(a);
                isDone=false;
                break;
            case 2:
                saveOnFile(lib);
                isDone=true;
                break;
            case 3: default: case 0:
                isDone=false;
                break;
            }
        }while (!isDone);}

}
