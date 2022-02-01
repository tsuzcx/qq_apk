package com.tencent.moai.mailsdk.util.stream;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class BASE64EncoderStream
  extends FilterOutputStream
{
  private static byte[] newline = { 13, 10 };
  private static final char[] pem_array = { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47 };
  private byte[] buffer = new byte[3];
  private int bufsize = 0;
  private int bytesPerLine;
  private int count = 0;
  private int lineLimit;
  private boolean noCRLF = false;
  private byte[] outbuf;
  
  public BASE64EncoderStream(OutputStream paramOutputStream)
  {
    this(paramOutputStream, 76);
  }
  
  public BASE64EncoderStream(OutputStream paramOutputStream, int paramInt)
  {
    super(paramOutputStream);
    int i;
    if (paramInt != 2147483647)
    {
      i = paramInt;
      if (paramInt >= 4) {}
    }
    else
    {
      this.noCRLF = true;
      i = 76;
    }
    paramInt = i / 4 * 4;
    this.bytesPerLine = paramInt;
    this.lineLimit = (paramInt / 4 * 3);
    if (this.noCRLF)
    {
      this.outbuf = new byte[paramInt];
      return;
    }
    this.outbuf = new byte[paramInt + 2];
    this.outbuf[paramInt] = 13;
    this.outbuf[(paramInt + 1)] = 10;
  }
  
  private void encode()
    throws IOException
  {
    int i = encodedSize(this.bufsize);
    this.out.write(encode(this.buffer, 0, this.bufsize, this.outbuf), 0, i);
    this.count = (i + this.count);
    if (this.count >= this.bytesPerLine)
    {
      if (!this.noCRLF) {
        this.out.write(newline);
      }
      this.count = 0;
    }
  }
  
  public static byte[] encode(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte.length == 0) {
      return paramArrayOfByte;
    }
    return encode(paramArrayOfByte, 0, paramArrayOfByte.length, null);
  }
  
  private static byte[] encode(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2)
  {
    byte[] arrayOfByte = paramArrayOfByte2;
    if (paramArrayOfByte2 == null) {
      arrayOfByte = new byte[encodedSize(paramInt2)];
    }
    int j = 0;
    int i = paramInt1;
    paramInt1 = j;
    while (paramInt2 >= 3)
    {
      int m = i + 1;
      j = paramArrayOfByte1[i];
      int k = m + 1;
      m = paramArrayOfByte1[m];
      i = k + 1;
      j = (m & 0xFF | (j & 0xFF) << 8) << 8 | paramArrayOfByte1[k] & 0xFF;
      arrayOfByte[(paramInt1 + 3)] = ((byte)pem_array[(j & 0x3F)]);
      j >>= 6;
      arrayOfByte[(paramInt1 + 2)] = ((byte)pem_array[(j & 0x3F)]);
      j >>= 6;
      arrayOfByte[(paramInt1 + 1)] = ((byte)pem_array[(j & 0x3F)]);
      arrayOfByte[(paramInt1 + 0)] = ((byte)pem_array[(j >> 6 & 0x3F)]);
      paramInt2 -= 3;
      paramInt1 += 4;
    }
    if (paramInt2 == 1)
    {
      paramInt2 = (paramArrayOfByte1[i] & 0xFF) << 4;
      arrayOfByte[(paramInt1 + 3)] = 61;
      arrayOfByte[(paramInt1 + 2)] = 61;
      arrayOfByte[(paramInt1 + 1)] = ((byte)pem_array[(paramInt2 & 0x3F)]);
      arrayOfByte[(paramInt1 + 0)] = ((byte)pem_array[(paramInt2 >> 6 & 0x3F)]);
    }
    while (paramInt2 != 2) {
      return arrayOfByte;
    }
    paramInt2 = i + 1;
    i = paramArrayOfByte1[i];
    paramInt2 = (paramArrayOfByte1[paramInt2] & 0xFF | (i & 0xFF) << 8) << 2;
    arrayOfByte[(paramInt1 + 3)] = 61;
    arrayOfByte[(paramInt1 + 2)] = ((byte)pem_array[(paramInt2 & 0x3F)]);
    paramInt2 >>= 6;
    arrayOfByte[(paramInt1 + 1)] = ((byte)pem_array[(paramInt2 & 0x3F)]);
    arrayOfByte[(paramInt1 + 0)] = ((byte)pem_array[(paramInt2 >> 6 & 0x3F)]);
    return arrayOfByte;
  }
  
  private static int encodedSize(int paramInt)
  {
    return (paramInt + 2) / 3 * 4;
  }
  
  public void close()
    throws IOException
  {
    try
    {
      flush();
      if ((this.count > 0) && (!this.noCRLF))
      {
        this.out.write(newline);
        this.out.flush();
      }
      this.out.close();
      return;
    }
    finally {}
  }
  
  public void flush()
    throws IOException
  {
    try
    {
      if (this.bufsize > 0)
      {
        encode();
        this.bufsize = 0;
      }
      this.out.flush();
      return;
    }
    finally {}
  }
  
  public void write(int paramInt)
    throws IOException
  {
    try
    {
      byte[] arrayOfByte = this.buffer;
      int i = this.bufsize;
      this.bufsize = (i + 1);
      arrayOfByte[i] = ((byte)paramInt);
      if (this.bufsize == 3)
      {
        encode();
        this.bufsize = 0;
      }
      return;
    }
    finally {}
  }
  
  public void write(byte[] paramArrayOfByte)
    throws IOException
  {
    write(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    int j = paramInt1 + paramInt2;
    paramInt2 = paramInt1;
    try
    {
      while ((this.bufsize != 0) && (paramInt2 < j))
      {
        write(paramArrayOfByte[paramInt2]);
        paramInt2 += 1;
      }
      int k = (this.bytesPerLine - this.count) / 4 * 3;
      paramInt1 = paramInt2;
      int i;
      if (paramInt2 + k < j)
      {
        i = encodedSize(k);
        paramInt1 = i;
        if (!this.noCRLF)
        {
          byte[] arrayOfByte = this.outbuf;
          int m = i + 1;
          arrayOfByte[i] = 13;
          arrayOfByte = this.outbuf;
          paramInt1 = m + 1;
          arrayOfByte[m] = 10;
        }
        this.out.write(encode(paramArrayOfByte, paramInt2, k, this.outbuf), 0, paramInt1);
        paramInt1 = paramInt2 + k;
        this.count = 0;
      }
      while (this.lineLimit + paramInt1 < j)
      {
        this.out.write(encode(paramArrayOfByte, paramInt1, this.lineLimit, this.outbuf));
        paramInt1 += this.lineLimit;
      }
      paramInt2 = paramInt1;
      if (paramInt1 + 3 < j)
      {
        paramInt2 = (j - paramInt1) / 3 * 3;
        i = encodedSize(paramInt2);
        this.out.write(encode(paramArrayOfByte, paramInt1, paramInt2, this.outbuf), 0, i);
        paramInt2 = paramInt1 + paramInt2;
        this.count += i;
      }
      while (paramInt2 < j)
      {
        write(paramArrayOfByte[paramInt2]);
        paramInt2 += 1;
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.util.stream.BASE64EncoderStream
 * JD-Core Version:    0.7.0.1
 */