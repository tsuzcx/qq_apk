package com.tencent.mobileqq.msf.sdk;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.app.NotificationManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build.VERSION;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public final class QNotificationManager
{
  public static final String CHANNEL_ID_OFFLINEMSG = "CHANNEL_ID_OFFLINEMSG";
  public static final String CHANNEL_ID_OTHER = "CHANNEL_ID_MSF";
  private static final CharSequence CHANNEL_NAME_OFFLINEMSG = "离线消息";
  private static final CharSequence CHANNEL_NAME_OTHER;
  private static final String GROUP_ID_TOP = "GROUP_ID_TOP";
  private static final CharSequence GROUP_NAME_TOP = "消息通知";
  public static final String TAG = "QNotificationMsf";
  private NotificationManager localManager = null;
  private HashMap mChannelGroups = new HashMap();
  
  static
  {
    CHANNEL_NAME_OTHER = "其它通知";
  }
  
  public QNotificationManager(Context paramContext)
  {
    this.localManager = ((NotificationManager)paramContext.getSystemService("notification"));
    initOreo(paramContext);
  }
  
  private void createNotificationChannelGroup(String paramString, CharSequence paramCharSequence)
  {
    if (isOreo())
    {
      paramString = new NotificationChannelGroup(paramString, paramCharSequence);
      this.mChannelGroups.put("GROUP_ID_TOP", paramString);
      this.localManager.createNotificationChannelGroup(paramString);
    }
  }
  
  public static boolean isOreo()
  {
    return Build.VERSION.SDK_INT >= 26;
  }
  
  public static void setProperty(Object paramObject1, Class paramClass, String paramString, Object paramObject2)
    throws Exception
  {
    paramClass = paramClass.getDeclaredField(paramString);
    paramClass.setAccessible(true);
    paramClass.set(paramObject1, paramObject2);
  }
  
  public void addChannelIfNeed(Notification paramNotification)
  {
    addChannelIfNeed(paramNotification, "CHANNEL_ID_MSF");
  }
  
  public void addChannelIfNeed(Notification paramNotification, CharSequence paramCharSequence)
  {
    if ((isOreo()) && (BaseApplication.getContext().getApplicationInfo().targetSdkVersion >= 26) && (paramNotification.getChannelId() == null)) {}
    try
    {
      setProperty(paramNotification, Notification.class, "mChannelId", paramCharSequence);
      return;
    }
    catch (Exception paramNotification)
    {
      paramNotification.printStackTrace();
    }
  }
  
  public void cancel(String paramString, int paramInt)
  {
    QLog.i("QNotificationMsf", 1, paramString + " cancel id:" + paramInt);
    if (this.localManager != null) {
      this.localManager.cancel(paramInt);
    }
  }
  
  public void cancelAll()
  {
    QLog.i("QNotificationMsf", 1, "clearAll");
    if (this.localManager != null) {
      this.localManager.cancelAll();
    }
  }
  
  public void cancelUseTag(String paramString1, String paramString2, int paramInt)
  {
    QLog.i("QNotificationMsf", 1, paramString1 + " cancel UseTag:" + paramString2 + " id:" + paramInt);
    if (this.localManager != null) {
      this.localManager.cancel(paramString2, paramInt);
    }
  }
  
  public void createNotificationChannel(String paramString1, CharSequence paramCharSequence, int paramInt, String paramString2, boolean paramBoolean)
  {
    if (!isOreo()) {
      return;
    }
    Object localObject = this.localManager.getNotificationChannelGroups();
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      if (((Iterator)localObject).hasNext()) {
        ((NotificationChannelGroup)((Iterator)localObject).next()).getId().equals(paramString2);
      }
    }
    for (int i = 1;; i = 0)
    {
      if ((i == 0) && (QLog.isColorLevel())) {
        QLog.i("QNotificationMsf", 2, "please create NotificationChannelGroup First, create NotificationChannelGroup with id " + paramString2);
      }
      if (this.localManager.getNotificationChannel(paramString1) != null)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("QNotificationMsf", 2, "NotificationChannel " + paramString1 + " has been create");
        return;
      }
      paramCharSequence = new NotificationChannel(paramString1, paramCharSequence, paramInt);
      paramCharSequence.setShowBadge(paramBoolean);
      paramCharSequence.setGroup(paramString2);
      if (paramInt > 3)
      {
        paramCharSequence.enableLights(true);
        paramCharSequence.enableVibration(true);
        paramCharSequence.setLightColor(-16711936);
        paramCharSequence.setLockscreenVisibility(0);
        paramCharSequence.setBypassDnd(true);
        paramCharSequence.setVibrationPattern(new long[] { 100L });
      }
      paramCharSequence.setSound(null, null);
      if (QLog.isColorLevel()) {
        QLog.i("QNotificationMsf", 2, "NotificationChannel " + paramString1 + "canShowBadge " + paramCharSequence.canShowBadge());
      }
      this.localManager.createNotificationChannel(paramCharSequence);
      return;
    }
  }
  
  public NotificationManager getNotificationManager()
  {
    return this.localManager;
  }
  
  public void initOreo(Context paramContext)
  {
    if ((isOreo()) && (paramContext.getApplicationContext().getApplicationInfo().targetSdkVersion >= 26))
    {
      createNotificationChannelGroup("GROUP_ID_TOP", GROUP_NAME_TOP);
      createNotificationChannel("CHANNEL_ID_MSF", CHANNEL_NAME_OTHER, 3, "GROUP_ID_TOP", false);
      createNotificationChannel("CHANNEL_ID_OFFLINEMSG", CHANNEL_NAME_OFFLINEMSG, 3, "GROUP_ID_TOP", false);
    }
  }
  
  public void notify(String paramString, int paramInt, Notification paramNotification)
  {
    addChannelIfNeed(paramNotification);
    QLog.i("QNotificationMsf", 1, paramString + " notify DontUseTag id:" + paramInt + " " + paramNotification);
    if (this.localManager != null) {
      this.localManager.notify(paramInt, paramNotification);
    }
  }
  
  public void notifyUseTag(String paramString1, String paramString2, int paramInt, Notification paramNotification)
  {
    addChannelIfNeed(paramNotification);
    QLog.i("QNotificationMsf", 1, paramString1 + " notify UseTag:" + paramString2 + " id:" + paramInt + " " + paramNotification);
    if (this.localManager != null) {
      this.localManager.notify(paramString2, paramInt, paramNotification);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.QNotificationManager
 * JD-Core Version:    0.7.0.1
 */