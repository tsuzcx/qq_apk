package com.google.common.io;

import java.io.IOException;
import java.io.Writer;

final class BaseEncoding$5
  extends Writer
{
  BaseEncoding$5(Appendable paramAppendable, Writer paramWriter) {}
  
  public void close()
    throws IOException
  {
    this.val$delegate.close();
  }
  
  public void flush()
    throws IOException
  {
    this.val$delegate.flush();
  }
  
  public void write(int paramInt)
    throws IOException
  {
    this.val$seperatingAppendable.append((char)paramInt);
  }
  
  public void write(char[] paramArrayOfChar, int paramInt1, int paramInt2)
    throws IOException
  {
    throw new UnsupportedOperationException();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.io.BaseEncoding.5
 * JD-Core Version:    0.7.0.1
 */