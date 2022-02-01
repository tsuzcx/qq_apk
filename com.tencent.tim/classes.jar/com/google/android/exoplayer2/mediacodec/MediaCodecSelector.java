package com.google.android.exoplayer2.mediacodec;

public abstract interface MediaCodecSelector
{
  public static final MediaCodecSelector DEFAULT = new MediaCodecSelector.1();
  
  public abstract MediaCodecInfo getDecoderInfo(String paramString, boolean paramBoolean1, boolean paramBoolean2)
    throws MediaCodecUtil.DecoderQueryException;
  
  public abstract MediaCodecInfo getPassthroughDecoderInfo()
    throws MediaCodecUtil.DecoderQueryException;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.mediacodec.MediaCodecSelector
 * JD-Core Version:    0.7.0.1
 */