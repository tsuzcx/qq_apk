import com.tencent.mobileqq.activity.specialcare.QQSpecialCareSettingActivity;
import com.tencent.mobileqq.activity.specialcare.QvipSpecialSoundManager.CallBack;
import com.tencent.qphone.base.util.QLog;

public class yfa
  implements QvipSpecialSoundManager.CallBack
{
  public yfa(QQSpecialCareSettingActivity paramQQSpecialCareSettingActivity) {}
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQSpecialCareSettingActivity", 2, "loadSpecialSoundConfig onResult: " + paramBoolean);
    }
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        QQSpecialCareSettingActivity.a(this.a);
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
      finally
      {
        this.a.stopTitleProgress();
      }
      if (QLog.isColorLevel()) {
        QLog.d("QQSpecialCareSettingActivity", 2, "loadSpecialSoundConfig fail.");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     yfa
 * JD-Core Version:    0.7.0.1
 */