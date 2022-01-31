package com.tencent.image;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.support.v4.util.LruCache;
import android.support.v4.util.MQLruCache;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.animation.AnimationUtils;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;
import java.net.URLStreamHandlerFactory;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.apache.http.Header;
import org.apache.http.client.CookieStore;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.apache.http.message.BasicHeader;

public class URLDrawable
  extends Drawable
  implements Drawable.Callback, Runnable, URLState.Callback
{
  static final int ANIMATION_DURATION = 600;
  public static final int CANCLED = 3;
  public static boolean DEBUG = false;
  public static final int FAILED = 2;
  public static final int FILE_DOWNLOADED = 4;
  public static final int LOADING = 0;
  private static final int PENDING_ACTION_CAPACITY = 100;
  public static final int SUCCESSED = 1;
  static final String TAG = "URLDrawable_";
  static Context mApplicationContext;
  static URLDrawableParams sDefaultDrawableParms;
  static MQLruCache<String, Object> sMemoryCache;
  static boolean sPause = false;
  static Object sPauseLock = new Object();
  private static final LruCache<URLDrawable, LruCache> sPendingActions = new LruCache(100);
  private static URLStreamHandlerFactory sStreamHandler = new URLStreamHandlerFactory()
  {
    URLStreamHandler handler = new URLStreamHandler()
    {
      protected URLConnection openConnection(URL paramAnonymous2URL)
        throws IOException
      {
        return null;
      }
    };
    
    public URLStreamHandler createURLStreamHandler(String paramAnonymousString)
    {
      if (("http".equalsIgnoreCase(paramAnonymousString)) || ("https".equalsIgnoreCase(paramAnonymousString)) || ("file".equalsIgnoreCase(paramAnonymousString))) {
        return null;
      }
      return this.handler;
    }
  };
  private int mAlpha = 255;
  private boolean mAutoDownload = true;
  private ColorFilter mColorFilter;
  private CookieStore mCookies;
  private Drawable mCurrDrawable;
  protected URLState mDrawableContainerState;
  private Matrix mExifMatrix;
  private long mFadeInAnimationStartTime = -1L;
  private boolean mFadeInAnimationStarted = false;
  boolean mFadeInImage;
  private Drawable mFailedDrawable;
  private float mGifRoundCorner;
  private Header[] mHeaders;
  private URLDrawableListener mListener;
  private int mProgress = 0;
  private Drawable mProgressDrawable;
  private Object mTag;
  private int mTargetDensity = 160;
  private boolean mUseExifOrientation = true;
  private boolean mUseGifAnimation;
  
  URLDrawable(URLState paramURLState, Resources paramResources)
  {
    this.mDrawableContainerState = paramURLState;
    if (paramURLState.mStatus == 1)
    {
      this.mCurrDrawable = this.mDrawableContainerState.mSuccessed.newDrawable(paramResources);
      this.mCurrDrawable.setCallback(this);
      return;
    }
    this.mDrawableContainerState.addCallBack(this);
  }
  
  private URLDrawable(URL paramURL, URLDrawableOptions paramURLDrawableOptions)
  {
    this.mDrawableContainerState = new URLState(paramURL, paramURLDrawableOptions);
    this.mFailedDrawable = paramURLDrawableOptions.mFailedDrawable;
    this.mCurrDrawable = paramURLDrawableOptions.mLoadingDrawable;
    if ((this.mCurrDrawable == null) && (sDefaultDrawableParms.getDefaultLoadingDrawable() != null)) {
      this.mCurrDrawable = sDefaultDrawableParms.getDefaultLoadingDrawable();
    }
    this.mDrawableContainerState.addCallBack(this);
  }
  
  private static URLDrawable autoScale(Resources paramResources, URLDrawable paramURLDrawable)
  {
    if (sDefaultDrawableParms.mAutoScaleByDensity)
    {
      if (paramResources != null) {
        paramURLDrawable.setTargetDensity(paramResources.getDisplayMetrics().densityDpi);
      }
    }
    else {
      return paramURLDrawable;
    }
    paramURLDrawable.setTargetDensity(sDefaultDrawableParms.mDeviceDensity);
    return paramURLDrawable;
  }
  
  private static void checkParams()
  {
    if (sDefaultDrawableParms == null) {
      throw new IllegalStateException("Default params is not seted, please call setURLDrawableParams first");
    }
  }
  
  public static void clearMemoryCache()
  {
    sMemoryCache.evictAll();
  }
  
  /* Error */
  public static URLDrawable getDrawable(java.io.File paramFile, URLDrawableOptions paramURLDrawableOptions)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 224	java/io/File:toURL	()Ljava/net/URL;
    //   4: astore_0
    //   5: aload_0
    //   6: ifnull +33 -> 39
    //   9: aload_0
    //   10: aload_1
    //   11: invokestatic 227	com/tencent/image/URLDrawable:getDrawable	(Ljava/net/URL;Lcom/tencent/image/URLDrawable$URLDrawableOptions;)Lcom/tencent/image/URLDrawable;
    //   14: areturn
    //   15: astore_0
    //   16: iconst_0
    //   17: ifeq +22 -> 39
    //   20: aconst_null
    //   21: aload_1
    //   22: invokestatic 227	com/tencent/image/URLDrawable:getDrawable	(Ljava/net/URL;Lcom/tencent/image/URLDrawable$URLDrawableOptions;)Lcom/tencent/image/URLDrawable;
    //   25: areturn
    //   26: astore_0
    //   27: iconst_0
    //   28: ifeq +9 -> 37
    //   31: aconst_null
    //   32: aload_1
    //   33: invokestatic 227	com/tencent/image/URLDrawable:getDrawable	(Ljava/net/URL;Lcom/tencent/image/URLDrawable$URLDrawableOptions;)Lcom/tencent/image/URLDrawable;
    //   36: areturn
    //   37: aload_0
    //   38: athrow
    //   39: aconst_null
    //   40: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	41	0	paramFile	java.io.File
    //   0	41	1	paramURLDrawableOptions	URLDrawableOptions
    // Exception table:
    //   from	to	target	type
    //   0	5	15	java/net/MalformedURLException
    //   0	5	26	finally
  }
  
  @Deprecated
  public static URLDrawable getDrawable(String paramString)
    throws IllegalArgumentException
  {
    return getDrawable(paramString, null, null);
  }
  
  @Deprecated
  public static URLDrawable getDrawable(String paramString, int paramInt1, int paramInt2)
    throws IllegalArgumentException
  {
    return getDrawable(paramString, paramInt1, paramInt2, null, null);
  }
  
  @Deprecated
  public static URLDrawable getDrawable(String paramString, int paramInt1, int paramInt2, Drawable paramDrawable1, Drawable paramDrawable2)
    throws IllegalArgumentException
  {
    return getDrawable(paramString, paramInt1, paramInt2, paramDrawable1, paramDrawable2, false);
  }
  
  @Deprecated
  public static URLDrawable getDrawable(String paramString, int paramInt1, int paramInt2, Drawable paramDrawable1, Drawable paramDrawable2, boolean paramBoolean)
    throws IllegalArgumentException
  {
    try
    {
      paramDrawable1 = getDrawable(new URL(paramString), paramInt1, paramInt2, paramDrawable1, paramDrawable2, paramBoolean, 0.0F);
      return paramDrawable1;
    }
    catch (MalformedURLException paramDrawable1)
    {
      throw new IllegalArgumentException("illegal url format: " + paramString);
    }
  }
  
  @Deprecated
  public static URLDrawable getDrawable(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
    throws IllegalArgumentException
  {
    return getDrawable(paramString, paramInt1, paramInt2, null, null, paramBoolean);
  }
  
  @Deprecated
  public static URLDrawable getDrawable(String paramString, Drawable paramDrawable1, Drawable paramDrawable2)
    throws IllegalArgumentException
  {
    return getDrawable(paramString, 0, 0, paramDrawable1, paramDrawable2);
  }
  
  @Deprecated
  public static URLDrawable getDrawable(String paramString, Drawable paramDrawable1, Drawable paramDrawable2, boolean paramBoolean)
    throws IllegalArgumentException
  {
    return getDrawable(paramString, 0, 0, paramDrawable1, paramDrawable2, paramBoolean);
  }
  
  public static URLDrawable getDrawable(String paramString, URLDrawableOptions paramURLDrawableOptions)
  {
    try
    {
      paramURLDrawableOptions = getDrawable(new URL(paramString), paramURLDrawableOptions);
      return paramURLDrawableOptions;
    }
    catch (MalformedURLException paramURLDrawableOptions)
    {
      throw new IllegalArgumentException("illegal url format: " + paramString);
    }
  }
  
  @Deprecated
  public static URLDrawable getDrawable(String paramString, boolean paramBoolean)
    throws IllegalArgumentException
  {
    return getDrawable(paramString, null, null, paramBoolean);
  }
  
  @Deprecated
  public static URLDrawable getDrawable(URL paramURL)
  {
    return getDrawable(paramURL, null, null);
  }
  
  @Deprecated
  public static URLDrawable getDrawable(URL paramURL, int paramInt1, int paramInt2)
  {
    return getDrawable(paramURL, paramInt1, paramInt2, null, null);
  }
  
  @Deprecated
  public static URLDrawable getDrawable(URL paramURL, int paramInt1, int paramInt2, Drawable paramDrawable1, Drawable paramDrawable2)
  {
    return getDrawable(paramURL, paramInt1, paramInt2, paramDrawable1, paramDrawable2, false, 0.0F);
  }
  
  @Deprecated
  public static URLDrawable getDrawable(URL paramURL, int paramInt1, int paramInt2, Drawable paramDrawable1, Drawable paramDrawable2, boolean paramBoolean)
  {
    return getDrawable(paramURL, paramInt1, paramInt2, paramDrawable1, paramDrawable2, paramBoolean, 0.0F);
  }
  
  @Deprecated
  public static URLDrawable getDrawable(URL paramURL, int paramInt1, int paramInt2, Drawable paramDrawable1, Drawable paramDrawable2, boolean paramBoolean, float paramFloat)
  {
    URLDrawableOptions localURLDrawableOptions = new URLDrawableOptions();
    localURLDrawableOptions.mRequestWidth = paramInt1;
    localURLDrawableOptions.mRequestHeight = paramInt2;
    localURLDrawableOptions.mLoadingDrawable = paramDrawable1;
    localURLDrawableOptions.mFailedDrawable = paramDrawable2;
    localURLDrawableOptions.mPlayGifImage = paramBoolean;
    localURLDrawableOptions.mGifRoundCorner = paramFloat;
    return getDrawable(paramURL, localURLDrawableOptions);
  }
  
  @Deprecated
  public static URLDrawable getDrawable(URL paramURL, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    return getDrawable(paramURL, paramInt1, paramInt2, null, null, paramBoolean, 0.0F);
  }
  
  @Deprecated
  public static URLDrawable getDrawable(URL paramURL, Drawable paramDrawable1, Drawable paramDrawable2)
  {
    return getDrawable(paramURL, 0, 0, paramDrawable1, paramDrawable2);
  }
  
  @Deprecated
  public static URLDrawable getDrawable(URL paramURL, Drawable paramDrawable1, Drawable paramDrawable2, boolean paramBoolean)
  {
    return getDrawable(paramURL, 0, 0, paramDrawable1, paramDrawable2, paramBoolean, 0.0F);
  }
  
  public static URLDrawable getDrawable(URL paramURL, URLDrawableOptions paramURLDrawableOptions)
  {
    for (;;)
    {
      URLDrawableOptions localURLDrawableOptions;
      int i;
      try
      {
        checkParams();
        localURLDrawableOptions = paramURLDrawableOptions;
        if (paramURLDrawableOptions == null) {
          localURLDrawableOptions = new URLDrawableOptions();
        }
        localObject = URLState.getConstants(paramURL.toString());
        if (localObject == null) {
          break label304;
        }
        paramURL = (URLDrawable)((URLState)localObject).newDrawable(null);
        if (((URLState)localObject).mParams.mAutoScaleByDensity)
        {
          paramURL = autoScale(null, paramURL);
          paramURL.mUseExifOrientation = localURLDrawableOptions.mUseExifOrientation;
          i = paramURL.getStatus();
          if (i != 1) {
            break label150;
          }
          if ((paramURL.mCurrDrawable instanceof GifDrawable))
          {
            ((GifDrawable)paramURL.mCurrDrawable).mUseAnimation = localURLDrawableOptions.mPlayGifImage;
            paramURLDrawableOptions = paramURL;
            return paramURLDrawableOptions;
          }
        }
        else
        {
          continue;
        }
        paramURLDrawableOptions = paramURL;
        if (!(paramURL.mCurrDrawable instanceof ApngDrawable)) {
          continue;
        }
        ((ApngDrawable)paramURL.mCurrDrawable).mUseAnimation = localURLDrawableOptions.mPlayGifImage;
        paramURLDrawableOptions = paramURL;
        continue;
        paramURL.mUseGifAnimation = localURLDrawableOptions.mPlayGifImage;
      }
      finally {}
      label150:
      paramURL.mGifRoundCorner = localURLDrawableOptions.mGifRoundCorner;
      paramURL.mFadeInImage = sDefaultDrawableParms.mFadeInImage;
      if (i == 2)
      {
        paramURLDrawableOptions = sDefaultDrawableParms.getDefualtFailedDrawable();
        if ((localURLDrawableOptions.mFailedDrawable == null) && (paramURLDrawableOptions != null)) {}
        for (;;)
        {
          paramURL.mFailedDrawable = paramURLDrawableOptions;
          paramURL.mCurrDrawable = paramURL.mFailedDrawable;
          paramURLDrawableOptions = paramURL;
          break;
          paramURLDrawableOptions = localURLDrawableOptions.mFailedDrawable;
        }
      }
      paramURL.mFailedDrawable = localURLDrawableOptions.mFailedDrawable;
      paramURLDrawableOptions = sDefaultDrawableParms.getDefaultLoadingDrawable();
      if ((localURLDrawableOptions.mLoadingDrawable == null) && (paramURLDrawableOptions != null)) {}
      for (;;)
      {
        paramURL.mProgressDrawable = paramURLDrawableOptions;
        paramURL.mCurrDrawable = paramURL.mProgressDrawable;
        paramURLDrawableOptions = paramURL;
        if (i != 4) {
          break;
        }
        paramURLDrawableOptions = ((URLState)localObject).mParams;
        paramURLDrawableOptions = paramURL;
        if (localURLDrawableOptions.mRequestWidth == 0) {
          break;
        }
        i = localURLDrawableOptions.mRequestHeight;
        paramURLDrawableOptions = paramURL;
        break;
        paramURLDrawableOptions = localURLDrawableOptions.mLoadingDrawable;
      }
      label304:
      paramURLDrawableOptions = new URLDrawable(paramURL, localURLDrawableOptions);
      paramURLDrawableOptions.mUseGifAnimation = localURLDrawableOptions.mPlayGifImage;
      paramURLDrawableOptions.mGifRoundCorner = localURLDrawableOptions.mGifRoundCorner;
      paramURLDrawableOptions.mFadeInImage = sDefaultDrawableParms.mFadeInImage;
      paramURLDrawableOptions.mUseExifOrientation = localURLDrawableOptions.mUseExifOrientation;
      Object localObject = paramURLDrawableOptions.mDrawableContainerState.mParams;
      ((DownloadParams)localObject).url = paramURL;
      ((DownloadParams)localObject).urlStr = paramURL.toString();
      if (localURLDrawableOptions.mUseAutoScaleParams) {
        ((DownloadParams)localObject).mAutoScaleByDensity = sDefaultDrawableParms.mAutoScaleByDensity;
      }
      if ((localURLDrawableOptions.mRequestWidth == 0) || (localURLDrawableOptions.mRequestHeight == 0)) {
        ((DownloadParams)localObject).reqWidth = sDefaultDrawableParms.mReqWidth;
      }
      for (((DownloadParams)localObject).reqHeight = sDefaultDrawableParms.mReqHeight; localURLDrawableOptions.mUseAutoScaleParams; ((DownloadParams)localObject).reqHeight = localURLDrawableOptions.mRequestHeight)
      {
        paramURL = autoScale(null, paramURLDrawableOptions);
        break label465;
        ((DownloadParams)localObject).reqWidth = localURLDrawableOptions.mRequestWidth;
      }
      paramURL = paramURLDrawableOptions;
      label465:
      paramURLDrawableOptions = paramURL;
    }
  }
  
  @Deprecated
  public static URLDrawable getDrawable(URL paramURL, boolean paramBoolean)
  {
    return getDrawable(paramURL, null, null, paramBoolean);
  }
  
  public static void init(Context paramContext, URLDrawableParams paramURLDrawableParams)
  {
    URL.setURLStreamHandlerFactory(sStreamHandler);
    if (sDefaultDrawableParms != null) {
      throw new IllegalArgumentException("please don't call setURLDrawableParams twice");
    }
    sDefaultDrawableParms = paramURLDrawableParams;
    if (paramURLDrawableParams.mMemoryCache == null) {}
    for (sMemoryCache = new MQLruCache(paramURLDrawableParams.mMemoryCacheSize)
        {
          protected int sizeOfObj(String paramAnonymousString, Object paramAnonymousObject)
          {
            if (paramAnonymousObject != null)
            {
              if ((paramAnonymousObject instanceof Pair)) {
                return ((Integer)((Pair)paramAnonymousObject).second).intValue();
              }
              if ((paramAnonymousObject instanceof Bitmap))
              {
                paramAnonymousString = (Bitmap)paramAnonymousObject;
                return paramAnonymousString.getRowBytes() * paramAnonymousString.getHeight();
              }
            }
            return 12;
          }
        };; sMemoryCache = paramURLDrawableParams.mMemoryCache)
    {
      mApplicationContext = paramContext;
      return;
    }
  }
  
  public static void pause()
  {
    synchronized (sPauseLock)
    {
      sPause = true;
      return;
    }
  }
  
  public static void removeMemoryCacheByUrl(String paramString)
  {
    sMemoryCache.remove(paramString);
  }
  
  public static void resume()
  {
    synchronized (sPauseLock)
    {
      sPause = false;
      sPauseLock.notifyAll();
      Iterator localIterator = sPendingActions.snapshot().keySet().iterator();
      if (!localIterator.hasNext()) {
        return;
      }
      URLDrawable localURLDrawable = (URLDrawable)localIterator.next();
      localURLDrawable.scheduleSelf(localURLDrawable, SystemClock.uptimeMillis() + 1L);
      sPendingActions.remove(localURLDrawable);
    }
  }
  
  public void addCookies(String paramString1, String paramString2)
  {
    if (this.mCookies == null) {
      this.mCookies = new BasicCookieStore();
    }
    this.mCookies.addCookie(new BasicClientCookie(paramString1, paramString2));
  }
  
  public void addHeader(String paramString1, String paramString2)
  {
    if ((this.mHeaders == null) || (this.mHeaders.length == 0))
    {
      this.mHeaders = new Header[] { new BasicHeader(paramString1, paramString2) };
      return;
    }
    Header[] arrayOfHeader = new Header[this.mHeaders.length + 1];
    System.arraycopy(this.mHeaders, 0, arrayOfHeader, 0, this.mHeaders.length);
    arrayOfHeader[this.mHeaders.length] = new BasicHeader(paramString1, paramString2);
    this.mHeaders = arrayOfHeader;
  }
  
  public void cancelDownload()
  {
    cancelDownload(false);
  }
  
  public void cancelDownload(boolean paramBoolean)
  {
    URLState.DownloadAsyncTask localDownloadAsyncTask = this.mDrawableContainerState.mTask;
    if (localDownloadAsyncTask != null) {
      localDownloadAsyncTask.cancel(paramBoolean);
    }
  }
  
  public void downloadImediatly()
  {
    this.mDrawableContainerState.downloadImediatly(this.mHeaders, this.mCookies, this.mTag, true, this.mUseGifAnimation, this.mGifRoundCorner);
  }
  
  public void downloadImediatly(boolean paramBoolean)
  {
    this.mDrawableContainerState.downloadImediatly(this.mHeaders, this.mCookies, this.mTag, paramBoolean, this.mUseGifAnimation, this.mGifRoundCorner);
  }
  
  public void draw(Canvas paramCanvas)
  {
    int i;
    if (this.mCurrDrawable != null)
    {
      i = paramCanvas.save();
      if ((this.mFadeInImage) && (this.mFadeInAnimationStarted))
      {
        long l = AnimationUtils.currentAnimationTimeMillis();
        if (this.mFadeInAnimationStartTime == -1L) {
          this.mFadeInAnimationStartTime = l;
        }
        float f = (float)(l - this.mFadeInAnimationStartTime) / 600.0F;
        if ((f < 0.0F) || (f > 1.0F)) {
          break label227;
        }
        int j = Math.min((int)(255.0F * (1.0F - (1.0F - f) * (1.0F - f))), 255);
        Rect localRect = getBounds();
        paramCanvas.saveLayerAlpha(localRect.left, localRect.top, localRect.width(), localRect.height(), j, 20);
        invalidateSelf();
      }
    }
    for (;;)
    {
      if (this.mExifMatrix != null) {
        paramCanvas.concat(this.mExifMatrix);
      }
      this.mCurrDrawable.draw(paramCanvas);
      if ((getStatus() == 0) && (this.mProgressDrawable != null) && (this.mDrawableContainerState.mIsLoadingStarted == 1)) {
        this.mProgressDrawable.draw(paramCanvas);
      }
      paramCanvas.restoreToCount(i);
      if (this.mAutoDownload)
      {
        if ((sPause) && (!this.mDrawableContainerState.mIgnorePause)) {
          break;
        }
        startDownload();
      }
      return;
      label227:
      this.mFadeInAnimationStarted = false;
    }
    sPendingActions.put(this, sPendingActions);
  }
  
  public Drawable.ConstantState getConstantState()
  {
    return this.mDrawableContainerState;
  }
  
  public Drawable getCurrDrawable()
  {
    return this.mCurrDrawable;
  }
  
  public int getExifOrientation()
  {
    if ((this.mDrawableContainerState.mStatus == 1) && (this.mCurrDrawable != null)) {
      return this.mDrawableContainerState.mOrientation;
    }
    return 0;
  }
  
  public Header getHeader(String paramString)
  {
    Header[] arrayOfHeader;
    int j;
    int i;
    if (this.mHeaders != null)
    {
      arrayOfHeader = this.mHeaders;
      j = arrayOfHeader.length;
      i = 0;
    }
    for (;;)
    {
      Object localObject;
      if (i >= j) {
        localObject = null;
      }
      Header localHeader;
      do
      {
        return localObject;
        localHeader = arrayOfHeader[i];
        if (paramString == null) {
          break;
        }
        localObject = localHeader;
      } while (paramString.equals(localHeader.getName()));
      i += 1;
    }
  }
  
  public Header[] getHeaders()
  {
    return this.mHeaders;
  }
  
  public int getIntrinsicHeight()
  {
    if ((this.mUseExifOrientation) && (this.mDrawableContainerState.mStatus == 1) && (this.mCurrDrawable != null))
    {
      switch (this.mDrawableContainerState.mOrientation)
      {
      default: 
        if (this.mDrawableContainerState.mHeight > 0) {
          return this.mDrawableContainerState.mHeight;
        }
        break;
      case 5: 
      case 6: 
      case 7: 
      case 8: 
        if (this.mDrawableContainerState.mWidth > 0) {
          return this.mDrawableContainerState.mWidth;
        }
        return this.mCurrDrawable.getIntrinsicWidth();
      }
      return this.mCurrDrawable.getIntrinsicHeight();
    }
    if (this.mDrawableContainerState.mHeight > 0) {
      return this.mDrawableContainerState.mHeight;
    }
    if (this.mCurrDrawable != null) {
      return this.mCurrDrawable.getIntrinsicHeight();
    }
    return -1;
  }
  
  public int getIntrinsicWidth()
  {
    if ((this.mUseExifOrientation) && (this.mDrawableContainerState.mStatus == 1) && (this.mCurrDrawable != null))
    {
      switch (this.mDrawableContainerState.mOrientation)
      {
      default: 
        if (this.mDrawableContainerState.mWidth > 0) {
          return this.mDrawableContainerState.mWidth;
        }
        break;
      case 5: 
      case 6: 
      case 7: 
      case 8: 
        if (this.mDrawableContainerState.mHeight > 0) {
          return this.mDrawableContainerState.mHeight;
        }
        return this.mCurrDrawable.getIntrinsicHeight();
      }
      return this.mCurrDrawable.getIntrinsicWidth();
    }
    if (this.mDrawableContainerState.mWidth > 0) {
      return this.mDrawableContainerState.mWidth;
    }
    if (this.mCurrDrawable != null) {
      return this.mCurrDrawable.getIntrinsicWidth();
    }
    return -1;
  }
  
  public int getOpacity()
  {
    return -2;
  }
  
  public boolean getPadding(Rect paramRect)
  {
    if (this.mCurrDrawable != null) {
      return this.mCurrDrawable.getPadding(paramRect);
    }
    return super.getPadding(paramRect);
  }
  
  public int getProgress()
  {
    return this.mProgress;
  }
  
  public int getStatus()
  {
    return this.mDrawableContainerState.mStatus;
  }
  
  public Object getTag()
  {
    return this.mTag;
  }
  
  public URL getURL()
  {
    return this.mDrawableContainerState.mUrl;
  }
  
  public void invalidateDrawable(Drawable paramDrawable)
  {
    invalidateSelf();
  }
  
  public boolean isAnim()
  {
    return ((this.mCurrDrawable instanceof GifDrawable)) || ((this.mCurrDrawable instanceof ApngDrawable));
  }
  
  public boolean isDownloadStarted()
  {
    return this.mDrawableContainerState.mIsLoadingStarted == 1;
  }
  
  public boolean isFakeSize()
  {
    return (this.mDrawableContainerState.mWidth != 0) && (this.mDrawableContainerState.mHeight != 0);
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    int j;
    float f1;
    int k;
    float f2;
    Rect localRect;
    Matrix localMatrix;
    if ((this.mUseExifOrientation) && (this.mDrawableContainerState.mStatus == 1) && (this.mCurrDrawable != null) && (this.mDrawableContainerState.mOrientation != 0) && (this.mDrawableContainerState.mOrientation != 1))
    {
      j = paramRect.width();
      f1 = j / 2.0F;
      k = paramRect.height();
      f2 = k / 2.0F;
      localRect = new Rect();
      localMatrix = new Matrix();
      switch (this.mDrawableContainerState.mOrientation)
      {
      default: 
        localMatrix = null;
        localRect = paramRect;
        this.mExifMatrix = localMatrix;
        this.mCurrDrawable.setBounds(localRect);
      }
    }
    for (;;)
    {
      if (this.mProgressDrawable != null) {
        this.mProgressDrawable.setBounds(paramRect);
      }
      return;
      localRect.set(0, 0, j, k);
      localMatrix.setTranslate(-f1, -f2);
      localMatrix.postScale(-1.0F, 1.0F);
      localMatrix.postTranslate(paramRect.left + f1, paramRect.top + f2);
      break;
      localRect.set(0, 0, j, k);
      localMatrix.setTranslate(-f1, -f2);
      localMatrix.postScale(1.0F, -1.0F);
      localMatrix.postTranslate(paramRect.left + f1, paramRect.top + f2);
      break;
      if (this.mDrawableContainerState.mOrientation == 5) {}
      for (int i = 90;; i = 270)
      {
        localRect.set(0, 0, j, k);
        localMatrix.setTranslate(-f1, -f2);
        localMatrix.postScale(1.0F, -1.0F);
        localMatrix.postRotate(i);
        localMatrix.postTranslate(paramRect.left + f1, paramRect.top + f2);
        break;
      }
      if (this.mDrawableContainerState.mOrientation == 6) {}
      for (i = 90;; i = 270)
      {
        localRect.set(0, 0, k, j);
        localMatrix.setTranslate(-f2, -f1);
        localMatrix.postRotate(i);
        localMatrix.postTranslate(paramRect.left + f1, paramRect.top + f2);
        break;
      }
      localRect.set(0, 0, j, k);
      localMatrix.setTranslate(-f1, -f2);
      localMatrix.postRotate(180.0F);
      localMatrix.postTranslate(paramRect.left + f1, paramRect.top + f2);
      break;
      if (this.mCurrDrawable != null) {
        this.mCurrDrawable.setBounds(paramRect);
      }
    }
  }
  
  public void onFileDownloaded(URLState paramURLState)
  {
    if ((getStatus() == 4) && (this.mListener != null) && ((this.mListener instanceof URLDrawableListener2))) {
      ((URLDrawableListener2)this.mListener).onFileDownloaded(this);
    }
  }
  
  protected boolean onLevelChange(int paramInt)
  {
    if (this.mCurrDrawable != null) {
      return this.mCurrDrawable.setLevel(paramInt);
    }
    return false;
  }
  
  public void onLoadCanceled(URLState paramURLState)
  {
    if (this.mListener != null) {
      this.mListener.onLoadCanceled(this);
    }
    invalidateSelf();
  }
  
  public void onLoadFailed(URLState paramURLState, Throwable paramThrowable)
  {
    paramURLState = this.mCurrDrawable;
    if (this.mFailedDrawable == null) {
      this.mFailedDrawable = sDefaultDrawableParms.getDefualtFailedDrawable();
    }
    this.mCurrDrawable = this.mFailedDrawable;
    if (this.mCurrDrawable != null)
    {
      this.mCurrDrawable.setAlpha(this.mAlpha);
      this.mCurrDrawable.setVisible(isVisible(), true);
      this.mCurrDrawable.setDither(this.mDrawableContainerState.mDither);
      this.mCurrDrawable.setColorFilter(this.mColorFilter);
      this.mCurrDrawable.setState(getState());
      this.mCurrDrawable.setLevel(getLevel());
      this.mCurrDrawable.setCallback(this);
      this.mCurrDrawable.setBounds(getBounds());
    }
    if (paramURLState != null) {
      paramURLState.setCallback(null);
    }
    this.mDrawableContainerState.mCacheFile = null;
    if (this.mListener != null) {
      this.mListener.onLoadFialed(this, paramThrowable);
    }
    if (this.mFadeInImage) {
      this.mFadeInAnimationStarted = true;
    }
    invalidateSelf();
  }
  
  public void onLoadStarted(URLState paramURLState)
  {
    invalidateSelf();
  }
  
  public void onLoadSuccessed(URLState paramURLState)
  {
    Drawable localDrawable = this.mCurrDrawable;
    paramURLState = paramURLState.mSuccessed.newDrawable();
    paramURLState.setAlpha(this.mAlpha);
    paramURLState.setVisible(isVisible(), true);
    paramURLState.setColorFilter(this.mColorFilter);
    paramURLState.setState(getState());
    paramURLState.setLevel(getLevel());
    paramURLState.setCallback(this);
    paramURLState.setBounds(getBounds());
    if ((paramURLState instanceof RegionDrawable)) {
      ((RegionDrawable)paramURLState).setTargetDensity(this.mTargetDensity);
    }
    for (;;)
    {
      this.mCurrDrawable = paramURLState;
      if (localDrawable != null) {
        localDrawable.setCallback(null);
      }
      if (this.mListener != null) {
        this.mListener.onLoadSuccessed(this);
      }
      if (this.mFadeInImage) {
        this.mFadeInAnimationStarted = true;
      }
      if (this.mProgressDrawable != null)
      {
        this.mProgressDrawable.setCallback(null);
        this.mProgressDrawable = null;
      }
      invalidateSelf();
      return;
      if ((paramURLState instanceof SliceBitmapDrawable))
      {
        ((SliceBitmapDrawable)paramURLState).setTargetDensity(this.mTargetDensity);
      }
      else if ((paramURLState instanceof GifDrawable))
      {
        ((GifDrawable)paramURLState).setTargetDensity(this.mTargetDensity);
        ((GifDrawable)paramURLState).mUseAnimation = this.mUseGifAnimation;
      }
      else if ((paramURLState instanceof ApngDrawable))
      {
        ((ApngDrawable)paramURLState).setTargetDensity(this.mTargetDensity);
        ((ApngDrawable)paramURLState).mUseAnimation = this.mUseGifAnimation;
      }
      else if ((paramURLState instanceof RoundRectDrawable))
      {
        ((RoundRectDrawable)paramURLState).setTargetDensity(this.mTargetDensity);
      }
    }
  }
  
  protected boolean onStateChange(int[] paramArrayOfInt)
  {
    if (this.mCurrDrawable != null) {
      this.mCurrDrawable.setState(paramArrayOfInt);
    }
    return true;
  }
  
  public void onUpdateProgress(int paramInt)
  {
    if (this.mProgressDrawable != null)
    {
      this.mProgressDrawable.setLevel(paramInt);
      invalidateSelf();
    }
    if (this.mListener != null) {
      this.mListener.onLoadProgressed(this, paramInt);
    }
  }
  
  public void restartDownload()
  {
    if (this.mDrawableContainerState.reStartDownload(this.mHeaders, this.mCookies, this.mTag, true, this.mUseGifAnimation, this.mGifRoundCorner, this.mUseExifOrientation)) {
      invalidateSelf();
    }
  }
  
  public void run()
  {
    startDownload();
  }
  
  public String saveTo(String paramString)
    throws IOException
  {
    return this.mDrawableContainerState.saveTo(paramString);
  }
  
  public void scheduleDrawable(Drawable paramDrawable, Runnable paramRunnable, long paramLong)
  {
    scheduleSelf(paramRunnable, paramLong);
  }
  
  public void setAlpha(int paramInt) {}
  
  public void setAutoDownload(boolean paramBoolean)
  {
    this.mAutoDownload = paramBoolean;
    if (paramBoolean) {
      invalidateSelf();
    }
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    if (this.mColorFilter != paramColorFilter)
    {
      this.mColorFilter = paramColorFilter;
      if (this.mCurrDrawable != null) {
        this.mCurrDrawable.setColorFilter(paramColorFilter);
      }
    }
  }
  
  public void setCookies(CookieStore paramCookieStore)
  {
    this.mCookies = paramCookieStore;
  }
  
  public void setDither(boolean paramBoolean)
  {
    if (this.mDrawableContainerState.mDither != paramBoolean)
    {
      this.mDrawableContainerState.mDither = paramBoolean;
      if (this.mCurrDrawable != null) {
        this.mCurrDrawable.setDither(this.mDrawableContainerState.mDither);
      }
    }
  }
  
  public void setFadeInImage(boolean paramBoolean)
  {
    this.mFadeInImage = paramBoolean;
  }
  
  public void setHeaders(Header... paramVarArgs)
  {
    this.mHeaders = paramVarArgs;
  }
  
  public void setIgnorePause(boolean paramBoolean)
  {
    this.mDrawableContainerState.mIgnorePause = paramBoolean;
  }
  
  public void setProgressDrawable(Drawable paramDrawable)
  {
    if (this.mProgressDrawable != paramDrawable)
    {
      if (this.mProgressDrawable != null) {
        this.mProgressDrawable.setCallback(null);
      }
      this.mProgressDrawable = paramDrawable;
      if (this.mProgressDrawable != null)
      {
        this.mProgressDrawable.setCallback(this);
        this.mProgressDrawable.setBounds(getBounds());
        this.mProgressDrawable.setLevel(this.mProgress);
      }
      onUpdateProgress(this.mDrawableContainerState.mProgress);
    }
  }
  
  public void setTag(Object paramObject)
  {
    this.mTag = paramObject;
  }
  
  public void setTargetDensity(int paramInt)
  {
    int i;
    if (paramInt != this.mTargetDensity)
    {
      if (paramInt != 0) {
        break label51;
      }
      i = 160;
      this.mTargetDensity = i;
      if (getStatus() == 1)
      {
        if (!(this.mCurrDrawable instanceof RegionDrawable)) {
          break label56;
        }
        ((RegionDrawable)this.mCurrDrawable).setTargetDensity(paramInt);
      }
    }
    label51:
    label56:
    do
    {
      return;
      i = paramInt;
      break;
      if ((this.mCurrDrawable instanceof SliceBitmapDrawable))
      {
        ((SliceBitmapDrawable)this.mCurrDrawable).setTargetDensity(this.mTargetDensity);
        return;
      }
      if ((this.mCurrDrawable instanceof GifDrawable))
      {
        ((GifDrawable)this.mCurrDrawable).setTargetDensity(paramInt);
        return;
      }
      if ((this.mCurrDrawable instanceof ApngDrawable))
      {
        ((ApngDrawable)this.mCurrDrawable).setTargetDensity(paramInt);
        return;
      }
    } while (!(this.mCurrDrawable instanceof RoundRectDrawable));
    ((RoundRectDrawable)this.mCurrDrawable).setTargetDensity(paramInt);
  }
  
  public void setURLDrawableListener(URLDrawableListener paramURLDrawableListener)
  {
    this.mListener = paramURLDrawableListener;
  }
  
  public boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = super.setVisible(paramBoolean1, paramBoolean2);
    if (this.mCurrDrawable != null) {
      this.mCurrDrawable.setVisible(paramBoolean1, paramBoolean2);
    }
    return bool;
  }
  
  public void startDownload()
  {
    startDownload(true);
  }
  
  public void startDownload(boolean paramBoolean)
  {
    this.mDrawableContainerState.startDownload(this.mHeaders, this.mCookies, this.mTag, paramBoolean, this.mUseGifAnimation, this.mGifRoundCorner, this.mUseExifOrientation);
  }
  
  public void unscheduleDrawable(Drawable paramDrawable, Runnable paramRunnable)
  {
    unscheduleSelf(paramRunnable);
  }
  
  public void updateRegionBitmap(Rect paramRect1, Rect paramRect2, boolean paramBoolean, float paramFloat)
  {
    if (!RegionDrawable.class.isInstance(this.mCurrDrawable)) {
      return;
    }
    Matrix localMatrix1 = this.mExifMatrix;
    if ((localMatrix1 != null) && (!localMatrix1.isIdentity()))
    {
      RectF localRectF = new RectF(paramRect2);
      Matrix localMatrix2 = new Matrix();
      localMatrix1.invert(localMatrix2);
      localMatrix2.mapRect(localRectF);
      localRectF.round(paramRect2);
      localRectF.set(paramRect1);
      localMatrix2.mapRect(localRectF);
      localRectF.round(paramRect1);
    }
    ((RegionDrawable)this.mCurrDrawable).updateRegionRect(paramRect1, paramRect2, paramBoolean, paramFloat);
  }
  
  public static abstract interface URLDrawableListener
  {
    public abstract void onLoadCanceled(URLDrawable paramURLDrawable);
    
    public abstract void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable);
    
    public abstract void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt);
    
    public abstract void onLoadSuccessed(URLDrawable paramURLDrawable);
  }
  
  public static abstract interface URLDrawableListener2
    extends URLDrawable.URLDrawableListener
  {
    public abstract void onFileDownloaded(URLDrawable paramURLDrawable);
  }
  
  public static class URLDrawableOptions
  {
    public Drawable mFailedDrawable = null;
    public float mGifRoundCorner = 0.0F;
    public Drawable mLoadingDrawable = null;
    public boolean mPlayGifImage = false;
    public int mRequestHeight = 0;
    public int mRequestWidth = 0;
    public boolean mUseAutoScaleParams = true;
    public boolean mUseExifOrientation = true;
    public boolean mUseMemoryCache = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.image.URLDrawable
 * JD-Core Version:    0.7.0.1
 */