package br.com.fiap.fintech.models;

import java.time.LocalDate;

public class Receita {
    private int idReceita;
    private int idUsuarioCpf;
    private String descricao;
    private double valor;
    private LocalDate data;

    public Receita() {
    }

    public Receita(int idReceita, int idUsuarioCpf, String descricao, double valor, LocalDate data) {
        this.idReceita = idReceita;
        this.idUsuarioCpf = idUsuarioCpf;
        this.descricao = descricao;
        this.valor = valor;
        this.data = data;
    }

    public int getIdReceita() {
        return idReceita;
    }

    public void setIdReceita(int idReceita) {
        this.idReceita = idReceita;
    }

    public int getIdUsuarioCpf() {
        return idUsuarioCpf;
    }

    public void setIdUsuarioCpf(int idUsuarioCpf) {
        this.idUsuarioCpf = idUsuarioCpf;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Receita{" +
                "idReceita=" + idReceita +
                ", idUsuarioCpf=" + idUsuarioCpf +
                ", descricao='" + descricao + '\'' +
                ", valor=" + valor +
                ", data=" + data +
                '}';
    }
}
