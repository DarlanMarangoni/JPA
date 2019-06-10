package br.com.alura.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import br.com.alura.financas.modelo.Conta;
import br.com.alura.financas.modelo.TipoMovimentacao;
import br.com.alura.financas.util.JPAUtil;

public class TesteTypedQueryPQL {

	public static void main(String[] args) {		
		

		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		Conta conta = new Conta();
		conta.setId(2);
		
		String jpql = "Select avg (m.valor) from Movimentacao m where m.conta = :pConta" + 
														" and m.tipo = :pTipo" + 
														" group by day(m.data), month(m.data), year(m.data)";
		
		TypedQuery<Double> query = em.createQuery(jpql, Double.class);
		query.setParameter("pConta", conta);
		query.setParameter("pTipo", TipoMovimentacao.SAIDA);
		
		List<Double> mediaDia = (List<Double>) query.getResultList();
			
		System.out.println("Media dia 27: " + mediaDia.get(0));
		System.out.println("Media dia 28: " + mediaDia.get(1));
		
		em.getTransaction().commit();
		em.close();
	
	}
}
