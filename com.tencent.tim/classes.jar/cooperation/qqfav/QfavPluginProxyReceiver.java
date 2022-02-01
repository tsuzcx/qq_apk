package cooperation.qqfav;

import android.content.Intent;
import avfw;
import avfw.d;
import com.tencent.mobileqq.pluginsdk.PluginProxyBroadcastReceiver;
import mqq.app.AppRuntime;

public class QfavPluginProxyReceiver
  extends PluginProxyBroadcastReceiver
{
  public static void d(AppRuntime paramAppRuntime, Intent paramIntent)
  {
    avfw.d locald = new avfw.d(0);
    locald.mPluginID = "qqfav.apk";
    locald.mPluginName = "qqfav.apk";
    locald.mUin = paramAppRuntime.getAccount();
    locald.cKu = "com.qqfav.ipc.QfavPluginReceiver";
    locald.mIntent = paramIntent;
    avfw.b(paramAppRuntime.getApplication(), locald);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qqfav.QfavPluginProxyReceiver
 * JD-Core Version:    0.7.0.1
 */