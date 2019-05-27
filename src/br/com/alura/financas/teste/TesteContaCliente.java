package br.com.alura.financas.teste;

import javax.persistence.EntityManager;

import br.com.alura.financas.modelo.Cliente;
import br.com.alura.financas.modelo.Conta;
import br.com.alura.financas.util.JPAUtil;

public class TesteContaCliente {

	public static void main(String[] args) {
		
		Cliente cliente = new Cliente();
		cliente.setNome("Darlan");
		cliente.setProfissao("Ferramenteiro");
		cliente.setEndereco("Av. Reneville, 558");
				
		Conta conta = new Conta();
		conta.setId(2);
				
		cliente.setConta(conta);
		
		Cliente cliente2 = new Cliente();
		cliente2.setNome("Leonardo");
		cliente2.setProfissao("Filho");
		cliente2.setEndereco("Av. Reneville, 558");
				
		cliente2.setConta(conta);
		
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		em.persist(cliente);
		
		em.getTransaction().commit();
		em.close();
		
	}
}
