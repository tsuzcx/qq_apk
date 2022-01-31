package com.tencent.mobileqq.msf.core.c;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class b
{
  public static final String a = "android.intent.action.APPLICATION_MESSAGE_QUERY";
  public static final String b = "android.intent.action.APPLICATION_MESSAGE_UPDATE";
  public static final String c = "android.intent.extra.update_application_message_text";
  public static final String d = "android.intent.extra.update_application_component_name";
  public static final String e = "samsung";
  public static final String f = "Xiaomi";
  public static final String g = "Sony Ericsson";
  
  public static String a(Context paramContext)
  {
    Object localObject1 = paramContext.getPackageManager();
    Object localObject2 = new Intent("android.intent.action.MAIN");
    ((Intent)localObject2).addCategory("android.intent.category.LAUNCHER");
    localObject1 = ((PackageManager)localObject1).queryIntentActivities((Intent)localObject2, 0).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (ResolveInfo)((Iterator)localObject1).next();
      if (((ResolveInfo)localObject2).activityInfo.applicationInfo.packageName.equalsIgnoreCase(paramContext.getPackageName())) {
        return ((ResolveInfo)localObject2).activityInfo.name;
      }
    }
    return null;
  }
  
  public static void a(Context paramContext, int paramInt)
  {
    Intent localIntent = new Intent("android.intent.action.APPLICATION_MESSAGE_UPDATE");
    localIntent.putExtra("android.intent.extra.update_application_component_name", "com.tencent.mobileqq/.activity.SplashActivity");
    String str;
    if (paramInt > 0) {
      if (paramInt > 99) {
        str = "99";
      }
    }
    for (;;)
    {
      localIntent.putExtra("android.intent.extra.update_application_message_text", str);
      paramContext.sendBroadcast(localIntent);
      return;
      str = paramInt + "";
      continue;
      str = "";
    }
  }
  
  public static void b(Context paramContext, int paramInt)
  {
    String str = a(paramContext);
    if (str == null) {
      return;
    }
    int i = paramInt;
    if (paramInt > 99) {
      i = 99;
    }
    Intent localIntent = new Intent("android.intent.action.BADGE_COUNT_UPDATE");
    localIntent.putExtra("badge_count", i);
    localIntent.putExtra("badge_count_package_name", paramContext.getPackageName());
    localIntent.putExtra("badge_count_class_name", str);
    paramContext.sendBroadcast(localIntent);
  }
  
  public static void c(Context paramContext, int paramInt)
  {
    Intent localIntent = new Intent();
    if (paramInt < 1)
    {
      str = "";
      localIntent.putExtra("com.sonyericsson.home.intent.extra.badge.SHOW_MESSAGE", false);
      localIntent.setAction("com.sonyericsson.home.action.UPDATE_BADGE");
      localIntent.putExtra("com.sonyericsson.home.intent.extra.badge.ACTIVITY_NAME", a(paramContext));
      localIntent.putExtra("com.sonyericsson.home.intent.extra.badge.MESSAGE", str);
      localIntent.putExtra("com.sonyericsson.home.intent.extra.badge.PACKAGE_NAME", paramContext.getPackageName());
      paramContext.sendBroadcast(localIntent);
      return;
    }
    if (paramInt > 99) {}
    for (String str = "99";; str = paramInt + "")
    {
      localIntent.putExtra("com.sonyericsson.home.intent.extra.badge.SHOW_MESSAGE", true);
      break;
    }
  }
  
  public static void d(Context paramContext, int paramInt)
  {
    if (paramInt < 0) {
      QLog.d("yhhh test", 2, "set badge error    -x");
    }
    if (Build.MANUFACTURER.equalsIgnoreCase("Xiaomi")) {
      a(paramContext, paramInt);
    }
    do
    {
      return;
      if (Build.MANUFACTURER.equalsIgnoreCase("samsung"))
      {
        b(paramContext, paramInt);
        return;
      }
    } while (!Build.MANUFACTURER.equalsIgnoreCase("Sony Ericsson"));
    c(paramContext, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.c.b
 * JD-Core Version:    0.7.0.1
 */