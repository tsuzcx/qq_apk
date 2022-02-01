package com.tencent.mqp.app.sec;

import com.tencent.mobileqq.app.ThreadManager;

public class SecClientInfoTaskEx
  implements Runnable
{
  private static boolean dcs;
  private static String mMd5;
  private int ekz = 1;
  private int mTaskType = 1;
  private long mUin = 1L;
  
  public SecClientInfoTaskEx(long paramLong, int paramInt1, int paramInt2)
  {
    this.mUin = paramLong;
    this.mTaskType = paramInt1;
    this.ekz = paramInt2;
  }
  
  private static byte[] int2byte(int paramInt)
  {
    return new byte[] { (byte)(paramInt & 0xFF), (byte)(paramInt >> 8 & 0xFF), (byte)(paramInt >> 16 & 0xFF), (byte)(paramInt >>> 24) };
  }
  
  public void run()
  {
    ThreadManager.post(new SecClientInfoTaskEx.1(this), 5, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mqp.app.sec.SecClientInfoTaskEx
 * JD-Core Version:    0.7.0.1
 */