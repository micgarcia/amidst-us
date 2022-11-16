import java.util.Arrays;

public class BlueAstronaut extends Player implements Crewmate {
  private int numTasks;
  private int taskSpeed;

  // Overloaded constructors
  public BlueAstronaut(String name, int susLevel, int numTasks, int taskSpeed) {
    super(name, susLevel);
    this.numTasks = numTasks;
    if (taskSpeed > 0) {
      this.taskSpeed = taskSpeed;
    }
  }
  public BlueAstronaut(String name) {
    super(name, 15);
    this.numTasks = 6;
    this.taskSpeed = 10;
  }

  // Methods
  public void emergencyMeeting() {
    if (this.isFrozen()) {
      return;
    }

    // Get players array, sort highest sus level using overriden compareTo()
    Player[] players = getPlayers();
    Arrays.sort(players);
    players = getPlayers();

    // Freeze highest sus level, except if tie
    for (int i = 0; i < players.length; i++) {
      if (!players[i].isFrozen()) {
        if (i == players.length - 1) {
          players[i].setFrozen(true);
        } else if (players[i].getSusLevel() == players[i+1].getSusLevel()) {
          return;
        } else {
          players[i].setFrozen(true);
        }
      }
    }

    gameOver();
  }

  // If unfrozen, completes tasks based on taskSpeed
  public void completeTask() {
    if (this.isFrozen()) {
      return;
    }
    if (this.numTasks == 0) {
      return;
    }
    if (this.taskSpeed > 20) {
      this.numTasks -= 2;
    } else {
      this.numTasks -= 1;
    }
    if (numTasks < 0) {
      numTasks = 0;
      System.out.println("I have completed all my tasks.");
      this.setSusLevel((int)(getSusLevel() * 0.50));
    }
  }

  public boolean equals(Object o) {
    if (this.equals(o)) {
      return true;
    } else {
      return false;
    }
  }

  public String toString() {
    if (this.getSusLevel() > 15) {
      return (super.toString() + " I have " + this.getNumTasks() + " left over.").toUpperCase();
    }
    return super.toString() + " I have " + this.getNumTasks() + " left over.";
  }

  public int getNumTasks() {
    return numTasks;
  }

  public int getTaskSpeed() {
    return taskSpeed;
  }
}