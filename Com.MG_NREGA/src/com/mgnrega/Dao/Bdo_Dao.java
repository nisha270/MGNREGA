package com.mgnrega.Dao;

import java.util.List;

import com.mgnrega.Dto.CProject_Dto;
import com.mgnrega.Dto.Gpm_Dto;
import com.mgnrega.Dto.gpm_project_dto;
import com.mgnrega.Exception.NoRecordFoundException;
import com.mgnrega.Exception.SomethingWentWrongException;

public interface Bdo_Dao {
	public void CreateProject(CProject_Dto cp)throws SomethingWentWrongException, ClassNotFoundException;
	public  List<CProject_Dto> allProject() throws SomethingWentWrongException, NoRecordFoundException;
	public void addGpm(Gpm_Dto gd) throws SomethingWentWrongException, ClassNotFoundException;
	public List<Gpm_Dto> allgpm() throws SomethingWentWrongException, NoRecordFoundException;
	public void AllocateTheProject(gpm_project_dto gp) throws SomethingWentWrongException;
	
	
	
}
