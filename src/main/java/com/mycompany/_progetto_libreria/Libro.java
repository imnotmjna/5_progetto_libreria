/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany._progetto_libreria;

/**
 * Classe che rappresenta un libro
 * @author Studente
 */
public class Libro 
{
    private String titolo;
    private String autore;
    private int numeroPagine;
    private static double costoPagina=0.05;
    private final double COSTO_FISSO=5.5;
    /**
     * Metodo costruttore
     * @param titolo titolo del libro
     * @param autore autore del libro
     * @param numeroPagine numero di pagine di cui è costituito il libro
     */
    public Libro(String titolo, String autore, int numeroPagine)
    {
        setTitolo(titolo);
        setAutore(autore);
        setNumeroPagine(numeroPagine);
    }
    /**
     * Costruttore di copia
     * @param libro Il libro da copiare
     */
    public Libro(Libro libro)
    {
        titolo=libro.getTitolo();
        autore=libro.getAutore();
        numeroPagine=libro.getNumeroPagine();
    }
    /**
     * 
     * @return il prezzo del libro
     */
    public double prezzo()
    {
        double p;
        p=COSTO_FISSO+(numeroPagine+costoPagina);
        return p;
    }
    /**
     * 
     * @return Il titolo del libro
     */
    public String getTitolo()
    {
        return titolo;
    }
    /**
     * 
     * @return L'autore del libro
     */
    public String getAutore()
    {
        return autore;
    }
    /**
     * 
     * @return Il numero di pagine di cui + costituito il libro
     */
    public int getNumeroPagine()
    {
        return numeroPagine;
    }
    /**
     * 
     * @return Il costo di una singola pagina
     */
    public double getCostoPagina()
    {
        return costoPagina;
    }
     /**
      * 
      * @return Il costo fisso del libro
      */
    public double getCOSTO_FISSO()
    {
        return COSTO_FISSO;
    }
    /**
     * Assegna un autore al libro
     * @param autore 
     */
    public void setAutore(String autore)
    {
        this.autore=autore;
    }
    /**
     * Assegna un titolo al libro
     * @param titolo 
     */
    public void setTitolo(String titolo)
    {
        this.titolo=titolo;
    }
    /**
     * Assegna un numero di pagine al libro
     * @param numeroPagine 
     */
    public void setNumeroPagine(int numeroPagine)
    {
        this.numeroPagine=numeroPagine;
    }
    /**
     * Assegna un costo ad una pagina del libri
     * @param costoP 
     */
    public static void setCostoPagina(int costoP)
    {
        costoPagina=costoP;
    }
    /**
     * Restituisce il libro in formato testuale
     * @return 
     */
    public String toString()
    {
        String s;
        s=getTitolo()+";"+getAutore()+";"+getNumeroPagine()+";"+prezzo()+" €";
        return s;
    }
}
