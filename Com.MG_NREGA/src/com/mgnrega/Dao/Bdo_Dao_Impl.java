package com.mgnrega.Dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.mgnrega.Dto.CProject_Dto;
import com.mgnrega.Dto.cprojectDto_Impl;
import com.mgnrega.Exception.NoRecordFoundException;
import com.mgnrega.Exception.SomethingWentWrongException;
import com.mgnrega.Utility.dbUtil;

public class Bdo_Dao_Impl implements Bdo_Dao {
//	create Project
	public void CreateProject(CProject_Dto cp) throws SomethingWentWrongException, ClassNotFoundException {

		Connection conn = null;
		try {
			conn = dbUtil.getConnection();
			String query = "INSERT INTO PROJECT(PROJECT_NAME, START_DATE, END_DATE,WORKERS_NUMBER,PER_DAY_WAGES) VALUES (?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, cp.getProjectName());
			ps.setDate(2, Date.valueOf(cp.getStartDate()));
			ps.setDate(3, Date.valueOf(cp.getEndDate()));
			ps.setInt(4, cp.getNumberOfWorkers());
			ps.setDouble(5, cp.getPerDayWages());

			ps.executeUpdate();

		} catch (SQLException e) {
			throw new SomethingWentWrongException("Not able to Create Project");
		} finally {
			try {
				dbUtil.cloceConnection(conn);
			} catch (SQLException ex) {
				System.out.println("yes!");
			}
		}
	}

//	 gell all project
	public List<CProject_Dto> allProject() throws SomethingWentWrongException, NoRecordFoundException {
		Connection conn = null;
		List<CProject_Dto> list = new ArrayList<>();
		try {
			conn = dbUtil.getConnection();
			String query = "SELECT PROJECT_NAME,  START_DATE, END_DATE, WORKERS_NUMBER, PER_DAY_WAGES FROM PROJECT";

			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			
			if (rs.isBeforeFirst() && rs.getRow() == 0) {
				throw new NoRecordFoundException("Not Data Found");
			} else {
				while (rs.next()) {
					String pn = rs.getString(1);
					LocalDate sd = rs.getDate(2).toLocalDate();
					LocalDate ed = rs.getDate(2).toLocalDate();
					int wn = rs.getInt(4);
					Double pd = rs.getDouble(5);

					CProject_Dto cp=new cprojectDto_Impl(pn, sd, ed, wn, pd);
					list.add(cp);

				}
			}
		} catch (SQLException e) {
			throw new SomethingWentWrongException("Not able to find Records!");
		}
		return list;

	}

}
