package com.tencent.mobileqq.minicode;

public class DecodeProxy
{
  public static final int MODE_FAST = 0;
  public static final int MODE_SLOW = 1;
  
  public static native boolean checkQRExist(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3);
  
  public static native String getVersion();
  
  public static native String nativeDecode(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7);
  
  public static native void setLogSwitch(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minicode.DecodeProxy
 * JD-Core Version:    0.7.0.1
 */