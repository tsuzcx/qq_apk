package com.tencent.ttpic.video;

public class AECoderFactory
{
  private static AEDecoderFactory mAEDecoderFactory;
  private static AEEncoderFactory mAEEncoderFactory;
  
  public static AEDecoder createDecoder(String paramString)
  {
    if (mAEDecoderFactory == null) {
      return null;
    }
    return mAEDecoderFactory.createDecoder(paramString);
  }
  
  public static AEEncoder createEncoder(String paramString, int paramInt1, int paramInt2)
  {
    if (mAEEncoderFactory == null) {
      return null;
    }
    return mAEEncoderFactory.createEncoder(paramString, paramInt1, paramInt2);
  }
  
  public static void setAEDecoder(AEDecoderFactory paramAEDecoderFactory)
  {
    mAEDecoderFactory = paramAEDecoderFactory;
  }
  
  public static void setAEEncoder(AEEncoderFactory paramAEEncoderFactory)
  {
    mAEEncoderFactory = paramAEEncoderFactory;
  }
  
  public static abstract interface AEDecoderFactory
  {
    public abstract AEDecoder createDecoder(String paramString);
  }
  
  public static abstract interface AEEncoderFactory
  {
    public abstract AEEncoder createEncoder(String paramString, int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.video.AECoderFactory
 * JD-Core Version:    0.7.0.1
 */