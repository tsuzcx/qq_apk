package com.tencent.map.sdk.a;

import android.graphics.Rect;
import java.nio.ByteBuffer;

public final class ov
{
  public final Rect a = new Rect();
  public int[] b;
  public int[] c;
  public int[] d;
  
  public static void a(int paramInt)
  {
    if ((paramInt == 0) || ((paramInt & 0x1) != 0)) {
      throw new RuntimeException("invalid nine-patch: ".concat(String.valueOf(paramInt)));
    }
  }
  
  public static void a(int[] paramArrayOfInt, ByteBuffer paramByteBuffer)
  {
    int i = 0;
    int j = paramArrayOfInt.length;
    while (i < j)
    {
      paramArrayOfInt[i] = paramByteBuffer.getInt();
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.map.sdk.a.ov
 * JD-Core Version:    0.7.0.1
 */