package Exam_Advance.controller;

import Exam_Advance.run.MusicManagement;
import Exam_Advance.service.SingerService;

import java.util.Scanner;

public class SingerController {
    public static void SingerController(Scanner sc) {
        do {
            System.out.println("==========SINGER-MANAGEMENT==========");
            System.out.println("1. Add singer");
            System.out.println("2. Show list singer");
            System.out.println("3. Update singer by id");
            System.out.println("4. Delete singer by id");
            System.out.println("5. Exit");

            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    SingerService.addSinger(sc);
                    break;
                case 2:
                    SingerService.displaySinger();
                    break;
                case 3:
                    SingerService.updateSinger(sc);
                    break;
                case 4:
                    SingerService.deleteSingerById(sc);
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
