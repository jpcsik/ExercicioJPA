package br.com.zup.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.zup.jpa.modelo.Autocorrecao;
import br.com.zup.jpa.modelo.Resposta;

public class SalvarAutocorrecao {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicio");
		EntityManager em = emf.createEntityManager();
		
		Autocorrecao autocorrecao = new Autocorrecao();
		autocorrecao.setNota(9);
		autocorrecao.setRespota(em.find(Resposta.class, 1L));;
		
		em.getTransaction().begin();
		
		em.persist(autocorrecao);
		
		em.getTransaction().commit();
		em.close();
		
	}
	
}
