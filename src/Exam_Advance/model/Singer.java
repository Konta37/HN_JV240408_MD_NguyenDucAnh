package Exam_Advance.model;

import Exam_Advance.run.MusicManagement;

import java.util.Scanner;

public class Singer {
    private int singerId; //auto
    private String singerName;
    private int age; //>0
    private String nationality; //quoc tich
    private boolean gender; //gioi tinh
    private String genre;
    //the loai
    public Singer() {}

    public Singer(int id,String singerName, int age, String nationality, boolean gender, String genre) {
        this.singerName = singerName;
        this.age = age;
        this.nationality = nationality;
        this.gender = gender;
        this.genre = genre;
        this.singerId = id;
    }

    public int getSingerId() {
        return singerId;
    }

    public void setSingerId(int singerId) {
        this.singerId = singerId;
    }

    public String getSingerName() {
        return singerName;
    }

    public void setSingerName(String singerName) {
        this.singerName = singerName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public boolean getGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void inputData(Scanner sc){
        this.singerId = inputSingerId();
        this.singerName = inputSingerName(sc);
        this.age = inputSingerAge(sc);
        this.nationality = inputSingerNationality(sc);
        this.gender = inputSingerGender(sc);
        this.genre = inputSingerGenre(sc);
        System.out.println("=============================");
    }

    public void displayData(){
        System.out.printf("Singer ID: %d\nName: %s  Age: %d\nNationality: %s\nGender: %b    Genre: %s\n",
                this.singerId,this.singerName,this.age,this.nationality,this.gender,this.genre);
        System.out.println("=====================================================");
    }

    public int inputSingerId(){
        return MusicManagement.currentSingerIndex;
    }

    public String inputSingerName(Scanner sc){
        System.out.print("Enter Singer Name: ");
        do {
            String singerName = sc.nextLine();
            if (!singerName.isEmpty()) {
                return singerName;
            }else {
                System.err.println("Please enter a valid Singer Name");
            }
        }while (true);
    }

    public int inputSingerAge(Scanner sc){
        System.out.print("Enter Singer Age: ");
        do{
            String age = sc.nextLine();
            try {
                if(Integer.parseInt(age)>0){
                    return Integer.parseInt(age);
                }else {
                    System.err.println("Error age. Must be bigger than 0 and doesnt have character. Try again!");
                }
            } catch (NumberFormatException e) {
                System.err.println("Error age. Must be bigger than 0 and doesnt have character. Try again!");
            }
        }while(true);
    }

    public String inputSingerNationality(Scanner sc){
        System.out.print("Enter Singer Nationality: ");
        do {
            String singerNation = sc.nextLine();
            if (!singerNation.isEmpty()) {
                return singerNation;
            }else {
                System.err.println("Please enter a valid Singer Nationality");
            }
        }while (true);
    }

    public boolean inputSingerGender(Scanner sc){
        System.out.print("Enter Singer Gender: ");
        do {
            String bookStatus = sc.nextLine();
            if(bookStatus.equalsIgnoreCase("true") || bookStatus.equalsIgnoreCase("false")){
                return Boolean.parseBoolean(bookStatus);
            }else {
                System.err.println("Invalid Singer Gender (true/false). Please try again.");
            }
        }while (true);
    }

    public String inputSingerGenre(Scanner sc){
        System.out.print("Enter Singer Genre: ");
        do {
            String singerNation = sc.nextLine();
            if (!singerNation.isEmpty()) {
                return singerNation;
            }else {
                System.err.println("Please enter a valid Singer Genre");
            }
        }while (true);
    }

}
