
/**
 * Un tassometro
 * Gestisce le tasse in base a tre soglie
 * 
 * Sotto la prima soglia bisogna pagare il 10% delle tasse 
 * Tra la prima soglia e la seconda bisogna pagare il 26% di reddito - prima soglia
 * Oltre la terza si aggiunge il 35% di reddito - seconda soglia
 * 
 * @author Greta Maria Brugnatti
 * @version 3/11/2024 */
public class Tassometro
{
    private int [] soglie;
    private int [] aliquote;

    /**
     * Costruttore dell'oggetto Tassometro date le soglie
     * Di default le aliquote sono quelle scritte nella descrizione della classe
     * 
     * @param soglia1 Prima soglia
     * @param soglia2 Seconda soglia
     * @param soglia3 Terza soglia
     */
    public Tassometro(int soglia1, int soglia2, int soglia3)
    {
        if(soglia1 < 0 || soglia2 < 0 || soglia3 < 0){
            throw new IllegalArgumentException("Impossibile creare l'oggetto. Le soglie non posso essere negative");
        }
        
        soglie = new int [3];
        aliquote = new int [3];
        
        soglie[0] = soglia1;
        soglie[1] = soglia2;
        soglie[2] = soglia3;
        
        aliquote[0] = 10;
        aliquote[1] = 26;
        aliquote[2] = 35;
    }
    /**
     * Costruttore dell'oggetto Tassometro date le soglie e le aliquote
     * 
     * @param soglia1 Prima soglia
     * @param soglia2 Seconda soglia
     * @param soglia3 Terza soglia
     * 
     * @param aliquota1 Prima aliquota in percentuale
     * @param aliquota2 Seconda aliquota in percentuale
     * @param aliquota3 Terza aliquota in percentuale
     */
    public Tassometro(int soglia1, int soglia2, int soglia3, int aliquota1, int aliquota2, int aliquota3)
    {
        if(soglia1 < 0 || soglia2 < 0 || soglia3 < 0){
            throw new IllegalArgumentException("Impossibile creare l'oggetto. Le soglie non possono essere negative");
        }
        if(aliquota1 < 0 || aliquota2 < 0 || aliquota3 < 0){
            throw new IllegalArgumentException("Impossibile creare l'oggetto. Le aliquote non possono essere negative");
        }
        soglie[0] = soglia1;
        soglie[1] = soglia2;
        soglie[2] = soglia3;
        
        aliquote[0] = aliquota1;
        aliquote[1] = aliquota2;
        aliquote[2] = aliquota3;
    }

    /**
     * Calcola le tasse da pagare 
     * 
     * @param importo  Importo su cui applicare le tasse
     * @return         Ritorna le tasse da pagare
     */
    public float getTasse(float importo)
    {
        if(importo < 0){
            throw new IllegalArgumentException("Impossibile utilizzare il seguente metodo. L'importo non può essere negativo");
        }
        float tasse = 0;
        
        if(importo < soglie[0]){
            tasse = importo * aliquote[0] / 100;
        }
        if(importo > soglie[0] && importo < soglie[1]){
            tasse = soglie[0] * aliquote[0] / 100;
            tasse = tasse + ((importo - soglie[0]) * aliquote[1] / 100);
        }
        if(importo > soglie[2]){
            tasse = soglie[0] * aliquote[0] / 100;
            tasse = tasse + (soglie[1] - soglie[0]) * aliquote[1] / 100;
            tasse = tasse + ((importo - soglie[2]) * aliquote[2] / 100);
        }
        return tasse;
    }
    
    public String toString(){
        String tabella;
        tabella = "Soglie" + "    " + "Aliquote" + "\n";
        tabella = tabella + String.valueOf(soglie[0]) + "       " + String.valueOf(aliquote[0])+ "\n";
        tabella = tabella + String.valueOf(soglie[1]) + "       " + String.valueOf(aliquote[1]) + "\n";
        tabella = tabella + String.valueOf(soglie[2]) + "       " + String.valueOf(aliquote[2]);
        return tabella;
    }
    /**
     * Data il numero restituisce la soglia
     * 
     * @param a Numero compreso tra 1 e 3
     * @return Soglia
     */    
    public int getSoglia(int a){
        if(a<1 && a>3){
            throw new IllegalArgumentException("Impossibile utilizzare il seguente metodo. a non è compreso tra 1 e 3.");
        }
        return soglie[a-1];
    }
    /**
     * Cambia la soglia desiderata
     * 
     * @param soglia    Nuovo valore della soglia 
     * @param a         Quale soglia, numero compreso tra 1 e 3
     * 
     */
    public void setSoglia(int soglia, int a){
        if(a<1 && a>3){
            throw new IllegalArgumentException("Impossibile utilizzare il seguente metodo. a non è compreso tra 1 e 3.");
        }
        
        if(soglia < 0){
            throw new IllegalArgumentException("Impossibile utilizzare il seguente metodo. Le soglie non possono essere negative");
        }
        
        soglie[a-1]=soglia;
        
    }
}
