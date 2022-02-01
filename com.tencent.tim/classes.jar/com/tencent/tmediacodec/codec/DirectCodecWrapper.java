package com.tencent.tmediacodec.codec;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCrypto;
import android.media.MediaDescrambler;
import android.media.MediaFormat;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.Surface;
import com.tencent.tmediacodec.callback.CodecCallback;
import com.tencent.tmediacodec.reuse.ReuseHelper.ReuseType;
import com.tencent.tmediacodec.util.LogUtils;

public final class DirectCodecWrapper
  implements CodecWrapper
{
  public static final String TAG = "DirectCodecWrapper";
  @NonNull
  private final MediaCodec codec;
  
  public DirectCodecWrapper(@NonNull MediaCodec paramMediaCodec)
  {
    this.codec = paramMediaCodec;
  }
  
  public void attachThread() {}
  
  @TargetApi(26)
  public void configure(@NonNull MediaFormat paramMediaFormat, @Nullable Surface paramSurface, int paramInt, @Nullable MediaDescrambler paramMediaDescrambler)
  {
    this.codec.configure(paramMediaFormat, paramSurface, paramInt, paramMediaDescrambler);
  }
  
  public void configure(@NonNull MediaFormat paramMediaFormat, @Nullable Surface paramSurface, @Nullable MediaCrypto paramMediaCrypto, int paramInt)
  {
    this.codec.configure(paramMediaFormat, paramSurface, paramMediaCrypto, paramInt);
  }
  
  public int dequeueInputBuffer(long paramLong)
  {
    return this.codec.dequeueInputBuffer(paramLong);
  }
  
  public int dequeueOutputBuffer(@NonNull MediaCodec.BufferInfo paramBufferInfo, long paramLong)
  {
    return this.codec.dequeueOutputBuffer(paramBufferInfo, paramLong);
  }
  
  public void flush()
  {
    this.codec.flush();
  }
  
  @NonNull
  public final MediaCodec getCodec()
  {
    return this.codec;
  }
  
  @NonNull
  public MediaCodec getMediaCodec()
  {
    return this.codec;
  }
  
  public void prepareToReUse()
  {
    LogUtils.w("DirectCodecWrapper", "DirectCodecWrapper prepareToReUse ignore...");
  }
  
  public void queueInputBuffer(int paramInt1, int paramInt2, int paramInt3, long paramLong, int paramInt4)
  {
    this.codec.queueInputBuffer(paramInt1, paramInt2, paramInt3, paramLong, paramInt4);
  }
  
  public void release()
  {
    this.codec.release();
  }
  
  @TargetApi(21)
  public void releaseOutputBuffer(int paramInt, long paramLong)
  {
    this.codec.releaseOutputBuffer(paramInt, paramLong);
  }
  
  public void releaseOutputBuffer(int paramInt, boolean paramBoolean)
  {
    this.codec.releaseOutputBuffer(paramInt, paramBoolean);
  }
  
  @TargetApi(21)
  public void reset()
  {
    this.codec.reset();
  }
  
  @NonNull
  public ReuseHelper.ReuseType setCanReuseType(@NonNull FormatWrapper paramFormatWrapper)
  {
    LogUtils.w("DirectCodecWrapper", "setCanReuseType setCodecCallback ignore...");
    return ReuseHelper.ReuseType.KEEP_CODEC_RESULT_NO;
  }
  
  public void setCodecCallback(@Nullable CodecCallback paramCodecCallback)
  {
    LogUtils.w("DirectCodecWrapper", "DirectCodecWrapper setCodecCallback ignore...");
  }
  
  @TargetApi(23)
  public void setOutputSurface(@NonNull Surface paramSurface)
  {
    this.codec.setOutputSurface(paramSurface);
  }
  
  public void start()
  {
    this.codec.start();
  }
  
  public void stop()
  {
    this.codec.stop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tmediacodec.codec.DirectCodecWrapper
 * JD-Core Version:    0.7.0.1
 */