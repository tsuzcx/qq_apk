import com.tencent.mobileqq.activity.specialcare.QQSpecialFriendSettingActivity;
import com.tencent.mobileqq.activity.specialcare.QvipSpecialSoundManager.a;
import com.tencent.qphone.base.util.QLog;

public class abbb
  implements QvipSpecialSoundManager.a
{
  public abbb(QQSpecialFriendSettingActivity paramQQSpecialFriendSettingActivity) {}
  
  public void onResult(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQSpecialFriendSettingActivity", 2, "loadSpecialSoundConfig onResult: " + paramBoolean);
    }
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        QQSpecialFriendSettingActivity.a(this.a);
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
        QLog.i("QQSpecialFriendSettingActivity", 2, "loadSpecialSoundConfig fail.");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abbb
 * JD-Core Version:    0.7.0.1
 */