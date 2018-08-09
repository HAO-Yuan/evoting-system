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
 * Servlet implementation class VoterHomepage
 */

public class VoterHomepage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VoterHomepage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int vId = ((Voters)request.getSession().getAttribute("currentVoter")).getId();
		try {
			ElectionsDisplayDAO electionsDisplayDao= new ElectionsDisplayDAO();
			HttpSession session = request.getSession();
			
			ArrayList<ReferendumElections> electionComplete = electionsDisplayDao.getClosedElections();
			ArrayList<ReferendumElections> electionOpened = electionsDisplayDao.getElectionsByVid(vId);
			ArrayList<ReferendumElections> electionFuture = electionsDisplayDao.getFutureElections();
			
			
			session.setAttribute("electionComplete", electionComplete);
			session.setAttribute("electionOpened", electionOpened);
			session.setAttribute("electionFuture", electionFuture);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("WEB-INF/voter/voter_homepage.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
