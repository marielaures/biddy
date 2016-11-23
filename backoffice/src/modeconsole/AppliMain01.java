package modeconsole;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import metier.FacadeRemoteRemote;


public class AppliMain01 {
     public static void main(String[] args) throws NamingException {
        InitialContext ctx = new InitialContext();                    
        FacadeRemoteRemote frr = (FacadeRemoteRemote) ctx.lookup(FacadeRemoteRemote.class.getName());
        frr.createData();
        System.out.println("------------- DONE -----------------");
    }
    
}

