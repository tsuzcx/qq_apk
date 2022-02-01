package com.tencent.android.tpush.stat.event;

import android.content.Context;
import android.os.Build.VERSION;
import com.tencent.android.tpush.common.AppInfos;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.tpns.baseapi.XGApiConfig;
import com.tencent.tpns.baseapi.base.device.GuidInfoManager;
import org.json.JSONObject;

public class b
  extends Event
{
  public String a;
  public long b = 0L;
  private String l = null;
  private String m = null;
  private String n = null;
  private long o = 0L;
  private int p = 0;
  
  public b(Context paramContext, long paramLong, int paramInt)
  {
    super(paramContext, XGApiConfig.getAccessKey(paramContext), XGApiConfig.getAccessId(paramContext));
    this.c = XGApiConfig.getAccessKey(paramContext);
    this.d = XGApiConfig.getAccessId(paramContext);
    this.l = GuidInfoManager.getToken(paramContext.getApplicationContext());
    this.m = "1.2.7.3";
    this.n = AppInfos.getCurAppVersion(paramContext);
    this.o = paramLong;
    this.p = paramInt;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    for (;;)
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (b)paramObject;
      try
      {
        if ((this.d == paramObject.d) && (this.e == paramObject.e) && (this.l.equals(paramObject.l)) && (this.m.equals(paramObject.m)) && (this.a.equals(paramObject.a)))
        {
          long l1 = this.b;
          long l2 = paramObject.b;
          if (l1 == l2) {}
        }
        else
        {
          return false;
        }
      }
      catch (Throwable paramObject)
      {
        TLogger.d("CloudEvent equals Error:", paramObject.getMessage());
      }
    }
    return false;
  }
  
  public long getAccessid()
  {
    return this.d;
  }
  
  public EventType getType()
  {
    return null;
  }
  
  public int hashCode()
  {
    return super.hashCode();
  }
  
  public boolean onEncode(JSONObject paramJSONObject)
  {
    return true;
  }
  
  public void setAccessid(long paramLong)
  {
    this.d = paramLong;
  }
  
  public String toJsonString()
  {
    Object localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("accessId", this.d);
      ((JSONObject)localObject).put("timestamp", this.e);
      if (this.l != null) {
        ((JSONObject)localObject).put("token", this.l);
      }
      if (this.c != null) {
        ((JSONObject)localObject).put("accessKey", this.c);
      }
      if (this.m != null) {
        ((JSONObject)localObject).put("sdkVersion", this.m);
      }
      if (this.n != null) {
        ((JSONObject)localObject).put("appVersion", this.n);
      }
      ((JSONObject)localObject).put("et", 4);
      ((JSONObject)localObject).put("sdkVersionName", Build.VERSION.RELEASE);
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("cloudVersion", this.o);
      localJSONObject.put("cloudControlRet", this.p);
      ((JSONObject)localObject).put("cloudMsg", localJSONObject);
      localObject = ((JSONObject)localObject).toString();
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      TLogger.e("CloudEvent toJson Error:", localThrowable.getMessage());
    }
    return null;
  }
  
  public String toString()
  {
    return toJsonString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.stat.event.b
 * JD-Core Version:    0.7.0.1
 */