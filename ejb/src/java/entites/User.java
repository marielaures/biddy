package entites;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.Column;
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
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    //Propriétés
    @Column(nullable=false)
    private String surname;
    private String firstName;
    @Column(nullable=false)
    private String email;
    @Column(nullable = false, length =10)
    private String pwd;
    
    //Associations
    @OneToMany(mappedBy = "user")
    private Collection<Auction> auctions;
    
    @OneToMany(mappedBy = "user")
    private Collection<Bid> bids;
    
    
    //Constructeurs

    public User() {
        auctions = new ArrayList();
        bids = new ArrayList();
    }

    public User(String surname, String firstName, String email, String pwd) {
        this();
        this.surname = surname;
        this.firstName = firstName;
        this.email = email;
        this.pwd = pwd;
    }
    
    

    //G&s  
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
    
    
    public Collection<Auction> getAuctions() {
        return auctions;
    }

    public void setAuctions(Collection<Auction> auctions) {
        this.auctions = auctions;
    }

    public Collection<Bid> getBids() {
        return bids;
    }

    public void setBids(Collection<Bid> bids) {
        this.bids = bids;
    }
    
    
    @Override
    public String toString() {
        return "entites.User[ id=" + id + " ]";
    }
}
