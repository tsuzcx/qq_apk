import NS_UNDEAL_COUNT.entrance_cfg;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.SQLException;
import android.net.Uri;
import android.text.TextUtils;
import com.qq.jce.wup.UniAttribute;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.provider.QZoneConfigProvider;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import mqq.app.AppRuntime;

public class sxc
{
  private static final Set<String> aU = new HashSet();
  
  static
  {
    aU.add("miniappshowreddot".toLowerCase());
    aU.add("miniappshowmessagereddot".toLowerCase());
    aU.add("miniappfullscreenshownotificationbtn".toLowerCase());
    aU.add("miniappfullscreenshownotificationreddot".toLowerCase());
    aU.add("miniapptriggerfullscreenheight".toLowerCase());
    aU.add("miniappgetpskeydomain".toLowerCase());
    aU.add("miniappsustempermissionconfig".toLowerCase());
    aU.add("MiniAppMsfTimeoutValue".toLowerCase());
    aU.add("miniappsendrequestbyhttps".toLowerCase());
    aU.add("newsdkenable".toLowerCase());
    aU.add("MiniAppEcShopNumMsgEnable".toLowerCase());
    aU.add("newappsdkenable".toLowerCase());
    aU.add("mini_sdk_prelaunch_enable".toLowerCase());
  }
  
  public static void KU()
  {
    try
    {
      BaseApplication.getContext().getContentResolver().delete(QZoneConfigProvider.q, null, null);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("QZConfigProviderUtil", 2, "database clear error" + localException.getMessage(), localException);
    }
  }
  
  /* Error */
  public static Map<String, String> O()
  {
    // Byte code:
    //   0: new 111	java/util/HashMap
    //   3: dup
    //   4: invokespecial 112	java/util/HashMap:<init>	()V
    //   7: astore_3
    //   8: invokestatic 64	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   11: invokevirtual 68	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   14: getstatic 115	com/tencent/common/config/provider/QZoneConfigProvider:r	Landroid/net/Uri;
    //   17: aconst_null
    //   18: aconst_null
    //   19: aconst_null
    //   20: aconst_null
    //   21: invokestatic 121	alld:query	(Landroid/content/ContentResolver;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   24: astore_2
    //   25: aload_2
    //   26: ifnull +88 -> 114
    //   29: aload_2
    //   30: astore_1
    //   31: aload_2
    //   32: invokeinterface 126 1 0
    //   37: ifeq +77 -> 114
    //   40: aload_2
    //   41: astore_1
    //   42: aload_3
    //   43: new 20	java/lang/String
    //   46: dup
    //   47: aload_2
    //   48: aload_2
    //   49: ldc 128
    //   51: invokeinterface 132 2 0
    //   56: invokeinterface 136 2 0
    //   61: invokevirtual 140	java/lang/String:getBytes	()[B
    //   64: ldc 142
    //   66: invokespecial 145	java/lang/String:<init>	([BLjava/lang/String;)V
    //   69: new 20	java/lang/String
    //   72: dup
    //   73: aload_2
    //   74: aload_2
    //   75: ldc 147
    //   77: invokeinterface 132 2 0
    //   82: invokeinterface 136 2 0
    //   87: invokevirtual 140	java/lang/String:getBytes	()[B
    //   90: ldc 142
    //   92: invokespecial 145	java/lang/String:<init>	([BLjava/lang/String;)V
    //   95: invokeinterface 153 3 0
    //   100: pop
    //   101: aload_2
    //   102: astore_1
    //   103: aload_2
    //   104: invokeinterface 156 1 0
    //   109: istore_0
    //   110: iload_0
    //   111: ifne -71 -> 40
    //   114: aload_2
    //   115: ifnull +9 -> 124
    //   118: aload_2
    //   119: invokeinterface 159 1 0
    //   124: aload_3
    //   125: areturn
    //   126: astore_3
    //   127: aconst_null
    //   128: astore_2
    //   129: aload_2
    //   130: astore_1
    //   131: invokestatic 86	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   134: ifeq +34 -> 168
    //   137: aload_2
    //   138: astore_1
    //   139: ldc 88
    //   141: iconst_2
    //   142: new 90	java/lang/StringBuilder
    //   145: dup
    //   146: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   149: ldc 161
    //   151: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: aload_3
    //   155: invokevirtual 100	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   158: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   164: aload_3
    //   165: invokestatic 107	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   168: aload_2
    //   169: ifnull +9 -> 178
    //   172: aload_2
    //   173: invokeinterface 159 1 0
    //   178: aconst_null
    //   179: areturn
    //   180: astore_2
    //   181: aconst_null
    //   182: astore_1
    //   183: aload_1
    //   184: ifnull +9 -> 193
    //   187: aload_1
    //   188: invokeinterface 159 1 0
    //   193: aload_2
    //   194: athrow
    //   195: astore_2
    //   196: goto -13 -> 183
    //   199: astore_3
    //   200: goto -71 -> 129
    // Local variable table:
    //   start	length	slot	name	signature
    //   109	2	0	bool	boolean
    //   30	158	1	localCursor1	android.database.Cursor
    //   24	149	2	localCursor2	android.database.Cursor
    //   180	14	2	localObject1	Object
    //   195	1	2	localObject2	Object
    //   7	118	3	localHashMap	java.util.HashMap
    //   126	39	3	localException1	Exception
    //   199	1	3	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   8	25	126	java/lang/Exception
    //   8	25	180	finally
    //   31	40	195	finally
    //   42	101	195	finally
    //   103	110	195	finally
    //   131	137	195	finally
    //   139	168	195	finally
    //   31	40	199	java/lang/Exception
    //   42	101	199	java/lang/Exception
    //   103	110	199	java/lang/Exception
  }
  
  public static void Q(Map<String, String> paramMap)
  {
    if (paramMap == null) {}
    for (;;)
    {
      return;
      if (!paramMap.isEmpty())
      {
        Iterator localIterator = paramMap.keySet().iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          U(str, (String)paramMap.get(str));
        }
      }
    }
  }
  
  private static boolean U(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (TextUtils.getTrimmedLength(paramString1) <= 0)) {}
    while ((paramString2 == null) || (TextUtils.getTrimmedLength(paramString2) <= 0)) {
      return false;
    }
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("key", paramString1);
    localContentValues.put("value", paramString2);
    try
    {
      BaseApplication.getContext().getContentResolver().insert(QZoneConfigProvider.r, localContentValues);
      return true;
    }
    catch (SQLException paramString1)
    {
      if (QLog.isColorLevel()) {
        QLog.e("QZConfigProviderUtil", 2, "insertUpdateIspConfigItem error:" + paramString1.getMessage(), paramString1);
      }
      return false;
    }
    catch (Exception paramString1)
    {
      if (QLog.isColorLevel()) {
        QLog.e("QZConfigProviderUtil", 2, "insertUpdateIspConfigItem error:" + paramString1.getMessage(), paramString1);
      }
      return false;
    }
    finally
    {
      localContentValues.clear();
    }
  }
  
  private static void V(String paramString1, String paramString2, String paramString3)
  {
    if (("qqminiapp".equals(paramString1)) && ("miniappshowfullscreen".equals(paramString2))) {}
    String str;
    do
    {
      int i;
      try
      {
        i = Integer.valueOf(paramString3).intValue();
        paramString1 = BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4);
        str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
        paramString1.edit().putInt(str + "_" + "miniappshowfullscreen", i).apply();
        QZLog.d("QZConfigProviderUtil", 1, "[saveConfig miniapp], full screen config, key: " + paramString2 + ", value: " + paramString3 + ", uin = " + str);
        return;
      }
      catch (Exception paramString1)
      {
        QZLog.e("QZConfigProviderUtil", 1, new Object[] { "[saveConfig miniapp], full screen config exception. key: " + paramString2 + ", value: " + paramString3 });
        return;
      }
      if (("qqminiapp".equals(paramString1)) && ("miniappfullscreenshowsetting".equals(paramString2))) {
        try
        {
          i = Integer.valueOf(paramString3).intValue();
          paramString1 = BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4);
          str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
          paramString1.edit().putInt(str + "_" + "miniappfullscreenshowsetting", i).apply();
          QZLog.d("QZConfigProviderUtil", 1, "[saveConfig miniapp], setting config, key: " + paramString2 + ", value: " + paramString3 + ", uin = " + str);
          return;
        }
        catch (Exception paramString1)
        {
          QZLog.e("QZConfigProviderUtil", 1, new Object[] { "[saveConfig miniapp], setting config exception. key: " + paramString2 + ", value: " + paramString3 });
          return;
        }
      }
      if (("qqminiapp".equals(paramString1)) && ("miniappfullscreenshowclose".equals(paramString2))) {
        try
        {
          i = Integer.valueOf(paramString3).intValue();
          paramString1 = BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4);
          str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
          paramString1.edit().putInt(str + "_" + "miniappfullscreenshowclose", i).apply();
          QZLog.d("QZConfigProviderUtil", 1, "[saveConfig miniapp], close config, key: " + paramString2 + ", value: " + paramString3 + ", uin = " + str);
          return;
        }
        catch (Exception paramString1)
        {
          QZLog.e("QZConfigProviderUtil", 1, new Object[] { "[saveConfig miniapp], close config exception. key: " + paramString2 + ", value: " + paramString3 });
          return;
        }
      }
      if (("qqminiapp".equals(paramString1)) && ("miniappfullscreenshowsearch".equals(paramString2))) {
        try
        {
          i = Integer.valueOf(paramString3).intValue();
          paramString1 = BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4);
          str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
          paramString1.edit().putInt(str + "_" + "miniappfullscreenshowsearch", i).apply();
          QZLog.d("QZConfigProviderUtil", 1, "[saveConfig miniapp], search config, key: " + paramString2 + ", value: " + paramString3 + ", uin = " + str);
          return;
        }
        catch (Exception paramString1)
        {
          QZLog.e("QZConfigProviderUtil", 1, new Object[] { "[saveConfig miniapp], search config exception. key: " + paramString2 + ", value: " + paramString3 });
          return;
        }
      }
      if (("qqminiapp".equals(paramString1)) && ("miniappfullscreentitle".equals(paramString2))) {
        try
        {
          paramString1 = BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4);
          str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
          paramString1.edit().putString(str + "_" + "miniappfullscreentitle", paramString3).apply();
          QZLog.d("QZConfigProviderUtil", 1, "saveConfig miniapp, search config, key: " + paramString2 + ", value: " + paramString3 + ", uin = " + str);
          return;
        }
        catch (Exception paramString1)
        {
          QZLog.e("QZConfigProviderUtil", 1, new Object[] { "saveConfig miniapp, search config exception. key: " + paramString2 + ", value: " + paramString3 });
          return;
        }
      }
    } while ((!"qqminiapp".equals(paramString1)) || (!aU.contains(paramString2)));
    try
    {
      paramString1 = BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4);
      str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
      paramString1.edit().putString(str + "_" + paramString2, paramString3).apply();
      QZLog.d("QZConfigProviderUtil", 1, "saveConfig miniapp high priority config, key: " + paramString2 + ", value: " + paramString3 + ", uin = " + str);
      return;
    }
    catch (Exception paramString1)
    {
      QZLog.e("QZConfigProviderUtil", 1, new Object[] { "saveConfig miniapp high priority config exception. key: " + paramString2 + ", value: " + paramString3 });
    }
  }
  
  public static ContentValues a(String paramString, entrance_cfg paramentrance_cfg)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      do
      {
        return null;
      } while ((paramentrance_cfg == null) || (paramentrance_cfg.iEntranceId < 0) || (paramentrance_cfg.iEntranceId > 999));
      paramString = paramString.replace(" ", "");
      QZLog.e("QZConfigProviderUtil", 2, new Object[] { "********* insertNavigatorConfigItem ******** rsp return navigator item id:", Integer.valueOf(paramentrance_cfg.iEntranceId), " item name: ", paramentrance_cfg.sEntranceName, " item icon: ", paramentrance_cfg.sEntranceIcon, " item action: ", paramentrance_cfg.sEntranceAction, " item qbossicon: ", paramentrance_cfg.sQbossEntranceIcon });
    } while ((TextUtils.isEmpty(paramString)) || (TextUtils.isEmpty(paramentrance_cfg.sEntranceName)));
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("uin", paramString + "&" + paramentrance_cfg.iEntranceId);
    localContentValues.put("entraceid", Integer.valueOf(paramentrance_cfg.iEntranceId));
    localContentValues.put("entracename", paramentrance_cfg.sEntranceName);
    localContentValues.put("entraceicon", paramentrance_cfg.sEntranceIcon);
    localContentValues.put("entraceaction", paramentrance_cfg.sEntranceAction);
    localContentValues.put("isDefault", Integer.valueOf(paramentrance_cfg.isDefualt));
    localContentValues.put("tabid", Integer.valueOf(paramentrance_cfg.tabid));
    localContentValues.put("qbossentraceicon", paramentrance_cfg.sQbossEntranceIcon);
    localContentValues.put("qbosstraceinfo", paramentrance_cfg.sQbossTraceInfo);
    return localContentValues;
  }
  
  public static void a(Map<String, byte[]> paramMap, String paramString1, String paramString2, AppRuntime paramAppRuntime)
  {
    boolean bool = a(paramMap, paramString2);
    if ((gq("PhotoUpload")) && (gq("PhotoSvrList"))) {
      if (bool) {
        tY(paramString1);
      }
    }
    for (;;)
    {
      gr(paramString2);
      if (paramAppRuntime != null) {}
      try
      {
        if (((paramAppRuntime instanceof QQAppInterface)) && (paramAppRuntime.getLongAccountUin() != 0L))
        {
          paramMap = QzoneConfig.getInstance().getConfig("QZoneSetting", "Qzone_clearCacheVersion", "");
          if ((!TextUtils.isEmpty(paramMap)) && (!LocalMultiProcConfig.getString4Uin("Qzone_clearCacheVersion", "", paramAppRuntime.getLongAccountUin()).equals(paramMap)))
          {
            avpw.e(paramAppRuntime, true);
            LocalMultiProcConfig.putString4Uin("Qzone_clearCacheVersion", paramMap, paramAppRuntime.getLongAccountUin());
          }
        }
        return;
      }
      catch (Exception paramMap)
      {
        QLog.e("QZConfigProviderUtil", 1, paramMap.getMessage());
      }
      tY("");
    }
  }
  
  /* Error */
  public static boolean a(String paramString, ArrayList<entrance_cfg> paramArrayList)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +10 -> 11
    //   4: aload_0
    //   5: invokestatic 202	android/text/TextUtils:getTrimmedLength	(Ljava/lang/CharSequence;)I
    //   8: ifgt +5 -> 13
    //   11: iconst_0
    //   12: ireturn
    //   13: aload_1
    //   14: ifnull -3 -> 11
    //   17: aload_1
    //   18: invokevirtual 467	java/util/ArrayList:clear	()V
    //   21: aload_0
    //   22: ldc_w 340
    //   25: ldc_w 342
    //   28: invokevirtual 346	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   31: astore_0
    //   32: new 90	java/lang/StringBuilder
    //   35: dup
    //   36: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   39: ldc_w 469
    //   42: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: aload_0
    //   46: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: ldc_w 471
    //   52: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   58: astore_0
    //   59: invokestatic 64	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   62: invokevirtual 68	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   65: getstatic 474	com/tencent/common/config/provider/QZoneConfigProvider:t	Landroid/net/Uri;
    //   68: aconst_null
    //   69: aload_0
    //   70: aconst_null
    //   71: aconst_null
    //   72: invokestatic 121	alld:query	(Landroid/content/ContentResolver;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   75: astore_0
    //   76: aload_0
    //   77: ifnull +217 -> 294
    //   80: aload_0
    //   81: invokeinterface 126 1 0
    //   86: ifeq +208 -> 294
    //   89: aload_1
    //   90: new 334	NS_UNDEAL_COUNT/entrance_cfg
    //   93: dup
    //   94: aload_0
    //   95: aload_0
    //   96: ldc_w 381
    //   99: invokeinterface 132 2 0
    //   104: invokeinterface 478 2 0
    //   109: new 20	java/lang/String
    //   112: dup
    //   113: aload_0
    //   114: aload_0
    //   115: ldc_w 386
    //   118: invokeinterface 132 2 0
    //   123: invokeinterface 136 2 0
    //   128: invokevirtual 140	java/lang/String:getBytes	()[B
    //   131: ldc 142
    //   133: invokespecial 145	java/lang/String:<init>	([BLjava/lang/String;)V
    //   136: new 20	java/lang/String
    //   139: dup
    //   140: aload_0
    //   141: aload_0
    //   142: ldc_w 388
    //   145: invokeinterface 132 2 0
    //   150: invokeinterface 136 2 0
    //   155: invokevirtual 140	java/lang/String:getBytes	()[B
    //   158: ldc 142
    //   160: invokespecial 145	java/lang/String:<init>	([BLjava/lang/String;)V
    //   163: new 20	java/lang/String
    //   166: dup
    //   167: aload_0
    //   168: aload_0
    //   169: ldc_w 390
    //   172: invokeinterface 132 2 0
    //   177: invokeinterface 136 2 0
    //   182: invokevirtual 140	java/lang/String:getBytes	()[B
    //   185: ldc 142
    //   187: invokespecial 145	java/lang/String:<init>	([BLjava/lang/String;)V
    //   190: aload_0
    //   191: aload_0
    //   192: ldc_w 392
    //   195: invokeinterface 132 2 0
    //   200: invokeinterface 478 2 0
    //   205: aload_0
    //   206: aload_0
    //   207: ldc_w 397
    //   210: invokeinterface 132 2 0
    //   215: invokeinterface 478 2 0
    //   220: new 20	java/lang/String
    //   223: dup
    //   224: aload_0
    //   225: aload_0
    //   226: ldc_w 401
    //   229: invokeinterface 132 2 0
    //   234: invokeinterface 136 2 0
    //   239: invokevirtual 140	java/lang/String:getBytes	()[B
    //   242: ldc 142
    //   244: invokespecial 145	java/lang/String:<init>	([BLjava/lang/String;)V
    //   247: new 20	java/lang/String
    //   250: dup
    //   251: aload_0
    //   252: aload_0
    //   253: ldc_w 403
    //   256: invokeinterface 132 2 0
    //   261: invokeinterface 136 2 0
    //   266: invokevirtual 140	java/lang/String:getBytes	()[B
    //   269: ldc 142
    //   271: invokespecial 145	java/lang/String:<init>	([BLjava/lang/String;)V
    //   274: iconst_0
    //   275: aconst_null
    //   276: invokespecial 481	NS_UNDEAL_COUNT/entrance_cfg:<init>	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;ILNS_UNDEAL_COUNT/st_report_info;)V
    //   279: invokevirtual 482	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   282: pop
    //   283: aload_0
    //   284: invokeinterface 156 1 0
    //   289: istore_2
    //   290: iload_2
    //   291: ifne -202 -> 89
    //   294: aload_0
    //   295: ifnull -284 -> 11
    //   298: aload_0
    //   299: invokeinterface 159 1 0
    //   304: iconst_0
    //   305: ireturn
    //   306: astore_1
    //   307: aconst_null
    //   308: astore_0
    //   309: invokestatic 86	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   312: ifeq +33 -> 345
    //   315: ldc 88
    //   317: iconst_2
    //   318: new 90	java/lang/StringBuilder
    //   321: dup
    //   322: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   325: ldc_w 484
    //   328: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   331: aload_1
    //   332: invokevirtual 100	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   335: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   338: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   341: aload_1
    //   342: invokestatic 107	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   345: aload_0
    //   346: ifnull -335 -> 11
    //   349: aload_0
    //   350: invokeinterface 159 1 0
    //   355: iconst_0
    //   356: ireturn
    //   357: astore_1
    //   358: aconst_null
    //   359: astore_0
    //   360: aload_0
    //   361: ifnull +9 -> 370
    //   364: aload_0
    //   365: invokeinterface 159 1 0
    //   370: aload_1
    //   371: athrow
    //   372: astore_1
    //   373: goto -13 -> 360
    //   376: astore_1
    //   377: goto -17 -> 360
    //   380: astore_1
    //   381: goto -72 -> 309
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	384	0	paramString	String
    //   0	384	1	paramArrayList	ArrayList<entrance_cfg>
    //   289	2	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   59	76	306	java/lang/Exception
    //   59	76	357	finally
    //   80	89	372	finally
    //   89	290	372	finally
    //   309	345	376	finally
    //   80	89	380	java/lang/Exception
    //   89	290	380	java/lang/Exception
  }
  
  private static boolean a(Map<String, byte[]> paramMap, String paramString)
  {
    if (paramMap == null) {}
    while (paramMap.isEmpty()) {
      return false;
    }
    paramString = paramMap.keySet();
    QZLog.i("QZConfigProviderUtil", 1, new Object[] { "saveConfig mainkey count:", Integer.valueOf(paramString.size()) });
    localArrayList = new ArrayList();
    Iterator localIterator1 = paramString.iterator();
    while (localIterator1.hasNext())
    {
      paramString = (String)localIterator1.next();
      Object localObject1 = (byte[])paramMap.get(paramString);
      if ((paramString != null) && (localObject1 != null) && (localObject1.length > 0))
      {
        QZLog.i("QZConfigProviderUtil", 1, new Object[] { "saveConfig mainKey:", paramString });
        QzoneConfig.getInstance().deleteConfigs(paramString);
        UniAttribute localUniAttribute = new UniAttribute();
        localUniAttribute.setEncodeName("utf-8");
        localUniAttribute.decode((byte[])localObject1);
        Iterator localIterator2 = localUniAttribute.getKeySet().iterator();
        while (localIterator2.hasNext())
        {
          Object localObject2 = (String)localIterator2.next();
          String str = (String)localUniAttribute.get((String)localObject2);
          localObject1 = paramString;
          if (localObject2 != null)
          {
            if (QLog.isColorLevel()) {
              QZLog.i("QZConfigProviderUtil", 2, new Object[] { " main key:", paramString, " second key:", localObject2, " value:", str });
            }
            localObject1 = paramString.toLowerCase();
            paramString = ((String)localObject2).toLowerCase();
            localObject2 = new ContentValues();
            ((ContentValues)localObject2).put("main_key", (String)localObject1);
            ((ContentValues)localObject2).put("second_key", paramString);
            ((ContentValues)localObject2).put("value", str);
            QzoneConfig.getInstance().updateOneConfig((String)localObject1, paramString, str);
            localArrayList.add(localObject2);
            V((String)localObject1, paramString, str);
          }
          paramString = (String)localObject1;
        }
        try
        {
          BaseApplication.getContext().getContentResolver().delete(QZoneConfigProvider.l, "main_key=?", new String[] { paramString });
          if (QLog.isColorLevel()) {
            QZLog.i("QZConfigProviderUtil", 4, new Object[] { "deleteConfig: ", paramString });
          }
        }
        catch (Exception paramString)
        {
          QZLog.e("QZConfigProviderUtil", 1, paramString, new Object[] { "deleteConfig error:" });
        }
      }
    }
    try
    {
      BaseApplication.getContext().getContentResolver().bulkInsert(QZoneConfigProvider.l, (ContentValues[])localArrayList.toArray(new ContentValues[localArrayList.size()]));
      localArrayList.clear();
      bool = true;
    }
    catch (SQLException paramMap)
    {
      for (;;)
      {
        QZLog.e("QZConfigProviderUtil", 1, paramMap, new Object[] { "saveConfig error:" });
        localArrayList.clear();
        bool = false;
      }
    }
    catch (Exception paramMap)
    {
      for (;;)
      {
        QZLog.e("QZConfigProviderUtil", 1, paramMap, new Object[] { "saveConfig error:" });
        localArrayList.clear();
        boolean bool = false;
      }
    }
    finally
    {
      localArrayList.clear();
    }
    return bool;
  }
  
  private static boolean a(ContentValues[] paramArrayOfContentValues)
  {
    boolean bool = false;
    try
    {
      BaseApplication.getContext().getContentResolver().bulkInsert(QZoneConfigProvider.t, paramArrayOfContentValues);
      bool = true;
    }
    catch (SQLException paramArrayOfContentValues)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("QZConfigProviderUtil", 2, "insertNavigatorConfigItem error:" + paramArrayOfContentValues.getMessage(), paramArrayOfContentValues);
      return false;
    }
    catch (Exception paramArrayOfContentValues)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("QZConfigProviderUtil", 2, "insertNavigatorConfigItem error:" + paramArrayOfContentValues.getMessage(), paramArrayOfContentValues);
    }
    return bool;
    return false;
  }
  
  /* Error */
  public static long aT()
  {
    // Byte code:
    //   0: invokestatic 64	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   3: invokevirtual 68	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   6: getstatic 565	com/tencent/common/config/provider/QZoneConfigProvider:s	Landroid/net/Uri;
    //   9: aconst_null
    //   10: aconst_null
    //   11: aconst_null
    //   12: aconst_null
    //   13: invokestatic 121	alld:query	(Landroid/content/ContentResolver;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   16: astore_2
    //   17: aload_2
    //   18: ifnull +40 -> 58
    //   21: aload_2
    //   22: invokeinterface 126 1 0
    //   27: ifeq +31 -> 58
    //   30: aload_2
    //   31: aload_2
    //   32: ldc_w 567
    //   35: invokeinterface 132 2 0
    //   40: invokeinterface 571 2 0
    //   45: lstore_0
    //   46: aload_2
    //   47: ifnull +9 -> 56
    //   50: aload_2
    //   51: invokeinterface 159 1 0
    //   56: lload_0
    //   57: lreturn
    //   58: aload_2
    //   59: ifnull +9 -> 68
    //   62: aload_2
    //   63: invokeinterface 159 1 0
    //   68: lconst_0
    //   69: lreturn
    //   70: astore_3
    //   71: aconst_null
    //   72: astore_2
    //   73: invokestatic 86	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   76: ifeq +33 -> 109
    //   79: ldc 88
    //   81: iconst_2
    //   82: new 90	java/lang/StringBuilder
    //   85: dup
    //   86: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   89: ldc_w 573
    //   92: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: aload_3
    //   96: invokevirtual 100	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   99: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   105: aload_3
    //   106: invokestatic 107	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   109: aload_2
    //   110: ifnull -42 -> 68
    //   113: aload_2
    //   114: invokeinterface 159 1 0
    //   119: goto -51 -> 68
    //   122: astore_3
    //   123: aconst_null
    //   124: astore_2
    //   125: aload_2
    //   126: ifnull +9 -> 135
    //   129: aload_2
    //   130: invokeinterface 159 1 0
    //   135: aload_3
    //   136: athrow
    //   137: astore_3
    //   138: goto -13 -> 125
    //   141: astore_3
    //   142: goto -17 -> 125
    //   145: astore_3
    //   146: goto -73 -> 73
    // Local variable table:
    //   start	length	slot	name	signature
    //   45	12	0	l	long
    //   16	114	2	localCursor	android.database.Cursor
    //   70	36	3	localException1	Exception
    //   122	14	3	localObject1	Object
    //   137	1	3	localObject2	Object
    //   141	1	3	localObject3	Object
    //   145	1	3	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   0	17	70	java/lang/Exception
    //   0	17	122	finally
    //   21	46	137	finally
    //   73	109	141	finally
    //   21	46	145	java/lang/Exception
  }
  
  /* Error */
  public static String ar(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +10 -> 11
    //   4: aload_0
    //   5: invokestatic 202	android/text/TextUtils:getTrimmedLength	(Ljava/lang/CharSequence;)I
    //   8: ifgt +5 -> 13
    //   11: aconst_null
    //   12: areturn
    //   13: aload_1
    //   14: ifnull -3 -> 11
    //   17: aload_1
    //   18: invokestatic 202	android/text/TextUtils:getTrimmedLength	(Ljava/lang/CharSequence;)I
    //   21: ifle -10 -> 11
    //   24: invokestatic 64	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   27: invokevirtual 68	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   30: getstatic 535	com/tencent/common/config/provider/QZoneConfigProvider:l	Landroid/net/Uri;
    //   33: aconst_null
    //   34: ldc_w 577
    //   37: iconst_2
    //   38: anewarray 20	java/lang/String
    //   41: dup
    //   42: iconst_0
    //   43: aload_0
    //   44: aastore
    //   45: dup
    //   46: iconst_1
    //   47: aload_1
    //   48: aastore
    //   49: aconst_null
    //   50: invokestatic 121	alld:query	(Landroid/content/ContentResolver;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   53: astore_1
    //   54: aload_1
    //   55: ifnull +148 -> 203
    //   58: aload_1
    //   59: astore_0
    //   60: aload_1
    //   61: invokeinterface 126 1 0
    //   66: ifeq +137 -> 203
    //   69: aload_1
    //   70: astore_0
    //   71: aload_1
    //   72: aload_1
    //   73: ldc 147
    //   75: invokeinterface 132 2 0
    //   80: invokeinterface 136 2 0
    //   85: astore_2
    //   86: aload_2
    //   87: astore_0
    //   88: aload_1
    //   89: ifnull +11 -> 100
    //   92: aload_1
    //   93: invokeinterface 159 1 0
    //   98: aload_2
    //   99: astore_0
    //   100: aload_0
    //   101: areturn
    //   102: astore_0
    //   103: aload_0
    //   104: invokevirtual 580	java/lang/Exception:printStackTrace	()V
    //   107: aload_2
    //   108: astore_0
    //   109: goto -9 -> 100
    //   112: astore_2
    //   113: aconst_null
    //   114: astore_1
    //   115: aload_1
    //   116: astore_0
    //   117: invokestatic 86	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   120: ifeq +22 -> 142
    //   123: aload_1
    //   124: astore_0
    //   125: ldc 88
    //   127: iconst_2
    //   128: aload_2
    //   129: iconst_1
    //   130: anewarray 4	java/lang/Object
    //   133: dup
    //   134: iconst_0
    //   135: ldc_w 582
    //   138: aastore
    //   139: invokestatic 583	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   142: aload_1
    //   143: ifnull +55 -> 198
    //   146: aload_1
    //   147: invokeinterface 159 1 0
    //   152: aconst_null
    //   153: astore_0
    //   154: goto -54 -> 100
    //   157: astore_0
    //   158: aload_0
    //   159: invokevirtual 580	java/lang/Exception:printStackTrace	()V
    //   162: aconst_null
    //   163: astore_0
    //   164: goto -64 -> 100
    //   167: astore_1
    //   168: aconst_null
    //   169: astore_0
    //   170: aload_0
    //   171: ifnull +9 -> 180
    //   174: aload_0
    //   175: invokeinterface 159 1 0
    //   180: aload_1
    //   181: athrow
    //   182: astore_0
    //   183: aload_0
    //   184: invokevirtual 580	java/lang/Exception:printStackTrace	()V
    //   187: goto -7 -> 180
    //   190: astore_1
    //   191: goto -21 -> 170
    //   194: astore_2
    //   195: goto -80 -> 115
    //   198: aconst_null
    //   199: astore_0
    //   200: goto -100 -> 100
    //   203: aconst_null
    //   204: astore_2
    //   205: goto -119 -> 86
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	208	0	paramString1	String
    //   0	208	1	paramString2	String
    //   85	23	2	str	String
    //   112	17	2	localException1	Exception
    //   194	1	2	localException2	Exception
    //   204	1	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   92	98	102	java/lang/Exception
    //   24	54	112	java/lang/Exception
    //   146	152	157	java/lang/Exception
    //   24	54	167	finally
    //   174	180	182	java/lang/Exception
    //   60	69	190	finally
    //   71	86	190	finally
    //   117	123	190	finally
    //   125	142	190	finally
    //   60	69	194	java/lang/Exception
    //   71	86	194	java/lang/Exception
  }
  
  /* Error */
  public static boolean e(Map<String, java.util.concurrent.ConcurrentHashMap<String, String>> paramMap)
    throws Exception
  {
    // Byte code:
    //   0: aload_0
    //   1: invokeinterface 585 1 0
    //   6: invokestatic 64	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   9: invokevirtual 68	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   12: getstatic 535	com/tencent/common/config/provider/QZoneConfigProvider:l	Landroid/net/Uri;
    //   15: aconst_null
    //   16: aconst_null
    //   17: aconst_null
    //   18: aconst_null
    //   19: invokestatic 121	alld:query	(Landroid/content/ContentResolver;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   22: astore 4
    //   24: aload 4
    //   26: ifnull +310 -> 336
    //   29: aload 4
    //   31: astore_3
    //   32: aload 4
    //   34: invokeinterface 156 1 0
    //   39: ifeq +170 -> 209
    //   42: aload 4
    //   44: astore_3
    //   45: aload 4
    //   47: iconst_0
    //   48: invokeinterface 136 2 0
    //   53: astore 7
    //   55: aload 4
    //   57: astore_3
    //   58: aload 4
    //   60: iconst_1
    //   61: invokeinterface 136 2 0
    //   66: astore 8
    //   68: aload 7
    //   70: ifnull -41 -> 29
    //   73: aload 8
    //   75: ifnull -46 -> 29
    //   78: aload 4
    //   80: astore_3
    //   81: aload 4
    //   83: iconst_2
    //   84: invokeinterface 136 2 0
    //   89: astore 9
    //   91: aload 4
    //   93: astore_3
    //   94: aload_0
    //   95: aload 7
    //   97: invokeinterface 189 2 0
    //   102: checkcast 587	java/util/concurrent/ConcurrentHashMap
    //   105: astore 6
    //   107: aload 6
    //   109: astore 5
    //   111: aload 6
    //   113: ifnonnull +29 -> 142
    //   116: aload 4
    //   118: astore_3
    //   119: new 587	java/util/concurrent/ConcurrentHashMap
    //   122: dup
    //   123: invokespecial 588	java/util/concurrent/ConcurrentHashMap:<init>	()V
    //   126: astore 5
    //   128: aload 4
    //   130: astore_3
    //   131: aload_0
    //   132: aload 7
    //   134: aload 5
    //   136: invokeinterface 153 3 0
    //   141: pop
    //   142: aload 5
    //   144: ifnull -115 -> 29
    //   147: aload 4
    //   149: astore_3
    //   150: aload 5
    //   152: aload 8
    //   154: aload 9
    //   156: invokevirtual 589	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   159: pop
    //   160: goto -131 -> 29
    //   163: astore_0
    //   164: aload 4
    //   166: astore_3
    //   167: invokestatic 86	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   170: ifeq +23 -> 193
    //   173: aload 4
    //   175: astore_3
    //   176: ldc 88
    //   178: iconst_2
    //   179: aload_0
    //   180: iconst_1
    //   181: anewarray 4	java/lang/Object
    //   184: dup
    //   185: iconst_0
    //   186: ldc_w 591
    //   189: aastore
    //   190: invokestatic 583	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   193: aload 4
    //   195: ifnull +139 -> 334
    //   198: aload 4
    //   200: invokeinterface 159 1 0
    //   205: iconst_0
    //   206: istore_2
    //   207: iload_2
    //   208: ireturn
    //   209: iconst_1
    //   210: istore_1
    //   211: iload_1
    //   212: istore_2
    //   213: aload 4
    //   215: ifnull -8 -> 207
    //   218: aload 4
    //   220: invokeinterface 159 1 0
    //   225: iload_1
    //   226: ireturn
    //   227: astore_0
    //   228: iload_1
    //   229: istore_2
    //   230: invokestatic 86	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   233: ifeq -26 -> 207
    //   236: ldc 88
    //   238: iconst_2
    //   239: aload_0
    //   240: iconst_1
    //   241: anewarray 4	java/lang/Object
    //   244: dup
    //   245: iconst_0
    //   246: ldc_w 591
    //   249: aastore
    //   250: invokestatic 583	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   253: iload_1
    //   254: ireturn
    //   255: astore_0
    //   256: invokestatic 86	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   259: ifeq +20 -> 279
    //   262: ldc 88
    //   264: iconst_2
    //   265: aload_0
    //   266: iconst_1
    //   267: anewarray 4	java/lang/Object
    //   270: dup
    //   271: iconst_0
    //   272: ldc_w 591
    //   275: aastore
    //   276: invokestatic 583	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   279: iconst_0
    //   280: ireturn
    //   281: astore_0
    //   282: aconst_null
    //   283: astore_3
    //   284: aload_3
    //   285: ifnull +9 -> 294
    //   288: aload_3
    //   289: invokeinterface 159 1 0
    //   294: aload_0
    //   295: athrow
    //   296: astore_3
    //   297: invokestatic 86	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   300: ifeq -6 -> 294
    //   303: ldc 88
    //   305: iconst_2
    //   306: aload_3
    //   307: iconst_1
    //   308: anewarray 4	java/lang/Object
    //   311: dup
    //   312: iconst_0
    //   313: ldc_w 591
    //   316: aastore
    //   317: invokestatic 583	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   320: goto -26 -> 294
    //   323: astore_0
    //   324: goto -40 -> 284
    //   327: astore_0
    //   328: aconst_null
    //   329: astore 4
    //   331: goto -167 -> 164
    //   334: iconst_0
    //   335: ireturn
    //   336: iconst_0
    //   337: istore_1
    //   338: goto -127 -> 211
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	341	0	paramMap	Map<String, java.util.concurrent.ConcurrentHashMap<String, String>>
    //   210	128	1	bool1	boolean
    //   206	24	2	bool2	boolean
    //   31	258	3	localCursor1	android.database.Cursor
    //   296	11	3	localException	Exception
    //   22	308	4	localCursor2	android.database.Cursor
    //   109	42	5	localConcurrentHashMap1	java.util.concurrent.ConcurrentHashMap
    //   105	7	6	localConcurrentHashMap2	java.util.concurrent.ConcurrentHashMap
    //   53	80	7	str1	String
    //   66	87	8	str2	String
    //   89	66	9	str3	String
    // Exception table:
    //   from	to	target	type
    //   32	42	163	java/lang/Exception
    //   45	55	163	java/lang/Exception
    //   58	68	163	java/lang/Exception
    //   81	91	163	java/lang/Exception
    //   94	107	163	java/lang/Exception
    //   119	128	163	java/lang/Exception
    //   131	142	163	java/lang/Exception
    //   150	160	163	java/lang/Exception
    //   218	225	227	java/lang/Exception
    //   198	205	255	java/lang/Exception
    //   0	24	281	finally
    //   288	294	296	java/lang/Exception
    //   32	42	323	finally
    //   45	55	323	finally
    //   58	68	323	finally
    //   81	91	323	finally
    //   94	107	323	finally
    //   119	128	323	finally
    //   131	142	323	finally
    //   150	160	323	finally
    //   167	173	323	finally
    //   176	193	323	finally
    //   0	24	327	java/lang/Exception
  }
  
  public static void fy(long paramLong)
  {
    if (paramLong <= 0L) {
      return;
    }
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("check_time", Long.valueOf(paramLong));
    if (QLog.isColorLevel()) {
      QLog.d("QZConfigProviderUtil", 2, "saveIspCheckTime time:" + paramLong);
    }
    try
    {
      BaseApplication.getContext().getContentResolver().insert(QZoneConfigProvider.s, localContentValues);
      localContentValues.clear();
      return;
    }
    catch (SQLException localSQLException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("QZConfigProviderUtil", 2, "saveIspCheckTime error :" + localSQLException.getMessage(), localSQLException);
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("QZConfigProviderUtil", 2, "saveIspCheckTime error :" + localException.getMessage(), localException);
        }
      }
    }
  }
  
  /* Error */
  private static boolean gq(String paramString)
  {
    // Byte code:
    //   0: invokestatic 64	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   3: invokevirtual 68	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   6: getstatic 535	com/tencent/common/config/provider/QZoneConfigProvider:l	Landroid/net/Uri;
    //   9: iconst_1
    //   10: anewarray 20	java/lang/String
    //   13: dup
    //   14: iconst_0
    //   15: ldc_w 613
    //   18: aastore
    //   19: ldc_w 615
    //   22: iconst_1
    //   23: anewarray 20	java/lang/String
    //   26: dup
    //   27: iconst_0
    //   28: aload_0
    //   29: aastore
    //   30: aconst_null
    //   31: invokestatic 121	alld:query	(Landroid/content/ContentResolver;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   34: astore 4
    //   36: aload 4
    //   38: ifnull +175 -> 213
    //   41: aload 4
    //   43: astore_3
    //   44: aload 4
    //   46: invokeinterface 618 1 0
    //   51: istore_1
    //   52: iload_1
    //   53: ifne +27 -> 80
    //   56: iconst_0
    //   57: istore_1
    //   58: iload_1
    //   59: istore_2
    //   60: aload 4
    //   62: ifnull +12 -> 74
    //   65: aload 4
    //   67: invokeinterface 159 1 0
    //   72: iload_1
    //   73: istore_2
    //   74: iload_2
    //   75: ifle +122 -> 197
    //   78: iconst_1
    //   79: ireturn
    //   80: aload 4
    //   82: astore_3
    //   83: aload 4
    //   85: invokeinterface 126 1 0
    //   90: pop
    //   91: aload 4
    //   93: astore_3
    //   94: aload 4
    //   96: iconst_0
    //   97: invokeinterface 478 2 0
    //   102: istore_1
    //   103: goto -45 -> 58
    //   106: astore 5
    //   108: aconst_null
    //   109: astore 4
    //   111: aload 4
    //   113: astore_3
    //   114: invokestatic 86	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   117: ifeq +48 -> 165
    //   120: aload 4
    //   122: astore_3
    //   123: ldc 88
    //   125: iconst_2
    //   126: new 90	java/lang/StringBuilder
    //   129: dup
    //   130: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   133: ldc_w 620
    //   136: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: aload_0
    //   140: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: ldc_w 622
    //   146: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: aload 5
    //   151: invokevirtual 100	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   154: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   160: aload 5
    //   162: invokestatic 107	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   165: aload 4
    //   167: ifnull +41 -> 208
    //   170: aload 4
    //   172: invokeinterface 159 1 0
    //   177: iconst_0
    //   178: istore_2
    //   179: goto -105 -> 74
    //   182: astore_0
    //   183: aconst_null
    //   184: astore_3
    //   185: aload_3
    //   186: ifnull +9 -> 195
    //   189: aload_3
    //   190: invokeinterface 159 1 0
    //   195: aload_0
    //   196: athrow
    //   197: iconst_0
    //   198: ireturn
    //   199: astore_0
    //   200: goto -15 -> 185
    //   203: astore 5
    //   205: goto -94 -> 111
    //   208: iconst_0
    //   209: istore_2
    //   210: goto -136 -> 74
    //   213: iconst_0
    //   214: istore_1
    //   215: goto -157 -> 58
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	218	0	paramString	String
    //   51	164	1	i	int
    //   59	151	2	j	int
    //   43	147	3	localCursor1	android.database.Cursor
    //   34	137	4	localCursor2	android.database.Cursor
    //   106	55	5	localException1	Exception
    //   203	1	5	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   0	36	106	java/lang/Exception
    //   0	36	182	finally
    //   44	52	199	finally
    //   83	91	199	finally
    //   94	103	199	finally
    //   114	120	199	finally
    //   123	165	199	finally
    //   44	52	203	java/lang/Exception
    //   83	91	203	java/lang/Exception
    //   94	103	203	java/lang/Exception
  }
  
  public static boolean gr(String paramString)
  {
    if ((paramString == null) || (TextUtils.getTrimmedLength(paramString) <= 0)) {
      return false;
    }
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("updatelog", paramString);
    try
    {
      BaseApplication.getContext().getContentResolver().insert(QZoneConfigProvider.o, localContentValues);
      return true;
    }
    catch (SQLException paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e("QZConfigProviderUtil", 1, "recUpdateSource error:" + paramString.getMessage(), paramString);
      }
      return false;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e("QZConfigProviderUtil", 1, "recUpdateSource error:" + paramString.getMessage(), paramString);
      }
      return false;
    }
    finally
    {
      localContentValues.clear();
    }
  }
  
  /* Error */
  public static String nV()
  {
    // Byte code:
    //   0: invokestatic 64	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   3: invokevirtual 68	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   6: getstatic 633	com/tencent/common/config/provider/QZoneConfigProvider:m	Landroid/net/Uri;
    //   9: aconst_null
    //   10: aconst_null
    //   11: aconst_null
    //   12: aconst_null
    //   13: invokestatic 121	alld:query	(Landroid/content/ContentResolver;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   16: astore_1
    //   17: aload_1
    //   18: ifnull +56 -> 74
    //   21: aload_1
    //   22: astore_0
    //   23: aload_1
    //   24: invokeinterface 126 1 0
    //   29: ifeq +45 -> 74
    //   32: aload_1
    //   33: astore_0
    //   34: new 20	java/lang/String
    //   37: dup
    //   38: aload_1
    //   39: aload_1
    //   40: ldc_w 635
    //   43: invokeinterface 132 2 0
    //   48: invokeinterface 136 2 0
    //   53: invokevirtual 140	java/lang/String:getBytes	()[B
    //   56: ldc 142
    //   58: invokespecial 145	java/lang/String:<init>	([BLjava/lang/String;)V
    //   61: astore_2
    //   62: aload_1
    //   63: ifnull +9 -> 72
    //   66: aload_1
    //   67: invokeinterface 159 1 0
    //   72: aload_2
    //   73: areturn
    //   74: aload_1
    //   75: ifnull +9 -> 84
    //   78: aload_1
    //   79: invokeinterface 159 1 0
    //   84: ldc_w 342
    //   87: areturn
    //   88: astore_2
    //   89: aconst_null
    //   90: astore_1
    //   91: aload_1
    //   92: astore_0
    //   93: invokestatic 86	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   96: ifeq +35 -> 131
    //   99: aload_1
    //   100: astore_0
    //   101: ldc 88
    //   103: iconst_2
    //   104: new 90	java/lang/StringBuilder
    //   107: dup
    //   108: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   111: ldc_w 637
    //   114: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: aload_2
    //   118: invokevirtual 100	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   121: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   127: aload_2
    //   128: invokestatic 639	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   131: aload_1
    //   132: ifnull -48 -> 84
    //   135: aload_1
    //   136: invokeinterface 159 1 0
    //   141: goto -57 -> 84
    //   144: astore_1
    //   145: aconst_null
    //   146: astore_0
    //   147: aload_0
    //   148: ifnull +9 -> 157
    //   151: aload_0
    //   152: invokeinterface 159 1 0
    //   157: aload_1
    //   158: athrow
    //   159: astore_1
    //   160: goto -13 -> 147
    //   163: astore_2
    //   164: goto -73 -> 91
    // Local variable table:
    //   start	length	slot	name	signature
    //   22	130	0	localCursor1	android.database.Cursor
    //   16	120	1	localCursor2	android.database.Cursor
    //   144	14	1	localObject1	Object
    //   159	1	1	localObject2	Object
    //   61	12	2	str	String
    //   88	40	2	localException1	Exception
    //   163	1	2	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   0	17	88	java/lang/Exception
    //   0	17	144	finally
    //   23	32	159	finally
    //   34	62	159	finally
    //   93	99	159	finally
    //   101	131	159	finally
    //   23	32	163	java/lang/Exception
    //   34	62	163	java/lang/Exception
  }
  
  /* Error */
  public static String nW()
  {
    // Byte code:
    //   0: invokestatic 64	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   3: invokevirtual 68	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   6: getstatic 627	com/tencent/common/config/provider/QZoneConfigProvider:o	Landroid/net/Uri;
    //   9: aconst_null
    //   10: aconst_null
    //   11: aconst_null
    //   12: aconst_null
    //   13: invokestatic 121	alld:query	(Landroid/content/ContentResolver;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   16: astore_0
    //   17: aload_0
    //   18: ifnull +130 -> 148
    //   21: aload_0
    //   22: astore_1
    //   23: aload_0
    //   24: invokeinterface 126 1 0
    //   29: ifeq +119 -> 148
    //   32: aload_0
    //   33: astore_1
    //   34: aload_0
    //   35: aload_0
    //   36: ldc_w 624
    //   39: invokeinterface 132 2 0
    //   44: invokeinterface 136 2 0
    //   49: astore_2
    //   50: aload_2
    //   51: astore_1
    //   52: aload_0
    //   53: ifnull +9 -> 62
    //   56: aload_0
    //   57: invokeinterface 159 1 0
    //   62: aload_1
    //   63: areturn
    //   64: astore_2
    //   65: aconst_null
    //   66: astore_0
    //   67: aload_0
    //   68: astore_1
    //   69: invokestatic 86	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   72: ifeq +35 -> 107
    //   75: aload_0
    //   76: astore_1
    //   77: ldc 88
    //   79: iconst_2
    //   80: new 90	java/lang/StringBuilder
    //   83: dup
    //   84: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   87: ldc_w 642
    //   90: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: aload_2
    //   94: invokevirtual 100	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   97: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   103: aload_2
    //   104: invokestatic 107	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   107: aload_0
    //   108: ifnull +36 -> 144
    //   111: aload_0
    //   112: invokeinterface 159 1 0
    //   117: ldc_w 342
    //   120: areturn
    //   121: astore_0
    //   122: aconst_null
    //   123: astore_1
    //   124: aload_1
    //   125: ifnull +9 -> 134
    //   128: aload_1
    //   129: invokeinterface 159 1 0
    //   134: aload_0
    //   135: athrow
    //   136: astore_0
    //   137: goto -13 -> 124
    //   140: astore_2
    //   141: goto -74 -> 67
    //   144: ldc_w 342
    //   147: areturn
    //   148: ldc_w 342
    //   151: astore_1
    //   152: goto -100 -> 52
    // Local variable table:
    //   start	length	slot	name	signature
    //   16	96	0	localCursor	android.database.Cursor
    //   121	14	0	localObject1	Object
    //   136	1	0	localObject2	Object
    //   22	130	1	localObject3	Object
    //   49	2	2	str	String
    //   64	40	2	localException1	Exception
    //   140	1	2	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   0	17	64	java/lang/Exception
    //   0	17	121	finally
    //   23	32	136	finally
    //   34	50	136	finally
    //   69	75	136	finally
    //   77	107	136	finally
    //   23	32	140	java/lang/Exception
    //   34	50	140	java/lang/Exception
  }
  
  public static void q(String paramString, ArrayList<entrance_cfg> paramArrayList)
  {
    if (paramArrayList == null) {}
    while (paramArrayList.size() == 0) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      ContentValues localContentValues = a(paramString, (entrance_cfg)paramArrayList.next());
      if (localContentValues != null) {
        localArrayList.add(localContentValues);
      }
    }
    a((ContentValues[])localArrayList.toArray(new ContentValues[0]));
  }
  
  public static void tY(String paramString)
  {
    ContentValues localContentValues = new ContentValues();
    String str;
    if (paramString == null)
    {
      str = "";
      localContentValues.put("cookie", str);
      QLog.i("ConfigProvider", 1, "saveConfigCookie cookie" + paramString);
    }
    for (;;)
    {
      try
      {
        paramString = BaseApplication.getContext().getContentResolver().insert(QZoneConfigProvider.m, localContentValues);
        if (paramString == null) {
          continue;
        }
        QLog.i("QZConfigProviderUtil", 1, paramString.toString() + " saveConfigCookie done.");
      }
      catch (SQLException paramString)
      {
        QLog.e("QZConfigProviderUtil", 1, "saveConfigCookie error:" + paramString.getMessage(), paramString);
        continue;
      }
      catch (Exception paramString)
      {
        QLog.e("QZConfigProviderUtil", 1, "saveConfigCookie error:" + paramString.getMessage(), paramString);
        continue;
      }
      localContentValues.clear();
      return;
      str = paramString;
      break;
      QLog.e("QZConfigProviderUtil", 1, "saveConfigCookie error!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     sxc
 * JD-Core Version:    0.7.0.1
 */