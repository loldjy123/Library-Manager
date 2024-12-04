import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.FileWriter;

import java.util.List;

public class Main {

    public static ArrayList<User> read_file() throws FileNotFoundException{
        BufferedReader users_data = new BufferedReader(new FileReader("database.csv"));

        ArrayList <User> user_data = new ArrayList<>();

        String line2;
        String emp_id;
        String auth_name;
        String book_status;
        try{
            while ((line2 = users_data.readLine()) != null){
                int current_index;

                current_index = line2.indexOf(",");

                emp_id = line2.substring(0, current_index).trim();
                line2 = line2.substring(current_index + 1).trim();

                // Extract height
                current_index = line2.indexOf(",");

                auth_name = line2.substring(0, current_index).trim();
                line2 = line2.substring(current_index + 1).trim();

                // Extract publisher (the rest of the line)
                book_status = line2.trim();

                user_data.add(new User(emp_id,auth_name,book_status));


            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return user_data;

    }

    public static void remove_data(int lineToRemove) {
        List<String> lines = new ArrayList<>();


        try (BufferedReader reader = new BufferedReader(new FileReader("database.csv"))) {
            String line;
            int currentLine = 1;

            while ((line = reader.readLine()) != null) {
                if (currentLine != lineToRemove) {
                    lines.add(line);
                }
                currentLine++;
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
            return;
        }


        try (BufferedWriter writer = new BufferedWriter(new FileWriter("database.csv"))) {
            for (String line : lines) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error writing to the file: " + e.getMessage());
        }


    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(System.in);

        BufferedReader booksdata = new BufferedReader(new FileReader("books.csv"));


        Book[] book_list = new Book[502];

        String line;
        int i = 0;

        try {
            while ((line = booksdata.readLine()) != null) {
                int current_index;

                // Check if the line is not empty
                if (line.trim().isEmpty()) {
                    continue; // Skip empty lines
                }

                // Extract title
                current_index = line.indexOf(",");
                String title = line.substring(0, current_index).trim();
                line = line.substring(current_index + 1).trim();

                // Extract first name
                current_index = line.indexOf(",");
                String firstName = line.substring(0, current_index).trim();
                line = line.substring(current_index + 1).trim();

                // Extract last name
                current_index = line.indexOf(",");

                String lastName = line.substring(0, current_index).trim();
                line = line.substring(current_index + 1).trim();

                // Extract genre
                current_index = line.indexOf(",");

                String genre = line.substring(0, current_index).trim();
                line = line.substring(current_index + 1).trim();

                // Extract height
                current_index = line.indexOf(",");

                String height = line.substring(0, current_index).trim();
                line = line.substring(current_index + 1).trim();

                // Extract publisher (the rest of the line)
                String pub = line.trim();

                // Create a new Book object with separated author names
                book_list[i] = new Book(title, firstName, lastName, genre, height, pub, i);
                i++;

                // Display each book for verification

            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                booksdata.close();
            } catch (IOException e) {
                System.out.println("Error closing file: " + e.getMessage());
            }
        }



        // these are the functions to display and compare

        int choice = 0;
        int comp1, comp2; // variable to compare 2 books
        System.out.println("----    Welcome to our library                ----");
        System.out.println("----    We have " + i + " books in our database     ----");

        do {
            System.out.println();
            System.out.println("1- See all the books");
            System.out.println("2- Borrow a book");
            System.out.println("3- Return a book");
            System.out.println("4- Exit");

            boolean error_checker = true;

            while (error_checker){
                try{
                    choice = input.nextInt();
                    error_checker = false;
                }catch (InputMismatchException e){
                    System.out.println("Wrong input, try again");
                    input.next();
                }
            }




            if (choice < 1 || choice > 4){
                // check to see if the user choose a number in the menu
                System.out.println("Wrong choice");
            }


            if (choice == 1){

                /*
                In the section, we will show the entire books that we have in our database in alphabetic order

                 */
                String[] alphabetArray = {
                        "A", "B", "C", "D", "E", "F", "G", "H", "I", "J",
                        "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T",
                        "U", "V", "W", "X", "Y", "Z", "1"
                };

                for( int al = 0; al < 27; al++){

                    System.out.println(alphabetArray[al]);

                    for( int c = 0; c < i; c++){
                        if(alphabetArray[al].equals(book_list[c].getTitle().substring(0,1))){
                            book_list[c].display();
                            System.out.println();

                        }
                    }
                }
            }

            if (choice == 2) {

                System.out.println("Choose an option");

                System.out.println("1-EBook");
                System.out.println("2-Physical Book");

                int type_b = 0;

                // checking for error
                error_checker = true;
                while (error_checker){
                    try{
                        type_b = input.nextInt();
                        if (type_b == 1 || type_b == 2){
                            error_checker = false;
                        }else {
                            System.out.println("Wrong choice! choose again");
                        }
                    }catch (InputMismatchException e){
                        System.out.println("Wrong input! try again");
                        input.next();
                    }
                }



                System.out.println();

                System.out.println("1-Search by book's title");
                System.out.println("2-Search by Author's first name.");
                System.out.println("3-Search by Author's last name.");
                System.out.println("4-Search by book's genre");
                System.out.println("5-Search by publisher's name:");




                int pick = 0;

                // checking for error
                error_checker = true;
                while (error_checker){
                    try{
                        pick = input.nextInt();

                        // checking to see if the user input a number between 1 to 6
                        if (pick >= 1 && pick <= 5){
                            error_checker = false;
                        }else{
                            System.out.println("Wrong choice! choose again");
                        }

                    }catch (InputMismatchException e){
                        System.out.println("Wrong input! try again");
                        input.next();
                    }
                }



                if (pick == 1) {

                    System.out.println("Enter the book's title:");


                    String str = input.next().toUpperCase();
                    int str_len = str.length();


                    for (int j = 1; j < i; j++) {
                        if (str.equals(book_list[j].getTitle().substring(0, str_len))) {
                            System.out.println("The book location is: " + book_list[j].getLocation());
                            book_list[j].display();
                            System.out.println();
                        }

                    }


                }

                if (pick == 2) {
                    System.out.println("Enter the author first name:");

                    String str1 = input.next().toUpperCase();
                    int str_len1 = str1.length();


                    for (int j = 1; j < i; j++) {
                        if (str1.equals(book_list[j].getFirst().substring(0, str_len1))) {
                            System.out.println("The book location is: " + book_list[j].getLocation());
                            book_list[j].display();
                            System.out.println();
                        }

                    }

                }

                if (pick == 3) {
                    System.out.println("Enter the author's last name :");
                    String str2 = input.next().toUpperCase();
                    int str_len2 = str2.length();
                    for (int j = 1; j < i; j++) {
                        if (str2.equals(book_list[j].getLast().substring(0, str_len2))) {
                            System.out.println("The book location is: " + book_list[j].getLocation());
                            book_list[j].display();
                            System.out.println();
                        }
                    }
                }

                if (pick == 4) {
                    System.out.println("Enter the book's genre:");
                    String str3 = input.next().toUpperCase();
                    int str_len3 = str3.length();
                    for (int j = 1; j < i; j++) {
                        if (str3.equals(book_list[j].getGenre().substring(0, str_len3))) {
                            System.out.println("The book location is: " + book_list[j].getLocation());
                            book_list[j].display();
                            System.out.println();
                        }
                    }
                }

                if (pick == 5) {
                    System.out.println("Enter the publisher's name:");
                    String str4 = input.next().toUpperCase();
                    int str_len4 = str4.length();
                    for (int j = 1; j < i; j++) {
                        if (str4.equals(book_list[j].getPublisher().substring(0, str_len4))) {
                            System.out.println("The book location is: " + book_list[j].getLocation());
                            book_list[j].display();
                            System.out.println();
                        }
                    }
                }

                //  to know if the user want to continue or look for another book
                System.out.println();
                System.out.println("Do you want to continue ? (y/n)");
                String answer1 = input.next();

                if (answer1.toLowerCase().equals("y")) {
                    System.out.println();
                    System.out.println("Enter your EmplID: ");
                    String emplID = input.next();

                    int book_location = -1;
                    error_checker = true;
                    while (error_checker){
                        try{
                            System.out.println("Enter the book location: ");
                            book_location = input.nextInt();
                            if (book_location > 0 && book_location < 501) {
                                error_checker = false;
                            }else{
                                System.out.println("Wrong choice! choose between 1 t0 501");
                            }


                        }catch (InputMismatchException e){
                            System.out.println("Wrong input, try again");
                            input.next();
                        }
                    }

                    ArrayList<User> get_user = read_file();



                    boolean found = false;


                    if (type_b == 2) {
                        try (BufferedWriter data = new BufferedWriter(new FileWriter("database.csv", true))) {

                            //int z = 0;
                            for (int z = 0; z < get_user.size(); z++) {


                                if (get_user.get(z).getEmplId().equals(emplID.trim())) {
                                    found = true;

                                }

                            }

                            if (found) {
                                System.out.println("You already have a book in your possession, you cannot borrow more than 1 book");
                            } else {
                                System.out.println();
                                book_list[book_location].display();
                                data.write(emplID + "," + book_list[book_location].getTitle() + "," + "1");
                                data.newLine();
                                System.out.println();
                                System.out.println(book_list[book_location].getTitle() + "'s borrowed.");

                            }


                        } catch (IOException e) {
                            System.out.println(e.getMessage());

                        }
                    }else{

                        System.out.println();
                        book_list[book_location].display();
                        System.out.println();
                        System.out.println(book_list[book_location].getTitle() + " downloaded");
                    }


                }
            }

            if (choice == 3){
                System.out.println("Enter your emplID");

                String empl_id2 = input.next();

                ArrayList<User> get_user2 = read_file();

                boolean b_found = false;
                int address = -1;



                for (int z = 0; z < get_user2.size(); z++) {


                    if (get_user2.get(z).getEmplId().equals(empl_id2.trim())) {
                        b_found = true;
                        address = z;

                    }

                }
                if(b_found){
                    System.out.println(get_user2.get(address).getTitle()+" has been return");
                    remove_data(address+1);
                }else{
                    System.out.println("Your don't have any book to return");

                }
            }



        }while (choice != 4) ;

        }


    }

