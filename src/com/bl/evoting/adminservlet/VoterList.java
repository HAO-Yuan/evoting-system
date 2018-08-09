package com.bl.evoting.adminservlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bl.evoting.bean.Voters;
import com.bl.evoting.dao.VotersDisplayDAO;

/**
 * Servlet implementation class CandidateOperation
 */

public class VoterList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VoterList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		VotersDisplayDAO vDAO= new VotersDisplayDAO();
		try {
			ArrayList<Voters> voteresList = vDAO.getAllVoters();
			request.getSession().setAttribute("voterList", voteresList);	
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		request.getRequestDispatcher("/WEB-INF/voter/voters_list.jsp").forward(request, response);	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
