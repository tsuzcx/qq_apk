import android.app.Activity;
import android.app.Dialog;
import android.app.KeyguardManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.ProviderInfo;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.SparseArray;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ShortcutGuideActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.mobileqq.utils.QQUtils.1;
import com.tencent.mobileqq.utils.QQUtils.2;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import java.io.File;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.manager.ServerConfigManager;
import mqq.manager.ServerConfigManager.ConfigType;
import mqq.os.MqqHandler;

public class aqlr
{
  private static String TAG = "QQUtils";
  
  public static Dialog a(Activity paramActivity, String paramString1, String paramString2, int paramInt)
  {
    paramActivity = new ReportDialog(paramActivity, 2131756467);
    paramActivity.setContentView(2131561435);
    TextView localTextView3 = (TextView)paramActivity.findViewById(2131381087);
    TextView localTextView4 = (TextView)paramActivity.findViewById(2131381064);
    TextView localTextView1 = (TextView)paramActivity.findViewById(2131381059);
    TextView localTextView2 = (TextView)paramActivity.findViewById(2131381055);
    localTextView3.setText(paramString1);
    localTextView4.setText(new SpannableString(paramString2));
    paramString1 = (ImageView)paramActivity.findViewById(2131364456);
    ((ImageButton)paramActivity.findViewById(2131364690)).setOnClickListener(new aqls(paramActivity));
    if (paramInt >= 0)
    {
      paramString1.setVisibility(0);
      localTextView2.setText("+");
      localTextView1.setText(String.valueOf(paramInt));
      return paramActivity;
    }
    localTextView2.setText("-");
    localTextView1.setText(String.valueOf(0 - paramInt));
    return paramActivity;
  }
  
  public static Intent a(QQAppInterface paramQQAppInterface, String paramString, Map<String, Object> paramMap)
  {
    Intent localIntent = new Intent("intent.start.shortcut.guide");
    localIntent.setClassName(paramQQAppInterface.getApp(), ShortcutGuideActivity.class.getName());
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
  
  public static Bitmap a(String paramString1, String paramString2, String paramString3, QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    paramString2 = pG(paramString2);
    File localFile = new File(paramString2);
    if (!localFile.exists())
    {
      if (paramBoolean) {
        return QQAppInterface.getCircleFaceBitmap(e(paramQQAppInterface.getApp(), paramString3), 50, 50);
      }
      if (!HttpDownloadUtil.a(paramQQAppInterface, paramString1, localFile))
      {
        if (localFile.exists()) {
          localFile.delete();
        }
        return null;
      }
    }
    return QQAppInterface.getCircleFaceBitmap(aqcu.decodeFile(paramString2), 50, 50);
  }
  
  /* Error */
  public static SparseArray<String> a(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 209	aqml:ce	(Landroid/content/Context;)Z
    //   4: ifne +7 -> 11
    //   7: aconst_null
    //   8: astore_0
    //   9: aload_0
    //   10: areturn
    //   11: getstatic 212	aqml:aQb	Ljava/lang/String;
    //   14: astore_2
    //   15: aload_0
    //   16: invokevirtual 218	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   19: astore_0
    //   20: aload_2
    //   21: invokestatic 224	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   24: astore_2
    //   25: new 226	java/lang/StringBuilder
    //   28: dup
    //   29: invokespecial 228	java/lang/StringBuilder:<init>	()V
    //   32: ldc 230
    //   34: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: aload_1
    //   38: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: ldc 236
    //   43: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: invokevirtual 237	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   49: astore_1
    //   50: aload_0
    //   51: aload_2
    //   52: iconst_2
    //   53: anewarray 69	java/lang/String
    //   56: dup
    //   57: iconst_0
    //   58: ldc 239
    //   60: aastore
    //   61: dup
    //   62: iconst_1
    //   63: ldc 241
    //   65: aastore
    //   66: aload_1
    //   67: aconst_null
    //   68: aconst_null
    //   69: invokestatic 247	alld:query	(Landroid/content/ContentResolver;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   72: astore_1
    //   73: aload_1
    //   74: ifnull +132 -> 206
    //   77: aload_1
    //   78: astore_0
    //   79: new 249	android/util/SparseArray
    //   82: dup
    //   83: invokespecial 250	android/util/SparseArray:<init>	()V
    //   86: astore_2
    //   87: aload_1
    //   88: astore_0
    //   89: aload_1
    //   90: invokeinterface 255 1 0
    //   95: ifeq +97 -> 192
    //   98: aload_1
    //   99: astore_0
    //   100: aload_1
    //   101: aload_1
    //   102: ldc 239
    //   104: invokeinterface 259 2 0
    //   109: invokeinterface 262 2 0
    //   114: astore_3
    //   115: aload_1
    //   116: astore_0
    //   117: aload_2
    //   118: aload_1
    //   119: aload_1
    //   120: ldc 241
    //   122: invokeinterface 259 2 0
    //   127: invokeinterface 266 2 0
    //   132: aload_3
    //   133: invokevirtual 270	android/util/SparseArray:put	(ILjava/lang/Object;)V
    //   136: goto -49 -> 87
    //   139: astore_2
    //   140: aload_1
    //   141: astore_0
    //   142: invokestatic 275	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   145: ifeq +35 -> 180
    //   148: aload_1
    //   149: astore_0
    //   150: getstatic 12	aqlr:TAG	Ljava/lang/String;
    //   153: iconst_2
    //   154: new 226	java/lang/StringBuilder
    //   157: dup
    //   158: invokespecial 228	java/lang/StringBuilder:<init>	()V
    //   161: ldc_w 277
    //   164: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: aload_2
    //   168: invokevirtual 278	java/lang/Exception:toString	()Ljava/lang/String;
    //   171: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: invokevirtual 237	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   177: invokestatic 282	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   180: aload_1
    //   181: ifnull +9 -> 190
    //   184: aload_1
    //   185: invokeinterface 285 1 0
    //   190: aconst_null
    //   191: areturn
    //   192: aload_2
    //   193: astore_0
    //   194: aload_1
    //   195: ifnull -186 -> 9
    //   198: aload_1
    //   199: invokeinterface 285 1 0
    //   204: aload_2
    //   205: areturn
    //   206: aload_1
    //   207: ifnull -17 -> 190
    //   210: aload_1
    //   211: invokeinterface 285 1 0
    //   216: goto -26 -> 190
    //   219: astore_1
    //   220: aconst_null
    //   221: astore_0
    //   222: aload_0
    //   223: ifnull +9 -> 232
    //   226: aload_0
    //   227: invokeinterface 285 1 0
    //   232: aload_1
    //   233: athrow
    //   234: astore_1
    //   235: goto -13 -> 222
    //   238: astore_2
    //   239: aconst_null
    //   240: astore_1
    //   241: goto -101 -> 140
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	244	0	paramContext	Context
    //   0	244	1	paramString	String
    //   14	104	2	localObject	Object
    //   139	66	2	localException1	java.lang.Exception
    //   238	1	2	localException2	java.lang.Exception
    //   114	19	3	str	String
    // Exception table:
    //   from	to	target	type
    //   79	87	139	java/lang/Exception
    //   89	98	139	java/lang/Exception
    //   100	115	139	java/lang/Exception
    //   117	136	139	java/lang/Exception
    //   20	73	219	finally
    //   79	87	234	finally
    //   89	98	234	finally
    //   100	115	234	finally
    //   117	136	234	finally
    //   142	148	234	finally
    //   150	180	234	finally
    //   20	73	238	java/lang/Exception
  }
  
  public static String a(ServerConfigManager.ConfigType paramConfigType, String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = BaseApplicationImpl.getApplication();
    if (localObject1 != null) {}
    for (localObject1 = ((BaseApplicationImpl)localObject1).getRuntime();; localObject1 = null)
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
        localObject1 = localServerConfigManager.getServerConfig(getUin(), paramConfigType);
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
  
  public static void a(QQAppInterface paramQQAppInterface, Intent paramIntent, String paramString, Bitmap paramBitmap)
  {
    Intent localIntent = new Intent();
    aqoo.a().setShortcutIntentFlag(paramIntent);
    localIntent.putExtra("android.intent.extra.shortcut.INTENT", paramIntent);
    localIntent.putExtra("android.intent.extra.shortcut.NAME", paramString);
    int i = aqho.O(paramQQAppInterface.getApp());
    paramIntent = paramBitmap;
    if (i != paramBitmap.getWidth()) {
      if (aqoq.cVg) {
        break label128;
      }
    }
    label128:
    for (paramIntent = aqoo.a().createScaledBitmapByConfig(paramBitmap, i);; paramIntent = Bitmap.createScaledBitmap(paramBitmap, i, i, false))
    {
      localIntent.putExtra("android.intent.extra.shortcut.ICON", paramIntent);
      localIntent.putExtra("duplicate", false);
      localIntent.setAction("com.android.launcher.action.INSTALL_SHORTCUT");
      paramQQAppInterface.getApp().sendOrderedBroadcast(localIntent, null);
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "createShortcut.finish.");
      }
      return;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt1, MqqHandler paramMqqHandler, int paramInt2, String paramString3, int paramInt3)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "createShortcutWhihTips.begin.");
    }
    if (hasShortCut(paramQQAppInterface.getApp(), new String[] { paramString2 }))
    {
      paramString1 = paramQQAppInterface.getApp().getString(2131693296);
      if (paramString1 != null) {
        paramMqqHandler.post(new QQUtils.1(paramQQAppInterface, paramString1, paramInt1));
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "createShortcutWhihTips.no shortcut.");
    }
    s(paramQQAppInterface, paramString1, paramString2, paramInt3);
    paramMqqHandler.postDelayed(new QQUtils.2(hasShortCut(paramQQAppInterface.getApp(), new String[] { paramString2 }), paramQQAppInterface, paramInt1, paramString3), paramInt2);
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
  
  public static void bi(QQAppInterface paramQQAppInterface, String paramString)
  {
    SparseArray localSparseArray = a(paramQQAppInterface.getApp(), paramString);
    if (localSparseArray == null) {}
    for (;;)
    {
      return;
      int j = localSparseArray.size();
      int i = 0;
      label24:
      if (i >= j) {
        continue;
      }
      int k = localSparseArray.keyAt(i);
      Object localObject1 = (String)localSparseArray.get(k);
      try
      {
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          localObject1 = Intent.parseUri((String)localObject1, 0);
        }
      }
      catch (URISyntaxException localInterruptedException2)
      {
        for (;;)
        {
          for (;;)
          {
            try
            {
              ((Intent)localObject1).addCategory("android.intent.category.BROWSABLE");
              ((Intent)localObject1).setComponent(null);
              localObject2 = localObject1;
              if (Build.VERSION.SDK_INT >= 15)
              {
                ((Intent)localObject1).setSelector(null);
                localObject2 = localObject1;
              }
              if (localObject2 == null) {
                break;
              }
              str = localObject2.getStringExtra("uinname");
              if (paramString.endsWith("sid"))
              {
                localObject1 = a(null, localObject2.getStringExtra("sid"), String.valueOf(k), paramQQAppInterface, true);
                g(paramQQAppInterface, localObject2);
              }
            }
            catch (URISyntaxException localURISyntaxException2)
            {
              String str;
              continue;
            }
            try
            {
              Thread.sleep(1000L);
              a(paramQQAppInterface, localObject2, str, (Bitmap)localObject1);
            }
            catch (InterruptedException localInterruptedException2)
            {
              try
              {
                Thread.sleep(1000L);
                i += 1;
                break label24;
                localURISyntaxException1 = localURISyntaxException1;
                localObject1 = null;
                localObject2 = localObject1;
                if (QLog.isColorLevel())
                {
                  QLog.d(TAG, 2, "shortcutIntent parse exception " + localURISyntaxException1.getMessage());
                  localObject2 = localObject1;
                  continue;
                  localObject1 = aqff.getDrawableBitmap(paramQQAppInterface.m(localObject2.getStringExtra("uin")));
                  continue;
                  localInterruptedException2 = localInterruptedException2;
                  if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "thread sleep exception " + localInterruptedException2.getMessage());
                  }
                }
              }
              catch (InterruptedException localInterruptedException1)
              {
                if (QLog.isColorLevel()) {
                  QLog.d(TAG, 2, "thread sleep exception " + localInterruptedException1.getMessage());
                }
              }
            }
          }
          Object localObject2 = null;
        }
      }
    }
  }
  
  /* Error */
  public static Bitmap e(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 209	aqml:ce	(Landroid/content/Context;)Z
    //   4: ifne +7 -> 11
    //   7: aconst_null
    //   8: astore_1
    //   9: aload_1
    //   10: areturn
    //   11: getstatic 212	aqml:aQb	Ljava/lang/String;
    //   14: astore_2
    //   15: aload_0
    //   16: invokevirtual 218	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   19: astore_0
    //   20: aload_0
    //   21: aload_2
    //   22: invokestatic 224	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   25: aconst_null
    //   26: ldc_w 531
    //   29: iconst_1
    //   30: anewarray 69	java/lang/String
    //   33: dup
    //   34: iconst_0
    //   35: aload_1
    //   36: aastore
    //   37: aconst_null
    //   38: invokestatic 247	alld:query	(Landroid/content/ContentResolver;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   41: astore_0
    //   42: aload_0
    //   43: ifnull +61 -> 104
    //   46: aconst_null
    //   47: astore_2
    //   48: aload_0
    //   49: astore_1
    //   50: aload_0
    //   51: invokeinterface 255 1 0
    //   56: ifeq +34 -> 90
    //   59: aload_0
    //   60: astore_1
    //   61: aload_0
    //   62: aload_0
    //   63: ldc_w 533
    //   66: invokeinterface 259 2 0
    //   71: invokeinterface 537 2 0
    //   76: astore_2
    //   77: aload_0
    //   78: astore_1
    //   79: aload_2
    //   80: iconst_0
    //   81: aload_2
    //   82: arraylength
    //   83: invokestatic 541	aqcu:decodeByteArray	([BII)Landroid/graphics/Bitmap;
    //   86: astore_2
    //   87: goto -39 -> 48
    //   90: aload_2
    //   91: astore_1
    //   92: aload_0
    //   93: ifnull -84 -> 9
    //   96: aload_0
    //   97: invokeinterface 285 1 0
    //   102: aload_2
    //   103: areturn
    //   104: aload_0
    //   105: ifnull +9 -> 114
    //   108: aload_0
    //   109: invokeinterface 285 1 0
    //   114: aconst_null
    //   115: areturn
    //   116: astore_2
    //   117: aconst_null
    //   118: astore_0
    //   119: aload_0
    //   120: astore_1
    //   121: invokestatic 275	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   124: ifeq +35 -> 159
    //   127: aload_0
    //   128: astore_1
    //   129: getstatic 12	aqlr:TAG	Ljava/lang/String;
    //   132: iconst_2
    //   133: new 226	java/lang/StringBuilder
    //   136: dup
    //   137: invokespecial 228	java/lang/StringBuilder:<init>	()V
    //   140: ldc_w 277
    //   143: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: aload_2
    //   147: invokevirtual 278	java/lang/Exception:toString	()Ljava/lang/String;
    //   150: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: invokevirtual 237	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   156: invokestatic 282	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   159: aload_0
    //   160: ifnull -46 -> 114
    //   163: aload_0
    //   164: invokeinterface 285 1 0
    //   169: goto -55 -> 114
    //   172: astore_0
    //   173: aconst_null
    //   174: astore_1
    //   175: aload_1
    //   176: ifnull +9 -> 185
    //   179: aload_1
    //   180: invokeinterface 285 1 0
    //   185: aload_0
    //   186: athrow
    //   187: astore_0
    //   188: goto -13 -> 175
    //   191: astore_2
    //   192: goto -73 -> 119
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	195	0	paramContext	Context
    //   0	195	1	paramString	String
    //   14	89	2	localObject	Object
    //   116	31	2	localException1	java.lang.Exception
    //   191	1	2	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   20	42	116	java/lang/Exception
    //   20	42	172	finally
    //   50	59	187	finally
    //   61	77	187	finally
    //   79	87	187	finally
    //   121	127	187	finally
    //   129	159	187	finally
    //   50	59	191	java/lang/Exception
    //   61	77	191	java/lang/Exception
    //   79	87	191	java/lang/Exception
  }
  
  public static void g(QQAppInterface paramQQAppInterface, Intent paramIntent)
  {
    Intent localIntent = new Intent();
    aqoo.a().setShortcutIntentFlag(paramIntent);
    localIntent.putExtra("android.intent.extra.shortcut.INTENT", paramIntent);
    localIntent.putExtra("android.intent.extra.shortcut.NAME", "QQ");
    localIntent.putExtra("duplicate", false);
    localIntent.setAction("com.android.launcher.action.UNINSTALL_SHORTCUT");
    paramQQAppInterface.getApp().sendOrderedBroadcast(localIntent, null);
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "deleteShortcut.finish.");
    }
  }
  
  public static String getAuthorityFromPermission(Context paramContext, String paramString)
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
  
  public static String getUin()
  {
    AppRuntime localAppRuntime = null;
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    if (localBaseApplicationImpl != null) {
      localAppRuntime = localBaseApplicationImpl.getRuntime();
    }
    if (localAppRuntime == null) {
      return "0";
    }
    if (localAppRuntime.getAccount() == null) {
      return "0";
    }
    return localAppRuntime.getAccount();
  }
  
  public static boolean hasShortCut(Context paramContext, String[] paramArrayOfString)
  {
    return aqml.hasShortCut(paramContext, paramArrayOfString);
  }
  
  public static final boolean isScreenLocked(Context paramContext)
  {
    return ((KeyguardManager)paramContext.getSystemService("keyguard")).inKeyguardRestrictedInputMode();
  }
  
  public static String pG(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder(256);
    localStringBuilder.append(acbn.bmJ);
    String str = MD5.toMD5(paramString);
    str = MD5.toMD5(str + paramString);
    localStringBuilder.append(MD5.toMD5(str + paramString));
    localStringBuilder.append(".png");
    return localStringBuilder.toString();
  }
  
  public static void s(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt)
  {
    Object localObject = new HashMap();
    ((Map)localObject).put("uin", paramString1);
    ((Map)localObject).put("nickname", paramString2);
    ((Map)localObject).put("uinType", Integer.valueOf(paramInt));
    Intent localIntent = a(paramQQAppInterface, "uin", (Map)localObject);
    localObject = paramQQAppInterface.getFaceBitmap(1, paramString1, (byte)1, true, 0);
    paramString1 = (String)localObject;
    if (localObject == null) {
      paramString1 = aqhu.G();
    }
    a(paramQQAppInterface, localIntent, paramString2, paramString1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqlr
 * JD-Core Version:    0.7.0.1
 */