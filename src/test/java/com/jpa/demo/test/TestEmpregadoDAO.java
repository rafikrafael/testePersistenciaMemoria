package com.jpa.demo.test;
 
import static org.junit.Assert.assertNotEquals;

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
import tads.jpa.demo.dao.EmpregadoDAO;
import tads.jpa.demo.pojo.Departamento;
import tads.jpa.demo.pojo.Empregado;
import tads.jpa.demo.pojo.Endereco;
 
@ContextConfiguration(locations = "classpath:application-context-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class TestEmpregadoDAO
{
     
    @Autowired
    private EmpregadoDAO empregadoDAO;
     
    @Autowired
    private BaseDAO<Departamento> departamentoDAO;     
     
    @Test
    @Transactional
    @Rollback(true)
    public void testAddEmpregado()
    {
        Departamento departamento = new Departamento("Human Resource");
        departamentoDAO.add(departamento);
         
        Empregado empregado = new Empregado();
        empregado.setPrimeiroNome("Jos�");
        empregado.setUltimoNome("Maria");
        empregado.setEmail("jose.maria@gmail.com");
        empregado.setDepartamento(departamento);
        
        Endereco endereco = new Endereco("Rua ivai", "123", empregado);
        empregado.getEnderecos().add(endereco);
         
        empregadoDAO.addEmpregado(empregado);
         
        List<Departamento> departamentos = departamentoDAO.getTodos();
        List<Empregado> empregados = empregadoDAO.getTodosEmpregados();
         
        Assert.assertEquals(1, departamentos.size());
        Assert.assertEquals(1, empregados.size());
         
        Assert.assertEquals(departamento.getNome(), departamentos.get(0).getNome());
        Assert.assertEquals(empregado.getEmail(), empregados.get(0).getEmail());
        
        List<Endereco> enderecosRetornados = empregados.get(0).getEnderecos();
		Assert.assertEquals(1, enderecosRetornados.size());
		Assert.assertEquals(endereco.getRua(), enderecosRetornados.get(0).getRua());
		
		Empregado empregado2 = new Empregado();
		empregado2.setPrimeiroNome("Marcos");
		empregado2.setUltimoNome("Silva");
		empregado2.setEmail("marcos.silva@gmail.com");
		empregado2.setDepartamento(departamento);
		
		empregadoDAO.addEmpregado(empregado2);
		
		Departamento departamento2 = new Departamento("Sales");
	    departamentoDAO.add(departamento2);
	    
	    Empregado empregadoSales = new Empregado();
		empregadoSales.setPrimeiroNome("Maria");
		empregadoSales.setUltimoNome("Silva");
		empregadoSales.setEmail("maria.silva@gmail.com");
		empregadoSales.setDepartamento(departamento2);
		
		empregadoDAO.addEmpregado(empregadoSales);
		
		List<Empregado> empregadosDepartamento = empregadoDAO.getTodosEmpregadosPorDepartamento(departamento.getId());
		Assert.assertEquals(2, empregadosDepartamento.size());
		Assert.assertEquals("Jos�", empregadosDepartamento.get(0).getPrimeiroNome());
		Assert.assertEquals("Marcos", empregadosDepartamento.get(1).getPrimeiroNome());
		
		List<Empregado> empregadosDepartamentoSales = empregadoDAO.getTodosEmpregadosPorDepartamento(departamento2.getId());
		Assert.assertEquals(1, empregadosDepartamentoSales.size());
		Assert.assertEquals("Maria", empregadosDepartamentoSales.get(0).getPrimeiroNome());
		
    }    
      
}