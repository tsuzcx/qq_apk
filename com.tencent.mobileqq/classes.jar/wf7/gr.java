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
      Object localObject = paramContext;
      if (paramContext == null) {
        localObject = "00000000000000";
      }
      return localObject;
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        paramContext = null;
      }
    }
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
    catch (Throwable paramContext) {}
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
    //   0: new 90	java/io/FileInputStream
    //   3: dup
    //   4: ldc 92
    //   6: invokespecial 96	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   9: astore_2
    //   10: new 98	java/io/BufferedReader
    //   13: dup
    //   14: new 100	java/io/InputStreamReader
    //   17: dup
    //   18: aload_2
    //   19: invokespecial 103	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   22: sipush 8192
    //   25: invokespecial 106	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   28: astore_3
    //   29: new 108	java/lang/StringBuilder
    //   32: dup
    //   33: ldc 58
    //   35: invokespecial 109	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   38: astore_1
    //   39: aload_3
    //   40: invokevirtual 112	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   43: astore 4
    //   45: aload 4
    //   47: ifnull +46 -> 93
    //   50: aload_1
    //   51: aload 4
    //   53: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: pop
    //   57: goto -18 -> 39
    //   60: astore 4
    //   62: aload_3
    //   63: ifnull +7 -> 70
    //   66: aload_3
    //   67: invokevirtual 119	java/io/BufferedReader:close	()V
    //   70: aload_2
    //   71: ifnull +7 -> 78
    //   74: aload_2
    //   75: invokevirtual 122	java/io/InputStream:close	()V
    //   78: aload_1
    //   79: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   82: astore_1
    //   83: iload_0
    //   84: ifne +59 -> 143
    //   87: aload_1
    //   88: areturn
    //   89: astore_1
    //   90: ldc 58
    //   92: areturn
    //   93: aload_3
    //   94: ifnull +7 -> 101
    //   97: aload_3
    //   98: invokevirtual 119	java/io/BufferedReader:close	()V
    //   101: aload_2
    //   102: ifnull +7 -> 109
    //   105: aload_2
    //   106: invokevirtual 122	java/io/InputStream:close	()V
    //   109: aload_1
    //   110: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   113: astore_1
    //   114: goto -31 -> 83
    //   117: astore 4
    //   119: aload_3
    //   120: ifnull +7 -> 127
    //   123: aload_3
    //   124: invokevirtual 119	java/io/BufferedReader:close	()V
    //   127: aload_2
    //   128: ifnull +7 -> 135
    //   131: aload_2
    //   132: invokevirtual 122	java/io/InputStream:close	()V
    //   135: aload_1
    //   136: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   139: pop
    //   140: aload 4
    //   142: athrow
    //   143: aload_1
    //   144: ifnull +71 -> 215
    //   147: aload_1
    //   148: ldc 58
    //   150: invokevirtual 131	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   153: ifne +62 -> 215
    //   156: aload_1
    //   157: aload_1
    //   158: ldc 133
    //   160: invokevirtual 137	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   163: ldc 133
    //   165: invokevirtual 140	java/lang/String:length	()I
    //   168: iadd
    //   169: invokevirtual 144	java/lang/String:substring	(I)Ljava/lang/String;
    //   172: astore_1
    //   173: aload_1
    //   174: iconst_0
    //   175: aload_1
    //   176: ldc 146
    //   178: invokevirtual 137	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   181: invokevirtual 149	java/lang/String:substring	(II)Ljava/lang/String;
    //   184: astore_1
    //   185: aload_1
    //   186: areturn
    //   187: astore_1
    //   188: ldc 58
    //   190: areturn
    //   191: astore_3
    //   192: goto -91 -> 101
    //   195: astore_2
    //   196: goto -87 -> 109
    //   199: astore_3
    //   200: goto -130 -> 70
    //   203: astore_2
    //   204: goto -126 -> 78
    //   207: astore_3
    //   208: goto -81 -> 127
    //   211: astore_2
    //   212: goto -77 -> 135
    //   215: ldc 58
    //   217: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	218	0	paramBoolean	boolean
    //   38	50	1	localObject1	Object
    //   89	21	1	localThrowable1	Throwable
    //   113	73	1	str1	String
    //   187	1	1	localThrowable2	Throwable
    //   9	123	2	localFileInputStream	java.io.FileInputStream
    //   195	1	2	localThrowable3	Throwable
    //   203	1	2	localThrowable4	Throwable
    //   211	1	2	localThrowable5	Throwable
    //   28	96	3	localBufferedReader	java.io.BufferedReader
    //   191	1	3	localThrowable6	Throwable
    //   199	1	3	localThrowable7	Throwable
    //   207	1	3	localThrowable8	Throwable
    //   43	9	4	str2	String
    //   60	1	4	localThrowable9	Throwable
    //   117	24	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   39	45	60	java/lang/Throwable
    //   50	57	60	java/lang/Throwable
    //   0	10	89	java/lang/Throwable
    //   39	45	117	finally
    //   50	57	117	finally
    //   156	185	187	java/lang/Throwable
    //   97	101	191	java/lang/Throwable
    //   105	109	195	java/lang/Throwable
    //   66	70	199	java/lang/Throwable
    //   74	78	203	java/lang/Throwable
    //   123	127	207	java/lang/Throwable
    //   131	135	211	java/lang/Throwable
  }
  
  /* Error */
  public static String L(boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: iload_0
    //   4: ifeq +137 -> 141
    //   7: ldc 154
    //   9: astore_3
    //   10: ldc 156
    //   12: astore_2
    //   13: new 98	java/io/BufferedReader
    //   16: dup
    //   17: new 158	java/io/FileReader
    //   20: dup
    //   21: new 108	java/lang/StringBuilder
    //   24: dup
    //   25: invokespecial 160	java/lang/StringBuilder:<init>	()V
    //   28: aload_3
    //   29: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: ldc 162
    //   34: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   40: invokespecial 163	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   43: invokespecial 166	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   46: astore_1
    //   47: aload_1
    //   48: invokevirtual 112	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   51: astore 5
    //   53: aload 5
    //   55: ifnull +95 -> 150
    //   58: aload 5
    //   60: invokevirtual 169	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   63: aload_2
    //   64: invokevirtual 131	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   67: ifeq +83 -> 150
    //   70: new 98	java/io/BufferedReader
    //   73: dup
    //   74: new 158	java/io/FileReader
    //   77: dup
    //   78: new 108	java/lang/StringBuilder
    //   81: dup
    //   82: invokespecial 160	java/lang/StringBuilder:<init>	()V
    //   85: aload_3
    //   86: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: ldc 171
    //   91: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   97: invokespecial 163	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   100: invokespecial 166	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   103: astore_2
    //   104: aload_2
    //   105: invokevirtual 112	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   108: astore 4
    //   110: aload_2
    //   111: astore_3
    //   112: aload 4
    //   114: ifnull +38 -> 152
    //   117: aload 4
    //   119: invokevirtual 174	java/lang/String:trim	()Ljava/lang/String;
    //   122: astore_3
    //   123: aload_1
    //   124: ifnull +7 -> 131
    //   127: aload_1
    //   128: invokevirtual 119	java/io/BufferedReader:close	()V
    //   131: aload_2
    //   132: ifnull +7 -> 139
    //   135: aload_2
    //   136: invokevirtual 119	java/io/BufferedReader:close	()V
    //   139: aload_3
    //   140: areturn
    //   141: ldc 176
    //   143: astore_3
    //   144: ldc 178
    //   146: astore_2
    //   147: goto -134 -> 13
    //   150: aconst_null
    //   151: astore_3
    //   152: aload_1
    //   153: ifnull +7 -> 160
    //   156: aload_1
    //   157: invokevirtual 119	java/io/BufferedReader:close	()V
    //   160: aload_3
    //   161: ifnull +7 -> 168
    //   164: aload_3
    //   165: invokevirtual 119	java/io/BufferedReader:close	()V
    //   168: aconst_null
    //   169: areturn
    //   170: astore_1
    //   171: aconst_null
    //   172: astore_1
    //   173: aconst_null
    //   174: astore_2
    //   175: aload_2
    //   176: ifnull +7 -> 183
    //   179: aload_2
    //   180: invokevirtual 119	java/io/BufferedReader:close	()V
    //   183: aload_1
    //   184: ifnull -16 -> 168
    //   187: aload_1
    //   188: invokevirtual 119	java/io/BufferedReader:close	()V
    //   191: goto -23 -> 168
    //   194: astore_1
    //   195: goto -27 -> 168
    //   198: astore_2
    //   199: aconst_null
    //   200: astore_1
    //   201: aload 4
    //   203: astore_3
    //   204: aload_1
    //   205: ifnull +7 -> 212
    //   208: aload_1
    //   209: invokevirtual 119	java/io/BufferedReader:close	()V
    //   212: aload_3
    //   213: ifnull +7 -> 220
    //   216: aload_3
    //   217: invokevirtual 119	java/io/BufferedReader:close	()V
    //   220: aload_2
    //   221: athrow
    //   222: astore_1
    //   223: goto -92 -> 131
    //   226: astore_1
    //   227: aload_3
    //   228: areturn
    //   229: astore_1
    //   230: goto -70 -> 160
    //   233: astore_1
    //   234: goto -66 -> 168
    //   237: astore_2
    //   238: goto -55 -> 183
    //   241: astore_1
    //   242: goto -30 -> 212
    //   245: astore_1
    //   246: goto -26 -> 220
    //   249: astore_2
    //   250: aload 4
    //   252: astore_3
    //   253: goto -49 -> 204
    //   256: astore 4
    //   258: aload_2
    //   259: astore_3
    //   260: aload 4
    //   262: astore_2
    //   263: goto -59 -> 204
    //   266: astore_2
    //   267: aconst_null
    //   268: astore_3
    //   269: aload_1
    //   270: astore_2
    //   271: aload_3
    //   272: astore_1
    //   273: goto -98 -> 175
    //   276: astore_3
    //   277: aload_1
    //   278: astore_3
    //   279: aload_2
    //   280: astore_1
    //   281: aload_3
    //   282: astore_2
    //   283: goto -108 -> 175
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	286	0	paramBoolean	boolean
    //   46	111	1	localBufferedReader	java.io.BufferedReader
    //   170	1	1	localThrowable1	Throwable
    //   172	16	1	localObject1	Object
    //   194	1	1	localIOException1	java.io.IOException
    //   200	9	1	localObject2	Object
    //   222	1	1	localIOException2	java.io.IOException
    //   226	1	1	localIOException3	java.io.IOException
    //   229	1	1	localIOException4	java.io.IOException
    //   233	1	1	localIOException5	java.io.IOException
    //   241	1	1	localIOException6	java.io.IOException
    //   245	25	1	localIOException7	java.io.IOException
    //   272	9	1	localObject3	Object
    //   12	168	2	localObject4	Object
    //   198	23	2	localObject5	Object
    //   237	1	2	localIOException8	java.io.IOException
    //   249	10	2	localObject6	Object
    //   262	1	2	localObject7	Object
    //   266	1	2	localThrowable2	Throwable
    //   270	13	2	localObject8	Object
    //   9	263	3	localObject9	Object
    //   276	1	3	localThrowable3	Throwable
    //   278	4	3	localObject10	Object
    //   1	250	4	str1	String
    //   256	5	4	localObject11	Object
    //   51	8	5	str2	String
    // Exception table:
    //   from	to	target	type
    //   13	47	170	java/lang/Throwable
    //   187	191	194	java/io/IOException
    //   13	47	198	finally
    //   127	131	222	java/io/IOException
    //   135	139	226	java/io/IOException
    //   156	160	229	java/io/IOException
    //   164	168	233	java/io/IOException
    //   179	183	237	java/io/IOException
    //   208	212	241	java/io/IOException
    //   216	220	245	java/io/IOException
    //   47	53	249	finally
    //   58	104	249	finally
    //   104	110	256	finally
    //   117	123	256	finally
    //   47	53	266	java/lang/Throwable
    //   58	104	266	java/lang/Throwable
    //   104	110	276	java/lang/Throwable
    //   117	123	276	java/lang/Throwable
  }
  
  public static String U(String paramString)
  {
    try
    {
      Object localObject = Class.forName("android.os.SystemProperties").getMethod("get", new Class[] { String.class });
      ((Method)localObject).setAccessible(true);
      localObject = (String)((Method)localObject).invoke(null, new Object[] { paramString });
      paramString = (String)localObject;
      if (localObject == null) {
        paramString = "";
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
    catch (Throwable paramContext) {}
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
    catch (Throwable paramContext) {}
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
    Object localObject3;
    for (;;)
    {
      try
      {
        Object localObject1 = Build.MANUFACTURER;
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          return null;
        }
        localObject1 = ((String)localObject1).toLowerCase(Locale.ENGLISH);
        if (((String)localObject1).contains("huawei")) {
          return U("ro.build.version.emui");
        }
        if (((String)localObject1).contains("xiaomi")) {
          return U("ro.miui.ui.version.name");
        }
        if (((String)localObject1).contains("gionee"))
        {
          localObject1 = U("ro.gn.extvernumber");
          localObject3 = localObject1;
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            break;
          }
          return U("ro.build.display.id");
        }
        if (((String)localObject1).contains("vivo"))
        {
          localObject1 = U("ro.vivo.os.name");
          localObject3 = U("ro.vivo.os.version");
          if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty((CharSequence)localObject3))) {
            return (String)localObject1 + "_" + (String)localObject3;
          }
          return U("ro.vivo.os.build.display.id");
        }
        if (((String)localObject1).contains("meizu")) {
          return U("ro.build.display.id");
        }
        if (((String)localObject1).contains("lenovo"))
        {
          localObject1 = U("ro.lenovo.lvp.version");
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            break label258;
          }
          localObject1 = ((String)localObject1).split("_");
          if ((localObject1 == null) || (localObject1.length <= 0)) {
            break label258;
          }
          localObject1 = localObject1[0];
          localObject3 = localObject1;
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            break;
          }
          return U("ro.build.version.incremental");
        }
        if (((String)localObject1).contains("letv"))
        {
          localObject1 = U("ro.letv.eui");
          return localObject1;
        }
      }
      catch (Exception localException) {}
      return null;
      label258:
      Object localObject2 = null;
    }
    return localObject3;
  }
  
  /* Error */
  public static long fh()
  {
    // Byte code:
    //   0: getstatic 12	wf7/gr:sv	J
    //   3: ldc2_w 9
    //   6: lcmp
    //   7: ifne +76 -> 83
    //   10: new 212	java/io/File
    //   13: dup
    //   14: ldc_w 367
    //   17: invokespecial 368	java/io/File:<init>	(Ljava/lang/String;)V
    //   20: astore_0
    //   21: aload_0
    //   22: invokevirtual 371	java/io/File:exists	()Z
    //   25: ifeq +58 -> 83
    //   28: new 373	java/io/DataInputStream
    //   31: dup
    //   32: new 90	java/io/FileInputStream
    //   35: dup
    //   36: aload_0
    //   37: invokespecial 376	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   40: invokespecial 377	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   43: astore_1
    //   44: aload_1
    //   45: astore_0
    //   46: aload_1
    //   47: invokevirtual 378	java/io/DataInputStream:readLine	()Ljava/lang/String;
    //   50: astore_2
    //   51: aload_2
    //   52: ifnonnull +43 -> 95
    //   55: aload_1
    //   56: astore_0
    //   57: new 152	java/io/IOException
    //   60: dup
    //   61: ldc_w 380
    //   64: invokespecial 381	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   67: athrow
    //   68: astore_2
    //   69: aload_1
    //   70: astore_0
    //   71: aload_2
    //   72: invokevirtual 384	java/io/FileNotFoundException:printStackTrace	()V
    //   75: aload_1
    //   76: ifnull +7 -> 83
    //   79: aload_1
    //   80: invokevirtual 385	java/io/DataInputStream:close	()V
    //   83: getstatic 12	wf7/gr:sv	J
    //   86: lconst_0
    //   87: lcmp
    //   88: ifle +159 -> 247
    //   91: getstatic 12	wf7/gr:sv	J
    //   94: lreturn
    //   95: aload_1
    //   96: astore_0
    //   97: aload_2
    //   98: invokevirtual 174	java/lang/String:trim	()Ljava/lang/String;
    //   101: ldc_w 387
    //   104: invokevirtual 353	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   107: iconst_1
    //   108: aaload
    //   109: invokestatic 393	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   112: putstatic 12	wf7/gr:sv	J
    //   115: aload_1
    //   116: ifnull -33 -> 83
    //   119: aload_1
    //   120: invokevirtual 385	java/io/DataInputStream:close	()V
    //   123: goto -40 -> 83
    //   126: astore_0
    //   127: aload_0
    //   128: invokevirtual 394	java/io/IOException:printStackTrace	()V
    //   131: goto -48 -> 83
    //   134: astore_0
    //   135: aload_0
    //   136: invokevirtual 394	java/io/IOException:printStackTrace	()V
    //   139: goto -56 -> 83
    //   142: astore_2
    //   143: aconst_null
    //   144: astore_1
    //   145: aload_1
    //   146: astore_0
    //   147: aload_2
    //   148: invokevirtual 394	java/io/IOException:printStackTrace	()V
    //   151: aload_1
    //   152: ifnull -69 -> 83
    //   155: aload_1
    //   156: invokevirtual 385	java/io/DataInputStream:close	()V
    //   159: goto -76 -> 83
    //   162: astore_0
    //   163: aload_0
    //   164: invokevirtual 394	java/io/IOException:printStackTrace	()V
    //   167: goto -84 -> 83
    //   170: astore_2
    //   171: aconst_null
    //   172: astore_1
    //   173: aload_1
    //   174: astore_0
    //   175: aload_2
    //   176: invokevirtual 395	java/lang/NumberFormatException:printStackTrace	()V
    //   179: aload_1
    //   180: ifnull -97 -> 83
    //   183: aload_1
    //   184: invokevirtual 385	java/io/DataInputStream:close	()V
    //   187: goto -104 -> 83
    //   190: astore_0
    //   191: aload_0
    //   192: invokevirtual 394	java/io/IOException:printStackTrace	()V
    //   195: goto -112 -> 83
    //   198: astore_2
    //   199: aconst_null
    //   200: astore_1
    //   201: aload_1
    //   202: astore_0
    //   203: aload_2
    //   204: invokevirtual 396	java/lang/Throwable:printStackTrace	()V
    //   207: aload_1
    //   208: ifnull -125 -> 83
    //   211: aload_1
    //   212: invokevirtual 385	java/io/DataInputStream:close	()V
    //   215: goto -132 -> 83
    //   218: astore_0
    //   219: aload_0
    //   220: invokevirtual 394	java/io/IOException:printStackTrace	()V
    //   223: goto -140 -> 83
    //   226: astore_1
    //   227: aconst_null
    //   228: astore_0
    //   229: aload_0
    //   230: ifnull +7 -> 237
    //   233: aload_0
    //   234: invokevirtual 385	java/io/DataInputStream:close	()V
    //   237: aload_1
    //   238: athrow
    //   239: astore_0
    //   240: aload_0
    //   241: invokevirtual 394	java/io/IOException:printStackTrace	()V
    //   244: goto -7 -> 237
    //   247: lconst_1
    //   248: lreturn
    //   249: astore_1
    //   250: goto -21 -> 229
    //   253: astore_2
    //   254: goto -53 -> 201
    //   257: astore_2
    //   258: goto -85 -> 173
    //   261: astore_2
    //   262: goto -117 -> 145
    //   265: astore_2
    //   266: aconst_null
    //   267: astore_1
    //   268: goto -199 -> 69
    // Local variable table:
    //   start	length	slot	name	signature
    //   20	77	0	localObject1	Object
    //   126	2	0	localIOException1	java.io.IOException
    //   134	2	0	localIOException2	java.io.IOException
    //   146	1	0	localObject2	Object
    //   162	2	0	localIOException3	java.io.IOException
    //   174	1	0	localObject3	Object
    //   190	2	0	localIOException4	java.io.IOException
    //   202	1	0	localObject4	Object
    //   218	2	0	localIOException5	java.io.IOException
    //   228	6	0	localObject5	Object
    //   239	2	0	localIOException6	java.io.IOException
    //   43	169	1	localDataInputStream	java.io.DataInputStream
    //   226	12	1	localObject6	Object
    //   249	1	1	localObject7	Object
    //   267	1	1	localObject8	Object
    //   50	2	2	str	String
    //   68	30	2	localFileNotFoundException1	java.io.FileNotFoundException
    //   142	6	2	localIOException7	java.io.IOException
    //   170	6	2	localNumberFormatException1	java.lang.NumberFormatException
    //   198	6	2	localThrowable1	Throwable
    //   253	1	2	localThrowable2	Throwable
    //   257	1	2	localNumberFormatException2	java.lang.NumberFormatException
    //   261	1	2	localIOException8	java.io.IOException
    //   265	1	2	localFileNotFoundException2	java.io.FileNotFoundException
    // Exception table:
    //   from	to	target	type
    //   46	51	68	java/io/FileNotFoundException
    //   57	68	68	java/io/FileNotFoundException
    //   97	115	68	java/io/FileNotFoundException
    //   119	123	126	java/io/IOException
    //   79	83	134	java/io/IOException
    //   28	44	142	java/io/IOException
    //   155	159	162	java/io/IOException
    //   28	44	170	java/lang/NumberFormatException
    //   183	187	190	java/io/IOException
    //   28	44	198	java/lang/Throwable
    //   211	215	218	java/io/IOException
    //   28	44	226	finally
    //   233	237	239	java/io/IOException
    //   46	51	249	finally
    //   57	68	249	finally
    //   71	75	249	finally
    //   97	115	249	finally
    //   147	151	249	finally
    //   175	179	249	finally
    //   203	207	249	finally
    //   46	51	253	java/lang/Throwable
    //   57	68	253	java/lang/Throwable
    //   97	115	253	java/lang/Throwable
    //   46	51	257	java/lang/NumberFormatException
    //   57	68	257	java/lang/NumberFormatException
    //   97	115	257	java/lang/NumberFormatException
    //   46	51	261	java/io/IOException
    //   57	68	261	java/io/IOException
    //   97	115	261	java/io/IOException
    //   28	44	265	java/io/FileNotFoundException
  }
  
  public static String getRadioVersion()
  {
    try
    {
      String str = (String)Class.forName("android.os.Build").getMethod("getRadioVersion", new Class[0]).invoke(null, new Object[0]);
      return str;
    }
    catch (Throwable localThrowable) {}
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