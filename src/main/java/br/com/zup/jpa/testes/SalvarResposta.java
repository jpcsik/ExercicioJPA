package br.com.zup.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.zup.jpa.modelo.Aluno;
import br.com.zup.jpa.modelo.Avaliacao;
import br.com.zup.jpa.modelo.Resposta;

public class SalvarResposta {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicio");
		EntityManager em = emf.createEntityManager();

		
		Resposta resposta = new Resposta();
		resposta.setAluno(em.find(Aluno.class, 1L));
		resposta.setAvaliacao(em.find(Avaliacao.class, 1L));
		resposta.setSolucao("Aqui esta a solucao da avaliacao de servlets");
		
		em.getTransaction().begin();
		
		em.persist(resposta);
		
		em.getTransaction().commit();
		em.close();
		
	}
	
}
