package entites;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

/**
 *
 * @author ml
 */
@Entity
public class Auction implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    //Propriétés
    private Float initialAmount;
    private Float reserveAmount;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date startDate;
    private Integer duration;
    private String status;

    
    //Associations
    @OneToMany(mappedBy = "auction")
    private Collection<Bid> bids;
    
    @ManyToOne
    private User user;
    
    @ManyToOne
    private Product product;
    
    //Constructeurs
    public Auction() {
        bids = new ArrayList();
    }

    public Auction(Float initialAmount, Float reserveAmount, Date startDate, Integer duration, String status) {
        this();
        this.initialAmount = initialAmount;
        this.reserveAmount = reserveAmount;
        this.startDate = startDate;
        this.duration = duration;
        this.status = status;
    }

    

    //G&s
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public Float getInitialAmount() {
        return initialAmount;
    }

    public void setInitialAmount(Float initialAmount) {
        this.initialAmount = initialAmount;
    }

    public Float getReserveAmount() {
        return reserveAmount;
    }

    public void setReserveAmount(Float reserveAmount) {
        this.reserveAmount = reserveAmount;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
        
    public Collection<Bid> getBids() {
        return bids;
    }

    public void setBids(Collection<Bid> bids) {
        this.bids = bids;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
    
    
    @Override
    public String toString() {
        return "entites.Auction[ id=" + id + " ]";
    }

}
