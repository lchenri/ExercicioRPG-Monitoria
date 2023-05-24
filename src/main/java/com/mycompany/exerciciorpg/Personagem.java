/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.exerciciorpg;

/**
 *
 * @author lucas
 */
public abstract class Personagem {
    protected int vida = 100;
    protected int defesa = 0;
    protected int ataquePersonagem;
    protected int defesaPersonagem;
    protected boolean morto = false;
    
    
    public abstract void atacar(Personagem alvo);
    public abstract void defender();
    public abstract void usarHabilidade(Personagem alvo);
    
    public int getVida(){
        return this.vida;
    }
    
    protected void recebeAtaque(int ataque, Personagem alvo){
        int vidaAtacada = alvo.getVida() - ataque + alvo.defesa;
        alvo.vida = vidaAtacada;
    }
    
    protected void aumentaDefesa(int defesa){
        this.defesa = this.defesa + defesa;
    }
    
    public boolean verificaMorte() {
        return this.vida <= 0;
    }
}
