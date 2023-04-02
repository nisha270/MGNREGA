package com.mgnrega.Dao;

import java.util.List;

import com.mgnrega.Dto.Gpm_Dto;
import com.mgnrega.Dto.Users_Dto;
import com.mgnrega.Dto.Worker_Dto;
import com.mgnrega.Dto.getWorkerProject_Dto;
import com.mgnrega.Exception.NoRecordFoundException;
import com.mgnrega.Exception.SomethingWentWrongException;

public interface Gpm_Dao {
	public void Login_Gpm(Users_Dto ud) throws SomethingWentWrongException;
	public void AddWorkers(Worker_Dto cp) throws SomethingWentWrongException, ClassNotFoundException;
	public List<Worker_Dto> ViewWorker(String adhar)throws SomethingWentWrongException, NoRecordFoundException;
	public List<getWorkerProject_Dto> getWorkerProjects() throws SomethingWentWrongException, NoRecordFoundException;
	public List<getWorkerProject_Dto> getWorkerwages() throws SomethingWentWrongException, NoRecordFoundException;
}
