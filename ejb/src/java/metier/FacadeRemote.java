package metier;

import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author ml
 */
@Stateless
public class FacadeRemote implements FacadeRemoteRemote {
    @EJB
    private ManageProductsLocal manageProducts;
    
    @Override
    public void createData(){
        manageProducts.createData();
    }
    
}
