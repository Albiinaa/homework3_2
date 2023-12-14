
public class Main {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount();
        bankAccount.deposit(15000);
        try {
            while (true) {
                bankAccount.withDraw(6000);
                System.out.println("Снято 6000 сом. Остаток: " + bankAccount.getAmount());
            }
        } catch (LimitException le) {
            try {
                bankAccount.withDraw((int) le.getRemainingAmount());
            } catch (LimitException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Исключение: " + le.getMessage());
            System.out.println("Максимальная доступная сумма для снятия: " + le.getRemainingAmount() + "сом");
            System.out.println("Снято: " + le.getRemainingAmount() + "сом");
            System.out.println("Остаток на счете: 0 сом");
        }
    }
}