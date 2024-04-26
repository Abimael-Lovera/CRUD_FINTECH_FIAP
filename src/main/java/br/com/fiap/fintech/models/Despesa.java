package br.com.fiap.fintech.models;

import java.time.LocalDate;

public class Despesa {
    private int idDespesa;
    private int idUsuarioCpf;
    private String descricao;
    private double valor;
    private LocalDate data;

    public Despesa() {
    }

    public Despesa(int idDespesa, int idUsuarioCpf, String descricao, double valor, LocalDate data) {
        this.idDespesa = idDespesa;
        this.idUsuarioCpf = idUsuarioCpf;
        this.descricao = descricao;
        this.valor = valor;
        this.data = data;
    }

    public int getIdDespesa() {
        return idDespesa;
    }

    public void setIdDespesa(int idDespesa) {
        this.idDespesa = idDespesa;
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
        return "Despesa{" +
                "idDespesa=" + idDespesa +
                ", idUsuarioCpf=" + idUsuarioCpf +
                ", descricao='" + descricao + '\'' +
                ", valor=" + valor +
                ", data=" + data +
                '}';
    }
}
