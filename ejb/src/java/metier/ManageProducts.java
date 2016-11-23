package metier;

import entites.Auction;
import entites.Bid;
import entites.Category;
import entites.Product;
import entites.User;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author ml
 */
@Stateless
public class ManageProducts implements ManageProductsLocal {

    @PersistenceContext(unitName = "encheres-ejbPU")
    private EntityManager em;

    @Override
    public Product findByName(String name) {
        return em.find(Product.class, name);
    }

    @Override
    public List<Product> findAllProduct() {
        Query qr = em.createNamedQuery("entites.Product.findAll");
        return qr.getResultList();
    }
    
    
    @Override
    public List<Category> getCategoryList() {
       String rq = "select c from Category c";
       Query qr = em.createQuery(rq);
       return qr.getResultList();
    }

    //>>>>>>>>>>>>>>>>>>>>>> A MODIFIER SI BESOIN pour prendre le BONTYPE de parametre du menu deroulant ATTENTION AUX ARGUEMENTS
    
    @Override
    public List<Product> findByCategoryId(int id) {
        String req = "select c.products from Category c where c.id = :paramId";
        Query qr = em.createQuery(req);
        qr.setParameter("paramId", id);
        return qr.getResultList();     
    }
    
    @Override
    public List<Auction> findCurrentAuctionByCategoryId(int id) {
        String req = "select a from Auction a where a.product.category.id = :paramId and a.status = :paramStatus";
        Query qr = em.createQuery(req);
        qr.setParameter("paramId", id);
        qr.setParameter("paramStatus", "in progress");
        return qr.getResultList();     
    }
    
    
    @Override
    public Bid findBestBid(int id) {
        String req = "select b from Bid b join b.auction a where a.id = :paramId order by b.amount";
    //    String req = "select MAX(a.bids.amount) from Auction a where a.id = :paramId";
        Query qr = em.createQuery(req);
        qr.setParameter("paramId", id);
        qr.setMaxResults(1);
        Bid bestBid = (Bid) qr.getSingleResult();
        System.out.println(bestBid);
        return bestBid;
    }
    
    public void insertNewBid(float amount, User user) {
        Bid newBid = new Bid();
        newBid.setAmount(amount);
        newBid.setUser(user);
        em.persist(newBid);  
    }
    
//     public List<Product> findByNameSearch(String recherche){
//        String req = "select p from Produit p  where "
//                + "(UPPER(p.reference) like UPPER(:param)) OR (UPPER(p.nom) like UPPER(:param))";
//        Query qr = em.createQuery(req);
//        qr.setParameter("param", "%"+recherche+"%");
//        return qr.getResultList();
//    }
    
    
    
    
    @Override
    public void createData() {

        Category c01 = new Category("mobilier");
        Category c02 = new Category("tableau");
        Category c03 = new Category("joaillerie");
        Product p01 = new Product("coiffeuse", "coiffeuse style Louis XVI", "exceptionnel");
        Product p02 = new Product("picasso", "tableau de la période bleue", "bon état");
        Product p03 = new Product("matisse", "découpage oiseaux", "bon état");
        Product p04 = new Product("solitaire", "pierre 120 carats", "exceptionnel");
        Product p05 = new Product("commode", "commode style Louis XII", "bon état");
        Product p06 = new Product("fauteuil", "fauteuil plastique Starck", "bon état");
        Product p07 = new Product("monet", "tableau coquelicots", "bon état");
        Product p08 = new Product("diadème", "Diadème Cartier", "bon état");

        p01.setCategory(c01);
        p02.setCategory(c02);
        p03.setCategory(c02);
        p04.setCategory(c03);
        p05.setCategory(c01);
        p06.setCategory(c01);
        p07.setCategory(c02);
        p08.setCategory(c03);

        em.persist(c01);
        em.persist(c02);
        em.persist(c03);
        em.persist(p01);
        em.persist(p02);
        em.persist(p03);
        em.persist(p04);
        em.persist(p05);
        em.persist(p06);
        em.persist(p07);
        em.persist(p08);

        //Creation du reste du jeu de test
        Date d01 = new GregorianCalendar(2016, 11, 2, 10, 00).getTime();
        Auction a01 = new Auction(999f, 1500f, d01, 9, "in progress"); //pour fauteuil p06
        Auction a02 = new Auction(99999f, 150000f, d01, 9, "in progress"); //pour picasso p02
        Auction a03 = new Auction(10000f, 20000f, d01, 9, "in progress"); //pour diademe p08
        Date d02 = new GregorianCalendar(2016, 13, 1, 10, 00).getTime();
        Auction a04 = new Auction(12000f, 22000f, d02, 9, "not started yet"); //pour matisse p03
        Auction a05 = new Auction(10500f, 25000f, d02, 9, "not started yet"); //pour coiffeusep01
        
        em.persist(a01);
        em.persist(a02);
        em.persist(a03);
        em.persist(a04);
        em.persist(a05);
        
        a01.setProduct(p06);
        a02.setProduct(p02);
        a03.setProduct(p08);
        a04.setProduct(p03);
        a05.setProduct(p01);
        
        
        User u01 = new User("Phaco", "Sher", "phacosher@gmail.com", "phacos");
        User u02 = new User("Marsu", "Pilami", "marsupilamir@gmail.com", "marsup");
        User u03 = new User("ml", "sin", "mlsin@gmail.com", "ml");
        
        
        em.persist(u01);
        em.persist(u02);
        em.persist(u03);
        
        a01.setUser(u01);
        a02.setUser(u02);
        a03.setUser(u03);
        a04.setUser(u03);
        a05.setUser(u03);
        
        
        Bid b01 = new Bid(1200f);
        Bid b02 = new Bid(1500f);
        Bid b03 = new Bid(1800f);
        
        
        
        b01.setUser(u03);
        b02.setUser(u02);
        b03.setUser(u03);
        
        b01.setAuction(a01);
        b02.setAuction(a01);
        b03.setAuction(a01);
        
        
        //Auction2
        Bid b04 = new Bid(100000f);
        Bid b05 = new Bid(150000f);
        Bid b06 = new Bid(300000f);
        
        b04.setUser(u01);
        b05.setUser(u03);
        b06.setUser(u01);
        
        b04.setAuction(a02);
        b05.setAuction(a02);
        b06.setAuction(a02);
        
        //Auction3
        Bid b07 = new Bid(11000f);     
        b07.setUser(u01);  
        b07.setAuction(a03);
        
        
        em.persist(b01);
        em.persist(b02);
        em.persist(b03);
        em.persist(b04);
        em.persist(b05);
        em.persist(b06);
        em.persist(b07);
    }

}
