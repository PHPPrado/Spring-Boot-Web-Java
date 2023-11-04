package com.unip.universidade.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

    @Entity
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public class Tcc {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int codigo;

        @Pattern(regexp = "^ALPOO:(\\s|[A-Z]|[a-z]){1,50}$",
                message = "valor deve iniciar com \"ALPOO:\" e ter um tamanho máximo de 50")
        private String titulo;

        @Min(1950) @Max(2023)
        private int ano;

        @Min(1) @Max(2)
        private int semestre;

        @OneToMany(mappedBy = "tcc", cascade = CascadeType.ALL)
        private List<Aluno> alunosGrupo = new ArrayList<>();
        public Tcc(String titulo, int ano, int semestre, List<Aluno>
                alunosGrupo) {
            this.titulo = titulo;
            this.ano = ano;
            this.semestre = semestre;
            this.alunosGrupo = alunosGrupo;
        }
    }