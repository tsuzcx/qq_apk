package com.tencent.qqmail.qmimagecache;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import android.util.Log;
import android.util.LruCache;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXFragment;
import com.tencent.qqmail.utilities.QMPathManager;
import com.tencent.qqmail.utilities.fileextention.FileUtil;
import com.tencent.qqmail.utilities.log.QMLog;
import java.io.File;
import java.io.IOException;
import java.lang.ref.SoftReference;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashSet;
import java.util.Iterator;
import moai.core.utilities.Utils;

public class ImageDrawableCache
{
  private static final boolean DEFAULT_CLEAR_DISK_CACHE_ON_START = false;
  private static final Bitmap.CompressFormat DEFAULT_COMPRESS_FORMAT = Bitmap.CompressFormat.JPEG;
  private static final int DEFAULT_COMPRESS_QUALITY = 70;
  private static final boolean DEFAULT_DISK_CACHE_ENABLED = true;
  private static final int DEFAULT_DISK_CACHE_SIZE = 31457280;
  private static final boolean DEFAULT_INIT_DISK_CACHE_ON_CREATE = false;
  private static final boolean DEFAULT_MEM_CACHE_ENABLED = true;
  private static final int DEFAULT_MEM_CACHE_SIZE = 20480;
  private static final int DISK_CACHE_INDEX = 0;
  private static final String TAG = "ImageCache";
  private ImageCacheParams mCacheParams;
  private final Object mDiskCacheLock = new Object();
  private boolean mDiskCacheStarting = true;
  private DiskLruCache mDiskLruCache;
  private LruCache<String, BitmapDrawable> mMemoryCache;
  private HashSet<SoftReference<Bitmap>> mReusableBitmaps;
  
  public ImageDrawableCache(Context paramContext, String paramString)
  {
    init(new ImageCacheParams(paramContext, paramString));
  }
  
  public ImageDrawableCache(ImageCacheParams paramImageCacheParams)
  {
    init(paramImageCacheParams);
  }
  
  private static String bytesToHexString(byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      String str = Integer.toHexString(paramArrayOfByte[i] & 0xFF);
      if (str.length() == 1) {
        localStringBuilder.append('0');
      }
      localStringBuilder.append(str);
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  private static boolean canUseForInBitmap(Bitmap paramBitmap, BitmapFactory.Options paramOptions)
  {
    int i = paramOptions.outWidth / paramOptions.inSampleSize;
    int j = paramOptions.outHeight / paramOptions.inSampleSize;
    return (paramBitmap.getWidth() == i) && (paramBitmap.getHeight() == j);
  }
  
  public static RetainFragment findOrCreateRetainFragment(FragmentManager paramFragmentManager)
  {
    RetainFragment localRetainFragment2 = (RetainFragment)paramFragmentManager.findFragmentByTag("ImageCache");
    RetainFragment localRetainFragment1 = localRetainFragment2;
    if (localRetainFragment2 == null)
    {
      localRetainFragment1 = new RetainFragment();
      paramFragmentManager.beginTransaction().add(localRetainFragment1, "ImageCache").commitAllowingStateLoss();
    }
    return localRetainFragment1;
  }
  
  @TargetApi(12)
  public static int getBitmapSize(BitmapDrawable paramBitmapDrawable)
  {
    paramBitmapDrawable = paramBitmapDrawable.getBitmap();
    if (Utils.hasHoneycombMR1()) {
      return paramBitmapDrawable.getByteCount();
    }
    int i = paramBitmapDrawable.getRowBytes();
    return paramBitmapDrawable.getHeight() * i;
  }
  
  public static File getDiskCacheDir(Context paramContext, String paramString)
  {
    if (("mounted".equals(Environment.getExternalStorageState())) || (!isExternalStorageRemovable())) {}
    for (paramContext = getExternalCacheDir().getPath();; paramContext = paramContext.getCacheDir().getPath()) {
      return new File(paramContext + File.separator + paramString);
    }
  }
  
  @TargetApi(8)
  public static File getExternalCacheDir()
  {
    return new File(QMPathManager.sharedInstance().getQQMailDir());
  }
  
  public static ImageDrawableCache getInstance(FragmentManager paramFragmentManager, ImageCacheParams paramImageCacheParams)
  {
    RetainFragment localRetainFragment = findOrCreateRetainFragment(paramFragmentManager);
    ImageDrawableCache localImageDrawableCache = (ImageDrawableCache)localRetainFragment.getObject();
    paramFragmentManager = localImageDrawableCache;
    if (localImageDrawableCache == null)
    {
      paramFragmentManager = new ImageDrawableCache(paramImageCacheParams);
      localRetainFragment.setObject(paramFragmentManager);
    }
    return paramFragmentManager;
  }
  
  @TargetApi(9)
  public static long getUsableSpace(File paramFile)
  {
    if (Utils.hasGingerbread()) {
      return paramFile.getUsableSpace();
    }
    try
    {
      paramFile = new StatFs(paramFile.getPath());
      long l = paramFile.getBlockSize();
      int i = paramFile.getAvailableBlocks();
      return i * l;
    }
    catch (Exception paramFile)
    {
      QMLog.log(6, "ImageCache", "getUsableSpace error " + paramFile.getMessage());
    }
    return 0L;
  }
  
  public static String hashKeyForDisk(String paramString)
  {
    try
    {
      Object localObject = MessageDigest.getInstance("MD5");
      ((MessageDigest)localObject).update(paramString.getBytes());
      localObject = bytesToHexString(((MessageDigest)localObject).digest());
      return localObject;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException) {}
    return String.valueOf(paramString.hashCode());
  }
  
  private void init(ImageCacheParams paramImageCacheParams)
  {
    this.mCacheParams = paramImageCacheParams;
    if (this.mCacheParams.memoryCacheEnabled)
    {
      if (Utils.hasHoneycomb()) {
        this.mReusableBitmaps = new HashSet();
      }
      this.mMemoryCache = new ImageDrawableCache.1(this, this.mCacheParams.memCacheSize);
    }
    if (paramImageCacheParams.initDiskCacheOnCreate) {
      initDiskCache();
    }
  }
  
  @TargetApi(9)
  public static boolean isExternalStorageRemovable()
  {
    if (Utils.hasGingerbread()) {
      return Environment.isExternalStorageRemovable();
    }
    return true;
  }
  
  /* Error */
  public void addBitmapToCache(String paramString, BitmapDrawable paramBitmapDrawable)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +7 -> 8
    //   4: aload_2
    //   5: ifnonnull +4 -> 9
    //   8: return
    //   9: aload_0
    //   10: getfield 311	com/tencent/qqmail/qmimagecache/ImageDrawableCache:mMemoryCache	Landroid/util/LruCache;
    //   13: ifnull +31 -> 44
    //   16: ldc_w 324
    //   19: aload_2
    //   20: invokevirtual 329	java/lang/Class:isInstance	(Ljava/lang/Object;)Z
    //   23: ifeq +11 -> 34
    //   26: aload_2
    //   27: checkcast 324	com/tencent/qqmail/qmimagecache/RecyclingBitmapDrawable
    //   30: iconst_1
    //   31: invokevirtual 333	com/tencent/qqmail/qmimagecache/RecyclingBitmapDrawable:setIsCached	(Z)V
    //   34: aload_0
    //   35: getfield 311	com/tencent/qqmail/qmimagecache/ImageDrawableCache:mMemoryCache	Landroid/util/LruCache;
    //   38: aload_1
    //   39: aload_2
    //   40: invokevirtual 339	android/util/LruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   43: pop
    //   44: aload_0
    //   45: getfield 60	com/tencent/qqmail/qmimagecache/ImageDrawableCache:mDiskCacheLock	Ljava/lang/Object;
    //   48: astore 4
    //   50: aload 4
    //   52: monitorenter
    //   53: aload_0
    //   54: getfield 341	com/tencent/qqmail/qmimagecache/ImageDrawableCache:mDiskLruCache	Lcom/tencent/qqmail/qmimagecache/DiskLruCache;
    //   57: ifnull +83 -> 140
    //   60: aload_1
    //   61: invokestatic 343	com/tencent/qqmail/qmimagecache/ImageDrawableCache:hashKeyForDisk	(Ljava/lang/String;)Ljava/lang/String;
    //   64: astore_3
    //   65: aconst_null
    //   66: astore_1
    //   67: aload_0
    //   68: getfield 341	com/tencent/qqmail/qmimagecache/ImageDrawableCache:mDiskLruCache	Lcom/tencent/qqmail/qmimagecache/DiskLruCache;
    //   71: aload_3
    //   72: invokevirtual 349	com/tencent/qqmail/qmimagecache/DiskLruCache:get	(Ljava/lang/String;)Lcom/tencent/qqmail/qmimagecache/DiskLruCache$Snapshot;
    //   75: astore 5
    //   77: aload 5
    //   79: ifnonnull +71 -> 150
    //   82: aload_0
    //   83: getfield 341	com/tencent/qqmail/qmimagecache/ImageDrawableCache:mDiskLruCache	Lcom/tencent/qqmail/qmimagecache/DiskLruCache;
    //   86: aload_3
    //   87: invokevirtual 353	com/tencent/qqmail/qmimagecache/DiskLruCache:edit	(Ljava/lang/String;)Lcom/tencent/qqmail/qmimagecache/DiskLruCache$Editor;
    //   90: astore_3
    //   91: aload_3
    //   92: ifnull +40 -> 132
    //   95: aload_3
    //   96: iconst_0
    //   97: invokevirtual 359	com/tencent/qqmail/qmimagecache/DiskLruCache$Editor:newOutputStream	(I)Ljava/io/OutputStream;
    //   100: astore_1
    //   101: aload_2
    //   102: invokevirtual 156	android/graphics/drawable/BitmapDrawable:getBitmap	()Landroid/graphics/Bitmap;
    //   105: aload_0
    //   106: getfield 292	com/tencent/qqmail/qmimagecache/ImageDrawableCache:mCacheParams	Lcom/tencent/qqmail/qmimagecache/ImageDrawableCache$ImageCacheParams;
    //   109: getfield 362	com/tencent/qqmail/qmimagecache/ImageDrawableCache$ImageCacheParams:compressFormat	Landroid/graphics/Bitmap$CompressFormat;
    //   112: aload_0
    //   113: getfield 292	com/tencent/qqmail/qmimagecache/ImageDrawableCache:mCacheParams	Lcom/tencent/qqmail/qmimagecache/ImageDrawableCache$ImageCacheParams;
    //   116: getfield 365	com/tencent/qqmail/qmimagecache/ImageDrawableCache$ImageCacheParams:compressQuality	I
    //   119: aload_1
    //   120: invokevirtual 369	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   123: pop
    //   124: aload_3
    //   125: invokevirtual 372	com/tencent/qqmail/qmimagecache/DiskLruCache$Editor:commit	()V
    //   128: aload_1
    //   129: invokevirtual 377	java/io/OutputStream:close	()V
    //   132: aload_1
    //   133: ifnull +7 -> 140
    //   136: aload_1
    //   137: invokevirtual 377	java/io/OutputStream:close	()V
    //   140: aload 4
    //   142: monitorexit
    //   143: return
    //   144: astore_1
    //   145: aload 4
    //   147: monitorexit
    //   148: aload_1
    //   149: athrow
    //   150: aload 5
    //   152: iconst_0
    //   153: invokevirtual 383	com/tencent/qqmail/qmimagecache/DiskLruCache$Snapshot:getInputStream	(I)Ljava/io/InputStream;
    //   156: invokevirtual 386	java/io/InputStream:close	()V
    //   159: goto -27 -> 132
    //   162: astore_3
    //   163: aconst_null
    //   164: astore_2
    //   165: aload_2
    //   166: astore_1
    //   167: ldc 31
    //   169: new 78	java/lang/StringBuilder
    //   172: dup
    //   173: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   176: ldc_w 388
    //   179: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: aload_3
    //   183: invokevirtual 391	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   186: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   189: invokestatic 397	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   192: pop
    //   193: aload_2
    //   194: ifnull -54 -> 140
    //   197: aload_2
    //   198: invokevirtual 377	java/io/OutputStream:close	()V
    //   201: goto -61 -> 140
    //   204: astore_1
    //   205: goto -65 -> 140
    //   208: astore_3
    //   209: aconst_null
    //   210: astore_2
    //   211: aload_2
    //   212: astore_1
    //   213: ldc 31
    //   215: new 78	java/lang/StringBuilder
    //   218: dup
    //   219: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   222: ldc_w 388
    //   225: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   228: aload_3
    //   229: invokevirtual 391	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   232: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   235: invokestatic 397	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   238: pop
    //   239: aload_2
    //   240: ifnull -100 -> 140
    //   243: aload_2
    //   244: invokevirtual 377	java/io/OutputStream:close	()V
    //   247: goto -107 -> 140
    //   250: astore_1
    //   251: goto -111 -> 140
    //   254: astore_2
    //   255: aconst_null
    //   256: astore_1
    //   257: aload_1
    //   258: ifnull +7 -> 265
    //   261: aload_1
    //   262: invokevirtual 377	java/io/OutputStream:close	()V
    //   265: aload_2
    //   266: athrow
    //   267: astore_1
    //   268: goto -128 -> 140
    //   271: astore_1
    //   272: goto -7 -> 265
    //   275: astore_2
    //   276: goto -19 -> 257
    //   279: astore_2
    //   280: goto -23 -> 257
    //   283: astore_3
    //   284: aload_1
    //   285: astore_2
    //   286: goto -75 -> 211
    //   289: astore_3
    //   290: aload_1
    //   291: astore_2
    //   292: goto -127 -> 165
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	295	0	this	ImageDrawableCache
    //   0	295	1	paramString	String
    //   0	295	2	paramBitmapDrawable	BitmapDrawable
    //   64	61	3	localObject1	Object
    //   162	21	3	localIOException1	IOException
    //   208	21	3	localException1	Exception
    //   283	1	3	localException2	Exception
    //   289	1	3	localIOException2	IOException
    //   48	98	4	localObject2	Object
    //   75	76	5	localSnapshot	DiskLruCache.Snapshot
    // Exception table:
    //   from	to	target	type
    //   53	65	144	finally
    //   136	140	144	finally
    //   140	143	144	finally
    //   145	148	144	finally
    //   197	201	144	finally
    //   243	247	144	finally
    //   261	265	144	finally
    //   265	267	144	finally
    //   67	77	162	java/io/IOException
    //   82	91	162	java/io/IOException
    //   95	101	162	java/io/IOException
    //   150	159	162	java/io/IOException
    //   197	201	204	java/io/IOException
    //   67	77	208	java/lang/Exception
    //   82	91	208	java/lang/Exception
    //   95	101	208	java/lang/Exception
    //   150	159	208	java/lang/Exception
    //   243	247	250	java/io/IOException
    //   67	77	254	finally
    //   82	91	254	finally
    //   95	101	254	finally
    //   150	159	254	finally
    //   136	140	267	java/io/IOException
    //   261	265	271	java/io/IOException
    //   101	132	275	finally
    //   167	193	279	finally
    //   213	239	279	finally
    //   101	132	283	java/lang/Exception
    //   101	132	289	java/io/IOException
  }
  
  /* Error */
  public void addBitmapToDisk(String paramString, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +7 -> 8
    //   4: aload_2
    //   5: ifnonnull +4 -> 9
    //   8: return
    //   9: aload_0
    //   10: getfield 60	com/tencent/qqmail/qmimagecache/ImageDrawableCache:mDiskCacheLock	Ljava/lang/Object;
    //   13: astore 5
    //   15: aload 5
    //   17: monitorenter
    //   18: aload_0
    //   19: getfield 62	com/tencent/qqmail/qmimagecache/ImageDrawableCache:mDiskCacheStarting	Z
    //   22: istore_3
    //   23: iload_3
    //   24: ifeq +18 -> 42
    //   27: aload_0
    //   28: getfield 60	com/tencent/qqmail/qmimagecache/ImageDrawableCache:mDiskCacheLock	Ljava/lang/Object;
    //   31: invokevirtual 404	java/lang/Object:wait	()V
    //   34: goto -16 -> 18
    //   37: astore 4
    //   39: goto -21 -> 18
    //   42: aload_0
    //   43: getfield 341	com/tencent/qqmail/qmimagecache/ImageDrawableCache:mDiskLruCache	Lcom/tencent/qqmail/qmimagecache/DiskLruCache;
    //   46: ifnull +68 -> 114
    //   49: aload_1
    //   50: invokestatic 343	com/tencent/qqmail/qmimagecache/ImageDrawableCache:hashKeyForDisk	(Ljava/lang/String;)Ljava/lang/String;
    //   53: astore 4
    //   55: aconst_null
    //   56: astore_1
    //   57: aload_0
    //   58: getfield 341	com/tencent/qqmail/qmimagecache/ImageDrawableCache:mDiskLruCache	Lcom/tencent/qqmail/qmimagecache/DiskLruCache;
    //   61: aload 4
    //   63: invokevirtual 349	com/tencent/qqmail/qmimagecache/DiskLruCache:get	(Ljava/lang/String;)Lcom/tencent/qqmail/qmimagecache/DiskLruCache$Snapshot;
    //   66: astore 6
    //   68: aload 6
    //   70: ifnonnull +54 -> 124
    //   73: aload_0
    //   74: getfield 341	com/tencent/qqmail/qmimagecache/ImageDrawableCache:mDiskLruCache	Lcom/tencent/qqmail/qmimagecache/DiskLruCache;
    //   77: aload 4
    //   79: invokevirtual 353	com/tencent/qqmail/qmimagecache/DiskLruCache:edit	(Ljava/lang/String;)Lcom/tencent/qqmail/qmimagecache/DiskLruCache$Editor;
    //   82: astore 4
    //   84: aload 4
    //   86: ifnull +20 -> 106
    //   89: aload 4
    //   91: iconst_0
    //   92: invokevirtual 359	com/tencent/qqmail/qmimagecache/DiskLruCache$Editor:newOutputStream	(I)Ljava/io/OutputStream;
    //   95: astore_1
    //   96: aload_1
    //   97: aload_2
    //   98: invokevirtual 407	java/io/OutputStream:write	([B)V
    //   101: aload 4
    //   103: invokevirtual 372	com/tencent/qqmail/qmimagecache/DiskLruCache$Editor:commit	()V
    //   106: aload_1
    //   107: ifnull +7 -> 114
    //   110: aload_1
    //   111: invokevirtual 377	java/io/OutputStream:close	()V
    //   114: aload 5
    //   116: monitorexit
    //   117: return
    //   118: astore_1
    //   119: aload 5
    //   121: monitorexit
    //   122: aload_1
    //   123: athrow
    //   124: aload 6
    //   126: iconst_0
    //   127: invokevirtual 383	com/tencent/qqmail/qmimagecache/DiskLruCache$Snapshot:getInputStream	(I)Ljava/io/InputStream;
    //   130: invokevirtual 386	java/io/InputStream:close	()V
    //   133: goto -27 -> 106
    //   136: astore 4
    //   138: aconst_null
    //   139: astore_2
    //   140: aload_2
    //   141: astore_1
    //   142: ldc 31
    //   144: new 78	java/lang/StringBuilder
    //   147: dup
    //   148: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   151: ldc_w 388
    //   154: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: aload 4
    //   159: invokevirtual 391	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   162: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   165: invokestatic 397	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   168: pop
    //   169: aload_2
    //   170: ifnull -56 -> 114
    //   173: aload_2
    //   174: invokevirtual 377	java/io/OutputStream:close	()V
    //   177: goto -63 -> 114
    //   180: astore_1
    //   181: goto -67 -> 114
    //   184: astore 4
    //   186: aconst_null
    //   187: astore_2
    //   188: aload_2
    //   189: astore_1
    //   190: ldc 31
    //   192: new 78	java/lang/StringBuilder
    //   195: dup
    //   196: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   199: ldc_w 388
    //   202: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: aload 4
    //   207: invokevirtual 391	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   210: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   213: invokestatic 397	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   216: pop
    //   217: aload_2
    //   218: ifnull -104 -> 114
    //   221: aload_2
    //   222: invokevirtual 377	java/io/OutputStream:close	()V
    //   225: goto -111 -> 114
    //   228: astore_1
    //   229: goto -115 -> 114
    //   232: astore_2
    //   233: aconst_null
    //   234: astore_1
    //   235: aload_1
    //   236: ifnull +7 -> 243
    //   239: aload_1
    //   240: invokevirtual 377	java/io/OutputStream:close	()V
    //   243: aload_2
    //   244: athrow
    //   245: astore_1
    //   246: goto -132 -> 114
    //   249: astore_1
    //   250: goto -7 -> 243
    //   253: astore_2
    //   254: goto -19 -> 235
    //   257: astore_2
    //   258: goto -23 -> 235
    //   261: astore 4
    //   263: aload_1
    //   264: astore_2
    //   265: goto -77 -> 188
    //   268: astore 4
    //   270: aload_1
    //   271: astore_2
    //   272: goto -132 -> 140
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	275	0	this	ImageDrawableCache
    //   0	275	1	paramString	String
    //   0	275	2	paramArrayOfByte	byte[]
    //   22	2	3	bool	boolean
    //   37	1	4	localInterruptedException	java.lang.InterruptedException
    //   53	49	4	localObject1	Object
    //   136	22	4	localIOException1	IOException
    //   184	22	4	localException1	Exception
    //   261	1	4	localException2	Exception
    //   268	1	4	localIOException2	IOException
    //   13	107	5	localObject2	Object
    //   66	59	6	localSnapshot	DiskLruCache.Snapshot
    // Exception table:
    //   from	to	target	type
    //   27	34	37	java/lang/InterruptedException
    //   18	23	118	finally
    //   27	34	118	finally
    //   42	55	118	finally
    //   110	114	118	finally
    //   114	117	118	finally
    //   119	122	118	finally
    //   173	177	118	finally
    //   221	225	118	finally
    //   239	243	118	finally
    //   243	245	118	finally
    //   57	68	136	java/io/IOException
    //   73	84	136	java/io/IOException
    //   89	96	136	java/io/IOException
    //   124	133	136	java/io/IOException
    //   173	177	180	java/io/IOException
    //   57	68	184	java/lang/Exception
    //   73	84	184	java/lang/Exception
    //   89	96	184	java/lang/Exception
    //   124	133	184	java/lang/Exception
    //   221	225	228	java/io/IOException
    //   57	68	232	finally
    //   73	84	232	finally
    //   89	96	232	finally
    //   124	133	232	finally
    //   110	114	245	java/io/IOException
    //   239	243	249	java/io/IOException
    //   96	106	253	finally
    //   142	169	257	finally
    //   190	217	257	finally
    //   96	106	261	java/lang/Exception
    //   96	106	268	java/io/IOException
  }
  
  /* Error */
  public void clearCache()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 311	com/tencent/qqmail/qmimagecache/ImageDrawableCache:mMemoryCache	Landroid/util/LruCache;
    //   4: ifnull +59 -> 63
    //   7: aload_0
    //   8: getfield 311	com/tencent/qqmail/qmimagecache/ImageDrawableCache:mMemoryCache	Landroid/util/LruCache;
    //   11: invokevirtual 411	android/util/LruCache:evictAll	()V
    //   14: aload_0
    //   15: getfield 60	com/tencent/qqmail/qmimagecache/ImageDrawableCache:mDiskCacheLock	Ljava/lang/Object;
    //   18: astore_2
    //   19: aload_2
    //   20: monitorenter
    //   21: aload_0
    //   22: iconst_1
    //   23: putfield 62	com/tencent/qqmail/qmimagecache/ImageDrawableCache:mDiskCacheStarting	Z
    //   26: aload_0
    //   27: getfield 341	com/tencent/qqmail/qmimagecache/ImageDrawableCache:mDiskLruCache	Lcom/tencent/qqmail/qmimagecache/DiskLruCache;
    //   30: ifnull +31 -> 61
    //   33: aload_0
    //   34: getfield 341	com/tencent/qqmail/qmimagecache/ImageDrawableCache:mDiskLruCache	Lcom/tencent/qqmail/qmimagecache/DiskLruCache;
    //   37: invokevirtual 414	com/tencent/qqmail/qmimagecache/DiskLruCache:isClosed	()Z
    //   40: istore_1
    //   41: iload_1
    //   42: ifne +19 -> 61
    //   45: aload_0
    //   46: getfield 341	com/tencent/qqmail/qmimagecache/ImageDrawableCache:mDiskLruCache	Lcom/tencent/qqmail/qmimagecache/DiskLruCache;
    //   49: invokevirtual 417	com/tencent/qqmail/qmimagecache/DiskLruCache:delete	()V
    //   52: aload_0
    //   53: aconst_null
    //   54: putfield 341	com/tencent/qqmail/qmimagecache/ImageDrawableCache:mDiskLruCache	Lcom/tencent/qqmail/qmimagecache/DiskLruCache;
    //   57: aload_0
    //   58: invokevirtual 317	com/tencent/qqmail/qmimagecache/ImageDrawableCache:initDiskCache	()V
    //   61: aload_2
    //   62: monitorexit
    //   63: aload_0
    //   64: getfield 60	com/tencent/qqmail/qmimagecache/ImageDrawableCache:mDiskCacheLock	Ljava/lang/Object;
    //   67: astore_2
    //   68: aload_2
    //   69: monitorenter
    //   70: aload_0
    //   71: iconst_1
    //   72: putfield 62	com/tencent/qqmail/qmimagecache/ImageDrawableCache:mDiskCacheStarting	Z
    //   75: aload_0
    //   76: getfield 341	com/tencent/qqmail/qmimagecache/ImageDrawableCache:mDiskLruCache	Lcom/tencent/qqmail/qmimagecache/DiskLruCache;
    //   79: ifnull +31 -> 110
    //   82: aload_0
    //   83: getfield 341	com/tencent/qqmail/qmimagecache/ImageDrawableCache:mDiskLruCache	Lcom/tencent/qqmail/qmimagecache/DiskLruCache;
    //   86: invokevirtual 414	com/tencent/qqmail/qmimagecache/DiskLruCache:isClosed	()Z
    //   89: istore_1
    //   90: iload_1
    //   91: ifne +19 -> 110
    //   94: aload_0
    //   95: getfield 341	com/tencent/qqmail/qmimagecache/ImageDrawableCache:mDiskLruCache	Lcom/tencent/qqmail/qmimagecache/DiskLruCache;
    //   98: invokevirtual 417	com/tencent/qqmail/qmimagecache/DiskLruCache:delete	()V
    //   101: aload_0
    //   102: aconst_null
    //   103: putfield 341	com/tencent/qqmail/qmimagecache/ImageDrawableCache:mDiskLruCache	Lcom/tencent/qqmail/qmimagecache/DiskLruCache;
    //   106: aload_0
    //   107: invokevirtual 317	com/tencent/qqmail/qmimagecache/ImageDrawableCache:initDiskCache	()V
    //   110: aload_2
    //   111: monitorexit
    //   112: return
    //   113: astore_3
    //   114: ldc 31
    //   116: new 78	java/lang/StringBuilder
    //   119: dup
    //   120: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   123: ldc_w 419
    //   126: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: aload_3
    //   130: invokevirtual 391	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   133: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   136: invokestatic 397	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   139: pop
    //   140: goto -88 -> 52
    //   143: astore_3
    //   144: aload_2
    //   145: monitorexit
    //   146: aload_3
    //   147: athrow
    //   148: astore_3
    //   149: ldc 31
    //   151: new 78	java/lang/StringBuilder
    //   154: dup
    //   155: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   158: ldc_w 419
    //   161: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: aload_3
    //   165: invokevirtual 391	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   168: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   171: invokestatic 397	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   174: pop
    //   175: goto -74 -> 101
    //   178: astore_3
    //   179: aload_2
    //   180: monitorexit
    //   181: aload_3
    //   182: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	183	0	this	ImageDrawableCache
    //   40	51	1	bool	boolean
    //   113	17	3	localIOException1	IOException
    //   143	4	3	localObject2	Object
    //   148	17	3	localIOException2	IOException
    //   178	4	3	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   45	52	113	java/io/IOException
    //   21	41	143	finally
    //   45	52	143	finally
    //   52	61	143	finally
    //   61	63	143	finally
    //   114	140	143	finally
    //   144	146	143	finally
    //   94	101	148	java/io/IOException
    //   70	90	178	finally
    //   94	101	178	finally
    //   101	110	178	finally
    //   110	112	178	finally
    //   149	175	178	finally
    //   179	181	178	finally
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
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore_3
    //   5: aload_1
    //   6: invokestatic 343	com/tencent/qqmail/qmimagecache/ImageDrawableCache:hashKeyForDisk	(Ljava/lang/String;)Ljava/lang/String;
    //   9: astore_1
    //   10: aload_0
    //   11: getfield 60	com/tencent/qqmail/qmimagecache/ImageDrawableCache:mDiskCacheLock	Ljava/lang/Object;
    //   14: astore 7
    //   16: aload 7
    //   18: monitorenter
    //   19: aload_0
    //   20: getfield 62	com/tencent/qqmail/qmimagecache/ImageDrawableCache:mDiskCacheStarting	Z
    //   23: istore_2
    //   24: iload_2
    //   25: ifeq +18 -> 43
    //   28: aload_0
    //   29: getfield 60	com/tencent/qqmail/qmimagecache/ImageDrawableCache:mDiskCacheLock	Ljava/lang/Object;
    //   32: invokevirtual 404	java/lang/Object:wait	()V
    //   35: goto -16 -> 19
    //   38: astore 4
    //   40: goto -21 -> 19
    //   43: aload_0
    //   44: getfield 341	com/tencent/qqmail/qmimagecache/ImageDrawableCache:mDiskLruCache	Lcom/tencent/qqmail/qmimagecache/DiskLruCache;
    //   47: astore 5
    //   49: aload 6
    //   51: astore 4
    //   53: aload 5
    //   55: ifnull +72 -> 127
    //   58: aload_0
    //   59: getfield 341	com/tencent/qqmail/qmimagecache/ImageDrawableCache:mDiskLruCache	Lcom/tencent/qqmail/qmimagecache/DiskLruCache;
    //   62: aload_1
    //   63: invokevirtual 349	com/tencent/qqmail/qmimagecache/DiskLruCache:get	(Ljava/lang/String;)Lcom/tencent/qqmail/qmimagecache/DiskLruCache$Snapshot;
    //   66: astore_1
    //   67: aload_1
    //   68: ifnull +164 -> 232
    //   71: aload_1
    //   72: iconst_0
    //   73: invokevirtual 383	com/tencent/qqmail/qmimagecache/DiskLruCache$Snapshot:getInputStream	(I)Ljava/io/InputStream;
    //   76: astore_1
    //   77: aload_1
    //   78: astore 5
    //   80: aload_1
    //   81: ifnull +30 -> 111
    //   84: aload_1
    //   85: astore_3
    //   86: aload_1
    //   87: checkcast 431	java/io/FileInputStream
    //   90: invokevirtual 435	java/io/FileInputStream:getFD	()Ljava/io/FileDescriptor;
    //   93: ldc_w 436
    //   96: ldc_w 436
    //   99: aload_0
    //   100: invokestatic 442	com/tencent/qqmail/qmimagecache/ImageResizer:decodeSampledBitmapFromDescriptor	(Ljava/io/FileDescriptor;IILcom/tencent/qqmail/qmimagecache/ImageDrawableCache;)Landroid/graphics/Bitmap;
    //   103: astore 4
    //   105: aload 4
    //   107: astore_3
    //   108: aload_1
    //   109: astore 5
    //   111: aload_3
    //   112: astore 4
    //   114: aload 5
    //   116: ifnull +11 -> 127
    //   119: aload 5
    //   121: invokevirtual 386	java/io/InputStream:close	()V
    //   124: aload_3
    //   125: astore 4
    //   127: aload 7
    //   129: monitorexit
    //   130: aload 4
    //   132: areturn
    //   133: astore 4
    //   135: aconst_null
    //   136: astore_1
    //   137: aload_1
    //   138: astore_3
    //   139: ldc 31
    //   141: new 78	java/lang/StringBuilder
    //   144: dup
    //   145: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   148: ldc_w 444
    //   151: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: aload 4
    //   156: invokevirtual 391	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   159: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   162: invokestatic 397	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   165: pop
    //   166: aload 6
    //   168: astore 4
    //   170: aload_1
    //   171: ifnull -44 -> 127
    //   174: aload_1
    //   175: invokevirtual 386	java/io/InputStream:close	()V
    //   178: aload 6
    //   180: astore 4
    //   182: goto -55 -> 127
    //   185: astore_1
    //   186: aload 6
    //   188: astore 4
    //   190: goto -63 -> 127
    //   193: astore_1
    //   194: aconst_null
    //   195: astore_3
    //   196: aload_3
    //   197: ifnull +7 -> 204
    //   200: aload_3
    //   201: invokevirtual 386	java/io/InputStream:close	()V
    //   204: aload_1
    //   205: athrow
    //   206: astore_1
    //   207: aload 7
    //   209: monitorexit
    //   210: aload_1
    //   211: athrow
    //   212: astore_1
    //   213: aload_3
    //   214: astore 4
    //   216: goto -89 -> 127
    //   219: astore_3
    //   220: goto -16 -> 204
    //   223: astore_1
    //   224: goto -28 -> 196
    //   227: astore 4
    //   229: goto -92 -> 137
    //   232: aconst_null
    //   233: astore 5
    //   235: goto -124 -> 111
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	238	0	this	ImageDrawableCache
    //   0	238	1	paramString	String
    //   23	2	2	bool	boolean
    //   4	210	3	localObject1	Object
    //   219	1	3	localIOException1	IOException
    //   38	1	4	localInterruptedException	java.lang.InterruptedException
    //   51	80	4	localObject2	Object
    //   133	22	4	localIOException2	IOException
    //   168	47	4	localObject3	Object
    //   227	1	4	localIOException3	IOException
    //   47	187	5	localObject4	Object
    //   1	186	6	localObject5	Object
    //   14	194	7	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   28	35	38	java/lang/InterruptedException
    //   58	67	133	java/io/IOException
    //   71	77	133	java/io/IOException
    //   174	178	185	java/io/IOException
    //   58	67	193	finally
    //   71	77	193	finally
    //   19	24	206	finally
    //   28	35	206	finally
    //   43	49	206	finally
    //   119	124	206	finally
    //   127	130	206	finally
    //   174	178	206	finally
    //   200	204	206	finally
    //   204	206	206	finally
    //   207	210	206	finally
    //   119	124	212	java/io/IOException
    //   200	204	219	java/io/IOException
    //   86	105	223	finally
    //   139	166	223	finally
    //   86	105	227	java/io/IOException
  }
  
  public BitmapDrawable getBitmapFromMemCache(String paramString)
  {
    BitmapDrawable localBitmapDrawable = null;
    if (this.mMemoryCache != null) {
      localBitmapDrawable = (BitmapDrawable)this.mMemoryCache.get(paramString);
    }
    return localBitmapDrawable;
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
          long l = getUsableSpace(localFile);
          int i = this.mCacheParams.diskCacheSize;
          if (l <= i) {}
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
          Log.e("ImageCache", "initDiskCache - " + localIOException);
        }
      }
    }
  }
  
  public boolean isExistInDisk(String paramString)
  {
    synchronized (this.mDiskCacheLock)
    {
      if (this.mDiskLruCache != null)
      {
        paramString = hashKeyForDisk(paramString);
        boolean bool = this.mDiskLruCache.isExist(paramString);
        return bool;
      }
      return false;
    }
  }
  
  public static class ImageCacheParams
  {
    public boolean clearDiskCacheOnStart = false;
    public Bitmap.CompressFormat compressFormat = ImageDrawableCache.DEFAULT_COMPRESS_FORMAT;
    public int compressQuality = 70;
    public File diskCacheDir;
    public boolean diskCacheEnabled = true;
    public int diskCacheSize = 31457280;
    public boolean initDiskCacheOnCreate = false;
    public int memCacheSize = 20480;
    public boolean memoryCacheEnabled = true;
    
    public ImageCacheParams(Context paramContext, String paramString)
    {
      this.diskCacheDir = ImageDrawableCache.getDiskCacheDir(paramContext, paramString);
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
  
  public static class RetainFragment
    extends ReportAndroidXFragment
  {
    private Object mObject;
    
    public Object getObject()
    {
      return this.mObject;
    }
    
    public void onCreate(Bundle paramBundle)
    {
      super.onCreate(paramBundle);
      setRetainInstance(true);
    }
    
    public void setObject(Object paramObject)
    {
      this.mObject = paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.qmimagecache.ImageDrawableCache
 * JD-Core Version:    0.7.0.1
 */