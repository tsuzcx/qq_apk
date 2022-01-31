import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.mobileqq.vas.VipGrayConfigHelper;
import com.tencent.qphone.base.util.QLog;

public class trg
  implements Runnable
{
  public trg(QQSettingMe paramQQSettingMe) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQSettingRedesign", 2, "init parse config json");
    }
    VipGrayConfigHelper.a().a(this.a.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     trg
 * JD-Core Version:    0.7.0.1
 */