package com.tencent.android.tpush;

import android.content.Intent;
import com.tencent.android.tpush.encrypt.Rijndael;
import com.tencent.android.tpush.logging.TLogger;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class XGPushShowedResult
  implements XGIResult
{
  public static final int NOTIFICATION_ACTION_ACTIVITY = NotificationAction.activity.getType();
  public static final int NOTIFICATION_ACTION_INTENT;
  public static final int NOTIFICATION_ACTION_INTENT_WIHT_ACTION = NotificationAction.intent_with_action.getType();
  public static final int NOTIFICATION_ACTION_PACKAGE;
  public static final int NOTIFICATION_ACTION_URL = NotificationAction.url.getType();
  long a = 0L;
  String b = "";
  String c = "";
  String d = "";
  String e = "";
  int f = 0;
  int g = NotificationAction.activity.getType();
  int h = 100;
  public String templateId = "";
  public String traceId = "";
  
  static
  {
    NOTIFICATION_ACTION_INTENT = NotificationAction.intent.getType();
    NOTIFICATION_ACTION_PACKAGE = NotificationAction.action_package.getType();
  }
  
  public String getActivity()
  {
    return this.e;
  }
  
  public String getContent()
  {
    return this.c;
  }
  
  public String getCustomContent()
  {
    return this.d;
  }
  
  public long getMsgId()
  {
    return this.a;
  }
  
  public int getNotifactionId()
  {
    return this.f;
  }
  
  public int getNotificationActionType()
  {
    return this.g;
  }
  
  public int getPushChannel()
  {
    return this.h;
  }
  
  public String getTemplateId()
  {
    return this.templateId;
  }
  
  public String getTitle()
  {
    return this.b;
  }
  
  public String getTraceId()
  {
    return this.traceId;
  }
  
  public void parseIntent(Intent paramIntent)
  {
    this.a = paramIntent.getLongExtra("msgId", -1L);
    this.e = paramIntent.getStringExtra("activity");
    this.b = Rijndael.decrypt(paramIntent.getStringExtra("title"));
    this.c = Rijndael.decrypt(paramIntent.getStringExtra("content"));
    this.g = paramIntent.getIntExtra("notificationActionType", NotificationAction.activity.getType());
    this.d = Rijndael.decrypt(paramIntent.getStringExtra("custom_content"));
    this.f = paramIntent.getIntExtra("notifaction_id", 0);
    this.h = paramIntent.getIntExtra("PUSH.CHANNEL", 100);
    this.templateId = paramIntent.getStringExtra("templateId");
    this.traceId = paramIntent.getStringExtra("traceId");
    if ((this.h == 101) || (this.h == 99)) {}
    try
    {
      this.e = URLDecoder.decode(this.e, "UTF-8");
      return;
    }
    catch (UnsupportedEncodingException paramIntent)
    {
      TLogger.d("XGPushShowedResult", "parseIntent activityName :" + paramIntent.toString());
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("XGPushShowedResult [msgId = ").append(this.a).append(", title = ").append(this.b).append(", content = ").append(this.c).append(", customContent=").append(this.d).append(", activity = ").append(this.e).append(", notificationActionType = ").append(this.g).append(", pushChannel = ").append(this.h).append(", templateId = ").append(this.templateId).append(", traceId = ").append(this.traceId).append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.XGPushShowedResult
 * JD-Core Version:    0.7.0.1
 */