package Exam_Advance.service;

import Exam_Advance.controller.SingerController;
import Exam_Advance.controller.SongController;
import Exam_Advance.model.Singer;
import Exam_Advance.model.Song;
import Exam_Advance.run.MusicManagement;

import java.util.Scanner;

public class SongService {
    public static void addSong(Scanner sc) {
        System.out.println("Enter the number of Song");
        int numberOfSongs = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < numberOfSongs; i++) {
            MusicManagement.songsArray[MusicManagement.currentSongIndex] = new Song();
            MusicManagement.songsArray[MusicManagement.currentSongIndex].inputData(sc);
            MusicManagement.currentSongIndex++;
        }
    }

    public static void displaySongs() {
        for (int i = 0; i < MusicManagement.currentSongIndex; i++) {
            MusicManagement.songsArray[i].displayData();
        }
        if (MusicManagement.currentSongIndex == 0) {
            System.out.println("Song List is empty");
        }
    }

    public static void updateSong(Scanner sc) {
        System.out.println("Enter the name of the Song");
        String songId = sc.nextLine();
        int indexEdit = getIndexById(songId);
        if (indexEdit != -1) {
            boolean isExit = true;
            MusicManagement.songsArray[indexEdit].displayData();
            do {
                System.out.println("1. Update Song Name");
                System.out.println("2. Update Song Description");
                System.out.println("3. Update Singer");
                System.out.println("4. Update Song Writer");
                System.out.println("5. Update Song Status");
                System.out.println("6. Exit");
                int choice = Integer.parseInt(sc.nextLine());
                switch (choice) {
                    case 1:
                        MusicManagement.songsArray[indexEdit].setSongName(MusicManagement.songsArray[indexEdit].inputSongName(sc));
                        break;
                    case 2:
                        MusicManagement.songsArray[indexEdit].setDescription(MusicManagement.songsArray[indexEdit].inputDescription(sc));
                        break;
                    case 3:
                        MusicManagement.songsArray[indexEdit].setSinger(MusicManagement.songsArray[indexEdit].inputSinger(sc));
                        break;
                    case 4:
                        MusicManagement.songsArray[indexEdit].setSongWriter(MusicManagement.songsArray[indexEdit].inputSongWriter(sc));
                        break;
                    case 5:
                        MusicManagement.songsArray[indexEdit].setSongStatus(MusicManagement.songsArray[indexEdit].inputSongStatus(sc));
                        break;
                    case 6:
                        SongController.songMenu(sc);
                        break;
                    default:
                        isExit = false;
                }
            } while (isExit);

        } else {
            System.out.println("There is no singer with id to edit" + songId);
        }
    }


    public static void deleteSongById(Scanner sc) {
        System.out.println("Enter singer id to delete:");
        String songId = sc.nextLine();
        int indexDelete = getIndexById(songId);
        if (indexDelete != -1) {
            for (int i = indexDelete; i < MusicManagement.currentSongIndex; i++) {
                MusicManagement.songsArray[i] = MusicManagement.songsArray[i + 1];
            }
            MusicManagement.currentSongIndex--;
        } else {
            System.out.println("There is no book with id to delete" + songId);
        }
    }

    public static int getIndexById(String songId) {
        for (int i = 0; i < MusicManagement.currentSongIndex; i++) {
            if (MusicManagement.songsArray[i].getSongId().equals(songId)) {
                return i;
            }
        }
        return -1;
    }
}
