/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package agendatelefonica;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author FABIO
 */
public class Agenda implements InterfaceAgenda {

    Scanner scan = new Scanner(System.in);
    List<Contato> listaContatos = new ArrayList<>();

    public void agenda() {

        Contato ex1 = new Contato("Fabio", 932322232);
        listaContatos.add(ex1);
        Contato ex2 = new Contato("Amanda", 11111111);
        listaContatos.add(ex2);
        Contato ex3 = new Contato("Bruno", 22222222);
        listaContatos.add(ex3);
        Contato ex4 = new Contato("Caio", 33333333);
        listaContatos.add(ex4);
        Contato ex5 = new Contato("Danilo", 44444444);
        listaContatos.add(ex5);
        Contato ex6 = new Contato("Gustavo", 55555555);
        listaContatos.add(ex6);
        Contato ex7 = new Contato("Irene", 66666666);
        listaContatos.add(ex7);
        Contato ex8 = new Contato("Laura", 77777777);
        listaContatos.add(ex8);
        Contato ex9 = new Contato("Maria", 88888888);
        listaContatos.add(ex9);
        Contato ex10 = new Contato("Pedro", 99999999);
        listaContatos.add(ex10);
        Contato ex11 = new Contato("Renata", 10000000);
        listaContatos.add(ex11);
        Contato ex12 = new Contato("Samara", 12345678);
        listaContatos.add(ex12);
        Contato ex13 = new Contato("Ze", 87654321);
        listaContatos.add(ex13);
        Contato ex14 = new Contato("*@#&¨!", 40028922);
        listaContatos.add(ex14);
        Contato ex15 = new Contato("Luiza", 931313131);
        listaContatos.add(ex15);
        Contato ex16 = new Contato("Gustavo Guanabara", 12341234);
        listaContatos.add(ex16);
        Contato ex17 = new Contato("Giovana", 98769876);
        listaContatos.add(ex17);
        Collections.sort(listaContatos, new ComparadorUsuario());

        int opcao = 9;
        while (opcao != 0) {

            System.out.println("\n ####### Agenda Telefonica ####### \n");
            for (int i = 0; i < listaContatos.size(); i++) {
                System.out.println(listaContatos.get(i));
            }

            System.out.println("""
                               Opções:
                               1 - Adicionar contato
                               2 - Remover contato
                               3 - Editar contato
                               4 - Procurar o nome do contato
                               5 - Procurar o n\u00famero do contato
                               0 - Sair
                               """);
            int n = scan.nextInt();
            scan.nextLine();
            switch (n) {
                case 1 -> adicionarContato();
                case 2 -> removerContato();
                case 3 -> editarContato();
                case 4 -> {
                    procurarNomeContato(); 
                }
                case 5 -> {
                    procurarNumContato();
                }
                case 0 -> opcao = 0;
            }
        }
    }

    @Override
    public void adicionarContato() {
        System.out.println(" - Adcionar contato - ");
        boolean e = true;
        boolean e1 = true;
        boolean e2 = true;
        while (e) {
            System.out.println("Digite o nome do novo contato");
            String nomeContato = scan.nextLine();
            for (int i = 0; i < listaContatos.size(); i++) {
                if (nomeContato.equalsIgnoreCase(listaContatos.get(i).getNome())) {
                    System.out.println("Esse nome ja existe");
                    e1 = false;
                    break;
                } else {
                    e1 = true;
                }
            }
            while (e1) {
                System.out.println("\nDigite o número do novo contato");
                int numeroContato = scan.nextInt();
                scan.nextLine();
                for (int i = 0; i < listaContatos.size(); i++) {
                    if (numeroContato == listaContatos.get(i).getNumero()) {
                        System.out.println("Esse número ja existe");
                        e2 = false;
                        break;
                    } else {
                        e2 = true;
                    }
                }
                if (e2) {
                    Contato c = new Contato(nomeContato, numeroContato);
                    listaContatos.add(c);
                    Collections.sort(listaContatos, new ComparadorUsuario());
                    e1 = false;
                    e = false;
                }
            }
        }
    }

    @Override
    public void removerContato() {
        System.out.println(" - Remover contato - ");
        System.out.println("Digite o nome do contato a ser removido");
        String nomeContato = scan.nextLine();
        for (int i = 0; i < listaContatos.size(); i++) {
            if (listaContatos.get(i).getNome().equalsIgnoreCase(nomeContato)) {
                System.out.println(listaContatos.get(i).getNome() + " removido com sucesso");
                listaContatos.remove(i);
                System.out.println("\nDigite 1 para continuar");
                scan.nextLine();
                break;
            } else {
                if (i == listaContatos.size() - 1) {
                    System.out.println("Nome de usuário não encontrado");
                    System.out.println("Digite 1 para continuar");
                    scan.nextLine();
                }
            }
        }
    }

    @Override
    public void procurarNomeContato() {
        System.out.println(" - Procurar contato - ");
        System.out.println("Digite o nome do contato");
        String procuraNome = scan.nextLine();
        for (int i = 0; i < listaContatos.size(); i++) {
            if (listaContatos.get(i).getNome().equalsIgnoreCase(procuraNome)) {
                System.out.println(listaContatos.get(i));
                System.out.println("Digite 1 para continuar");
                scan.nextLine();
                break;
            } else {
                if (i == listaContatos.size() - 1) {
                    System.out.println("Nome de usuário não encontrado");
                    System.out.println("Digite 1 para continuar");
                    scan.nextLine();
                }
            }
        }
    }

    @Override
    public void procurarNumContato() {
        System.out.println(" - Procurar contato - ");
        System.out.println("Digite o número do contato");
        int procuraNumero = scan.nextInt();
        scan.nextLine();
        for (int i = 0; i < listaContatos.size(); i++) {
            if (listaContatos.get(i).getNumero() == procuraNumero) {
                System.out.println(listaContatos.get(i));
                System.out.println("Digite 1 para continuar");
                scan.nextLine();
                break;
            } else {
                if (i == listaContatos.size() - 1) {
                    System.out.println("Número de usuário não encontrado");
                    System.out.println("Digite 1 para continuar");
                    scan.nextLine();
                }
            }
        }
    }
    
    @Override
    public void editarContato() {
        System.out.println(" - Editar contato - ");
        System.out.println("Digite o nome do contato");
        String nomeContato = scan.nextLine();
        for (int i = 0; i < listaContatos.size(); i++) {
            if (listaContatos.get(i).getNome().equalsIgnoreCase(nomeContato)) {
                System.out.println("""
                                   
                                   Editar:
                                   1 - Nome
                                   2 - Número
                                   3 - Cancelar
                                   """);
                int n2 = scan.nextInt();
                scan.nextLine();
                switch (n2) {
                    case 1 -> {
                        boolean erro = true;
                        boolean erro1 = true;
                        while (erro) {
                            System.out.println("Mudar nome de " + listaContatos.get(i).getNome() + " para:");
                            String novoNome = scan.nextLine();
                            for (int j = 0; j < listaContatos.size(); j++) {
                                erro1 = true;
                                if (novoNome.equalsIgnoreCase(listaContatos.get(j).getNome())) {
                                    System.out.println("Esse nome ja existe");
                                    erro1 = false;
                                    break;
                                }
                            }
                            if (erro1) {
                                listaContatos.get(i).setNome(novoNome);
                                System.out.println("Nome alterado para " + listaContatos.get(i).getNome());
                                Collections.sort(listaContatos, new ComparadorUsuario());
                                erro = false;
                            }
                        }
                    }
                    case 2 -> {
                        boolean erro2 = true;
                        boolean erro3 = true;
                        while (erro2) {
                            System.out.println("Mudar número de " + listaContatos.get(i).getNumero() + " para:");
                            int novoNumero = scan.nextInt();
                            scan.nextLine();
                            for (int k = 0; k < listaContatos.size(); k++) {
                                erro3 = true;
                                if (novoNumero == listaContatos.get(k).getNumero()) {
                                    System.out.println("Esse número já existe");
                                    erro3 = false;
                                    break;
                                }
                            }
                            if (erro3) {
                                listaContatos.get(i).setNumero(novoNumero);
                                System.out.println("Número alterado para " + listaContatos.get(i).getNumero());
                                erro2 = false;
                            }
                        }
                    }
                    case 3 -> {
                    }
                }
                System.out.println("\nDigite 1 para continuar");
                scan.nextLine();
                break;
            } else {
                if (i == listaContatos.size() - 1) {
                    System.out.println("Nome de usuário não encontrado");
                    System.out.println("Digite 1 para continuar");
                    scan.nextLine();
                    break;
                }
            }
        }
        
    }
    
}
