package com.tencent.common.config.provider;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.net.Uri;
import android.text.TextUtils;
import com.qq.jce.wup.UniAttribute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class QZConfigProviderUtil
{
  public static final String a = "TimeMonitor";
  public static final boolean a = false;
  public static final String b = "unknow";
  public static final String c = "ConfigProvider";
  private static final String d = "QZConfigProviderUtil";
  
  private static int a(String paramString)
  {
    if ((paramString == null) || (TextUtils.getTrimmedLength(paramString) <= 0)) {
      return 0;
    }
    try
    {
      int i = BaseApplication.getContext().getContentResolver().delete(QZoneConfigProvider.a, "key=?", new String[] { paramString });
      return i;
    }
    catch (Exception paramString)
    {
      QLog.e("ConfigProvider", 2, "deleteOneConfig error:" + paramString.getMessage());
    }
    return 0;
  }
  
  /* Error */
  public static long a()
  {
    // Byte code:
    //   0: invokestatic 39	com/tencent/qphone/base/util/BaseApplication:getContext	()Landroid/content/Context;
    //   3: invokevirtual 45	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   6: getstatic 86	com/tencent/common/config/provider/QZoneConfigProvider:f	Landroid/net/Uri;
    //   9: aconst_null
    //   10: aconst_null
    //   11: aconst_null
    //   12: aconst_null
    //   13: invokevirtual 90	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   16: astore_2
    //   17: aload_2
    //   18: ifnull +39 -> 57
    //   21: aload_2
    //   22: invokeinterface 96 1 0
    //   27: ifeq +30 -> 57
    //   30: aload_2
    //   31: aload_2
    //   32: ldc 98
    //   34: invokeinterface 101 2 0
    //   39: invokeinterface 105 2 0
    //   44: lstore_0
    //   45: aload_2
    //   46: ifnull +9 -> 55
    //   49: aload_2
    //   50: invokeinterface 108 1 0
    //   55: lload_0
    //   56: lreturn
    //   57: aload_2
    //   58: ifnull +9 -> 67
    //   61: aload_2
    //   62: invokeinterface 108 1 0
    //   67: lconst_0
    //   68: lreturn
    //   69: astore_3
    //   70: aconst_null
    //   71: astore_2
    //   72: ldc 16
    //   74: iconst_2
    //   75: new 62	java/lang/StringBuilder
    //   78: dup
    //   79: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   82: ldc 110
    //   84: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: aload_3
    //   88: invokevirtual 73	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   91: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   97: aload_3
    //   98: invokestatic 113	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   101: aload_2
    //   102: ifnull -35 -> 67
    //   105: aload_2
    //   106: invokeinterface 108 1 0
    //   111: goto -44 -> 67
    //   114: astore_3
    //   115: aconst_null
    //   116: astore_2
    //   117: aload_2
    //   118: ifnull +9 -> 127
    //   121: aload_2
    //   122: invokeinterface 108 1 0
    //   127: aload_3
    //   128: athrow
    //   129: astore_3
    //   130: goto -13 -> 117
    //   133: astore_3
    //   134: goto -17 -> 117
    //   137: astore_3
    //   138: goto -66 -> 72
    // Local variable table:
    //   start	length	slot	name	signature
    //   44	12	0	l	long
    //   16	106	2	localCursor	android.database.Cursor
    //   69	29	3	localException1	Exception
    //   114	14	3	localObject1	Object
    //   129	1	3	localObject2	Object
    //   133	1	3	localObject3	Object
    //   137	1	3	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   0	17	69	java/lang/Exception
    //   0	17	114	finally
    //   21	45	129	finally
    //   72	101	133	finally
    //   21	45	137	java/lang/Exception
  }
  
  /* Error */
  public static String a()
  {
    // Byte code:
    //   0: invokestatic 39	com/tencent/qphone/base/util/BaseApplication:getContext	()Landroid/content/Context;
    //   3: invokevirtual 45	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   6: getstatic 115	com/tencent/common/config/provider/QZoneConfigProvider:b	Landroid/net/Uri;
    //   9: aconst_null
    //   10: aconst_null
    //   11: aconst_null
    //   12: aconst_null
    //   13: invokevirtual 90	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   16: astore_1
    //   17: aload_1
    //   18: ifnull +55 -> 73
    //   21: aload_1
    //   22: astore_0
    //   23: aload_1
    //   24: invokeinterface 96 1 0
    //   29: ifeq +44 -> 73
    //   32: aload_1
    //   33: astore_0
    //   34: new 54	java/lang/String
    //   37: dup
    //   38: aload_1
    //   39: aload_1
    //   40: ldc 117
    //   42: invokeinterface 101 2 0
    //   47: invokeinterface 121 2 0
    //   52: invokevirtual 125	java/lang/String:getBytes	()[B
    //   55: ldc 127
    //   57: invokespecial 130	java/lang/String:<init>	([BLjava/lang/String;)V
    //   60: astore_2
    //   61: aload_1
    //   62: ifnull +9 -> 71
    //   65: aload_1
    //   66: invokeinterface 108 1 0
    //   71: aload_2
    //   72: areturn
    //   73: aload_1
    //   74: ifnull +9 -> 83
    //   77: aload_1
    //   78: invokeinterface 108 1 0
    //   83: ldc 132
    //   85: areturn
    //   86: astore_2
    //   87: aconst_null
    //   88: astore_1
    //   89: aload_1
    //   90: astore_0
    //   91: ldc 16
    //   93: iconst_2
    //   94: new 62	java/lang/StringBuilder
    //   97: dup
    //   98: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   101: ldc 134
    //   103: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: aload_2
    //   107: invokevirtual 73	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   110: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   116: aload_2
    //   117: invokestatic 136	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   120: aload_1
    //   121: ifnull -38 -> 83
    //   124: aload_1
    //   125: invokeinterface 108 1 0
    //   130: goto -47 -> 83
    //   133: astore_1
    //   134: aconst_null
    //   135: astore_0
    //   136: aload_0
    //   137: ifnull +9 -> 146
    //   140: aload_0
    //   141: invokeinterface 108 1 0
    //   146: aload_1
    //   147: athrow
    //   148: astore_1
    //   149: goto -13 -> 136
    //   152: astore_2
    //   153: goto -64 -> 89
    // Local variable table:
    //   start	length	slot	name	signature
    //   22	119	0	localCursor1	android.database.Cursor
    //   16	109	1	localCursor2	android.database.Cursor
    //   133	14	1	localObject1	Object
    //   148	1	1	localObject2	Object
    //   60	12	2	str	String
    //   86	31	2	localException1	Exception
    //   152	1	2	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   0	17	86	java/lang/Exception
    //   0	17	133	finally
    //   23	32	148	finally
    //   34	61	148	finally
    //   91	120	148	finally
    //   23	32	152	java/lang/Exception
    //   34	61	152	java/lang/Exception
  }
  
  /* Error */
  private static String a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +10 -> 11
    //   4: aload_0
    //   5: invokestatic 33	android/text/TextUtils:getTrimmedLength	(Ljava/lang/CharSequence;)I
    //   8: ifgt +7 -> 15
    //   11: aconst_null
    //   12: astore_2
    //   13: aload_2
    //   14: areturn
    //   15: invokestatic 39	com/tencent/qphone/base/util/BaseApplication:getContext	()Landroid/content/Context;
    //   18: invokevirtual 45	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   21: getstatic 139	com/tencent/common/config/provider/QZoneConfigProvider:e	Landroid/net/Uri;
    //   24: iconst_2
    //   25: anewarray 54	java/lang/String
    //   28: dup
    //   29: iconst_0
    //   30: ldc 141
    //   32: aastore
    //   33: dup
    //   34: iconst_1
    //   35: ldc 143
    //   37: aastore
    //   38: ldc 52
    //   40: iconst_1
    //   41: anewarray 54	java/lang/String
    //   44: dup
    //   45: iconst_0
    //   46: aload_0
    //   47: aastore
    //   48: aconst_null
    //   49: invokevirtual 90	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   52: astore_0
    //   53: aload_0
    //   54: ifnull +130 -> 184
    //   57: aload_0
    //   58: astore_1
    //   59: aload_0
    //   60: invokeinterface 96 1 0
    //   65: ifeq +119 -> 184
    //   68: aload_0
    //   69: astore_1
    //   70: new 54	java/lang/String
    //   73: dup
    //   74: aload_0
    //   75: aload_0
    //   76: ldc 143
    //   78: invokeinterface 101 2 0
    //   83: invokeinterface 121 2 0
    //   88: invokevirtual 125	java/lang/String:getBytes	()[B
    //   91: ldc 127
    //   93: invokespecial 130	java/lang/String:<init>	([BLjava/lang/String;)V
    //   96: astore_2
    //   97: aload_2
    //   98: astore_1
    //   99: aload_1
    //   100: astore_2
    //   101: aload_0
    //   102: ifnull -89 -> 13
    //   105: aload_0
    //   106: invokeinterface 108 1 0
    //   111: aload_1
    //   112: areturn
    //   113: astore_2
    //   114: aconst_null
    //   115: astore_0
    //   116: aload_0
    //   117: astore_1
    //   118: ldc 16
    //   120: iconst_2
    //   121: new 62	java/lang/StringBuilder
    //   124: dup
    //   125: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   128: ldc 145
    //   130: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: aload_2
    //   134: invokevirtual 73	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   137: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   143: aload_2
    //   144: invokestatic 113	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   147: aload_0
    //   148: ifnull +34 -> 182
    //   151: aload_0
    //   152: invokeinterface 108 1 0
    //   157: aconst_null
    //   158: areturn
    //   159: astore_0
    //   160: aconst_null
    //   161: astore_1
    //   162: aload_1
    //   163: ifnull +9 -> 172
    //   166: aload_1
    //   167: invokeinterface 108 1 0
    //   172: aload_0
    //   173: athrow
    //   174: astore_0
    //   175: goto -13 -> 162
    //   178: astore_2
    //   179: goto -63 -> 116
    //   182: aconst_null
    //   183: areturn
    //   184: aconst_null
    //   185: astore_1
    //   186: goto -87 -> 99
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	189	0	paramString	String
    //   58	128	1	localObject1	Object
    //   12	89	2	localObject2	Object
    //   113	31	2	localException1	Exception
    //   178	1	2	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   15	53	113	java/lang/Exception
    //   15	53	159	finally
    //   59	68	174	finally
    //   70	97	174	finally
    //   118	147	174	finally
    //   59	68	178	java/lang/Exception
    //   70	97	178	java/lang/Exception
  }
  
  /* Error */
  public static Map a()
  {
    // Byte code:
    //   0: new 148	java/util/HashMap
    //   3: dup
    //   4: invokespecial 149	java/util/HashMap:<init>	()V
    //   7: astore_3
    //   8: invokestatic 39	com/tencent/qphone/base/util/BaseApplication:getContext	()Landroid/content/Context;
    //   11: invokevirtual 45	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   14: getstatic 50	com/tencent/common/config/provider/QZoneConfigProvider:a	Landroid/net/Uri;
    //   17: aconst_null
    //   18: aconst_null
    //   19: aconst_null
    //   20: aconst_null
    //   21: invokevirtual 90	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   24: astore_2
    //   25: aload_2
    //   26: ifnull +120 -> 146
    //   29: aload_2
    //   30: astore_1
    //   31: aload_2
    //   32: invokeinterface 96 1 0
    //   37: ifeq +109 -> 146
    //   40: aload_2
    //   41: astore_1
    //   42: ldc 19
    //   44: iconst_1
    //   45: new 62	java/lang/StringBuilder
    //   48: dup
    //   49: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   52: ldc 151
    //   54: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: aload_2
    //   58: invokeinterface 155 1 0
    //   63: invokevirtual 158	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   66: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   69: invokestatic 161	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   72: aload_2
    //   73: astore_1
    //   74: aload_3
    //   75: new 54	java/lang/String
    //   78: dup
    //   79: aload_2
    //   80: aload_2
    //   81: ldc 141
    //   83: invokeinterface 101 2 0
    //   88: invokeinterface 121 2 0
    //   93: invokevirtual 125	java/lang/String:getBytes	()[B
    //   96: ldc 127
    //   98: invokespecial 130	java/lang/String:<init>	([BLjava/lang/String;)V
    //   101: aload_2
    //   102: aload_2
    //   103: ldc 143
    //   105: invokeinterface 101 2 0
    //   110: invokeinterface 165 2 0
    //   115: invokeinterface 171 3 0
    //   120: pop
    //   121: aload_2
    //   122: astore_1
    //   123: aload_2
    //   124: invokeinterface 174 1 0
    //   129: istore_0
    //   130: iload_0
    //   131: ifne -59 -> 72
    //   134: aload_2
    //   135: ifnull +9 -> 144
    //   138: aload_2
    //   139: invokeinterface 108 1 0
    //   144: aload_3
    //   145: areturn
    //   146: aload_2
    //   147: astore_1
    //   148: ldc 19
    //   150: iconst_1
    //   151: ldc 176
    //   153: invokestatic 161	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   156: goto -22 -> 134
    //   159: astore_3
    //   160: aload_2
    //   161: astore_1
    //   162: ldc 19
    //   164: iconst_1
    //   165: new 62	java/lang/StringBuilder
    //   168: dup
    //   169: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   172: ldc 178
    //   174: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: aload_3
    //   178: invokevirtual 73	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   181: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   187: aload_3
    //   188: invokestatic 180	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   191: aload_2
    //   192: ifnull +9 -> 201
    //   195: aload_2
    //   196: invokeinterface 108 1 0
    //   201: aconst_null
    //   202: areturn
    //   203: astore_2
    //   204: aconst_null
    //   205: astore_1
    //   206: aload_1
    //   207: ifnull +9 -> 216
    //   210: aload_1
    //   211: invokeinterface 108 1 0
    //   216: aload_2
    //   217: athrow
    //   218: astore_2
    //   219: goto -13 -> 206
    //   222: astore_3
    //   223: aconst_null
    //   224: astore_2
    //   225: goto -65 -> 160
    // Local variable table:
    //   start	length	slot	name	signature
    //   129	2	0	bool	boolean
    //   30	181	1	localCursor1	android.database.Cursor
    //   24	172	2	localCursor2	android.database.Cursor
    //   203	14	2	localObject1	Object
    //   218	1	2	localObject2	Object
    //   224	1	2	localObject3	Object
    //   7	138	3	localHashMap	HashMap
    //   159	29	3	localException1	Exception
    //   222	1	3	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   31	40	159	java/lang/Exception
    //   42	72	159	java/lang/Exception
    //   74	121	159	java/lang/Exception
    //   123	130	159	java/lang/Exception
    //   148	156	159	java/lang/Exception
    //   8	25	203	finally
    //   31	40	218	finally
    //   42	72	218	finally
    //   74	121	218	finally
    //   123	130	218	finally
    //   148	156	218	finally
    //   162	191	218	finally
    //   8	25	222	java/lang/Exception
  }
  
  public static Map a(String paramString)
  {
    if ((paramString == null) || (TextUtils.getTrimmedLength(paramString) <= 0)) {}
    do
    {
      return null;
      localObject = a(paramString);
    } while ((localObject == null) || (localObject.length <= 0));
    paramString = new UniAttribute();
    paramString.decode((byte[])localObject);
    Object localObject = new HashMap();
    Iterator localIterator = paramString.getKeySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      ((Map)localObject).put(str, (String)paramString.get(str));
    }
    return localObject;
  }
  
  private static void a()
  {
    try
    {
      BaseApplication.getContext().getContentResolver().delete(QZoneConfigProvider.d, null, null);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("ConfigProvider", 2, "database clear error" + localException.getMessage(), localException);
    }
  }
  
  public static void a(long paramLong)
  {
    if (paramLong <= 0L) {
      return;
    }
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("check_time", Long.valueOf(paramLong));
    QLog.d("ConfigProvider", 2, "saveIspCheckTime time:" + paramLong);
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
        QLog.e("ConfigProvider", 2, "saveIspCheckTime error :" + localSQLException.getMessage(), localSQLException);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("ConfigProvider", 2, "saveIspCheckTime error :" + localException.getMessage(), localException);
      }
    }
  }
  
  public static void a(String paramString)
  {
    ContentValues localContentValues = new ContentValues();
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    localContentValues.put("cookie", str);
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
      QLog.e("QZConfigProviderUtil", 1, "saveConfigCookie error!");
    }
  }
  
  private static void a(String paramString, Map paramMap) {}
  
  public static void a(Map paramMap)
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
  
  public static void a(Map paramMap, String paramString1, String paramString2)
  {
    b(paramMap);
    a(paramString1);
    a(paramString2);
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
      QLog.e("QZConfigProviderUtil", 1, "recUpdateSource error:" + paramString.getMessage(), paramString);
      return false;
    }
    catch (Exception paramString)
    {
      QLog.e("QZConfigProviderUtil", 1, "recUpdateSource error:" + paramString.getMessage(), paramString);
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
      QLog.e("ConfigProvider", 2, "insertUpdateIspConfigItem error:" + paramString1.getMessage(), paramString1);
      return false;
    }
    catch (Exception paramString1)
    {
      QLog.e("ConfigProvider", 2, "insertUpdateIspConfigItem error:" + paramString1.getMessage(), paramString1);
      return false;
    }
    finally
    {
      localContentValues.clear();
    }
  }
  
  /* Error */
  private static boolean a(String paramString, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +10 -> 11
    //   4: aload_0
    //   5: invokestatic 33	android/text/TextUtils:getTrimmedLength	(Ljava/lang/CharSequence;)I
    //   8: ifgt +5 -> 13
    //   11: iconst_0
    //   12: ireturn
    //   13: aload_1
    //   14: arraylength
    //   15: ifle -4 -> 11
    //   18: new 223	android/content/ContentValues
    //   21: dup
    //   22: invokespecial 224	android/content/ContentValues:<init>	()V
    //   25: astore_2
    //   26: aload_2
    //   27: ldc 141
    //   29: aload_0
    //   30: invokevirtual 254	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   33: aload_2
    //   34: ldc 143
    //   36: aload_1
    //   37: invokevirtual 297	android/content/ContentValues:put	(Ljava/lang/String;[B)V
    //   40: invokestatic 39	com/tencent/qphone/base/util/BaseApplication:getContext	()Landroid/content/Context;
    //   43: invokevirtual 45	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   46: getstatic 50	com/tencent/common/config/provider/QZoneConfigProvider:a	Landroid/net/Uri;
    //   49: aload_2
    //   50: invokevirtual 244	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   53: astore_0
    //   54: aload_0
    //   55: ifnull +38 -> 93
    //   58: ldc 19
    //   60: iconst_1
    //   61: new 62	java/lang/StringBuilder
    //   64: dup
    //   65: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   68: aload_0
    //   69: invokevirtual 257	android/net/Uri:toString	()Ljava/lang/String;
    //   72: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: ldc_w 299
    //   78: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   84: invokestatic 161	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   87: aload_2
    //   88: invokevirtual 247	android/content/ContentValues:clear	()V
    //   91: iconst_1
    //   92: ireturn
    //   93: ldc 19
    //   95: iconst_1
    //   96: ldc_w 301
    //   99: invokestatic 161	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   102: goto -15 -> 87
    //   105: astore_0
    //   106: ldc 19
    //   108: iconst_1
    //   109: new 62	java/lang/StringBuilder
    //   112: dup
    //   113: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   116: ldc_w 303
    //   119: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: aload_0
    //   123: invokevirtual 250	android/database/SQLException:getMessage	()Ljava/lang/String;
    //   126: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   132: invokestatic 82	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   135: aload_2
    //   136: invokevirtual 247	android/content/ContentValues:clear	()V
    //   139: iconst_0
    //   140: ireturn
    //   141: astore_0
    //   142: ldc 19
    //   144: iconst_1
    //   145: new 62	java/lang/StringBuilder
    //   148: dup
    //   149: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   152: ldc_w 303
    //   155: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: aload_0
    //   159: invokevirtual 73	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   162: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   168: invokestatic 82	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   171: aload_2
    //   172: invokevirtual 247	android/content/ContentValues:clear	()V
    //   175: iconst_0
    //   176: ireturn
    //   177: astore_0
    //   178: aload_2
    //   179: invokevirtual 247	android/content/ContentValues:clear	()V
    //   182: aload_0
    //   183: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	184	0	paramString	String
    //   0	184	1	paramArrayOfByte	byte[]
    //   25	154	2	localContentValues	ContentValues
    // Exception table:
    //   from	to	target	type
    //   40	54	105	android/database/SQLException
    //   58	87	105	android/database/SQLException
    //   93	102	105	android/database/SQLException
    //   40	54	141	java/lang/Exception
    //   58	87	141	java/lang/Exception
    //   93	102	141	java/lang/Exception
    //   40	54	177	finally
    //   58	87	177	finally
    //   93	102	177	finally
    //   106	135	177	finally
    //   142	171	177	finally
  }
  
  /* Error */
  private static byte[] a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +10 -> 11
    //   4: aload_0
    //   5: invokestatic 33	android/text/TextUtils:getTrimmedLength	(Ljava/lang/CharSequence;)I
    //   8: ifgt +7 -> 15
    //   11: aconst_null
    //   12: astore_2
    //   13: aload_2
    //   14: areturn
    //   15: invokestatic 39	com/tencent/qphone/base/util/BaseApplication:getContext	()Landroid/content/Context;
    //   18: invokevirtual 45	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   21: getstatic 50	com/tencent/common/config/provider/QZoneConfigProvider:a	Landroid/net/Uri;
    //   24: iconst_2
    //   25: anewarray 54	java/lang/String
    //   28: dup
    //   29: iconst_0
    //   30: ldc 141
    //   32: aastore
    //   33: dup
    //   34: iconst_1
    //   35: ldc 143
    //   37: aastore
    //   38: ldc 52
    //   40: iconst_1
    //   41: anewarray 54	java/lang/String
    //   44: dup
    //   45: iconst_0
    //   46: aload_0
    //   47: aastore
    //   48: aconst_null
    //   49: invokevirtual 90	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   52: astore_0
    //   53: aload_0
    //   54: ifnull +118 -> 172
    //   57: aload_0
    //   58: astore_1
    //   59: aload_0
    //   60: invokeinterface 96 1 0
    //   65: ifeq +107 -> 172
    //   68: aload_0
    //   69: astore_1
    //   70: aload_0
    //   71: aload_0
    //   72: ldc 143
    //   74: invokeinterface 101 2 0
    //   79: invokeinterface 165 2 0
    //   84: astore_2
    //   85: aload_2
    //   86: astore_1
    //   87: aload_1
    //   88: astore_2
    //   89: aload_0
    //   90: ifnull -77 -> 13
    //   93: aload_0
    //   94: invokeinterface 108 1 0
    //   99: aload_1
    //   100: areturn
    //   101: astore_2
    //   102: aconst_null
    //   103: astore_0
    //   104: aload_0
    //   105: astore_1
    //   106: ldc 16
    //   108: iconst_2
    //   109: new 62	java/lang/StringBuilder
    //   112: dup
    //   113: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   116: ldc_w 305
    //   119: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: aload_2
    //   123: invokevirtual 73	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   126: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   132: invokestatic 82	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   135: aload_0
    //   136: ifnull +34 -> 170
    //   139: aload_0
    //   140: invokeinterface 108 1 0
    //   145: aconst_null
    //   146: areturn
    //   147: astore_0
    //   148: aconst_null
    //   149: astore_1
    //   150: aload_1
    //   151: ifnull +9 -> 160
    //   154: aload_1
    //   155: invokeinterface 108 1 0
    //   160: aload_0
    //   161: athrow
    //   162: astore_0
    //   163: goto -13 -> 150
    //   166: astore_2
    //   167: goto -63 -> 104
    //   170: aconst_null
    //   171: areturn
    //   172: aconst_null
    //   173: astore_1
    //   174: goto -87 -> 87
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	177	0	paramString	String
    //   58	116	1	localObject1	Object
    //   12	77	2	localObject2	Object
    //   101	22	2	localException1	Exception
    //   166	1	2	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   15	53	101	java/lang/Exception
    //   15	53	147	finally
    //   59	68	162	finally
    //   70	85	162	finally
    //   106	135	162	finally
    //   59	68	166	java/lang/Exception
    //   70	85	166	java/lang/Exception
  }
  
  private static int b(String paramString)
  {
    if ((paramString == null) || (TextUtils.getTrimmedLength(paramString) <= 0)) {
      return 0;
    }
    try
    {
      int i = BaseApplication.getContext().getContentResolver().delete(QZoneConfigProvider.e, "key=?", new String[] { paramString });
      return i;
    }
    catch (Exception paramString)
    {
      QLog.e("ConfigProvider", 2, "deleteOneIspConfig error:" + paramString.getMessage());
    }
    return 0;
  }
  
  /* Error */
  public static String b()
  {
    // Byte code:
    //   0: invokestatic 39	com/tencent/qphone/base/util/BaseApplication:getContext	()Landroid/content/Context;
    //   3: invokevirtual 45	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   6: getstatic 289	com/tencent/common/config/provider/QZoneConfigProvider:c	Landroid/net/Uri;
    //   9: aconst_null
    //   10: aconst_null
    //   11: aconst_null
    //   12: aconst_null
    //   13: invokevirtual 90	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   16: astore_0
    //   17: aload_0
    //   18: ifnull +120 -> 138
    //   21: aload_0
    //   22: astore_1
    //   23: aload_0
    //   24: invokeinterface 96 1 0
    //   29: ifeq +109 -> 138
    //   32: aload_0
    //   33: astore_1
    //   34: aload_0
    //   35: aload_0
    //   36: ldc_w 287
    //   39: invokeinterface 101 2 0
    //   44: invokeinterface 121 2 0
    //   49: astore_2
    //   50: aload_2
    //   51: astore_1
    //   52: aload_0
    //   53: ifnull +9 -> 62
    //   56: aload_0
    //   57: invokeinterface 108 1 0
    //   62: aload_1
    //   63: areturn
    //   64: astore_2
    //   65: aconst_null
    //   66: astore_0
    //   67: aload_0
    //   68: astore_1
    //   69: ldc 16
    //   71: iconst_2
    //   72: new 62	java/lang/StringBuilder
    //   75: dup
    //   76: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   79: ldc_w 309
    //   82: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: aload_2
    //   86: invokevirtual 73	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   89: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   95: aload_2
    //   96: invokestatic 113	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   99: aload_0
    //   100: ifnull +35 -> 135
    //   103: aload_0
    //   104: invokeinterface 108 1 0
    //   109: ldc 132
    //   111: areturn
    //   112: astore_0
    //   113: aconst_null
    //   114: astore_1
    //   115: aload_1
    //   116: ifnull +9 -> 125
    //   119: aload_1
    //   120: invokeinterface 108 1 0
    //   125: aload_0
    //   126: athrow
    //   127: astore_0
    //   128: goto -13 -> 115
    //   131: astore_2
    //   132: goto -65 -> 67
    //   135: ldc 132
    //   137: areturn
    //   138: ldc 132
    //   140: astore_1
    //   141: goto -89 -> 52
    // Local variable table:
    //   start	length	slot	name	signature
    //   16	88	0	localCursor	android.database.Cursor
    //   112	14	0	localObject1	Object
    //   127	1	0	localObject2	Object
    //   22	119	1	localObject3	Object
    //   49	2	2	str	String
    //   64	32	2	localException1	Exception
    //   131	1	2	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   0	17	64	java/lang/Exception
    //   0	17	112	finally
    //   23	32	127	finally
    //   34	50	127	finally
    //   69	99	127	finally
    //   23	32	131	java/lang/Exception
    //   34	50	131	java/lang/Exception
  }
  
  /* Error */
  public static Map b()
  {
    // Byte code:
    //   0: new 148	java/util/HashMap
    //   3: dup
    //   4: invokespecial 149	java/util/HashMap:<init>	()V
    //   7: astore_3
    //   8: invokestatic 39	com/tencent/qphone/base/util/BaseApplication:getContext	()Landroid/content/Context;
    //   11: invokevirtual 45	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   14: getstatic 139	com/tencent/common/config/provider/QZoneConfigProvider:e	Landroid/net/Uri;
    //   17: aconst_null
    //   18: aconst_null
    //   19: aconst_null
    //   20: aconst_null
    //   21: invokevirtual 90	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   24: astore_2
    //   25: aload_2
    //   26: ifnull +88 -> 114
    //   29: aload_2
    //   30: astore_1
    //   31: aload_2
    //   32: invokeinterface 96 1 0
    //   37: ifeq +77 -> 114
    //   40: aload_2
    //   41: astore_1
    //   42: aload_3
    //   43: new 54	java/lang/String
    //   46: dup
    //   47: aload_2
    //   48: aload_2
    //   49: ldc 141
    //   51: invokeinterface 101 2 0
    //   56: invokeinterface 121 2 0
    //   61: invokevirtual 125	java/lang/String:getBytes	()[B
    //   64: ldc 127
    //   66: invokespecial 130	java/lang/String:<init>	([BLjava/lang/String;)V
    //   69: new 54	java/lang/String
    //   72: dup
    //   73: aload_2
    //   74: aload_2
    //   75: ldc 143
    //   77: invokeinterface 101 2 0
    //   82: invokeinterface 121 2 0
    //   87: invokevirtual 125	java/lang/String:getBytes	()[B
    //   90: ldc 127
    //   92: invokespecial 130	java/lang/String:<init>	([BLjava/lang/String;)V
    //   95: invokeinterface 171 3 0
    //   100: pop
    //   101: aload_2
    //   102: astore_1
    //   103: aload_2
    //   104: invokeinterface 174 1 0
    //   109: istore_0
    //   110: iload_0
    //   111: ifne -71 -> 40
    //   114: aload_2
    //   115: ifnull +9 -> 124
    //   118: aload_2
    //   119: invokeinterface 108 1 0
    //   124: aload_3
    //   125: areturn
    //   126: astore_3
    //   127: aconst_null
    //   128: astore_2
    //   129: aload_2
    //   130: astore_1
    //   131: ldc 16
    //   133: iconst_2
    //   134: new 62	java/lang/StringBuilder
    //   137: dup
    //   138: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   141: ldc 178
    //   143: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: aload_3
    //   147: invokevirtual 73	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   150: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   156: aload_3
    //   157: invokestatic 113	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   160: aload_2
    //   161: ifnull +9 -> 170
    //   164: aload_2
    //   165: invokeinterface 108 1 0
    //   170: aconst_null
    //   171: areturn
    //   172: astore_2
    //   173: aconst_null
    //   174: astore_1
    //   175: aload_1
    //   176: ifnull +9 -> 185
    //   179: aload_1
    //   180: invokeinterface 108 1 0
    //   185: aload_2
    //   186: athrow
    //   187: astore_2
    //   188: goto -13 -> 175
    //   191: astore_3
    //   192: goto -63 -> 129
    // Local variable table:
    //   start	length	slot	name	signature
    //   109	2	0	bool	boolean
    //   30	150	1	localCursor1	android.database.Cursor
    //   24	141	2	localCursor2	android.database.Cursor
    //   172	14	2	localObject1	Object
    //   187	1	2	localObject2	Object
    //   7	118	3	localHashMap	HashMap
    //   126	31	3	localException1	Exception
    //   191	1	3	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   8	25	126	java/lang/Exception
    //   8	25	172	finally
    //   31	40	187	finally
    //   42	101	187	finally
    //   103	110	187	finally
    //   131	160	187	finally
    //   31	40	191	java/lang/Exception
    //   42	101	191	java/lang/Exception
    //   103	110	191	java/lang/Exception
  }
  
  private static void b()
  {
    try
    {
      BaseApplication.getContext().getContentResolver().delete(QZoneConfigProvider.b, null, null);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("ConfigProvider", 2, "deleteCookie error " + localException.getMessage(), localException);
    }
  }
  
  private static void b(Map paramMap)
  {
    if (paramMap == null) {}
    for (;;)
    {
      return;
      if (!paramMap.isEmpty())
      {
        a("saveConfig", paramMap);
        Object localObject = paramMap.keySet();
        QLog.i("QZConfigProviderUtil", 1, "saveConfig mainkey:" + ((Set)localObject).size());
        localObject = ((Set)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          a(str, (byte[])paramMap.get(str));
        }
      }
    }
  }
  
  private static void c()
  {
    try
    {
      BaseApplication.getContext().getContentResolver().delete(QZoneConfigProvider.f, null, null);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("ConfigProvider", 2, "deleteIspCheckTime error" + localException.getMessage(), localException);
    }
  }
  
  private static void d()
  {
    try
    {
      BaseApplication.getContext().getContentResolver().delete(QZoneConfigProvider.a, null, null);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("ConfigProvider", 2, "deleteConfig error" + localException.getMessage(), localException);
    }
  }
  
  private static void e()
  {
    try
    {
      BaseApplication.getContext().getContentResolver().delete(QZoneConfigProvider.e, null, null);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("ConfigProvider", 2, "deleteIspConfig error " + localException.getMessage(), localException);
    }
  }
  
  private static void f()
  {
    try
    {
      BaseApplication.getContext().getContentResolver().delete(QZoneConfigProvider.c, null, null);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("ConfigProvider", 2, "deleteLastUpdateLog error " + localException.getMessage(), localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.common.config.provider.QZConfigProviderUtil
 * JD-Core Version:    0.7.0.1
 */