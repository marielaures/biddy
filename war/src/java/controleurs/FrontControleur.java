/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleurs;

import entites.Auction;
import entites.Bid;
import entites.Category;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import metier.ManageProductsLocal;

/**
 *
 * @author ml
 */
public class FrontControleur extends HttpServlet {

    @EJB
    private ManageProductsLocal manageProducts;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        // HttpSession session = request.getSession()
        
        // use common JSP for website skeleton "/WEB-INF/jsp/magasin.jsp";
        // by default, if the request match none of the routes below, display home
        request.setAttribute("contentJSP", "/WEB-INF/jsp/includes/hello.jsp");


        // dispatch different URLs to units of processing
        String section = request.getParameter("section");
        
        if (section != null && section.equals("encheres")) {
            encheresController(request, response);
        }
        
        // skeleton resources
        // all categories
        List<Category> lc = manageProducts.getCategoryList();
        request.setAttribute("categories", lc);
        // current category
        request.setAttribute("category", request.getParameter("category"));

//        // enregistrer la nouvelle enchere
//        String newAmount = request.getParameter("enchere");
//        int newAmountConverted = Integer.parseInt(newAmount.trim());
        
        
        
        
        //YOYO
        
        getServletContext().getRequestDispatcher(response.encodeURL("/WEB-INF/jsp/magasin.jsp")).include(request, response);
    }
    
    private void encheresController(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
        String action = request.getParameter("action");
        String category = request.getParameter("category");
        
        // encheres should always have a category
        if (category == null) {
            response.setStatus(400);
            return;
        }
        
        Integer categoryID = Integer.parseInt(category.trim());
               
        // no action, display bids
        if (action == null) {
            List<Auction> listAuctions = manageProducts.findCurrentAuctionByCategoryId(categoryID);
            request.setAttribute("auctions", listAuctions);
            request.setAttribute("contentJSP", "/WEB-INF/jsp/includes/encheres.jsp");      
        } else if (action.equals("details")) {
            String auctionIDStr = request.getParameter("auctionID");
            if (auctionIDStr == null) {
                response.sendError(400);
                return;
            }
            
            Integer auctionID = Integer.parseInt(auctionIDStr.trim());
            Bid bestBid = manageProducts.findBestBid(auctionID);
            request.setAttribute("bestBid", bestBid);
            request.setAttribute("contentJSP", "/WEB-INF/jsp/includes/detailenchere.jsp");
        } else if (action.equals("new")) {
            String auctionIDStr = request.getParameter("auctionID");
            if (auctionIDStr == null) {
                response.sendError(400);
                return;
            }
            
            Integer auctionID = Integer.parseInt(auctionIDStr.trim());            
            request.setAttribute("contentJSP", "/WEB-INF/jsp/includes/encherir.jsp");            
        }

        
    }
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
