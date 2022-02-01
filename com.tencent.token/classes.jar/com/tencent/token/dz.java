package com.tencent.token;

import java.io.Writer;

public final class dz
  extends Writer
{
  private final String a;
  private StringBuilder b = new StringBuilder(128);
  
  public dz(String paramString)
  {
    this.a = paramString;
  }
  
  private void a()
  {
    if (this.b.length() > 0)
    {
      StringBuilder localStringBuilder = this.b;
      localStringBuilder.delete(0, localStringBuilder.length());
    }
  }
  
  public final void close()
  {
    a();
  }
  
  public final void flush()
  {
    a();
  }
  
  public final void write(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    int i = 0;
    while (i < paramInt2)
    {
      char c = paramArrayOfChar[(paramInt1 + i)];
      if (c == '\n') {
        a();
      } else {
        this.b.append(c);
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.dz
 * JD-Core Version:    0.7.0.1
 */