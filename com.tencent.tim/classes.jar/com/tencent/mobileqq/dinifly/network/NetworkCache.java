package com.tencent.mobileqq.dinifly.network;

import android.content.Context;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.dinifly.L;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

class NetworkCache
{
  private final Context appContext;
  private final String url;
  
  NetworkCache(Context paramContext, String paramString)
  {
    this.appContext = paramContext.getApplicationContext();
    this.url = paramString;
  }
  
  private static String filenameForUrl(String paramString, FileExtension paramFileExtension, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("lottie_cache_").append(paramString.replaceAll("\\W+", ""));
    if (paramBoolean) {}
    for (paramString = paramFileExtension.tempExtension();; paramString = paramFileExtension.extension) {
      return paramString;
    }
  }
  
  @Nullable
  private File getCachedFile(String paramString)
    throws FileNotFoundException
  {
    File localFile = new File(this.appContext.getCacheDir(), filenameForUrl(paramString, FileExtension.JSON, false));
    if (localFile.exists()) {
      paramString = localFile;
    }
    do
    {
      return paramString;
      localFile = new File(this.appContext.getCacheDir(), filenameForUrl(paramString, FileExtension.ZIP, false));
      paramString = localFile;
    } while (localFile.exists());
    return null;
  }
  
  /* Error */
  @Nullable
  @android.support.annotation.WorkerThread
  android.util.Pair<FileExtension, InputStream> fetch()
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_0
    //   2: getfield 23	com/tencent/mobileqq/dinifly/network/NetworkCache:url	Ljava/lang/String;
    //   5: invokespecial 91	com/tencent/mobileqq/dinifly/network/NetworkCache:getCachedFile	(Ljava/lang/String;)Ljava/io/File;
    //   8: astore_2
    //   9: aload_2
    //   10: ifnonnull +5 -> 15
    //   13: aconst_null
    //   14: areturn
    //   15: new 93	java/io/FileInputStream
    //   18: dup
    //   19: aload_2
    //   20: invokespecial 96	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   23: astore_3
    //   24: aload_2
    //   25: invokevirtual 99	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   28: ldc 101
    //   30: invokevirtual 105	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   33: ifeq +54 -> 87
    //   36: getstatic 84	com/tencent/mobileqq/dinifly/network/FileExtension:ZIP	Lcom/tencent/mobileqq/dinifly/network/FileExtension;
    //   39: astore_1
    //   40: new 28	java/lang/StringBuilder
    //   43: dup
    //   44: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   47: ldc 107
    //   49: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: aload_0
    //   53: getfield 23	com/tencent/mobileqq/dinifly/network/NetworkCache:url	Ljava/lang/String;
    //   56: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: ldc 109
    //   61: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: aload_2
    //   65: invokevirtual 99	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   68: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   74: invokestatic 115	com/tencent/mobileqq/dinifly/L:debug	(Ljava/lang/String;)V
    //   77: new 117	android/util/Pair
    //   80: dup
    //   81: aload_1
    //   82: aload_3
    //   83: invokespecial 120	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   86: areturn
    //   87: getstatic 72	com/tencent/mobileqq/dinifly/network/FileExtension:JSON	Lcom/tencent/mobileqq/dinifly/network/FileExtension;
    //   90: astore_1
    //   91: goto -51 -> 40
    //   94: astore_1
    //   95: aconst_null
    //   96: areturn
    //   97: astore_1
    //   98: aconst_null
    //   99: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	100	0	this	NetworkCache
    //   39	52	1	localFileExtension	FileExtension
    //   94	1	1	localFileNotFoundException1	FileNotFoundException
    //   97	1	1	localFileNotFoundException2	FileNotFoundException
    //   8	57	2	localFile	File
    //   23	60	3	localFileInputStream	java.io.FileInputStream
    // Exception table:
    //   from	to	target	type
    //   15	24	94	java/io/FileNotFoundException
    //   0	9	97	java/io/FileNotFoundException
  }
  
  void renameTempFile(FileExtension paramFileExtension)
  {
    paramFileExtension = filenameForUrl(this.url, paramFileExtension, true);
    paramFileExtension = new File(this.appContext.getCacheDir(), paramFileExtension);
    File localFile = new File(paramFileExtension.getAbsolutePath().replace(".temp", ""));
    boolean bool = paramFileExtension.renameTo(localFile);
    L.debug("Copying temp file to real file (" + localFile + ")");
    if (!bool) {
      L.warn("Unable to rename cache file " + paramFileExtension.getAbsolutePath() + " to " + localFile.getAbsolutePath() + ".");
    }
  }
  
  File writeTempCacheFile(InputStream paramInputStream, FileExtension paramFileExtension)
    throws IOException
  {
    paramFileExtension = filenameForUrl(this.url, paramFileExtension, true);
    File localFile1 = new File(this.appContext.getCacheDir(), paramFileExtension);
    try
    {
      paramFileExtension = new FileOutputStream(localFile1);
      try
      {
        byte[] arrayOfByte = new byte[1024];
        for (;;)
        {
          int i = paramInputStream.read(arrayOfByte);
          if (i == -1) {
            break;
          }
          paramFileExtension.write(arrayOfByte, 0, i);
        }
        paramFileExtension = finally;
      }
      finally {}
    }
    finally
    {
      paramInputStream.close();
    }
    paramFileExtension.close();
    paramInputStream.close();
    return localFile2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.network.NetworkCache
 * JD-Core Version:    0.7.0.1
 */