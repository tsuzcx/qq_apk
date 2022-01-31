import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SVIPObserver;
import com.tencent.qphone.base.util.QLog;

public class tqu
  extends SVIPObserver
{
  public tqu(QQSettingMe paramQQSettingMe) {}
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQSettingRedesign", 2, "updateLevelAndVip from mVipInfoChangedObserver");
    }
    this.a.b(this.a.a.getCurrentAccountUin());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tqu
 * JD-Core Version:    0.7.0.1
 */