package br.com.jdbc.model.bean;

import java.time.LocalDate;

public class Pessoa {

    private Integer id;
    private String nome;
    private boolean casado;
    private Character sexo;
    private LocalDate data;

    public Pessoa(String nome, boolean casado, Character sexo, LocalDate data) {
        this.nome = nome;
        this.casado = casado;
        this.sexo = sexo;
        this.data = data;
    }

    public Pessoa(Integer id, String nome, boolean casado, Character sexo, LocalDate data) {
        this.id = id;
        this.nome = nome;
        this.casado = casado;
        this.sexo = sexo;
        this.data = data;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isCasado() {
        return casado;
    }

    public void setCasado(boolean casado) {
        this.casado = casado;
    }

    public Character getSexo() {
        return sexo;
    }

    public void setSexo(Character sexo) {
        this.sexo = sexo;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nId: ");
        sb.append(this.id);
        sb.append("\nNome: ");
        sb.append(this.nome);
        sb.append("\nCasado : ");
        sb.append(this.casado);
        sb.append("\nSexo: ");
        sb.append(this.sexo);
        sb.append("\nData: ");
        sb.append(this.data);
        sb.append("\n");
        return sb.toString();
    }
}
