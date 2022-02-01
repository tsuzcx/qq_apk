package com.tencent.qqmail.utilities.ui;

import alkx;
import alld;
import android.content.Context;
import android.content.Intent;
import android.content.Intent.ShortcutIconResource;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.launcher.third.LaunchWebPush;
import com.tencent.qqmail.utilities.log.QMLog;
import java.util.Iterator;
import java.util.List;

public class ShortcutUtility
{
  public static final String TAG = "ShortcutUtility";
  
  public static void addAppShortcut(Context paramContext) {}
  
  public static void addApplicationShortcut(String paramString, int paramInt)
  {
    QMLog.log(4, "ShortcutUtility", "add ShortCut, shortcutName:" + paramString);
    if (paramString.equals(QMApplicationContext.sharedInstance().getString(2131690401))) {}
    for (Intent localIntent1 = getCalendarIntent();; localIntent1 = getNoteIntent())
    {
      Intent localIntent2 = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
      localIntent2.putExtra("android.intent.extra.shortcut.NAME", paramString);
      localIntent2.putExtra("android.intent.extra.shortcut.INTENT", localIntent1);
      localIntent2.putExtra("duplicate", false);
      localIntent2.addFlags(268435456);
      localIntent2.addFlags(536870912);
      localIntent2.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", Intent.ShortcutIconResource.fromContext(QMApplicationContext.sharedInstance(), paramInt));
      QMApplicationContext.sharedInstance().sendBroadcast(localIntent2);
      do
      {
        return;
      } while (!paramString.equals(QMApplicationContext.sharedInstance().getString(2131690417)));
    }
  }
  
  public static void deleteApplicationShortcut(String paramString)
  {
    QMLog.log(4, "ShortcutUtility", "delete Shortcut, shortcutName:" + paramString);
    if (paramString.equals(QMApplicationContext.sharedInstance().getString(2131690401))) {}
    for (Intent localIntent1 = getCalendarIntent();; localIntent1 = getNoteIntent())
    {
      Intent localIntent2 = new Intent("com.android.launcher.action.UNINSTALL_SHORTCUT");
      localIntent2.putExtra("android.intent.extra.shortcut.NAME", paramString);
      localIntent2.putExtra("android.intent.extra.shortcut.INTENT", localIntent1);
      QMApplicationContext.sharedInstance().sendBroadcast(localIntent2);
      do
      {
        return;
      } while (!paramString.equals(QMApplicationContext.sharedInstance().getString(2131690417)));
    }
  }
  
  public static String getAuthority(String paramString)
  {
    try
    {
      Object localObject = alkx.a(QMApplicationContext.sharedInstance().getPackageManager(), 8);
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          ProviderInfo[] arrayOfProviderInfo = ((PackageInfo)((Iterator)localObject).next()).providers;
          if (arrayOfProviderInfo != null)
          {
            int j = arrayOfProviderInfo.length;
            int i = 0;
            while (i < j)
            {
              ProviderInfo localProviderInfo = arrayOfProviderInfo[i];
              if ((paramString.equals(localProviderInfo.readPermission)) || (paramString.equals(localProviderInfo.writePermission)))
              {
                paramString = localProviderInfo.authority;
                return paramString;
              }
              i += 1;
            }
          }
        }
      }
      return "com.android.launcher.settings";
    }
    catch (Exception paramString)
    {
      QMLog.log(6, "install_shortcut", paramString.getMessage());
    }
  }
  
  private static String getAuthorityFromPermission(Context paramContext, String paramString)
  {
    if (paramString == null) {
      return null;
    }
    paramContext = alkx.a(paramContext.getPackageManager(), 8);
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
            if ((localProviderInfo.readPermission != null) && (localProviderInfo.readPermission.equals(paramString))) {
              return localProviderInfo.authority;
            }
            i += 1;
          }
        }
      }
    }
    return null;
  }
  
  private static Intent getCalendarIntent()
  {
    return LaunchWebPush.createCalendarMainIntent();
  }
  
  private static Intent getNoteIntent()
  {
    return LaunchWebPush.createNoteMainIntent();
  }
  
  /* Error */
  public static boolean hasAppShortcut()
  {
    // Byte code:
    //   0: invokestatic 42	com/tencent/qqmail/QMApplicationContext:sharedInstance	()Lcom/tencent/qqmail/QMApplicationContext;
    //   3: astore_2
    //   4: aload_2
    //   5: invokevirtual 166	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   8: astore_3
    //   9: aload_3
    //   10: aload_3
    //   11: aload_2
    //   12: invokevirtual 178	android/content/Context:getPackageName	()Ljava/lang/String;
    //   15: sipush 128
    //   18: invokevirtual 184	android/content/pm/PackageManager:getApplicationInfo	(Ljava/lang/String;I)Landroid/content/pm/ApplicationInfo;
    //   21: invokevirtual 188	android/content/pm/PackageManager:getApplicationLabel	(Landroid/content/pm/ApplicationInfo;)Ljava/lang/CharSequence;
    //   24: invokeinterface 191 1 0
    //   29: astore_3
    //   30: iconst_5
    //   31: anewarray 49	java/lang/String
    //   34: astore 4
    //   36: aload 4
    //   38: iconst_0
    //   39: ldc 161
    //   41: aastore
    //   42: aload 4
    //   44: iconst_1
    //   45: ldc 193
    //   47: aastore
    //   48: aload 4
    //   50: iconst_2
    //   51: ldc 195
    //   53: aastore
    //   54: aload 4
    //   56: iconst_3
    //   57: ldc 197
    //   59: aastore
    //   60: aload 4
    //   62: iconst_4
    //   63: ldc 199
    //   65: invokestatic 201	com/tencent/qqmail/utilities/ui/ShortcutUtility:getAuthority	(Ljava/lang/String;)Ljava/lang/String;
    //   68: aastore
    //   69: aload 4
    //   71: arraylength
    //   72: istore_1
    //   73: iconst_0
    //   74: istore_0
    //   75: iload_0
    //   76: iload_1
    //   77: if_icmpge +188 -> 265
    //   80: aload 4
    //   82: iload_0
    //   83: aaload
    //   84: astore_2
    //   85: new 19	java/lang/StringBuilder
    //   88: dup
    //   89: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   92: ldc 203
    //   94: invokevirtual 26	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: aload_2
    //   98: invokevirtual 26	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: ldc 205
    //   103: invokevirtual 26	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: invokevirtual 30	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   109: invokestatic 211	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   112: astore_2
    //   113: invokestatic 42	com/tencent/qqmail/QMApplicationContext:sharedInstance	()Lcom/tencent/qqmail/QMApplicationContext;
    //   116: invokevirtual 215	com/tencent/qqmail/QMApplicationContext:getContentResolver	()Landroid/content/ContentResolver;
    //   119: aload_2
    //   120: iconst_1
    //   121: anewarray 49	java/lang/String
    //   124: dup
    //   125: iconst_0
    //   126: ldc 217
    //   128: aastore
    //   129: ldc 219
    //   131: iconst_1
    //   132: anewarray 49	java/lang/String
    //   135: dup
    //   136: iconst_0
    //   137: aload_3
    //   138: aastore
    //   139: aconst_null
    //   140: invokestatic 225	alld:query	(Landroid/content/ContentResolver;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   143: astore_2
    //   144: aload_2
    //   145: ifnull +39 -> 184
    //   148: aload_2
    //   149: invokeinterface 231 1 0
    //   154: ifle +30 -> 184
    //   157: aload_2
    //   158: invokeinterface 234 1 0
    //   163: aload_2
    //   164: ifnull +99 -> 263
    //   167: aload_2
    //   168: invokeinterface 237 1 0
    //   173: ifne +90 -> 263
    //   176: aload_2
    //   177: invokeinterface 234 1 0
    //   182: iconst_1
    //   183: ireturn
    //   184: aload_2
    //   185: ifnull +82 -> 267
    //   188: aload_2
    //   189: invokeinterface 237 1 0
    //   194: ifne +73 -> 267
    //   197: aload_2
    //   198: invokeinterface 234 1 0
    //   203: goto +64 -> 267
    //   206: aload_2
    //   207: ifnull +18 -> 225
    //   210: aload_2
    //   211: invokeinterface 237 1 0
    //   216: ifne +9 -> 225
    //   219: aload_2
    //   220: invokeinterface 234 1 0
    //   225: aload_3
    //   226: athrow
    //   227: astore_2
    //   228: bipush 6
    //   230: ldc 156
    //   232: new 19	java/lang/StringBuilder
    //   235: dup
    //   236: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   239: ldc 239
    //   241: invokevirtual 26	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   244: aload_2
    //   245: invokevirtual 159	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   248: invokevirtual 26	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   251: invokevirtual 30	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   254: invokestatic 36	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   257: iconst_1
    //   258: ireturn
    //   259: astore_3
    //   260: goto -54 -> 206
    //   263: iconst_1
    //   264: ireturn
    //   265: iconst_0
    //   266: ireturn
    //   267: iload_0
    //   268: iconst_1
    //   269: iadd
    //   270: istore_0
    //   271: goto -196 -> 75
    //   274: astore_3
    //   275: aconst_null
    //   276: astore_2
    //   277: goto -71 -> 206
    // Local variable table:
    //   start	length	slot	name	signature
    //   74	197	0	i	int
    //   72	6	1	j	int
    //   3	217	2	localObject1	Object
    //   227	18	2	localException	Exception
    //   276	1	2	localObject2	Object
    //   8	218	3	localObject3	Object
    //   259	1	3	localObject4	Object
    //   274	1	3	localObject5	Object
    //   34	47	4	arrayOfString	String[]
    // Exception table:
    //   from	to	target	type
    //   4	36	227	java/lang/Exception
    //   60	73	227	java/lang/Exception
    //   85	113	227	java/lang/Exception
    //   167	182	227	java/lang/Exception
    //   188	203	227	java/lang/Exception
    //   210	225	227	java/lang/Exception
    //   225	227	227	java/lang/Exception
    //   148	163	259	finally
    //   113	144	274	finally
  }
  
  public static boolean isShortcutExist(String paramString)
  {
    try
    {
      Object localObject = getAuthorityFromPermission(QMApplicationContext.sharedInstance(), "com.android.launcher.permission.READ_SETTINGS");
      if (localObject == null) {
        return false;
      }
      localObject = Uri.parse("content://" + (String)localObject + "/favorites?notify=true");
      paramString = alld.query(QMApplicationContext.sharedInstance().getContentResolver(), (Uri)localObject, null, "title=?", new String[] { paramString.trim() }, null);
      if (paramString != null)
      {
        if (paramString.getCount() > 0)
        {
          paramString.close();
          return true;
        }
        paramString.close();
        return false;
      }
      return false;
    }
    catch (Exception paramString) {}
    return false;
  }
  
  public static void showShortcutInstaller(Context paramContext)
  {
    SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("user_info", 4);
    String str = localSharedPreferences.getString("shortcut_install_key", "");
    QMLog.log(4, "shortcut", "getresult : [" + str + "]");
    if (str.length() == 0)
    {
      boolean bool = localSharedPreferences.edit().putString("shortcut_install_key", "anyhow").commit();
      QMLog.log(4, "shortcut", "result " + bool);
      addAppShortcut(paramContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.ui.ShortcutUtility
 * JD-Core Version:    0.7.0.1
 */