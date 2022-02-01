package com.tencent.android.tpush.stat.event;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.message.PushMessageManager;
import com.tencent.android.tpush.stat.b.b;
import com.tencent.tpns.baseapi.XGApiConfig;
import com.tencent.tpns.baseapi.base.device.GuidInfoManager;
import org.json.JSONObject;

public class MQTTEvent
  extends Event
{
  public long accessid = 0L;
  public String appVersion = null;
  public String appkey = null;
  public String eventId = null;
  public long msgBusiId;
  public long msgId = -1L;
  public long msgType = -1L;
  public String nGroupId = null;
  public JSONObject prop = null;
  public int pushAction = -1;
  public int pushChannel;
  public long pushtime;
  public String sdkVersion = null;
  public long source = 0L;
  public long targetType = 0L;
  public String templateId = "";
  public long timestamp;
  public String token = null;
  public String traceId = "";
  
  public MQTTEvent(Context paramContext)
  {
    super(paramContext, XGApiConfig.getAccessKey(paramContext), XGApiConfig.getAccessId(paramContext));
    this.appkey = XGApiConfig.getAccessKey(paramContext);
    this.accessid = XGApiConfig.getAccessId(paramContext);
  }
  
  public MQTTEvent(Context paramContext, long paramLong)
  {
    this(paramContext, XGApiConfig.getAccessKey(paramContext), paramLong);
  }
  
  public MQTTEvent(Context paramContext, long paramLong, PushMessageManager paramPushMessageManager)
  {
    this(paramContext, paramLong);
    a(paramPushMessageManager);
  }
  
  public MQTTEvent(Context paramContext, String paramString, long paramLong)
  {
    super(paramContext, paramString, paramLong);
    this.appkey = paramString;
    this.accessid = paramLong;
  }
  
  private void a(PushMessageManager paramPushMessageManager)
  {
    this.msgBusiId = paramPushMessageManager.getBusiMsgId();
    this.timestamp = (System.currentTimeMillis() / 1000L);
    this.pushtime = (paramPushMessageManager.getTimestamps() / 1000L);
    this.pushChannel = paramPushMessageManager.pushChannel;
    this.appVersion = b.c(this.k);
    this.sdkVersion = "1.2.7.3";
    this.token = GuidInfoManager.getToken(this.k);
    this.msgId = paramPushMessageManager.getMsgId();
    this.msgType = paramPushMessageManager.getType();
    this.nGroupId = paramPushMessageManager.getGroupId();
    this.targetType = paramPushMessageManager.getTargetType();
    this.source = paramPushMessageManager.getSource();
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
      paramObject = (MQTTEvent)paramObject;
      try
      {
        if ((this.accessid == paramObject.accessid) && (this.timestamp == paramObject.timestamp) && (this.msgType == paramObject.msgType) && (this.pushAction == paramObject.pushAction) && (this.msgId == paramObject.msgId) && (this.appVersion.equals(paramObject.appVersion)) && (this.token.equals(paramObject.token)) && (this.targetType == paramObject.targetType))
        {
          long l1 = this.source;
          long l2 = paramObject.source;
          if (l1 == l2) {}
        }
        else
        {
          return false;
        }
      }
      catch (Throwable paramObject)
      {
        TLogger.d("MQTTEvent equals Error:", paramObject.getMessage());
      }
    }
    return false;
  }
  
  public long getAccessid()
  {
    return this.accessid;
  }
  
  public String getAppkey()
  {
    return this.appkey;
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
    this.accessid = paramLong;
  }
  
  public void setAppkey(String paramString)
  {
    this.appkey = paramString;
  }
  
  public String toJsonString()
  {
    Object localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("accessId", this.accessid);
      ((JSONObject)localObject).put("pushAction", this.pushAction);
      ((JSONObject)localObject).put("msgId", this.msgId);
      ((JSONObject)localObject).put("msgType", this.msgType);
      ((JSONObject)localObject).put("msgId", this.msgId);
      ((JSONObject)localObject).put("pushtime", this.pushtime);
      ((JSONObject)localObject).put("timestamp", this.timestamp);
      ((JSONObject)localObject).put("templateId", this.templateId);
      ((JSONObject)localObject).put("traceId", this.traceId);
      if (this.token != null) {
        ((JSONObject)localObject).put("token", this.token);
      }
      if (this.appkey != null) {
        ((JSONObject)localObject).put("accessKey", this.appkey);
      }
      if (this.appVersion != null) {
        ((JSONObject)localObject).put("appVersion", this.appVersion);
      }
      if (this.sdkVersion != null) {
        ((JSONObject)localObject).put("sdkVersion", this.sdkVersion);
      }
      if (this.nGroupId != null) {
        ((JSONObject)localObject).put("groupId", this.nGroupId);
      }
      ((JSONObject)localObject).put("pushChannel", this.pushChannel);
      if (this.targetType > 0L) {
        ((JSONObject)localObject).put("targetType", this.targetType);
      }
      if (this.source > 0L) {
        ((JSONObject)localObject).put("source", this.source);
      }
      if ((this.eventId != null) && (!TextUtils.isEmpty(this.eventId)))
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("eventId", this.eventId);
        if ((this.prop != null) && (this.prop.length() != 0)) {
          localJSONObject.put("kv", this.prop);
        }
        ((JSONObject)localObject).put("customEvent", localJSONObject);
      }
      localObject = ((JSONObject)localObject).toString();
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      TLogger.d("MQTTEvent toJsonString Error:", localThrowable.getMessage());
    }
    return null;
  }
  
  public String toString()
  {
    return toJsonString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.stat.event.MQTTEvent
 * JD-Core Version:    0.7.0.1
 */