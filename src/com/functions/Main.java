package com.functions;

import java.util.function.Function;

public class Main {

    public static void main(String[] args) {
        //1
        TooresMuna muna1 = new TooresMuna();
        TooresMuna muna2 = new TooresMuna();

        ValmisMuna praeMuna = prae(muna1);
        ValmisMuna keeduMuna = keeda(muna2);
        // kõik on lihtne

        //2
        hommikuPeekon();
        ValmisMuna praeMuna1 = prae(muna1);
        keedaKohv();
        //ja siis
        hommikuPeekon();
        ValmisMuna keeduMuna1 = keeda(muna1);
        keedaKohv();

        //3
        ValmisMuna praeMuna2 = teeSyyaPraeMuna(muna1);
        ValmisMuna keeduMuna2 = teeSyyaKeeduMuna(muna2);

        //4
        ValmisMuna praeMuna3 = teeSyya(muna1, tm -> prae(tm));
        ValmisMuna keeduMuna3 = teeSyya(muna2, Main::keeda);
    }

    public static ValmisMuna teeSyyaPraeMuna(TooresMuna tooresMuna){
        hommikuPeekon();
        ValmisMuna praeMuna1 = prae(tooresMuna);
        keedaKohv();
        return praeMuna1;
    }

    public static ValmisMuna teeSyyaKeeduMuna(TooresMuna tooresMuna){
        hommikuPeekon();
        ValmisMuna praeMuna1 = keeda(tooresMuna);
        keedaKohv();
        return praeMuna1;
    }

    public static ValmisMuna teeSyya(TooresMuna tooresMuna,
                                     Function<TooresMuna, ValmisMuna> valmistamiseFunktsioon){
        hommikuPeekon();
        ValmisMuna valmisMuna = valmistamiseFunktsioon.apply(tooresMuna);
        keedaKohv();
        return valmisMuna;
    }

    public static ValmisMuna prae(TooresMuna toores) {
        ValmisMuna valmisMuna = new ValmisMuna();
        valmisMuna.setToitAined(toores.getEnergia() / 3);
        return valmisMuna;
    }

    public static ValmisMuna keeda(TooresMuna toores) {
        ValmisMuna valmisMuna = new ValmisMuna();
        valmisMuna.setToitAined(toores.getEnergia() / 2);
        return valmisMuna;
    }

    public static void hommikuPeekon(){}
    public static void keedaKohv(){}
}
