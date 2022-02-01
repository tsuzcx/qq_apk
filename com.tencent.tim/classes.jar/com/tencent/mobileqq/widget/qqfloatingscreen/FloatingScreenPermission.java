package com.tencent.mobileqq.widget.qqfloatingscreen;

import android.annotation.TargetApi;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Binder;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings;
import android.support.annotation.RequiresApi;
import aqha;
import aqju;
import arky;
import arkz;
import arlb;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Method;

public class FloatingScreenPermission
{
  private static final int OP_SYSTEM_ALERT_WINDOW = 24;
  private static final String TAG = "FloatingScreenPermission";
  
  public static boolean canUseCheckOpForVivo()
  {
    return Build.MANUFACTURER.equalsIgnoreCase("vivo");
  }
  
  @RequiresApi(19)
  private static boolean checkOp(Context paramContext, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 19)
    {
      AppOpsManager localAppOpsManager = (AppOpsManager)paramContext.getSystemService("appops");
      try
      {
        paramContext = (Integer)localAppOpsManager.getClass().getDeclaredMethod("checkOp", new Class[] { Integer.TYPE, Integer.TYPE, String.class }).invoke(localAppOpsManager, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(Binder.getCallingUid()), paramContext.getApplicationContext().getPackageName() });
        if (QLog.isColorLevel()) {
          QLog.d("FloatingScreenPermission", 2, "0 invoke " + paramContext);
        }
        if (paramContext != null)
        {
          paramInt = paramContext.intValue();
          if (paramInt == 0) {
            return true;
          }
        }
        return false;
      }
      catch (Exception paramContext)
      {
        QLog.e("FloatingScreenPermission", 1, "checkOp failed.", paramContext);
      }
    }
    return true;
  }
  
  public static boolean checkOpForCommon(Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 23) {
      return Settings.canDrawOverlays(paramContext);
    }
    if (Build.VERSION.SDK_INT >= 19) {
      return checkOps(paramContext);
    }
    return true;
  }
  
  /* Error */
  public static boolean checkOpForVivo(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 145	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   4: astore 4
    //   6: ldc 147
    //   8: invokestatic 153	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   11: astore 5
    //   13: new 101	java/lang/StringBuilder
    //   16: dup
    //   17: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   20: ldc 155
    //   22: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: aload_0
    //   26: invokevirtual 88	android/content/Context:getPackageName	()Ljava/lang/String;
    //   29: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: ldc 157
    //   34: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   40: astore 6
    //   42: aload 4
    //   44: aload 5
    //   46: iconst_1
    //   47: anewarray 27	java/lang/String
    //   50: dup
    //   51: iconst_0
    //   52: ldc 159
    //   54: aastore
    //   55: aload 6
    //   57: aconst_null
    //   58: aconst_null
    //   59: invokestatic 165	alld:query	(Landroid/content/ContentResolver;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   62: astore 5
    //   64: aload 5
    //   66: ifnull +97 -> 163
    //   69: aload 5
    //   71: astore 4
    //   73: aload 5
    //   75: invokeinterface 170 1 0
    //   80: ifeq +83 -> 163
    //   83: aload 5
    //   85: astore 4
    //   87: aload 5
    //   89: iconst_0
    //   90: invokeinterface 174 2 0
    //   95: istore_1
    //   96: iload_1
    //   97: ifne +61 -> 158
    //   100: iconst_1
    //   101: istore_2
    //   102: aload 5
    //   104: astore 4
    //   106: ldc 11
    //   108: iconst_1
    //   109: iconst_4
    //   110: anewarray 4	java/lang/Object
    //   113: dup
    //   114: iconst_0
    //   115: ldc 176
    //   117: aastore
    //   118: dup
    //   119: iconst_1
    //   120: iload_1
    //   121: invokestatic 74	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   124: aastore
    //   125: dup
    //   126: iconst_2
    //   127: ldc 178
    //   129: aastore
    //   130: dup
    //   131: iconst_3
    //   132: iload_2
    //   133: invokestatic 183	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   136: aastore
    //   137: invokestatic 186	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   140: iload_2
    //   141: istore_3
    //   142: aload 5
    //   144: ifnull +12 -> 156
    //   147: aload 5
    //   149: invokeinterface 189 1 0
    //   154: iload_2
    //   155: istore_3
    //   156: iload_3
    //   157: ireturn
    //   158: iconst_0
    //   159: istore_2
    //   160: goto -58 -> 102
    //   163: aload 5
    //   165: astore 4
    //   167: aload_0
    //   168: invokestatic 191	com/tencent/mobileqq/widget/qqfloatingscreen/FloatingScreenPermission:checkOpForCommon	(Landroid/content/Context;)Z
    //   171: istore_2
    //   172: aload 5
    //   174: astore 4
    //   176: ldc 11
    //   178: iconst_1
    //   179: iconst_4
    //   180: anewarray 4	java/lang/Object
    //   183: dup
    //   184: iconst_0
    //   185: ldc 193
    //   187: aastore
    //   188: dup
    //   189: iconst_1
    //   190: iload_2
    //   191: invokestatic 183	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   194: aastore
    //   195: dup
    //   196: iconst_2
    //   197: ldc 195
    //   199: aastore
    //   200: dup
    //   201: iconst_3
    //   202: aload 5
    //   204: aastore
    //   205: invokestatic 186	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   208: goto -68 -> 140
    //   211: astore 6
    //   213: aload 5
    //   215: astore 4
    //   217: ldc 11
    //   219: iconst_1
    //   220: ldc 197
    //   222: aload 6
    //   224: invokestatic 200	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   227: aload 5
    //   229: astore 4
    //   231: aload_0
    //   232: invokestatic 191	com/tencent/mobileqq/widget/qqfloatingscreen/FloatingScreenPermission:checkOpForCommon	(Landroid/content/Context;)Z
    //   235: istore_2
    //   236: iload_2
    //   237: istore_3
    //   238: aload 5
    //   240: ifnull -84 -> 156
    //   243: aload 5
    //   245: invokeinterface 189 1 0
    //   250: iload_2
    //   251: ireturn
    //   252: astore_0
    //   253: aconst_null
    //   254: astore 4
    //   256: aload 4
    //   258: ifnull +10 -> 268
    //   261: aload 4
    //   263: invokeinterface 189 1 0
    //   268: aload_0
    //   269: athrow
    //   270: astore_0
    //   271: goto -15 -> 256
    //   274: astore 6
    //   276: aconst_null
    //   277: astore 5
    //   279: goto -66 -> 213
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	282	0	paramContext	Context
    //   95	26	1	i	int
    //   101	150	2	bool1	boolean
    //   141	97	3	bool2	boolean
    //   4	258	4	localObject1	Object
    //   11	267	5	localObject2	Object
    //   40	16	6	str	String
    //   211	12	6	localThrowable1	java.lang.Throwable
    //   274	1	6	localThrowable2	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   73	83	211	java/lang/Throwable
    //   87	96	211	java/lang/Throwable
    //   106	140	211	java/lang/Throwable
    //   167	172	211	java/lang/Throwable
    //   176	208	211	java/lang/Throwable
    //   0	64	252	finally
    //   73	83	270	finally
    //   87	96	270	finally
    //   106	140	270	finally
    //   167	172	270	finally
    //   176	208	270	finally
    //   217	227	270	finally
    //   231	236	270	finally
    //   0	64	274	java/lang/Throwable
  }
  
  @TargetApi(19)
  private static boolean checkOps(Context paramContext)
  {
    if (paramContext == null) {}
    for (;;)
    {
      return false;
      try
      {
        Object localObject = paramContext.getSystemService("appops");
        if (localObject == null) {
          continue;
        }
        Method localMethod = localObject.getClass().getMethod("checkOp", new Class[] { Integer.TYPE, Integer.TYPE, String.class });
        if (localMethod == null) {
          continue;
        }
        paramContext = (Integer)localMethod.invoke(localObject, new Object[] { Integer.valueOf(24), Integer.valueOf(Binder.getCallingUid()), paramContext.getPackageName() });
        if (QLog.isColorLevel()) {
          QLog.d("FloatingScreenPermission", 2, new Object[] { "checkOps ", paramContext });
        }
        if (paramContext != null)
        {
          int i = paramContext.intValue();
          if (i != 0) {}
        }
        for (boolean bool = true;; bool = false) {
          return bool;
        }
        return false;
      }
      catch (Exception paramContext) {}
    }
  }
  
  public static boolean checkPermission(Context paramContext)
  {
    if (paramContext == null) {
      return false;
    }
    if (canUseCheckOpForVivo()) {
      return checkOpForVivo(paramContext);
    }
    return checkOpForCommon(paramContext);
  }
  
  public static void enterPermissionRequestDialog(Context paramContext)
  {
    if (paramContext == null) {
      return;
    }
    arlb.ejR();
    aqha.a(paramContext, 230, paramContext.getString(2131718499), paramContext.getString(2131718497), paramContext.getString(2131718496), paramContext.getString(2131718498), new arky(paramContext), null).show();
  }
  
  private static boolean handleVivoPermissionDialog(Context paramContext)
  {
    if (canUseCheckOpForVivo())
    {
      aqha.a(paramContext, 230, paramContext.getString(2131718499), paramContext.getString(2131701870), paramContext.getString(2131718496), paramContext.getString(2131696701), new arkz(paramContext), null).show();
      return true;
    }
    return false;
  }
  
  private static boolean isIntentAvailable(Context paramContext, Intent paramIntent)
  {
    if ((paramContext == null) || (paramIntent == null)) {}
    do
    {
      return false;
      paramContext = paramIntent.resolveActivityInfo(paramContext.getPackageManager(), 65536);
    } while ((paramContext == null) || (!paramContext.exported));
    return true;
  }
  
  public static boolean requestPermission(Context paramContext)
  {
    boolean bool1 = false;
    if (canUseCheckOpForVivo())
    {
      bool2 = startVivoPmActivity(paramContext);
      bool1 = bool2;
      if (!bool2) {
        bool1 = startVivoPmActivity2(paramContext);
      }
    }
    boolean bool2 = bool1;
    if (!bool1)
    {
      bool2 = bool1;
      if (Build.VERSION.SDK_INT >= 23) {
        bool2 = startCommonPmActivity(paramContext);
      }
    }
    bool1 = bool2;
    if (!bool2) {
      bool1 = startMiuiPmActivity(paramContext);
    }
    bool2 = bool1;
    if (!bool1) {
      bool2 = startMiuiPmActivity8(paramContext);
    }
    bool1 = bool2;
    if (!bool2) {
      bool1 = startMiuiPmActivity8DEV(paramContext);
    }
    bool2 = bool1;
    if (!bool1) {
      bool2 = startMeizuPmActivity(paramContext);
    }
    bool1 = bool2;
    if (!bool2) {
      bool1 = startHuaWeiPmActivity(paramContext);
    }
    bool2 = bool1;
    if (!bool1) {
      bool2 = startHuaWeiPmActivity2(paramContext);
    }
    return bool2;
  }
  
  @RequiresApi(api=23)
  private static boolean startCommonPmActivity(Context paramContext)
  {
    boolean bool = false;
    Intent localIntent = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION", Uri.parse("package:" + paramContext.getPackageName()));
    localIntent.addFlags(268435456);
    if (isIntentAvailable(paramContext, localIntent)) {}
    try
    {
      paramContext.startActivity(localIntent);
      bool = true;
      return bool;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return false;
  }
  
  private static boolean startHuaWeiPmActivity(Context paramContext)
  {
    boolean bool = false;
    Intent localIntent = new Intent();
    localIntent.setClassName("com.huawei.systemmanager", "com.huawei.systemmanager.addviewmonitor.AddViewMonitorActivity");
    localIntent.putExtra("packageName", paramContext.getPackageName());
    localIntent.addFlags(268435456);
    localIntent.putExtra("big_brother_source_key", "biz_src_fs");
    if (isIntentAvailable(paramContext, localIntent)) {}
    try
    {
      paramContext.startActivity(localIntent);
      bool = true;
      return bool;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return false;
  }
  
  private static boolean startHuaWeiPmActivity2(Context paramContext)
  {
    boolean bool = false;
    Intent localIntent = new Intent("huawei.intent.action.NOTIFICATIONMANAGER");
    localIntent.addFlags(268435456);
    localIntent.putExtra("big_brother_source_key", "biz_src_fs");
    if (isIntentAvailable(paramContext, localIntent)) {}
    try
    {
      paramContext.startActivity(localIntent);
      bool = true;
      return bool;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return false;
  }
  
  private static boolean startMeizuPmActivity(Context paramContext)
  {
    boolean bool = false;
    Intent localIntent = new Intent("com.meizu.safe.security.SHOW_APPSEC");
    localIntent.setClassName("com.meizu.safe", "com.meizu.safe.security.AppSecActivity");
    localIntent.putExtra("extra_pkgname", paramContext.getPackageName());
    localIntent.addFlags(268435456);
    localIntent.putExtra("big_brother_source_key", "biz_src_fs");
    if (isIntentAvailable(paramContext, localIntent)) {}
    try
    {
      paramContext.startActivity(localIntent);
      bool = true;
      return bool;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return false;
  }
  
  private static boolean startMiuiPmActivity(Context paramContext)
  {
    boolean bool = false;
    Intent localIntent = new Intent("miui.intent.action.APP_PERM_EDITOR");
    localIntent.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.AppPermissionsEditorActivity");
    localIntent.putExtra("extra_pkgname", paramContext.getPackageName());
    localIntent.putExtra("big_brother_source_key", "biz_src_fs");
    localIntent.addFlags(268435456);
    if (isIntentAvailable(paramContext, localIntent)) {}
    try
    {
      paramContext.startActivity(localIntent);
      bool = true;
      return bool;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return false;
  }
  
  private static boolean startMiuiPmActivity8(Context paramContext)
  {
    boolean bool = false;
    Intent localIntent = new Intent("miui.intent.action.APP_PERM_EDITOR");
    localIntent.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.RealAppPermissionsEditorActivity");
    localIntent.putExtra("extra_pkgname", paramContext.getPackageName());
    localIntent.addFlags(268435456);
    localIntent.putExtra("big_brother_source_key", "biz_src_fs");
    if (isIntentAvailable(paramContext, localIntent)) {}
    try
    {
      paramContext.startActivity(localIntent);
      bool = true;
      return bool;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return false;
  }
  
  private static boolean startMiuiPmActivity8DEV(Context paramContext)
  {
    boolean bool = false;
    Intent localIntent = new Intent("miui.intent.action.APP_PERM_EDITOR");
    localIntent.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.PermissionsEditorActivity");
    localIntent.putExtra("extra_pkgname", paramContext.getPackageName());
    localIntent.addFlags(268435456);
    localIntent.putExtra("big_brother_source_key", "biz_src_fs");
    if (isIntentAvailable(paramContext, localIntent)) {}
    try
    {
      paramContext.startActivity(localIntent);
      bool = true;
      return bool;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return false;
  }
  
  private static boolean startVivoPmActivity(Context paramContext)
  {
    boolean bool = false;
    Intent localIntent = new Intent("com.iqoo.secure");
    localIntent.setClassName("com.iqoo.secure", "com.iqoo.secure.MainActivity");
    localIntent.addFlags(268435456);
    localIntent.putExtra("big_brother_source_key", "biz_src_fs");
    if (isIntentAvailable(paramContext, localIntent)) {}
    try
    {
      paramContext.startActivity(localIntent);
      bool = true;
      return bool;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return false;
  }
  
  private static boolean startVivoPmActivity2(Context paramContext)
  {
    boolean bool = false;
    Intent localIntent = new Intent("permission.intent.action.softPermissionDetail");
    localIntent.addFlags(268435456);
    localIntent.putExtra("big_brother_source_key", "biz_src_fs");
    localIntent.putExtra("packagename", paramContext.getPackageName());
    if (isIntentAvailable(paramContext, localIntent)) {}
    try
    {
      paramContext.startActivity(localIntent);
      bool = true;
      return bool;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.qqfloatingscreen.FloatingScreenPermission
 * JD-Core Version:    0.7.0.1
 */