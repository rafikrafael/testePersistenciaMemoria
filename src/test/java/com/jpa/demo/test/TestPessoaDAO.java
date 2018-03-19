package com.jpa.demo.test;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import tads.jpa.demo.dao.PessoaDAO;
import tads.jpa.demo.pojo.Pessoa;

@ContextConfiguration(locations = "classpath:application-context-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class TestPessoaDAO {

		@Autowired
		private PessoaDAO pessoaDAO;

		@Test
		@Transactional
		@Rollback(true)
		public void testAddPessoa() {
			Pessoa pessoa = new Pessoa();
			
			pessoa.setNome("Willian");
			pessoa.setDataNascimento(new Date());
			pessoa.setCpf("027.726.501-03");
			pessoa.setRg("79695521");
			pessoa.setFone("(44) 99999-9999");
			
			String validacao = pessoa.validaDadosMinimos();
			
			pessoaDAO.add(pessoa);
			
			Assert.assertTrue(pessoa.getId() > 0);

			Pessoa pessoaNovaFalha = new Pessoa();
			pessoaNovaFalha.setNome("");
			pessoaNovaFalha.setDataNascimento(new Date());
			pessoaNovaFalha.setCpf("027.726.501-03");
			pessoaNovaFalha.setRg("79695521");
			pessoaNovaFalha.setFone("(44) 99999-9999");
			
			pessoaDAO.add(pessoaNovaFalha);
			
			Assert.assertEquals(null, pessoaNovaFalha.getId());
			
			Pessoa pessoaNovaFalhaCPF = new Pessoa();
			pessoaNovaFalhaCPF.setNome("Willian");
			pessoaNovaFalhaCPF.setDataNascimento(new Date());
			pessoaNovaFalhaCPF.setCpf("asdjasjdoiaj");
			pessoaNovaFalhaCPF.setRg("79695521");
			pessoaNovaFalhaCPF.setFone("(44) 99999-9999");
			
			pessoaDAO.add(pessoaNovaFalhaCPF);
			
			Assert.assertEquals(null, pessoaNovaFalhaCPF.getId());

			
		}

	}
