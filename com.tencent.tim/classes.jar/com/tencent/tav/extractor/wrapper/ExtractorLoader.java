package com.tencent.tav.extractor.wrapper;

import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.tav.extractor.AssetExtractor;

public class ExtractorLoader
{
  private static Handler loadHandler;
  private static HandlerThread loadThread = new HandlerThread("ExtractorLoader");
  
  static
  {
    loadThread.start();
  }
  
  public static void cacheExtractor(AssetExtractor paramAssetExtractor)
  {
    checkAndStart();
    loadHandler.post(new ExtractorLoaderRunnable(paramAssetExtractor));
  }
  
  public static void cacheExtractor(String paramString)
  {
    checkAndStart();
    loadHandler.post(new VideoPathLoaderRunnable(paramString));
  }
  
  private static void checkAndStart()
  {
    if ((loadHandler == null) && (loadThread.getLooper() != null)) {
      loadHandler = new Handler(loadThread.getLooper());
    }
  }
  
  static class ExtractorLoaderRunnable
    implements Runnable
  {
    private AssetExtractor extractor;
    
    ExtractorLoaderRunnable(AssetExtractor paramAssetExtractor)
    {
      this.extractor = paramAssetExtractor;
    }
    
    public void run()
    {
      if (!ExtractorWrapperPool.contains(this.extractor.getSourcePath()))
      {
        ExtractorWrapper localExtractorWrapper = new ExtractorWrapper(this.extractor.getSourcePath());
        localExtractorWrapper.checkAndLoad(this.extractor);
        ExtractorWrapperPool.put(localExtractorWrapper);
        this.extractor = null;
      }
    }
  }
  
  static class VideoPathLoaderRunnable
    implements Runnable
  {
    private String videoPath;
    
    VideoPathLoaderRunnable(String paramString)
    {
      this.videoPath = paramString;
    }
    
    public void run()
    {
      if (!ExtractorWrapperPool.contains(this.videoPath))
      {
        AssetExtractor localAssetExtractor = new AssetExtractor();
        localAssetExtractor.setDataSource(this.videoPath);
        ExtractorWrapper localExtractorWrapper = new ExtractorWrapper(this.videoPath);
        localExtractorWrapper.checkAndLoad(localAssetExtractor);
        ExtractorWrapperPool.put(localExtractorWrapper);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tav.extractor.wrapper.ExtractorLoader
 * JD-Core Version:    0.7.0.1
 */