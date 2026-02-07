package miniproject;

import java.util.ArrayList;
import java.util.Scanner;



public class FitnessTracker {
	
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Exercise> exercises = new ArrayList<>();

    static int getRate(String exercise) {
        switch (exercise.toLowerCase()) {
            case "running": return 10;
            case "walking": return 5;
            case "cycling": return 8;
            default: return 6;}}

    static void addExercise() {
        System.out.print("Enter exercise name: ");
        String name = sc.next();
        System.out.print
        ("Enter duration (minutes): ");
        int duration = sc.nextInt();

        int rate = getRate(name);
        exercises.add(new Exercise(name, duration, rate));

        System.out.println("Exercise added successfully!");
    }

    static void editExercise() {
        System.out.print("Enter exercise number to edit: ");
        int index = sc.nextInt() - 1;

        if (index >= 0 && index < exercises.size()) {
            System.out.print
            ("Enter new duration: ");
            int duration = sc.nextInt();
            int rate = getRate(exercises.get(index).name);
            exercises.get(index).duration = duration;
            exercises.get(index).calories = duration * rate;
            System.out.println("Exercise updated!");
        } else {
            System.out.println("Invalid exercise number");
        }
    }

    static void removeExercise() {
        System.out.print("Enter exercise number to remove: ");
        int index = sc.nextInt() - 1;

        if (index >= 0 && index < exercises.size()) {
            exercises.remove(index);
            System.out.println("Exercise removed!");
        } else {
            System.out.println("Invalid exercise number");
        }
    }

    static void dailyReport() {
        int totalCalories = 0;
        System.out.println("\n--- Daily Fitness Report ---");
        for (int i = 0; i < exercises.size(); i++) {
            Exercise e = exercises.get(i);
            System.out.println((i + 1) + ". " + e.name +
                    " - " + e.duration + " mins - " +
                    e.calories + " calories");
            totalCalories += e.calories;
        }
        System.out.println("Total Calories Burned Today: " + totalCalories);
    }
   static void weeklySummary() {
        int weeklyCalories = 0;
        for (Exercise e : exercises) {
            weeklyCalories += e.calories;
        }
        System.out.println("\n--- Weekly Summary ---");
        System.out.println("Total Calories Burned This Week: " + weeklyCalories);
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- Fitness Tracker Menu ---");
            System.out.println("1. Add Exercise");
            System.out.println("2. Edit Exercise");
            System.out.println("3. Remove Exercise");
            System.out.println("4. Daily Report");
            System.out.println("5. Weekly Summary");
            System.out.println("6. Exit");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1: addExercise(); break;
                case 2: editExercise(); break;
                case 3: removeExercise(); break;
                case 4: dailyReport(); break;
                case 5: weeklySummary(); break;
                case 6:
                    System.out.println("Thank you! Stay Fit 💪");
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}

