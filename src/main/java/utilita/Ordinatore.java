/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilita;

import com.mycompany._progetto_libreria.Libro;

/**
 *Rappresenta una libreria di funzioni per ordinare array di interi o stringhe con (in ordine crescente/decrescente) diversi algoritmi
 *Per ordinare array di altri tipi di oggetti è possibile aggiungere nuovi metodi, copiando/incollando/modificando i metodi esistenti.
 * @author Studente
 * 
 */
public class Ordinatore 
{
    /**
     * Scambia fra di loro gli elementi in posizione "pos1" e "pos2" di un array "v" di interi
     * @param v array che contiene gli elementi da scambiare
     * @param pos1 posizione del primo elemento
     * @param pos2 posizione del secondo elemento
     */
    public static void scambia(int[] v, int pos1, int pos2)
    {
        int sost=v[pos1];
        v[pos1]=v[pos2];
        v[pos2]=sost;
    }
    
    /**
     * Scambia fra di loro gli elementi in posizione "pos1" e "pos2" di un array "v" di stringhe
     * @param v
     * @param pos1
     * @param pos2 
     */
    public static void scambia(String[] v, int pos1, int pos2)
    {
        String sost=v[pos1];
        v[pos1]=v[pos2];
        v[pos2]=sost;
        
    }
    
    /**
     * Restituisce una copia ordinata in ordine crescente di un array "v" di interi
     * secondo l'arlgoritmo selection sort
     * @param v vettore da ordinare
     * @return il vettore in ordine crescente
     */
    public static int[] selectionSortCrescente(int[] v)
    {
        int lunghezza=v.length;
        //creo una copia di "v" e lo chiamo "vOrdinato"
        int[] vOrdinato=new int[lunghezza];
        for(int i=0;i<lunghezza;i++)
        {
            vOrdinato[i]=v[i];
        }
        for(int i=0;i<lunghezza-1;i++)
        {
            for(int j=i+1;j<lunghezza;j++)
            {
                if(vOrdinato[j]<vOrdinato[i])
                    scambia(vOrdinato,i,j);
            }
        }
        return vOrdinato;
    }
    
    /**
     * Restituisce una copia ordinata in ordine decrescente di un array "v" di interi
     * secondo l'arlgoritmo selection sort
     * @param v vettore da ordinare
     * @return il vettore in ordine decrescente
     */
    public static int[] selectionSortDecrescente(int[] v)
    {
        int lunghezza=v.length;
        //creo una copia di "v" e lo chiamo "vOrdinato"
        int[] vOrdinato=new int[lunghezza];
        for(int i=0;i<lunghezza;i++)
        {
            vOrdinato[i]=v[i];
        }
        
        for(int i=0;i<lunghezza-1;i++)
        {
            for(int j=i+1;j<lunghezza;j++)
            {
                if(vOrdinato[j]>vOrdinato[i])
                    scambia(vOrdinato,i,j);
            }
        }
        return vOrdinato;
    }
    
    /**
     * Restituisce una copia ordinata in ordine alfabetico crescento di un array "v" di stringhe
     * secondo l'arlgoritmo selection sort
     * @param v vettore da ordinare
     * @return il vettore in ordine alfabetico crescento
     */
    public static String[] selectionSortCrescente(String[] a)
    {

        //creo una copia di "v" e lo chiamo "vOrdinato"
        String[] vOrdinato=new String[a.length];
        int lunghezza=vOrdinato.length;
        
        for(int i=0;i<vOrdinato.length;i++)
        {
            vOrdinato[i]=a[i];
        }
        for(int i=0;i<lunghezza-1;i++)
        {
            for(int j=i+1;j<lunghezza;j++)
            {
                if(vOrdinato[i].compareToIgnoreCase(vOrdinato[j])>0)
                    scambia(vOrdinato,i,j);
            }
        }
        return vOrdinato;
    }
    
    /**
     * Restituisce una copia ordinata in ordine alfabetico inverso inverso di un array "v" di stringhe
     * secondo l'arlgoritmo selection sort
     * @param v vettore da ordinare
     * @return il vettore in ordine alfabetico inverso
     */
    public static String[] selectionSortDecrescente(String[] v)
    {
        int lunghezza=v.length;
        //creo una copia di "v" e lo chiamo "vOrdinato"
        String[] vOrdinato=new String[lunghezza];
        for(int i=0;i<lunghezza;i++)
        {
            vOrdinato[i]=v[i];
        }
        for(int i=0;i<lunghezza-1;i++)
        {
            for(int j=i+1;j<lunghezza;j++)
            {
                if(vOrdinato[i].compareToIgnoreCase(vOrdinato[j])<0)
                    scambia(vOrdinato,i,j);
            }
        }
        return vOrdinato;
    }
    /**
     * Restituisce una copia ordinata in ordine alfabetico crescente di un array "v" di stringhe
     * secondo l'arlgoritmo bubble sort
     * @param v vettore da ordinare
     * @return il vettore in ordine alfabetico crescente
     */
    public static int[] bubbleSortCrescente(int[] v)
    {
        int lunghezza=v.length;
        //creo una copia di "v" e lo chiamo "vOrdinato"
        int[] vOrdinato=new int[lunghezza];
        for(int i=0;i<lunghezza;i++)
        {
            vOrdinato[i]=v[i];
        }
        
        boolean scambio=false;
        do
        {
            scambio=false;
            for(int i=0;i<lunghezza-1;i++)
            {
               if(vOrdinato[i]>vOrdinato[i+1])
               {
                   scambia(vOrdinato,i,i+1);
                   scambio=true;
               }
            }  
        }while(scambio==true);
        return vOrdinato;
    }
        /**
     * Restituisce una copia ordinata in ordine alfabetico decrescente di un array "v" di stringhe
     * secondo l'arlgoritmo bubble sort
     * @param v vettore da ordinare
     * @return il vettore in ordine alfabetico decrescente
     */
    public static int[] bubbleSortDecrescente(int[] v)
    {
        int lunghezza=v.length;
        //creo una copia di "v" e lo chiamo "vOrdinato"
        int[] vOrdinato=new int[lunghezza];
        for(int i=0;i<lunghezza;i++)
        {
            vOrdinato[i]=v[i];
        }
        
        boolean scambio=false;
        do
        {
            scambio=false;
            for(int i=0;i<lunghezza-1;i++)
            {
               if(vOrdinato[i]<vOrdinato[i+1])
               {
                   scambia(vOrdinato,i,i+1);
                   scambio=true;
               }
            }  
        }while(scambio==true);
        return vOrdinato;
    }
    
    public static String[] bubbleSortCrescente(String[] v)
    {
        int lunghezza=v.length;
        //creo una copia di "v" e lo chiamo "vOrdinato"
        String[] vOrdinato=new String[lunghezza];
        for(int i=0;i<lunghezza;i++)
        {
            vOrdinato[i]=v[i];
        }
        
        boolean scambio=false;
        do
        {
            scambio=false;
            for(int i=0;i<lunghezza-1;i++)
            {
               if(vOrdinato[i].compareToIgnoreCase(vOrdinato[i+1])>0)
               {
                   scambia(vOrdinato,i,i+1);
                   scambio=true;
               }
            }  
        }while(scambio);
        return vOrdinato;
    }
    
    public static String[] bubbleSortDecrescente(String[] v)
    {
        int lunghezza=v.length;
        //creo una copia di "v" e lo chiamo "vOrdinato"
        String[] vOrdinato=new String[lunghezza];
        for(int i=0;i<lunghezza;i++)
        {
            vOrdinato[i]=v[i];
        }
        
        boolean scambio=false;
        do
        {
            scambio=false;
            for(int i=0;i<lunghezza-1;i++)
            {
               if(vOrdinato[i].compareToIgnoreCase(vOrdinato[i+1])<0)
               {
                   scambia(vOrdinato,i,i+1);
                   scambio=true;
               }
            }  
        }while(scambio==true);
        return vOrdinato;
    }
    
    public static void scambiaLibri(Libro[] a, int pos1, int pos2)
    {
        Libro s;
        s=a[pos1];
        a[pos1]=a[pos2];
        a[pos2]=s;
    }
    
    public static Libro[] selectionSortCrescenteLibri(Libro[] a)
    {

        //creo una copia di "v" e lo chiamo "vOrdinato"
        Libro[] v=new Libro[a.length];
        int lunghezza=v.length;
        
        for(int i=0;i<v.length;i++)
        {
            v[i]=new Libro (a[i]);
        }
        for(int i=0;i<lunghezza-1;i++)
        {
            for(int j=i+1;j<lunghezza;j++)
            {
                if(v[j].getTitolo().compareToIgnoreCase(v[i].getTitolo())<0);
                    scambiaLibri(v,i,j);
            }
        }
        return v;
    }
}