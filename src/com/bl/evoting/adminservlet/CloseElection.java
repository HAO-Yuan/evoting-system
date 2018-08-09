package com.bl.evoting.adminservlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bl.evoting.dao.DBDao;


/**
 * Servlet implementation class VoterHomepage
 */

public class CloseElection extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CloseElection() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub	
		try {
			int eid = Integer.parseInt(request.getParameter("id"));
			DBDao dbDao = new DBDao();
			dbDao.modify("update referendum_election set status=2 where id=?", eid);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		request.getRequestDispatcher("WEB-INF/admin/admin_close_success.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
