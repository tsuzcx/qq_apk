package com.tencent.moai.mailsdk.util.stream;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class CRLFOutputStream
  extends FilterOutputStream
{
  private static final byte[] newline = { 13, 10 };
  protected boolean atBOL = true;
  protected int lastb = -1;
  
  public CRLFOutputStream(OutputStream paramOutputStream)
  {
    super(paramOutputStream);
  }
  
  public void write(int paramInt)
    throws IOException
  {
    if (paramInt == 13) {
      writeln();
    }
    for (;;)
    {
      this.lastb = paramInt;
      return;
      if (paramInt == 10)
      {
        if (this.lastb != 13) {
          writeln();
        }
      }
      else
      {
        this.out.write(paramInt);
        this.atBOL = false;
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
    int j = paramInt2 + paramInt1;
    int i = paramInt1;
    paramInt2 = paramInt1;
    if (paramInt2 < j)
    {
      if (paramArrayOfByte[paramInt2] == 13)
      {
        this.out.write(paramArrayOfByte, i, paramInt2 - i);
        writeln();
        paramInt1 = paramInt2 + 1;
      }
      for (;;)
      {
        this.lastb = paramArrayOfByte[paramInt2];
        paramInt2 += 1;
        i = paramInt1;
        break;
        paramInt1 = i;
        if (paramArrayOfByte[paramInt2] == 10)
        {
          if (this.lastb != 13)
          {
            this.out.write(paramArrayOfByte, i, paramInt2 - i);
            writeln();
          }
          paramInt1 = paramInt2 + 1;
        }
      }
    }
    if (j - i > 0)
    {
      this.out.write(paramArrayOfByte, i, j - i);
      this.atBOL = false;
    }
  }
  
  public void writeln()
    throws IOException
  {
    this.out.write(newline);
    this.atBOL = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.util.stream.CRLFOutputStream
 * JD-Core Version:    0.7.0.1
 */