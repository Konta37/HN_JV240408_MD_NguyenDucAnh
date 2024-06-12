package Exam_Advance.run;

import Exam_Advance.controller.SearchController;
import Exam_Advance.controller.SingerController;
import Exam_Advance.controller.SongController;
import Exam_Advance.model.Singer;
import Exam_Advance.model.Song;

import java.util.Date;
import java.util.Scanner;

public class MusicManagement {
    public static Song[] songsArray = new Song[100];
    public static int currentSongIndex = 0;
    public static Singer[] singersArray = new Singer[100];
    public static int currentSingerIndex = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        mainMenu(sc);
    }

    public static void mainMenu(Scanner sc) {
        do {
            System.out.println("==========MUSIC-MANAGEMENT==========");
            System.out.println("1. Singer management");
            System.out.println("2. Song management");
            System.out.println("3. Search song");
            System.out.println("4. Exit");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    SingerController.SingerController(sc);
                    break;
                case 2:
                    SongController.songMenu(sc);
                    break;
                case 3:
                    SearchController.searchController(sc);
                    break;
                case 4:
                    System.exit(0);
                case 5:
                    autoInput();
                    break;
                default:
                    System.err.println("Invalid choice");
            }
        } while (true);
    }


    public static void autoInput(){
        currentSongIndex = 12;
        currentSingerIndex = 12;
        Date d = new Date();
        for (int i = 0; i < currentSingerIndex; i++) {
            singersArray[i] = new Singer((i+2),"singer"+i,24,"VN",true,"Kpop");
        }
        for(int i =0; i<currentSongIndex; i++){
            songsArray[i]  = new Song("S00"+(i+2),"Song" +i,"hohoho",singersArray[i], "Hihi", d,true );
        }
    }
}
