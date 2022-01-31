package com.tencent.mobileqq.transfile;

import com.tencent.image.DownloadParams;
import com.tencent.image.ProtocolDownloader.Adapter;
import com.tencent.image.URLDrawableHandler;
import com.tencent.image.Utils;
import com.tencent.mobileqq.startup.step.InitUrlDrawable;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.OutputStream;
import java.util.Locale;

public abstract class AbsDownloader
  extends ProtocolDownloader.Adapter
  implements ProtocolDownloaderConstants
{
  private static final String a = AbsDownloader.class.getSimpleName();
  
  public static final File a(String paramString)
  {
    paramString = c(paramString);
    paramString = new File(URLDrawableHelper.a, paramString);
    if (paramString.exists()) {
      return paramString;
    }
    return null;
  }
  
  public static final boolean a(String paramString)
  {
    Object localObject3 = null;
    Object localObject2 = null;
    Object localObject1;
    if (paramString != null) {
      if (paramString.toLowerCase(Locale.US).startsWith("file")) {
        localObject1 = localObject2;
      }
    }
    try
    {
      if (paramString.substring(0, "file:".length()).equalsIgnoreCase("file:")) {
        localObject1 = paramString.substring("file:".length());
      }
      if (localObject1 != null)
      {
        return new File((String)localObject1).exists();
        if (paramString.toLowerCase(Locale.US).startsWith("regionalthumb")) {
          localObject1 = localObject3;
        }
      }
      try
      {
        if (paramString.substring(0, "regionalthumb:".length()).equalsIgnoreCase("regionalthumb:")) {
          localObject1 = paramString.substring("regionalthumb:".length());
        }
        if (localObject1 != null)
        {
          paramString = ((String)localObject1).split("\\|");
          if (paramString != null)
          {
            return new File(paramString[0]).exists();
            paramString = b(paramString);
            if (paramString != null) {
              return a(paramString) != null;
            }
          }
        }
        return false;
      }
      catch (IndexOutOfBoundsException paramString)
      {
        for (;;)
        {
          localObject1 = localObject3;
        }
      }
    }
    catch (IndexOutOfBoundsException paramString)
    {
      for (;;)
      {
        localObject1 = localObject2;
      }
    }
  }
  
  public static String b(String paramString)
  {
    String str = paramString;
    if (paramString != null) {
      str = paramString;
    }
    try
    {
      if (paramString.substring(0, "aiothumb".length()).equalsIgnoreCase("aiothumb"))
      {
        str = "chatthumb" + paramString.substring("aiothumb".length());
        if (QLog.isColorLevel()) {
          QLog.d(a, 2, "getUrlStringForDisk newUrl = " + str);
        }
      }
      return str;
    }
    catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
    {
      do
      {
        str = paramString;
      } while (!QLog.isColorLevel());
      QLog.d(a, 2, "getUrlStringForDisk IndexOutOfBoundsException" + localIndexOutOfBoundsException);
    }
    return paramString;
  }
  
  public static final String c(String paramString)
  {
    return "Cache_" + Utils.Crc64String(paramString);
  }
  
  public static final String d(String paramString)
  {
    return URLDrawableHelper.a + "/" + c(paramString);
  }
  
  public abstract File a(OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler);
  
  public String a(String paramString)
  {
    return paramString;
  }
  
  public boolean a()
  {
    return false;
  }
  
  public boolean a(DownloadParams paramDownloadParams)
  {
    return false;
  }
  
  public boolean b()
  {
    return false;
  }
  
  public final boolean hasDiskFile(DownloadParams paramDownloadParams)
  {
    if (!a()) {}
    do
    {
      return false;
      paramDownloadParams = c(a(paramDownloadParams.urlStr));
      paramDownloadParams = InitUrlDrawable.a.a(paramDownloadParams);
    } while ((paramDownloadParams == null) || (!paramDownloadParams.exists()));
    return true;
  }
  
  /* Error */
  public File loadImageFile(DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 8
    //   6: aload_0
    //   7: invokevirtual 139	com/tencent/mobileqq/transfile/AbsDownloader:a	()Z
    //   10: ifeq +264 -> 274
    //   13: aload_1
    //   14: getfield 144	com/tencent/image/DownloadParams:urlStr	Ljava/lang/String;
    //   17: astore 9
    //   19: aload_0
    //   20: aload 9
    //   22: invokevirtual 146	com/tencent/mobileqq/transfile/AbsDownloader:a	(Ljava/lang/String;)Ljava/lang/String;
    //   25: astore 10
    //   27: aload 10
    //   29: invokestatic 27	com/tencent/mobileqq/transfile/AbsDownloader:c	(Ljava/lang/String;)Ljava/lang/String;
    //   32: astore 11
    //   34: getstatic 151	com/tencent/mobileqq/startup/step/InitUrlDrawable:a	Lcom/tencent/mobileqq/transfile/DiskCache;
    //   37: aload 11
    //   39: invokevirtual 154	com/tencent/mobileqq/transfile/DiskCache:a	(Ljava/lang/String;)Ljava/io/File;
    //   42: astore 6
    //   44: aload 6
    //   46: ifnull +16 -> 62
    //   49: aload 6
    //   51: invokevirtual 41	java/io/File:exists	()Z
    //   54: ifeq +8 -> 62
    //   57: aload 6
    //   59: astore_2
    //   60: aload_2
    //   61: areturn
    //   62: getstatic 151	com/tencent/mobileqq/startup/step/InitUrlDrawable:a	Lcom/tencent/mobileqq/transfile/DiskCache;
    //   65: aload 11
    //   67: invokevirtual 163	com/tencent/mobileqq/transfile/DiskCache:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/transfile/DiskCache$Editor;
    //   70: astore 12
    //   72: aload_0
    //   73: invokevirtual 165	com/tencent/mobileqq/transfile/AbsDownloader:b	()Z
    //   76: istore 4
    //   78: iload 4
    //   80: ifeq +228 -> 308
    //   83: aload 7
    //   85: astore 6
    //   87: aload_1
    //   88: aload 12
    //   90: getfield 168	com/tencent/mobileqq/transfile/DiskCache$Editor:a	Ljava/io/File;
    //   93: invokevirtual 171	java/io/File:length	()J
    //   96: putfield 175	com/tencent/image/DownloadParams:downloaded	J
    //   99: aload 7
    //   101: astore 6
    //   103: aload_0
    //   104: aload_1
    //   105: invokevirtual 177	com/tencent/mobileqq/transfile/AbsDownloader:a	(Lcom/tencent/image/DownloadParams;)Z
    //   108: istore 5
    //   110: iload 5
    //   112: ifne +63 -> 175
    //   115: iconst_1
    //   116: istore_3
    //   117: iload 4
    //   119: iload_3
    //   120: iand
    //   121: istore 4
    //   123: aload 7
    //   125: astore 6
    //   127: new 179	java/io/FileOutputStream
    //   130: dup
    //   131: aload 12
    //   133: getfield 168	com/tencent/mobileqq/transfile/DiskCache$Editor:a	Ljava/io/File;
    //   136: iload 4
    //   138: invokespecial 182	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   141: astore 7
    //   143: aload_0
    //   144: aload 7
    //   146: aload_1
    //   147: aload_2
    //   148: invokevirtual 184	com/tencent/mobileqq/transfile/AbsDownloader:a	(Ljava/io/OutputStream;Lcom/tencent/image/DownloadParams;Lcom/tencent/image/URLDrawableHandler;)Ljava/io/File;
    //   151: pop
    //   152: aload 12
    //   154: invokevirtual 187	com/tencent/mobileqq/transfile/DiskCache$Editor:a	()Ljava/io/File;
    //   157: astore_1
    //   158: aload_1
    //   159: astore_2
    //   160: aload 7
    //   162: ifnull -102 -> 60
    //   165: aload 7
    //   167: invokevirtual 192	java/io/OutputStream:close	()V
    //   170: aload_1
    //   171: areturn
    //   172: astore_2
    //   173: aload_1
    //   174: areturn
    //   175: iconst_0
    //   176: istore_3
    //   177: goto -60 -> 117
    //   180: astore_1
    //   181: aload 8
    //   183: astore_2
    //   184: aload 12
    //   186: ifnull +13 -> 199
    //   189: aload_2
    //   190: astore 6
    //   192: aload 12
    //   194: iload 4
    //   196: invokevirtual 195	com/tencent/mobileqq/transfile/DiskCache$Editor:a	(Z)V
    //   199: aload_2
    //   200: astore 6
    //   202: ldc 197
    //   204: ldc 198
    //   206: new 99	java/lang/StringBuilder
    //   209: dup
    //   210: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   213: ldc 200
    //   215: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: aload 11
    //   220: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   223: ldc 202
    //   225: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   228: aload 10
    //   230: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: ldc 204
    //   235: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: aload 9
    //   240: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   243: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   246: invokestatic 209	com/tencent/mobileqq/pic/Logger:b	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   249: aload_2
    //   250: astore 6
    //   252: aload_1
    //   253: invokevirtual 212	java/lang/Exception:printStackTrace	()V
    //   256: aload_2
    //   257: astore 6
    //   259: aload_1
    //   260: athrow
    //   261: astore_1
    //   262: aload 6
    //   264: ifnull +8 -> 272
    //   267: aload 6
    //   269: invokevirtual 192	java/io/OutputStream:close	()V
    //   272: aload_1
    //   273: athrow
    //   274: aload_0
    //   275: aconst_null
    //   276: aload_1
    //   277: aload_2
    //   278: invokevirtual 184	com/tencent/mobileqq/transfile/AbsDownloader:a	(Ljava/io/OutputStream;Lcom/tencent/image/DownloadParams;Lcom/tencent/image/URLDrawableHandler;)Ljava/io/File;
    //   281: areturn
    //   282: astore_2
    //   283: goto -11 -> 272
    //   286: astore_1
    //   287: aload 7
    //   289: astore 6
    //   291: goto -29 -> 262
    //   294: astore_1
    //   295: aload 8
    //   297: astore_2
    //   298: goto -114 -> 184
    //   301: astore_1
    //   302: aload 7
    //   304: astore_2
    //   305: goto -121 -> 184
    //   308: goto -185 -> 123
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	311	0	this	AbsDownloader
    //   0	311	1	paramDownloadParams	DownloadParams
    //   0	311	2	paramURLDrawableHandler	URLDrawableHandler
    //   116	61	3	bool1	boolean
    //   76	119	4	bool2	boolean
    //   108	3	5	bool3	boolean
    //   42	248	6	localObject1	Object
    //   1	302	7	localFileOutputStream	java.io.FileOutputStream
    //   4	292	8	localObject2	Object
    //   17	222	9	str1	String
    //   25	204	10	str2	String
    //   32	187	11	str3	String
    //   70	123	12	localEditor	DiskCache.Editor
    // Exception table:
    //   from	to	target	type
    //   165	170	172	java/io/IOException
    //   87	99	180	java/lang/Exception
    //   103	110	180	java/lang/Exception
    //   87	99	261	finally
    //   103	110	261	finally
    //   127	143	261	finally
    //   192	199	261	finally
    //   202	249	261	finally
    //   252	256	261	finally
    //   259	261	261	finally
    //   267	272	282	java/io/IOException
    //   143	158	286	finally
    //   127	143	294	java/lang/Exception
    //   143	158	301	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.AbsDownloader
 * JD-Core Version:    0.7.0.1
 */