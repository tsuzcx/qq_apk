import com.tencent.mobileqq.activity.specialcare.QQSpecialCareSettingActivity;
import com.tencent.mobileqq.activity.specialcare.QvipSpecialSoundManager.a;
import com.tencent.qphone.base.util.QLog;

public class abau
  implements QvipSpecialSoundManager.a
{
  public abau(QQSpecialCareSettingActivity paramQQSpecialCareSettingActivity) {}
  
  public void onResult(boolean paramBoolean)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abau
 * JD-Core Version:    0.7.0.1
 */