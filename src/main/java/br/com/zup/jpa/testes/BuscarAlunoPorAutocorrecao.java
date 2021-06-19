package br.com.zup.jpa.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.zup.jpa.modelo.Autocorrecao;
import br.com.zup.jpa.modelo.Resposta;

public class BuscarAlunoPorAutocorrecao {

	// Resolucao sem o uso de jpql
	
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicio");
		EntityManager em = emf.createEntityManager();
		
		Autocorrecao autocorrecao = em.find(Autocorrecao.class, 2L);
		Resposta resposta = em.find(Resposta.class, autocorrecao.getRespota());
		System.out.println(resposta.getAluno());
		
		em.close();
		
	}
	
	// Resolucao com jpql
	
	public static void main2(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicio");
		EntityManager em = emf.createEntityManager();
		
		Autocorrecao autocorrecao = em.find(Autocorrecao.class, 5L);
		
		String jpql = "select r from Resposta r where r.id = :pAutocorrecao";
		TypedQuery<Resposta> query = em.createQuery(jpql, Resposta.class);
		query.setParameter("pAutocorrecao", autocorrecao.getRespota());
		
		List<Resposta> resultList = query.getResultList();
		for (Resposta resposta : resultList) {
			System.out.println(resposta.getAluno());
		}
	}
}
