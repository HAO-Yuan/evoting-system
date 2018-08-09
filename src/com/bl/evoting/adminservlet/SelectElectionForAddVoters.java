package com.bl.evoting.adminservlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bl.evoting.bean.ReferendumElections;
import com.bl.evoting.dao.ElectionsDisplayDAO;

/**
 * Servlet implementation class SelectElectionForAddVoters
 */
@WebServlet("/SelectElectionForAddVoters")
public class SelectElectionForAddVoters extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectElectionForAddVoters() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ReferendumElections election;
		ElectionsDisplayDAO eDao = new ElectionsDisplayDAO();
		int eid = Integer.parseInt((request.getParameter("id")));
		
		
		try {
			election = eDao.getElectionById(eid);
			request.getSession().setAttribute("electionForAddVoter", election);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.getRequestDispatcher("WEB-INF/admin/admin_add_voter.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
