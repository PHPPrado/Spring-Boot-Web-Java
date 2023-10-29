package com.unip.universidade.model.bd;

import java.util.List;

import com.unip.universidade.model.Aluno;

public interface AlunoDAO {
    public List<Aluno> listarAlunos();
    public Aluno pesquisarAluno(int matricula);
    public boolean alterarAluno(Aluno aluno);
    public boolean incluirAluno(Aluno aluno);
    public boolean excluirAluno(int matricula);
}
