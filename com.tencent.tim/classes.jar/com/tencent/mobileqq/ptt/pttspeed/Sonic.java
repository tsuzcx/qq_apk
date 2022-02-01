package com.tencent.mobileqq.ptt.pttspeed;

public class Sonic
{
  long agJ = 0L;
  
  static
  {
    System.loadLibrary("sonic");
  }
  
  public Sonic(int paramInt1, int paramInt2)
  {
    close();
    this.agJ = initNative(paramInt1, paramInt2);
  }
  
  private native int availableBytesNative(long paramLong);
  
  private native void closeNative(long paramLong);
  
  private native void flushNative(long paramLong);
  
  private native boolean getChordPitchNative(long paramLong);
  
  private native int getNumChannelsNative(long paramLong);
  
  private native float getPitchNative(long paramLong);
  
  private native float getRateNative(long paramLong);
  
  private native int getSampleRateNative(long paramLong);
  
  private native float getSpeedNative(long paramLong);
  
  private native float getVolumeNative(long paramLong);
  
  private native long initNative(int paramInt1, int paramInt2);
  
  private native boolean putBytesNative(long paramLong, byte[] paramArrayOfByte, int paramInt);
  
  private native int receiveBytesNative(long paramLong, byte[] paramArrayOfByte, int paramInt);
  
  private native void setChordPitchNative(long paramLong, boolean paramBoolean);
  
  private native void setNumChannelsNative(long paramLong, int paramInt);
  
  private native void setPitchNative(long paramLong, float paramFloat);
  
  private native void setRateNative(long paramLong, float paramFloat);
  
  private native void setSampleRateNative(long paramLong, int paramInt);
  
  private native void setSpeedNative(long paramLong, float paramFloat);
  
  private native void setVolumeNative(long paramLong, float paramFloat);
  
  public int HC()
  {
    return availableBytesNative(this.agJ);
  }
  
  public void close()
  {
    if (this.agJ != 0L)
    {
      closeNative(this.agJ);
      this.agJ = 0L;
    }
  }
  
  public boolean e(byte[] paramArrayOfByte, int paramInt)
  {
    return putBytesNative(this.agJ, paramArrayOfByte, paramInt);
  }
  
  protected void finalize()
  {
    close();
  }
  
  public void flush()
  {
    flushNative(this.agJ);
  }
  
  public int i(byte[] paramArrayOfByte, int paramInt)
  {
    return receiveBytesNative(this.agJ, paramArrayOfByte, paramInt);
  }
  
  public void setSpeed(float paramFloat)
  {
    setSpeedNative(this.agJ, paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ptt.pttspeed.Sonic
 * JD-Core Version:    0.7.0.1
 */