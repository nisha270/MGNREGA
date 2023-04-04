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
import com.mgnrega.Dto.Gpm_Dto;
import com.mgnrega.Dto.Gpm_Dto_impl;
import com.mgnrega.Dto.Users_Dto;
import com.mgnrega.Dto.cprojectDto_Impl;
import com.mgnrega.Dto.gpm_project_dto;
import com.mgnrega.Exception.NoRecordFoundException;
import com.mgnrega.Exception.SomethingWentWrongException;
import com.mgnrega.Utility.dbUtil;
import com.mgnrega_Ui.Bdo_Ui;

public class Bdo_Dao_Impl implements Bdo_Dao {
	
//	Login BDO
	public void Login_Bdo(Users_Dto ud) throws SomethingWentWrongException {
		
		Connection conn=null;
		try {
			conn= dbUtil.getConnection();
			String query="Select * from users where username=? And password=? and user_type=? AND is_delete = 0";
			PreparedStatement ps= conn.prepareStatement(query);
			ps.setString(1, ud.getUsername());
			ps.setString(2, ud.getPassword());
			ps.setString(3, ud.getUsertype());
			
			ResultSet rs= ps.executeQuery();
			
			if(!rs.next()) {
				System.out.println("*=*=*=*=User Name And Password are Invalid=*=*=*=*");
				System.out.println();
			}
			
		} catch (Exception e) {
//			System.out.println(e);
			throw new SomethingWentWrongException("Error occurred while logging in. Please try again later.");
		}
		finally {
			try {
				dbUtil.cloceConnection(conn);
			}catch(SQLException ex) {
				
			}
		}
	}
	
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

			if (!rs.next()) {
				throw new NoRecordFoundException("Not Data Found");

			} else {
				while (rs.next()) {
					String pn = rs.getString(1);
					LocalDate sd = rs.getDate(2).toLocalDate();
					LocalDate ed = rs.getDate(3).toLocalDate();
					int wn = rs.getInt(4);
					Double pd = rs.getDouble(5);

					CProject_Dto cp = new cprojectDto_Impl(pn, sd, ed, wn, pd);
					list.add(cp);

				}
			}
		} catch (SQLException e) {
			throw new SomethingWentWrongException("Not able to find Records!");
		}
		return list;
	}

//create New Gpm
	public void addGpm(Gpm_Dto gd) throws SomethingWentWrongException, ClassNotFoundException {

		Connection conn = null;
		PreparedStatement ps=null;
		try {
			conn = dbUtil.getConnection();
			String query = "INSERT INTO GPM(AADHAR_NUMBER, Name, Dob, GENDER, PANCHAYAT_NAME, DISTRIC, STATE) VALUES (?, ?, ?, ?, ?, ?, ?)";
		        ps = conn.prepareStatement(query);
			ps.setString(1, gd.getAadhar_number());
			ps.setString(2, gd.getName());
			ps.setDate(3, Date.valueOf(gd.getDob()));
			ps.setString(4, gd.getGender());
			ps.setString(5, gd.getPanchyatName());
			ps.setString(6, gd.getDistric());
			ps.setString(7, gd.getState());
			ps.executeUpdate();

		} catch (SQLException e) {
//			System.out.println(e);
			throw new SomethingWentWrongException("Not able to Create Project");
		} finally {
			try {
				if(ps!=null)
					ps.close();
				dbUtil.cloceConnection(conn);
			} catch (SQLException ex) {
//				System.out.println(ex);
				throw new SomethingWentWrongException("Not able to Create Project");
			}
		}
	}

//	View all Gpm
	public List<Gpm_Dto> allgpm() throws SomethingWentWrongException, NoRecordFoundException {
		Connection conn = null;
		List<Gpm_Dto> list = new ArrayList<>();
		try {
			conn = dbUtil.getConnection();
			String query = "SELECT AADHAR_NUMBER,NAME,DOB,GENDER,PANCHAYAT_NAME,DISTRIC,STATE FROM gpm";

			
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();

			if (!rs.next()) {
				throw new NoRecordFoundException("Not Data Found");

			} else {
				while (rs.next()) {
					String a = rs.getString(1);
					String n = rs.getString(2);
					LocalDate dob = rs.getDate(3).toLocalDate();
					String g = rs.getString(4);
					
					String pn = rs.getString(5);
					String d = rs.getString(6);
					String s = rs.getString(7);
					

					   Gpm_Dto gd=new Gpm_Dto_impl(a,n,dob,g,pn,d,s);
					list.add(gd);

				}
			}
		} catch (SQLException e) {
			throw new SomethingWentWrongException("Not able to find Records!");
		}
		return list;
	}

//	Allocate a project to a GPM.
	public void AllocateTheProject(gpm_project_dto gp) throws SomethingWentWrongException{
		Connection conn = null;
		try {
			conn=dbUtil.getConnection();
			String query="insert into gpm_project(gpm_id,project_id) values(?,?)";
			PreparedStatement ps=conn.prepareStatement(query);
			ps.setInt(1, gp.getGpmId());
			ps.setInt(2, gp.getProjectId());
			
			int rs=ps.executeUpdate();
			if(rs==0) {
				System.out.println("Not record Found");
			}
			
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("somethinf went wrong");
		}
		finally {
			try {
				dbUtil.cloceConnection(conn);
			} catch (SQLException ex) {
				throw new SomethingWentWrongException("Not able to Create Project");
			}
		}
		
	}
}
