package com.tencent.commonsdk.soload;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import dalvik.system.BaseDexClassLoader;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.zip.CRC32;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class SoLoadCore
{
  public static final int API_BELOW_14 = 128;
  public static final int API_EUQAL_AND_ABOVE_14 = 256;
  public static final String APP_ROOT = "/data/data/com.tencent.mobileqq/files";
  private static final String CONFIGPATH = "soconfig.cfg";
  public static final int CONFIG_SO_PATH_IN_LIB = 32768;
  public static final int CONFIG_SO_PATH_IN_TXLIB = 16384;
  public static final int IF_CONFIG_SO_CRCCHECK_SUCCESS = 8192;
  public static final int IF_GENERATE_CACHE_SUCCESS = 2097152;
  public static final int IF_GET_AVAILIABLE_CRCVALUE = 1048576;
  public static final int IF_READ_CONFIGFILE_SUCCESS = 65536;
  public static final int IF_RELEASE_BY_CLASSLOADER_SUCCESS = 64;
  public static final int IF_RELEASE_BY_ZIP_CHECK_SUCCESS = 8;
  public static final int IF_RELEASE_SOFILE_CHECK_SUCCESS = 32;
  public static final int IF_SOFILE_EXIST_IN_LIBPATH = 2048;
  public static final int IF_SOFILE_IN_LIB_CHECK_SUCCESS = 1024;
  public static final int IF_SO_CONFIG_EXIST = 131072;
  public static final int IF_TRY_LOADSO_INLIBPATH_SUCCESS = 512;
  public static final int IF_TRY_LOAD_CONFIG_SO_SUCCESS = 4096;
  public static final int IF_TRY_LOAD_LIBRARY_SUCCESS = 524288;
  public static final int IF_TRY_LOAD_RELEASESO_SUCCESS = 16;
  public static final int IF_TRY_LOAD_SO_BY_ZIP_SUCCESS = 4;
  public static boolean IS_CPU_64_BIT = false;
  public static final int LOAD_SO_SUCCESS_SAVE_AND_RETURN = 2;
  private static final String PACKAGE_NAME = "com.tencent.tim";
  public static final String PATH_LIB = "/lib/";
  public static final String PATH_TX_LIB = "/txlib/";
  private static final String TAG = "SoLoadCore";
  public static final int TRY_LOAD_LIBRARY_SUCCESS = 262144;
  private static HashMap<String, Long> assestCrcConfigs = null;
  
  public static boolean contentEquals(InputStream paramInputStream1, InputStream paramInputStream2)
    throws IOException
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
  
  /* Error */
  private static void copyZipEntry2File(ZipEntry paramZipEntry, ZipFile paramZipFile, File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 5
    //   6: aload_0
    //   7: ifnull +7 -> 14
    //   10: aload_1
    //   11: ifnonnull +44 -> 55
    //   14: iconst_0
    //   15: ifeq +11 -> 26
    //   18: new 102	java/lang/NullPointerException
    //   21: dup
    //   22: invokespecial 103	java/lang/NullPointerException:<init>	()V
    //   25: athrow
    //   26: iconst_0
    //   27: ifeq +11 -> 38
    //   30: new 102	java/lang/NullPointerException
    //   33: dup
    //   34: invokespecial 103	java/lang/NullPointerException:<init>	()V
    //   37: athrow
    //   38: iconst_0
    //   39: ifeq +11 -> 50
    //   42: new 102	java/lang/NullPointerException
    //   45: dup
    //   46: invokespecial 103	java/lang/NullPointerException:<init>	()V
    //   49: athrow
    //   50: aload_1
    //   51: invokevirtual 108	java/util/zip/ZipFile:close	()V
    //   54: return
    //   55: aload_1
    //   56: aload_0
    //   57: invokevirtual 112	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   60: astore_0
    //   61: new 88	java/io/BufferedInputStream
    //   64: dup
    //   65: aload_0
    //   66: invokespecial 91	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   69: astore 4
    //   71: sipush 8192
    //   74: newarray byte
    //   76: astore 7
    //   78: new 114	java/io/BufferedOutputStream
    //   81: dup
    //   82: new 116	java/io/FileOutputStream
    //   85: dup
    //   86: aload_2
    //   87: invokespecial 119	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   90: invokespecial 122	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   93: astore_2
    //   94: aload 4
    //   96: aload 7
    //   98: invokevirtual 125	java/io/BufferedInputStream:read	([B)I
    //   101: istore_3
    //   102: iload_3
    //   103: iconst_m1
    //   104: if_icmpeq +61 -> 165
    //   107: aload_2
    //   108: aload 7
    //   110: iconst_0
    //   111: iload_3
    //   112: invokevirtual 129	java/io/BufferedOutputStream:write	([BII)V
    //   115: goto -21 -> 94
    //   118: astore 6
    //   120: aload_2
    //   121: astore 5
    //   123: aload 6
    //   125: astore_2
    //   126: aload_2
    //   127: invokevirtual 132	java/io/IOException:printStackTrace	()V
    //   130: aload 4
    //   132: ifnull +8 -> 140
    //   135: aload 4
    //   137: invokevirtual 133	java/io/BufferedInputStream:close	()V
    //   140: aload_0
    //   141: ifnull +7 -> 148
    //   144: aload_0
    //   145: invokevirtual 134	java/io/InputStream:close	()V
    //   148: aload 5
    //   150: ifnull +8 -> 158
    //   153: aload 5
    //   155: invokevirtual 135	java/io/BufferedOutputStream:close	()V
    //   158: aload_1
    //   159: invokevirtual 108	java/util/zip/ZipFile:close	()V
    //   162: return
    //   163: astore_0
    //   164: return
    //   165: aload_2
    //   166: ifnull +7 -> 173
    //   169: aload_2
    //   170: invokevirtual 135	java/io/BufferedOutputStream:close	()V
    //   173: aload 4
    //   175: ifnull +8 -> 183
    //   178: aload 4
    //   180: invokevirtual 133	java/io/BufferedInputStream:close	()V
    //   183: aload_0
    //   184: ifnull +7 -> 191
    //   187: aload_0
    //   188: invokevirtual 134	java/io/InputStream:close	()V
    //   191: aload_2
    //   192: ifnull +7 -> 199
    //   195: aload_2
    //   196: invokevirtual 135	java/io/BufferedOutputStream:close	()V
    //   199: aload_1
    //   200: invokevirtual 108	java/util/zip/ZipFile:close	()V
    //   203: return
    //   204: astore_0
    //   205: return
    //   206: astore_2
    //   207: aconst_null
    //   208: astore 4
    //   210: aconst_null
    //   211: astore_0
    //   212: aload 6
    //   214: astore 5
    //   216: aload 4
    //   218: ifnull +8 -> 226
    //   221: aload 4
    //   223: invokevirtual 133	java/io/BufferedInputStream:close	()V
    //   226: aload_0
    //   227: ifnull +7 -> 234
    //   230: aload_0
    //   231: invokevirtual 134	java/io/InputStream:close	()V
    //   234: aload 5
    //   236: ifnull +8 -> 244
    //   239: aload 5
    //   241: invokevirtual 135	java/io/BufferedOutputStream:close	()V
    //   244: aload_1
    //   245: invokevirtual 108	java/util/zip/ZipFile:close	()V
    //   248: aload_2
    //   249: athrow
    //   250: astore_0
    //   251: return
    //   252: astore_0
    //   253: goto -5 -> 248
    //   256: astore_0
    //   257: goto -13 -> 244
    //   260: astore_2
    //   261: aconst_null
    //   262: astore 4
    //   264: aload 6
    //   266: astore 5
    //   268: goto -52 -> 216
    //   271: astore_2
    //   272: aload 6
    //   274: astore 5
    //   276: goto -60 -> 216
    //   279: astore 6
    //   281: aload_2
    //   282: astore 5
    //   284: aload 6
    //   286: astore_2
    //   287: goto -71 -> 216
    //   290: astore_2
    //   291: goto -75 -> 216
    //   294: astore_0
    //   295: goto -137 -> 158
    //   298: astore_2
    //   299: aconst_null
    //   300: astore 4
    //   302: aconst_null
    //   303: astore_0
    //   304: goto -178 -> 126
    //   307: astore_2
    //   308: aconst_null
    //   309: astore 4
    //   311: goto -185 -> 126
    //   314: astore_2
    //   315: goto -189 -> 126
    //   318: astore_0
    //   319: goto -120 -> 199
    //   322: astore_0
    //   323: goto -273 -> 50
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	326	0	paramZipEntry	ZipEntry
    //   0	326	1	paramZipFile	ZipFile
    //   0	326	2	paramFile	File
    //   101	11	3	i	int
    //   69	241	4	localBufferedInputStream	BufferedInputStream
    //   4	279	5	localObject1	Object
    //   1	1	6	localObject2	Object
    //   118	155	6	localIOException	IOException
    //   279	6	6	localObject3	Object
    //   76	33	7	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   94	102	118	java/io/IOException
    //   107	115	118	java/io/IOException
    //   169	173	118	java/io/IOException
    //   158	162	163	java/io/IOException
    //   199	203	204	java/io/IOException
    //   55	61	206	finally
    //   50	54	250	java/io/IOException
    //   244	248	252	java/io/IOException
    //   221	226	256	java/io/IOException
    //   230	234	256	java/io/IOException
    //   239	244	256	java/io/IOException
    //   61	71	260	finally
    //   71	94	271	finally
    //   94	102	279	finally
    //   107	115	279	finally
    //   169	173	279	finally
    //   126	130	290	finally
    //   135	140	294	java/io/IOException
    //   144	148	294	java/io/IOException
    //   153	158	294	java/io/IOException
    //   55	61	298	java/io/IOException
    //   61	71	307	java/io/IOException
    //   71	94	314	java/io/IOException
    //   178	183	318	java/io/IOException
    //   187	191	318	java/io/IOException
    //   195	199	318	java/io/IOException
    //   18	26	322	java/io/IOException
    //   30	38	322	java/io/IOException
    //   42	50	322	java/io/IOException
  }
  
  public static String getApkPath(Context paramContext)
  {
    Object localObject1 = null;
    Object localObject2 = paramContext.getPackageManager();
    paramContext = paramContext.getPackageName();
    try
    {
      localObject2 = ((PackageManager)localObject2).getApplicationInfo(paramContext, 8192);
      paramContext = localObject1;
      if (localObject2 != null) {
        paramContext = ((ApplicationInfo)localObject2).sourceDir;
      }
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      paramContext.printStackTrace();
    }
    return null;
  }
  
  public static File getAppWorkFile(Context paramContext)
  {
    try
    {
      File localFile = paramContext.getFilesDir().getParentFile();
      return localFile;
    }
    catch (Exception localException)
    {
      try
      {
        if ((paramContext instanceof ContextWrapper)) {}
        Object localObject;
        for (paramContext = ((ContextWrapper)paramContext).getBaseContext();; paramContext = ((Field)localObject).get(paramContext))
        {
          localObject = paramContext.getClass().getDeclaredMethod("getDataDirFile", new Class[0]);
          ((Method)localObject).setAccessible(true);
          return (File)((Method)localObject).invoke(paramContext, new Object[0]);
          localObject = ContextWrapper.class.getDeclaredField("mBase");
          ((Field)localObject).setAccessible(true);
        }
        return null;
      }
      catch (Throwable paramContext) {}
    }
  }
  
  public static String getAppWorkPath(Context paramContext)
  {
    try
    {
      String str = paramContext.getFilesDir().getParent();
      return str;
    }
    catch (Exception localException)
    {
      try
      {
        if ((paramContext instanceof ContextWrapper)) {}
        Object localObject;
        for (paramContext = ((ContextWrapper)paramContext).getBaseContext();; paramContext = ((Field)localObject).get(paramContext))
        {
          localObject = paramContext.getClass().getDeclaredMethod("getDataDirFile", new Class[0]);
          ((Method)localObject).setAccessible(true);
          return ((File)((Method)localObject).invoke(paramContext, new Object[0])).getAbsolutePath();
          localObject = ContextWrapper.class.getDeclaredField("mBase");
          ((Field)localObject).setAccessible(true);
        }
        return null;
      }
      catch (Throwable paramContext) {}
    }
  }
  
  /* Error */
  public static long getCRC32Value(File paramFile)
  {
    // Byte code:
    //   0: ldc2_w 227
    //   3: lstore_3
    //   4: lload_3
    //   5: lstore_1
    //   6: aload_0
    //   7: ifnull +12 -> 19
    //   10: aload_0
    //   11: invokevirtual 232	java/io/File:exists	()Z
    //   14: ifne +7 -> 21
    //   17: lload_3
    //   18: lstore_1
    //   19: lload_1
    //   20: lreturn
    //   21: new 234	java/io/FileInputStream
    //   24: dup
    //   25: aload_0
    //   26: invokespecial 235	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   29: astore 5
    //   31: aload 5
    //   33: astore_0
    //   34: aload 5
    //   36: invokestatic 238	com/tencent/commonsdk/soload/SoLoadCore:getCRC32Value	(Ljava/io/InputStream;)J
    //   39: lstore_1
    //   40: lload_1
    //   41: lstore_3
    //   42: lload_3
    //   43: lstore_1
    //   44: aload 5
    //   46: ifnull -27 -> 19
    //   49: aload 5
    //   51: invokevirtual 239	java/io/FileInputStream:close	()V
    //   54: lload_3
    //   55: lreturn
    //   56: astore_0
    //   57: aload_0
    //   58: invokevirtual 132	java/io/IOException:printStackTrace	()V
    //   61: lload_3
    //   62: lreturn
    //   63: astore 6
    //   65: aconst_null
    //   66: astore 5
    //   68: aload 5
    //   70: astore_0
    //   71: aload 6
    //   73: invokevirtual 240	java/lang/Exception:printStackTrace	()V
    //   76: lload_3
    //   77: lstore_1
    //   78: aload 5
    //   80: ifnull -61 -> 19
    //   83: aload 5
    //   85: invokevirtual 239	java/io/FileInputStream:close	()V
    //   88: ldc2_w 227
    //   91: lreturn
    //   92: astore_0
    //   93: aload_0
    //   94: invokevirtual 132	java/io/IOException:printStackTrace	()V
    //   97: ldc2_w 227
    //   100: lreturn
    //   101: astore 5
    //   103: aconst_null
    //   104: astore_0
    //   105: aload_0
    //   106: ifnull +7 -> 113
    //   109: aload_0
    //   110: invokevirtual 239	java/io/FileInputStream:close	()V
    //   113: aload 5
    //   115: athrow
    //   116: astore_0
    //   117: aload_0
    //   118: invokevirtual 132	java/io/IOException:printStackTrace	()V
    //   121: goto -8 -> 113
    //   124: astore 5
    //   126: goto -21 -> 105
    //   129: astore 6
    //   131: goto -63 -> 68
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	134	0	paramFile	File
    //   5	73	1	l1	long
    //   3	74	3	l2	long
    //   29	55	5	localFileInputStream	java.io.FileInputStream
    //   101	13	5	localObject1	Object
    //   124	1	5	localObject2	Object
    //   63	9	6	localException1	Exception
    //   129	1	6	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   49	54	56	java/io/IOException
    //   21	31	63	java/lang/Exception
    //   83	88	92	java/io/IOException
    //   21	31	101	finally
    //   109	113	116	java/io/IOException
    //   34	40	124	finally
    //   71	76	124	finally
    //   34	40	129	java/lang/Exception
  }
  
  public static long getCRC32Value(InputStream paramInputStream)
    throws Exception
  {
    byte[] arrayOfByte = new byte[8192];
    CRC32 localCRC32 = new CRC32();
    for (;;)
    {
      int i = paramInputStream.read(arrayOfByte);
      if (i == -1) {
        break;
      }
      localCRC32.update(arrayOfByte, 0, i);
    }
    return localCRC32.getValue();
  }
  
  private static String getCurProcessName(Context paramContext)
  {
    paramContext = ((ActivityManager)paramContext.getApplicationContext().getSystemService("activity")).getRunningAppProcesses();
    if (paramContext != null)
    {
      int i = Process.myPid();
      paramContext = paramContext.iterator();
      while (paramContext.hasNext())
      {
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
        if ((localRunningAppProcessInfo.processName.startsWith("com.tencent.tim")) && (localRunningAppProcessInfo.pid == i)) {
          return localRunningAppProcessInfo.processName + "_" + i;
        }
      }
    }
    return null;
  }
  
  /* Error */
  private static String getDefaultPlatformString()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 322	android/os/Build:CPU_ABI	Ljava/lang/String;
    //   6: astore_0
    //   7: aload_0
    //   8: ifnull +22 -> 30
    //   11: aload_0
    //   12: ldc_w 324
    //   15: invokevirtual 328	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   18: ifeq +12 -> 30
    //   21: ldc_w 330
    //   24: astore_0
    //   25: ldc 2
    //   27: monitorexit
    //   28: aload_0
    //   29: areturn
    //   30: ldc_w 332
    //   33: astore_0
    //   34: goto -9 -> 25
    //   37: astore_0
    //   38: ldc 2
    //   40: monitorexit
    //   41: aload_0
    //   42: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   6	28	0	str	String
    //   37	5	0	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	7	37	finally
    //   11	21	37	finally
  }
  
  @SuppressLint({"SdCardPath"})
  public static File getExistFile(Context paramContext, String paramString)
  {
    File localFile = new File(paramContext.getFilesDir(), paramString);
    Object localObject = localFile;
    if (!localFile.exists())
    {
      paramContext = new File(paramContext.getFilesDir(), paramString);
      localObject = paramContext;
      if (!paramContext.exists())
      {
        paramContext = new File("/data/data/com.tencent.mobileqq/files", paramString);
        localObject = paramContext;
        if (!paramContext.exists()) {
          localObject = null;
        }
      }
    }
    return localObject;
  }
  
  public static String getLibActualName(String paramString)
  {
    return "lib" + paramString + ".so";
  }
  
  public static String getOsClassLoader()
  {
    try
    {
      Class.forName("dalvik.system.LexClassLoader");
      return "lex";
    }
    catch (ClassNotFoundException localClassNotFoundException1)
    {
      int i = 1;
      try
      {
        Class.forName("dalvik.system.BaseDexClassLoader");
        if (i == 0) {
          return "below14";
        }
      }
      catch (ClassNotFoundException localClassNotFoundException2)
      {
        for (;;)
        {
          i = 0;
        }
      }
    }
    return "equalAndAbove14";
  }
  
  /* Error */
  private static String getPlatform32String()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 322	android/os/Build:CPU_ABI	Ljava/lang/String;
    //   6: astore_0
    //   7: aload_0
    //   8: ifnull +22 -> 30
    //   11: aload_0
    //   12: ldc_w 370
    //   15: invokevirtual 328	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   18: ifeq +12 -> 30
    //   21: ldc_w 370
    //   24: astore_0
    //   25: ldc 2
    //   27: monitorexit
    //   28: aload_0
    //   29: areturn
    //   30: aload_0
    //   31: ifnull +20 -> 51
    //   34: aload_0
    //   35: ldc_w 372
    //   38: invokevirtual 328	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   41: ifeq +10 -> 51
    //   44: ldc_w 374
    //   47: astore_0
    //   48: goto -23 -> 25
    //   51: ldc_w 332
    //   54: astore_0
    //   55: goto -30 -> 25
    //   58: astore_0
    //   59: ldc 2
    //   61: monitorexit
    //   62: aload_0
    //   63: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   6	49	0	str	String
    //   58	5	0	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	7	58	finally
    //   11	21	58	finally
    //   34	44	58	finally
  }
  
  /* Error */
  private static String getPlatform64String()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 322	android/os/Build:CPU_ABI	Ljava/lang/String;
    //   6: astore_0
    //   7: aload_0
    //   8: ifnull +22 -> 30
    //   11: aload_0
    //   12: ldc_w 377
    //   15: invokevirtual 328	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   18: ifeq +12 -> 30
    //   21: ldc_w 377
    //   24: astore_0
    //   25: ldc 2
    //   27: monitorexit
    //   28: aload_0
    //   29: areturn
    //   30: aload_0
    //   31: ifnull +20 -> 51
    //   34: aload_0
    //   35: ldc_w 379
    //   38: invokevirtual 328	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   41: ifeq +10 -> 51
    //   44: ldc_w 379
    //   47: astore_0
    //   48: goto -23 -> 25
    //   51: ldc_w 330
    //   54: astore_0
    //   55: goto -30 -> 25
    //   58: astore_0
    //   59: ldc 2
    //   61: monitorexit
    //   62: aload_0
    //   63: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   6	49	0	str	String
    //   58	5	0	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	7	58	finally
    //   11	21	58	finally
    //   34	44	58	finally
  }
  
  /* Error */
  private static String getPlatformString()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 78	com/tencent/commonsdk/soload/SoLoadCore:IS_CPU_64_BIT	Z
    //   6: ifeq +12 -> 18
    //   9: invokestatic 382	com/tencent/commonsdk/soload/SoLoadCore:getPlatform64String	()Ljava/lang/String;
    //   12: astore_0
    //   13: ldc 2
    //   15: monitorexit
    //   16: aload_0
    //   17: areturn
    //   18: invokestatic 384	com/tencent/commonsdk/soload/SoLoadCore:getPlatform32String	()Ljava/lang/String;
    //   21: astore_0
    //   22: goto -9 -> 13
    //   25: astore_0
    //   26: ldc 2
    //   28: monitorexit
    //   29: aload_0
    //   30: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   12	10	0	str	String
    //   25	5	0	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	13	25	finally
    //   18	22	25	finally
  }
  
  public static String getReleasedSoFilePath(Context paramContext, String paramString)
  {
    paramString = getLibActualName(paramString);
    initAssestCrcConfigs(paramContext);
    if (assestCrcConfigs != null)
    {
      if (assestCrcConfigs.isEmpty()) {
        return null;
      }
      Long localLong = (Long)assestCrcConfigs.get(getDefaultPlatformString() + "/" + paramString);
      if (localLong == null) {
        return null;
      }
      long l = localLong.longValue();
      if (l <= 0L) {
        return null;
      }
      paramContext = paramContext.getFilesDir() + "/soconfigs";
      paramContext = new File(paramContext + "/" + paramString + ".cfg");
      if (paramContext.exists())
      {
        if (!paramContext.isFile()) {
          return null;
        }
        paramContext = readConfig(paramContext);
        if (paramContext == null) {
          return null;
        }
        if (paramContext.mCrcvalue != l) {
          return null;
        }
        return paramContext.mSopath;
      }
    }
    return null;
  }
  
  private static File getSoOrDexByBaseDexClassLoader(Context paramContext, String paramString1, String paramString2)
  {
    File localFile = new File(paramString2);
    if (localFile.exists()) {
      localFile.delete();
    }
    paramString2 = paramContext.getClassLoader();
    paramContext = (BaseDexClassLoader)paramContext.getClassLoader();
    paramString2 = paramString2.getClass().getSuperclass();
    for (;;)
    {
      try
      {
        localFile.createNewFile();
        localObject1 = paramString2.getDeclaredField("pathList");
        ((Field)localObject1).setAccessible(true);
        paramString2 = ((Field)localObject1).get(paramContext);
        paramContext = ((Field)localObject1).get(paramContext).getClass().getDeclaredField("dexElements");
        paramContext.setAccessible(true);
        Object localObject3 = paramContext.get(paramString2);
        if (!localObject3.getClass().isArray()) {
          break;
        }
        int j = Array.getLength(localObject3);
        if (j <= 0) {
          break;
        }
        int i = 0;
        paramString2 = null;
        paramContext = null;
        if (i < j)
        {
          localObject1 = Array.get(localObject3, i);
          localObject2 = localObject1.getClass().getDeclaredField("zipFile");
          ((Field)localObject2).setAccessible(true);
          localObject1 = ((Field)localObject2).get(localObject1);
          if (localObject1 != null)
          {
            localObject1 = (ZipFile)localObject1;
            localObject2 = ((ZipFile)localObject1).getEntry(paramString1);
            paramContext = (Context)localObject1;
            paramString2 = (String)localObject2;
            if (localObject2 != null)
            {
              if ((localObject2 == null) || (localObject1 == null)) {
                continue;
              }
              copyZipEntry2File((ZipEntry)localObject2, (ZipFile)localObject1, localFile);
              return localFile;
            }
          }
          else
          {
            localObject1 = paramString2;
            paramString2 = paramContext;
            paramContext = (Context)localObject1;
          }
          i += 1;
          localObject1 = paramString2;
          paramString2 = paramContext;
          paramContext = (Context)localObject1;
          continue;
          return null;
        }
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
        return null;
      }
      Object localObject1 = paramString2;
      Object localObject2 = paramContext;
    }
    return localFile;
  }
  
  public static File getSoOrDexByPathClassLoader(Context paramContext, String paramString1, String paramString2)
  {
    File localFile = new File(paramString2 + paramString1);
    paramContext = paramContext.getClassLoader();
    paramString2 = paramContext.getClass();
    try
    {
      paramString2 = paramString2.getDeclaredField("mZips");
      paramString2.setAccessible(true);
      Object localObject = paramString2.get(paramContext);
      if (localObject.getClass().isArray())
      {
        int j = Array.getLength(localObject);
        int i = 0;
        paramContext = null;
        paramString2 = null;
        for (;;)
        {
          if (i < j)
          {
            paramString2 = (ZipFile)Array.get(localObject, i);
            paramContext = paramString2.getEntry(paramString1);
            if (paramContext == null) {}
          }
          else
          {
            if ((paramContext == null) || (paramString2 == null)) {
              break;
            }
            copyZipEntry2File(paramContext, paramString2, localFile);
            return localFile;
          }
          i += 1;
        }
        return null;
      }
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
      return null;
    }
    return localFile;
  }
  
  private static boolean hasBaseDexClassloader()
  {
    try
    {
      Class.forName("dalvik.system.BaseDexClassLoader");
      return true;
    }
    catch (ClassNotFoundException localClassNotFoundException) {}
    return false;
  }
  
  /* Error */
  private static void initAssestCrcConfigs(Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 76	com/tencent/commonsdk/soload/SoLoadCore:assestCrcConfigs	Ljava/util/HashMap;
    //   6: astore 4
    //   8: aload 4
    //   10: ifnull +7 -> 17
    //   13: ldc 2
    //   15: monitorexit
    //   16: return
    //   17: aconst_null
    //   18: astore 5
    //   20: aload 5
    //   22: astore 4
    //   24: new 394	java/util/HashMap
    //   27: dup
    //   28: invokespecial 479	java/util/HashMap:<init>	()V
    //   31: putstatic 76	com/tencent/commonsdk/soload/SoLoadCore:assestCrcConfigs	Ljava/util/HashMap;
    //   34: aload 5
    //   36: astore 4
    //   38: aload_0
    //   39: invokevirtual 483	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   42: invokevirtual 489	android/content/res/Resources:getAssets	()Landroid/content/res/AssetManager;
    //   45: ldc 16
    //   47: invokevirtual 495	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   50: astore 5
    //   52: aload 5
    //   54: astore 4
    //   56: aload 5
    //   58: astore_0
    //   59: new 497	java/io/BufferedReader
    //   62: dup
    //   63: new 499	java/io/InputStreamReader
    //   66: dup
    //   67: aload 5
    //   69: invokespecial 500	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   72: invokespecial 503	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   75: astore 6
    //   77: aload 5
    //   79: astore 4
    //   81: aload 5
    //   83: astore_0
    //   84: aload 6
    //   86: invokevirtual 506	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   89: astore 7
    //   91: aload 7
    //   93: ifnull +123 -> 216
    //   96: aload 5
    //   98: astore 4
    //   100: aload 5
    //   102: astore_0
    //   103: aload 7
    //   105: ldc_w 508
    //   108: invokevirtual 512	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   111: istore_1
    //   112: aload 5
    //   114: astore 4
    //   116: aload 5
    //   118: astore_0
    //   119: aload 7
    //   121: iconst_0
    //   122: iload_1
    //   123: invokevirtual 516	java/lang/String:substring	(II)Ljava/lang/String;
    //   126: astore 8
    //   128: aload 5
    //   130: astore 4
    //   132: aload 5
    //   134: astore_0
    //   135: aload 7
    //   137: iload_1
    //   138: iconst_1
    //   139: iadd
    //   140: invokevirtual 519	java/lang/String:substring	(I)Ljava/lang/String;
    //   143: invokestatic 523	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   146: lstore_2
    //   147: lload_2
    //   148: lconst_1
    //   149: lcmp
    //   150: iflt -73 -> 77
    //   153: aload 5
    //   155: astore 4
    //   157: aload 5
    //   159: astore_0
    //   160: getstatic 76	com/tencent/commonsdk/soload/SoLoadCore:assestCrcConfigs	Ljava/util/HashMap;
    //   163: aload 8
    //   165: lload_2
    //   166: invokestatic 527	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   169: invokevirtual 531	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   172: pop
    //   173: goto -96 -> 77
    //   176: astore_0
    //   177: aload 4
    //   179: astore_0
    //   180: ldc 67
    //   182: iconst_1
    //   183: ldc_w 533
    //   186: invokestatic 539	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   189: aload 4
    //   191: ifnull -178 -> 13
    //   194: aload 4
    //   196: invokevirtual 134	java/io/InputStream:close	()V
    //   199: goto -186 -> 13
    //   202: astore_0
    //   203: aload_0
    //   204: invokevirtual 132	java/io/IOException:printStackTrace	()V
    //   207: goto -194 -> 13
    //   210: astore_0
    //   211: ldc 2
    //   213: monitorexit
    //   214: aload_0
    //   215: athrow
    //   216: aload 5
    //   218: ifnull -205 -> 13
    //   221: aload 5
    //   223: invokevirtual 134	java/io/InputStream:close	()V
    //   226: goto -213 -> 13
    //   229: astore_0
    //   230: aload_0
    //   231: invokevirtual 132	java/io/IOException:printStackTrace	()V
    //   234: goto -221 -> 13
    //   237: astore_0
    //   238: aconst_null
    //   239: astore 4
    //   241: aload 4
    //   243: ifnull +8 -> 251
    //   246: aload 4
    //   248: invokevirtual 134	java/io/InputStream:close	()V
    //   251: aload_0
    //   252: athrow
    //   253: astore 4
    //   255: aload 4
    //   257: invokevirtual 132	java/io/IOException:printStackTrace	()V
    //   260: goto -9 -> 251
    //   263: astore 5
    //   265: aload_0
    //   266: astore 4
    //   268: aload 5
    //   270: astore_0
    //   271: goto -30 -> 241
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	274	0	paramContext	Context
    //   111	29	1	i	int
    //   146	20	2	l	long
    //   6	241	4	localObject1	Object
    //   253	3	4	localIOException	IOException
    //   266	1	4	localContext	Context
    //   18	204	5	localInputStream	InputStream
    //   263	6	5	localObject2	Object
    //   75	10	6	localBufferedReader	java.io.BufferedReader
    //   89	47	7	str1	String
    //   126	38	8	str2	String
    // Exception table:
    //   from	to	target	type
    //   24	34	176	java/lang/Exception
    //   38	52	176	java/lang/Exception
    //   59	77	176	java/lang/Exception
    //   84	91	176	java/lang/Exception
    //   103	112	176	java/lang/Exception
    //   119	128	176	java/lang/Exception
    //   135	147	176	java/lang/Exception
    //   160	173	176	java/lang/Exception
    //   194	199	202	java/io/IOException
    //   3	8	210	finally
    //   194	199	210	finally
    //   203	207	210	finally
    //   221	226	210	finally
    //   230	234	210	finally
    //   246	251	210	finally
    //   251	253	210	finally
    //   255	260	210	finally
    //   221	226	229	java/io/IOException
    //   24	34	237	finally
    //   38	52	237	finally
    //   246	251	253	java/io/IOException
    //   59	77	263	finally
    //   84	91	263	finally
    //   103	112	263	finally
    //   119	128	263	finally
    //   135	147	263	finally
    //   160	173	263	finally
    //   180	189	263	finally
  }
  
  /* Error */
  public static boolean isLibExtracted(Context paramContext, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 6
    //   6: iconst_0
    //   7: istore 4
    //   9: aload_0
    //   10: aload_1
    //   11: invokestatic 543	com/tencent/commonsdk/soload/SoLoadCore:getExistFile	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;
    //   14: ifnonnull +8 -> 22
    //   17: iload 4
    //   19: istore_3
    //   20: iload_3
    //   21: ireturn
    //   22: aload_0
    //   23: aload_2
    //   24: invokestatic 543	com/tencent/commonsdk/soload/SoLoadCore:getExistFile	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;
    //   27: astore_1
    //   28: iload 4
    //   30: istore_3
    //   31: aload_1
    //   32: ifnull -12 -> 20
    //   35: aload_0
    //   36: invokevirtual 544	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   39: aload_2
    //   40: invokevirtual 495	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   43: astore_0
    //   44: new 234	java/io/FileInputStream
    //   47: dup
    //   48: aload_1
    //   49: invokespecial 235	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   52: astore_1
    //   53: aload_0
    //   54: aload_1
    //   55: invokestatic 546	com/tencent/commonsdk/soload/SoLoadCore:contentEquals	(Ljava/io/InputStream;Ljava/io/InputStream;)Z
    //   58: istore_3
    //   59: iload_3
    //   60: istore 4
    //   62: aload_0
    //   63: ifnull +7 -> 70
    //   66: aload_0
    //   67: invokevirtual 134	java/io/InputStream:close	()V
    //   70: iload 4
    //   72: istore_3
    //   73: aload_1
    //   74: ifnull -54 -> 20
    //   77: aload_1
    //   78: invokevirtual 134	java/io/InputStream:close	()V
    //   81: iload 4
    //   83: ireturn
    //   84: astore_0
    //   85: iload 4
    //   87: ireturn
    //   88: astore_2
    //   89: aconst_null
    //   90: astore_0
    //   91: aload 6
    //   93: astore_1
    //   94: aload_2
    //   95: invokevirtual 132	java/io/IOException:printStackTrace	()V
    //   98: aload_1
    //   99: ifnull +7 -> 106
    //   102: aload_1
    //   103: invokevirtual 134	java/io/InputStream:close	()V
    //   106: iload 4
    //   108: istore_3
    //   109: aload_0
    //   110: ifnull -90 -> 20
    //   113: aload_0
    //   114: invokevirtual 134	java/io/InputStream:close	()V
    //   117: iconst_0
    //   118: ireturn
    //   119: astore_0
    //   120: iconst_0
    //   121: ireturn
    //   122: astore_1
    //   123: aconst_null
    //   124: astore_0
    //   125: aload 5
    //   127: astore_2
    //   128: aload_0
    //   129: ifnull +7 -> 136
    //   132: aload_0
    //   133: invokevirtual 134	java/io/InputStream:close	()V
    //   136: aload_2
    //   137: ifnull +7 -> 144
    //   140: aload_2
    //   141: invokevirtual 134	java/io/InputStream:close	()V
    //   144: aload_1
    //   145: athrow
    //   146: astore_0
    //   147: goto -77 -> 70
    //   150: astore_1
    //   151: goto -45 -> 106
    //   154: astore_0
    //   155: goto -19 -> 136
    //   158: astore_0
    //   159: goto -15 -> 144
    //   162: astore_1
    //   163: aload 5
    //   165: astore_2
    //   166: goto -38 -> 128
    //   169: astore 5
    //   171: aload_1
    //   172: astore_2
    //   173: aload 5
    //   175: astore_1
    //   176: goto -48 -> 128
    //   179: astore_2
    //   180: aload_1
    //   181: astore 5
    //   183: aload_2
    //   184: astore_1
    //   185: aload_0
    //   186: astore_2
    //   187: aload 5
    //   189: astore_0
    //   190: goto -62 -> 128
    //   193: astore_2
    //   194: aconst_null
    //   195: astore 5
    //   197: aload_0
    //   198: astore_1
    //   199: aload 5
    //   201: astore_0
    //   202: goto -108 -> 94
    //   205: astore_2
    //   206: aload_0
    //   207: astore 5
    //   209: aload_1
    //   210: astore_0
    //   211: aload 5
    //   213: astore_1
    //   214: goto -120 -> 94
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	217	0	paramContext	Context
    //   0	217	1	paramString1	String
    //   0	217	2	paramString2	String
    //   19	90	3	bool1	boolean
    //   7	100	4	bool2	boolean
    //   1	163	5	localObject1	Object
    //   169	5	5	localObject2	Object
    //   181	31	5	localObject3	Object
    //   4	88	6	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   77	81	84	java/io/IOException
    //   35	44	88	java/io/IOException
    //   113	117	119	java/io/IOException
    //   35	44	122	finally
    //   66	70	146	java/io/IOException
    //   102	106	150	java/io/IOException
    //   132	136	154	java/io/IOException
    //   140	144	158	java/io/IOException
    //   44	53	162	finally
    //   53	59	169	finally
    //   94	98	179	finally
    //   44	53	193	java/io/IOException
    //   53	59	205	java/io/IOException
  }
  
  private static boolean loadAndSave(File paramFile1, String paramString, long paramLong, File paramFile2)
  {
    try
    {
      System.load(paramFile1.getAbsolutePath());
      if (QLog.isColorLevel()) {
        QLog.d("SoLoadCore", 2, "System.load path = " + paramFile1.getAbsolutePath() + " suc");
      }
      bool = true;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      for (;;)
      {
        reportThrowable(localUnsatisfiedLinkError, paramString);
        QLog.e("SoLoadCore", 1, "System.load path = " + paramFile1.getAbsolutePath() + " failed", localUnsatisfiedLinkError);
        boolean bool = false;
      }
    }
    if (bool) {
      writeConfig(new ConfigStruct(paramLong, paramFile1.getAbsolutePath()), paramFile2);
    }
    return bool;
  }
  
  public static int loadSo(Context paramContext, String paramString)
  {
    String str1 = getLibActualName(paramString);
    int j = 2097152;
    long l2 = -1L;
    initAssestCrcConfigs(paramContext);
    int i = j;
    long l1 = l2;
    if (assestCrcConfigs != null)
    {
      if (!assestCrcConfigs.isEmpty()) {
        break label110;
      }
      l1 = l2;
      i = j;
    }
    label683:
    label942:
    for (;;)
    {
      if (l1 < 0L) {
        i = 0x80000 | i;
      }
      label110:
      label881:
      do
      {
        do
        {
          try
          {
            System.loadLibrary(paramString);
            j = 0x40000 | i;
            i = j;
          }
          catch (UnsatisfiedLinkError paramContext) {}
          try
          {
            if (QLog.isColorLevel())
            {
              QLog.d("SoLoadCore", 2, "System.loadLibrary, lib = " + paramString + " suc");
              i = j;
            }
            return i;
          }
          catch (UnsatisfiedLinkError paramContext)
          {
            for (;;)
            {
              File localFile;
              Object localObject3;
              Object localObject2;
              String str2;
              i = j;
            }
            i = 3145728;
            l1 = l2;
          }
          Object localObject1 = (Long)assestCrcConfigs.get(getPlatformString() + "/" + str1);
          if ((localObject1 != null) && (((Long)localObject1).longValue() > 1L))
          {
            l1 = ((Long)localObject1).longValue();
            i = 3145728;
            break;
          }
          localObject1 = (Long)assestCrcConfigs.get(getDefaultPlatformString() + "/" + str1);
          if ((localObject1 == null) || (((Long)localObject1).longValue() <= 1L)) {
            break label942;
          }
          l1 = ((Long)localObject1).longValue();
          i = 3145728;
          break;
          reportThrowable(paramContext, paramString);
          QLog.e("SoLoadCore", 1, "try System.loadLibrary, lib = " + paramString + " failed", paramContext);
          return i;
          localObject1 = paramContext.getFilesDir() + "/soconfigs";
          new File((String)localObject1).mkdirs();
          localObject1 = (String)localObject1 + "/" + paramString + ".cfg";
          j = i | 0x20000;
          localFile = new File((String)localObject1);
          i = j;
          if (localFile.exists())
          {
            localObject1 = readConfig(localFile);
            j |= 0x10000;
            i = j;
            if (localObject1 != null) {
              if (!((ConfigStruct)localObject1).mSopath.contains("/txlib/")) {
                break label683;
              }
            }
          }
          for (i = j | 0x4000;; i = j | 0x8000)
          {
            for (;;)
            {
              localObject3 = new File(((ConfigStruct)localObject1).mSopath);
              j = i | 0x2000;
              i = j;
              if (((ConfigStruct)localObject1).mCrcvalue == l1)
              {
                i = j;
                if (((File)localObject3).exists())
                {
                  i = j | 0x1000;
                  j = i;
                  try
                  {
                    System.load(((File)localObject3).getAbsolutePath());
                    int k = i | 0x2;
                    i = k;
                    j = k;
                    if (!QLog.isColorLevel()) {
                      break;
                    }
                    j = k;
                    QLog.d("SoLoadCore", 2, "System.load path = " + ((File)localObject3).getAbsolutePath() + " suc");
                    return k;
                  }
                  catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
                  {
                    i = j;
                  }
                }
              }
            }
            localObject3 = getAppWorkPath(paramContext) + "/txlib/";
            localObject2 = getAppWorkPath(paramContext) + "/lib/";
            localObject2 = new File((String)localObject2 + str1);
            j = i | 0x800;
            i = j;
            if (!((File)localObject2).exists()) {
              break label691;
            }
            j |= 0x400;
            l2 = getCRC32Value((File)localObject2);
            i = j;
            if (l2 != l1) {
              break label691;
            }
            j |= 0x200;
            i = j;
            if (!loadAndSave((File)localObject2, paramString, l2, localFile)) {
              break label691;
            }
            return j | 0x2;
          }
          str2 = getOsClassLoader();
          localObject2 = null;
          if (str2.equals("equalAndAbove14"))
          {
            localObject2 = getSoOrDexByBaseDexClassLoader(paramContext, "lib/" + getPlatformString() + "/" + str1, (String)localObject3 + str1);
            j = i | 0x100;
          }
          for (;;)
          {
            j |= 0x40;
            i = j;
            if (localObject2 == null) {
              break label881;
            }
            l2 = getCRC32Value((File)localObject2);
            j |= 0x20;
            if (l2 != l1) {
              break;
            }
            j |= 0x10;
            i = j;
            if (!loadAndSave((File)localObject2, paramString, l2, localFile)) {
              break label881;
            }
            return j | 0x2;
            j = i;
            if (str2.equals("below14"))
            {
              localObject2 = getSoOrDexByPathClassLoader(paramContext, str1, (String)localObject3);
              j = i | 0x80;
            }
          }
          i = j;
          if (((File)localObject2).exists())
          {
            ((File)localObject2).delete();
            i = j;
          }
          paramContext = releaseFromApk(getApkPath(paramContext), str1, (String)localObject3);
          l2 = getCRC32Value(paramContext);
          j = i | 0x8;
          i = j;
        } while (l2 != l1);
        j |= 0x4;
        i = j;
      } while (!loadAndSave(paramContext, paramString, l2, localFile));
      label691:
      return j | 0x2;
    }
  }
  
  /* Error */
  private static ConfigStruct readConfig(File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 6
    //   6: new 497	java/io/BufferedReader
    //   9: dup
    //   10: new 499	java/io/InputStreamReader
    //   13: dup
    //   14: new 234	java/io/FileInputStream
    //   17: dup
    //   18: aload_0
    //   19: invokespecial 235	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   22: invokespecial 500	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   25: invokespecial 503	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   28: astore_3
    //   29: aload_3
    //   30: invokevirtual 506	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   33: astore_0
    //   34: aload_0
    //   35: ifnull +114 -> 149
    //   38: aload_0
    //   39: ldc_w 624
    //   42: invokevirtual 328	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   45: ifeq +104 -> 149
    //   48: aload_0
    //   49: aload_0
    //   50: ldc_w 626
    //   53: invokevirtual 512	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   56: iconst_1
    //   57: iadd
    //   58: invokevirtual 519	java/lang/String:substring	(I)Ljava/lang/String;
    //   61: invokestatic 523	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   64: lstore_1
    //   65: aload_3
    //   66: invokevirtual 506	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   69: astore_0
    //   70: aload_0
    //   71: ifnull +159 -> 230
    //   74: aload_0
    //   75: ldc_w 628
    //   78: invokevirtual 328	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   81: ifeq +149 -> 230
    //   84: aload_0
    //   85: aload_0
    //   86: ldc_w 626
    //   89: invokevirtual 512	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   92: iconst_1
    //   93: iadd
    //   94: invokevirtual 519	java/lang/String:substring	(I)Ljava/lang/String;
    //   97: astore 4
    //   99: aload 6
    //   101: astore_0
    //   102: lload_1
    //   103: ldc2_w 584
    //   106: lcmp
    //   107: ifeq +25 -> 132
    //   110: aload 6
    //   112: astore_0
    //   113: aload 4
    //   115: ldc_w 630
    //   118: if_acmpeq +14 -> 132
    //   121: new 426	com/tencent/commonsdk/soload/ConfigStruct
    //   124: dup
    //   125: lload_1
    //   126: aload 4
    //   128: invokespecial 568	com/tencent/commonsdk/soload/ConfigStruct:<init>	(JLjava/lang/String;)V
    //   131: astore_0
    //   132: aload_0
    //   133: astore 4
    //   135: aload_3
    //   136: ifnull +10 -> 146
    //   139: aload_3
    //   140: invokevirtual 631	java/io/BufferedReader:close	()V
    //   143: aload_0
    //   144: astore 4
    //   146: aload 4
    //   148: areturn
    //   149: aload 5
    //   151: astore 4
    //   153: aload_3
    //   154: ifnull -8 -> 146
    //   157: aload_3
    //   158: invokevirtual 631	java/io/BufferedReader:close	()V
    //   161: aconst_null
    //   162: areturn
    //   163: astore_0
    //   164: aload_0
    //   165: invokevirtual 132	java/io/IOException:printStackTrace	()V
    //   168: aconst_null
    //   169: areturn
    //   170: astore_3
    //   171: aload_3
    //   172: invokevirtual 132	java/io/IOException:printStackTrace	()V
    //   175: aload_0
    //   176: areturn
    //   177: astore_0
    //   178: aconst_null
    //   179: astore_3
    //   180: aload 5
    //   182: astore 4
    //   184: aload_3
    //   185: ifnull -39 -> 146
    //   188: aload_3
    //   189: invokevirtual 631	java/io/BufferedReader:close	()V
    //   192: aconst_null
    //   193: areturn
    //   194: astore_0
    //   195: aload_0
    //   196: invokevirtual 132	java/io/IOException:printStackTrace	()V
    //   199: aconst_null
    //   200: areturn
    //   201: astore_0
    //   202: aconst_null
    //   203: astore_3
    //   204: aload_3
    //   205: ifnull +7 -> 212
    //   208: aload_3
    //   209: invokevirtual 631	java/io/BufferedReader:close	()V
    //   212: aload_0
    //   213: athrow
    //   214: astore_3
    //   215: aload_3
    //   216: invokevirtual 132	java/io/IOException:printStackTrace	()V
    //   219: goto -7 -> 212
    //   222: astore_0
    //   223: goto -19 -> 204
    //   226: astore_0
    //   227: goto -47 -> 180
    //   230: ldc_w 630
    //   233: astore 4
    //   235: goto -136 -> 99
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	238	0	paramFile	File
    //   64	62	1	l	long
    //   28	130	3	localBufferedReader	java.io.BufferedReader
    //   170	2	3	localIOException1	IOException
    //   179	30	3	localObject1	Object
    //   214	2	3	localIOException2	IOException
    //   97	137	4	localObject2	Object
    //   1	180	5	localObject3	Object
    //   4	107	6	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   157	161	163	java/io/IOException
    //   139	143	170	java/io/IOException
    //   6	29	177	java/lang/Exception
    //   188	192	194	java/io/IOException
    //   6	29	201	finally
    //   208	212	214	java/io/IOException
    //   29	34	222	finally
    //   38	70	222	finally
    //   74	99	222	finally
    //   121	132	222	finally
    //   29	34	226	java/lang/Exception
    //   38	70	226	java/lang/Exception
    //   74	99	226	java/lang/Exception
    //   121	132	226	java/lang/Exception
  }
  
  public static boolean releaseDexFromApk(Context paramContext, String paramString)
  {
    String str1 = null;
    Object localObject1 = paramContext.getFilesDir();
    Object localObject2;
    DexReleasor localDexReleasor;
    int i;
    if (localObject1 != null)
    {
      localObject1 = ((File)localObject1).getAbsolutePath();
      localObject2 = localObject1;
      if (!((String)localObject1).endsWith(File.separator)) {
        localObject2 = (String)localObject1 + File.separator;
      }
      new File((String)localObject2).mkdirs();
      localDexReleasor = DexReleasor.getInstance(getApkPath(paramContext), (String)localObject2);
      i = 0;
      label78:
      if (i >= DexReleasor.sExtraDexes.length) {
        break label256;
      }
      if (!TextUtils.equals(paramString, DexReleasor.sExtraDexes[i])) {
        break label152;
      }
      localObject1 = DexReleasor.sExtraJarDexes[i];
      str1 = DexReleasor.sExtraDexes[i] + ".MD5";
    }
    for (;;)
    {
      String str2 = getCurProcessName(paramContext);
      if (TextUtils.isEmpty(str2)) {}
      label152:
      do
      {
        return false;
        localObject1 = "/data/data/com.tencent.mobileqq/files";
        break;
        i += 1;
        break label78;
        paramString = localDexReleasor.releaseDex(str2, paramString);
        if (isLibExtracted(paramContext, (String)localObject1, str1))
        {
          if ((paramString == null) || (!paramString.exists())) {
            break label254;
          }
          paramString.delete();
          return true;
        }
        paramContext = new File((String)localObject2 + (String)localObject1);
        if (paramContext.exists()) {
          paramContext.delete();
        }
      } while ((paramString == null) || (!paramString.exists()));
      paramString.renameTo(paramContext);
      return true;
      label254:
      return true;
      label256:
      localObject1 = null;
    }
  }
  
  /* Error */
  public static File releaseFromApk(String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +5 -> 6
    //   4: aconst_null
    //   5: areturn
    //   6: aload_2
    //   7: astore 4
    //   9: aload_2
    //   10: getstatic 636	java/io/File:separator	Ljava/lang/String;
    //   13: invokevirtual 639	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   16: ifne +25 -> 41
    //   19: new 303	java/lang/StringBuilder
    //   22: dup
    //   23: invokespecial 304	java/lang/StringBuilder:<init>	()V
    //   26: aload_2
    //   27: invokevirtual 308	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: getstatic 636	java/io/File:separator	Ljava/lang/String;
    //   33: invokevirtual 308	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: invokevirtual 316	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   39: astore 4
    //   41: new 173	java/io/File
    //   44: dup
    //   45: aload 4
    //   47: invokespecial 417	java/io/File:<init>	(Ljava/lang/String;)V
    //   50: invokevirtual 598	java/io/File:mkdirs	()Z
    //   53: pop
    //   54: new 303	java/lang/StringBuilder
    //   57: dup
    //   58: invokespecial 304	java/lang/StringBuilder:<init>	()V
    //   61: ldc_w 612
    //   64: invokevirtual 308	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: invokestatic 592	com/tencent/commonsdk/soload/SoLoadCore:getPlatformString	()Ljava/lang/String;
    //   70: invokevirtual 308	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: ldc_w 401
    //   76: invokevirtual 308	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: invokevirtual 316	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   82: astore_2
    //   83: new 303	java/lang/StringBuilder
    //   86: dup
    //   87: invokespecial 304	java/lang/StringBuilder:<init>	()V
    //   90: ldc_w 612
    //   93: invokevirtual 308	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: invokestatic 592	com/tencent/commonsdk/soload/SoLoadCore:getPlatformString	()Ljava/lang/String;
    //   99: invokevirtual 308	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: ldc_w 401
    //   105: invokevirtual 308	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: aload_1
    //   109: invokevirtual 308	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: invokevirtual 316	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   115: astore_1
    //   116: new 675	com/tencent/commonsdk/soload/MyZipFile
    //   119: dup
    //   120: new 173	java/io/File
    //   123: dup
    //   124: aload_0
    //   125: invokespecial 417	java/io/File:<init>	(Ljava/lang/String;)V
    //   128: aload_1
    //   129: invokespecial 676	com/tencent/commonsdk/soload/MyZipFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   132: astore_0
    //   133: aload_0
    //   134: ifnull -130 -> 4
    //   137: aload_0
    //   138: invokevirtual 680	com/tencent/commonsdk/soload/MyZipFile:getDesEntry	()Lcom/tencent/commonsdk/soload/MyZipEntry;
    //   141: astore 5
    //   143: aload 5
    //   145: ifnull -141 -> 4
    //   148: aload 5
    //   150: invokevirtual 685	com/tencent/commonsdk/soload/MyZipEntry:getName	()Ljava/lang/String;
    //   153: aload_2
    //   154: invokevirtual 328	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   157: ifeq -153 -> 4
    //   160: aload 5
    //   162: invokevirtual 685	com/tencent/commonsdk/soload/MyZipEntry:getName	()Ljava/lang/String;
    //   165: ldc_w 350
    //   168: invokevirtual 639	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   171: ifeq -167 -> 4
    //   174: aload 5
    //   176: invokevirtual 685	com/tencent/commonsdk/soload/MyZipEntry:getName	()Ljava/lang/String;
    //   179: astore_2
    //   180: aload_2
    //   181: bipush 47
    //   183: invokevirtual 689	java/lang/String:lastIndexOf	(I)I
    //   186: istore_3
    //   187: aload_2
    //   188: astore_1
    //   189: iload_3
    //   190: iconst_m1
    //   191: if_icmpeq +11 -> 202
    //   194: aload_2
    //   195: iload_3
    //   196: iconst_1
    //   197: iadd
    //   198: invokevirtual 519	java/lang/String:substring	(I)Ljava/lang/String;
    //   201: astore_1
    //   202: new 173	java/io/File
    //   205: dup
    //   206: new 303	java/lang/StringBuilder
    //   209: dup
    //   210: invokespecial 304	java/lang/StringBuilder:<init>	()V
    //   213: aload 4
    //   215: invokevirtual 308	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: aload_1
    //   219: invokevirtual 308	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: invokevirtual 316	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   225: invokespecial 417	java/io/File:<init>	(Ljava/lang/String;)V
    //   228: astore_1
    //   229: aload_1
    //   230: invokevirtual 232	java/io/File:exists	()Z
    //   233: ifeq +8 -> 241
    //   236: aload_1
    //   237: invokevirtual 438	java/io/File:delete	()Z
    //   240: pop
    //   241: sipush 4096
    //   244: newarray byte
    //   246: astore_2
    //   247: aload_0
    //   248: aload 5
    //   250: invokevirtual 692	com/tencent/commonsdk/soload/MyZipFile:getInputStream	(Lcom/tencent/commonsdk/soload/MyZipEntry;)Ljava/io/InputStream;
    //   253: astore_0
    //   254: new 116	java/io/FileOutputStream
    //   257: dup
    //   258: aload_1
    //   259: invokespecial 119	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   262: astore 4
    //   264: aload_0
    //   265: aload_2
    //   266: invokevirtual 244	java/io/InputStream:read	([B)I
    //   269: istore_3
    //   270: iload_3
    //   271: ifle +43 -> 314
    //   274: aload 4
    //   276: aload_2
    //   277: iconst_0
    //   278: iload_3
    //   279: invokevirtual 693	java/io/FileOutputStream:write	([BII)V
    //   282: goto -18 -> 264
    //   285: astore_0
    //   286: ldc 67
    //   288: iconst_1
    //   289: ldc_w 695
    //   292: aload_0
    //   293: invokestatic 581	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   296: aload_1
    //   297: areturn
    //   298: astore_0
    //   299: ldc 67
    //   301: iconst_1
    //   302: ldc_w 695
    //   305: aload_0
    //   306: invokestatic 581	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   309: aconst_null
    //   310: astore_0
    //   311: goto -178 -> 133
    //   314: aload_1
    //   315: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	316	0	paramString1	String
    //   0	316	1	paramString2	String
    //   0	316	2	paramString3	String
    //   186	93	3	i	int
    //   7	268	4	localObject	Object
    //   141	108	5	localMyZipEntry	MyZipEntry
    // Exception table:
    //   from	to	target	type
    //   247	264	285	java/io/IOException
    //   264	270	285	java/io/IOException
    //   274	282	285	java/io/IOException
    //   116	133	298	java/io/IOException
  }
  
  public static String releaseSo(Context paramContext, String paramString)
  {
    String str = getLibActualName(paramString);
    initAssestCrcConfigs(paramContext);
    if ((assestCrcConfigs != null) && (!assestCrcConfigs.isEmpty()))
    {
      paramString = (Long)assestCrcConfigs.get(getDefaultPlatformString() + "/" + str);
      if (paramString == null) {}
    }
    for (long l = paramString.longValue();; l = -1L)
    {
      paramString = paramContext.getFilesDir() + "/soconfigs";
      new File(paramString).mkdirs();
      File localFile = new File(paramString + "/" + str + ".cfg");
      if ((localFile.exists()) && (localFile.isFile()))
      {
        paramString = readConfig(localFile);
        if (paramString != null)
        {
          localObject = new File(paramString.mSopath);
          if ((paramString.mCrcvalue == l) && (((File)localObject).exists())) {
            return ((File)localObject).getAbsolutePath();
          }
        }
        localFile.delete();
      }
      Object localObject = getAppWorkPath(paramContext) + "/txlib/";
      paramString = getAppWorkPath(paramContext) + "/lib/";
      paramString = new File(paramString + str);
      if ((paramString.exists()) && (paramString.isFile()) && (getCRC32Value(paramString) == l))
      {
        paramContext = paramString.getAbsolutePath();
        writeConfig(new ConfigStruct(l, paramString.getAbsolutePath()), localFile);
        return paramContext;
      }
      paramString = getOsClassLoader();
      if (paramString.equals("equalAndAbove14")) {
        paramString = getSoOrDexByBaseDexClassLoader(paramContext, "lib/" + getPlatformString() + "/" + str, (String)localObject + str);
      }
      for (;;)
      {
        if (paramString == null) {}
        for (paramContext = releaseFromApk(getApkPath(paramContext), str, (String)localObject);; paramContext = paramString)
        {
          if ((paramContext != null) && (paramContext.exists()))
          {
            paramString = paramContext.getAbsolutePath();
            writeConfig(new ConfigStruct(l, paramContext.getAbsolutePath()), localFile);
            return paramString;
            if (!paramString.equals("below14")) {
              break label490;
            }
            paramString = getSoOrDexByPathClassLoader(paramContext, str, (String)localObject);
            break;
          }
          return null;
        }
        label490:
        paramString = null;
      }
    }
  }
  
  public static File releaseSoAnyway(Context paramContext, String paramString1, String paramString2)
  {
    Object localObject2;
    if (hasBaseDexClassloader())
    {
      localObject2 = "lib/" + getPlatformString() + "/" + paramString1;
      localObject1 = paramString2;
      if (!paramString2.endsWith(File.separator)) {
        localObject1 = paramString2 + File.separator;
      }
      localObject2 = getSoOrDexByBaseDexClassLoader(paramContext, (String)localObject2, (String)localObject1 + paramString1);
      paramString2 = (String)localObject1;
    }
    for (Object localObject1 = localObject2;; localObject1 = getSoOrDexByPathClassLoader(paramContext, paramString1, paramString2))
    {
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = releaseFromApk(getApkPath(paramContext), paramString1, paramString2);
      }
      return localObject2;
    }
  }
  
  private static void reportThrowable(Throwable paramThrowable, String paramString)
  {
    SoLoadReport localSoLoadReport = SoLoadUtilNew.sReport;
    if (localSoLoadReport != null) {
      localSoLoadReport.reportThrowable(paramThrowable, paramString);
    }
  }
  
  public static void setIsCpu64Bit(boolean paramBoolean)
  {
    IS_CPU_64_BIT = paramBoolean;
  }
  
  /* Error */
  private static boolean writeConfig(ConfigStruct paramConfigStruct, File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: iconst_0
    //   4: istore_2
    //   5: aload_1
    //   6: invokevirtual 232	java/io/File:exists	()Z
    //   9: ifeq +8 -> 17
    //   12: aload_1
    //   13: invokevirtual 438	java/io/File:delete	()Z
    //   16: pop
    //   17: aload_1
    //   18: invokevirtual 450	java/io/File:createNewFile	()Z
    //   21: pop
    //   22: new 711	java/io/BufferedWriter
    //   25: dup
    //   26: new 713	java/io/OutputStreamWriter
    //   29: dup
    //   30: new 116	java/io/FileOutputStream
    //   33: dup
    //   34: aload_1
    //   35: invokespecial 119	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   38: invokespecial 714	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;)V
    //   41: invokespecial 717	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   44: astore_1
    //   45: aload_1
    //   46: new 303	java/lang/StringBuilder
    //   49: dup
    //   50: invokespecial 304	java/lang/StringBuilder:<init>	()V
    //   53: ldc_w 719
    //   56: invokevirtual 308	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: aload_0
    //   60: getfield 430	com/tencent/commonsdk/soload/ConfigStruct:mCrcvalue	J
    //   63: invokevirtual 722	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   66: invokevirtual 316	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   69: invokevirtual 724	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   72: aload_1
    //   73: invokevirtual 727	java/io/BufferedWriter:newLine	()V
    //   76: aload_1
    //   77: new 303	java/lang/StringBuilder
    //   80: dup
    //   81: invokespecial 304	java/lang/StringBuilder:<init>	()V
    //   84: ldc_w 729
    //   87: invokevirtual 308	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: aload_0
    //   91: getfield 433	com/tencent/commonsdk/soload/ConfigStruct:mSopath	Ljava/lang/String;
    //   94: invokevirtual 308	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: invokevirtual 316	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   100: invokevirtual 724	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   103: iconst_1
    //   104: istore_3
    //   105: iload_3
    //   106: istore_2
    //   107: aload_1
    //   108: ifnull +9 -> 117
    //   111: aload_1
    //   112: invokevirtual 730	java/io/BufferedWriter:close	()V
    //   115: iload_3
    //   116: istore_2
    //   117: iload_2
    //   118: ireturn
    //   119: astore_0
    //   120: aload_0
    //   121: invokevirtual 132	java/io/IOException:printStackTrace	()V
    //   124: iconst_1
    //   125: ireturn
    //   126: astore_0
    //   127: aload 4
    //   129: astore_0
    //   130: aload_0
    //   131: ifnull -14 -> 117
    //   134: aload_0
    //   135: invokevirtual 730	java/io/BufferedWriter:close	()V
    //   138: iconst_0
    //   139: ireturn
    //   140: astore_0
    //   141: aload_0
    //   142: invokevirtual 132	java/io/IOException:printStackTrace	()V
    //   145: iconst_0
    //   146: ireturn
    //   147: astore_0
    //   148: aconst_null
    //   149: astore_1
    //   150: aload_1
    //   151: ifnull +7 -> 158
    //   154: aload_1
    //   155: invokevirtual 730	java/io/BufferedWriter:close	()V
    //   158: aload_0
    //   159: athrow
    //   160: astore_1
    //   161: aload_1
    //   162: invokevirtual 132	java/io/IOException:printStackTrace	()V
    //   165: goto -7 -> 158
    //   168: astore_0
    //   169: goto -19 -> 150
    //   172: astore_0
    //   173: aload_1
    //   174: astore_0
    //   175: goto -45 -> 130
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	178	0	paramConfigStruct	ConfigStruct
    //   0	178	1	paramFile	File
    //   4	114	2	bool1	boolean
    //   104	12	3	bool2	boolean
    //   1	127	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   111	115	119	java/io/IOException
    //   5	17	126	java/lang/Exception
    //   17	45	126	java/lang/Exception
    //   134	138	140	java/io/IOException
    //   5	17	147	finally
    //   17	45	147	finally
    //   154	158	160	java/io/IOException
    //   45	103	168	finally
    //   45	103	172	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.commonsdk.soload.SoLoadCore
 * JD-Core Version:    0.7.0.1
 */