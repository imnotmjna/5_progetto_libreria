/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany._progetto_libreria;

/**
 *
 * @author Studente
 */
public class Mensola 
{
    private Libro[] volumi;
    private final static int NUM_MAX_VOLUMI=15;
    
    public Mensola()
    {
        volumi=new Libro[NUM_MAX_VOLUMI];
    }
    
    public Mensola(Mensola mensola)
    {
        volumi=new Libro[NUM_MAX_VOLUMI];
        Libro lib;
        for(int i=0;i<mensola.getNumMaxVolumi();i++)
        {
            lib=mensola.getVolume(i);
            if(lib!=null)
                volumi[i]=lib;
        }
    }
    /**
     * Costruttore che riceve un array di libri e istanzia una mensola contenente i libri dell'array passato.
     * Se i libri dell'array sono + di 15 i libri in eccesso vengono ignorati,
     * I libri vengono aggiunti alla mensola nello stesso ordine i cui si trovano nell'array.
     * @param elencoLibri 
     */
    public Mensola(Libro[] elencoLibri)
    {
        volumi=new Libro[NUM_MAX_VOLUMI]; //creo array vuota nella mensola
        
        //il numero di libri da aggiungere è pari alla lunghezza dell'array se essa è< di 15 
        //altrimenti il numero di libri da aggiungere è 15
        int numeroLibriDaAggiungere=elencoLibri.length;
        if (numeroLibriDaAggiungere>NUM_MAX_VOLUMI)
            numeroLibriDaAggiungere=NUM_MAX_VOLUMI;
        
        //aggiungo i libri dell'array a volumi
        for(int i=0;i<numeroLibriDaAggiungere;i++)
        {
            setVolume(elencoLibri[i], i);
        }
    }
    
    /**
     *  Aggiunge un libro alla mensola nella posizione indicata 
        
     * @param volume E'  una copia del libro da aggiungere
     * @param posizione E' la posizione in cui si vuole posizionare il libro
     * @return 
     *  se la posizione non esiste --> return -1
        se la posizione è già occupata --> return -2
        se il libro viene posizionato --> return posizione 
     */
    public int setVolume(Libro volume, int posizione)
    {
        /*if (posizione<0 || posizione>=NUM_MAX_VOLUMI)
            return -1; //la posizione non esiste 
        */
        
        try
        {
            if (volumi[posizione]!=null)
                return -2; //la posizione è già occupata
        
            volumi[posizione]=new Libro(volume);
            return posizione;
        }
        catch(ArrayIndexOutOfBoundsException e)
        {
            return -1;
        }
        
    }
    
    /**
     * Restituisce il libro che si trova in una determinata posizione

     * @param posizione
     * @return Il libro che si trova nrlla posizione indicata
     * se la posizione è vuota --> return null
       se la posizione<0 o >= NUM_MAX_LIBRI (non valida) --> return null
     */
    public Libro getVolume(int posizione)
    {
        /*if(posizione <0 || posizione>=NUM_MAX_VOLUMI)
            return null;
        
        if(volumi[posizione]==null)
            return null;
        */
        
        try
        {
            return new Libro(volumi[posizione]);
        }
        catch(ArrayIndexOutOfBoundsException | NullPointerException e)
        {
            return null;
        }
    }
   
    /**
     * Libera (inserendo null) la posizione "posizione" e restituisce il numero della
    posizione "liberata"
    se la posizione indicata è<0 o >= NUM_MAX_LIBRI (non valida) --> return -1
    se la posizione è già vuota --> return -2
     */
    
    public int rimuoviVolume(int posizione)
    {
        /*
        if (posizione<0 || posizione>=NUM_MAX_VOLUMI)
            return -1;
        */
        
        try
        {
            if (volumi[posizione]==null)
                return -2;
            volumi[posizione]=null;
            return posizione;
        }
        catch(ArrayIndexOutOfBoundsException e)
        {
            return -1;
        }
    }
    
    /**
     * Restituisce il numero massimo di volumi presenti nella mensola
     * @return 
     */
    public int getNumMaxVolumi()
    {
        return NUM_MAX_VOLUMI;
    }
    
    public int getNumVolumi()
    {
        int contaLibri=0;
        
        for(int i=0; i<NUM_MAX_VOLUMI;i++)
        {
            if(volumi[i]!=null)
                contaLibri++;
        }
        return contaLibri;
    }
    
    public boolean presenzaTitolo(String titoloDaCercare)
    {
        for(int i=0;i<NUM_MAX_VOLUMI;i++)
        {
            if(volumi[i]!=null)
            {
                if(volumi[i].getTitolo().equals(titoloDaCercare))
                    return true;
            }
        }
        return false;
    }
    
    /**
     * Mostra ogni posizione con l'eventuale volume contenuto
     * @return 
     */
    
    public String toString()
    {
        String s="";
        for(int i=0; i<NUM_MAX_VOLUMI;i++)
        {
            s=s+i+"\t--> ";
            if(volumi[i]!=null)
                s=s+volumi[i].toString()+"\n";
            else
                s=s+"\n";
        }
        return s;
    }
}

