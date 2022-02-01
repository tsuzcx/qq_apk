package com.tencent.TMG.ptt;

public class TraeJni
{
  static TraeJni sInstance = null;
  
  static
  {
    System.loadLibrary("silk");
  }
  
  private native boolean destory();
  
  public static TraeJni getInstance()
  {
    if (sInstance == null) {
      sInstance = new TraeJni();
    }
    return sInstance;
  }
  
  private native boolean init();
  
  private native byte[] turnPCM2SILK(byte[] paramArrayOfByte, long paramLong);
  
  private native byte[] turnSILK2PCM(byte[] paramArrayOfByte, long paramLong);
  
  public boolean destoryTRAE()
  {
    return destory();
  }
  
  public boolean initTRAE()
  {
    return init();
  }
  
  public byte[] turnPCM(byte[] paramArrayOfByte, long paramLong)
  {
    return turnSILK2PCM(paramArrayOfByte, paramLong);
  }
  
  public byte[] turnSilk(byte[] paramArrayOfByte, long paramLong)
  {
    return turnPCM2SILK(paramArrayOfByte, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.tencent.TMG.ptt.TraeJni
 * JD-Core Version:    0.7.0.1
 */