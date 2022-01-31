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
import common.config.service.QzoneConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class QZConfigProviderUtil
{
  public static final String a = "TimeMonitor";
  public static final boolean a = false;
  public static final String b = "unknow";
  public static final String c = "ConfigProvider";
  public static final String d = "NavigationBar";
  private static final String e = "QZConfigProviderUtil";
  
  private static int a(String paramString)
  {
    if ((paramString == null) || (TextUtils.getTrimmedLength(paramString) <= 0)) {}
    do
    {
      return 0;
      try
      {
        int i = BaseApplication.getContext().getContentResolver().delete(QZoneConfigProvider.e, "key=?", new String[] { paramString });
        return i;
      }
      catch (Exception paramString) {}
    } while (!QLog.isColorLevel());
    QLog.e("QZConfigProviderUtil", 2, "deleteOneIspConfig error:" + paramString.getMessage());
    return 0;
  }
  
  private static int a(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (TextUtils.getTrimmedLength(paramString1) <= 0)) {}
    do
    {
      do
      {
        return 0;
      } while ((paramString2 == null) || (TextUtils.getTrimmedLength(paramString2) <= 0));
      try
      {
        int i = BaseApplication.getContext().getContentResolver().delete(QZoneConfigProvider.a, "main_key=? and second_key=? ", new String[] { paramString1, paramString2 });
        return i;
      }
      catch (Exception paramString1) {}
    } while (!QLog.isColorLevel());
    QLog.e("QZConfigProviderUtil", 2, "deleteOneConfig error:" + paramString1.getMessage());
    return 0;
  }
  
  /* Error */
  public static long a()
  {
    // Byte code:
    //   0: invokestatic 42	com/tencent/qphone/base/util/BaseApplication:getContext	()Landroid/content/Context;
    //   3: invokevirtual 48	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   6: getstatic 99	com/tencent/common/config/provider/QZoneConfigProvider:f	Landroid/net/Uri;
    //   9: aconst_null
    //   10: aconst_null
    //   11: aconst_null
    //   12: aconst_null
    //   13: invokevirtual 103	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   16: astore_2
    //   17: aload_2
    //   18: ifnull +39 -> 57
    //   21: aload_2
    //   22: invokeinterface 108 1 0
    //   27: ifeq +30 -> 57
    //   30: aload_2
    //   31: aload_2
    //   32: ldc 110
    //   34: invokeinterface 113 2 0
    //   39: invokeinterface 117 2 0
    //   44: lstore_0
    //   45: aload_2
    //   46: ifnull +9 -> 55
    //   49: aload_2
    //   50: invokeinterface 120 1 0
    //   55: lload_0
    //   56: lreturn
    //   57: aload_2
    //   58: ifnull +9 -> 67
    //   61: aload_2
    //   62: invokeinterface 120 1 0
    //   67: lconst_0
    //   68: lreturn
    //   69: astore_3
    //   70: aconst_null
    //   71: astore_2
    //   72: invokestatic 69	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   75: ifeq +32 -> 107
    //   78: ldc 22
    //   80: iconst_2
    //   81: new 71	java/lang/StringBuilder
    //   84: dup
    //   85: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   88: ldc 122
    //   90: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: aload_3
    //   94: invokevirtual 82	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   97: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   103: aload_3
    //   104: invokestatic 125	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   107: aload_2
    //   108: ifnull -41 -> 67
    //   111: aload_2
    //   112: invokeinterface 120 1 0
    //   117: goto -50 -> 67
    //   120: astore_3
    //   121: aconst_null
    //   122: astore_2
    //   123: aload_2
    //   124: ifnull +9 -> 133
    //   127: aload_2
    //   128: invokeinterface 120 1 0
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
  
  /* Error */
  public static String a()
  {
    // Byte code:
    //   0: invokestatic 42	com/tencent/qphone/base/util/BaseApplication:getContext	()Landroid/content/Context;
    //   3: invokevirtual 48	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   6: getstatic 127	com/tencent/common/config/provider/QZoneConfigProvider:b	Landroid/net/Uri;
    //   9: aconst_null
    //   10: aconst_null
    //   11: aconst_null
    //   12: aconst_null
    //   13: invokevirtual 103	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   16: astore_1
    //   17: aload_1
    //   18: ifnull +55 -> 73
    //   21: aload_1
    //   22: astore_0
    //   23: aload_1
    //   24: invokeinterface 108 1 0
    //   29: ifeq +44 -> 73
    //   32: aload_1
    //   33: astore_0
    //   34: new 57	java/lang/String
    //   37: dup
    //   38: aload_1
    //   39: aload_1
    //   40: ldc 129
    //   42: invokeinterface 113 2 0
    //   47: invokeinterface 133 2 0
    //   52: invokevirtual 137	java/lang/String:getBytes	()[B
    //   55: ldc 139
    //   57: invokespecial 142	java/lang/String:<init>	([BLjava/lang/String;)V
    //   60: astore_2
    //   61: aload_1
    //   62: ifnull +9 -> 71
    //   65: aload_1
    //   66: invokeinterface 120 1 0
    //   71: aload_2
    //   72: areturn
    //   73: aload_1
    //   74: ifnull +9 -> 83
    //   77: aload_1
    //   78: invokeinterface 120 1 0
    //   83: ldc 144
    //   85: areturn
    //   86: astore_2
    //   87: aconst_null
    //   88: astore_1
    //   89: aload_1
    //   90: astore_0
    //   91: invokestatic 69	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   94: ifeq +34 -> 128
    //   97: aload_1
    //   98: astore_0
    //   99: ldc 22
    //   101: iconst_2
    //   102: new 71	java/lang/StringBuilder
    //   105: dup
    //   106: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   109: ldc 146
    //   111: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: aload_2
    //   115: invokevirtual 82	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   118: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   124: aload_2
    //   125: invokestatic 148	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   128: aload_1
    //   129: ifnull -46 -> 83
    //   132: aload_1
    //   133: invokeinterface 120 1 0
    //   138: goto -55 -> 83
    //   141: astore_1
    //   142: aconst_null
    //   143: astore_0
    //   144: aload_0
    //   145: ifnull +9 -> 154
    //   148: aload_0
    //   149: invokeinterface 120 1 0
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
  private static String a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +10 -> 11
    //   4: aload_0
    //   5: invokestatic 36	android/text/TextUtils:getTrimmedLength	(Ljava/lang/CharSequence;)I
    //   8: ifgt +7 -> 15
    //   11: aconst_null
    //   12: astore_2
    //   13: aload_2
    //   14: areturn
    //   15: invokestatic 42	com/tencent/qphone/base/util/BaseApplication:getContext	()Landroid/content/Context;
    //   18: invokevirtual 48	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   21: getstatic 53	com/tencent/common/config/provider/QZoneConfigProvider:e	Landroid/net/Uri;
    //   24: aconst_null
    //   25: ldc 55
    //   27: iconst_1
    //   28: anewarray 57	java/lang/String
    //   31: dup
    //   32: iconst_0
    //   33: aload_0
    //   34: aastore
    //   35: aconst_null
    //   36: invokevirtual 103	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   39: astore_0
    //   40: aload_0
    //   41: ifnull +138 -> 179
    //   44: aload_0
    //   45: astore_1
    //   46: aload_0
    //   47: invokeinterface 108 1 0
    //   52: ifeq +127 -> 179
    //   55: aload_0
    //   56: astore_1
    //   57: new 57	java/lang/String
    //   60: dup
    //   61: aload_0
    //   62: aload_0
    //   63: ldc 151
    //   65: invokeinterface 113 2 0
    //   70: invokeinterface 133 2 0
    //   75: invokevirtual 137	java/lang/String:getBytes	()[B
    //   78: ldc 139
    //   80: invokespecial 142	java/lang/String:<init>	([BLjava/lang/String;)V
    //   83: astore_2
    //   84: aload_2
    //   85: astore_1
    //   86: aload_1
    //   87: astore_2
    //   88: aload_0
    //   89: ifnull -76 -> 13
    //   92: aload_0
    //   93: invokeinterface 120 1 0
    //   98: aload_1
    //   99: areturn
    //   100: astore_2
    //   101: aconst_null
    //   102: astore_0
    //   103: aload_0
    //   104: astore_1
    //   105: invokestatic 69	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   108: ifeq +34 -> 142
    //   111: aload_0
    //   112: astore_1
    //   113: ldc 22
    //   115: iconst_2
    //   116: new 71	java/lang/StringBuilder
    //   119: dup
    //   120: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   123: ldc 153
    //   125: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: aload_2
    //   129: invokevirtual 82	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   132: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   138: aload_2
    //   139: invokestatic 125	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   142: aload_0
    //   143: ifnull +34 -> 177
    //   146: aload_0
    //   147: invokeinterface 120 1 0
    //   152: aconst_null
    //   153: areturn
    //   154: astore_0
    //   155: aconst_null
    //   156: astore_1
    //   157: aload_1
    //   158: ifnull +9 -> 167
    //   161: aload_1
    //   162: invokeinterface 120 1 0
    //   167: aload_0
    //   168: athrow
    //   169: astore_0
    //   170: goto -13 -> 157
    //   173: astore_2
    //   174: goto -71 -> 103
    //   177: aconst_null
    //   178: areturn
    //   179: aconst_null
    //   180: astore_1
    //   181: goto -95 -> 86
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	184	0	paramString	String
    //   45	136	1	localObject1	Object
    //   12	76	2	localObject2	Object
    //   100	39	2	localException1	Exception
    //   173	1	2	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   15	40	100	java/lang/Exception
    //   15	40	154	finally
    //   46	55	169	finally
    //   57	84	169	finally
    //   105	111	169	finally
    //   113	142	169	finally
    //   46	55	173	java/lang/Exception
    //   57	84	173	java/lang/Exception
  }
  
  /* Error */
  public static String a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +10 -> 11
    //   4: aload_0
    //   5: invokestatic 36	android/text/TextUtils:getTrimmedLength	(Ljava/lang/CharSequence;)I
    //   8: ifgt +5 -> 13
    //   11: aconst_null
    //   12: areturn
    //   13: aload_1
    //   14: ifnull -3 -> 11
    //   17: aload_1
    //   18: invokestatic 36	android/text/TextUtils:getTrimmedLength	(Ljava/lang/CharSequence;)I
    //   21: ifle -10 -> 11
    //   24: invokestatic 42	com/tencent/qphone/base/util/BaseApplication:getContext	()Landroid/content/Context;
    //   27: invokevirtual 48	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   30: getstatic 91	com/tencent/common/config/provider/QZoneConfigProvider:a	Landroid/net/Uri;
    //   33: aconst_null
    //   34: ldc 156
    //   36: iconst_2
    //   37: anewarray 57	java/lang/String
    //   40: dup
    //   41: iconst_0
    //   42: aload_0
    //   43: aastore
    //   44: dup
    //   45: iconst_1
    //   46: aload_1
    //   47: aastore
    //   48: aconst_null
    //   49: invokevirtual 103	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   52: astore_0
    //   53: aload_0
    //   54: ifnull +133 -> 187
    //   57: aload_0
    //   58: astore_1
    //   59: aload_0
    //   60: invokeinterface 108 1 0
    //   65: ifeq +122 -> 187
    //   68: aload_0
    //   69: astore_1
    //   70: aload_0
    //   71: aload_0
    //   72: ldc 151
    //   74: invokeinterface 113 2 0
    //   79: invokeinterface 133 2 0
    //   84: astore_2
    //   85: aload_2
    //   86: astore_1
    //   87: aload_1
    //   88: astore_2
    //   89: aload_0
    //   90: ifnull +11 -> 101
    //   93: aload_0
    //   94: invokeinterface 120 1 0
    //   99: aload_1
    //   100: astore_2
    //   101: aload_2
    //   102: areturn
    //   103: astore_2
    //   104: aconst_null
    //   105: astore_0
    //   106: aload_0
    //   107: astore_1
    //   108: invokestatic 69	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   111: ifeq +33 -> 144
    //   114: aload_0
    //   115: astore_1
    //   116: ldc 22
    //   118: iconst_2
    //   119: new 71	java/lang/StringBuilder
    //   122: dup
    //   123: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   126: ldc 158
    //   128: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: aload_2
    //   132: invokevirtual 82	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   135: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   141: invokestatic 88	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   144: aload_0
    //   145: ifnull +37 -> 182
    //   148: aload_0
    //   149: invokeinterface 120 1 0
    //   154: aconst_null
    //   155: astore_2
    //   156: goto -55 -> 101
    //   159: astore_0
    //   160: aconst_null
    //   161: astore_1
    //   162: aload_1
    //   163: ifnull +9 -> 172
    //   166: aload_1
    //   167: invokeinterface 120 1 0
    //   172: aload_0
    //   173: athrow
    //   174: astore_0
    //   175: goto -13 -> 162
    //   178: astore_2
    //   179: goto -73 -> 106
    //   182: aconst_null
    //   183: astore_2
    //   184: goto -83 -> 101
    //   187: aconst_null
    //   188: astore_1
    //   189: goto -102 -> 87
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	192	0	paramString1	String
    //   0	192	1	paramString2	String
    //   84	18	2	str	String
    //   103	29	2	localException1	Exception
    //   155	1	2	localObject1	Object
    //   178	1	2	localException2	Exception
    //   183	1	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   24	53	103	java/lang/Exception
    //   24	53	159	finally
    //   59	68	174	finally
    //   70	85	174	finally
    //   108	114	174	finally
    //   116	144	174	finally
    //   59	68	178	java/lang/Exception
    //   70	85	178	java/lang/Exception
  }
  
  /* Error */
  public static Map a()
  {
    // Byte code:
    //   0: new 161	java/util/HashMap
    //   3: dup
    //   4: invokespecial 162	java/util/HashMap:<init>	()V
    //   7: astore_3
    //   8: invokestatic 42	com/tencent/qphone/base/util/BaseApplication:getContext	()Landroid/content/Context;
    //   11: invokevirtual 48	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   14: getstatic 53	com/tencent/common/config/provider/QZoneConfigProvider:e	Landroid/net/Uri;
    //   17: aconst_null
    //   18: aconst_null
    //   19: aconst_null
    //   20: aconst_null
    //   21: invokevirtual 103	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   24: astore_2
    //   25: aload_2
    //   26: ifnull +88 -> 114
    //   29: aload_2
    //   30: astore_1
    //   31: aload_2
    //   32: invokeinterface 108 1 0
    //   37: ifeq +77 -> 114
    //   40: aload_2
    //   41: astore_1
    //   42: aload_3
    //   43: new 57	java/lang/String
    //   46: dup
    //   47: aload_2
    //   48: aload_2
    //   49: ldc 164
    //   51: invokeinterface 113 2 0
    //   56: invokeinterface 133 2 0
    //   61: invokevirtual 137	java/lang/String:getBytes	()[B
    //   64: ldc 139
    //   66: invokespecial 142	java/lang/String:<init>	([BLjava/lang/String;)V
    //   69: new 57	java/lang/String
    //   72: dup
    //   73: aload_2
    //   74: aload_2
    //   75: ldc 151
    //   77: invokeinterface 113 2 0
    //   82: invokeinterface 133 2 0
    //   87: invokevirtual 137	java/lang/String:getBytes	()[B
    //   90: ldc 139
    //   92: invokespecial 142	java/lang/String:<init>	([BLjava/lang/String;)V
    //   95: invokeinterface 170 3 0
    //   100: pop
    //   101: aload_2
    //   102: astore_1
    //   103: aload_2
    //   104: invokeinterface 173 1 0
    //   109: istore_0
    //   110: iload_0
    //   111: ifne -71 -> 40
    //   114: aload_2
    //   115: ifnull +9 -> 124
    //   118: aload_2
    //   119: invokeinterface 120 1 0
    //   124: aload_3
    //   125: areturn
    //   126: astore_3
    //   127: aconst_null
    //   128: astore_2
    //   129: aload_2
    //   130: astore_1
    //   131: invokestatic 69	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   134: ifeq +34 -> 168
    //   137: aload_2
    //   138: astore_1
    //   139: ldc 22
    //   141: iconst_2
    //   142: new 71	java/lang/StringBuilder
    //   145: dup
    //   146: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   149: ldc 175
    //   151: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: aload_3
    //   155: invokevirtual 82	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   158: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   164: aload_3
    //   165: invokestatic 125	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   168: aload_2
    //   169: ifnull +9 -> 178
    //   172: aload_2
    //   173: invokeinterface 120 1 0
    //   178: aconst_null
    //   179: areturn
    //   180: astore_2
    //   181: aconst_null
    //   182: astore_1
    //   183: aload_1
    //   184: ifnull +9 -> 193
    //   187: aload_1
    //   188: invokeinterface 120 1 0
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
  
  private static void a()
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
    if ((b("PhotoUpload")) && (b("PhotoSvrList"))) {
      a(paramString1);
    }
    for (;;)
    {
      a(paramString2);
      return;
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
  public static String b()
  {
    // Byte code:
    //   0: invokestatic 42	com/tencent/qphone/base/util/BaseApplication:getContext	()Landroid/content/Context;
    //   3: invokevirtual 48	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   6: getstatic 275	com/tencent/common/config/provider/QZoneConfigProvider:c	Landroid/net/Uri;
    //   9: aconst_null
    //   10: aconst_null
    //   11: aconst_null
    //   12: aconst_null
    //   13: invokevirtual 103	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   16: astore_0
    //   17: aload_0
    //   18: ifnull +128 -> 146
    //   21: aload_0
    //   22: astore_1
    //   23: aload_0
    //   24: invokeinterface 108 1 0
    //   29: ifeq +117 -> 146
    //   32: aload_0
    //   33: astore_1
    //   34: aload_0
    //   35: aload_0
    //   36: ldc_w 273
    //   39: invokeinterface 113 2 0
    //   44: invokeinterface 133 2 0
    //   49: astore_2
    //   50: aload_2
    //   51: astore_1
    //   52: aload_0
    //   53: ifnull +9 -> 62
    //   56: aload_0
    //   57: invokeinterface 120 1 0
    //   62: aload_1
    //   63: areturn
    //   64: astore_2
    //   65: aconst_null
    //   66: astore_0
    //   67: aload_0
    //   68: astore_1
    //   69: invokestatic 69	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   72: ifeq +35 -> 107
    //   75: aload_0
    //   76: astore_1
    //   77: ldc 22
    //   79: iconst_2
    //   80: new 71	java/lang/StringBuilder
    //   83: dup
    //   84: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   87: ldc_w 281
    //   90: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: aload_2
    //   94: invokevirtual 82	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   97: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   103: aload_2
    //   104: invokestatic 125	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   107: aload_0
    //   108: ifnull +35 -> 143
    //   111: aload_0
    //   112: invokeinterface 120 1 0
    //   117: ldc 144
    //   119: areturn
    //   120: astore_0
    //   121: aconst_null
    //   122: astore_1
    //   123: aload_1
    //   124: ifnull +9 -> 133
    //   127: aload_1
    //   128: invokeinterface 120 1 0
    //   133: aload_0
    //   134: athrow
    //   135: astore_0
    //   136: goto -13 -> 123
    //   139: astore_2
    //   140: goto -73 -> 67
    //   143: ldc 144
    //   145: areturn
    //   146: ldc 144
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
  
  private static void b()
  {
    try
    {
      BaseApplication.getContext().getContentResolver().delete(QZoneConfigProvider.b, null, null);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("QZConfigProviderUtil", 2, "deleteCookie error " + localException.getMessage(), localException);
    }
  }
  
  private static void b(Map paramMap)
  {
    if (paramMap == null) {}
    while (paramMap.isEmpty()) {
      return;
    }
    Object localObject1 = paramMap.keySet();
    QLog.i("QZConfigProviderUtil", 1, "saveConfig mainkey:" + ((Set)localObject1).size());
    ArrayList localArrayList = new ArrayList();
    localObject1 = ((Set)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      String str1 = (String)((Iterator)localObject1).next();
      Object localObject2 = (byte[])paramMap.get(str1);
      if ((str1 != null) && (localObject2 != null) && (localObject2.length > 0))
      {
        QLog.i("QZConfigProviderUtil", 1, "saveConfig mainKey:" + str1);
        UniAttribute localUniAttribute = new UniAttribute();
        if (str1.equalsIgnoreCase("NavigationBar")) {
          localUniAttribute.setEncodeName("utf-8");
        }
        localUniAttribute.decode((byte[])localObject2);
        localObject2 = localUniAttribute.getKeySet().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          String str2 = (String)((Iterator)localObject2).next();
          ContentValues localContentValues = new ContentValues();
          localContentValues.put("main_key", str1);
          localContentValues.put("second_key", str2);
          localContentValues.put("value", (String)localUniAttribute.get(str2));
          QzoneConfig.a().a(str1, str2, (String)localUniAttribute.get(str2));
          localArrayList.add(localContentValues);
        }
      }
    }
    try
    {
      BaseApplication.getContext().getContentResolver().bulkInsert(QZoneConfigProvider.a, (ContentValues[])localArrayList.toArray(new ContentValues[localArrayList.size()]));
      return;
    }
    catch (SQLException paramMap)
    {
      QLog.e("QZConfigProviderUtil", 1, "saveConfig error:" + paramMap.getMessage());
      return;
    }
    catch (Exception paramMap)
    {
      QLog.e("QZConfigProviderUtil", 1, "saveConfig error:" + paramMap.getMessage());
      return;
    }
    finally
    {
      localArrayList.clear();
    }
  }
  
  /* Error */
  private static boolean b(String paramString)
  {
    // Byte code:
    //   0: invokestatic 42	com/tencent/qphone/base/util/BaseApplication:getContext	()Landroid/content/Context;
    //   3: invokevirtual 48	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   6: getstatic 91	com/tencent/common/config/provider/QZoneConfigProvider:a	Landroid/net/Uri;
    //   9: iconst_1
    //   10: anewarray 57	java/lang/String
    //   13: dup
    //   14: iconst_0
    //   15: ldc_w 350
    //   18: aastore
    //   19: ldc_w 352
    //   22: iconst_1
    //   23: anewarray 57	java/lang/String
    //   26: dup
    //   27: iconst_0
    //   28: aload_0
    //   29: aastore
    //   30: aconst_null
    //   31: invokevirtual 103	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   34: astore 4
    //   36: aload 4
    //   38: ifnull +175 -> 213
    //   41: aload 4
    //   43: astore_3
    //   44: aload 4
    //   46: invokeinterface 355 1 0
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
    //   67: invokeinterface 120 1 0
    //   72: iload_1
    //   73: istore_2
    //   74: iload_2
    //   75: ifle +122 -> 197
    //   78: iconst_1
    //   79: ireturn
    //   80: aload 4
    //   82: astore_3
    //   83: aload 4
    //   85: invokeinterface 108 1 0
    //   90: pop
    //   91: aload 4
    //   93: astore_3
    //   94: aload 4
    //   96: iconst_0
    //   97: invokeinterface 359 2 0
    //   102: istore_1
    //   103: goto -45 -> 58
    //   106: astore 5
    //   108: aconst_null
    //   109: astore 4
    //   111: aload 4
    //   113: astore_3
    //   114: invokestatic 69	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   117: ifeq +48 -> 165
    //   120: aload 4
    //   122: astore_3
    //   123: ldc 22
    //   125: iconst_2
    //   126: new 71	java/lang/StringBuilder
    //   129: dup
    //   130: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   133: ldc_w 361
    //   136: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: aload_0
    //   140: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: ldc_w 363
    //   146: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: aload 5
    //   151: invokevirtual 82	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   154: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   160: aload 5
    //   162: invokestatic 125	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   165: aload 4
    //   167: ifnull +41 -> 208
    //   170: aload 4
    //   172: invokeinterface 120 1 0
    //   177: iconst_0
    //   178: istore_2
    //   179: goto -105 -> 74
    //   182: astore_0
    //   183: aconst_null
    //   184: astore_3
    //   185: aload_3
    //   186: ifnull +9 -> 195
    //   189: aload_3
    //   190: invokeinterface 120 1 0
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
  
  private static void c()
  {
    try
    {
      BaseApplication.getContext().getContentResolver().delete(QZoneConfigProvider.f, null, null);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("QZConfigProviderUtil", 2, "deleteIspCheckTime error" + localException.getMessage(), localException);
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
      while (!QLog.isColorLevel()) {}
      QLog.e("QZConfigProviderUtil", 2, "deleteConfig error" + localException.getMessage(), localException);
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
      while (!QLog.isColorLevel()) {}
      QLog.e("QZConfigProviderUtil", 2, "deleteIspConfig error " + localException.getMessage(), localException);
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
      while (!QLog.isColorLevel()) {}
      QLog.e("QZConfigProviderUtil", 2, "deleteLastUpdateLog error " + localException.getMessage(), localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.common.config.provider.QZConfigProviderUtil
 * JD-Core Version:    0.7.0.1
 */