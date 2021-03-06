package br.com.alura.financas.teste;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.alura.financas.modelo.Conta;
import br.com.alura.financas.modelo.Movimentacao;
import br.com.alura.financas.modelo.TipoMovimentacao;
import br.com.alura.financas.util.JPAUtil;

public class TesteMaximoJPQL {

	public static void main(String[] args) {		
		

		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		Conta conta = new Conta();
		conta.setId(2);
		
		String jpql = "Select max (m.valor) from Movimentacao m where m.conta = :pConta" + 
														" and m.tipo = :pTipo" + 
														" order by m.valor desc";
		
		Query query = em.createQuery(jpql);
		query.setParameter("pConta", conta);
		query.setParameter("pTipo", TipoMovimentacao.SAIDA);
		
		BigDecimal max = (BigDecimal) query.getSingleResult();
			
		System.out.println("Maximo de Saida: " + max);
		em.getTransaction().commit();
		em.close();
	
	}
}
