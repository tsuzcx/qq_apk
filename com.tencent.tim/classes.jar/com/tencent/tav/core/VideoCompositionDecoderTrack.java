package com.tencent.tav.core;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.tav.asset.Asset;
import com.tencent.tav.asset.AssetTrack;
import com.tencent.tav.core.compositing.AsynchronousVideoCompositionRequest;
import com.tencent.tav.core.compositing.VideoCompositing;
import com.tencent.tav.core.compositing.VideoCompositionRenderContext;
import com.tencent.tav.core.composition.VideoComposition;
import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.tav.decoder.DecoderTrackSegment;
import com.tencent.tav.decoder.IDecoder;
import com.tencent.tav.decoder.IDecoder.DecodeType;
import com.tencent.tav.decoder.IDecoderTrack;
import com.tencent.tav.decoder.IDecoderTrack.SurfaceCreator;
import com.tencent.tav.decoder.RenderContext;
import com.tencent.tav.decoder.VideoDecoderTrack;
import com.tencent.tav.decoder.logger.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class VideoCompositionDecoderTrack
  implements IDecoderTrack
{
  private static final String TAG = "VideoComDecoderTrack";
  private static final int WAIT_TIME = 200;
  private Asset asset;
  private AssetExtension assetExtension;
  private List<AssetTrack> assetTrackList = new ArrayList();
  private boolean asynced = true;
  private List<IDecoderTrack> decoderTrackList = new ArrayList();
  private CMTime frameDuration = new CMTime(1L, 30);
  private int frameRate = 30;
  private CMTime lastSampleTime = CMTime.CMTimeInvalid;
  private VideoCompositionRenderContext renderContext;
  private int trackId;
  private VideoCompositing videoCompositing;
  private VideoComposition videoComposition;
  
  public VideoCompositionDecoderTrack(Asset paramAsset, AssetExtension paramAssetExtension, int paramInt)
  {
    this.asset = paramAsset;
    this.assetExtension = paramAssetExtension;
    this.trackId = paramInt;
  }
  
  @NonNull
  private AsynchronousVideoCompositionRequest createVideoCompositionRequest(CMTime paramCMTime)
  {
    AsynchronousVideoCompositionRequest localAsynchronousVideoCompositionRequest = new AsynchronousVideoCompositionRequest(this, this.assetExtension);
    localAsynchronousVideoCompositionRequest.setRenderContext(this.renderContext);
    localAsynchronousVideoCompositionRequest.setCompositionTime(paramCMTime);
    if (this.videoComposition != null) {
      localAsynchronousVideoCompositionRequest.setVideoCompositionInstruction(VideoComposition.findInstruction(this.videoComposition, paramCMTime));
    }
    return localAsynchronousVideoCompositionRequest;
  }
  
  private CMSampleBuffer getSampleFromRequest(AsynchronousVideoCompositionRequest paramAsynchronousVideoCompositionRequest)
  {
    try
    {
      if (paramAsynchronousVideoCompositionRequest.getStatus() == -2147483648) {
        waitForRequestFinish(200);
      }
      switch (paramAsynchronousVideoCompositionRequest.getStatus())
      {
      default: 
        this.lastSampleTime = IDecoder.SAMPLE_TIME_ERROR;
        if (Logger.LOG_VERBOSE) {
          Logger.e("VideoComDecoderTrack", "readSample: failed 1 " + this.lastSampleTime);
        }
        return new CMSampleBuffer(IDecoder.SAMPLE_TIME_ERROR);
      }
    }
    finally {}
    this.lastSampleTime = paramAsynchronousVideoCompositionRequest.getComposedSampleBuffer().getTime();
    return paramAsynchronousVideoCompositionRequest.getComposedSampleBuffer();
  }
  
  @Nullable
  private CMSampleBuffer readSampleToRequest(CMTime paramCMTime, AsynchronousVideoCompositionRequest paramAsynchronousVideoCompositionRequest)
  {
    Object localObject2 = null;
    Iterator localIterator = this.decoderTrackList.iterator();
    for (;;)
    {
      Object localObject1 = localObject2;
      CMSampleBuffer localCMSampleBuffer;
      if (localIterator.hasNext())
      {
        localObject1 = (IDecoderTrack)localIterator.next();
        localCMSampleBuffer = ((IDecoderTrack)localObject1).readSample(paramCMTime);
        if ((localCMSampleBuffer.getTime().equalsTo(IDecoder.SAMPLE_TIME_ERROR)) || (localCMSampleBuffer.getTime().equalsTo(IDecoder.SAMPLE_TIME_FAILED)) || (localCMSampleBuffer.getTime().equalsTo(IDecoder.SAMPLE_TIME_UNSTART)))
        {
          this.lastSampleTime = localCMSampleBuffer.getTime();
          Logger.e("VideoComDecoderTrack", "readSample: failed 0 " + localCMSampleBuffer.getTime());
          localObject1 = new CMSampleBuffer(localCMSampleBuffer.getTime(), (TextureInfo)null);
        }
      }
      else
      {
        return localObject1;
      }
      if (localCMSampleBuffer.getTime().equalsTo(IDecoder.SAMPLE_TIME_FINISH))
      {
        if (this.decoderTrackList.size() <= 1)
        {
          Logger.d("VideoComDecoderTrack", "readSample: finish 1");
          return localCMSampleBuffer;
        }
      }
      else {
        paramAsynchronousVideoCompositionRequest.appendCMSampleBuffer(localCMSampleBuffer, ((IDecoderTrack)localObject1).getTrackId());
      }
    }
  }
  
  private void waitForRequestFinish(int paramInt)
  {
    long l = paramInt;
    try
    {
      wait(l);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
    finally {}
  }
  
  public void addTrack(AssetTrack paramAssetTrack)
  {
    try
    {
      this.assetTrackList.add(paramAssetTrack);
      return;
    }
    finally
    {
      paramAssetTrack = finally;
      throw paramAssetTrack;
    }
  }
  
  public void asyncReadNextSample(CMTime paramCMTime)
  {
    if (!this.asynced) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.decoderTrackList.iterator();
      while (localIterator.hasNext()) {
        ((IDecoderTrack)localIterator.next()).asyncReadNextSample(paramCMTime);
      }
    }
  }
  
  public void clipRangeAndClearRange(CMTimeRange paramCMTimeRange)
  {
    Iterator localIterator = this.decoderTrackList.iterator();
    while (localIterator.hasNext()) {
      ((IDecoderTrack)localIterator.next()).clipRangeAndClearRange(paramCMTimeRange);
    }
  }
  
  public Asset getAsset()
  {
    return this.asset;
  }
  
  public CMTime getCurrentSampleTime()
  {
    return this.lastSampleTime;
  }
  
  public CMTime getDuration()
  {
    Object localObject = CMTime.CMTimeZero;
    Iterator localIterator = this.decoderTrackList.iterator();
    if (localIterator.hasNext())
    {
      CMTime localCMTime = ((IDecoderTrack)localIterator.next()).getDuration();
      if (localCMTime.bigThan((CMTime)localObject)) {
        localObject = localCMTime;
      }
      for (;;)
      {
        break;
      }
    }
    return localObject;
  }
  
  public CMTime getFrameDuration()
  {
    return this.frameDuration;
  }
  
  public int getFrameRate()
  {
    return this.frameRate;
  }
  
  public VideoCompositionRenderContext getRenderContext()
  {
    return this.renderContext;
  }
  
  public int getTrackId()
  {
    return this.trackId;
  }
  
  public VideoCompositing getVideoCompositing()
  {
    return this.videoCompositing;
  }
  
  public VideoComposition getVideoComposition()
  {
    return this.videoComposition;
  }
  
  public CMSampleBuffer readSample()
  {
    if ((this.lastSampleTime == IDecoder.SAMPLE_TIME_UNSTART) || (this.lastSampleTime == CMTime.CMTimeInvalid)) {
      return readSample(CMTime.CMTimeZero);
    }
    return readSample(this.lastSampleTime.add(this.frameDuration));
  }
  
  public CMSampleBuffer readSample(CMTime paramCMTime)
  {
    if (Logger.LOG_VERBOSE) {
      Logger.d("VideoComDecoderTrack", "readSample:[targetTime " + paramCMTime + "]" + this.videoCompositing);
    }
    if (this.videoCompositing == null)
    {
      this.lastSampleTime = IDecoder.SAMPLE_TIME_ERROR;
      if (Logger.LOG_VERBOSE) {
        Logger.e("VideoComDecoderTrack", "readSample: failed 2 " + this.lastSampleTime);
      }
      paramCMTime = new CMSampleBuffer(IDecoder.SAMPLE_TIME_ERROR);
    }
    Object localObject;
    AsynchronousVideoCompositionRequest localAsynchronousVideoCompositionRequest;
    do
    {
      return paramCMTime;
      localObject = paramCMTime;
      if (paramCMTime.getValue() < 0L) {
        localObject = this.lastSampleTime.add(this.frameDuration);
      }
      localAsynchronousVideoCompositionRequest = createVideoCompositionRequest((CMTime)localObject);
      localObject = readSampleToRequest((CMTime)localObject, localAsynchronousVideoCompositionRequest);
      paramCMTime = (CMTime)localObject;
    } while (localObject != null);
    if (localAsynchronousVideoCompositionRequest.getSourceTrackIDs().size() == 0)
    {
      if (Logger.LOG_VERBOSE) {
        Logger.d("VideoComDecoderTrack", "readSample: finish 2");
      }
      return new CMSampleBuffer(IDecoder.SAMPLE_TIME_FINISH);
    }
    if (Logger.LOG_VERBOSE) {
      Logger.e("VideoComDecoderTrack", "readSample: startVideoCompositionRequest ");
    }
    this.videoCompositing.startVideoCompositionRequest(localAsynchronousVideoCompositionRequest);
    if (Logger.LOG_VERBOSE) {
      Logger.e("VideoComDecoderTrack", "readSample: startVideoCompositionRequest finish ");
    }
    return getSampleFromRequest(localAsynchronousVideoCompositionRequest);
  }
  
  public void release()
  {
    Logger.e("VideoComDecoderTrack", "release:start " + this);
    Iterator localIterator = this.decoderTrackList.iterator();
    while (localIterator.hasNext()) {
      ((IDecoderTrack)localIterator.next()).release();
    }
    this.decoderTrackList.clear();
    this.assetTrackList.clear();
    this.videoComposition = null;
    this.videoCompositing = null;
    this.renderContext = null;
    Logger.e("VideoComDecoderTrack", "release:finish " + this);
  }
  
  public void removeTrack(AssetTrack paramAssetTrack)
  {
    try
    {
      this.assetTrackList.remove(paramAssetTrack);
      return;
    }
    finally
    {
      paramAssetTrack = finally;
      throw paramAssetTrack;
    }
  }
  
  public CMSampleBuffer seekTo(CMTime paramCMTime, boolean paramBoolean1, boolean paramBoolean2)
  {
    Logger.d("VideoComDecoderTrack", "seekTo:[timeUs " + paramCMTime + "] [needRead " + paramBoolean1 + "] [quickSeek " + paramBoolean2 + "]");
    Iterator localIterator = this.decoderTrackList.iterator();
    while (localIterator.hasNext()) {
      ((IDecoderTrack)localIterator.next()).seekTo(paramCMTime, false, paramBoolean2);
    }
    if (paramCMTime.bigThan(this.frameDuration)) {}
    for (this.lastSampleTime = paramCMTime.sub(this.frameDuration); paramBoolean1; this.lastSampleTime = paramCMTime) {
      return readSample();
    }
    return null;
  }
  
  public void setDecodeType(IDecoder.DecodeType paramDecodeType) {}
  
  public void setFrameDuration(CMTime paramCMTime)
  {
    this.frameDuration = paramCMTime;
  }
  
  public void setFrameRate(int paramInt)
  {
    this.frameRate = paramInt;
    Iterator localIterator = this.decoderTrackList.iterator();
    while (localIterator.hasNext()) {
      ((IDecoderTrack)localIterator.next()).setFrameRate(paramInt);
    }
  }
  
  public void setRenderContext(VideoCompositionRenderContext paramVideoCompositionRenderContext)
  {
    this.renderContext = paramVideoCompositionRenderContext;
  }
  
  public void setTrackSegments(List<DecoderTrackSegment> paramList) {}
  
  public void setVideoCompositing(VideoCompositing paramVideoCompositing)
  {
    this.videoCompositing = paramVideoCompositing;
  }
  
  public void setVideoComposition(VideoComposition paramVideoComposition)
  {
    this.videoComposition = paramVideoComposition;
  }
  
  public void setVolume(float paramFloat) {}
  
  public void start()
  {
    start(null);
  }
  
  public void start(IDecoderTrack.SurfaceCreator paramSurfaceCreator)
  {
    start(paramSurfaceCreator, null);
  }
  
  public void start(IDecoderTrack.SurfaceCreator paramSurfaceCreator, CMTimeRange paramCMTimeRange)
  {
    Logger.d("VideoComDecoderTrack", "start:[start] " + paramCMTimeRange + " size - " + this.assetTrackList.size());
    this.renderContext = new VideoCompositionRenderContext((RenderContext)paramSurfaceCreator);
    this.renderContext.setVideoComposition(this.videoComposition);
    Iterator localIterator = this.assetTrackList.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (AssetTrack)localIterator.next();
      if (((AssetTrack)localObject).getMediaType() == 1)
      {
        VideoDecoderTrack localVideoDecoderTrack = new VideoDecoderTrack((AssetTrack)localObject);
        this.decoderTrackList.add(localVideoDecoderTrack);
        if (paramCMTimeRange != null)
        {
          localVideoDecoderTrack.start(paramSurfaceCreator, paramCMTimeRange);
        }
        else
        {
          localObject = ((AssetTrack)localObject).getTimeRange();
          if (localObject == null) {}
          for (localObject = null;; localObject = new CMTimeRange(((CMTimeRange)localObject).getStart(), ((CMTimeRange)localObject).getDuration()))
          {
            localVideoDecoderTrack.start(paramSurfaceCreator, (CMTimeRange)localObject);
            break;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.tav.core.VideoCompositionDecoderTrack
 * JD-Core Version:    0.7.0.1
 */