package com.bl.evoting.voterservlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bl.evoting.bean.ReferendumElections;
import com.bl.evoting.bean.Voters;
import com.bl.evoting.dao.ElectionsDisplayDAO;

/**
 * Servlet implementation class VotedReferendumsAndElections
 */

public class VotedReferendumsAndElections extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VotedReferendumsAndElections() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			HttpSession session = request.getSession();
			Voters currentVoter = (Voters)session.getAttribute("currentVoter");
			
			//System.out.println(currentVoter.getId());
			
			ElectionsDisplayDAO electionsDisplayDao= new ElectionsDisplayDAO();
			ArrayList<ReferendumElections> votedElectionsList = electionsDisplayDao.getVotedElections(currentVoter.getId());
			
			session.setAttribute("votedElectionList", votedElectionsList);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("WEB-INF/votes/voted_referendums_and_elections.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
