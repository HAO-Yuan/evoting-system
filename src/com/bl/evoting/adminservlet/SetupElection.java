package com.bl.evoting.adminservlet;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bl.evoting.bean.Candidates;
import com.bl.evoting.bean.CandidatesSet;
import com.bl.evoting.bean.ReferendumElections;
import com.bl.evoting.dao.DBDao;

/**
 * Servlet implementation class VotingSubmission
 */

public class SetupElection extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SetupElection() {
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
		request.getRequestDispatcher("WEB-INF/admin/admin_homepage.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		
		try {
			DBDao dbDao = new DBDao();
			int eId = -1;
			
			ReferendumElections election = new ReferendumElections();
			CandidatesSet candidatesSet = (CandidatesSet) request.getSession().getAttribute("candidatesSet");
			
			election.setTitle(request.getParameter("title"));
			election.setDescription(request.getParameter("description"));
			election.setLocation(Integer.parseInt(request.getParameter("location")));
			election.setOptions(candidatesSet.countNumberOfCandidates());


//			ResultSet rs = dbDao.query("select * from vote where e_id=? and v_id=?;", vote.geteId(), vote.getvId());
			
//			if (!rs.next()) {
				ResultSet rs = dbDao.getLastId("insert into referendum_election (title,description,location,options) values(?,?,?,?)", election.getTitle(), election.getDescription(), election.getLocation(),election.getOptions());
				if(rs.next()) {
					eId = rs.getInt(1);
				}
				for (Candidates candidate : candidatesSet.getCandidatesSet()) {
					dbDao.insert("insert into candidate_referendum_election_relation (c_id,e_id) values (?,?)", candidate.getId(),eId);
				}
				request.getRequestDispatcher("WEB-INF/admin/admin_setup_success.jsp").forward(request, response);
//			} else {
//				request.getRequestDispatcher("WEB-INF/votes/voting_submission_failure.jsp").forward(request, response);
//			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
