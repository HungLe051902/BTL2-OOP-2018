
package project_management;

public class TaskActionLog_ {
    String status;
    Date date;
    int ID_task;

    public int getID_task() {
        return ID_task;
    }

    public void setID_task(int ID_task) {
        this.ID_task = ID_task;
    }

    public TaskActionLog_() {
        status = "Created";
        date = new Date();
    }

    
    public TaskActionLog_(String status, Date date) {
        this.status = status;
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    public String toString(){
        return "  -  Status : "+status + ", Update : "+date.toString()+"\n";
    }
}
