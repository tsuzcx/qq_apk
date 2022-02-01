package com.tencent.token;

import java.io.Closeable;
import java.io.Flushable;

public final class aht
  implements Closeable, Flushable
{
  final ajb a;
  final aja b;
  
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
 * Qualified Name:     com.tencent.token.aht
 * JD-Core Version:    0.7.0.1
 */