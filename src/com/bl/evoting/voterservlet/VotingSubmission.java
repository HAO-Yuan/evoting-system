package com.bl.evoting.voterservlet;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bl.evoting.bean.Voters;
import com.bl.evoting.bean.Votes;
import com.bl.evoting.dao.DBDao;

/**
 * Servlet implementation class VotingSubmission
 */

public class VotingSubmission extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public VotingSubmission() {
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
		request.getRequestDispatcher("WEB-INF/voter/voter_homepage.jsp").forward(request, response);
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
			HttpSession session = request.getSession();
			Voters currentVoter = (Voters) session.getAttribute("currentVoter");

			Votes vote = new Votes();
			vote.seteId(Integer.parseInt(request.getParameter("e_id")));
			vote.setvId(currentVoter.getId());
			vote.setcId(Integer.parseInt(request.getParameter("options")));
			
			System.out.println("*********vote details: eId:"+vote.geteId()+"/n***vId:"+vote.getvId()+"/n***cId:"+vote.getcId()+"*******");
			
			ResultSet rs = dbDao.query("select * from vote where e_id=? and v_id=?;", vote.geteId(), vote.getvId());
			
			if (!rs.next()) {
				dbDao.insert("insert into vote values(?,?,?)", vote.getvId(),vote.getcId(),vote.geteId());
				request.getRequestDispatcher("WEB-INF/votes/voting_submission_success.jsp").forward(request, response);
			} else {
				request.getRequestDispatcher("WEB-INF/votes/voting_submission_failure.jsp").forward(request, response);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
