package entites;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author ml
 */
@Entity
public class Category implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //Proprietes
    private String name;

    //Associations
    @OneToMany(mappedBy = "category")
    private Collection<Product> products;

    //Constructeurs
    public Category() {
        products = new ArrayList();
    }

    public Category(String name) {
        this();
        this.name = name;
    }

    //G&s
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<Product> getProducts() {
        return products;
    }

    public void setProducts(Collection<Product> products) {
        this.products = products;
    }
    
   
    @Override
    public String toString() {
        return "entites.Category[ id=" + id + " ]";
    }
}
