import com.tencent.mobileqq.activity.leba.LebaShowListManager;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.qphone.base.util.QLog;

public class wvc
  implements Runnable
{
  public wvc(LebaShowListManager paramLebaShowListManager, RedTouchManager paramRedTouchManager, long paramLong1, boolean paramBoolean, long paramLong2, long paramLong3) {}
  
  public void run()
  {
    for (;;)
    {
      try
      {
        RedTouchManager localRedTouchManager = this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouchManager;
        i = (int)this.jdField_a_of_type_Long;
        boolean bool = this.jdField_a_of_type_Boolean;
        if (this.b != -9223372036854775808L) {
          continue;
        }
        l = this.c;
        i = localRedTouchManager.a(i, bool, l);
      }
      catch (Exception localException)
      {
        long l;
        int j = -2;
        int i = j;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("Q.lebatab.mgr", 2, localException.toString());
        i = j;
        continue;
      }
      if (QLog.isDevelopLevel()) {
        QLog.i("Q.lebatab.mgr", 4, "updateAppSetting, result = " + i);
      }
      return;
      l = this.b;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wvc
 * JD-Core Version:    0.7.0.1
 */