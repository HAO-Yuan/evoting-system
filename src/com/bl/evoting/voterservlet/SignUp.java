package com.bl.evoting.voterservlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bl.evoting.bean.Voters;
import com.bl.evoting.dao.DBDao;

/**
 * Servlet implementation class SignUp
 */
@WebServlet("/SignUp")
public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Voters voter = new Voters();
		voter.setUsername(request.getParameter("username"));
		voter.setPassword(request.getParameter("password"));
		voter.setEmail(request.getParameter("email"));
		
		try {
			DBDao dbDao = new DBDao();
			
			if(dbDao.insert("insert into voter(username,password,email) value(?,?,?)", voter.getUsername(), voter.getPassword(),voter.getEmail())) {
				request.getRequestDispatcher("/WEB-INF/voter/voter_signup_success.jsp").forward(request, response);
			}else {
				request.getRequestDispatcher("/WEB-INF/voter/voter_signup_failure.jsp").forward(request, response);
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
