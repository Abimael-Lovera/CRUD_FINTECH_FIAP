package br.com.fiap.fintech.models;

import java.time.LocalDate;

public class Investimento {

    private int idInvestimento;
    private int idUsuarioCpf;
    private String descricao;
    private double valor;
    private LocalDate data;

    public Investimento() {
    }

    public Investimento(int idInvestimento, int idUsuarioCpf, String descricao, double valor, LocalDate data) {
        this.idInvestimento = idInvestimento;
        this.idUsuarioCpf = idUsuarioCpf;
        this.descricao = descricao;
        this.valor = valor;
        this.data = data;
    }

    public int getIdInvestimento() {
        return idInvestimento;
    }

    public void setIdInvestimento(int idInvestimento) {
        this.idInvestimento = idInvestimento;
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
        return "Investimento{" +
                "idInvestimento=" + idInvestimento +
                ", idUsuarioCpf=" + idUsuarioCpf +
                ", descricao='" + descricao + '\'' +
                ", valor=" + valor +
                ", data=" + data +
                '}';
    }
}
