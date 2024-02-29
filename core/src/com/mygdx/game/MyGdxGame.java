package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.modelo.Boton;
import com.mygdx.game.modelo.Tabla;

public class MyGdxGame extends ApplicationAdapter {
    SpriteBatch sp;
    Texture skinPlay, skinReset, skinPause, skinOn, skinOff;

    Boton play, reset;

    Tabla miTabla;
    boolean tablonCreado, pausado;

    float pulsacionX, pulsacionY;


    @Override
    public void create() {
        sp = new SpriteBatch();
        pulsacionX = 0;
        pulsacionY = 0;
        skinPlay = new Texture("play.png");
        skinPause = new Texture("pausa.png");
        skinReset = new Texture("reset.png");
        skinOn = new Texture("on.png");
        skinOff = new Texture("off.png");
        play = new Boton((Gdx.graphics.getWidth() / 2) - 60, 10, skinPlay);
        reset = new Boton((play.getPosX() + play.getWidth()) + 10, 10, skinReset);
        miTabla = new Tabla(Gdx.graphics.getHeight() - 15, 50, 3, skinOn, skinOff, sp, 30);
        tablonCreado = false;
        pausado = false;

    }

    @Override
    public void render() {
        ScreenUtils.clear(0.9f, 0.9f, 0.9f, 1);
        sp.begin();

        play.draw(sp);
        reset.draw(sp);

        if (Gdx.input.justTouched()) {
            pulsacionX = Gdx.input.getX();
            pulsacionY = Gdx.graphics.getHeight() - Gdx.input.getY();

            hacerPlay();
            hacerReset();

        }

        if (tablonCreado && !pausado) {

            miTabla.siguienteTurn();
            miTabla.contarVecinos();
            miTabla.draw(sp);
        }

        if (pausado) {

            miTabla.draw(sp);

        }


        sp.end();

    }

    @Override
    public void dispose() {
        sp.dispose();

    }

    private void hacerPlay(){
        if (play.colisionar(pulsacionX, pulsacionY)) {

            if (play.getSkin() == skinPause) {

                play.setSkin(skinPlay);

                pausado = true;


            } else if (play.getSkin() == skinPlay) {
                if (!tablonCreado) {
                    miTabla.nacer();
                    miTabla.contarVecinos();
                    tablonCreado = true;
                }
                pausado = false;
                play.setSkin(skinPause);
            }

        }
    }

    private void hacerReset(){

            if (reset.colisionar(pulsacionX, pulsacionY)) {

                tablonCreado = false;

                if (!tablonCreado) {
                    miTabla.nacer();
                    miTabla.contarVecinos();
                    tablonCreado = true;
                }
                pausado = false;
                play.setSkin(skinPause);
            }

    }

}
