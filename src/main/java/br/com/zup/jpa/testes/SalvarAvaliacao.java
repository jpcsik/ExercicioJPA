package br.com.zup.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.zup.jpa.modelo.Avaliacao;

public class SalvarAvaliacao {

	public static void main(String[] args) {
		Avaliacao avaliacao = new Avaliacao();
		avaliacao.setTitulo("Exercicio de Servlets");
		avaliacao.setDescricao("Construa uma api utilizando Servlets");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicio");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		em.persist(avaliacao);
		
		em.getTransaction().commit();
		em.close();
	}

}
