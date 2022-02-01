package com.tencent.moai.mailsdk.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class ASCIIUtility
{
  public static byte[] getBytes(InputStream paramInputStream)
    throws IOException
  {
    int i;
    if ((paramInputStream instanceof ByteArrayInputStream))
    {
      i = paramInputStream.available();
      localObject = new byte[i];
      paramInputStream.read((byte[])localObject, 0, i);
      return localObject;
    }
    Object localObject = new ByteArrayOutputStream();
    byte[] arrayOfByte = new byte[1024];
    for (;;)
    {
      i = paramInputStream.read(arrayOfByte, 0, 1024);
      if (i == -1) {
        break;
      }
      ((ByteArrayOutputStream)localObject).write(arrayOfByte, 0, i);
    }
    return ((ByteArrayOutputStream)localObject).toByteArray();
  }
  
  public static byte[] getBytes(String paramString)
  {
    paramString = paramString.toCharArray();
    int j = paramString.length;
    byte[] arrayOfByte = new byte[j];
    int i = 0;
    while (i < j)
    {
      arrayOfByte[i] = ((byte)paramString[i]);
      i += 1;
    }
    return arrayOfByte;
  }
  
  public static int parseInt(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws NumberFormatException
  {
    return parseInt(paramArrayOfByte, paramInt1, paramInt2, 10);
  }
  
  public static int parseInt(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
    throws NumberFormatException
  {
    if (paramArrayOfByte == null) {
      throw new NumberFormatException("null");
    }
    int m;
    int k;
    int i;
    int i1;
    int j;
    int n;
    if (paramInt2 > paramInt1)
    {
      if (paramArrayOfByte[paramInt1] == 45)
      {
        m = 1;
        k = -2147483648;
        i = paramInt1 + 1;
      }
      for (;;)
      {
        i1 = k / paramInt3;
        if (i >= paramInt2) {
          break label262;
        }
        j = i + 1;
        i = Character.digit((char)paramArrayOfByte[i], paramInt3);
        if (i >= 0) {
          break;
        }
        throw new NumberFormatException("illegal number: " + toString(paramArrayOfByte, paramInt1, paramInt2));
        k = -2147483647;
        i = paramInt1;
        m = 0;
      }
      n = -i;
      i = j;
      j = n;
    }
    for (;;)
    {
      if (i < paramInt2)
      {
        n = Character.digit((char)paramArrayOfByte[i], paramInt3);
        if (n < 0) {
          throw new NumberFormatException("illegal number");
        }
        if (j < i1) {
          throw new NumberFormatException("illegal number");
        }
        j *= paramInt3;
        if (j < k + n) {
          throw new NumberFormatException("illegal number");
        }
        j -= n;
        i += 1;
        continue;
        throw new NumberFormatException("illegal number");
      }
      else
      {
        if (m != 0)
        {
          if (i > paramInt1 + 1) {
            return j;
          }
          throw new NumberFormatException("illegal number");
        }
        return -j;
        label262:
        j = 0;
      }
    }
  }
  
  public static long parseLong(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws NumberFormatException
  {
    return parseLong(paramArrayOfByte, paramInt1, paramInt2, 10);
  }
  
  public static long parseLong(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
    throws NumberFormatException
  {
    if (paramArrayOfByte == null) {
      throw new NumberFormatException("null");
    }
    long l1 = 0L;
    int k;
    int j;
    if (paramInt2 > paramInt1)
    {
      long l2;
      if (paramArrayOfByte[paramInt1] == 45)
      {
        k = 1;
        l2 = -9223372036854775808L;
      }
      long l3;
      for (int i = paramInt1 + 1;; i = paramInt1)
      {
        l3 = l2 / paramInt3;
        j = i;
        if (i >= paramInt2) {
          break label134;
        }
        j = Character.digit((char)paramArrayOfByte[i], paramInt3);
        if (j >= 0) {
          break;
        }
        throw new NumberFormatException("illegal number: " + toString(paramArrayOfByte, paramInt1, paramInt2));
        l2 = -9223372036854775807L;
        k = 0;
      }
      l1 = -j;
      j = i + 1;
      label134:
      while (j < paramInt2)
      {
        i = Character.digit((char)paramArrayOfByte[j], paramInt3);
        if (i < 0) {
          throw new NumberFormatException("illegal number");
        }
        if (l1 < l3) {
          throw new NumberFormatException("illegal number");
        }
        l1 *= paramInt3;
        if (l1 < i + l2) {
          throw new NumberFormatException("illegal number");
        }
        l1 -= i;
        j += 1;
      }
    }
    throw new NumberFormatException("illegal number");
    if (k != 0)
    {
      if (j > paramInt1 + 1) {
        return l1;
      }
      throw new NumberFormatException("illegal number");
    }
    return -l1;
  }
  
  public static String toString(ByteArrayInputStream paramByteArrayInputStream)
  {
    int i = 0;
    int j = paramByteArrayInputStream.available();
    char[] arrayOfChar = new char[j];
    byte[] arrayOfByte = new byte[j];
    paramByteArrayInputStream.read(arrayOfByte, 0, j);
    while (i < j)
    {
      arrayOfChar[i] = ((char)(arrayOfByte[i] & 0xFF));
      i += 1;
    }
    return new String(arrayOfChar);
  }
  
  public static String toString(byte[] paramArrayOfByte)
  {
    return toString(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public static String toString(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int j = paramInt2 - paramInt1;
    char[] arrayOfChar = new char[j];
    int i = 0;
    paramInt2 = paramInt1;
    paramInt1 = i;
    while (paramInt1 < j)
    {
      arrayOfChar[paramInt1] = ((char)(paramArrayOfByte[paramInt2] & 0xFF));
      paramInt2 += 1;
      paramInt1 += 1;
    }
    return new String(arrayOfChar);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.util.ASCIIUtility
 * JD-Core Version:    0.7.0.1
 */