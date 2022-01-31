import com.tencent.mobileqq.activity.QQSettingSettingActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.managers.CUOpenCardGuideMng;
import com.tencent.qphone.base.util.QLog;
import java.util.Locale;

public class tnt
  implements Runnable
{
  public tnt(QQSettingSettingActivity paramQQSettingSettingActivity) {}
  
  public void run()
  {
    CUOpenCardGuideMng localCUOpenCardGuideMng = (CUOpenCardGuideMng)this.a.app.getManager(220);
    localCUOpenCardGuideMng.a();
    this.a.a = localCUOpenCardGuideMng.a(0);
    if (QLog.isColorLevel()) {
      QLog.i("QQSetting2Activity", 2, String.format(Locale.getDefault(), "cu_open_card_guide later init entry: %s ", new Object[] { this.a.a }));
    }
    this.a.runOnUiThread(new tnu(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tnt
 * JD-Core Version:    0.7.0.1
 */