package com.tencent.mobileqq.minicode;

public class RecogProxy
{
  public static native void QCodeDestroy(long paramLong);
  
  public static native long QCodeInit(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2, String paramString3, String paramString4, float paramFloat);
  
  public static native String QCodeProcess(long paramLong, int paramInt1, int paramInt2);
  
  public static native int getBox(long paramLong, int paramInt, float[] paramArrayOfFloat);
  
  public static native int getBoxCnt(long paramLong);
  
  public static native int getBoxType(long paramLong, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minicode.RecogProxy
 * JD-Core Version:    0.7.0.1
 */