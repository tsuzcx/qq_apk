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

public class xoz
{
  private static final Set<String> a = new HashSet();
  
  static
  {
    a.add("miniappshowreddot");
    a.add("miniappshowmessagereddot");
    a.add("miniappfullscreenshownotificationbtn");
    a.add("miniappfullscreenshownotificationreddot");
    a.add("miniapptriggerfullscreenheight");
    a.add("miniappgetpskeydomain");
    a.add("miniappsustempermissionconfig");
    a.add("MiniAppMsfTimeoutValue");
    a.add("miniappsendrequestbyhttps");
  }
  
  /* Error */
  public static long a()
  {
    // Byte code:
    //   0: invokestatic 50	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   3: invokevirtual 54	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   6: getstatic 60	com/tencent/common/config/provider/QZoneConfigProvider:f	Landroid/net/Uri;
    //   9: aconst_null
    //   10: aconst_null
    //   11: aconst_null
    //   12: aconst_null
    //   13: invokevirtual 66	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   16: astore_2
    //   17: aload_2
    //   18: ifnull +39 -> 57
    //   21: aload_2
    //   22: invokeinterface 72 1 0
    //   27: ifeq +30 -> 57
    //   30: aload_2
    //   31: aload_2
    //   32: ldc 74
    //   34: invokeinterface 78 2 0
    //   39: invokeinterface 82 2 0
    //   44: lstore_0
    //   45: aload_2
    //   46: ifnull +9 -> 55
    //   49: aload_2
    //   50: invokeinterface 85 1 0
    //   55: lload_0
    //   56: lreturn
    //   57: aload_2
    //   58: ifnull +9 -> 67
    //   61: aload_2
    //   62: invokeinterface 85 1 0
    //   67: lconst_0
    //   68: lreturn
    //   69: astore_3
    //   70: aconst_null
    //   71: astore_2
    //   72: invokestatic 90	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   75: ifeq +32 -> 107
    //   78: ldc 92
    //   80: iconst_2
    //   81: new 94	java/lang/StringBuilder
    //   84: dup
    //   85: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   88: ldc 97
    //   90: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: aload_3
    //   94: invokevirtual 105	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   97: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   103: aload_3
    //   104: invokestatic 112	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   107: aload_2
    //   108: ifnull -41 -> 67
    //   111: aload_2
    //   112: invokeinterface 85 1 0
    //   117: goto -50 -> 67
    //   120: astore_3
    //   121: aconst_null
    //   122: astore_2
    //   123: aload_2
    //   124: ifnull +9 -> 133
    //   127: aload_2
    //   128: invokeinterface 85 1 0
    //   133: aload_3
    //   134: athrow
    //   135: astore_3
    //   136: goto -13 -> 123
    //   139: astore_3
    //   140: goto -17 -> 123
    //   143: astore_3
    //   144: goto -72 -> 72
    // Local variable table:
    //   start	length	slot	name	signature
    //   44	12	0	l	long
    //   16	112	2	localCursor	android.database.Cursor
    //   69	35	3	localException1	Exception
    //   120	14	3	localObject1	Object
    //   135	1	3	localObject2	Object
    //   139	1	3	localObject3	Object
    //   143	1	3	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   0	17	69	java/lang/Exception
    //   0	17	120	finally
    //   21	45	135	finally
    //   72	107	139	finally
    //   21	45	143	java/lang/Exception
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
  
  /* Error */
  public static String a()
  {
    // Byte code:
    //   0: invokestatic 50	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   3: invokevirtual 54	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   6: getstatic 213	com/tencent/common/config/provider/QZoneConfigProvider:b	Landroid/net/Uri;
    //   9: aconst_null
    //   10: aconst_null
    //   11: aconst_null
    //   12: aconst_null
    //   13: invokevirtual 66	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   16: astore_1
    //   17: aload_1
    //   18: ifnull +55 -> 73
    //   21: aload_1
    //   22: astore_0
    //   23: aload_1
    //   24: invokeinterface 72 1 0
    //   29: ifeq +44 -> 73
    //   32: aload_1
    //   33: astore_0
    //   34: new 131	java/lang/String
    //   37: dup
    //   38: aload_1
    //   39: aload_1
    //   40: ldc 215
    //   42: invokeinterface 78 2 0
    //   47: invokeinterface 219 2 0
    //   52: invokevirtual 223	java/lang/String:getBytes	()[B
    //   55: ldc 225
    //   57: invokespecial 228	java/lang/String:<init>	([BLjava/lang/String;)V
    //   60: astore_2
    //   61: aload_1
    //   62: ifnull +9 -> 71
    //   65: aload_1
    //   66: invokeinterface 85 1 0
    //   71: aload_2
    //   72: areturn
    //   73: aload_1
    //   74: ifnull +9 -> 83
    //   77: aload_1
    //   78: invokeinterface 85 1 0
    //   83: ldc 129
    //   85: areturn
    //   86: astore_2
    //   87: aconst_null
    //   88: astore_1
    //   89: aload_1
    //   90: astore_0
    //   91: invokestatic 90	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   94: ifeq +34 -> 128
    //   97: aload_1
    //   98: astore_0
    //   99: ldc 92
    //   101: iconst_2
    //   102: new 94	java/lang/StringBuilder
    //   105: dup
    //   106: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   109: ldc 230
    //   111: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: aload_2
    //   115: invokevirtual 105	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   118: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   124: aload_2
    //   125: invokestatic 233	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   128: aload_1
    //   129: ifnull -46 -> 83
    //   132: aload_1
    //   133: invokeinterface 85 1 0
    //   138: goto -55 -> 83
    //   141: astore_1
    //   142: aconst_null
    //   143: astore_0
    //   144: aload_0
    //   145: ifnull +9 -> 154
    //   148: aload_0
    //   149: invokeinterface 85 1 0
    //   154: aload_1
    //   155: athrow
    //   156: astore_1
    //   157: goto -13 -> 144
    //   160: astore_2
    //   161: goto -72 -> 89
    // Local variable table:
    //   start	length	slot	name	signature
    //   22	127	0	localCursor1	android.database.Cursor
    //   16	117	1	localCursor2	android.database.Cursor
    //   141	14	1	localObject1	Object
    //   156	1	1	localObject2	Object
    //   60	12	2	str	String
    //   86	39	2	localException1	Exception
    //   160	1	2	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   0	17	86	java/lang/Exception
    //   0	17	141	finally
    //   23	32	156	finally
    //   34	61	156	finally
    //   91	97	156	finally
    //   99	128	156	finally
    //   23	32	160	java/lang/Exception
    //   34	61	160	java/lang/Exception
  }
  
  /* Error */
  public static String a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +10 -> 11
    //   4: aload_0
    //   5: invokestatic 238	android/text/TextUtils:getTrimmedLength	(Ljava/lang/CharSequence;)I
    //   8: ifgt +5 -> 13
    //   11: aconst_null
    //   12: areturn
    //   13: aload_1
    //   14: ifnull -3 -> 11
    //   17: aload_1
    //   18: invokestatic 238	android/text/TextUtils:getTrimmedLength	(Ljava/lang/CharSequence;)I
    //   21: ifle -10 -> 11
    //   24: invokestatic 50	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   27: invokevirtual 54	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   30: getstatic 240	com/tencent/common/config/provider/QZoneConfigProvider:a	Landroid/net/Uri;
    //   33: aconst_null
    //   34: ldc 242
    //   36: iconst_2
    //   37: anewarray 131	java/lang/String
    //   40: dup
    //   41: iconst_0
    //   42: aload_0
    //   43: aastore
    //   44: dup
    //   45: iconst_1
    //   46: aload_1
    //   47: aastore
    //   48: aconst_null
    //   49: invokevirtual 66	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   52: astore_1
    //   53: aload_1
    //   54: ifnull +147 -> 201
    //   57: aload_1
    //   58: astore_0
    //   59: aload_1
    //   60: invokeinterface 72 1 0
    //   65: ifeq +136 -> 201
    //   68: aload_1
    //   69: astore_0
    //   70: aload_1
    //   71: aload_1
    //   72: ldc 244
    //   74: invokeinterface 78 2 0
    //   79: invokeinterface 219 2 0
    //   84: astore_2
    //   85: aload_2
    //   86: astore_0
    //   87: aload_1
    //   88: ifnull +11 -> 99
    //   91: aload_1
    //   92: invokeinterface 85 1 0
    //   97: aload_2
    //   98: astore_0
    //   99: aload_0
    //   100: areturn
    //   101: astore_0
    //   102: aload_0
    //   103: invokevirtual 247	java/lang/Exception:printStackTrace	()V
    //   106: aload_2
    //   107: astore_0
    //   108: goto -9 -> 99
    //   111: astore_2
    //   112: aconst_null
    //   113: astore_1
    //   114: aload_1
    //   115: astore_0
    //   116: invokestatic 90	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   119: ifeq +21 -> 140
    //   122: aload_1
    //   123: astore_0
    //   124: ldc 92
    //   126: iconst_2
    //   127: aload_2
    //   128: iconst_1
    //   129: anewarray 4	java/lang/Object
    //   132: dup
    //   133: iconst_0
    //   134: ldc 249
    //   136: aastore
    //   137: invokestatic 252	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   140: aload_1
    //   141: ifnull +55 -> 196
    //   144: aload_1
    //   145: invokeinterface 85 1 0
    //   150: aconst_null
    //   151: astore_0
    //   152: goto -53 -> 99
    //   155: astore_0
    //   156: aload_0
    //   157: invokevirtual 247	java/lang/Exception:printStackTrace	()V
    //   160: aconst_null
    //   161: astore_0
    //   162: goto -63 -> 99
    //   165: astore_1
    //   166: aconst_null
    //   167: astore_0
    //   168: aload_0
    //   169: ifnull +9 -> 178
    //   172: aload_0
    //   173: invokeinterface 85 1 0
    //   178: aload_1
    //   179: athrow
    //   180: astore_0
    //   181: aload_0
    //   182: invokevirtual 247	java/lang/Exception:printStackTrace	()V
    //   185: goto -7 -> 178
    //   188: astore_1
    //   189: goto -21 -> 168
    //   192: astore_2
    //   193: goto -79 -> 114
    //   196: aconst_null
    //   197: astore_0
    //   198: goto -99 -> 99
    //   201: aconst_null
    //   202: astore_2
    //   203: goto -118 -> 85
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	206	0	paramString1	String
    //   0	206	1	paramString2	String
    //   84	23	2	str	String
    //   111	17	2	localException1	Exception
    //   192	1	2	localException2	Exception
    //   202	1	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   91	97	101	java/lang/Exception
    //   24	53	111	java/lang/Exception
    //   144	150	155	java/lang/Exception
    //   24	53	165	finally
    //   172	178	180	java/lang/Exception
    //   59	68	188	finally
    //   70	85	188	finally
    //   116	122	188	finally
    //   124	140	188	finally
    //   59	68	192	java/lang/Exception
    //   70	85	192	java/lang/Exception
  }
  
  /* Error */
  public static Map<String, String> a()
  {
    // Byte code:
    //   0: new 255	java/util/HashMap
    //   3: dup
    //   4: invokespecial 256	java/util/HashMap:<init>	()V
    //   7: astore_3
    //   8: invokestatic 50	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   11: invokevirtual 54	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   14: getstatic 258	com/tencent/common/config/provider/QZoneConfigProvider:e	Landroid/net/Uri;
    //   17: aconst_null
    //   18: aconst_null
    //   19: aconst_null
    //   20: aconst_null
    //   21: invokevirtual 66	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   24: astore_2
    //   25: aload_2
    //   26: ifnull +89 -> 115
    //   29: aload_2
    //   30: astore_1
    //   31: aload_2
    //   32: invokeinterface 72 1 0
    //   37: ifeq +78 -> 115
    //   40: aload_2
    //   41: astore_1
    //   42: aload_3
    //   43: new 131	java/lang/String
    //   46: dup
    //   47: aload_2
    //   48: aload_2
    //   49: ldc_w 260
    //   52: invokeinterface 78 2 0
    //   57: invokeinterface 219 2 0
    //   62: invokevirtual 223	java/lang/String:getBytes	()[B
    //   65: ldc 225
    //   67: invokespecial 228	java/lang/String:<init>	([BLjava/lang/String;)V
    //   70: new 131	java/lang/String
    //   73: dup
    //   74: aload_2
    //   75: aload_2
    //   76: ldc 244
    //   78: invokeinterface 78 2 0
    //   83: invokeinterface 219 2 0
    //   88: invokevirtual 223	java/lang/String:getBytes	()[B
    //   91: ldc 225
    //   93: invokespecial 228	java/lang/String:<init>	([BLjava/lang/String;)V
    //   96: invokeinterface 265 3 0
    //   101: pop
    //   102: aload_2
    //   103: astore_1
    //   104: aload_2
    //   105: invokeinterface 268 1 0
    //   110: istore_0
    //   111: iload_0
    //   112: ifne -72 -> 40
    //   115: aload_2
    //   116: ifnull +9 -> 125
    //   119: aload_2
    //   120: invokeinterface 85 1 0
    //   125: aload_3
    //   126: areturn
    //   127: astore_3
    //   128: aconst_null
    //   129: astore_2
    //   130: aload_2
    //   131: astore_1
    //   132: invokestatic 90	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   135: ifeq +35 -> 170
    //   138: aload_2
    //   139: astore_1
    //   140: ldc 92
    //   142: iconst_2
    //   143: new 94	java/lang/StringBuilder
    //   146: dup
    //   147: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   150: ldc_w 270
    //   153: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: aload_3
    //   157: invokevirtual 105	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   160: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   166: aload_3
    //   167: invokestatic 112	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   170: aload_2
    //   171: ifnull +9 -> 180
    //   174: aload_2
    //   175: invokeinterface 85 1 0
    //   180: aconst_null
    //   181: areturn
    //   182: astore_2
    //   183: aconst_null
    //   184: astore_1
    //   185: aload_1
    //   186: ifnull +9 -> 195
    //   189: aload_1
    //   190: invokeinterface 85 1 0
    //   195: aload_2
    //   196: athrow
    //   197: astore_2
    //   198: goto -13 -> 185
    //   201: astore_3
    //   202: goto -72 -> 130
    // Local variable table:
    //   start	length	slot	name	signature
    //   110	2	0	bool	boolean
    //   30	160	1	localCursor1	android.database.Cursor
    //   24	151	2	localCursor2	android.database.Cursor
    //   182	14	2	localObject1	Object
    //   197	1	2	localObject2	Object
    //   7	119	3	localHashMap	java.util.HashMap
    //   127	40	3	localException1	Exception
    //   201	1	3	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   8	25	127	java/lang/Exception
    //   8	25	182	finally
    //   31	40	197	finally
    //   42	102	197	finally
    //   104	111	197	finally
    //   132	138	197	finally
    //   140	170	197	finally
    //   31	40	201	java/lang/Exception
    //   42	102	201	java/lang/Exception
    //   104	111	201	java/lang/Exception
  }
  
  public static void a()
  {
    try
    {
      BaseApplication.getContext().getContentResolver().delete(QZoneConfigProvider.d, null, null);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("QZConfigProviderUtil", 2, "database clear error" + localException.getMessage(), localException);
    }
  }
  
  public static void a(long paramLong)
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
      BaseApplication.getContext().getContentResolver().insert(QZoneConfigProvider.f, localContentValues);
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
  
  public static void a(String paramString)
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
        paramString = BaseApplication.getContext().getContentResolver().insert(QZoneConfigProvider.b, localContentValues);
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
  
  private static void a(String paramString1, String paramString2, String paramString3)
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
    } while ((!"qqminiapp".equals(paramString1)) || (!a.contains(paramString2)));
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
  
  public static void a(String paramString, ArrayList<entrance_cfg> paramArrayList)
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
  
  public static void a(Map<String, String> paramMap)
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
          a(str, (String)paramMap.get(str));
        }
      }
    }
  }
  
  public static void a(Map<String, byte[]> paramMap, String paramString1, String paramString2, AppRuntime paramAppRuntime)
  {
    boolean bool = a(paramMap, paramString2);
    if ((b("PhotoUpload")) && (b("PhotoSvrList"))) {
      if (bool) {
        a(paramString1);
      }
    }
    for (;;)
    {
      a(paramString2);
      if (paramAppRuntime != null) {}
      try
      {
        if (((paramAppRuntime instanceof QQAppInterface)) && (paramAppRuntime.getLongAccountUin() != 0L))
        {
          paramMap = QzoneConfig.getInstance().getConfig("QZoneSetting", "Qzone_clearCacheVersion", "");
          if ((!TextUtils.isEmpty(paramMap)) && (!LocalMultiProcConfig.getString4Uin("Qzone_clearCacheVersion", "", paramAppRuntime.getLongAccountUin()).equals(paramMap)))
          {
            bgyp.a(paramAppRuntime, true);
            LocalMultiProcConfig.putString4Uin("Qzone_clearCacheVersion", paramMap, paramAppRuntime.getLongAccountUin());
          }
        }
        return;
      }
      catch (Exception paramMap)
      {
        QLog.e("QZConfigProviderUtil", 1, paramMap.getMessage());
      }
      a("");
    }
  }
  
  public static boolean a(String paramString)
  {
    if ((paramString == null) || (TextUtils.getTrimmedLength(paramString) <= 0)) {
      return false;
    }
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("updatelog", paramString);
    try
    {
      BaseApplication.getContext().getContentResolver().insert(QZoneConfigProvider.c, localContentValues);
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
  
  private static boolean a(String paramString1, String paramString2)
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
      BaseApplication.getContext().getContentResolver().insert(QZoneConfigProvider.e, localContentValues);
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
  
  /* Error */
  public static boolean a(String paramString, ArrayList<entrance_cfg> paramArrayList)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +10 -> 11
    //   4: aload_0
    //   5: invokestatic 238	android/text/TextUtils:getTrimmedLength	(Ljava/lang/CharSequence;)I
    //   8: ifgt +5 -> 13
    //   11: iconst_0
    //   12: ireturn
    //   13: aload_1
    //   14: ifnull -3 -> 11
    //   17: aload_1
    //   18: invokevirtual 535	java/util/ArrayList:clear	()V
    //   21: aload_0
    //   22: ldc 127
    //   24: ldc 129
    //   26: invokevirtual 135	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   29: astore_0
    //   30: new 94	java/lang/StringBuilder
    //   33: dup
    //   34: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   37: ldc_w 537
    //   40: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: aload_0
    //   44: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: ldc_w 539
    //   50: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   56: astore_0
    //   57: invokestatic 50	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   60: invokevirtual 54	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   63: getstatic 542	com/tencent/common/config/provider/QZoneConfigProvider:g	Landroid/net/Uri;
    //   66: aconst_null
    //   67: aload_0
    //   68: aconst_null
    //   69: aconst_null
    //   70: invokevirtual 66	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   73: astore_0
    //   74: aload_0
    //   75: ifnull +209 -> 284
    //   78: aload_0
    //   79: invokeinterface 72 1 0
    //   84: ifeq +200 -> 284
    //   87: aload_1
    //   88: new 121	NS_UNDEAL_COUNT/entrance_cfg
    //   91: dup
    //   92: aload_0
    //   93: aload_0
    //   94: ldc 185
    //   96: invokeinterface 78 2 0
    //   101: invokeinterface 546 2 0
    //   106: new 131	java/lang/String
    //   109: dup
    //   110: aload_0
    //   111: aload_0
    //   112: ldc 190
    //   114: invokeinterface 78 2 0
    //   119: invokeinterface 219 2 0
    //   124: invokevirtual 223	java/lang/String:getBytes	()[B
    //   127: ldc 225
    //   129: invokespecial 228	java/lang/String:<init>	([BLjava/lang/String;)V
    //   132: new 131	java/lang/String
    //   135: dup
    //   136: aload_0
    //   137: aload_0
    //   138: ldc 192
    //   140: invokeinterface 78 2 0
    //   145: invokeinterface 219 2 0
    //   150: invokevirtual 223	java/lang/String:getBytes	()[B
    //   153: ldc 225
    //   155: invokespecial 228	java/lang/String:<init>	([BLjava/lang/String;)V
    //   158: new 131	java/lang/String
    //   161: dup
    //   162: aload_0
    //   163: aload_0
    //   164: ldc 194
    //   166: invokeinterface 78 2 0
    //   171: invokeinterface 219 2 0
    //   176: invokevirtual 223	java/lang/String:getBytes	()[B
    //   179: ldc 225
    //   181: invokespecial 228	java/lang/String:<init>	([BLjava/lang/String;)V
    //   184: aload_0
    //   185: aload_0
    //   186: ldc 196
    //   188: invokeinterface 78 2 0
    //   193: invokeinterface 546 2 0
    //   198: aload_0
    //   199: aload_0
    //   200: ldc 201
    //   202: invokeinterface 78 2 0
    //   207: invokeinterface 546 2 0
    //   212: new 131	java/lang/String
    //   215: dup
    //   216: aload_0
    //   217: aload_0
    //   218: ldc 205
    //   220: invokeinterface 78 2 0
    //   225: invokeinterface 219 2 0
    //   230: invokevirtual 223	java/lang/String:getBytes	()[B
    //   233: ldc 225
    //   235: invokespecial 228	java/lang/String:<init>	([BLjava/lang/String;)V
    //   238: new 131	java/lang/String
    //   241: dup
    //   242: aload_0
    //   243: aload_0
    //   244: ldc 207
    //   246: invokeinterface 78 2 0
    //   251: invokeinterface 219 2 0
    //   256: invokevirtual 223	java/lang/String:getBytes	()[B
    //   259: ldc 225
    //   261: invokespecial 228	java/lang/String:<init>	([BLjava/lang/String;)V
    //   264: iconst_0
    //   265: aconst_null
    //   266: invokespecial 549	NS_UNDEAL_COUNT/entrance_cfg:<init>	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;ILNS_UNDEAL_COUNT/st_report_info;)V
    //   269: invokevirtual 448	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   272: pop
    //   273: aload_0
    //   274: invokeinterface 268 1 0
    //   279: istore_2
    //   280: iload_2
    //   281: ifne -194 -> 87
    //   284: aload_0
    //   285: ifnull -274 -> 11
    //   288: aload_0
    //   289: invokeinterface 85 1 0
    //   294: iconst_0
    //   295: ireturn
    //   296: astore_1
    //   297: aconst_null
    //   298: astore_0
    //   299: invokestatic 90	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   302: ifeq +33 -> 335
    //   305: ldc 92
    //   307: iconst_2
    //   308: new 94	java/lang/StringBuilder
    //   311: dup
    //   312: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   315: ldc_w 551
    //   318: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   321: aload_1
    //   322: invokevirtual 105	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   325: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   328: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   331: aload_1
    //   332: invokestatic 112	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   335: aload_0
    //   336: ifnull -325 -> 11
    //   339: aload_0
    //   340: invokeinterface 85 1 0
    //   345: iconst_0
    //   346: ireturn
    //   347: astore_1
    //   348: aconst_null
    //   349: astore_0
    //   350: aload_0
    //   351: ifnull +9 -> 360
    //   354: aload_0
    //   355: invokeinterface 85 1 0
    //   360: aload_1
    //   361: athrow
    //   362: astore_1
    //   363: goto -13 -> 350
    //   366: astore_1
    //   367: goto -17 -> 350
    //   370: astore_1
    //   371: goto -72 -> 299
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	374	0	paramString	String
    //   0	374	1	paramArrayList	ArrayList<entrance_cfg>
    //   279	2	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   57	74	296	java/lang/Exception
    //   57	74	347	finally
    //   78	87	362	finally
    //   87	280	362	finally
    //   299	335	366	finally
    //   78	87	370	java/lang/Exception
    //   87	280	370	java/lang/Exception
  }
  
  /* Error */
  public static boolean a(Map<String, java.util.concurrent.ConcurrentHashMap<String, String>> paramMap)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokeinterface 554 1 0
    //   6: invokestatic 50	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   9: invokevirtual 54	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   12: getstatic 240	com/tencent/common/config/provider/QZoneConfigProvider:a	Landroid/net/Uri;
    //   15: aconst_null
    //   16: aconst_null
    //   17: aconst_null
    //   18: aconst_null
    //   19: invokevirtual 66	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   22: astore 4
    //   24: aload 4
    //   26: ifnull +310 -> 336
    //   29: aload 4
    //   31: astore_3
    //   32: aload 4
    //   34: invokeinterface 268 1 0
    //   39: ifeq +170 -> 209
    //   42: aload 4
    //   44: astore_3
    //   45: aload 4
    //   47: iconst_0
    //   48: invokeinterface 219 2 0
    //   53: astore 7
    //   55: aload 4
    //   57: astore_3
    //   58: aload 4
    //   60: iconst_1
    //   61: invokeinterface 219 2 0
    //   66: astore 8
    //   68: aload 7
    //   70: ifnull -41 -> 29
    //   73: aload 8
    //   75: ifnull -46 -> 29
    //   78: aload 4
    //   80: astore_3
    //   81: aload 4
    //   83: iconst_2
    //   84: invokeinterface 219 2 0
    //   89: astore 9
    //   91: aload 4
    //   93: astore_3
    //   94: aload_0
    //   95: aload 7
    //   97: invokeinterface 470 2 0
    //   102: checkcast 556	java/util/concurrent/ConcurrentHashMap
    //   105: astore 6
    //   107: aload 6
    //   109: astore 5
    //   111: aload 6
    //   113: ifnonnull +29 -> 142
    //   116: aload 4
    //   118: astore_3
    //   119: new 556	java/util/concurrent/ConcurrentHashMap
    //   122: dup
    //   123: invokespecial 557	java/util/concurrent/ConcurrentHashMap:<init>	()V
    //   126: astore 5
    //   128: aload 4
    //   130: astore_3
    //   131: aload_0
    //   132: aload 7
    //   134: aload 5
    //   136: invokeinterface 265 3 0
    //   141: pop
    //   142: aload 5
    //   144: ifnull -115 -> 29
    //   147: aload 4
    //   149: astore_3
    //   150: aload 5
    //   152: aload 8
    //   154: aload 9
    //   156: invokevirtual 558	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   159: pop
    //   160: goto -131 -> 29
    //   163: astore_0
    //   164: aload 4
    //   166: astore_3
    //   167: invokestatic 90	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   170: ifeq +23 -> 193
    //   173: aload 4
    //   175: astore_3
    //   176: ldc 92
    //   178: iconst_2
    //   179: aload_0
    //   180: iconst_1
    //   181: anewarray 4	java/lang/Object
    //   184: dup
    //   185: iconst_0
    //   186: ldc_w 560
    //   189: aastore
    //   190: invokestatic 252	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   193: aload 4
    //   195: ifnull +139 -> 334
    //   198: aload 4
    //   200: invokeinterface 85 1 0
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
    //   220: invokeinterface 85 1 0
    //   225: iload_1
    //   226: ireturn
    //   227: astore_0
    //   228: iload_1
    //   229: istore_2
    //   230: invokestatic 90	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   233: ifeq -26 -> 207
    //   236: ldc 92
    //   238: iconst_2
    //   239: aload_0
    //   240: iconst_1
    //   241: anewarray 4	java/lang/Object
    //   244: dup
    //   245: iconst_0
    //   246: ldc_w 560
    //   249: aastore
    //   250: invokestatic 252	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   253: iload_1
    //   254: ireturn
    //   255: astore_0
    //   256: invokestatic 90	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   259: ifeq +20 -> 279
    //   262: ldc 92
    //   264: iconst_2
    //   265: aload_0
    //   266: iconst_1
    //   267: anewarray 4	java/lang/Object
    //   270: dup
    //   271: iconst_0
    //   272: ldc_w 560
    //   275: aastore
    //   276: invokestatic 252	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   279: iconst_0
    //   280: ireturn
    //   281: astore_0
    //   282: aconst_null
    //   283: astore_3
    //   284: aload_3
    //   285: ifnull +9 -> 294
    //   288: aload_3
    //   289: invokeinterface 85 1 0
    //   294: aload_0
    //   295: athrow
    //   296: astore_3
    //   297: invokestatic 90	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   300: ifeq -6 -> 294
    //   303: ldc 92
    //   305: iconst_2
    //   306: aload_3
    //   307: iconst_1
    //   308: anewarray 4	java/lang/Object
    //   311: dup
    //   312: iconst_0
    //   313: ldc_w 560
    //   316: aastore
    //   317: invokestatic 252	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
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
            a((String)localObject1, paramString, str);
          }
          paramString = (String)localObject1;
        }
        try
        {
          BaseApplication.getContext().getContentResolver().delete(QZoneConfigProvider.a, "main_key=?", new String[] { paramString });
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
      BaseApplication.getContext().getContentResolver().bulkInsert(QZoneConfigProvider.a, (ContentValues[])localArrayList.toArray(new ContentValues[localArrayList.size()]));
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
      BaseApplication.getContext().getContentResolver().bulkInsert(QZoneConfigProvider.g, paramArrayOfContentValues);
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
  public static String b()
  {
    // Byte code:
    //   0: invokestatic 50	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   3: invokevirtual 54	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   6: getstatic 529	com/tencent/common/config/provider/QZoneConfigProvider:c	Landroid/net/Uri;
    //   9: aconst_null
    //   10: aconst_null
    //   11: aconst_null
    //   12: aconst_null
    //   13: invokevirtual 66	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   16: astore_0
    //   17: aload_0
    //   18: ifnull +128 -> 146
    //   21: aload_0
    //   22: astore_1
    //   23: aload_0
    //   24: invokeinterface 72 1 0
    //   29: ifeq +117 -> 146
    //   32: aload_0
    //   33: astore_1
    //   34: aload_0
    //   35: aload_0
    //   36: ldc_w 526
    //   39: invokeinterface 78 2 0
    //   44: invokeinterface 219 2 0
    //   49: astore_2
    //   50: aload_2
    //   51: astore_1
    //   52: aload_0
    //   53: ifnull +9 -> 62
    //   56: aload_0
    //   57: invokeinterface 85 1 0
    //   62: aload_1
    //   63: areturn
    //   64: astore_2
    //   65: aconst_null
    //   66: astore_0
    //   67: aload_0
    //   68: astore_1
    //   69: invokestatic 90	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   72: ifeq +35 -> 107
    //   75: aload_0
    //   76: astore_1
    //   77: ldc 92
    //   79: iconst_2
    //   80: new 94	java/lang/StringBuilder
    //   83: dup
    //   84: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   87: ldc_w 625
    //   90: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: aload_2
    //   94: invokevirtual 105	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   97: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   103: aload_2
    //   104: invokestatic 112	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   107: aload_0
    //   108: ifnull +35 -> 143
    //   111: aload_0
    //   112: invokeinterface 85 1 0
    //   117: ldc 129
    //   119: areturn
    //   120: astore_0
    //   121: aconst_null
    //   122: astore_1
    //   123: aload_1
    //   124: ifnull +9 -> 133
    //   127: aload_1
    //   128: invokeinterface 85 1 0
    //   133: aload_0
    //   134: athrow
    //   135: astore_0
    //   136: goto -13 -> 123
    //   139: astore_2
    //   140: goto -73 -> 67
    //   143: ldc 129
    //   145: areturn
    //   146: ldc 129
    //   148: astore_1
    //   149: goto -97 -> 52
    // Local variable table:
    //   start	length	slot	name	signature
    //   16	96	0	localCursor	android.database.Cursor
    //   120	14	0	localObject1	Object
    //   135	1	0	localObject2	Object
    //   22	127	1	localObject3	Object
    //   49	2	2	str	String
    //   64	40	2	localException1	Exception
    //   139	1	2	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   0	17	64	java/lang/Exception
    //   0	17	120	finally
    //   23	32	135	finally
    //   34	50	135	finally
    //   69	75	135	finally
    //   77	107	135	finally
    //   23	32	139	java/lang/Exception
    //   34	50	139	java/lang/Exception
  }
  
  /* Error */
  private static boolean b(String paramString)
  {
    // Byte code:
    //   0: invokestatic 50	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   3: invokevirtual 54	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   6: getstatic 240	com/tencent/common/config/provider/QZoneConfigProvider:a	Landroid/net/Uri;
    //   9: iconst_1
    //   10: anewarray 131	java/lang/String
    //   13: dup
    //   14: iconst_0
    //   15: ldc_w 627
    //   18: aastore
    //   19: ldc_w 629
    //   22: iconst_1
    //   23: anewarray 131	java/lang/String
    //   26: dup
    //   27: iconst_0
    //   28: aload_0
    //   29: aastore
    //   30: aconst_null
    //   31: invokevirtual 66	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   34: astore 4
    //   36: aload 4
    //   38: ifnull +175 -> 213
    //   41: aload 4
    //   43: astore_3
    //   44: aload 4
    //   46: invokeinterface 632 1 0
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
    //   67: invokeinterface 85 1 0
    //   72: iload_1
    //   73: istore_2
    //   74: iload_2
    //   75: ifle +122 -> 197
    //   78: iconst_1
    //   79: ireturn
    //   80: aload 4
    //   82: astore_3
    //   83: aload 4
    //   85: invokeinterface 72 1 0
    //   90: pop
    //   91: aload 4
    //   93: astore_3
    //   94: aload 4
    //   96: iconst_0
    //   97: invokeinterface 546 2 0
    //   102: istore_1
    //   103: goto -45 -> 58
    //   106: astore 5
    //   108: aconst_null
    //   109: astore 4
    //   111: aload 4
    //   113: astore_3
    //   114: invokestatic 90	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   117: ifeq +48 -> 165
    //   120: aload 4
    //   122: astore_3
    //   123: ldc 92
    //   125: iconst_2
    //   126: new 94	java/lang/StringBuilder
    //   129: dup
    //   130: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   133: ldc_w 634
    //   136: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: aload_0
    //   140: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: ldc_w 636
    //   146: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: aload 5
    //   151: invokevirtual 105	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   154: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   160: aload 5
    //   162: invokestatic 112	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   165: aload 4
    //   167: ifnull +41 -> 208
    //   170: aload 4
    //   172: invokeinterface 85 1 0
    //   177: iconst_0
    //   178: istore_2
    //   179: goto -105 -> 74
    //   182: astore_0
    //   183: aconst_null
    //   184: astore_3
    //   185: aload_3
    //   186: ifnull +9 -> 195
    //   189: aload_3
    //   190: invokeinterface 85 1 0
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     xoz
 * JD-Core Version:    0.7.0.1
 */