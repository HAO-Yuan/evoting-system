package com.bl.evoting.voterservlet;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bl.evoting.bean.Voters;
import com.bl.evoting.dao.DBDao;

/**
 * Servlet implementation class VoterLoginServlet
 */

public class VoterLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public VoterLogin() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// if login failure, redirect to the login page
		if(request.getParameter("action") == null) {
			request.getRequestDispatcher("WEB-INF/voter/voter_login.jsp").forward(request, response);
		}else {
			this.doPost(request,response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String action = request.getParameter("action");
		
		switch(action) {
		case "signup": 
			request.getRequestDispatcher("WEB-INF/voter/voter_signup.jsp").forward(request, response);break;
		default:
			login(request, response);
		}
		
	}
	
	protected void login(HttpServletRequest request, HttpServletResponse response) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		try {
			DBDao dbDao = new DBDao();

			ResultSet rs = dbDao.query("select * from voter where username=?", username);

			if (rs.next()) {
				if (rs.getString("password").equals(password)) {
					Voters currentVoter = new Voters();
					currentVoter.setId(rs.getInt("id"));
					currentVoter.setUsername(rs.getString("username"));
					currentVoter.setPassword(rs.getString("password"));

					// put currentVoter into current session
					HttpSession session = request.getSession();
					session.setAttribute("currentVoter", currentVoter);

					request.getRequestDispatcher("WEB-INF/voter/voter_login_success.jsp").forward(request, response);
				} else {

					request.getRequestDispatcher("WEB-INF/voter/voter_login_failure.jsp").forward(request, response);
				}
			} else {
				request.getRequestDispatcher("WEB-INF/voter/voter_login_failure.jsp").forward(request, response);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
