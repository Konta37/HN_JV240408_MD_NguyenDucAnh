package Exam_Advance.controller;

import Exam_Advance.run.MusicManagement;
import Exam_Advance.service.SearchService;

import java.util.Scanner;

public class SearchController {
    public static void searchController(Scanner sc) {
        do {
            System.out.println("==========SEARCH-MANAGEMENT==========");
            System.out.println("1. Search Song by Singer or Genre");
            System.out.println("2. Search Singer by Name or Genre");
            System.out.println("3. Show list of Songs (low to high)");
            System.out.println("4. Show 10 newest Song");
            System.out.println("5. Exit");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    SearchService.searchSongBySingerOrGenre(sc);
                    break;
                case 2:
                    SearchService.searchSingerByGenre(sc);
                    break;
                case 3:
                    SearchService.showListSongAToZ();
                    break;
                case 4:
                    SearchService.show10NewestSong();
                    break;
                case 5:
                    MusicManagement.mainMenu(sc);
                    break;
                default:
                    System.err.println("Invalid choice");
            }
        } while (true);
    }
}
