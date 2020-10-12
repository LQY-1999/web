package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;
import vo.User;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/servlet/CheckVerifyCode")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		String vcode 	= request.getParameter("vcode"); 
		
		HttpSession session = request.getSession();
		String saveVcode = (String) session.getAttribute("verifyCode");
		
		String forwardPath = "";
		if(!vcode.equalsIgnoreCase(saveVcode)) {
			request.setAttribute("info", "��Ǹ,���������֤�벻��ȷ��");
			forwardPath ="/error.jsp";
		}
		else {
			UserDao userDao = new UserDao();
			User user = UserDao.get(userName);
			if(user == null) {
				request.setAttribute("info", "��Ǹ,����������û������!");
				forwardPath = "/error.jsp";
			}
			else {
				if(!user.getPassword().equals(password)) {
					request.setAttribute("info", "��Ǹ,����������벻��ȷ!");
					forwardPath = "/error.jsp";
				}
				else {
					session.setAttribute("currentUser", user);
					forwardPath = "/maintest.jsp";
				}
			}
		}
		RequestDispatcher reqDispatcher = this.getServletContext().getRequestDispatcher(forwardPath);
		reqDispatcher.forward(request, response);
	}

}
