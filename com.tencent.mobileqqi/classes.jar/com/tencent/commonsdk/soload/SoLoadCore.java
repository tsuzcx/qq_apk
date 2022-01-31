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
import dalvik.system.BaseDexClassLoader;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.zip.CRC32;
import java.util.zip.ZipFile;

public class SoLoadCore
{
  public static final int API_BELOW_14 = 128;
  public static final int API_EUQAL_AND_ABOVE_14 = 256;
  public static final String APP_ROOT = "/data/data/com.tencent.mobileqqi/files";
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
  public static final int LOAD_SO_SUCCESS_SAVE_AND_RETURN = 2;
  private static final String PACKAGE_NAME = "com.tencent.mobileqqi";
  public static final String PATH_LIB = "/lib/";
  public static final String PATH_TX_LIB = "/txlib/";
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
    int i = ((InputStream)localObject).read();
    if (-1 != i) {
      if (i == paramInputStream1.read()) {}
    }
    while (paramInputStream1.read() != -1)
    {
      return false;
      i = ((InputStream)localObject).read();
      break;
    }
    return true;
  }
  
  /* Error */
  private static void copyZipEntry2File(java.util.zip.ZipEntry paramZipEntry, ZipFile paramZipFile, File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: aconst_null
    //   4: astore 4
    //   6: aconst_null
    //   7: astore 5
    //   9: aconst_null
    //   10: astore 9
    //   12: aconst_null
    //   13: astore 10
    //   15: aconst_null
    //   16: astore 12
    //   18: aconst_null
    //   19: astore 11
    //   21: aload_0
    //   22: ifnull +7 -> 29
    //   25: aload_1
    //   26: ifnonnull +44 -> 70
    //   29: iconst_0
    //   30: ifeq +11 -> 41
    //   33: new 94	java/lang/NullPointerException
    //   36: dup
    //   37: invokespecial 95	java/lang/NullPointerException:<init>	()V
    //   40: athrow
    //   41: iconst_0
    //   42: ifeq +11 -> 53
    //   45: new 94	java/lang/NullPointerException
    //   48: dup
    //   49: invokespecial 95	java/lang/NullPointerException:<init>	()V
    //   52: athrow
    //   53: iconst_0
    //   54: ifeq +11 -> 65
    //   57: new 94	java/lang/NullPointerException
    //   60: dup
    //   61: invokespecial 95	java/lang/NullPointerException:<init>	()V
    //   64: athrow
    //   65: aload_1
    //   66: invokevirtual 100	java/util/zip/ZipFile:close	()V
    //   69: return
    //   70: aload 12
    //   72: astore 6
    //   74: aload 5
    //   76: astore 7
    //   78: aload_1
    //   79: aload_0
    //   80: invokevirtual 104	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   83: astore_0
    //   84: aload 12
    //   86: astore 6
    //   88: aload 5
    //   90: astore 7
    //   92: aload_0
    //   93: astore 4
    //   95: aload_0
    //   96: astore 8
    //   98: new 80	java/io/BufferedInputStream
    //   101: dup
    //   102: aload_0
    //   103: invokespecial 83	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   106: astore 5
    //   108: sipush 8192
    //   111: newarray byte
    //   113: astore 4
    //   115: new 106	java/io/BufferedOutputStream
    //   118: dup
    //   119: new 108	java/io/FileOutputStream
    //   122: dup
    //   123: aload_2
    //   124: invokespecial 111	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   127: invokespecial 114	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   130: astore_2
    //   131: aload 5
    //   133: aload 4
    //   135: invokevirtual 117	java/io/BufferedInputStream:read	([B)I
    //   138: istore_3
    //   139: iload_3
    //   140: iconst_m1
    //   141: if_icmpeq +74 -> 215
    //   144: aload_2
    //   145: aload 4
    //   147: iconst_0
    //   148: iload_3
    //   149: invokevirtual 121	java/io/BufferedOutputStream:write	([BII)V
    //   152: goto -21 -> 131
    //   155: astore 9
    //   157: aload 5
    //   159: astore 4
    //   161: aload_2
    //   162: astore 5
    //   164: aload 4
    //   166: astore_2
    //   167: aload_2
    //   168: astore 6
    //   170: aload 5
    //   172: astore 7
    //   174: aload_0
    //   175: astore 4
    //   177: aload 9
    //   179: invokevirtual 124	java/io/IOException:printStackTrace	()V
    //   182: aload_2
    //   183: ifnull +7 -> 190
    //   186: aload_2
    //   187: invokevirtual 125	java/io/BufferedInputStream:close	()V
    //   190: aload_0
    //   191: ifnull +7 -> 198
    //   194: aload_0
    //   195: invokevirtual 126	java/io/InputStream:close	()V
    //   198: aload 5
    //   200: ifnull +8 -> 208
    //   203: aload 5
    //   205: invokevirtual 127	java/io/BufferedOutputStream:close	()V
    //   208: aload_1
    //   209: invokevirtual 100	java/util/zip/ZipFile:close	()V
    //   212: return
    //   213: astore_0
    //   214: return
    //   215: aload_2
    //   216: ifnull +7 -> 223
    //   219: aload_2
    //   220: invokevirtual 127	java/io/BufferedOutputStream:close	()V
    //   223: aload 5
    //   225: ifnull +8 -> 233
    //   228: aload 5
    //   230: invokevirtual 125	java/io/BufferedInputStream:close	()V
    //   233: aload_0
    //   234: ifnull +7 -> 241
    //   237: aload_0
    //   238: invokevirtual 126	java/io/InputStream:close	()V
    //   241: aload_2
    //   242: ifnull +7 -> 249
    //   245: aload_2
    //   246: invokevirtual 127	java/io/BufferedOutputStream:close	()V
    //   249: aload_1
    //   250: invokevirtual 100	java/util/zip/ZipFile:close	()V
    //   253: return
    //   254: astore_0
    //   255: return
    //   256: astore_0
    //   257: aload 6
    //   259: ifnull +8 -> 267
    //   262: aload 6
    //   264: invokevirtual 125	java/io/BufferedInputStream:close	()V
    //   267: aload 4
    //   269: ifnull +8 -> 277
    //   272: aload 4
    //   274: invokevirtual 126	java/io/InputStream:close	()V
    //   277: aload 7
    //   279: ifnull +8 -> 287
    //   282: aload 7
    //   284: invokevirtual 127	java/io/BufferedOutputStream:close	()V
    //   287: aload_1
    //   288: invokevirtual 100	java/util/zip/ZipFile:close	()V
    //   291: aload_0
    //   292: athrow
    //   293: astore_0
    //   294: return
    //   295: astore_1
    //   296: goto -5 -> 291
    //   299: astore_2
    //   300: goto -13 -> 287
    //   303: astore_2
    //   304: aload 5
    //   306: astore 6
    //   308: aload 9
    //   310: astore 7
    //   312: aload_0
    //   313: astore 4
    //   315: aload_2
    //   316: astore_0
    //   317: goto -60 -> 257
    //   320: astore 8
    //   322: aload 5
    //   324: astore 6
    //   326: aload_2
    //   327: astore 7
    //   329: aload_0
    //   330: astore 4
    //   332: aload 8
    //   334: astore_0
    //   335: goto -78 -> 257
    //   338: astore_0
    //   339: goto -131 -> 208
    //   342: astore 9
    //   344: aload 11
    //   346: astore_2
    //   347: aload 10
    //   349: astore 5
    //   351: aload 8
    //   353: astore_0
    //   354: goto -187 -> 167
    //   357: astore 9
    //   359: aload 5
    //   361: astore_2
    //   362: aload 10
    //   364: astore 5
    //   366: goto -199 -> 167
    //   369: astore_0
    //   370: goto -121 -> 249
    //   373: astore_0
    //   374: goto -309 -> 65
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	377	0	paramZipEntry	java.util.zip.ZipEntry
    //   0	377	1	paramZipFile	ZipFile
    //   0	377	2	paramFile	File
    //   138	11	3	i	int
    //   4	327	4	localObject1	Object
    //   7	358	5	localObject2	Object
    //   72	253	6	localObject3	Object
    //   76	252	7	localObject4	Object
    //   1	96	8	localZipEntry	java.util.zip.ZipEntry
    //   320	32	8	localObject5	Object
    //   10	1	9	localObject6	Object
    //   155	154	9	localIOException1	IOException
    //   342	1	9	localIOException2	IOException
    //   357	1	9	localIOException3	IOException
    //   13	350	10	localObject7	Object
    //   19	326	11	localObject8	Object
    //   16	69	12	localObject9	Object
    // Exception table:
    //   from	to	target	type
    //   131	139	155	java/io/IOException
    //   144	152	155	java/io/IOException
    //   219	223	155	java/io/IOException
    //   208	212	213	java/io/IOException
    //   249	253	254	java/io/IOException
    //   78	84	256	finally
    //   98	108	256	finally
    //   177	182	256	finally
    //   65	69	293	java/io/IOException
    //   287	291	295	java/io/IOException
    //   262	267	299	java/io/IOException
    //   272	277	299	java/io/IOException
    //   282	287	299	java/io/IOException
    //   108	131	303	finally
    //   131	139	320	finally
    //   144	152	320	finally
    //   219	223	320	finally
    //   186	190	338	java/io/IOException
    //   194	198	338	java/io/IOException
    //   203	208	338	java/io/IOException
    //   78	84	342	java/io/IOException
    //   98	108	342	java/io/IOException
    //   108	131	357	java/io/IOException
    //   228	233	369	java/io/IOException
    //   237	241	369	java/io/IOException
    //   245	249	369	java/io/IOException
    //   33	41	373	java/io/IOException
    //   45	53	373	java/io/IOException
    //   57	65	373	java/io/IOException
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
    //   0: ldc2_w 219
    //   3: lstore_3
    //   4: lload_3
    //   5: lstore_1
    //   6: aload_0
    //   7: ifnull +12 -> 19
    //   10: aload_0
    //   11: invokevirtual 224	java/io/File:exists	()Z
    //   14: ifne +7 -> 21
    //   17: lload_3
    //   18: lstore_1
    //   19: lload_1
    //   20: lreturn
    //   21: aconst_null
    //   22: astore 5
    //   24: aconst_null
    //   25: astore 6
    //   27: new 226	java/io/FileInputStream
    //   30: dup
    //   31: aload_0
    //   32: invokespecial 227	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   35: astore_0
    //   36: aload_0
    //   37: invokestatic 230	com/tencent/commonsdk/soload/SoLoadCore:getCRC32Value	(Ljava/io/InputStream;)J
    //   40: lstore_1
    //   41: lload_1
    //   42: lstore_3
    //   43: lload_3
    //   44: lstore_1
    //   45: aload_0
    //   46: ifnull -27 -> 19
    //   49: aload_0
    //   50: invokevirtual 231	java/io/FileInputStream:close	()V
    //   53: lload_3
    //   54: lreturn
    //   55: astore_0
    //   56: aload_0
    //   57: invokevirtual 124	java/io/IOException:printStackTrace	()V
    //   60: lload_3
    //   61: lreturn
    //   62: astore 5
    //   64: aload 6
    //   66: astore_0
    //   67: aload 5
    //   69: astore 6
    //   71: aload_0
    //   72: astore 5
    //   74: aload 6
    //   76: invokevirtual 232	java/lang/Exception:printStackTrace	()V
    //   79: lload_3
    //   80: lstore_1
    //   81: aload_0
    //   82: ifnull -63 -> 19
    //   85: aload_0
    //   86: invokevirtual 231	java/io/FileInputStream:close	()V
    //   89: ldc2_w 219
    //   92: lreturn
    //   93: astore_0
    //   94: aload_0
    //   95: invokevirtual 124	java/io/IOException:printStackTrace	()V
    //   98: ldc2_w 219
    //   101: lreturn
    //   102: astore_0
    //   103: aload 5
    //   105: ifnull +8 -> 113
    //   108: aload 5
    //   110: invokevirtual 231	java/io/FileInputStream:close	()V
    //   113: aload_0
    //   114: athrow
    //   115: astore 5
    //   117: aload 5
    //   119: invokevirtual 124	java/io/IOException:printStackTrace	()V
    //   122: goto -9 -> 113
    //   125: astore 6
    //   127: aload_0
    //   128: astore 5
    //   130: aload 6
    //   132: astore_0
    //   133: goto -30 -> 103
    //   136: astore 6
    //   138: goto -67 -> 71
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	141	0	paramFile	File
    //   5	76	1	l1	long
    //   3	77	3	l2	long
    //   22	1	5	localObject1	Object
    //   62	6	5	localException1	Exception
    //   72	37	5	localFile1	File
    //   115	3	5	localIOException	IOException
    //   128	1	5	localFile2	File
    //   25	50	6	localException2	Exception
    //   125	6	6	localObject2	Object
    //   136	1	6	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   49	53	55	java/io/IOException
    //   27	36	62	java/lang/Exception
    //   85	89	93	java/io/IOException
    //   27	36	102	finally
    //   74	79	102	finally
    //   108	113	115	java/io/IOException
    //   36	41	125	finally
    //   36	41	136	java/lang/Exception
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
        if ((localRunningAppProcessInfo.processName.startsWith("com.tencent.mobileqqi")) && (localRunningAppProcessInfo.pid == i)) {
          return localRunningAppProcessInfo.processName + "_" + i;
        }
      }
    }
    return null;
  }
  
  private static String getDefaultPlatformString()
  {
    return "armeabi";
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
        paramContext = new File("/data/data/com.tencent.mobileqqi/files", paramString);
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
  private static String getPlatformString()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 352	android/os/Build:CPU_ABI	Ljava/lang/String;
    //   6: astore_0
    //   7: aload_0
    //   8: ifnull +22 -> 30
    //   11: aload_0
    //   12: ldc_w 354
    //   15: invokevirtual 358	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   18: ifeq +12 -> 30
    //   21: ldc_w 354
    //   24: astore_0
    //   25: ldc 2
    //   27: monitorexit
    //   28: aload_0
    //   29: areturn
    //   30: aload_0
    //   31: ifnull +20 -> 51
    //   34: aload_0
    //   35: ldc_w 360
    //   38: invokevirtual 358	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   41: ifeq +10 -> 51
    //   44: ldc_w 362
    //   47: astore_0
    //   48: goto -23 -> 25
    //   51: ldc_w 311
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
  
  public static String getReleasedSoFilePath(Context paramContext, String paramString)
  {
    paramString = getLibActualName(paramString);
    initAssestCrcConfigs(paramContext);
    if ((assestCrcConfigs == null) || (assestCrcConfigs.isEmpty())) {}
    long l;
    do
    {
      do
      {
        do
        {
          Long localLong;
          do
          {
            return null;
            localLong = (Long)assestCrcConfigs.get(getDefaultPlatformString() + "/" + paramString);
          } while (localLong == null);
          l = localLong.longValue();
        } while (l <= 0L);
        paramContext = paramContext.getFilesDir() + "/" + "soconfigs";
        paramContext = new File(paramContext + "/" + paramString + ".cfg");
      } while ((!paramContext.exists()) || (!paramContext.isFile()));
      paramContext = readConfig(paramContext);
    } while ((paramContext == null) || (paramContext.mCrcvalue != l));
    return paramContext.mSopath;
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
    try
    {
      localFile.createNewFile();
      Object localObject = paramString2.getDeclaredField("pathList");
      ((Field)localObject).setAccessible(true);
      paramString2 = ((Field)localObject).get(paramContext);
      paramContext = ((Field)localObject).get(paramContext).getClass().getDeclaredField("dexElements");
      paramContext.setAccessible(true);
      localObject = paramContext.get(paramString2);
      int j;
      int i;
      if (localObject.getClass().isArray())
      {
        j = Array.getLength(localObject);
        if (j > 0)
        {
          paramString2 = null;
          paramContext = null;
          i = 0;
        }
      }
      for (;;)
      {
        if (i < j)
        {
          paramContext = Array.get(localObject, i);
          paramString2 = paramContext.getClass().getDeclaredField("zipFile");
          paramString2.setAccessible(true);
          paramContext = (ZipFile)paramString2.get(paramContext);
          paramString2 = paramContext.getEntry(paramString1);
          if (paramString2 == null) {}
        }
        else
        {
          if ((paramString2 == null) || (paramContext == null)) {
            break;
          }
          copyZipEntry2File(paramString2, paramContext, localFile);
          return localFile;
        }
        i += 1;
      }
      return null;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return null;
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
      int j;
      int i;
      if (localObject.getClass().isArray())
      {
        paramContext = null;
        paramString2 = null;
        j = Array.getLength(localObject);
        i = 0;
      }
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
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return null;
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
    //   3: getstatic 70	com/tencent/commonsdk/soload/SoLoadCore:assestCrcConfigs	Ljava/util/HashMap;
    //   6: astore 4
    //   8: aload 4
    //   10: ifnull +7 -> 17
    //   13: ldc 2
    //   15: monitorexit
    //   16: return
    //   17: aconst_null
    //   18: astore 7
    //   20: aconst_null
    //   21: astore 6
    //   23: aload 6
    //   25: astore 5
    //   27: aload 7
    //   29: astore 4
    //   31: new 372	java/util/HashMap
    //   34: dup
    //   35: invokespecial 457	java/util/HashMap:<init>	()V
    //   38: putstatic 70	com/tencent/commonsdk/soload/SoLoadCore:assestCrcConfigs	Ljava/util/HashMap;
    //   41: aload 6
    //   43: astore 5
    //   45: aload 7
    //   47: astore 4
    //   49: aload_0
    //   50: invokevirtual 461	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   53: invokevirtual 467	android/content/res/Resources:getAssets	()Landroid/content/res/AssetManager;
    //   56: ldc 16
    //   58: invokevirtual 473	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   61: astore_0
    //   62: aload_0
    //   63: astore 5
    //   65: aload_0
    //   66: astore 4
    //   68: new 475	java/io/BufferedReader
    //   71: dup
    //   72: new 477	java/io/InputStreamReader
    //   75: dup
    //   76: aload_0
    //   77: invokespecial 478	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   80: invokespecial 481	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   83: astore 6
    //   85: aload_0
    //   86: astore 5
    //   88: aload_0
    //   89: astore 4
    //   91: aload 6
    //   93: invokevirtual 484	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   96: astore 7
    //   98: aload 7
    //   100: ifnull +115 -> 215
    //   103: aload_0
    //   104: astore 5
    //   106: aload_0
    //   107: astore 4
    //   109: aload 7
    //   111: ldc_w 486
    //   114: invokevirtual 490	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   117: istore_1
    //   118: aload_0
    //   119: astore 5
    //   121: aload_0
    //   122: astore 4
    //   124: aload 7
    //   126: iconst_0
    //   127: iload_1
    //   128: invokevirtual 494	java/lang/String:substring	(II)Ljava/lang/String;
    //   131: astore 8
    //   133: aload_0
    //   134: astore 5
    //   136: aload_0
    //   137: astore 4
    //   139: aload 7
    //   141: iload_1
    //   142: iconst_1
    //   143: iadd
    //   144: invokevirtual 497	java/lang/String:substring	(I)Ljava/lang/String;
    //   147: invokestatic 501	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   150: lstore_2
    //   151: lload_2
    //   152: lconst_1
    //   153: lcmp
    //   154: iflt -69 -> 85
    //   157: aload_0
    //   158: astore 5
    //   160: aload_0
    //   161: astore 4
    //   163: getstatic 70	com/tencent/commonsdk/soload/SoLoadCore:assestCrcConfigs	Ljava/util/HashMap;
    //   166: aload 8
    //   168: lload_2
    //   169: invokestatic 505	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   172: invokevirtual 509	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   175: pop
    //   176: goto -91 -> 85
    //   179: astore_0
    //   180: aload 5
    //   182: astore 4
    //   184: aload_0
    //   185: invokevirtual 232	java/lang/Exception:printStackTrace	()V
    //   188: aload 5
    //   190: ifnull -177 -> 13
    //   193: aload 5
    //   195: invokevirtual 126	java/io/InputStream:close	()V
    //   198: goto -185 -> 13
    //   201: astore_0
    //   202: aload_0
    //   203: invokevirtual 124	java/io/IOException:printStackTrace	()V
    //   206: goto -193 -> 13
    //   209: astore_0
    //   210: ldc 2
    //   212: monitorexit
    //   213: aload_0
    //   214: athrow
    //   215: aload_0
    //   216: ifnull -203 -> 13
    //   219: aload_0
    //   220: invokevirtual 126	java/io/InputStream:close	()V
    //   223: goto -210 -> 13
    //   226: astore_0
    //   227: aload_0
    //   228: invokevirtual 124	java/io/IOException:printStackTrace	()V
    //   231: goto -218 -> 13
    //   234: astore_0
    //   235: aload 4
    //   237: ifnull +8 -> 245
    //   240: aload 4
    //   242: invokevirtual 126	java/io/InputStream:close	()V
    //   245: aload_0
    //   246: athrow
    //   247: astore 4
    //   249: aload 4
    //   251: invokevirtual 124	java/io/IOException:printStackTrace	()V
    //   254: goto -9 -> 245
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	257	0	paramContext	Context
    //   117	27	1	i	int
    //   150	19	2	l	long
    //   6	235	4	localObject1	Object
    //   247	3	4	localIOException	IOException
    //   25	169	5	localObject2	Object
    //   21	71	6	localBufferedReader	java.io.BufferedReader
    //   18	122	7	str1	String
    //   131	36	8	str2	String
    // Exception table:
    //   from	to	target	type
    //   31	41	179	java/lang/Exception
    //   49	62	179	java/lang/Exception
    //   68	85	179	java/lang/Exception
    //   91	98	179	java/lang/Exception
    //   109	118	179	java/lang/Exception
    //   124	133	179	java/lang/Exception
    //   139	151	179	java/lang/Exception
    //   163	176	179	java/lang/Exception
    //   193	198	201	java/io/IOException
    //   3	8	209	finally
    //   193	198	209	finally
    //   202	206	209	finally
    //   219	223	209	finally
    //   227	231	209	finally
    //   240	245	209	finally
    //   245	247	209	finally
    //   249	254	209	finally
    //   219	223	226	java/io/IOException
    //   31	41	234	finally
    //   49	62	234	finally
    //   68	85	234	finally
    //   91	98	234	finally
    //   109	118	234	finally
    //   124	133	234	finally
    //   139	151	234	finally
    //   163	176	234	finally
    //   184	188	234	finally
    //   240	245	247	java/io/IOException
  }
  
  /* Error */
  public static boolean isLibExtracted(Context paramContext, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: aload_0
    //   4: aload_1
    //   5: invokestatic 513	com/tencent/commonsdk/soload/SoLoadCore:getExistFile	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;
    //   8: ifnonnull +8 -> 16
    //   11: iload 4
    //   13: istore_3
    //   14: iload_3
    //   15: ireturn
    //   16: aconst_null
    //   17: astore_1
    //   18: aconst_null
    //   19: astore 6
    //   21: aconst_null
    //   22: astore 8
    //   24: aconst_null
    //   25: astore 7
    //   27: aload_0
    //   28: aload_2
    //   29: invokestatic 513	com/tencent/commonsdk/soload/SoLoadCore:getExistFile	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;
    //   32: astore 9
    //   34: iload 4
    //   36: istore_3
    //   37: aload 9
    //   39: ifnull -25 -> 14
    //   42: aload 8
    //   44: astore 5
    //   46: aload_0
    //   47: invokevirtual 514	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   50: aload_2
    //   51: invokevirtual 473	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   54: astore_0
    //   55: aload_0
    //   56: astore 6
    //   58: aload_0
    //   59: astore_1
    //   60: aload 8
    //   62: astore 5
    //   64: new 226	java/io/FileInputStream
    //   67: dup
    //   68: aload 9
    //   70: invokespecial 227	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   73: astore_2
    //   74: aload_0
    //   75: aload_2
    //   76: invokestatic 516	com/tencent/commonsdk/soload/SoLoadCore:contentEquals	(Ljava/io/InputStream;Ljava/io/InputStream;)Z
    //   79: istore_3
    //   80: iload_3
    //   81: istore 4
    //   83: aload_0
    //   84: ifnull +7 -> 91
    //   87: aload_0
    //   88: invokevirtual 126	java/io/InputStream:close	()V
    //   91: iload 4
    //   93: istore_3
    //   94: aload_2
    //   95: ifnull -81 -> 14
    //   98: aload_2
    //   99: invokevirtual 126	java/io/InputStream:close	()V
    //   102: iload 4
    //   104: ireturn
    //   105: astore_0
    //   106: iload 4
    //   108: ireturn
    //   109: astore_2
    //   110: aload 7
    //   112: astore_0
    //   113: aload 6
    //   115: astore_1
    //   116: aload_0
    //   117: astore 5
    //   119: aload_2
    //   120: invokevirtual 124	java/io/IOException:printStackTrace	()V
    //   123: aload 6
    //   125: ifnull +8 -> 133
    //   128: aload 6
    //   130: invokevirtual 126	java/io/InputStream:close	()V
    //   133: iload 4
    //   135: istore_3
    //   136: aload_0
    //   137: ifnull -123 -> 14
    //   140: aload_0
    //   141: invokevirtual 126	java/io/InputStream:close	()V
    //   144: iconst_0
    //   145: ireturn
    //   146: astore_0
    //   147: iconst_0
    //   148: ireturn
    //   149: astore_0
    //   150: aload_1
    //   151: ifnull +7 -> 158
    //   154: aload_1
    //   155: invokevirtual 126	java/io/InputStream:close	()V
    //   158: aload 5
    //   160: ifnull +8 -> 168
    //   163: aload 5
    //   165: invokevirtual 126	java/io/InputStream:close	()V
    //   168: aload_0
    //   169: athrow
    //   170: astore_0
    //   171: goto -80 -> 91
    //   174: astore_1
    //   175: goto -42 -> 133
    //   178: astore_1
    //   179: goto -21 -> 158
    //   182: astore_1
    //   183: goto -15 -> 168
    //   186: astore 6
    //   188: aload_0
    //   189: astore_1
    //   190: aload_2
    //   191: astore 5
    //   193: aload 6
    //   195: astore_0
    //   196: goto -46 -> 150
    //   199: astore 5
    //   201: aload_2
    //   202: astore_1
    //   203: aload 5
    //   205: astore_2
    //   206: aload_0
    //   207: astore 6
    //   209: aload_1
    //   210: astore_0
    //   211: goto -98 -> 113
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	214	0	paramContext	Context
    //   0	214	1	paramString1	String
    //   0	214	2	paramString2	String
    //   13	123	3	bool1	boolean
    //   1	133	4	bool2	boolean
    //   44	148	5	localObject1	Object
    //   199	5	5	localIOException	IOException
    //   19	110	6	localContext1	Context
    //   186	8	6	localObject2	Object
    //   207	1	6	localContext2	Context
    //   25	86	7	localObject3	Object
    //   22	39	8	localObject4	Object
    //   32	37	9	localFile	File
    // Exception table:
    //   from	to	target	type
    //   98	102	105	java/io/IOException
    //   46	55	109	java/io/IOException
    //   64	74	109	java/io/IOException
    //   140	144	146	java/io/IOException
    //   46	55	149	finally
    //   64	74	149	finally
    //   119	123	149	finally
    //   87	91	170	java/io/IOException
    //   128	133	174	java/io/IOException
    //   154	158	178	java/io/IOException
    //   163	168	182	java/io/IOException
    //   74	80	186	finally
    //   74	80	199	java/io/IOException
  }
  
  private static boolean loadAndSave(File paramFile1, long paramLong, File paramFile2)
  {
    try
    {
      System.load(paramFile1.getAbsolutePath());
      bool = true;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      for (;;)
      {
        boolean bool = false;
      }
    }
    if (bool) {
      writeConfig(new ConfigStruct(paramLong, paramFile1.getAbsolutePath()), paramFile2);
    }
    return bool;
  }
  
  static int loadSo(Context paramContext, String paramString)
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
        break label68;
      }
      l1 = l2;
      i = j;
    }
    while (l1 < 0L)
    {
      i |= 0x80000;
      try
      {
        System.loadLibrary(paramString);
        i |= 0x40000;
      }
      catch (UnsatisfiedLinkError paramContext)
      {
        label66:
        Object localObject1;
        Object localObject2;
        String str2;
        break label66;
      }
      return i;
      label68:
      j = 0x200000 | 0x100000;
      localObject1 = (Long)assestCrcConfigs.get(getPlatformString() + "/" + str1);
      if ((localObject1 != null) && (((Long)localObject1).longValue() > 1L))
      {
        l1 = ((Long)localObject1).longValue();
        i = j;
      }
      else
      {
        localObject1 = (Long)assestCrcConfigs.get("armeabi/" + str1);
        i = j;
        l1 = l2;
        if (localObject1 != null)
        {
          i = j;
          l1 = l2;
          if (((Long)localObject1).longValue() > 1L)
          {
            l1 = ((Long)localObject1).longValue();
            i = j;
          }
        }
      }
    }
    localObject1 = paramContext.getFilesDir() + "/" + "soconfigs";
    new File((String)localObject1).mkdirs();
    paramString = (String)localObject1 + "/" + paramString + ".cfg";
    j = i | 0x20000;
    localObject1 = new File(paramString);
    i = j;
    if (((File)localObject1).exists())
    {
      paramString = readConfig((File)localObject1);
      j |= 0x10000;
      i = j;
      if (paramString != null)
      {
        if (paramString.mSopath.contains("/txlib/")) {}
        for (i = j | 0x4000;; i = j | 0x8000)
        {
          localObject2 = new File(paramString.mSopath);
          j = i | 0x2000;
          i = j;
          if (paramString.mCrcvalue != l1) {
            break;
          }
          i = j;
          if (!((File)localObject2).exists()) {
            break;
          }
          i = j | 0x1000;
          try
          {
            System.load(((File)localObject2).getAbsolutePath());
            return i | 0x2;
          }
          catch (UnsatisfiedLinkError paramString) {}
        }
      }
    }
    localObject2 = getAppWorkPath(paramContext) + "/txlib/";
    paramString = getAppWorkPath(paramContext) + "/lib/";
    paramString = new File(paramString + str1);
    j = i | 0x800;
    i = j;
    if (paramString.exists())
    {
      j |= 0x400;
      l2 = getCRC32Value(paramString);
      i = j;
      if (l2 == l1)
      {
        j |= 0x200;
        i = j;
        if (loadAndSave(paramString, l2, (File)localObject1)) {
          return j | 0x2;
        }
      }
    }
    str2 = getOsClassLoader();
    paramString = null;
    if (str2.equals("equalAndAbove14"))
    {
      j = i | 0x100;
      paramString = getSoOrDexByBaseDexClassLoader(paramContext, "lib/" + getPlatformString() + "/" + str1, (String)localObject2 + str1);
    }
    for (;;)
    {
      j |= 0x40;
      i = j;
      if (paramString == null) {
        break label729;
      }
      l2 = getCRC32Value(paramString);
      j |= 0x20;
      if (l2 != l1) {
        break;
      }
      j |= 0x10;
      i = j;
      if (!loadAndSave(paramString, l2, (File)localObject1)) {
        break label729;
      }
      return j | 0x2;
      j = i;
      if (str2.equals("below14"))
      {
        j = i | 0x80;
        paramString = getSoOrDexByPathClassLoader(paramContext, str1, (String)localObject2);
      }
    }
    i = j;
    if (paramString.exists())
    {
      paramString.delete();
      i = j;
    }
    label729:
    paramContext = releaseFromApk(getApkPath(paramContext), str1, (String)localObject2);
    l2 = getCRC32Value(paramContext);
    j = i | 0x8;
    i = j;
    if (l2 == l1)
    {
      j |= 0x4;
      i = j;
      if (loadAndSave(paramContext, l2, (File)localObject1)) {
        i = j | 0x2;
      }
    }
    return i;
  }
  
  /* Error */
  private static ConfigStruct readConfig(File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 8
    //   6: aconst_null
    //   7: astore 5
    //   9: aconst_null
    //   10: astore 6
    //   12: ldc_w 572
    //   15: astore 7
    //   17: new 226	java/io/FileInputStream
    //   20: dup
    //   21: aload_0
    //   22: invokespecial 227	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   25: astore_0
    //   26: new 475	java/io/BufferedReader
    //   29: dup
    //   30: new 477	java/io/InputStreamReader
    //   33: dup
    //   34: aload_0
    //   35: invokespecial 478	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   38: invokespecial 481	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   41: astore_3
    //   42: aload_3
    //   43: invokevirtual 484	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   46: astore_0
    //   47: aload_0
    //   48: ifnull +115 -> 163
    //   51: aload_0
    //   52: ldc_w 574
    //   55: invokevirtual 358	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   58: ifeq +105 -> 163
    //   61: aload_0
    //   62: aload_0
    //   63: ldc_w 576
    //   66: invokevirtual 490	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   69: iconst_1
    //   70: iadd
    //   71: invokevirtual 497	java/lang/String:substring	(I)Ljava/lang/String;
    //   74: invokestatic 501	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   77: lstore_1
    //   78: aload_3
    //   79: invokevirtual 484	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   82: astore_0
    //   83: aload 7
    //   85: astore 4
    //   87: aload_0
    //   88: ifnull +32 -> 120
    //   91: aload 7
    //   93: astore 4
    //   95: aload_0
    //   96: ldc_w 578
    //   99: invokevirtual 358	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   102: ifeq +18 -> 120
    //   105: aload_0
    //   106: aload_0
    //   107: ldc_w 576
    //   110: invokevirtual 490	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   113: iconst_1
    //   114: iadd
    //   115: invokevirtual 497	java/lang/String:substring	(I)Ljava/lang/String;
    //   118: astore 4
    //   120: aload 6
    //   122: astore_0
    //   123: lload_1
    //   124: ldc2_w 535
    //   127: lcmp
    //   128: ifeq +25 -> 153
    //   131: aload 6
    //   133: astore_0
    //   134: aload 4
    //   136: ldc_w 572
    //   139: if_acmpeq +14 -> 153
    //   142: new 404	com/tencent/commonsdk/soload/ConfigStruct
    //   145: dup
    //   146: lload_1
    //   147: aload 4
    //   149: invokespecial 528	com/tencent/commonsdk/soload/ConfigStruct:<init>	(JLjava/lang/String;)V
    //   152: astore_0
    //   153: aload_3
    //   154: ifnull +111 -> 265
    //   157: aload_3
    //   158: invokevirtual 579	java/io/BufferedReader:close	()V
    //   161: aload_0
    //   162: areturn
    //   163: aload_3
    //   164: ifnull +7 -> 171
    //   167: aload_3
    //   168: invokevirtual 579	java/io/BufferedReader:close	()V
    //   171: aconst_null
    //   172: areturn
    //   173: astore_0
    //   174: aload_0
    //   175: invokevirtual 124	java/io/IOException:printStackTrace	()V
    //   178: goto -7 -> 171
    //   181: astore_3
    //   182: aload_3
    //   183: invokevirtual 124	java/io/IOException:printStackTrace	()V
    //   186: goto -25 -> 161
    //   189: astore_0
    //   190: aload 8
    //   192: astore_3
    //   193: aload 5
    //   195: astore_0
    //   196: aload_3
    //   197: ifnull -36 -> 161
    //   200: aload_3
    //   201: invokevirtual 579	java/io/BufferedReader:close	()V
    //   204: aload 5
    //   206: astore_0
    //   207: goto -46 -> 161
    //   210: astore_0
    //   211: aload_0
    //   212: invokevirtual 124	java/io/IOException:printStackTrace	()V
    //   215: aload 5
    //   217: astore_0
    //   218: goto -57 -> 161
    //   221: astore_0
    //   222: aload 4
    //   224: astore_3
    //   225: aload_3
    //   226: ifnull +7 -> 233
    //   229: aload_3
    //   230: invokevirtual 579	java/io/BufferedReader:close	()V
    //   233: aload_0
    //   234: athrow
    //   235: astore_3
    //   236: aload_3
    //   237: invokevirtual 124	java/io/IOException:printStackTrace	()V
    //   240: goto -7 -> 233
    //   243: astore_0
    //   244: aload 4
    //   246: astore_3
    //   247: goto -22 -> 225
    //   250: astore_0
    //   251: goto -26 -> 225
    //   254: astore_0
    //   255: aload 8
    //   257: astore_3
    //   258: goto -65 -> 193
    //   261: astore_0
    //   262: goto -69 -> 193
    //   265: goto -104 -> 161
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	268	0	paramFile	File
    //   77	70	1	l	long
    //   41	127	3	localBufferedReader	java.io.BufferedReader
    //   181	2	3	localIOException1	IOException
    //   192	38	3	localObject1	Object
    //   235	2	3	localIOException2	IOException
    //   246	12	3	localObject2	Object
    //   1	244	4	localObject3	Object
    //   7	209	5	localObject4	Object
    //   10	122	6	localObject5	Object
    //   15	77	7	str	String
    //   4	252	8	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   167	171	173	java/io/IOException
    //   157	161	181	java/io/IOException
    //   17	26	189	java/lang/Exception
    //   200	204	210	java/io/IOException
    //   17	26	221	finally
    //   229	233	235	java/io/IOException
    //   26	42	243	finally
    //   42	47	250	finally
    //   51	83	250	finally
    //   95	120	250	finally
    //   142	153	250	finally
    //   26	42	254	java/lang/Exception
    //   42	47	261	java/lang/Exception
    //   51	83	261	java/lang/Exception
    //   95	120	261	java/lang/Exception
    //   142	153	261	java/lang/Exception
  }
  
  public static boolean releaseDexFromApk(Context paramContext, String paramString)
  {
    boolean bool1 = false;
    Object localObject1 = paramContext.getFilesDir();
    Object localObject2;
    DexReleasor localDexReleasor;
    String str1;
    label133:
    String str2;
    if (localObject1 != null)
    {
      localObject1 = ((File)localObject1).getAbsolutePath();
      localObject2 = localObject1;
      if (!((String)localObject1).endsWith(File.separator)) {
        localObject2 = (String)localObject1 + File.separator;
      }
      new File((String)localObject2).mkdirs();
      localDexReleasor = DexReleasor.getInstance(getApkPath(paramContext), (String)localObject2);
      str1 = null;
      localObject1 = null;
      if (!paramString.equals(DexReleasor.sExtraDexes[0])) {
        break label156;
      }
      localObject1 = DexReleasor.sExtraJarDexes[0];
      str1 = DexReleasor.sExtraDexes[0] + ".MD5";
      str2 = getCurProcessName(paramContext);
      if (!TextUtils.isEmpty(str2)) {
        break label204;
      }
    }
    label156:
    label204:
    do
    {
      boolean bool2;
      do
      {
        return bool1;
        localObject1 = "/data/data/com.tencent.mobileqqi/files";
        break;
        if (!paramString.equals(DexReleasor.sExtraDexes[1])) {
          break label133;
        }
        localObject1 = DexReleasor.sExtraJarDexes[1];
        str1 = DexReleasor.sExtraDexes[1] + ".MD5";
        break label133;
        bool2 = true;
        paramString = localDexReleasor.releaseDex(str2, paramString);
        if (!isLibExtracted(paramContext, (String)localObject1, str1)) {
          break label248;
        }
        bool1 = bool2;
      } while (paramString == null);
      bool1 = bool2;
    } while (!paramString.exists());
    paramString.delete();
    return true;
    label248:
    paramContext = new File((String)localObject2 + (String)localObject1);
    if (paramContext.exists()) {
      paramContext.delete();
    }
    if ((paramString != null) && (paramString.exists()))
    {
      paramString.renameTo(paramContext);
      return true;
    }
    return false;
  }
  
  public static File releaseFromApk(String paramString1, String paramString2, String paramString3)
  {
    Object localObject1 = paramString3;
    if (!paramString3.endsWith(File.separator)) {
      localObject1 = paramString3 + File.separator;
    }
    new File((String)localObject1).mkdirs();
    paramString3 = null;
    String str = "lib/" + getPlatformString() + "/";
    paramString2 = "lib/" + getPlatformString() + "/" + paramString2;
    MyZipEntry localMyZipEntry;
    Object localObject2;
    try
    {
      paramString1 = new MyZipFile(new File(paramString1), paramString2);
      if (paramString1 == null) {
        return null;
      }
    }
    catch (IOException paramString2)
    {
      for (;;)
      {
        paramString1 = null;
        paramString2.printStackTrace();
      }
      localMyZipEntry = paramString1.getDesEntry();
      localObject2 = localMyZipEntry.getName();
      if ((localObject2 == null) || (((String)localObject2).contains("../"))) {
        return null;
      }
      paramString2 = paramString3;
      if (localMyZipEntry == null) {
        break label329;
      }
    }
    paramString2 = paramString3;
    int i;
    if (((String)localObject2).contains(str))
    {
      paramString2 = paramString3;
      if (((String)localObject2).endsWith(".so"))
      {
        paramString2 = (String)localObject2;
        i = paramString2.lastIndexOf('/');
        paramString3 = paramString2;
        if (i != -1) {
          paramString3 = paramString2.substring(i + 1);
        }
        paramString3 = new File((String)localObject1 + paramString3);
        if (paramString3.exists()) {
          paramString3.delete();
        }
        localObject1 = new byte[4096];
      }
    }
    try
    {
      paramString1 = paramString1.getInputStream(localMyZipEntry);
      localObject2 = new FileOutputStream(paramString3);
      try
      {
        for (;;)
        {
          i = paramString1.read((byte[])localObject1);
          paramString2 = paramString3;
          if (i <= 0) {
            break;
          }
          ((FileOutputStream)localObject2).write((byte[])localObject1, 0, i);
        }
        paramString1.printStackTrace();
      }
      catch (IOException paramString1) {}
    }
    catch (IOException paramString1)
    {
      label323:
      break label323;
    }
    paramString2 = paramString3;
    label329:
    return paramString2;
  }
  
  public static String releaseSo(Context paramContext, String paramString)
  {
    Object localObject2 = null;
    String str1 = getLibActualName(paramString);
    long l2 = -1L;
    initAssestCrcConfigs(paramContext);
    long l1 = l2;
    if (assestCrcConfigs != null)
    {
      l1 = l2;
      if (!assestCrcConfigs.isEmpty()) {
        l1 = ((Long)assestCrcConfigs.get("armeabi/" + str1)).longValue();
      }
    }
    paramString = paramContext.getFilesDir() + "/" + "soconfigs";
    new File(paramString).mkdirs();
    File localFile = new File(paramString + "/" + str1 + ".cfg");
    if ((localFile.exists()) && (localFile.isFile()))
    {
      paramString = readConfig(localFile);
      if (paramString != null)
      {
        localObject1 = new File(paramString.mSopath);
        if ((paramString.mCrcvalue == l1) && (((File)localObject1).exists()))
        {
          paramContext = ((File)localObject1).getAbsolutePath();
          return paramContext;
        }
      }
      localFile.delete();
    }
    String str2 = getAppWorkPath(paramContext) + "/txlib/";
    paramString = getAppWorkPath(paramContext) + "/lib/";
    paramString = new File(paramString + str1);
    if ((paramString.exists()) && (paramString.isFile()) && (getCRC32Value(paramString) == l1))
    {
      paramContext = paramString.getAbsolutePath();
      writeConfig(new ConfigStruct(l1, paramString.getAbsolutePath()), localFile);
      return paramContext;
    }
    paramString = null;
    Object localObject1 = getOsClassLoader();
    if (((String)localObject1).equals("equalAndAbove14")) {
      paramString = getSoOrDexByBaseDexClassLoader(paramContext, "lib/" + getPlatformString() + "/" + str1, str2 + str1);
    }
    for (;;)
    {
      localObject1 = paramString;
      if (paramString == null) {
        localObject1 = releaseFromApk(getApkPath(paramContext), str1, str2);
      }
      paramContext = localObject2;
      if (localObject1 == null) {
        break;
      }
      paramContext = localObject2;
      if (!((File)localObject1).exists()) {
        break;
      }
      paramContext = ((File)localObject1).getAbsolutePath();
      writeConfig(new ConfigStruct(l1, ((File)localObject1).getAbsolutePath()), localFile);
      return paramContext;
      if (((String)localObject1).equals("below14")) {
        paramString = getSoOrDexByPathClassLoader(paramContext, str1, str2);
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
  
  /* Error */
  private static boolean writeConfig(ConfigStruct paramConfigStruct, File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 4
    //   5: iconst_0
    //   6: istore_2
    //   7: aload_1
    //   8: invokevirtual 224	java/io/File:exists	()Z
    //   11: ifeq +8 -> 19
    //   14: aload_1
    //   15: invokevirtual 416	java/io/File:delete	()Z
    //   18: pop
    //   19: aload_1
    //   20: invokevirtual 428	java/io/File:createNewFile	()Z
    //   23: pop
    //   24: new 646	java/io/BufferedWriter
    //   27: dup
    //   28: new 648	java/io/OutputStreamWriter
    //   31: dup
    //   32: new 108	java/io/FileOutputStream
    //   35: dup
    //   36: aload_1
    //   37: invokespecial 111	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   40: invokespecial 649	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;)V
    //   43: invokespecial 652	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   46: astore_1
    //   47: aload_1
    //   48: new 295	java/lang/StringBuilder
    //   51: dup
    //   52: invokespecial 296	java/lang/StringBuilder:<init>	()V
    //   55: ldc_w 654
    //   58: invokevirtual 300	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: aload_0
    //   62: getfield 408	com/tencent/commonsdk/soload/ConfigStruct:mCrcvalue	J
    //   65: invokevirtual 657	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   68: invokevirtual 308	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   71: invokevirtual 659	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   74: aload_1
    //   75: invokevirtual 662	java/io/BufferedWriter:newLine	()V
    //   78: aload_1
    //   79: new 295	java/lang/StringBuilder
    //   82: dup
    //   83: invokespecial 296	java/lang/StringBuilder:<init>	()V
    //   86: ldc_w 664
    //   89: invokevirtual 300	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: aload_0
    //   93: getfield 411	com/tencent/commonsdk/soload/ConfigStruct:mSopath	Ljava/lang/String;
    //   96: invokevirtual 300	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: invokevirtual 308	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   102: invokevirtual 659	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   105: iconst_1
    //   106: istore_2
    //   107: aload_1
    //   108: ifnull +68 -> 176
    //   111: aload_1
    //   112: invokevirtual 665	java/io/BufferedWriter:close	()V
    //   115: iload_2
    //   116: ireturn
    //   117: astore_0
    //   118: aload_0
    //   119: invokevirtual 124	java/io/IOException:printStackTrace	()V
    //   122: iconst_1
    //   123: ireturn
    //   124: astore_0
    //   125: aload 4
    //   127: astore_0
    //   128: aload_0
    //   129: ifnull -14 -> 115
    //   132: aload_0
    //   133: invokevirtual 665	java/io/BufferedWriter:close	()V
    //   136: iconst_0
    //   137: ireturn
    //   138: astore_0
    //   139: aload_0
    //   140: invokevirtual 124	java/io/IOException:printStackTrace	()V
    //   143: iconst_0
    //   144: ireturn
    //   145: astore_0
    //   146: aload_3
    //   147: astore_1
    //   148: aload_1
    //   149: ifnull +7 -> 156
    //   152: aload_1
    //   153: invokevirtual 665	java/io/BufferedWriter:close	()V
    //   156: aload_0
    //   157: athrow
    //   158: astore_1
    //   159: aload_1
    //   160: invokevirtual 124	java/io/IOException:printStackTrace	()V
    //   163: goto -7 -> 156
    //   166: astore_0
    //   167: goto -19 -> 148
    //   170: astore_0
    //   171: aload_1
    //   172: astore_0
    //   173: goto -45 -> 128
    //   176: iconst_1
    //   177: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	178	0	paramConfigStruct	ConfigStruct
    //   0	178	1	paramFile	File
    //   6	110	2	bool	boolean
    //   1	146	3	localObject1	Object
    //   3	123	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   111	115	117	java/io/IOException
    //   7	19	124	java/lang/Exception
    //   19	47	124	java/lang/Exception
    //   132	136	138	java/io/IOException
    //   7	19	145	finally
    //   19	47	145	finally
    //   152	156	158	java/io/IOException
    //   47	105	166	finally
    //   47	105	170	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.commonsdk.soload.SoLoadCore
 * JD-Core Version:    0.7.0.1
 */