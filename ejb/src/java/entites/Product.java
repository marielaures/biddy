package entites;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQueries({
    @NamedQuery(name ="entites.Product.findAll" , query ="select p from Product p"),
    @NamedQuery(name = "entites.Product.findByNom",  query = "select p from Product p where p.name= :paramName")
})
public class Product implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    //Propriétés
    private String name;
    private String description;
    private String cond;

    
    //Dépendances
    @OneToMany(mappedBy = "product")
    private List<Auction> auctions;
    
    @ManyToOne
    private Category category;
    
    
    
    
    //Constructeurs
    public Product() {
        auctions = new ArrayList();
    }

    public Product(String name, String description, String condition) {
        this();
        this.name = name;
        this.description = description;
        this.cond = condition;
    }
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    
   // G&s
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCondition() {
        return cond;
    }

    public void setCondition(String condition) {
        this.cond = condition;
    }
  
    public List<Auction> getAuctions() {
        return auctions;
    }

    public void setAuctions(List<Auction> auctions) {
        this.auctions = auctions;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
    
      
    
    @Override
    public String toString() {
        return "entites.Product[ id=" + id + " ]";
    }
}
