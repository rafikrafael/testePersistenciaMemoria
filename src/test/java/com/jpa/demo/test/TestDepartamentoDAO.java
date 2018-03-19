package com.jpa.demo.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import tads.jpa.demo.dao.BaseDAO;
import tads.jpa.demo.pojo.Departamento;

@ContextConfiguration(locations = "classpath:application-context-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class TestDepartamentoDAO {

	@Autowired
	private BaseDAO<Departamento> departamentoDAO;

	@Test
	@Transactional
	@Rollback(true)
	public void testAddDepartamento() {
		Departamento departamento = new Departamento("TI");
		departamentoDAO.add(departamento);

		List<Departamento> departamentos = departamentoDAO.getTodos();
		Assert.assertEquals(departamento.getNome(), departamentos.get(0).getNome());
	}

}
