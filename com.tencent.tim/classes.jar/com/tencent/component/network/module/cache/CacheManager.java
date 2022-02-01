package com.tencent.component.network.module.cache;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import com.tencent.component.network.downloader.common.Utils;
import com.tencent.component.network.module.base.QDLog;
import com.tencent.component.network.module.cache.file.FileCacheService;
import com.tencent.component.network.module.cache.file.FileStorageHandler;
import com.tencent.component.network.utils.AssertUtil;
import com.tencent.component.network.utils.FileUtils;
import java.io.File;
import java.util.HashMap;

public class CacheManager
{
  public static final int AUDIO_EXTERNAL_CAPACITY = 100;
  public static final String AUDIO_FILE_CACHE_NAME = "audio";
  public static final int AUDIO_INTERNAL_CAPACITY = 100;
  private static final String BLOB_DIR = "blob";
  private static final boolean FILE_CLEAR_PERSIST = false;
  private static final int FILE_VERSION = 1;
  public static final int IMAGE_EXTERNAL_CAPACITY = 3000;
  public static final String IMAGE_FILE_CACHE_NAME = "image";
  public static final int IMAGE_INTERNAL_CAPACITY = 800;
  private static final String PREFERENCE_FILE = "_cache_file";
  private static final String PREFERENCE_FILE_VERSION = "_version";
  public static final int TMP_EXTERNAL_CAPACITY = 500;
  public static final String TMP_FILE_CACHE_NAME = "tmp";
  public static final int TMP_INTERNAL_CAPACITY = 200;
  private static final HashMap<String, FileCacheService> sFileCacheService = new HashMap();
  private static final FileStorageHandler sStorageHandler = new FileStorageHandler(new CacheManager.1());
  
  public static void clear(Context paramContext)
  {
    try
    {
      clear(paramContext, 0L);
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public static void clear(Context paramContext, long paramLong)
  {
    try
    {
      clearFiles(paramContext);
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  private static void clearFiles(Context paramContext)
  {
    String str1 = getExternalCacheDir(paramContext, false);
    if (str1 != null) {
      FileUtils.delete(str1, true);
    }
    String str2 = getExternalCacheDirExt(paramContext, false);
    if (str1 != null) {
      FileUtils.delete(str2, true);
    }
    paramContext = getInternalCacheDir(paramContext, false);
    if (paramContext != null) {
      FileUtils.delete(paramContext, true);
    }
  }
  
  public static String getExternalCacheDir(Context paramContext, String paramString, boolean paramBoolean)
  {
    String str = getExternalCacheDir(paramContext, paramBoolean);
    if (str == null) {
      paramContext = null;
    }
    do
    {
      return paramContext;
      paramContext = str;
    } while (TextUtils.isEmpty(paramString));
    paramContext = new File(str + File.separator + paramString);
    try
    {
      if (paramContext.isFile()) {
        FileUtils.delete(paramContext);
      }
      if (!paramContext.exists()) {
        paramContext.mkdirs();
      }
      return paramContext.getAbsolutePath();
    }
    finally {}
  }
  
  private static String getExternalCacheDir(Context paramContext, boolean paramBoolean)
  {
    if (!isExternalAvailable()) {}
    for (;;)
    {
      return null;
      if (!paramBoolean) {}
      for (paramContext = InnerEnvironment.getExternalCacheDir(paramContext, false); paramContext != null; paramContext = InnerEnvironment.getExternalFilesDir(paramContext, "cache", false)) {
        return paramContext.getAbsolutePath();
      }
    }
  }
  
  public static String getExternalCacheDirExt(Context paramContext, String paramString, boolean paramBoolean)
  {
    String str = getExternalCacheDirExt(paramContext, paramBoolean);
    if (str == null) {
      paramContext = null;
    }
    do
    {
      return paramContext;
      paramContext = str;
    } while (TextUtils.isEmpty(paramString));
    paramContext = new File(str + File.separator + paramString);
    try
    {
      if (paramContext.isFile()) {
        FileUtils.delete(paramContext);
      }
      if (!paramContext.exists()) {
        paramContext.mkdirs();
      }
      return paramContext.getAbsolutePath();
    }
    finally {}
  }
  
  private static String getExternalCacheDirExt(Context paramContext, boolean paramBoolean)
  {
    if (!isExternalAvailable()) {}
    for (;;)
    {
      return null;
      if (!paramBoolean) {}
      for (paramContext = InnerEnvironment.getExternalCacheDir(paramContext, true); paramContext != null; paramContext = InnerEnvironment.getExternalFilesDir(paramContext, "cache", true)) {
        return paramContext.getAbsolutePath();
      }
    }
  }
  
  public static FileCacheService getFileCacheService(Context paramContext, String paramString, int paramInt1, int paramInt2)
  {
    return getFileCacheService(paramContext, paramString, paramInt1, paramInt2, false);
  }
  
  public static FileCacheService getFileCacheService(Context paramContext, String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (!TextUtils.isEmpty(paramString)) {}
    for (boolean bool = true;; bool = false)
    {
      AssertUtil.assertTrue(bool);
      synchronized (sFileCacheService)
      {
        FileCacheService localFileCacheService2 = (FileCacheService)sFileCacheService.get(paramString);
        FileCacheService localFileCacheService1 = localFileCacheService2;
        if (localFileCacheService2 == null)
        {
          localFileCacheService1 = new FileCacheService(paramContext, paramString, paramInt1, paramInt2, paramBoolean);
          localFileCacheService1.setStorageHandler(sStorageHandler);
          sFileCacheService.put(paramString, localFileCacheService1);
        }
        return localFileCacheService1;
      }
    }
  }
  
  public static String getInternalCacheDir(Context paramContext, String paramString, boolean paramBoolean)
  {
    paramContext = getInternalCacheDir(paramContext, paramBoolean);
    if (TextUtils.isEmpty(paramString)) {
      return paramContext;
    }
    paramContext = new File(paramContext + File.separator + paramString);
    if (paramContext.isFile()) {
      FileUtils.delete(paramContext);
    }
    if (!paramContext.exists()) {
      paramContext.mkdirs();
    }
    return paramContext.getAbsolutePath();
  }
  
  public static String getInternalCacheDir(Context paramContext, boolean paramBoolean)
  {
    if (!paramBoolean) {
      return paramContext.getCacheDir().getAbsolutePath();
    }
    return paramContext.getFilesDir().getAbsolutePath() + File.separator + "cache";
  }
  
  public static FileCacheService getTmpFileCacheService(Context paramContext)
  {
    String str2 = "tmp";
    String str3 = Utils.getCurrentProcessName(paramContext);
    String str1 = str2;
    if (str3 != null)
    {
      str1 = str2;
      if (str3.contains(":"))
      {
        int i = str3.lastIndexOf(":");
        str1 = str2;
        if (i > 0) {
          str1 = "tmp" + "_" + str3.substring(i + 1);
        }
      }
    }
    return getFileCacheService(paramContext, str1, 500, 200);
  }
  
  public static FileCacheService getTmpFileCacheService(Context paramContext, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return getFileCacheService(paramContext, paramString, 500, 200);
  }
  
  public static boolean isExternalAvailable()
  {
    try
    {
      boolean bool = "mounted".equals(Environment.getExternalStorageState());
      return bool;
    }
    catch (Exception localException)
    {
      QDLog.e("CacheManager", "Downloader ", localException);
    }
    return false;
  }
  
  static class InnerEnvironment
  {
    private static final String EXTEND_SUFFIX = "-ext";
    private static final File EXTERNAL_STORAGE_ANDROID_DATA_DIRECTORY = new File(new File(Environment.getExternalStorageDirectory(), "Android"), "data");
    private static final String TAG = "InnerEnvironment";
    
    /* Error */
    public static File getExternalCacheDir(Context paramContext, boolean paramBoolean)
    {
      // Byte code:
      //   0: iload_1
      //   1: ifne +16 -> 17
      //   4: invokestatic 48	com/tencent/component/network/utils/PlatformUtil:version	()I
      //   7: bipush 8
      //   9: if_icmplt +8 -> 17
      //   12: aload_0
      //   13: invokevirtual 52	android/content/Context:getExternalCacheDir	()Ljava/io/File;
      //   16: areturn
      //   17: ldc 2
      //   19: monitorenter
      //   20: new 54	java/lang/StringBuilder
      //   23: dup
      //   24: invokespecial 55	java/lang/StringBuilder:<init>	()V
      //   27: aload_0
      //   28: invokevirtual 59	android/content/Context:getPackageName	()Ljava/lang/String;
      //   31: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   34: astore_2
      //   35: iload_1
      //   36: ifeq +68 -> 104
      //   39: ldc 11
      //   41: astore_0
      //   42: aload_2
      //   43: aload_0
      //   44: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   47: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   50: invokestatic 70	com/tencent/component/network/module/cache/CacheManager$InnerEnvironment:getExternalStorageAppCacheDirectory	(Ljava/lang/String;)Ljava/io/File;
      //   53: astore_0
      //   54: aload_0
      //   55: invokevirtual 74	java/io/File:exists	()Z
      //   58: istore_1
      //   59: iload_1
      //   60: ifne +62 -> 122
      //   63: new 19	java/io/File
      //   66: dup
      //   67: invokestatic 77	com/tencent/component/network/module/cache/CacheManager$InnerEnvironment:getExternalStorageAndroidDataDir	()Ljava/io/File;
      //   70: ldc 79
      //   72: invokespecial 31	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
      //   75: invokevirtual 82	java/io/File:createNewFile	()Z
      //   78: pop
      //   79: aload_0
      //   80: invokevirtual 85	java/io/File:mkdirs	()Z
      //   83: ifne +39 -> 122
      //   86: ldc 15
      //   88: ldc 87
      //   90: invokestatic 93	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;)V
      //   93: ldc 2
      //   95: monitorexit
      //   96: aconst_null
      //   97: areturn
      //   98: astore_0
      //   99: ldc 2
      //   101: monitorexit
      //   102: aload_0
      //   103: athrow
      //   104: ldc 95
      //   106: astore_0
      //   107: goto -65 -> 42
      //   110: astore_2
      //   111: ldc 15
      //   113: ldc 95
      //   115: aload_2
      //   116: invokestatic 99	com/tencent/component/network/module/base/QDLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
      //   119: goto -40 -> 79
      //   122: ldc 2
      //   124: monitorexit
      //   125: aload_0
      //   126: areturn
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	127	0	paramContext	Context
      //   0	127	1	paramBoolean	boolean
      //   34	9	2	localStringBuilder	java.lang.StringBuilder
      //   110	6	2	localIOException	java.io.IOException
      // Exception table:
      //   from	to	target	type
      //   20	35	98	finally
      //   42	59	98	finally
      //   63	79	98	finally
      //   79	96	98	finally
      //   99	102	98	finally
      //   111	119	98	finally
      //   122	125	98	finally
      //   63	79	110	java/io/IOException
    }
    
    /* Error */
    public static File getExternalFilesDir(Context paramContext, String paramString, boolean paramBoolean)
    {
      // Byte code:
      //   0: iload_2
      //   1: ifne +17 -> 18
      //   4: invokestatic 48	com/tencent/component/network/utils/PlatformUtil:version	()I
      //   7: bipush 8
      //   9: if_icmplt +9 -> 18
      //   12: aload_0
      //   13: aload_1
      //   14: invokevirtual 103	android/content/Context:getExternalFilesDir	(Ljava/lang/String;)Ljava/io/File;
      //   17: areturn
      //   18: ldc 2
      //   20: monitorenter
      //   21: new 54	java/lang/StringBuilder
      //   24: dup
      //   25: invokespecial 55	java/lang/StringBuilder:<init>	()V
      //   28: aload_0
      //   29: invokevirtual 59	android/content/Context:getPackageName	()Ljava/lang/String;
      //   32: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   35: astore_3
      //   36: iload_2
      //   37: ifeq +69 -> 106
      //   40: ldc 11
      //   42: astore_0
      //   43: aload_3
      //   44: aload_0
      //   45: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   48: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   51: invokestatic 106	com/tencent/component/network/module/cache/CacheManager$InnerEnvironment:getExternalStorageAppFilesDirectory	(Ljava/lang/String;)Ljava/io/File;
      //   54: astore_0
      //   55: aload_0
      //   56: invokevirtual 74	java/io/File:exists	()Z
      //   59: istore_2
      //   60: iload_2
      //   61: ifne +51 -> 112
      //   64: new 19	java/io/File
      //   67: dup
      //   68: invokestatic 77	com/tencent/component/network/module/cache/CacheManager$InnerEnvironment:getExternalStorageAndroidDataDir	()Ljava/io/File;
      //   71: ldc 79
      //   73: invokespecial 31	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
      //   76: invokevirtual 82	java/io/File:createNewFile	()Z
      //   79: pop
      //   80: aload_0
      //   81: invokevirtual 85	java/io/File:mkdirs	()Z
      //   84: ifne +28 -> 112
      //   87: ldc 15
      //   89: ldc 108
      //   91: invokestatic 113	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
      //   94: pop
      //   95: ldc 2
      //   97: monitorexit
      //   98: aconst_null
      //   99: areturn
      //   100: astore_0
      //   101: ldc 2
      //   103: monitorexit
      //   104: aload_0
      //   105: athrow
      //   106: ldc 95
      //   108: astore_0
      //   109: goto -66 -> 43
      //   112: aload_1
      //   113: ifnonnull +8 -> 121
      //   116: ldc 2
      //   118: monitorexit
      //   119: aload_0
      //   120: areturn
      //   121: new 19	java/io/File
      //   124: dup
      //   125: aload_0
      //   126: aload_1
      //   127: invokespecial 31	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
      //   130: astore_0
      //   131: aload_0
      //   132: invokevirtual 74	java/io/File:exists	()Z
      //   135: ifne +40 -> 175
      //   138: aload_0
      //   139: invokevirtual 85	java/io/File:mkdirs	()Z
      //   142: ifne +33 -> 175
      //   145: ldc 15
      //   147: new 54	java/lang/StringBuilder
      //   150: dup
      //   151: invokespecial 55	java/lang/StringBuilder:<init>	()V
      //   154: ldc 115
      //   156: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   159: aload_0
      //   160: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   163: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   166: invokestatic 113	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
      //   169: pop
      //   170: ldc 2
      //   172: monitorexit
      //   173: aconst_null
      //   174: areturn
      //   175: ldc 2
      //   177: monitorexit
      //   178: aload_0
      //   179: areturn
      //   180: astore_3
      //   181: goto -101 -> 80
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	184	0	paramContext	Context
      //   0	184	1	paramString	String
      //   0	184	2	paramBoolean	boolean
      //   35	9	3	localStringBuilder	java.lang.StringBuilder
      //   180	1	3	localIOException	java.io.IOException
      // Exception table:
      //   from	to	target	type
      //   21	36	100	finally
      //   43	60	100	finally
      //   64	80	100	finally
      //   80	98	100	finally
      //   101	104	100	finally
      //   116	119	100	finally
      //   121	173	100	finally
      //   175	178	100	finally
      //   64	80	180	java/io/IOException
    }
    
    public static File getExternalStorageAndroidDataDir()
    {
      return EXTERNAL_STORAGE_ANDROID_DATA_DIRECTORY;
    }
    
    public static File getExternalStorageAppCacheDirectory(String paramString)
    {
      return new File(new File(EXTERNAL_STORAGE_ANDROID_DATA_DIRECTORY, paramString), "cache");
    }
    
    public static File getExternalStorageAppFilesDirectory(String paramString)
    {
      return new File(new File(EXTERNAL_STORAGE_ANDROID_DATA_DIRECTORY, paramString), "files");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.component.network.module.cache.CacheManager
 * JD-Core Version:    0.7.0.1
 */