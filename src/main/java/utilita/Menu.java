/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilita;

import java.io.IOException;

/**
 *rappresenta un menu costituito da un elenco di voci Ad ogni voce è associato un numero intero
 * Il metodo elencoVoci è un array di stringhe dove ogni elemento corrisponde a una voce del menu
 * Tali numeri vanno da 0 a numeroVoci -1
 * L'utente scegle il numero della voce.
 * @author Mina
 * rappresenta un menu costituito da un elenco di voci. Ad ogni voce è associato un numero intero.
 * Il metodo elencoVoci è un array di stringhe dove ogni elemento corrisponde a una voce del menu.
 * Tali numeri vanno da 0 a numeroVoci -1. L'utente scegle il numero della voce.
 * Esempio:
 *  (0)Esci
    (1)Fai questo..
    (2)Fai quello..
    Scegli-->1
S   celta: 1
 */
public class Menu
{
    private String[] elencoVoci;
    private int numeroVoci;
    
    /**
     * Costruttore
     * @param elenco rappresenta le voci del menu
     * Esempio: elenco={"Esci","Fai questo..","Fai quello.."}
     */
    public Menu(String[] elenco)
    {
        numeroVoci=elenco.length;
        elencoVoci=new String[numeroVoci];
        for(int i=0;i<numeroVoci;i++)
        {
            elencoVoci[i]=elenco[i]; 
        }
    }
    /**
     * Metodo che consente di scegliere una voce fra quelle del menu.
     * L'utente può selezionare un numero intero corrispondente alle voci del menu.
     * Controllo di input se è numerico e valido (compreso fra le voci del menu).
     * @return la scelta fatta
     */
    public int sceltaMenu()
    {
        //Scanner tastiera=new Scanner(System.in);
        ConsoleInput tastiera=new ConsoleInput();
        int scelta = 0;
        String sceltaStringa;
        boolean sceltaOK=true;
        
        do
        {
            sceltaOK=true;
            visualizzaMenu();
            System.out.print("Scegli-->");
          
           
            try 
            {
                scelta=tastiera.readInt();
            } 
            catch (IOException ex) 
            {
                System.out.println("Impossibile leggere da tastiera");
                sceltaOK=false;
            } 
            catch (NumberFormatException ex) 
            {
                System.out.println("Formato input non conforme");
                sceltaOK=false;
            }
            
            //controlliamo che il numero inserito dall'utente sia compreso fra 0 e numeroVoci-1
            if(sceltaOK)
            {
                if(scelta<0||scelta>=numeroVoci)
                {
                    sceltaOK=false;
                    System.out.println("Scelta non valida! Inserire un numero compreso tra 0 e "+(numeroVoci-1));
                }
            }
    
        }while(!sceltaOK);
        return scelta;
          
    }
    
    /**
     * Visualizza l'elenco delle voci del menu
     */
    public void visualizzaMenu()
    {
        for(int i=0;i<numeroVoci;i++)
        {
            System.out.println("("+i+")"+elencoVoci[i]);
        }
    }
    
}
