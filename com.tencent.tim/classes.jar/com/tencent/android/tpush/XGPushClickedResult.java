package com.tencent.android.tpush;

import android.content.Intent;
import com.tencent.android.tpush.encrypt.Rijndael;
import com.tencent.android.tpush.logging.TLogger;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class XGPushClickedResult
  implements XGIResult, Serializable
{
  public static final int NOTIFACTION_CLICKED_TYPE = NotificationAction.clicked.getType();
  public static final int NOTIFACTION_DELETED_TYPE;
  public static final int NOTIFACTION_DOWNLOAD_CANCEL_TYPE = NotificationAction.download_cancel.getType();
  public static final int NOTIFACTION_DOWNLOAD_TYPE;
  public static final int NOTIFACTION_OPEN_CANCEL_TYPE;
  public static final int NOTIFACTION_OPEN_TYPE;
  public static final int NOTIFICATION_ACTION_ACTIVITY = NotificationAction.activity.getType();
  private static final String TAG = "XGPushClickedResult";
  private static final long serialVersionUID = 5485267763104201539L;
  int actionType = NotificationAction.clicked.getType();
  String activityName = "";
  String content = "";
  String customContent = "";
  long msgId = 0L;
  int notificationActionType = NotificationAction.activity.getType();
  int pushChannel = 100;
  String templateId = "";
  String title = "";
  String traceId = "";
  
  static
  {
    NOTIFACTION_DELETED_TYPE = NotificationAction.delete.getType();
    NOTIFACTION_OPEN_TYPE = NotificationAction.open.getType();
    NOTIFACTION_OPEN_CANCEL_TYPE = NotificationAction.open_cancel.getType();
    NOTIFACTION_DOWNLOAD_TYPE = NotificationAction.download.getType();
  }
  
  public long getActionType()
  {
    return this.actionType;
  }
  
  public String getActivityName()
  {
    return this.activityName;
  }
  
  public String getContent()
  {
    return this.content;
  }
  
  public String getCustomContent()
  {
    return this.customContent;
  }
  
  public long getMsgId()
  {
    return this.msgId;
  }
  
  public int getNotificationActionType()
  {
    return this.notificationActionType;
  }
  
  public int getPushChannel()
  {
    return this.pushChannel;
  }
  
  public String getTemplateId()
  {
    return this.templateId;
  }
  
  public String getTitle()
  {
    return this.title;
  }
  
  public String getTraceId()
  {
    return this.traceId;
  }
  
  public void parseIntent(Intent paramIntent)
  {
    this.msgId = paramIntent.getLongExtra("msgId", -1L);
    this.activityName = paramIntent.getStringExtra("activity");
    this.title = Rijndael.decrypt(paramIntent.getStringExtra("title"));
    this.content = Rijndael.decrypt(paramIntent.getStringExtra("content"));
    this.customContent = Rijndael.decrypt(paramIntent.getStringExtra("custom_content"));
    this.actionType = paramIntent.getIntExtra("action", NotificationAction.clicked.getType());
    this.notificationActionType = paramIntent.getIntExtra("notificationActionType", NotificationAction.activity.getType());
    this.pushChannel = paramIntent.getIntExtra("PUSH.CHANNEL", 100);
    this.templateId = paramIntent.getStringExtra("templateId");
    this.traceId = paramIntent.getStringExtra("traceId");
    if ((this.pushChannel == 101) || (this.pushChannel == 99)) {}
    try
    {
      this.activityName = URLDecoder.decode(this.activityName, "UTF-8");
      return;
    }
    catch (UnsupportedEncodingException paramIntent)
    {
      TLogger.d("XGPushClickedResult", "parseIntent activityName :" + paramIntent.toString());
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("XGPushClickedResult [msgId = ").append(this.msgId).append(", title = ").append(this.title).append(", content = ").append(this.content).append(", customContent = ").append(this.customContent).append(", activityName = ").append(this.activityName).append(", actionType = ").append(this.actionType).append(", pushChannel = ").append(this.pushChannel).append(", notificationActionType = ").append(this.notificationActionType).append(", templateId = ").append(this.templateId).append(", traceId = ").append(this.traceId).append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.XGPushClickedResult
 * JD-Core Version:    0.7.0.1
 */