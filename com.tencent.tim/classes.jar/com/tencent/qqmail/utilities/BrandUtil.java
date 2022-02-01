package com.tencent.qqmail.utilities;

import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.qqmail.utilities.log.QMLog;
import java.lang.reflect.Method;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BrandUtil
{
  private static final String BRAND;
  private static final String KEY_COLOR_OS_VERSION_NAME = "ro.build.version.opporom";
  private static final String KEY_EMUI_API_LEVEL = "ro.build.hw_emui_api_level";
  private static final String KEY_EMUI_VERSION_NAME = "ro.build.version.emui";
  private static final String KEY_FLYME_VERSION_NAME = "ro.build.display.id";
  private static final String KEY_FUNTOUCH_OS_VERSION_NAME = "ro.vivo.os.build.display.id";
  private static final String KEY_LETV_EUI_VERSION_NAME = "ro.letv.eui";
  private static final String KEY_MIUI_VERSION_NAME = "ro.miui.ui.version.name";
  private static final String KEY_SMARTISAN_OS_VERSION_NAME = "ro.smartisan.version";
  public static final String TAG = "BrandUtil";
  private static String sColorOsVersionName;
  private static String sDisplayId;
  private static String sEmuiApiLevel;
  private static String sEmuiVersionName;
  private static String sFuntouchOsVersionName;
  private static String sLetvEuiVersionName;
  private static String sMiuiVersionName;
  private static String sRom = "";
  private static String sSmartisanVersionName;
  
  /* Error */
  static
  {
    // Byte code:
    //   0: ldc 48
    //   2: putstatic 50	com/tencent/qqmail/utilities/BrandUtil:sRom	Ljava/lang/String;
    //   5: getstatic 54	android/os/Build:BRAND	Ljava/lang/String;
    //   8: invokevirtual 60	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   11: putstatic 61	com/tencent/qqmail/utilities/BrandUtil:BRAND	Ljava/lang/String;
    //   14: new 63	java/io/FileInputStream
    //   17: dup
    //   18: new 65	java/io/File
    //   21: dup
    //   22: invokestatic 71	android/os/Environment:getRootDirectory	()Ljava/io/File;
    //   25: ldc 73
    //   27: invokespecial 77	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   30: invokespecial 80	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   33: astore_1
    //   34: aload_1
    //   35: astore_0
    //   36: new 82	java/util/Properties
    //   39: dup
    //   40: invokespecial 84	java/util/Properties:<init>	()V
    //   43: astore_2
    //   44: aload_1
    //   45: astore_0
    //   46: aload_2
    //   47: aload_1
    //   48: invokevirtual 88	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   51: aload_1
    //   52: astore_0
    //   53: ldc 90
    //   55: invokestatic 96	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   58: ldc 98
    //   60: iconst_1
    //   61: anewarray 92	java/lang/Class
    //   64: dup
    //   65: iconst_0
    //   66: ldc 56
    //   68: aastore
    //   69: invokevirtual 102	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   72: astore_3
    //   73: aload_1
    //   74: astore_0
    //   75: aload_2
    //   76: aload_3
    //   77: ldc 27
    //   79: invokestatic 106	com/tencent/qqmail/utilities/BrandUtil:getLowerCaseName	(Ljava/util/Properties;Ljava/lang/reflect/Method;Ljava/lang/String;)Ljava/lang/String;
    //   82: putstatic 108	com/tencent/qqmail/utilities/BrandUtil:sMiuiVersionName	Ljava/lang/String;
    //   85: aload_1
    //   86: astore_0
    //   87: aload_2
    //   88: aload_3
    //   89: ldc 18
    //   91: invokestatic 106	com/tencent/qqmail/utilities/BrandUtil:getLowerCaseName	(Ljava/util/Properties;Ljava/lang/reflect/Method;Ljava/lang/String;)Ljava/lang/String;
    //   94: putstatic 110	com/tencent/qqmail/utilities/BrandUtil:sDisplayId	Ljava/lang/String;
    //   97: aload_1
    //   98: astore_0
    //   99: aload_2
    //   100: aload_3
    //   101: ldc 9
    //   103: invokestatic 106	com/tencent/qqmail/utilities/BrandUtil:getLowerCaseName	(Ljava/util/Properties;Ljava/lang/reflect/Method;Ljava/lang/String;)Ljava/lang/String;
    //   106: putstatic 112	com/tencent/qqmail/utilities/BrandUtil:sColorOsVersionName	Ljava/lang/String;
    //   109: aload_1
    //   110: astore_0
    //   111: aload_2
    //   112: aload_3
    //   113: ldc 15
    //   115: invokestatic 106	com/tencent/qqmail/utilities/BrandUtil:getLowerCaseName	(Ljava/util/Properties;Ljava/lang/reflect/Method;Ljava/lang/String;)Ljava/lang/String;
    //   118: putstatic 114	com/tencent/qqmail/utilities/BrandUtil:sEmuiVersionName	Ljava/lang/String;
    //   121: aload_1
    //   122: astore_0
    //   123: aload_2
    //   124: aload_3
    //   125: ldc 12
    //   127: invokestatic 106	com/tencent/qqmail/utilities/BrandUtil:getLowerCaseName	(Ljava/util/Properties;Ljava/lang/reflect/Method;Ljava/lang/String;)Ljava/lang/String;
    //   130: putstatic 116	com/tencent/qqmail/utilities/BrandUtil:sEmuiApiLevel	Ljava/lang/String;
    //   133: aload_1
    //   134: astore_0
    //   135: aload_2
    //   136: aload_3
    //   137: ldc 21
    //   139: invokestatic 106	com/tencent/qqmail/utilities/BrandUtil:getLowerCaseName	(Ljava/util/Properties;Ljava/lang/reflect/Method;Ljava/lang/String;)Ljava/lang/String;
    //   142: putstatic 118	com/tencent/qqmail/utilities/BrandUtil:sFuntouchOsVersionName	Ljava/lang/String;
    //   145: aload_1
    //   146: astore_0
    //   147: aload_2
    //   148: aload_3
    //   149: ldc 24
    //   151: invokestatic 106	com/tencent/qqmail/utilities/BrandUtil:getLowerCaseName	(Ljava/util/Properties;Ljava/lang/reflect/Method;Ljava/lang/String;)Ljava/lang/String;
    //   154: putstatic 120	com/tencent/qqmail/utilities/BrandUtil:sLetvEuiVersionName	Ljava/lang/String;
    //   157: aload_1
    //   158: astore_0
    //   159: aload_2
    //   160: aload_3
    //   161: ldc 30
    //   163: invokestatic 106	com/tencent/qqmail/utilities/BrandUtil:getLowerCaseName	(Ljava/util/Properties;Ljava/lang/reflect/Method;Ljava/lang/String;)Ljava/lang/String;
    //   166: putstatic 122	com/tencent/qqmail/utilities/BrandUtil:sSmartisanVersionName	Ljava/lang/String;
    //   169: aload_1
    //   170: invokevirtual 125	java/io/FileInputStream:close	()V
    //   173: getstatic 108	com/tencent/qqmail/utilities/BrandUtil:sMiuiVersionName	Ljava/lang/String;
    //   176: invokestatic 131	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   179: ifne +100 -> 279
    //   182: new 133	java/lang/StringBuilder
    //   185: dup
    //   186: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   189: ldc 136
    //   191: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: getstatic 108	com/tencent/qqmail/utilities/BrandUtil:sMiuiVersionName	Ljava/lang/String;
    //   197: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   203: putstatic 50	com/tencent/qqmail/utilities/BrandUtil:sRom	Ljava/lang/String;
    //   206: iconst_4
    //   207: ldc 33
    //   209: new 133	java/lang/StringBuilder
    //   212: dup
    //   213: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   216: ldc 145
    //   218: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   221: getstatic 61	com/tencent/qqmail/utilities/BrandUtil:BRAND	Ljava/lang/String;
    //   224: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   227: ldc 147
    //   229: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: getstatic 50	com/tencent/qqmail/utilities/BrandUtil:sRom	Ljava/lang/String;
    //   235: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   241: invokestatic 153	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   244: return
    //   245: astore_2
    //   246: aconst_null
    //   247: astore_1
    //   248: aload_1
    //   249: astore_0
    //   250: iconst_5
    //   251: ldc 33
    //   253: ldc 155
    //   255: aload_2
    //   256: invokestatic 158	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   259: aload_1
    //   260: invokevirtual 125	java/io/FileInputStream:close	()V
    //   263: goto -90 -> 173
    //   266: astore_0
    //   267: goto -94 -> 173
    //   270: astore_1
    //   271: aconst_null
    //   272: astore_0
    //   273: aload_0
    //   274: invokevirtual 125	java/io/FileInputStream:close	()V
    //   277: aload_1
    //   278: athrow
    //   279: getstatic 114	com/tencent/qqmail/utilities/BrandUtil:sEmuiVersionName	Ljava/lang/String;
    //   282: invokestatic 131	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   285: ifne +12 -> 297
    //   288: getstatic 114	com/tencent/qqmail/utilities/BrandUtil:sEmuiVersionName	Ljava/lang/String;
    //   291: putstatic 50	com/tencent/qqmail/utilities/BrandUtil:sRom	Ljava/lang/String;
    //   294: goto -88 -> 206
    //   297: getstatic 112	com/tencent/qqmail/utilities/BrandUtil:sColorOsVersionName	Ljava/lang/String;
    //   300: invokestatic 131	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   303: ifne +30 -> 333
    //   306: new 133	java/lang/StringBuilder
    //   309: dup
    //   310: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   313: ldc 160
    //   315: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   318: getstatic 112	com/tencent/qqmail/utilities/BrandUtil:sColorOsVersionName	Ljava/lang/String;
    //   321: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   324: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   327: putstatic 50	com/tencent/qqmail/utilities/BrandUtil:sRom	Ljava/lang/String;
    //   330: goto -124 -> 206
    //   333: getstatic 118	com/tencent/qqmail/utilities/BrandUtil:sFuntouchOsVersionName	Ljava/lang/String;
    //   336: invokestatic 131	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   339: ifne +12 -> 351
    //   342: getstatic 118	com/tencent/qqmail/utilities/BrandUtil:sFuntouchOsVersionName	Ljava/lang/String;
    //   345: putstatic 50	com/tencent/qqmail/utilities/BrandUtil:sRom	Ljava/lang/String;
    //   348: goto -142 -> 206
    //   351: getstatic 120	com/tencent/qqmail/utilities/BrandUtil:sLetvEuiVersionName	Ljava/lang/String;
    //   354: invokestatic 131	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   357: ifne +30 -> 387
    //   360: new 133	java/lang/StringBuilder
    //   363: dup
    //   364: invokespecial 134	java/lang/StringBuilder:<init>	()V
    //   367: ldc 162
    //   369: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   372: getstatic 120	com/tencent/qqmail/utilities/BrandUtil:sLetvEuiVersionName	Ljava/lang/String;
    //   375: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   378: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   381: putstatic 50	com/tencent/qqmail/utilities/BrandUtil:sRom	Ljava/lang/String;
    //   384: goto -178 -> 206
    //   387: invokestatic 166	com/tencent/qqmail/utilities/BrandUtil:isFlyme	()Z
    //   390: ifeq +21 -> 411
    //   393: getstatic 110	com/tencent/qqmail/utilities/BrandUtil:sDisplayId	Ljava/lang/String;
    //   396: invokestatic 131	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   399: ifne +12 -> 411
    //   402: getstatic 110	com/tencent/qqmail/utilities/BrandUtil:sDisplayId	Ljava/lang/String;
    //   405: putstatic 50	com/tencent/qqmail/utilities/BrandUtil:sRom	Ljava/lang/String;
    //   408: goto -202 -> 206
    //   411: getstatic 122	com/tencent/qqmail/utilities/BrandUtil:sSmartisanVersionName	Ljava/lang/String;
    //   414: invokestatic 131	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   417: ifne -211 -> 206
    //   420: getstatic 122	com/tencent/qqmail/utilities/BrandUtil:sSmartisanVersionName	Ljava/lang/String;
    //   423: putstatic 50	com/tencent/qqmail/utilities/BrandUtil:sRom	Ljava/lang/String;
    //   426: goto -220 -> 206
    //   429: astore_0
    //   430: goto -257 -> 173
    //   433: astore_0
    //   434: goto -157 -> 277
    //   437: astore_1
    //   438: goto -165 -> 273
    //   441: astore_2
    //   442: goto -194 -> 248
    // Local variable table:
    //   start	length	slot	name	signature
    //   35	215	0	localFileInputStream1	java.io.FileInputStream
    //   266	1	0	localException1	Exception
    //   272	2	0	localObject1	Object
    //   429	1	0	localException2	Exception
    //   433	1	0	localException3	Exception
    //   33	227	1	localFileInputStream2	java.io.FileInputStream
    //   270	8	1	localObject2	Object
    //   437	1	1	localObject3	Object
    //   43	117	2	localProperties	Properties
    //   245	11	2	localException4	Exception
    //   441	1	2	localException5	Exception
    //   72	89	3	localMethod	Method
    // Exception table:
    //   from	to	target	type
    //   14	34	245	java/lang/Exception
    //   259	263	266	java/lang/Exception
    //   14	34	270	finally
    //   169	173	429	java/lang/Exception
    //   273	277	433	java/lang/Exception
    //   36	44	437	finally
    //   46	51	437	finally
    //   53	73	437	finally
    //   75	85	437	finally
    //   87	97	437	finally
    //   99	109	437	finally
    //   111	121	437	finally
    //   123	133	437	finally
    //   135	145	437	finally
    //   147	157	437	finally
    //   159	169	437	finally
    //   250	259	437	finally
    //   36	44	441	java/lang/Exception
    //   46	51	441	java/lang/Exception
    //   53	73	441	java/lang/Exception
    //   75	85	441	java/lang/Exception
    //   87	97	441	java/lang/Exception
    //   99	109	441	java/lang/Exception
    //   111	121	441	java/lang/Exception
    //   123	133	441	java/lang/Exception
    //   135	145	441	java/lang/Exception
    //   147	157	441	java/lang/Exception
    //   159	169	441	java/lang/Exception
  }
  
  public static String getFlymeVersion()
  {
    String str = "";
    Matcher localMatcher = Pattern.compile("(\\d+\\.\\d+\\.\\d+)").matcher(sDisplayId);
    if (localMatcher.find()) {
      str = localMatcher.group(1);
    }
    QMLog.log(4, "BrandUtil", "getFlymeVersion flymeVersion = " + str);
    return str;
  }
  
  @Nullable
  private static String getLowerCaseName(Properties paramProperties, Method paramMethod, String paramString)
  {
    paramProperties = paramProperties.getProperty(paramString);
    if (paramProperties == null) {}
    for (;;)
    {
      try
      {
        paramMethod = (String)paramMethod.invoke(null, new Object[] { paramString });
        paramProperties = paramMethod;
      }
      catch (Exception paramMethod)
      {
        continue;
      }
      paramMethod = paramProperties;
      if (paramProperties != null) {
        paramMethod = paramProperties.toLowerCase();
      }
      return paramMethod;
    }
  }
  
  @NonNull
  public static String getRom()
  {
    return sRom;
  }
  
  public static boolean is360()
  {
    return (BRAND.contains("360")) || (BRAND.contains("qiku"));
  }
  
  public static boolean isAndroidMarshmallow()
  {
    return (!TextUtils.isEmpty(sDisplayId)) && (sDisplayId.contains("mra58k"));
  }
  
  public static boolean isColorOS()
  {
    return !TextUtils.isEmpty(sColorOsVersionName);
  }
  
  public static boolean isColorOSV2()
  {
    return (!TextUtils.isEmpty(sColorOsVersionName)) && (sColorOsVersionName.contains("v2"));
  }
  
  public static boolean isColorOSV21()
  {
    return (!TextUtils.isEmpty(sColorOsVersionName)) && (sColorOsVersionName.contains("v2.1"));
  }
  
  public static boolean isColorOSV3()
  {
    return (!TextUtils.isEmpty(sColorOsVersionName)) && (sColorOsVersionName.contains("v3"));
  }
  
  public static boolean isColorfulNotificationIcon()
  {
    return (isHuawei()) || (isXiaomi());
  }
  
  public static boolean isEmui()
  {
    return (!TextUtils.isEmpty(sEmuiVersionName)) || (!TextUtils.isEmpty(sEmuiApiLevel));
  }
  
  public static boolean isEmuiV5()
  {
    return "emotionui_5.0".equals(sEmuiVersionName);
  }
  
  public static boolean isFlyme()
  {
    return (!TextUtils.isEmpty(sDisplayId)) && (sDisplayId.contains("flyme"));
  }
  
  public static boolean isFuntouchOS()
  {
    return !TextUtils.isEmpty(sFuntouchOsVersionName);
  }
  
  public static boolean isGIONEE()
  {
    return BRAND.contains("gionee");
  }
  
  public static boolean isHuawei()
  {
    return (BRAND.contains("huawei")) || (BRAND.contains("honor"));
  }
  
  public static boolean isLenovo()
  {
    return (BRAND.contains("lenovo")) || (BRAND.contains("zuk"));
  }
  
  public static boolean isLetv()
  {
    return (BRAND.contains("letv")) || (BRAND.contains("leeco"));
  }
  
  public static boolean isLetvEui()
  {
    return !TextUtils.isEmpty(sLetvEuiVersionName);
  }
  
  public static boolean isMeitu()
  {
    return BRAND.contains("meitu");
  }
  
  public static boolean isMeizu()
  {
    return BRAND.contains("meizu");
  }
  
  public static boolean isMiui()
  {
    return !TextUtils.isEmpty(sMiuiVersionName);
  }
  
  public static boolean isMiuiV5()
  {
    return "v5".equals(sMiuiVersionName);
  }
  
  public static boolean isMiuiV6()
  {
    return "v6".equals(sMiuiVersionName);
  }
  
  public static boolean isMiuiV7()
  {
    return "v7".equals(sMiuiVersionName);
  }
  
  public static boolean isMiuiV8()
  {
    return "v8".equals(sMiuiVersionName);
  }
  
  public static boolean isMiuiV9()
  {
    return "v9".equals(sMiuiVersionName);
  }
  
  public static boolean isNubia()
  {
    return BRAND.contains("nubia");
  }
  
  public static boolean isOppo()
  {
    return BRAND.contains("oppo");
  }
  
  public static boolean isSamsung()
  {
    return BRAND.contains("samsung");
  }
  
  public static boolean isVivo()
  {
    return (BRAND.contains("vivo")) || (BRAND.contains("bbk"));
  }
  
  public static boolean isVivoX9()
  {
    return Build.MODEL.contains("vivo X9");
  }
  
  public static boolean isXiaomi()
  {
    return BRAND.contains("xiaomi");
  }
  
  public static boolean isZuk()
  {
    return BRAND.contains("zuk");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.BrandUtil
 * JD-Core Version:    0.7.0.1
 */