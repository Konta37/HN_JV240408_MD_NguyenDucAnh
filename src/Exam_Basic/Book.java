package Exam_Basic;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Book {
    private int bookId; //auto
    private String bookName;
    private String author;
    private String description;
    private double importPrice; //>0
    private double exportPrice; //>1.2import
    private float interest;
    private boolean bookStatus;

    public Book(){}


    public int getId() {
        return bookId;
    }

    public void setId(int id) {
        this.bookId = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(double importPrice) {
        this.importPrice = importPrice;
    }

    public double getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(double exportPrice) {
        this.exportPrice = exportPrice;
    }

    public float getInterest() {
        return interest;
    }

    public void setInterest(float interest) {
        this.interest = interest;
    }

    public boolean getBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(boolean bookStatus) {
        this.bookStatus = bookStatus;
    }

    public void inputData(Scanner scanner){
        this.bookId = BookManagement.currentBookIndex;
        this.bookName = inputBookName(scanner);
        this.author = inputBookAuthor(scanner);
        this.description = inputBookDescription(scanner);
        this.importPrice = inputImportPrice(scanner);
        this.exportPrice = inputExportPrice(scanner);
        this.interest = inputInterest();
        this.bookStatus = inputBookStatus(scanner);
    }

    public void displayData(){
        DecimalFormat formatter = new DecimalFormat("###,###,###");
        System.out.printf("Book Id: %s     Name: %s\nImport Price: %s     Export Price: %s\nAuthor: %s\nInterest: %s\nStatus: %b\n",
                bookId, bookName, formatter.format(importPrice) + " VNĐ", formatter.format(exportPrice) + " VNĐ", author, formatter.format(interest) + " VNĐ",bookStatus);
        System.out.println("======================================");
    }

    public String inputBookName(Scanner scanner){
        System.out.print("Enter Book Name: ");
        do {
            String bookName = scanner.nextLine();
            if (!bookName.isEmpty()) {
                return bookName;
            }else {
                System.err.println("Please enter a valid Book Name");
            }
        }while (true);
    }

    public String inputBookAuthor(Scanner scanner){
        System.out.print("Enter Author: ");
        do {
            String author = scanner.nextLine();
            if (!author.isEmpty()) {
                return author;
            }else {
                System.err.println("Please enter a valid Author");
            }
        }while (true);
    }
    public String inputBookDescription(Scanner scanner){
        System.out.print("Enter Description: ");
        do {
            String description = scanner.nextLine();
            if (description.length()>=10){
                return description;
            }else {
                System.err.println("Please enter a valid Description. Must be more than 10 characters");
            }
        }while (true);
    }
    public double inputImportPrice(Scanner scanner){
        System.out.print("Enter Import Price: ");
        do{
            String importPrice = scanner.nextLine();
            try {
                if(Double.parseDouble(importPrice)>0){
                    return Double.parseDouble(importPrice);
                }else {
                    System.err.println("Error parsing the double value. Please enter a valid Import Price.");
                }
            } catch (NumberFormatException e) {
                System.err.println("Error parsing the double value. Please enter a valid Import Price.");
            }
        }while(true);
    }
    //>1.2import
    public double inputExportPrice(Scanner scanner){
        System.out.print("Enter Export Price: ");
        do{
            String exportPrice = scanner.nextLine();
            try {
                if (Double.parseDouble(exportPrice)>= 1.2 * this.getImportPrice()){
                    return Double.parseDouble(exportPrice);
                }else {
                    System.err.println("Error parsing export price. More than 1.2 import price");
                }
            } catch (NumberFormatException e) {
                System.err.println("Error parsing the double value. Please enter a valid Export Price.");
            }
        }while(true);
    }
    public float inputInterest(){
        return (float) (this.exportPrice - this.importPrice);
    }

    public boolean inputBookStatus(Scanner sc){
        System.out.print("Enter Book Status: ");
        do {
            String bookStatus = sc.nextLine();
            if(bookStatus.equalsIgnoreCase("true") || bookStatus.equalsIgnoreCase("false")){
                return Boolean.parseBoolean(bookStatus);
            }else {
                System.err.println("Invalid book status. Please try again.");
            }
        }while (true);
    }
}
