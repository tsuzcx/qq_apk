package moai.core.utilities;

import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Badges
{
  private static int currCount = 0;
  private static volatile Badges instance;
  
  public static Badges getInstance()
  {
    if (instance == null) {}
    try
    {
      if (instance == null) {
        instance = new Badges();
      }
      return instance;
    }
    finally {}
  }
  
  public ComponentName getLaucnerComponent(Context paramContext)
  {
    return paramContext.getPackageManager().getLaunchIntentForPackage(paramContext.getPackageName()).getComponent();
  }
  
  public boolean isSupportedHuaweiBadge(Context paramContext)
  {
    try
    {
      paramContext = paramContext.createPackageContext("com.huawei.android.launcher", 3).getClassLoader().loadClass("com.huawei.android.launcher.LauncherProvider");
      Object localObject = paramContext.newInstance();
      boolean bool = ((Boolean)paramContext.getMethod("isSupportChangeBadgeByCallMethod", new Class[0]).invoke(localObject, new Object[0])).booleanValue();
      return bool;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      paramContext.printStackTrace();
      return false;
    }
    catch (NoSuchMethodException paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
      }
    }
    catch (InstantiationException paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
      }
    }
    catch (IllegalAccessException paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
      }
    }
    catch (InvocationTargetException paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
      }
    }
    catch (ClassNotFoundException paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
      }
    }
  }
  
  public void resetBadgeCount(Context paramContext)
    throws Throwable
  {
    setBadgeCount(paramContext, 0);
  }
  
  public void setBadgeCount(Context paramContext, int paramInt)
    throws Throwable
  {
    paramInt = Math.max(0, Math.min(paramInt, 99));
    ComponentName localComponentName = getLaucnerComponent(paramContext);
    currCount = paramInt;
    if (localComponentName == null)
    {
      setBadgeUsingCommonWay(paramContext, paramInt);
      return;
    }
    if (Build.BRAND.toLowerCase().equalsIgnoreCase("sony"))
    {
      setBadgeOfSony(localComponentName, paramContext, paramInt);
      return;
    }
    if (Build.BRAND.toLowerCase().contains("samsung"))
    {
      setBadgeOfSumsung(localComponentName, paramContext, paramInt);
      return;
    }
    if (Build.BRAND.toLowerCase().contains("htc"))
    {
      setBadgeOfHTC(localComponentName, paramContext, paramInt);
      return;
    }
    if (Build.BRAND.toLowerCase().contains("vivo"))
    {
      setBadgeOfVivo(localComponentName, paramContext, paramInt);
      return;
    }
    if ((Build.BRAND.toLowerCase().contains("huawei")) || (Build.BRAND.toLowerCase().contains("honor")))
    {
      setBadgeOfHuawei(localComponentName, paramContext, paramInt);
      return;
    }
    if (Build.BRAND.toLowerCase().contains("smartisan"))
    {
      setBadgeOfSmartisan(localComponentName, paramContext, paramInt);
      setBadgeUsingCommonWay(paramContext, paramInt);
      return;
    }
    setBadgeUsingCommonWay(paramContext, paramInt);
  }
  
  public void setBadgeCountDecrease(Context paramContext)
    throws Throwable
  {
    int i = currCount - 1;
    currCount = i;
    setBadgeCount(paramContext, i);
  }
  
  public void setBadgeCountIncrease(Context paramContext)
    throws Throwable
  {
    int i = currCount + 1;
    currCount = i;
    setBadgeCount(paramContext, i);
  }
  
  public void setBadgeOfHTC(ComponentName paramComponentName, Context paramContext, int paramInt)
  {
    Intent localIntent = new Intent("com.htc.launcher.action.UPDATE_SHORTCUT");
    localIntent.putExtra("packagename", paramComponentName.getPackageName());
    localIntent.putExtra("count", paramInt);
    paramContext.sendBroadcast(localIntent);
    localIntent = new Intent("com.htc.launcher.action.SET_NOTIFICATION");
    localIntent.putExtra("com.htc.launcher.extra.COMPONENT", paramComponentName.flattenToShortString());
    localIntent.putExtra("com.htc.launcher.extra.COUNT", paramInt);
    paramContext.sendBroadcast(localIntent);
  }
  
  public void setBadgeOfHuawei(ComponentName paramComponentName, Context paramContext, int paramInt)
  {
    try
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("package", paramComponentName.getPackageName());
      localBundle.putString("class", paramComponentName.getClassName());
      localBundle.putInt("badgenumber", paramInt);
      paramContext.getContentResolver().call(Uri.parse("content://com.huawei.android.launcher.settings/badge/"), "change_badge", null, localBundle);
      return;
    }
    catch (Exception paramComponentName)
    {
      paramComponentName.printStackTrace();
    }
  }
  
  public void setBadgeOfNova(ComponentName paramComponentName, Context paramContext, int paramInt)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("tag", paramComponentName.getPackageName() + "/" + paramComponentName.getClassName());
    localContentValues.put("count", Integer.valueOf(paramInt));
    paramContext.getContentResolver().insert(Uri.parse("content://com.teslacoilsw.notifier/unread_count"), localContentValues);
  }
  
  public void setBadgeOfSmartisan(ComponentName paramComponentName, Context paramContext, int paramInt)
  {
    Intent localIntent = new Intent("com.smartisanos.launcher.new_message");
    localIntent.putExtra("extra_packagename", paramComponentName.getPackageName());
    localIntent.putExtra("extra_componentname", paramComponentName.getClassName());
    localIntent.putExtra("extra_message_count", paramInt);
    paramContext.sendBroadcast(localIntent);
  }
  
  public void setBadgeOfSony(ComponentName paramComponentName, Context paramContext, int paramInt)
  {
    if (paramInt > 0) {}
    for (boolean bool = true;; bool = false)
    {
      Intent localIntent = new Intent();
      localIntent.setAction("com.sonyericsson.home.action.UPDATE_BADGE");
      localIntent.putExtra("com.sonyericsson.home.intent.extra.badge.SHOW_MESSAGE", bool);
      localIntent.putExtra("com.sonyericsson.home.intent.extra.badge.MESSAGE", String.valueOf(paramInt));
      localIntent.putExtra("com.sonyericsson.home.intent.extra.badge.ACTIVITY_NAME", paramComponentName.getClassName());
      localIntent.putExtra("com.sonyericsson.home.intent.extra.badge.PACKAGE_NAME", paramComponentName.getPackageName());
      paramContext.sendBroadcast(localIntent);
      return;
    }
  }
  
  public void setBadgeOfSumsung(ComponentName paramComponentName, Context paramContext, int paramInt)
  {
    Intent localIntent = new Intent("android.intent.action.BADGE_COUNT_UPDATE");
    localIntent.putExtra("badge_count", paramInt);
    localIntent.putExtra("badge_count_package_name", paramComponentName.getPackageName());
    localIntent.putExtra("badge_count_class_name", paramComponentName.getClassName());
    paramContext.sendBroadcast(localIntent);
  }
  
  public void setBadgeOfVivo(ComponentName paramComponentName, Context paramContext, int paramInt)
  {
    Intent localIntent = new Intent("launcher.action.CHANGE_APPLICATION_NOTIFICATION_NUM");
    localIntent.putExtra("packageName", paramComponentName.getPackageName());
    localIntent.putExtra("className", paramComponentName.getClassName());
    localIntent.putExtra("notificationNum", paramInt);
    paramContext.sendBroadcast(localIntent);
  }
  
  public void setBadgeUsingCommonWay(Context paramContext, int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putStringArrayList("app_shortcut_custom_id", null);
    localBundle.putInt("app_badge_count", paramInt);
    Uri localUri = Uri.parse("content://com.android.badge/badge");
    paramContext.getContentResolver().call(localUri, "setAppBadgeCount", null, localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.core.utilities.Badges
 * JD-Core Version:    0.7.0.1
 */