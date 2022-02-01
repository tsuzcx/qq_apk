package com.tencent.token;

import java.io.Closeable;
import java.io.Flushable;

public final class ahu
  implements Closeable, Flushable
{
  final ajc a;
  final ajb b;
  
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
 * Qualified Name:     com.tencent.token.ahu
 * JD-Core Version:    0.7.0.1
 */