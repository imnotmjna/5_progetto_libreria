/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilita;

import java.io.*;

/**
 *Rappresenta un dispositivo per acquisire dati di input di tipo nativo e di tipo String dalla console di input(tastiera)
 *
 * 
 * esempio: ConsoleInput tastiera=new ConsoleInput();
 *          tastiera.readString --> restituisce una stringa inserito da tastiera
 *          tastiera.readInt --> restituisce un numero intero inserito da tastiera
 * @author Mina
 */
public class ConsoleInput 
{
    private InputStreamReader reader;
    private BufferedReader tastiera;
    
    /**
     * Costruttore
     */
    public ConsoleInput()
    {
        reader=new InputStreamReader(System.in);
        tastiera=new BufferedReader(reader);
    }
    
    /**
     * Legge una stringa da tastiera
     * @return la stringa letta
     * @throws IOException Errore di input
     * @throws NumberFormatException Input inserito non coerente
     */
    public String readString() throws IOException, NumberFormatException
    {
        return tastiera.readLine();
    }
    /**
     * Legge un intero da tastiera
     * @return l'intero letto
     * @throws IOException Errore di input
     * @throws NumberFormatException Input inserito non coerente
     */
    public int readInt() throws IOException, NumberFormatException
    {
        String s=tastiera.readLine();
        int x=Integer.parseInt(s);
        return x;
    }
    /**
     * Legge uno short da tastiera
     * @return lo short letto
     * @throws IOException Errore di input
     * @throws NumberFormatException Input inserito non coerente
     *                               (se viene inserito un valore che non è un numero intero short)
     *                               come: "ciao" o un numero troppo grande
     */
    public short readShort() throws IOException, NumberFormatException
    {
        return Short.parseShort(tastiera.readLine());
    }
    /**
     * Legge un carattere da tastiera
     * @returns solo il primo carattere della stringa
     * se vengono inseriti + caratteri restituisce solo il primo
     * @throws IOException Errore di input
     */
    public char readChar() throws IOException, NumberFormatException
    {
        return tastiera.readLine().charAt(0);
    }
    /**
     * Legge un long da tastiera
     * @return il long letto
     * @throws IOException Errore di input
     * @throws NumberFormatException Input inserito non coerente
     *                               (se viene inserito un valore che non è un numero intero long)
     *                               come: "ciao" o "10.2" o un numero troppo grande
     */
    public Long readLong() throws IOException, NumberFormatException
    {
        return Long.parseLong(tastiera.readLine());
    }
    /**
     * Legge un float da tastiera
     * @return il float letto
     * @throws IOException Errore di input
          * @throws NumberFormatException Input inserito non coerente
     *                               (se viene inserito un valore che non è un numero float)
     *                               come: "ciao"
     */
    public float readFloat() throws IOException, NumberFormatException
    {
        return Float.parseFloat(tastiera.readLine());
    }
    /**
     * Legge una double da tastiera
     * @return il double letto
     * @throws IOException Errore di input
     * @throws NumberFormatException Input inserito non coerente
     *                               (se viene inserito un valore che non è un numero double)
     *                               come: "ciao" o "10.2"
     */
    public double readDouble() throws IOException, NumberFormatException
    {
        return Double.parseDouble(tastiera.readLine());
    }
    /**
     * Legge un boolean da tastiera
     * @return true se il valore letto è true, false se il valore è diverso da true
     * @throws IOException Errore di input
     * @throws NumberFormatException Input inserito non coerente
     */
    public Boolean readBoolean() throws IOException, NumberFormatException
    {
        return Boolean.parseBoolean(tastiera.readLine());
    }
    /**
     * Legge una byte da tastiera
     * @return il byte letto
     * @throws IOException Errore di input
     *      * @throws NumberFormatException Input inserito non coerente
     *                               (se viene inserito un valore che non è un numero byte)
     *                               come: "ciao" o o "-129" o "128" poichè sono fuori dal range dei numeri byte" 
     */
    public byte readByte() throws IOException, NumberFormatException
    {
        return Byte.parseByte(tastiera.readLine());
    }
}
