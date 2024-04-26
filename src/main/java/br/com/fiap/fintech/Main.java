package br.com.fiap.fintech;

import br.com.fiap.fintech.controller.*;

public class Main {
    public static void main(String[] args)  {
        System.out.println("Inicializando aplicação...");
        try {
            var usuarioController = new UsuarioController();
//            usuarioController.deletarTodos();
            usuarioController.iniciarAplicacao();
        } catch (Exception e) {
            System.out.println("Erro no UsuarioController:"+ e.getMessage());
            e.printStackTrace();
        }

        try {
            var loginController = new LoginController();
//            loginController.deletarTodos();
            loginController.iniciarAplicacao();
        } catch (Exception e) {
            System.out.println("Erro no LoginController:"+ e.getMessage());
            e.printStackTrace();
        }

        try {
            var despesaController = new DespesaController();
//            despesaController.deletarTodos();
            despesaController.iniciarAplicacao();
        } catch (Exception e) {
            System.out.println("Erro no DespesaController:"+ e.getMessage());
            e.printStackTrace();
        }

        try {
            var investimentoController = new InvestimentoController();
//            investimentoController.deletarTodos();
            investimentoController.iniciarAplicacao();
        } catch (Exception e) {
            System.out.println("Erro no InvestimentoController:"+ e.getMessage());
            e.printStackTrace();
        }

        try {
            var receitaController = new ReceitaController();
//            receitaController.deletarTodos();
            receitaController.iniciarAplicacao();
        } catch (Exception e) {
            System.out.println("Erro no ReceitaController:"+ e.getMessage());
            e.printStackTrace();
        }

    }
}