package com.mgnrega.Dto;

public class gpm_project_Dto {
	 private int gpmId;
	    private int projectId;
		public gpm_project_Dto(int gpmId, int projectId) {
			super();
			this.gpmId = gpmId;
			this.projectId = projectId;
		}
		public gpm_project_Dto() {
			super();
		}
		public int getGpmId() {
			return gpmId;
		}
		public void setGpmId(int gpmId) {
			this.gpmId = gpmId;
		}
		public int getProjectId() {
			return projectId;
		}
		public void setProjectId(int projectId) {
			this.projectId = projectId;
		}
	    
}
