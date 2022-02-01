package com.tencent.tmediacodec.codec;

import android.media.MediaCodec;
import android.support.annotation.NonNull;
import com.tencent.tmediacodec.reuse.ReuseHelper;
import com.tencent.tmediacodec.reuse.ReuseHelper.ReuseType;

public final class AudioCodecWrapper
  extends ReuseCodecWrapper
{
  public AudioCodecWrapper(@NonNull MediaCodec paramMediaCodec, @NonNull FormatWrapper paramFormatWrapper)
  {
    super(paramMediaCodec, paramFormatWrapper);
  }
  
  @NonNull
  public ReuseHelper.ReuseType canReuse(@NonNull FormatWrapper paramFormatWrapper)
  {
    if (ReuseHelper.isSeamlessAdaptationSupported(this, paramFormatWrapper)) {
      return ReuseHelper.ReuseType.KEEP_CODEC_RESULT_YES_WITHOUT_RECONFIGURATION;
    }
    return ReuseHelper.ReuseType.KEEP_CODEC_RESULT_NO;
  }
  
  @NonNull
  public String toString()
  {
    return "AudioCodecWrapper[" + hashCode() + ']';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tmediacodec.codec.AudioCodecWrapper
 * JD-Core Version:    0.7.0.1
 */