package android.support.v4.app;

import android.app.AppOpsManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.provider.Settings.Secure;
import android.support.annotation.GuardedBy;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

public final class NotificationManagerCompat
{
  public static final String ACTION_BIND_SIDE_CHANNEL = "android.support.BIND_NOTIFICATION_SIDE_CHANNEL";
  private static final String CHECK_OP_NO_THROW = "checkOpNoThrow";
  public static final String EXTRA_USE_SIDE_CHANNEL = "android.support.useSideChannel";
  public static final int IMPORTANCE_DEFAULT = 3;
  public static final int IMPORTANCE_HIGH = 4;
  public static final int IMPORTANCE_LOW = 2;
  public static final int IMPORTANCE_MAX = 5;
  public static final int IMPORTANCE_MIN = 1;
  public static final int IMPORTANCE_NONE = 0;
  public static final int IMPORTANCE_UNSPECIFIED = -1000;
  static final int MAX_SIDE_CHANNEL_SDK_VERSION = 19;
  private static final String OP_POST_NOTIFICATION = "OP_POST_NOTIFICATION";
  private static final String SETTING_ENABLED_NOTIFICATION_LISTENERS = "enabled_notification_listeners";
  private static final int SIDE_CHANNEL_RETRY_BASE_INTERVAL_MS = 1000;
  private static final int SIDE_CHANNEL_RETRY_MAX_COUNT = 6;
  private static final String TAG = "NotifManCompat";
  @GuardedBy("sEnabledNotificationListenersLock")
  private static Set sEnabledNotificationListenerPackages = new HashSet();
  @GuardedBy("sEnabledNotificationListenersLock")
  private static String sEnabledNotificationListeners;
  private static final Object sEnabledNotificationListenersLock = new Object();
  private static final Object sLock = new Object();
  @GuardedBy("sLock")
  private static NotificationManagerCompat.SideChannelManager sSideChannelManager;
  private final Context mContext;
  private final NotificationManager mNotificationManager;
  
  private NotificationManagerCompat(Context paramContext)
  {
    this.mContext = paramContext;
    this.mNotificationManager = ((NotificationManager)this.mContext.getSystemService("notification"));
  }
  
  @NonNull
  public static NotificationManagerCompat from(@NonNull Context paramContext)
  {
    return new NotificationManagerCompat(paramContext);
  }
  
  @NonNull
  public static Set getEnabledListenerPackages(@NonNull Context paramContext)
  {
    Object localObject1 = Settings.Secure.getString(paramContext.getContentResolver(), "enabled_notification_listeners");
    paramContext = sEnabledNotificationListenersLock;
    if (localObject1 != null) {}
    for (;;)
    {
      int i;
      try
      {
        if (!((String)localObject1).equals(sEnabledNotificationListeners))
        {
          String[] arrayOfString = ((String)localObject1).split(":");
          HashSet localHashSet = new HashSet(arrayOfString.length);
          int j = arrayOfString.length;
          i = 0;
          if (i < j)
          {
            ComponentName localComponentName = ComponentName.unflattenFromString(arrayOfString[i]);
            if (localComponentName != null) {
              localHashSet.add(localComponentName.getPackageName());
            }
          }
          else
          {
            sEnabledNotificationListenerPackages = localHashSet;
            sEnabledNotificationListeners = (String)localObject1;
          }
        }
        else
        {
          localObject1 = sEnabledNotificationListenerPackages;
          return localObject1;
        }
      }
      finally {}
      i += 1;
    }
  }
  
  private void pushSideChannelQueue(NotificationManagerCompat.Task paramTask)
  {
    synchronized (sLock)
    {
      if (sSideChannelManager == null) {
        sSideChannelManager = new NotificationManagerCompat.SideChannelManager(this.mContext.getApplicationContext());
      }
      sSideChannelManager.queueTask(paramTask);
      return;
    }
  }
  
  private static boolean useSideChannelForNotification(Notification paramNotification)
  {
    paramNotification = NotificationCompat.getExtras(paramNotification);
    return (paramNotification != null) && (paramNotification.getBoolean("android.support.useSideChannel"));
  }
  
  public boolean areNotificationsEnabled()
  {
    boolean bool = true;
    if (Build.VERSION.SDK_INT >= 24) {
      bool = this.mNotificationManager.areNotificationsEnabled();
    }
    while (Build.VERSION.SDK_INT < 19) {
      return bool;
    }
    AppOpsManager localAppOpsManager = (AppOpsManager)this.mContext.getSystemService("appops");
    Object localObject = this.mContext.getApplicationInfo();
    String str = this.mContext.getApplicationContext().getPackageName();
    int i = ((ApplicationInfo)localObject).uid;
    try
    {
      localObject = Class.forName(AppOpsManager.class.getName());
      i = ((Integer)((Class)localObject).getMethod("checkOpNoThrow", new Class[] { Integer.TYPE, Integer.TYPE, String.class }).invoke(localAppOpsManager, new Object[] { Integer.valueOf(((Integer)((Class)localObject).getDeclaredField("OP_POST_NOTIFICATION").get(Integer.class)).intValue()), Integer.valueOf(i), str })).intValue();
      if (i == 0) {}
      for (bool = true;; bool = false) {
        return bool;
      }
      return true;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      return true;
    }
    catch (RuntimeException localRuntimeException)
    {
      return true;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      return true;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      return true;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      return true;
    }
    catch (InvocationTargetException localInvocationTargetException) {}
  }
  
  public void cancel(int paramInt)
  {
    cancel(null, paramInt);
  }
  
  public void cancel(@Nullable String paramString, int paramInt)
  {
    this.mNotificationManager.cancel(paramString, paramInt);
    if (Build.VERSION.SDK_INT <= 19) {
      pushSideChannelQueue(new NotificationManagerCompat.CancelTask(this.mContext.getPackageName(), paramInt, paramString));
    }
  }
  
  public void cancelAll()
  {
    this.mNotificationManager.cancelAll();
    if (Build.VERSION.SDK_INT <= 19) {
      pushSideChannelQueue(new NotificationManagerCompat.CancelTask(this.mContext.getPackageName()));
    }
  }
  
  public int getImportance()
  {
    if (Build.VERSION.SDK_INT >= 24) {
      return this.mNotificationManager.getImportance();
    }
    return -1000;
  }
  
  public void notify(int paramInt, @NonNull Notification paramNotification)
  {
    notify(null, paramInt, paramNotification);
  }
  
  public void notify(@Nullable String paramString, int paramInt, @NonNull Notification paramNotification)
  {
    if (useSideChannelForNotification(paramNotification))
    {
      pushSideChannelQueue(new NotificationManagerCompat.NotifyTask(this.mContext.getPackageName(), paramInt, paramString, paramNotification));
      this.mNotificationManager.cancel(paramString, paramInt);
      return;
    }
    this.mNotificationManager.notify(paramString, paramInt, paramNotification);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.app.NotificationManagerCompat
 * JD-Core Version:    0.7.0.1
 */