package com.tencent.mobileqq.app;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.StatFs;
import android.telephony.TelephonyManager;
import com.tencent.commonsdk.soload.SoLoadCore;
import com.tencent.qphone.base.util.QLog;
import fdc;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;

public class InjectUtils
{
  public static final String a = "Success";
  public static boolean a = false;
  public static final String[] a;
  private static final String jdField_b_of_type_JavaLangString = "DexLoadOat";
  private static boolean jdField_b_of_type_Boolean;
  public static final String[] b;
  private static String jdField_c_of_type_JavaLangString;
  private static final String[] jdField_c_of_type_ArrayOfJavaLangString;
  private static final String[] d = { "classes2.jar", "classes3.jar" };
  
  static
  {
    jdField_a_of_type_Boolean = false;
    jdField_c_of_type_ArrayOfJavaLangString = new String[] { "exlibs.1.jar", "exlibs.2.jar", "exlibs.3.jar", "exlibs.4.jar" };
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "Foo", "Foo2" };
    jdField_b_of_type_ArrayOfJavaLangString = new String[] { "classes2.dex", "classes3.dex" };
  }
  
  public static float a()
  {
    Object localObject = Environment.getDataDirectory().getPath();
    try
    {
      localObject = new StatFs((String)localObject);
      float f = ((StatFs)localObject).getAvailableBlocks() / 1024.0F;
      int i = ((StatFs)localObject).getBlockSize();
      return i * f;
    }
    catch (Exception localException) {}
    return -1.0F;
  }
  
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
  
  /* Error */
  private static String a(Application paramApplication, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_3
    //   5: aload_0
    //   6: invokevirtual 106	android/app/Application:getFilesDir	()Ljava/io/File;
    //   9: astore_2
    //   10: aload_2
    //   11: ifnull +74 -> 85
    //   14: aload_2
    //   15: invokevirtual 109	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   18: astore_2
    //   19: new 65	java/io/File
    //   22: dup
    //   23: aload_2
    //   24: aload_1
    //   25: invokespecial 112	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   28: astore 5
    //   30: ldc 8
    //   32: ldc 8
    //   34: invokevirtual 116	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   37: ifeq +199 -> 236
    //   40: aload_0
    //   41: invokevirtual 120	android/app/Application:getAssets	()Landroid/content/res/AssetManager;
    //   44: aload_1
    //   45: invokevirtual 126	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   48: astore_0
    //   49: new 128	java/io/FileOutputStream
    //   52: dup
    //   53: aload 5
    //   55: iconst_0
    //   56: invokespecial 131	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   59: astore_1
    //   60: aload_0
    //   61: aload_1
    //   62: invokestatic 133	com/tencent/mobileqq/app/InjectUtils:a	(Ljava/io/InputStream;Ljava/io/OutputStream;)J
    //   65: pop2
    //   66: aload_0
    //   67: ifnull +7 -> 74
    //   70: aload_0
    //   71: invokevirtual 136	java/io/InputStream:close	()V
    //   74: aload_1
    //   75: ifnull +7 -> 82
    //   78: aload_1
    //   79: invokevirtual 137	java/io/OutputStream:close	()V
    //   82: ldc 8
    //   84: areturn
    //   85: ldc 139
    //   87: astore_2
    //   88: goto -69 -> 19
    //   91: astore_0
    //   92: aconst_null
    //   93: astore_1
    //   94: aload_3
    //   95: astore_2
    //   96: invokestatic 145	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   99: ifeq +30 -> 129
    //   102: ldc 147
    //   104: iconst_2
    //   105: new 149	java/lang/StringBuilder
    //   108: dup
    //   109: invokespecial 150	java/lang/StringBuilder:<init>	()V
    //   112: aload 5
    //   114: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   117: ldc 156
    //   119: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   125: aload_0
    //   126: invokestatic 166	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   129: aload_2
    //   130: ifnull +7 -> 137
    //   133: aload_2
    //   134: invokevirtual 136	java/io/InputStream:close	()V
    //   137: aload_1
    //   138: ifnull -56 -> 82
    //   141: aload_1
    //   142: invokevirtual 137	java/io/OutputStream:close	()V
    //   145: ldc 8
    //   147: areturn
    //   148: astore_0
    //   149: ldc 8
    //   151: areturn
    //   152: astore_0
    //   153: aconst_null
    //   154: astore_1
    //   155: aload 4
    //   157: astore_2
    //   158: aload_2
    //   159: ifnull +7 -> 166
    //   162: aload_2
    //   163: invokevirtual 136	java/io/InputStream:close	()V
    //   166: aload_1
    //   167: ifnull +7 -> 174
    //   170: aload_1
    //   171: invokevirtual 137	java/io/OutputStream:close	()V
    //   174: aload_0
    //   175: athrow
    //   176: astore_0
    //   177: goto -103 -> 74
    //   180: astore_0
    //   181: ldc 8
    //   183: areturn
    //   184: astore_0
    //   185: goto -48 -> 137
    //   188: astore_2
    //   189: goto -23 -> 166
    //   192: astore_1
    //   193: goto -19 -> 174
    //   196: astore_3
    //   197: aconst_null
    //   198: astore_1
    //   199: aload_0
    //   200: astore_2
    //   201: aload_3
    //   202: astore_0
    //   203: goto -45 -> 158
    //   206: astore_3
    //   207: aload_0
    //   208: astore_2
    //   209: aload_3
    //   210: astore_0
    //   211: goto -53 -> 158
    //   214: astore_0
    //   215: goto -57 -> 158
    //   218: astore_3
    //   219: aconst_null
    //   220: astore_1
    //   221: aload_0
    //   222: astore_2
    //   223: aload_3
    //   224: astore_0
    //   225: goto -129 -> 96
    //   228: astore_3
    //   229: aload_0
    //   230: astore_2
    //   231: aload_3
    //   232: astore_0
    //   233: goto -137 -> 96
    //   236: aconst_null
    //   237: astore_1
    //   238: aconst_null
    //   239: astore_0
    //   240: goto -174 -> 66
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	243	0	paramApplication	Application
    //   0	243	1	paramString	String
    //   9	154	2	localObject1	Object
    //   188	1	2	localIOException	java.io.IOException
    //   200	31	2	localApplication	Application
    //   4	91	3	localObject2	Object
    //   196	6	3	localObject3	Object
    //   206	4	3	localObject4	Object
    //   218	6	3	localThrowable1	Throwable
    //   228	4	3	localThrowable2	Throwable
    //   1	155	4	localObject5	Object
    //   28	85	5	localFile	File
    // Exception table:
    //   from	to	target	type
    //   30	49	91	java/lang/Throwable
    //   141	145	148	java/io/IOException
    //   30	49	152	finally
    //   70	74	176	java/io/IOException
    //   78	82	180	java/io/IOException
    //   133	137	184	java/io/IOException
    //   162	166	188	java/io/IOException
    //   170	174	192	java/io/IOException
    //   49	60	196	finally
    //   60	66	206	finally
    //   96	129	214	finally
    //   49	60	218	java/lang/Throwable
    //   60	66	228	java/lang/Throwable
  }
  
  /* Error */
  private static String a(Application paramApplication, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_3
    //   5: new 65	java/io/File
    //   8: dup
    //   9: aload_0
    //   10: invokevirtual 106	android/app/Application:getFilesDir	()Ljava/io/File;
    //   13: aload_2
    //   14: invokespecial 170	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   17: astore 5
    //   19: ldc 8
    //   21: ldc 8
    //   23: invokevirtual 116	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   26: ifeq +193 -> 219
    //   29: aload_0
    //   30: invokevirtual 120	android/app/Application:getAssets	()Landroid/content/res/AssetManager;
    //   33: aload_1
    //   34: invokevirtual 126	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   37: astore_0
    //   38: new 128	java/io/FileOutputStream
    //   41: dup
    //   42: aload 5
    //   44: iconst_0
    //   45: invokespecial 131	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   48: astore_1
    //   49: aload_0
    //   50: aload_1
    //   51: invokestatic 133	com/tencent/mobileqq/app/InjectUtils:a	(Ljava/io/InputStream;Ljava/io/OutputStream;)J
    //   54: pop2
    //   55: aload_0
    //   56: ifnull +7 -> 63
    //   59: aload_0
    //   60: invokevirtual 136	java/io/InputStream:close	()V
    //   63: aload_1
    //   64: ifnull +7 -> 71
    //   67: aload_1
    //   68: invokevirtual 137	java/io/OutputStream:close	()V
    //   71: ldc 8
    //   73: areturn
    //   74: astore_0
    //   75: aconst_null
    //   76: astore_1
    //   77: aload_3
    //   78: astore_2
    //   79: invokestatic 145	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   82: ifeq +30 -> 112
    //   85: ldc 147
    //   87: iconst_2
    //   88: new 149	java/lang/StringBuilder
    //   91: dup
    //   92: invokespecial 150	java/lang/StringBuilder:<init>	()V
    //   95: aload 5
    //   97: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   100: ldc 156
    //   102: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   108: aload_0
    //   109: invokestatic 166	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   112: aload_2
    //   113: ifnull +7 -> 120
    //   116: aload_2
    //   117: invokevirtual 136	java/io/InputStream:close	()V
    //   120: aload_1
    //   121: ifnull -50 -> 71
    //   124: aload_1
    //   125: invokevirtual 137	java/io/OutputStream:close	()V
    //   128: ldc 8
    //   130: areturn
    //   131: astore_0
    //   132: ldc 8
    //   134: areturn
    //   135: astore_0
    //   136: aconst_null
    //   137: astore_1
    //   138: aload 4
    //   140: astore_2
    //   141: aload_2
    //   142: ifnull +7 -> 149
    //   145: aload_2
    //   146: invokevirtual 136	java/io/InputStream:close	()V
    //   149: aload_1
    //   150: ifnull +7 -> 157
    //   153: aload_1
    //   154: invokevirtual 137	java/io/OutputStream:close	()V
    //   157: aload_0
    //   158: athrow
    //   159: astore_0
    //   160: goto -97 -> 63
    //   163: astore_0
    //   164: ldc 8
    //   166: areturn
    //   167: astore_0
    //   168: goto -48 -> 120
    //   171: astore_2
    //   172: goto -23 -> 149
    //   175: astore_1
    //   176: goto -19 -> 157
    //   179: astore_3
    //   180: aconst_null
    //   181: astore_1
    //   182: aload_0
    //   183: astore_2
    //   184: aload_3
    //   185: astore_0
    //   186: goto -45 -> 141
    //   189: astore_3
    //   190: aload_0
    //   191: astore_2
    //   192: aload_3
    //   193: astore_0
    //   194: goto -53 -> 141
    //   197: astore_0
    //   198: goto -57 -> 141
    //   201: astore_3
    //   202: aconst_null
    //   203: astore_1
    //   204: aload_0
    //   205: astore_2
    //   206: aload_3
    //   207: astore_0
    //   208: goto -129 -> 79
    //   211: astore_3
    //   212: aload_0
    //   213: astore_2
    //   214: aload_3
    //   215: astore_0
    //   216: goto -137 -> 79
    //   219: aconst_null
    //   220: astore_1
    //   221: aconst_null
    //   222: astore_0
    //   223: goto -168 -> 55
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	226	0	paramApplication	Application
    //   0	226	1	paramString1	String
    //   0	226	2	paramString2	String
    //   4	74	3	localObject1	Object
    //   179	6	3	localObject2	Object
    //   189	4	3	localObject3	Object
    //   201	6	3	localThrowable1	Throwable
    //   211	4	3	localThrowable2	Throwable
    //   1	138	4	localObject4	Object
    //   17	79	5	localFile	File
    // Exception table:
    //   from	to	target	type
    //   19	38	74	java/lang/Throwable
    //   124	128	131	java/io/IOException
    //   19	38	135	finally
    //   59	63	159	java/io/IOException
    //   67	71	163	java/io/IOException
    //   116	120	167	java/io/IOException
    //   145	149	171	java/io/IOException
    //   153	157	175	java/io/IOException
    //   38	49	179	finally
    //   49	55	189	finally
    //   79	112	197	finally
    //   38	49	201	java/lang/Throwable
    //   49	55	211	java/lang/Throwable
  }
  
  public static String a(Application paramApplication, boolean paramBoolean)
  {
    boolean bool1 = true;
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
        if (i < jdField_c_of_type_ArrayOfJavaLangString.length)
        {
          str3 = jdField_c_of_type_ArrayOfJavaLangString[i];
          str2 = jdField_a_of_type_ArrayOfJavaLangString[i];
          str1 = str3 + ".MD5";
          localFile = new File(paramApplication.getFilesDir(), str3);
          boolean bool2 = SoLoadCore.isLibExtracted(paramApplication.getApplicationContext(), str3, str1);
          if (bool2) {
            break label118;
          }
        }
        label118:
        for (int j = 1;; j = 0)
        {
          localObject2 = localObject1;
          if (j == 0) {
            break label134;
          }
          if (!paramBoolean) {
            break;
          }
          localObject2 = null;
          return localObject2;
        }
        localObject2 = b(paramApplication, str3, str1);
        label134:
        localObject1 = localObject2;
        if ("Success".equals(localObject2)) {
          localObject1 = SystemClassLoaderInjector.a(paramApplication, localFile.getAbsolutePath(), str2, true);
        }
        QLog.e("DexLoad", 1, (String)localObject1);
        if (!"Success".equals(localObject1))
        {
          a(paramApplication, "", (String)localObject1);
          float f = a();
          if ((f > 0.0F) && (f < 250.0F)) {}
          for (paramBoolean = bool1;; paramBoolean = false)
          {
            for (;;)
            {
              jdField_a_of_type_Boolean = paramBoolean;
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
            break;
          }
        }
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
    new fdc(arrayOfByte, localStringBuilder.toString()).start();
  }
  
  public static boolean a()
  {
    if (jdField_c_of_type_JavaLangString == null)
    {
      jdField_c_of_type_JavaLangString = System.getProperty("java.vm.version");
      if ((jdField_c_of_type_JavaLangString == null) || (!jdField_c_of_type_JavaLangString.startsWith("2"))) {
        break label43;
      }
    }
    label43:
    for (boolean bool = true;; bool = false)
    {
      jdField_b_of_type_Boolean = bool;
      return jdField_b_of_type_Boolean;
    }
  }
  
  /* Error */
  private static boolean a(Application paramApplication, Context paramContext, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aload_1
    //   4: aload_3
    //   5: invokestatic 282	com/tencent/commonsdk/soload/SoLoadCore:getExistFile	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;
    //   8: astore 6
    //   10: aload 6
    //   12: ifnonnull +37 -> 49
    //   15: invokestatic 145	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   18: ifeq +29 -> 47
    //   21: ldc 14
    //   23: iconst_2
    //   24: new 149	java/lang/StringBuilder
    //   27: dup
    //   28: invokespecial 150	java/lang/StringBuilder:<init>	()V
    //   31: aload_3
    //   32: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: ldc_w 284
    //   38: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   44: invokestatic 193	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   47: iconst_0
    //   48: ireturn
    //   49: aload_0
    //   50: invokevirtual 120	android/app/Application:getAssets	()Landroid/content/res/AssetManager;
    //   53: aload_2
    //   54: invokevirtual 126	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   57: astore_0
    //   58: new 286	java/io/FileInputStream
    //   61: dup
    //   62: aload 6
    //   64: invokespecial 289	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   67: astore_3
    //   68: aload_0
    //   69: aload_3
    //   70: invokestatic 293	com/tencent/commonsdk/soload/SoLoadCore:contentEquals	(Ljava/io/InputStream;Ljava/io/InputStream;)Z
    //   73: istore 4
    //   75: invokestatic 145	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   78: ifeq +35 -> 113
    //   81: ldc 14
    //   83: iconst_2
    //   84: new 149	java/lang/StringBuilder
    //   87: dup
    //   88: invokespecial 150	java/lang/StringBuilder:<init>	()V
    //   91: aload 6
    //   93: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   96: ldc_w 295
    //   99: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: iload 4
    //   104: invokevirtual 298	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   107: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   110: invokestatic 193	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   113: aload_0
    //   114: ifnull +7 -> 121
    //   117: aload_0
    //   118: invokevirtual 136	java/io/InputStream:close	()V
    //   121: aload_3
    //   122: ifnull +7 -> 129
    //   125: aload_3
    //   126: invokevirtual 136	java/io/InputStream:close	()V
    //   129: iload 4
    //   131: ireturn
    //   132: astore_2
    //   133: aconst_null
    //   134: astore_0
    //   135: aload 5
    //   137: astore_1
    //   138: invokestatic 145	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   141: ifeq +31 -> 172
    //   144: ldc 14
    //   146: iconst_2
    //   147: new 149	java/lang/StringBuilder
    //   150: dup
    //   151: invokespecial 150	java/lang/StringBuilder:<init>	()V
    //   154: aload 6
    //   156: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   159: ldc_w 300
    //   162: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   168: aload_2
    //   169: invokestatic 166	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   172: aload_2
    //   173: invokevirtual 303	java/io/IOException:printStackTrace	()V
    //   176: aload_1
    //   177: ifnull +7 -> 184
    //   180: aload_1
    //   181: invokevirtual 136	java/io/InputStream:close	()V
    //   184: aload_0
    //   185: ifnull -138 -> 47
    //   188: aload_0
    //   189: invokevirtual 136	java/io/InputStream:close	()V
    //   192: iconst_0
    //   193: ireturn
    //   194: astore_0
    //   195: iconst_0
    //   196: ireturn
    //   197: astore_1
    //   198: aconst_null
    //   199: astore_2
    //   200: aconst_null
    //   201: astore_0
    //   202: aload_0
    //   203: ifnull +7 -> 210
    //   206: aload_0
    //   207: invokevirtual 136	java/io/InputStream:close	()V
    //   210: aload_2
    //   211: ifnull +7 -> 218
    //   214: aload_2
    //   215: invokevirtual 136	java/io/InputStream:close	()V
    //   218: aload_1
    //   219: athrow
    //   220: astore_0
    //   221: goto -100 -> 121
    //   224: astore_0
    //   225: goto -96 -> 129
    //   228: astore_1
    //   229: goto -45 -> 184
    //   232: astore_0
    //   233: goto -23 -> 210
    //   236: astore_0
    //   237: goto -19 -> 218
    //   240: astore_1
    //   241: aconst_null
    //   242: astore_2
    //   243: goto -41 -> 202
    //   246: astore_1
    //   247: aload_3
    //   248: astore_2
    //   249: goto -47 -> 202
    //   252: astore_2
    //   253: aload_1
    //   254: astore_3
    //   255: aload_2
    //   256: astore_1
    //   257: aload_0
    //   258: astore_2
    //   259: aload_3
    //   260: astore_0
    //   261: goto -59 -> 202
    //   264: astore_2
    //   265: aconst_null
    //   266: astore_3
    //   267: aload_0
    //   268: astore_1
    //   269: aload_3
    //   270: astore_0
    //   271: goto -133 -> 138
    //   274: astore_2
    //   275: aload_0
    //   276: astore_1
    //   277: aload_3
    //   278: astore_0
    //   279: goto -141 -> 138
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	282	0	paramApplication	Application
    //   0	282	1	paramContext	Context
    //   0	282	2	paramString1	String
    //   0	282	3	paramString2	String
    //   73	57	4	bool	boolean
    //   1	135	5	localObject	Object
    //   8	147	6	localFile	File
    // Exception table:
    //   from	to	target	type
    //   49	58	132	java/io/IOException
    //   188	192	194	java/io/IOException
    //   49	58	197	finally
    //   117	121	220	java/io/IOException
    //   125	129	224	java/io/IOException
    //   180	184	228	java/io/IOException
    //   206	210	232	java/io/IOException
    //   214	218	236	java/io/IOException
    //   58	68	240	finally
    //   68	113	246	finally
    //   138	172	252	finally
    //   172	176	252	finally
    //   58	68	264	java/io/IOException
    //   68	113	274	java/io/IOException
  }
  
  public static boolean a(Context paramContext)
  {
    try
    {
      if (Build.VERSION.SDK_INT >= 21)
      {
        if (SoLoadCore.getExistFile(paramContext, jdField_b_of_type_ArrayOfJavaLangString[0] + ".oat.MD5") == null) {
          break label87;
        }
        return true;
      }
      paramContext = SoLoadCore.getExistFile(paramContext, jdField_b_of_type_ArrayOfJavaLangString[0] + ".MD5");
      if (paramContext == null) {
        return false;
      }
    }
    catch (Throwable paramContext)
    {
      QLog.e("DexLoadOat", 1, "", paramContext);
    }
    return true;
    label87:
    return false;
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
  
  /* Error */
  private static String b(Application paramApplication, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: aconst_null
    //   4: astore 7
    //   6: ldc 8
    //   8: astore 6
    //   10: new 65	java/io/File
    //   13: dup
    //   14: aload_0
    //   15: invokevirtual 106	android/app/Application:getFilesDir	()Ljava/io/File;
    //   18: aload_1
    //   19: invokespecial 170	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   22: astore_3
    //   23: new 65	java/io/File
    //   26: dup
    //   27: aload_0
    //   28: invokevirtual 106	android/app/Application:getFilesDir	()Ljava/io/File;
    //   31: aload_2
    //   32: invokespecial 170	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   35: astore 9
    //   37: aload_0
    //   38: invokevirtual 120	android/app/Application:getAssets	()Landroid/content/res/AssetManager;
    //   41: aload_1
    //   42: invokevirtual 126	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   45: astore_1
    //   46: new 128	java/io/FileOutputStream
    //   49: dup
    //   50: aload_3
    //   51: iconst_0
    //   52: invokespecial 131	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   55: astore_3
    //   56: aload_3
    //   57: astore 5
    //   59: aload_1
    //   60: astore 4
    //   62: aload_1
    //   63: aload_3
    //   64: invokestatic 133	com/tencent/mobileqq/app/InjectUtils:a	(Ljava/io/InputStream;Ljava/io/OutputStream;)J
    //   67: pop2
    //   68: aload_1
    //   69: ifnull +7 -> 76
    //   72: aload_1
    //   73: invokevirtual 136	java/io/InputStream:close	()V
    //   76: aload 6
    //   78: astore 4
    //   80: aload_3
    //   81: ifnull +11 -> 92
    //   84: aload_3
    //   85: invokevirtual 137	java/io/OutputStream:close	()V
    //   88: aload 6
    //   90: astore 4
    //   92: ldc 8
    //   94: aload 4
    //   96: invokevirtual 116	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   99: ifeq +380 -> 479
    //   102: aload_0
    //   103: invokevirtual 120	android/app/Application:getAssets	()Landroid/content/res/AssetManager;
    //   106: aload_2
    //   107: invokevirtual 126	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   110: astore_0
    //   111: new 128	java/io/FileOutputStream
    //   114: dup
    //   115: aload 9
    //   117: iconst_0
    //   118: invokespecial 131	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   121: astore_1
    //   122: aload_0
    //   123: aload_1
    //   124: invokestatic 133	com/tencent/mobileqq/app/InjectUtils:a	(Ljava/io/InputStream;Ljava/io/OutputStream;)J
    //   127: pop2
    //   128: aload_0
    //   129: ifnull +7 -> 136
    //   132: aload_0
    //   133: invokevirtual 136	java/io/InputStream:close	()V
    //   136: aload_1
    //   137: ifnull +7 -> 144
    //   140: aload_1
    //   141: invokevirtual 137	java/io/OutputStream:close	()V
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
    //   161: invokevirtual 310	java/lang/Throwable:printStackTrace	()V
    //   164: aload_3
    //   165: astore 5
    //   167: aload_1
    //   168: astore 4
    //   170: aload 9
    //   172: invokevirtual 204	java/io/File:delete	()Z
    //   175: pop
    //   176: aload_3
    //   177: astore 5
    //   179: aload_1
    //   180: astore 4
    //   182: new 149	java/lang/StringBuilder
    //   185: dup
    //   186: invokespecial 150	java/lang/StringBuilder:<init>	()V
    //   189: ldc_w 312
    //   192: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: aload 6
    //   197: invokestatic 318	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   200: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   206: astore 6
    //   208: aload 6
    //   210: astore 5
    //   212: aload_1
    //   213: ifnull +7 -> 220
    //   216: aload_1
    //   217: invokevirtual 136	java/io/InputStream:close	()V
    //   220: aload 5
    //   222: astore 4
    //   224: aload_3
    //   225: ifnull -133 -> 92
    //   228: aload_3
    //   229: invokevirtual 137	java/io/OutputStream:close	()V
    //   232: aload 5
    //   234: astore 4
    //   236: goto -144 -> 92
    //   239: astore_1
    //   240: aload 5
    //   242: astore 4
    //   244: goto -152 -> 92
    //   247: astore_0
    //   248: aconst_null
    //   249: astore 5
    //   251: aconst_null
    //   252: astore_1
    //   253: aload_1
    //   254: ifnull +7 -> 261
    //   257: aload_1
    //   258: invokevirtual 136	java/io/InputStream:close	()V
    //   261: aload 5
    //   263: ifnull +8 -> 271
    //   266: aload 5
    //   268: invokevirtual 137	java/io/OutputStream:close	()V
    //   271: aload_0
    //   272: athrow
    //   273: astore_0
    //   274: aconst_null
    //   275: astore_1
    //   276: aload 7
    //   278: astore_2
    //   279: invokestatic 145	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   282: ifeq +30 -> 312
    //   285: ldc 147
    //   287: iconst_2
    //   288: new 149	java/lang/StringBuilder
    //   291: dup
    //   292: invokespecial 150	java/lang/StringBuilder:<init>	()V
    //   295: aload 9
    //   297: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   300: ldc 156
    //   302: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   305: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   308: aload_0
    //   309: invokestatic 166	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   312: aload_1
    //   313: ifnull +7 -> 320
    //   316: aload_1
    //   317: invokevirtual 136	java/io/InputStream:close	()V
    //   320: aload_2
    //   321: ifnull -177 -> 144
    //   324: aload_2
    //   325: invokevirtual 137	java/io/OutputStream:close	()V
    //   328: aload 4
    //   330: areturn
    //   331: astore_0
    //   332: aload 4
    //   334: areturn
    //   335: astore_0
    //   336: aconst_null
    //   337: astore_1
    //   338: aload 8
    //   340: astore_2
    //   341: aload_1
    //   342: ifnull +7 -> 349
    //   345: aload_1
    //   346: invokevirtual 136	java/io/InputStream:close	()V
    //   349: aload_2
    //   350: ifnull +7 -> 357
    //   353: aload_2
    //   354: invokevirtual 137	java/io/OutputStream:close	()V
    //   357: aload_0
    //   358: athrow
    //   359: astore_1
    //   360: goto -284 -> 76
    //   363: astore_1
    //   364: aload 6
    //   366: astore 4
    //   368: goto -276 -> 92
    //   371: astore_1
    //   372: goto -152 -> 220
    //   375: astore_1
    //   376: goto -115 -> 261
    //   379: astore_1
    //   380: goto -109 -> 271
    //   383: astore_0
    //   384: goto -248 -> 136
    //   387: astore_0
    //   388: aload 4
    //   390: areturn
    //   391: astore_0
    //   392: goto -72 -> 320
    //   395: astore_1
    //   396: goto -47 -> 349
    //   399: astore_1
    //   400: goto -43 -> 357
    //   403: astore_2
    //   404: aload_0
    //   405: astore_1
    //   406: aload_2
    //   407: astore_0
    //   408: aload 8
    //   410: astore_2
    //   411: goto -70 -> 341
    //   414: astore_2
    //   415: aload_0
    //   416: astore_3
    //   417: aload_2
    //   418: astore_0
    //   419: aload_1
    //   420: astore_2
    //   421: aload_3
    //   422: astore_1
    //   423: goto -82 -> 341
    //   426: astore_0
    //   427: goto -86 -> 341
    //   430: astore_2
    //   431: aload_0
    //   432: astore_1
    //   433: aload_2
    //   434: astore_0
    //   435: aload 7
    //   437: astore_2
    //   438: goto -159 -> 279
    //   441: astore_2
    //   442: aload_0
    //   443: astore_3
    //   444: aload_2
    //   445: astore_0
    //   446: aload_1
    //   447: astore_2
    //   448: aload_3
    //   449: astore_1
    //   450: goto -171 -> 279
    //   453: astore_0
    //   454: aconst_null
    //   455: astore 5
    //   457: goto -204 -> 253
    //   460: astore_0
    //   461: aload 4
    //   463: astore_1
    //   464: goto -211 -> 253
    //   467: astore 6
    //   469: aconst_null
    //   470: astore_3
    //   471: goto -318 -> 153
    //   474: astore 6
    //   476: goto -323 -> 153
    //   479: aconst_null
    //   480: astore_1
    //   481: aconst_null
    //   482: astore_0
    //   483: goto -355 -> 128
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	486	0	paramApplication	Application
    //   0	486	1	paramString1	String
    //   0	486	2	paramString2	String
    //   22	449	3	localObject1	Object
    //   60	402	4	localObject2	Object
    //   57	399	5	localObject3	Object
    //   8	81	6	str1	String
    //   147	49	6	localThrowable1	Throwable
    //   206	159	6	str2	String
    //   467	1	6	localThrowable2	Throwable
    //   474	1	6	localThrowable3	Throwable
    //   4	432	7	localObject4	Object
    //   1	408	8	localObject5	Object
    //   35	261	9	localFile	File
    // Exception table:
    //   from	to	target	type
    //   37	46	147	java/lang/Throwable
    //   228	232	239	java/io/IOException
    //   37	46	247	finally
    //   92	111	273	java/lang/Throwable
    //   324	328	331	java/io/IOException
    //   92	111	335	finally
    //   72	76	359	java/io/IOException
    //   84	88	363	java/io/IOException
    //   216	220	371	java/io/IOException
    //   257	261	375	java/io/IOException
    //   266	271	379	java/io/IOException
    //   132	136	383	java/io/IOException
    //   140	144	387	java/io/IOException
    //   316	320	391	java/io/IOException
    //   345	349	395	java/io/IOException
    //   353	357	399	java/io/IOException
    //   111	122	403	finally
    //   122	128	414	finally
    //   279	312	426	finally
    //   111	122	430	java/lang/Throwable
    //   122	128	441	java/lang/Throwable
    //   46	56	453	finally
    //   62	68	460	finally
    //   159	164	460	finally
    //   170	176	460	finally
    //   182	208	460	finally
    //   46	56	467	java/lang/Throwable
    //   62	68	474	java/lang/Throwable
  }
  
  /* Error */
  public static String b(Application paramApplication, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 145	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6: ifeq +53 -> 59
    //   9: new 149	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 150	java/lang/StringBuilder:<init>	()V
    //   16: ldc_w 320
    //   19: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: astore_3
    //   23: invokestatic 322	com/tencent/mobileqq/app/InjectUtils:a	()Z
    //   26: ifeq +52 -> 78
    //   29: ldc_w 324
    //   32: astore_2
    //   33: ldc 14
    //   35: iconst_2
    //   36: aload_3
    //   37: aload_2
    //   38: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: ldc_w 326
    //   44: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: getstatic 229	android/os/Build$VERSION:SDK_INT	I
    //   50: invokevirtual 232	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   53: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   56: invokestatic 329	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   59: getstatic 229	android/os/Build$VERSION:SDK_INT	I
    //   62: bipush 21
    //   64: if_icmplt +21 -> 85
    //   67: aload_0
    //   68: iload_1
    //   69: invokestatic 331	com/tencent/mobileqq/app/InjectUtils:c	(Landroid/app/Application;Z)Ljava/lang/String;
    //   72: astore_0
    //   73: ldc 2
    //   75: monitorexit
    //   76: aload_0
    //   77: areturn
    //   78: ldc_w 333
    //   81: astore_2
    //   82: goto -49 -> 33
    //   85: aload_0
    //   86: iload_1
    //   87: invokestatic 335	com/tencent/mobileqq/app/InjectUtils:d	(Landroid/app/Application;Z)Ljava/lang/String;
    //   90: astore_0
    //   91: goto -18 -> 73
    //   94: astore_0
    //   95: ldc 14
    //   97: iconst_1
    //   98: ldc 195
    //   100: aload_0
    //   101: invokestatic 166	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   104: aconst_null
    //   105: astore_0
    //   106: goto -33 -> 73
    //   109: astore_0
    //   110: ldc 2
    //   112: monitorexit
    //   113: aload_0
    //   114: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	115	0	paramApplication	Application
    //   0	115	1	paramBoolean	boolean
    //   32	50	2	str	String
    //   22	15	3	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   59	73	94	java/lang/Throwable
    //   85	91	94	java/lang/Throwable
    //   3	29	109	finally
    //   33	59	109	finally
    //   59	73	109	finally
    //   85	91	109	finally
    //   95	104	109	finally
  }
  
  /* Error */
  public static String c(Application paramApplication, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 8
    //   5: astore 6
    //   7: iconst_0
    //   8: istore_2
    //   9: aload 6
    //   11: astore 5
    //   13: iload_2
    //   14: getstatic 44	com/tencent/mobileqq/app/InjectUtils:jdField_b_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   17: arraylength
    //   18: if_icmpge +158 -> 176
    //   21: new 149	java/lang/StringBuilder
    //   24: dup
    //   25: invokespecial 150	java/lang/StringBuilder:<init>	()V
    //   28: getstatic 44	com/tencent/mobileqq/app/InjectUtils:jdField_b_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   31: iload_2
    //   32: aaload
    //   33: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: ldc 173
    //   38: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   44: astore 5
    //   46: new 149	java/lang/StringBuilder
    //   49: dup
    //   50: invokespecial 150	java/lang/StringBuilder:<init>	()V
    //   53: getstatic 44	com/tencent/mobileqq/app/InjectUtils:jdField_b_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   56: iload_2
    //   57: aaload
    //   58: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: ldc_w 306
    //   64: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   70: astore 7
    //   72: aload_0
    //   73: aload_0
    //   74: invokevirtual 177	android/app/Application:getApplicationContext	()Landroid/content/Context;
    //   77: aload 5
    //   79: aload 7
    //   81: invokestatic 337	com/tencent/mobileqq/app/InjectUtils:a	(Landroid/app/Application;Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Z
    //   84: istore 4
    //   86: iload 4
    //   88: ifne +22 -> 110
    //   91: iconst_1
    //   92: istore_3
    //   93: iload_3
    //   94: ifeq +30 -> 124
    //   97: iload_1
    //   98: ifeq +17 -> 115
    //   101: aconst_null
    //   102: astore 6
    //   104: ldc 2
    //   106: monitorexit
    //   107: aload 6
    //   109: areturn
    //   110: iconst_0
    //   111: istore_3
    //   112: goto -19 -> 93
    //   115: aload_0
    //   116: aload 5
    //   118: aload 7
    //   120: invokestatic 339	com/tencent/mobileqq/app/InjectUtils:a	(Landroid/app/Application;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   123: pop
    //   124: aload_0
    //   125: invokevirtual 343	android/app/Application:getClassLoader	()Ljava/lang/ClassLoader;
    //   128: astore 5
    //   130: aload 5
    //   132: getstatic 38	com/tencent/mobileqq/app/InjectUtils:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   135: iload_2
    //   136: aaload
    //   137: invokevirtual 349	java/lang/ClassLoader:loadClass	(Ljava/lang/String;)Ljava/lang/Class;
    //   140: pop
    //   141: iload_2
    //   142: iconst_1
    //   143: iadd
    //   144: istore_2
    //   145: goto -136 -> 9
    //   148: astore 5
    //   150: new 149	java/lang/StringBuilder
    //   153: dup
    //   154: invokespecial 150	java/lang/StringBuilder:<init>	()V
    //   157: ldc_w 351
    //   160: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: aload 5
    //   165: invokestatic 318	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   168: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   174: astore 5
    //   176: ldc 14
    //   178: iconst_1
    //   179: aload 5
    //   181: invokestatic 193	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   184: aload 5
    //   186: astore 6
    //   188: ldc 8
    //   190: aload 5
    //   192: invokevirtual 116	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   195: ifne -91 -> 104
    //   198: aload_0
    //   199: iload_1
    //   200: invokestatic 335	com/tencent/mobileqq/app/InjectUtils:d	(Landroid/app/Application;Z)Ljava/lang/String;
    //   203: astore 6
    //   205: goto -101 -> 104
    //   208: astore_0
    //   209: ldc 2
    //   211: monitorexit
    //   212: aload_0
    //   213: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	214	0	paramApplication	Application
    //   0	214	1	paramBoolean	boolean
    //   8	137	2	i	int
    //   92	20	3	j	int
    //   84	3	4	bool	boolean
    //   11	120	5	localObject1	Object
    //   148	16	5	localThrowable	Throwable
    //   174	17	5	str1	String
    //   5	199	6	localObject2	Object
    //   70	49	7	str2	String
    // Exception table:
    //   from	to	target	type
    //   130	141	148	java/lang/Throwable
    //   13	86	208	finally
    //   115	124	208	finally
    //   124	130	208	finally
    //   130	141	208	finally
    //   150	176	208	finally
    //   176	184	208	finally
    //   188	205	208	finally
  }
  
  /* Error */
  public static String d(Application paramApplication, boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 9
    //   3: iconst_1
    //   4: istore 5
    //   6: ldc 2
    //   8: monitorenter
    //   9: ldc 8
    //   11: astore 7
    //   13: iconst_0
    //   14: istore_3
    //   15: iload_3
    //   16: getstatic 44	com/tencent/mobileqq/app/InjectUtils:jdField_b_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   19: arraylength
    //   20: if_icmpge +304 -> 324
    //   23: getstatic 44	com/tencent/mobileqq/app/InjectUtils:jdField_b_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   26: iload_3
    //   27: aaload
    //   28: astore 12
    //   30: getstatic 38	com/tencent/mobileqq/app/InjectUtils:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   33: iload_3
    //   34: aaload
    //   35: astore 11
    //   37: new 149	java/lang/StringBuilder
    //   40: dup
    //   41: invokespecial 150	java/lang/StringBuilder:<init>	()V
    //   44: getstatic 44	com/tencent/mobileqq/app/InjectUtils:jdField_b_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   47: iload_3
    //   48: aaload
    //   49: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: ldc 173
    //   54: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   60: astore 10
    //   62: aload_0
    //   63: invokevirtual 177	android/app/Application:getApplicationContext	()Landroid/content/Context;
    //   66: getstatic 50	com/tencent/mobileqq/app/InjectUtils:d	[Ljava/lang/String;
    //   69: iload_3
    //   70: aaload
    //   71: aload 10
    //   73: invokestatic 183	com/tencent/commonsdk/soload/SoLoadCore:isLibExtracted	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Z
    //   76: istore 6
    //   78: iload 6
    //   80: ifne +27 -> 107
    //   83: iconst_1
    //   84: istore 4
    //   86: aload 7
    //   88: astore 8
    //   90: iload 4
    //   92: ifeq +36 -> 128
    //   95: iload_1
    //   96: ifeq +17 -> 113
    //   99: aload 9
    //   101: astore_0
    //   102: ldc 2
    //   104: monitorexit
    //   105: aload_0
    //   106: areturn
    //   107: iconst_0
    //   108: istore 4
    //   110: goto -24 -> 86
    //   113: aload_0
    //   114: invokevirtual 177	android/app/Application:getApplicationContext	()Landroid/content/Context;
    //   117: aload 12
    //   119: invokestatic 355	com/tencent/commonsdk/soload/SoLoadCore:releaseDexFromApk	(Landroid/content/Context;Ljava/lang/String;)Z
    //   122: ifne +154 -> 276
    //   125: aconst_null
    //   126: astore 8
    //   128: aload 8
    //   130: astore 7
    //   132: ldc 8
    //   134: aload 8
    //   136: invokevirtual 116	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   139: ifeq +47 -> 186
    //   142: aload_0
    //   143: invokevirtual 106	android/app/Application:getFilesDir	()Ljava/io/File;
    //   146: astore 7
    //   148: aload 7
    //   150: ifnull +137 -> 287
    //   153: aload 7
    //   155: invokevirtual 109	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   158: astore 7
    //   160: aload_0
    //   161: new 65	java/io/File
    //   164: dup
    //   165: aload 7
    //   167: getstatic 50	com/tencent/mobileqq/app/InjectUtils:d	[Ljava/lang/String;
    //   170: iload_3
    //   171: aaload
    //   172: invokespecial 112	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   175: invokevirtual 109	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   178: aload 11
    //   180: iconst_1
    //   181: invokestatic 190	com/tencent/mobileqq/app/SystemClassLoaderInjector:a	(Landroid/app/Application;Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;
    //   184: astore 7
    //   186: ldc 14
    //   188: iconst_1
    //   189: aload 7
    //   191: invokestatic 193	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   194: ldc 8
    //   196: aload 7
    //   198: invokevirtual 116	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   201: ifne +105 -> 306
    //   204: aload_0
    //   205: ldc 195
    //   207: aload 7
    //   209: invokestatic 198	com/tencent/mobileqq/app/InjectUtils:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   212: invokestatic 200	com/tencent/mobileqq/app/InjectUtils:a	()F
    //   215: fstore_2
    //   216: fload_2
    //   217: fconst_0
    //   218: fcmpl
    //   219: ifle +75 -> 294
    //   222: fload_2
    //   223: ldc 201
    //   225: fcmpg
    //   226: ifge +68 -> 294
    //   229: iload 5
    //   231: istore_1
    //   232: iload_1
    //   233: putstatic 20	com/tencent/mobileqq/app/InjectUtils:jdField_a_of_type_Boolean	Z
    //   236: new 65	java/io/File
    //   239: dup
    //   240: aload_0
    //   241: invokevirtual 106	android/app/Application:getFilesDir	()Ljava/io/File;
    //   244: aload 10
    //   246: invokespecial 170	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   249: invokevirtual 204	java/io/File:delete	()Z
    //   252: pop
    //   253: new 65	java/io/File
    //   256: dup
    //   257: aload_0
    //   258: invokevirtual 106	android/app/Application:getFilesDir	()Ljava/io/File;
    //   261: aload 10
    //   263: invokespecial 170	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   266: invokevirtual 204	java/io/File:delete	()Z
    //   269: pop
    //   270: aload 7
    //   272: astore_0
    //   273: goto -171 -> 102
    //   276: aload_0
    //   277: aload 10
    //   279: invokestatic 357	com/tencent/mobileqq/app/InjectUtils:a	(Landroid/app/Application;Ljava/lang/String;)Ljava/lang/String;
    //   282: astore 8
    //   284: goto -156 -> 128
    //   287: ldc 139
    //   289: astore 7
    //   291: goto -131 -> 160
    //   294: iconst_0
    //   295: istore_1
    //   296: goto -64 -> 232
    //   299: astore_0
    //   300: aload 7
    //   302: astore_0
    //   303: goto -201 -> 102
    //   306: iload_3
    //   307: iconst_1
    //   308: iadd
    //   309: istore_3
    //   310: goto -295 -> 15
    //   313: astore_0
    //   314: ldc 2
    //   316: monitorexit
    //   317: aload_0
    //   318: athrow
    //   319: astore 8
    //   321: goto -68 -> 253
    //   324: aload 7
    //   326: astore_0
    //   327: goto -225 -> 102
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	330	0	paramApplication	Application
    //   0	330	1	paramBoolean	boolean
    //   215	8	2	f	float
    //   14	296	3	i	int
    //   84	25	4	j	int
    //   4	226	5	bool1	boolean
    //   76	3	6	bool2	boolean
    //   11	314	7	localObject1	Object
    //   88	195	8	localObject2	Object
    //   319	1	8	localException	Exception
    //   1	99	9	localObject3	Object
    //   60	218	10	str1	String
    //   35	144	11	str2	String
    //   28	90	12	str3	String
    // Exception table:
    //   from	to	target	type
    //   253	270	299	java/lang/Exception
    //   15	78	313	finally
    //   113	125	313	finally
    //   132	148	313	finally
    //   153	160	313	finally
    //   160	186	313	finally
    //   186	216	313	finally
    //   232	236	313	finally
    //   236	253	313	finally
    //   253	270	313	finally
    //   276	284	313	finally
    //   236	253	319	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.InjectUtils
 * JD-Core Version:    0.7.0.1
 */