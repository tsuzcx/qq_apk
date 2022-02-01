package com.tencent.token;

import java.io.Closeable;
import java.io.Flushable;

public final class ajq
  implements Closeable, Flushable
{
  final aky a;
  final akx b;
  
  public final void close()
  {
    this.b.close();
  }
  
  public final void flush()
  {
    this.b.flush();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ajq
 * JD-Core Version:    0.7.0.1
 */