/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.exerciciorpg;

import static java.lang.System.exit;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author lucas
 */
public class ControlaJogo {

    private String nomeJogador;
    private Personagem personagemJogador;
    private Personagem inimigo;
    private Scanner in = new Scanner(System.in);

    public ControlaJogo() {
        System.out.println("Bem vindo ao RPG!!");
        criaJogador();
        iniciaBatalha();
    }

    private void criaJogador() {
        System.out.println("Digite seu nome:");
        this.nomeJogador = in.nextLine();
        System.out.println("Seu nome = " + this.nomeJogador);
        setPersonagem();
    }

    private void separaPersonagem(int escolha, int ataque, int defesa) {
        switch (escolha) {
            case 1:
                if(this.personagemJogador == null)
                    this.personagemJogador = new Guerreiro(ataque, defesa);
                else
                    this.inimigo = new Guerreiro(ataque, defesa);
                break;
            case 2:
                if(this.personagemJogador == null)
                    this.personagemJogador = new Mago(ataque, defesa);
                else
                    this.inimigo = new Mago(ataque, defesa);
                break;
            case 3:
                if(this.personagemJogador == null)
                    this.personagemJogador = new Arqueiro(ataque, defesa);
                else
                    this.inimigo = new Arqueiro(ataque, defesa);
                break;
            default:
                System.out.println("Opcao Invalida!");
                exit(1);
        }
    }

    private void setPersonagem() {
        int escolha;
        int ataque;
        int defesa;
        System.out.println("Escolha o personagem que deseja utilizar:\n"
                + "1 - Guerreiro\n"
                + "2 - Mago\n"
                + "3 - Arqueiro\n");
        escolha = in.nextInt();
        System.out.println("Digite o poder de ataque:");
        ataque = in.nextInt();
        System.out.println("Digite o poder de defesa:");
        defesa = in.nextInt();
        separaPersonagem(escolha, ataque, defesa);
        System.out.println("Escolha o inimigo que deseja enfrentar:\n"
                + "1 - Guerreiro\n"
                + "2 - Mago\n"
                + "3 - Arqueiro\n");
        escolha = in.nextInt();
        System.out.println("Digite o poder de ataque do inimigo:");
        ataque = in.nextInt();
        System.out.println("Digite o poder de defesa do inimigo:");
        defesa = in.nextInt();
        separaPersonagem(escolha, ataque, defesa);
    }
    
    private int imprimeOpcoes(){
        int escolha;
        System.out.println("1 - Atacar\n"
                + "2 - Defender\n"
                + "3 - Usar Habilidade"); 
        escolha = in.nextInt();
        return escolha;
    }
    
    private void acaoInimigo(){
        Random rand = new Random();
        int acaoAleatoria = rand.nextInt(3) + 1;
        switch(acaoAleatoria){
            case 1: 
                System.out.println("O inimigo usou o ataque");
                inimigo.atacar(personagemJogador);
                break;
            case 2:
                System.out.println("O inimigo escolheu se defender");
                inimigo.defender();
                break;
            case 3:
                System.out.println("O inimigo usou a habilidade");
                inimigo.usarHabilidade(personagemJogador);
                break;
        }
        
    }
    
    // Não precisa ser uma impressão dessa forma. Pode ser feita de outro jeito.
    public void imprimeVida(Personagem a) {
        int vida = a.getVida();
        int tamanhoTotal = 30;
        System.out.print("Vida: ");
        
        int preenchido = (int) Math.ceil((double) vida / tamanhoTotal * 20);
        System.out.println("Valor de preenchido:" + preenchido);
        for (int i = 0; i < preenchido; i++) {
            System.out.print("|");
        }
        
        for (int i = preenchido; i < 20; i++) {
            System.out.print("-");
        }
        
        System.out.println();
    }
    
    private void iniciaBatalha(){
        System.out.println("Comecou a batalha!");
        do{
            switch(imprimeOpcoes()){
                case 1:
                    personagemJogador.atacar(inimigo);
                    break;
                case 2:
                    personagemJogador.defender();
                    break;
                case 3:
                    personagemJogador.usarHabilidade(inimigo);
                    break;
                default:
                    System.out.println("Opcao Invalida");
                    break;
            }
            acaoInimigo();
            System.out.println("Vida atual Personagem ");
            imprimeVida(personagemJogador);
            System.out.println("Vida atual Inimigo ");
            imprimeVida(inimigo);
        }while((inimigo.verificaMorte() || personagemJogador.verificaMorte()) != true);
        if(inimigo.verificaMorte()){
            System.out.println("Fim de Jogo!" + this.nomeJogador + " venceu!");
        }else{
            System.out.println("Fim de Jogo! O inimigo venceu!");
        }
    }
    
}
