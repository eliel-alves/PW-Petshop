/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Pet;
import br.edu.ifsul.modelo.Raca;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author eliel
 */
public class TesteListarPet {
    
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PW-Petshop-ModelPU");
        EntityManager em = emf.createEntityManager();
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        List<Pet> lista = em.createQuery("from Pet order by id").getResultList();
        for (Pet p : lista){
            System.out.println("ID: " + p.getId() + " | Nome: " + p.getNome() +
                               " | Espécie: " + p.getEspecie() +
                               " | Nascimento: " + sdf.format(p.getNascimento().getTime()) +
                               " | Peso: " + p.getPeso() + "kg" +
                               " | Raça: " + em.find(Raca.class, p.getRaca().getId()).getNome());
        }
        
        em.close();
        emf.close();
    }
    
}
