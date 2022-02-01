package com.tencent.mobileqq.triton.font;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class b
{
  private static int a = 4096;
  private static int b = -1;
  
  public static int a(InputStream paramInputStream, OutputStream paramOutputStream)
    throws IOException
  {
    long l = b(paramInputStream, paramOutputStream);
    if (l > 2147483647L) {
      return -1;
    }
    return (int)l;
  }
  
  public static long a(InputStream paramInputStream, OutputStream paramOutputStream, byte[] paramArrayOfByte)
    throws IOException
  {
    int j;
    for (long l = 0L;; l += j)
    {
      int i = b;
      j = paramInputStream.read(paramArrayOfByte);
      if (i == j) {
        break;
      }
      paramOutputStream.write(paramArrayOfByte, 0, j);
    }
    return l;
  }
  
  public static byte[] a(InputStream paramInputStream)
    throws IOException
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    a(paramInputStream, localByteArrayOutputStream);
    return localByteArrayOutputStream.toByteArray();
  }
  
  public static long b(InputStream paramInputStream, OutputStream paramOutputStream)
    throws IOException
  {
    return a(paramInputStream, paramOutputStream, new byte[a]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.triton.font.b
 * JD-Core Version:    0.7.0.1
 */