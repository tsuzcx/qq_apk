package com.tencent.qqmail.qmimagecache;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import android.util.Log;
import android.util.LruCache;
import com.tencent.qqmail.utilities.fileextention.FileUtil;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import java.io.File;
import java.io.IOException;
import java.lang.ref.SoftReference;
import java.util.HashSet;
import java.util.Iterator;

public class ImageCache
{
  private static final boolean DEFAULT_CLEAR_DISK_CACHE_ON_START = false;
  private static final Bitmap.CompressFormat DEFAULT_COMPRESS_FORMAT = Bitmap.CompressFormat.PNG;
  private static final int DEFAULT_COMPRESS_QUALITY = 70;
  private static final boolean DEFAULT_DISK_CACHE_ENABLED = true;
  private static final int DEFAULT_DISK_CACHE_SIZE = 314572800;
  private static final boolean DEFAULT_INIT_DISK_CACHE_ON_CREATE = false;
  private static final boolean DEFAULT_MEM_CACHE_ENABLED = true;
  private static final int DEFAULT_MEM_CACHE_SIZE = 20480;
  public static final int DISK_CACHE_INDEX = 0;
  private static final String TAG = "ImageCache";
  private ImageCacheParams mCacheParams;
  private final Object mDiskCacheLock = new Object();
  private boolean mDiskCacheStarting = true;
  private DiskLruCache mDiskLruCache;
  private LruCache<String, Bitmap> mMemoryCache;
  private HashSet<SoftReference<Bitmap>> mReusableBitmaps;
  
  public ImageCache()
  {
    init(new ImageCacheParams());
  }
  
  public ImageCache(ImageCacheParams paramImageCacheParams)
  {
    init(paramImageCacheParams);
  }
  
  private static boolean canUseForInBitmap(Bitmap paramBitmap, BitmapFactory.Options paramOptions)
  {
    int i = paramOptions.outWidth / paramOptions.inSampleSize;
    int j = paramOptions.outHeight / paramOptions.inSampleSize;
    return (paramBitmap.getWidth() == i) && (paramBitmap.getHeight() == j);
  }
  
  private void init(ImageCacheParams paramImageCacheParams)
  {
    this.mCacheParams = paramImageCacheParams;
    if (this.mCacheParams.memoryCacheEnabled) {
      this.mMemoryCache = new ImageCache.1(this, this.mCacheParams.memCacheSize);
    }
    if (paramImageCacheParams.initDiskCacheOnCreate) {
      initDiskCache();
    }
  }
  
  public void addBitmapToCache(String paramString, Bitmap paramBitmap)
  {
    if ((paramString == null) || (paramBitmap == null)) {}
    while ((this.mMemoryCache == null) || (this.mMemoryCache.get(paramString) != null)) {
      return;
    }
    this.mMemoryCache.put(paramString, paramBitmap);
  }
  
  /* Error */
  public void addBitmapToDiskCache(String paramString, Bitmap paramBitmap)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +7 -> 8
    //   4: aload_2
    //   5: ifnonnull +4 -> 9
    //   8: return
    //   9: aload_0
    //   10: getfield 56	com/tencent/qqmail/qmimagecache/ImageCache:mDiskCacheLock	Ljava/lang/Object;
    //   13: astore 8
    //   15: aload 8
    //   17: monitorenter
    //   18: aload_0
    //   19: getfield 127	com/tencent/qqmail/qmimagecache/ImageCache:mDiskLruCache	Lcom/tencent/qqmail/qmimagecache/DiskLruCache;
    //   22: astore_3
    //   23: aload_3
    //   24: ifnull +125 -> 149
    //   27: aconst_null
    //   28: astore 5
    //   30: aconst_null
    //   31: astore 6
    //   33: aconst_null
    //   34: astore 7
    //   36: aload 5
    //   38: astore_3
    //   39: aload 6
    //   41: astore 4
    //   43: aload_0
    //   44: getfield 127	com/tencent/qqmail/qmimagecache/ImageCache:mDiskLruCache	Lcom/tencent/qqmail/qmimagecache/DiskLruCache;
    //   47: aload_1
    //   48: invokevirtual 132	com/tencent/qqmail/qmimagecache/DiskLruCache:get	(Ljava/lang/String;)Lcom/tencent/qqmail/qmimagecache/DiskLruCache$Snapshot;
    //   51: astore 9
    //   53: aload 9
    //   55: ifnonnull +104 -> 159
    //   58: aload 5
    //   60: astore_3
    //   61: aload 6
    //   63: astore 4
    //   65: aload_0
    //   66: getfield 127	com/tencent/qqmail/qmimagecache/ImageCache:mDiskLruCache	Lcom/tencent/qqmail/qmimagecache/DiskLruCache;
    //   69: aload_1
    //   70: invokevirtual 136	com/tencent/qqmail/qmimagecache/DiskLruCache:edit	(Ljava/lang/String;)Lcom/tencent/qqmail/qmimagecache/DiskLruCache$Editor;
    //   73: astore 9
    //   75: aload 7
    //   77: astore_1
    //   78: aload 9
    //   80: ifnull +61 -> 141
    //   83: aload 5
    //   85: astore_3
    //   86: aload 6
    //   88: astore 4
    //   90: aload 9
    //   92: iconst_0
    //   93: invokevirtual 142	com/tencent/qqmail/qmimagecache/DiskLruCache$Editor:newOutputStream	(I)Ljava/io/OutputStream;
    //   96: astore_1
    //   97: aload_1
    //   98: astore_3
    //   99: aload_1
    //   100: astore 4
    //   102: aload_2
    //   103: aload_0
    //   104: getfield 89	com/tencent/qqmail/qmimagecache/ImageCache:mCacheParams	Lcom/tencent/qqmail/qmimagecache/ImageCache$ImageCacheParams;
    //   107: getfield 145	com/tencent/qqmail/qmimagecache/ImageCache$ImageCacheParams:compressFormat	Landroid/graphics/Bitmap$CompressFormat;
    //   110: aload_0
    //   111: getfield 89	com/tencent/qqmail/qmimagecache/ImageCache:mCacheParams	Lcom/tencent/qqmail/qmimagecache/ImageCache$ImageCacheParams;
    //   114: getfield 148	com/tencent/qqmail/qmimagecache/ImageCache$ImageCacheParams:compressQuality	I
    //   117: aload_1
    //   118: invokevirtual 152	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   121: pop
    //   122: aload_1
    //   123: astore_3
    //   124: aload_1
    //   125: astore 4
    //   127: aload 9
    //   129: invokevirtual 155	com/tencent/qqmail/qmimagecache/DiskLruCache$Editor:commit	()V
    //   132: aload_1
    //   133: astore_3
    //   134: aload_1
    //   135: astore 4
    //   137: aload_1
    //   138: invokevirtual 160	java/io/OutputStream:close	()V
    //   141: aload_1
    //   142: ifnull +7 -> 149
    //   145: aload_1
    //   146: invokevirtual 160	java/io/OutputStream:close	()V
    //   149: aload 8
    //   151: monitorexit
    //   152: return
    //   153: astore_1
    //   154: aload 8
    //   156: monitorexit
    //   157: aload_1
    //   158: athrow
    //   159: aload 5
    //   161: astore_3
    //   162: aload 6
    //   164: astore 4
    //   166: aload 9
    //   168: iconst_0
    //   169: invokevirtual 166	com/tencent/qqmail/qmimagecache/DiskLruCache$Snapshot:getInputStream	(I)Ljava/io/InputStream;
    //   172: invokevirtual 169	java/io/InputStream:close	()V
    //   175: aload 7
    //   177: astore_1
    //   178: goto -37 -> 141
    //   181: astore_1
    //   182: aload_3
    //   183: ifnull -34 -> 149
    //   186: aload_3
    //   187: invokevirtual 160	java/io/OutputStream:close	()V
    //   190: goto -41 -> 149
    //   193: astore_1
    //   194: goto -45 -> 149
    //   197: astore_1
    //   198: aload 4
    //   200: ifnull -51 -> 149
    //   203: aload 4
    //   205: invokevirtual 160	java/io/OutputStream:close	()V
    //   208: goto -59 -> 149
    //   211: astore_1
    //   212: goto -63 -> 149
    //   215: astore_1
    //   216: aconst_null
    //   217: astore_2
    //   218: aload_2
    //   219: ifnull +7 -> 226
    //   222: aload_2
    //   223: invokevirtual 160	java/io/OutputStream:close	()V
    //   226: aload_1
    //   227: athrow
    //   228: astore_1
    //   229: goto -80 -> 149
    //   232: astore_2
    //   233: goto -7 -> 226
    //   236: astore_3
    //   237: aload_1
    //   238: astore_2
    //   239: aload_3
    //   240: astore_1
    //   241: goto -23 -> 218
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	244	0	this	ImageCache
    //   0	244	1	paramString	String
    //   0	244	2	paramBitmap	Bitmap
    //   22	165	3	localObject1	Object
    //   236	4	3	localObject2	Object
    //   41	163	4	localObject3	Object
    //   28	132	5	localObject4	Object
    //   31	132	6	localObject5	Object
    //   34	142	7	localObject6	Object
    //   13	142	8	localObject7	Object
    //   51	116	9	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   18	23	153	finally
    //   145	149	153	finally
    //   149	152	153	finally
    //   154	157	153	finally
    //   186	190	153	finally
    //   203	208	153	finally
    //   222	226	153	finally
    //   226	228	153	finally
    //   43	53	181	java/io/IOException
    //   65	75	181	java/io/IOException
    //   90	97	181	java/io/IOException
    //   102	122	181	java/io/IOException
    //   127	132	181	java/io/IOException
    //   137	141	181	java/io/IOException
    //   166	175	181	java/io/IOException
    //   186	190	193	java/io/IOException
    //   43	53	197	java/lang/Exception
    //   65	75	197	java/lang/Exception
    //   90	97	197	java/lang/Exception
    //   102	122	197	java/lang/Exception
    //   127	132	197	java/lang/Exception
    //   137	141	197	java/lang/Exception
    //   166	175	197	java/lang/Exception
    //   203	208	211	java/io/IOException
    //   43	53	215	finally
    //   65	75	215	finally
    //   90	97	215	finally
    //   166	175	215	finally
    //   145	149	228	java/io/IOException
    //   222	226	232	java/io/IOException
    //   102	122	236	finally
    //   127	132	236	finally
    //   137	141	236	finally
  }
  
  public void clearCache()
  {
    if (this.mMemoryCache != null) {
      this.mMemoryCache.evictAll();
    }
    synchronized (this.mDiskCacheLock)
    {
      this.mDiskCacheStarting = true;
      if (this.mDiskLruCache != null)
      {
        boolean bool = this.mDiskLruCache.isClosed();
        if (bool) {}
      }
      try
      {
        this.mDiskLruCache.delete();
        this.mDiskLruCache = null;
        initDiskCache();
        return;
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          Log.e("ImageCache", "clearCache - " + localIOException);
        }
      }
    }
  }
  
  public void clearMemoryCache()
  {
    if (this.mMemoryCache != null) {
      this.mMemoryCache.evictAll();
    }
  }
  
  public void close()
  {
    synchronized (this.mDiskCacheLock)
    {
      DiskLruCache localDiskLruCache = this.mDiskLruCache;
      if (localDiskLruCache != null) {}
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
        for (;;)
        {
          Log.e("ImageCache", "close - " + localIOException);
        }
      }
    }
  }
  
  public void flush()
  {
    synchronized (this.mDiskCacheLock)
    {
      DiskLruCache localDiskLruCache = this.mDiskLruCache;
      if (localDiskLruCache != null) {}
      try
      {
        this.mDiskLruCache.flush();
        return;
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          Log.e("ImageCache", "flush - " + localIOException);
        }
      }
    }
  }
  
  /* Error */
  public Bitmap getBitmapFromDiskCache(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 56	com/tencent/qqmail/qmimagecache/ImageCache:mDiskCacheLock	Ljava/lang/Object;
    //   4: astore 6
    //   6: aload 6
    //   8: monitorenter
    //   9: aload_0
    //   10: getfield 58	com/tencent/qqmail/qmimagecache/ImageCache:mDiskCacheStarting	Z
    //   13: istore_3
    //   14: iload_3
    //   15: ifeq +18 -> 33
    //   18: aload_0
    //   19: getfield 56	com/tencent/qqmail/qmimagecache/ImageCache:mDiskCacheLock	Ljava/lang/Object;
    //   22: invokevirtual 220	java/lang/Object:wait	()V
    //   25: goto -16 -> 9
    //   28: astore 4
    //   30: goto -21 -> 9
    //   33: aload_0
    //   34: getfield 127	com/tencent/qqmail/qmimagecache/ImageCache:mDiskLruCache	Lcom/tencent/qqmail/qmimagecache/DiskLruCache;
    //   37: ifnull +58 -> 95
    //   40: new 222	android/graphics/Rect
    //   43: dup
    //   44: iconst_m1
    //   45: iconst_m1
    //   46: iconst_m1
    //   47: iconst_m1
    //   48: invokespecial 225	android/graphics/Rect:<init>	(IIII)V
    //   51: astore 7
    //   53: new 69	android/graphics/BitmapFactory$Options
    //   56: dup
    //   57: invokespecial 226	android/graphics/BitmapFactory$Options:<init>	()V
    //   60: astore 8
    //   62: iconst_1
    //   63: istore_2
    //   64: iload_2
    //   65: bipush 32
    //   67: if_icmpgt +225 -> 292
    //   70: aload_0
    //   71: getfield 127	com/tencent/qqmail/qmimagecache/ImageCache:mDiskLruCache	Lcom/tencent/qqmail/qmimagecache/DiskLruCache;
    //   74: aload_1
    //   75: invokevirtual 132	com/tencent/qqmail/qmimagecache/DiskLruCache:get	(Ljava/lang/String;)Lcom/tencent/qqmail/qmimagecache/DiskLruCache$Snapshot;
    //   78: astore 4
    //   80: aload 4
    //   82: ifnonnull +18 -> 100
    //   85: aload 4
    //   87: ifnull +8 -> 95
    //   90: aload 4
    //   92: invokevirtual 227	com/tencent/qqmail/qmimagecache/DiskLruCache$Snapshot:close	()V
    //   95: aload 6
    //   97: monitorexit
    //   98: aconst_null
    //   99: areturn
    //   100: aload 4
    //   102: astore 5
    //   104: aload 4
    //   106: iconst_0
    //   107: invokevirtual 166	com/tencent/qqmail/qmimagecache/DiskLruCache$Snapshot:getInputStream	(I)Ljava/io/InputStream;
    //   110: astore 9
    //   112: aload 4
    //   114: astore 5
    //   116: aload 8
    //   118: iload_2
    //   119: putfield 75	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   122: aload 9
    //   124: aload 7
    //   126: aload 8
    //   128: invokestatic 233	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   131: astore 9
    //   133: aload 4
    //   135: astore 5
    //   137: aload 4
    //   139: invokevirtual 227	com/tencent/qqmail/qmimagecache/DiskLruCache$Snapshot:close	()V
    //   142: iconst_0
    //   143: ifeq +11 -> 154
    //   146: new 235	java/lang/NullPointerException
    //   149: dup
    //   150: invokespecial 236	java/lang/NullPointerException:<init>	()V
    //   153: athrow
    //   154: aload 6
    //   156: monitorexit
    //   157: aload 9
    //   159: areturn
    //   160: astore_1
    //   161: aload 6
    //   163: monitorexit
    //   164: aload_1
    //   165: athrow
    //   166: astore 5
    //   168: bipush 6
    //   170: ldc 28
    //   172: new 182	java/lang/StringBuilder
    //   175: dup
    //   176: invokespecial 183	java/lang/StringBuilder:<init>	()V
    //   179: ldc 238
    //   181: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: aload_1
    //   185: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: invokevirtual 196	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   191: invokestatic 244	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   194: aload 4
    //   196: astore 5
    //   198: aload 4
    //   200: invokevirtual 227	com/tencent/qqmail/qmimagecache/DiskLruCache$Snapshot:close	()V
    //   203: iload_2
    //   204: iconst_1
    //   205: iadd
    //   206: istore_2
    //   207: goto -143 -> 64
    //   210: astore_1
    //   211: aload 4
    //   213: astore 5
    //   215: aload 4
    //   217: invokevirtual 227	com/tencent/qqmail/qmimagecache/DiskLruCache$Snapshot:close	()V
    //   220: aload_1
    //   221: athrow
    //   222: astore_1
    //   223: aconst_null
    //   224: astore 4
    //   226: aload 4
    //   228: astore 5
    //   230: bipush 6
    //   232: ldc 28
    //   234: new 182	java/lang/StringBuilder
    //   237: dup
    //   238: invokespecial 183	java/lang/StringBuilder:<init>	()V
    //   241: ldc 246
    //   243: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: aload_1
    //   247: invokevirtual 249	java/io/IOException:getMessage	()Ljava/lang/String;
    //   250: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: invokevirtual 196	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   256: invokestatic 244	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   259: aload 4
    //   261: ifnull -166 -> 95
    //   264: aload 4
    //   266: invokevirtual 227	com/tencent/qqmail/qmimagecache/DiskLruCache$Snapshot:close	()V
    //   269: goto -174 -> 95
    //   272: aload 5
    //   274: ifnull +8 -> 282
    //   277: aload 5
    //   279: invokevirtual 227	com/tencent/qqmail/qmimagecache/DiskLruCache$Snapshot:close	()V
    //   282: aload_1
    //   283: athrow
    //   284: astore_1
    //   285: goto -13 -> 272
    //   288: astore_1
    //   289: goto -63 -> 226
    //   292: aconst_null
    //   293: astore 4
    //   295: goto -210 -> 85
    //   298: astore_1
    //   299: aconst_null
    //   300: astore 5
    //   302: goto -30 -> 272
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	305	0	this	ImageCache
    //   0	305	1	paramString	String
    //   63	144	2	i	int
    //   13	2	3	bool	boolean
    //   28	1	4	localInterruptedException	java.lang.InterruptedException
    //   78	216	4	localSnapshot1	DiskLruCache.Snapshot
    //   102	34	5	localSnapshot2	DiskLruCache.Snapshot
    //   166	1	5	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   196	105	5	localSnapshot3	DiskLruCache.Snapshot
    //   4	158	6	localObject1	Object
    //   51	74	7	localRect	android.graphics.Rect
    //   60	67	8	localOptions	BitmapFactory.Options
    //   110	48	9	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   18	25	28	java/lang/InterruptedException
    //   9	14	160	finally
    //   18	25	160	finally
    //   33	62	160	finally
    //   90	95	160	finally
    //   95	98	160	finally
    //   146	154	160	finally
    //   154	157	160	finally
    //   161	164	160	finally
    //   264	269	160	finally
    //   277	282	160	finally
    //   282	284	160	finally
    //   122	133	166	java/lang/OutOfMemoryError
    //   122	133	210	finally
    //   168	194	210	finally
    //   70	80	222	java/io/IOException
    //   220	222	222	java/io/IOException
    //   104	112	284	finally
    //   116	122	284	finally
    //   137	142	284	finally
    //   198	203	284	finally
    //   215	220	284	finally
    //   230	259	284	finally
    //   104	112	288	java/io/IOException
    //   116	122	288	java/io/IOException
    //   137	142	288	java/io/IOException
    //   198	203	288	java/io/IOException
    //   215	220	288	java/io/IOException
    //   70	80	298	finally
    //   220	222	298	finally
  }
  
  public Bitmap getBitmapFromMemCache(String paramString)
  {
    if (this.mMemoryCache != null)
    {
      paramString = (Bitmap)this.mMemoryCache.get(paramString);
      if (paramString != null) {
        return paramString;
      }
    }
    return null;
  }
  
  protected Bitmap getBitmapFromReusableSet(BitmapFactory.Options paramOptions)
  {
    if ((this.mReusableBitmaps != null) && (!this.mReusableBitmaps.isEmpty()))
    {
      Iterator localIterator = this.mReusableBitmaps.iterator();
      while (localIterator.hasNext())
      {
        Bitmap localBitmap = (Bitmap)((SoftReference)localIterator.next()).get();
        if ((localBitmap != null) && (localBitmap.isMutable()))
        {
          if (canUseForInBitmap(localBitmap, paramOptions))
          {
            localIterator.remove();
            return localBitmap;
          }
        }
        else {
          localIterator.remove();
        }
      }
    }
    return null;
  }
  
  public File getDiskCacheDir()
  {
    return this.mCacheParams.diskCacheDir;
  }
  
  public String getDiskCacheFilePath(String arg1)
  {
    String str = StringExtention.hashKeyForDisk(???);
    synchronized (this.mDiskCacheLock)
    {
      if (this.mDiskLruCache != null)
      {
        str = this.mDiskLruCache.getFilePath(str);
        return str;
      }
      return "";
    }
  }
  
  public String getDiskCacheFilePathByKey(String paramString)
  {
    synchronized (this.mDiskCacheLock)
    {
      if (this.mDiskLruCache != null)
      {
        paramString = this.mDiskLruCache.getFilePath(paramString);
        return paramString;
      }
      return "";
    }
  }
  
  public DiskLruCache getDiskLruCache()
  {
    if (this.mDiskLruCache == null) {
      initDiskCache();
    }
    return this.mDiskLruCache;
  }
  
  public void initDiskCache()
  {
    synchronized (this.mDiskCacheLock)
    {
      File localFile;
      if ((this.mDiskLruCache == null) || (this.mDiskLruCache.isClosed()))
      {
        localFile = this.mCacheParams.diskCacheDir;
        if ((this.mCacheParams.diskCacheEnabled) && (localFile != null))
        {
          FileUtil.tryMkdirs(localFile);
          QMLog.log(4, "ImageCache", "ImageCache getUsableSpace: " + FileUtil.getUsableSpace(localFile) + ", " + this.mCacheParams.diskCacheSize);
        }
      }
      try
      {
        this.mDiskLruCache = DiskLruCache.open(localFile, 1, 1, this.mCacheParams.diskCacheSize);
        this.mDiskCacheStarting = false;
        this.mDiskCacheLock.notifyAll();
        return;
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          this.mCacheParams.diskCacheDir = null;
        }
      }
    }
  }
  
  public boolean isExistInDiskWithKey(String paramString)
  {
    synchronized (this.mDiskCacheLock)
    {
      if (this.mDiskLruCache != null)
      {
        boolean bool = this.mDiskLruCache.isExist(paramString);
        return bool;
      }
      return false;
    }
  }
  
  public void removeDiskCache(String paramString)
  {
    synchronized (this.mDiskCacheLock)
    {
      DiskLruCache localDiskLruCache = this.mDiskLruCache;
      if (localDiskLruCache != null) {}
      try
      {
        this.mDiskLruCache.remove(paramString);
        return;
      }
      catch (IOException paramString)
      {
        for (;;)
        {
          paramString.printStackTrace();
        }
      }
    }
  }
  
  public void removeMemoryCache(String paramString)
  {
    if (this.mMemoryCache != null) {
      this.mMemoryCache.remove(paramString);
    }
  }
  
  public static class ImageCacheParams
  {
    public boolean clearDiskCacheOnStart = false;
    public Bitmap.CompressFormat compressFormat = ImageCache.DEFAULT_COMPRESS_FORMAT;
    public int compressQuality = 70;
    public File diskCacheDir;
    public boolean diskCacheEnabled = true;
    public int diskCacheSize = 314572800;
    public boolean initDiskCacheOnCreate = false;
    public int memCacheSize = 20480;
    public boolean memoryCacheEnabled = true;
    
    public ImageCacheParams()
    {
      String str = FileUtil.getThumbImageCacheDir();
      if (!StringExtention.isNullOrEmpty(str)) {
        this.diskCacheDir = new File(str);
      }
      QMLog.log(4, "ImageCache", "image cache dir:" + this.diskCacheDir + ",size:" + this.diskCacheSize);
    }
    
    public ImageCacheParams(File paramFile)
    {
      this.diskCacheDir = paramFile;
    }
    
    public void setMemCacheSizePercent(float paramFloat)
    {
      if ((paramFloat < 0.05F) || (paramFloat > 0.8F)) {
        throw new IllegalArgumentException("setMemCacheSizePercent - percent must be between 0.05 and 0.8 (inclusive)");
      }
      this.memCacheSize = Math.round((float)Runtime.getRuntime().maxMemory() * paramFloat / 1024.0F);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.qmimagecache.ImageCache
 * JD-Core Version:    0.7.0.1
 */