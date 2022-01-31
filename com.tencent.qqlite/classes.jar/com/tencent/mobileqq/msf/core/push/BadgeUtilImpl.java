package com.tencent.mobileqq.msf.core.push;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import java.util.Iterator;
import java.util.List;

public class BadgeUtilImpl
{
  public static final String ACTION_APPLICATION_MESSAGE_QUERY = "android.intent.action.APPLICATION_MESSAGE_QUERY";
  public static final String ACTION_APPLICATION_MESSAGE_UPDATE = "android.intent.action.APPLICATION_MESSAGE_UPDATE";
  public static final String EXTRA_UPDATE_APPLICATION_COMPONENT_NAME = "android.intent.extra.update_application_component_name";
  public static final String EXTRA_UPDATE_APPLICATION_MESSAGE_TEXT = "android.intent.extra.update_application_message_text";
  public static final String MANUFACTURER_OF_HARDWARE_SANXING = "samsung";
  public static final String MANUFACTURER_OF_HARDWARE_SONY = "Sony Ericsson";
  public static final String MANUFACTURER_OF_HARDWARE_XIAOMI = "Xiaomi";
  private static Boolean haveprovider = null;
  
  public static void changeMIBadge(Context paramContext, int paramInt)
  {
    Intent localIntent = new Intent("android.intent.action.APPLICATION_MESSAGE_UPDATE");
    localIntent.putExtra("android.intent.extra.update_application_component_name", "com.tencent.qqlite/com.tencent.mobileqq.activity.SplashActivity");
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
  
  public static String getLauncherClassName(Context paramContext)
  {
    Object localObject1 = paramContext.getPackageManager();
    Object localObject2 = new Intent("android.intent.action.MAIN");
    ((Intent)localObject2).addCategory("android.intent.category.LAUNCHER");
    try
    {
      localObject1 = ((PackageManager)localObject1).queryIntentActivities((Intent)localObject2, 0).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ResolveInfo)((Iterator)localObject1).next();
        if (((ResolveInfo)localObject2).activityInfo.applicationInfo.packageName.equalsIgnoreCase(paramContext.getPackageName()))
        {
          paramContext = ((ResolveInfo)localObject2).activityInfo.name;
          return paramContext;
        }
      }
    }
    catch (Exception paramContext)
    {
      return null;
    }
    return null;
  }
  
  public static void setBadge(Context paramContext, int paramInt)
  {
    if (Build.MANUFACTURER.equalsIgnoreCase("Xiaomi")) {
      changeMIBadge(paramContext, paramInt);
    }
    while (!Build.MANUFACTURER.equalsIgnoreCase("samsung")) {
      return;
    }
    setSamsungBadge(paramContext, paramInt);
  }
  
  /* Error */
  public static void setSamsungBadge(Context paramContext, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: getstatic 32	com/tencent/mobileqq/msf/core/push/BadgeUtilImpl:haveprovider	Ljava/lang/Boolean;
    //   5: ifnonnull +283 -> 288
    //   8: ldc 155
    //   10: invokestatic 161	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   13: astore 4
    //   15: aload_0
    //   16: invokevirtual 165	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   19: aload 4
    //   21: aconst_null
    //   22: aconst_null
    //   23: aconst_null
    //   24: aconst_null
    //   25: invokevirtual 171	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   28: astore 4
    //   30: aload 4
    //   32: ifnonnull +30 -> 62
    //   35: aload 4
    //   37: astore_3
    //   38: aload 4
    //   40: astore 5
    //   42: iconst_0
    //   43: invokestatic 177	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   46: putstatic 32	com/tencent/mobileqq/msf/core/push/BadgeUtilImpl:haveprovider	Ljava/lang/Boolean;
    //   49: aload 4
    //   51: ifnull +10 -> 61
    //   54: aload 4
    //   56: invokeinterface 182 1 0
    //   61: return
    //   62: aload 4
    //   64: astore_3
    //   65: aload 4
    //   67: astore 5
    //   69: iconst_1
    //   70: invokestatic 177	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   73: putstatic 32	com/tencent/mobileqq/msf/core/push/BadgeUtilImpl:haveprovider	Ljava/lang/Boolean;
    //   76: aload 4
    //   78: astore_3
    //   79: aload 4
    //   81: astore 5
    //   83: getstatic 32	com/tencent/mobileqq/msf/core/push/BadgeUtilImpl:haveprovider	Ljava/lang/Boolean;
    //   86: invokevirtual 185	java/lang/Boolean:booleanValue	()Z
    //   89: ifeq +128 -> 217
    //   92: aload 4
    //   94: astore_3
    //   95: aload 4
    //   97: astore 5
    //   99: aload_0
    //   100: invokestatic 187	com/tencent/mobileqq/msf/core/push/BadgeUtilImpl:getLauncherClassName	(Landroid/content/Context;)Ljava/lang/String;
    //   103: astore 6
    //   105: aload 6
    //   107: ifnonnull +16 -> 123
    //   110: aload 4
    //   112: ifnull -51 -> 61
    //   115: aload 4
    //   117: invokeinterface 182 1 0
    //   122: return
    //   123: iload_1
    //   124: istore_2
    //   125: iload_1
    //   126: bipush 99
    //   128: if_icmple +6 -> 134
    //   131: bipush 99
    //   133: istore_2
    //   134: aload 4
    //   136: astore_3
    //   137: aload 4
    //   139: astore 5
    //   141: new 40	android/content/Intent
    //   144: dup
    //   145: ldc 189
    //   147: invokespecial 43	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   150: astore 7
    //   152: aload 4
    //   154: astore_3
    //   155: aload 4
    //   157: astore 5
    //   159: aload 7
    //   161: ldc 191
    //   163: iload_2
    //   164: invokevirtual 194	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   167: pop
    //   168: aload 4
    //   170: astore_3
    //   171: aload 4
    //   173: astore 5
    //   175: aload 7
    //   177: ldc 196
    //   179: aload_0
    //   180: invokevirtual 131	android/content/Context:getPackageName	()Ljava/lang/String;
    //   183: invokevirtual 49	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   186: pop
    //   187: aload 4
    //   189: astore_3
    //   190: aload 4
    //   192: astore 5
    //   194: aload 7
    //   196: ldc 198
    //   198: aload 6
    //   200: invokevirtual 49	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   203: pop
    //   204: aload 4
    //   206: astore_3
    //   207: aload 4
    //   209: astore 5
    //   211: aload_0
    //   212: aload 7
    //   214: invokevirtual 57	android/content/Context:sendBroadcast	(Landroid/content/Intent;)V
    //   217: aload 4
    //   219: ifnull -158 -> 61
    //   222: aload 4
    //   224: invokeinterface 182 1 0
    //   229: return
    //   230: astore_0
    //   231: aconst_null
    //   232: astore 5
    //   234: aload 5
    //   236: astore_3
    //   237: invokestatic 203	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   240: ifeq +14 -> 254
    //   243: aload 5
    //   245: astore_3
    //   246: ldc 205
    //   248: iconst_2
    //   249: ldc 207
    //   251: invokestatic 211	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   254: aload 5
    //   256: ifnull -195 -> 61
    //   259: aload 5
    //   261: invokeinterface 182 1 0
    //   266: return
    //   267: astore_0
    //   268: aload_3
    //   269: ifnull +9 -> 278
    //   272: aload_3
    //   273: invokeinterface 182 1 0
    //   278: aload_0
    //   279: athrow
    //   280: astore_0
    //   281: goto -13 -> 268
    //   284: astore_0
    //   285: goto -51 -> 234
    //   288: aconst_null
    //   289: astore 4
    //   291: goto -215 -> 76
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	294	0	paramContext	Context
    //   0	294	1	paramInt	int
    //   124	40	2	i	int
    //   1	272	3	localObject1	Object
    //   13	277	4	localObject2	Object
    //   40	220	5	localObject3	Object
    //   103	96	6	str	String
    //   150	63	7	localIntent	Intent
    // Exception table:
    //   from	to	target	type
    //   2	30	230	java/lang/Throwable
    //   2	30	267	finally
    //   42	49	280	finally
    //   69	76	280	finally
    //   83	92	280	finally
    //   99	105	280	finally
    //   141	152	280	finally
    //   159	168	280	finally
    //   175	187	280	finally
    //   194	204	280	finally
    //   211	217	280	finally
    //   237	243	280	finally
    //   246	254	280	finally
    //   42	49	284	java/lang/Throwable
    //   69	76	284	java/lang/Throwable
    //   83	92	284	java/lang/Throwable
    //   99	105	284	java/lang/Throwable
    //   141	152	284	java/lang/Throwable
    //   159	168	284	java/lang/Throwable
    //   175	187	284	java/lang/Throwable
    //   194	204	284	java/lang/Throwable
    //   211	217	284	java/lang/Throwable
  }
  
  public static void setSonyBadge(Context paramContext, int paramInt)
  {
    Intent localIntent = new Intent();
    String str2 = getLauncherClassName(paramContext);
    if (str2 == null) {
      return;
    }
    if (paramInt < 1)
    {
      str1 = "";
      localIntent.putExtra("com.sonyericsson.home.intent.extra.badge.SHOW_MESSAGE", false);
      localIntent.setAction("com.sonyericsson.home.action.UPDATE_BADGE");
      localIntent.putExtra("com.sonyericsson.home.intent.extra.badge.ACTIVITY_NAME", str2);
      localIntent.putExtra("com.sonyericsson.home.intent.extra.badge.MESSAGE", str1);
      localIntent.putExtra("com.sonyericsson.home.intent.extra.badge.PACKAGE_NAME", paramContext.getPackageName());
      paramContext.sendBroadcast(localIntent);
      return;
    }
    if (paramInt > 99) {}
    for (String str1 = "99";; str1 = paramInt + "")
    {
      localIntent.putExtra("com.sonyericsson.home.intent.extra.badge.SHOW_MESSAGE", true);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.push.BadgeUtilImpl
 * JD-Core Version:    0.7.0.1
 */