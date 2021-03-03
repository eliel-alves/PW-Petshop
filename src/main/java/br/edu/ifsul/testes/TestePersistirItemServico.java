/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.ItemServico;
import br.edu.ifsul.modelo.OrdemServico;
import br.edu.ifsul.modelo.Produto;
import br.edu.ifsul.modelo.Servico;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author eliel
 */
public class TestePersistirItemServico {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PW-Petshop-ModelPU");
        EntityManager em = emf.createEntityManager();
  
        ItemServico is = new ItemServico();
        is.setQuantidade(2);
        is.setServico(em.find(Servico.class, 1));
        is.setValorUnitario(8.50);
        is.setValorTotal(17.00);
        is.setOrdemServico(em.find(OrdemServico.class, 1));
        
        em.getTransaction().begin();
        em.persist(is);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
    
}
