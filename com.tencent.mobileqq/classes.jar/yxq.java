import android.content.Intent;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.qphone.base.util.QLog;

public class yxq
  implements Runnable
{
  public yxq(BrowserAppInterface paramBrowserAppInterface) {}
  
  public void run()
  {
    if ((this.a.isBackground_Stop) && (BaseActivity.sTopActivity == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("BrowserAppInterface", 2, "no activity running, reboot for tbs now");
      }
      localIntent = new Intent();
      localIntent.putExtra("qq_mode_foreground", true);
      BrowserAppInterface.a(this.a, localIntent);
    }
    while (!QLog.isColorLevel())
    {
      Intent localIntent;
      return;
    }
    QLog.d("BrowserAppInterface", 2, "activity still running, cannot reboot");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     yxq
 * JD-Core Version:    0.7.0.1
 */