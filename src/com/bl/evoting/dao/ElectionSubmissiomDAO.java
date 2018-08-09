package com.bl.evoting.dao;

import java.sql.ResultSet;

public class ElectionSubmissiomDAO {

	public void getLastId() throws Exception {
		DBDao dbDao = new DBDao();
		ResultSet rs = null;

		rs = (ResultSet) dbDao.getLastId("insert into tb2 (username) values(?);", "Clement");
		int autoIncKeyFromApi = -1;

		if (rs.next()) {
			autoIncKeyFromApi = rs.getInt(1);

		}
		rs.close();
		rs = null;
		System.out.println("Key returned from getGeneratedKeys():" + autoIncKeyFromApi);

	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
