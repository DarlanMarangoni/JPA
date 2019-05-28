package br.com.alura.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.alura.financas.modelo.Categoria;
import br.com.alura.financas.modelo.Movimentacao;
import br.com.alura.financas.util.JPAUtil;

public class TesteMovimentscaoPorCategoria {
	public static void main(String[] args) {
		
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		//instancio o objeto a ser consultado
		Categoria categoria = new Categoria();
		categoria.setId(4);
		//escrevo a consulta
		String jpql = "Select m from Movimentacao m join m.categorias c where c = :pCategoria";
		//instancio uma query
		Query query = em.createQuery(jpql);
		query.setParameter("pCategoria", categoria);//passo o obj como parametro para query
		//recebo o resultado da query
		List<Movimentacao> movimentacoes = query.getResultList();
		
		for (Movimentacao m : movimentacoes) {
			System.out.println("Descrição: "+ m.getDescricao());
			System.out.println("Conta.id: "+ m.getConta().getId());
		}
		
		
		em.getTransaction().commit();
		em.close();
		
	}

}
