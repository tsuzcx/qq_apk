package com.tencent.android.tpns.mqtt.internal.wire;

import java.io.IOException;
import java.io.InputStream;

public class CountingInputStream
  extends InputStream
{
  private int counter;
  private InputStream in;
  
  public CountingInputStream(InputStream paramInputStream)
  {
    this.in = paramInputStream;
    this.counter = 0;
  }
  
  public int getCounter()
  {
    return this.counter;
  }
  
  public int read()
    throws IOException
  {
    int i = this.in.read();
    if (i != -1) {
      this.counter += 1;
    }
    return i;
  }
  
  public void resetCounter()
  {
    this.counter = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpns.mqtt.internal.wire.CountingInputStream
 * JD-Core Version:    0.7.0.1
 */