package com.huawei.hms.support.api.push.service;

import android.app.Notification.Builder;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.PackageManagerHelper;
import com.huawei.hms.utils.ResourceLoaderUtil;
import java.util.Objects;

public class HmsMsgService
  extends Service
{
  private static void c(Context paramContext, Bundle paramBundle)
  {
    Intent localIntent = new Intent();
    localIntent.setAction("com.huawei.android.push.intent.RECEIVE");
    localIntent.putExtra("msg_data", com.huawei.hms.push.c.a.c(paramBundle, "msg_data"));
    localIntent.putExtra("device_token", com.huawei.hms.push.c.a.c(paramBundle, "device_token"));
    localIntent.putExtra("msgIdStr", com.huawei.hms.push.c.a.b(paramBundle, "msgIdStr"));
    localIntent.setFlags(32);
    localIntent.setPackage(com.huawei.hms.push.c.a.b(paramBundle, "push_package"));
    paramContext.sendBroadcast(localIntent, paramContext.getPackageName() + ".permission.PROCESS_PUSH_MSG");
    HMSLog.i("HmsMsgService", "send broadcast passby done");
  }
  
  private static void d(Context paramContext, Bundle paramBundle)
  {
    if (!com.huawei.hms.support.api.push.c.a.a.a(paramContext)) {
      HMSLog.i("HmsMsgService", paramContext.getPackageName() + " disable display notification.");
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.huawei.push.msg.NOTIFY_MSG");
    localIntent.putExtra("selfshow_info", com.huawei.hms.push.c.a.c(paramBundle, "selfshow_info"));
    localIntent.putExtra("selfshow_token", com.huawei.hms.push.c.a.c(paramBundle, "selfshow_token"));
    localIntent.setPackage(com.huawei.hms.push.c.a.b(paramBundle, "push_package"));
    new com.huawei.hms.support.api.push.b.a().a(paramContext, localIntent);
    HMSLog.i("HmsMsgService", "invokeSelfShow done");
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    HMSLog.i("HmsMsgService", "onBind");
    Messenger localMessenger = new Messenger(new a(this));
    stopService(paramIntent);
    return localMessenger.getBinder();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (Build.VERSION.SDK_INT >= 26) {
      stopForeground(true);
    }
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    HMSLog.i("HmsMsgService", "Enter onStartCommand.");
    if (Build.VERSION.SDK_INT >= 26)
    {
      paramIntent = new NotificationChannel("HwPushChannelID", "pushKit", 3);
      paramIntent.enableVibration(false);
      NotificationManager localNotificationManager = (NotificationManager)getSystemService("notification");
      if (localNotificationManager != null) {
        localNotificationManager.createNotificationChannel(paramIntent);
      }
      paramIntent = new Notification.Builder(this, "HwPushChannelID");
      paramIntent.setAutoCancel(true);
      startForeground(1, paramIntent.build());
    }
    return 2;
  }
  
  static class a
    extends Handler
  {
    private Context a;
    
    a(Context paramContext)
    {
      this.a = paramContext;
    }
    
    public void handleMessage(Message paramMessage)
    {
      Bundle localBundle = paramMessage.getData();
      if (Build.VERSION.SDK_INT >= 21) {
        if ((Objects.equals(this.a.getApplicationContext().getPackageManager().getNameForUid(paramMessage.sendingUid), "com.huawei.hwid")) && (localBundle != null))
        {
          HMSLog.i("HmsMsgService", "get package signature");
          if ("B92825C2BD5D6D6D1E7F39EECD17843B7D9016F611136B75441BC6F4D3F00F05".equalsIgnoreCase(new PackageManagerHelper(this.a).getPackageSignature("com.huawei.hwid"))) {
            break label86;
          }
          HMSLog.i("HmsMsgService", "service not start by hms");
        }
      }
      for (;;)
      {
        super.handleMessage(paramMessage);
        return;
        label86:
        HMSLog.i("HmsMsgService", "chose push type");
        if (Objects.equals(com.huawei.hms.push.c.a.a(localBundle, "push_action"), "com.huawei.push.msg.NOTIFY_MSG"))
        {
          if (ResourceLoaderUtil.getmContext() == null) {
            ResourceLoaderUtil.setmContext(this.a.getApplicationContext());
          }
          HMSLog.i("HmsMsgService", "invokeSelfShow");
          HmsMsgService.a(this.a, localBundle);
        }
        else if (Objects.equals(com.huawei.hms.push.c.a.a(localBundle, "push_action"), "com.huawei.push.msg.PASSBY_MSG"))
        {
          HMSLog.i("HmsMsgService", "sendBroadcastToHms");
          HmsMsgService.b(this.a, localBundle);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hms.support.api.push.service.HmsMsgService
 * JD-Core Version:    0.7.0.1
 */