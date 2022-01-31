package com.tencent.image;

import android.app.PendingIntent.CanceledException;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.media.ExifInterface;
import android.os.AsyncTask;
import android.os.AsyncTask.Status;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.util.MQLruCache;
import android.util.Pair;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.util.HashMap;
import java.util.Vector;
import java.util.concurrent.CancellationException;
import java.util.concurrent.RejectedExecutionException;
import org.apache.http.Header;
import org.apache.http.client.CookieStore;

final class URLState
  extends Drawable.ConstantState
{
  static final String CACHE_PREFIX = "Cache_";
  static final Object FILE_DOWNLOADED = new Object();
  private static final Handler UI_HANDLER = new Handler(Looper.getMainLooper());
  static HashMap<String, WeakReference<URLState>> sUnFinishImageCache = new HashMap();
  private Vector<WeakReference<Callback>> callbacks = new Vector();
  File mCacheFile;
  boolean mDecodeFile;
  private final Object mDecodeFileLock = new Object();
  boolean mDither = true;
  int mHeight = 0;
  boolean mIgnorePause = false;
  int mIsLoadingStarted = 0;
  int mOrientation = 0;
  DownloadParams mParams = new DownloadParams();
  int mProgress = 0;
  ProtocolDownloader mProtocolDownloader;
  int mStatus = 0;
  Drawable.ConstantState mSuccessed;
  PreDownloadAsyncTask mTask;
  URL mUrl;
  String mUrlStr;
  boolean mUseMemoryCache = true;
  boolean mUseThreadPool = true;
  int mWidth = 0;
  
  URLState(URL arg1, URLDrawable.URLDrawableOptions paramURLDrawableOptions)
  {
    this.mUrl = ???;
    this.mUrlStr = ???.toString();
    this.mUseMemoryCache = paramURLDrawableOptions.mUseMemoryCache;
    this.mUseThreadPool = paramURLDrawableOptions.mUseThreadPool;
    this.mProtocolDownloader = URLDrawable.sDefaultDrawableParms.getDownloader(???.getProtocol());
    if ((this.mProtocolDownloader == null) && (QLog.isDevelopLevel())) {
      QLog.e("URLDrawable_", 4, "No comfortable downloader. url:" + ??? + "protocol" + ???.getProtocol());
    }
    synchronized (URLDrawable.sMemoryCache)
    {
      sUnFinishImageCache.put(this.mUrlStr, new WeakReference(this));
      return;
    }
  }
  
  private int calculateInSampleSize(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 0) || (paramInt2 == 0) || (paramInt1 == -1) || (paramInt2 == -1)) {
      m = 1;
    }
    int j;
    int k;
    int i;
    label39:
    do
    {
      do
      {
        return m;
        j = paramOptions.outHeight;
        k = paramOptions.outWidth;
        i = 1;
        m = i;
      } while (j <= paramInt2);
      m = i;
    } while (k <= paramInt1);
    int n = Math.round(j / paramInt2);
    int m = Math.round(k / paramInt1);
    if (n > m) {}
    for (;;)
    {
      m = i;
      if (n < 2) {
        break;
      }
      k >>= 1;
      j >>= 1;
      i <<= 1;
      break label39;
      n = m;
    }
  }
  
  private Object decodeFile(File paramFile, URLDrawableHandler paramURLDrawableHandler)
    throws Exception
  {
    if ((paramFile == null) || (!paramFile.exists())) {
      return null;
    }
    Object localObject = this.mProtocolDownloader;
    if (localObject != null)
    {
      paramURLDrawableHandler = ((ProtocolDownloader)localObject).decodeFile(paramFile, this.mParams, paramURLDrawableHandler);
      if (paramURLDrawableHandler != null)
      {
        this.mOrientation = this.mParams.outOrientation;
        this.mWidth = this.mParams.outWidth;
        this.mHeight = this.mParams.outHeight;
        return paramURLDrawableHandler;
      }
    }
    if ((localObject != null) && (((ProtocolDownloader)localObject).gifHasDifferentState())) {}
    for (boolean bool = true; (GifDrawable.isGifFile(paramFile)) && ((bool) || (this.mParams.useGifAnimation)); bool = false) {
      return NativeGifFactory.getNativeGifObject(paramFile, bool, false, this.mParams.reqWidth, this.mParams.reqHeight, this.mParams.mGifRoundCorner);
    }
    if ((ApngImage.needDecodeAnimation(paramFile)) && ((bool) || (this.mParams.useGifAnimation))) {
      return new ApngImage(paramFile, bool);
    }
    localObject = paramFile.getAbsolutePath();
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    localOptions.inPreferredConfig = URLDrawable.sDefaultDrawableParms.mConfig;
    localOptions.inDensity = 160;
    localOptions.inTargetDensity = 160;
    localOptions.inScreenDensity = 160;
    SafeBitmapFactory.decodeFile((String)localObject, localOptions);
    localOptions.inJustDecodeBounds = false;
    localOptions.inSampleSize = calculateInSampleSize(localOptions, this.mParams.reqWidth, this.mParams.reqHeight);
    paramURLDrawableHandler = SafeBitmapFactory.decodeFile((String)localObject, localOptions);
    if (QLog.isDevelopLevel()) {
      QLog.d("URLDrawable_", 4, "decodeFile:sampleSize=" + localOptions.inSampleSize + ", requestSize=" + this.mParams.reqWidth + "," + this.mParams.reqHeight);
    }
    if (paramURLDrawableHandler == null)
    {
      bool = paramFile.delete();
      if (QLog.isDevelopLevel()) {
        QLog.d("URLDrawable_", 4, "Delete error cache return " + bool);
      }
      throw new IOException("decode cache file failed: " + (String)localObject);
    }
    this.mOrientation = new ExifInterface((String)localObject).getAttributeInt("Orientation", 1);
    paramFile = paramURLDrawableHandler;
    if (this.mParams.mDecodeHandler != null) {
      paramFile = this.mParams.mDecodeHandler.run(this.mParams, paramURLDrawableHandler);
    }
    if ((Build.VERSION.SDK_INT >= 11) && (SliceBitmap.needSlice(paramFile)))
    {
      paramURLDrawableHandler = new SliceBitmap(paramFile);
      paramFile.recycle();
      return paramURLDrawableHandler;
    }
    return paramFile;
  }
  
  static URLState getConstants(String paramString)
  {
    synchronized (URLDrawable.sMemoryCache)
    {
      WeakReference localWeakReference = (WeakReference)sUnFinishImageCache.get(paramString);
      if ((localWeakReference != null) && (localWeakReference.get() != null))
      {
        paramString = (URLState)localWeakReference.get();
        return paramString;
      }
      paramString = (Pair)URLDrawable.sMemoryCache.get(paramString);
      if ((paramString != null) && ((paramString.first instanceof URLState))) {
        return (URLState)paramString.first;
      }
    }
    return null;
  }
  
  private static int getImageByteSize(Object paramObject)
  {
    if ((paramObject instanceof Bitmap)) {
      return Utils.getBitmapSize((Bitmap)paramObject);
    }
    if ((paramObject instanceof SliceBitmap)) {
      return ((SliceBitmap)paramObject).getByteCount();
    }
    if ((paramObject instanceof AbstractGifImage)) {
      return ((AbstractGifImage)paramObject).getByteSize();
    }
    return 0;
  }
  
  private void pauseThread()
  {
    if ((this.mIgnorePause) || (Looper.myLooper() == Looper.getMainLooper())) {
      return;
    }
    synchronized (URLDrawable.sPauseLock)
    {
      for (;;)
      {
        boolean bool = URLDrawable.sPause;
        if (!bool) {
          break;
        }
        try
        {
          URLDrawable.sPauseLock.wait();
        }
        catch (InterruptedException localInterruptedException) {}
      }
      return;
    }
  }
  
  void addCallBack(Callback paramCallback)
  {
    if (paramCallback != null) {
      this.callbacks.add(new WeakReference(paramCallback));
    }
  }
  
  /* Error */
  void downloadImediatly(Header[] paramArrayOfHeader, CookieStore paramCookieStore, Object paramObject, boolean paramBoolean1, boolean paramBoolean2, float paramFloat)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 89	com/tencent/image/URLState:mStatus	I
    //   4: iconst_1
    //   5: if_icmpeq +10 -> 15
    //   8: aload_0
    //   9: getfield 107	com/tencent/image/URLState:mIsLoadingStarted	I
    //   12: ifle +4 -> 16
    //   15: return
    //   16: aload_0
    //   17: aload_0
    //   18: getfield 107	com/tencent/image/URLState:mIsLoadingStarted	I
    //   21: iconst_1
    //   22: iadd
    //   23: putfield 107	com/tencent/image/URLState:mIsLoadingStarted	I
    //   26: aload_0
    //   27: iload 4
    //   29: putfield 423	com/tencent/image/URLState:mDecodeFile	Z
    //   32: aload_0
    //   33: getfield 96	com/tencent/image/URLState:mParams	Lcom/tencent/image/DownloadParams;
    //   36: aload_2
    //   37: putfield 427	com/tencent/image/DownloadParams:cookies	Lorg/apache/http/client/CookieStore;
    //   40: aload_0
    //   41: getfield 96	com/tencent/image/URLState:mParams	Lcom/tencent/image/DownloadParams;
    //   44: aload_1
    //   45: putfield 431	com/tencent/image/DownloadParams:headers	[Lorg/apache/http/Header;
    //   48: aload_0
    //   49: getfield 96	com/tencent/image/URLState:mParams	Lcom/tencent/image/DownloadParams;
    //   52: aload_3
    //   53: putfield 434	com/tencent/image/DownloadParams:tag	Ljava/lang/Object;
    //   56: aload_0
    //   57: getfield 96	com/tencent/image/URLState:mParams	Lcom/tencent/image/DownloadParams;
    //   60: iload 5
    //   62: putfield 239	com/tencent/image/DownloadParams:useGifAnimation	Z
    //   65: aload_0
    //   66: getfield 96	com/tencent/image/URLState:mParams	Lcom/tencent/image/DownloadParams;
    //   69: fload 6
    //   71: putfield 249	com/tencent/image/DownloadParams:mGifRoundCorner	F
    //   74: aload_0
    //   75: aload_0
    //   76: getfield 121	com/tencent/image/URLState:mUrl	Ljava/net/URL;
    //   79: new 436	com/tencent/image/URLDrawableHandler$Adapter
    //   82: dup
    //   83: invokespecial 437	com/tencent/image/URLDrawableHandler$Adapter:<init>	()V
    //   86: invokevirtual 441	com/tencent/image/URLState:loadImage	(Ljava/net/URL;Lcom/tencent/image/URLDrawableHandler;)Ljava/lang/Object;
    //   89: astore_1
    //   90: invokestatic 402	android/os/Looper:myLooper	()Landroid/os/Looper;
    //   93: invokestatic 79	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   96: if_acmpne +82 -> 178
    //   99: aload_1
    //   100: astore_2
    //   101: aload_0
    //   102: aload_2
    //   103: invokevirtual 444	com/tencent/image/URLState:onResult	(Ljava/lang/Object;)V
    //   106: return
    //   107: astore_1
    //   108: aload_1
    //   109: astore_2
    //   110: invokestatic 402	android/os/Looper:myLooper	()Landroid/os/Looper;
    //   113: invokestatic 79	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   116: if_acmpeq -15 -> 101
    //   119: getstatic 84	com/tencent/image/URLState:UI_HANDLER	Landroid/os/Handler;
    //   122: astore_3
    //   123: new 12	com/tencent/image/URLState$PostOnResult
    //   126: dup
    //   127: aload_0
    //   128: aload_1
    //   129: invokespecial 447	com/tencent/image/URLState$PostOnResult:<init>	(Lcom/tencent/image/URLState;Ljava/lang/Object;)V
    //   132: astore_2
    //   133: aload_3
    //   134: astore_1
    //   135: aload_1
    //   136: aload_2
    //   137: invokevirtual 451	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   140: pop
    //   141: return
    //   142: astore_1
    //   143: invokestatic 402	android/os/Looper:myLooper	()Landroid/os/Looper;
    //   146: invokestatic 79	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   149: if_acmpne +10 -> 159
    //   152: aload_0
    //   153: aconst_null
    //   154: invokevirtual 444	com/tencent/image/URLState:onResult	(Ljava/lang/Object;)V
    //   157: aload_1
    //   158: athrow
    //   159: getstatic 84	com/tencent/image/URLState:UI_HANDLER	Landroid/os/Handler;
    //   162: new 12	com/tencent/image/URLState$PostOnResult
    //   165: dup
    //   166: aload_0
    //   167: aconst_null
    //   168: invokespecial 447	com/tencent/image/URLState$PostOnResult:<init>	(Lcom/tencent/image/URLState;Ljava/lang/Object;)V
    //   171: invokevirtual 451	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   174: pop
    //   175: goto -18 -> 157
    //   178: getstatic 84	com/tencent/image/URLState:UI_HANDLER	Landroid/os/Handler;
    //   181: astore_2
    //   182: new 12	com/tencent/image/URLState$PostOnResult
    //   185: dup
    //   186: aload_0
    //   187: aload_1
    //   188: invokespecial 447	com/tencent/image/URLState$PostOnResult:<init>	(Lcom/tencent/image/URLState;Ljava/lang/Object;)V
    //   191: astore_3
    //   192: aload_2
    //   193: astore_1
    //   194: aload_3
    //   195: astore_2
    //   196: goto -61 -> 135
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	199	0	this	URLState
    //   0	199	1	paramArrayOfHeader	Header[]
    //   0	199	2	paramCookieStore	CookieStore
    //   0	199	3	paramObject	Object
    //   0	199	4	paramBoolean1	boolean
    //   0	199	5	paramBoolean2	boolean
    //   0	199	6	paramFloat	float
    // Exception table:
    //   from	to	target	type
    //   74	90	107	java/lang/Throwable
    //   74	90	142	finally
  }
  
  public int getChangingConfigurations()
  {
    return 0;
  }
  
  Object loadImage(URL paramURL, URLDrawableHandler paramURLDrawableHandler)
    throws Throwable
  {
    paramURL = null;
    pauseThread();
    if (this.mProtocolDownloader != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("URLDrawable_", 2, "call downloader loadImage." + this.mUrlStr);
      }
      paramURL = this.mProtocolDownloader.loadImageFile(this.mParams, paramURLDrawableHandler);
      this.mCacheFile = paramURL;
    }
    for (;;)
    {
      Pair localPair;
      synchronized (this.mDecodeFileLock)
      {
        if (!this.mDecodeFile)
        {
          this.mStatus = 4;
          this.mIsLoadingStarted -= 1;
          paramURL = FILE_DOWNLOADED;
          return paramURL;
        }
        this.mStatus = 4;
        this.mStatus = 4;
        paramURL = decodeFile(paramURL, paramURLDrawableHandler);
        if (paramURL != null)
        {
          if (!(paramURL instanceof Bitmap)) {
            break label267;
          }
          ??? = this.mUrl.getPath();
          ??? = new RegionDrawable(null, (Bitmap)paramURL, (String)???);
          ((RegionDrawable)???).setDither(this.mDither);
          this.mSuccessed = ((RegionDrawable)???).getConstantState();
          localPair = new Pair(this, Integer.valueOf(getImageByteSize(paramURL)));
        }
      }
      synchronized (URLDrawable.sMemoryCache)
      {
        sUnFinishImageCache.remove(this.mUrlStr);
        if (this.mUseMemoryCache) {
          URLDrawable.sMemoryCache.put(this.mUrlStr, localPair);
        }
        this.mStatus = 1;
        pauseThread();
        paramURLDrawableHandler.publishProgress(10000);
        if (paramURL == null)
        {
          throw new NullPointerException("bitmap decode failed");
          paramURL = finally;
          throw paramURL;
          label267:
          if ((paramURL instanceof SliceBitmap))
          {
            ??? = new SliceBitmapDrawable.BitmapState((SliceBitmap)paramURL);
            ((SliceBitmapDrawable.BitmapState)???).mPaint.setDither(this.mDither);
            this.mSuccessed = ((Drawable.ConstantState)???);
            continue;
          }
          if ((paramURL instanceof AbstractGifImage))
          {
            ??? = new GifDrawable.GifState((AbstractGifImage)paramURL);
            ((GifDrawable.GifState)???).mPaint.setDither(this.mDither);
            this.mSuccessed = ((Drawable.ConstantState)???);
            continue;
          }
          if ((paramURL instanceof ApngImage))
          {
            ??? = new ApngDrawable.ApngState((ApngImage)paramURL);
            ((ApngDrawable.ApngState)???).mPaint.setDither(this.mDither);
            this.mSuccessed = ((Drawable.ConstantState)???);
            continue;
          }
          if ((paramURL instanceof RoundRectBitmap))
          {
            ??? = new RoundRectDrawable.RoundRectDrawableState((RoundRectBitmap)paramURL);
            ((RoundRectDrawable.RoundRectDrawableState)???).mBorderPaint.setDither(this.mDither);
            ((RoundRectDrawable.RoundRectDrawableState)???).mBitmapPaint.setDither(this.mDither);
            this.mSuccessed = ((Drawable.ConstantState)???);
            continue;
          }
          throw new RuntimeException("Invalide image type " + paramURL.getClass().getSimpleName());
        }
      }
    }
    if (this.mSuccessed == null) {
      throw new NullPointerException("mSuccessed is null...");
    }
    return paramURL;
  }
  
  public Drawable newDrawable()
  {
    return new URLDrawable(this, null);
  }
  
  public Drawable newDrawable(Resources paramResources)
  {
    return new URLDrawable(this, paramResources);
  }
  
  void onFileDownloaded()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("URLDrawable_", 4, "download successed, URLState: " + this + " , url: " + this.mUrlStr + "\nnotify " + this.callbacks.size() + " callbacks");
    }
    Vector localVector = this.callbacks;
    int i = 0;
    for (;;)
    {
      Object localObject1;
      int j;
      label129:
      try
      {
        if (i < this.callbacks.size())
        {
          localObject1 = (WeakReference)this.callbacks.get(i);
          if ((localObject1 == null) || (((WeakReference)localObject1).get() == null))
          {
            localObject1 = this.callbacks;
            j = i - 1;
          }
        }
      }
      finally {}
    }
    try
    {
      ((Vector)localObject1).remove(i);
      i = j;
      i += 1;
    }
    finally
    {
      label157:
      break label157;
    }
    ((Callback)((WeakReference)localObject1).get()).onFileDownloaded(this);
    break label129;
    return;
    throw localObject2;
  }
  
  void onLoadCancelled()
  {
    if (QLog.isColorLevel()) {
      QLog.i("URLDrawable_", 2, "[onLoadCancelled]");
    }
    this.mStatus = 3;
    this.mIsLoadingStarted -= 1;
    int i = 0;
    for (;;)
    {
      if (i < this.callbacks.size()) {}
      synchronized (this.callbacks)
      {
        Object localObject1 = (WeakReference)this.callbacks.get(i);
        if ((localObject1 == null) || (((WeakReference)localObject1).get() == null)) {
          localObject1 = this.callbacks;
        }
        for (;;)
        {
          try
          {
            ((Vector)localObject1).remove(i);
            i -= 1;
            i += 1;
          }
          finally
          {
            continue;
          }
          ((Callback)((WeakReference)localObject1).get()).onLoadCanceled(this);
        }
        throw ((Throwable)localObject1);
        return;
      }
    }
  }
  
  void onLoadFailed(Throwable paramThrowable)
  {
    if (QLog.isDevelopLevel()) {
      QLog.e("URLDrawable_", 4, wrapLog("URLState onLoadFailed():"), paramThrowable);
    }
    this.mStatus = 2;
    Vector localVector = this.callbacks;
    int i = 0;
    for (;;)
    {
      Object localObject;
      int j;
      try
      {
        if (i < this.callbacks.size())
        {
          localObject = (WeakReference)this.callbacks.get(i);
          if ((localObject == null) || (((WeakReference)localObject).get() == null))
          {
            localObject = this.callbacks;
            j = i - 1;
          }
        }
      }
      finally {}
      try
      {
        ((Vector)localObject).remove(i);
        i = j;
        i += 1;
      }
      finally
      {
        break;
      }
      ((Callback)((WeakReference)localObject).get()).onLoadFailed(this, paramThrowable);
      continue;
      return;
    }
    throw paramThrowable;
  }
  
  void onLoadStart()
  {
    Vector localVector = this.callbacks;
    int i = 0;
    for (;;)
    {
      Object localObject1;
      int j;
      try
      {
        if (i < this.callbacks.size())
        {
          localObject1 = (WeakReference)this.callbacks.get(i);
          if ((localObject1 == null) || (((WeakReference)localObject1).get() == null))
          {
            localObject1 = this.callbacks;
            j = i - 1;
          }
        }
      }
      finally {}
      try
      {
        ((Vector)localObject1).remove(i);
        i = j;
        i += 1;
      }
      finally
      {
        break;
      }
      ((Callback)((WeakReference)localObject1).get()).onLoadStarted(this);
      continue;
      return;
    }
    throw localObject2;
  }
  
  void onLoadSuccessed(Object paramObject)
  {
    if (this.mIsLoadingStarted == 0) {
      return;
    }
    Vector localVector = this.callbacks;
    int i = 0;
    for (;;)
    {
      int j;
      label70:
      try
      {
        if (i < this.callbacks.size())
        {
          paramObject = (WeakReference)this.callbacks.get(i);
          if ((paramObject == null) || (paramObject.get() == null))
          {
            paramObject = this.callbacks;
            j = i - 1;
          }
        }
      }
      finally {}
    }
    try
    {
      paramObject.remove(i);
      i = j;
      i += 1;
    }
    finally
    {
      label105:
      break label105;
    }
    ((Callback)paramObject.get()).onLoadSuccessed(this);
    break label70;
    this.callbacks.clear();
    return;
    throw paramObject;
  }
  
  void onResult(Object paramObject)
  {
    if (paramObject == FILE_DOWNLOADED)
    {
      onFileDownloaded();
      return;
    }
    if ((paramObject instanceof PendingIntent.CanceledException))
    {
      onLoadCancelled();
      return;
    }
    if ((paramObject instanceof Throwable))
    {
      onLoadFailed((Throwable)paramObject);
      return;
    }
    onLoadSuccessed(paramObject);
  }
  
  boolean reStartDownload(Header[] paramArrayOfHeader, CookieStore paramCookieStore, Object paramObject1, boolean paramBoolean1, boolean paramBoolean2, float paramFloat, boolean paramBoolean3, Object paramObject2)
  {
    if ((this.mStatus != 2) && (this.mStatus != 3)) {
      return false;
    }
    this.mIsLoadingStarted = 0;
    this.mStatus = 0;
    startDownload(paramArrayOfHeader, paramCookieStore, paramObject1, paramBoolean1, paramBoolean2, paramFloat, paramBoolean3, paramObject2);
    return true;
  }
  
  void removeCallBack(Callback paramCallback)
  {
    localVector = this.callbacks;
    int i = 0;
    Object localObject;
    for (;;)
    {
      int j;
      try
      {
        if (i < this.callbacks.size())
        {
          localObject = (WeakReference)this.callbacks.get(i);
          if ((localObject == null) || (((WeakReference)localObject).get() == null))
          {
            localObject = this.callbacks;
            j = i - 1;
          }
        }
      }
      finally {}
      try
      {
        ((Vector)localObject).remove(i);
        i = j;
      }
      finally
      {
        continue;
        continue;
      }
      i += 1;
    }
    if (((WeakReference)localObject).get() == paramCallback)
    {
      paramCallback = this.callbacks;
      paramCallback.remove(i);
      return;
      return;
    }
  }
  
  public String saveTo(String paramString)
    throws IOException
  {
    if (this.mCacheFile == null) {
      throw new FileNotFoundException("File is not download complete, please check getStatus() == URLDrawable.SUCCESSED first. ");
    }
    File localFile = this.mCacheFile;
    String str = paramString;
    if (paramString.indexOf(".") == -1) {
      if (!(this.mSuccessed instanceof GifDrawable.GifState)) {
        break label87;
      }
    }
    label87:
    for (str = ".gif";; str = ".jpg")
    {
      str = paramString + str;
      Utils.copyFile(localFile, new File(str));
      if (localFile == null) {
        break;
      }
      return str;
    }
    return null;
  }
  
  void startDownload(Header[] paramArrayOfHeader, CookieStore paramCookieStore, Object paramObject1, boolean paramBoolean1, boolean paramBoolean2, float paramFloat, boolean paramBoolean3, Object paramObject2)
  {
    if (this.mProtocolDownloader == null) {
      onLoadFailed(new NullPointerException("mProtocolDownloader is null"));
    }
    do
    {
      do
      {
        return;
        if (this.mIsLoadingStarted == 0)
        {
          this.mIsLoadingStarted += 1;
          this.mDecodeFile = paramBoolean1;
          this.mParams.cookies = paramCookieStore;
          this.mParams.headers = paramArrayOfHeader;
          this.mParams.tag = paramObject1;
          this.mParams.useGifAnimation = paramBoolean2;
          this.mParams.mGifRoundCorner = paramFloat;
          this.mParams.useExifOrientation = paramBoolean3;
          this.mParams.mExtraInfo = paramObject2;
          try
          {
            paramArrayOfHeader = new PreDownloadAsyncTask(this.mUrl);
            Utils.executeAsyncTaskOnNewThreadPool(URLDrawable.sDefaultDrawableParms.mURLDrawableSubExecutor, paramArrayOfHeader, new Void[] { (Void)null });
            this.mTask = paramArrayOfHeader;
            return;
          }
          catch (RejectedExecutionException paramArrayOfHeader)
          {
            if (QLog.isColorLevel()) {
              QLog.e("URLDrawable_", 2, "startDownload(): execute AsyncTask failed.", paramArrayOfHeader);
            }
            this.mIsLoadingStarted -= 1;
            onLoadFailed(paramArrayOfHeader);
            return;
          }
        }
        if ((this.mDecodeFile) || (!paramBoolean1)) {
          break;
        }
        synchronized (this.mDecodeFileLock)
        {
          if (this.mStatus == 0)
          {
            this.mDecodeFile = true;
            return;
          }
        }
      } while (this.mIsLoadingStarted != 0);
      startDownload(paramArrayOfHeader, paramCookieStore, paramObject1, paramBoolean1, paramBoolean2, paramFloat, paramBoolean3, paramObject2);
      return;
    } while ((this.mIsLoadingStarted <= 1) || (!QLog.isColorLevel()));
    QLog.i("URLDrawable_", 2, "startDownload mIsLoadingStarted is " + this.mIsLoadingStarted);
  }
  
  String wrapLog(String paramString)
  {
    paramString = new StringBuilder(paramString);
    paramString.append('\n');
    paramString.append("  |- URLState:");
    paramString.append(this);
    paramString.append('\n');
    paramString.append("  |- url:");
    paramString.append(this.mUrlStr);
    paramString.append('\n');
    paramString.append("  |- callbacks:");
    paramString.append(this.callbacks.size());
    return paramString.toString();
  }
  
  public static abstract interface Callback
  {
    public abstract void onFileDownloadFailed(int paramInt);
    
    public abstract void onFileDownloadStarted();
    
    public abstract void onFileDownloadSucceed(long paramLong);
    
    public abstract void onFileDownloaded(URLState paramURLState);
    
    public abstract void onLoadCanceled(URLState paramURLState);
    
    public abstract void onLoadFailed(URLState paramURLState, Throwable paramThrowable);
    
    public abstract void onLoadStarted(URLState paramURLState);
    
    public abstract void onLoadSuccessed(URLState paramURLState);
    
    public abstract void onUpdateProgress(int paramInt);
  }
  
  class DownloadAsyncTask
    extends AsyncTask<URL, Integer, Object>
    implements URLDrawableHandler
  {
    DownloadAsyncTask() {}
    
    public void doCancel()
    {
      throw new CancellationException();
    }
    
    protected Object doInBackground(URL... paramVarArgs)
    {
      try
      {
        if (isCancelled()) {
          return null;
        }
        paramVarArgs = URLState.this.loadImage(paramVarArgs[0], this);
        return paramVarArgs;
      }
      catch (Throwable paramVarArgs) {}
      return paramVarArgs;
    }
    
    protected void onCancelled()
    {
      URLState.this.onLoadCancelled();
    }
    
    public void onFileDownloadFailed(int paramInt)
    {
      Vector localVector = URLState.this.callbacks;
      int i = 0;
      for (;;)
      {
        Object localObject1;
        int j;
        try
        {
          if (i < URLState.this.callbacks.size())
          {
            localObject1 = (WeakReference)URLState.this.callbacks.get(i);
            if ((localObject1 == null) || (((WeakReference)localObject1).get() == null))
            {
              localObject1 = URLState.this.callbacks;
              j = i - 1;
            }
          }
        }
        finally {}
        try
        {
          ((Vector)localObject1).remove(i);
          i = j;
          i += 1;
        }
        finally
        {
          break label109;
        }
        ((URLState.Callback)((WeakReference)localObject1).get()).onFileDownloadFailed(paramInt);
        continue;
        return;
      }
      label109:
      throw localObject2;
    }
    
    public void onFileDownloadStarted()
    {
      Vector localVector = URLState.this.callbacks;
      int i = 0;
      for (;;)
      {
        Object localObject1;
        int j;
        try
        {
          if (i < URLState.this.callbacks.size())
          {
            localObject1 = (WeakReference)URLState.this.callbacks.get(i);
            if ((localObject1 == null) || (((WeakReference)localObject1).get() == null))
            {
              localObject1 = URLState.this.callbacks;
              j = i - 1;
            }
          }
        }
        finally {}
        try
        {
          ((Vector)localObject1).remove(i);
          i = j;
          i += 1;
        }
        finally
        {
          break;
        }
        ((URLState.Callback)((WeakReference)localObject1).get()).onFileDownloadStarted();
        continue;
        return;
      }
      throw localObject2;
    }
    
    public void onFileDownloadSucceed(long paramLong)
    {
      Vector localVector = URLState.this.callbacks;
      int i = 0;
      for (;;)
      {
        Object localObject1;
        int j;
        try
        {
          if (i < URLState.this.callbacks.size())
          {
            localObject1 = (WeakReference)URLState.this.callbacks.get(i);
            if ((localObject1 == null) || (((WeakReference)localObject1).get() == null))
            {
              localObject1 = URLState.this.callbacks;
              j = i - 1;
            }
          }
        }
        finally {}
        try
        {
          ((Vector)localObject1).remove(i);
          i = j;
          i += 1;
        }
        finally
        {
          break label111;
        }
        ((URLState.Callback)((WeakReference)localObject1).get()).onFileDownloadSucceed(paramLong);
        continue;
        return;
      }
      label111:
      throw localObject2;
    }
    
    protected void onPostExecute(Object paramObject)
    {
      if (isCancelled())
      {
        onCancelled();
        return;
      }
      URLState.this.onResult(paramObject);
    }
    
    protected void onProgressUpdate(Integer... paramVarArgs)
    {
      int k = paramVarArgs[(paramVarArgs.length - 1)].intValue();
      if (k == URLState.this.mProgress) {}
      do
      {
        return;
        URLState.this.mProgress = k;
      } while ((URLDrawable.sPause) && (!URLState.this.mIgnorePause));
      Vector localVector = URLState.this.callbacks;
      int i = 0;
      for (;;)
      {
        int j;
        try
        {
          if (i < URLState.this.callbacks.size())
          {
            paramVarArgs = (WeakReference)URLState.this.callbacks.get(i);
            if ((paramVarArgs == null) || (paramVarArgs.get() == null))
            {
              paramVarArgs = URLState.this.callbacks;
              j = i - 1;
            }
          }
        }
        finally {}
        try
        {
          paramVarArgs.remove(i);
          i = j;
          i += 1;
        }
        finally
        {
          break;
        }
        ((URLState.Callback)paramVarArgs.get()).onUpdateProgress(k);
        continue;
        return;
      }
      throw paramVarArgs;
    }
    
    public void publishProgress(int paramInt)
    {
      publishProgress(new Integer[] { Integer.valueOf(paramInt) });
    }
  }
  
  private class PostOnResult
    implements Runnable
  {
    Object result;
    
    public PostOnResult(Object paramObject)
    {
      this.result = paramObject;
    }
    
    public void run()
    {
      URLState.this.onResult(this.result);
    }
  }
  
  class PreDownloadAsyncTask
    extends AsyncTask<Void, Void, Integer>
  {
    private static final int DOWNLOAD_THREAD_POOL = 1;
    private static final int LOCAL_THREAD_POOL = 0;
    URLState.DownloadAsyncTask mDownloadTask;
    private URL url;
    
    PreDownloadAsyncTask(URL paramURL)
    {
      this.url = paramURL;
      this.mDownloadTask = new URLState.DownloadAsyncTask(URLState.this);
    }
    
    protected Integer doInBackground(Void... paramVarArgs)
    {
      if ((Build.VERSION.SDK_INT >= 11) && (URLState.this.mProtocolDownloader != null) && (URLState.this.mProtocolDownloader.hasDiskFile(URLState.this.mParams))) {
        return Integer.valueOf(0);
      }
      return Integer.valueOf(1);
    }
    
    protected void onCancelled() {}
    
    protected void onPostExecute(Integer paramInteger)
    {
      if (this.mDownloadTask.getStatus() == AsyncTask.Status.FINISHED) {
        return;
      }
      for (;;)
      {
        try
        {
          if (paramInteger.intValue() == 0)
          {
            Utils.executeAsyncTaskOnNewThreadPool(URLDrawable.sDefaultDrawableParms.mURLDrawableFileExecutor, this.mDownloadTask, new URL[] { this.url });
            URLState.this.onLoadStart();
            return;
          }
        }
        catch (RejectedExecutionException paramInteger)
        {
          if (QLog.isColorLevel()) {
            QLog.e("URLDrawable_", 2, "onPostExecute(): execute AsyncTask failed.", paramInteger);
          }
          URLState localURLState = URLState.this;
          localURLState.mIsLoadingStarted -= 1;
          URLState.this.onLoadFailed(paramInteger);
          return;
        }
        if (URLState.this.mUseThreadPool) {
          Utils.executeAsyncTaskOnNewThreadPool(URLDrawable.sDefaultDrawableParms.mURLDrawableExecutor, this.mDownloadTask, new URL[] { this.url });
        } else {
          Utils.executeAsyncTaskOnSerialExcuter(this.mDownloadTask, new URL[] { this.url });
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.image.URLState
 * JD-Core Version:    0.7.0.1
 */