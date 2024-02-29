package com.mygdx.game.modelo;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ObjetoVolador {
    float posX, posY;
    Texture skin;

    public ObjetoVolador(float posX, float posY, Texture skin) {
        this.posX = posX;
        this.posY = posY;
        this.skin = skin;
    }

    public float getPosX() {
        return posX;
    }

    public float getPosY() {
        return posY;
    }

    public int getWidth() {
        return this.skin.getWidth();
    }

    public int getHeight() {
        return this.skin.getHeight();
    }

    public Texture getSkin() {
        return skin;
    }

    public void setPosX(float posX) {
        this.posX = posX;
    }

    public void setPosY(float posY) {
        this.posY = posY;
    }

    public void setSkin(Texture skin) {
        this.skin = skin;
    }

    public void draw(SpriteBatch pantalla) {

        pantalla.draw(skin, posX, posY);

    }

    public boolean colisionar(float pulsacionX, float PuelsacionY) {

        if (colisionarColumna(pulsacionX) && colisionarFilas(PuelsacionY)) {
            return true;
        }

        return false;

    }

    public boolean colisionarFilas(float pulsacionY) {

        if (pulsacionY >= this.getPosY() && pulsacionY <= this.getPosY() + this.getHeight())
            return true;
        return false;

    }

    public boolean colisionarColumna(float pulsacionX) {

        if (pulsacionX >= this.getPosX() && pulsacionX <= this.getPosX() + this.getWidth())
            return true;
        return false;
    }




}
