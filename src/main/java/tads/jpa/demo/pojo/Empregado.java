package tads.jpa.demo.pojo;
 
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
  
@Entity(name="Empregado")
@Table (name="empregado")
public class Empregado implements Serializable
{
    private static final long serialVersionUID = 1L;
  
    @Id
    @GeneratedValue
    private Integer id;
      
    private String primeiroNome;
    private String ultimoNome;
    private String email;
      
    @ManyToOne
    private Departamento departamento;
    
    @OneToMany(mappedBy="empregado", cascade=CascadeType.ALL)
    private List<Endereco> enderecos = new ArrayList<Endereco>();
      
    public Empregado() {}
       
    public Empregado(String nome, Departamento departamento) {
        this.primeiroNome = nome;
        this.departamento = departamento;
    }
       
    public Empregado(String nome) {
        this.primeiroNome = nome;
    }
  
    //Setters and Getters
    
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPrimeiroNome() {
		return primeiroNome;
	}

	public void setPrimeiroNome(String primeiroNome) {
		this.primeiroNome = primeiroNome;
	}

	public String getUltimoNome() {
		return ultimoNome;
	}

	public void setUltimoNome(String ultimoNome) {
		this.ultimoNome = ultimoNome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
	
    public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	@Override
    public String toString() {
        return "Empregado [id=" + id + ", primeiroNome=" + primeiroNome
                + ", ultimoNome=" + ultimoNome + ", email=" + email
                + ", departamento=" + departamento + "]";
    }

}