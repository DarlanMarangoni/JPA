package br.com.alura.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.alura.financas.dao.MovimentacaoDAO;
import br.com.alura.financas.modelo.Conta;
import br.com.alura.financas.modelo.TipoMovimentacao;
import br.com.alura.financas.util.JPAUtil;

public class TesteTypedQueryPQL {

	public static void main(String[] args) {		
		

		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		Conta conta = new Conta();
		conta.setId(2);
		
		MovimentacaoDAO movimentacaoDAO = new MovimentacaoDAO(em);		
		List<Double> mediaDias = movimentacaoDAO.getMediasDia(TipoMovimentacao.SAIDA, conta);		
			
		System.out.println("Media dia 27: " + mediaDias.get(0));
		System.out.println("Media dia 28: " + mediaDias.get(1));
		
		em.getTransaction().commit();
		em.close();
	
	}
}
