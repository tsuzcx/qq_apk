import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gamecenter.appointment.GameCenterCheck;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class yev
  implements INetEventHandler
{
  public static int a;
  private static BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  private static yev jdField_a_of_type_Yev;
  public static boolean a;
  public static boolean b;
  boolean c = false;
  boolean d = false;
  
  static
  {
    jdField_a_of_type_Int = 100;
  }
  
  public static void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameCenterBroadcastReceiver", 2, "registerReceiver");
    }
    if (jdField_a_of_type_Yev == null) {
      jdField_a_of_type_Yev = new yev();
    }
    if (jdField_a_of_type_AndroidContentBroadcastReceiver == null) {
      jdField_a_of_type_AndroidContentBroadcastReceiver = new yew();
    }
    if (!jdField_a_of_type_Boolean)
    {
      jdField_a_of_type_Boolean = true;
      AppNetConnInfo.registerNetChangeReceiver(BaseApplicationImpl.getApplication(), jdField_a_of_type_Yev);
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
      localIntentFilter.addAction("android.intent.action.BATTERY_CHANGED");
      localIntentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
      localIntentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
      BaseApplicationImpl.getContext().registerReceiver(jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
    }
  }
  
  public static void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameCenterBroadcastReceiver", 2, "unRegisterReceiver");
    }
    if (jdField_a_of_type_Yev != null)
    {
      AppNetConnInfo.unregisterNetEventHandler(jdField_a_of_type_Yev);
      jdField_a_of_type_Yev = null;
    }
    if (jdField_a_of_type_AndroidContentBroadcastReceiver != null)
    {
      BaseApplicationImpl.getContext().unregisterReceiver(jdField_a_of_type_AndroidContentBroadcastReceiver);
      jdField_a_of_type_AndroidContentBroadcastReceiver = null;
    }
    jdField_a_of_type_Boolean = false;
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
    } while (this.d);
    if (QLog.isColorLevel()) {
      bckd.b("GameCenterBroadcastReceiver", "mobile connect");
    }
    for (;;)
    {
      this.c = false;
      return;
      if (AppNetConnInfo.isWifiConn())
      {
        if (this.c) {
          break;
        }
        this.c = true;
        if (QLog.isColorLevel()) {
          bckd.b("GameCenterBroadcastReceiver", "wifi connect");
        }
        GameCenterCheck.b();
        continue;
      }
      if (QLog.isColorLevel()) {
        bckd.b("GameCenterBroadcastReceiver", "no connect");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     yev
 * JD-Core Version:    0.7.0.1
 */