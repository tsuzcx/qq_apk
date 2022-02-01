package com.tencent.moai.mailsdk.util.stream;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class QPEncoderStream
  extends FilterOutputStream
{
  private static final char[] hex = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70 };
  private int bytesPerLine;
  private int count = 0;
  private boolean gotCR = false;
  private boolean gotSpace = false;
  
  public QPEncoderStream(OutputStream paramOutputStream)
  {
    this(paramOutputStream, 76);
  }
  
  public QPEncoderStream(OutputStream paramOutputStream, int paramInt)
  {
    super(paramOutputStream);
    this.bytesPerLine = (paramInt - 1);
  }
  
  private void outputCRLF()
    throws IOException
  {
    this.out.write(13);
    this.out.write(10);
    this.count = 0;
  }
  
  public void close()
    throws IOException
  {
    this.out.close();
  }
  
  public void flush()
    throws IOException
  {
    this.out.flush();
  }
  
  protected void output(int paramInt, boolean paramBoolean)
    throws IOException
  {
    if (paramBoolean)
    {
      i = this.count + 3;
      this.count = i;
      if (i > this.bytesPerLine)
      {
        this.out.write(61);
        this.out.write(13);
        this.out.write(10);
        this.count = 3;
      }
      this.out.write(61);
      this.out.write(hex[(paramInt >> 4)]);
      this.out.write(hex[(paramInt & 0xF)]);
      return;
    }
    int i = this.count + 1;
    this.count = i;
    if (i > this.bytesPerLine)
    {
      this.out.write(61);
      this.out.write(13);
      this.out.write(10);
      this.count = 1;
    }
    this.out.write(paramInt);
  }
  
  public void write(int paramInt)
    throws IOException
  {
    paramInt &= 0xFF;
    if (this.gotSpace)
    {
      if ((paramInt != 13) && (paramInt != 10)) {
        break label53;
      }
      output(32, true);
    }
    for (;;)
    {
      this.gotSpace = false;
      if (paramInt != 13) {
        break;
      }
      this.gotCR = true;
      outputCRLF();
      return;
      label53:
      output(32, false);
    }
    if (paramInt == 10) {
      if (!this.gotCR) {}
    }
    for (;;)
    {
      this.gotCR = false;
      return;
      outputCRLF();
      continue;
      if (paramInt == 32) {
        this.gotSpace = true;
      } else if ((paramInt < 32) || (paramInt >= 127) || (paramInt == 61)) {
        output(paramInt, true);
      } else {
        output(paramInt, false);
      }
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
 * Qualified Name:     com.tencent.moai.mailsdk.util.stream.QPEncoderStream
 * JD-Core Version:    0.7.0.1
 */