package cooperation.troop;

import android.content.Context;
import android.content.Intent;
import avfw;
import avfw.d;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pluginsdk.PluginProxyBroadcastReceiver;
import com.tencent.qphone.base.util.QLog;
import cooperation.plugin.PluginInfo;
import mqq.app.AppRuntime;

public class NearbyVideoProxyBroadcastReceiver
  extends PluginProxyBroadcastReceiver
{
  public static void V(Context paramContext, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NearbyVideoProxyBroadcastReceiver", 2, "sendPluginBroadcast:" + paramIntent.getAction());
    }
    Intent localIntent = new Intent(paramIntent.getAction());
    localIntent.putExtras(paramIntent);
    localIntent.putExtra("action", paramIntent.getAction());
    paramIntent = new avfw.d(1);
    paramIntent.mPluginID = "nearby_video_chat_plugin.apk";
    paramIntent.mPluginName = PluginInfo.cKJ;
    paramIntent.mUin = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    paramIntent.cKu = "com.tencent.mobileqq.nearbyvideochat.service.NearbyVideoMsgBroadcastReceiver";
    paramIntent.mIntent = localIntent;
    avfw.b(paramContext, paramIntent);
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    super.onReceive(paramContext, paramIntent);
    if (QLog.isColorLevel()) {
      QLog.d("NearbyVideoProxyBroadcastReceiver", 2, "onReceive:" + paramIntent.getAction());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.troop.NearbyVideoProxyBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */