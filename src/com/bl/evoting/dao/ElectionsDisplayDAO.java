package com.bl.evoting.dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.bl.evoting.bean.Candidates;
import com.bl.evoting.bean.ReferendumElections;

public class ElectionsDisplayDAO {

	public ArrayList<ReferendumElections> getAllElections() throws Exception {
		DBDao dbDao = new DBDao();
		ResultSet rs = null;
		ArrayList<ReferendumElections> electionsList = new ArrayList<ReferendumElections>();

		try {

			rs = dbDao.query("select * from referendum_election;");

			while (rs.next()) {
				ReferendumElections election = new ReferendumElections();
				election.setId(rs.getInt("id"));
				election.setTitle(rs.getString("title"));
				election.setLocation(rs.getInt("location"));
				election.setDescription(rs.getString("description"));
				election.setOptions(rs.getInt("options"));

				electionsList.add(election);
			}
			return electionsList;
		} catch (Exception ex) {
			// TODO: handle exception
			ex.printStackTrace();
			return null;
		} finally {
			if (rs != null) {
				try {
					rs.close();
					rs = null;
				} catch (Exception ex) {
					// TODO: handle exception
					ex.printStackTrace();
				}
			}

			try {
				dbDao.finalize();
			} catch (Exception ex) {
				// TODO: handle exception
				ex.printStackTrace();
			}

		}
	}

	public ReferendumElections getElectionById(int id) throws Exception {
		DBDao dbDao = new DBDao();
		ResultSet rs = null;

		try {
			rs = dbDao.query("select * from referendum_election where id = ?;", id);

			if (rs.next()) {
				ReferendumElections election = new ReferendumElections();
				election.setId(rs.getInt("id"));
				election.setTitle(rs.getString("title"));
				election.setLocation(rs.getInt("location"));
				election.setDescription(rs.getString("description"));
				election.setOptions(rs.getInt("options"));

				return election;
			} else {
				return null;
			}
		} catch (Exception ex) {
			// TODO: handle exception
			ex.printStackTrace();
			return null;
		} finally {
			if (rs != null) {
				try {
					rs.close();
					rs = null;
				} catch (Exception ex) {
					// TODO: handle exception
					ex.printStackTrace();
				}
			}

			try {
				dbDao.finalize();
			} catch (Exception ex) {
				// TODO: handle exception
				ex.printStackTrace();
			}
		}
	}
	
	public ArrayList<ReferendumElections> getFutureElections() throws Exception {
		DBDao dbDao = new DBDao();
		ResultSet rs = null;
		ArrayList<ReferendumElections> votedElectionsList = new ArrayList<ReferendumElections>();
		
		try {
			rs = dbDao.query("select id,title,location,description from referendum_election where status=0;");

			while (rs.next()) {
				ReferendumElections election = new ReferendumElections();
				election.setId(rs.getInt("id"));
				election.setTitle(rs.getString("title"));
				election.setLocation(rs.getInt("location"));
				election.setDescription(rs.getString("description"));

				votedElectionsList.add(election);
			}
			return votedElectionsList;
		} catch (Exception ex) {
			// TODO: handle exception
			ex.printStackTrace();
			return null;
		} finally {
			if (rs != null) {
				try {
					rs.close();
					rs = null;
				} catch (Exception ex) {
					// TODO: handle exception
					ex.printStackTrace();
				}
			}

			try {
				dbDao.finalize();
			} catch (Exception ex) {
				// TODO: handle exception
				ex.printStackTrace();
			}

		}
	}

	public ArrayList<ReferendumElections> getVotedElections(int id) throws Exception {
		DBDao dbDao = new DBDao();
		ResultSet rs = null;
		ArrayList<ReferendumElections> votedElectionsList = new ArrayList<ReferendumElections>();
		
		try {
////////////todo
			rs = dbDao.query("SELECT * "
							+ "FROM  referendum_election re"
							+ "join vote v on re.id = v.e_id"
							+ "join voter vo on vo.id = v.v_id"
							+ "join candidate can on can.id= v.c_id"
							+ "where vo.id=?;",id );

			while (rs.next()) {
				ReferendumElections election = new ReferendumElections();
				Candidates candidate = new Candidates();
				election.setId(rs.getInt("id"));
				election.setTitle(rs.getString("title"));
				election.setLocation(rs.getInt("location"));
				election.setDescription(rs.getString("description"));
				election.setOptions(rs.getInt("options"));
				
				candidate.setId(rs.getInt("id"));
				candidate.setName(rs.getString("name"));

				votedElectionsList.add(election);
			}
			return votedElectionsList;
		} catch (Exception ex) {
			// TODO: handle exception
			ex.printStackTrace();
			return null;
		} finally {
			if (rs != null) {
				try {
					rs.close();
					rs = null;
				} catch (Exception ex) {
					// TODO: handle exception
					ex.printStackTrace();
				}
			}

			try {
				dbDao.finalize();
			} catch (Exception ex) {
				// TODO: handle exception
				ex.printStackTrace();
			}

		}
	}
	
	public ArrayList<ReferendumElections> getClosedElections() throws Exception {
		DBDao dbDao = new DBDao();
		ResultSet rs = null;
		ArrayList<ReferendumElections> votedElectionsList = new ArrayList<ReferendumElections>();
		
		try {
			rs = dbDao.query("select id,title,location,description from referendum_election where status=2;");

			while (rs.next()) {
				ReferendumElections election = new ReferendumElections();
				election.setId(rs.getInt("id"));
				election.setTitle(rs.getString("title"));
				election.setLocation(rs.getInt("location"));
				election.setDescription(rs.getString("description"));

				votedElectionsList.add(election);
			}
			return votedElectionsList;
		} catch (Exception ex) {
			// TODO: handle exception
			ex.printStackTrace();
			return null;
		} finally {
			if (rs != null) {
				try {
					rs.close();
					rs = null;
				} catch (Exception ex) {
					// TODO: handle exception
					ex.printStackTrace();
				}
			}

			try {
				dbDao.finalize();
			} catch (Exception ex) {
				// TODO: handle exception
				ex.printStackTrace();
			}

		}
	}
	
	public ArrayList<ReferendumElections> getOpenedElections() throws Exception {
		DBDao dbDao = new DBDao();
		ResultSet rs = null;
		ArrayList<ReferendumElections> votedElectionsList = new ArrayList<ReferendumElections>();
		
		try {
			rs = dbDao.query("select id,title,location,description from referendum_election where status=1;");

			while (rs.next()) {
				ReferendumElections election = new ReferendumElections();
				election.setId(rs.getInt("id"));
				election.setTitle(rs.getString("title"));
				election.setLocation(rs.getInt("location"));
				election.setDescription(rs.getString("description"));

				votedElectionsList.add(election);
			}
			return votedElectionsList;
		} catch (Exception ex) {
			// TODO: handle exception
			ex.printStackTrace();
			return null;
		} finally {
			if (rs != null) {
				try {
					rs.close();
					rs = null;
				} catch (Exception ex) {
					// TODO: handle exception
					ex.printStackTrace();
				}
			}

			try {
				dbDao.finalize();
			} catch (Exception ex) {
				// TODO: handle exception
				ex.printStackTrace();
			}

		}
	}
	
	public ArrayList<ReferendumElections> getElectionsByVid(int vId) throws Exception {
		DBDao dbDao = new DBDao();
		ResultSet rs = null;
		ArrayList<ReferendumElections> votedElectionsList = new ArrayList<ReferendumElections>();
		
		try {
			rs = dbDao.query("select id,title,location,description,options,status from referendum_election re "
							 + "join admin_voter_election_relation aver on aver.e_id=re.id "
							 + "where aver.v_id = ? and re.status = 1;",vId);

			while (rs.next()) {
				ReferendumElections election = new ReferendumElections();
				election.setId(rs.getInt("id"));
				election.setTitle(rs.getString("title"));
				election.setLocation(rs.getInt("location"));
				election.setDescription(rs.getString("description"));

				votedElectionsList.add(election);
			}
			return votedElectionsList;
		} catch (Exception ex) {
			// TODO: handle exception
			ex.printStackTrace();
			return null;
		} finally {
			if (rs != null) {
				try {
					rs.close();
					rs = null;
				} catch (Exception ex) {
					// TODO: handle exception
					ex.printStackTrace();
				}
			}

			try {
				dbDao.finalize();
			} catch (Exception ex) {
				// TODO: handle exception
				ex.printStackTrace();
			}

		}
	}
	
}
