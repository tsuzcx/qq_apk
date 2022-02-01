package com.tencent.moai.mailsdk.protocol.imap.util;

import java.io.CharArrayWriter;
import java.io.IOException;
import java.io.Writer;

public class BASE64MailboxEncoder
{
  private static final char[] pem_array = { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 44 };
  protected byte[] buffer = new byte[4];
  protected int bufsize = 0;
  protected Writer out = null;
  protected boolean started = false;
  
  public BASE64MailboxEncoder(Writer paramWriter)
  {
    this.out = paramWriter;
  }
  
  public static String encode(String paramString)
  {
    int i = 0;
    Object localObject1 = null;
    char[] arrayOfChar = paramString.toCharArray();
    int k = arrayOfChar.length;
    CharArrayWriter localCharArrayWriter = new CharArrayWriter(k);
    int j = 0;
    if (j < k)
    {
      int m = arrayOfChar[j];
      if ((m >= 32) && (m <= 126))
      {
        if (localObject1 != null) {
          localObject1.flush();
        }
        if (m == 38)
        {
          localCharArrayWriter.write(38);
          localCharArrayWriter.write(45);
          i = 1;
        }
      }
      for (;;)
      {
        j += 1;
        break;
        localCharArrayWriter.write(m);
        continue;
        Object localObject2 = localObject1;
        if (localObject1 == null)
        {
          localObject2 = new BASE64MailboxEncoder(localCharArrayWriter);
          i = 1;
        }
        ((BASE64MailboxEncoder)localObject2).write(m);
        localObject1 = localObject2;
      }
    }
    if (localObject1 != null) {
      localObject1.flush();
    }
    if (i != 0) {
      paramString = localCharArrayWriter.toString();
    }
    return paramString;
  }
  
  protected void encode()
    throws IOException
  {
    int i;
    if (this.bufsize == 1)
    {
      i = this.buffer[0];
      this.out.write(pem_array[(i >>> 2 & 0x3F)]);
      this.out.write(pem_array[((i << 4 & 0x30) + 0)]);
    }
    do
    {
      return;
      if (this.bufsize == 2)
      {
        i = this.buffer[0];
        j = this.buffer[1];
        this.out.write(pem_array[(i >>> 2 & 0x3F)]);
        this.out.write(pem_array[((i << 4 & 0x30) + (j >>> 4 & 0xF))]);
        this.out.write(pem_array[((j << 2 & 0x3C) + 0)]);
        return;
      }
      i = this.buffer[0];
      int j = this.buffer[1];
      int k = this.buffer[2];
      this.out.write(pem_array[(i >>> 2 & 0x3F)]);
      this.out.write(pem_array[((i << 4 & 0x30) + (j >>> 4 & 0xF))]);
      this.out.write(pem_array[((j << 2 & 0x3C) + (k >>> 6 & 0x3))]);
      this.out.write(pem_array[(k & 0x3F)]);
    } while (this.bufsize != 4);
    this.buffer[0] = this.buffer[3];
  }
  
  public void flush()
  {
    try
    {
      if (this.bufsize > 0)
      {
        encode();
        this.bufsize = 0;
      }
      if (this.started)
      {
        this.out.write(45);
        this.started = false;
      }
      return;
    }
    catch (IOException localIOException) {}
  }
  
  public void write(int paramInt)
  {
    try
    {
      if (!this.started)
      {
        this.started = true;
        this.out.write(38);
      }
      byte[] arrayOfByte = this.buffer;
      int i = this.bufsize;
      this.bufsize = (i + 1);
      arrayOfByte[i] = ((byte)(paramInt >> 8));
      arrayOfByte = this.buffer;
      i = this.bufsize;
      this.bufsize = (i + 1);
      arrayOfByte[i] = ((byte)(paramInt & 0xFF));
      if (this.bufsize >= 3)
      {
        encode();
        this.bufsize -= 3;
      }
      return;
    }
    catch (IOException localIOException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.protocol.imap.util.BASE64MailboxEncoder
 * JD-Core Version:    0.7.0.1
 */