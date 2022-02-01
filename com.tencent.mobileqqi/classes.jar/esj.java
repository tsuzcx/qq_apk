import com.tencent.mobileqq.activity.specialcare.QvipSpecialCarePersonActivity;
import com.tencent.mobileqq.activity.specialcare.QvipSpecialSoundManager.CallBack;
import com.tencent.qphone.base.util.QLog;

public class esj
  implements QvipSpecialSoundManager.CallBack
{
  public esj(QvipSpecialCarePersonActivity paramQvipSpecialCarePersonActivity) {}
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        QvipSpecialCarePersonActivity.a(this.a);
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
      finally
      {
        QvipSpecialCarePersonActivity.a(this.a);
      }
      if (QLog.isColorLevel()) {
        QLog.i("QvipSpecialCarePersonActivity", 2, "loadSpecialSoundConfig fail.");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     esj
 * JD-Core Version:    0.7.0.1
 */