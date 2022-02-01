package com.tencent.android.tpush.common;

import android.content.Context;
import com.tencent.android.tpush.XGPushConfig;
import com.tencent.android.tpush.d.d;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.service.util.b;
import com.tencent.tpns.baseapi.base.PushPreferences;
import com.tencent.tpns.baseapi.base.util.CommonHelper;
import org.json.JSONObject;

public class f
{
  private static f a = null;
  private Context b = null;
  private String c = null;
  private String d = null;
  
  private f(Context paramContext)
  {
    this.b = paramContext.getApplicationContext();
    this.c = AppInfos.getCurAppVersion(paramContext);
    this.d = String.valueOf("1.2.7.3");
  }
  
  public static f a(Context paramContext)
  {
    try
    {
      if (a == null) {
        a = new f(paramContext);
      }
      paramContext = a;
      return paramContext;
    }
    finally {}
  }
  
  public String a()
  {
    i = 0;
    j = 0;
    JSONObject localJSONObject = new JSONObject();
    try
    {
      CommonHelper.jsonPut(localJSONObject, "appVer", this.c);
      CommonHelper.jsonPut(localJSONObject, "appSdkVer", this.d);
      CommonHelper.jsonPut(localJSONObject, "ch", XGPushConfig.getInstallChannel(this.b));
      CommonHelper.jsonPut(localJSONObject, "gs", XGPushConfig.getGameServer(this.b));
      if ((!XGPushConfig.isUsedOtherPush(this.b)) || (!d.a(this.b).j())) {
        break label421;
      }
      str1 = d.a(this.b).i();
      String str2 = d.a(this.b).f();
      TLogger.ii("RegisterReservedInfo", "Reservert info: other push token is : " + str2 + "  other push type: " + str1);
      if ((i.b(str1)) || (i.b(str2))) {
        break label416;
      }
      CommonHelper.jsonPut(localJSONObject, str1, str2);
      if (d.a(this.b).e() != 4) {
        break label409;
      }
      j = 2;
      i = 1;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        String str1;
        long l1;
        long l2;
        TLogger.e("RegisterReservedInfo", "toSting", localThrowable);
        continue;
        continue;
        int k = j;
        j = i;
        i = k;
      }
    }
    if (j == 0)
    {
      TLogger.ii("RegisterReservedInfo", "Reservert info: use normal TPNS token register");
      CommonHelper.jsonPut(localJSONObject, "fcm", "");
      CommonHelper.jsonPut(localJSONObject, "miid", "");
    }
    k = PushPreferences.getInt(this.b, ".firstregister", 1);
    j = PushPreferences.getInt(this.b, ".usertype", 0);
    l1 = PushPreferences.getLong(this.b, ".installtime", 0L);
    l2 = System.currentTimeMillis();
    if (l1 == 0L)
    {
      PushPreferences.putLong(this.b, ".installtime", l2);
      l1 = l2;
    }
    for (;;)
    {
      localJSONObject.put("ut", j);
      if (k == 1) {
        localJSONObject.put("freg", 1);
      }
      localJSONObject.put("it", (int)(l1 / 1000L));
      if (i.b(this.b)) {
        localJSONObject.put("aidl", 1);
      }
      localJSONObject.put("nf_st", b.b(this.b));
      localJSONObject.put("push_type", i);
      localJSONObject.put("os_version", g.a());
      str1 = g.c();
      if (!i.b(str1)) {
        localJSONObject.put("oh_version", str1);
      }
      return localJSONObject.toString();
      label409:
      i = 1;
      j = 1;
      break label484;
      label416:
      j = 0;
      break label484;
      label421:
      i = 0;
      break;
      if ((j != 0) || (k == 1) || (i.a(l1).equals(i.a(System.currentTimeMillis())))) {
        break label481;
      }
      PushPreferences.putInt(this.b, ".usertype", 1);
      j = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.common.f
 * JD-Core Version:    0.7.0.1
 */