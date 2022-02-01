package com.tencent.android.tpush.service.channel.security;

import java.io.ByteArrayOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class c
  extends FilterOutputStream
{
  private static final char[] a = { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47 };
  private int b;
  private int c;
  
  public c(OutputStream paramOutputStream)
  {
    super(paramOutputStream);
  }
  
  public static String a(byte[] paramArrayOfByte)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream((int)(paramArrayOfByte.length * 1.37D));
    c localc = new c(localByteArrayOutputStream);
    try
    {
      localc.write(paramArrayOfByte);
      localc.close();
      localByteArrayOutputStream.close();
      paramArrayOfByte = localByteArrayOutputStream.toString("UTF-8");
      return paramArrayOfByte;
    }
    catch (IOException paramArrayOfByte) {}
    return null;
  }
  
  public void close()
  {
    int i;
    if (this.b % 3 == 1)
    {
      i = this.c;
      this.out.write(a[(i << 4 & 0x3F)]);
      this.out.write(61);
      this.out.write(61);
    }
    for (;;)
    {
      super.close();
      return;
      if (this.b % 3 == 2)
      {
        i = this.c;
        this.out.write(a[(i << 2 & 0x3F)]);
        this.out.write(61);
      }
    }
  }
  
  public void write(int paramInt)
  {
    int i = paramInt;
    if (paramInt < 0) {
      i = paramInt + 256;
    }
    if (this.b % 3 == 0)
    {
      this.c = (i & 0x3);
      this.out.write(a[(i >> 2)]);
    }
    for (;;)
    {
      this.b += 1;
      if (this.b % 57 == 0) {
        this.out.write(10);
      }
      return;
      if (this.b % 3 == 1)
      {
        paramInt = this.c;
        this.c = (i & 0xF);
        this.out.write(a[((paramInt << 4) + (i >> 4) & 0x3F)]);
      }
      else if (this.b % 3 == 2)
      {
        paramInt = this.c;
        this.out.write(a[((paramInt << 2) + (i >> 6) & 0x3F)]);
        this.out.write(a[(i & 0x3F)]);
        this.c = 0;
      }
    }
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = 0;
    while (i < paramInt2)
    {
      write(paramArrayOfByte[(paramInt1 + i)]);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.service.channel.security.c
 * JD-Core Version:    0.7.0.1
 */