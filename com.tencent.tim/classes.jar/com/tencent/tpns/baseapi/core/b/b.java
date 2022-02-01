package com.tencent.tpns.baseapi.core.b;

public class b
{
  private static final char[] a = "0123456789abcdef".toCharArray();
  
  public static String a(byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramArrayOfByte.length * 2);
    int j = paramArrayOfByte.length;
    int i = 0;
    while (i < j)
    {
      int k = paramArrayOfByte[i];
      localStringBuilder.append(a[(k >> 4 & 0xF)]);
      localStringBuilder.append(a[(k & 0xF)]);
      i += 1;
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tpns.baseapi.core.b.b
 * JD-Core Version:    0.7.0.1
 */