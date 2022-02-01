package com.tencent.moai.mailsdk.util.stream;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;

public class LineInputStream
  extends FilterInputStream
{
  private char[] lineBuffer = null;
  
  public LineInputStream(InputStream paramInputStream)
  {
    super(paramInputStream);
  }
  
  public String readLine()
    throws IOException
  {
    Object localObject = this.in;
    char[] arrayOfChar2 = this.lineBuffer;
    char[] arrayOfChar1 = arrayOfChar2;
    if (arrayOfChar2 == null)
    {
      arrayOfChar1 = new char[''];
      this.lineBuffer = arrayOfChar1;
    }
    int i = arrayOfChar1.length;
    int j = 0;
    int k = ((InputStream)localObject).read();
    if ((k == -1) || (k == 10)) {}
    label57:
    label205:
    label206:
    for (;;)
    {
      if ((k == -1) && (j == 0))
      {
        return null;
        if (k == 13)
        {
          i = ((InputStream)localObject).read();
          if (i != 13) {
            break label205;
          }
          i = ((InputStream)localObject).read();
        }
      }
      for (;;)
      {
        if (i == 10) {
          break label206;
        }
        if (!(localObject instanceof PushbackInputStream))
        {
          localObject = new PushbackInputStream((InputStream)localObject);
          this.in = ((InputStream)localObject);
        }
        for (;;)
        {
          ((PushbackInputStream)localObject).unread(i);
          break label57;
          i -= 1;
          if (i < 0)
          {
            arrayOfChar1 = new char[j + 128];
            i = arrayOfChar1.length - j - 1;
            System.arraycopy(this.lineBuffer, 0, arrayOfChar1, 0, j);
            this.lineBuffer = arrayOfChar1;
          }
          for (;;)
          {
            arrayOfChar1[j] = ((char)k);
            j += 1;
            break;
            return String.copyValueOf(arrayOfChar1, 0, j);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.util.stream.LineInputStream
 * JD-Core Version:    0.7.0.1
 */