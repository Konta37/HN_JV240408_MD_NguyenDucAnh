package Exam_Advance.controller;

import Exam_Advance.run.MusicManagement;
import Exam_Advance.service.SongService;

import java.util.Scanner;

public class SongController {
    public static void songMenu(Scanner sc) {
        do {
            System.out.println("==========SONG-MANAGEMENT==========");
            System.out.println("1. Add song");
            System.out.println("2. Show list song");
            System.out.println("3. Update song by id");
            System.out.println("4. Delete song by id");
            System.out.println("5. Exit");

            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    SongService.addSong(sc);
                    break;
                case 2:
                    SongService.displaySongs();
                    break;
                case 3:
                    SongService.updateSong(sc);
                    break;
                case 4:
                    SongService.deleteSongById(sc);
                    break;
                case 5:
                    MusicManagement.mainMenu(sc);
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        } while (true);
    }
}
