
package project_management;

import java.util.ArrayList;

public class Task implements Comparable<Task>{
    int projectId;
    int ID;
    ArrayList<Integer> developerIds;
    ArrayList<Integer> testerIds;
    ArrayList<TaskActionLog_> task_logs;
    Date createDate;
    Date endDate;
    String status;

    public Task() {
        developerIds = new ArrayList<>();
        testerIds = new ArrayList<>();
        task_logs = new ArrayList<>();
        createDate = new Date();
        endDate = new Date();
        status = "Create";
        ID = 0;
    }

    public Task(int projectId, ArrayList<Integer> developerIds, ArrayList<Integer> testerIds, Date createDate, Date endDate, String status,int ID,ArrayList<TaskActionLog_> task_logs) {
        this.projectId = projectId;
        this.developerIds = developerIds;
        this.testerIds = testerIds;
        this.task_logs=task_logs;
        this.createDate = createDate;
        this.endDate = endDate;
        this.status = status;
        this.ID = ID;
    }

    public ArrayList<TaskActionLog_> getTask_logs() {
        return task_logs;
    }

    public void setTask_logs(ArrayList<TaskActionLog_> task_logs) {
        this.task_logs = task_logs;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public ArrayList<Integer> getDeveloperIds() {
        return developerIds;
    }

    public void setDeveloperIds(ArrayList<Integer> developerIds) {
        this.developerIds = developerIds;
    }

    public ArrayList<Integer> getTesterIds() {
        return testerIds;
    }

    public void setTesterIds(ArrayList<Integer> testerIds) {
        this.testerIds = testerIds;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
    public String toString(){
        return "Task ( ID = "+ ID+",projectID = "+projectId+",developerIDs = "+developerIds.toString()+",testerIDs = "+testerIds.toString()+
                ", create Date = "+createDate.toString()+", EndDate = "+endDate.toString()+", Status = "+status+" )\n";
    }

    

    @Override
    public int compareTo(Task o) {
        return status.compareTo(o.status);
    }
}
