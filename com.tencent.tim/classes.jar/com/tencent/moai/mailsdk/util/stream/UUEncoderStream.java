package com.tencent.moai.mailsdk.util.stream;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

public class UUEncoderStream
  extends FilterOutputStream
{
  private byte[] buffer;
  private int bufsize = 0;
  protected int mode;
  protected String name;
  private boolean wrotePrefix = false;
  
  public UUEncoderStream(OutputStream paramOutputStream)
  {
    this(paramOutputStream, "encoder.buf", 644);
  }
  
  public UUEncoderStream(OutputStream paramOutputStream, String paramString)
  {
    this(paramOutputStream, paramString, 644);
  }
  
  public UUEncoderStream(OutputStream paramOutputStream, String paramString, int paramInt)
  {
    super(paramOutputStream);
    this.name = paramString;
    this.mode = paramInt;
    this.buffer = new byte[45];
  }
  
  private void encode()
    throws IOException
  {
    int i = 0;
    this.out.write((this.bufsize & 0x3F) + 32);
    if (i < this.bufsize)
    {
      byte[] arrayOfByte = this.buffer;
      int j = i + 1;
      int m = arrayOfByte[i];
      int k;
      if (j < this.bufsize)
      {
        arrayOfByte = this.buffer;
        i = j + 1;
        k = arrayOfByte[j];
        if (i < this.bufsize)
        {
          j = this.buffer[i];
          i += 1;
        }
      }
      for (;;)
      {
        this.out.write((m >>> 2 & 0x3F) + 32);
        this.out.write((m << 4 & 0x30 | k >>> 4 & 0xF) + 32);
        this.out.write((k << 2 & 0x3C | j >>> 6 & 0x3) + 32);
        this.out.write((j & 0x3F) + 32);
        break;
        j = 1;
        continue;
        k = 1;
        i = j;
        j = 1;
      }
    }
    this.out.write(10);
  }
  
  private void writePrefix()
    throws IOException
  {
    if (!this.wrotePrefix)
    {
      PrintStream localPrintStream = new PrintStream(this.out);
      localPrintStream.println("begin " + this.mode + " " + this.name);
      localPrintStream.flush();
      this.wrotePrefix = true;
    }
  }
  
  private void writeSuffix()
    throws IOException
  {
    PrintStream localPrintStream = new PrintStream(this.out);
    localPrintStream.println(" \nend");
    localPrintStream.flush();
  }
  
  public void close()
    throws IOException
  {
    flush();
    this.out.close();
  }
  
  public void flush()
    throws IOException
  {
    if (this.bufsize > 0)
    {
      writePrefix();
      encode();
    }
    writeSuffix();
    this.out.flush();
  }
  
  public void setNameMode(String paramString, int paramInt)
  {
    this.name = paramString;
    this.mode = paramInt;
  }
  
  public void write(int paramInt)
    throws IOException
  {
    byte[] arrayOfByte = this.buffer;
    int i = this.bufsize;
    this.bufsize = (i + 1);
    arrayOfByte[i] = ((byte)paramInt);
    if (this.bufsize == 45)
    {
      writePrefix();
      encode();
      this.bufsize = 0;
    }
  }
  
  public void write(byte[] paramArrayOfByte)
    throws IOException
  {
    write(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    int i = 0;
    while (i < paramInt2)
    {
      write(paramArrayOfByte[(paramInt1 + i)]);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.util.stream.UUEncoderStream
 * JD-Core Version:    0.7.0.1
 */