/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import entites.Auction;
import entites.Bid;
import entites.Category;
import entites.Product;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author ml
 */
@Local
public interface ManageProductsLocal {

    public Product findByName(String name);

    public List<Product> findAllProduct();

    public void createData();



    public List<Category> getCategoryList();


    public List<Product> findByCategoryId(int id);

    public List<Auction> findCurrentAuctionByCategoryId(int id);

    public Bid findBestBid(int id);
    
}
