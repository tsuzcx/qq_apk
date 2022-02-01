package com.tencent.android.tpush.stat.event;

import android.content.Context;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.stat.b.b;
import com.tencent.tpns.baseapi.XGApiConfig;
import com.tencent.tpns.baseapi.base.device.GuidInfoManager;
import java.util.Properties;
import org.json.JSONArray;
import org.json.JSONObject;

public class c
  extends Event
{
  protected a a = new a();
  protected long b = -1L;
  
  public c(Context paramContext, int paramInt, String paramString, long paramLong1, long paramLong2)
  {
    super(paramContext, paramInt, paramLong1);
    this.a.a = paramString;
    this.j = paramLong2;
  }
  
  public a a()
  {
    return this.a;
  }
  
  public EventType getType()
  {
    return EventType.CUSTOM;
  }
  
  public boolean onEncode(JSONObject paramJSONObject)
  {
    return true;
  }
  
  public String toJsonString()
  {
    Object localObject1 = new JSONObject();
    try
    {
      Object localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("eventId", this.a.a);
      if ((this.a.c != null) && (this.a.c.length() != 0)) {
        ((JSONObject)localObject2).put("kv", this.a.c);
      }
      ((JSONObject)localObject1).put("customEvent", localObject2);
      localObject2 = getType();
      if (localObject2 != null) {
        ((JSONObject)localObject1).put("et", ((EventType)localObject2).GetIntValue());
      }
      ((JSONObject)localObject1).put("sdkVersion", "1.2.7.3");
      ((JSONObject)localObject1).put("token", GuidInfoManager.getToken(this.k.getApplicationContext()));
      ((JSONObject)localObject1).put("accessId", XGApiConfig.getAccessId(this.k));
      ((JSONObject)localObject1).put("timestamp", System.currentTimeMillis() / 1000L);
      ((JSONObject)localObject1).put("idx", b.a());
      localObject1 = ((JSONObject)localObject1).toString();
      return localObject1;
    }
    catch (Throwable localThrowable)
    {
      TLogger.e("CustomEvent toJson Error:", localThrowable.getMessage());
    }
    return "";
  }
  
  public String toString()
  {
    return toJsonString();
  }
  
  public static class a
  {
    public String a;
    public JSONArray b;
    public JSONObject c = null;
    public boolean d = false;
    
    public a() {}
    
    public a(String paramString, String[] paramArrayOfString, Properties paramProperties)
    {
      this.a = paramString;
      if (paramProperties != null) {
        this.c = new JSONObject(paramProperties);
      }
      for (;;)
      {
        return;
        if (paramArrayOfString == null) {
          break;
        }
        this.b = new JSONArray();
        int j = paramArrayOfString.length;
        while (i < j)
        {
          paramString = paramArrayOfString[i];
          this.b.put(paramString);
          i += 1;
        }
      }
      this.c = new JSONObject();
    }
    
    public boolean equals(Object paramObject)
    {
      if (paramObject == null) {}
      do
      {
        return false;
        if (this == paramObject) {
          return true;
        }
      } while (!(paramObject instanceof a));
      paramObject = (a)paramObject;
      return toString().equals(paramObject.toString());
    }
    
    public int hashCode()
    {
      return toString().hashCode();
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder(32);
      localStringBuilder.append(this.a).append(",");
      if (this.b != null) {
        localStringBuilder.append(this.b.toString());
      }
      if (this.c != null) {
        localStringBuilder.append(this.c.toString());
      }
      return localStringBuilder.toString();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.stat.event.c
 * JD-Core Version:    0.7.0.1
 */