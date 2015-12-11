package com.streams;

public class Aadress {

    private long postiIndeks;
    private String riik;

    public Aadress(long postiIndeks, String riik) {
        this.postiIndeks = postiIndeks;
        this.riik = riik;
    }

    public long getPostiIndeks() {
        return postiIndeks;
    }

    public String getRiik() {
        return riik;
    }

    public void setRiik(String riik) {
        this.riik = riik;
    }

    public void setPostiIndeks(long postiIndeks) {
        this.postiIndeks = postiIndeks;
    }
}
