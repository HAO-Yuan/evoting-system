package com.bl.evoting.candidateservlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bl.evoting.bean.Candidates;
import com.bl.evoting.bean.CandidatesSet;
import com.bl.evoting.dao.CandidatesDisplayDAO;

/**
 * Servlet implementation class CandidateOperation
 */

public class CandidateOperation extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private String action;
	
	private CandidatesDisplayDAO cDAO = new CandidatesDisplayDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CandidateOperation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		
		if(request.getParameter("action") != null) {
			action = request.getParameter("action");
			if("add".equals(action)) {
				try {
					if(addToList(request,response)) {
						request.getRequestDispatcher("/WEB-INF/candidate/add_success.jsp").forward(request, response);
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if("show".equals(action)) {
				
				request.getRequestDispatcher("/WEB-INF/candidate/candidates_set.jsp").forward(request, response);
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
	
	private boolean addToList(HttpServletRequest request, HttpServletResponse response) throws NumberFormatException, Exception {
		String id = request.getParameter("id");
		CandidatesSet candidatesSet;
		Candidates candidate = cDAO.getCandidateById(Integer.parseInt(id));
		
		if(request.getSession().getAttribute("candidatesSet") == null) {
			candidatesSet = new CandidatesSet();
			request.getSession().setAttribute("candidatesSet", candidatesSet);
		}
		candidatesSet = (CandidatesSet) request.getSession().getAttribute("candidatesSet");
		
		if(candidatesSet.addCandidates(candidate)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	

}
