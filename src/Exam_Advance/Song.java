package Exam_Advance;
import java.util.Date;
import java.util.Scanner;

public class Song {
    private String songId;
    private String songName;
    private String description;
    private String singer;
    private String songWriter;
    private Date createDate;
    private boolean songStatus;

    public Song(){}

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

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
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
    }

    public void displayData(){

    }

    public String inputSongId(Scanner sc){
        System.out.println("Enter Song ID: ");
        do {
            String songId = sc.nextLine();
            String regex = "S\\d{3}";
            if(songId.matches(regex)){
                boolean isCheck = false;
                for(int i = 0; i< MusicManagement.currentSongIndex;i++){
                    if(MusicManagement.songsArray[i].getSongId().equals(songId)){
                        isCheck = true;
                        break;
                    }
                }
                if(isCheck){
                    return songId;
                }else {
                    System.out.println("The Song ID has been duplicated. Try again!");
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

    public String inputSinger(Scanner sc){
        System.out.print("Enter Singer Id: ");
        do {
            String singer = sc.nextLine();
            //check input is number or not
            try {
                if(Integer.parseInt(singer)>=0){
                    //check if there any singer with that id
                    boolean isCheck = false;
                    for (int i = 0; i< MusicManagement.currentSingerIndex;i++){
                        if(MusicManagement.singersArray[i].getSingerId() == Integer.parseInt(singer) ){
                            isCheck = true;
                            break;
                        }
                    }
                    if(isCheck){
                        return singer;
                    }else {
                        System.out.println("There is no singer with that id. Make a new one");
                    }
                }else {
                    System.err.println("Please enter a valid Singer. Try again!");
                }
            } catch (NumberFormatException e) {
                System.err.println("Error parsing the double value. Please enter a valid Import Price.");
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
