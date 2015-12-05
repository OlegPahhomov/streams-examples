package com.company;

import java.util.List;

public class Isik {

    private Long id;
    private Integer vanus;
    private List<Aadress> aadressid;


    public Integer getVanus() {
        return vanus;
    }

    public void setVanus(Integer vanus) {
        this.vanus = vanus;
    }

    public List<Aadress> getAadressid() {
        return aadressid;
    }

    public void setAadressid(List<Aadress> aadressid) {
        this.aadressid = aadressid;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
