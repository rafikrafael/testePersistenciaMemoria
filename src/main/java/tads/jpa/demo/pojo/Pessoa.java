package tads.jpa.demo.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="Pessoa")
@Table (name="pessoa")
public class Pessoa implements Serializable
{
    private static final long serialVersionUID = 1L;
  
    @Id
    @GeneratedValue
    private Integer id;
      
    private String nome;
    
    private Date dataNascimento;
    private String rg;
    private String cpf;
    private String fone;
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getFone() {
		return fone;
	}
	public void setFone(String fone) {
		this.fone = fone;
	}
	
	public String validaDadosMinimos() {
		String msg = "";
		if (this.nome.equals("")) {
			msg += "O nome da pessoa deve ser preenchido";
		} 
		if (this.cpf.equals("")) {
			msg += "O Cpf deve ser preenchido";			
		} else {
			Pattern padrao = Pattern.compile("^([0-9]{3}\\.?){3}-?[0-9]{2}$");
			Matcher matcher = padrao.matcher(this.cpf);
			if (!matcher.matches()) {
				msg += "O Cpf deve ser preenchido corretamente";		
			}
		}
		return msg;
	}

}
