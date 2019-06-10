package br.com.alura.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.alura.financas.modelo.Conta;
import br.com.alura.financas.modelo.Movimentacao;
import br.com.alura.financas.util.JPAUtil;

public class TesteInserirMovimentacao {

    public static void main(String[] args) {

        EntityManager em = new JPAUtil().getEntityManager();
       
        Conta conta = em.find(Conta.class, 1);
        
        //trazer as contas junto com as movimentações
//        Conta conta = new Conta();
//        conta.setId(1);
//        String jpql = "Select m from Movimentacao m join fetch m.conta c where c = :pConta";
//        Query query = em.createQuery(jpql);
//        query.setParameter("pConta", conta);

        List<Movimentacao> movimentacoes = conta.getMovimentacoes();//query.getResultList();

        em.close();//mudar para depois do for

        for (Movimentacao movimentacao : movimentacoes) {
            System.out.println("Movimentação: " + movimentacao.getDescricao());
        }

    }
}
