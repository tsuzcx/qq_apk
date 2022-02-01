package com.tencent.moai.mailsdk.util.stream;

import java.io.IOException;
import java.io.OutputStream;

public class SMTPOutputStream
  extends CRLFOutputStream
{
  public SMTPOutputStream(OutputStream paramOutputStream)
  {
    super(paramOutputStream);
  }
  
  public void ensureAtBOL()
    throws IOException
  {
    if (!this.atBOL) {
      super.writeln();
    }
  }
  
  public void flush() {}
  
  public void write(int paramInt)
    throws IOException
  {
    if (((this.lastb == 10) || (this.lastb == 13) || (this.lastb == -1)) && (paramInt == 46)) {
      this.out.write(46);
    }
    super.write(paramInt);
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    if (this.lastb == -1) {}
    int k;
    for (int i = 10;; i = this.lastb)
    {
      k = paramInt2 + paramInt1;
      paramInt2 = paramInt1;
      int j = paramInt1;
      paramInt1 = paramInt2;
      for (paramInt2 = j; paramInt1 < k; paramInt2 = j)
      {
        if (i != 10)
        {
          j = paramInt2;
          if (i != 13) {}
        }
        else
        {
          j = paramInt2;
          if (paramArrayOfByte[paramInt1] == 46)
          {
            super.write(paramArrayOfByte, paramInt2, paramInt1 - paramInt2);
            this.out.write(46);
            j = paramInt1;
          }
        }
        i = paramArrayOfByte[paramInt1];
        paramInt1 += 1;
      }
    }
    if (k - paramInt2 > 0) {
      super.write(paramArrayOfByte, paramInt2, k - paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.util.stream.SMTPOutputStream
 * JD-Core Version:    0.7.0.1
 */