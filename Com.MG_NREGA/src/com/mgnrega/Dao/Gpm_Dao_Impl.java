package com.mgnrega.Dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.mgnrega.Dto.CProject_Dto;
import com.mgnrega.Dto.Gpm_Dto;
import com.mgnrega.Dto.Gpm_Dto_impl;
import com.mgnrega.Dto.Users_Dto;
import com.mgnrega.Dto.Worker_Dto;
import com.mgnrega.Dto.Worker_Dto_Impl;
import com.mgnrega.Dto.getWorkerProject_Dto;
import com.mgnrega.Dto.getWorkerProject_Dto_impl;
import com.mgnrega.Exception.NoRecordFoundException;
import com.mgnrega.Exception.SomethingWentWrongException;
import com.mgnrega.Utility.dbUtil;

public class Gpm_Dao_Impl implements Gpm_Dao {
//	login Gpm
	public void Login_Gpm(Users_Dto ud) throws SomethingWentWrongException {

		Connection conn = null;
		try {
			conn = dbUtil.getConnection();
			String query = "Select * from users where username=? And password=? and user_type=? AND is_delete = 0";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, ud.getUsername());
			ps.setString(2, ud.getPassword());
			ps.setString(3, ud.getUsertype());

			ResultSet rs = ps.executeQuery();

			if (rs.isBeforeFirst() && rs.getRow() == 0) {
				System.out.println("User Name And Password are Invalid");
			} else {
				rs.next();
				System.out.println();
			}
		} catch (Exception e) {
			System.out.println(e);
			throw new SomethingWentWrongException("Error occurred while logging in. Please try again later.");
		} finally {
			try {
				dbUtil.cloceConnection(conn);
			} catch (SQLException ex) {

			}
		}
	}

//Add Workers
	public void AddWorkers(Worker_Dto cp) throws SomethingWentWrongException, ClassNotFoundException {

		Connection conn = null;
		try {
			conn = dbUtil.getConnection();
			String query = "INSERT INTO worker(AADHAR_NUMBER, NAME, DOB,GENDER,PANCHAYaT_NAME,DISTRIC,STATE) VALUES (?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, cp.getWaadar());
			ps.setString(2, cp.getWname());
			ps.setDate(3, Date.valueOf(cp.getWdob()));
			ps.setString(4, cp.getWgender());
			ps.setString(5, cp.getPname());
			ps.setString(6, cp.getDistric());
			ps.setString(7, cp.getState());

			ps.executeUpdate();

		} catch (SQLException e) {
			System.out.println(e);
			throw new SomethingWentWrongException("Not able to Add GPM");
		} finally {
			try {
				dbUtil.cloceConnection(conn);
			} catch (SQLException ex) {
				System.out.println("yes!");
			}
		}
	}

//view Worker
	public List<Worker_Dto> ViewWorker(String adhar) throws SomethingWentWrongException, NoRecordFoundException {
		Connection conn = null;
		List<Worker_Dto> list = new ArrayList<>();
		try {
			conn = dbUtil.getConnection();
			String query = "SELECT AADHAR_NUMBER,NAME,DOB,GENDER,PANCHAYAT_NAME,DISTRIC,STATE FROM worker where AADHAR_NUMBER=?";

			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, adhar);
			ResultSet rs = ps.executeQuery();

			if (!rs.next()) {
				throw new NoRecordFoundException("Not Data Found for Aadhar number: " + adhar);

			} else {
				do {
					String a = rs.getString(1);
					String n = rs.getString(2);
					LocalDate dob = rs.getDate(3).toLocalDate();
					String g = rs.getString(4);
					String pn = rs.getString(5);
					String d = rs.getString(6);
					String s = rs.getString(7);

					Worker_Dto_Impl worker = new Worker_Dto_Impl(a, n, dob, g, pn, d, s);
					list.add(worker);
				} while (rs.next());
			}
		} catch (SQLException e) {
			throw new SomethingWentWrongException("Error occurred while trying to retrieve worker details.");
		} finally {
			try {
				dbUtil.cloceConnection(conn);
			} catch (SQLException ex) {
				// ignore exception
			}
		}
		return list;
	}

//	view  name and Worker days and wages
	public List<getWorkerProject_Dto> getWorkerProjects() throws SomethingWentWrongException, NoRecordFoundException {
		Connection conn = null;
		List<getWorkerProject_Dto> list = new ArrayList<>();
		try {
			conn = dbUtil.getConnection();
			String query = "SELECT w.name AS worker_name, SUM(DATEDIFF(p.end_date, p.start_date) + 1) AS total_days_worked FROM worker w JOIN worker_project wp ON w.worker_id = wp.worker_id JOIN project p ON wp.project_id = p.project_id WHERE w.is_delete = 0 AND p.is_delete = 0 GROUP BY w.worker_id; ";
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();

			if (!rs.next()) {
				throw new NoRecordFoundException("Not Data Found for Worker projects ");

			} else {
				do {
						 String n = rs.getString(1);
						    int d = rs.getInt(2);
						    getWorkerProject_Dto dto = new getWorkerProject_Dto_impl(n, d);
						    list.add(dto);

					
				}
				while (rs.next()) ;
			}
		} catch (SQLException e) {
			throw new SomethingWentWrongException("Error occurred while trying to retrieve worker details.");
		} finally {
			try {
				dbUtil.cloceConnection(conn);
			} catch (SQLException ex) {
				// ignore exception
			} finally {
				try {
					dbUtil.cloceConnection(conn);
				} catch (SQLException ex) {

				}
			}
		}
		return list;
	}

//	view  name and wages
	public List<getWorkerProject_Dto> getWorkerwages() throws SomethingWentWrongException, NoRecordFoundException {
		Connection conn = null;
		List<getWorkerProject_Dto> list = new ArrayList<>();
		try {
			conn = dbUtil.getConnection();
			String query = "SELECT w.name AS worker_name, SUM(DATEDIFF(p.end_date, p.start_date) + 1)*p.per_day_wages AS total_Wages "
					+ "FROM worker w JOIN worker_project wp ON w.worker_id = wp.worker_id JOIN project p ON wp.project_id = p.project_id  "
					+ "WHERE w.is_delete = 0 AND p.is_delete = 0 GROUP BY w.worker_id, p.per_day_wages;";
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();

			if (!rs.next()) {
				throw new NoRecordFoundException("Not Data Found for Worker projects ");

			} else {
				do {
						 String n = rs.getString(1);
						   Double d = rs.getDouble(2);
						    getWorkerProject_Dto dto = new getWorkerProject_Dto_impl(n, d);
						    list.add(dto);

					
				}
				while (rs.next()) ;
			}
		} catch (SQLException e) {
			throw new SomethingWentWrongException("Error occurred while trying to retrieve worker details.");
		} finally {
			try {
				dbUtil.cloceConnection(conn);
			} catch (SQLException ex) {
				// ignore exception
			} finally {
				try {
					dbUtil.cloceConnection(conn);
				} catch (SQLException ex) {

				}
			}
		}
		return list;
	}


}
