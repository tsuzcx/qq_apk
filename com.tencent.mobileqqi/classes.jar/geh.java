import android.content.SharedPreferences;
import android.os.Handler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.profile.ProfileCardBrowserActivity;
import com.tencent.qphone.base.util.QLog;

public class geh
  implements Runnable
{
  public geh(ProfileCardBrowserActivity paramProfileCardBrowserActivity) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCard.ProfileCardBrowserActivity", 2, "mReloadTask, start.");
    }
    int i = 0;
    for (;;)
    {
      if (i < 25) {}
      try
      {
        Thread.sleep(200L);
        this.a.c = this.a.b.getPreferences().getBoolean("is_template_list_loaded", false);
        boolean bool = this.a.c;
        if (bool)
        {
          this.a.c = this.a.b.getPreferences().getBoolean("is_template_list_loaded", false);
          if (this.a.c) {
            this.a.d();
          }
          this.a.a.sendEmptyMessage(18);
          return;
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        localInterruptedException.printStackTrace();
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     geh
 * JD-Core Version:    0.7.0.1
 */