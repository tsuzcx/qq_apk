package com.tencent.mobileqq.utils;

import android.app.Activity;
import android.app.KeyguardManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ShortcutGuideActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.util.SkinUtils;
import com.tencent.mobileqq.utils.kapalaiadapter.KapalaiAdapterUtil;
import com.tencent.mobileqq.utils.kapalaiadapter.MobileIssueSettings;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.BadgeUtils;
import evp;
import evq;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.manager.ServerConfigManager;
import mqq.manager.ServerConfigManager.ConfigType;

public class QQUtils
{
  public static final String a = "sid";
  public static final String b = "uin";
  private static String c = "QQUtils";
  
  public static Intent a(QQAppInterface paramQQAppInterface, String paramString, Map paramMap)
  {
    Intent localIntent = new Intent("android.intent.action.MAIN");
    localIntent.setClassName(paramQQAppInterface.a(), ShortcutGuideActivity.class.getName());
    localIntent.addCategory("android.intent.category.LAUNCHER");
    String str = (String)paramMap.get("nickname");
    if (paramString.endsWith("sid"))
    {
      paramQQAppInterface = (String)paramMap.get("starHomeUrl");
      localIntent.putExtra("sid", (String)paramMap.get("starId"));
      localIntent.putExtra("from", "starShortcut");
      localIntent.putExtra("starhomeurl", paramQQAppInterface);
      paramQQAppInterface = str;
    }
    for (;;)
    {
      localIntent.putExtra("uinname", paramQQAppInterface);
      return localIntent;
      paramString = (String)paramMap.get("uin");
      int i = Integer.valueOf(paramMap.get("uinType").toString()).intValue();
      localIntent.putExtra("uin", paramString);
      if (str != null)
      {
        paramQQAppInterface = str;
        if (str.trim().length() != 0) {}
      }
      else
      {
        paramQQAppInterface = paramString;
      }
      if (i == 1024) {
        localIntent.putExtra("uintype", 1024);
      } else {
        localIntent.putExtra("uintype", 0);
      }
    }
  }
  
  /* Error */
  public static Bitmap a(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 117	com/tencent/mobileqq/utils/ShortcutUtils:a	(Landroid/content/Context;)Z
    //   4: ifne +7 -> 11
    //   7: aconst_null
    //   8: astore_1
    //   9: aload_1
    //   10: areturn
    //   11: getstatic 119	com/tencent/mobileqq/utils/ShortcutUtils:a	Ljava/lang/String;
    //   14: astore_2
    //   15: aload_0
    //   16: invokevirtual 125	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   19: astore_0
    //   20: aload_0
    //   21: aload_2
    //   22: invokestatic 131	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   25: aconst_null
    //   26: ldc 133
    //   28: iconst_1
    //   29: anewarray 63	java/lang/String
    //   32: dup
    //   33: iconst_0
    //   34: aload_1
    //   35: aastore
    //   36: aconst_null
    //   37: invokevirtual 139	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   40: astore_0
    //   41: aload_0
    //   42: ifnull +60 -> 102
    //   45: aconst_null
    //   46: astore_2
    //   47: aload_0
    //   48: astore_1
    //   49: aload_0
    //   50: invokeinterface 145 1 0
    //   55: ifeq +33 -> 88
    //   58: aload_0
    //   59: astore_1
    //   60: aload_0
    //   61: aload_0
    //   62: ldc 147
    //   64: invokeinterface 151 2 0
    //   69: invokeinterface 155 2 0
    //   74: astore_2
    //   75: aload_0
    //   76: astore_1
    //   77: aload_2
    //   78: iconst_0
    //   79: aload_2
    //   80: arraylength
    //   81: invokestatic 160	com/tencent/mobileqq/util/BitmapManager:a	([BII)Landroid/graphics/Bitmap;
    //   84: astore_2
    //   85: goto -38 -> 47
    //   88: aload_2
    //   89: astore_1
    //   90: aload_0
    //   91: ifnull -82 -> 9
    //   94: aload_0
    //   95: invokeinterface 163 1 0
    //   100: aload_2
    //   101: areturn
    //   102: aload_0
    //   103: ifnull +9 -> 112
    //   106: aload_0
    //   107: invokeinterface 163 1 0
    //   112: aconst_null
    //   113: areturn
    //   114: astore_2
    //   115: aconst_null
    //   116: astore_0
    //   117: aload_0
    //   118: astore_1
    //   119: invokestatic 168	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   122: ifeq +34 -> 156
    //   125: aload_0
    //   126: astore_1
    //   127: getstatic 18	com/tencent/mobileqq/utils/QQUtils:c	Ljava/lang/String;
    //   130: iconst_2
    //   131: new 170	java/lang/StringBuilder
    //   134: dup
    //   135: invokespecial 171	java/lang/StringBuilder:<init>	()V
    //   138: ldc 173
    //   140: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: aload_2
    //   144: invokevirtual 178	java/lang/Exception:toString	()Ljava/lang/String;
    //   147: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   153: invokestatic 183	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   156: aload_0
    //   157: ifnull -45 -> 112
    //   160: aload_0
    //   161: invokeinterface 163 1 0
    //   166: goto -54 -> 112
    //   169: astore_0
    //   170: aconst_null
    //   171: astore_1
    //   172: aload_1
    //   173: ifnull +9 -> 182
    //   176: aload_1
    //   177: invokeinterface 163 1 0
    //   182: aload_0
    //   183: athrow
    //   184: astore_0
    //   185: goto -13 -> 172
    //   188: astore_2
    //   189: goto -72 -> 117
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	192	0	paramContext	Context
    //   0	192	1	paramString	String
    //   14	87	2	localObject	Object
    //   114	30	2	localException1	java.lang.Exception
    //   188	1	2	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   20	41	114	java/lang/Exception
    //   20	41	169	finally
    //   49	58	184	finally
    //   60	75	184	finally
    //   77	85	184	finally
    //   119	125	184	finally
    //   127	156	184	finally
    //   49	58	188	java/lang/Exception
    //   60	75	188	java/lang/Exception
    //   77	85	188	java/lang/Exception
  }
  
  public static Bitmap a(String paramString1, String paramString2, String paramString3, QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    paramString2 = a(paramString2);
    File localFile = new File(paramString2);
    if (!localFile.exists())
    {
      if (paramBoolean) {
        return paramQQAppInterface.a(a(paramQQAppInterface.a(), paramString3), 50, 50);
      }
      if (!HttpDownloadUtil.a(paramQQAppInterface, paramString1, localFile))
      {
        if (localFile.exists()) {
          localFile.delete();
        }
        return null;
      }
    }
    return paramQQAppInterface.a(BitmapManager.a(paramString2), 50, 50);
  }
  
  /* Error */
  public static android.util.SparseArray a(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 117	com/tencent/mobileqq/utils/ShortcutUtils:a	(Landroid/content/Context;)Z
    //   4: ifne +7 -> 11
    //   7: aconst_null
    //   8: astore_0
    //   9: aload_0
    //   10: areturn
    //   11: getstatic 119	com/tencent/mobileqq/utils/ShortcutUtils:a	Ljava/lang/String;
    //   14: astore_2
    //   15: aload_0
    //   16: invokevirtual 125	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   19: astore_0
    //   20: aload_2
    //   21: invokestatic 131	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   24: astore_2
    //   25: new 170	java/lang/StringBuilder
    //   28: dup
    //   29: invokespecial 171	java/lang/StringBuilder:<init>	()V
    //   32: ldc 212
    //   34: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: aload_1
    //   38: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: ldc 214
    //   43: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   49: astore_1
    //   50: aload_0
    //   51: aload_2
    //   52: iconst_2
    //   53: anewarray 63	java/lang/String
    //   56: dup
    //   57: iconst_0
    //   58: ldc 216
    //   60: aastore
    //   61: dup
    //   62: iconst_1
    //   63: ldc 218
    //   65: aastore
    //   66: aload_1
    //   67: aconst_null
    //   68: aconst_null
    //   69: invokevirtual 139	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   72: astore_1
    //   73: aload_1
    //   74: ifnull +131 -> 205
    //   77: aload_1
    //   78: astore_0
    //   79: new 220	android/util/SparseArray
    //   82: dup
    //   83: invokespecial 221	android/util/SparseArray:<init>	()V
    //   86: astore_2
    //   87: aload_1
    //   88: astore_0
    //   89: aload_1
    //   90: invokeinterface 145 1 0
    //   95: ifeq +96 -> 191
    //   98: aload_1
    //   99: astore_0
    //   100: aload_1
    //   101: aload_1
    //   102: ldc 216
    //   104: invokeinterface 151 2 0
    //   109: invokeinterface 225 2 0
    //   114: astore_3
    //   115: aload_1
    //   116: astore_0
    //   117: aload_2
    //   118: aload_1
    //   119: aload_1
    //   120: ldc 218
    //   122: invokeinterface 151 2 0
    //   127: invokeinterface 229 2 0
    //   132: aload_3
    //   133: invokevirtual 233	android/util/SparseArray:put	(ILjava/lang/Object;)V
    //   136: goto -49 -> 87
    //   139: astore_2
    //   140: aload_1
    //   141: astore_0
    //   142: invokestatic 168	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   145: ifeq +34 -> 179
    //   148: aload_1
    //   149: astore_0
    //   150: getstatic 18	com/tencent/mobileqq/utils/QQUtils:c	Ljava/lang/String;
    //   153: iconst_2
    //   154: new 170	java/lang/StringBuilder
    //   157: dup
    //   158: invokespecial 171	java/lang/StringBuilder:<init>	()V
    //   161: ldc 173
    //   163: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: aload_2
    //   167: invokevirtual 178	java/lang/Exception:toString	()Ljava/lang/String;
    //   170: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   176: invokestatic 183	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   179: aload_1
    //   180: ifnull +9 -> 189
    //   183: aload_1
    //   184: invokeinterface 163 1 0
    //   189: aconst_null
    //   190: areturn
    //   191: aload_2
    //   192: astore_0
    //   193: aload_1
    //   194: ifnull -185 -> 9
    //   197: aload_1
    //   198: invokeinterface 163 1 0
    //   203: aload_2
    //   204: areturn
    //   205: aload_1
    //   206: ifnull -17 -> 189
    //   209: aload_1
    //   210: invokeinterface 163 1 0
    //   215: goto -26 -> 189
    //   218: astore_1
    //   219: aconst_null
    //   220: astore_0
    //   221: aload_0
    //   222: ifnull +9 -> 231
    //   225: aload_0
    //   226: invokeinterface 163 1 0
    //   231: aload_1
    //   232: athrow
    //   233: astore_1
    //   234: goto -13 -> 221
    //   237: astore_2
    //   238: aconst_null
    //   239: astore_1
    //   240: goto -100 -> 140
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	243	0	paramContext	Context
    //   0	243	1	paramString	String
    //   14	104	2	localObject	Object
    //   139	65	2	localException1	java.lang.Exception
    //   237	1	2	localException2	java.lang.Exception
    //   114	19	3	str	String
    // Exception table:
    //   from	to	target	type
    //   79	87	139	java/lang/Exception
    //   89	98	139	java/lang/Exception
    //   100	115	139	java/lang/Exception
    //   117	136	139	java/lang/Exception
    //   20	73	218	finally
    //   79	87	233	finally
    //   89	98	233	finally
    //   100	115	233	finally
    //   117	136	233	finally
    //   142	148	233	finally
    //   150	179	233	finally
    //   20	73	237	java/lang/Exception
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
  
  public static String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder(256);
    localStringBuilder.append(AppConstants.aP);
    String str = MD5.toMD5(paramString);
    str = MD5.toMD5(str + paramString);
    localStringBuilder.append(MD5.toMD5(str + paramString));
    localStringBuilder.append(".png");
    return localStringBuilder.toString();
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
          break label258;
        }
        String str = "<" + paramString + ">";
        i = ((String)localObject1).indexOf(str);
        paramConfigType = (ServerConfigManager.ConfigType)localObject1;
        if (-1 == i) {
          break label258;
        }
        i = str.length() + i;
        int j = ((String)localObject1).indexOf("</" + paramString + ">", i);
        paramConfigType = (ServerConfigManager.ConfigType)localObject1;
        if (-1 == j) {
          break label258;
        }
        paramString = ((String)localObject1).substring(i, j);
        localStringBuilder.append(paramString);
        paramConfigType = paramString;
      } while (!QLog.isColorLevel());
      QLog.d("QQUtils", 2, localStringBuilder.toString());
      return paramString;
      paramConfigType = null;
      label258:
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
    ShortcutUtils.a(paramActivity, paramString);
  }
  
  public static void a(Context paramContext, String paramString)
  {
    ShortcutUtils.a(paramContext, paramString);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt1, String paramString1, String paramString2, int paramInt2, Handler paramHandler, int paramInt3)
  {
    if (a(paramQQAppInterface.a(), new String[] { paramString2 }))
    {
      paramString1 = paramQQAppInterface.a().getString(2131363664);
      if (paramString1 != null) {
        QQToast.a(paramQQAppInterface.a(), paramString1, 0).b(paramInt2);
      }
      return;
    }
    Object localObject = new Intent("android.intent.action.MAIN");
    ((Intent)localObject).setClassName(paramQQAppInterface.a(), paramString1);
    ((Intent)localObject).addCategory("android.intent.category.LAUNCHER");
    ((Intent)localObject).putExtra("jump_shortcut_dataline", true);
    Intent localIntent = new Intent();
    KapalaiAdapterUtil.a().a((Intent)localObject);
    localIntent.putExtra("android.intent.extra.shortcut.INTENT", (Parcelable)localObject);
    localIntent.putExtra("android.intent.extra.shortcut.NAME", paramString2);
    paramString1 = paramQQAppInterface.a().getApplicationContext();
    localObject = BitmapFactory.decodeResource(paramString1.getResources(), paramInt1);
    paramInt1 = DisplayUtils.b(paramString1);
    paramString1 = (String)localObject;
    if (((Bitmap)localObject).getWidth() != paramInt1) {
      if (MobileIssueSettings.c) {
        break label238;
      }
    }
    label238:
    for (paramString1 = KapalaiAdapterUtil.a().a((Bitmap)localObject, paramInt1);; paramString1 = Bitmap.createScaledBitmap((Bitmap)localObject, paramInt1, paramInt1, false))
    {
      localIntent.putExtra("android.intent.extra.shortcut.ICON", paramString1);
      localIntent.putExtra("duplicate", false);
      localIntent.setAction("com.android.launcher.action.INSTALL_SHORTCUT");
      paramQQAppInterface.a().sendOrderedBroadcast(localIntent, null);
      paramHandler.postDelayed(new evq(paramQQAppInterface, paramString2, paramInt2), paramInt3);
      return;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Intent paramIntent)
  {
    BadgeUtils.a(paramQQAppInterface.a(), 0);
    Intent localIntent = new Intent();
    KapalaiAdapterUtil.a().a(paramIntent);
    localIntent.putExtra("android.intent.extra.shortcut.INTENT", paramIntent);
    localIntent.putExtra("android.intent.extra.shortcut.NAME", "QQ");
    localIntent.putExtra("duplicate", false);
    localIntent.setAction("com.android.launcher.action.UNINSTALL_SHORTCUT");
    paramQQAppInterface.a().sendOrderedBroadcast(localIntent, null);
    if (QLog.isColorLevel()) {
      QLog.d(c, 2, "deleteShortcut.finish.");
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Intent paramIntent, String paramString, Bitmap paramBitmap)
  {
    BadgeUtils.a(paramQQAppInterface.a(), 0);
    Intent localIntent = new Intent();
    KapalaiAdapterUtil.a().a(paramIntent);
    localIntent.putExtra("android.intent.extra.shortcut.INTENT", paramIntent);
    localIntent.putExtra("android.intent.extra.shortcut.NAME", paramString);
    int i = DisplayUtils.b(paramQQAppInterface.a());
    paramIntent = paramBitmap;
    if (i != paramBitmap.getWidth()) {
      if (MobileIssueSettings.c) {
        break label136;
      }
    }
    label136:
    for (paramIntent = KapalaiAdapterUtil.a().a(paramBitmap, i);; paramIntent = Bitmap.createScaledBitmap(paramBitmap, i, i, false))
    {
      localIntent.putExtra("android.intent.extra.shortcut.ICON", paramIntent);
      localIntent.putExtra("duplicate", false);
      localIntent.setAction("com.android.launcher.action.INSTALL_SHORTCUT");
      paramQQAppInterface.a().sendOrderedBroadcast(localIntent, null);
      if (QLog.isColorLevel()) {
        QLog.d(c, 2, "createShortcut.finish.");
      }
      return;
    }
  }
  
  /* Error */
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 35	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   4: aload_1
    //   5: invokestatic 490	com/tencent/mobileqq/utils/QQUtils:a	(Landroid/content/Context;Ljava/lang/String;)Landroid/util/SparseArray;
    //   8: astore 8
    //   10: aload 8
    //   12: ifnonnull +4 -> 16
    //   15: return
    //   16: aload 8
    //   18: invokevirtual 493	android/util/SparseArray:size	()I
    //   21: istore_3
    //   22: iconst_0
    //   23: istore_2
    //   24: iload_2
    //   25: iload_3
    //   26: if_icmpge -11 -> 15
    //   29: aload 8
    //   31: iload_2
    //   32: invokevirtual 496	android/util/SparseArray:keyAt	(I)I
    //   35: istore 4
    //   37: aload 8
    //   39: iload 4
    //   41: invokevirtual 499	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   44: checkcast 63	java/lang/String
    //   47: astore 5
    //   49: aload 5
    //   51: iconst_1
    //   52: invokestatic 502	android/content/Intent:parseUri	(Ljava/lang/String;I)Landroid/content/Intent;
    //   55: astore 5
    //   57: aload 5
    //   59: ldc_w 504
    //   62: invokevirtual 53	android/content/Intent:addCategory	(Ljava/lang/String;)Landroid/content/Intent;
    //   65: pop
    //   66: aload 5
    //   68: aconst_null
    //   69: invokevirtual 508	android/content/Intent:setComponent	(Landroid/content/ComponentName;)Landroid/content/Intent;
    //   72: pop
    //   73: aload 5
    //   75: aconst_null
    //   76: invokevirtual 511	android/content/Intent:setSelector	(Landroid/content/Intent;)V
    //   79: aload 5
    //   81: astore 6
    //   83: aload 6
    //   85: ifnull -70 -> 15
    //   88: aload 6
    //   90: ldc 83
    //   92: invokevirtual 514	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   95: astore 7
    //   97: aload_1
    //   98: ldc 8
    //   100: invokevirtual 67	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   103: ifeq +111 -> 214
    //   106: aconst_null
    //   107: aload 6
    //   109: ldc 8
    //   111: invokevirtual 514	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   114: iload 4
    //   116: invokestatic 516	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   119: aload_0
    //   120: iconst_1
    //   121: invokestatic 518	com/tencent/mobileqq/utils/QQUtils:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/app/QQAppInterface;Z)Landroid/graphics/Bitmap;
    //   124: astore 5
    //   126: aload_0
    //   127: aload 6
    //   129: invokestatic 520	com/tencent/mobileqq/utils/QQUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Intent;)V
    //   132: ldc2_w 521
    //   135: invokestatic 528	java/lang/Thread:sleep	(J)V
    //   138: aload_0
    //   139: aload 6
    //   141: aload 7
    //   143: aload 5
    //   145: invokestatic 530	com/tencent/mobileqq/utils/QQUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Intent;Ljava/lang/String;Landroid/graphics/Bitmap;)V
    //   148: ldc2_w 521
    //   151: invokestatic 528	java/lang/Thread:sleep	(J)V
    //   154: iload_2
    //   155: iconst_1
    //   156: iadd
    //   157: istore_2
    //   158: goto -134 -> 24
    //   161: astore 7
    //   163: aconst_null
    //   164: astore 5
    //   166: aload 5
    //   168: astore 6
    //   170: invokestatic 168	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   173: ifeq -90 -> 83
    //   176: getstatic 18	com/tencent/mobileqq/utils/QQUtils:c	Ljava/lang/String;
    //   179: iconst_2
    //   180: new 170	java/lang/StringBuilder
    //   183: dup
    //   184: invokespecial 171	java/lang/StringBuilder:<init>	()V
    //   187: ldc_w 532
    //   190: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   193: aload 7
    //   195: invokevirtual 535	java/net/URISyntaxException:getMessage	()Ljava/lang/String;
    //   198: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   204: invokestatic 183	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   207: aload 5
    //   209: astore 6
    //   211: goto -128 -> 83
    //   214: aload_0
    //   215: aload 6
    //   217: ldc 11
    //   219: invokevirtual 514	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   222: invokevirtual 538	com/tencent/mobileqq/app/QQAppInterface:b	(Ljava/lang/String;)Landroid/graphics/drawable/Drawable;
    //   225: invokestatic 543	com/tencent/mobileqq/util/SkinUtils:a	(Landroid/graphics/drawable/Drawable;)Landroid/graphics/Bitmap;
    //   228: astore 5
    //   230: goto -104 -> 126
    //   233: astore 9
    //   235: invokestatic 168	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   238: ifeq -100 -> 138
    //   241: getstatic 18	com/tencent/mobileqq/utils/QQUtils:c	Ljava/lang/String;
    //   244: iconst_2
    //   245: new 170	java/lang/StringBuilder
    //   248: dup
    //   249: invokespecial 171	java/lang/StringBuilder:<init>	()V
    //   252: ldc_w 545
    //   255: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   258: aload 9
    //   260: invokevirtual 546	java/lang/InterruptedException:getMessage	()Ljava/lang/String;
    //   263: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   266: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   269: invokestatic 183	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   272: goto -134 -> 138
    //   275: astore 5
    //   277: invokestatic 168	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   280: ifeq -126 -> 154
    //   283: getstatic 18	com/tencent/mobileqq/utils/QQUtils:c	Ljava/lang/String;
    //   286: iconst_2
    //   287: new 170	java/lang/StringBuilder
    //   290: dup
    //   291: invokespecial 171	java/lang/StringBuilder:<init>	()V
    //   294: ldc_w 545
    //   297: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   300: aload 5
    //   302: invokevirtual 546	java/lang/InterruptedException:getMessage	()Ljava/lang/String;
    //   305: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   308: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   311: invokestatic 183	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   314: goto -160 -> 154
    //   317: astore 7
    //   319: goto -153 -> 166
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	322	0	paramQQAppInterface	QQAppInterface
    //   0	322	1	paramString	String
    //   23	135	2	i	int
    //   21	6	3	j	int
    //   35	80	4	k	int
    //   47	182	5	localObject1	Object
    //   275	26	5	localInterruptedException1	java.lang.InterruptedException
    //   81	135	6	localObject2	Object
    //   95	47	7	str	String
    //   161	33	7	localURISyntaxException1	java.net.URISyntaxException
    //   317	1	7	localURISyntaxException2	java.net.URISyntaxException
    //   8	30	8	localSparseArray	android.util.SparseArray
    //   233	26	9	localInterruptedException2	java.lang.InterruptedException
    // Exception table:
    //   from	to	target	type
    //   49	57	161	java/net/URISyntaxException
    //   132	138	233	java/lang/InterruptedException
    //   148	154	275	java/lang/InterruptedException
    //   57	79	317	java/net/URISyntaxException
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("uin", paramString1);
    localHashMap.put("nickname", paramString2);
    localHashMap.put("uinType", Integer.valueOf(paramInt));
    a(paramQQAppInterface, a(paramQQAppInterface, "uin", localHashMap), paramString2, SkinUtils.a(paramQQAppInterface.b(paramString1)));
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt1, Handler paramHandler, int paramInt2, String paramString3, int paramInt3)
  {
    if (QLog.isColorLevel()) {
      QLog.d(c, 2, "createShortcutWhihTips.begin.");
    }
    if (a(paramQQAppInterface.a(), new String[] { paramString2 }))
    {
      paramString1 = paramQQAppInterface.a().getString(2131363664);
      if (paramString1 != null) {
        QQToast.a(paramQQAppInterface.a(), paramString1, 0).b(paramInt1);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(c, 2, "createShortcutWhihTips.no shortcut.");
    }
    a(paramQQAppInterface, paramString1, paramString2, paramInt3);
    paramHandler.postDelayed(new evp(paramQQAppInterface, paramString2, paramInt1, paramString3), paramInt2);
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
  
  public static boolean a(Context paramContext, String[] paramArrayOfString)
  {
    return ShortcutUtils.a(paramContext, paramArrayOfString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQUtils
 * JD-Core Version:    0.7.0.1
 */