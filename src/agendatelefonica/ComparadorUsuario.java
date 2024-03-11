/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package agendatelefonica;

import java.util.Comparator;
/**
 *
 * @author FABIO
 */
public class ComparadorUsuario implements Comparator<Contato>{

    @Override
    public int compare(Contato contato1, Contato contato2) {
        if(contato1.getNome().compareToIgnoreCase(contato2.getNome()) > 0) {
            return 1;
        }
        return -1;
    }
    
    
}
