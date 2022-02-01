package wf7;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.StatFs;
import android.provider.Settings.Secure;
import android.provider.Settings.System;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import java.io.File;
import java.lang.reflect.Method;
import java.util.Locale;

public final class gr
{
  private static long sv = -1L;
  
  @SuppressLint({"MissingPermission"})
  public static String A(Context paramContext)
  {
    try
    {
      paramContext = ((TelephonyManager)paramContext.getSystemService("phone")).getDeviceId();
    }
    catch (Throwable paramContext)
    {
      label16:
      Object localObject;
      break label16;
    }
    paramContext = null;
    localObject = paramContext;
    if (paramContext == null) {
      localObject = "00000000000000";
    }
    return localObject;
  }
  
  public static String B(Context paramContext)
  {
    return go.u(paramContext);
  }
  
  public static String C(Context paramContext)
  {
    try
    {
      paramContext = Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      label12:
      break label12;
    }
    return "";
  }
  
  public static int D(Context paramContext)
  {
    return paramContext.getResources().getDisplayMetrics().widthPixels;
  }
  
  public static int E(Context paramContext)
  {
    return paramContext.getResources().getDisplayMetrics().heightPixels;
  }
  
  public static boolean F(Context paramContext)
  {
    return ((TelephonyManager)paramContext.getSystemService("phone")).getSimState() != 1;
  }
  
  /* Error */
  public static String K(boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 56
    //   2: astore_2
    //   3: new 88	java/io/FileInputStream
    //   6: dup
    //   7: ldc 90
    //   9: invokespecial 94	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   12: astore_3
    //   13: new 96	java/io/BufferedReader
    //   16: dup
    //   17: new 98	java/io/InputStreamReader
    //   20: dup
    //   21: aload_3
    //   22: invokespecial 101	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   25: sipush 8192
    //   28: invokespecial 104	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   31: astore 4
    //   33: new 106	java/lang/StringBuilder
    //   36: dup
    //   37: ldc 56
    //   39: invokespecial 107	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   42: astore_1
    //   43: aload 4
    //   45: invokevirtual 110	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   48: astore 5
    //   50: aload 5
    //   52: ifnull +13 -> 65
    //   55: aload_1
    //   56: aload 5
    //   58: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: pop
    //   62: goto -19 -> 43
    //   65: aload 4
    //   67: invokevirtual 117	java/io/BufferedReader:close	()V
    //   70: goto +25 -> 95
    //   73: astore_2
    //   74: aload 4
    //   76: invokevirtual 117	java/io/BufferedReader:close	()V
    //   79: aload_3
    //   80: invokevirtual 120	java/io/InputStream:close	()V
    //   83: aload_1
    //   84: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   87: pop
    //   88: aload_2
    //   89: athrow
    //   90: aload 4
    //   92: invokevirtual 117	java/io/BufferedReader:close	()V
    //   95: aload_3
    //   96: invokevirtual 120	java/io/InputStream:close	()V
    //   99: aload_1
    //   100: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   103: astore_3
    //   104: iload_0
    //   105: ifne +5 -> 110
    //   108: aload_3
    //   109: areturn
    //   110: aload_2
    //   111: astore_1
    //   112: aload_3
    //   113: ifnull +40 -> 153
    //   116: aload_2
    //   117: astore_1
    //   118: aload_3
    //   119: ldc 56
    //   121: invokevirtual 129	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   124: ifne +29 -> 153
    //   127: aload_3
    //   128: aload_3
    //   129: ldc 131
    //   131: invokevirtual 135	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   134: bipush 8
    //   136: iadd
    //   137: invokevirtual 139	java/lang/String:substring	(I)Ljava/lang/String;
    //   140: astore_1
    //   141: aload_1
    //   142: iconst_0
    //   143: aload_1
    //   144: ldc 141
    //   146: invokevirtual 135	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   149: invokevirtual 144	java/lang/String:substring	(II)Ljava/lang/String;
    //   152: astore_1
    //   153: aload_1
    //   154: areturn
    //   155: astore_1
    //   156: ldc 56
    //   158: areturn
    //   159: astore 5
    //   161: goto -71 -> 90
    //   164: astore 4
    //   166: goto -71 -> 95
    //   169: astore 4
    //   171: goto -92 -> 79
    //   174: astore_3
    //   175: goto -92 -> 83
    //   178: astore_3
    //   179: goto -80 -> 99
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	182	0	paramBoolean	boolean
    //   42	112	1	localObject1	Object
    //   155	1	1	localThrowable1	Throwable
    //   2	1	2	str1	String
    //   73	44	2	localObject2	Object
    //   12	117	3	localObject3	Object
    //   174	1	3	localThrowable2	Throwable
    //   178	1	3	localThrowable3	Throwable
    //   31	60	4	localBufferedReader	java.io.BufferedReader
    //   164	1	4	localThrowable4	Throwable
    //   169	1	4	localThrowable5	Throwable
    //   48	9	5	str2	String
    //   159	1	5	localThrowable6	Throwable
    // Exception table:
    //   from	to	target	type
    //   43	50	73	finally
    //   55	62	73	finally
    //   3	13	155	java/lang/Throwable
    //   127	153	155	java/lang/Throwable
    //   43	50	159	java/lang/Throwable
    //   55	62	159	java/lang/Throwable
    //   65	70	164	java/lang/Throwable
    //   90	95	164	java/lang/Throwable
    //   74	79	169	java/lang/Throwable
    //   79	83	174	java/lang/Throwable
    //   95	99	178	java/lang/Throwable
  }
  
  /* Error */
  public static String L(boolean paramBoolean)
  {
    // Byte code:
    //   0: iload_0
    //   1: ifeq +12 -> 13
    //   4: ldc 149
    //   6: astore_1
    //   7: ldc 151
    //   9: astore_2
    //   10: goto +9 -> 19
    //   13: ldc 153
    //   15: astore_1
    //   16: ldc 155
    //   18: astore_2
    //   19: aconst_null
    //   20: astore 4
    //   22: new 106	java/lang/StringBuilder
    //   25: dup
    //   26: invokespecial 157	java/lang/StringBuilder:<init>	()V
    //   29: astore_3
    //   30: aload_3
    //   31: aload_1
    //   32: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: pop
    //   36: aload_3
    //   37: ldc 159
    //   39: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: pop
    //   43: new 96	java/io/BufferedReader
    //   46: dup
    //   47: new 161	java/io/FileReader
    //   50: dup
    //   51: aload_3
    //   52: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   55: invokespecial 162	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   58: invokespecial 165	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   61: astore_3
    //   62: aload_3
    //   63: invokevirtual 110	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   66: astore 5
    //   68: aload 5
    //   70: ifnull +97 -> 167
    //   73: aload 5
    //   75: invokevirtual 168	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   78: aload_2
    //   79: invokevirtual 129	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   82: ifeq +85 -> 167
    //   85: new 106	java/lang/StringBuilder
    //   88: dup
    //   89: invokespecial 157	java/lang/StringBuilder:<init>	()V
    //   92: astore_2
    //   93: aload_2
    //   94: aload_1
    //   95: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: pop
    //   99: aload_2
    //   100: ldc 170
    //   102: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: pop
    //   106: new 96	java/io/BufferedReader
    //   109: dup
    //   110: new 161	java/io/FileReader
    //   113: dup
    //   114: aload_2
    //   115: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   118: invokespecial 162	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   121: invokespecial 165	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   124: astore_1
    //   125: aload_1
    //   126: invokevirtual 110	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   129: astore 4
    //   131: aload_1
    //   132: astore_2
    //   133: aload 4
    //   135: ifnull +34 -> 169
    //   138: aload 4
    //   140: invokevirtual 173	java/lang/String:trim	()Ljava/lang/String;
    //   143: astore_2
    //   144: aload_3
    //   145: invokevirtual 117	java/io/BufferedReader:close	()V
    //   148: aload_1
    //   149: invokevirtual 117	java/io/BufferedReader:close	()V
    //   152: aload_2
    //   153: areturn
    //   154: astore 4
    //   156: aload_1
    //   157: astore_2
    //   158: aload 4
    //   160: astore_1
    //   161: goto +42 -> 203
    //   164: goto +64 -> 228
    //   167: aconst_null
    //   168: astore_2
    //   169: aload_3
    //   170: invokevirtual 117	java/io/BufferedReader:close	()V
    //   173: aload_2
    //   174: ifnull +72 -> 246
    //   177: aload_2
    //   178: astore_1
    //   179: aload_1
    //   180: invokevirtual 117	java/io/BufferedReader:close	()V
    //   183: aconst_null
    //   184: areturn
    //   185: astore_1
    //   186: aload 4
    //   188: astore_2
    //   189: goto +14 -> 203
    //   192: aconst_null
    //   193: astore_1
    //   194: goto +34 -> 228
    //   197: astore_1
    //   198: aconst_null
    //   199: astore_3
    //   200: aload 4
    //   202: astore_2
    //   203: aload_3
    //   204: ifnull +10 -> 214
    //   207: aload_3
    //   208: invokevirtual 117	java/io/BufferedReader:close	()V
    //   211: goto +3 -> 214
    //   214: aload_2
    //   215: ifnull +7 -> 222
    //   218: aload_2
    //   219: invokevirtual 117	java/io/BufferedReader:close	()V
    //   222: aload_1
    //   223: athrow
    //   224: aconst_null
    //   225: astore_1
    //   226: aload_1
    //   227: astore_3
    //   228: aload_3
    //   229: ifnull +10 -> 239
    //   232: aload_3
    //   233: invokevirtual 117	java/io/BufferedReader:close	()V
    //   236: goto +3 -> 239
    //   239: aload_1
    //   240: ifnull +6 -> 246
    //   243: goto -64 -> 179
    //   246: aconst_null
    //   247: areturn
    //   248: astore_1
    //   249: goto -25 -> 224
    //   252: astore_1
    //   253: goto -61 -> 192
    //   256: astore_2
    //   257: goto -93 -> 164
    //   260: astore_3
    //   261: goto -113 -> 148
    //   264: astore_1
    //   265: aload_2
    //   266: areturn
    //   267: astore_1
    //   268: goto -95 -> 173
    //   271: astore_1
    //   272: aconst_null
    //   273: areturn
    //   274: astore_3
    //   275: goto -61 -> 214
    //   278: astore_2
    //   279: goto -57 -> 222
    //   282: astore_2
    //   283: goto -44 -> 239
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	286	0	paramBoolean	boolean
    //   6	174	1	localObject1	Object
    //   185	1	1	localObject2	Object
    //   193	1	1	localObject3	Object
    //   197	26	1	localObject4	Object
    //   225	15	1	localObject5	Object
    //   248	1	1	localThrowable1	Throwable
    //   252	1	1	localThrowable2	Throwable
    //   264	1	1	localIOException1	java.io.IOException
    //   267	1	1	localIOException2	java.io.IOException
    //   271	1	1	localIOException3	java.io.IOException
    //   9	210	2	localObject6	Object
    //   256	10	2	localThrowable3	Throwable
    //   278	1	2	localIOException4	java.io.IOException
    //   282	1	2	localIOException5	java.io.IOException
    //   29	204	3	localObject7	Object
    //   260	1	3	localIOException6	java.io.IOException
    //   274	1	3	localIOException7	java.io.IOException
    //   20	119	4	str1	String
    //   154	47	4	localObject8	Object
    //   66	8	5	str2	String
    // Exception table:
    //   from	to	target	type
    //   125	131	154	finally
    //   138	144	154	finally
    //   62	68	185	finally
    //   73	125	185	finally
    //   22	62	197	finally
    //   22	62	248	java/lang/Throwable
    //   62	68	252	java/lang/Throwable
    //   73	125	252	java/lang/Throwable
    //   125	131	256	java/lang/Throwable
    //   138	144	256	java/lang/Throwable
    //   144	148	260	java/io/IOException
    //   148	152	264	java/io/IOException
    //   169	173	267	java/io/IOException
    //   179	183	271	java/io/IOException
    //   207	211	274	java/io/IOException
    //   218	222	278	java/io/IOException
    //   232	236	282	java/io/IOException
  }
  
  public static String U(String paramString)
  {
    try
    {
      Method localMethod = Class.forName("android.os.SystemProperties").getMethod("get", new Class[] { String.class });
      localMethod.setAccessible(true);
      paramString = (String)localMethod.invoke(null, new Object[] { paramString });
      if (paramString == null) {
        return "";
      }
      return paramString;
    }
    catch (Throwable paramString) {}
    return "";
  }
  
  public static void a(File paramFile, gr.a parama)
  {
    try
    {
      paramFile = new StatFs(paramFile.getPath());
      long l = paramFile.getBlockSize();
      parama.sw = (paramFile.getAvailableBlocks() * l);
      parama.sx = (paramFile.getBlockCount() * l);
      return;
    }
    catch (Exception paramFile) {}
  }
  
  public static void a(gr.a parama)
  {
    a(Environment.getDataDirectory(), parama);
  }
  
  public static boolean a(Context paramContext, String paramString1, String paramString2)
  {
    try
    {
      boolean bool = Settings.System.putString(paramContext.getContentResolver(), paramString1, paramString2);
      return bool;
    }
    catch (Throwable paramContext)
    {
      label12:
      break label12;
    }
    return false;
  }
  
  public static void b(gr.a parama)
  {
    if (gk.eV())
    {
      a(Environment.getExternalStorageDirectory(), parama);
      return;
    }
    parama.sw = 0L;
    parama.sx = 0L;
  }
  
  public static String d(Context paramContext, String paramString)
  {
    try
    {
      paramContext = Settings.System.getString(paramContext.getContentResolver(), paramString);
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      label11:
      break label11;
    }
    return null;
  }
  
  public static String eZ()
  {
    return Build.MODEL;
  }
  
  public static String fa()
  {
    return Build.VERSION.INCREMENTAL;
  }
  
  public static String fb()
  {
    return Build.VERSION.RELEASE;
  }
  
  public static String fc()
  {
    return Build.BRAND;
  }
  
  public static String fd()
  {
    return Build.DEVICE;
  }
  
  public static String fe()
  {
    return Build.BOARD;
  }
  
  public static String ff()
  {
    String str2 = Build.MANUFACTURER;
    String str1 = str2;
    if (str2 == null) {
      str1 = "UNKNOWN";
    }
    return str1;
  }
  
  public static String fg()
  {
    String str1;
    for (Object localObject = null;; str1 = null)
    {
      try
      {
        String str2 = Build.MANUFACTURER;
        if (TextUtils.isEmpty(str2)) {
          return null;
        }
        str2 = str2.toLowerCase(Locale.ENGLISH);
        if (str2.contains("huawei")) {
          return U("ro.build.version.emui");
        }
        if (str2.contains("xiaomi")) {
          return U("ro.miui.ui.version.name");
        }
        boolean bool = str2.contains("gionee");
        if (bool)
        {
          localObject = U("ro.gn.extvernumber");
          if (TextUtils.isEmpty((CharSequence)localObject)) {
            return U("ro.build.display.id");
          }
        }
        else
        {
          bool = str2.contains("vivo");
          if (bool)
          {
            localObject = U("ro.vivo.os.name");
            str2 = U("ro.vivo.os.version");
            if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!TextUtils.isEmpty(str2)))
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append((String)localObject);
              localStringBuilder.append("_");
              localStringBuilder.append(str2);
              return localStringBuilder.toString();
            }
            return U("ro.vivo.os.build.display.id");
          }
          if (str2.contains("meizu")) {
            return U("ro.build.display.id");
          }
          if (str2.contains("lenovo"))
          {
            localObject = U("ro.lenovo.lvp.version");
            if (TextUtils.isEmpty((CharSequence)localObject)) {
              continue;
            }
            localObject = ((String)localObject).split("_");
            if ((localObject == null) || (localObject.length <= 0)) {
              continue;
            }
            localObject = localObject[0];
            if (!TextUtils.isEmpty((CharSequence)localObject)) {
              break;
            }
            return U("ro.build.version.incremental");
          }
          if (str2.contains("letv")) {
            localObject = U("ro.letv.eui");
          }
          return localObject;
        }
      }
      catch (Exception localException)
      {
        return null;
      }
      return localException;
    }
    return str1;
  }
  
  /* Error */
  public static long fh()
  {
    // Byte code:
    //   0: getstatic 362	wf7/gr:sv	J
    //   3: ldc2_w 7
    //   6: lcmp
    //   7: ifne +250 -> 257
    //   10: new 207	java/io/File
    //   13: dup
    //   14: ldc_w 364
    //   17: invokespecial 365	java/io/File:<init>	(Ljava/lang/String;)V
    //   20: astore_3
    //   21: aconst_null
    //   22: astore 4
    //   24: aconst_null
    //   25: astore 5
    //   27: aconst_null
    //   28: astore 6
    //   30: aconst_null
    //   31: astore 7
    //   33: aconst_null
    //   34: astore_2
    //   35: aload_3
    //   36: invokevirtual 368	java/io/File:exists	()Z
    //   39: ifeq +218 -> 257
    //   42: new 370	java/io/DataInputStream
    //   45: dup
    //   46: new 88	java/io/FileInputStream
    //   49: dup
    //   50: aload_3
    //   51: invokespecial 373	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   54: invokespecial 374	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   57: astore_3
    //   58: aload_3
    //   59: invokevirtual 375	java/io/DataInputStream:readLine	()Ljava/lang/String;
    //   62: astore_2
    //   63: aload_2
    //   64: ifnull +36 -> 100
    //   67: aload_2
    //   68: invokevirtual 173	java/lang/String:trim	()Ljava/lang/String;
    //   71: ldc_w 377
    //   74: invokevirtual 348	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   77: iconst_1
    //   78: aaload
    //   79: invokestatic 383	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   82: putstatic 362	wf7/gr:sv	J
    //   85: aload_3
    //   86: invokevirtual 384	java/io/DataInputStream:close	()V
    //   89: goto +168 -> 257
    //   92: astore_2
    //   93: aload_2
    //   94: invokevirtual 387	java/io/IOException:printStackTrace	()V
    //   97: goto +160 -> 257
    //   100: new 147	java/io/IOException
    //   103: dup
    //   104: ldc_w 389
    //   107: invokespecial 390	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   110: athrow
    //   111: astore_2
    //   112: goto +127 -> 239
    //   115: astore 4
    //   117: goto +35 -> 152
    //   120: astore 4
    //   122: goto +53 -> 175
    //   125: astore 4
    //   127: goto +71 -> 198
    //   130: astore 4
    //   132: goto +89 -> 221
    //   135: astore 4
    //   137: aload_2
    //   138: astore_3
    //   139: aload 4
    //   141: astore_2
    //   142: goto +97 -> 239
    //   145: astore_2
    //   146: aload 4
    //   148: astore_3
    //   149: aload_2
    //   150: astore 4
    //   152: aload_3
    //   153: astore_2
    //   154: aload 4
    //   156: invokevirtual 391	java/lang/Throwable:printStackTrace	()V
    //   159: aload_3
    //   160: ifnull +97 -> 257
    //   163: aload_3
    //   164: invokevirtual 384	java/io/DataInputStream:close	()V
    //   167: goto +90 -> 257
    //   170: astore 4
    //   172: aload 5
    //   174: astore_3
    //   175: aload_3
    //   176: astore_2
    //   177: aload 4
    //   179: invokevirtual 392	java/lang/NumberFormatException:printStackTrace	()V
    //   182: aload_3
    //   183: ifnull +74 -> 257
    //   186: aload_3
    //   187: invokevirtual 384	java/io/DataInputStream:close	()V
    //   190: goto +67 -> 257
    //   193: astore 4
    //   195: aload 6
    //   197: astore_3
    //   198: aload_3
    //   199: astore_2
    //   200: aload 4
    //   202: invokevirtual 387	java/io/IOException:printStackTrace	()V
    //   205: aload_3
    //   206: ifnull +51 -> 257
    //   209: aload_3
    //   210: invokevirtual 384	java/io/DataInputStream:close	()V
    //   213: goto +44 -> 257
    //   216: astore 4
    //   218: aload 7
    //   220: astore_3
    //   221: aload_3
    //   222: astore_2
    //   223: aload 4
    //   225: invokevirtual 393	java/io/FileNotFoundException:printStackTrace	()V
    //   228: aload_3
    //   229: ifnull +28 -> 257
    //   232: aload_3
    //   233: invokevirtual 384	java/io/DataInputStream:close	()V
    //   236: goto +21 -> 257
    //   239: aload_3
    //   240: ifnull +15 -> 255
    //   243: aload_3
    //   244: invokevirtual 384	java/io/DataInputStream:close	()V
    //   247: goto +8 -> 255
    //   250: astore_3
    //   251: aload_3
    //   252: invokevirtual 387	java/io/IOException:printStackTrace	()V
    //   255: aload_2
    //   256: athrow
    //   257: getstatic 362	wf7/gr:sv	J
    //   260: lstore_0
    //   261: lload_0
    //   262: lconst_0
    //   263: lcmp
    //   264: ifle +5 -> 269
    //   267: lload_0
    //   268: lreturn
    //   269: lconst_1
    //   270: lreturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   260	8	0	l	long
    //   34	34	2	str	String
    //   92	2	2	localIOException1	java.io.IOException
    //   111	27	2	localObject1	Object
    //   141	1	2	localObject2	Object
    //   145	5	2	localThrowable1	Throwable
    //   153	103	2	localObject3	Object
    //   20	224	3	localObject4	Object
    //   250	2	3	localIOException2	java.io.IOException
    //   22	1	4	localObject5	Object
    //   115	1	4	localThrowable2	Throwable
    //   120	1	4	localNumberFormatException1	java.lang.NumberFormatException
    //   125	1	4	localIOException3	java.io.IOException
    //   130	1	4	localFileNotFoundException1	java.io.FileNotFoundException
    //   135	12	4	localObject6	Object
    //   150	5	4	localObject7	Object
    //   170	8	4	localNumberFormatException2	java.lang.NumberFormatException
    //   193	8	4	localIOException4	java.io.IOException
    //   216	8	4	localFileNotFoundException2	java.io.FileNotFoundException
    //   25	148	5	localObject8	Object
    //   28	168	6	localObject9	Object
    //   31	188	7	localObject10	Object
    // Exception table:
    //   from	to	target	type
    //   85	89	92	java/io/IOException
    //   163	167	92	java/io/IOException
    //   186	190	92	java/io/IOException
    //   209	213	92	java/io/IOException
    //   232	236	92	java/io/IOException
    //   58	63	111	finally
    //   67	85	111	finally
    //   100	111	111	finally
    //   58	63	115	java/lang/Throwable
    //   67	85	115	java/lang/Throwable
    //   100	111	115	java/lang/Throwable
    //   58	63	120	java/lang/NumberFormatException
    //   67	85	120	java/lang/NumberFormatException
    //   100	111	120	java/lang/NumberFormatException
    //   58	63	125	java/io/IOException
    //   67	85	125	java/io/IOException
    //   100	111	125	java/io/IOException
    //   58	63	130	java/io/FileNotFoundException
    //   67	85	130	java/io/FileNotFoundException
    //   100	111	130	java/io/FileNotFoundException
    //   42	58	135	finally
    //   154	159	135	finally
    //   177	182	135	finally
    //   200	205	135	finally
    //   223	228	135	finally
    //   42	58	145	java/lang/Throwable
    //   42	58	170	java/lang/NumberFormatException
    //   42	58	193	java/io/IOException
    //   42	58	216	java/io/FileNotFoundException
    //   243	247	250	java/io/IOException
  }
  
  public static String getRadioVersion()
  {
    try
    {
      String str = (String)Class.forName("android.os.Build").getMethod("getRadioVersion", new Class[0]).invoke(null, new Object[0]);
      return str;
    }
    catch (Throwable localThrowable)
    {
      label30:
      break label30;
    }
    return "";
  }
  
  public static String k(Context paramContext)
  {
    return fg.k(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wf7.gr
 * JD-Core Version:    0.7.0.1
 */