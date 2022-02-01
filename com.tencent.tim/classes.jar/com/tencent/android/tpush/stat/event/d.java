package com.tencent.android.tpush.stat.event;

import android.content.Context;
import android.os.Process;
import android.support.annotation.Nullable;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.stat.b.a;
import com.tencent.android.tpush.stat.b.b;
import com.tencent.tpns.baseapi.base.logger.DeviceInfo;
import org.json.JSONArray;
import org.json.JSONObject;

public class d
  extends Event
{
  private static DeviceInfo a = null;
  private String b;
  private JSONArray l;
  private int m;
  private Thread n = null;
  private String o = null;
  private long p = -1L;
  private String q = null;
  private String r = null;
  private String s = null;
  
  public d(Context paramContext, int paramInt1, int paramInt2, JSONArray paramJSONArray, long paramLong)
  {
    super(paramContext, 0, paramLong);
    this.m = paramInt2;
    this.l = paramJSONArray;
  }
  
  private JSONObject a(Thread paramThread)
  {
    JSONObject localJSONObject = new JSONObject();
    if (paramThread != null)
    {
      localJSONObject.put("id", paramThread.getId());
      localJSONObject.put("name", paramThread.getName());
      localJSONObject.put("pr", paramThread.getPriority());
    }
    if (this.p > -1L) {
      localJSONObject.put("gthn", this.p);
    }
    return localJSONObject;
  }
  
  private void a(JSONObject paramJSONObject)
  {
    paramJSONObject.put("md5", b.a(this.b));
    paramJSONObject.put("ct", this.m);
    paramJSONObject.put("bid", this.k.getPackageName());
    paramJSONObject.put("dt", System.currentTimeMillis() / 1000L);
  }
  
  private void b(JSONObject paramJSONObject)
  {
    localJSONObject = a(this.n);
    try
    {
      if (a == null) {
        a = new DeviceInfo(this.k);
      }
      localJSONObject.put("deviceInfo", a);
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        TLogger.w("ErrorEvent", "unexpected for encodeCrashThread");
        continue;
        localJSONObject.put("stack", this.b);
        if (this.p > -1L) {
          localJSONObject.put("gfra", this.b);
        }
      }
    }
    if (this.l != null)
    {
      localJSONObject.put("stack", this.l);
      if (this.p > -1L) {
        localJSONObject.put("gfra", this.l);
      }
      paramJSONObject.put("cth", localJSONObject);
      if (this.m == 3) {
        localJSONObject.put("nfra", this.s);
      }
      return;
    }
  }
  
  public void a(String paramString)
  {
    this.o = paramString;
  }
  
  public boolean a()
  {
    if (this.l != null) {}
    for (String str = this.l.toString(); (str.contains("com.tencent.android.tpush.")) || (str.contains("com.tencent.android.tpns.")) || (str.contains("com.tencent.tpns.")); str = this.b) {
      return true;
    }
    return false;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this == paramObject) {}
    for (;;)
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (d)paramObject;
      try
      {
        if ((this.d == paramObject.d) && (this.q.equals(paramObject.q)) && (this.r.equals(paramObject.r)))
        {
          boolean bool = this.l.toString().equals(paramObject.l.toString());
          if (bool) {}
        }
        else
        {
          return false;
        }
      }
      catch (Throwable paramObject)
      {
        TLogger.w("ErrorEvent", "unexpected for equals");
      }
    }
    return false;
  }
  
  public EventType getType()
  {
    return EventType.ERROR;
  }
  
  public int hashCode()
  {
    return super.hashCode();
  }
  
  public boolean onEncode(JSONObject paramJSONObject)
  {
    paramJSONObject.put("cmode", 2);
    paramJSONObject.put("ea", this.m);
    paramJSONObject.put("prcp", Process.myPid());
    paramJSONObject.put("prct", Process.myTid());
    new a(this.k, this.d).a(paramJSONObject, this.n);
    b(paramJSONObject);
    a(paramJSONObject);
    return true;
  }
  
  public String toJsonString()
  {
    Object localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("accessId", this.d);
      ((JSONObject)localObject).put("timestamp", this.e);
      if (this.q != null) {
        ((JSONObject)localObject).put("token", this.q);
      }
      if (this.c != null) {
        ((JSONObject)localObject).put("accessKey", this.c);
      }
      if (this.r != null) {
        ((JSONObject)localObject).put("sdkVersion", this.r);
      }
      ((JSONObject)localObject).put("et", getType().GetIntValue());
      b((JSONObject)localObject);
      localObject = ((JSONObject)localObject).toString();
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      TLogger.w("ErrorEvent", "unexpected for toJsonString");
    }
    return null;
  }
  
  public String toString()
  {
    return toJsonString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.stat.event.d
 * JD-Core Version:    0.7.0.1
 */