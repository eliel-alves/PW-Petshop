/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author eliel
 */
@Entity
@Table(name = "funcionario")
public class Funcionario extends Pessoa implements Serializable {
    
    @NotBlank(message = "O nome do usuário deve ser informado.")
    @Length(max = 20, message = "O nome de usuário não pode ter mais que {max} caracteres.")
    @Column(name = "nome_usuario", length = 20, nullable = false)
    private String nomeUsuario;
    
    @NotNull(message = "O campo ativo deve ser informdo.")
    @Column(name = "ativo", nullable = false)
    private Boolean ativo;
    
    @NotBlank(message = "A senha deve ser informada.")
    @Length(max = 20, message = "A senha não pode ter mais que {max} caracteres.")
    @Column(name = "senha", length = 20, nullable = false)
    private String senha;

    public Funcionario() {
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    
    
}
