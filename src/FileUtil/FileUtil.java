package FileUtil;

import model.BankAccount;
import model.PaymentAccount;
import model.SavingsAccount;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {
    public static void writeBankAccountToFile(String fileName, List<SavingsAccount> savingsAccounts) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (SavingsAccount sa : savingsAccounts) {
                writer.write(sa.convertData());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

        public static List<SavingsAccount> readBankAccountFromFile(String fileName)  {
            List<SavingsAccount> savingsAccounts = new ArrayList<>();
            try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
                String line;
                boolean isEmpty = true;
                while ((line = reader.readLine()) != null) {
                    isEmpty = false;
                    SavingsAccount savingsAccount = SavingsAccount.fromCSV(line);
                    savingsAccounts.add(savingsAccount);
                }
                if (isEmpty) {
                    System.out.println("The file " + fileName + " is empty.");
                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return savingsAccounts;
        }

    public static void writePaymentAccountToFile(String fileName, List<PaymentAccount> paymentAccounts) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (PaymentAccount pay : paymentAccounts) {
                writer.write(pay.convertData());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    public static List<PaymentAccount> readPaymentAccountFromFile(String fileName)  {
        List<PaymentAccount> paymentAccounts = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            boolean isEmpty = true;
            while ((line = reader.readLine()) != null) {
                isEmpty = false;
                PaymentAccount paymentAccount = PaymentAccount.fromCSV(line);
                paymentAccounts.add(paymentAccount);
            }
            if (isEmpty) {
                System.out.println("The file " + fileName + " is empty.");
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return paymentAccounts;
    }

    }
