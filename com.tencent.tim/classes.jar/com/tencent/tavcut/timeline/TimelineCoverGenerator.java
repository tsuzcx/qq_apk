package com.tencent.tavcut.timeline;

import android.support.annotation.NonNull;
import com.tencent.tav.asset.Asset;
import com.tencent.tav.core.AssetImageGenerator;
import com.tencent.tav.core.AssetImageGenerator.ApertureMode;
import com.tencent.tav.core.composition.VideoComposition;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.decoder.RenderContextParams;
import com.tencent.tavcut.cover.CoverCache;
import com.tencent.tavcut.cover.ICoverGenerator;
import com.tencent.tavcut.util.FloatUtils;
import com.tencent.tavcut.util.Logger;
import com.tencent.tavkit.component.TAVSourceImageGenerator;
import com.tencent.tavkit.composition.TAVSource;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;

public class TimelineCoverGenerator
  implements ICoverGenerator
{
  private static final float SCALE_SIZE = 4.0F;
  public static final String TAG = "TimelineCoverGenerator";
  protected CoverCache mCoverCache;
  protected float mCoverHeight;
  protected ConcurrentHashMap<Long, CoverTask> mCoverTaskMap;
  protected BlockingQueue<CoverTask> mCoverTaskQueue;
  protected float mCoverWidth;
  protected ExecutorService mExecutors;
  protected TAVSourceImageGenerator mImageGenerator;
  protected int mItemCount;
  protected long mItemDurationMs;
  protected float mLastCoverWidth;
  protected volatile boolean mReleased;
  private RenderContextParams mRenderContextParams;
  protected TAVSource mTavSource;
  protected long mTotalDurationMs;
  
  private void realRelease()
  {
    Logger.d("TimelineCoverGenerator", "realRelease: ");
    releaseImageGenerator();
    releaseCache();
    releaseQueue();
    releaseExecutors();
  }
  
  private void releaseCache()
  {
    Logger.d("TimelineCoverGenerator", "releaseCache: ");
    if (this.mCoverCache != null)
    {
      this.mCoverCache.release();
      this.mCoverCache = null;
    }
  }
  
  private void releaseExecutors()
  {
    Logger.d("TimelineCoverGenerator", "releaseExecutors: ");
    if (this.mExecutors != null)
    {
      this.mExecutors.shutdownNow();
      this.mExecutors = null;
    }
  }
  
  private void releaseImageGenerator()
  {
    Logger.d("TimelineCoverGenerator", "releaseImageGenerator: ");
    if (this.mImageGenerator != null)
    {
      if (this.mImageGenerator.getAssetImageGenerator() != null) {
        this.mImageGenerator.getAssetImageGenerator().release();
      }
      this.mImageGenerator = null;
    }
  }
  
  private void releaseQueue()
  {
    Logger.d("TimelineCoverGenerator", "releaseQueue: ");
    if (this.mCoverTaskMap != null)
    {
      this.mCoverTaskMap.clear();
      this.mCoverTaskMap = null;
    }
    if (this.mCoverTaskQueue != null)
    {
      this.mCoverTaskQueue.clear();
      this.mCoverTaskQueue = null;
    }
  }
  
  protected CGSize calculateRenderSize()
  {
    CGSize localCGSize3 = new CGSize(this.mCoverWidth * 4.0F, this.mCoverHeight * 4.0F);
    if ((this.mTavSource == null) || (this.mTavSource.getVideoComposition() == null) || (FloatUtils.isEquals(this.mCoverWidth, 0.0F)) || (FloatUtils.isEquals(this.mCoverHeight, 0.0F))) {
      return localCGSize3;
    }
    CGSize localCGSize2 = this.mTavSource.getVideoComposition().getRenderSize().clone();
    CGSize localCGSize1;
    if ((localCGSize2 != null) && (!FloatUtils.isEquals(localCGSize2.width, 0.0F)))
    {
      localCGSize1 = localCGSize2;
      if (!FloatUtils.isEquals(localCGSize2.height, 0.0F)) {}
    }
    else
    {
      if ((this.mTavSource.getAsset() == null) || (this.mTavSource.getAsset().getNaturalSize() == null)) {
        return localCGSize3;
      }
      localCGSize1 = this.mTavSource.getAsset().getNaturalSize().clone();
    }
    float f = localCGSize1.width / localCGSize1.height;
    if (f > 1.0F)
    {
      localCGSize1.height = (this.mCoverHeight * 4.0F);
      localCGSize1.width = (f * localCGSize1.height);
      return localCGSize1;
    }
    localCGSize1.width = (this.mCoverWidth * 4.0F);
    localCGSize1.height = (localCGSize1.width / f);
    return localCGSize1;
  }
  
  public void generateCoverByIndex(int paramInt, CMTime paramCMTime) {}
  
  public void generateCoverByIndexRange(int paramInt1, int paramInt2)
  {
    if (this.mCoverTaskQueue == null)
    {
      Logger.e("TimelineCoverGenerator", "CoverTaskQueue is null maybe TimelineCoverGenerator was released");
      return;
    }
    int i = paramInt2;
    label17:
    if (i > paramInt1 - 1) {
      if ((this.mCoverCache == null) || (this.mCoverCache.getCover(i) == null)) {
        break label49;
      }
    }
    for (;;)
    {
      i -= 1;
      break label17;
      break;
      label49:
      long l = i * this.mItemDurationMs;
      if ((this.mCoverTaskMap != null) && (this.mCoverTaskMap.containsKey(Long.valueOf(l))))
      {
        CoverTask localCoverTask1 = (CoverTask)this.mCoverTaskMap.get(Long.valueOf(l));
        if (!localCoverTask1.generating)
        {
          this.mCoverTaskQueue.remove(localCoverTask1);
          CoverTask.access$202(localCoverTask1, System.currentTimeMillis() + paramInt2 - i);
          this.mCoverTaskMap.put(Long.valueOf(l), localCoverTask1);
          try
          {
            this.mCoverTaskQueue.put(localCoverTask1);
          }
          catch (InterruptedException localInterruptedException1)
          {
            localInterruptedException1.printStackTrace();
          }
        }
      }
      else
      {
        CoverTask localCoverTask2 = new CoverTask(System.currentTimeMillis() + paramInt2 - i, i);
        try
        {
          this.mCoverTaskQueue.put(localCoverTask2);
        }
        catch (InterruptedException localInterruptedException2)
        {
          localInterruptedException2.printStackTrace();
        }
      }
    }
  }
  
  public void generateCoverByTimeRange(long paramLong1, long paramLong2)
  {
    generateCoverByIndexRange((int)(paramLong1 / this.mItemDurationMs), (int)(paramLong2 / this.mItemDurationMs));
  }
  
  public void init(TAVSource paramTAVSource, long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    this.mTavSource = paramTAVSource;
    this.mItemDurationMs = paramLong;
    this.mItemCount = paramInt1;
    this.mCoverWidth = paramInt2;
    this.mCoverHeight = paramInt3;
    initParams();
  }
  
  public void init(TAVSource paramTAVSource, List<CMTime> paramList, int paramInt1, int paramInt2) {}
  
  protected void initParams()
  {
    try
    {
      this.mTotalDurationMs = (this.mTavSource.getAsset().getDuration().getTimeUs() / 1000L);
      if ((this.mItemDurationMs == 0L) || (this.mTotalDurationMs == 0L)) {
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
      this.mLastCoverWidth = ((float)(this.mTotalDurationMs - (this.mItemCount - 1) * this.mItemDurationMs) * 1.0F / (float)this.mItemDurationMs * this.mCoverWidth);
      if (this.mLastCoverWidth > this.mCoverWidth) {
        this.mLastCoverWidth = this.mCoverWidth;
      }
      Logger.d("TimelineCoverGenerator", "initParams: mItemDurationMs is  " + this.mItemDurationMs);
      Logger.d("TimelineCoverGenerator", "initParams: mItemCount is  " + this.mItemCount);
      Logger.d("TimelineCoverGenerator", "initParams: mTotalDurationMs is  " + this.mTotalDurationMs);
      Logger.d("TimelineCoverGenerator", "initParams: mCoverWidth is " + this.mCoverWidth);
      Logger.d("TimelineCoverGenerator", "initParams: mLastCoverWidth is " + this.mLastCoverWidth);
      this.mImageGenerator = new TAVSourceImageGenerator(this.mTavSource, calculateRenderSize());
      this.mImageGenerator.getAssetImageGenerator().setApertureMode(AssetImageGenerator.ApertureMode.scaleToFit);
      this.mImageGenerator.getAssetImageGenerator().setRenderContextParams(this.mRenderContextParams);
      this.mCoverTaskMap = new ConcurrentHashMap(16);
      this.mCoverTaskQueue = new PriorityBlockingQueue();
      int i = 0;
      for (;;)
      {
        if (i < this.mItemCount)
        {
          CoverTask localCoverTask = new CoverTask(this.mItemCount - i, i);
          Logger.d("TimelineCoverGenerator", "initParams: task.index is " + localCoverTask.index);
          try
          {
            this.mCoverTaskQueue.put(localCoverTask);
            i += 1;
          }
          catch (InterruptedException localInterruptedException)
          {
            for (;;)
            {
              localInterruptedException.printStackTrace();
            }
          }
        }
      }
      this.mExecutors = Executors.newSingleThreadExecutor();
      this.mExecutors.submit(new CoverRunnable());
    }
  }
  
  public void pause() {}
  
  public void release()
  {
    Logger.d("TimelineCoverGenerator", "release: ");
    this.mReleased = true;
    if ((this.mExecutors != null) && (!this.mExecutors.isShutdown()))
    {
      this.mExecutors.submit(new CoverRunnable());
      return;
    }
    releaseQueue();
    releaseCache();
  }
  
  public void resume() {}
  
  public void setCoverCache(CoverCache paramCoverCache)
  {
    this.mCoverCache = paramCoverCache;
  }
  
  public void setRenderContextParamas(RenderContextParams paramRenderContextParams)
  {
    this.mRenderContextParams = paramRenderContextParams;
  }
  
  public class CoverRunnable
    implements Runnable
  {
    public CoverRunnable() {}
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 15	com/tencent/tavcut/timeline/TimelineCoverGenerator$CoverRunnable:this$0	Lcom/tencent/tavcut/timeline/TimelineCoverGenerator;
      //   4: getfield 28	com/tencent/tavcut/timeline/TimelineCoverGenerator:mCoverTaskQueue	Ljava/util/concurrent/BlockingQueue;
      //   7: ifnull +613 -> 620
      //   10: aload_0
      //   11: getfield 15	com/tencent/tavcut/timeline/TimelineCoverGenerator$CoverRunnable:this$0	Lcom/tencent/tavcut/timeline/TimelineCoverGenerator;
      //   14: getfield 28	com/tencent/tavcut/timeline/TimelineCoverGenerator:mCoverTaskQueue	Ljava/util/concurrent/BlockingQueue;
      //   17: invokeinterface 34 1 0
      //   22: ifne +598 -> 620
      //   25: aload_0
      //   26: getfield 15	com/tencent/tavcut/timeline/TimelineCoverGenerator$CoverRunnable:this$0	Lcom/tencent/tavcut/timeline/TimelineCoverGenerator;
      //   29: getfield 38	com/tencent/tavcut/timeline/TimelineCoverGenerator:mImageGenerator	Lcom/tencent/tavkit/component/TAVSourceImageGenerator;
      //   32: ifnull +588 -> 620
      //   35: aload_0
      //   36: getfield 15	com/tencent/tavcut/timeline/TimelineCoverGenerator$CoverRunnable:this$0	Lcom/tencent/tavcut/timeline/TimelineCoverGenerator;
      //   39: getfield 42	com/tencent/tavcut/timeline/TimelineCoverGenerator:mReleased	Z
      //   42: ifne +578 -> 620
      //   45: aload_0
      //   46: getfield 15	com/tencent/tavcut/timeline/TimelineCoverGenerator$CoverRunnable:this$0	Lcom/tencent/tavcut/timeline/TimelineCoverGenerator;
      //   49: getfield 28	com/tencent/tavcut/timeline/TimelineCoverGenerator:mCoverTaskQueue	Ljava/util/concurrent/BlockingQueue;
      //   52: invokeinterface 46 1 0
      //   57: checkcast 48	com/tencent/tavcut/timeline/TimelineCoverGenerator$CoverTask
      //   60: astore 7
      //   62: ldc 50
      //   64: new 52	java/lang/StringBuilder
      //   67: dup
      //   68: invokespecial 53	java/lang/StringBuilder:<init>	()V
      //   71: ldc 55
      //   73: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   76: aload 7
      //   78: invokestatic 63	com/tencent/tavcut/timeline/TimelineCoverGenerator$CoverTask:access$000	(Lcom/tencent/tavcut/timeline/TimelineCoverGenerator$CoverTask;)I
      //   81: invokevirtual 66	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   84: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   87: invokestatic 76	com/tencent/tavcut/util/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
      //   90: ldc 50
      //   92: new 52	java/lang/StringBuilder
      //   95: dup
      //   96: invokespecial 53	java/lang/StringBuilder:<init>	()V
      //   99: ldc 78
      //   101: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   104: aload 7
      //   106: invokestatic 82	com/tencent/tavcut/timeline/TimelineCoverGenerator$CoverTask:access$200	(Lcom/tencent/tavcut/timeline/TimelineCoverGenerator$CoverTask;)J
      //   109: invokevirtual 85	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   112: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   115: invokestatic 76	com/tencent/tavcut/util/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
      //   118: aload 7
      //   120: astore 9
      //   122: aload 9
      //   124: ifnull -124 -> 0
      //   127: aload 9
      //   129: iconst_1
      //   130: invokestatic 89	com/tencent/tavcut/timeline/TimelineCoverGenerator$CoverTask:access$102	(Lcom/tencent/tavcut/timeline/TimelineCoverGenerator$CoverTask;Z)Z
      //   133: pop
      //   134: aload_0
      //   135: getfield 15	com/tencent/tavcut/timeline/TimelineCoverGenerator$CoverRunnable:this$0	Lcom/tencent/tavcut/timeline/TimelineCoverGenerator;
      //   138: getfield 38	com/tencent/tavcut/timeline/TimelineCoverGenerator:mImageGenerator	Lcom/tencent/tavkit/component/TAVSourceImageGenerator;
      //   141: ifnull +577 -> 718
      //   144: ldc 50
      //   146: ldc 91
      //   148: invokestatic 76	com/tencent/tavcut/util/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
      //   151: aload_0
      //   152: getfield 15	com/tencent/tavcut/timeline/TimelineCoverGenerator$CoverRunnable:this$0	Lcom/tencent/tavcut/timeline/TimelineCoverGenerator;
      //   155: getfield 38	com/tencent/tavcut/timeline/TimelineCoverGenerator:mImageGenerator	Lcom/tencent/tavkit/component/TAVSourceImageGenerator;
      //   158: new 93	com/tencent/tav/coremedia/CMTime
      //   161: dup
      //   162: aload 9
      //   164: invokestatic 96	com/tencent/tavcut/timeline/TimelineCoverGenerator$CoverTask:access$300	(Lcom/tencent/tavcut/timeline/TimelineCoverGenerator$CoverTask;)J
      //   167: l2f
      //   168: ldc 97
      //   170: fdiv
      //   171: invokespecial 100	com/tencent/tav/coremedia/CMTime:<init>	(F)V
      //   174: invokevirtual 106	com/tencent/tavkit/component/TAVSourceImageGenerator:generateThumbnailAtTimeSync	(Lcom/tencent/tav/coremedia/CMTime;)Landroid/graphics/Bitmap;
      //   177: astore 8
      //   179: ldc 50
      //   181: ldc 108
      //   183: invokestatic 76	com/tencent/tavcut/util/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
      //   186: aload 8
      //   188: ifnull +524 -> 712
      //   191: aload 8
      //   193: invokevirtual 114	android/graphics/Bitmap:getWidth	()I
      //   196: istore_2
      //   197: aload 8
      //   199: invokevirtual 117	android/graphics/Bitmap:getHeight	()I
      //   202: istore_3
      //   203: new 119	android/graphics/Matrix
      //   206: dup
      //   207: invokespecial 120	android/graphics/Matrix:<init>	()V
      //   210: astore 7
      //   212: aload 7
      //   214: ldc 121
      //   216: ldc 121
      //   218: invokevirtual 125	android/graphics/Matrix:postScale	(FF)Z
      //   221: pop
      //   222: iload_2
      //   223: i2f
      //   224: aload_0
      //   225: getfield 15	com/tencent/tavcut/timeline/TimelineCoverGenerator$CoverRunnable:this$0	Lcom/tencent/tavcut/timeline/TimelineCoverGenerator;
      //   228: getfield 129	com/tencent/tavcut/timeline/TimelineCoverGenerator:mCoverWidth	F
      //   231: ldc 130
      //   233: fmul
      //   234: fsub
      //   235: fconst_2
      //   236: fdiv
      //   237: f2i
      //   238: istore_1
      //   239: iload_3
      //   240: i2f
      //   241: aload_0
      //   242: getfield 15	com/tencent/tavcut/timeline/TimelineCoverGenerator$CoverRunnable:this$0	Lcom/tencent/tavcut/timeline/TimelineCoverGenerator;
      //   245: getfield 133	com/tencent/tavcut/timeline/TimelineCoverGenerator:mCoverHeight	F
      //   248: ldc 130
      //   250: fmul
      //   251: fsub
      //   252: fconst_2
      //   253: fdiv
      //   254: f2i
      //   255: istore 4
      //   257: aload_0
      //   258: getfield 15	com/tencent/tavcut/timeline/TimelineCoverGenerator$CoverRunnable:this$0	Lcom/tencent/tavcut/timeline/TimelineCoverGenerator;
      //   261: getfield 129	com/tencent/tavcut/timeline/TimelineCoverGenerator:mCoverWidth	F
      //   264: ldc 130
      //   266: fmul
      //   267: f2i
      //   268: istore 6
      //   270: aload_0
      //   271: getfield 15	com/tencent/tavcut/timeline/TimelineCoverGenerator$CoverRunnable:this$0	Lcom/tencent/tavcut/timeline/TimelineCoverGenerator;
      //   274: getfield 133	com/tencent/tavcut/timeline/TimelineCoverGenerator:mCoverHeight	F
      //   277: ldc 130
      //   279: fmul
      //   280: f2i
      //   281: istore 5
      //   283: iload_1
      //   284: ifgt +422 -> 706
      //   287: iconst_0
      //   288: istore_1
      //   289: iload 4
      //   291: ifgt +409 -> 700
      //   294: iconst_0
      //   295: istore 4
      //   297: aload 8
      //   299: iload_1
      //   300: iload 4
      //   302: iload_2
      //   303: iload_3
      //   304: aload 7
      //   306: iconst_0
      //   307: invokestatic 137	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIIILandroid/graphics/Matrix;Z)Landroid/graphics/Bitmap;
      //   310: astore 10
      //   312: aload 10
      //   314: astore 7
      //   316: aload 8
      //   318: invokevirtual 140	android/graphics/Bitmap:isRecycled	()Z
      //   321: ifne +12 -> 333
      //   324: aload 8
      //   326: invokevirtual 143	android/graphics/Bitmap:recycle	()V
      //   329: aload 10
      //   331: astore 7
      //   333: aload 7
      //   335: ifnull +258 -> 593
      //   338: aload 9
      //   340: invokestatic 63	com/tencent/tavcut/timeline/TimelineCoverGenerator$CoverTask:access$000	(Lcom/tencent/tavcut/timeline/TimelineCoverGenerator$CoverTask;)I
      //   343: aload_0
      //   344: getfield 15	com/tencent/tavcut/timeline/TimelineCoverGenerator$CoverRunnable:this$0	Lcom/tencent/tavcut/timeline/TimelineCoverGenerator;
      //   347: getfield 147	com/tencent/tavcut/timeline/TimelineCoverGenerator:mItemCount	I
      //   350: iconst_1
      //   351: isub
      //   352: if_icmpne +341 -> 693
      //   355: aload_0
      //   356: getfield 15	com/tencent/tavcut/timeline/TimelineCoverGenerator$CoverRunnable:this$0	Lcom/tencent/tavcut/timeline/TimelineCoverGenerator;
      //   359: getfield 150	com/tencent/tavcut/timeline/TimelineCoverGenerator:mLastCoverWidth	F
      //   362: aload_0
      //   363: getfield 15	com/tencent/tavcut/timeline/TimelineCoverGenerator$CoverRunnable:this$0	Lcom/tencent/tavcut/timeline/TimelineCoverGenerator;
      //   366: getfield 129	com/tencent/tavcut/timeline/TimelineCoverGenerator:mCoverWidth	F
      //   369: invokestatic 155	com/tencent/tavcut/util/FloatUtils:isEquals	(FF)Z
      //   372: ifne +321 -> 693
      //   375: aload 7
      //   377: iconst_0
      //   378: iconst_0
      //   379: fconst_1
      //   380: aload_0
      //   381: getfield 15	com/tencent/tavcut/timeline/TimelineCoverGenerator$CoverRunnable:this$0	Lcom/tencent/tavcut/timeline/TimelineCoverGenerator;
      //   384: getfield 150	com/tencent/tavcut/timeline/TimelineCoverGenerator:mLastCoverWidth	F
      //   387: fmul
      //   388: aload_0
      //   389: getfield 15	com/tencent/tavcut/timeline/TimelineCoverGenerator$CoverRunnable:this$0	Lcom/tencent/tavcut/timeline/TimelineCoverGenerator;
      //   392: getfield 129	com/tencent/tavcut/timeline/TimelineCoverGenerator:mCoverWidth	F
      //   395: fdiv
      //   396: aload 7
      //   398: invokevirtual 114	android/graphics/Bitmap:getWidth	()I
      //   401: i2f
      //   402: fmul
      //   403: f2i
      //   404: aload 7
      //   406: invokevirtual 117	android/graphics/Bitmap:getHeight	()I
      //   409: invokestatic 158	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIII)Landroid/graphics/Bitmap;
      //   412: astore 10
      //   414: aload 10
      //   416: astore 8
      //   418: aload 7
      //   420: invokevirtual 140	android/graphics/Bitmap:isRecycled	()Z
      //   423: ifne +12 -> 435
      //   426: aload 7
      //   428: invokevirtual 143	android/graphics/Bitmap:recycle	()V
      //   431: aload 10
      //   433: astore 8
      //   435: aload_0
      //   436: getfield 15	com/tencent/tavcut/timeline/TimelineCoverGenerator$CoverRunnable:this$0	Lcom/tencent/tavcut/timeline/TimelineCoverGenerator;
      //   439: getfield 162	com/tencent/tavcut/timeline/TimelineCoverGenerator:mCoverCache	Lcom/tencent/tavcut/cover/CoverCache;
      //   442: ifnull +20 -> 462
      //   445: aload_0
      //   446: getfield 15	com/tencent/tavcut/timeline/TimelineCoverGenerator$CoverRunnable:this$0	Lcom/tencent/tavcut/timeline/TimelineCoverGenerator;
      //   449: getfield 162	com/tencent/tavcut/timeline/TimelineCoverGenerator:mCoverCache	Lcom/tencent/tavcut/cover/CoverCache;
      //   452: aload 9
      //   454: invokestatic 63	com/tencent/tavcut/timeline/TimelineCoverGenerator$CoverTask:access$000	(Lcom/tencent/tavcut/timeline/TimelineCoverGenerator$CoverTask;)I
      //   457: aload 8
      //   459: invokevirtual 168	com/tencent/tavcut/cover/CoverCache:addCover	(ILandroid/graphics/Bitmap;)V
      //   462: aload_0
      //   463: getfield 15	com/tencent/tavcut/timeline/TimelineCoverGenerator$CoverRunnable:this$0	Lcom/tencent/tavcut/timeline/TimelineCoverGenerator;
      //   466: getfield 172	com/tencent/tavcut/timeline/TimelineCoverGenerator:mCoverTaskMap	Ljava/util/concurrent/ConcurrentHashMap;
      //   469: ifnull +22 -> 491
      //   472: aload_0
      //   473: getfield 15	com/tencent/tavcut/timeline/TimelineCoverGenerator$CoverRunnable:this$0	Lcom/tencent/tavcut/timeline/TimelineCoverGenerator;
      //   476: getfield 172	com/tencent/tavcut/timeline/TimelineCoverGenerator:mCoverTaskMap	Ljava/util/concurrent/ConcurrentHashMap;
      //   479: aload 9
      //   481: invokestatic 96	com/tencent/tavcut/timeline/TimelineCoverGenerator$CoverTask:access$300	(Lcom/tencent/tavcut/timeline/TimelineCoverGenerator$CoverTask;)J
      //   484: invokestatic 178	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   487: invokevirtual 184	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
      //   490: pop
      //   491: aload_0
      //   492: getfield 15	com/tencent/tavcut/timeline/TimelineCoverGenerator$CoverRunnable:this$0	Lcom/tencent/tavcut/timeline/TimelineCoverGenerator;
      //   495: getfield 162	com/tencent/tavcut/timeline/TimelineCoverGenerator:mCoverCache	Lcom/tencent/tavcut/cover/CoverCache;
      //   498: ifnull -498 -> 0
      //   501: aload_0
      //   502: getfield 15	com/tencent/tavcut/timeline/TimelineCoverGenerator$CoverRunnable:this$0	Lcom/tencent/tavcut/timeline/TimelineCoverGenerator;
      //   505: getfield 162	com/tencent/tavcut/timeline/TimelineCoverGenerator:mCoverCache	Lcom/tencent/tavcut/cover/CoverCache;
      //   508: invokevirtual 187	com/tencent/tavcut/cover/CoverCache:getCacheSize	()I
      //   511: aload_0
      //   512: getfield 15	com/tencent/tavcut/timeline/TimelineCoverGenerator$CoverRunnable:this$0	Lcom/tencent/tavcut/timeline/TimelineCoverGenerator;
      //   515: getfield 147	com/tencent/tavcut/timeline/TimelineCoverGenerator:mItemCount	I
      //   518: if_icmpne -518 -> 0
      //   521: aload_0
      //   522: getfield 15	com/tencent/tavcut/timeline/TimelineCoverGenerator$CoverRunnable:this$0	Lcom/tencent/tavcut/timeline/TimelineCoverGenerator;
      //   525: getfield 38	com/tencent/tavcut/timeline/TimelineCoverGenerator:mImageGenerator	Lcom/tencent/tavkit/component/TAVSourceImageGenerator;
      //   528: invokevirtual 191	com/tencent/tavkit/component/TAVSourceImageGenerator:getAssetImageGenerator	()Lcom/tencent/tav/core/AssetImageGenerator;
      //   531: invokevirtual 196	com/tencent/tav/core/AssetImageGenerator:release	()V
      //   534: aload_0
      //   535: getfield 15	com/tencent/tavcut/timeline/TimelineCoverGenerator$CoverRunnable:this$0	Lcom/tencent/tavcut/timeline/TimelineCoverGenerator;
      //   538: aconst_null
      //   539: putfield 38	com/tencent/tavcut/timeline/TimelineCoverGenerator:mImageGenerator	Lcom/tencent/tavkit/component/TAVSourceImageGenerator;
      //   542: goto -542 -> 0
      //   545: astore 8
      //   547: aconst_null
      //   548: astore 7
      //   550: ldc 50
      //   552: ldc 198
      //   554: invokestatic 76	com/tencent/tavcut/util/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
      //   557: aload 8
      //   559: invokevirtual 201	java/lang/InterruptedException:printStackTrace	()V
      //   562: aload 7
      //   564: astore 9
      //   566: goto -444 -> 122
      //   569: astore 8
      //   571: aconst_null
      //   572: astore 7
      //   574: ldc 50
      //   576: ldc 203
      //   578: invokestatic 76	com/tencent/tavcut/util/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
      //   581: aload 8
      //   583: invokevirtual 204	java/lang/Exception:printStackTrace	()V
      //   586: aload 7
      //   588: astore 8
      //   590: goto -404 -> 186
      //   593: aload_0
      //   594: getfield 15	com/tencent/tavcut/timeline/TimelineCoverGenerator$CoverRunnable:this$0	Lcom/tencent/tavcut/timeline/TimelineCoverGenerator;
      //   597: getfield 28	com/tencent/tavcut/timeline/TimelineCoverGenerator:mCoverTaskQueue	Ljava/util/concurrent/BlockingQueue;
      //   600: aload 9
      //   602: invokeinterface 208 2 0
      //   607: goto -607 -> 0
      //   610: astore 7
      //   612: aload 7
      //   614: invokevirtual 201	java/lang/InterruptedException:printStackTrace	()V
      //   617: goto -617 -> 0
      //   620: aload_0
      //   621: getfield 15	com/tencent/tavcut/timeline/TimelineCoverGenerator$CoverRunnable:this$0	Lcom/tencent/tavcut/timeline/TimelineCoverGenerator;
      //   624: getfield 172	com/tencent/tavcut/timeline/TimelineCoverGenerator:mCoverTaskMap	Ljava/util/concurrent/ConcurrentHashMap;
      //   627: ifnull +30 -> 657
      //   630: aload_0
      //   631: getfield 15	com/tencent/tavcut/timeline/TimelineCoverGenerator$CoverRunnable:this$0	Lcom/tencent/tavcut/timeline/TimelineCoverGenerator;
      //   634: getfield 172	com/tencent/tavcut/timeline/TimelineCoverGenerator:mCoverTaskMap	Ljava/util/concurrent/ConcurrentHashMap;
      //   637: invokevirtual 209	java/util/concurrent/ConcurrentHashMap:isEmpty	()Z
      //   640: ifeq +17 -> 657
      //   643: aload_0
      //   644: getfield 15	com/tencent/tavcut/timeline/TimelineCoverGenerator$CoverRunnable:this$0	Lcom/tencent/tavcut/timeline/TimelineCoverGenerator;
      //   647: invokestatic 212	com/tencent/tavcut/timeline/TimelineCoverGenerator:access$400	(Lcom/tencent/tavcut/timeline/TimelineCoverGenerator;)V
      //   650: aload_0
      //   651: getfield 15	com/tencent/tavcut/timeline/TimelineCoverGenerator$CoverRunnable:this$0	Lcom/tencent/tavcut/timeline/TimelineCoverGenerator;
      //   654: invokestatic 215	com/tencent/tavcut/timeline/TimelineCoverGenerator:access$500	(Lcom/tencent/tavcut/timeline/TimelineCoverGenerator;)V
      //   657: aload_0
      //   658: getfield 15	com/tencent/tavcut/timeline/TimelineCoverGenerator$CoverRunnable:this$0	Lcom/tencent/tavcut/timeline/TimelineCoverGenerator;
      //   661: getfield 42	com/tencent/tavcut/timeline/TimelineCoverGenerator:mReleased	Z
      //   664: ifeq +10 -> 674
      //   667: aload_0
      //   668: getfield 15	com/tencent/tavcut/timeline/TimelineCoverGenerator$CoverRunnable:this$0	Lcom/tencent/tavcut/timeline/TimelineCoverGenerator;
      //   671: invokestatic 218	com/tencent/tavcut/timeline/TimelineCoverGenerator:access$600	(Lcom/tencent/tavcut/timeline/TimelineCoverGenerator;)V
      //   674: return
      //   675: astore 10
      //   677: aload 8
      //   679: astore 7
      //   681: aload 10
      //   683: astore 8
      //   685: goto -111 -> 574
      //   688: astore 8
      //   690: goto -140 -> 550
      //   693: aload 7
      //   695: astore 8
      //   697: goto -262 -> 435
      //   700: iload 5
      //   702: istore_3
      //   703: goto -406 -> 297
      //   706: iload 6
      //   708: istore_2
      //   709: goto -420 -> 289
      //   712: aconst_null
      //   713: astore 7
      //   715: goto -382 -> 333
      //   718: aconst_null
      //   719: astore 8
      //   721: goto -535 -> 186
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	724	0	this	CoverRunnable
      //   238	62	1	i	int
      //   196	513	2	j	int
      //   202	501	3	k	int
      //   255	46	4	m	int
      //   281	420	5	n	int
      //   268	439	6	i1	int
      //   60	527	7	localObject1	Object
      //   610	3	7	localInterruptedException1	InterruptedException
      //   679	35	7	localObject2	Object
      //   177	281	8	localObject3	Object
      //   545	13	8	localInterruptedException2	InterruptedException
      //   569	13	8	localException1	Exception
      //   588	96	8	localObject4	Object
      //   688	1	8	localInterruptedException3	InterruptedException
      //   695	25	8	localObject5	Object
      //   120	481	9	localObject6	Object
      //   310	122	10	localBitmap	android.graphics.Bitmap
      //   675	7	10	localException2	Exception
      // Exception table:
      //   from	to	target	type
      //   45	62	545	java/lang/InterruptedException
      //   134	179	569	java/lang/Exception
      //   593	607	610	java/lang/InterruptedException
      //   179	186	675	java/lang/Exception
      //   62	118	688	java/lang/InterruptedException
    }
  }
  
  public class CoverTask
    implements Comparable<CoverTask>
  {
    private boolean generating;
    private int index;
    private long requestTimeMs;
    private long startTimeMs;
    
    public CoverTask(long paramLong, int paramInt)
    {
      this.requestTimeMs = paramLong;
      this.startTimeMs = (paramInt * TimelineCoverGenerator.this.mItemDurationMs);
      this.index = paramInt;
      if (TimelineCoverGenerator.this.mCoverTaskMap != null) {
        TimelineCoverGenerator.this.mCoverTaskMap.put(Long.valueOf(this.startTimeMs), this);
      }
    }
    
    public int compareTo(@NonNull CoverTask paramCoverTask)
    {
      if (this.requestTimeMs > paramCoverTask.requestTimeMs) {
        return -1;
      }
      return 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tavcut.timeline.TimelineCoverGenerator
 * JD-Core Version:    0.7.0.1
 */