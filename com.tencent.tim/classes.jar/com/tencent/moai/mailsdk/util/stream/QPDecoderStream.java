package com.tencent.moai.mailsdk.util.stream;

import com.tencent.moai.mailsdk.util.ASCIIUtility;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;

public class QPDecoderStream
  extends FilterInputStream
{
  protected byte[] ba = new byte[2];
  protected int spaces = 0;
  
  public QPDecoderStream(InputStream paramInputStream)
  {
    super(new PushbackInputStream(paramInputStream, 2));
  }
  
  public int available()
    throws IOException
  {
    return this.in.available();
  }
  
  public boolean markSupported()
  {
    return false;
  }
  
  public int read()
    throws IOException
  {
    if (this.spaces > 0)
    {
      this.spaces -= 1;
      return 32;
    }
    int i = this.in.read();
    if (i == 32)
    {
      for (;;)
      {
        i = this.in.read();
        if (i != 32) {
          break;
        }
        this.spaces += 1;
      }
      if ((i == 13) || (i == 10) || (i == -1)) {
        this.spaces = 0;
      }
      for (;;)
      {
        return i;
        ((PushbackInputStream)this.in).unread(i);
        i = 32;
      }
    }
    if (i == 61)
    {
      int j = this.in.read();
      if (j == 10) {
        return read();
      }
      if (j == 13)
      {
        i = this.in.read();
        if (i != 10) {
          ((PushbackInputStream)this.in).unread(i);
        }
        return read();
      }
      if (j == -1) {
        return -1;
      }
      this.ba[0] = ((byte)j);
      this.ba[1] = ((byte)this.in.read());
      try
      {
        j = ASCIIUtility.parseInt(this.ba, 0, 2, 16);
        return j;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        ((PushbackInputStream)this.in).unread(this.ba);
        return i;
      }
    }
    return i;
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
 * Qualified Name:     com.tencent.moai.mailsdk.util.stream.QPDecoderStream
 * JD-Core Version:    0.7.0.1
 */