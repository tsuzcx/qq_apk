package com.tencent.android.tpush;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Process;
import com.jg.JgClassChecked;
import com.tencent.android.tpush.common.i;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.service.b;
import com.tencent.tpns.baseapi.XGApiConfig;
import com.tencent.tpns.baseapi.base.TPushAlarmManager;
import com.tencent.tpns.baseapi.base.util.CommonWorkingThread;
import com.tencent.tpns.baseapi.base.util.Util;
import com.tencent.tpns.mqttchannel.api.MqttChannel;
import com.tencent.tpns.mqttchannel.api.MqttConfig;

@JgClassChecked(author=1, fComment="确认已进行安全校验", lastDate="20150316", reviewer=3, vComment={com.jg.EType.RECEIVERCHECK})
public class XGPushReceiver
  extends BroadcastReceiver
{
  public void a(Context paramContext, Intent paramIntent)
  {
    TLogger.d("XGPushReceiver", "ping from receiver");
    paramIntent = PendingIntent.getBroadcast(paramContext, 0, paramIntent, 134217728);
    TPushAlarmManager.getAlarmManager(paramContext).set(0, System.currentTimeMillis() + MqttConfig.getKeepAliveInterval(paramContext) * 1000, paramIntent, XGApiConfig.isPowerSaveMode(paramContext));
    Util.getWakeCpu(paramContext);
    MqttChannel.getInstance(paramContext).ping(null);
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramContext == null) || (paramIntent == null) || (!i.h(paramContext))) {
      Process.killProcess(Process.myPid());
    }
    String str;
    do
    {
      do
      {
        return;
        str = paramIntent.getAction();
      } while (str == null);
      b.b(paramContext.getApplicationContext());
      if (XGPushConfig.enableDebug) {
        TLogger.d("XGPushReceiver", "PushReceiver received " + str + " @@ " + paramContext.getPackageName());
      }
      if ("com.tencent.android.xg.vip.action.INTERNAL_PUSH_MESSAGE".equals(str))
      {
        a.b(b.e());
        return;
      }
    } while ("com.tencent.android.xg.vip.action.SDK".equals(str));
    if ("com.tencent.android.xg.vip.action.ACTION_SDK_KEEPALIVE".equals(str))
    {
      CommonWorkingThread.getInstance().execute(new XGPushReceiver.1(this, paramContext, paramIntent));
      return;
    }
    TLogger.d("XGPushReceiver", "start XGService");
    b.a(paramContext.getApplicationContext(), 3500L);
    CommonWorkingThread.getInstance().execute(new XGPushReceiver.2(this, paramContext));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.XGPushReceiver
 * JD-Core Version:    0.7.0.1
 */