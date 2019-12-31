import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
import java.lang.String;

public class SecurityCheckDriver {

    public static void main(String[] args) throws personNotFoundException{
        SecurityCheck sc = new SecurityCheck();

        System.out.println("The following options are available to you:\n");
        System.out.println("A) Add the persons in the lines");
        System.out.println("R) Remove persons from the lines");
        System.out.println("P) Print the lines");
        System.out.println("PR) Print the lines in reverse order");
        System.out.println("Q) Close the Security Check application");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            String userInput = scanner.nextLine();

            switch (userInput) {
                case "a":
                case "A":
                    System.out.println("Please provide the number of people:");
                    int number = scanner.nextInt();
                    for (int i=0; i<number; i++){
                        scanner.nextLine(); //TEST IF THIS SHOULD BE TAKEN OUT
                        String temp[] = scanner.nextLine().split(" ");
                        String name = temp[0].trim();
                        String ticketNoString = temp[1].trim();
                        int ticketNo = Integer.parseInt(ticketNoString);
                        Person newPerson = new Person(name, ticketNo);
                        sc.addPerson(newPerson);
                        System.out.println("PERSON HAS BEEN ADDED");
                    }
                    break;
                case "r":
                case "R":
                    System.out.println("Please provide the number of people:");
                    int number2 = scanner.nextInt();
                    for (int i=0;i<number2; i++){
                        int ticketNo2 = scanner.nextInt();
                        String name2 =sc.findPerson(ticketNo2);
                        Person personN = new Person(name2, ticketNo2);
                        try { sc.removePerson(personN);
                        } catch(Exception personNotFoundException){
                            throw new personNotFoundException();
                        }
                        System.out.println("PERSON HAS BEEN REMOVED");
                    }
//                    List<Person> removePersonList = new ArrayList<>();
//                    for (int j=0; j<number2;j++){
//                        //I read in the persons ticket number
//                        String ticketNoTemp = scanner.nextLine().trim();
//                        int ticketNo = Integer.parseInt(ticketNoTemp);
//
//                        String nameN;
//                        //I find the name of that person
//                        try {
//                            nameN  = sc.findPerson(ticketNo);
//                        } catch(Exception personNotFoundException){
//                            throw new personNotFoundException();
//                        }
//                        System.out.println("THIS IS THE VALUE OF NAMEN: " + nameN);
//                        //I create an instance of a Person with the parameters name and ticketNo
//                        Person newPerson = new Person(nameN, ticketNo);
//
//                        //I add it to the remove person list
//                        removePersonList.add(newPerson);
//                        System.out.println("REMOVING PERSONA");
//                    }
//                    try {
//                        //I remove the people in the list provided
//                        sc.removePerson(removePersonList);
//                    } catch (Exception personNotFoundException){
//                        throw new personNotFoundException();
//                    }
                    break;
                case "p":
                case "P":
                    sc.printSecurityCheck();

                    break;
                case "pr":
                case "PR":
                    sc.printReverse();
                    break;
                case "q":
                case "Q":
                    System.exit(0);
                    break;
                default:
                    System.out.println("That is not an option, please try again.");
                    break;
            }
        }

    }
}
