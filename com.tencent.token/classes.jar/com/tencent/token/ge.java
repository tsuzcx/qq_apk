package com.tencent.token;

import java.util.ArrayList;

public final class ge
{
  private static byte[] a(int paramInt)
  {
    return new byte[] { (byte)(paramInt >> 24 & 0xFF), (byte)(paramInt >> 16 & 0xFF), (byte)(paramInt >> 8 & 0xFF), (byte)(paramInt & 0xFF) };
  }
  
  public static byte[] a(ArrayList paramArrayList)
  {
    int k = paramArrayList.size();
    int i = 0;
    int j = k * 4 + 4;
    while (i < k)
    {
      j += ((byte[])paramArrayList.get(i)).length;
      i += 1;
    }
    byte[] arrayOfByte = new byte[j];
    System.arraycopy(a(k), 0, arrayOfByte, 0, 4);
    i = 0;
    while (i < k)
    {
      System.arraycopy(a(((byte[])paramArrayList.get(i)).length), 0, arrayOfByte, i * 4 + 4, 4);
      i += 1;
    }
    i = 0;
    j = k * 4 + 4;
    while (i < k)
    {
      int m = ((byte[])paramArrayList.get(i)).length;
      System.arraycopy(paramArrayList.get(i), 0, arrayOfByte, j, m);
      j += m;
      i += 1;
    }
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ge
 * JD-Core Version:    0.7.0.1
 */