package br.com.alura.financas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.alura.financas.modelo.Conta;
import br.com.alura.financas.modelo.TipoMovimentacao;

public class MovimentacaoDAO {
	private EntityManager em;

	public MovimentacaoDAO(EntityManager em) {
		this.em = em;
	}

	public List<Double> getMediasDia(TipoMovimentacao tipoMovimentacao, Conta conta) {
		String jpql = "Select avg (m.valor) from Movimentacao m where m.conta = :pConta" + " and m.tipo = :pTipo"
				+ " group by day(m.data), month(m.data), year(m.data)";

		TypedQuery<Double> query = em.createQuery(jpql, Double.class);
		query.setParameter("pConta", conta);
		query.setParameter("pTipo", TipoMovimentacao.SAIDA);

		return query.getResultList();
	}

}
