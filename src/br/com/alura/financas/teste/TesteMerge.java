package br.com.alura.financas.teste;

import javax.persistence.EntityManager;

import br.com.alura.financas.modelo.Conta;
import br.com.alura.financas.util.JPAUtil;

public class TesteMerge {
	
	public static void main(String[] args) {
		Conta conta = new Conta();
		conta.setId(2);
		
		EntityManager em2 = new JPAUtil().getEntityManager();
		
		em2.getTransaction().begin();
		conta.setAgencia("987");
		//em2.persist(conta); -> detached entity passed to persist, usar o metodo merge()
		em2.merge(conta);
		
		em2.getTransaction().commit();
		em2.close();
		
	}
}
