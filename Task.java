/**
 * Class for the tasks requried to win the game
 */
public class Task {
  //attributes
  private String description;
  private boolean completed;
  String statusString;

  /**
   * Constructor for the task class
   * @param description what the person needs to do to complete the task
   */
  public Task(String description) {
    this.description = description;
    this.completed = false;
    this.statusString = "X";
  }

  /**
   * Getter for the description of the task
   * @return the description of the task
   */
  public String getDescription() {
    return this.description;
  }
  /**
   * Getter for whether or not the task has been completed
   * @return the boolean indicating whether or not the task has been completed
   */
  public boolean getCompletionStatus() {
    return this.completed;
  }
  /**
   * Setter for whether or not the task has been completed, sets true
   */
  public void setCompletedTrue() {
    this.completed = true;
  }
  /**
   * Setter for whether or not the task has been completed, sets false
   */
  public void setCompletedFalse() {
    this.completed = false;
  }
  /**
   * Returns a string corresponding to whether or not the task has been completed, for printing purposes
   * @return a checkmark string if the task has been completed, and an x if it has not
   */
  public String printStatus() {
    if (this.completed) {
      statusString = "✓";
    } else {
      statusString = "X";
    }
    return statusString;
  }

}