package com.tencent.mobileqq.richmedia.mediacodec.videodecoder;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.Surface;
import com.tencent.mobileqq.shortvideo.pkvideo.PKFilter;
import com.tencent.mobileqq.shortvideo.pkvideo.PKManager;
import com.tencent.mobileqq.shortvideo.util.VideoUtil;
import com.tencent.sveffects.Logger;
import com.tencent.sveffects.SLog;
import com.tencent.sveffects.SdkContext;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

@TargetApi(16)
public class HWVideoDecoder
{
  private static final int ACTION_PAUSE = 1;
  private static final int ACTION_PLAY = 0;
  private static final int ACTION_SEEK = 2;
  private static final int ACTION_SEEK_NEXT = 3;
  public static final int MAX_FRAME_SEEK_INTERVAL = 100000;
  private static final int MAX_SEEK_WAIT_TIME = 1000;
  private static final int MSG_PLAY = 1;
  private static final int MSG_SOME_THING = 2;
  public static final int SPEED_TYPE_FAST = 1;
  public static final int SPEED_TYPE_LITTLE_FAST = 3;
  public static final int SPEED_TYPE_REAL_TIME = 0;
  public static final int SPEED_TYPE_REVERSE = 5;
  public static final int SPEED_TYPE_SLOW = 2;
  public static final int SPEED_TYPE_VERY_SLOW = 4;
  private static final String TAG = "HWVideoDecoder";
  public static String debugDecodeFilePath = Environment.getExternalStorageDirectory() + "/Tencent/com/tencent/mobileqq/debugDecodeShortVideo";
  private DecodeRunnable currentDecodeRunnable;
  private Thread currentDecodeThread;
  private DecodeOutputSurface decodeOutputSurface;
  private Logger logger = SdkContext.getInstance().getLogger();
  private PKManager mPKManager;
  private PlayHandler mPlayHandler;
  private HandlerThread mPlayThread;
  private Object mSeekingFlag = new Object();
  
  private void assureThread()
  {
    if ((this.mPlayThread != null) && (this.mPlayThread.isAlive()) && (this.mPlayHandler != null))
    {
      this.logger.d("HWVideoDecoder", "playThread: already start");
      return;
    }
    this.mPlayThread = new HandlerThread("HWVideoDecoder_" + hashCode());
    this.mPlayThread.start();
    while (!this.mPlayThread.isAlive()) {}
    this.mPlayHandler = new PlayHandler(this.mPlayThread.getLooper());
  }
  
  public static final float getSpeedRate(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 1.0F;
    case 1: 
      return 2.0F;
    case 2: 
      return 0.5F;
    case 3: 
      return 1.5F;
    case 4: 
      return 0.25F;
    }
    return -1.0F;
  }
  
  private void sendMessage(int paramInt1, int paramInt2, Object paramObject)
  {
    PlayHandler localPlayHandler;
    if (this.mPlayHandler != null)
    {
      localPlayHandler = this.mPlayHandler;
      if (paramInt1 != 0) {
        break label34;
      }
    }
    label34:
    for (int i = 1;; i = 2)
    {
      localPlayHandler.obtainMessage(i, paramInt1, paramInt2, paramObject).sendToTarget();
      return;
    }
  }
  
  private void startDecode(DecodeConfig paramDecodeConfig, Surface paramSurface, HWDecodeListener paramHWDecodeListener)
  {
    if ((paramDecodeConfig == null) || (paramSurface == null)) {
      throw new IllegalArgumentException("both decodeConfig and surface should not be null");
    }
    this.logger.i("HWVideoDecoder", "startDecode config = " + paramDecodeConfig);
    Thread localThread;
    if (this.currentDecodeThread != null)
    {
      localThread = this.currentDecodeThread;
      stopDecode();
    }
    try
    {
      localThread.join();
      this.currentDecodeRunnable = new DecodeRunnable(paramDecodeConfig.inputFilePath, paramSurface, paramHWDecodeListener, this.mSeekingFlag);
      this.currentDecodeRunnable.setDecodeConfig(paramDecodeConfig);
      this.currentDecodeRunnable.setPKManager(this.mPKManager);
      this.currentDecodeThread = new Thread(this.currentDecodeRunnable, "HWVideoDecoder-Thread");
      this.currentDecodeThread.start();
      assureThread();
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        localInterruptedException.printStackTrace();
      }
    }
  }
  
  public void decodeFrame()
  {
    DecodeRunnable localDecodeRunnable = this.currentDecodeRunnable;
    if ((localDecodeRunnable != null) && (localDecodeRunnable.pauseFlag.get()))
    {
      sendMessage(0, 0, null);
      this.logger.d("HWVideoDecoder", "decodeFrame, " + localDecodeRunnable.pauseFlag.get());
      return;
    }
    this.logger.w("HWVideoDecoder", "decodeFrame failed, can not find DecodeRunnable");
  }
  
  public int getLastFrameSampleTimeMs()
  {
    DecodeRunnable localDecodeRunnable = this.currentDecodeRunnable;
    if (localDecodeRunnable != null) {
      return (int)localDecodeRunnable.getLastFrameSampleTimeMs();
    }
    return 0;
  }
  
  public long getProgress()
  {
    if (this.currentDecodeRunnable == null) {
      return 0L;
    }
    return this.currentDecodeRunnable.getProgress();
  }
  
  public void handlePlay()
  {
    DecodeRunnable localDecodeRunnable = this.currentDecodeRunnable;
    if (localDecodeRunnable != null) {}
    synchronized (localDecodeRunnable.pauseLock)
    {
      localDecodeRunnable.pauseLock.notifyAll();
      this.logger.d("HWVideoDecoder", "handlePlay");
      return;
    }
  }
  
  public void handleSeek(long paramLong)
  {
    DecodeRunnable localDecodeRunnable = this.currentDecodeRunnable;
    if (localDecodeRunnable != null) {}
    try
    {
      if (localDecodeRunnable.isSeeking()) {}
      synchronized (this.mSeekingFlag)
      {
        this.mSeekingFlag.wait(1000L);
        localDecodeRunnable.seekTo(paramLong);
        this.logger.d("HWVideoDecoder", "handleSeek " + paramLong + " ms");
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      this.logger.e("HWVideoDecoder", "handleSeek " + paramLong + " ms", localException);
    }
  }
  
  public void handleSeekNext(long paramLong)
  {
    DecodeRunnable localDecodeRunnable = this.currentDecodeRunnable;
    if (localDecodeRunnable != null) {}
    try
    {
      if (localDecodeRunnable.isSeeking()) {}
      synchronized (this.mSeekingFlag)
      {
        this.mSeekingFlag.wait(1000L);
        localDecodeRunnable.nextTo(paramLong);
        this.logger.d("HWVideoDecoder", "handleSeekNext " + paramLong + " ms");
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      this.logger.e("HWVideoDecoder", "handleSeekNext " + paramLong + " ms", localException);
    }
  }
  
  public void nextTo(long paramLong)
  {
    if ((this.currentDecodeRunnable != null) && (this.mPlayHandler != null))
    {
      this.mPlayHandler.removeMessages(2);
      sendMessage(3, (int)paramLong, null);
      this.logger.d("HWVideoDecoder", "nextTo " + paramLong + " ms");
      return;
    }
    this.logger.w("HWVideoDecoder", "nextTo " + paramLong + " ms failed, can not find DecodeRunnable");
  }
  
  public void pauseDecode()
  {
    DecodeRunnable localDecodeRunnable = this.currentDecodeRunnable;
    if (localDecodeRunnable != null)
    {
      localDecodeRunnable.pauseFlag.compareAndSet(false, true);
      sendMessage(1, 0, null);
      this.logger.d("HWVideoDecoder", "pauseDecode " + localDecodeRunnable.pauseFlag.get());
      return;
    }
    this.logger.w("HWVideoDecoder", "pauseDecode failed, can not find DecodeRunnable");
  }
  
  public void resumeDecode()
  {
    DecodeRunnable localDecodeRunnable = this.currentDecodeRunnable;
    if (localDecodeRunnable != null)
    {
      localDecodeRunnable.clearTimeStamp();
      localDecodeRunnable.pauseFlag.compareAndSet(true, false);
      sendMessage(0, 0, null);
      this.logger.d("HWVideoDecoder", "resumeDecode " + localDecodeRunnable.pauseFlag.get());
      return;
    }
    this.logger.w("HWVideoDecoder", "resumeDecode failed, can not find DecodeRunnable");
  }
  
  public void seekTo(int paramInt)
  {
    if ((this.currentDecodeRunnable != null) && (this.mPlayHandler != null))
    {
      this.mPlayHandler.removeMessages(2);
      sendMessage(2, paramInt, null);
      this.logger.d("HWVideoDecoder", "seekTo " + paramInt + " ms");
      return;
    }
    this.logger.w("HWVideoDecoder", "seekTo " + paramInt + " ms failed, can not find DecodeRunnable");
  }
  
  public void setPKManager(PKManager paramPKManager)
  {
    this.mPKManager = paramPKManager;
  }
  
  public void setPlayRange(long paramLong1, long paramLong2)
  {
    DecodeRunnable localDecodeRunnable = this.currentDecodeRunnable;
    if (localDecodeRunnable != null)
    {
      this.logger.d("HWVideoDecoder", "setPlayRange [" + paramLong1 + " ms, " + paramLong2 + " ms]");
      localDecodeRunnable.setPlayRange(paramLong1, paramLong2);
      return;
    }
    this.logger.w("HWVideoDecoder", "setPlayRange failed, can not find DecodeRunnable");
  }
  
  public void setProlongToTime(long paramLong)
  {
    DecodeRunnable localDecodeRunnable = this.currentDecodeRunnable;
    if (localDecodeRunnable != null) {
      localDecodeRunnable.setProlongToTime(paramLong);
    }
  }
  
  public void setSpeedType(int paramInt)
  {
    DecodeRunnable localDecodeRunnable = this.currentDecodeRunnable;
    if (localDecodeRunnable != null)
    {
      localDecodeRunnable.setSpeedType(paramInt);
      this.logger.d("HWVideoDecoder", "setSpeedType" + paramInt);
      return;
    }
    this.logger.w("HWVideoDecoder", "setSpeedType " + paramInt + " failed, can not find DecodeRunnable");
  }
  
  public void startDecode(DecodeConfig paramDecodeConfig, int paramInt, SurfaceTexture.OnFrameAvailableListener paramOnFrameAvailableListener, HWDecodeListener paramHWDecodeListener)
  {
    this.decodeOutputSurface = new DecodeOutputSurface(paramInt, paramOnFrameAvailableListener);
    startDecode(paramDecodeConfig, this.decodeOutputSurface.surface, paramHWDecodeListener);
  }
  
  public void stopDecode()
  {
    if ((this.mPlayThread != null) && (this.mPlayThread.isAlive()) && (this.mPlayHandler != null))
    {
      this.mPlayHandler.removeMessages(1);
      this.mPlayHandler.removeMessages(2);
      this.mPlayThread.quit();
    }
    if (this.currentDecodeThread != null) {
      this.currentDecodeThread.interrupt();
    }
    this.currentDecodeThread = null;
    this.currentDecodeRunnable = null;
  }
  
  static class DecodeRunnable
    implements Runnable
  {
    private static final String TAG = "HWVideoDecoder.DecodeRunnable";
    private ArrayList<HWVideoDecoder.timeStampPair> arrTimeStampPairs = new ArrayList();
    private final DecodeConfig currentDecodeConfig;
    private final HWDecodeListener decodeListener;
    long decodeProgressUs = 0L;
    private MediaCodec decoder;
    private final DecodeConfig dirtyDecodeConfig;
    private long endFrameSampleTime = 0L;
    private MediaExtractor extractor;
    private final String filePath;
    MediaCodec.BufferInfo info;
    ByteBuffer[] inputBuffers;
    private boolean inputDone = false;
    boolean interruptedFlag = false;
    public boolean isDebug = false;
    private long lastFramePresentationTimeUs = 0L;
    private long lastFrameSampleTimeUs = 0L;
    private Logger logger = SdkContext.getInstance().getLogger();
    private final AtomicLong mNextToTaskUs = new AtomicLong(-1L);
    private PKManager mPKManager;
    public int mRotation = 0;
    private long mSeekTarget = 0L;
    private String mTag = "HWVideoDecoder.DecodeRunnable";
    ByteBuffer[] outputBuffers;
    private boolean outputDone = false;
    private volatile AtomicBoolean pauseFlag = new AtomicBoolean(false);
    private final Object pauseLock = new Object();
    private int prolongFrameCount = 0;
    private final AtomicLong seekToTaskUs = new AtomicLong(-1L);
    private Object seekingFlag;
    long startMs = System.currentTimeMillis();
    private Surface surface;
    public final long videoDurationMs;
    
    public DecodeRunnable(String paramString, Surface paramSurface, HWDecodeListener paramHWDecodeListener, Object paramObject)
    {
      this.logger.i("HWVideoDecoder.DecodeRunnable", "create DecodeRunnable filePath: " + paramString);
      this.surface = paramSurface;
      if (paramHWDecodeListener != null) {}
      for (;;)
      {
        this.decodeListener = paramHWDecodeListener;
        this.filePath = paramString;
        this.videoDurationMs = VideoUtil.getDurationOfVideo(paramString);
        this.seekingFlag = paramObject;
        this.dirtyDecodeConfig = new DecodeConfig(paramString, 0, true, false, 0L, this.videoDurationMs);
        this.currentDecodeConfig = new DecodeConfig(paramString, 0, true, false, 0L, this.videoDurationMs);
        this.isDebug = new File(HWVideoDecoder.debugDecodeFilePath).exists();
        return;
        paramHWDecodeListener = new HWVideoDecoder.EmptyHWDecodeListener();
      }
    }
    
    private boolean dequeueDataFromCodec(boolean paramBoolean)
    {
      int i = this.decoder.dequeueOutputBuffer(this.info, 10000L);
      switch (i)
      {
      default: 
        if ((this.info.flags & 0x4) != 0)
        {
          if (this.logger.isEnable()) {
            this.logger.d(this.mTag, "output EOS " + this.pauseFlag.get());
          }
          this.outputDone = true;
          this.decodeProgressUs = 9223372036854775807L;
          if ((this.currentDecodeConfig.noSleep) || (!paramBoolean) || (this.pauseFlag.get()) || (this.mSeekTarget != -1L)) {
            break label365;
          }
        }
        break;
      case -3: 
        while (this.info.presentationTimeUs / 1000L > System.currentTimeMillis() - this.startMs)
        {
          try
          {
            Thread.sleep(10L);
          }
          catch (InterruptedException localInterruptedException1)
          {
            if (this.logger.isEnable()) {
              this.logger.e(this.mTag, "Thread.sleep error, ", localInterruptedException1);
            }
            this.interruptedFlag = true;
          }
          continue;
          if (this.logger.isEnable()) {
            this.logger.d(this.mTag, "INFO_OUTPUT_BUFFERS_CHANGED");
          }
          this.outputBuffers = this.decoder.getOutputBuffers();
        }
      }
      label365:
      do
      {
        for (;;)
        {
          return true;
          if (this.logger.isEnable())
          {
            this.logger.d(this.mTag, "New format " + this.decoder.getOutputFormat());
            continue;
            if (this.logger.isEnable()) {
              this.logger.d(this.mTag, "dequeueOutputBuffer timed out!");
            }
          }
        }
        this.decodeProgressUs = this.info.presentationTimeUs;
        break;
        if ((this.currentDecodeConfig.noSleep) && (this.currentDecodeConfig.syncDecode) && (this.mPKManager != null))
        {
          this.logger.d(PKFilter.TAG, "this is " + hashCode() + " current = " + this.info.presentationTimeUs / 1000L + ", sync decoder=" + this.mPKManager.getSyncDecodeTimeUs() / 1000L);
          while (this.info.presentationTimeUs > this.mPKManager.getSyncDecodeTimeUs()) {
            try
            {
              Thread.sleep(5L);
            }
            catch (InterruptedException localInterruptedException2)
            {
              if (this.logger.isEnable()) {
                this.logger.e(this.mTag, "Thread.sleep error, ", localInterruptedException2);
              }
              this.interruptedFlag = true;
            }
          }
        }
        if ((paramBoolean) && (this.info.size != 0)) {}
        for (paramBoolean = true;; paramBoolean = false)
        {
          if ((!this.pauseFlag.get()) || (isCloseSeekTarget(this.lastFrameSampleTimeUs, this.mSeekTarget)) || (this.outputDone)) {
            break label665;
          }
          if ((this.logger.isEnable()) && (this.isDebug)) {
            this.logger.d("HWVideoDecoder.DecodeRunnable", "seek, doRender = " + paramBoolean + " ; output sampleTime = " + this.info.presentationTimeUs);
          }
          this.decoder.releaseOutputBuffer(i, false);
          break;
        }
        if (this.mSeekTarget >= 0L) {
          this.startMs = (System.currentTimeMillis() - this.info.presentationTimeUs / 1000L);
        }
        seekFinishNotify();
        this.mSeekTarget = -1L;
        if ((this.logger.isEnable()) && (this.isDebug)) {
          this.logger.d("HWVideoDecoder.DecodeRunnable", "doRender = " + paramBoolean + " ; output sampleTime = " + this.info.presentationTimeUs);
        }
        this.decoder.releaseOutputBuffer(i, paramBoolean);
      } while (!paramBoolean);
      for (;;)
      {
        try
        {
          label665:
          if (this.currentDecodeConfig.speedType == 0) {
            break label1077;
          }
          if ((this.arrTimeStampPairs == null) || (this.arrTimeStampPairs.size() <= 0)) {
            break label1117;
          }
          l1 = ((HWVideoDecoder.timeStampPair)this.arrTimeStampPairs.get(0)).orgSampleTime;
          l2 = Math.abs(((HWVideoDecoder.timeStampPair)this.arrTimeStampPairs.get(0)).presentTime - this.info.presentationTimeUs);
          i = 0;
          if (i >= this.arrTimeStampPairs.size()) {
            break label1107;
          }
          HWVideoDecoder.timeStampPair localtimeStampPair = (HWVideoDecoder.timeStampPair)this.arrTimeStampPairs.get(i);
          if (localtimeStampPair.presentTime != this.info.presentationTimeUs) {
            break label1038;
          }
          l2 = localtimeStampPair.orgSampleTime;
          this.arrTimeStampPairs.remove(i);
          if ((!this.logger.isEnable()) || (!this.isDebug)) {
            break label1124;
          }
          this.logger.d(this.mTag, "size : " + this.arrTimeStampPairs.size() + "  remove " + l2);
        }
        catch (InterruptedException localInterruptedException3)
        {
          this.logger.e(this.mTag, "arrTimeStamp error, ", localInterruptedException3);
          this.interruptedFlag = true;
        }
        this.decodeListener.onDecodeFrame(this.info.presentationTimeUs * 1000L, 1000L * l1);
        break;
        break;
        label1038:
        long l3 = Math.abs(localInterruptedException3.presentTime - this.info.presentationTimeUs);
        if (l3 < l2)
        {
          l2 = localInterruptedException3.orgSampleTime;
          l1 = l3;
          break label1133;
          label1077:
          l1 = this.info.presentationTimeUs;
        }
        else
        {
          label1107:
          label1117:
          label1124:
          do
          {
            l1 = l2;
            break;
            l3 = l1;
            l1 = l2;
            l2 = l3;
            break label1133;
            i = 0;
            l2 = -1L;
            continue;
            l1 = -1L;
            break;
            i = 1;
          } while (i != 0);
          continue;
        }
        label1133:
        i += 1;
        l3 = l2;
        long l2 = l1;
        long l1 = l3;
      }
    }
    
    private long getEndFrameSampleTime()
    {
      this.extractor.seekTo((this.videoDurationMs - 1L) * 1000L, 2);
      long l = this.extractor.getSampleTime();
      SLog.d(PKFilter.TAG, "getEndFrameSampleTime and durationMS=" + this.videoDurationMs + " and result=" + l);
      this.extractor.seekTo(0L, 1);
      return l;
    }
    
    private long getPresentationTime(int paramInt, long paramLong1, long paramLong2)
    {
      switch (paramInt)
      {
      default: 
        return paramLong1 + paramLong2;
      case 1: 
        return paramLong2 / 2L + paramLong1;
      case 2: 
        return 2L * paramLong2 + paramLong1;
      case 3: 
        return (int)((float)paramLong2 / 1.5F) + paramLong1;
      case 4: 
        return 4L * paramLong2 + paramLong1;
      }
      return paramLong1 - paramLong2;
    }
    
    private boolean init()
    {
      this.extractor = new MediaExtractor();
      for (;;)
      {
        int i;
        try
        {
          this.extractor.setDataSource(this.filePath);
          i = 0;
          if (i >= this.extractor.getTrackCount()) {
            break label157;
          }
          MediaFormat localMediaFormat = this.extractor.getTrackFormat(i);
          localObject = localMediaFormat.getString("mime");
          if (!((String)localObject).startsWith("video/")) {
            break label198;
          }
          this.extractor.selectTrack(i);
          localMediaFormat.setInteger("rotation-degrees", this.mRotation);
          try
          {
            this.decoder = MediaCodec.createDecoderByType((String)localObject);
            if (this.surface.isValid()) {
              break label143;
            }
            throw new RuntimeException("surface is not valid.");
          }
          catch (Throwable localThrowable)
          {
            if (!Thread.interrupted()) {
              break label159;
            }
          }
          this.logger.e(this.mTag, "Thread is interrupted.", localThrowable);
          return false;
        }
        catch (IOException localIOException)
        {
          localIOException.printStackTrace();
          return false;
        }
        label143:
        this.decoder.configure(localIOException, this.surface, null, 0);
        label157:
        return true;
        label159:
        Object localObject = new RuntimeException(localIOException);
        this.decodeListener.onDecodeError(1, (Throwable)localObject);
        this.logger.e(this.mTag, "decode configure error", localIOException);
        return false;
        label198:
        i += 1;
      }
    }
    
    private boolean isCloseSeekTarget(long paramLong1, long paramLong2)
    {
      if (this.dirtyDecodeConfig.speedType != 5) {
        if (this.lastFrameSampleTimeUs < this.mSeekTarget) {
          break label37;
        }
      }
      label37:
      do
      {
        do
        {
          return true;
        } while (this.lastFrameSampleTimeUs <= this.mSeekTarget);
        paramLong1 = paramLong2 - paramLong1;
      } while ((paramLong1 > -100000L) && (paramLong1 < 100000L));
      return false;
    }
    
    private void loopInternal(boolean paramBoolean)
    {
      if (!this.inputDone) {
        queueSampleToCodec();
      }
      if (!this.outputDone) {
        dequeueDataFromCodec(paramBoolean);
      }
    }
    
    private boolean queueSampleToCodec()
    {
      int j = -1;
      try
      {
        i = this.decoder.dequeueInputBuffer(10000L);
        if (i >= 0)
        {
          ByteBuffer localByteBuffer = this.inputBuffers[i];
          if (this.currentDecodeConfig.speedType == 5) {
            this.extractor.seekTo(this.lastFrameSampleTimeUs - 1000L, 0);
          }
          j = this.extractor.readSampleData(localByteBuffer, 0);
          l3 = this.extractor.getSampleTime();
          l2 = 1000L * this.currentDecodeConfig.startTimeMillSecond;
          l4 = 1000L * this.currentDecodeConfig.endTimeMillSecond;
          if ((this.logger.isEnable()) && (this.isDebug)) {
            this.logger.d("HWVideoDecoder.DecodeRunnable", "intput sampleTime = " + l3);
          }
          if ((l3 == this.endFrameSampleTime) && (this.currentDecodeConfig.prolongToTime > 0L)) {
            if (this.prolongFrameCount * 33 * 1000 + l3 > (this.currentDecodeConfig.prolongToTime - 500L) * 1000L)
            {
              if ((this.logger.isEnable()) && (this.isDebug)) {
                this.logger.e(PKFilter.TAG, "prolongFrameCount=" + this.prolongFrameCount + " finish");
              }
              this.decoder.queueInputBuffer(i, 0, 0, 0L, 4);
              this.inputDone = true;
              this.prolongFrameCount = 0;
              return true;
            }
          }
        }
      }
      catch (IllegalStateException localIllegalStateException)
      {
        int i;
        for (;;)
        {
          long l3;
          long l2;
          long l4;
          i = j;
          if (this.logger.isEnable())
          {
            this.logger.e(this.mTag, "dequeueInputBuffer =" + localIllegalStateException.getMessage());
            i = j;
            continue;
            if ((this.logger.isEnable()) && (this.isDebug)) {
              this.logger.e(PKFilter.TAG, "prolongFrameCount=" + this.prolongFrameCount + " and we send the same frame to render");
            }
            this.prolongFrameCount += 1;
            long l1 = this.prolongFrameCount * 33 * 1000;
            this.decoder.queueInputBuffer(i, 0, j, l1 + l3, 0);
            continue;
            if ((j >= 0) && ((l4 <= 0L) || (l3 <= l4)))
            {
              if (this.currentDecodeConfig.speedType != 5) {
                break label600;
              }
              if (l2 <= 0L) {
                break label593;
              }
            }
            label593:
            for (l1 = l2;; l1 = 10000L)
            {
              if (l3 >= l1) {
                break label600;
              }
              if (this.logger.isEnable()) {
                this.logger.d(this.mTag, "InputBuffer BUFFER_FLAG_END_OF_STREAM sampleTime=" + l3 + " endTime=" + l4 + " startTime=" + l2 + " sampleSize=" + j);
              }
              this.decoder.queueInputBuffer(i, 0, 0, 0L, 4);
              this.inputDone = true;
              break;
            }
            label600:
            l1 = this.lastFrameSampleTimeUs;
            this.lastFrameSampleTimeUs = l3;
            this.lastFramePresentationTimeUs = getPresentationTime(this.currentDecodeConfig.speedType, this.lastFramePresentationTimeUs, l3 - l1);
            this.decoder.queueInputBuffer(i, 0, j, this.lastFramePresentationTimeUs, 0);
            this.extractor.advance();
            HWVideoDecoder.timeStampPair localtimeStampPair = new HWVideoDecoder.timeStampPair(this.lastFrameSampleTimeUs, this.lastFramePresentationTimeUs);
            if ((this.currentDecodeConfig.speedType != 0) && (this.arrTimeStampPairs != null))
            {
              this.arrTimeStampPairs.add(localtimeStampPair);
              if ((this.logger.isEnable()) && (this.isDebug)) {
                this.logger.d(this.mTag, "size : " + this.arrTimeStampPairs.size() + "  add " + this.lastFrameSampleTimeUs);
              }
            }
          }
        }
        if (this.logger.isEnable()) {
          this.logger.w(this.mTag, "queueSampleToCodec inIndex = " + i);
        }
      }
      return false;
    }
    
    private long seekInLoop(long paramLong)
    {
      long l5 = System.currentTimeMillis();
      long l2;
      long l3;
      try
      {
        this.decoder.flush();
        this.extractor.seekTo(paramLong, 0);
        long l4 = this.extractor.getSampleTime();
        l2 = l4;
        l3 = paramLong;
        if (l4 == -1L)
        {
          if (this.logger.isEnable()) {
            this.logger.d(this.mTag, "seekInLoop, getSampleTime return -1");
          }
          l2 = l4;
          l3 = paramLong;
          if (this.currentDecodeConfig.speedType == 5)
          {
            long l1 = paramLong;
            for (paramLong = l4;; paramLong = this.extractor.getSampleTime())
            {
              l2 = paramLong;
              l3 = l1;
              if (paramLong != -1L) {
                break;
              }
              l1 -= 1000L;
              this.extractor.seekTo(l1, 0);
            }
          }
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          this.logger.e("HWVideoDecoder.DecodeRunnable", localException);
        }
        this.decodeListener.onDecodeSeekTo(l2 / 1000L);
        this.startMs = System.currentTimeMillis();
        this.inputDone = false;
        this.outputDone = false;
        this.lastFrameSampleTimeUs = l2;
        if (this.currentDecodeConfig.speedType != 5) {}
      }
      for (this.lastFramePresentationTimeUs = (this.currentDecodeConfig.endTimeMillSecond * 1000L - l2);; this.lastFramePresentationTimeUs = l2)
      {
        if (this.logger.isEnable()) {
          this.logger.d(this.mTag, "end seekTo timecost=" + (System.currentTimeMillis() - l5) + " seekTargetTimeUs:" + l3 + " realStartTime:" + l2);
        }
        return l2;
      }
    }
    
    private boolean start()
    {
      if (this.decoder == null)
      {
        this.logger.e(this.mTag, "Can't find video info!");
        return false;
      }
      this.decodeListener.onDecodeStart();
      try
      {
        this.decoder.start();
        RuntimeException localRuntimeException;
        return false;
      }
      catch (Throwable localThrowable)
      {
        try
        {
          this.inputBuffers = this.decoder.getInputBuffers();
          this.outputBuffers = this.decoder.getOutputBuffers();
          this.info = new MediaCodec.BufferInfo();
          this.startMs = System.currentTimeMillis();
          if (this.currentDecodeConfig.speedType == 5) {
            this.lastFrameSampleTimeUs = (this.currentDecodeConfig.endTimeMillSecond * 1000L);
          }
          return true;
        }
        catch (Exception localException)
        {
          this.decodeListener.onDecodeError(2, localException);
          this.logger.e(this.mTag, "decode start error2", localException);
        }
        localThrowable = localThrowable;
        if (Thread.interrupted())
        {
          this.logger.e(this.mTag, "Thread is interrupted.", localThrowable);
          return false;
        }
        localRuntimeException = new RuntimeException(localThrowable);
        this.decodeListener.onDecodeError(2, localRuntimeException);
        this.logger.e(this.mTag, "decode start error", localThrowable);
        return false;
      }
    }
    
    public void clearTimeStamp()
    {
      if (this.arrTimeStampPairs != null) {
        this.arrTimeStampPairs.clear();
      }
    }
    
    public long getLastFrameSampleTimeMs()
    {
      return this.lastFrameSampleTimeUs / 1000L;
    }
    
    public long getProgress()
    {
      return this.decodeProgressUs;
    }
    
    public boolean isSeeking()
    {
      return this.mSeekTarget >= 0L;
    }
    
    public void nextTo(long paramLong)
    {
      this.mNextToTaskUs.set(1000L * paramLong);
    }
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: invokestatic 81	java/lang/System:currentTimeMillis	()J
      //   3: lstore_1
      //   4: aload_0
      //   5: getfield 189	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/HWVideoDecoder$DecodeRunnable:currentDecodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig;
      //   8: aload_0
      //   9: getfield 187	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/HWVideoDecoder$DecodeRunnable:dirtyDecodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig;
      //   12: invokevirtual 601	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig:copyFrom	(Lcom/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig;)V
      //   15: aload_0
      //   16: invokespecial 603	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/HWVideoDecoder$DecodeRunnable:init	()Z
      //   19: ifne +4 -> 23
      //   22: return
      //   23: aload_0
      //   24: getfield 189	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/HWVideoDecoder$DecodeRunnable:currentDecodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig;
      //   27: getfield 504	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig:prolongToTime	J
      //   30: lconst_0
      //   31: lcmp
      //   32: ifle +59 -> 91
      //   35: aload_0
      //   36: aload_0
      //   37: invokespecial 605	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/HWVideoDecoder$DecodeRunnable:getEndFrameSampleTime	()J
      //   40: putfield 91	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/HWVideoDecoder$DecodeRunnable:endFrameSampleTime	J
      //   43: aload_0
      //   44: getfield 156	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/HWVideoDecoder$DecodeRunnable:logger	Lcom/tencent/sveffects/Logger;
      //   47: invokeinterface 233 1 0
      //   52: ifeq +39 -> 91
      //   55: aload_0
      //   56: getfield 156	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/HWVideoDecoder$DecodeRunnable:logger	Lcom/tencent/sveffects/Logger;
      //   59: aload_0
      //   60: getfield 69	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/HWVideoDecoder$DecodeRunnable:mTag	Ljava/lang/String;
      //   63: new 126	java/lang/StringBuilder
      //   66: dup
      //   67: invokespecial 127	java/lang/StringBuilder:<init>	()V
      //   70: ldc_w 607
      //   73: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   76: aload_0
      //   77: getfield 91	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/HWVideoDecoder$DecodeRunnable:endFrameSampleTime	J
      //   80: invokevirtual 302	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   83: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   86: invokeinterface 244 3 0
      //   91: aload_0
      //   92: invokespecial 609	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/HWVideoDecoder$DecodeRunnable:start	()Z
      //   95: ifeq -73 -> 22
      //   98: aload_0
      //   99: getfield 156	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/HWVideoDecoder$DecodeRunnable:logger	Lcom/tencent/sveffects/Logger;
      //   102: invokeinterface 233 1 0
      //   107: ifeq +40 -> 147
      //   110: aload_0
      //   111: getfield 156	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/HWVideoDecoder$DecodeRunnable:logger	Lcom/tencent/sveffects/Logger;
      //   114: aload_0
      //   115: getfield 69	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/HWVideoDecoder$DecodeRunnable:mTag	Ljava/lang/String;
      //   118: new 126	java/lang/StringBuilder
      //   121: dup
      //   122: invokespecial 127	java/lang/StringBuilder:<init>	()V
      //   125: ldc_w 611
      //   128: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   131: invokestatic 81	java/lang/System:currentTimeMillis	()J
      //   134: lload_1
      //   135: lsub
      //   136: invokevirtual 302	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   139: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   142: invokeinterface 244 3 0
      //   147: invokestatic 453	java/lang/Thread:interrupted	()Z
      //   150: ifne +585 -> 735
      //   153: aload_0
      //   154: getfield 75	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/HWVideoDecoder$DecodeRunnable:interruptedFlag	Z
      //   157: ifne +578 -> 735
      //   160: aload_0
      //   161: getfield 187	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/HWVideoDecoder$DecodeRunnable:dirtyDecodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig;
      //   164: getfield 334	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig:speedType	I
      //   167: aload_0
      //   168: getfield 189	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/HWVideoDecoder$DecodeRunnable:currentDecodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig;
      //   171: getfield 334	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig:speedType	I
      //   174: if_icmpeq +29 -> 203
      //   177: aload_0
      //   178: getfield 187	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/HWVideoDecoder$DecodeRunnable:dirtyDecodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig;
      //   181: getfield 334	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig:speedType	I
      //   184: iconst_5
      //   185: if_icmpne +18 -> 203
      //   188: aload_0
      //   189: aload_0
      //   190: getfield 189	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/HWVideoDecoder$DecodeRunnable:currentDecodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig;
      //   193: getfield 499	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig:endTimeMillSecond	J
      //   196: ldc2_w 253
      //   199: lmul
      //   200: putfield 87	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/HWVideoDecoder$DecodeRunnable:lastFrameSampleTimeUs	J
      //   203: aload_0
      //   204: getfield 189	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/HWVideoDecoder$DecodeRunnable:currentDecodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig;
      //   207: aload_0
      //   208: getfield 187	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/HWVideoDecoder$DecodeRunnable:dirtyDecodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig;
      //   211: invokevirtual 601	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig:copyFrom	(Lcom/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig;)V
      //   214: aload_0
      //   215: getfield 189	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/HWVideoDecoder$DecodeRunnable:currentDecodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig;
      //   218: getfield 496	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig:startTimeMillSecond	J
      //   221: ldc2_w 253
      //   224: lmul
      //   225: lstore_1
      //   226: ldc2_w 253
      //   229: aload_0
      //   230: getfield 189	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/HWVideoDecoder$DecodeRunnable:currentDecodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig;
      //   233: getfield 499	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig:endTimeMillSecond	J
      //   236: lmul
      //   237: lstore_3
      //   238: iconst_0
      //   239: istore 8
      //   241: aload_0
      //   242: getfield 102	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/HWVideoDecoder$DecodeRunnable:seekToTaskUs	Ljava/util/concurrent/atomic/AtomicLong;
      //   245: invokevirtual 613	java/util/concurrent/atomic/AtomicLong:get	()J
      //   248: lstore 5
      //   250: iload 8
      //   252: istore 7
      //   254: lload 5
      //   256: lconst_0
      //   257: lcmp
      //   258: iflt +41 -> 299
      //   261: iload 8
      //   263: istore 7
      //   265: lload 5
      //   267: lload_1
      //   268: lcmp
      //   269: iflt +30 -> 299
      //   272: iload 8
      //   274: istore 7
      //   276: lload 5
      //   278: lload_3
      //   279: lcmp
      //   280: ifgt +19 -> 299
      //   283: aload_0
      //   284: lload 5
      //   286: invokespecial 615	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/HWVideoDecoder$DecodeRunnable:seekInLoop	(J)J
      //   289: pop2
      //   290: iconst_1
      //   291: istore 7
      //   293: aload_0
      //   294: lload 5
      //   296: putfield 122	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/HWVideoDecoder$DecodeRunnable:mSeekTarget	J
      //   299: aload_0
      //   300: getfield 102	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/HWVideoDecoder$DecodeRunnable:seekToTaskUs	Ljava/util/concurrent/atomic/AtomicLong;
      //   303: lload 5
      //   305: ldc2_w 96
      //   308: invokevirtual 618	java/util/concurrent/atomic/AtomicLong:compareAndSet	(JJ)Z
      //   311: pop
      //   312: aload_0
      //   313: getfield 104	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/HWVideoDecoder$DecodeRunnable:mNextToTaskUs	Ljava/util/concurrent/atomic/AtomicLong;
      //   316: invokevirtual 613	java/util/concurrent/atomic/AtomicLong:get	()J
      //   319: lstore 5
      //   321: lload 5
      //   323: lconst_0
      //   324: lcmp
      //   325: iflt +22 -> 347
      //   328: aload_0
      //   329: lload 5
      //   331: putfield 122	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/HWVideoDecoder$DecodeRunnable:mSeekTarget	J
      //   334: aload_0
      //   335: getfield 104	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/HWVideoDecoder$DecodeRunnable:mNextToTaskUs	Ljava/util/concurrent/atomic/AtomicLong;
      //   338: lload 5
      //   340: ldc2_w 96
      //   343: invokevirtual 618	java/util/concurrent/atomic/AtomicLong:compareAndSet	(JJ)Z
      //   346: pop
      //   347: aload_0
      //   348: iconst_1
      //   349: invokespecial 620	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/HWVideoDecoder$DecodeRunnable:loopInternal	(Z)V
      //   352: aload_0
      //   353: getfield 156	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/HWVideoDecoder$DecodeRunnable:logger	Lcom/tencent/sveffects/Logger;
      //   356: invokeinterface 233 1 0
      //   361: ifeq +44 -> 405
      //   364: aload_0
      //   365: getfield 124	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/HWVideoDecoder$DecodeRunnable:isDebug	Z
      //   368: ifeq +37 -> 405
      //   371: aload_0
      //   372: getfield 156	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/HWVideoDecoder$DecodeRunnable:logger	Lcom/tencent/sveffects/Logger;
      //   375: aload_0
      //   376: getfield 69	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/HWVideoDecoder$DecodeRunnable:mTag	Ljava/lang/String;
      //   379: new 126	java/lang/StringBuilder
      //   382: dup
      //   383: invokespecial 127	java/lang/StringBuilder:<init>	()V
      //   386: ldc_w 622
      //   389: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   392: iload 7
      //   394: invokevirtual 241	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
      //   397: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   400: invokeinterface 244 3 0
      //   405: aload_0
      //   406: getfield 73	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/HWVideoDecoder$DecodeRunnable:outputDone	Z
      //   409: ifeq +137 -> 546
      //   412: aload_0
      //   413: getfield 109	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/HWVideoDecoder$DecodeRunnable:arrTimeStampPairs	Ljava/util/ArrayList;
      //   416: ifnull +10 -> 426
      //   419: aload_0
      //   420: getfield 109	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/HWVideoDecoder$DecodeRunnable:arrTimeStampPairs	Ljava/util/ArrayList;
      //   423: invokevirtual 589	java/util/ArrayList:clear	()V
      //   426: aload_0
      //   427: getfield 156	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/HWVideoDecoder$DecodeRunnable:logger	Lcom/tencent/sveffects/Logger;
      //   430: invokeinterface 233 1 0
      //   435: ifeq +19 -> 454
      //   438: aload_0
      //   439: getfield 156	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/HWVideoDecoder$DecodeRunnable:logger	Lcom/tencent/sveffects/Logger;
      //   442: aload_0
      //   443: getfield 69	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/HWVideoDecoder$DecodeRunnable:mTag	Ljava/lang/String;
      //   446: ldc_w 624
      //   449: invokeinterface 244 3 0
      //   454: aload_0
      //   455: getfield 189	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/HWVideoDecoder$DecodeRunnable:currentDecodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig;
      //   458: getfield 627	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig:repeat	Z
      //   461: ifeq +274 -> 735
      //   464: aload_0
      //   465: getfield 189	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/HWVideoDecoder$DecodeRunnable:currentDecodeConfig	Lcom/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig;
      //   468: getfield 334	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/DecodeConfig:speedType	I
      //   471: iconst_5
      //   472: if_icmpne +252 -> 724
      //   475: lload_3
      //   476: lstore_1
      //   477: aload_0
      //   478: lload_1
      //   479: ldc2_w 253
      //   482: ldiv
      //   483: invokevirtual 629	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/HWVideoDecoder$DecodeRunnable:seekTo	(J)V
      //   486: aload_0
      //   487: getfield 168	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/HWVideoDecoder$DecodeRunnable:decodeListener	Lcom/tencent/mobileqq/richmedia/mediacodec/videodecoder/HWDecodeListener;
      //   490: invokeinterface 632 1 0
      //   495: aload_0
      //   496: getfield 156	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/HWVideoDecoder$DecodeRunnable:logger	Lcom/tencent/sveffects/Logger;
      //   499: invokeinterface 233 1 0
      //   504: ifeq +42 -> 546
      //   507: aload_0
      //   508: getfield 156	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/HWVideoDecoder$DecodeRunnable:logger	Lcom/tencent/sveffects/Logger;
      //   511: aload_0
      //   512: getfield 69	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/HWVideoDecoder$DecodeRunnable:mTag	Ljava/lang/String;
      //   515: new 126	java/lang/StringBuilder
      //   518: dup
      //   519: invokespecial 127	java/lang/StringBuilder:<init>	()V
      //   522: ldc_w 634
      //   525: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   528: aload_0
      //   529: getfield 118	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/HWVideoDecoder$DecodeRunnable:pauseFlag	Ljava/util/concurrent/atomic/AtomicBoolean;
      //   532: invokevirtual 238	java/util/concurrent/atomic/AtomicBoolean:get	()Z
      //   535: invokevirtual 241	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
      //   538: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   541: invokeinterface 244 3 0
      //   546: aload_0
      //   547: getfield 118	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/HWVideoDecoder$DecodeRunnable:pauseFlag	Ljava/util/concurrent/atomic/AtomicBoolean;
      //   550: invokevirtual 238	java/util/concurrent/atomic/AtomicBoolean:get	()Z
      //   553: ifeq -406 -> 147
      //   556: aload_0
      //   557: getfield 122	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/HWVideoDecoder$DecodeRunnable:mSeekTarget	J
      //   560: lconst_0
      //   561: lcmp
      //   562: ifge -415 -> 147
      //   565: aload_0
      //   566: getfield 102	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/HWVideoDecoder$DecodeRunnable:seekToTaskUs	Ljava/util/concurrent/atomic/AtomicLong;
      //   569: invokevirtual 613	java/util/concurrent/atomic/AtomicLong:get	()J
      //   572: lconst_0
      //   573: lcmp
      //   574: ifge -427 -> 147
      //   577: aload_0
      //   578: getfield 120	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/HWVideoDecoder$DecodeRunnable:pauseLock	Ljava/lang/Object;
      //   581: astore 9
      //   583: aload 9
      //   585: monitorenter
      //   586: aload_0
      //   587: getfield 75	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/HWVideoDecoder$DecodeRunnable:interruptedFlag	Z
      //   590: ifne +10 -> 600
      //   593: aload_0
      //   594: getfield 120	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/HWVideoDecoder$DecodeRunnable:pauseLock	Ljava/lang/Object;
      //   597: invokevirtual 637	java/lang/Object:wait	()V
      //   600: aload 9
      //   602: monitorexit
      //   603: aload_0
      //   604: invokestatic 81	java/lang/System:currentTimeMillis	()J
      //   607: aload_0
      //   608: getfield 217	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/HWVideoDecoder$DecodeRunnable:info	Landroid/media/MediaCodec$BufferInfo;
      //   611: getfield 252	android/media/MediaCodec$BufferInfo:presentationTimeUs	J
      //   614: ldc2_w 253
      //   617: ldiv
      //   618: lsub
      //   619: putfield 83	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/HWVideoDecoder$DecodeRunnable:startMs	J
      //   622: goto -475 -> 147
      //   625: astore 9
      //   627: aload_0
      //   628: getfield 156	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/HWVideoDecoder$DecodeRunnable:logger	Lcom/tencent/sveffects/Logger;
      //   631: aload_0
      //   632: getfield 69	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/HWVideoDecoder$DecodeRunnable:mTag	Ljava/lang/String;
      //   635: ldc_w 639
      //   638: aload 9
      //   640: invokeinterface 267 4 0
      //   645: aload_0
      //   646: iconst_1
      //   647: putfield 75	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/HWVideoDecoder$DecodeRunnable:interruptedFlag	Z
      //   650: goto -503 -> 147
      //   653: astore 9
      //   655: invokestatic 453	java/lang/Thread:interrupted	()Z
      //   658: ifeq +24 -> 682
      //   661: aload_0
      //   662: getfield 156	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/HWVideoDecoder$DecodeRunnable:logger	Lcom/tencent/sveffects/Logger;
      //   665: aload_0
      //   666: getfield 69	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/HWVideoDecoder$DecodeRunnable:mTag	Ljava/lang/String;
      //   669: ldc_w 455
      //   672: aload 9
      //   674: invokeinterface 267 4 0
      //   679: goto -327 -> 352
      //   682: new 447	java/lang/RuntimeException
      //   685: dup
      //   686: aload 9
      //   688: invokespecial 465	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
      //   691: astore 10
      //   693: aload_0
      //   694: getfield 168	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/HWVideoDecoder$DecodeRunnable:decodeListener	Lcom/tencent/mobileqq/richmedia/mediacodec/videodecoder/HWDecodeListener;
      //   697: iconst_3
      //   698: aload 10
      //   700: invokeinterface 469 3 0
      //   705: aload_0
      //   706: getfield 156	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/HWVideoDecoder$DecodeRunnable:logger	Lcom/tencent/sveffects/Logger;
      //   709: aload_0
      //   710: getfield 69	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/HWVideoDecoder$DecodeRunnable:mTag	Ljava/lang/String;
      //   713: ldc_w 471
      //   716: aload 9
      //   718: invokeinterface 267 4 0
      //   723: return
      //   724: goto -247 -> 477
      //   727: astore 10
      //   729: aload 9
      //   731: monitorexit
      //   732: aload 10
      //   734: athrow
      //   735: aload_0
      //   736: getfield 215	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/HWVideoDecoder$DecodeRunnable:decoder	Landroid/media/MediaCodec;
      //   739: invokevirtual 642	android/media/MediaCodec:stop	()V
      //   742: aload_0
      //   743: getfield 215	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/HWVideoDecoder$DecodeRunnable:decoder	Landroid/media/MediaCodec;
      //   746: invokevirtual 645	android/media/MediaCodec:release	()V
      //   749: aload_0
      //   750: getfield 371	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/HWVideoDecoder$DecodeRunnable:extractor	Landroid/media/MediaExtractor;
      //   753: invokevirtual 646	android/media/MediaExtractor:release	()V
      //   756: aload_0
      //   757: invokevirtual 329	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/HWVideoDecoder$DecodeRunnable:seekFinishNotify	()V
      //   760: aload_0
      //   761: getfield 73	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/HWVideoDecoder$DecodeRunnable:outputDone	Z
      //   764: ifeq +53 -> 817
      //   767: aload_0
      //   768: getfield 168	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/HWVideoDecoder$DecodeRunnable:decodeListener	Lcom/tencent/mobileqq/richmedia/mediacodec/videodecoder/HWDecodeListener;
      //   771: invokeinterface 649 1 0
      //   776: return
      //   777: astore 9
      //   779: aload_0
      //   780: getfield 156	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/HWVideoDecoder$DecodeRunnable:logger	Lcom/tencent/sveffects/Logger;
      //   783: ldc 13
      //   785: new 126	java/lang/StringBuilder
      //   788: dup
      //   789: invokespecial 127	java/lang/StringBuilder:<init>	()V
      //   792: ldc_w 651
      //   795: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   798: aload 9
      //   800: invokevirtual 652	java/lang/Exception:toString	()Ljava/lang/String;
      //   803: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   806: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   809: invokeinterface 512 3 0
      //   814: goto -58 -> 756
      //   817: aload_0
      //   818: getfield 168	com/tencent/mobileqq/richmedia/mediacodec/videodecoder/HWVideoDecoder$DecodeRunnable:decodeListener	Lcom/tencent/mobileqq/richmedia/mediacodec/videodecoder/HWDecodeListener;
      //   821: invokeinterface 655 1 0
      //   826: return
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	827	0	this	DecodeRunnable
      //   3	476	1	l1	long
      //   237	239	3	l2	long
      //   248	91	5	l3	long
      //   252	141	7	bool1	boolean
      //   239	34	8	bool2	boolean
      //   625	14	9	localInterruptedException	InterruptedException
      //   653	77	9	localThrowable	Throwable
      //   777	22	9	localException	Exception
      //   691	8	10	localRuntimeException	RuntimeException
      //   727	6	10	localObject2	Object
      // Exception table:
      //   from	to	target	type
      //   577	586	625	java/lang/InterruptedException
      //   603	622	625	java/lang/InterruptedException
      //   732	735	625	java/lang/InterruptedException
      //   347	352	653	java/lang/Throwable
      //   586	600	727	finally
      //   600	603	727	finally
      //   729	732	727	finally
      //   735	756	777	java/lang/Exception
    }
    
    public void seekFinishNotify()
    {
      if (this.mSeekTarget >= 0L) {
        synchronized (this.seekingFlag)
        {
          this.seekingFlag.notifyAll();
          return;
        }
      }
    }
    
    public void seekTo(long paramLong)
    {
      this.seekToTaskUs.set(1000L * paramLong);
    }
    
    public void setDecodeConfig(DecodeConfig paramDecodeConfig)
    {
      if (!TextUtils.equals(this.filePath, paramDecodeConfig.inputFilePath)) {
        this.logger.w("HWVideoDecoder.DecodeRunnable", "DecodeRunnable does not support changing the file");
      }
      setSpeedType(paramDecodeConfig.speedType);
      setPlayRange(paramDecodeConfig.startTimeMillSecond, paramDecodeConfig.endTimeMillSecond);
      setRepeat(paramDecodeConfig.repeat);
      setNoSleep(paramDecodeConfig.noSleep);
      setProlongToTime(paramDecodeConfig.prolongToTime);
      setSyncDecode(paramDecodeConfig.syncDecode);
      this.mRotation = paramDecodeConfig.rotation;
    }
    
    public void setNoSleep(boolean paramBoolean)
    {
      this.dirtyDecodeConfig.noSleep = paramBoolean;
    }
    
    public void setPKManager(PKManager paramPKManager)
    {
      this.mPKManager = paramPKManager;
    }
    
    public void setPlayRange(long paramLong1, long paramLong2)
    {
      if ((paramLong1 < 0L) || (paramLong2 < 0L)) {
        throw new IllegalArgumentException("both start time and end time should not less than 0");
      }
      if (paramLong2 < paramLong1) {
        throw new IllegalArgumentException("end time should not less than start time");
      }
      if (paramLong1 >= this.videoDurationMs)
      {
        this.logger.e("HWVideoDecoder.DecodeRunnable", "setPlayRange ignore, startTimeMs=" + paramLong1 + ", videoDuration=" + this.videoDurationMs);
        return;
      }
      if (paramLong2 > this.videoDurationMs) {
        paramLong2 = this.videoDurationMs;
      }
      for (;;)
      {
        long l = paramLong2;
        if (paramLong2 == 0L) {
          l = this.videoDurationMs;
        }
        if ((paramLong1 == this.dirtyDecodeConfig.startTimeMillSecond) && (l == this.dirtyDecodeConfig.endTimeMillSecond))
        {
          this.logger.w("HWVideoDecoder.DecodeRunnable", "segment not changed, setPlayRange ignore, startTimeMs=" + paramLong1 + ", endTimeMs=" + l);
          return;
        }
        this.dirtyDecodeConfig.startTimeMillSecond = paramLong1;
        this.dirtyDecodeConfig.endTimeMillSecond = l;
        if (this.dirtyDecodeConfig.speedType == 5)
        {
          seekTo(l);
          return;
        }
        seekTo(paramLong1);
        return;
      }
    }
    
    public void setProlongToTime(long paramLong)
    {
      this.dirtyDecodeConfig.prolongToTime = paramLong;
    }
    
    public void setRepeat(boolean paramBoolean)
    {
      this.dirtyDecodeConfig.repeat = paramBoolean;
    }
    
    public void setSpeedType(int paramInt)
    {
      this.dirtyDecodeConfig.speedType = paramInt;
    }
    
    public void setSyncDecode(boolean paramBoolean)
    {
      this.dirtyDecodeConfig.syncDecode = paramBoolean;
    }
  }
  
  public static class EmptyHWDecodeListener
    implements HWDecodeListener
  {
    public void onDecodeCancel() {}
    
    public void onDecodeError(int paramInt, Throwable paramThrowable) {}
    
    public void onDecodeFinish() {}
    
    public void onDecodeFrame(long paramLong1, long paramLong2)
      throws InterruptedException
    {}
    
    public void onDecodeRepeat() {}
    
    public void onDecodeSeekTo(long paramLong) {}
    
    public void onDecodeStart() {}
  }
  
  class PlayHandler
    extends Handler
  {
    public PlayHandler(Looper paramLooper)
    {
      super();
    }
    
    public void handleMessage(Message paramMessage)
    {
      switch (paramMessage.arg1)
      {
      case 1: 
      default: 
        return;
      case 0: 
        HWVideoDecoder.this.handlePlay();
        return;
      case 2: 
        HWVideoDecoder.this.handleSeek(paramMessage.arg2);
        return;
      }
      HWVideoDecoder.this.handleSeekNext(paramMessage.arg2);
    }
  }
  
  public static class timeStampPair
  {
    long orgSampleTime = 0L;
    long presentTime = 0L;
    
    timeStampPair(long paramLong1, long paramLong2)
    {
      this.orgSampleTime = paramLong1;
      this.presentTime = paramLong2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.mediacodec.videodecoder.HWVideoDecoder
 * JD-Core Version:    0.7.0.1
 */