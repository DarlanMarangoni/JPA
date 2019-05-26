package br.com.alura.financas.teste;

import javax.persistence.EntityManager;

import br.com.alura.financas.modelo.Conta;
import br.com.alura.financas.util.JPAUtil;

public class TesteDeletaConta {
	
	public static void main(String[] args) {
		Conta conta = new Conta();
		EntityManager em = new JPAUtil().getEntityManager();
		
		em.getTransaction().begin();
		conta = em.find(Conta.class, 1);
		em.remove(conta);		
		em.getTransaction().commit();
		em.close();
		
	}
	
}
