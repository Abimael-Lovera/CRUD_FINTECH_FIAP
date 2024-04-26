package br.com.fiap.fintech.models;

import java.time.LocalDate;

public class Usuario {
    private int idUsuarioCPF;
    private String nome;
    private String email;
    private String telefone;
    private LocalDate dataNascimento;

    public Usuario() {
    }

    public Usuario(int idUsuarioCPF, String nome, String email, String telefone, LocalDate dataNascimento) {
        this.idUsuarioCPF = idUsuarioCPF;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
    }

    public Usuario(String email, String telefone) {
        this.email = email;
        this.telefone = telefone;
    }

    public int getIdUsuarioCPF() {
        return idUsuarioCPF;
    }

    public void setIdUsuarioCPF(int idUsuarioCPF) {
        this.idUsuarioCPF = idUsuarioCPF;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "idUsuarioCPF=" + idUsuarioCPF +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", telefone='" + telefone + '\'' +
                ", dataNascimento=" + dataNascimento +
                '}';
    }
}
