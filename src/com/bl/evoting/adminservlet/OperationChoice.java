package com.bl.evoting.adminservlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bl.evoting.bean.ReferendumElections;
import com.bl.evoting.dao.ElectionsDisplayDAO;

/**
 * Servlet implementation class LgoinChoice
 */

public class OperationChoice extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OperationChoice() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String choice = request.getParameter("choice");
		switch(choice)
		{
		case "add":
			request.getRequestDispatcher("/WEB-INF/admin/admin_add_voter.jsp").forward(request, response);break;
		case "setup":
			request.getRequestDispatcher("/WEB-INF/admin/admin_setup_election.jsp").forward(request, response);break;
		case "open":
		{
			try {
				ElectionsDisplayDAO electionsDisplayDao= new ElectionsDisplayDAO();
				ArrayList<ReferendumElections> electionList = electionsDisplayDao.getFutureElections();
				
				HttpSession session = request.getSession();
				session.setAttribute("electionList", electionList);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.getRequestDispatcher("/WEB-INF/admin/admin_open_election.jsp").forward(request, response);break;
		}
			
		case "close":
		{
			try {
				ElectionsDisplayDAO electionsDisplayDao= new ElectionsDisplayDAO();
				ArrayList<ReferendumElections> electionList = electionsDisplayDao.getOpenedElections();
				
				HttpSession session = request.getSession();
				session.setAttribute("electionList", electionList);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.getRequestDispatcher("/WEB-INF/admin/admin_close_election.jsp").forward(request, response);break;
		}
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
