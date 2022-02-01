package com.tencent.android.tpush.stat.b;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import com.tencent.android.tpush.XGPushConfig;
import com.tencent.android.tpush.stat.event.Event;
import com.tencent.tpns.baseapi.base.util.TGlobalHelper;
import com.tencent.tpns.dataacquisition.CustomDeviceInfos;
import com.tencent.tpns.dataacquisition.DeviceInfos;
import java.util.Locale;
import java.util.TimeZone;
import org.json.JSONArray;
import org.json.JSONObject;

public class a
{
  static a a;
  private static c d = ;
  private static JSONObject e = new JSONObject();
  Integer b = null;
  String c = null;
  
  public a(Context paramContext, long paramLong)
  {
    try
    {
      a(paramContext, paramLong);
      this.b = DeviceInfos.getTelephonyNetworkType(paramContext.getApplicationContext());
      this.c = com.tencent.android.tpush.stat.b.a(paramContext).a();
      return;
    }
    catch (Throwable paramContext)
    {
      d.b(paramContext);
    }
  }
  
  static a a(Context paramContext, long paramLong)
  {
    try
    {
      if (a == null) {
        a = new a(paramContext.getApplicationContext(), paramLong, null);
      }
      paramContext = a;
      return paramContext;
    }
    finally {}
  }
  
  public void a(JSONObject paramJSONObject, Thread paramThread)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      if (a != null) {
        a.a(localJSONObject, paramThread);
      }
      e.a(localJSONObject, "cn", this.c);
      if (this.b != null) {
        localJSONObject.put("tn", this.b);
      }
      if (paramThread == null) {
        paramJSONObject.put("ev", localJSONObject);
      }
      while ((e != null) && (e.length() > 0))
      {
        paramJSONObject.put("eva", e);
        return;
        paramJSONObject.put("errkv", localJSONObject.toString());
      }
      return;
    }
    catch (Throwable paramJSONObject)
    {
      d.b(paramJSONObject);
    }
  }
  
  static class a
  {
    String a;
    DisplayMetrics b;
    int c = Build.VERSION.SDK_INT;
    String d = TGlobalHelper.getDM(null);
    String e = Build.MANUFACTURER;
    String f = Locale.getDefault().getLanguage();
    String g;
    String h;
    String i;
    int j = 0;
    String k = null;
    Context l = null;
    long m = 0L;
    private String n = null;
    private String o = null;
    
    private a(Context paramContext, long paramLong)
    {
      this.l = paramContext.getApplicationContext();
      this.b = DeviceInfos.getDisplayMetrics(this.l);
      this.a = b.b(this.l, paramLong);
      this.g = CustomDeviceInfos.getSimOperator(this.l);
      this.h = TimeZone.getDefault().getID();
      this.i = DeviceInfos.getExternalStorageInfo(this.l);
      this.k = this.l.getPackageName();
      this.n = DeviceInfos.getSystemMemory(this.l);
      this.o = DeviceInfos.getRomMemory();
      this.m = paramLong;
    }
    
    void a(JSONObject paramJSONObject, Thread paramThread)
    {
      if (paramThread == null)
      {
        if (this.b != null)
        {
          paramJSONObject.put("sr", this.b.widthPixels + "*" + this.b.heightPixels);
          paramJSONObject.put("dpi", this.b.xdpi + "*" + this.b.ydpi);
        }
        if (com.tencent.android.tpush.stat.b.a(this.l).b())
        {
          paramThread = new JSONObject();
          e.a(paramThread, "bs", CustomDeviceInfos.getWiFiBBSID(this.l));
          e.a(paramThread, "ss", CustomDeviceInfos.getWiFiSSID(this.l));
          if (paramThread.length() > 0) {
            e.a(paramJSONObject, "wf", paramThread.toString());
          }
        }
        paramThread = CustomDeviceInfos.getWifiTopN(this.l, 10);
        if ((paramThread != null) && (paramThread.length() > 0)) {
          e.a(paramJSONObject, "wflist", paramThread.toString());
        }
      }
      for (;;)
      {
        e.a(paramJSONObject, "pcn", b.d(this.l));
        e.a(paramJSONObject, "osn", Build.VERSION.RELEASE);
        e.a(paramJSONObject, "av", this.a);
        e.a(paramJSONObject, "ch", Event.channel);
        e.a(paramJSONObject, "mf", this.e);
        if (this.m > 0L) {
          e.a(paramJSONObject, "sv", b.a(this.l, this.m));
        }
        e.a(paramJSONObject, "osd", Build.DISPLAY);
        e.a(paramJSONObject, "prod", Build.PRODUCT);
        e.a(paramJSONObject, "tags", Build.TAGS);
        e.a(paramJSONObject, "id", Build.ID);
        e.a(paramJSONObject, "fng", Build.FINGERPRINT);
        e.a(paramJSONObject, "ov", Integer.toString(this.c));
        paramJSONObject.put("os", 1);
        e.a(paramJSONObject, "op", this.g);
        e.a(paramJSONObject, "lg", this.f);
        e.a(paramJSONObject, "md", this.d);
        e.a(paramJSONObject, "tz", this.h);
        if (this.j != 0) {
          paramJSONObject.put("jb", this.j);
        }
        e.a(paramJSONObject, "sd", this.i);
        e.a(paramJSONObject, "abi", Build.CPU_ABI);
        e.a(paramJSONObject, "ram", this.n);
        e.a(paramJSONObject, "rom", this.o);
        return;
        e.a(paramJSONObject, "thn", paramThread.getName());
        if ((b.c(this.n)) && (this.n.split("/").length == 2)) {
          e.a(paramJSONObject, "fram", this.n.split("/")[0]);
        }
        if ((b.c(this.o)) && (this.o.split("/").length == 2)) {
          e.a(paramJSONObject, "from", this.o.split("/")[0]);
        }
        paramJSONObject.put("ui", CustomDeviceInfos.getFacilityIdentity(this.l));
        e.a(paramJSONObject, "mid", XGPushConfig.getToken(this.l));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.stat.b.a
 * JD-Core Version:    0.7.0.1
 */