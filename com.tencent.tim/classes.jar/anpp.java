import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.statistics.WtloginReporter.1;

public class anpp
{
  public static void dY(QQAppInterface paramQQAppInterface)
  {
    ThreadManagerV2.executeOnFileThread(new WtloginReporter.1(paramQQAppInterface.getCurrentAccountUin()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anpp
 * JD-Core Version:    0.7.0.1
 */