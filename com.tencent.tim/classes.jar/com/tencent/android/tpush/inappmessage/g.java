package com.tencent.android.tpush.inappmessage;

import android.content.Context;
import android.content.Intent;
import com.tencent.android.tpush.encrypt.Rijndael;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.service.b;
import com.tencent.android.tpush.service.protocol.j;
import com.tencent.android.tpush.stat.ServiceStat;
import com.tencent.tpns.baseapi.base.util.Util;

public class g
{
  private static Context a;
  
  public static g a(Context paramContext)
  {
    if (a == null) {
      a = paramContext.getApplicationContext();
    }
    return a.a;
  }
  
  private void b(j paramj)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("group_id", paramj.r);
    localIntent.putExtra("msgId", paramj.a);
    localIntent.putExtra("type", paramj.f);
    localIntent.putExtra("pushChannel", 100);
    localIntent.putExtra("server_time", paramj.k);
    localIntent.putExtra("targetType", paramj.t);
    localIntent.putExtra("source", paramj.u);
    localIntent.putExtra("timestamps", paramj.h);
    ServiceStat.appReportServiceReceived(b.e(), localIntent);
  }
  
  public void a(j paramj)
  {
    try
    {
      String str = paramj.y;
      if (!Util.isNullOrEmptyString(str))
      {
        if (a == null) {
          return;
        }
        b(paramj);
        Intent localIntent = new Intent();
        localIntent.setClass(a, InAppMessageActivity.class);
        localIntent.putExtra("inAppMsg", str);
        localIntent.putExtra("group_id", paramj.r);
        localIntent.putExtra("msgId", paramj.a);
        localIntent.putExtra("type", paramj.f);
        localIntent.putExtra("pushChannel", paramj.m);
        localIntent.putExtra("server_time", paramj.k);
        localIntent.putExtra("targetType", paramj.t);
        localIntent.putExtra("source", paramj.u);
        localIntent.putExtra("timestamps", paramj.h);
        long l = System.currentTimeMillis();
        localIntent.putExtra("inapp_protect", Rijndael.encrypt("" + (l - 1000L)));
        localIntent.addFlags(268435456);
        a.startActivity(localIntent);
        return;
      }
    }
    catch (Throwable paramj)
    {
      TLogger.e("InAppMessageManager", "InAppMsg parseInAppMsgConfig :" + paramj.toString());
    }
  }
  
  public static class a
  {
    public static g a = new g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.inappmessage.g
 * JD-Core Version:    0.7.0.1
 */