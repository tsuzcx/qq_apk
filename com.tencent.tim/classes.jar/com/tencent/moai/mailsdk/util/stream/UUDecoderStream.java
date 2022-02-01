package com.tencent.moai.mailsdk.util.stream;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class UUDecoderStream
  extends FilterInputStream
{
  private byte[] buffer;
  private int bufsize = 0;
  private boolean gotEnd = false;
  private boolean gotPrefix = false;
  private int index = 0;
  private LineInputStream lin;
  private int mode;
  private String name;
  
  public UUDecoderStream(InputStream paramInputStream)
  {
    super(paramInputStream);
    this.lin = new LineInputStream(paramInputStream);
    this.buffer = new byte[45];
  }
  
  private boolean decode()
    throws IOException
  {
    if (this.gotEnd) {
      return false;
    }
    this.bufsize = 0;
    String str;
    do
    {
      str = this.lin.readLine();
      if (str == null) {
        throw new IOException("Missing End");
      }
      if (str.regionMatches(true, 0, "end", 0, 3))
      {
        this.gotEnd = true;
        return false;
      }
    } while (str.length() == 0);
    int i = str.charAt(0);
    if (i < 32) {
      throw new IOException("Buffer format error");
    }
    int m = i - 32 & 0x3F;
    if (m == 0)
    {
      str = this.lin.readLine();
      if ((str == null) || (!str.regionMatches(true, 0, "end", 0, 3))) {
        throw new IOException("Missing End");
      }
      this.gotEnd = true;
      return false;
    }
    i = (m * 8 + 5) / 6;
    if (str.length() < i + 1) {
      throw new IOException("Short buffer error");
    }
    i = 1;
    int j;
    int k;
    byte[] arrayOfByte;
    int n;
    if (this.bufsize < m)
    {
      j = i + 1;
      k = (byte)(str.charAt(i) - ' ' & 0x3F);
      i = j + 1;
      j = (byte)(str.charAt(j) - ' ' & 0x3F);
      arrayOfByte = this.buffer;
      n = this.bufsize;
      this.bufsize = (n + 1);
      arrayOfByte[n] = ((byte)(k << 2 & 0xFC | j >>> 4 & 0x3));
      if (this.bufsize >= m) {
        break label412;
      }
      k = (byte)(str.charAt(i) - ' ' & 0x3F);
      arrayOfByte = this.buffer;
      n = this.bufsize;
      this.bufsize = (n + 1);
      arrayOfByte[n] = ((byte)(j << 4 & 0xF0 | k >>> 2 & 0xF));
      i += 1;
      j = k;
    }
    label412:
    for (;;)
    {
      if (this.bufsize < m)
      {
        k = i + 1;
        i = (byte)(str.charAt(i) - ' ' & 0x3F);
        arrayOfByte = this.buffer;
        n = this.bufsize;
        this.bufsize = (n + 1);
        arrayOfByte[n] = ((byte)(i & 0x3F | j << 6 & 0xC0));
        i = k;
        break;
        return true;
      }
      break;
    }
  }
  
  private void readPrefix()
    throws IOException
  {
    if (this.gotPrefix) {
      return;
    }
    String str;
    do
    {
      str = this.lin.readLine();
      if (str == null) {
        throw new IOException("UUDecoder error: No Begin");
      }
    } while (!str.regionMatches(true, 0, "begin", 0, 5));
    try
    {
      this.mode = Integer.parseInt(str.substring(6, 9));
      this.name = str.substring(10);
      this.gotPrefix = true;
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      throw new IOException("UUDecoder error: " + localNumberFormatException.toString());
    }
  }
  
  public int available()
    throws IOException
  {
    return this.in.available() * 3 / 4 + (this.bufsize - this.index);
  }
  
  public int getMode()
    throws IOException
  {
    readPrefix();
    return this.mode;
  }
  
  public String getName()
    throws IOException
  {
    readPrefix();
    return this.name;
  }
  
  public boolean markSupported()
  {
    return false;
  }
  
  public int read()
    throws IOException
  {
    if (this.index >= this.bufsize)
    {
      readPrefix();
      if (!decode()) {
        return -1;
      }
      this.index = 0;
    }
    byte[] arrayOfByte = this.buffer;
    int i = this.index;
    this.index = (i + 1);
    return arrayOfByte[i] & 0xFF;
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    int i = 0;
    while (i < paramInt2)
    {
      int j = read();
      if (j == -1)
      {
        if (i != 0) {
          break;
        }
        return -1;
      }
      paramArrayOfByte[(paramInt1 + i)] = ((byte)j);
      i += 1;
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.util.stream.UUDecoderStream
 * JD-Core Version:    0.7.0.1
 */