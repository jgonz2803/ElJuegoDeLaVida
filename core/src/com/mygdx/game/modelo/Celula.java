package com.mygdx.game.modelo;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Celula extends ObjetoVolador {

    Texture skinOff;
    boolean vivo;
    int   numVecinos;

    public Celula(float posX, float posY,  Texture skin,  Texture skinOff, boolean vivo) {
        super(posX, posY,skin);
        this.skinOff = skinOff;
        this.vivo = vivo;
    }

    public Texture getSkinOff() {
        return skinOff;
    }

    public void setSkinOff(Texture skinOff) {
        this.skinOff = skinOff;
    }

    public boolean isVivo() {
        return vivo;
    }

    public void setVivo(boolean vivo) {
        this.vivo = vivo;
    }

    public int getNumVecinos() {
        return numVecinos;
    }

    public void setNumVecinos(int numVecinos) {
        this.numVecinos = numVecinos;
    }

    public boolean sobrevivir (){

        boolean vivito  = true;

        if(!vivo && numVecinos == 3){
            vivito = true;
        }

        if (!vivo && numVecinos != 3){
            vivito = false;
        }

        if (vivo){

            if ( numVecinos > 3 || numVecinos <=1){
                vivito = false;
            }else{
                vivito= true;
            }

        }

        return vivito;

    }


    @Override
    public void draw (SpriteBatch pantalla) {

       if (vivo){
           super.draw(pantalla);
       }else{
           pantalla.draw(skinOff,posX,posY);
       }

    }
}
