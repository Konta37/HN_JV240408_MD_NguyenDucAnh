package Exam_Advance.model;
import Exam_Advance.run.MusicManagement;

import java.util.Date;
import java.util.Scanner;

public class Song {
    private String songId;
    private String songName;
    private String description;
    private Singer singer;
    private String songWriter;
    private Date createDate;
    private boolean songStatus;

    public Song(){}

    public Song(String songId, String songName, String description, Singer singer,String songWriter, Date createDate, boolean songStatus) {
        this.songId = songId;
        this.songName = songName;
        this.description = description;
        this.singer = singer;
        this.songStatus = songStatus;
        this.createDate = createDate;
        this.songWriter= songWriter;
    }

    public String getSongId() {
        return songId;
    }

    public void setSongId(String songId) {
        this.songId = songId;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Singer getSinger() {
        return singer;
    }

    public void setSinger(Singer singer) {
        this.singer = singer;
    }

    public String getSongWriter() {
        return songWriter;
    }

    public void setSongWriter(String songWriter) {
        this.songWriter = songWriter;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public boolean isSongStatus() {
        return songStatus;
    }

    public void setSongStatus(boolean songStatus) {
        this.songStatus = songStatus;
    }

    public void inputData(Scanner sc) {
        this.songId = inputSongId(sc);
        this.songName = inputSongName(sc);
        this.description = inputDescription(sc);
        this.singer = inputSinger(sc);
        this.songWriter = inputSongWriter(sc);
        this.createDate = inputCreateDate();
        this.songStatus = inputSongStatus(sc);
        System.out.println("=============================");
    }

    public void displayData(){
        System.out.printf("Song ID: %s\nName: %s\nDescription: %s\nSinger: %s   Writer by: %s\nCreate: %s   Status: %b\n",
                this.songId,this.songName,this.description,this.singer.getSingerName(),this.songWriter,this.createDate,this.songStatus);
        System.out.println("=====================================================");
    }

    public String inputSongId(Scanner sc){
        System.out.println("Enter Song ID: ");
        do {
            String songId = sc.nextLine();
            String regex = "S\\d{3}";
            if(songId.matches(regex)){
                boolean isCheck = false;
                for(int i = 0; i< MusicManagement.currentSongIndex; i++){
                    if(MusicManagement.songsArray[i].getSongId().equals(songId)){
                        isCheck = true;
                        break;
                    }
                }
                if(isCheck){
                    System.out.println("The Song ID has been duplicated. Try again!");
                }else {
                    return songId;
                }
            }else {
                System.out.println("Invalid Song ID(Sxxx). Try again!");
            }
        }while (true);
    }

    public String inputSongName(Scanner sc){
        System.out.print("Enter Song Name: ");
        do {
            String songName = sc.nextLine();
            if (!songName.isEmpty()) {
                return songName;
            }else {
                System.err.println("Please enter a valid Song Name");
            }
        }while (true);
    }

    public String inputDescription(Scanner sc){
        System.out.print("Enter Description: ");
        return sc.nextLine();
    }

    public Singer inputSinger(Scanner sc){
        System.out.print("Enter Singer Id: ");
        int count =2;
        do {
            String singer = sc.nextLine();
            //check input is number or not
            try {
                if(Integer.parseInt(singer)>=0){
                    //check if there any singer with that id
                    int index = -1;
                    for (int i = 0; i< MusicManagement.currentSingerIndex;i++){
                        if(MusicManagement.singersArray[i].getSingerId() == Integer.parseInt(singer) ){
                            index = i;
                            break;
                        }
                    }
                    if(index>=0){
                        return MusicManagement.singersArray[index];
                    }else {

                        if(count!=0){
                            System.err.printf("Please enter a valid Singer. %d times to try again!\n", count);
                            count--;
                        }else {
                            System.out.println("Out of try. Exit program.");
                            System.exit(0);
                        }
                        System.out.println("There is no singer with that id. Must make a new one. Try again!");
                    }
                }else {
                    System.err.println("Error parsing the int value. Please enter a valid Singer Id.");

                }
            } catch (NumberFormatException e) {
                System.err.println("Error parsing the int value. Please enter a valid Singer Id.");
            }
        }while (true);
    }

    public String inputSongWriter(Scanner sc){
        System.out.print("Enter Song Writer: ");
        do {
            String writer = sc.nextLine();
            if (!writer.isEmpty()) {
                return writer;
            }else {
                System.err.println("Please enter a valid Song Writer");
            }
        }while (true);
    }

    public Date inputCreateDate(){
        return new Date();
    }

    public boolean inputSongStatus(Scanner sc){
        System.out.print("Enter Song Status: ");
        do {
            String bookStatus = sc.nextLine();
            if(bookStatus.equalsIgnoreCase("true") || bookStatus.equalsIgnoreCase("false")){
                return Boolean.parseBoolean(bookStatus);
            }else {
                System.err.println("Invalid song status. Please try again.");
            }
        }while (true);
    }
}
