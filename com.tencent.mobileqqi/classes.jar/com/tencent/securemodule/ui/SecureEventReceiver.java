package com.tencent.securemodule.ui;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.format.Formatter;
import android.util.Log;
import android.widget.Toast;
import com.tencent.securemodule.ac;
import com.tencent.securemodule.impl.SecureService;
import com.tencent.securemodule.r;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class SecureEventReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    Log.d("", "dafsdjflkjewoqiruoeiuroiqjdfklajsdlkj");
    if ("1000020".equals(paramIntent.getAction())) {
      ac.a(paramContext, 17301628, "QQ安全登录扫描中...", "QQ安全登录扫描中...", "");
    }
    label584:
    label594:
    do
    {
      int i;
      Object localObject2;
      Object localObject3;
      for (;;)
      {
        return;
        if ("1000021".equals(paramIntent.getAction()))
        {
          ac.a(paramContext, 17301628, "QQ安全登录扫描正常，请放心使用", "QQ安全登录扫描正常，请放心使用", "");
          return;
        }
        if (!"1000022".equals(paramIntent.getAction())) {
          break;
        }
        paramIntent = (ArrayList)paramIntent.getSerializableExtra("data");
        if ((paramIntent != null) && (paramIntent.size() > 0))
        {
          i = paramIntent.size();
          localObject1 = "危险！QQ安全登录发现" + i + "个病毒";
          ac.a(paramContext, 17301642, (String)localObject1, (String)localObject1, "");
          paramIntent = paramIntent.iterator();
          while (paramIntent.hasNext())
          {
            localObject1 = (r)paramIntent.next();
            localObject2 = new Notification();
            ((Notification)localObject2).icon = 17301642;
            ((Notification)localObject2).when = System.currentTimeMillis();
            ((Notification)localObject2).flags = 16;
            ((Notification)localObject2).defaults = 4;
            localObject3 = ((r)localObject1).a();
            Object localObject4 = new Intent();
            ((Intent)localObject4).setClass(paramContext, TransparentActivity.class);
            ((Intent)localObject4).setAction("1000041");
            ((Intent)localObject4).putExtra("data", (Serializable)localObject1);
            localObject4 = PendingIntent.getActivity(paramContext, 0, (Intent)localObject4, 134217728);
            ((Notification)localObject2).setLatestEventInfo(paramContext, "QQ安全登录发现病毒", "“" + ((r)localObject1).b() + "应用”已被病毒感染", (PendingIntent)localObject4);
            ((NotificationManager)paramContext.getSystemService("notification")).notify(((String)localObject3).hashCode() + 1, (Notification)localObject2);
          }
        }
      }
      if ("1000023".equals(paramIntent.getAction()))
      {
        ac.a(paramContext, 17301642, "QQ安全登录扫描联网超时，无法判断风险", "QQ安全登录扫描联网超时，无法判断风险", "");
        return;
      }
      if ("1000024".equals(paramIntent.getAction()))
      {
        Toast.makeText(paramContext, "开始下载手机管家", 0).show();
        return;
      }
      if ("1000025".equals(paramIntent.getAction()))
      {
        localObject3 = paramIntent.getBundleExtra("data");
        localObject1 = new Notification();
        ((Notification)localObject1).icon = 17301633;
        ((Notification)localObject1).when = System.currentTimeMillis();
        ((Notification)localObject1).flags = 16;
        ((Notification)localObject1).defaults = 4;
        localObject2 = PendingIntent.getActivity(paramContext, 0, new Intent(), 134217728);
        paramIntent = "";
        long l1;
        long l2;
        if (localObject3 != null)
        {
          l1 = ((Bundle)localObject3).getLong("key_total");
          l2 = ((Bundle)localObject3).getLong("key_completed");
          i = ((Bundle)localObject3).getInt("key_progress");
          localObject3 = new StringBuffer();
          ((StringBuffer)localObject3).append("下载：");
          if (l2 != -1L) {
            break label584;
          }
          paramIntent = "0";
          ((StringBuffer)localObject3).append(paramIntent);
          ((StringBuffer)localObject3).append("/");
          if (l1 != -1L) {
            break label594;
          }
        }
        for (paramIntent = "0";; paramIntent = Formatter.formatFileSize(paramContext, l1))
        {
          ((StringBuffer)localObject3).append(paramIntent);
          ((StringBuffer)localObject3).append("    " + i + "%");
          paramIntent = ((StringBuffer)localObject3).toString();
          ((Notification)localObject1).setLatestEventInfo(paramContext, "腾讯手机管家", paramIntent, (PendingIntent)localObject2);
          ((NotificationManager)paramContext.getSystemService("notification")).notify(2, (Notification)localObject1);
          return;
          paramIntent = Formatter.formatFileSize(paramContext, l2);
          break;
        }
      }
      if ("1000027".equals(paramIntent.getAction()))
      {
        paramIntent.getBundleExtra("data");
        ((NotificationManager)paramContext.getSystemService("notification")).cancel(2);
        return;
      }
    } while (!"1000026".equals(paramIntent.getAction()));
    paramIntent = new Intent();
    paramIntent.setClass(paramContext, SecureService.class);
    paramIntent.setAction("1000011");
    Object localObject1 = PendingIntent.getService(paramContext, 0, paramIntent, 134217728);
    paramIntent = new Notification();
    paramIntent.icon = 17301642;
    paramIntent.when = System.currentTimeMillis();
    paramIntent.flags = 16;
    paramIntent.defaults = 4;
    paramIntent.tickerText = "腾讯手机管家下载失败";
    paramIntent.setLatestEventInfo(paramContext, "腾讯手机管家下载失败", "点击继续下载？", (PendingIntent)localObject1);
    paramContext = (NotificationManager)paramContext.getSystemService("notification");
    paramContext.cancel(2);
    paramContext.notify(2, paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.securemodule.ui.SecureEventReceiver
 * JD-Core Version:    0.7.0.1
 */