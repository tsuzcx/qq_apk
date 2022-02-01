package com.tencent.thumbplayer.core.decoder;

import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodec.CodecException;
import android.media.MediaCodec.CryptoInfo;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.tencent.thumbplayer.core.common.TPCodecUtils;
import com.tencent.thumbplayer.core.common.TPNativeLog;
import com.tencent.tmediacodec.TMediaCodec;
import com.tencent.tmediacodec.TMediaCodec.Callback;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.ByteBuffer;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

@RequiresApi(api=16)
public abstract class TPBaseMediaCodecDecoder
  implements ITPMediaCodecDecoder
{
  private static final int DUMP_BYTE_BUFFER_BYTES = 100;
  private static final int DUMP_ONE_LINE_BYTES = 20;
  private static final int MEDIA_CODEC_ERROR_INDEX = -1000;
  private static long MEDIA_CODEC_INPUT_TIMEOUT_US = 2000L;
  private static long MEDIA_CODEC_OUTPUT_TIMEOUT_US = 2000L;
  private static final int MSG_FLUSH = 1002;
  private static final int MSG_RELEASE = 1003;
  private static final int MSG_RELEASE_OUTPUT_BUFFER = 1000;
  private static final int MSG_SET_OUTPUT_SURFACE = 1001;
  public static boolean forceRelease = false;
  private TMediaCodec mCodec = null;
  protected int mCodecId;
  private MediaCodec.CryptoInfo mCryptoInfo = null;
  private HandlerThread mDecodeThread = null;
  private AsyncDecodeHandler mDecoderHandler = null;
  protected int mDolbyVisionLevel = 0;
  protected int mDolbyVisionProfile = 0;
  protected int mDrmType = -1;
  protected boolean mEnableAsyncMode = false;
  private boolean mEnableAudioPassThrough = false;
  protected boolean mEnableMediaCodecReuse = false;
  private boolean mEnableSetOutputSurfaceApi = false;
  private TPFrameInfo mFrameInfo = new TPFrameInfo();
  private int mHandlerResult = 0;
  private BlockingQueue<Integer> mInputQueue = new LinkedBlockingQueue();
  protected MediaCrypto mMediaCrypto = null;
  private BlockingQueue<TPFrameInfo> mOutputQueue = new LinkedBlockingQueue();
  private boolean mRestartCodecOnException = false;
  private boolean mStarted = false;
  protected Surface mSurface = null;
  private final Object mThreadLock = new Object();
  
  public TPBaseMediaCodecDecoder(int paramInt)
  {
    this.mCodecId = paramInt;
  }
  
  private void bufferSizeCheck(ByteBuffer paramByteBuffer, byte[] paramArrayOfByte)
  {
    if (paramByteBuffer.remaining() < paramArrayOfByte.length) {
      TPNativeLog.printLog(4, getLogTag(), "decodeAsync, not enough space, byteBuffer.remaining:" + paramByteBuffer.remaining() + ", buffer size:" + paramArrayOfByte.length);
    }
    try
    {
      dumpByteArray(paramArrayOfByte, 0, 100, 20);
      return;
    }
    catch (Exception paramByteBuffer)
    {
      TPNativeLog.printLog(4, getLogTag(), paramByteBuffer.toString());
    }
  }
  
  @RequiresApi(api=21)
  private int decodeAsync(byte[] paramArrayOfByte, boolean paramBoolean1, long paramLong, boolean paramBoolean2)
  {
    Object localObject1 = (Integer)this.mInputQueue.poll();
    if (localObject1 == null) {
      return 1;
    }
    for (;;)
    {
      try
      {
        Object localObject2 = this.mCodec.getInputBuffer(((Integer)localObject1).intValue());
        if (localObject2 != null)
        {
          bufferSizeCheck((ByteBuffer)localObject2, paramArrayOfByte);
          ((ByteBuffer)localObject2).put(paramArrayOfByte);
        }
        int j;
        if ((paramBoolean2) && (this.mCryptoInfo != null))
        {
          paramArrayOfByte = this.mCodec;
          j = ((Integer)localObject1).intValue();
          localObject1 = this.mCryptoInfo;
          if (!paramBoolean1) {
            break label161;
          }
          i = 1;
          paramArrayOfByte.queueSecureInputBuffer(j, 0, (MediaCodec.CryptoInfo)localObject1, paramLong, i);
        }
        else
        {
          localObject2 = this.mCodec;
          j = ((Integer)localObject1).intValue();
          int k = paramArrayOfByte.length;
          if (paramBoolean1)
          {
            i = 1;
            ((TMediaCodec)localObject2).queueInputBuffer(j, 0, k, paramLong, i);
          }
        }
      }
      catch (Exception paramArrayOfByte)
      {
        return onMediaCodecException(paramArrayOfByte);
      }
      int i = 0;
      continue;
      return 0;
      label161:
      i = 0;
    }
  }
  
  private TPFrameInfo dequeueOutputBufferAsync()
  {
    this.mFrameInfo.errCode = 1;
    TPFrameInfo localTPFrameInfo2 = (TPFrameInfo)this.mOutputQueue.poll();
    TPFrameInfo localTPFrameInfo1 = localTPFrameInfo2;
    if (localTPFrameInfo2 == null) {
      localTPFrameInfo1 = this.mFrameInfo;
    }
    return localTPFrameInfo1;
  }
  
  private void dumpByteArray(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
    throws IllegalArgumentException
  {
    if ((paramArrayOfByte == null) || (paramInt1 < 0) || (paramInt2 <= 0) || (paramInt1 >= paramArrayOfByte.length) || (paramInt1 >= paramInt2) || (paramInt3 <= 0)) {
      throw new IllegalArgumentException();
    }
    int i = paramInt2;
    if (paramArrayOfByte.length <= paramInt2) {
      i = paramArrayOfByte.length;
    }
    int j = Math.min(i - paramInt1, 100);
    StringBuilder localStringBuilder = new StringBuilder();
    TPNativeLog.printLog(2, getLogTag(), "dumpByteArray begin:");
    i = 0;
    paramInt2 = paramInt1;
    if (paramInt2 < j + paramInt1)
    {
      String str2 = Integer.toHexString(paramArrayOfByte[paramInt2] & 0xFF);
      String str1 = str2;
      if (str2.length() == 1) {
        str1 = '0' + str2;
      }
      localStringBuilder.append(str1.toUpperCase());
      i += 1;
      if (i % paramInt3 == 0)
      {
        TPNativeLog.printLog(2, getLogTag(), localStringBuilder.toString());
        localStringBuilder.setLength(0);
      }
      for (;;)
      {
        paramInt2 += 1;
        break;
        localStringBuilder.append(" ");
      }
    }
    TPNativeLog.printLog(2, getLogTag(), "dumpByteArray end.");
  }
  
  private void exitDecodeThread()
  {
    if (this.mDecodeThread != null)
    {
      if (Build.VERSION.SDK_INT < 18) {
        break label31;
      }
      this.mDecodeThread.quitSafely();
    }
    for (;;)
    {
      try
      {
        this.mDecodeThread.join();
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        label31:
        localInterruptedException.printStackTrace();
      }
      this.mDecodeThread.quit();
    }
  }
  
  private int flushAsync()
  {
    TPNativeLog.printLog(2, getLogTag(), "flushAsync: ");
    Message localMessage = this.mDecoderHandler.obtainMessage();
    localMessage.what = 1002;
    return waitingForHandleMessage(localMessage);
  }
  
  private int forceHandleRelease()
  {
    if (this.mCodec == null) {
      return 101;
    }
    this.mStarted = false;
    try
    {
      this.mCodec.stop();
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        try
        {
          this.mCodec.release();
          return 0;
        }
        catch (Exception localException2)
        {
          TPNativeLog.printLog(4, getLogTag(), "release: failed!" + getStackTrace(localException2));
          return 3;
        }
        finally
        {
          this.mCodec = null;
        }
        localException1 = localException1;
        TPNativeLog.printLog(4, getLogTag(), "stop: failed!" + getStackTrace(localException1));
      }
    }
  }
  
  private int handleFlush()
  {
    TPNativeLog.printLog(2, getLogTag(), "handleFlush: ");
    if (this.mCodec == null) {
      return 104;
    }
    try
    {
      this.mCodec.flush();
      return 0;
    }
    catch (Exception localException)
    {
      return onMediaCodecException(localException);
    }
  }
  
  private void handleMessageComplete(int paramInt)
  {
    this.mHandlerResult = paramInt;
    this.mThreadLock.notify();
  }
  
  private int handleRelease()
  {
    TPNativeLog.printLog(4, getLogTag(), "handleRelease:" + forceRelease);
    if (forceRelease) {
      return forceHandleRelease();
    }
    return originHandleRelease();
  }
  
  private int handleReleaseOutputBuffer(int paramInt, boolean paramBoolean)
  {
    if ((this.mCodec == null) || (paramInt < 0)) {
      return 3;
    }
    try
    {
      this.mCodec.releaseOutputBuffer(paramInt, paramBoolean);
      return 0;
    }
    catch (Exception localException)
    {
      return onMediaCodecException(localException);
    }
  }
  
  private int handleSetOutputSurface(Surface paramSurface)
  {
    TPNativeLog.printLog(2, getLogTag(), "setOutputSurface: " + paramSurface);
    if (this.mSurface == paramSurface) {
      TPNativeLog.printLog(3, getLogTag(), "setOutputSurface: set the same surface.");
    }
    Surface localSurface;
    do
    {
      return 0;
      localSurface = this.mSurface;
      this.mSurface = paramSurface;
    } while (this.mCodec == null);
    if ((localSurface != null) && (paramSurface != null)) {
      try
      {
        if ((paramSurface.isValid()) && (Build.VERSION.SDK_INT >= 23) && (this.mEnableSetOutputSurfaceApi))
        {
          this.mCodec.setOutputSurface(paramSurface);
          return 0;
        }
      }
      catch (Exception paramSurface)
      {
        TPNativeLog.printLog(4, getLogTag(), "setOutputSurface onMediaCodecException:\n" + getStackTrace(paramSurface));
        return 3;
      }
    }
    return 3;
  }
  
  private int handleSignalEndOfStream(int paramInt)
  {
    try
    {
      this.mCodec.queueInputBuffer(paramInt, 0, 0, 0L, 4);
      return 0;
    }
    catch (Exception localException)
    {
      TPNativeLog.printLog(4, getLogTag(), "handleSignalEndOfStream: failed!" + getStackTrace(localException));
    }
    return 3;
  }
  
  private boolean initMediaCodecInternal()
  {
    for (;;)
    {
      try
      {
        if (getMimeType().equals("audio/vnd.dts"))
        {
          TPNativeLog.printLog(2, getLogTag(), "initMediaCodec current mime type:" + getMimeType() + " is audio dts, need set input timeout to 0!");
          MEDIA_CODEC_INPUT_TIMEOUT_US = 0L;
          MEDIA_CODEC_OUTPUT_TIMEOUT_US = 0L;
        }
        TPNativeLog.printLog(2, getLogTag(), "initMediaCodec mime:" + getMimeType() + " profile:" + this.mDolbyVisionProfile + " level:" + this.mDolbyVisionLevel + " mDrmType:" + this.mDrmType);
        if (this.mMediaCrypto != null)
        {
          bool1 = this.mMediaCrypto.requiresSecureDecoderComponent(getMimeType());
          if ((bool1) && (TPCodecUtils.isInDRMLevel1Blacklist(this.mDrmType)))
          {
            TPNativeLog.printLog(2, getLogTag(), "Device " + Build.MODEL + " DrmType " + this.mDrmType + " fallback to L3.");
            bool1 = false;
            String str;
            if (this.mDolbyVisionProfile > 0)
            {
              str = TPCodecUtils.getDolbyVisionDecoderName(getMimeType(), this.mDolbyVisionProfile, this.mDolbyVisionLevel, bool1);
              TPNativeLog.printLog(2, getLogTag(), "initMediaCodec codecName:" + str + " secureComponent " + bool1);
              if (str == null)
              {
                TPNativeLog.printLog(4, getLogTag(), "initMediaCodec failed, codecName is null.");
                return false;
              }
            }
            else
            {
              str = TPCodecUtils.getDecoderName(getMimeType(), bool1);
              continue;
            }
            this.mCodec = TMediaCodec.createByCodecName(str);
            Object localObject = this.mCodec;
            if ((this.mEnableMediaCodecReuse) && (!this.mEnableAsyncMode))
            {
              bool2 = true;
              ((TMediaCodec)localObject).setReuseEnable(bool2);
              this.mCodec.setCodecCallback(new TPBaseMediaCodecDecoder.1(this));
              TPNativeLog.printLog(2, getLogTag(), "initMediaCodec codec name: " + str);
              if ((this.mEnableAsyncMode) && (Build.VERSION.SDK_INT >= 23))
              {
                TPNativeLog.printLog(2, getLogTag(), "MediaCodec EnableAsyncMode！");
                this.mDecodeThread = new HandlerThread("MediaCodecThread");
                this.mDecodeThread.start();
                this.mDecoderHandler = new AsyncDecodeHandler(this.mDecodeThread.getLooper());
                this.mCodec.setCallback(new BufferCallback(null), this.mDecoderHandler);
              }
              configCodec(this.mCodec);
              this.mCodec.start();
              this.mStarted = true;
              if (this.mDrmType != -1)
              {
                if (TPCodecUtils.getDecoderName(getMimeType(), true) != null)
                {
                  bool2 = true;
                  localObject = new TPMediaDrmInfo();
                  ((TPMediaDrmInfo)localObject).supportSecureDecoder = bool2;
                  ((TPMediaDrmInfo)localObject).supportSecureDecrypt = bool1;
                  ((TPMediaDrmInfo)localObject).componentName = str;
                  ((TPMediaDrmInfo)localObject).drmType = this.mDrmType;
                  TPNativeLog.printLog(2, getLogTag(), "DRM Info: supportSecureDecoder: " + ((TPMediaDrmInfo)localObject).supportSecureDecoder + " supportSecureDecrypt:" + ((TPMediaDrmInfo)localObject).supportSecureDecrypt + " componentName: " + ((TPMediaDrmInfo)localObject).componentName + " drmType: " + ((TPMediaDrmInfo)localObject).drmType);
                  TPMediaCodecManager.onMediaDrmInfo(this.mCodecId, localObject);
                }
              }
              else {
                return true;
              }
            }
            else
            {
              bool2 = false;
              continue;
            }
            boolean bool2 = false;
            continue;
          }
          continue;
        }
      }
      catch (Exception localException)
      {
        TPNativeLog.printLog(4, getLogTag(), getStackTrace(localException));
        return false;
      }
      boolean bool1 = false;
    }
  }
  
  private int onFlush()
  {
    this.mInputQueue.clear();
    this.mOutputQueue.clear();
    int i = handleFlush();
    this.mCodec.start();
    return i;
  }
  
  private int onMediaCodecException(Exception paramException)
  {
    TPNativeLog.printLog(4, getLogTag(), "onMediaCodecException!\n" + getStackTrace(paramException));
    resetFrameInfo();
    processMediaCodecException(paramException);
    if (this.mRestartCodecOnException)
    {
      initMediaCodecInternal();
      return 4;
    }
    handleRelease();
    return 103;
  }
  
  private int onRelease()
  {
    this.mInputQueue.clear();
    this.mOutputQueue.clear();
    return handleRelease();
  }
  
  private int onReleaseOutputBuffer(int paramInt, boolean paramBoolean)
  {
    return handleReleaseOutputBuffer(paramInt, paramBoolean);
  }
  
  private int onSetOutputSurface(Surface paramSurface)
  {
    return handleSetOutputSurface(paramSurface);
  }
  
  private int originHandleRelease()
  {
    if (this.mCodec == null) {
      return 101;
    }
    this.mStarted = false;
    try
    {
      this.mCodec.stop();
      this.mCodec.release();
      return 0;
    }
    catch (Exception localException)
    {
      TPNativeLog.printLog(4, getLogTag(), "release: failed!" + getStackTrace(localException));
      return 3;
    }
    finally
    {
      this.mCodec = null;
    }
  }
  
  private int queueInputBuffer(byte[] paramArrayOfByte, long paramLong, boolean paramBoolean)
  {
    int i = 103;
    int j;
    try
    {
      Object localObject = this.mCodec.getInputBuffers();
      j = this.mCodec.dequeueInputBuffer(MEDIA_CODEC_INPUT_TIMEOUT_US);
      if (j >= 0)
      {
        localObject = localObject[j];
        bufferSizeCheck((ByteBuffer)localObject, paramArrayOfByte);
        ((ByteBuffer)localObject).put(paramArrayOfByte);
        if ((paramBoolean) && (this.mCryptoInfo != null)) {
          this.mCodec.queueSecureInputBuffer(j, 0, this.mCryptoInfo, paramLong, 0);
        } else {
          this.mCodec.queueInputBuffer(j, 0, paramArrayOfByte.length, paramLong, 0);
        }
      }
    }
    catch (Exception paramArrayOfByte)
    {
      return onMediaCodecException(paramArrayOfByte);
    }
    if (j == -1)
    {
      return 1;
      i = 0;
    }
    return i;
  }
  
  private int releaseAsync()
  {
    TPNativeLog.printLog(2, getLogTag(), "releaseAsync: ");
    Message localMessage = this.mDecoderHandler.obtainMessage();
    localMessage.what = 1003;
    int i = waitingForHandleMessage(localMessage);
    exitDecodeThread();
    return i;
  }
  
  private int releaseOutputBufferAsync(int paramInt, boolean paramBoolean)
  {
    Message localMessage = this.mDecoderHandler.obtainMessage();
    localMessage.what = 1000;
    localMessage.arg1 = paramInt;
    if (paramBoolean) {}
    for (paramInt = 1;; paramInt = 0)
    {
      localMessage.arg2 = paramInt;
      return waitingForHandleMessage(localMessage);
    }
  }
  
  private void resetFrameInfo()
  {
    this.mFrameInfo.bufferIndex = -1000;
    this.mFrameInfo.ptsUs = -1L;
    this.mFrameInfo.data = null;
    this.mFrameInfo.errCode = 103;
  }
  
  private MediaCodecInfo selectCodec(String paramString)
  {
    int k = MediaCodecList.getCodecCount();
    int i = 0;
    if (i < k)
    {
      MediaCodecInfo localMediaCodecInfo = MediaCodecList.getCodecInfoAt(i);
      if (localMediaCodecInfo.isEncoder()) {}
      for (;;)
      {
        i += 1;
        break;
        String[] arrayOfString = localMediaCodecInfo.getSupportedTypes();
        int m = arrayOfString.length;
        int j = 0;
        while (j < m)
        {
          if (arrayOfString[j].equalsIgnoreCase(paramString)) {
            return localMediaCodecInfo;
          }
          j += 1;
        }
      }
    }
    return null;
  }
  
  private int setOutputSurfaceAsync(Surface paramSurface)
  {
    TPNativeLog.printLog(2, getLogTag(), "setOutputSurfaceAsync: " + paramSurface);
    Message localMessage = this.mDecoderHandler.obtainMessage();
    localMessage.what = 1001;
    localMessage.obj = paramSurface;
    return waitingForHandleMessage(localMessage);
  }
  
  private int signalEndOfStreamAsync()
  {
    Integer localInteger = (Integer)this.mInputQueue.poll();
    if (localInteger == null) {
      return 1;
    }
    return handleSignalEndOfStream(localInteger.intValue());
  }
  
  private int waitingForHandleMessage(Message paramMessage)
  {
    synchronized (this.mThreadLock)
    {
      paramMessage.sendToTarget();
      try
      {
        this.mThreadLock.wait();
        return this.mHandlerResult;
      }
      catch (InterruptedException paramMessage)
      {
        for (;;)
        {
          paramMessage.printStackTrace();
        }
      }
    }
  }
  
  abstract void configCodec(@NonNull TMediaCodec paramTMediaCodec);
  
  public int decode(byte[] paramArrayOfByte, boolean paramBoolean1, long paramLong, boolean paramBoolean2)
  {
    if ((!this.mStarted) || (this.mCodec == null)) {
      return 101;
    }
    if ((this.mEnableAsyncMode) && (Build.VERSION.SDK_INT >= 23)) {
      return decodeAsync(paramArrayOfByte, paramBoolean1, paramLong, paramBoolean2);
    }
    return queueInputBuffer(paramArrayOfByte, paramLong, paramBoolean2);
  }
  
  public TPFrameInfo dequeueOutputBuffer()
  {
    if (this.mCodec == null) {
      return this.mFrameInfo;
    }
    resetFrameInfo();
    if (this.mEnableAsyncMode) {
      return dequeueOutputBufferAsync();
    }
    MediaCodec.BufferInfo localBufferInfo = new MediaCodec.BufferInfo();
    for (;;)
    {
      int i;
      try
      {
        i = this.mCodec.dequeueOutputBuffer(localBufferInfo, MEDIA_CODEC_OUTPUT_TIMEOUT_US);
        if (i < 0) {
          break label208;
        }
        if (localBufferInfo.flags == 4)
        {
          TPNativeLog.printLog(2, getLogTag(), "dequeueOutputBuffer: BUFFER_FLAG_END_OF_STREAM");
          this.mFrameInfo.errCode = 2;
          return this.mFrameInfo;
        }
      }
      catch (Exception localException)
      {
        this.mFrameInfo.errCode = onMediaCodecException(localException);
        return this.mFrameInfo;
      }
      if ((localException.flags == 2) && (this.mEnableAudioPassThrough))
      {
        TPNativeLog.printLog(2, getLogTag(), "dequeueOutputBuffer: BUFFER_FLAG_CODEC_CONFIG, AudioPassThrough");
        this.mFrameInfo.bufferIndex = i;
        this.mFrameInfo.ptsUs = localException.presentationTimeUs;
        processOutputConfigData(this.mCodec, i, localException, this.mFrameInfo);
      }
      else
      {
        this.mFrameInfo.bufferIndex = i;
        this.mFrameInfo.ptsUs = localException.presentationTimeUs;
        this.mFrameInfo.errCode = 0;
        processOutputBuffer(this.mCodec, i, localException, this.mFrameInfo);
        continue;
        label208:
        if (i == -2)
        {
          processOutputFormatChanged(this.mCodec.getOutputFormat());
          this.mFrameInfo.errCode = 1;
        }
        else if (i == -1)
        {
          this.mFrameInfo.errCode = 1;
        }
        else if (i == -3)
        {
          TPNativeLog.printLog(2, getLogTag(), "dequeueOutputBuffer: INFO_OUTPUT_BUFFERS_CHANGED!");
          this.mFrameInfo.errCode = 1;
        }
        else if (localException.flags == 4)
        {
          TPNativeLog.printLog(2, getLogTag(), "dequeueOutputBuffer: BUFFER_FLAG_END_OF_STREAM!");
          this.mFrameInfo.errCode = 2;
        }
        else
        {
          TPNativeLog.printLog(4, getLogTag(), "dequeueOutputBuffer: TP_ERROR_DECODE_FAILED! index = " + i);
          this.mFrameInfo.errCode = 103;
        }
      }
    }
  }
  
  public int flush()
  {
    TPNativeLog.printLog(2, getLogTag(), "flush: ");
    if (this.mCodec == null) {
      return 104;
    }
    if (this.mEnableAsyncMode) {
      return flushAsync();
    }
    return handleFlush();
  }
  
  abstract String getLogTag();
  
  abstract String getMimeType();
  
  protected String getStackTrace(Throwable paramThrowable)
  {
    StringWriter localStringWriter = new StringWriter();
    paramThrowable.printStackTrace(new PrintWriter(localStringWriter));
    return localStringWriter.toString();
  }
  
  abstract void processMediaCodecException(Exception paramException);
  
  abstract void processOutputBuffer(@NonNull TMediaCodec paramTMediaCodec, int paramInt, @NonNull MediaCodec.BufferInfo paramBufferInfo, @NonNull TPFrameInfo paramTPFrameInfo);
  
  abstract void processOutputConfigData(@NonNull TMediaCodec paramTMediaCodec, int paramInt, @NonNull MediaCodec.BufferInfo paramBufferInfo, @NonNull TPFrameInfo paramTPFrameInfo);
  
  abstract void processOutputFormatChanged(@NonNull MediaFormat paramMediaFormat);
  
  public int release()
  {
    if (this.mEnableAsyncMode) {
      return releaseAsync();
    }
    return handleRelease();
  }
  
  public int releaseOutputBuffer(int paramInt, boolean paramBoolean)
  {
    if ((this.mCodec == null) || (paramInt < 0)) {
      return 3;
    }
    if (this.mEnableAsyncMode) {
      return releaseOutputBufferAsync(paramInt, paramBoolean);
    }
    return handleReleaseOutputBuffer(paramInt, paramBoolean);
  }
  
  public void setCryptoInfo(int paramInt1, @NonNull int[] paramArrayOfInt1, @NonNull int[] paramArrayOfInt2, @NonNull byte[] paramArrayOfByte1, @NonNull byte[] paramArrayOfByte2, int paramInt2)
  {
    if (this.mCryptoInfo == null) {
      this.mCryptoInfo = new MediaCodec.CryptoInfo();
    }
    this.mCryptoInfo.set(paramInt1, paramArrayOfInt1, paramArrayOfInt2, paramArrayOfByte1, paramArrayOfByte2, paramInt2);
  }
  
  public int setOperateRate(float paramFloat)
  {
    if (this.mCodec != null) {}
    try
    {
      if (Build.VERSION.SDK_INT >= 19)
      {
        TPNativeLog.printLog(2, getLogTag(), "setOperateRate: " + paramFloat);
        Bundle localBundle = new Bundle();
        localBundle.putShort("priority", (short)0);
        localBundle.putFloat("operating-rate", paramFloat);
        this.mCodec.setParameters(localBundle);
      }
      return 0;
    }
    catch (Exception localException)
    {
      TPNativeLog.printLog(3, getLogTag(), "setOperateRate: " + paramFloat + " failed.");
    }
    return 0;
  }
  
  public int setOutputSurface(Surface paramSurface)
  {
    if (this.mEnableAsyncMode) {
      return setOutputSurfaceAsync(paramSurface);
    }
    return handleSetOutputSurface(paramSurface);
  }
  
  public boolean setParamBool(int paramInt, boolean paramBoolean)
  {
    switch (paramInt)
    {
    case 2: 
    default: 
      TPNativeLog.printLog(3, getLogTag(), "Unknown paramKey: " + paramInt);
      return false;
    case 0: 
      this.mEnableSetOutputSurfaceApi = paramBoolean;
    }
    for (;;)
    {
      return true;
      if (!this.mStarted)
      {
        this.mEnableAsyncMode = paramBoolean;
      }
      else
      {
        TPNativeLog.printLog(3, getLogTag(), "BOOL_ENABLE_ASYNC_MODE must setup before started!");
        continue;
        this.mEnableAudioPassThrough = paramBoolean;
        TPNativeLog.printLog(2, getLogTag(), "BOOL_SET_IS_AUDIO_PASSTHROUGH mEnableAudioPassThrough:" + this.mEnableAudioPassThrough);
        continue;
        this.mEnableMediaCodecReuse = paramBoolean;
      }
    }
  }
  
  public boolean setParamBytes(int paramInt, byte[] paramArrayOfByte)
  {
    return false;
  }
  
  public boolean setParamInt(int paramInt1, int paramInt2)
  {
    return false;
  }
  
  public boolean setParamLong(int paramInt, long paramLong)
  {
    return false;
  }
  
  public boolean setParamObject(int paramInt, Object paramObject)
  {
    if (paramInt == 300)
    {
      this.mMediaCrypto = ((MediaCrypto)paramObject);
      return true;
    }
    return false;
  }
  
  public boolean setParamString(int paramInt, String paramString)
  {
    return false;
  }
  
  public int signalEndOfStream()
  {
    TPNativeLog.printLog(2, getLogTag(), "signalEndOfStream: ");
    if (this.mCodec == null) {}
    int i;
    do
    {
      return 3;
      if (this.mEnableAsyncMode) {
        return signalEndOfStreamAsync();
      }
      i = this.mCodec.dequeueInputBuffer(MEDIA_CODEC_INPUT_TIMEOUT_US);
      if (i >= 0) {
        return handleSignalEndOfStream(i);
      }
    } while (i != -1);
    return 1;
  }
  
  public boolean startDecoder()
  {
    return initMediaCodecInternal();
  }
  
  class AsyncDecodeHandler
    extends Handler
  {
    AsyncDecodeHandler(Looper paramLooper)
    {
      super();
    }
    
    public void handleMessage(Message paramMessage)
    {
      boolean bool = false;
      int i = 0;
      for (;;)
      {
        synchronized (TPBaseMediaCodecDecoder.this.mThreadLock)
        {
          switch (paramMessage.what)
          {
          case 1000: 
            TPBaseMediaCodecDecoder.this.handleMessageComplete(i);
            return;
            TPBaseMediaCodecDecoder localTPBaseMediaCodecDecoder = TPBaseMediaCodecDecoder.this;
            i = paramMessage.arg1;
            if (paramMessage.arg2 == 1) {
              bool = true;
            }
            i = localTPBaseMediaCodecDecoder.onReleaseOutputBuffer(i, bool);
            break;
          case 1001: 
            i = TPBaseMediaCodecDecoder.this.onSetOutputSurface((Surface)paramMessage.obj);
            break;
          case 1002: 
            i = TPBaseMediaCodecDecoder.this.onFlush();
            break;
          case 1003: 
            i = TPBaseMediaCodecDecoder.this.onRelease();
          }
        }
      }
    }
  }
  
  @RequiresApi(api=21)
  class BufferCallback
    extends TMediaCodec.Callback
  {
    private BufferCallback() {}
    
    public void onError(@NonNull TMediaCodec paramTMediaCodec, @NonNull MediaCodec.CodecException paramCodecException)
    {
      TPNativeLog.printLog(4, TPBaseMediaCodecDecoder.this.getLogTag(), "onError: " + TPBaseMediaCodecDecoder.this.getStackTrace(paramCodecException));
      TPBaseMediaCodecDecoder.this.handleRelease();
    }
    
    public void onInputBufferAvailable(@NonNull TMediaCodec paramTMediaCodec, int paramInt)
    {
      try
      {
        TPBaseMediaCodecDecoder.this.mInputQueue.put(Integer.valueOf(paramInt));
        return;
      }
      catch (Exception paramTMediaCodec)
      {
        TPNativeLog.printLog(3, TPBaseMediaCodecDecoder.this.getLogTag(), TPBaseMediaCodecDecoder.this.getStackTrace(paramTMediaCodec));
      }
    }
    
    public void onOutputBufferAvailable(@NonNull TMediaCodec paramTMediaCodec, int paramInt, @NonNull MediaCodec.BufferInfo paramBufferInfo)
    {
      try
      {
        TPFrameInfo localTPFrameInfo = new TPFrameInfo();
        localTPFrameInfo.errCode = 0;
        localTPFrameInfo.bufferIndex = paramInt;
        localTPFrameInfo.ptsUs = paramBufferInfo.presentationTimeUs;
        TPBaseMediaCodecDecoder.this.processOutputBuffer(paramTMediaCodec, paramInt, paramBufferInfo, localTPFrameInfo);
        TPBaseMediaCodecDecoder.this.mOutputQueue.put(localTPFrameInfo);
        return;
      }
      catch (Exception paramTMediaCodec)
      {
        TPNativeLog.printLog(3, TPBaseMediaCodecDecoder.this.getLogTag(), TPBaseMediaCodecDecoder.this.getStackTrace(paramTMediaCodec));
      }
    }
    
    public void onOutputFormatChanged(@NonNull TMediaCodec paramTMediaCodec, @NonNull MediaFormat paramMediaFormat)
    {
      TPBaseMediaCodecDecoder.this.processOutputFormatChanged(paramMediaFormat);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.core.decoder.TPBaseMediaCodecDecoder
 * JD-Core Version:    0.7.0.1
 */