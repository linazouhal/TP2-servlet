package com.metier;

public class IMC {

    private double taille;
    private double poids;

   
    public IMC(double taille, double poids) {
        this.taille = taille;
        this.poids = poids;
    }

    
    public double calcul() {
        return poids / (taille * taille);
    }
}
