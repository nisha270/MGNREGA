package com.mgnrega.Dto;

public class worker_project_Dto {
	 private int workerId;
	    private int projectId;
		public worker_project_Dto(int workerId, int projectId) {
			super();
			this.workerId = workerId;
			this.projectId = projectId;
		}
		public worker_project_Dto() {
			super();
		}
		public int getWorkerId() {
			return workerId;
		}
		public void setWorkerId(int workerId) {
			this.workerId = workerId;
		}
		public int getProjectId() {
			return projectId;
		}
		public void setProjectId(int projectId) {
			this.projectId = projectId;
		}
	    
}
