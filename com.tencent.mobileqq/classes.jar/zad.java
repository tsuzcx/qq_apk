import android.content.Context;
import android.content.IntentFilter;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.qphone.base.util.QLog;

public class zad
  implements Runnable
{
  public zad(BaseActivity paramBaseActivity) {}
  
  public void run()
  {
    int i = 0;
    if (!SettingCloneUtil.readValue(this.a, null, this.a.getString(2131433581), "qqsetting_screenshot_key", false)) {}
    for (;;)
    {
      if (i != 0) {
        this.a.turnOnShake();
      }
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
      localIntentFilter.addAction("android.intent.action.SCREEN_ON");
      BaseActivity.access$102(new zak(null));
      try
      {
        this.a.getApplicationContext().registerReceiver(BaseActivity.access$100(), localIntentFilter);
        return;
      }
      catch (Exception localException)
      {
        QLog.e("qqBaseActivity", 1, "", localException);
      }
      i = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zad
 * JD-Core Version:    0.7.0.1
 */