/*+a
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany._progetto_libreria;

import eccezioni.EccezionePosizioneNonValida;
import eccezioni.EccezionePosizioneOccupata;

/**
 *Rappresenta uno scaffale costituito da
 * NUM_RIPIANI mensole, ciascuna delle quali può contenere dei libri
 * @author Studente
 */
public class Scaffale 
{
    private Mensola[] ripiani; //array di mensole
    private final static int NUM_RIPIANI=5;
    
    /**
     * Costruttore
     */
    public Scaffale()
    {
        ripiani=new Mensola[NUM_RIPIANI];
        //istanzio una mensola vuota per ciascun ripiano
        for(int i=0;i<NUM_RIPIANI;i++)
        {
            ripiani[i]=new Mensola();
        }
    }
    
    public Scaffale (Scaffale scaf) 
    {
        ripiani=new Mensola[NUM_RIPIANI];
        Libro lib;
        for(int i=0;i<NUM_RIPIANI;i++)
        {
            ripiani[i]=new Mensola();
            for (int j=0;j<scaf.getNumMaxLibri(i);j++)
            {
                lib=scaf.getLibro(i, j);
                if(lib!=null)
                    this.setLibro(scaf.getLibro(i, j), i, j);
            }
        }
    }
    
    /**
     * Inserisce il libro nella posizione "posizione" del ripiano “ripiano”.
        se il ripiano non è valido --> return -3
        se la posizione non è valida --> return -1
        se la posizione è già occupata --> return -2
        se ok  return 0
     */
    
    public int setLibro(Libro libro, int ripiano, int posizione)
    {
        int esito;
        
        if(ripiano<0||ripiano>=NUM_RIPIANI)
            return -3;
        esito=ripiani[ripiano].setVolume(libro, posizione);
        if(esito>=0)
            return 0;
        else
            return esito; //return -1 o -2
    }
    /**
     * Restituisce il libro che si trova in un certo ripiano, in una certa posizione
     * @param ripiano
     * @param posizione
     * @return null se il ripiano non esiste, se la posizione non esiste oppure se nei dati ripiano/posizione non è presente il libro
     *         negli altri casi restituisce il libro
     */
        public Libro getLibro(int ripiano, int posizione)
        {
            if(ripiano<0 || ripiano>=NUM_RIPIANI)
                return null;
            Libro lib;
            lib=ripiani[ripiano].getVolume(posizione);
            return lib;
        }
        
        /**
         * Rimmuove un volume da un determinato ripiano e una determinata posizione 
         * @param ripiano
         * @param posizione
         * @return se il ripiano non è valido--> return -3;
         *         se la posizione non è valida--> return -1;
         *         se la poszione è vuota--> return -2;
         *         se il volume è rimosso correttamente--> return 0;
         */
        public int rimuoviLibro(int ripiano, int posizione)
        {
            int esito;
        
            if(ripiano<0||ripiano>=NUM_RIPIANI)
                return -3; //non valido
            esito=ripiani[ripiano].rimuoviVolume(posizione);
            if(esito>=0)
                return 0; //tutto ok
            else
                return esito; //return -1 o -2
        }
        
        /**
         * Restituisce il numero di mensole(ripiani) presenti nello scaffale 
         * @return 
         */
        public int getNumRipiani()
        {
            return NUM_RIPIANI;
        }
        /**
         *Restituisce il numero massimo di libri contenuti in uno scaffale
         * @return 
         */
        public int getNumMaxLibri()
        {
            int contatore=0;
            for(int i=0;i<NUM_RIPIANI;i++)
            {
                contatore+=ripiani[i].getNumMaxVolumi();
            }
            return contatore;
        }
        
        /**
         * Restituisce il numero di volumi presenti nello scaffale
         * @return 
         */
        public int getNumLibri()
        {
            int contaVolumi=0;
            for(int i=0; i<NUM_RIPIANI;i++)
            {
                contaVolumi+=ripiani[i].getNumVolumi();
            }
            return contaVolumi;
        }
        
        /**
         * Restituisce il numero di volumi presenti nel ripiano
         * @param ripiano
         * @return se il ripiano non esiste--> return -1;
         */
        public int getNumLibri(int ripiano)
        {
            if(ripiano<0 || ripiano>NUM_RIPIANI)
                return -1;
            return ripiani[ripiano].getNumVolumi();
        }
        /**
         * Restituisce il numero massimo di volumi presenti nel ripiano
         * @param ripiano
         * @return se il ripiano non esiste--> return -1;
         */
        public int getNumMaxLibri (int ripiano)
        {
            if(ripiano<0 || ripiano>NUM_RIPIANI)
                return -1;
            return ripiani[ripiano].getNumMaxVolumi();
        }
        /**
         * Restituisce una stringa che contiene i volumi presenti in ciascun scaffale
         * @return 
         */
        public String toString()
        {
            String s="";
            for(int i=0; i<NUM_RIPIANI;i++)
            {
                s+="Ripiano "+i+":\n"+ripiani[i].toString();
            }
            return s;
        }
        
        public String[] elencoTitoliAutore(String autore)
        {
            Libro lib;
            
            String[] elencoTitoliAutore;
            
            int contaLibriAutore=0;
            for(int i=0; i>NUM_RIPIANI;i++)
            {
                for(int j=0; j<ripiani[i].getNumMaxVolumi();j++)
                {
                    lib=this.getLibro(i, j);
                    if(lib!=null)
                    {
                        if(lib.getAutore().equalsIgnoreCase(autore))
                        {
                            contaLibriAutore++; //sarà la dimensione dell'array
                        }
                    }
                }
            }
            //se non cisono libri dell'autore-->return null
            if(contaLibriAutore==0)
                return null;
            
            //istanzio l'array DINAMICAMENTE (run time, durante l'esecuzione)
            elencoTitoliAutore=new String[contaLibriAutore];
                    
            //copio i titoli dell'autore nell'array di titoli
            contaLibriAutore=0;
            for(int i=0; i>NUM_RIPIANI;i++)
            {
                for(int j=0; j<ripiani[i].getNumMaxVolumi();j++)
                {
                    lib=this.getLibro(i, j);
                    if(lib!=null)
                    {
                        if(lib.getAutore().equalsIgnoreCase(autore))
                        {
                            elencoTitoliAutore[contaLibriAutore]=lib.getTitolo();
                            contaLibriAutore++; //sarà la dimensione dell'array
                        }
                    }
                }
            }
            return elencoTitoliAutore;
        }
        
}
