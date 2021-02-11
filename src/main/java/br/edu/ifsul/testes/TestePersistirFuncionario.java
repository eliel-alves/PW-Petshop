/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Funcionario;
import br.edu.ifsul.modelo.Pessoa;
import br.edu.ifsul.modelo.Raca;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author eliel
 */
public class TestePersistirFuncionario {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PW-Petshop-ModelPU");
        EntityManager em = emf.createEntityManager();
        
        Funcionario f = new Funcionario();
        f.setAtivo(true);
        f.setNome("Zezin");
        f.setNomeUsuario("zezin");
        f.setSenha("senha123");
        
        em.getTransaction().begin();
        em.persist(f);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
    
}
