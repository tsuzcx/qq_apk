package com.tencent.mobileqq.magicface;

public class DecoderUtil
{
  static
  {
    try
    {
      System.loadLibrary("magicfaceDec");
      return;
    }
    catch (Exception localException) {}
  }
  
  public native int createAlphaDecoder();
  
  public native int createVideoDecoder();
  
  public native int decodeAlphaDecoder(byte[] paramArrayOfByte1, int paramInt, byte[] paramArrayOfByte2);
  
  public native int decodeVideoDecoder(byte[] paramArrayOfByte1, int paramInt, byte[] paramArrayOfByte2);
  
  public native int getHeightVideoDecoder();
  
  public native int getWidthVideoDecoder();
  
  public native int releaseAlphaDecoder();
  
  public native int releaseVideoDecoder();
  
  public void testfunc1(byte[] paramArrayOfByte, long paramLong) {}
  
  public void testfunc2(byte paramByte, long paramLong) {}
  
  public void testfunc3() {}
  
  public void testfunc4(long paramLong) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.magicface.DecoderUtil
 * JD-Core Version:    0.7.0.1
 */