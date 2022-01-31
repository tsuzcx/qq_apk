package com.tencent.commonsdk.soload;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import dalvik.system.BaseDexClassLoader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.zip.CRC32;
import java.util.zip.ZipFile;

public class SoLoadCore
{
  public static final int API_BELOW_14 = 128;
  public static final int API_EUQAL_AND_ABOVE_14 = 256;
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
  public static final int TRY_LOAD_LIBRARY_SUCCESS = 262144;
  private static HashMap<String, Long> assestCrcConfigs = null;
  
  /* Error */
  private static void copyZipEntry2File(java.util.zip.ZipEntry paramZipEntry, ZipFile paramZipFile, File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 4
    //   6: aconst_null
    //   7: astore 8
    //   9: aconst_null
    //   10: astore 7
    //   12: aload_0
    //   13: ifnull +7 -> 20
    //   16: aload_1
    //   17: ifnonnull +28 -> 45
    //   20: iconst_0
    //   21: ifeq +11 -> 32
    //   24: new 68	java/lang/NullPointerException
    //   27: dup
    //   28: invokespecial 69	java/lang/NullPointerException:<init>	()V
    //   31: athrow
    //   32: iconst_0
    //   33: ifeq +11 -> 44
    //   36: new 68	java/lang/NullPointerException
    //   39: dup
    //   40: invokespecial 69	java/lang/NullPointerException:<init>	()V
    //   43: athrow
    //   44: return
    //   45: aload 8
    //   47: astore 5
    //   49: aload_1
    //   50: aload_0
    //   51: invokevirtual 75	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   54: astore_0
    //   55: aload 8
    //   57: astore 5
    //   59: aload_0
    //   60: astore 4
    //   62: aload_0
    //   63: astore 6
    //   65: sipush 4096
    //   68: newarray byte
    //   70: astore 9
    //   72: aload 8
    //   74: astore 5
    //   76: aload_0
    //   77: astore 4
    //   79: aload_0
    //   80: astore 6
    //   82: new 77	java/io/FileOutputStream
    //   85: dup
    //   86: aload_2
    //   87: invokespecial 80	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   90: astore_1
    //   91: aload_0
    //   92: aload 9
    //   94: invokevirtual 86	java/io/InputStream:read	([B)I
    //   97: istore_3
    //   98: iload_3
    //   99: iconst_m1
    //   100: if_icmpeq +44 -> 144
    //   103: aload_1
    //   104: aload 9
    //   106: iconst_0
    //   107: iload_3
    //   108: invokevirtual 90	java/io/FileOutputStream:write	([BII)V
    //   111: goto -20 -> 91
    //   114: astore_2
    //   115: aload_1
    //   116: astore 5
    //   118: aload_0
    //   119: astore 4
    //   121: aload_2
    //   122: invokevirtual 93	java/io/IOException:printStackTrace	()V
    //   125: aload_0
    //   126: ifnull +7 -> 133
    //   129: aload_0
    //   130: invokevirtual 96	java/io/InputStream:close	()V
    //   133: aload_1
    //   134: ifnull -90 -> 44
    //   137: aload_1
    //   138: invokevirtual 97	java/io/FileOutputStream:close	()V
    //   141: return
    //   142: astore_0
    //   143: return
    //   144: aload_1
    //   145: ifnull +7 -> 152
    //   148: aload_1
    //   149: invokevirtual 97	java/io/FileOutputStream:close	()V
    //   152: aload_0
    //   153: ifnull +7 -> 160
    //   156: aload_0
    //   157: invokevirtual 96	java/io/InputStream:close	()V
    //   160: aload_1
    //   161: ifnull +7 -> 168
    //   164: aload_1
    //   165: invokevirtual 97	java/io/FileOutputStream:close	()V
    //   168: return
    //   169: astore_0
    //   170: return
    //   171: astore_0
    //   172: aload 4
    //   174: ifnull +8 -> 182
    //   177: aload 4
    //   179: invokevirtual 96	java/io/InputStream:close	()V
    //   182: aload 5
    //   184: ifnull +8 -> 192
    //   187: aload 5
    //   189: invokevirtual 97	java/io/FileOutputStream:close	()V
    //   192: aload_0
    //   193: athrow
    //   194: astore_1
    //   195: goto -3 -> 192
    //   198: astore_2
    //   199: aload_1
    //   200: astore 5
    //   202: aload_0
    //   203: astore 4
    //   205: aload_2
    //   206: astore_0
    //   207: goto -35 -> 172
    //   210: astore_2
    //   211: aload 7
    //   213: astore_1
    //   214: aload 6
    //   216: astore_0
    //   217: goto -102 -> 115
    //   220: astore_0
    //   221: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	222	0	paramZipEntry	java.util.zip.ZipEntry
    //   0	222	1	paramZipFile	ZipFile
    //   0	222	2	paramFile	File
    //   97	11	3	i	int
    //   4	200	4	localZipEntry1	java.util.zip.ZipEntry
    //   47	154	5	localObject1	Object
    //   1	214	6	localZipEntry2	java.util.zip.ZipEntry
    //   10	202	7	localObject2	Object
    //   7	66	8	localObject3	Object
    //   70	35	9	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   91	98	114	java/io/IOException
    //   103	111	114	java/io/IOException
    //   148	152	114	java/io/IOException
    //   129	133	142	java/io/IOException
    //   137	141	142	java/io/IOException
    //   156	160	169	java/io/IOException
    //   164	168	169	java/io/IOException
    //   49	55	171	finally
    //   65	72	171	finally
    //   82	91	171	finally
    //   121	125	171	finally
    //   177	182	194	java/io/IOException
    //   187	192	194	java/io/IOException
    //   91	98	198	finally
    //   103	111	198	finally
    //   148	152	198	finally
    //   49	55	210	java/io/IOException
    //   65	72	210	java/io/IOException
    //   82	91	210	java/io/IOException
    //   24	32	220	java/io/IOException
    //   36	44	220	java/io/IOException
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
    //   0: ldc2_w 184
    //   3: lstore_3
    //   4: lload_3
    //   5: lstore_1
    //   6: aload_0
    //   7: ifnull +12 -> 19
    //   10: aload_0
    //   11: invokevirtual 189	java/io/File:exists	()Z
    //   14: ifne +7 -> 21
    //   17: lload_3
    //   18: lstore_1
    //   19: lload_1
    //   20: lreturn
    //   21: aconst_null
    //   22: astore 5
    //   24: aconst_null
    //   25: astore 6
    //   27: new 191	java/io/FileInputStream
    //   30: dup
    //   31: aload_0
    //   32: invokespecial 192	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   35: astore_0
    //   36: aload_0
    //   37: invokestatic 195	com/tencent/commonsdk/soload/SoLoadCore:getCRC32Value	(Ljava/io/InputStream;)J
    //   40: lstore_1
    //   41: lload_1
    //   42: lstore_3
    //   43: lload_3
    //   44: lstore_1
    //   45: aload_0
    //   46: ifnull -27 -> 19
    //   49: aload_0
    //   50: invokevirtual 196	java/io/FileInputStream:close	()V
    //   53: lload_3
    //   54: lreturn
    //   55: astore_0
    //   56: aload_0
    //   57: invokevirtual 93	java/io/IOException:printStackTrace	()V
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
    //   76: invokevirtual 197	java/lang/Exception:printStackTrace	()V
    //   79: lload_3
    //   80: lstore_1
    //   81: aload_0
    //   82: ifnull -63 -> 19
    //   85: aload_0
    //   86: invokevirtual 196	java/io/FileInputStream:close	()V
    //   89: ldc2_w 184
    //   92: lreturn
    //   93: astore_0
    //   94: aload_0
    //   95: invokevirtual 93	java/io/IOException:printStackTrace	()V
    //   98: ldc2_w 184
    //   101: lreturn
    //   102: astore_0
    //   103: aload 5
    //   105: ifnull +8 -> 113
    //   108: aload 5
    //   110: invokevirtual 196	java/io/FileInputStream:close	()V
    //   113: aload_0
    //   114: athrow
    //   115: astore 5
    //   117: aload 5
    //   119: invokevirtual 93	java/io/IOException:printStackTrace	()V
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
  
  private static String getLibActualName(String paramString)
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
    //   3: getstatic 247	android/os/Build:CPU_ABI	Ljava/lang/String;
    //   6: astore_0
    //   7: aload_0
    //   8: ifnull +20 -> 28
    //   11: aload_0
    //   12: ldc 249
    //   14: invokevirtual 255	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   17: ifeq +11 -> 28
    //   20: ldc 249
    //   22: astore_0
    //   23: ldc 2
    //   25: monitorexit
    //   26: aload_0
    //   27: areturn
    //   28: aload_0
    //   29: ifnull +20 -> 49
    //   32: aload_0
    //   33: ldc_w 257
    //   36: invokevirtual 255	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   39: ifeq +10 -> 49
    //   42: ldc_w 259
    //   45: astore_0
    //   46: goto -23 -> 23
    //   49: ldc_w 261
    //   52: astore_0
    //   53: goto -30 -> 23
    //   56: astore_0
    //   57: ldc 2
    //   59: monitorexit
    //   60: aload_0
    //   61: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   6	47	0	str	String
    //   56	5	0	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	7	56	finally
    //   11	20	56	finally
    //   32	42	56	finally
  }
  
  private static File getSoByBaseDexClassLoader(Context paramContext, String paramString1, String paramString2)
  {
    String str = paramString2;
    if (!paramString2.endsWith("/")) {
      str = paramString2 + "/";
    }
    new File(str).mkdirs();
    paramString2 = new File(str + paramString1);
    if (paramString2.exists()) {
      paramString2.delete();
    }
    str = "lib/" + getPlatformString() + "/" + paramString1;
    paramString1 = paramContext.getClassLoader();
    paramContext = (BaseDexClassLoader)paramContext.getClassLoader();
    paramString1 = paramString1.getClass().getSuperclass();
    try
    {
      paramString2.createNewFile();
      Object localObject = paramString1.getDeclaredField("pathList");
      ((Field)localObject).setAccessible(true);
      paramString1 = ((Field)localObject).get(paramContext);
      paramContext = ((Field)localObject).get(paramContext).getClass().getDeclaredField("dexElements");
      paramContext.setAccessible(true);
      localObject = paramContext.get(paramString1);
      int j;
      int i;
      if (localObject.getClass().isArray())
      {
        j = Array.getLength(localObject);
        if (j > 0)
        {
          paramString1 = null;
          paramContext = null;
          i = 0;
        }
      }
      for (;;)
      {
        if (i < j)
        {
          paramContext = Array.get(localObject, i);
          paramString1 = paramContext.getClass().getDeclaredField("zipFile");
          paramString1.setAccessible(true);
          paramContext = (ZipFile)paramString1.get(paramContext);
          paramString1 = paramContext.getEntry(str);
          if (paramString1 == null) {}
        }
        else
        {
          copyZipEntry2File(paramString1, paramContext, paramString2);
          return paramString2;
        }
        i += 1;
      }
      return null;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public static File getSoByPathClassLoader(Context paramContext, String paramString1, String paramString2)
  {
    localFile = new File(paramString2 + paramString1);
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
          copyZipEntry2File(paramContext, paramString2, localFile);
          return localFile;
        }
        i += 1;
      }
      return localFile;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
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
    //   3: getstatic 58	com/tencent/commonsdk/soload/SoLoadCore:assestCrcConfigs	Ljava/util/HashMap;
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
    //   31: new 326	java/util/HashMap
    //   34: dup
    //   35: invokespecial 327	java/util/HashMap:<init>	()V
    //   38: putstatic 58	com/tencent/commonsdk/soload/SoLoadCore:assestCrcConfigs	Ljava/util/HashMap;
    //   41: aload 6
    //   43: astore 5
    //   45: aload 7
    //   47: astore 4
    //   49: aload_0
    //   50: invokevirtual 331	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   53: invokevirtual 337	android/content/res/Resources:getAssets	()Landroid/content/res/AssetManager;
    //   56: ldc 13
    //   58: invokevirtual 343	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   61: astore_0
    //   62: aload_0
    //   63: astore 5
    //   65: aload_0
    //   66: astore 4
    //   68: new 345	java/io/BufferedReader
    //   71: dup
    //   72: new 347	java/io/InputStreamReader
    //   75: dup
    //   76: aload_0
    //   77: invokespecial 350	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   80: invokespecial 353	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   83: astore 6
    //   85: aload_0
    //   86: astore 5
    //   88: aload_0
    //   89: astore 4
    //   91: aload 6
    //   93: invokevirtual 356	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   96: astore 7
    //   98: aload 7
    //   100: ifnull +115 -> 215
    //   103: aload_0
    //   104: astore 5
    //   106: aload_0
    //   107: astore 4
    //   109: aload 7
    //   111: ldc_w 358
    //   114: invokevirtual 362	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   117: istore_1
    //   118: aload_0
    //   119: astore 5
    //   121: aload_0
    //   122: astore 4
    //   124: aload 7
    //   126: iconst_0
    //   127: iload_1
    //   128: invokevirtual 366	java/lang/String:substring	(II)Ljava/lang/String;
    //   131: astore 8
    //   133: aload_0
    //   134: astore 5
    //   136: aload_0
    //   137: astore 4
    //   139: aload 7
    //   141: iload_1
    //   142: iconst_1
    //   143: iadd
    //   144: invokevirtual 369	java/lang/String:substring	(I)Ljava/lang/String;
    //   147: invokestatic 375	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   150: lstore_2
    //   151: lload_2
    //   152: lconst_1
    //   153: lcmp
    //   154: iflt -69 -> 85
    //   157: aload_0
    //   158: astore 5
    //   160: aload_0
    //   161: astore 4
    //   163: getstatic 58	com/tencent/commonsdk/soload/SoLoadCore:assestCrcConfigs	Ljava/util/HashMap;
    //   166: aload 8
    //   168: lload_2
    //   169: invokestatic 379	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   172: invokevirtual 383	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   175: pop
    //   176: goto -91 -> 85
    //   179: astore_0
    //   180: aload 5
    //   182: astore 4
    //   184: aload_0
    //   185: invokevirtual 197	java/lang/Exception:printStackTrace	()V
    //   188: aload 5
    //   190: ifnull -177 -> 13
    //   193: aload 5
    //   195: invokevirtual 96	java/io/InputStream:close	()V
    //   198: goto -185 -> 13
    //   201: astore_0
    //   202: aload_0
    //   203: invokevirtual 93	java/io/IOException:printStackTrace	()V
    //   206: goto -193 -> 13
    //   209: astore_0
    //   210: ldc 2
    //   212: monitorexit
    //   213: aload_0
    //   214: athrow
    //   215: aload_0
    //   216: ifnull -203 -> 13
    //   219: aload_0
    //   220: invokevirtual 96	java/io/InputStream:close	()V
    //   223: goto -210 -> 13
    //   226: astore_0
    //   227: aload_0
    //   228: invokevirtual 93	java/io/IOException:printStackTrace	()V
    //   231: goto -218 -> 13
    //   234: astore_0
    //   235: aload 4
    //   237: ifnull +8 -> 245
    //   240: aload 4
    //   242: invokevirtual 96	java/io/InputStream:close	()V
    //   245: aload_0
    //   246: athrow
    //   247: astore 4
    //   249: aload 4
    //   251: invokevirtual 93	java/io/IOException:printStackTrace	()V
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
        if (paramString.mSopath.contains("txlib/")) {}
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
    localObject2 = paramContext.getFilesDir().getParent() + "/txlib/";
    paramString = paramContext.getFilesDir().getParent() + "/lib/";
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
      paramString = getSoByBaseDexClassLoader(paramContext, str1, (String)localObject2);
    }
    for (;;)
    {
      j |= 0x40;
      i = j;
      if (paramString == null) {
        break label687;
      }
      l2 = getCRC32Value(paramString);
      j |= 0x20;
      if (l2 != l1) {
        break;
      }
      j |= 0x10;
      i = j;
      if (!loadAndSave(paramString, l2, (File)localObject1)) {
        break label687;
      }
      return j | 0x2;
      j = i;
      if (str2.equals("below14"))
      {
        j = i | 0x80;
        paramString = getSoByPathClassLoader(paramContext, str1, (String)localObject2);
      }
    }
    i = j;
    if (paramString.exists())
    {
      paramString.delete();
      i = j;
    }
    label687:
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
    //   12: ldc_w 467
    //   15: astore 7
    //   17: new 191	java/io/FileInputStream
    //   20: dup
    //   21: aload_0
    //   22: invokespecial 192	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   25: astore_0
    //   26: new 345	java/io/BufferedReader
    //   29: dup
    //   30: new 347	java/io/InputStreamReader
    //   33: dup
    //   34: aload_0
    //   35: invokespecial 350	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   38: invokespecial 353	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   41: astore_3
    //   42: aload_3
    //   43: invokevirtual 356	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   46: astore_0
    //   47: aload_0
    //   48: ifnull +115 -> 163
    //   51: aload_0
    //   52: ldc_w 469
    //   55: invokevirtual 255	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   58: ifeq +105 -> 163
    //   61: aload_0
    //   62: aload_0
    //   63: ldc_w 471
    //   66: invokevirtual 362	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   69: iconst_1
    //   70: iadd
    //   71: invokevirtual 369	java/lang/String:substring	(I)Ljava/lang/String;
    //   74: invokestatic 375	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   77: lstore_1
    //   78: aload_3
    //   79: invokevirtual 356	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   82: astore_0
    //   83: aload 7
    //   85: astore 4
    //   87: aload_0
    //   88: ifnull +32 -> 120
    //   91: aload 7
    //   93: astore 4
    //   95: aload_0
    //   96: ldc_w 473
    //   99: invokevirtual 255	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   102: ifeq +18 -> 120
    //   105: aload_0
    //   106: aload_0
    //   107: ldc_w 471
    //   110: invokevirtual 362	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   113: iconst_1
    //   114: iadd
    //   115: invokevirtual 369	java/lang/String:substring	(I)Ljava/lang/String;
    //   118: astore 4
    //   120: aload 6
    //   122: astore_0
    //   123: lload_1
    //   124: ldc2_w 406
    //   127: lcmp
    //   128: ifeq +25 -> 153
    //   131: aload 6
    //   133: astore_0
    //   134: aload 4
    //   136: ldc_w 467
    //   139: if_acmpeq +14 -> 153
    //   142: new 394	com/tencent/commonsdk/soload/ConfigStruct
    //   145: dup
    //   146: lload_1
    //   147: aload 4
    //   149: invokespecial 397	com/tencent/commonsdk/soload/ConfigStruct:<init>	(JLjava/lang/String;)V
    //   152: astore_0
    //   153: aload_3
    //   154: ifnull +111 -> 265
    //   157: aload_3
    //   158: invokevirtual 474	java/io/BufferedReader:close	()V
    //   161: aload_0
    //   162: areturn
    //   163: aload_3
    //   164: ifnull +7 -> 171
    //   167: aload_3
    //   168: invokevirtual 474	java/io/BufferedReader:close	()V
    //   171: aconst_null
    //   172: areturn
    //   173: astore_0
    //   174: aload_0
    //   175: invokevirtual 93	java/io/IOException:printStackTrace	()V
    //   178: goto -7 -> 171
    //   181: astore_3
    //   182: aload_3
    //   183: invokevirtual 93	java/io/IOException:printStackTrace	()V
    //   186: goto -25 -> 161
    //   189: astore_0
    //   190: aload 8
    //   192: astore_3
    //   193: aload 5
    //   195: astore_0
    //   196: aload_3
    //   197: ifnull -36 -> 161
    //   200: aload_3
    //   201: invokevirtual 474	java/io/BufferedReader:close	()V
    //   204: aload 5
    //   206: astore_0
    //   207: goto -46 -> 161
    //   210: astore_0
    //   211: aload_0
    //   212: invokevirtual 93	java/io/IOException:printStackTrace	()V
    //   215: aload 5
    //   217: astore_0
    //   218: goto -57 -> 161
    //   221: astore_0
    //   222: aload 4
    //   224: astore_3
    //   225: aload_3
    //   226: ifnull +7 -> 233
    //   229: aload_3
    //   230: invokevirtual 474	java/io/BufferedReader:close	()V
    //   233: aload_0
    //   234: athrow
    //   235: astore_3
    //   236: aload_3
    //   237: invokevirtual 93	java/io/IOException:printStackTrace	()V
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
  
  public static File releaseFromApk(String paramString1, String paramString2, String paramString3)
  {
    Object localObject1 = paramString3;
    if (!paramString3.endsWith(File.separator)) {
      localObject1 = paramString3 + File.separator;
    }
    new File((String)localObject1).mkdirs();
    paramString3 = null;
    Object localObject2 = "lib/" + getPlatformString() + "/";
    paramString2 = "lib/" + getPlatformString() + "/" + paramString2;
    MyZipEntry localMyZipEntry;
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
      paramString2 = paramString3;
      if (localMyZipEntry == null) {
        break label312;
      }
    }
    paramString2 = paramString3;
    int i;
    if (localMyZipEntry.getName().contains((CharSequence)localObject2))
    {
      paramString2 = paramString3;
      if (localMyZipEntry.getName().endsWith(".so"))
      {
        paramString3 = localMyZipEntry.getName();
        i = paramString3.lastIndexOf('/');
        paramString2 = paramString3;
        if (i != -1) {
          paramString2 = paramString3.substring(i + 1);
        }
        paramString3 = new File((String)localObject1 + paramString2);
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
      label306:
      break label306;
    }
    paramString2 = paramString3;
    label312:
    return paramString2;
  }
  
  public static File releaseSoAnyway(Context paramContext, String paramString1, String paramString2)
  {
    if (hasBaseDexClassloader()) {}
    for (File localFile1 = getSoByBaseDexClassLoader(paramContext, paramString1, paramString2);; localFile1 = getSoByPathClassLoader(paramContext, paramString1, paramString2))
    {
      File localFile2 = localFile1;
      if (localFile1 == null) {
        localFile2 = releaseFromApk(getApkPath(paramContext), paramString1, paramString2);
      }
      return localFile2;
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
    //   8: invokevirtual 189	java/io/File:exists	()Z
    //   11: ifeq +8 -> 19
    //   14: aload_1
    //   15: invokevirtual 278	java/io/File:delete	()Z
    //   18: pop
    //   19: aload_1
    //   20: invokevirtual 294	java/io/File:createNewFile	()Z
    //   23: pop
    //   24: new 503	java/io/BufferedWriter
    //   27: dup
    //   28: new 505	java/io/OutputStreamWriter
    //   31: dup
    //   32: new 77	java/io/FileOutputStream
    //   35: dup
    //   36: aload_1
    //   37: invokespecial 80	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   40: invokespecial 508	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;)V
    //   43: invokespecial 511	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   46: astore_1
    //   47: aload_1
    //   48: new 212	java/lang/StringBuilder
    //   51: dup
    //   52: invokespecial 213	java/lang/StringBuilder:<init>	()V
    //   55: ldc_w 513
    //   58: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: aload_0
    //   62: getfield 441	com/tencent/commonsdk/soload/ConfigStruct:mCrcvalue	J
    //   65: invokevirtual 516	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   68: invokevirtual 224	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   71: invokevirtual 518	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   74: aload_1
    //   75: invokevirtual 521	java/io/BufferedWriter:newLine	()V
    //   78: aload_1
    //   79: new 212	java/lang/StringBuilder
    //   82: dup
    //   83: invokespecial 213	java/lang/StringBuilder:<init>	()V
    //   86: ldc_w 523
    //   89: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: aload_0
    //   93: getfield 435	com/tencent/commonsdk/soload/ConfigStruct:mSopath	Ljava/lang/String;
    //   96: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: invokevirtual 224	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   102: invokevirtual 518	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   105: iconst_1
    //   106: istore_2
    //   107: aload_1
    //   108: ifnull +68 -> 176
    //   111: aload_1
    //   112: invokevirtual 524	java/io/BufferedWriter:close	()V
    //   115: iload_2
    //   116: ireturn
    //   117: astore_0
    //   118: aload_0
    //   119: invokevirtual 93	java/io/IOException:printStackTrace	()V
    //   122: iconst_1
    //   123: ireturn
    //   124: astore_0
    //   125: aload 4
    //   127: astore_0
    //   128: aload_0
    //   129: ifnull -14 -> 115
    //   132: aload_0
    //   133: invokevirtual 524	java/io/BufferedWriter:close	()V
    //   136: iconst_0
    //   137: ireturn
    //   138: astore_0
    //   139: aload_0
    //   140: invokevirtual 93	java/io/IOException:printStackTrace	()V
    //   143: iconst_0
    //   144: ireturn
    //   145: astore_0
    //   146: aload_3
    //   147: astore_1
    //   148: aload_1
    //   149: ifnull +7 -> 156
    //   152: aload_1
    //   153: invokevirtual 524	java/io/BufferedWriter:close	()V
    //   156: aload_0
    //   157: athrow
    //   158: astore_1
    //   159: aload_1
    //   160: invokevirtual 93	java/io/IOException:printStackTrace	()V
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.commonsdk.soload.SoLoadCore
 * JD-Core Version:    0.7.0.1
 */