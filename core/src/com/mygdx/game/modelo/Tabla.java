package com.mygdx.game.modelo;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Tabla {

    Celula[][] tablon;

    SpriteBatch sp;
    int numeroCeldas, indiceGen, separacion;
    float primeraX, primeraY;
    Texture off, on;

    public Tabla(float primeraY, int numeroCeldas, int separacion, Texture off, Texture on, SpriteBatch sp, int indiceGen) {
        this.tablon = new Celula[numeroCeldas][numeroCeldas];
        this.numeroCeldas = numeroCeldas;
        this.off = off;
        this.on = on;
        this.sp = sp;
        this.primeraX = (Gdx.graphics.getWidth() / 2) - (((numeroCeldas * on.getWidth()) + (separacion * numeroCeldas)) / 2);
        this.primeraY = primeraY;
        this.indiceGen = indiceGen;
        this.separacion = separacion;
    }

    public Celula[][] getTablon() {
        return tablon;
    }

    public void setTablon(Celula[][] tablon) {
        this.tablon = tablon;
    }

    public int getNumeroCeldas() {
        return numeroCeldas;
    }

    public void setNumeroCeldas(int numeroCeldas) {
        this.numeroCeldas = numeroCeldas;
    }


    public void nacer() {

        float posX = primeraX;
        float posY = primeraY;

        for (int i = 0; i < tablon.length; i++) {
            for (int j = 0; j < tablon[i].length; j++) {

                if (Math.random() < ((double) indiceGen / 100)) {
                    tablon[i][j] = new Celula(posX, posY, on, off, true);
                } else {
                    tablon[i][j] = new Celula(posX, posY, on, off, false);
                }
                posX += tablon[i][j].getWidth() + separacion;

            }
            posY -= tablon[i][0].getHeight() + separacion;
            posX = primeraX;
        }
    }

    public void contarVecinos() {
        int numVecinos = 0;

        for (int i = 0; i < tablon.length; i++) {
            for (int j = 0; j < tablon[i].length; j++) {

                numVecinos = 0;

                if (i == 0 && j == 0) { //esquina izq top


                    if (tablon[i][j + 1].isVivo()) {
                        numVecinos++;
                    }

                    if (tablon[i + 1][j].isVivo()) {
                        numVecinos++;
                    }

                    if (tablon[i + 1][j + 1].isVivo()) {
                        numVecinos++;
                    }


                } else if (i == 0 && j == (tablon[i].length-1)) { //esquina derecha top


                    if (tablon[i][j - 1].isVivo()) {
                        numVecinos++;
                    }

                    if (tablon[i + 1][j].isVivo()) {
                        numVecinos++;
                    }

                    if (tablon[i + 1][j - 1].isVivo()) {
                        numVecinos++;
                    }


                } else if (i == 0 && j != 0 & j != (tablon[i].length-1)) { //fila arriba menos dos esquinas

                    if (tablon[i + 1][j].isVivo()) {
                        numVecinos++;
                    }

                    if (tablon[i + 1][j + 1].isVivo()) {
                        numVecinos++;
                    }

                    if (tablon[i + 1][j - 1].isVivo()) {
                        numVecinos++;
                    }

                    if (tablon[i][j - 1].isVivo()) {
                        numVecinos++;
                    }

                    if (tablon[i][j + 1].isVivo()) {
                        numVecinos++;
                    }

                } else if (i == (tablon[i].length-1) && j == 0) { //esquina izq bott


                    if (tablon[i][j + 1].isVivo()) {
                        numVecinos++;
                    }

                    if (tablon[i - 1][j].isVivo()) {
                        numVecinos++;
                    }

                    if (tablon[i - 1][j + 1].isVivo()) {
                        numVecinos++;
                    }


                } else if (i == (tablon[i].length-1) && j == (tablon[i].length-1)) { //esquina der bott


                    if (tablon[i][j - 1].isVivo()) {
                        numVecinos++;
                    }

                    if (tablon[i - 1][j].isVivo()) {
                        numVecinos++;
                    }

                    if (tablon[i - 1][j - 1].isVivo()) {
                        numVecinos++;
                    }


                } else if (i == (tablon[i].length-1) && j != 0 & j != (tablon[i].length-1)) { //fila baja sin esquinas

                    if (tablon[i - 1][j].isVivo()) {
                        numVecinos++;
                    }

                    if (tablon[i - 1][j + 1].isVivo()) {
                        numVecinos++;
                    }

                    if (tablon[i - 1][j - 1].isVivo()) {
                        numVecinos++;
                    }

                    if (tablon[i][j - 1].isVivo()) {
                        numVecinos++;
                    }

                    if (tablon[i][j + 1].isVivo()) {
                        numVecinos++;
                    }

                } else if (j == 0 && i != 0 && i != (tablon[i].length-1)) {//pared izq menos esqina izq top y bott

                    if (tablon[i - 1][j].isVivo()) {
                        numVecinos++;
                    }

                    if (tablon[i - 1][j + 1].isVivo()) {
                        numVecinos++;
                    }


                    if (tablon[i][j + 1].isVivo()) {
                        numVecinos++;
                    }

                    if (tablon[i + 1][j].isVivo()) {
                        numVecinos++;
                    }

                    if (tablon[i + 1][j + 1].isVivo()) {
                        numVecinos++;
                    }

                } else if (j == (tablon[i].length-1) && i != 0 && i != (tablon[i].length-1)) {//pared der menos esqina der top y bott

                    if (tablon[i - 1][j].isVivo()) {
                        numVecinos++;
                    }

                    if (tablon[i - 1][j - 1].isVivo()) {
                        numVecinos++;
                    }


                    if (tablon[i][j - 1].isVivo()) {
                        numVecinos++;
                    }

                    if (tablon[i + 1][j].isVivo()) {
                        numVecinos++;
                    }

                    if (tablon[i + 1][j - 1].isVivo()) {
                        numVecinos++;
                    }

                } else {

                    if (tablon[i - 1][j].isVivo()) {
                        numVecinos++;
                    }

                    if (tablon[i - 1][j + 1].isVivo()) {
                        numVecinos++;
                    }

                    if (tablon[i - 1][j - 1].isVivo()) {
                        numVecinos++;
                    }

                    if (tablon[i][j - 1].isVivo()) {
                        numVecinos++;
                    }

                    if (tablon[i][j + 1].isVivo()) {
                        numVecinos++;
                    }

                    if (tablon[i + 1][j].isVivo()) {
                        numVecinos++;
                    }

                    if (tablon[i + 1][j - 1].isVivo()) {
                        numVecinos++;
                    }

                    if (tablon[i + 1][j + 1].isVivo()) {
                        numVecinos++;
                    }

                }//final de los calculos condicionales numvecinos

                tablon[i][j].setNumVecinos(numVecinos);

            }//final recorrido j

        }//final recorrido i

    }


    public void siguienteTurn(){

        for (int i = 0; i < tablon.length; i++) {
            for (int j = 0; j < tablon[i].length; j++) {

                tablon[i][j].setVivo(tablon[i][j].sobrevivir());

            }
        }
    }
    public void draw(SpriteBatch sp) {

        for (int i = 0; i < tablon.length; i++) {
            for (int j = 0; j < tablon[i].length; j++) {

                tablon[i][j].draw(sp);

            }

        }

    }
}


