package com.tencent.tim.dingdong;

import android.content.Intent;
import avfw;
import avfw.d;
import com.tencent.mobileqq.pluginsdk.PluginProxyBroadcastReceiver;
import com.tencent.qphone.base.util.BaseApplication;
import cooperation.plugin.PluginInfo;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class DingdongPluginProxyBroadcastReceiver
  extends PluginProxyBroadcastReceiver
{
  public static void c(AppRuntime paramAppRuntime, Intent paramIntent)
  {
    if (paramIntent.getAction() == null) {
      paramIntent.setAction("com.tencent.tim.ACTION_DINGDONG_BROADCAST");
    }
    paramIntent.setPackage(MobileQQ.getContext().getPackageName());
    avfw.d locald = new avfw.d(0);
    locald.mPluginID = "dingdong_plugin.apk";
    locald.mPluginName = PluginInfo.cKF;
    locald.mUin = paramAppRuntime.getAccount();
    locald.cKu = "com.dingdong.broadcast.DingdongBroadcastReceiver";
    locald.mIntent = paramIntent;
    avfw.b(paramAppRuntime.getApplication(), locald);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.dingdong.DingdongPluginProxyBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */