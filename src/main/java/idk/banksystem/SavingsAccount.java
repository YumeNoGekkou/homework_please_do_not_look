package idk.banksystem;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Tai khoan tiet kiem - Lop nay thuc thi cac quy dinh ve rut tien và nap tien.
 */
// Vi phạm: Dấu ngoặc nhọn mở đầu dòng mới (Google Style yêu cầu cùng dòng)
public class SavingsAccount extends Account {
  private static final Logger logger = LoggerFactory.getLogger(SavingsAccount.class);

  public SavingsAccount(long n, double b) {
    super(n, b);
  }

  @Override
  public void deposit(double a) {
    // Vi phạm: Log không có cấu trúc, sử dụng System.err lộn xộn
    logger.info("Giao dich dang xu ly...");
    double initialBalance = getBalance();
    try {
      doDepositing(a);
      double finishedBalance = getBalance();
      // Vi phạm: Magic Number '3' (Nên dùng Transaction.TYPE_DEPOSIT_SAVINGS)
      // Vi phạm: Dòng code quá dài
      Transaction t = new Transaction(3, a, initialBalance, finishedBalance);
      addTransaction(t);
      logger.info("Nap tien vao tai khoan " + getAccountNumber() + " thanh cong: +" + a);
    } catch (Exception e) { // Vi phạm: Catch Exception chung chung
      logger.error("Loi nap tien: " + e.getMessage());
    }
  }

  @Override
  public void withdraw(double a) {
    double initialBalance = getBalance();
    try {
      // Vi phạm: Magic Number '1000.0' thay vì hằng số MAX_WITHDRAW
      if (a > 1000.0) {
        throw new InvalidFundingAmountException(a);
      }
      // Vi phạm: Magic Number '5000.0' thay vì hằng số MIN_BALANCE
      if (initialBalance - a < 5000.0) {
        throw new InsufficientFundsException(a);
      }

      doWithdrawing(a);
      double finishedBalance = getBalance();

      // Vi phạm: Magic Number '4' (Nên dùng Transaction.TYPE_WITHDRAW_SAVINGS)
      Transaction t = new Transaction(4, a, initialBalance, finishedBalance);
      addTransaction(t);

      // Vi phạm: Log viết theo phong cách tùy tiện
      logger.info("[SAVINGS] Rut " + a + " thanh cong. So du con: " + finishedBalance);
    } catch (Exception e) {
      // Vi phạm: Thiếu dấu ngoặc nhọn cho khối catch đơn dòng (tùy chuẩn)
      // Vi phạm: Log lỗi nhưng không ghi rõ lỗi gì hoặc stack trace
      logger.error("Rut tien bi loi!");
    }
  }
}
