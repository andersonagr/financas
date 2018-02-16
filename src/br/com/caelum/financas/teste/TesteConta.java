package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TesteConta {

	public static void main(String[] args) {
		
		Conta conta = new Conta();
		conta.setTitular("Fábio");
		conta.setBanco("Banco do Brasil");
		conta.setAgencia("1234");
		conta.setNumero("455");
		
		EntityManager em = new JPAUtil().getEntityManager();
		
		em.getTransaction().begin();
		em.persist(conta);
		em.getTransaction().commit();
		
		em.close();
	}
		
	}

