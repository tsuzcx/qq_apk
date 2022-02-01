package com.tencent.qqmail.protocol;

public class Util
{
  public static native int MarkMailType(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean);
  
  public static native byte[] convertCharset(byte[] paramArrayOfByte, int paramInt, String paramString);
  
  public static native void simulateCrash(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.Util
 * JD-Core Version:    0.7.0.1
 */