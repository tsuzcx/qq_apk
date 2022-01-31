package com.tencent.mobileqq.app;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.StatFs;
import android.telephony.TelephonyManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import ctj;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;

public class InjectUtils
{
  public static final String a = "Success";
  private static final String[] a = { "exlibs.1.jar" };
  private static final String[] b = { "Foo" };
  
  public static long a(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    long l = 0L;
    byte[] arrayOfByte = new byte[8192];
    for (;;)
    {
      int i = paramInputStream.read(arrayOfByte, 0, arrayOfByte.length);
      if (i == -1) {
        break;
      }
      paramOutputStream.write(arrayOfByte, 0, i);
      l += i;
    }
    return l;
  }
  
  @SuppressLint({"SdCardPath"})
  private static File a(String paramString)
  {
    File localFile = new File(BaseApplicationImpl.a.getFilesDir(), paramString);
    Object localObject = localFile;
    if (!localFile.exists())
    {
      localFile = new File(BaseApplicationImpl.a.getFilesDir(), paramString);
      localObject = localFile;
      if (!localFile.exists())
      {
        paramString = new File("/data/data/com.tencent.qqlite/files", paramString);
        localObject = paramString;
        if (!paramString.exists()) {
          localObject = null;
        }
      }
    }
    return localObject;
  }
  
  /* Error */
  private static String a(Application paramApplication, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: aconst_null
    //   4: astore 7
    //   6: ldc 8
    //   8: astore 6
    //   10: new 45	java/io/File
    //   13: dup
    //   14: aload_0
    //   15: invokevirtual 75	android/app/Application:getFilesDir	()Ljava/io/File;
    //   18: aload_1
    //   19: invokespecial 57	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   22: astore_3
    //   23: new 45	java/io/File
    //   26: dup
    //   27: aload_0
    //   28: invokevirtual 75	android/app/Application:getFilesDir	()Ljava/io/File;
    //   31: aload_2
    //   32: invokespecial 57	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   35: astore 9
    //   37: aload_0
    //   38: invokevirtual 79	android/app/Application:getAssets	()Landroid/content/res/AssetManager;
    //   41: aload_1
    //   42: invokevirtual 85	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   45: astore_1
    //   46: new 87	java/io/FileOutputStream
    //   49: dup
    //   50: aload_3
    //   51: iconst_0
    //   52: invokespecial 90	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   55: astore_3
    //   56: aload_3
    //   57: astore 5
    //   59: aload_1
    //   60: astore 4
    //   62: aload_1
    //   63: aload_3
    //   64: invokestatic 92	com/tencent/mobileqq/app/InjectUtils:a	(Ljava/io/InputStream;Ljava/io/OutputStream;)J
    //   67: pop2
    //   68: aload_1
    //   69: ifnull +7 -> 76
    //   72: aload_1
    //   73: invokevirtual 95	java/io/InputStream:close	()V
    //   76: aload 6
    //   78: astore 4
    //   80: aload_3
    //   81: ifnull +11 -> 92
    //   84: aload_3
    //   85: invokevirtual 96	java/io/OutputStream:close	()V
    //   88: aload 6
    //   90: astore 4
    //   92: ldc 8
    //   94: aload 4
    //   96: invokevirtual 100	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   99: ifeq +383 -> 482
    //   102: aload_0
    //   103: invokevirtual 79	android/app/Application:getAssets	()Landroid/content/res/AssetManager;
    //   106: aload_2
    //   107: invokevirtual 85	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   110: astore_0
    //   111: new 87	java/io/FileOutputStream
    //   114: dup
    //   115: aload 9
    //   117: iconst_0
    //   118: invokespecial 90	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   121: astore_1
    //   122: aload_0
    //   123: aload_1
    //   124: invokestatic 92	com/tencent/mobileqq/app/InjectUtils:a	(Ljava/io/InputStream;Ljava/io/OutputStream;)J
    //   127: pop2
    //   128: aload_0
    //   129: ifnull +7 -> 136
    //   132: aload_0
    //   133: invokevirtual 95	java/io/InputStream:close	()V
    //   136: aload_1
    //   137: ifnull +7 -> 144
    //   140: aload_1
    //   141: invokevirtual 96	java/io/OutputStream:close	()V
    //   144: aload 4
    //   146: areturn
    //   147: astore 6
    //   149: aconst_null
    //   150: astore_3
    //   151: aconst_null
    //   152: astore_1
    //   153: aload_3
    //   154: astore 5
    //   156: aload_1
    //   157: astore 4
    //   159: aload 6
    //   161: invokevirtual 103	java/lang/Throwable:printStackTrace	()V
    //   164: aload_3
    //   165: astore 5
    //   167: aload_1
    //   168: astore 4
    //   170: aload 9
    //   172: invokevirtual 106	java/io/File:delete	()Z
    //   175: pop
    //   176: aload_3
    //   177: astore 5
    //   179: aload_1
    //   180: astore 4
    //   182: new 108	java/lang/StringBuilder
    //   185: dup
    //   186: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   189: ldc 111
    //   191: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: aload 6
    //   196: invokestatic 121	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   199: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   205: astore 6
    //   207: aload 6
    //   209: astore 5
    //   211: aload_1
    //   212: ifnull +7 -> 219
    //   215: aload_1
    //   216: invokevirtual 95	java/io/InputStream:close	()V
    //   219: aload 5
    //   221: astore 4
    //   223: aload_3
    //   224: ifnull -132 -> 92
    //   227: aload_3
    //   228: invokevirtual 96	java/io/OutputStream:close	()V
    //   231: aload 5
    //   233: astore 4
    //   235: goto -143 -> 92
    //   238: astore_1
    //   239: aload 5
    //   241: astore 4
    //   243: goto -151 -> 92
    //   246: astore_0
    //   247: aconst_null
    //   248: astore 5
    //   250: aconst_null
    //   251: astore_1
    //   252: aload_1
    //   253: ifnull +7 -> 260
    //   256: aload_1
    //   257: invokevirtual 95	java/io/InputStream:close	()V
    //   260: aload 5
    //   262: ifnull +8 -> 270
    //   265: aload 5
    //   267: invokevirtual 96	java/io/OutputStream:close	()V
    //   270: aload_0
    //   271: athrow
    //   272: astore_0
    //   273: aconst_null
    //   274: astore_1
    //   275: aload 7
    //   277: astore_2
    //   278: invokestatic 130	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   281: ifeq +30 -> 311
    //   284: ldc 132
    //   286: iconst_2
    //   287: new 108	java/lang/StringBuilder
    //   290: dup
    //   291: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   294: aload 9
    //   296: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   299: ldc 137
    //   301: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   304: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   307: aload_0
    //   308: invokestatic 141	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   311: aload_0
    //   312: invokevirtual 103	java/lang/Throwable:printStackTrace	()V
    //   315: aload_1
    //   316: ifnull +7 -> 323
    //   319: aload_1
    //   320: invokevirtual 95	java/io/InputStream:close	()V
    //   323: aload_2
    //   324: ifnull -180 -> 144
    //   327: aload_2
    //   328: invokevirtual 96	java/io/OutputStream:close	()V
    //   331: aload 4
    //   333: areturn
    //   334: astore_0
    //   335: aload 4
    //   337: areturn
    //   338: astore_0
    //   339: aconst_null
    //   340: astore_1
    //   341: aload 8
    //   343: astore_2
    //   344: aload_1
    //   345: ifnull +7 -> 352
    //   348: aload_1
    //   349: invokevirtual 95	java/io/InputStream:close	()V
    //   352: aload_2
    //   353: ifnull +7 -> 360
    //   356: aload_2
    //   357: invokevirtual 96	java/io/OutputStream:close	()V
    //   360: aload_0
    //   361: athrow
    //   362: astore_1
    //   363: goto -287 -> 76
    //   366: astore_1
    //   367: aload 6
    //   369: astore 4
    //   371: goto -279 -> 92
    //   374: astore_1
    //   375: goto -156 -> 219
    //   378: astore_1
    //   379: goto -119 -> 260
    //   382: astore_1
    //   383: goto -113 -> 270
    //   386: astore_0
    //   387: goto -251 -> 136
    //   390: astore_0
    //   391: aload 4
    //   393: areturn
    //   394: astore_0
    //   395: goto -72 -> 323
    //   398: astore_1
    //   399: goto -47 -> 352
    //   402: astore_1
    //   403: goto -43 -> 360
    //   406: astore_2
    //   407: aload_0
    //   408: astore_1
    //   409: aload_2
    //   410: astore_0
    //   411: aload 8
    //   413: astore_2
    //   414: goto -70 -> 344
    //   417: astore_2
    //   418: aload_0
    //   419: astore_3
    //   420: aload_2
    //   421: astore_0
    //   422: aload_1
    //   423: astore_2
    //   424: aload_3
    //   425: astore_1
    //   426: goto -82 -> 344
    //   429: astore_0
    //   430: goto -86 -> 344
    //   433: astore_2
    //   434: aload_0
    //   435: astore_1
    //   436: aload_2
    //   437: astore_0
    //   438: aload 7
    //   440: astore_2
    //   441: goto -163 -> 278
    //   444: astore_2
    //   445: aload_0
    //   446: astore_3
    //   447: aload_2
    //   448: astore_0
    //   449: aload_1
    //   450: astore_2
    //   451: aload_3
    //   452: astore_1
    //   453: goto -175 -> 278
    //   456: astore_0
    //   457: aconst_null
    //   458: astore 5
    //   460: goto -208 -> 252
    //   463: astore_0
    //   464: aload 4
    //   466: astore_1
    //   467: goto -215 -> 252
    //   470: astore 6
    //   472: aconst_null
    //   473: astore_3
    //   474: goto -321 -> 153
    //   477: astore 6
    //   479: goto -326 -> 153
    //   482: aconst_null
    //   483: astore_1
    //   484: aconst_null
    //   485: astore_0
    //   486: goto -358 -> 128
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	489	0	paramApplication	Application
    //   0	489	1	paramString1	String
    //   0	489	2	paramString2	String
    //   22	452	3	localObject1	Object
    //   60	405	4	localObject2	Object
    //   57	402	5	localObject3	Object
    //   8	81	6	str1	String
    //   147	48	6	localThrowable1	Throwable
    //   205	163	6	str2	String
    //   470	1	6	localThrowable2	Throwable
    //   477	1	6	localThrowable3	Throwable
    //   4	435	7	localObject4	Object
    //   1	411	8	localObject5	Object
    //   35	260	9	localFile	File
    // Exception table:
    //   from	to	target	type
    //   37	46	147	java/lang/Throwable
    //   227	231	238	java/io/IOException
    //   37	46	246	finally
    //   92	111	272	java/lang/Throwable
    //   327	331	334	java/io/IOException
    //   92	111	338	finally
    //   72	76	362	java/io/IOException
    //   84	88	366	java/io/IOException
    //   215	219	374	java/io/IOException
    //   256	260	378	java/io/IOException
    //   265	270	382	java/io/IOException
    //   132	136	386	java/io/IOException
    //   140	144	390	java/io/IOException
    //   319	323	394	java/io/IOException
    //   348	352	398	java/io/IOException
    //   356	360	402	java/io/IOException
    //   111	122	406	finally
    //   122	128	417	finally
    //   278	311	429	finally
    //   311	315	429	finally
    //   111	122	433	java/lang/Throwable
    //   122	128	444	java/lang/Throwable
    //   46	56	456	finally
    //   62	68	463	finally
    //   159	164	463	finally
    //   170	176	463	finally
    //   182	207	463	finally
    //   46	56	470	java/lang/Throwable
    //   62	68	477	java/lang/Throwable
  }
  
  public static String a(Application paramApplication, boolean paramBoolean)
  {
    Object localObject1 = "Success";
    int i = 0;
    for (;;)
    {
      Object localObject2 = localObject1;
      try
      {
        String str3;
        String str2;
        String str1;
        File localFile;
        int j;
        if (i < a.length)
        {
          str3 = a[i];
          str2 = b[i];
          str1 = str3 + ".MD5";
          localFile = new File(paramApplication.getFilesDir(), str3);
          boolean bool = a(paramApplication, str3, str1);
          if (bool) {
            break label110;
          }
          j = 1;
          localObject2 = localObject1;
          if (j == 0) {
            break label125;
          }
          if (!paramBoolean) {
            break label115;
          }
          localObject2 = null;
        }
        for (;;)
        {
          return localObject2;
          label110:
          j = 0;
          break;
          label115:
          localObject2 = a(paramApplication, str3, str1);
          label125:
          localObject1 = localObject2;
          if ("Success".equals(localObject2)) {
            localObject1 = SystemClassLoaderInjector.a(paramApplication, localFile.getAbsolutePath(), str2);
          }
          QLog.e("DexLoad", 1, (String)localObject1);
          if ("Success".equals(localObject1)) {
            break label210;
          }
          a(paramApplication, "", (String)localObject1);
          try
          {
            new File(paramApplication.getFilesDir(), str1).delete();
            localObject2 = localObject1;
          }
          catch (Exception paramApplication)
          {
            localObject2 = localObject1;
          }
        }
        label210:
        i += 1;
      }
      finally {}
    }
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2)
  {
    byte[] arrayOfByte = "9u23fh$jkf^%43hj".getBytes();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1).append("|");
    localStringBuilder.append(Build.DEVICE).append("|");
    localStringBuilder.append(Build.MANUFACTURER).append("|");
    localStringBuilder.append(Build.MODEL).append("|");
    localStringBuilder.append(Build.VERSION.SDK_INT).append("|");
    paramString1 = a();
    localStringBuilder.append(paramString1[0]).append("|").append(paramString1[1]).append("|");
    paramContext = (TelephonyManager)paramContext.getSystemService("phone");
    if (paramContext != null) {
      localStringBuilder.append(paramContext.getDeviceId()).append("|");
    }
    localStringBuilder.append(paramString2).append("|");
    new ctj(arrayOfByte, localStringBuilder.toString()).start();
  }
  
  /* Error */
  private static boolean a(Application paramApplication, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_1
    //   4: invokestatic 222	com/tencent/mobileqq/app/InjectUtils:a	(Ljava/lang/String;)Ljava/io/File;
    //   7: ifnonnull +36 -> 43
    //   10: invokestatic 130	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   13: ifeq +28 -> 41
    //   16: ldc 132
    //   18: iconst_2
    //   19: new 108	java/lang/StringBuilder
    //   22: dup
    //   23: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   26: aload_1
    //   27: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: ldc 224
    //   32: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   38: invokestatic 160	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   41: iconst_0
    //   42: ireturn
    //   43: aload_2
    //   44: invokestatic 222	com/tencent/mobileqq/app/InjectUtils:a	(Ljava/lang/String;)Ljava/io/File;
    //   47: astore 5
    //   49: aload 5
    //   51: ifnonnull +36 -> 87
    //   54: invokestatic 130	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   57: ifeq -16 -> 41
    //   60: ldc 132
    //   62: iconst_2
    //   63: new 108	java/lang/StringBuilder
    //   66: dup
    //   67: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   70: aload_2
    //   71: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: ldc 224
    //   76: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   82: invokestatic 160	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   85: iconst_0
    //   86: ireturn
    //   87: aload_0
    //   88: invokevirtual 79	android/app/Application:getAssets	()Landroid/content/res/AssetManager;
    //   91: aload_2
    //   92: invokevirtual 85	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   95: astore_0
    //   96: new 226	java/io/FileInputStream
    //   99: dup
    //   100: aload 5
    //   102: invokespecial 229	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   105: astore 4
    //   107: aload_0
    //   108: aload 4
    //   110: invokestatic 232	com/tencent/mobileqq/app/InjectUtils:a	(Ljava/io/InputStream;Ljava/io/InputStream;)Z
    //   113: istore_3
    //   114: invokestatic 130	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   117: ifeq +33 -> 150
    //   120: ldc 132
    //   122: iconst_2
    //   123: new 108	java/lang/StringBuilder
    //   126: dup
    //   127: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   130: aload 5
    //   132: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   135: ldc 234
    //   137: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: iload_3
    //   141: invokevirtual 237	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   144: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   147: invokestatic 160	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   150: aload_0
    //   151: ifnull +7 -> 158
    //   154: aload_0
    //   155: invokevirtual 95	java/io/InputStream:close	()V
    //   158: aload 4
    //   160: ifnull +8 -> 168
    //   163: aload 4
    //   165: invokevirtual 95	java/io/InputStream:close	()V
    //   168: iload_3
    //   169: ireturn
    //   170: astore_2
    //   171: aconst_null
    //   172: astore_0
    //   173: aload 4
    //   175: astore_1
    //   176: invokestatic 130	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   179: ifeq +30 -> 209
    //   182: ldc 132
    //   184: iconst_2
    //   185: new 108	java/lang/StringBuilder
    //   188: dup
    //   189: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   192: aload 5
    //   194: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   197: ldc 239
    //   199: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   205: aload_2
    //   206: invokestatic 141	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   209: aload_2
    //   210: invokevirtual 240	java/io/IOException:printStackTrace	()V
    //   213: aload_1
    //   214: ifnull +7 -> 221
    //   217: aload_1
    //   218: invokevirtual 95	java/io/InputStream:close	()V
    //   221: aload_0
    //   222: ifnull -181 -> 41
    //   225: aload_0
    //   226: invokevirtual 95	java/io/InputStream:close	()V
    //   229: iconst_0
    //   230: ireturn
    //   231: astore_0
    //   232: iconst_0
    //   233: ireturn
    //   234: astore_1
    //   235: aconst_null
    //   236: astore_2
    //   237: aconst_null
    //   238: astore_0
    //   239: aload_0
    //   240: ifnull +7 -> 247
    //   243: aload_0
    //   244: invokevirtual 95	java/io/InputStream:close	()V
    //   247: aload_2
    //   248: ifnull +7 -> 255
    //   251: aload_2
    //   252: invokevirtual 95	java/io/InputStream:close	()V
    //   255: aload_1
    //   256: athrow
    //   257: astore_0
    //   258: goto -100 -> 158
    //   261: astore_0
    //   262: goto -94 -> 168
    //   265: astore_1
    //   266: goto -45 -> 221
    //   269: astore_0
    //   270: goto -23 -> 247
    //   273: astore_0
    //   274: goto -19 -> 255
    //   277: astore_1
    //   278: aconst_null
    //   279: astore_2
    //   280: goto -41 -> 239
    //   283: astore_1
    //   284: aload 4
    //   286: astore_2
    //   287: goto -48 -> 239
    //   290: astore_2
    //   291: aload_1
    //   292: astore 4
    //   294: aload_2
    //   295: astore_1
    //   296: aload_0
    //   297: astore_2
    //   298: aload 4
    //   300: astore_0
    //   301: goto -62 -> 239
    //   304: astore_2
    //   305: aconst_null
    //   306: astore 4
    //   308: aload_0
    //   309: astore_1
    //   310: aload 4
    //   312: astore_0
    //   313: goto -137 -> 176
    //   316: astore_2
    //   317: aload_0
    //   318: astore_1
    //   319: aload 4
    //   321: astore_0
    //   322: goto -146 -> 176
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	325	0	paramApplication	Application
    //   0	325	1	paramString1	String
    //   0	325	2	paramString2	String
    //   113	56	3	bool	boolean
    //   1	319	4	localObject	Object
    //   47	146	5	localFile	File
    // Exception table:
    //   from	to	target	type
    //   87	96	170	java/io/IOException
    //   225	229	231	java/io/IOException
    //   87	96	234	finally
    //   154	158	257	java/io/IOException
    //   163	168	261	java/io/IOException
    //   217	221	265	java/io/IOException
    //   243	247	269	java/io/IOException
    //   251	255	273	java/io/IOException
    //   96	107	277	finally
    //   107	150	283	finally
    //   176	209	290	finally
    //   209	213	290	finally
    //   96	107	304	java/io/IOException
    //   107	150	316	java/io/IOException
  }
  
  private static boolean a(InputStream paramInputStream1, InputStream paramInputStream2)
  {
    Object localObject = paramInputStream1;
    if (!(paramInputStream1 instanceof BufferedInputStream)) {
      localObject = new BufferedInputStream(paramInputStream1);
    }
    paramInputStream1 = paramInputStream2;
    if (!(paramInputStream2 instanceof BufferedInputStream)) {
      paramInputStream1 = new BufferedInputStream(paramInputStream2);
    }
    for (int i = ((InputStream)localObject).read(); -1 != i; i = ((InputStream)localObject).read()) {
      if (i != paramInputStream1.read()) {
        return false;
      }
    }
    if (paramInputStream1.read() == -1) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static long[] a()
  {
    long l2 = 0L;
    try
    {
      localStatFs = new StatFs(Environment.getDataDirectory().getPath());
      i = localStatFs.getBlockSize();
      l3 = i;
    }
    catch (Throwable localThrowable1)
    {
      for (;;)
      {
        StatFs localStatFs;
        int i;
        label45:
        l1 = 0L;
        long l3 = 0L;
      }
    }
    try
    {
      i = localStatFs.getBlockCount();
      l1 = i;
    }
    catch (Throwable localThrowable2)
    {
      l1 = 0L;
      break label45;
    }
    try
    {
      i = localStatFs.getAvailableBlocks();
      l2 = i;
    }
    catch (Throwable localThrowable3)
    {
      break label45;
    }
    return new long[] { l2 * l3, l1 * l3 };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.InjectUtils
 * JD-Core Version:    0.7.0.1
 */