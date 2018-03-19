package tads.jpa.demo.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import tads.jpa.demo.pojo.Pessoa;

@Repository
@Transactional
public class PessoaDAOImpl extends BaseDAOImpl<Pessoa> implements PessoaDAO{
	
	public PessoaDAOImpl() {
		super(Pessoa.class);
	}
	
	@Override
	public boolean add(Pessoa objeto){
		String msg = ((Pessoa) objeto).validaDadosMinimos(); 
		if (!msg.equals("")) {
			System.out.println(msg);
			return false;
		}
		try {
			manager.persist(objeto);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
}
