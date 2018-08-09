package com.bl.evoting.candidateservlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bl.evoting.bean.Candidates;
import com.bl.evoting.dao.CandidatesDisplayDAO;

/**
 * Servlet implementation class CandidateOperation
 */

public class CandidateList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CandidateList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CandidatesDisplayDAO cDAO= new CandidatesDisplayDAO();
		try {
			ArrayList<Candidates> candidatesList = cDAO.getAllCandidates();
			request.getSession().setAttribute("candidatesList", candidatesList);	
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		request.getRequestDispatcher("/WEB-INF/candidate/candidates_list.jsp").forward(request, response);	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
