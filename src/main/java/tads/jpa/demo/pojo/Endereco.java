package tads.jpa.demo.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name="Endereco")
@Table(name="endereco")
public class Endereco {
	
	 private static final long serialVersionUID = 1L;
	 
	 @Id
	 @GeneratedValue
	 private Integer id;
	 
	 @ManyToOne
	 Empregado empregado;
	 
	 String rua;
	 String numero;
	 
	 public Endereco() {
		 
	 }
	 
	 public Endereco(String rua, String numero, Empregado empregado) {
		this.rua = rua;
		this.numero = numero;
		this.empregado = empregado;
	 }
	 
	 
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Empregado getEmpregado() {
		return empregado;
	}
	public void setEmpregado(Empregado empregado) {
		this.empregado = empregado;
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	 
	 

}
