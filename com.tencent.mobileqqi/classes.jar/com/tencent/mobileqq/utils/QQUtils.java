package com.tencent.mobileqq.utils;

import android.app.Activity;
import android.app.KeyguardManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.Intent.ShortcutIconResource;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ShortcutGuideActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.util.SkinUtils;
import com.tencent.mobileqq.utils.kapalaiadapter.KapalaiAdapterUtil;
import com.tencent.mobileqq.utils.kapalaiadapter.MobileIssueSettings;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.BadgeUtils;
import hdv;
import hdw;
import hdx;
import hdy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.manager.ServerConfigManager;
import mqq.manager.ServerConfigManager.ConfigType;

public class QQUtils
{
  private static final int jdField_a_of_type_Int = 3;
  private static String jdField_a_of_type_JavaLangString;
  private static int jdField_b_of_type_Int = 0;
  private static String jdField_b_of_type_JavaLangString = null;
  
  static
  {
    a = "QQUtils";
  }
  
  public static String a()
  {
    AppRuntime localAppRuntime = null;
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.a();
    if (localBaseApplicationImpl != null) {
      localAppRuntime = localBaseApplicationImpl.a();
    }
    if (localAppRuntime == null) {
      return "0";
    }
    if (localAppRuntime.getAccount() == null) {
      return "0";
    }
    return localAppRuntime.getAccount();
  }
  
  public static String a(Context paramContext, String paramString)
  {
    if (paramString == null) {
      return null;
    }
    paramContext = paramContext.getPackageManager().getInstalledPackages(8);
    if (paramContext != null)
    {
      paramContext = paramContext.iterator();
      while (paramContext.hasNext())
      {
        ProviderInfo[] arrayOfProviderInfo = ((PackageInfo)paramContext.next()).providers;
        if (arrayOfProviderInfo != null)
        {
          int j = arrayOfProviderInfo.length;
          int i = 0;
          while (i < j)
          {
            ProviderInfo localProviderInfo = arrayOfProviderInfo[i];
            if (paramString.equals(localProviderInfo.readPermission)) {
              return localProviderInfo.authority;
            }
            i += 1;
          }
        }
      }
    }
    return null;
  }
  
  public static String a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if ((paramQQAppInterface != null) && (paramString != null))
    {
      paramQQAppInterface = (FriendManager)paramQQAppInterface.getManager(8);
      if (paramQQAppInterface != null) {
        return paramQQAppInterface.a(paramString);
      }
    }
    return null;
  }
  
  public static String a(ServerConfigManager.ConfigType paramConfigType, String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = BaseApplicationImpl.a();
    if (localObject1 != null) {}
    for (localObject1 = ((BaseApplicationImpl)localObject1).a();; localObject1 = null)
    {
      if (localObject1 == null) {
        paramConfigType = localObject2;
      }
      StringBuilder localStringBuilder;
      ServerConfigManager localServerConfigManager;
      do
      {
        return paramConfigType;
        if ((localObject1 instanceof QQAppInterface)) {
          return ((QQAppInterface)localObject1).a(paramConfigType, paramString);
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("getServerConfigValue type=").append(paramConfigType).append(", key=").append(paramString).append(", value=");
        localServerConfigManager = (ServerConfigManager)((AppRuntime)localObject1).getManager(4);
        if (localServerConfigManager == null) {
          break;
        }
        localObject1 = localServerConfigManager.getServerConfig(a(), paramConfigType);
        paramConfigType = (ServerConfigManager.ConfigType)localObject1;
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          break label251;
        }
        String str = "<" + paramString + ">";
        i = ((String)localObject1).indexOf(str);
        paramConfigType = (ServerConfigManager.ConfigType)localObject1;
        if (-1 == i) {
          break label251;
        }
        i = str.length() + i;
        int j = ((String)localObject1).indexOf("</" + paramString + ">", i);
        paramConfigType = (ServerConfigManager.ConfigType)localObject1;
        if (-1 == j) {
          break label251;
        }
        paramString = ((String)localObject1).substring(i, j);
        localStringBuilder.append(paramString);
        paramConfigType = paramString;
      } while (!QLog.isColorLevel());
      QLog.d("QQUtils", 2, localStringBuilder.toString());
      return paramString;
      paramConfigType = null;
      label251:
      paramString = new StringBuilder().append("null, configTextSize=");
      if (paramConfigType != null) {}
      for (int i = paramConfigType.length();; i = -1)
      {
        localStringBuilder.append(i).append(", scm=").append(localServerConfigManager);
        paramConfigType = localObject2;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("QQUtils", 2, localStringBuilder.toString());
        return null;
      }
    }
  }
  
  public static void a(Activity paramActivity, String paramString)
  {
    if (!a(paramActivity, new String[] { paramActivity.getString(2131561399) })) {
      return;
    }
    Intent localIntent = new Intent("android.intent.action.MAIN");
    localIntent.setClassName(paramActivity, paramString);
    localIntent.addCategory("android.intent.category.LAUNCHER");
    localIntent.addFlags(268435456);
    localIntent.addFlags(2097152);
    paramString = new Intent();
    paramString.putExtra("android.intent.extra.shortcut.INTENT", localIntent);
    paramString.putExtra("android.intent.extra.shortcut.NAME", paramActivity.getResources().getString(2131561399));
    paramString.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", Intent.ShortcutIconResource.fromContext(paramActivity.getApplicationContext(), 2130838018));
    paramString.setAction("com.android.launcher.action.UNINSTALL_SHORTCUT");
    paramActivity.sendOrderedBroadcast(paramString, null);
    BadgeUtils.d(paramActivity.getApplicationContext(), 0);
  }
  
  public static void a(Context paramContext, String paramString)
  {
    new hdv(paramContext, paramString).run();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt1, String paramString1, String paramString2, int paramInt2, Handler paramHandler, int paramInt3)
  {
    if (a(paramQQAppInterface.a(), new String[] { paramString2 }))
    {
      paramString1 = paramQQAppInterface.a().getString(2131561938);
      if (paramString1 != null) {
        QQToast.a(paramQQAppInterface.a(), paramString1, 0).b(paramInt2);
      }
      return;
    }
    Intent localIntent = new Intent("android.intent.action.MAIN");
    localIntent.setComponent(new ComponentName("com.tencent.mobileqqi", paramString1));
    localIntent.addCategory("android.intent.category.LAUNCHER");
    localIntent.putExtra("jump_shortcut_dataline", true);
    paramString1 = new Intent();
    KapalaiAdapterUtil.a().a(localIntent);
    paramString1.putExtra("android.intent.extra.shortcut.INTENT", localIntent);
    paramString1.putExtra("android.intent.extra.shortcut.NAME", paramString2);
    paramString1.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", Intent.ShortcutIconResource.fromContext(paramQQAppInterface.a().getApplicationContext(), paramInt1));
    paramString1.putExtra("duplicate", false);
    paramString1.setAction("com.android.launcher.action.INSTALL_SHORTCUT");
    paramQQAppInterface.a().sendOrderedBroadcast(paramString1, null);
    paramHandler.postDelayed(new hdx(paramQQAppInterface, paramString2, paramInt2), paramInt3);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, Handler paramHandler)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    paramQQAppInterface.a(new hdy(paramMessageRecord, paramQQAppInterface, paramHandler));
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    BadgeUtils.d(paramQQAppInterface.a(), 0);
    Intent localIntent2 = new Intent("android.intent.action.MAIN");
    localIntent2.setComponent(new ComponentName("com.tencent.mobileqqi", "com.tencent.mobileqq.activity." + ShortcutGuideActivity.class.getSimpleName()));
    localIntent2.addCategory("android.intent.category.LAUNCHER");
    localIntent2.putExtra("uin", paramString1);
    String str;
    if (paramString2 != null)
    {
      str = paramString2;
      if (paramString2.trim().length() != 0) {}
    }
    else
    {
      str = paramString1;
    }
    if (a(paramQQAppInterface.a(), new String[] { str })) {
      return;
    }
    localIntent2.putExtra("uinname", str);
    localIntent2.putExtra("uintype", 0);
    Intent localIntent1 = new Intent();
    KapalaiAdapterUtil.a().a(localIntent2);
    localIntent1.putExtra("android.intent.extra.shortcut.INTENT", localIntent2);
    localIntent1.putExtra("android.intent.extra.shortcut.NAME", str);
    paramString2 = SkinUtils.a(paramQQAppInterface.b(paramString1));
    int i = DisplayUtils.b(paramQQAppInterface.a());
    paramString1 = paramString2;
    if (i != paramString2.getWidth()) {
      if (MobileIssueSettings.c) {
        break label274;
      }
    }
    label274:
    for (paramString1 = KapalaiAdapterUtil.a().a(paramString2, i);; paramString1 = Bitmap.createScaledBitmap(paramString2, i, i, false))
    {
      localIntent1.putExtra("android.intent.extra.shortcut.ICON", paramString1);
      localIntent1.putExtra("duplicate", false);
      localIntent1.setAction("com.android.launcher.action.INSTALL_SHORTCUT");
      paramQQAppInterface.a().sendOrderedBroadcast(localIntent1, null);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d(a, 2, "createShortcut.finish.");
      return;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt1, Handler paramHandler, int paramInt2, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.d(a, 2, "createShortcutWhihTips.begin.");
    }
    if (a(paramQQAppInterface.a(), new String[] { paramString2 }))
    {
      paramString1 = paramQQAppInterface.a().getString(2131561938);
      if (paramString1 != null) {
        QQToast.a(paramQQAppInterface.a(), paramString1, 0).b(paramInt1);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(a, 2, "createShortcutWhihTips.no shortcut.");
    }
    a(paramQQAppInterface, paramString1, paramString2);
    paramHandler.postDelayed(new hdw(paramQQAppInterface, paramString2, paramInt1, paramString3), paramInt2);
  }
  
  public static void a(String paramString1, int paramInt, String paramString2, ArrayList paramArrayList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      int i = 0;
      while (i < paramArrayList.size())
      {
        localStringBuilder.append(paramArrayList.get(i)).append(", ");
        i += 1;
      }
    }
    QLog.d(paramString1, paramInt, paramString2 + localStringBuilder.toString());
  }
  
  public static final boolean a(Context paramContext)
  {
    return ((KeyguardManager)paramContext.getSystemService("keyguard")).inKeyguardRestrictedInputMode();
  }
  
  /* Error */
  public static boolean a(Context paramContext, String[] paramArrayOfString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: getstatic 19	com/tencent/mobileqq/utils/QQUtils:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   6: ifnonnull +23 -> 29
    //   9: aload_0
    //   10: invokestatic 430	com/tencent/mobileqq/utils/QQShortCutUtils:a	(Landroid/content/Context;)Ljava/lang/String;
    //   13: putstatic 19	com/tencent/mobileqq/utils/QQUtils:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   16: getstatic 19	com/tencent/mobileqq/utils/QQUtils:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   19: ldc_w 432
    //   22: if_acmpne +7 -> 29
    //   25: iconst_0
    //   26: istore_2
    //   27: iload_2
    //   28: ireturn
    //   29: getstatic 19	com/tencent/mobileqq/utils/QQUtils:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   32: astore 6
    //   34: aload_0
    //   35: invokevirtual 436	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   38: astore 7
    //   40: invokestatic 163	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   43: ifeq +85 -> 128
    //   46: ldc_w 438
    //   49: astore 5
    //   51: aload 5
    //   53: astore_0
    //   54: aload_1
    //   55: ifnull +35 -> 90
    //   58: aload 5
    //   60: astore_0
    //   61: aload_1
    //   62: arraylength
    //   63: iconst_1
    //   64: if_icmplt +26 -> 90
    //   67: new 106	java/lang/StringBuilder
    //   70: dup
    //   71: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   74: ldc_w 438
    //   77: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: aload_1
    //   81: iconst_0
    //   82: aaload
    //   83: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   89: astore_0
    //   90: getstatic 15	com/tencent/mobileqq/utils/QQUtils:a	Ljava/lang/String;
    //   93: iconst_2
    //   94: new 106	java/lang/StringBuilder
    //   97: dup
    //   98: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   101: ldc_w 440
    //   104: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: aload 6
    //   109: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: ldc_w 442
    //   115: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: aload_0
    //   119: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   125: invokestatic 167	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   128: aload 7
    //   130: aload 6
    //   132: invokestatic 448	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   135: aconst_null
    //   136: ldc_w 450
    //   139: aload_1
    //   140: aconst_null
    //   141: invokevirtual 456	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   144: astore_1
    //   145: aload_1
    //   146: ifnull +26 -> 172
    //   149: aload_1
    //   150: astore_0
    //   151: aload_1
    //   152: invokeinterface 461 1 0
    //   157: istore_3
    //   158: iload_3
    //   159: istore_2
    //   160: aload_1
    //   161: ifnull -134 -> 27
    //   164: aload_1
    //   165: invokeinterface 464 1 0
    //   170: iload_3
    //   171: ireturn
    //   172: aload_1
    //   173: ifnull +9 -> 182
    //   176: aload_1
    //   177: invokeinterface 464 1 0
    //   182: iconst_0
    //   183: ireturn
    //   184: astore 4
    //   186: aconst_null
    //   187: astore_1
    //   188: aload_1
    //   189: astore_0
    //   190: invokestatic 163	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   193: ifeq +36 -> 229
    //   196: aload_1
    //   197: astore_0
    //   198: getstatic 15	com/tencent/mobileqq/utils/QQUtils:a	Ljava/lang/String;
    //   201: iconst_2
    //   202: new 106	java/lang/StringBuilder
    //   205: dup
    //   206: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   209: ldc_w 466
    //   212: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: aload 4
    //   217: invokevirtual 467	java/lang/Exception:toString	()Ljava/lang/String;
    //   220: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   223: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   226: invokestatic 167	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   229: aload_1
    //   230: ifnull -48 -> 182
    //   233: aload_1
    //   234: invokeinterface 464 1 0
    //   239: goto -57 -> 182
    //   242: astore_0
    //   243: aload 4
    //   245: astore_1
    //   246: aload_1
    //   247: ifnull +9 -> 256
    //   250: aload_1
    //   251: invokeinterface 464 1 0
    //   256: aload_0
    //   257: athrow
    //   258: astore 4
    //   260: aload_0
    //   261: astore_1
    //   262: aload 4
    //   264: astore_0
    //   265: goto -19 -> 246
    //   268: astore 4
    //   270: goto -82 -> 188
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	273	0	paramContext	Context
    //   0	273	1	paramArrayOfString	String[]
    //   26	134	2	bool1	boolean
    //   157	14	3	bool2	boolean
    //   1	1	4	localObject1	Object
    //   184	60	4	localException1	java.lang.Exception
    //   258	5	4	localObject2	Object
    //   268	1	4	localException2	java.lang.Exception
    //   49	10	5	str1	String
    //   32	99	6	str2	String
    //   38	91	7	localContentResolver	android.content.ContentResolver
    // Exception table:
    //   from	to	target	type
    //   40	46	184	java/lang/Exception
    //   61	90	184	java/lang/Exception
    //   90	128	184	java/lang/Exception
    //   128	145	184	java/lang/Exception
    //   40	46	242	finally
    //   61	90	242	finally
    //   90	128	242	finally
    //   128	145	242	finally
    //   151	158	258	finally
    //   190	196	258	finally
    //   198	229	258	finally
    //   151	158	268	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQUtils
 * JD-Core Version:    0.7.0.1
 */