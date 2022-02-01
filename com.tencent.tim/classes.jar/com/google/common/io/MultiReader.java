package com.google.common.io;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;
import javax.annotation.Nullable;

@GwtIncompatible
class MultiReader
  extends Reader
{
  private Reader current;
  private final Iterator<? extends CharSource> it;
  
  MultiReader(Iterator<? extends CharSource> paramIterator)
    throws IOException
  {
    this.it = paramIterator;
    advance();
  }
  
  private void advance()
    throws IOException
  {
    close();
    if (this.it.hasNext()) {
      this.current = ((CharSource)this.it.next()).openStream();
    }
  }
  
  public void close()
    throws IOException
  {
    if (this.current != null) {}
    try
    {
      this.current.close();
      return;
    }
    finally
    {
      this.current = null;
    }
  }
  
  public int read(@Nullable char[] paramArrayOfChar, int paramInt1, int paramInt2)
    throws IOException
  {
    if (this.current == null) {
      return -1;
    }
    int i = this.current.read(paramArrayOfChar, paramInt1, paramInt2);
    if (i == -1)
    {
      advance();
      return read(paramArrayOfChar, paramInt1, paramInt2);
    }
    return i;
  }
  
  public boolean ready()
    throws IOException
  {
    return (this.current != null) && (this.current.ready());
  }
  
  public long skip(long paramLong)
    throws IOException
  {
    boolean bool;
    if (paramLong >= 0L)
    {
      bool = true;
      Preconditions.checkArgument(bool, "n is negative");
      if (paramLong <= 0L) {}
    }
    else
    {
      for (;;)
      {
        if (this.current == null) {
          break label59;
        }
        long l = this.current.skip(paramLong);
        if (l > 0L)
        {
          return l;
          bool = false;
          break;
        }
        advance();
      }
    }
    label59:
    return 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.io.MultiReader
 * JD-Core Version:    0.7.0.1
 */