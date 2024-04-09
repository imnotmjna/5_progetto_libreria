/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany._progetto_libreria;

import eccezioni.EccezionePosizioneNonValida;
import eccezioni.EccezionePosizioneOccupata;
import eccezioni.EccezionePosizioneVuota;
import eccezioni.EccezioneRipianoNonValido;
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import utilita.ConsoleInput;
import utilita.Menu;
import utilita.Ordinatore;


/**
 *
 * @author Studente
 */
public class App {

    public static void main(String[] args) 
    {
        
        String[] vociMenu;
        int numeroVoci=7;
        vociMenu=new String [numeroVoci];
        Menu menu;
        int voceScelta;
        int esito=0;
        //Scanner tastiera=new Scanner(System.in);
        ConsoleInput tastiera=new ConsoleInput();
        String titolo,autore;
        int numeroPagine;
        Libro lib;
        int ripiano, posizione;
        String[] elencoTitoliAutore;
        Libro[] libriPresenti;

        Scaffale s1=new Scaffale(); //creo uno scaffale vuoto

        vociMenu[0]="0\t--> Esci";
        vociMenu[1]="1\t--> Visualizza tutti i volumi presenti";
        vociMenu[2]="2\t--> Aggiungi un volume";
        vociMenu[3]="3\t--> Visualizza il singolo volume(ripiano/posizione)";
        vociMenu[4]="4\t--> Elimina volume (ripiano/posizione)";
        vociMenu[5]="5\t--> Mostra libri di un autore";
        vociMenu[6]="6\t--> Mostra volumi in ordine alfabetico di un titolo";

        menu=new Menu(vociMenu);

            //gestione menu
            do
            {
                System.out.println("Menu:");
                voceScelta=menu.sceltaMenu();
                switch(voceScelta)
                {
                    case 0: //esci
                        System.out.println("Arrivederci!");
                        break;
                    case 1: //visualizza tutti
                        System.out.println(s1.toString());
                        break;
                    case 2: //aggiungi volume
                        try
                        {
                            System.out.println("Titolo--> ");
                            titolo=tastiera.readString();

                            System.out.println("Autore--> ");
                            autore=tastiera.readString();
                            do
                            {
                                try
                                {
                                    System.out.println("Numero pagine--> ");
                                    numeroPagine=tastiera.readInt(); 
                                    break; //se input ok, esci dal ciclo
                                }
                                catch(NumberFormatException e)
                                {
                                    System.out.println("Errore! devi inserire un numero!");
                                } 
                            }while(true);
                            
                            do
                            {
                                try
                                {
                                    System.out.println("Ripiano--> ");
                                    ripiano=tastiera.readInt();
                                    break; //se input ok, esci dal ciclo
                                }
                                catch(NumberFormatException e)
                                {
                                    System.out.println("Errore! devi inserire un numero!");
                                } 
                            }while(true);
                            
                            do
                            {
                                try
                                {
                                    System.out.println("Posizione (0..14)--> ");
                                    posizione=tastiera.readInt();
                                    break; //se input ok, esci dal ciclo
                                }
                                catch(NumberFormatException e)
                                {
                                    System.out.println("Errore! devi inserire un numero!");
                                } 
                            }while(true);
                            
                            try 
                            {
                                s1.setLibro(new Libro(titolo, autore, numeroPagine),ripiano,posizione);
                                System.out.println("Volume aggiunto correttamente");
                            } 
                            catch (EccezioneRipianoNonValido ex) 
                            {
                                System.out.println("Ripiano inesistente");
                            } 
                            catch (EccezionePosizioneNonValida ex) 
                            {
                                System.out.println("Posizione inesistente");
                            } 
                            catch (EccezionePosizioneOccupata ex) 
                            {
                                System.out.println("Posizione già occupata");
                            }
                        }
                        catch(IOException e)
                        {
                            System.out.println("Impossibile leggere da tastiera");
                        }
                        
                        break;

                    case 3: //visualizza volume
                        try 
                        {
                            do
                            {
                                try
                                {
                                    System.out.println("Ripiano--> ");
                                    ripiano=tastiera.readInt();
                                    break; //se input ok, esci dal ciclo
                                }
                                catch(NumberFormatException e)
                                {
                                    System.out.println("Errore! devi inserire un numero!");
                                } 
                                catch (IOException e) 
                                {
                                    System.out.println("Impossibile leggere da tastiera!");
                                } 
                            }while(true);
                            
                            do
                            {
                                try
                                {
                                    System.out.println("Posizione (0..14)--> ");
                                    posizione=tastiera.readInt();
                                    break; //se input ok, esci dal ciclo
                                }
                                catch(NumberFormatException e)
                                {
                                    System.out.println("Errore! devi inserire un numero!");
                                } 
                                catch (IOException ex) 
                                {
                                    System.out.println("Impossibile leggere da tastiera!");
                                } 
                            }while(true);
                        
                            lib=s1.getLibro(ripiano, posizione);
                            System.out.println("Libro cercato: "+lib.toString());
                        } 
                        catch (EccezioneRipianoNonValido ex) 
                        {
                            System.out.println("Ripiano inesistente");
                        } 
                        catch (EccezionePosizioneNonValida ex) 
                        {
                            System.out.println("Posizione inesistente");
                        } 
                        catch (EccezionePosizioneVuota ex) 
                        {
                            System.out.println("Libto non trovato");
                        }
                        break;
                        
                    case 4: //elimina volume
                        
                    {
                        try 
                        {
                            do
                            {
                                try
                                {
                                    System.out.println("Ripiano--> ");
                                    ripiano=tastiera.readInt();
                                    break; //se input ok, esci dal ciclo
                                }
                                catch(NumberFormatException e)
                                {
                                    System.out.println("Errore! devi inserire un numero!");
                                } 
                                catch (IOException e) 
                                {
                                    System.out.println("Impossibile leggere da tastiera!");
                                } 
                            }while(true);
                            
                            do
                            {
                                try
                                {
                                    System.out.println("Posizione (0..14)--> ");
                                    posizione=tastiera.readInt();
                                    break; //se input ok, esci dal ciclo
                                }
                                catch(NumberFormatException e)
                                {
                                    System.out.println("Errore! devi inserire un numero!");
                                } 
                                catch (IOException ex) 
                                {
                                    System.out.println("Impossibile leggere da tastiera!");
                                } 
                            }while(true);
                            
                            s1.rimuoviLibro(ripiano,posizione);
                            System.out.println("Volume rimosso correttamente");
                        } 
                        catch (EccezioneRipianoNonValido ex) 
                        {
                            System.out.println("Ripiano inesistente");
                        } 
                        catch (EccezionePosizioneNonValida ex) 
                        {
                                System.out.println("Posizione inesistente");
                        }
                        catch (EccezionePosizioneVuota ex)
                        {
                            System.out.println("Libto non trovato");
                        }
                    }
                        break;

                    case 5: //mostra libri autore
                        
                        try
                        {
                            System.out.println("Autore--> ");
                            autore=tastiera.readString();
                            elencoTitoliAutore=s1.elencoTitoliAutore(autore);
                            if(elencoTitoliAutore==null)
                                System.out.println("Nessun libro presente");
                            else
                            {
                                for(int i=0; i<elencoTitoliAutore.length;i++)
                                {
                                    System.out.println(elencoTitoliAutore[i]);
                                }
                            }
                        }
                        catch(IOException e)
                        {
                            System.out.println("Impossibile leggere da tastiera!");
                        }
                        break;
                        
                    case 6: //mostra elenco libri ordinati
                        libriPresenti=s1.elencoLibriPresenti();
                        libriPresenti=Ordinatore.selectionSortCrescenteLibri(libriPresenti);
                        for(int i=0; i<libriPresenti.length; i++)
                        {
                            System.out.println(libriPresenti[i].toString());
                        }
                        break;
                }
            }while(voceScelta!=0);
        }
    }
