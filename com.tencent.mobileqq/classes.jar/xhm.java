import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.PeakService;
import com.tencent.mobileqq.activity.recent.RecentOptPopBar;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class xhm
  implements Runnable
{
  public xhm(RecentOptPopBar paramRecentOptPopBar) {}
  
  public void run()
  {
    Intent localIntent = new Intent(BaseApplicationImpl.getContext(), PeakService.class);
    if (VideoEnvironment.d(this.a.a.app)) {
      localIntent.putExtra("ServiceAction", 2);
    }
    try
    {
      BaseApplicationImpl.getContext().startService(localIntent);
      return;
    }
    catch (SecurityException localSecurityException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("RecentOptPopBar", 2, "onShow_otherThings, e = " + localSecurityException.getStackTrace());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xhm
 * JD-Core Version:    0.7.0.1
 */