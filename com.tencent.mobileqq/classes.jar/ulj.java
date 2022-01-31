import android.app.Activity;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class ulj
  implements Runnable
{
  private WeakReference a;
  
  public ulj(WeakReference paramWeakReference)
  {
    this.a = paramWeakReference;
  }
  
  public void run()
  {
    if (this.a != null)
    {
      Activity localActivity = (Activity)this.a.get();
      if ((localActivity != null) && (!localActivity.isFinishing()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("UserGuideWeishiFragment", 2, "FinishDeLay5Seconds");
        }
        localActivity.finish();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ulj
 * JD-Core Version:    0.7.0.1
 */