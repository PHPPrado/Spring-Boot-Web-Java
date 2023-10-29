package com.unip.universidade.model.bd;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.unip.universidade.model.Aluno;

@Component
public class AlunoDAOImpl implements AlunoDAO {
    ConnectionFactory connectionFactory;

    public AlunoDAOImpl() {
        connectionFactory = new ConnectionFactory();
    }

    @Override
    public List<Aluno> listarAlunos() {
        List<Aluno> lista = new ArrayList<Aluno>();
        try {
            Connection connection = connectionFactory.getConnection();
            Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from aluno");

            while (resultSet.next()) {
                lista.add(new Aluno(resultSet.getInt("matricula"), resultSet.getString("nome"), resultSet.getDate("data_nascimento")));
            }
            connection.close();
            resultSet.close();
            statement.close();
        } catch (SQLException e) { 
            e.printStackTrace(); 
        }
        return lista;
    }

    @Override
    public Aluno pesquisarAluno(int matricula) {
        Aluno alunoRetorno = null;
        try {
            Connection connection = connectionFactory.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from aluno where matricula = ?");
            preparedStatement.setInt(1, matricula);
            ResultSet resultSet = preparedStatement.executeQuery();

            resultSet.next();
            alunoRetorno = new Aluno(matricula, resultSet.getString("nome"), resultSet.getDate("data_nascimento"));
            
            connection.close();
            preparedStatement.close();
        } catch (SQLException e) { 
            e.printStackTrace(); 
        }
        return alunoRetorno;
    }

    @Override
    public boolean incluirAluno(Aluno aluno) {
        try {
            Connection connection = connectionFactory.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("insert into aluno (nome, data_nascimento) VALUES (?, ?)");
            preparedStatement.setString(1, aluno.getNome());
            preparedStatement.setDate(2, new Date(aluno.getDataNascimento().getTime()));
            int retorno = preparedStatement.executeUpdate();
            connection.close();
            preparedStatement.close();
            if (retorno > 0) return true;
        } catch (SQLException e) { 
            e.printStackTrace(); 
        }
        return false;
    }

    @Override
    public boolean alterarAluno(Aluno aluno) {
        try {
            Connection connection = connectionFactory.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("update aluno set nome = ?, data_nascimento = ? where matricula = ?");
            preparedStatement.setString(1, aluno.getNome());
            preparedStatement.setDate(2, new Date(aluno.getDataNascimento().getTime()));
            preparedStatement.setInt(3, aluno.getMatricula());
            int retorno = preparedStatement.executeUpdate();
            connection.close();
            preparedStatement.close();
            if (retorno > 0) return true;
        } catch (SQLException e) { 
            e.printStackTrace(); 
        }
        return false;
    }

    @Override
    public boolean excluirAluno(int matricula) {
        try {
            Connection connection = connectionFactory.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("delete from aluno where matricula = ?");
            preparedStatement.setInt(1, matricula);
            int retorno = preparedStatement.executeUpdate();
            connection.close();
            preparedStatement.close();
            if (retorno > 0) return true;
        } catch (SQLException e) { 
            e.printStackTrace(); 
        }
        return false;
    }
}
