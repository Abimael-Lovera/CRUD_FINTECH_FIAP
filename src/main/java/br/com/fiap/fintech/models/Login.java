package br.com.fiap.fintech.models;

import java.time.LocalDate;

public class Login {
    private int idLogin;
    private int idUsuarioCpf;
    private TipoLoginEnum tipo;
    private String senha;
    private LocalDate dtCriacao;
    private LocalDate dtUltimoAcesso;

    public Login() {
    }

    public Login(int idLogin, int idUsuarioCpf, TipoLoginEnum tipo, String senha, LocalDate dtCriacao, LocalDate dtUltimoAcesso) {
        this.idLogin = idLogin;
        this.idUsuarioCpf = idUsuarioCpf;
        this.tipo = tipo;
        this.senha = senha;
        this.dtCriacao = dtCriacao;
        this.dtUltimoAcesso = dtUltimoAcesso;
    }

    public int getIdLogin() {
        return idLogin;
    }

    public void setIdLogin(int idLogin) {
        this.idLogin = idLogin;
    }

    public int getIdUsuarioCpf() {
        return idUsuarioCpf;
    }

    public void setIdUsuarioCpf(int idUsuarioCpf) {
        this.idUsuarioCpf = idUsuarioCpf;
    }

    public TipoLoginEnum getTipo() {
        return tipo;
    }

    public void setTipo(TipoLoginEnum tipo) {
        this.tipo = tipo;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public LocalDate getDtCriacao() {
        return dtCriacao;
    }

    public void setDtCriacao(LocalDate dtCriacao) {
        this.dtCriacao = dtCriacao;
    }

    public LocalDate getDtUltimoAcesso() {
        return dtUltimoAcesso;
    }

    public void setDtUltimoAcesso(LocalDate dtUltimoAcesso) {
        this.dtUltimoAcesso = dtUltimoAcesso;
    }

    @Override
    public String toString() {
        return "Login{" +
                "idLogin=" + idLogin +
                ", idUsuarioCpf=" + idUsuarioCpf +
                ", tipo=" + tipo +
                ", senha='" + senha + '\'' +
                ", dtCriacao=" + dtCriacao +
                ", dtUltimoAcesso=" + dtUltimoAcesso +
                '}';
    }
}
