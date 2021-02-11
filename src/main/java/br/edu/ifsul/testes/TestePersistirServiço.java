/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Produto;
import br.edu.ifsul.modelo.Serviço;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author eliel
 */
public class TestePersistirServiço {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PW-Petshop-ModelPU");
        EntityManager em = emf.createEntityManager();
        
        Serviço s = new Serviço();
        s.setNome("Serviço 1");
        Produto p = em.find(Produto.class, 1);
        s.getProdutos().add(p);
        s.setValor(8.50);
        
        em.getTransaction().begin();
        em.persist(s);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
    
}
