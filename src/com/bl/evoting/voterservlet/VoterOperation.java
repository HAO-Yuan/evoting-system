package com.bl.evoting.voterservlet;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bl.evoting.bean.Voters;
import com.bl.evoting.dao.VotersDisplayDAO;

/**
 * Servlet implementation class CandidateOperation
 */

public class VoterOperation extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private String action;
	
	private VotersDisplayDAO cDAO = new VotersDisplayDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VoterOperation() {
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
							//////attention	path					
						request.getRequestDispatcher("/WEB-INF/candidate/add_success.jsp").forward(request, response);
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if("show".equals(action)) {
				
				request.getRequestDispatcher("/WEB-INF/voter/voters_set.jsp").forward(request, response);
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
	
	@SuppressWarnings("unchecked")
	private boolean addToList(HttpServletRequest request, HttpServletResponse response) throws NumberFormatException, Exception {
		String id = request.getParameter("id");
		Set<Voters> votersSet;
		Voters voter = cDAO.getVoterById(Integer.parseInt(id));
		
		if(request.getSession().getAttribute("votersListForAddToElection") == null) {
			votersSet = new HashSet<Voters>();
			request.getSession().setAttribute("votersListForAddToElection", votersSet);
		}
		votersSet = (Set<Voters>) request.getSession().getAttribute("votersListForAddToElection");
		
		if(votersSet.add(voter)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	

}
