package com.tencent.component.media.image;

import com.tencent.component.media.ILog;
import com.tencent.component.media.ImageManagerEnv;
import com.tencent.component.media.gif.NewGifDecoder.Options;
import com.tencent.component.media.gif.NewGifDrawable;
import com.tencent.component.media.image.processor.NewGifDrawableSpecifiedRegionProcessor;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class StreamDecodeGifTask
  extends DecodeImageTask
{
  protected static ConcurrentHashMap<String, NewGifDrawable> mGifDrawableRecord = new ConcurrentHashMap();
  private static int mObjectPoolSize = 0;
  private static StreamDecodeGifTask sPool = null;
  private static final Object sPoolSync = new Object();
  private long beginTime = 0L;
  ThreadPoolExecutor executorService;
  boolean isFirstCallback = true;
  private volatile int mBaseImageCount = 1;
  private volatile int mControlLimitTimes = 3;
  private volatile int mControlTimes = 2;
  DecodeStreamTask mDecodetask;
  Future<?> mEndRes;
  EndCloseStreamTask mEndTask;
  private volatile boolean mNeedControl = false;
  Future<?> mProgressRes;
  protected List<Runnable> mResult = new ArrayList();
  private StreamDecodeGifTask next = null;
  
  protected StreamDecodeGifTask(ImageKey paramImageKey)
  {
    super(paramImageKey);
  }
  
  protected StreamDecodeGifTask(ImageTask paramImageTask)
  {
    super(paramImageTask);
  }
  
  private void decoding(ImageKey paramImageKey, String paramString1, String paramString2)
  {
    localObject = (NewGifDrawable)ImageManager.getInstance().getDrawbleFromCache(paramImageKey);
    if (localObject == null) {}
    for (;;)
    {
      try
      {
        NewGifDecoder.Options localOptions = new NewGifDecoder.Options();
        localOptions.inPreferHeight = paramImageKey.options.clipHeight;
        localOptions.inPreferWidth = paramImageKey.options.clipWidth;
        paramString2 = new NewGifDrawable(paramString2, 4, localOptions, paramImageKey.hashCodeEx());
        if (paramString2 == null) {
          return;
        }
        paramString2.printStackTrace();
      }
      catch (IOException paramString2)
      {
        try
        {
          paramString2.setUrl(paramImageKey.url);
          localObject = paramString2;
          this.mBaseImageCount = ((NewGifDrawable)localObject).getImageCount();
          ImageManagerEnv.getLogger().d("StreamDecodeGifTask-decoding-thread", new Object[] { "RESULT_ON_STREAM_APPLY_IMAGE newFile count:" + this.mBaseImageCount + " hashcode:" + paramImageKey.hashCodeEx() + " url:" + paramString1 });
          setResult(15, new Object[] { localObject });
          this.beginTime = System.currentTimeMillis();
          ImageManagerEnv.getLogger().d("StreamDecodeGifTask-performance", new Object[] { "First time:" + System.currentTimeMillis() + " hashcode:" + paramImageKey.hashCodeEx() + " url:" + paramString1 });
          paramString1 = (String)localObject;
          paramString2 = paramString1;
          if (paramImageKey != null)
          {
            paramString2 = paramString1;
            if (paramImageKey.options != null)
            {
              paramString2 = paramString1;
              if ((paramImageKey.options.extraProcessor instanceof NewGifDrawableSpecifiedRegionProcessor)) {
                paramString2 = (NewGifDrawable)paramImageKey.options.extraProcessor.doProcess(paramString1);
              }
            }
          }
          ImageManager.getInstance().putDrawableInMemoryCache(paramImageKey, paramImageKey.hashCodeEx(), null, paramString2, paramImageKey.options);
          return;
        }
        catch (IOException localIOException)
        {
          for (;;)
          {
            localObject = paramString2;
            paramString2 = localIOException;
          }
        }
        paramString2 = paramString2;
      }
      continue;
      if (this.mControlTimes != 0)
      {
        this.mControlTimes -= 1;
        paramString1 = (String)localObject;
      }
      else
      {
        ((NewGifDrawable)localObject).updateFile(paramString2);
        if (((NewGifDrawable)localObject).getImageCount() > this.mBaseImageCount)
        {
          this.mControlTimes = this.mControlLimitTimes;
          ImageManagerEnv.getLogger().d("StreamDecodeGifTask-decoding-thread", new Object[] { "updateFile mControlLimitTimes:" + this.mControlLimitTimes + " hashcode:" + paramImageKey.hashCodeEx() + " url:" + paramString1 });
          paramString1 = (String)localObject;
        }
        else
        {
          this.mControlTimes = this.mControlLimitTimes;
          this.mControlLimitTimes *= 2;
          this.mControlTimes = (this.mControlLimitTimes - this.mControlTimes);
          paramString1 = (String)localObject;
        }
      }
    }
  }
  
  public static StreamDecodeGifTask obtain(ImageTask paramImageTask)
  {
    if (needRecycle) {}
    synchronized (sPoolSync)
    {
      if (sPool != null)
      {
        StreamDecodeGifTask localStreamDecodeGifTask = sPool;
        sPool = sPool.next;
        localStreamDecodeGifTask.next = null;
        mObjectPoolSize -= 1;
        localStreamDecodeGifTask.setImageTask(paramImageTask);
        return localStreamDecodeGifTask;
      }
      return new StreamDecodeGifTask(paramImageTask);
    }
  }
  
  public void excuteTask()
  {
    this.executorService = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
    super.excuteTask();
  }
  
  protected void onResult(int paramInt, Object... paramVarArgs)
  {
    String str;
    switch (paramInt)
    {
    default: 
      super.setResult(paramInt, paramVarArgs);
    case 14: 
      do
      {
        return;
        str = (String)paramVarArgs[0];
        paramVarArgs = (String)paramVarArgs[1];
      } while (this.executorService.isShutdown());
      if (this.executorService.getQueue().contains(this.mDecodetask))
      {
        ImageManagerEnv.getLogger().d("StreamDecodeGifTask", new Object[] { "onResult RESULT_ON_STREAM_PROGRESS | contains | hashcode:" + this.mImageKey.hashCodeEx() });
        return;
      }
      this.mDecodetask = new DecodeStreamTask(this.mImageKey, str, paramVarArgs);
      this.mProgressRes = this.executorService.submit(this.mDecodetask);
      return;
    case 2: 
      paramVarArgs = (String)paramVarArgs[0];
      str = this.mImageKey.filePath;
      if (!this.executorService.isShutdown())
      {
        if (this.executorService.getQueue().contains(this.mEndTask))
        {
          ImageManagerEnv.getLogger().d("StreamDecodeGifTask", new Object[] { "onResult RESULT_ON_DONWNLOAD_SUCCEED contains | hashcode:" + this.mImageKey.hashCodeEx() });
          return;
        }
        this.mEndTask = new EndCloseStreamTask(this.mImageKey, paramVarArgs, str);
        this.mEndRes = this.executorService.submit(this.mEndTask);
      }
      this.executorService.shutdown();
      return;
    }
    if (this.isFirstCallback)
    {
      ImageTaskBuilder.stampMap2.put(this.mImageKey.url, Long.valueOf(System.currentTimeMillis()));
      this.isFirstCallback = false;
    }
    super.setResult(paramInt, paramVarArgs);
  }
  
  public void recycle()
  {
    if (!needRecycle) {
      return;
    }
    reset();
    if ((this.executorService != null) && (!this.executorService.isShutdown()))
    {
      ImageManagerEnv.getLogger().d("StreamDecodeGifTask", new Object[] { "executorService shutdown" });
      this.executorService.shutdown();
    }
    this.mDecodetask = null;
    this.mEndTask = null;
    synchronized (sPoolSync)
    {
      if (mObjectPoolSize < 50)
      {
        this.next = sPool;
        sPool = this;
        mObjectPoolSize += 1;
      }
      return;
    }
  }
  
  protected void removeRecord(String paramString)
  {
    boolean bool;
    if (this.mDecodetask != null)
    {
      bool = this.executorService.remove(this.mDecodetask);
      ImageManagerEnv.getLogger().d("StreamDecodeGifTask", new Object[] { "mDecodetask remove:" + bool });
    }
    if (this.mProgressRes != null) {}
    try
    {
      this.mProgressRes.get();
      if (this.mEndTask != null)
      {
        bool = this.executorService.remove(this.mEndTask);
        ImageManagerEnv.getLogger().d("kaedelin", new Object[] { "mEndTask remove:" + bool });
      }
      if (this.mEndRes == null) {}
    }
    catch (InterruptedException paramString)
    {
      for (;;)
      {
        try
        {
          this.mEndRes.get();
          return;
        }
        catch (InterruptedException paramString)
        {
          paramString.printStackTrace();
          return;
        }
        catch (ExecutionException paramString)
        {
          paramString.printStackTrace();
        }
        paramString = paramString;
        paramString.printStackTrace();
      }
    }
    catch (ExecutionException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  class DecodeStreamTask
    implements Runnable
  {
    private ImageKey key = null;
    String path = null;
    String url = null;
    
    public DecodeStreamTask(ImageKey paramImageKey, String paramString1, String paramString2)
    {
      this.key = paramImageKey;
      this.url = paramString1;
      this.path = paramString2;
    }
    
    public void run()
    {
      try
      {
        if (!StreamDecodeGifTask.this.isCanceled()) {
          StreamDecodeGifTask.this.decoding(this.key, this.url, this.path);
        }
        return;
      }
      catch (Throwable localThrowable)
      {
        ImageManagerEnv.getLogger().e("StreamDecodeGifTask-decoding-thread", new Object[] { "DecodeStreamTask error : " + localThrowable.toString() });
      }
    }
  }
  
  class EndCloseStreamTask
    implements Runnable
  {
    String filePath = null;
    private ImageKey key = null;
    String url = null;
    
    public EndCloseStreamTask(ImageKey paramImageKey, String paramString1, String paramString2)
    {
      this.key = paramImageKey;
      this.url = paramString1;
      this.filePath = paramString2;
    }
    
    public void run()
    {
      if (StreamDecodeGifTask.this.isCanceled()) {
        return;
      }
      label687:
      for (;;)
      {
        try
        {
          NewGifDrawable localNewGifDrawable = (NewGifDrawable)ImageManager.getInstance().getDrawbleFromCache(this.key);
          if (localNewGifDrawable != null)
          {
            ImageManagerEnv.getLogger().d("StreamDecodeGifTask-decoding-thread", new Object[] { " isEndDownload hashcode:" + this.key.hashCodeEx() + " filePath:" + this.filePath + " url:" + this.url });
            if ((this.key == null) || (this.key.options == null) || (!(this.key.options.extraProcessor instanceof NewGifDrawableSpecifiedRegionProcessor))) {
              break label687;
            }
            localNewGifDrawable = (NewGifDrawable)this.key.options.extraProcessor.doProcess(localNewGifDrawable);
            localNewGifDrawable.isEndDownload();
            localNewGifDrawable.changeFile(this.filePath);
            ImageManager.getInstance().putDrawableInMemoryCache(this.key, this.key.hashCodeEx(), null, localNewGifDrawable, this.key.options);
            StreamDecodeGifTask.this.setResult(8, new Object[] { localNewGifDrawable, null, this.key.urlKey, Integer.valueOf(this.key.hashCodeEx()), null, localNewGifDrawable });
            ImageManagerEnv.getLogger().d("StreamDecodeGifTask-performance", new Object[] { "isEndDownload hashcode:" + this.key.hashCodeEx() + "\ncost time:" + (System.currentTimeMillis() - StreamDecodeGifTask.this.beginTime) + "\nwidth:" + localNewGifDrawable.getsWidth() + " height:" + localNewGifDrawable.getsHeight() + "\nframe count:" + localNewGifDrawable.getNumberOfFrames() + "\nlength:" + localNewGifDrawable.getAllocationByteCount() + "\nnetworkstate:" + ImageManagerEnv.g().getNetWorkState() + "\ncontrolsTime:" + StreamDecodeGifTask.this.mControlLimitTimes + "\nurl:" + this.url });
            if (StreamDecodeGifTask.this.beginTime == 0L) {
              break;
            }
            HashMap localHashMap = new HashMap();
            int i = (int)(System.currentTimeMillis() - StreamDecodeGifTask.this.beginTime);
            if (i <= 0) {
              break;
            }
            localHashMap.put("g_costTime", String.valueOf(i));
            localHashMap.put("g_width", String.valueOf(localNewGifDrawable.getsWidth()));
            localHashMap.put("g_height", String.valueOf(localNewGifDrawable.getsHeight()));
            localHashMap.put("g_frameCount", String.valueOf(localNewGifDrawable.getNumberOfFrames()));
            localHashMap.put("g_size", String.valueOf(localNewGifDrawable.getAllocationByteCount()));
            localHashMap.put("g_networkstate", String.valueOf(ImageManagerEnv.g().getNetWorkState()));
            localHashMap.put("g_controlsTime", String.valueOf(StreamDecodeGifTask.this.mControlLimitTimes));
            ImageManagerEnv.g().reportImageTimeCostMTA("gifPlayingReportNew", "performance", "g_costTime", i);
            ImageManagerEnv.g().reportImageTimeCostMTA("gifPlayingReportNew", "performance", "g_frameCount", localNewGifDrawable.getNumberOfFrames());
            ImageManagerEnv.g().reportImageTimeCostMTA("gifPlayingReportNew", "performance", "g_size", (int)localNewGifDrawable.getAllocationByteCount());
            ImageManagerEnv.g().reportImageTimeCostMTA("gifPlayingReportNew", "performance", "g_controlsTime", StreamDecodeGifTask.this.mControlLimitTimes);
            ImageManagerEnv.g().statisticCollectorReport("gifPlayingReportNew", localHashMap);
            return;
          }
        }
        catch (Throwable localThrowable)
        {
          ImageManagerEnv.getLogger().e("StreamDecodeGifTask-decoding-thread", new Object[] { "EndCloseStreamTask error :" + localThrowable.toString() });
          return;
        }
        ImageManagerEnv.getLogger().e("StreamDecodeGifTask-decoding-thread", new Object[] { " NewGifDrawable is null url:" + this.url });
        StreamDecodeGifTask.this.startDecodeTask();
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.component.media.image.StreamDecodeGifTask
 * JD-Core Version:    0.7.0.1
 */