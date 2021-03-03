/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Funcionario;
import br.edu.ifsul.modelo.ItemServico;
import br.edu.ifsul.modelo.OrdemServico;
import br.edu.ifsul.modelo.Pessoa;
import br.edu.ifsul.modelo.Pet;
import br.edu.ifsul.modelo.Produto;
import br.edu.ifsul.modelo.Servico;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author eliel
 */
public class TestePersistirOrdemServico {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PW-Petshop-ModelPU");
        EntityManager em = emf.createEntityManager();
        
        OrdemServico os = new OrdemServico();
        os.setData(new GregorianCalendar(2021, Calendar.FEBRUARY, 12));
        os.setDescricao("Descrição da ordem do serviço");
        os.setFuncionario(em.find(Funcionario.class, 2));
        os.setPessoa(em.find(Pessoa.class, 1));
        os.setPet(em.find(Pet.class, 2));
        os.setValorTotal(200.00);
        
        em.getTransaction().begin();
        em.persist(os);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
    
}
