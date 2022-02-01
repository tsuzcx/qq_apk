package com.tencent.qqmail.notificationshortcut;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat.Builder;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.utilities.BrandUtil;
import com.tencent.qqmail.utilities.VersionUtils;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.ui.QMUIKit;

public class NotificationShortCutManager
{
  static final int PENDINGINTENT_TYPE_CALENDAR = 104;
  static final int PENDINGINTENT_TYPE_COMPOSEMAIL = 101;
  static final int PENDINGINTENT_TYPE_COMPOSENOTE = 102;
  static final int PENDINGINTENT_TYPE_DISMISS = 100;
  static final String PENDINGINTENT_TYPE_EXTRA_KEY = "PENDINGINTENT_TYPE_EXTRA_KEY";
  static final int PENDINGINTENT_TYPE_SCAN = 103;
  static final int PENDINGINTENT_TYPE_SETTING = 105;
  private static final String TAG = "NotifShortCutManager";
  
  public static void enable(@NonNull Context paramContext, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramContext.startService(new Intent(paramContext, ShortcutService.class));
      return;
    }
    paramContext.stopService(new Intent(paramContext, ShortcutService.class));
  }
  
  public static void ensure(@NonNull Context paramContext)
  {
    if (QMSettingManager.sharedInstance().getNotificationShortCutEnable()) {
      enable(paramContext, true);
    }
  }
  
  private static PendingIntent getAddCalenderPendingIntent(@NonNull Context paramContext)
  {
    Intent localIntent = new Intent(paramContext, ShortCutNotificationBroadcastReceiver.class);
    localIntent.putExtra("PENDINGINTENT_TYPE_EXTRA_KEY", 104);
    return PendingIntent.getBroadcast(paramContext.getApplicationContext(), 104, localIntent, 134217728);
  }
  
  private static PendingIntent getComposeMailPendingIntent(@NonNull Context paramContext)
  {
    Intent localIntent = new Intent(paramContext, ShortCutNotificationBroadcastReceiver.class);
    localIntent.putExtra("PENDINGINTENT_TYPE_EXTRA_KEY", 101);
    return PendingIntent.getBroadcast(paramContext.getApplicationContext(), 101, localIntent, 134217728);
  }
  
  private static PendingIntent getComposeNotePendingIntent(@NonNull Context paramContext)
  {
    Intent localIntent = new Intent(paramContext, ShortCutNotificationBroadcastReceiver.class);
    localIntent.putExtra("PENDINGINTENT_TYPE_EXTRA_KEY", 102);
    return PendingIntent.getBroadcast(paramContext.getApplicationContext(), 102, localIntent, 134217728);
  }
  
  private static RemoteViews getCustomLayout(@NonNull Context paramContext)
  {
    int i = NotificationColorUtils.getNotificationColor(paramContext);
    RemoteViews localRemoteViews = new RemoteViews(paramContext.getPackageName(), 2131559472);
    localRemoteViews.setOnClickPendingIntent(2131378270, getComposeMailPendingIntent(paramContext));
    localRemoteViews.setOnClickPendingIntent(2131378271, getComposeNotePendingIntent(paramContext));
    localRemoteViews.setOnClickPendingIntent(2131378274, getScanPendingIntent(paramContext));
    localRemoteViews.setOnClickPendingIntent(2131378269, getAddCalenderPendingIntent(paramContext));
    localRemoteViews.setOnClickPendingIntent(2131378275, getSettingPendingIntent(paramContext));
    QMLog.log(4, "NotifShortCutManager", "Get NotificationColor = " + i);
    if (i != -1)
    {
      localRemoteViews.setTextColor(2131364173, i);
      localRemoteViews.setTextColor(2131365176, i);
      localRemoteViews.setTextColor(2131365184, i);
      localRemoteViews.setTextColor(2131365194, i);
      boolean bool = QMUIKit.isColorClosedToWhite(i);
      QMLog.log(4, "NotifShortCutManager", "isColorColosedToWhite = " + bool);
      if (!QMUIKit.isColorClosedToWhite(i))
      {
        localRemoteViews.setInt(2131365175, "setImageResource", 2130842260);
        localRemoteViews.setInt(2131365182, "setImageResource", 2130842262);
        localRemoteViews.setInt(2131365193, "setImageResource", 2130842256);
        localRemoteViews.setInt(2131364162, "setImageResource", 2130842254);
        localRemoteViews.setInt(2131378134, "setImageResource", 2130842258);
      }
    }
    return localRemoteViews;
  }
  
  private static PendingIntent getDismissPendingIntent(@NonNull Context paramContext)
  {
    Intent localIntent = new Intent(paramContext, ShortCutNotificationBroadcastReceiver.class);
    localIntent.putExtra("PENDINGINTENT_TYPE_EXTRA_KEY", 100);
    return PendingIntent.getBroadcast(paramContext.getApplicationContext(), 100, localIntent, 134217728);
  }
  
  private static PendingIntent getScanPendingIntent(@NonNull Context paramContext)
  {
    Intent localIntent = new Intent(paramContext, ShortCutNotificationBroadcastReceiver.class);
    localIntent.putExtra("PENDINGINTENT_TYPE_EXTRA_KEY", 103);
    return PendingIntent.getBroadcast(paramContext.getApplicationContext(), 103, localIntent, 134217728);
  }
  
  private static PendingIntent getSettingPendingIntent(@NonNull Context paramContext)
  {
    Intent localIntent = new Intent(paramContext, ShortCutNotificationBroadcastReceiver.class);
    localIntent.putExtra("PENDINGINTENT_TYPE_EXTRA_KEY", 105);
    return PendingIntent.getBroadcast(paramContext.getApplicationContext(), 105, localIntent, 134217728);
  }
  
  @NonNull
  static Notification getShortNotification(@NonNull Context paramContext)
  {
    NotificationCompat.Builder localBuilder = new NotificationCompat.Builder(paramContext);
    localBuilder.setOngoing(true);
    if (BrandUtil.isColorfulNotificationIcon()) {}
    for (int i = 2130840992;; i = 2130841012)
    {
      localBuilder.setSmallIcon(i);
      localBuilder.setCustomContentView(getCustomLayout(paramContext));
      if (VersionUtils.hasJellyBean()) {
        localBuilder.setPriority(-2);
      }
      localBuilder.setDeleteIntent(getDismissPendingIntent(paramContext));
      return localBuilder.build();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.notificationshortcut.NotificationShortCutManager
 * JD-Core Version:    0.7.0.1
 */