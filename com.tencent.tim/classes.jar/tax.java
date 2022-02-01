import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gamecenter.appointment.GameCenterCheck;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class tax
  implements INetEventHandler
{
  private static tax a;
  public static boolean aOu;
  private static BroadcastReceiver as;
  public static int bAT = 100;
  public static boolean lm;
  boolean aOv = false;
  boolean aOw = false;
  
  public static void registerReceiver()
  {
    asbt.i("GameCenterBroadcastReceiver", "registerReceiver");
    if (a == null) {
      a = new tax();
    }
    if (as == null) {
      as = new tay();
    }
    if (!lm)
    {
      lm = true;
      AppNetConnInfo.registerNetChangeReceiver(BaseApplicationImpl.getApplication(), a);
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
      localIntentFilter.addAction("android.intent.action.BATTERY_CHANGED");
      localIntentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
      localIntentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
      BaseApplicationImpl.getContext().registerReceiver(as, localIntentFilter);
    }
  }
  
  public static void unRegisterReceiver()
  {
    asbt.i("GameCenterBroadcastReceiver", "unRegisterReceiver");
    if (a != null)
    {
      AppNetConnInfo.unregisterNetEventHandler(a);
      a = null;
    }
    if (as != null)
    {
      BaseApplicationImpl.getContext().unregisterReceiver(as);
      as = null;
    }
    lm = false;
  }
  
  public void onNetChangeEvent(boolean paramBoolean)
  {
    if (!paramBoolean) {
      if (QLog.isColorLevel()) {
        QLog.i("GameCenterBroadcastReceiver", 2, "no net");
      }
    }
    do
    {
      return;
      if (!AppNetConnInfo.isMobileConn()) {
        break;
      }
    } while (this.aOw);
    if (QLog.isColorLevel()) {
      QLog.i("GameCenterBroadcastReceiver", 2, "mobile connect");
    }
    for (;;)
    {
      this.aOv = false;
      return;
      if (AppNetConnInfo.isWifiConn())
      {
        if (this.aOv) {
          break;
        }
        this.aOv = true;
        if (QLog.isColorLevel()) {
          QLog.i("GameCenterBroadcastReceiver", 2, "wifi connect");
        }
        GameCenterCheck.bCp();
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.i("GameCenterBroadcastReceiver", 2, "no connect");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tax
 * JD-Core Version:    0.7.0.1
 */