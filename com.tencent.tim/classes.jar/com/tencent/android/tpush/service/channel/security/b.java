package com.tencent.android.tpush.service.channel.security;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class b
  extends FilterInputStream
{
  private static final char[] a = { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47 };
  private static final int[] b = new int[''];
  private int c;
  private int d;
  
  static
  {
    int i = 0;
    while (i < 64)
    {
      b[a[i]] = i;
      i += 1;
    }
  }
  
  public b(InputStream paramInputStream)
  {
    super(paramInputStream);
  }
  
  public static byte[] a(String paramString)
  {
    Object localObject = new byte[0];
    try
    {
      paramString = paramString.getBytes("UTF-8");
      localObject = new b(new ByteArrayInputStream(paramString));
      paramString = new ByteArrayOutputStream((int)(paramString.length * 0.67D));
    }
    catch (Throwable paramString)
    {
      for (;;)
      {
        try
        {
          byte[] arrayOfByte = new byte[4096];
          int i = ((b)localObject).read(arrayOfByte);
          if (i != -1)
          {
            paramString.write(arrayOfByte, 0, i);
            continue;
          }
          ((b)localObject).close();
          paramString.close();
          paramString = paramString.toByteArray();
          return paramString;
        }
        catch (IOException paramString) {}
        paramString = paramString;
        paramString = (String)localObject;
      }
    }
    return null;
  }
  
  public int read()
  {
    int i = this.in.read();
    if (i == -1) {}
    int j;
    do
    {
      do
      {
        return -1;
        if (Character.isWhitespace((char)i)) {
          break;
        }
        this.c += 1;
      } while (i == 61);
      i = b[i];
      j = (this.c - 1) % 4;
      if (j == 0)
      {
        this.d = (i & 0x3F);
        return read();
      }
      if (j == 1)
      {
        j = this.d;
        this.d = (i & 0xF);
        return (j << 2) + (i >> 4) & 0xFF;
      }
      if (j == 2)
      {
        j = this.d;
        this.d = (i & 0x3);
        return (j << 4) + (i >> 2) & 0xFF;
      }
    } while (j != 3);
    return (this.d << 6) + i & 0xFF;
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramArrayOfByte.length < paramInt2 + paramInt1 - 1) {
      throw new IOException("The input buffer is too small: " + paramInt2 + " bytes requested starting at offset " + paramInt1 + " while the buffer " + " is only " + paramArrayOfByte.length + " bytes long.");
    }
    int i = 0;
    for (;;)
    {
      int j;
      if (i < paramInt2)
      {
        j = read();
        if ((j == -1) && (i == 0)) {
          return -1;
        }
        if (j != -1) {}
      }
      else
      {
        return i;
      }
      paramArrayOfByte[(paramInt1 + i)] = ((byte)j);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.service.channel.security.b
 * JD-Core Version:    0.7.0.1
 */