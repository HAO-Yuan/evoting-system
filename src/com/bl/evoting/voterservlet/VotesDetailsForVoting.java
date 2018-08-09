package com.bl.evoting.voterservlet;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bl.evoting.bean.Candidates;
import com.bl.evoting.bean.ReferendumElections;
import com.bl.evoting.dao.CandidatesDisplayDAO;
import com.bl.evoting.dao.ElectionsDisplayDAO;

/**
 * Servlet implementation class VotesDetails
 */

public class VotesDetailsForVoting extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VotesDetailsForVoting() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int eId = Integer.parseInt(request.getParameter("id"));
		ElectionsDisplayDAO electionsDisplayDao= new ElectionsDisplayDAO();
		CandidatesDisplayDAO candidatesDisplayDao = new CandidatesDisplayDAO();
		try {
			ReferendumElections elections = electionsDisplayDao.getElectionById(eId);
			request.setAttribute("electionDetailsForVoting", elections);
			
			Set<Candidates> candidateSet = candidatesDisplayDao.getCandidatesByEId(eId);
			request.setAttribute("candidatesForElectionToBeVoted", candidateSet);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.getRequestDispatcher("WEB-INF/votes/vote_details_for_voting.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
