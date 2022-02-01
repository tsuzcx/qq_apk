package com.tencent.tavsticker.core;

import android.graphics.PointF;
import android.opengl.EGLContext;
import android.view.Surface;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tavsticker.log.TLog;
import com.tencent.tavsticker.model.TAVSourceImage;
import com.tencent.tavsticker.model.TAVSticker;
import com.tencent.tavsticker.model.TAVStickerMode;
import com.tencent.tavsticker.model.TAVStickerProvider;
import com.tencent.tavsticker.model.TAVStickerQuality;
import com.tencent.tavsticker.model.TAVStickerTexture;
import com.tencent.tavsticker.utils.CollectionUtil;
import com.tencent.tavsticker.utils.TAVStickerUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.libpag.PAGSurface;

public class TAVStickerRenderContext
{
  private static final String TAG = TAVStickerRenderContext.class.getSimpleName();
  protected List<TAVStickerRenderContext> mChildContexts = new ArrayList();
  protected volatile PAGSurface mPagSurface = null;
  protected long mPresentationTimeMs = 0L;
  protected List<TAVStickerProvider> mProviders = Collections.synchronizedList(new ArrayList());
  protected TAVStickerQuality mQuality = TAVStickerQuality.TAVStickerQualityHigh;
  protected ITAVRenderContextDataSource mRenderContextDataSource = null;
  protected CGSize mRenderSize = CGSize.CGSizeZero;
  protected int mStickerLayerIndex = 0;
  protected Surface mStickerSurface = null;
  protected TAVStickerTexture mStickerTexture = null;
  protected List<TAVSticker> mStickers = Collections.synchronizedList(new ArrayList());
  
  protected void checkChildContexts()
  {
    if (this.mChildContexts == null) {
      this.mChildContexts = new ArrayList();
    }
  }
  
  protected void checkStickerList()
  {
    if (this.mStickers == null) {
      this.mStickers = Collections.synchronizedList(new ArrayList());
    }
  }
  
  protected void checkStickerProviderList()
  {
    if (this.mProviders == null) {
      this.mProviders = Collections.synchronizedList(new ArrayList());
    }
  }
  
  public boolean containSticker(TAVSticker paramTAVSticker)
  {
    if (paramTAVSticker == null) {
      return false;
    }
    checkStickerList();
    return this.mStickers.contains(paramTAVSticker);
  }
  
  @Deprecated
  public TAVStickerRenderContext copy()
  {
    TAVStickerRenderContext localTAVStickerRenderContext = new TAVStickerRenderContext();
    localTAVStickerRenderContext.checkStickerList();
    if (this.mStickers != null) {
      localTAVStickerRenderContext.mStickers = this.mStickers;
    }
    localTAVStickerRenderContext.setRenderSize(this.mRenderSize);
    localTAVStickerRenderContext.mStickerLayerIndex = this.mStickerLayerIndex;
    localTAVStickerRenderContext.mRenderContextDataSource = this.mRenderContextDataSource;
    localTAVStickerRenderContext.mQuality = this.mQuality;
    checkChildContexts();
    this.mChildContexts.add(localTAVStickerRenderContext);
    return localTAVStickerRenderContext;
  }
  
  public TAVStickerRenderContext copyRenderContext()
  {
    TAVStickerRenderContext localTAVStickerRenderContext = new TAVStickerRenderContext();
    localTAVStickerRenderContext.checkStickerList();
    if (this.mStickers != null) {
      localTAVStickerRenderContext.mStickers = this.mStickers;
    }
    localTAVStickerRenderContext.setRenderSize(this.mRenderSize);
    localTAVStickerRenderContext.mStickerLayerIndex = this.mStickerLayerIndex;
    localTAVStickerRenderContext.mRenderContextDataSource = this.mRenderContextDataSource;
    localTAVStickerRenderContext.mQuality = this.mQuality;
    checkChildContexts();
    this.mChildContexts.add(localTAVStickerRenderContext);
    return localTAVStickerRenderContext;
  }
  
  protected void createSurface()
  {
    try
    {
      if ((TAVStickerUtil.isValidCGSize(this.mRenderSize)) && ((this.mStickerSurface == null) || (!this.mStickerSurface.isValid())))
      {
        if (this.mStickerTexture != null) {
          this.mStickerTexture.release();
        }
        this.mStickerTexture = new TAVStickerTexture((int)this.mRenderSize.width, (int)this.mRenderSize.height);
        if (this.mStickerSurface != null) {
          this.mStickerSurface.release();
        }
        this.mStickerSurface = new Surface(this.mStickerTexture.surfaceTexture());
      }
      return;
    }
    finally {}
  }
  
  public int getStickerCount()
  {
    checkStickerList();
    return this.mStickers.size();
  }
  
  public TAVStickerTexture getStickerTexture()
  {
    return this.mStickerTexture;
  }
  
  public List<TAVSticker> getStickers()
  {
    checkStickerList();
    return this.mStickers;
  }
  
  protected TAVSticker getTouchedSticker(float paramFloat1, float paramFloat2)
  {
    checkStickerList();
    int i = this.mStickers.size() - 1;
    while (i >= 0)
    {
      TAVSticker localTAVSticker = (TAVSticker)this.mStickers.get(i);
      if ((localTAVSticker != null) && (TAVStickerUtil.isPresentationTimeInStickerTimeRange(this.mPresentationTimeMs, localTAVSticker)) && (localTAVSticker.isEditable()) && (isTouchOnTavSticker(localTAVSticker, paramFloat1, paramFloat2))) {
        return localTAVSticker;
      }
      i -= 1;
    }
    return null;
  }
  
  public void getUnderPointLayerItems(float paramFloat1, float paramFloat2, ITAVTouchStickerLayerListener paramITAVTouchStickerLayerListener)
  {
    TAVSticker localTAVSticker;
    if (paramITAVTouchStickerLayerListener != null)
    {
      localTAVSticker = getTouchedSticker(paramFloat1, paramFloat2);
      if (localTAVSticker != null)
      {
        checkStickerProviderList();
        Iterator localIterator = this.mProviders.iterator();
        TAVStickerProvider localTAVStickerProvider;
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localTAVStickerProvider = (TAVStickerProvider)localIterator.next();
        } while ((localTAVStickerProvider == null) || (localTAVSticker != localTAVStickerProvider.getSticker()));
        paramITAVTouchStickerLayerListener.onTouchSticker(localTAVSticker, localTAVStickerProvider.getUnderPointLayerItems(paramFloat1, paramFloat2));
      }
    }
    else
    {
      return;
    }
    paramITAVTouchStickerLayerListener.onTouchSticker(localTAVSticker, null);
  }
  
  protected boolean isTouchOnTavSticker(TAVSticker paramTAVSticker, float paramFloat1, float paramFloat2)
  {
    if (paramTAVSticker == null)
    {
      TLog.e(TAG, "isTouchOnTavSticker -> parameter tavSticker is null!");
      return false;
    }
    if (!TAVStickerUtil.isValidCGSize(this.mRenderSize))
    {
      TLog.e(TAG, "isTouchOnTavSticker -> mRenderSize invalid!");
      return false;
    }
    PointF[] arrayOfPointF = TAVStickerUtil.computeRectanglePoints(TAVStickerUtil.getMatrix(paramTAVSticker, (int)this.mRenderSize.width, (int)this.mRenderSize.height), paramTAVSticker.getWidth(), paramTAVSticker.getHeight());
    TLog.d(TAG, "isTouchOnTavSticker -> x : " + paramFloat1 + ", y : " + paramFloat2);
    if (TAVStickerUtil.inQuadrangle(arrayOfPointF[0], arrayOfPointF[1], arrayOfPointF[2], arrayOfPointF[3], new PointF(paramFloat1, paramFloat2)))
    {
      TLog.d(TAG, "isTouchOnTavSticker -> 点中了贴纸, " + paramTAVSticker.getFilePath());
      return true;
    }
    TLog.d(TAG, "isTouchOnTavSticker -> 没有点中贴纸, " + paramTAVSticker.getFilePath());
    return false;
  }
  
  public void loadSticker(TAVSticker paramTAVSticker)
  {
    loadSticker(paramTAVSticker, false);
  }
  
  public void loadSticker(TAVSticker paramTAVSticker, boolean paramBoolean)
  {
    checkStickerList();
    if ((paramTAVSticker != null) && (!containSticker(paramTAVSticker)))
    {
      paramTAVSticker.setMode(TAVStickerMode.INACTIVE);
      if (-1 == paramTAVSticker.getLayerIndex())
      {
        int i = this.mStickerLayerIndex;
        this.mStickerLayerIndex = (i + 1);
        paramTAVSticker.setLayerIndex(i);
      }
      this.mStickers.add(paramTAVSticker);
      sortedAllStickers();
      reloadAllProviders();
      sortedAllProviders();
      syncAllChildContext();
    }
  }
  
  /* Error */
  public void release()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 56	com/tencent/tavsticker/core/TAVStickerRenderContext:mProviders	Ljava/util/List;
    //   6: invokeinterface 188 1 0
    //   11: astore_1
    //   12: aload_1
    //   13: invokeinterface 193 1 0
    //   18: ifeq +32 -> 50
    //   21: aload_1
    //   22: invokeinterface 197 1 0
    //   27: checkcast 199	com/tencent/tavsticker/model/TAVStickerProvider
    //   30: astore_2
    //   31: aload_2
    //   32: ifnull -20 -> 12
    //   35: aload_2
    //   36: invokevirtual 311	com/tencent/tavsticker/model/TAVStickerProvider:release	()V
    //   39: goto -27 -> 12
    //   42: astore_1
    //   43: aload_1
    //   44: invokevirtual 314	java/lang/Exception:printStackTrace	()V
    //   47: aload_0
    //   48: monitorexit
    //   49: return
    //   50: aload_0
    //   51: getfield 56	com/tencent/tavsticker/core/TAVStickerRenderContext:mProviders	Ljava/util/List;
    //   54: invokeinterface 317 1 0
    //   59: aload_0
    //   60: iconst_0
    //   61: putfield 58	com/tencent/tavsticker/core/TAVStickerRenderContext:mStickerLayerIndex	I
    //   64: aload_0
    //   65: aconst_null
    //   66: putfield 62	com/tencent/tavsticker/core/TAVStickerRenderContext:mRenderContextDataSource	Lcom/tencent/tavsticker/core/ITAVRenderContextDataSource;
    //   69: aload_0
    //   70: getfield 73	com/tencent/tavsticker/core/TAVStickerRenderContext:mPagSurface	Lorg/libpag/PAGSurface;
    //   73: ifnull +22 -> 95
    //   76: aload_0
    //   77: getfield 73	com/tencent/tavsticker/core/TAVStickerRenderContext:mPagSurface	Lorg/libpag/PAGSurface;
    //   80: invokevirtual 322	org/libpag/PAGSurface:freeCache	()V
    //   83: aload_0
    //   84: getfield 73	com/tencent/tavsticker/core/TAVStickerRenderContext:mPagSurface	Lorg/libpag/PAGSurface;
    //   87: invokevirtual 323	org/libpag/PAGSurface:release	()V
    //   90: aload_0
    //   91: aconst_null
    //   92: putfield 73	com/tencent/tavsticker/core/TAVStickerRenderContext:mPagSurface	Lorg/libpag/PAGSurface;
    //   95: aload_0
    //   96: getfield 75	com/tencent/tavsticker/core/TAVStickerRenderContext:mStickerTexture	Lcom/tencent/tavsticker/model/TAVStickerTexture;
    //   99: ifnull +15 -> 114
    //   102: aload_0
    //   103: getfield 75	com/tencent/tavsticker/core/TAVStickerRenderContext:mStickerTexture	Lcom/tencent/tavsticker/model/TAVStickerTexture;
    //   106: invokevirtual 130	com/tencent/tavsticker/model/TAVStickerTexture:release	()V
    //   109: aload_0
    //   110: aconst_null
    //   111: putfield 75	com/tencent/tavsticker/core/TAVStickerRenderContext:mStickerTexture	Lcom/tencent/tavsticker/model/TAVStickerTexture;
    //   114: aload_0
    //   115: getfield 77	com/tencent/tavsticker/core/TAVStickerRenderContext:mStickerSurface	Landroid/view/Surface;
    //   118: ifnull +15 -> 133
    //   121: aload_0
    //   122: getfield 77	com/tencent/tavsticker/core/TAVStickerRenderContext:mStickerSurface	Landroid/view/Surface;
    //   125: invokevirtual 141	android/view/Surface:release	()V
    //   128: aload_0
    //   129: aconst_null
    //   130: putfield 77	com/tencent/tavsticker/core/TAVStickerRenderContext:mStickerSurface	Landroid/view/Surface;
    //   133: getstatic 39	com/tencent/tavsticker/core/TAVStickerRenderContext:TAG	Ljava/lang/String;
    //   136: new 238	java/lang/StringBuilder
    //   139: dup
    //   140: invokespecial 239	java/lang/StringBuilder:<init>	()V
    //   143: ldc_w 325
    //   146: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: invokestatic 331	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   152: invokevirtual 334	java/lang/Thread:getName	()Ljava/lang/String;
    //   155: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: ldc_w 336
    //   161: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: new 338	java/lang/RuntimeException
    //   167: dup
    //   168: invokespecial 339	java/lang/RuntimeException:<init>	()V
    //   171: invokestatic 345	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   174: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: invokevirtual 253	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   180: invokestatic 220	com/tencent/tavsticker/log/TLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   183: goto -136 -> 47
    //   186: astore_1
    //   187: aload_0
    //   188: monitorexit
    //   189: aload_1
    //   190: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	191	0	this	TAVStickerRenderContext
    //   11	11	1	localIterator	Iterator
    //   42	2	1	localException	java.lang.Exception
    //   186	4	1	localObject	Object
    //   30	6	2	localTAVStickerProvider	TAVStickerProvider
    // Exception table:
    //   from	to	target	type
    //   2	12	42	java/lang/Exception
    //   12	31	42	java/lang/Exception
    //   35	39	42	java/lang/Exception
    //   50	95	42	java/lang/Exception
    //   95	114	42	java/lang/Exception
    //   114	133	42	java/lang/Exception
    //   133	183	42	java/lang/Exception
    //   2	12	186	finally
    //   12	31	186	finally
    //   35	39	186	finally
    //   43	47	186	finally
    //   50	95	186	finally
    //   95	114	186	finally
    //   114	133	186	finally
    //   133	183	186	finally
  }
  
  public void reloadAllProviders()
  {
    checkStickerProviderList();
    Object localObject2 = new ArrayList(this.mProviders);
    Object localObject1 = new ArrayList(this.mStickers);
    localObject2 = ((ArrayList)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      TAVStickerProvider localTAVStickerProvider = (TAVStickerProvider)((Iterator)localObject2).next();
      if (localTAVStickerProvider != null)
      {
        TAVSticker localTAVSticker = localTAVStickerProvider.getSticker();
        if (localTAVSticker != null) {
          if (!this.mStickers.contains(localTAVStickerProvider.getSticker()))
          {
            this.mProviders.remove(localTAVStickerProvider);
          }
          else
          {
            localTAVStickerProvider.setRenderSize(this.mRenderSize);
            ((ArrayList)localObject1).remove(localTAVSticker);
          }
        }
      }
    }
    localObject1 = ((ArrayList)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (TAVSticker)((Iterator)localObject1).next();
      if (localObject2 != null)
      {
        localObject2 = new TAVStickerProvider((TAVSticker)localObject2);
        if (TAVStickerQuality.TAVStickerQualityHigh == this.mQuality) {}
        for (boolean bool = true;; bool = false)
        {
          ((TAVStickerProvider)localObject2).setHighQuality(bool);
          ((TAVStickerProvider)localObject2).setRenderSize(this.mRenderSize);
          this.mProviders.add(localObject2);
          break;
        }
      }
    }
  }
  
  public void reloadAllStickers()
  {
    checkStickerList();
    Iterator localIterator = this.mStickers.iterator();
    while (localIterator.hasNext())
    {
      TAVSticker localTAVSticker = (TAVSticker)localIterator.next();
      if (localTAVSticker != null)
      {
        localTAVSticker.updateImageData();
        localTAVSticker.updateTextData();
        localTAVSticker.setMode(TAVStickerMode.INACTIVE);
      }
    }
  }
  
  public void reloadStickers(List<TAVSticker> paramList)
  {
    checkStickerList();
    if (!CollectionUtil.isEmptyList(paramList))
    {
      removeAllStickers();
      this.mStickers.addAll(paramList);
      reloadAllStickers();
      reloadAllProviders();
      sortedAllProviders();
    }
  }
  
  public void removeAllStickers()
  {
    checkStickerList();
    this.mStickers.clear();
    syncAllChildContext();
  }
  
  public boolean removeSticker(TAVSticker paramTAVSticker)
  {
    checkStickerList();
    boolean bool = this.mStickers.remove(paramTAVSticker);
    syncAllChildContext();
    return bool;
  }
  
  public CMSampleBuffer renderSticker(long paramLong, List<TAVSourceImage> paramList, EGLContext paramEGLContext)
  {
    if (!TAVStickerUtil.isValidCGSize(this.mRenderSize))
    {
      TLog.e(TAG, "renderSticker -> mRenderSize is invalid!");
      return null;
    }
    createSurface();
    if (this.mStickerSurface == null)
    {
      TLog.e(TAG, "renderSticker -> mStickerSurface is null!");
      return null;
    }
    if (this.mStickerTexture == null)
    {
      TLog.e(TAG, "renderSticker -> mStickerTexture is null!");
      return null;
    }
    boolean bool = renderSticker(this.mStickerSurface, paramLong, paramList, paramEGLContext);
    return new CMSampleBuffer(new CMTime(TAVStickerUtil.millisecond2Seconds(paramLong)), this.mStickerTexture.getTextureInfo(), bool);
  }
  
  public boolean renderSticker(Surface paramSurface, long paramLong, List<TAVSourceImage> paramList, EGLContext paramEGLContext)
  {
    this.mPresentationTimeMs = paramLong;
    checkStickerList();
    checkStickerProviderList();
    if ((this.mPagSurface == null) && (paramSurface != null)) {
      if (paramEGLContext == null) {
        break label48;
      }
    }
    label48:
    for (this.mPagSurface = PAGSurface.FromSurface(paramSurface, paramEGLContext); this.mPagSurface == null; this.mPagSurface = PAGSurface.FromSurface(paramSurface)) {
      return false;
    }
    if (this.mStickers.size() != this.mProviders.size())
    {
      reloadAllProviders();
      sortedAllProviders();
    }
    paramSurface = this.mProviders.iterator();
    while (paramSurface.hasNext())
    {
      paramEGLContext = (TAVStickerProvider)paramSurface.next();
      if ((paramEGLContext != null) && (shouldRenderSticker(paramEGLContext.getSticker(), paramLong)))
      {
        paramEGLContext.setRenderSize(this.mRenderSize);
        paramEGLContext.setPagSurface(this.mPagSurface);
        paramEGLContext.replaceSourceImages(paramList);
        paramEGLContext.updateRender(paramLong);
      }
    }
    return this.mPagSurface.present();
  }
  
  public void setCacheEnabled(boolean paramBoolean)
  {
    if (this.mProviders != null)
    {
      Iterator localIterator = this.mProviders.iterator();
      while (localIterator.hasNext())
      {
        TAVStickerProvider localTAVStickerProvider = (TAVStickerProvider)localIterator.next();
        if (localTAVStickerProvider != null) {
          localTAVStickerProvider.setCacheEnabled(paramBoolean);
        }
      }
    }
  }
  
  public void setRenderSize(CGSize paramCGSize)
  {
    if ((TAVStickerUtil.isValidCGSize(paramCGSize)) && (!paramCGSize.equals(this.mRenderSize)))
    {
      TLog.d(TAG, "setRenderSize -> render size changed, oldRenderSize : " + this.mRenderSize + ", newRenderSize : " + paramCGSize);
      this.mRenderSize = paramCGSize;
      if (this.mStickerTexture != null) {
        this.mStickerTexture.updateStickerTextureSize((int)this.mRenderSize.width, (int)this.mRenderSize.height);
      }
    }
  }
  
  public void setStickerRenderQuality(TAVStickerQuality paramTAVStickerQuality)
  {
    if (paramTAVStickerQuality != null) {
      this.mQuality = paramTAVStickerQuality;
    }
  }
  
  public void setTavRenderContextDataSource(ITAVRenderContextDataSource paramITAVRenderContextDataSource)
  {
    this.mRenderContextDataSource = paramITAVRenderContextDataSource;
  }
  
  protected boolean shouldRenderSticker(TAVSticker paramTAVSticker, long paramLong)
  {
    if (paramTAVSticker == null) {}
    for (;;)
    {
      return false;
      if (this.mRenderContextDataSource != null) {
        return this.mRenderContextDataSource.shouldRenderSticker(paramTAVSticker, paramLong);
      }
      CMTimeRange localCMTimeRange = paramTAVSticker.getTimeRange();
      if (localCMTimeRange == null) {}
      for (boolean bool = true; (bool) && (TAVStickerMode.INACTIVE == paramTAVSticker.getMode()); bool = localCMTimeRange.containsTime(new CMTime(TAVStickerUtil.millisecond2Seconds(paramLong)))) {
        return true;
      }
    }
  }
  
  protected void sortedAllProviders()
  {
    checkStickerProviderList();
    Collections.sort(this.mProviders, new TAVStickerRenderContext.1(this));
  }
  
  protected void sortedAllStickers()
  {
    checkStickerList();
    Collections.sort(this.mStickers, new TAVStickerRenderContext.2(this));
  }
  
  protected void syncAllChildContext()
  {
    checkChildContexts();
    Iterator localIterator = this.mChildContexts.iterator();
    while (localIterator.hasNext())
    {
      TAVStickerRenderContext localTAVStickerRenderContext = (TAVStickerRenderContext)localIterator.next();
      if (localTAVStickerRenderContext != null)
      {
        localTAVStickerRenderContext.checkStickerList();
        localTAVStickerRenderContext.checkStickerProviderList();
        localTAVStickerRenderContext.mProviders.clear();
        if (this.mStickers != null) {
          localTAVStickerRenderContext.mStickers = this.mStickers;
        }
        localTAVStickerRenderContext.setRenderSize(this.mRenderSize);
        localTAVStickerRenderContext.mStickerLayerIndex = this.mStickerLayerIndex;
        localTAVStickerRenderContext.mRenderContextDataSource = this.mRenderContextDataSource;
        localTAVStickerRenderContext.mQuality = this.mQuality;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tavsticker.core.TAVStickerRenderContext
 * JD-Core Version:    0.7.0.1
 */