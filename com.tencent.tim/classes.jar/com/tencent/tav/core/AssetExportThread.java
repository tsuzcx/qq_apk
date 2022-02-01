package com.tencent.tav.core;

import android.graphics.Matrix;
import android.graphics.Point;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.tav.asset.Asset;
import com.tencent.tav.core.compositing.VideoCompositing;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.decoder.AudioInfo;
import com.tencent.tav.decoder.DecoderUtils;
import com.tencent.tav.decoder.EncoderWriter.OutputConfig;
import com.tencent.tav.decoder.Filter;
import com.tencent.tav.decoder.RenderContextParams;
import com.tencent.tav.decoder.VideoDecoder;
import com.tencent.tav.decoder.logger.Logger;
import com.tencent.tav.report.ExportReportSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class AssetExportThread
  extends HandlerThread
  implements Handler.Callback
{
  private static final String TAG = "AssetExportThread";
  private static final int msg_done_a = 2;
  private static final int msg_done_v = 1;
  private AssetReader assetReader;
  private AssetWriter assetWriter;
  private HandlerThread audioExportThread;
  private AudioInfo audioInfo;
  private AudioMix audioMix;
  private boolean audioReadFinish = false;
  private AssetReaderOutput audioReader;
  private long audioTime = 0L;
  private AssetWriterInput audioWriter;
  private volatile boolean audioWriterDone = false;
  private AssetExportSession.ExportCallbackHandler callbackHandler;
  private volatile boolean cancel = false;
  private Handler exportHandler;
  private AssetExportSession exportSession;
  private boolean isFinishing;
  private RenderContextParams renderContextParams;
  @Nullable
  private ExportReportSession reportSession = new ExportReportSession();
  private HandlerThread videoExportThread;
  private boolean videoReadFinish = false;
  private AssetReaderOutput videoReader;
  private long videoTime = 0L;
  private AssetWriterInput videoWriter;
  private volatile boolean videoWriterDone = false;
  
  AssetExportThread(AssetExportSession paramAssetExportSession, AssetExportSession.ExportCallbackHandler paramExportCallbackHandler, AudioMix paramAudioMix)
  {
    super("ExportThread");
    this.exportSession = paramAssetExportSession;
    this.callbackHandler = paramExportCallbackHandler;
    this.audioMix = paramAudioMix;
    this.audioInfo = new AudioInfo(paramAssetExportSession.outputConfig.AUDIO_SAMPLE_RATE_HZ, paramAssetExportSession.outputConfig.AUDIO_CHANNEL_COUNT, 2);
  }
  
  private AssetReaderOutput createAudioTrackOutput()
  {
    Object localObject = (ArrayList)this.exportSession.asset.tracksWithMediaType(2);
    if (localObject != null)
    {
      localObject = new AssetReaderAudioMixOutput((ArrayList)localObject, null);
      ((AssetReaderAudioMixOutput)localObject).setAudioMix(this.audioMix);
      ((AssetReaderAudioMixOutput)localObject).setAudioInfo(this.audioInfo);
      return localObject;
    }
    return new EmptyReaderOutput();
  }
  
  private AssetWriterInput createAudioWriterInput()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("bitrate", Integer.valueOf(this.exportSession.outputConfig.AUDIO_BIT_RATE));
    localHashMap.put("aac-profile", Integer.valueOf(this.exportSession.outputConfig.AUDIO_AAC_PROFILE));
    localHashMap.put("channel-count", Integer.valueOf(this.exportSession.outputConfig.AUDIO_CHANNEL_COUNT));
    localHashMap.put("mime", this.exportSession.outputConfig.AUDIO_MIME_TYPE);
    localHashMap.put("sample-rate", Integer.valueOf(this.exportSession.outputConfig.AUDIO_SAMPLE_RATE_HZ));
    return new AssetWriterInput(2, localHashMap);
  }
  
  private AssetReaderOutput createVideoTrackOutput()
  {
    Object localObject = this.exportSession.asset.tracksWithMediaType(1);
    if (localObject != null)
    {
      HashMap localHashMap = new HashMap(4);
      localHashMap.put("frame-rate", Integer.valueOf(this.exportSession.outputConfig.VIDEO_FRAME_RATE));
      localObject = new AssetReaderVideoCompositionOutput((List)localObject, localHashMap, this.exportSession.assetExtension);
      ((AssetReaderVideoCompositionOutput)localObject).setVideoComposition(this.exportSession.videoComposition);
      ((AssetReaderVideoCompositionOutput)localObject).setVideoCompositing(this.exportSession.videoCompositing);
      ((AssetReaderVideoCompositionOutput)localObject).setVideoRevertMode(this.exportSession.isRevertMode());
      return localObject;
    }
    return new EmptyReaderOutput();
  }
  
  private AssetWriterInput createVideoWriterInput()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("bitrate", Integer.valueOf(this.exportSession.outputConfig.VIDEO_BIT_RATE));
    localHashMap.put("frame-rate", Integer.valueOf(this.exportSession.outputConfig.VIDEO_FRAME_RATE));
    localHashMap.put("i-frame-interval", Integer.valueOf(this.exportSession.outputConfig.VIDEO_IFRAME_INTERVAL));
    localHashMap.put("height", Integer.valueOf(this.exportSession.outputConfig.VIDEO_TARGET_HEIGHT));
    localHashMap.put("width", Integer.valueOf(this.exportSession.outputConfig.VIDEO_TARGET_WIDTH));
    localHashMap.put("HIGH_PROFILE", Boolean.valueOf(this.exportSession.outputConfig.HIGH_PROFILE));
    if (this.reportSession != null) {
      this.reportSession.setFramePerSecond(this.exportSession.outputConfig.VIDEO_FRAME_RATE);
    }
    return new AssetWriterInput(1, localHashMap);
  }
  
  private void exportError(int paramInt)
  {
    try
    {
      exportError(paramInt, null);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void exportError(int paramInt, Throwable paramThrowable)
  {
    try
    {
      exportError(new ExportErrorStatus(paramInt, paramThrowable));
      return;
    }
    finally
    {
      paramThrowable = finally;
      throw paramThrowable;
    }
  }
  
  private void exportError(ExportErrorStatus paramExportErrorStatus)
  {
    if (this.exportSession.status != AssetExportSession.AssetExportSessionStatus.AssetExportSessionStatusFailed)
    {
      this.cancel = true;
      this.exportSession.status = AssetExportSession.AssetExportSessionStatus.AssetExportSessionStatusFailed;
      this.exportSession.exportErrorStatus = paramExportErrorStatus;
      if (this.reportSession != null) {
        this.reportSession.onExportError();
      }
      if (this.callbackHandler != null) {
        this.callbackHandler.handlerCallback(this.exportSession);
      }
    }
  }
  
  /* Error */
  private void exportSuccess()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 95	com/tencent/tav/core/AssetExportThread:exportSession	Lcom/tencent/tav/core/AssetExportSession;
    //   8: getfield 361	com/tencent/tav/core/AssetExportSession:status	Lcom/tencent/tav/core/AssetExportSession$AssetExportSessionStatus;
    //   11: getstatic 382	com/tencent/tav/core/AssetExportSession$AssetExportSessionStatus:AssetExportSessionStatusCompleted	Lcom/tencent/tav/core/AssetExportSession$AssetExportSessionStatus;
    //   14: if_acmpne +8 -> 22
    //   17: aload_0
    //   18: monitorexit
    //   19: aload_0
    //   20: monitorexit
    //   21: return
    //   22: aload_0
    //   23: getfield 95	com/tencent/tav/core/AssetExportThread:exportSession	Lcom/tencent/tav/core/AssetExportSession;
    //   26: fconst_1
    //   27: putfield 386	com/tencent/tav/core/AssetExportSession:progress	F
    //   30: aload_0
    //   31: getfield 95	com/tencent/tav/core/AssetExportThread:exportSession	Lcom/tencent/tav/core/AssetExportSession;
    //   34: getstatic 382	com/tencent/tav/core/AssetExportSession$AssetExportSessionStatus:AssetExportSessionStatusCompleted	Lcom/tencent/tav/core/AssetExportSession$AssetExportSessionStatus;
    //   37: putfield 361	com/tencent/tav/core/AssetExportSession:status	Lcom/tencent/tav/core/AssetExportSession$AssetExportSessionStatus;
    //   40: aload_0
    //   41: monitorexit
    //   42: aload_0
    //   43: getfield 93	com/tencent/tav/core/AssetExportThread:reportSession	Lcom/tencent/tav/report/ExportReportSession;
    //   46: ifnull +10 -> 56
    //   49: aload_0
    //   50: getfield 93	com/tencent/tav/core/AssetExportThread:reportSession	Lcom/tencent/tav/report/ExportReportSession;
    //   53: invokevirtual 389	com/tencent/tav/report/ExportReportSession:onExportSuccess	()V
    //   56: aload_0
    //   57: getfield 97	com/tencent/tav/core/AssetExportThread:callbackHandler	Lcom/tencent/tav/core/AssetExportSession$ExportCallbackHandler;
    //   60: ifnull -41 -> 19
    //   63: aload_0
    //   64: getfield 97	com/tencent/tav/core/AssetExportThread:callbackHandler	Lcom/tencent/tav/core/AssetExportSession$ExportCallbackHandler;
    //   67: aload_0
    //   68: getfield 95	com/tencent/tav/core/AssetExportThread:exportSession	Lcom/tencent/tav/core/AssetExportSession;
    //   71: invokeinterface 379 2 0
    //   76: goto -57 -> 19
    //   79: astore_1
    //   80: aload_0
    //   81: monitorexit
    //   82: aload_1
    //   83: athrow
    //   84: astore_1
    //   85: aload_0
    //   86: monitorexit
    //   87: aload_1
    //   88: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	89	0	this	AssetExportThread
    //   79	4	1	localObject1	Object
    //   84	4	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	4	79	finally
    //   42	56	79	finally
    //   56	76	79	finally
    //   87	89	79	finally
    //   4	19	84	finally
    //   22	42	84	finally
    //   85	87	84	finally
  }
  
  private void exporting()
  {
    initReaderAndWriter();
    this.exportSession.status = AssetExportSession.AssetExportSessionStatus.AssetExportSessionStatusExporting;
    this.videoExportThread = new HandlerThread("VideoWriter");
    this.videoWriter.setWriterProgressListener(new VideoWriterProgressListener(null));
    this.videoWriter.requestMediaDataWhenReadyOnQueue(this.videoExportThread, new VideoRequestMediaDataCallback(null));
    this.audioExportThread = new HandlerThread("VideoWriter");
    this.audioWriter.setWriterProgressListener(new AudioWriterProgressListener(null));
    this.audioWriter.requestMediaDataWhenReadyOnQueue(this.audioExportThread, new AudioRequestMediaDataCallback(null));
  }
  
  private void finish()
  {
    new Handler(this.videoExportThread.getLooper()).post(new AssetExportThread.1(this));
  }
  
  private long getDuration()
  {
    long l2 = 0L;
    if ((this.exportSession != null) && (this.exportSession.timeRange != null)) {
      return this.exportSession.timeRange.getDuration().getTimeUs() * 2L;
    }
    if (this.audioReader != null) {}
    for (long l1 = this.audioReader.duration();; l1 = 0L)
    {
      if (this.videoReader != null) {
        l2 = this.videoReader.duration();
      }
      return l1 + l2;
    }
  }
  
  private Matrix getPreferMatrix()
  {
    int i = this.exportSession.asset.getPreferRotation();
    CGSize localCGSize = this.exportSession.asset.getNaturalSize();
    Matrix localMatrix1 = new Matrix();
    DecoderUtils.getMatrixAndCropRect(localCGSize, i, 1.0F, 0.0F, new Point(0, 0), localMatrix1);
    Matrix localMatrix2 = new Matrix();
    localCGSize = DecoderUtils.getTransformedSize(localCGSize, i, 0.0F);
    float f1;
    float f2;
    if (localCGSize.width * 1.0F / this.exportSession.outputConfig.VIDEO_TARGET_WIDTH > 1.0F * localCGSize.height / this.exportSession.outputConfig.VIDEO_TARGET_HEIGHT)
    {
      f1 = this.exportSession.outputConfig.VIDEO_TARGET_WIDTH / localCGSize.width;
      localMatrix2.setScale(f1, f1);
      f2 = localCGSize.height;
      localMatrix2.postTranslate(0.0F, Math.round((this.exportSession.outputConfig.VIDEO_TARGET_HEIGHT - f2 * f1) * 0.5F));
    }
    for (;;)
    {
      localMatrix1.postConcat(localMatrix2);
      return localMatrix1;
      f1 = this.exportSession.outputConfig.VIDEO_TARGET_HEIGHT / localCGSize.height;
      localMatrix2.setScale(f1, f1);
      f2 = localCGSize.width;
      localMatrix2.postTranslate(Math.round((this.exportSession.outputConfig.VIDEO_TARGET_WIDTH - f2 * f1) * 0.5F), 0.0F);
    }
  }
  
  private void initReaderAndWriter()
  {
    this.assetReader = new AssetReader(this.exportSession.asset);
    this.assetReader.setTimeRange(this.exportSession.timeRange);
    this.videoReader = createVideoTrackOutput();
    this.audioReader = createAudioTrackOutput();
    if (this.assetReader.canAddOutput(this.videoReader)) {
      this.assetReader.addOutput(this.videoReader);
    }
    if (this.assetReader.canAddOutput(this.audioReader)) {
      this.assetReader.addOutput(this.audioReader);
    }
    this.assetWriter = new AssetWriter(this.exportSession.outputFilePath, this.exportSession.outputFileType);
    this.assetWriter.setRenderContextParams(this.renderContextParams);
    if (this.exportSession.timeRange != null)
    {
      this.assetWriter.startSessionAtSourceTime(this.exportSession.timeRange.getStart());
      this.assetWriter.endSessionAtSourceTime(this.exportSession.timeRange.getEnd());
      if (this.reportSession != null) {
        this.reportSession.setFileDurationUs(this.exportSession.timeRange.getDurationUs());
      }
    }
    this.videoWriter = createVideoWriterInput();
    this.audioWriter = createAudioWriterInput();
    if (this.assetWriter.canAddInput(this.videoWriter))
    {
      Matrix localMatrix = null;
      if (this.exportSession.appliesPreferredTrackTransform) {
        localMatrix = getPreferMatrix();
      }
      this.videoWriter.setTransform(localMatrix);
      this.assetWriter.addInput(this.videoWriter);
    }
    if (this.assetWriter.canAddInput(this.audioWriter)) {
      this.assetWriter.addInput(this.audioWriter);
    }
    this.assetWriter.startWriting();
    this.assetReader.startReading(this.assetWriter);
  }
  
  void cancel()
  {
    try
    {
      this.cancel = true;
      this.exportSession.status = AssetExportSession.AssetExportSessionStatus.AssetExportSessionStatusCancelled;
      if (this.reportSession != null)
      {
        this.reportSession.reset();
        this.reportSession = null;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        return true;
      } while (this.isFinishing);
      if (this.cancel)
      {
        this.isFinishing = true;
        finish();
      }
    } while ((!this.videoWriterDone) || (!this.audioWriterDone) || (!this.audioReadFinish) || (!this.videoReadFinish));
    this.isFinishing = true;
    finish();
    return true;
  }
  
  void setRenderContextParams(RenderContextParams paramRenderContextParams)
  {
    this.renderContextParams = paramRenderContextParams;
    if (this.assetWriter != null) {
      this.assetWriter.setRenderContextParams(paramRenderContextParams);
    }
  }
  
  void startExport()
  {
    start();
    this.cancel = false;
    if (this.reportSession != null) {
      this.reportSession.onExportStart(System.nanoTime());
    }
    this.exportHandler = new Handler(getLooper(), this);
    this.exportHandler.post(new AssetExportThread.2(this));
  }
  
  class AudioRequestMediaDataCallback
    implements Runnable
  {
    private AudioRequestMediaDataCallback() {}
    
    private void onAudioRequestMediaData()
    {
      while ((!AssetExportThread.this.audioWriterDone) && (!AssetExportThread.this.cancel)) {
        if ((AssetExportThread.this.audioReader != null) && (AssetExportThread.this.audioWriter.isReadyForMoreMediaData()))
        {
          AssetExportThread.this.audioReader.duration();
          localObject = AssetExportThread.this.audioReader.copyNextSampleBuffer();
          if (((CMSampleBuffer)localObject).getTime().getTimeUs() < 0L) {
            break label174;
          }
          ExportErrorStatus localExportErrorStatus = AssetExportThread.this.audioWriter.appendSampleBuffer((CMSampleBuffer)localObject);
          if (localExportErrorStatus != null) {
            AssetExportThread.this.exportError(localExportErrorStatus);
          }
          if (((CMSampleBuffer)localObject).getTime().getTimeUs() >= AssetExportThread.this.exportSession.timeRange.getDuration().getTimeUs()) {
            AssetExportThread.this.audioWriter.markAsFinished();
          }
        }
      }
      label138:
      Object localObject = AssetExportThread.this;
      if (!AssetExportThread.this.cancel) {}
      for (boolean bool = true;; bool = false)
      {
        AssetExportThread.access$2802((AssetExportThread)localObject, bool);
        AssetExportThread.this.exportHandler.sendEmptyMessage(2);
        return;
        label174:
        if (((CMSampleBuffer)localObject).getTime() == VideoDecoder.SAMPLE_TIME_FINISH)
        {
          AssetExportThread.this.audioWriter.markAsFinished();
          break label138;
        }
        if (((CMSampleBuffer)localObject).getTime() == VideoDecoder.SAMPLE_TIME_TIMEOUT) {
          break;
        }
        AssetExportThread.this.exportError((int)((CMSampleBuffer)localObject).getTime().getValue());
        break label138;
      }
    }
    
    public void run()
    {
      try
      {
        onAudioRequestMediaData();
        return;
      }
      catch (Throwable localThrowable)
      {
        Logger.e("AssetExportThread", "AudioRequestMediaDateCallback run: ", localThrowable);
        AssetExportThread.this.exportError(-15, localThrowable);
      }
    }
  }
  
  class AudioWriterProgressListener
    implements AssetWriterInput.WriterProgressListener
  {
    private AudioWriterProgressListener() {}
    
    public void onError(@NonNull ExportErrorStatus paramExportErrorStatus)
    {
      Logger.e("AssetExportThread", "AudioWriterProgressListener onError: ", paramExportErrorStatus.throwable);
      AssetExportThread.this.exportError(paramExportErrorStatus);
    }
    
    public void onProgressChanged(AssetWriterInput paramAssetWriterInput, long paramLong)
    {
      Logger.e("AssetExportSession", "onProgressChanged: audioWriter " + paramLong + "  / " + AssetExportThread.this.getDuration());
      if (paramLong == -1L)
      {
        AssetExportThread.access$2002(AssetExportThread.this, AssetExportThread.this.exportSession.timeRange.getDuration().getTimeUs());
        AssetExportThread.access$802(AssetExportThread.this, true);
        AssetExportThread.this.exportHandler.sendEmptyMessage(2);
      }
      do
      {
        return;
        AssetExportThread.access$2002(AssetExportThread.this, paramLong);
        paramLong = AssetExportThread.this.getDuration();
        if (paramLong != 0L) {
          AssetExportThread.this.exportSession.progress = ((float)(AssetExportThread.this.videoTime + AssetExportThread.this.audioTime) * 1.0F / (float)paramLong);
        }
        if (AssetExportThread.this.callbackHandler != null) {
          AssetExportThread.this.callbackHandler.handlerCallback(AssetExportThread.this.exportSession);
        }
      } while (((AssetExportThread.this.audioTime <= AssetExportThread.this.videoTime) || (!AssetExportThread.this.videoWriterDone)) && (AssetExportThread.this.audioTime < AssetExportThread.this.exportSession.timeRange.getDuration().getTimeUs()));
      AssetExportThread.access$2002(AssetExportThread.this, AssetExportThread.this.exportSession.timeRange.getDuration().getTimeUs());
      AssetExportThread.access$802(AssetExportThread.this, true);
      AssetExportThread.this.exportHandler.sendEmptyMessage(2);
    }
  }
  
  class VideoRequestMediaDataCallback
    implements Runnable
  {
    private VideoRequestMediaDataCallback() {}
    
    private void onRequestMediaData()
    {
      while ((!AssetExportThread.this.videoWriterDone) && (!AssetExportThread.this.cancel)) {
        if ((AssetExportThread.this.videoReader != null) && (AssetExportThread.this.videoWriter.isReadyForMoreMediaData()))
        {
          long l = System.nanoTime();
          localObject = AssetExportThread.this.videoReader.copyNextSampleBuffer();
          if (((CMSampleBuffer)localObject).getTime().getTimeUs() >= 0L)
          {
            localObject = AssetExportThread.this.videoWriter.appendSampleBuffer((CMSampleBuffer)localObject);
            if (localObject != null) {
              AssetExportThread.this.exportError((ExportErrorStatus)localObject);
            }
            if (AssetExportThread.this.reportSession != null) {
              AssetExportThread.this.reportSession.tickExport(System.nanoTime() - l);
            }
          }
          else
          {
            if (((CMSampleBuffer)localObject).getTime() != VideoDecoder.SAMPLE_TIME_FINISH) {
              break label241;
            }
            AssetExportThread.this.videoWriter.markAsFinished();
          }
        }
      }
      label149:
      if (AssetExportThread.this.videoWriter.matrixFilter != null) {
        AssetExportThread.this.videoWriter.matrixFilter.release();
      }
      if (AssetExportThread.this.exportSession.videoCompositing != null) {
        AssetExportThread.this.exportSession.videoCompositing.release();
      }
      Object localObject = AssetExportThread.this;
      if (!AssetExportThread.this.cancel) {}
      for (boolean bool = true;; bool = false)
      {
        AssetExportThread.access$2602((AssetExportThread)localObject, bool);
        AssetExportThread.this.exportHandler.sendEmptyMessage(1);
        return;
        label241:
        if (((CMSampleBuffer)localObject).getTime() == VideoDecoder.SAMPLE_TIME_TIMEOUT) {
          break;
        }
        AssetExportThread.this.exportError((int)((CMSampleBuffer)localObject).getTime().getValue());
        break label149;
      }
    }
    
    public void run()
    {
      try
      {
        onRequestMediaData();
        return;
      }
      catch (Throwable localThrowable)
      {
        Logger.e("AssetExportThread", "VideoRequestMediaDateCallback run: ", localThrowable);
        AssetExportThread.this.exportError(-14, localThrowable);
      }
    }
  }
  
  class VideoWriterProgressListener
    implements AssetWriterInput.WriterProgressListener
  {
    private VideoWriterProgressListener() {}
    
    public void onError(@NonNull ExportErrorStatus paramExportErrorStatus)
    {
      Logger.e("AssetExportThread", "VideoWriterProgressListener onError: ", paramExportErrorStatus.throwable);
      AssetExportThread.this.exportError(paramExportErrorStatus);
    }
    
    public void onProgressChanged(AssetWriterInput paramAssetWriterInput, long paramLong)
    {
      Logger.e("AssetExportSession", "onProgressChanged: videoWriter " + paramLong + "  / " + AssetExportThread.this.getDuration());
      if (paramLong == -1L)
      {
        AssetExportThread.access$1802(AssetExportThread.this, AssetExportThread.this.exportSession.timeRange.getDuration().getTimeUs());
        AssetExportThread.access$702(AssetExportThread.this, true);
        AssetExportThread.this.exportHandler.sendEmptyMessage(1);
      }
      do
      {
        return;
        AssetExportThread.access$1802(AssetExportThread.this, paramLong);
        paramLong = AssetExportThread.this.getDuration();
        if (paramLong != 0L) {
          AssetExportThread.this.exportSession.progress = ((float)(AssetExportThread.this.videoTime + AssetExportThread.this.audioTime) * 1.0F / (float)paramLong);
        }
      } while (AssetExportThread.this.callbackHandler == null);
      AssetExportThread.this.callbackHandler.handlerCallback(AssetExportThread.this.exportSession);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.tav.core.AssetExportThread
 * JD-Core Version:    0.7.0.1
 */