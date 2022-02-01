package com.tencent.qqmail.cache;

import android.text.TextUtils;
import android.util.Log;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.qmimagecache.DiskLruCache;
import com.tencent.qqmail.qmimagecache.DiskLruCache.Snapshot;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DiskCache
{
  private static final int DEFAULT_DISK_CACHE_SIZE = 20971520;
  private static final int DISK_CACHE_INDEX = 0;
  public static final String TAG = "DiskCache";
  private CacheParams mCacheParams;
  private DiskLruCache mDiskLruCache;
  private List<String> processingUrls = Collections.synchronizedList(new ArrayList());
  
  public DiskCache(CacheParams paramCacheParams)
  {
    this.mCacheParams = paramCacheParams;
    initDiskCache();
  }
  
  private void initDiskCache()
  {
    Object localObject;
    if ((this.mDiskLruCache == null) || (this.mDiskLruCache.isClosed()))
    {
      localObject = this.mCacheParams.diskCacheDir;
      if (TextUtils.isEmpty((CharSequence)localObject)) {}
    }
    try
    {
      localObject = new File((String)localObject);
      if (!((File)localObject).exists()) {
        ((File)localObject).mkdirs();
      }
      this.mDiskLruCache = DiskLruCache.open((File)localObject, 1, 1, this.mCacheParams.diskCacheSize);
      return;
    }
    catch (IOException localIOException)
    {
      this.mCacheParams.diskCacheDir = null;
    }
  }
  
  public void close()
  {
    if (this.mDiskLruCache != null) {}
    try
    {
      if (!this.mDiskLruCache.isClosed())
      {
        this.mDiskLruCache.close();
        this.mDiskLruCache = null;
      }
      return;
    }
    catch (IOException localIOException)
    {
      Log.e("DiskCache", "close - " + localIOException);
    }
  }
  
  public void flush()
  {
    if (this.mDiskLruCache != null) {}
    try
    {
      this.mDiskLruCache.flush();
      return;
    }
    catch (IOException localIOException)
    {
      Log.e("DiskCache", "flush - " + localIOException);
    }
  }
  
  public InputStream get(String paramString)
  {
    if (this.processingUrls.contains(paramString)) {
      QMLog.log(5, "DiskCache", "[Get]-Another thread processing the same file. Quit current thread!");
    }
    while (this.mDiskLruCache == null) {
      return null;
    }
    paramString = StringExtention.hashKeyForDisk(paramString);
    this.processingUrls.add(paramString);
    try
    {
      Object localObject = this.mDiskLruCache.get(paramString);
      if (localObject != null)
      {
        localObject = ((DiskLruCache.Snapshot)localObject).getInputStream(0);
        return localObject;
      }
    }
    catch (IOException localIOException)
    {
      Log.e("DiskCache", "getBitmapFromDiskCache - " + localIOException);
      this.processingUrls.remove(paramString);
    }
    return null;
  }
  
  /* Error */
  public void put(String paramString, InputStream paramInputStream)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +7 -> 8
    //   4: aload_2
    //   5: ifnonnull +4 -> 9
    //   8: return
    //   9: aload_0
    //   10: getfield 39	com/tencent/qqmail/cache/DiskCache:processingUrls	Ljava/util/List;
    //   13: aload_1
    //   14: invokeinterface 120 2 0
    //   19: ifeq +12 -> 31
    //   22: iconst_5
    //   23: ldc 16
    //   25: ldc 157
    //   27: invokestatic 128	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   30: return
    //   31: aload_0
    //   32: getfield 49	com/tencent/qqmail/cache/DiskCache:mDiskLruCache	Lcom/tencent/qqmail/qmimagecache/DiskLruCache;
    //   35: ifnull -27 -> 8
    //   38: aload_0
    //   39: getfield 39	com/tencent/qqmail/cache/DiskCache:processingUrls	Ljava/util/List;
    //   42: aload_1
    //   43: invokeinterface 137 2 0
    //   48: pop
    //   49: aload_1
    //   50: invokestatic 134	com/tencent/qqmail/utilities/stringextention/StringExtention:hashKeyForDisk	(Ljava/lang/String;)Ljava/lang/String;
    //   53: astore 5
    //   55: aconst_null
    //   56: astore 4
    //   58: aload_0
    //   59: getfield 49	com/tencent/qqmail/cache/DiskCache:mDiskLruCache	Lcom/tencent/qqmail/qmimagecache/DiskLruCache;
    //   62: aload 5
    //   64: invokevirtual 140	com/tencent/qqmail/qmimagecache/DiskLruCache:get	(Ljava/lang/String;)Lcom/tencent/qqmail/qmimagecache/DiskLruCache$Snapshot;
    //   67: astore 6
    //   69: aload 6
    //   71: ifnonnull +206 -> 277
    //   74: aload_0
    //   75: getfield 49	com/tencent/qqmail/cache/DiskCache:mDiskLruCache	Lcom/tencent/qqmail/qmimagecache/DiskLruCache;
    //   78: aload 5
    //   80: invokevirtual 161	com/tencent/qqmail/qmimagecache/DiskLruCache:edit	(Ljava/lang/String;)Lcom/tencent/qqmail/qmimagecache/DiskLruCache$Editor;
    //   83: astore 5
    //   85: aload 5
    //   87: ifnull +133 -> 220
    //   90: aload 5
    //   92: iconst_0
    //   93: invokevirtual 167	com/tencent/qqmail/qmimagecache/DiskLruCache$Editor:newOutputStream	(I)Ljava/io/OutputStream;
    //   96: astore 4
    //   98: aload_2
    //   99: invokevirtual 173	java/io/InputStream:read	()I
    //   102: istore_3
    //   103: iload_3
    //   104: iconst_m1
    //   105: if_icmpeq +105 -> 210
    //   108: aload 4
    //   110: iload_3
    //   111: invokevirtual 179	java/io/OutputStream:write	(I)V
    //   114: goto -16 -> 98
    //   117: astore 6
    //   119: aload 4
    //   121: astore 5
    //   123: aload 5
    //   125: astore 4
    //   127: ldc 16
    //   129: new 87	java/lang/StringBuilder
    //   132: dup
    //   133: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   136: ldc 181
    //   138: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: aload 6
    //   143: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   146: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   149: invokestatic 107	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   152: pop
    //   153: aload 5
    //   155: ifnull +8 -> 163
    //   158: aload 5
    //   160: invokevirtual 182	java/io/OutputStream:close	()V
    //   163: aload_2
    //   164: ifnull +7 -> 171
    //   167: aload_2
    //   168: invokevirtual 183	java/io/InputStream:close	()V
    //   171: ldc 16
    //   173: new 87	java/lang/StringBuilder
    //   176: dup
    //   177: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   180: ldc 185
    //   182: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: aload_1
    //   186: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   192: invokestatic 188	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   195: pop
    //   196: aload_0
    //   197: getfield 39	com/tencent/qqmail/cache/DiskCache:processingUrls	Ljava/util/List;
    //   200: aload_1
    //   201: invokeinterface 151 2 0
    //   206: pop
    //   207: return
    //   208: astore_1
    //   209: return
    //   210: aload 5
    //   212: invokevirtual 191	com/tencent/qqmail/qmimagecache/DiskLruCache$Editor:commit	()V
    //   215: aload 4
    //   217: invokevirtual 182	java/io/OutputStream:close	()V
    //   220: aload 4
    //   222: ifnull +8 -> 230
    //   225: aload 4
    //   227: invokevirtual 182	java/io/OutputStream:close	()V
    //   230: aload_2
    //   231: ifnull +7 -> 238
    //   234: aload_2
    //   235: invokevirtual 183	java/io/InputStream:close	()V
    //   238: ldc 16
    //   240: new 87	java/lang/StringBuilder
    //   243: dup
    //   244: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   247: ldc 185
    //   249: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   252: aload_1
    //   253: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   256: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   259: invokestatic 188	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   262: pop
    //   263: aload_0
    //   264: getfield 39	com/tencent/qqmail/cache/DiskCache:processingUrls	Ljava/util/List;
    //   267: aload_1
    //   268: invokeinterface 151 2 0
    //   273: pop
    //   274: return
    //   275: astore_1
    //   276: return
    //   277: aload 6
    //   279: iconst_0
    //   280: invokevirtual 146	com/tencent/qqmail/qmimagecache/DiskLruCache$Snapshot:getInputStream	(I)Ljava/io/InputStream;
    //   283: invokevirtual 183	java/io/InputStream:close	()V
    //   286: goto -66 -> 220
    //   289: astore 6
    //   291: aconst_null
    //   292: astore 5
    //   294: goto -171 -> 123
    //   297: astore 6
    //   299: aconst_null
    //   300: astore 5
    //   302: aload 5
    //   304: astore 4
    //   306: ldc 16
    //   308: new 87	java/lang/StringBuilder
    //   311: dup
    //   312: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   315: ldc 181
    //   317: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   320: aload 6
    //   322: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   325: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   328: invokestatic 107	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   331: pop
    //   332: aload 5
    //   334: ifnull +8 -> 342
    //   337: aload 5
    //   339: invokevirtual 182	java/io/OutputStream:close	()V
    //   342: aload_2
    //   343: ifnull +7 -> 350
    //   346: aload_2
    //   347: invokevirtual 183	java/io/InputStream:close	()V
    //   350: ldc 16
    //   352: new 87	java/lang/StringBuilder
    //   355: dup
    //   356: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   359: ldc 185
    //   361: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   364: aload_1
    //   365: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   368: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   371: invokestatic 188	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   374: pop
    //   375: aload_0
    //   376: getfield 39	com/tencent/qqmail/cache/DiskCache:processingUrls	Ljava/util/List;
    //   379: aload_1
    //   380: invokeinterface 151 2 0
    //   385: pop
    //   386: return
    //   387: astore_1
    //   388: return
    //   389: astore 5
    //   391: aconst_null
    //   392: astore 4
    //   394: aload 4
    //   396: ifnull +8 -> 404
    //   399: aload 4
    //   401: invokevirtual 182	java/io/OutputStream:close	()V
    //   404: aload_2
    //   405: ifnull +7 -> 412
    //   408: aload_2
    //   409: invokevirtual 183	java/io/InputStream:close	()V
    //   412: ldc 16
    //   414: new 87	java/lang/StringBuilder
    //   417: dup
    //   418: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   421: ldc 185
    //   423: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   426: aload_1
    //   427: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   430: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   433: invokestatic 188	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   436: pop
    //   437: aload_0
    //   438: getfield 39	com/tencent/qqmail/cache/DiskCache:processingUrls	Ljava/util/List;
    //   441: aload_1
    //   442: invokeinterface 151 2 0
    //   447: pop
    //   448: aload 5
    //   450: athrow
    //   451: astore_1
    //   452: goto -4 -> 448
    //   455: astore 5
    //   457: goto -63 -> 394
    //   460: astore 5
    //   462: goto -68 -> 394
    //   465: astore 6
    //   467: aload 4
    //   469: astore 5
    //   471: goto -169 -> 302
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	474	0	this	DiskCache
    //   0	474	1	paramString	String
    //   0	474	2	paramInputStream	InputStream
    //   102	9	3	i	int
    //   56	412	4	localObject1	Object
    //   53	285	5	localObject2	Object
    //   389	60	5	localObject3	Object
    //   455	1	5	localObject4	Object
    //   460	1	5	localObject5	Object
    //   469	1	5	localObject6	Object
    //   67	3	6	localSnapshot	DiskLruCache.Snapshot
    //   117	161	6	localIOException1	IOException
    //   289	1	6	localIOException2	IOException
    //   297	24	6	localException1	java.lang.Exception
    //   465	1	6	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   98	103	117	java/io/IOException
    //   108	114	117	java/io/IOException
    //   210	220	117	java/io/IOException
    //   158	163	208	java/io/IOException
    //   167	171	208	java/io/IOException
    //   171	207	208	java/io/IOException
    //   225	230	275	java/io/IOException
    //   234	238	275	java/io/IOException
    //   238	274	275	java/io/IOException
    //   58	69	289	java/io/IOException
    //   74	85	289	java/io/IOException
    //   90	98	289	java/io/IOException
    //   277	286	289	java/io/IOException
    //   58	69	297	java/lang/Exception
    //   74	85	297	java/lang/Exception
    //   90	98	297	java/lang/Exception
    //   277	286	297	java/lang/Exception
    //   337	342	387	java/io/IOException
    //   346	350	387	java/io/IOException
    //   350	386	387	java/io/IOException
    //   58	69	389	finally
    //   74	85	389	finally
    //   90	98	389	finally
    //   277	286	389	finally
    //   399	404	451	java/io/IOException
    //   408	412	451	java/io/IOException
    //   412	448	451	java/io/IOException
    //   98	103	455	finally
    //   108	114	455	finally
    //   210	220	455	finally
    //   127	153	460	finally
    //   306	332	460	finally
    //   98	103	465	java/lang/Exception
    //   108	114	465	java/lang/Exception
    //   210	220	465	java/lang/Exception
  }
  
  public static class CacheParams
  {
    String diskCacheDir = QMApplicationContext.sharedInstance().getCacheDir().getAbsolutePath();
    int diskCacheSize = 20971520;
    
    public CacheParams(String paramString)
    {
      this.diskCacheDir = paramString;
    }
    
    public CacheParams(String paramString, int paramInt)
    {
      this.diskCacheDir = paramString;
      this.diskCacheSize = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.cache.DiskCache
 * JD-Core Version:    0.7.0.1
 */