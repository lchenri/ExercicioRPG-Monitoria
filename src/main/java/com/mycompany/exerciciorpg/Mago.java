/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.exerciciorpg;

/**
 *
 * @author lucas
 */
public class Mago extends Personagem {

    public Mago(int ataque, int defesa) {
        super.ataquePersonagem = ataque;
        super.defesaPersonagem = defesa;
    }

    @Override
    public void atacar(Personagem alvo) {
        recebeAtaque(ataquePersonagem, alvo);
    }

    @Override
    public void defender() {
        //diminui o decremento se o inimigo atacar
        aumentaDefesa(defesaPersonagem);
    }

    @Override
    public void usarHabilidade(Personagem alvo) {
        int vidaAux = this.vida;
        this.vida = alvo.vida;
        alvo.vida = vidaAux;
    }

}
