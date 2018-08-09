package com.bl.evoting.voterservlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bl.evoting.bean.CandidatesSet;
import com.bl.evoting.bean.ReferendumElections;
import com.bl.evoting.dao.CandidatesDisplayDAO;
import com.bl.evoting.dao.ElectionsDisplayDAO;

/**
 * Servlet implementation class VotesDetails
 */

public class VotesDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VotesDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		ElectionsDisplayDAO electionsDisplayDao= new ElectionsDisplayDAO();
		CandidatesDisplayDAO candidatesDisplayDao= new CandidatesDisplayDAO();
		
		CandidatesSet candidatesSet = new CandidatesSet();
		try {
			ReferendumElections election = electionsDisplayDao.getElectionById(id);
			request.getSession().setAttribute("electionForDetails", election);
			
			candidatesSet.setCandidatesSet(candidatesDisplayDao.getCandidatesByEId(id));
			
			request.getSession().setAttribute("candidatesSetForElection", candidatesSet);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.getRequestDispatcher("WEB-INF/votes/vote_details.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
