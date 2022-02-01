import android.content.Context;
import android.content.res.Resources;
import android.media.AudioManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Method;

public class jkg
{
  static Boolean s = Boolean.valueOf(true);
  static Boolean t = Boolean.valueOf(true);
  static Boolean u = Boolean.valueOf(true);
  static Boolean v = Boolean.valueOf(true);
  static Boolean w = Boolean.valueOf(true);
  static Boolean x = Boolean.valueOf(true);
  
  public static int X(Context paramContext)
  {
    int i = 1;
    int j = aqiw.getSystemNetwork(paramContext);
    if (j == 1) {
      i = 0;
    }
    while (j == 4) {
      return i;
    }
    if (j == 3) {
      return 2;
    }
    if (j == 2) {
      return 3;
    }
    return -1;
  }
  
  public static String get(Context paramContext, String paramString)
    throws IllegalArgumentException
  {
    try
    {
      paramContext = paramContext.getClassLoader().loadClass("android.os.SystemProperties");
      paramContext = (String)paramContext.getMethod("get", new Class[] { String.class }).invoke(paramContext, new Object[] { new String(paramString) });
      return paramContext;
    }
    catch (IllegalArgumentException paramContext)
    {
      throw paramContext;
    }
    catch (Exception paramContext) {}
    return "";
  }
  
  public static NetworkInfo getNetWorkInfo(Context paramContext)
  {
    return AppNetConnInfo.getRecentNetworkInfo();
  }
  
  /* Error */
  public static boolean isCalling(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +13 -> 14
    //   4: ldc 95
    //   6: iconst_1
    //   7: ldc 97
    //   9: invokestatic 102	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   12: iconst_0
    //   13: ireturn
    //   14: aload_0
    //   15: ldc 104
    //   17: invokevirtual 108	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   20: checkcast 110	android/telephony/TelephonyManager
    //   23: astore_3
    //   24: aload_3
    //   25: ifnull +215 -> 240
    //   28: aload_3
    //   29: invokevirtual 114	android/telephony/TelephonyManager:getCallState	()I
    //   32: ifeq +38 -> 70
    //   35: iconst_1
    //   36: istore_2
    //   37: invokestatic 118	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   40: ifeq +28 -> 68
    //   43: ldc 95
    //   45: iconst_2
    //   46: new 120	java/lang/StringBuilder
    //   49: dup
    //   50: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   53: ldc 124
    //   55: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: iload_2
    //   59: invokevirtual 131	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   62: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   65: invokestatic 138	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   68: iload_2
    //   69: ireturn
    //   70: getstatic 21	jkg:s	Ljava/lang/Boolean;
    //   73: invokevirtual 141	java/lang/Boolean:booleanValue	()Z
    //   76: ifeq +69 -> 145
    //   79: aload_3
    //   80: ldc 143
    //   82: iconst_1
    //   83: anewarray 62	java/lang/Class
    //   86: dup
    //   87: iconst_0
    //   88: getstatic 149	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   91: aastore
    //   92: iconst_1
    //   93: anewarray 4	java/lang/Object
    //   96: dup
    //   97: iconst_0
    //   98: iconst_0
    //   99: invokestatic 152	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   102: aastore
    //   103: invokestatic 158	aqos:invokeMethod	(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   106: checkcast 145	java/lang/Integer
    //   109: invokevirtual 161	java/lang/Integer:intValue	()I
    //   112: istore_1
    //   113: iload_1
    //   114: ifeq +31 -> 145
    //   117: iconst_1
    //   118: istore_2
    //   119: goto -82 -> 37
    //   122: astore 4
    //   124: iconst_0
    //   125: invokestatic 19	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   128: putstatic 21	jkg:s	Ljava/lang/Boolean;
    //   131: invokestatic 118	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   134: ifeq +11 -> 145
    //   137: ldc 95
    //   139: iconst_2
    //   140: ldc 163
    //   142: invokestatic 138	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   145: getstatic 23	jkg:t	Ljava/lang/Boolean;
    //   148: invokevirtual 141	java/lang/Boolean:booleanValue	()Z
    //   151: ifeq +89 -> 240
    //   154: aload_3
    //   155: ldc 143
    //   157: iconst_1
    //   158: anewarray 62	java/lang/Class
    //   161: dup
    //   162: iconst_0
    //   163: getstatic 149	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   166: aastore
    //   167: iconst_1
    //   168: anewarray 4	java/lang/Object
    //   171: dup
    //   172: iconst_0
    //   173: iconst_1
    //   174: invokestatic 152	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   177: aastore
    //   178: invokestatic 158	aqos:invokeMethod	(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   181: checkcast 145	java/lang/Integer
    //   184: invokevirtual 161	java/lang/Integer:intValue	()I
    //   187: istore_1
    //   188: iload_1
    //   189: ifeq +51 -> 240
    //   192: iconst_1
    //   193: istore_2
    //   194: goto -157 -> 37
    //   197: astore 4
    //   199: invokestatic 118	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   202: ifeq -57 -> 145
    //   205: ldc 95
    //   207: iconst_2
    //   208: ldc 165
    //   210: aload 4
    //   212: invokestatic 168	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   215: goto -70 -> 145
    //   218: astore_3
    //   219: iconst_0
    //   220: invokestatic 19	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   223: putstatic 23	jkg:t	Ljava/lang/Boolean;
    //   226: invokestatic 118	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   229: ifeq +11 -> 240
    //   232: ldc 95
    //   234: iconst_2
    //   235: ldc 170
    //   237: invokestatic 138	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   240: aload_0
    //   241: ldc 172
    //   243: invokevirtual 108	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   246: checkcast 110	android/telephony/TelephonyManager
    //   249: astore_0
    //   250: aload_0
    //   251: ifnull +187 -> 438
    //   254: aload_0
    //   255: invokevirtual 114	android/telephony/TelephonyManager:getCallState	()I
    //   258: ifeq +33 -> 291
    //   261: iconst_1
    //   262: istore_2
    //   263: goto -226 -> 37
    //   266: astore_3
    //   267: invokestatic 118	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   270: ifeq -30 -> 240
    //   273: ldc 95
    //   275: iconst_2
    //   276: ldc 174
    //   278: aload_3
    //   279: invokestatic 168	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   282: goto -42 -> 240
    //   285: astore_0
    //   286: aconst_null
    //   287: astore_0
    //   288: goto -38 -> 250
    //   291: getstatic 25	jkg:u	Ljava/lang/Boolean;
    //   294: invokevirtual 141	java/lang/Boolean:booleanValue	()Z
    //   297: ifeq +58 -> 355
    //   300: aload_0
    //   301: ldc 143
    //   303: iconst_1
    //   304: anewarray 4	java/lang/Object
    //   307: dup
    //   308: iconst_0
    //   309: iconst_0
    //   310: invokestatic 152	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   313: aastore
    //   314: invokestatic 177	aqos:invokeMethod	(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/Object;
    //   317: checkcast 145	java/lang/Integer
    //   320: invokevirtual 161	java/lang/Integer:intValue	()I
    //   323: istore_1
    //   324: iload_1
    //   325: ifeq +30 -> 355
    //   328: iconst_1
    //   329: istore_2
    //   330: goto -293 -> 37
    //   333: astore_3
    //   334: iconst_0
    //   335: invokestatic 19	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   338: putstatic 25	jkg:u	Ljava/lang/Boolean;
    //   341: invokestatic 118	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   344: ifeq +11 -> 355
    //   347: ldc 95
    //   349: iconst_2
    //   350: ldc 179
    //   352: invokestatic 138	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   355: getstatic 27	jkg:v	Ljava/lang/Boolean;
    //   358: invokevirtual 141	java/lang/Boolean:booleanValue	()Z
    //   361: ifeq +77 -> 438
    //   364: aload_0
    //   365: ldc 143
    //   367: iconst_1
    //   368: anewarray 4	java/lang/Object
    //   371: dup
    //   372: iconst_0
    //   373: iconst_1
    //   374: invokestatic 152	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   377: aastore
    //   378: invokestatic 177	aqos:invokeMethod	(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/Object;
    //   381: checkcast 145	java/lang/Integer
    //   384: invokevirtual 161	java/lang/Integer:intValue	()I
    //   387: istore_1
    //   388: iload_1
    //   389: ifeq +49 -> 438
    //   392: iconst_1
    //   393: istore_2
    //   394: goto -357 -> 37
    //   397: astore_3
    //   398: invokestatic 118	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   401: ifeq -46 -> 355
    //   404: ldc 95
    //   406: iconst_2
    //   407: ldc 181
    //   409: aload_3
    //   410: invokestatic 168	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   413: goto -58 -> 355
    //   416: astore_0
    //   417: iconst_0
    //   418: invokestatic 19	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   421: putstatic 27	jkg:v	Ljava/lang/Boolean;
    //   424: invokestatic 118	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   427: ifeq +11 -> 438
    //   430: ldc 95
    //   432: iconst_2
    //   433: ldc 183
    //   435: invokestatic 138	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   438: getstatic 29	jkg:w	Ljava/lang/Boolean;
    //   441: invokevirtual 141	java/lang/Boolean:booleanValue	()Z
    //   444: ifeq +85 -> 529
    //   447: ldc 185
    //   449: ldc 187
    //   451: aconst_null
    //   452: aconst_null
    //   453: invokestatic 191	aqos:invokeStaticMethod	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;[Ljava/lang/Class;)Ljava/lang/Object;
    //   456: ldc 192
    //   458: iconst_1
    //   459: anewarray 4	java/lang/Object
    //   462: dup
    //   463: iconst_0
    //   464: iconst_0
    //   465: invokestatic 152	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   468: aastore
    //   469: invokestatic 177	aqos:invokeMethod	(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/Object;
    //   472: checkcast 145	java/lang/Integer
    //   475: invokevirtual 161	java/lang/Integer:intValue	()I
    //   478: istore_1
    //   479: iload_1
    //   480: ifeq +49 -> 529
    //   483: iconst_1
    //   484: istore_2
    //   485: goto -448 -> 37
    //   488: astore_0
    //   489: invokestatic 118	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   492: ifeq -54 -> 438
    //   495: ldc 95
    //   497: iconst_2
    //   498: ldc 194
    //   500: aload_0
    //   501: invokestatic 168	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   504: goto -66 -> 438
    //   507: astore_0
    //   508: iconst_0
    //   509: invokestatic 19	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   512: putstatic 29	jkg:w	Ljava/lang/Boolean;
    //   515: invokestatic 118	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   518: ifeq +11 -> 529
    //   521: ldc 95
    //   523: iconst_2
    //   524: ldc 196
    //   526: invokestatic 138	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   529: getstatic 31	jkg:x	Ljava/lang/Boolean;
    //   532: invokevirtual 141	java/lang/Boolean:booleanValue	()Z
    //   535: ifeq +86 -> 621
    //   538: ldc 185
    //   540: ldc 187
    //   542: aconst_null
    //   543: aconst_null
    //   544: invokestatic 191	aqos:invokeStaticMethod	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;[Ljava/lang/Class;)Ljava/lang/Object;
    //   547: ldc 192
    //   549: iconst_1
    //   550: anewarray 4	java/lang/Object
    //   553: dup
    //   554: iconst_0
    //   555: iconst_1
    //   556: invokestatic 152	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   559: aastore
    //   560: invokestatic 177	aqos:invokeMethod	(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/Object;
    //   563: checkcast 145	java/lang/Integer
    //   566: invokevirtual 161	java/lang/Integer:intValue	()I
    //   569: istore_1
    //   570: iload_1
    //   571: ifeq +8 -> 579
    //   574: iconst_1
    //   575: istore_2
    //   576: goto -539 -> 37
    //   579: iconst_0
    //   580: istore_2
    //   581: goto -544 -> 37
    //   584: astore_0
    //   585: iconst_0
    //   586: invokestatic 19	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   589: putstatic 31	jkg:x	Ljava/lang/Boolean;
    //   592: invokestatic 118	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   595: ifeq +11 -> 606
    //   598: ldc 95
    //   600: iconst_2
    //   601: ldc 198
    //   603: invokestatic 138	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   606: iconst_0
    //   607: istore_2
    //   608: goto -571 -> 37
    //   611: astore_0
    //   612: iconst_0
    //   613: istore_2
    //   614: goto -577 -> 37
    //   617: astore_0
    //   618: goto -89 -> 529
    //   621: iconst_0
    //   622: istore_2
    //   623: goto -586 -> 37
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	626	0	paramContext	Context
    //   112	459	1	i	int
    //   36	587	2	bool	boolean
    //   23	132	3	localTelephonyManager	TelephonyManager
    //   218	1	3	localNoSuchMethodException1	java.lang.NoSuchMethodException
    //   266	13	3	localException1	Exception
    //   333	1	3	localNoSuchMethodException2	java.lang.NoSuchMethodException
    //   397	13	3	localException2	Exception
    //   122	1	4	localNoSuchMethodException3	java.lang.NoSuchMethodException
    //   197	14	4	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   79	113	122	java/lang/NoSuchMethodException
    //   79	113	197	java/lang/Exception
    //   154	188	218	java/lang/NoSuchMethodException
    //   154	188	266	java/lang/Exception
    //   240	250	285	java/lang/Exception
    //   300	324	333	java/lang/NoSuchMethodException
    //   300	324	397	java/lang/Exception
    //   364	388	416	java/lang/NoSuchMethodException
    //   364	388	488	java/lang/Exception
    //   447	479	507	java/lang/NoSuchMethodException
    //   538	570	584	java/lang/NoSuchMethodException
    //   538	570	611	java/lang/Exception
    //   447	479	617	java/lang/Exception
  }
  
  public static boolean isHardCodePhoneDevice()
  {
    String str = Build.MODEL;
    return (Build.MANUFACTURER.equalsIgnoreCase("samsung")) && (str.equalsIgnoreCase("SM-T230"));
  }
  
  public static boolean isHardCodeTabletDevice()
  {
    boolean bool2 = false;
    String str = Build.MODEL;
    boolean bool1 = bool2;
    if ("samsung".equalsIgnoreCase(Build.MANUFACTURER)) {
      if (!"SM-T805C".equalsIgnoreCase(str))
      {
        bool1 = bool2;
        if (!"SM-T800".equalsIgnoreCase(str)) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static boolean isRingEqualsZero(Context paramContext)
  {
    paramContext = (AudioManager)paramContext.getSystemService("audio");
    return (paramContext != null) && (paramContext.getStreamVolume(2) == 0);
  }
  
  public static boolean isRingerNormal(Context paramContext)
  {
    paramContext = (AudioManager)paramContext.getSystemService("audio");
    return (paramContext != null) && (paramContext.getRingerMode() == 2);
  }
  
  public static boolean isRingerVibrate(Context paramContext)
  {
    paramContext = (AudioManager)paramContext.getSystemService("audio");
    return (paramContext != null) && (paramContext.getRingerMode() == 1);
  }
  
  public static boolean isTablet(Context paramContext)
  {
    boolean bool3 = true;
    boolean bool1;
    if (isHardCodePhoneDevice()) {
      bool1 = false;
    }
    for (;;)
    {
      return bool1;
      bool1 = bool3;
      if (isHardCodeTabletDevice()) {
        continue;
      }
      bool1 = bool3;
      if (get(paramContext, "ro.qq.istablet").equalsIgnoreCase("true")) {
        continue;
      }
      bool1 = bool3;
      if (get(paramContext, "ro.lenovo.device").equalsIgnoreCase("tablet")) {
        continue;
      }
      try
      {
        DisplayMetrics localDisplayMetrics = paramContext.getResources().getDisplayMetrics();
        float f1 = localDisplayMetrics.widthPixels / localDisplayMetrics.xdpi;
        float f2 = localDisplayMetrics.heightPixels / localDisplayMetrics.ydpi;
        d = Math.pow(f1, 2.0D);
        d = Math.sqrt(Math.pow(f2, 2.0D) + d);
        try
        {
          int i = ((TelephonyManager)paramContext.getSystemService("phone")).getPhoneType();
          if (i != 0) {
            break label217;
          }
          bool2 = false;
        }
        catch (Exception paramContext)
        {
          for (;;)
          {
            paramContext.printStackTrace();
            boolean bool2 = true;
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("PhoneStatusTools", 2, "device size : " + d + ", hasTelephone : " + bool2);
        }
        if (d > 6.5D)
        {
          bool1 = bool3;
          if (!bool2) {
            continue;
          }
        }
        return false;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          double d = 0.0D;
        }
      }
    }
  }
  
  public static boolean isWifiEnv(Context paramContext)
  {
    paramContext = getNetWorkInfo(paramContext);
    if (paramContext != null) {
      return paramContext.getType() == 1;
    }
    return false;
  }
  
  /* Error */
  public static void listen(Context paramContext, android.telephony.PhoneStateListener paramPhoneStateListener, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc 104
    //   3: invokevirtual 108	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   6: checkcast 110	android/telephony/TelephonyManager
    //   9: astore_3
    //   10: aload_3
    //   11: ifnull +146 -> 157
    //   14: aload_3
    //   15: ldc_w 316
    //   18: iconst_2
    //   19: anewarray 62	java/lang/Class
    //   22: dup
    //   23: iconst_0
    //   24: ldc_w 318
    //   27: aastore
    //   28: dup
    //   29: iconst_1
    //   30: getstatic 149	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   33: aastore
    //   34: iconst_2
    //   35: anewarray 4	java/lang/Object
    //   38: dup
    //   39: iconst_0
    //   40: aload_1
    //   41: aastore
    //   42: dup
    //   43: iconst_1
    //   44: iload_2
    //   45: invokestatic 152	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   48: aastore
    //   49: invokestatic 158	aqos:invokeMethod	(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   52: pop
    //   53: aload_3
    //   54: ldc_w 320
    //   57: iconst_3
    //   58: anewarray 62	java/lang/Class
    //   61: dup
    //   62: iconst_0
    //   63: getstatic 149	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   66: aastore
    //   67: dup
    //   68: iconst_1
    //   69: ldc_w 318
    //   72: aastore
    //   73: dup
    //   74: iconst_2
    //   75: getstatic 149	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   78: aastore
    //   79: iconst_3
    //   80: anewarray 4	java/lang/Object
    //   83: dup
    //   84: iconst_0
    //   85: iconst_0
    //   86: invokestatic 152	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   89: aastore
    //   90: dup
    //   91: iconst_1
    //   92: aload_1
    //   93: aastore
    //   94: dup
    //   95: iconst_2
    //   96: iload_2
    //   97: invokestatic 152	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   100: aastore
    //   101: invokestatic 158	aqos:invokeMethod	(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   104: pop
    //   105: aload_3
    //   106: ldc_w 320
    //   109: iconst_3
    //   110: anewarray 62	java/lang/Class
    //   113: dup
    //   114: iconst_0
    //   115: getstatic 149	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   118: aastore
    //   119: dup
    //   120: iconst_1
    //   121: ldc_w 318
    //   124: aastore
    //   125: dup
    //   126: iconst_2
    //   127: getstatic 149	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   130: aastore
    //   131: iconst_3
    //   132: anewarray 4	java/lang/Object
    //   135: dup
    //   136: iconst_0
    //   137: iconst_1
    //   138: invokestatic 152	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   141: aastore
    //   142: dup
    //   143: iconst_1
    //   144: aload_1
    //   145: aastore
    //   146: dup
    //   147: iconst_2
    //   148: iload_2
    //   149: invokestatic 152	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   152: aastore
    //   153: invokestatic 158	aqos:invokeMethod	(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   156: pop
    //   157: aload_0
    //   158: ldc 172
    //   160: invokevirtual 108	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   163: checkcast 110	android/telephony/TelephonyManager
    //   166: astore_0
    //   167: aload_0
    //   168: ifnull +146 -> 314
    //   171: aload_0
    //   172: ldc_w 316
    //   175: iconst_2
    //   176: anewarray 62	java/lang/Class
    //   179: dup
    //   180: iconst_0
    //   181: ldc_w 318
    //   184: aastore
    //   185: dup
    //   186: iconst_1
    //   187: getstatic 149	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   190: aastore
    //   191: iconst_2
    //   192: anewarray 4	java/lang/Object
    //   195: dup
    //   196: iconst_0
    //   197: aload_1
    //   198: aastore
    //   199: dup
    //   200: iconst_1
    //   201: iload_2
    //   202: invokestatic 152	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   205: aastore
    //   206: invokestatic 158	aqos:invokeMethod	(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   209: pop
    //   210: aload_0
    //   211: ldc_w 320
    //   214: iconst_3
    //   215: anewarray 62	java/lang/Class
    //   218: dup
    //   219: iconst_0
    //   220: getstatic 149	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   223: aastore
    //   224: dup
    //   225: iconst_1
    //   226: ldc_w 318
    //   229: aastore
    //   230: dup
    //   231: iconst_2
    //   232: getstatic 149	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   235: aastore
    //   236: iconst_3
    //   237: anewarray 4	java/lang/Object
    //   240: dup
    //   241: iconst_0
    //   242: iconst_0
    //   243: invokestatic 152	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   246: aastore
    //   247: dup
    //   248: iconst_1
    //   249: aload_1
    //   250: aastore
    //   251: dup
    //   252: iconst_2
    //   253: iload_2
    //   254: invokestatic 152	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   257: aastore
    //   258: invokestatic 158	aqos:invokeMethod	(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   261: pop
    //   262: aload_0
    //   263: ldc_w 320
    //   266: iconst_3
    //   267: anewarray 62	java/lang/Class
    //   270: dup
    //   271: iconst_0
    //   272: getstatic 149	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   275: aastore
    //   276: dup
    //   277: iconst_1
    //   278: ldc_w 318
    //   281: aastore
    //   282: dup
    //   283: iconst_2
    //   284: getstatic 149	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   287: aastore
    //   288: iconst_3
    //   289: anewarray 4	java/lang/Object
    //   292: dup
    //   293: iconst_0
    //   294: iconst_1
    //   295: invokestatic 152	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   298: aastore
    //   299: dup
    //   300: iconst_1
    //   301: aload_1
    //   302: aastore
    //   303: dup
    //   304: iconst_2
    //   305: iload_2
    //   306: invokestatic 152	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   309: aastore
    //   310: invokestatic 158	aqos:invokeMethod	(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   313: pop
    //   314: ldc 185
    //   316: ldc 187
    //   318: aconst_null
    //   319: aconst_null
    //   320: invokestatic 191	aqos:invokeStaticMethod	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;[Ljava/lang/Class;)Ljava/lang/Object;
    //   323: ldc_w 316
    //   326: iconst_2
    //   327: anewarray 62	java/lang/Class
    //   330: dup
    //   331: iconst_0
    //   332: ldc_w 318
    //   335: aastore
    //   336: dup
    //   337: iconst_1
    //   338: getstatic 149	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   341: aastore
    //   342: iconst_2
    //   343: anewarray 4	java/lang/Object
    //   346: dup
    //   347: iconst_0
    //   348: aload_1
    //   349: aastore
    //   350: dup
    //   351: iconst_1
    //   352: iload_2
    //   353: invokestatic 152	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   356: aastore
    //   357: invokestatic 158	aqos:invokeMethod	(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   360: pop
    //   361: return
    //   362: astore_0
    //   363: aconst_null
    //   364: astore_0
    //   365: goto -198 -> 167
    //   368: astore_0
    //   369: return
    //   370: astore_0
    //   371: return
    //   372: astore_0
    //   373: goto -59 -> 314
    //   376: astore_3
    //   377: goto -220 -> 157
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	380	0	paramContext	Context
    //   0	380	1	paramPhoneStateListener	android.telephony.PhoneStateListener
    //   0	380	2	paramInt	int
    //   9	97	3	localTelephonyManager	TelephonyManager
    //   376	1	3	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   157	167	362	java/lang/Exception
    //   0	10	368	java/lang/Exception
    //   314	361	370	java/lang/Exception
    //   171	314	372	java/lang/Exception
    //   14	157	376	java/lang/Exception
  }
  
  public static boolean xD()
  {
    String str1 = Build.MANUFACTURER;
    String str2 = Build.MODEL;
    return (str1.equalsIgnoreCase("ZTE")) && (str2.equalsIgnoreCase("ZTE U950"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jkg
 * JD-Core Version:    0.7.0.1
 */