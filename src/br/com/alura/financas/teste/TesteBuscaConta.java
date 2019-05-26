package br.com.alura.financas.teste;

import javax.persistence.EntityManager;

import br.com.alura.financas.modelo.Conta;
import br.com.alura.financas.util.JPAUtil;

public class TesteBuscaConta {

	public static void main(String[] args) {
		
		Conta conta = new Conta();
		
		EntityManager em = new JPAUtil().getEntityManager();
		
		em.getTransaction().begin();
		
		conta = em.find(Conta.class, 1);
		System.out.println("antiga = " + conta.getAgencia());
		conta.setAgencia("987");
		System.out.println("nova = " + conta.getAgencia());
		
		em.getTransaction().commit();
		em.close();
		
	}
}
