package test;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.message_daoImpl;
import pojo.message_Pojo;

/**
 * Servlet implementation class message_servlet
 */
@WebServlet("/message_servlet")
public class message_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public message_servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int sid = Integer.parseInt(request.getParameter("sid"));
		String name =request.getParameter("name");
		String message = request.getParameter("message");
		
		HttpSession session = request.getSession();
		message_Pojo m = new message_Pojo(sid, name, message);
		message_daoImpl mimpl = new message_daoImpl();
		List<message_Pojo> li =	mimpl.getMessage();
		if(mimpl.addMessage(m)) {
			session.setAttribute("list", li);
			response.sendRedirect("inbox.jsp");
		}else {
			response.sendRedirect("login.jsp");
		}
	}

}
