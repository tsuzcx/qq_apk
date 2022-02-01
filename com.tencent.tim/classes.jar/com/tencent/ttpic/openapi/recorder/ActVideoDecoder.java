package com.tencent.ttpic.openapi.recorder;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.graphics.SurfaceTexture;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.view.Surface;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.aekit.openrender.AEOpenRenderConfig;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.filter.SurfaceTextureFilter;
import com.tencent.ttpic.baseutils.fps.BenchUtil;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.view.RendererUtils;
import java.io.IOException;
import java.nio.ByteBuffer;

@TargetApi(18)
public class ActVideoDecoder
{
  private static final String TAG = ActVideoDecoder.class.getSimpleName();
  private static final int TIMEOUT_MS = 2500;
  private static final int TIMEOUT_US = 10000;
  private MediaCodec.BufferInfo info = new MediaCodec.BufferInfo();
  private ByteBuffer[] inputBuffers;
  private volatile boolean isDecoding;
  private boolean isEOS = false;
  private long mCurFrameIndex = -1L;
  private MediaCodec mDecoder;
  private Surface mDecoderSurface;
  private int mDstTex;
  private long mDuration;
  private MediaExtractor mExtractor;
  private String mFilename;
  private Frame mFrame = new Frame();
  private boolean mFrameAvailable;
  private Handler mHandler;
  private boolean mHasNewFrame;
  private int mHeight;
  private final Object mInitLock = new Object();
  private boolean mInited;
  private long mLastFrameIndex = -1L;
  private int mRotation;
  private SurfaceTextureFilter mSurfaceTexFilter = new SurfaceTextureFilter();
  private SurfaceTexture mSurfaceTexture;
  private int mTempTex;
  private final float[] mTransformMatrix = new float[16];
  private final Object mUpdateFrameLock = new Object();
  private int mWidth;
  
  public ActVideoDecoder(String arg1, int paramInt)
  {
    this.mFilename = ???;
    this.mDstTex = paramInt;
    this.mTempTex = RendererUtils.createTexture();
    this.mSurfaceTexFilter.apply();
    this.mSurfaceTexFilter.setRotationAndFlip(0, 0, 1);
    ??? = new HandlerThread(ActVideoDecoder.class.getSimpleName(), 10);
    ???.start();
    this.mHandler = new Handler(???.getLooper());
    this.mHandler.post(new ActVideoDecoder.1(this));
    synchronized (this.mInitLock)
    {
      for (;;)
      {
        boolean bool = this.mInited;
        if (!bool) {
          try
          {
            this.mInitLock.wait();
          }
          catch (InterruptedException localInterruptedException)
          {
            localInterruptedException.printStackTrace();
          }
        }
      }
    }
    this.mDecoderSurface = new Surface(this.mSurfaceTexture);
    this.mExtractor = new MediaExtractor();
    try
    {
      setExtractorDataSource(this.mExtractor, this.mFilename);
      prepare();
      return;
    }
    catch (IOException ???)
    {
      ???.printStackTrace();
    }
  }
  
  private int decodeNext()
  {
    int j = -1;
    int k = 0;
    int i;
    int m;
    if (this.mDecoder == null)
    {
      if (AEOpenRenderConfig.DEBUG) {
        throw new RuntimeException("ActVideoDecoder init fail!");
      }
    }
    else
    {
      i = 0;
      j = k;
      if (!Thread.interrupted())
      {
        BenchUtil.benchStart("[decodeNext] dequeueInputBuffer");
        if (!this.isEOS)
        {
          j = this.mDecoder.dequeueInputBuffer(10000L);
          if (j >= 0)
          {
            ByteBuffer localByteBuffer = this.inputBuffers[j];
            m = this.mExtractor.readSampleData(localByteBuffer, 0);
            if (m >= 0) {
              break label165;
            }
            LogUtils.d(TAG, "extractor read sample to EOS");
            this.mDecoder.queueInputBuffer(j, 0, 0, 0L, 4);
            this.isEOS = true;
          }
        }
        BenchUtil.benchEnd("[decodeNext] dequeueInputBuffer");
        BenchUtil.benchStart("[decodeNext] wait");
        j = this.mDecoder.dequeueOutputBuffer(this.info, 10000L);
        BenchUtil.benchEnd("[decodeNext] wait");
        if ((this.info.flags & 0x4) == 0) {
          break label195;
        }
      }
    }
    for (j = k;; j = k)
    {
      label163:
      return j;
      label165:
      this.mDecoder.queueInputBuffer(j, 0, m, this.mExtractor.getSampleTime(), 0);
      this.mExtractor.advance();
      break;
      switch (j)
      {
      default: 
        label195:
        this.mCurFrameIndex += 1L;
        if (this.mCurFrameIndex != this.mLastFrameIndex) {
          break label317;
        }
        this.mHasNewFrame = true;
        this.mDecoder.releaseOutputBuffer(j, true);
      }
    }
    for (;;)
    {
      break;
      continue;
      j = i + 1;
      i = j;
      if (j > 10)
      {
        LogUtils.e(TAG, "dequeueOutputBuffer timed out! eos = " + this.isEOS);
        j = -1;
        break label163;
        label317:
        this.mDecoder.releaseOutputBuffer(j, false);
      }
    }
  }
  
  private void prepare()
    throws IOException
  {
    int i = 0;
    for (;;)
    {
      if (i < this.mExtractor.getTrackCount())
      {
        MediaFormat localMediaFormat = this.mExtractor.getTrackFormat(i);
        String str = localMediaFormat.getString("mime");
        if (str.startsWith("video/"))
        {
          this.mExtractor.selectTrack(i);
          LogUtils.d(TAG, "extractor video track selected");
          this.mWidth = localMediaFormat.getInteger("width");
          this.mHeight = localMediaFormat.getInteger("height");
          if ((this.mRotation == 90) || (this.mRotation == 270))
          {
            i = this.mWidth;
            this.mWidth = this.mHeight;
            this.mHeight = i;
          }
          this.mDuration = (localMediaFormat.getLong("durationUs") / 1000L);
          LogUtils.d(TAG, "width = " + this.mWidth + ", height = " + this.mHeight + ", mDuration = " + this.mDuration);
          this.mDecoder = MediaCodec.createDecoderByType(str);
          localMediaFormat.setInteger("max-input-size", 0);
          this.mDecoder.configure(localMediaFormat, this.mDecoderSurface, null, 0);
        }
      }
      else
      {
        if (this.mDecoder != null) {
          break;
        }
        LogUtils.e(TAG, "Can't find video info!");
        return;
      }
      i += 1;
    }
    try
    {
      this.mDecoder.start();
      this.inputBuffers = this.mDecoder.getInputBuffers();
      this.isEOS = false;
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  private static void setExtractorDataSource(MediaExtractor paramMediaExtractor, String paramString)
    throws IOException
  {
    if (paramString.startsWith("assets://"))
    {
      paramString = paramString.substring("assets://".length());
      paramString = AEModule.getContext().getAssets().openFd(paramString);
      paramMediaExtractor.setDataSource(paramString.getFileDescriptor(), paramString.getStartOffset(), paramString.getLength());
      paramString.close();
      return;
    }
    paramMediaExtractor.setDataSource(paramString);
  }
  
  public void decodeFrame(long paramLong)
  {
    if (this.mDecoderSurface == null) {
      throw new RuntimeException("You haven't set surfaceTexture?!");
    }
    if (paramLong <= this.mLastFrameIndex) {
      return;
    }
    this.mLastFrameIndex = paramLong;
    try
    {
      BenchUtil.benchStart(TAG + "[decodeNext]");
      decodeNext();
      BenchUtil.benchEnd(TAG + "[decodeNext]");
      return;
    }
    catch (Exception localException)
    {
      LogUtils.e(TAG, "decodeNext error: ", localException, new Object[0]);
    }
  }
  
  public void decodeFrameAsync(long paramLong)
  {
    if (this.mDecoderSurface == null) {
      throw new RuntimeException("You haven't set surfaceTexture?!");
    }
    if ((this.isDecoding) || (paramLong <= this.mLastFrameIndex)) {
      return;
    }
    this.isDecoding = true;
    this.mLastFrameIndex = paramLong;
    this.mHandler.post(new ActVideoDecoder.2(this));
  }
  
  public long getDuration()
  {
    return this.mDuration;
  }
  
  public Frame getFrame()
  {
    return this.mFrame;
  }
  
  public int getHeight()
  {
    return this.mHeight;
  }
  
  public int getWidth()
  {
    return this.mWidth;
  }
  
  public boolean isLive()
  {
    return this.mDecoder != null;
  }
  
  public void release()
  {
    RendererUtils.clearTexture(this.mTempTex);
    this.mSurfaceTexFilter.clearGLSLSelf();
    this.mFrame.clear();
    if (this.mDecoderSurface != null) {
      this.mDecoderSurface.release();
    }
    if (this.mExtractor != null) {
      this.mExtractor.release();
    }
    if (this.mDecoder != null) {}
    try
    {
      this.mDecoder.stop();
      this.mDecoder.release();
      LogUtils.i(TAG, "mDecoder stop and release");
      this.mDecoder = null;
      if (this.mHandler != null)
      {
        this.mHandler.removeCallbacksAndMessages(null);
        this.mHandler.post(new ActVideoDecoder.4(this));
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        this.mDecoder = null;
      }
    }
  }
  
  public void reset()
  {
    try
    {
      if (this.mExtractor != null) {
        this.mExtractor.seekTo(0L, 0);
      }
      if (this.mDecoder != null) {
        this.mDecoder.flush();
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (!TextUtils.isEmpty(localException.getMessage())) {
          LogUtils.d(TAG, localException.getMessage());
        }
      }
    }
    this.isEOS = false;
    this.mCurFrameIndex = -1L;
    this.mLastFrameIndex = -1L;
  }
  
  public void resetAsync()
  {
    if (this.mHandler != null) {
      this.mHandler.post(new ActVideoDecoder.3(this));
    }
  }
  
  public void setRotation(int paramInt)
  {
    this.mRotation = paramInt;
    if ((paramInt == 90) || (paramInt == 270))
    {
      paramInt = this.mWidth;
      this.mWidth = this.mHeight;
      this.mHeight = paramInt;
    }
  }
  
  public boolean updateFrame()
  {
    boolean bool1 = this.mHasNewFrame;
    if (this.mHasNewFrame)
    {
      BenchUtil.benchStart(TAG + "[updateFrame] wait");
      synchronized (this.mUpdateFrameLock)
      {
        for (;;)
        {
          boolean bool2 = this.mFrameAvailable;
          if (!bool2) {
            try
            {
              this.mUpdateFrameLock.wait(2500L);
              if (!this.mFrameAvailable)
              {
                LogUtils.e(TAG, "frame wait timed out");
                return false;
              }
            }
            catch (InterruptedException localInterruptedException)
            {
              throw new RuntimeException(localInterruptedException);
            }
          }
        }
      }
      this.mFrameAvailable = false;
      BenchUtil.benchEnd(TAG + "[updateFrame] wait");
      BenchUtil.benchStart(TAG + "[updateFrame] render");
    }
    try
    {
      this.mSurfaceTexture.updateTexImage();
      label167:
      this.mSurfaceTexture.getTransformMatrix(this.mTransformMatrix);
      this.mSurfaceTexFilter.updateMatrix(this.mTransformMatrix);
      this.mSurfaceTexFilter.RenderProcess(this.mTempTex, getWidth(), getHeight(), this.mDstTex, 0.0D, this.mFrame);
      this.mHasNewFrame = false;
      BenchUtil.benchEnd(TAG + "[updateFrame] render");
      return bool1;
    }
    catch (Exception localException)
    {
      break label167;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.recorder.ActVideoDecoder
 * JD-Core Version:    0.7.0.1
 */