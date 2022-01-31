package com.qzone.cache;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import com.qzone.cache.file.FileCacheService;
import com.qzone.cache.file.FileStorageHandler;
import com.qzone.cache.file.FileStorageHandler.Collector;
import com.qzone.common.logging.QDLog;
import com.qzone.utils.AssertUtil;
import com.qzone.utils.FileUtil;
import com.qzone.utils.PlatformUtil;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
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
  private static final FileStorageHandler sStorageHandler = new FileStorageHandler(new FileStorageHandler.Collector()
  {
    public Collection<FileCacheService> collect()
    {
      synchronized (CacheManager.sFileCacheService)
      {
        if (CacheManager.sFileCacheService.size() <= 0)
        {
          localObject1 = null;
          return localObject1;
        }
        Object localObject1 = new ArrayList(CacheManager.sFileCacheService.values());
      }
    }
  });
  
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
      FileUtil.delete(str1, true);
    }
    String str2 = getExternalCacheDirExt(paramContext, false);
    if (str1 != null) {
      FileUtil.delete(str2, true);
    }
    paramContext = getInternalCacheDir(paramContext, false);
    if (paramContext != null) {
      FileUtil.delete(paramContext, true);
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
        FileUtil.delete(paramContext);
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
        FileUtil.delete(paramContext);
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
    if (TextUtils.isEmpty(paramString)) {}
    for (boolean bool = false;; bool = true)
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
      FileUtil.delete(paramContext);
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
    return getFileCacheService(paramContext, "tmp", 500, 200);
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
    return "mounted".equals(Environment.getExternalStorageState());
  }
  
  static class InnerEnvironment
  {
    private static final String EXTEND_SUFFIX = "-ext";
    private static final File EXTERNAL_STORAGE_ANDROID_DATA_DIRECTORY = new File(new File(Environment.getExternalStorageDirectory(), "Android"), "data");
    private static final String TAG = "InnerEnvironment";
    
    public static File getExternalCacheDir(Context paramContext, boolean paramBoolean)
    {
      if ((!paramBoolean) && (PlatformUtil.version() >= 8)) {
        return paramContext.getExternalCacheDir();
      }
      for (;;)
      {
        try
        {
          StringBuilder localStringBuilder = new StringBuilder(String.valueOf(paramContext.getPackageName()));
          if (!paramBoolean) {
            break label121;
          }
          paramContext = "-ext";
          paramContext = getExternalStorageAppCacheDirectory(paramContext);
          paramBoolean = paramContext.exists();
          if (!paramBoolean) {
            try
            {
              new File(getExternalStorageAndroidDataDir(), ".nomedia").createNewFile();
              if (!paramContext.mkdirs())
              {
                QDLog.w("InnerEnvironment", "Unable to create external cache directory");
                return null;
              }
            }
            catch (IOException localIOException)
            {
              QDLog.e("InnerEnvironment", "", localIOException);
              continue;
            }
          }
        }
        finally {}
        return paramContext;
        label121:
        paramContext = "";
      }
    }
    
    /* Error */
    public static File getExternalFilesDir(Context paramContext, String paramString, boolean paramBoolean)
    {
      // Byte code:
      //   0: iload_2
      //   1: ifne +17 -> 18
      //   4: invokestatic 48	com/qzone/utils/PlatformUtil:version	()I
      //   7: bipush 8
      //   9: if_icmplt +9 -> 18
      //   12: aload_0
      //   13: aload_1
      //   14: invokevirtual 111	android/content/Context:getExternalFilesDir	(Ljava/lang/String;)Ljava/io/File;
      //   17: areturn
      //   18: ldc 2
      //   20: monitorenter
      //   21: new 54	java/lang/StringBuilder
      //   24: dup
      //   25: aload_0
      //   26: invokevirtual 58	android/content/Context:getPackageName	()Ljava/lang/String;
      //   29: invokestatic 64	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
      //   32: invokespecial 67	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   35: astore_3
      //   36: iload_2
      //   37: ifeq +138 -> 175
      //   40: ldc 11
      //   42: astore_0
      //   43: aload_3
      //   44: aload_0
      //   45: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   48: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   51: invokestatic 114	com/qzone/cache/CacheManager$InnerEnvironment:getExternalStorageAppFilesDirectory	(Ljava/lang/String;)Ljava/io/File;
      //   54: astore_0
      //   55: aload_0
      //   56: invokevirtual 82	java/io/File:exists	()Z
      //   59: istore_2
      //   60: iload_2
      //   61: ifne +39 -> 100
      //   64: new 19	java/io/File
      //   67: dup
      //   68: invokestatic 85	com/qzone/cache/CacheManager$InnerEnvironment:getExternalStorageAndroidDataDir	()Ljava/io/File;
      //   71: ldc 87
      //   73: invokespecial 31	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
      //   76: invokevirtual 90	java/io/File:createNewFile	()Z
      //   79: pop
      //   80: aload_0
      //   81: invokevirtual 93	java/io/File:mkdirs	()Z
      //   84: ifne +16 -> 100
      //   87: ldc 15
      //   89: ldc 116
      //   91: invokestatic 121	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
      //   94: pop
      //   95: ldc 2
      //   97: monitorexit
      //   98: aconst_null
      //   99: areturn
      //   100: aload_1
      //   101: ifnonnull +14 -> 115
      //   104: ldc 2
      //   106: monitorexit
      //   107: aload_0
      //   108: areturn
      //   109: astore_0
      //   110: ldc 2
      //   112: monitorexit
      //   113: aload_0
      //   114: athrow
      //   115: new 19	java/io/File
      //   118: dup
      //   119: aload_0
      //   120: aload_1
      //   121: invokespecial 31	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
      //   124: astore_0
      //   125: aload_0
      //   126: invokevirtual 82	java/io/File:exists	()Z
      //   129: ifne +37 -> 166
      //   132: aload_0
      //   133: invokevirtual 93	java/io/File:mkdirs	()Z
      //   136: ifne +30 -> 166
      //   139: ldc 15
      //   141: new 54	java/lang/StringBuilder
      //   144: dup
      //   145: ldc 123
      //   147: invokespecial 67	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   150: aload_0
      //   151: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   154: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   157: invokestatic 121	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
      //   160: pop
      //   161: ldc 2
      //   163: monitorexit
      //   164: aconst_null
      //   165: areturn
      //   166: ldc 2
      //   168: monitorexit
      //   169: aload_0
      //   170: areturn
      //   171: astore_3
      //   172: goto -92 -> 80
      //   175: ldc 103
      //   177: astore_0
      //   178: goto -135 -> 43
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	181	0	paramContext	Context
      //   0	181	1	paramString	String
      //   0	181	2	paramBoolean	boolean
      //   35	9	3	localStringBuilder	StringBuilder
      //   171	1	3	localIOException	IOException
      // Exception table:
      //   from	to	target	type
      //   21	36	109	finally
      //   43	60	109	finally
      //   64	80	109	finally
      //   80	98	109	finally
      //   104	107	109	finally
      //   110	113	109	finally
      //   115	164	109	finally
      //   166	169	109	finally
      //   64	80	171	java/io/IOException
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.qzone.cache.CacheManager
 * JD-Core Version:    0.7.0.1
 */