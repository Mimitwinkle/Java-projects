import java.util.*; // Imports classes

class Main {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);  // Creates a Scanner object

    ArrayList<Integer> grades = enter_grades(scan); // Creates Arraylist full of grades from input

    System.out.println("\nAll grades: " + grades);

    int a_grade = average(grades); // Creates variable to contain grade average

    System.out.println("\nGrade average: " + a_grade);

    String l_grade = letter_grade(a_grade); // Creates variable to contain letter grade

    System.out.println("\nLetter grade: " + l_grade);
  }

  public static ArrayList<Integer> enter_grades(Scanner scan) {
    ArrayList<Integer> g = new ArrayList<Integer>(); // Creates empty ArrayList
    System.out.println("\nThis program will compute grade average & return a letter grade.\nYou may enter up to 10 quiz grades. If you have entered all grades, enter 999 to compute.");
    for (int i = 0; i < 10; i++) {
      // Requests up to 10 quiz grades
      System.out.println("\nEnter a quiz grade:");
      String input = scan.nextLine(); // Receives input
      try { // Checks whether input is integer or not
        Integer.parseInt(input);
      }
      catch (NumberFormatException ex) {
        // Notifies user if input is not an integer
        System.out.println("Quiz grades must be integers.");
        i--; // Decrements counter so user can still enter 10 grades
        continue;
      }
      if (Integer.parseInt(input) == 999) { // Exits if user enters 999
        return g;
      }
      else if (Integer.parseInt(input) > 100 | Integer.parseInt(input) < 0) { // Notifies user if input is not in range
        System.out.println("Quiz grades must be in the range of 0-100.");
        i--; // Decrements counter so user can still enter 10 grades
        continue;
      }
      g.add(Integer.parseInt(input)); // Adds grade to ArrayList
    }
    return g;
  }

  public static int average(ArrayList<Integer> g) {
    int sum = 0;
    int a = 0;
    for(int i = 0; i < g.size(); i++) {
      // Loops through ArrayList to add each element & divides sum by array size to compute average
      sum += g.get(i);
      a = sum / g.size();
    }
    return a;
  }

  public static String letter_grade(int a) {
    String letter = null; // Creates null variable for letter
    if (a > 89 & a < 101) { // If average grade is 90-100, grade is A
      letter = "A";
    }
    else if (a > 79 & a < 90) { // If average grade is 80-89, grade is B
      letter = "B";
    }
    else if (a > 69 & a < 80) { // If average grade is 70-79, grade is C
      letter = "C";
    }
    else if (a > 59 & a < 70) { // If average grade is 60-69, grade is D
      letter = "D";
    }
    else if (a < 60) { // If average grade is below 60, grade is F
      letter = "F";
    }
    return letter;
  }

}// End Main