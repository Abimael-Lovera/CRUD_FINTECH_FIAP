package br.com.fiap.fintech.controller;

import br.com.fiap.fintech.dao.UsuarioDAO;
import br.com.fiap.fintech.exception.NotFoundEntitiesException;
import br.com.fiap.fintech.infra.ConnectionDB;
import br.com.fiap.fintech.models.Usuario;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;

public class UsuarioController {

    public void iniciarAplicacao() {
        Connection conexao = null;
        try {
            conexao = ConnectionDB.getConnection();
            UsuarioDAO usuarioDAO = new UsuarioDAO(conexao);
            System.out.println("Inicializando criação de Usuarios...");
            Usuario usuario1 = new Usuario(111222333, "Joao", "joao@gmai.com", "11999999999", LocalDate.of(1999, 4, 7));
            Usuario usuario2 = new Usuario(222333444, "Maria", "maria@gmail.com", "11999999888", LocalDate.of(1998, 5, 7));
            Usuario usuario3 = new Usuario(333444555, "Pedro", "pedro@gmail.com", "11999999777", LocalDate.of(1997, 6, 7));
            Usuario usuario4 = new Usuario(444555666, "Ana", "ana@gmail.com", "11999999666", LocalDate.of(1996, 7, 7));
            Usuario usuario5 = new Usuario(555666777, "Carlos", "carlos@gmail.com", "11999999555", LocalDate.of(1995, 8, 7));

            usuarioDAO.create(usuario1);
            usuarioDAO.create(usuario2);
            usuarioDAO.create(usuario3);
            usuarioDAO.create(usuario4);
            usuarioDAO.create(usuario5);

            System.out.println("Usuarios criados com sucesso!");
            System.out.println("Listando Usuarios criados...");

            usuarioDAO.getEntitiesAll().forEach(System.out::println);

            if(!usuarioDAO.getEntitiesAll().isEmpty()){
                System.out.println("==================USUARIO============================");
                usuarioDAO.getEntitiesAll().forEach(System.out::println);
                System.out.println("======================================================");
            }else{
                throw new NotFoundEntitiesException("Nenhuma Usuario foi encontrada!");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao criar usuários!");
            e.printStackTrace();
        } finally {
            try {
                if (conexao != null) {
                    conexao.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void deletarTodos() {
        Connection conexao = null;
        try {
            conexao = ConnectionDB.getConnection();
            UsuarioDAO usuarioDAO = new UsuarioDAO(conexao);
            usuarioDAO.getEntitiesAll().forEach(usuario -> {
                try {
                    usuarioDAO.delete(usuario.getIdUsuarioCPF());
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            });
            System.out.println("Todos os usuários foram deletados com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao deletar usuários!");
            e.printStackTrace();
        } finally {
            try {
                if (conexao != null) {
                    conexao.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void CriarUsuario(Usuario usuario) {
        Connection conexao = null;
        try {
            conexao = ConnectionDB.getConnection();
            UsuarioDAO usuarioDAO = new UsuarioDAO(conexao);
            usuarioDAO.create(usuario);
            System.out.println("Usuario criado com sucesso:\n" + usuario);
        } catch (SQLException e) {
            System.out.println("Erro ao criar usuário!");
            e.printStackTrace();
        } finally {
            try {
                if (conexao != null) {
                    conexao.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public void BuscarUsuario(int id) {
        Connection conexao = null;
        try {
            conexao = ConnectionDB.getConnection();
            UsuarioDAO usuarioDAO = new UsuarioDAO(conexao);
            Usuario usuario = usuarioDAO.getEntity(id);
            System.out.println("Usuario encontrado:\n" + usuario);
        } catch (SQLException e) {
            System.out.println("Erro ao buscar usuário!");
            e.printStackTrace();
        } finally {
            try {
                if (conexao != null) {
                    conexao.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public void BuscarTodosOsUsuarios() {
        Connection conexao = null;
        try {
            conexao = ConnectionDB.getConnection();
            UsuarioDAO usuarioDAO = new UsuarioDAO(conexao);
            usuarioDAO.getEntitiesAll().forEach(System.out::println);
        } catch (SQLException e) {
            System.out.println("Erro ao buscar usuários!");
            e.printStackTrace();
        } finally {
            try {
                if (conexao != null) {
                    conexao.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void DeletarUsuario(int id) {
        Connection conexao = null;
        try {
            conexao = ConnectionDB.getConnection();
            UsuarioDAO usuarioDAO = new UsuarioDAO(conexao);
            usuarioDAO.delete(id);
            System.out.println("Usuario deletado com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao deletar usuário!");
            e.printStackTrace();
        } finally {
            try {
                if (conexao != null) {
                    conexao.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void AtualizarUsuario(String email, String telefone) {
        Connection conexao = null;
        Usuario usuario = new Usuario(email, telefone);
        try {
            conexao = ConnectionDB.getConnection();
            UsuarioDAO usuarioDAO = new UsuarioDAO(conexao);
            usuarioDAO.update(usuario);
            System.out.println("Usuario atualizado com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar usuário!");
            e.printStackTrace();
        } finally {
            try {
                if (conexao != null) {
                    conexao.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
