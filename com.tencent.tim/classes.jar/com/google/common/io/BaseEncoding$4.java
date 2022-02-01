package com.google.common.io;

import java.io.IOException;

final class BaseEncoding$4
  implements Appendable
{
  int charsUntilSeparator = this.val$afterEveryChars;
  
  BaseEncoding$4(int paramInt, Appendable paramAppendable, String paramString) {}
  
  public Appendable append(char paramChar)
    throws IOException
  {
    if (this.charsUntilSeparator == 0)
    {
      this.val$delegate.append(this.val$separator);
      this.charsUntilSeparator = this.val$afterEveryChars;
    }
    this.val$delegate.append(paramChar);
    this.charsUntilSeparator -= 1;
    return this;
  }
  
  public Appendable append(CharSequence paramCharSequence)
    throws IOException
  {
    throw new UnsupportedOperationException();
  }
  
  public Appendable append(CharSequence paramCharSequence, int paramInt1, int paramInt2)
    throws IOException
  {
    throw new UnsupportedOperationException();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.io.BaseEncoding.4
 * JD-Core Version:    0.7.0.1
 */