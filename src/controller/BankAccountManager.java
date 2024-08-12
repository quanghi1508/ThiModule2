package controller;

import model.BankAccount;

import java.util.List;
import java.util.Scanner;

public class BankAccountManager {
    BankAccountController controller = new BankAccountController();
    public static Scanner scanner = new Scanner(System.in);

    public BankAccountManager() {
    }

    public void BankAccountManager() {
        while (true) {
            System.out.println(" ===========================================");
            System.out.println("| Chương Trình Quản Lí Tài Khoản Ngân Hàng  |");
            System.out.println("|                                           |");
            System.out.println("| 1. Thêm mới                               |");
            System.out.println("| 2. Xóa                                    |");
            System.out.println("| 3. Xem danh sách các tài khoản ngân hàng  |");
            System.out.println("| 4. Tìm kiếm                               |");
            System.out.println("| 5. Exit                                   |");
            System.out.println(" ===========================================");
            System.out.print("Choose a option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    controller.menuAddBankAccount();
                    break;
                case 2:

                    break;
                case 3:
                    controller.displayListAccount();
                    break;
                case 4:
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ, vui lòng chọn lại!");
            }
        }
    }


}
