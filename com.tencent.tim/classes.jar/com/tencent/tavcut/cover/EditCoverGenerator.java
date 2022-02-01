package com.tencent.tavcut.cover;

import android.support.annotation.NonNull;
import com.tencent.tav.asset.Asset;
import com.tencent.tav.core.AssetImageGenerator;
import com.tencent.tav.core.AssetImageGenerator.ApertureMode;
import com.tencent.tav.core.composition.VideoComposition;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.decoder.RenderContextParams;
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

public class EditCoverGenerator
  implements ICoverGenerator
{
  private static final float SCALE_SIZE = 1.0F;
  public static final String TAG = "EditCoverGenerator";
  private CoverCache mCoverCache;
  private float mCoverHeight;
  private ConcurrentHashMap<Integer, CoverTask> mCoverTaskMap;
  private BlockingQueue<CoverTask> mCoverTaskQueue;
  private float mCoverWidth;
  private ExecutorService mExecutors;
  private List<CMTime> mGenerateTimeList;
  private TAVSourceImageGenerator mImageGenerator;
  private volatile boolean mPaused;
  private volatile boolean mReleased;
  private TAVSource mTavSource;
  
  private CGSize calculateRenderSize()
  {
    CGSize localCGSize3 = new CGSize(this.mCoverWidth * 1.0F, this.mCoverHeight * 1.0F);
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
      localCGSize1.height = (this.mCoverHeight * 1.0F);
      localCGSize1.width = (f * localCGSize1.height);
      return localCGSize1;
    }
    localCGSize1.width = (this.mCoverWidth * 1.0F);
    localCGSize1.height = (localCGSize1.width / f);
    return localCGSize1;
  }
  
  private void initParams()
  {
    int i = 0;
    if ((this.mGenerateTimeList == null) || (this.mGenerateTimeList.isEmpty())) {
      return;
    }
    this.mPaused = false;
    Logger.d("EditCoverGenerator", "initParams: generateTimeList is  " + this.mGenerateTimeList);
    this.mImageGenerator = new TAVSourceImageGenerator(this.mTavSource, calculateRenderSize());
    this.mImageGenerator.getAssetImageGenerator().setApertureMode(AssetImageGenerator.ApertureMode.aspectFit);
    this.mCoverTaskMap = new ConcurrentHashMap(16);
    this.mCoverTaskQueue = new PriorityBlockingQueue();
    if (i < this.mGenerateTimeList.size())
    {
      Object localObject = (CMTime)this.mGenerateTimeList.get(i);
      if (localObject == null) {}
      for (;;)
      {
        i += 1;
        break;
        long l = System.currentTimeMillis();
        localObject = new CoverTask(i + l, (CMTime)localObject, i);
        try
        {
          this.mCoverTaskQueue.put(localObject);
        }
        catch (InterruptedException localInterruptedException)
        {
          localInterruptedException.printStackTrace();
        }
      }
    }
    this.mExecutors = Executors.newSingleThreadExecutor();
    this.mExecutors.submit(new CoverRunnable(null));
  }
  
  private void realRelease()
  {
    Logger.d("EditCoverGenerator", "realRelease: ");
    releaseImageGenerator();
    releaseCache();
    releaseQueue();
    releaseExecutors();
  }
  
  private void releaseCache()
  {
    Logger.d("EditCoverGenerator", "releaseCache: ");
    if (this.mCoverCache != null)
    {
      this.mCoverCache.release();
      this.mCoverCache = null;
    }
  }
  
  private void releaseExecutors()
  {
    Logger.d("EditCoverGenerator", "releaseExecutors: ");
    if (this.mExecutors != null)
    {
      this.mExecutors.shutdownNow();
      this.mExecutors = null;
    }
  }
  
  private void releaseImageGenerator()
  {
    Logger.d("EditCoverGenerator", "releaseImageGenerator: ");
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
    Logger.d("EditCoverGenerator", "releaseQueue: ");
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
  
  public void generateCoverByIndex(int paramInt, CMTime paramCMTime)
  {
    if (this.mCoverTaskMap == null) {
      return;
    }
    if ((this.mCoverTaskMap.containsKey(Integer.valueOf(paramInt))) && (!((CoverTask)this.mCoverTaskMap.get(Integer.valueOf(paramInt))).generating))
    {
      CoverTask.access$202((CoverTask)this.mCoverTaskMap.get(Integer.valueOf(paramInt)), paramCMTime);
      return;
    }
    paramCMTime = new CoverTask(System.currentTimeMillis(), paramCMTime, paramInt);
    this.mCoverTaskMap.put(Integer.valueOf(paramInt), paramCMTime);
    try
    {
      this.mCoverTaskQueue.put(paramCMTime);
      return;
    }
    catch (InterruptedException paramCMTime)
    {
      paramCMTime.printStackTrace();
    }
  }
  
  public void generateCoverByIndexRange(int paramInt1, int paramInt2) {}
  
  public void generateCoverByTimeRange(long paramLong1, long paramLong2) {}
  
  public void init(TAVSource paramTAVSource, long paramLong, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void init(TAVSource paramTAVSource, List<CMTime> paramList, int paramInt1, int paramInt2)
  {
    this.mTavSource = paramTAVSource;
    this.mGenerateTimeList = paramList;
    this.mCoverWidth = paramInt1;
    this.mCoverHeight = paramInt2;
    initParams();
  }
  
  public void pause()
  {
    if ((this.mCoverTaskMap == null) || (this.mCoverTaskMap.isEmpty())) {}
    do
    {
      return;
      Logger.d("EditCoverGenerator", "pause: ");
      this.mPaused = true;
    } while ((this.mExecutors == null) || (this.mExecutors.isShutdown()));
    this.mExecutors.submit(new CoverRunnable(null));
  }
  
  public void release()
  {
    Logger.d("EditCoverGenerator", "release: ");
    this.mReleased = true;
    if ((this.mExecutors != null) && (!this.mExecutors.isShutdown()))
    {
      this.mExecutors.submit(new CoverRunnable(null));
      return;
    }
    releaseQueue();
    releaseCache();
  }
  
  public void resume()
  {
    if ((this.mCoverTaskMap == null) || (this.mCoverTaskMap.isEmpty())) {
      return;
    }
    this.mPaused = false;
    Logger.d("EditCoverGenerator", "resume: ");
    if (this.mImageGenerator == null)
    {
      this.mImageGenerator = new TAVSourceImageGenerator(this.mTavSource, calculateRenderSize());
      this.mImageGenerator.getAssetImageGenerator().setApertureMode(AssetImageGenerator.ApertureMode.scaleToFit);
    }
    if (this.mExecutors == null) {
      this.mExecutors = Executors.newSingleThreadExecutor();
    }
    this.mExecutors.submit(new CoverRunnable(null));
  }
  
  public void setCoverCache(CoverCache paramCoverCache)
  {
    this.mCoverCache = paramCoverCache;
  }
  
  public void setRenderContextParamas(RenderContextParams paramRenderContextParams) {}
  
  class CoverRunnable
    implements Runnable
  {
    private CoverRunnable() {}
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: iconst_0
      //   1: istore 5
      //   3: aload_0
      //   4: getfield 15	com/tencent/tavcut/cover/EditCoverGenerator$CoverRunnable:this$0	Lcom/tencent/tavcut/cover/EditCoverGenerator;
      //   7: invokestatic 31	com/tencent/tavcut/cover/EditCoverGenerator:access$400	(Lcom/tencent/tavcut/cover/EditCoverGenerator;)Ljava/util/concurrent/BlockingQueue;
      //   10: ifnull +450 -> 460
      //   13: aload_0
      //   14: getfield 15	com/tencent/tavcut/cover/EditCoverGenerator$CoverRunnable:this$0	Lcom/tencent/tavcut/cover/EditCoverGenerator;
      //   17: invokestatic 31	com/tencent/tavcut/cover/EditCoverGenerator:access$400	(Lcom/tencent/tavcut/cover/EditCoverGenerator;)Ljava/util/concurrent/BlockingQueue;
      //   20: invokeinterface 37 1 0
      //   25: ifne +435 -> 460
      //   28: aload_0
      //   29: getfield 15	com/tencent/tavcut/cover/EditCoverGenerator$CoverRunnable:this$0	Lcom/tencent/tavcut/cover/EditCoverGenerator;
      //   32: invokestatic 41	com/tencent/tavcut/cover/EditCoverGenerator:access$500	(Lcom/tencent/tavcut/cover/EditCoverGenerator;)Lcom/tencent/tavkit/component/TAVSourceImageGenerator;
      //   35: ifnull +425 -> 460
      //   38: aload_0
      //   39: getfield 15	com/tencent/tavcut/cover/EditCoverGenerator$CoverRunnable:this$0	Lcom/tencent/tavcut/cover/EditCoverGenerator;
      //   42: invokestatic 45	com/tencent/tavcut/cover/EditCoverGenerator:access$600	(Lcom/tencent/tavcut/cover/EditCoverGenerator;)Z
      //   45: ifne +415 -> 460
      //   48: aload_0
      //   49: getfield 15	com/tencent/tavcut/cover/EditCoverGenerator$CoverRunnable:this$0	Lcom/tencent/tavcut/cover/EditCoverGenerator;
      //   52: invokestatic 48	com/tencent/tavcut/cover/EditCoverGenerator:access$700	(Lcom/tencent/tavcut/cover/EditCoverGenerator;)Z
      //   55: ifne +405 -> 460
      //   58: aload_0
      //   59: getfield 15	com/tencent/tavcut/cover/EditCoverGenerator$CoverRunnable:this$0	Lcom/tencent/tavcut/cover/EditCoverGenerator;
      //   62: invokestatic 31	com/tencent/tavcut/cover/EditCoverGenerator:access$400	(Lcom/tencent/tavcut/cover/EditCoverGenerator;)Ljava/util/concurrent/BlockingQueue;
      //   65: invokeinterface 52 1 0
      //   70: checkcast 54	com/tencent/tavcut/cover/EditCoverGenerator$CoverTask
      //   73: astore 8
      //   75: ldc 56
      //   77: new 58	java/lang/StringBuilder
      //   80: dup
      //   81: invokespecial 59	java/lang/StringBuilder:<init>	()V
      //   84: ldc 61
      //   86: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   89: aload 8
      //   91: invokestatic 69	com/tencent/tavcut/cover/EditCoverGenerator$CoverTask:access$800	(Lcom/tencent/tavcut/cover/EditCoverGenerator$CoverTask;)I
      //   94: invokevirtual 72	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   97: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   100: invokestatic 82	com/tencent/tavcut/util/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
      //   103: ldc 56
      //   105: new 58	java/lang/StringBuilder
      //   108: dup
      //   109: invokespecial 59	java/lang/StringBuilder:<init>	()V
      //   112: ldc 84
      //   114: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   117: aload 8
      //   119: invokestatic 88	com/tencent/tavcut/cover/EditCoverGenerator$CoverTask:access$900	(Lcom/tencent/tavcut/cover/EditCoverGenerator$CoverTask;)J
      //   122: invokevirtual 91	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   125: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   128: invokestatic 82	com/tencent/tavcut/util/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
      //   131: aload 8
      //   133: astore 9
      //   135: aload 9
      //   137: ifnull -134 -> 3
      //   140: aload 9
      //   142: iconst_1
      //   143: invokestatic 95	com/tencent/tavcut/cover/EditCoverGenerator$CoverTask:access$102	(Lcom/tencent/tavcut/cover/EditCoverGenerator$CoverTask;Z)Z
      //   146: pop
      //   147: aload_0
      //   148: getfield 15	com/tencent/tavcut/cover/EditCoverGenerator$CoverRunnable:this$0	Lcom/tencent/tavcut/cover/EditCoverGenerator;
      //   151: invokestatic 41	com/tencent/tavcut/cover/EditCoverGenerator:access$500	(Lcom/tencent/tavcut/cover/EditCoverGenerator;)Lcom/tencent/tavkit/component/TAVSourceImageGenerator;
      //   154: ifnull +409 -> 563
      //   157: ldc 56
      //   159: ldc 97
      //   161: invokestatic 82	com/tencent/tavcut/util/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
      //   164: aload_0
      //   165: getfield 15	com/tencent/tavcut/cover/EditCoverGenerator$CoverRunnable:this$0	Lcom/tencent/tavcut/cover/EditCoverGenerator;
      //   168: invokestatic 41	com/tencent/tavcut/cover/EditCoverGenerator:access$500	(Lcom/tencent/tavcut/cover/EditCoverGenerator;)Lcom/tencent/tavkit/component/TAVSourceImageGenerator;
      //   171: aload 9
      //   173: invokestatic 101	com/tencent/tavcut/cover/EditCoverGenerator$CoverTask:access$200	(Lcom/tencent/tavcut/cover/EditCoverGenerator$CoverTask;)Lcom/tencent/tav/coremedia/CMTime;
      //   176: invokevirtual 107	com/tencent/tavkit/component/TAVSourceImageGenerator:generateThumbnailAtTimeSync	(Lcom/tencent/tav/coremedia/CMTime;)Landroid/graphics/Bitmap;
      //   179: astore 8
      //   181: ldc 56
      //   183: ldc 109
      //   185: invokestatic 82	com/tencent/tavcut/util/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
      //   188: aload 8
      //   190: ifnull +367 -> 557
      //   193: aload 8
      //   195: invokevirtual 115	android/graphics/Bitmap:getWidth	()I
      //   198: istore_2
      //   199: aload 8
      //   201: invokevirtual 118	android/graphics/Bitmap:getHeight	()I
      //   204: istore_3
      //   205: new 120	android/graphics/Matrix
      //   208: dup
      //   209: invokespecial 121	android/graphics/Matrix:<init>	()V
      //   212: astore 10
      //   214: aload 10
      //   216: fconst_1
      //   217: fconst_1
      //   218: invokevirtual 125	android/graphics/Matrix:postScale	(FF)Z
      //   221: pop
      //   222: iload_2
      //   223: i2f
      //   224: aload_0
      //   225: getfield 15	com/tencent/tavcut/cover/EditCoverGenerator$CoverRunnable:this$0	Lcom/tencent/tavcut/cover/EditCoverGenerator;
      //   228: invokestatic 129	com/tencent/tavcut/cover/EditCoverGenerator:access$1000	(Lcom/tencent/tavcut/cover/EditCoverGenerator;)F
      //   231: fconst_1
      //   232: fmul
      //   233: fsub
      //   234: fconst_2
      //   235: fdiv
      //   236: f2i
      //   237: istore_1
      //   238: iload_3
      //   239: i2f
      //   240: aload_0
      //   241: getfield 15	com/tencent/tavcut/cover/EditCoverGenerator$CoverRunnable:this$0	Lcom/tencent/tavcut/cover/EditCoverGenerator;
      //   244: invokestatic 132	com/tencent/tavcut/cover/EditCoverGenerator:access$1100	(Lcom/tencent/tavcut/cover/EditCoverGenerator;)F
      //   247: fconst_1
      //   248: fmul
      //   249: fsub
      //   250: fconst_2
      //   251: fdiv
      //   252: f2i
      //   253: istore 4
      //   255: aload_0
      //   256: getfield 15	com/tencent/tavcut/cover/EditCoverGenerator$CoverRunnable:this$0	Lcom/tencent/tavcut/cover/EditCoverGenerator;
      //   259: invokestatic 129	com/tencent/tavcut/cover/EditCoverGenerator:access$1000	(Lcom/tencent/tavcut/cover/EditCoverGenerator;)F
      //   262: fconst_1
      //   263: fmul
      //   264: f2i
      //   265: istore 7
      //   267: aload_0
      //   268: getfield 15	com/tencent/tavcut/cover/EditCoverGenerator$CoverRunnable:this$0	Lcom/tencent/tavcut/cover/EditCoverGenerator;
      //   271: invokestatic 132	com/tencent/tavcut/cover/EditCoverGenerator:access$1100	(Lcom/tencent/tavcut/cover/EditCoverGenerator;)F
      //   274: fconst_1
      //   275: fmul
      //   276: f2i
      //   277: istore 6
      //   279: iload_1
      //   280: ifgt +271 -> 551
      //   283: iconst_0
      //   284: istore_1
      //   285: iload 4
      //   287: ifgt +258 -> 545
      //   290: iconst_0
      //   291: istore 4
      //   293: aload 8
      //   295: iload_1
      //   296: iload 4
      //   298: iload_2
      //   299: iload_3
      //   300: aload 10
      //   302: iconst_0
      //   303: invokestatic 136	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIIILandroid/graphics/Matrix;Z)Landroid/graphics/Bitmap;
      //   306: astore 10
      //   308: aload 8
      //   310: invokevirtual 139	android/graphics/Bitmap:isRecycled	()Z
      //   313: ifne +8 -> 321
      //   316: aload 8
      //   318: invokevirtual 142	android/graphics/Bitmap:recycle	()V
      //   321: aload 10
      //   323: astore 8
      //   325: aload 8
      //   327: ifnull +106 -> 433
      //   330: aload_0
      //   331: getfield 15	com/tencent/tavcut/cover/EditCoverGenerator$CoverRunnable:this$0	Lcom/tencent/tavcut/cover/EditCoverGenerator;
      //   334: invokestatic 146	com/tencent/tavcut/cover/EditCoverGenerator:access$1200	(Lcom/tencent/tavcut/cover/EditCoverGenerator;)Lcom/tencent/tavcut/cover/CoverCache;
      //   337: ifnull +20 -> 357
      //   340: aload_0
      //   341: getfield 15	com/tencent/tavcut/cover/EditCoverGenerator$CoverRunnable:this$0	Lcom/tencent/tavcut/cover/EditCoverGenerator;
      //   344: invokestatic 146	com/tencent/tavcut/cover/EditCoverGenerator:access$1200	(Lcom/tencent/tavcut/cover/EditCoverGenerator;)Lcom/tencent/tavcut/cover/CoverCache;
      //   347: aload 9
      //   349: invokestatic 69	com/tencent/tavcut/cover/EditCoverGenerator$CoverTask:access$800	(Lcom/tencent/tavcut/cover/EditCoverGenerator$CoverTask;)I
      //   352: aload 8
      //   354: invokevirtual 152	com/tencent/tavcut/cover/CoverCache:addCover	(ILandroid/graphics/Bitmap;)V
      //   357: aload_0
      //   358: getfield 15	com/tencent/tavcut/cover/EditCoverGenerator$CoverRunnable:this$0	Lcom/tencent/tavcut/cover/EditCoverGenerator;
      //   361: invokestatic 156	com/tencent/tavcut/cover/EditCoverGenerator:access$300	(Lcom/tencent/tavcut/cover/EditCoverGenerator;)Ljava/util/concurrent/ConcurrentHashMap;
      //   364: ifnull -361 -> 3
      //   367: aload_0
      //   368: getfield 15	com/tencent/tavcut/cover/EditCoverGenerator$CoverRunnable:this$0	Lcom/tencent/tavcut/cover/EditCoverGenerator;
      //   371: invokestatic 156	com/tencent/tavcut/cover/EditCoverGenerator:access$300	(Lcom/tencent/tavcut/cover/EditCoverGenerator;)Ljava/util/concurrent/ConcurrentHashMap;
      //   374: aload 9
      //   376: invokestatic 69	com/tencent/tavcut/cover/EditCoverGenerator$CoverTask:access$800	(Lcom/tencent/tavcut/cover/EditCoverGenerator$CoverTask;)I
      //   379: invokestatic 162	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   382: invokevirtual 168	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
      //   385: pop
      //   386: goto -383 -> 3
      //   389: astore 9
      //   391: aconst_null
      //   392: astore 8
      //   394: ldc 56
      //   396: ldc 170
      //   398: invokestatic 82	com/tencent/tavcut/util/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
      //   401: aload 9
      //   403: invokevirtual 173	java/lang/InterruptedException:printStackTrace	()V
      //   406: aload 8
      //   408: astore 9
      //   410: goto -275 -> 135
      //   413: astore 10
      //   415: aconst_null
      //   416: astore 8
      //   418: ldc 56
      //   420: ldc 175
      //   422: invokestatic 82	com/tencent/tavcut/util/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
      //   425: aload 10
      //   427: invokevirtual 176	java/lang/Exception:printStackTrace	()V
      //   430: goto -242 -> 188
      //   433: aload_0
      //   434: getfield 15	com/tencent/tavcut/cover/EditCoverGenerator$CoverRunnable:this$0	Lcom/tencent/tavcut/cover/EditCoverGenerator;
      //   437: invokestatic 31	com/tencent/tavcut/cover/EditCoverGenerator:access$400	(Lcom/tencent/tavcut/cover/EditCoverGenerator;)Ljava/util/concurrent/BlockingQueue;
      //   440: aload 9
      //   442: invokeinterface 180 2 0
      //   447: goto -444 -> 3
      //   450: astore 8
      //   452: aload 8
      //   454: invokevirtual 173	java/lang/InterruptedException:printStackTrace	()V
      //   457: goto -454 -> 3
      //   460: aload_0
      //   461: getfield 15	com/tencent/tavcut/cover/EditCoverGenerator$CoverRunnable:this$0	Lcom/tencent/tavcut/cover/EditCoverGenerator;
      //   464: invokestatic 48	com/tencent/tavcut/cover/EditCoverGenerator:access$700	(Lcom/tencent/tavcut/cover/EditCoverGenerator;)Z
      //   467: ifeq +11 -> 478
      //   470: aload_0
      //   471: getfield 15	com/tencent/tavcut/cover/EditCoverGenerator$CoverRunnable:this$0	Lcom/tencent/tavcut/cover/EditCoverGenerator;
      //   474: invokestatic 183	com/tencent/tavcut/cover/EditCoverGenerator:access$1300	(Lcom/tencent/tavcut/cover/EditCoverGenerator;)V
      //   477: return
      //   478: aload_0
      //   479: getfield 15	com/tencent/tavcut/cover/EditCoverGenerator$CoverRunnable:this$0	Lcom/tencent/tavcut/cover/EditCoverGenerator;
      //   482: invokestatic 156	com/tencent/tavcut/cover/EditCoverGenerator:access$300	(Lcom/tencent/tavcut/cover/EditCoverGenerator;)Ljava/util/concurrent/ConcurrentHashMap;
      //   485: ifnull +16 -> 501
      //   488: aload_0
      //   489: getfield 15	com/tencent/tavcut/cover/EditCoverGenerator$CoverRunnable:this$0	Lcom/tencent/tavcut/cover/EditCoverGenerator;
      //   492: invokestatic 156	com/tencent/tavcut/cover/EditCoverGenerator:access$300	(Lcom/tencent/tavcut/cover/EditCoverGenerator;)Ljava/util/concurrent/ConcurrentHashMap;
      //   495: invokevirtual 184	java/util/concurrent/ConcurrentHashMap:isEmpty	()Z
      //   498: ifne +16 -> 514
      //   501: iload 5
      //   503: istore_1
      //   504: aload_0
      //   505: getfield 15	com/tencent/tavcut/cover/EditCoverGenerator$CoverRunnable:this$0	Lcom/tencent/tavcut/cover/EditCoverGenerator;
      //   508: invokestatic 45	com/tencent/tavcut/cover/EditCoverGenerator:access$600	(Lcom/tencent/tavcut/cover/EditCoverGenerator;)Z
      //   511: ifeq +5 -> 516
      //   514: iconst_1
      //   515: istore_1
      //   516: iload_1
      //   517: ifeq -40 -> 477
      //   520: aload_0
      //   521: getfield 15	com/tencent/tavcut/cover/EditCoverGenerator$CoverRunnable:this$0	Lcom/tencent/tavcut/cover/EditCoverGenerator;
      //   524: invokestatic 187	com/tencent/tavcut/cover/EditCoverGenerator:access$1400	(Lcom/tencent/tavcut/cover/EditCoverGenerator;)V
      //   527: aload_0
      //   528: getfield 15	com/tencent/tavcut/cover/EditCoverGenerator$CoverRunnable:this$0	Lcom/tencent/tavcut/cover/EditCoverGenerator;
      //   531: invokestatic 190	com/tencent/tavcut/cover/EditCoverGenerator:access$1500	(Lcom/tencent/tavcut/cover/EditCoverGenerator;)V
      //   534: return
      //   535: astore 10
      //   537: goto -119 -> 418
      //   540: astore 9
      //   542: goto -148 -> 394
      //   545: iload 6
      //   547: istore_3
      //   548: goto -255 -> 293
      //   551: iload 7
      //   553: istore_2
      //   554: goto -269 -> 285
      //   557: aconst_null
      //   558: astore 8
      //   560: goto -235 -> 325
      //   563: aconst_null
      //   564: astore 8
      //   566: goto -378 -> 188
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	569	0	this	CoverRunnable
      //   237	280	1	i	int
      //   198	356	2	j	int
      //   204	344	3	k	int
      //   253	44	4	m	int
      //   1	501	5	n	int
      //   277	269	6	i1	int
      //   265	287	7	i2	int
      //   73	344	8	localObject1	Object
      //   450	3	8	localInterruptedException1	InterruptedException
      //   558	7	8	localObject2	Object
      //   133	242	9	localObject3	Object
      //   389	13	9	localInterruptedException2	InterruptedException
      //   408	33	9	localObject4	Object
      //   540	1	9	localInterruptedException3	InterruptedException
      //   212	110	10	localObject5	Object
      //   413	13	10	localException1	java.lang.Exception
      //   535	1	10	localException2	java.lang.Exception
      // Exception table:
      //   from	to	target	type
      //   58	75	389	java/lang/InterruptedException
      //   147	181	413	java/lang/Exception
      //   433	447	450	java/lang/InterruptedException
      //   181	188	535	java/lang/Exception
      //   75	131	540	java/lang/InterruptedException
    }
  }
  
  class CoverTask
    implements Comparable<CoverTask>
  {
    private boolean generating;
    private int index;
    private long requestTimeMs;
    private CMTime startTime;
    
    CoverTask(long paramLong, CMTime paramCMTime, int paramInt)
    {
      this.requestTimeMs = paramLong;
      this.startTime = paramCMTime;
      this.index = paramInt;
      EditCoverGenerator.this.mCoverTaskMap.put(Integer.valueOf(this.index), this);
    }
    
    public int compareTo(@NonNull CoverTask paramCoverTask)
    {
      return (int)(this.requestTimeMs - paramCoverTask.requestTimeMs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tavcut.cover.EditCoverGenerator
 * JD-Core Version:    0.7.0.1
 */