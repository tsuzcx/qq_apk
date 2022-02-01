package com.tencent.android.tpush;

import android.app.Notification;
import android.content.Context;
import android.util.Pair;
import org.json.JSONObject;

public class XGBasicPushNotificationBuilder
  extends XGPushNotificationBuilder
{
  protected void a(JSONObject paramJSONObject) {}
  
  protected void b(JSONObject paramJSONObject) {}
  
  public Pair<Notification, Object> buildNotification(Context paramContext)
  {
    return a(paramContext);
  }
  
  public String getType()
  {
    return "basic";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.XGBasicPushNotificationBuilder
 * JD-Core Version:    0.7.0.1
 */