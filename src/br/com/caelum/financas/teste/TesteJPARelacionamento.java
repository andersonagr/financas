package br.com.caelum.financas.teste;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TesteJPARelacionamento {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Conta conta = new Conta(); 
		conta.setAgencia("0102");
		conta.setBanco("Itau");
		conta.setNumero("1234");
		conta.setTitular("anderson");
		
		Movimentacao mov = new Movimentacao();
		mov.setData(Calendar.getInstance());
		mov.setDescricao("Churrascaria");
		mov.setTipo(TipoMovimentacao.SAIDA);
		mov.setValor(new BigDecimal("200.0"));
		mov.setConta(conta);
		
		EntityManager em = new JPAUtil().getEntityManager();
	
		em.getTransaction().begin();
		em.persist(conta);
		em.persist(mov);
		em.getTransaction().commit();
		em.close();
	}

}
