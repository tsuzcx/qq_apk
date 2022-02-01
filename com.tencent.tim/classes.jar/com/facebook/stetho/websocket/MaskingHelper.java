package com.facebook.stetho.websocket;

class MaskingHelper
{
  public static void unmask(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2)
  {
    int i = 0;
    while (paramInt2 > 0)
    {
      int j = paramArrayOfByte2[paramInt1];
      paramArrayOfByte2[paramInt1] = ((byte)(paramArrayOfByte1[(i % paramArrayOfByte1.length)] ^ j));
      i += 1;
      paramInt2 -= 1;
      paramInt1 += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.facebook.stetho.websocket.MaskingHelper
 * JD-Core Version:    0.7.0.1
 */