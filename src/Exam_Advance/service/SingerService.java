package Exam_Advance.service;

import Exam_Advance.controller.SingerController;
import Exam_Advance.model.Singer;
import Exam_Advance.run.MusicManagement;
import Exam_Basic.Book;

import java.util.Scanner;

public class SingerService {
    public static void addSinger(Scanner sc) {
        System.out.println("Enter the number of Singer");
        int numberOfSinger = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < numberOfSinger; i++) {
            MusicManagement.singersArray[MusicManagement.currentSingerIndex] = new Singer();
            MusicManagement.singersArray[MusicManagement.currentSingerIndex].inputData(sc);
            MusicManagement.currentSingerIndex++;
        }
    }

    public static void displaySinger() {
        for (int i = 0; i < MusicManagement.currentSingerIndex; i++) {
            MusicManagement.singersArray[i].displayData();
        }
        if (MusicManagement.currentSingerIndex == 0) {
            System.out.println("Singer List is empty");
        }
    }

    public static void updateSinger(Scanner sc) {
        System.out.println("Enter the name of the Singer");
        String singerId = sc.nextLine();
        int indexEdit = getIndexById(Integer.parseInt(singerId));
        if (indexEdit != -1) {
            boolean isExit = true;
            MusicManagement.singersArray[indexEdit].displayData();
            do {
                System.out.println("1. Update Singer Name");
                System.out.println("2. Update Singer Age");
                System.out.println("3. Update Singer Nationality");
                System.out.println("4. Update Singer gender");
                System.out.println("5. Update Singer Genre");
                System.out.println("6. Exit");
                int choice = Integer.parseInt(sc.nextLine());
                switch (choice) {
                    case 1:
                        MusicManagement.singersArray[indexEdit].setSingerName(MusicManagement.singersArray[indexEdit].inputSingerName(sc));
                        break;
                    case 2:
                        MusicManagement.singersArray[indexEdit].setAge(MusicManagement.singersArray[indexEdit].inputSingerAge(sc));
                        break;
                    case 3:
                        MusicManagement.singersArray[indexEdit].setNationality(MusicManagement.singersArray[indexEdit].inputSingerNationality(sc));
                        break;
                    case 4:
                        MusicManagement.singersArray[indexEdit].setGender(MusicManagement.singersArray[indexEdit].inputSingerGender(sc));
                        break;
                    case 5:
                        MusicManagement.singersArray[indexEdit].setGenre(MusicManagement.singersArray[indexEdit].inputSingerGenre(sc));
                        break;
                    case 6:
                        SingerController.SingerController(sc);
                        break;
                    default:
                        isExit = false;
                }
            } while (isExit);

        } else {
            System.out.println("There is no singer with id to edit" + singerId);
        }
    }

    public static int getIndexById(int singerId) {
        for (int i = 0; i < MusicManagement.currentSingerIndex; i++) {
            if (MusicManagement.singersArray[i].getSingerId() == singerId) {
                return i;
            }
        }
        return -1;
    }

    public static void deleteSingerById(Scanner sc) {
        System.out.println("Enter singer id to delete:");
        String singerId = sc.nextLine();
        int indexDelete = getIndexById(Integer.parseInt(singerId));
        if (indexDelete != -1) {
            boolean isExist = false;
            for (int i = 0; i<MusicManagement.currentSongIndex; i++) {
                if(MusicManagement.songsArray[i].getSinger().getSingerId()==Integer.parseInt(singerId)){
                    isExist = true;
                    break;
                }
            }
            if (isExist) {
                System.out.println("Singer with id has song so cant delete ");
            }else {
                for (int i = indexDelete; i < MusicManagement.currentSingerIndex; i++) {
                    MusicManagement.singersArray[i] = MusicManagement.singersArray[i + 1];
                }
                MusicManagement.currentSingerIndex--;
            }

        } else {
            System.out.println("There is no book with id to delete" + singerId);
        }
    }
}
