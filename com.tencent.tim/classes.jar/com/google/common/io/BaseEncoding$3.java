package com.google.common.io;

import com.google.common.base.CharMatcher;
import java.io.IOException;
import java.io.Reader;

final class BaseEncoding$3
  extends Reader
{
  BaseEncoding$3(Reader paramReader, CharMatcher paramCharMatcher) {}
  
  public void close()
    throws IOException
  {
    this.val$delegate.close();
  }
  
  public int read()
    throws IOException
  {
    int i;
    do
    {
      i = this.val$delegate.read();
    } while ((i != -1) && (this.val$toIgnore.matches((char)i)));
    return i;
  }
  
  public int read(char[] paramArrayOfChar, int paramInt1, int paramInt2)
    throws IOException
  {
    throw new UnsupportedOperationException();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.io.BaseEncoding.3
 * JD-Core Version:    0.7.0.1
 */