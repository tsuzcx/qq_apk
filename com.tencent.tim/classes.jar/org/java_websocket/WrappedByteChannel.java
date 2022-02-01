package org.java_websocket;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;

public abstract interface WrappedByteChannel
  extends ByteChannel
{
  public abstract boolean isBlocking();
  
  public abstract boolean isNeedRead();
  
  public abstract boolean isNeedWrite();
  
  public abstract int readMore(ByteBuffer paramByteBuffer)
    throws IOException;
  
  public abstract void writeMore()
    throws IOException;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.java_websocket.WrappedByteChannel
 * JD-Core Version:    0.7.0.1
 */