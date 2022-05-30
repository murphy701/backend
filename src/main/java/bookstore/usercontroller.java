package bookstore;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

@WebServlet("/usercontrol")
public class usercontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	userDAO dao;
	public void init(ServletConfig config) throws ServletException{
		super.init(config);
		dao=new userDAO();
	}
	
	public String insert(HttpServletRequest request, HttpServletResponse response) {
		userdb u= new userdb();
		try {
			BeanUtils.populate(u, request.getParameterMap());
		}catch(Exception e) {e.printStackTrace();}
		dao.insert(u);
		return "login.jsp";
	}
}
