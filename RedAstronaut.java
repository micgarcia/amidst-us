import java.util.Arrays;

public class RedAstronaut extends Player implements Impostor {
  private String skill;

  // Overloaded constructors
  public RedAstronaut(String name, int susLevel, String skill) {
    super(name, susLevel);
    this.skill = skill.toLowerCase();
  }
  public RedAstronaut(String name) {
    super(name, 15);
    this.skill = "experienced";
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
    System.out.println(players.length);

    // Freeze highest sus level, except if equal highest
    for (int i = 0; i < players.length; i++) {
      if (!players[i].isFrozen()) {
        if (this == players[i]) {
          continue;
        } else if (i == players.length - 1) {
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

  public void freeze(Player p) {
    // Won't freeze if player is frozen or if target is impostor or frozen
    if (p instanceof Impostor) {
      return;
    }
    if (this.isFrozen() || p.isFrozen()) {
      return;
    }
    if (this.getSusLevel() < p.getSusLevel()) {
      p.setFrozen(true);
    } else {
      this.setSusLevel(getSusLevel() * 2);
    }
    gameOver();

  }

  public void sabotage(Player p) {
    // Won't sabotage if player is frozen or if target is impostor or frozen
    if (p instanceof Impostor) {
      return;
    }
    if (this.isFrozen() || p.isFrozen()) {
      return;
    }
    if (this.getSusLevel() < 20) {
      p.setSusLevel((int)(p.getSusLevel() * 1.5));
    } else if (this.getSusLevel() >= 20) {
      p.setSusLevel((int)(p.getSusLevel() * 1.25));
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
    return super.toString();
  }

  public String getSkill() {
    return this.skill;
  }

  public void setSkill(String newSkill) {
    if (newSkill.toLowerCase() == "inexperienced" || newSkill.toLowerCase() == "experienced"
        || newSkill.toLowerCase() == "expert") {
          this.skill = newSkill;
        }
  }

}