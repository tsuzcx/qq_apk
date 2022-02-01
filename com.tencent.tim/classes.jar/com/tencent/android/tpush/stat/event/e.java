package com.tencent.android.tpush.stat.event;

import android.content.Context;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.stat.b.b;
import com.tencent.tpns.baseapi.XGApiConfig;
import com.tencent.tpns.baseapi.base.device.GuidInfoManager;
import org.json.JSONObject;

public class e
  extends Event
{
  private int a = 1;
  private int b;
  private long l;
  
  public e(Context paramContext, int paramInt1, int paramInt2, long paramLong)
  {
    super(paramContext);
    this.a = paramInt1;
    this.b = paramInt2;
    this.l = paramLong;
  }
  
  public EventType getType()
  {
    return EventType.LAUNCH;
  }
  
  public boolean onEncode(JSONObject paramJSONObject)
  {
    return true;
  }
  
  public String toJsonString()
  {
    Object localObject = new JSONObject();
    try
    {
      EventType localEventType = getType();
      if (localEventType != null) {
        ((JSONObject)localObject).put("et", localEventType.GetIntValue());
      }
      ((JSONObject)localObject).put("launchType", this.a);
      ((JSONObject)localObject).put("sdkVersion", "1.2.7.3");
      ((JSONObject)localObject).put("token", GuidInfoManager.getToken(this.k.getApplicationContext()));
      ((JSONObject)localObject).put("accessId", XGApiConfig.getAccessId(this.k));
      ((JSONObject)localObject).put("appkey", XGApiConfig.getAccessKey(this.k));
      ((JSONObject)localObject).put("timestamp", System.currentTimeMillis() / 1000L);
      ((JSONObject)localObject).put("idx", b.a());
      ((JSONObject)localObject).put("firstLaunch", this.b);
      if (this.a == 3) {
        ((JSONObject)localObject).put("pushId", this.l);
      }
      localObject = ((JSONObject)localObject).toString();
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      TLogger.e("LaunchEvent toJson Error:", localThrowable.getMessage());
    }
    return "";
  }
  
  public String toString()
  {
    return toJsonString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.stat.event.e
 * JD-Core Version:    0.7.0.1
 */