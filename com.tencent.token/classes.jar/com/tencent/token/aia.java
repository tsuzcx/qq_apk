package com.tencent.token;

import java.util.ArrayList;

public final class aia
{
  private static byte[] a(int paramInt)
  {
    return new byte[] { (byte)(paramInt >> 24 & 0xFF), (byte)(paramInt >> 16 & 0xFF), (byte)(paramInt >> 8 & 0xFF), (byte)(paramInt & 0xFF) };
  }
  
  public static byte[] a(ArrayList<byte[]> paramArrayList)
  {
    int m = paramArrayList.size();
    int i = m * 4 + 4;
    int k = i;
    int j = 0;
    while (j < m)
    {
      k += ((byte[])paramArrayList.get(j)).length;
      j += 1;
    }
    byte[] arrayOfByte = new byte[k];
    System.arraycopy(a(m), 0, arrayOfByte, 0, 4);
    j = 0;
    while (j < m)
    {
      System.arraycopy(a(((byte[])paramArrayList.get(j)).length), 0, arrayOfByte, j * 4 + 4, 4);
      j += 1;
    }
    k = 0;
    j = i;
    i = k;
    while (i < m)
    {
      k = ((byte[])paramArrayList.get(i)).length;
      System.arraycopy(paramArrayList.get(i), 0, arrayOfByte, j, k);
      j += k;
      i += 1;
    }
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.aia
 * JD-Core Version:    0.7.0.1
 */