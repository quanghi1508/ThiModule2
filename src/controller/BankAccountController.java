package controller;

import FileUtil.FileUtil;
import model.BankAccount;
import model.PaymentAccount;
import model.SavingsAccount;

import java.util.List;
import java.util.Scanner;

public class BankAccountController {
    private static final String BANK_ACCOUNT_FILE = "src/data/bank_accounts.csv";
    private List<SavingsAccount> savingsAccounts;
    private List<PaymentAccount> paymentAccounts;


    public BankAccountController() {
        savingsAccounts = loadSavingsAccounts();
        paymentAccounts = loadPaymentAccounts();
    }

    private List<SavingsAccount> loadSavingsAccounts() {
        return FileUtil.readBankAccountFromFile(BANK_ACCOUNT_FILE);
    }

    private List<PaymentAccount> loadPaymentAccounts() {
        return FileUtil.readPaymentAccountFromFile(BANK_ACCOUNT_FILE);
    }

    public static Scanner scanner = new Scanner(System.in);

    public void menuAddBankAccount() {
        while (true) {
            System.out.println(" ===========================================");
            System.out.println("|            Thêm mới tài khoản             |");
            System.out.println("|                                           |");
            System.out.println("| 1. Tài khoản tiết kiệm                    |");
            System.out.println("| 2. Tài khoản thanh toán                   |");
            System.out.println("| 3. Exít                                   |");
            System.out.println(" ===========================================");
            System.out.print("Choose a option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    addSavingsAccount();
                    break;
                case 2:
                    addPaymentAccount();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ, vui lòng chọn lại!");

            }
        }
    }

    public void addSavingsAccount() {
        System.out.println("======== Thêm mới tiết kiệm ========");
        System.out.println("Id: ");
        String id = scanner.nextLine();
        System.out.println("Mã tài khoản: ");
        String accountCode = scanner.nextLine();
        System.out.println("Tên chủ tài khoàn: ");
        String name = scanner.nextLine();
        System.out.println("Ngày tạo tài khoàn: ");
        String accountCreationDate = scanner.nextLine();
        System.out.println("Số tiền gửi tiết kiệm: ");
        String depositAmount = scanner.nextLine();
        System.out.println("Ngày gửi tiết kiệm: ");
        String depositDate = scanner.nextLine();
        System.out.println("Lãi suất: ");
        String interestDate = scanner.nextLine();
        System.out.println("Kỳ hạn (số tháng): ");
        String term = scanner.nextLine();
        SavingsAccount newSavingsAccount = new SavingsAccount(id, accountCode, name, accountCreationDate, depositAmount, depositDate, interestDate, term);
        savingsAccounts.add(newSavingsAccount);
        FileUtil.writeBankAccountToFile(BANK_ACCOUNT_FILE, savingsAccounts);
        System.out.println("Thêm tài khoản thành công!");
    }

    public void addPaymentAccount() {
        System.out.println("======== Thêm mới thanh toán ========");
        System.out.println("Id: ");
        String id = scanner.nextLine();
        System.out.println("Mã tài khoản: ");
        String accountCode = scanner.nextLine();
        System.out.println("Tên chủ tài khoàn: ");
        String name = scanner.nextLine();
        System.out.println("Ngày tạo tài khoàn: ");
        String accountCreationDate = scanner.nextLine();
        System.out.println("Số thẻ: ");
        String cardNumber = scanner.nextLine();
        System.out.println("Số tiền trong tài khoản: ");
        String balance = scanner.nextLine();
        PaymentAccount newPaymentAccount = new PaymentAccount(id, accountCode, name, accountCreationDate, cardNumber, balance);
        paymentAccounts.add(newPaymentAccount);
        FileUtil.writePaymentAccountToFile(BANK_ACCOUNT_FILE, paymentAccounts);
        System.out.println("Thêm tài khoản thành công!");
    }

    public void displayListAccount() {
        if (!paymentAccounts.isEmpty()) {
            for (PaymentAccount pay : paymentAccounts) {
                System.out.println(pay);
            }
        } else {
            System.out.println("Danh sách tài khoản thanh toán rỗng!!!");
        }
        if (!savingsAccounts.isEmpty()) {
            for (SavingsAccount sav : savingsAccounts) {
                System.out.println(sav);
            }
        } else {
            System.out.println("Danh sách tài khoản tiết kiệm rỗng!!!");
        }

    }

    public void deleteAccount() {
        System.out.println("========== Xoá Khách Hàng =============");
        System.out.println("Nhập mã khách hàng muốn xóa: ");
        String id = scanner.nextLine();
        SavingsAccount savingsAccountDelete = null;
        for (SavingsAccount sav: savingsAccounts) {
            if (sav.getId().equals(id) ){
                savingsAccountDelete = sav;
                break;

            }
        }
        if (savingsAccountDelete != null) {
            savingsAccounts.remove(savingsAccountDelete);

            System.out.println("Tài khoản với mã " + id + " đã được xóa!");

        } else {
            System.out.println("Không tìm thấy tài khoản với mã " + id);
        }

    }

}