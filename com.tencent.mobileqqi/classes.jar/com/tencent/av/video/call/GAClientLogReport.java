package com.tencent.av.video.call;

public class GAClientLogReport
{
  static {}
  
  public GAClientLogReport()
  {
    init();
  }
  
  private static native void cacheMethodIds();
  
  private int callbackSendLog(long paramLong, int paramInt, byte[] paramArrayOfByte)
  {
    return ClientLogReport.instance().callbackSendLog(paramLong, paramInt, paramArrayOfByte);
  }
  
  private native void init();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.av.video.call.GAClientLogReport
 * JD-Core Version:    0.7.0.1
 */