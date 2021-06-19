package br.com.zup.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.zup.jpa.modelo.Aluno;

public class SalvarAluno {

	public static void main(String[] args) {

		Aluno aluno = new Aluno();
		aluno.setEmail("Email@email.com");
		aluno.setNome("Joao Pedro");
		aluno.setIdade(25);
		
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicio");
		EntityManager em = emf.createEntityManager();
	
		em.getTransaction().begin();
		
		em.persist(aluno);
		
		em.getTransaction().commit();
		em.close();
		
	
	}
}
