package com.facebook.stetho.websocket;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
class WriteHandler
{
  private final BufferedOutputStream mBufferedOutput;
  
  public WriteHandler(OutputStream paramOutputStream)
  {
    this.mBufferedOutput = new BufferedOutputStream(paramOutputStream, 1024);
  }
  
  public void write(Frame paramFrame, WriteCallback paramWriteCallback)
  {
    try
    {
      paramFrame.writeTo(this.mBufferedOutput);
      this.mBufferedOutput.flush();
      paramWriteCallback.onSuccess();
      return;
    }
    catch (IOException paramFrame)
    {
      for (;;)
      {
        paramWriteCallback.onFailure(paramFrame);
      }
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.facebook.stetho.websocket.WriteHandler
 * JD-Core Version:    0.7.0.1
 */