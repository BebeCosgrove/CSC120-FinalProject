public class Task{
    //attributes
    private String description;
    private boolean completed;
    String statusString;

    public Task(String description){
        this.description = description;
        this.completed = false;
        this.statusString = "X";
    }

   //getter for description
    public String getDescription(){
        return this.description;
    }
    //getter for completed
    public boolean getCompletionStatus(){
        return this.completed;
    }
    //setter for completed
    public void setCompletedTrue(){
        this.completed = true;
    }
    public void setCompletedFalse(){
        this.completed = false;
    }
    public String printStatus(){
        if(this.completed){
            statusString = "✓";
        } else{
            statusString = "X";
        }
        return statusString;
    }

}