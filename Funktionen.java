
/**
 * Write a description of class Funktionen here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Funktionen
{
    /**
     * Standardkonstruktor der Klasse Funktionen
     */
    public Funktionen()
    {  
    }

    /**
     * Erste Funktion: Berechnen der Teilersumme
     *
     * @param  natuerliche Zahl (>=0)
     * @return teilersumme
     */
    public static int berechneTeilersumme(int y)
    {
        check((y>=0),"Eingegebene Zahl ist keine natuerliche Zahl!");
        int i, teilersumme;      
        
        for(i =1,teilersumme=0;i*i<y;i++)
        {
            if (y % i == 0)
            {
                teilersumme+=i+y/i;
            } 
            
        }
        return teilersumme;
    }
    
    /**
     * Zweite Funktion: Pruefziffer fuer ISBN berechnen.
     *
     * @param  zu pruefende Zahl. in diesem Fall mit 9 Zeichen
     * @return isbn mit der pruefziffer
     */
    public static String berechnePruefziffer(long isbn)
    {
       String s =String.valueOf(isbn);
       while (s.length()<9)
       {
           s = "0"+s;
        }
       check(((isbn > 0) && (isbn < 999999999) && (s.length()==9)),"Eingegebene Zahl ist keine gueltige ISBN");
       
       long summe=0;
       for(int i=9;i>0;i--)
       {
           summe +=(isbn % 10) *i;
           isbn = isbn/10;
       }
         
       if (summe % 11 == 10)
         {
          return s+"-X";
         }
       else
         {
          return s+"-" + summe % 11;
         }
    }

      
    /**
     * Dritte Funktion: Nullstellen fuer quadtratische Gleichung berechnen mittels p-q Formel. Fall: D>0: Es gibt 2 reelle Nullstellen.
     *
     * @param  Variablen p und q. Beide sind vom Datentyp double.
     * @return nullstelle1 und nullstelle2
     */
    public static String berechneNullstellen(double p,double q)
    {
        double nullstelle1 = 0;
        double nullstelle2 = 0;
        
        nullstelle1 = -(p/2)- Math.sqrt((p/2)*(p/2)-q);
        nullstelle2 = -(p/2)+ Math.sqrt((p/2)*(p/2)-q);
                     
        String nullstelle="Nullstellen sind ("+nullstelle1+"|0) und ("+nullstelle2+"|0).";
        return nullstelle;
    }
    /**
     * Dritte Funktion: Nullstellen fuer quadtratische Gleichung berechnen mittels p-q Formel. Fall: D=0: Es gibt 1 Nullstelle.
     *
     * @param  Variable p. q wird hier nicht benoetigt.
     * @return nullstelle1 und nullstelle2
     */
    public static String berechneNullstelle(double p)
    {
        double nullstelleDoppelt = -(p/2.0);
                     
        String doppelteNullstelle="Doppelte Nullstelle bei: ("+nullstelleDoppelt+"|0)";
        return doppelteNullstelle;
    }
    /**
     * Check-Methode um Fehler zu erkennen und als 
     * IllegalArgumentException auszuwerfen.
     */
    private static void check(boolean bedingung, String error)
    {
        if (!bedingung)
           throw new IllegalArgumentException(error);
    }
    
    
   
}
