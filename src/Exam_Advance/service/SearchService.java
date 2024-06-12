package Exam_Advance.service;

import Exam_Advance.run.MusicManagement;
import Exam_Basic.Book;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class SearchService {
    public static void searchSongBySingerOrGenre(Scanner sc) {
        System.out.println("Enter Singer or Genre: ");
        String nameSearch = sc.nextLine();
        int cntSong = 0;
        System.out.printf("Product with that name (%s): \n", nameSearch);
        for (int i = 0; i < MusicManagement.currentSongIndex; i++) {
            if (MusicManagement.songsArray[i].getSinger().getSingerName().toLowerCase().equals(nameSearch)
                    || MusicManagement.songsArray[i].getSinger().getGenre().toLowerCase().equals(nameSearch)) {
                MusicManagement.songsArray[i].displayData();
                cntSong++;
            }
        }
        System.out.printf("There are %d song had found\n", cntSong);
    }

    public static void searchSingerByGenre(Scanner sc) {
        System.out.println("Enter Genre to find Singer: ");
        String genreSearch = sc.nextLine();
        int cntSinger = 0;
        System.out.printf("Product with that name (%s): ", genreSearch);
        for (int i = 0; i < MusicManagement.currentSingerIndex; i++) {
            if (MusicManagement.singersArray[i].getSingerName().toLowerCase().equals(genreSearch)
                    || MusicManagement.singersArray[i].getGenre().toLowerCase().equals(genreSearch)) {
                MusicManagement.singersArray[i].displayData();
                cntSinger++;
            }
        }
        System.out.printf("There are %d song had found", cntSinger);
    }

    public static void showListSongAToZ() {
        Arrays.stream(MusicManagement.songsArray).sorted();
        for (int i = 0; i < MusicManagement.currentSongIndex; i++) {
            MusicManagement.songsArray[i].displayData();
        }
        System.out.println("Finish sort from a-z.");
    }


    public static void show10NewestSong() {
        int count = 0;
        System.out.println("List 10 Newest Song.");
        for (int i = MusicManagement.currentSongIndex-1; i >= 0; i--) {
            MusicManagement.songsArray[i].displayData();
            count++;
            if (count == 9) {
                break;
            }
        }
    }
}
