package com.tencent.android.tpush.stat.event;

import android.content.Context;
import com.tencent.android.tpush.XGPushConfig;
import com.tencent.android.tpush.service.cache.CacheManager;
import com.tencent.android.tpush.stat.b.b;
import com.tencent.android.tpush.stat.b.e;
import com.tencent.tpns.dataacquisition.CustomDeviceInfos;
import org.json.JSONObject;

public abstract class Event
{
  public static String channel = "xgsdk";
  protected static String h = null;
  protected static long i = 0L;
  protected String c = null;
  protected long d = 0L;
  protected long e;
  protected int f;
  protected String g = null;
  protected long j = 0L;
  protected Context k;
  
  public Event(Context paramContext)
  {
    a(paramContext, 0, this.d);
  }
  
  public Event(Context paramContext, int paramInt, long paramLong)
  {
    this.c = ("Axg" + paramLong);
    a(paramContext, paramInt, paramLong);
  }
  
  public Event(Context paramContext, String paramString)
  {
    this.c = paramString;
    a(paramContext, 0, this.d);
  }
  
  public Event(Context paramContext, String paramString, long paramLong)
  {
    this.c = paramString;
    a(paramContext, 0, paramLong);
  }
  
  private void a(Context paramContext, int paramInt, long paramLong)
  {
    this.k = paramContext;
    this.d = paramLong;
    this.e = (System.currentTimeMillis() / 1000L);
    this.f = paramInt;
    this.g = b.b(paramContext, paramLong);
    if ((h == null) || (h.trim().length() < 40))
    {
      h = XGPushConfig.getToken(paramContext);
      if (!b.c(h)) {
        h = "0";
      }
    }
    if (i == 0L) {
      i = CacheManager.getGuid(getContext());
    }
  }
  
  public boolean decode(JSONObject paramJSONObject)
  {
    return true;
  }
  
  public boolean encode(JSONObject paramJSONObject)
  {
    try
    {
      e.a(paramJSONObject, "ky", this.c);
      EventType localEventType = getType();
      if (localEventType != null) {
        paramJSONObject.put("et", localEventType.GetIntValue());
      }
      paramJSONObject.put("ui", e.a(this.k));
      e.a(paramJSONObject, "mc", CustomDeviceInfos.getFacilityMacAddr(this.k));
      paramJSONObject.put("ut", 1);
      if (getType() != EventType.SESSION_ENV)
      {
        e.a(paramJSONObject, "av", this.g);
        e.a(paramJSONObject, "ch", channel);
      }
      e.a(paramJSONObject, "mid", h);
      paramJSONObject.put("si", this.f);
      if (getType() == EventType.CUSTOM)
      {
        paramJSONObject.put("cts", this.e);
        if ((this.j == 0L) && (this.e != 0L))
        {
          paramJSONObject.put("ts", this.e);
          if (!"0".equals(b.a(this.k, this.d))) {
            break label256;
          }
          paramJSONObject.put("sv", b.a(this.k));
        }
      }
      for (;;)
      {
        paramJSONObject.put("guid", i);
        paramJSONObject.put("dts", b.a(this.k, false));
        return onEncode(paramJSONObject);
        paramJSONObject.put("ts", this.j);
        break;
        paramJSONObject.put("ts", this.e);
        break;
        label256:
        paramJSONObject.put("sv", b.a(this.k, this.d));
      }
      return false;
    }
    catch (Throwable paramJSONObject) {}
  }
  
  public long getAccessid()
  {
    return this.d;
  }
  
  public String getAppkey()
  {
    return this.c;
  }
  
  public Context getContext()
  {
    return this.k;
  }
  
  public long getMsgTimeSec()
  {
    return this.j;
  }
  
  public long getTimestamp()
  {
    return this.e;
  }
  
  public abstract EventType getType();
  
  public abstract boolean onEncode(JSONObject paramJSONObject);
  
  public void setAccessid(long paramLong)
  {
    this.d = paramLong;
  }
  
  public void setAppkey(String paramString)
  {
    this.c = paramString;
  }
  
  public void setMsgTimeSec(long paramLong)
  {
    this.j = paramLong;
  }
  
  public String toJsonString()
  {
    try
    {
      Object localObject = new JSONObject();
      encode((JSONObject)localObject);
      localObject = ((JSONObject)localObject).toString();
      return localObject;
    }
    catch (Throwable localThrowable) {}
    return "";
  }
  
  public String toString()
  {
    return toJsonString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.stat.event.Event
 * JD-Core Version:    0.7.0.1
 */