package com.tencent.androidqqmail.tim;

import android.content.Context;
import android.content.Intent;
import com.tencent.qqmail.QMApplicationContext;

public class TimNotificationManager
{
  private static TimNotificationManager protocolNotificationManager = new TimNotificationManager();
  
  public static TimNotificationManager getInstance()
  {
    return protocolNotificationManager;
  }
  
  public void notifyPreloadFinished()
  {
    Intent localIntent = new Intent();
    localIntent.setPackage("com.tencent.tim");
    localIntent.setAction("com.tencent.androidqqmail.tim.mail.broadcast");
    localIntent.putExtra("cmd", "preloadfinish");
    QMApplicationContext.sharedInstance().getApplicationContext().sendBroadcast(localIntent);
  }
  
  public void updateNewMailCount(String paramString, int paramInt)
  {
    if (paramInt == 0) {
      return;
    }
    Intent localIntent = new Intent();
    localIntent.setPackage("com.tencent.tim");
    localIntent.setAction("com.tencent.androidqqmail.tim.mail.broadcast");
    localIntent.putExtra("cmd", "getMailUnreadNum");
    localIntent.putExtra("unreadNum", paramInt);
    localIntent.putExtra("email", paramString);
    QMApplicationContext.sharedInstance().getApplicationContext().sendBroadcast(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.androidqqmail.tim.TimNotificationManager
 * JD-Core Version:    0.7.0.1
 */