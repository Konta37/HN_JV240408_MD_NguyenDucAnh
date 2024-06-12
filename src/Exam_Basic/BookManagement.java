package Exam_Basic;

import java.util.Scanner;

public class BookManagement {
    public static Book[] bookArray = new Book[100];
    public static int currentBookIndex = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        menuBookManagement(sc);
    }

    public static void menuBookManagement(Scanner sc) {
        do {
            System.out.println("==========MENU==========");
            System.out.println("1. Add book");
            System.out.println("2. Show books");
            System.out.println("3. Sort books by interest (low to high)");
            System.out.println("4. delete book by id");
            System.out.println("5. Search book by name or description");
            System.out.println("6. Edit data of book by name");
            System.out.println("7. Exit");

            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    inputListBooks(sc);
                    break;
                case 2:
                    displayBooks();
                    break;
                case 3:
                    sortByInterest();
                    break;
                case 4:
                    deleteBookById(sc);
                    break;
                case 5:
                    searchBookByNameOrDescription(sc);
                    break;
                case 6:
                    editBookByName(sc);
                    break;
                case 7:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice");
            }
        } while (true);
    }

    //add book
    public static void inputListBooks(Scanner sc) {
        System.out.println("Enter the number of books");
        int numberOfBooks = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < numberOfBooks; i++) {
            bookArray[currentBookIndex] = new Book();
            bookArray[currentBookIndex].inputData(sc);
            currentBookIndex++;
        }
    }
    //show books list
    public static void displayBooks() {
        for (int i = 0; i < currentBookIndex; i++) {
            bookArray[i].displayData();
        }
        if (currentBookIndex == 0) {
            System.out.println("No books found");
        }
    }

    public static void sortByInterest(){
        for (int i = 0; i < currentBookIndex; i++) {
            for (int j = i + 1; j < currentBookIndex; j++) {
                if (bookArray[i].getInterest() < bookArray[j].getInterest()) {
                    Book temp = bookArray[i];
                    bookArray[i] = bookArray[j];
                    bookArray[j] = temp;
                }
            }
        }
    }

    public static void searchBookByNameOrDescription(Scanner sc){
        System.out.println("Enter the name of the book");
        String name = sc.nextLine();
        int count = 0;
        for (int i = 0; i < currentBookIndex; i++) {
            if (bookArray[i].getBookName().toLowerCase().contains(name.toLowerCase()) || bookArray[i].getDescription().toLowerCase().contains(name.toLowerCase())) {
                bookArray[i].displayData();
                count++;
            }
        }
        if (count == 0) {
            System.out.println("No Book found");
        }
    }
    public static void deleteBookById(Scanner sc){
        System.out.println("Enter category id to delete (S00x):");
        String bookId = sc.nextLine();
        int indexDelete = getIndexById(Integer.parseInt(bookId));
        if (indexDelete != -1) {
            for (int i = indexDelete; i < currentBookIndex; i++) {
                bookArray[i] = bookArray[i + 1];
            }
            currentBookIndex--;
        }else {
            System.out.println("There is no book with id to delete" + bookId);
        }
    }

    public static void editBookByName(Scanner sc){
        System.out.println("Enter the name of the book");
        String bookId = sc.nextLine();
        int indexEdit = getIndexById(Integer.parseInt(bookId));
        if (indexEdit != -1) {boolean isExit = true;
            bookArray[indexEdit].displayData();
            do {
                System.out.println("1. Update Book Name");
                System.out.println("2. Update Book Author");
                System.out.println("3. Update Book Description");
                System.out.println("4. Update Book ImportPrice");
                System.out.println("5. Update Book ExportPrice");
                System.out.println("6. Update Book Status");
                System.out.println("7. Exit");
                int choice = Integer.parseInt(sc.nextLine());
                switch (choice) {
                    case 1:
                        bookArray[indexEdit].setBookName(bookArray[indexEdit].inputBookName(sc));
                        break;
                    case 2:
                        bookArray[indexEdit].setAuthor(bookArray[indexEdit].inputBookAuthor(sc));
                        break;
                    case 3:
                        bookArray[indexEdit].setDescription(bookArray[indexEdit].inputBookDescription(sc));
                        break;
                    case 4:
                        bookArray[indexEdit].setImportPrice(bookArray[indexEdit].inputImportPrice(sc));
                        break;
                    case 5:
                        bookArray[indexEdit].setExportPrice(bookArray[indexEdit].inputExportPrice(sc));
                        break;
                    case 6:
                        bookArray[indexEdit].setBookStatus(bookArray[indexEdit].inputBookStatus(sc));
                        break;
                    case 7:
                        menuBookManagement(sc);
                        break;
                    default:
                        isExit = false;
                }
            } while (isExit);

        }else {
            System.out.println("There is no book with id to edit" + bookId);
        }
    }
    public static int getIndexById(int bookId) {
        for (int i = 0; i < currentBookIndex; i++) {
            if (bookArray[i].getId()== bookId) {
                return i;
            }
        }
        return -1;
    }
}
