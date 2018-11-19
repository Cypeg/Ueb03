import java.util.*;
/**
 * Klasse FunktionenDialog: Interative Testklasse der Klasse Funktionen.
 *
 * @author JKrier, JVogt
 * @version Ueb03
 */
public class FunktionenDialog
{
    public Funktionen   funktion;
    public Scanner      input;
    private final String msg1 = "\nHier eine positive ganze Zahl eingeben.";
    private final String msg2 ="\nHier eine rationale Zahl eingeben.";
    /**
     * Konstruktor.
     */
    public FunktionenDialog()
    {
        Funktionen funktion = new Funktionen();
        input = new Scanner( System.in );
    }
    /**
     * Methode run(): Interaktives Testprogramm. Beinhaltet 4 Auswahlmoeglichkeiten, sowie drei Exception catcher bei ungueltigen Eingaben bei den Methoden. 
     * Die drei zu testende Funktionen sowie der Moeglichkeit das Programm mit der Eingeab "0" zu beenden.
     */
    
    public void run()
     {
        int wahl=1;
                              
     
       while ( wahl != 0 )
       {
          wahl = readlnInt("\n Bitte waehlen Sie aus: "+
                          "\n 1) Teilersummenergebnis berechnen = 1"+
                          "\n 2) ISBN Pruefziffer berechnen = 2"+
                          "\n 3) Nullstellen einer quadratischen Gleichung berechnen = 3"+
                          "\n Ende = 0\n");
                          
        try
        {
           
          System.out.println ("");
          switch (wahl)
          {
             case 0:
                 System.out.println("Ende");
                 break;
             case 1:
                 System.out.println("\nTeilersumme = "+funktion.berechneTeilersumme(zahl()));
                 break;
             case 2:
                 System.out.println("\n"+funktion.berechnePruefziffer(isbn()));
                 break;
             case 3:
                 System.out.println(gleichung());
                 break;
            
             default:
                 System.out.println("Ungueltige Eingabe!");
                 break;
          }
        }
        catch (AssertionError ae)
        {
            System.err.println(ae);
        } 
        catch ( NumberFormatException nfe)
        {  
            System.err.println(nfe);                           
        }       
        catch ( RuntimeException rex)
        {  
            System.err.println(rex);
        } 
       }                   
     }
     
    /**
     * Methode zahl() dient zum Einlesen des Parameters fuer die Berechnung der Teilersumme.
     * @return: Parameterwert fuer Methode berechneTeilersumme(zahl()).
     */
     public int zahl()
     {
         int zahl;
         zahl = readlnInt("Natuerliche Zahl eingeben: ");
         return zahl;
     }
     
     /**
     * Methode isbn() dient zum Einlesen der zu pruefenden ISBN neunstelligen Zahl
     * @return: Parameterwert fuer Methode berechnePruefziffer(isbn()).
     */
     public long isbn()
     {
         long isbn;
         isbn = readlnLong("Zu pruefende (neunstellige) ISBN  eingeben: ");
         
         return isbn;
     }
     
     /**
     * Methode gleichung() dient zur Fallunterscheidung, welche Nullstellenart vorliegt
     * und gibt -sofern es keine komplexe Nullstellen sind- die Nullstellen durch Methodenaufruf als String zurueck. 
     * @return: Parameterwert fuer Methode berechnePruefziffer(isbn()).
     */
     public String gleichung()
     {
         double p = p();
         double q = q();
         double d =(p/2)*(p/2)-q;
         
         String ergebnis = new String();
         
         if (d > 0.0)
         {
             ergebnis=funktion.berechneNullstellen(p,q);
         }
         if (d > -0.000000000000001 && d<0.000000000000001)
         {
             ergebnis=funktion.berechneNullstelle(p);
         }
         if (d < 0.0)
         {
             ergebnis = "\nKomplexe Nullstelle!";
         }
         return ergebnis;
     }
     
     /**
     * Methode p() dient zum Einlesen Variable p fuer die p-q-Formel
     * @return: Parameterwert fuer Methode gleichung().
     */
     public double p()
     {
         double p;
         p = readlnDouble("Zahl p eingeben: ");
         return p;
     }
     
     /**
     * Methode q() dient zum Einlesen Variable q fuer die p-q-Formel
     * @return: Parameterwert fuer Methode gleichung().
     */
     public double q()
     {
         double q;
         q = readlnDouble("Zahl q eingeben: ");
         return q;
     }
     
     /**
     * Methode readlnInt() dient zum Einlesen von int Werten.
     * @param String eingabe
     * @return: eingelesener int wert
     */
      private int readlnInt(String eingabe)
      {
        int wert = 0;
        try 
        {
            System.out.print(eingabe);
            wert= input.nextInt();
            input.nextLine();
            
        }
        
        catch (InputMismatchException e) 
        {
            System.err.println(e+ msg1);
        } 
        return wert;
     }
     
     /**
     * Methode readlnLong() dient zum Einlesen von long Werten.
     * @param String eingabe
     * @return: eingelesener long wert
     */
     public long readlnLong(String eingabe)
     {
        long wert = 0;
        try 
        {
            System.out.print(eingabe);
            wert= input.nextInt();
            input.nextLine();
            
        }
        
        catch (InputMismatchException e) 
        {
            System.err.println(e+ msg1);
        } 
        return wert;
     }
     
     /**
     * Methode readlnDouble() dient zum Einlesen von double Werten.
     * @param String eingabe
     * @return: eingelesener double wert
     */
     public double readlnDouble(String eingabe)
     {
        double wert = 0;
        try 
        {
            System.out.print(eingabe);
            wert= input.nextInt();
            input.nextLine();
            
        }
        
        catch (InputMismatchException e) 
        {
            System.err.println(e+ msg2);
        } 
        return wert;
     }
     
     /**
     * Die Main Methode dient zum starten des interaktiven Dialogs, der zum Testen der Methoden der Klasse Funktionen dient.
     * @param args Kommandozeilenparameter
     */
     public static void main (String[]args)
     {
         FunktionenDialog dialog = new FunktionenDialog();
         dialog.run();
    }
}
