package br.com.zup.jpa.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.zup.jpa.modelo.Aluno;
import br.com.zup.jpa.modelo.Resposta;

public class BuscarRespostaPorAluno {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicio");
		EntityManager em = emf.createEntityManager();
		
		Aluno aluno = em.find(Aluno.class, 1L);
		
		String jpql ="select r from Resposta r join fetch r.avaliacao where r.aluno = :pAluno";
		TypedQuery<Resposta> query = em.createQuery(jpql, Resposta.class);
		query.setParameter("pAluno", aluno);
		
		List<Resposta> resultList = query.getResultList();
		for (Resposta resposta : resultList) {
			System.out.println(resposta.getSolucao());
		}
		
		em.close();
	}
	
}
