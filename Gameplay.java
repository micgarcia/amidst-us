public class Gameplay {
  public static void main(String[] args) {
    BlueAstronaut bob = new BlueAstronaut("Bob", 20, 6, 30);
    BlueAstronaut heath = new BlueAstronaut("Heath", 30, 3, 21);
    BlueAstronaut albert = new BlueAstronaut("Albert", 44, 2, 0);
    BlueAstronaut angel = new BlueAstronaut("Angel", 0, 1, 0);

    RedAstronaut liam = new RedAstronaut("Liam", 19, "experienced");
    RedAstronaut susPerson = new RedAstronaut("Suspicious Person", 100, "expert");

    liam.sabotage(bob);
    System.out.println(bob.toString());
    System.out.println();

    liam.freeze(susPerson);
    System.out.println(susPerson.toString());
    System.out.println(liam.toString());
    System.out.println();

    liam.freeze(albert);
    System.out.println(liam.toString());
    System.out.println(albert.toString());
    System.out.println();

    albert.emergencyMeeting();
    System.out.println(albert.toString());
    System.out.println();

    susPerson.emergencyMeeting();
    System.out.println(susPerson.toString());
    System.out.println();

    bob.emergencyMeeting();
    System.out.println(susPerson.toString());
    System.out.println();

    heath.completeTask();
    System.out.println(heath.toString());
    System.out.println();

    heath.completeTask();
    System.out.println(heath.toString());
    System.out.println();

    heath.completeTask();
    System.out.println(heath.toString());
    System.out.println();

    liam.freeze(angel);
    System.out.println(angel.toString());
    System.out.println(liam.toString());
    System.out.println();

    liam.sabotage(bob);
    liam.sabotage(bob);
    System.out.println(bob.toString());
    System.out.println();

    liam.freeze(bob);
    System.out.println(bob.toString());
    System.out.println();

    liam.sabotage(heath);
    liam.sabotage(heath);
    liam.sabotage(heath);
    liam.sabotage(heath);
    liam.sabotage(heath);
    System.out.println(heath.toString());
    System.out.println();

    liam.freeze(heath);
    System.out.println(heath.toString());
    System.out.println();
  }
}
