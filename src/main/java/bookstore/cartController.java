package bookstore;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import org.apache.commons.beanutils.BeanUtils;

@WebServlet("/cart")
@MultipartConfig(maxFileSize=1024*1024*2, location="c:/Temp/img")
public class cartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    private cartDAO dao;
    private ServletContext ctx;
    private final String START_PAGE = "cart/cart.jsp";
    
    public void init(ServletConfig config) throws ServletException {
    	super.init(config);
    	dao = new cartDAO();
    	ctx = getServletContext();
    }
    
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("utf-8");
    	String action = request.getParameter("action");
    	Method m;
    	String view = null;
    	if (action == null) {
    		action = "insertCart";
    	}
    	try {
    		m = this.getClass().getMethod(action, HttpServletRequest.class);
    		view = (String)m.invoke(this, request);
    	} catch (NoSuchMethodException e) {
    		e.printStackTrace();
    		ctx.log("요청 action 없음!!");
    		request.setAttribute("error", "action 파라미터가 잘못되었습니다!!");
    		view = START_PAGE;
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	if(view.startsWith("redirect:/")) {
    		String rview = view.substring("redirect:/".length());
    		response.sendRedirect(rview);
    	} else {
    		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
    		dispatcher.forward(request, response);
    	}
    }

    public String insertCart(HttpServletRequest request) {
    	try {
    	cart c=new cart();
    	dao.insertCart(c);
    	}catch(Exception e) {
			e.printStackTrace();
			ctx.log("장바구니를 추가하는 과정에서 문제 발생!!");
			request.setAttribute("error", "장바구니를 추가하지 못하였습니다!!");
    	}
    return "cart/cart.jsp";//redirect는 webapp경로만 작동한 다고 되어있음
    }
    
    
}
