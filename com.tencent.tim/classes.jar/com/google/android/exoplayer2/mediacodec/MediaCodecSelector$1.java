package com.google.android.exoplayer2.mediacodec;

final class MediaCodecSelector$1
  implements MediaCodecSelector
{
  public MediaCodecInfo getDecoderInfo(String paramString, boolean paramBoolean1, boolean paramBoolean2)
    throws MediaCodecUtil.DecoderQueryException
  {
    return MediaCodecUtil.getDecoderInfo(paramString, paramBoolean1, paramBoolean2);
  }
  
  public MediaCodecInfo getPassthroughDecoderInfo()
    throws MediaCodecUtil.DecoderQueryException
  {
    return MediaCodecUtil.getPassthroughDecoderInfo();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.mediacodec.MediaCodecSelector.1
 * JD-Core Version:    0.7.0.1
 */