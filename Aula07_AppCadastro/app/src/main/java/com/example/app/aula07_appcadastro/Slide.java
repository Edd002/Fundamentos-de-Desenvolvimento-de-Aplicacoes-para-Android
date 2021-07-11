package com.example.app.aula07_appcadastro;

public class Slide {

    private int imgRes;
    private String descricao;

    public Slide() {
    }

    public Slide(int imgRes, String descricao) {
        this.imgRes = imgRes;
        this.descricao = descricao;
    }

    public int getImgRes() {
        return imgRes;
    }
    public void setImgRes(int imgRes) {
        this.imgRes = imgRes;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
