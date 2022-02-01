package com.tencent.android.tpush.stat.event;

import android.content.Context;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.tpns.baseapi.XGApiConfig;
import com.tencent.tpns.baseapi.base.device.GuidInfoManager;
import com.tencent.tpns.baseapi.base.util.TGlobalHelper;
import com.tencent.tpns.dataacquisition.DeviceInfos;
import org.json.JSONObject;

public class g
  extends Event
{
  public String a = null;
  public String b = null;
  public int l;
  public String m;
  public long n = 0L;
  public String o;
  public byte p;
  public String q;
  
  public g(Context paramContext, int paramInt, String paramString)
  {
    super(paramContext, XGApiConfig.getAccessKey(paramContext), XGApiConfig.getAccessId(paramContext));
    this.c = XGApiConfig.getAccessKey(paramContext);
    this.d = XGApiConfig.getAccessId(paramContext);
    this.a = GuidInfoManager.getToken(paramContext.getApplicationContext());
    this.b = "1.2.7.3";
    this.l = paramInt;
    this.o = paramString;
    this.p = DeviceInfos.getNetworkType(paramContext);
    this.q = TGlobalHelper.getDM(paramContext);
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
      paramObject = (g)paramObject;
      try
      {
        if ((this.d == paramObject.d) && (this.e == paramObject.e) && (this.a.equals(paramObject.a)) && (this.b.equals(paramObject.b)) && (this.l == paramObject.l) && (this.m.equals(paramObject.m)) && (this.n == paramObject.n) && (this.o.equals(paramObject.o)) && (this.p == paramObject.p))
        {
          boolean bool = this.q.equals(paramObject.q);
          if (bool) {}
        }
        else
        {
          return false;
        }
      }
      catch (Throwable paramObject)
      {
        TLogger.d("RspErrcodeEvent equals Error:", paramObject.getMessage());
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
    return EventType.ERRCODE;
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
      if (this.a != null) {
        ((JSONObject)localObject).put("token", this.a);
      }
      if (this.c != null) {
        ((JSONObject)localObject).put("accessKey", this.c);
      }
      if (this.b != null) {
        ((JSONObject)localObject).put("sdkVersion", this.b);
      }
      ((JSONObject)localObject).put("et", getType().GetIntValue());
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("errCode", this.l);
      if (this.m != null) {
        localJSONObject.put("msg", this.m);
      }
      if (0L != this.n) {
        localJSONObject.put("id", this.n);
      }
      ((JSONObject)localObject).put("errCode", localJSONObject);
      if (this.o != null) {
        ((JSONObject)localObject).put("errType", this.o);
      }
      ((JSONObject)localObject).put("networkType", this.p);
      if (this.q != null) {
        ((JSONObject)localObject).put("deviceModel", this.q);
      }
      localObject = ((JSONObject)localObject).toString();
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      TLogger.e("RspErrcodeEvent toJson Error:", localThrowable.getMessage());
    }
    return null;
  }
  
  public String toString()
  {
    return toJsonString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.stat.event.g
 * JD-Core Version:    0.7.0.1
 */