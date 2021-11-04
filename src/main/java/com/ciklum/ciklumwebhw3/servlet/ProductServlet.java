package com.ciklum.ciklumwebhw3.servlet;

import com.ciklum.ciklumwebhw3.dao.ProductDao;
import com.ciklum.ciklumwebhw3.domain.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ProductServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static String PRODUCT = "/product.jsp";
    private static String PRODUCT_LIST = "/product_list.jsp";
    private ProductDao dao;

    public ProductServlet() {

    }

    public ProductServlet(ProductDao productDao) {
        this.dao = productDao;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward="";
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("delete")){
            int productId = Integer.parseInt(request.getParameter("id"));
            dao.deleteById(productId);
            forward = PRODUCT_LIST;
            request.setAttribute("products", dao.findAll());
        } else if (action.equalsIgnoreCase("products")){
            forward = PRODUCT_LIST;
            request.setAttribute("products", dao.findAll());
        } else {
            forward = PRODUCT;
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Product product = new Product();
        product.setName(request.getParameter("name"));
        int price = Integer.parseInt(request.getParameter("price"));
        product.setPrice(price);
        product.setStatus(request.getParameter("status"));
        dao.save(product);

        RequestDispatcher view = request.getRequestDispatcher(PRODUCT_LIST);
        request.setAttribute("products", dao.findAll());
        view.forward(request, response);
    }


}
