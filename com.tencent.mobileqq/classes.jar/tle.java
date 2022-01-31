import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.VipInfoHandler;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.TicketManager;

public class tle
  implements Runnable
{
  public tle(QQSettingMe paramQQSettingMe) {}
  
  public void run()
  {
    if (!QQSettingMe.d(this.a)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQSettingRedesign", 2, "updateVipInfo");
    }
    String str1 = this.a.a.getCurrentAccountUin();
    String str2 = ((TicketManager)this.a.a.getManager(2)).getSkey(str1);
    ((VipInfoHandler)this.a.a.a(27)).a(str2, str1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tle
 * JD-Core Version:    0.7.0.1
 */