import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class iie
{
  private static String TAG = "GBatteryMonitor";
  private boolean PK;
  BroadcastReceiver V = new iif(this);
  private VideoAppInterface mApp;
  
  public iie(VideoAppInterface paramVideoAppInterface)
  {
    this.mApp = paramVideoAppInterface;
  }
  
  public void amw()
  {
    try
    {
      if (this.PK)
      {
        this.mApp.getApplication().unregisterReceiver(this.V);
        this.PK = false;
      }
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      QLog.d(TAG, 1, "video exit IllegalArgumentException ", localIllegalArgumentException);
    }
  }
  
  public void amx()
  {
    IntentFilter localIntentFilter = new IntentFilter("android.intent.action.BATTERY_CHANGED");
    if (this.mApp.getApplication().registerReceiver(this.V, localIntentFilter) != null) {
      this.PK = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     iie
 * JD-Core Version:    0.7.0.1
 */