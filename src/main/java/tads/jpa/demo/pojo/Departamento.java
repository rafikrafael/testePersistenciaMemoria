package tads.jpa.demo.pojo;
 
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
 
@Entity(name="Departamento")
@Table (name="departamento")
public class Departamento implements Serializable {
  
    private static final long serialVersionUID = 1L;
      
    @Id
    @GeneratedValue
    private Integer id;
    private String nome;
      
    public Departamento(){
    }
  
    public Departamento(String name) {
        super();
        this.nome = name;
    }
      
    @OneToMany(mappedBy="departamento",cascade=CascadeType.PERSIST)
    private List<Empregado> empregados = new ArrayList<Empregado>();
      
    //Setters and Getters
    
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setName(String name) {
		this.nome = name;
	}

	public List<Empregado> getEmpregados() {
		return empregados;
	}

	public void setEmpregados(List<Empregado> empregados) {
		this.empregados = empregados;
	}
	
    @Override
    public String toString() {
        return "Departamento [id=" + id + ", nome=" + nome + "]";
    }

}