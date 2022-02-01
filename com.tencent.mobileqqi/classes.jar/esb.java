import com.tencent.mobileqq.activity.specialcare.QvipSpecialCareActivity;
import com.tencent.mobileqq.activity.specialcare.QvipSpecialSoundManager.CallBack;
import com.tencent.qphone.base.util.QLog;

public class esb
  implements QvipSpecialSoundManager.CallBack
{
  public esb(QvipSpecialCareActivity paramQvipSpecialCareActivity) {}
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        QvipSpecialCareActivity.a(this.a);
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
      finally
      {
        QvipSpecialCareActivity.a(this.a);
      }
      if (QLog.isColorLevel()) {
        QLog.i("QvipSpecialCareActivity", 2, "loadSpecialSoundConfig fail.");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     esb
 * JD-Core Version:    0.7.0.1
 */