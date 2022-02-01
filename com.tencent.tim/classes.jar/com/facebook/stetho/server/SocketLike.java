package com.facebook.stetho.server;

import android.net.LocalSocket;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class SocketLike
{
  private final LeakyBufferedInputStream mLeakyInput;
  private final LocalSocket mSocket;
  
  public SocketLike(LocalSocket paramLocalSocket, LeakyBufferedInputStream paramLeakyBufferedInputStream)
  {
    this.mSocket = paramLocalSocket;
    this.mLeakyInput = paramLeakyBufferedInputStream;
  }
  
  public SocketLike(SocketLike paramSocketLike, LeakyBufferedInputStream paramLeakyBufferedInputStream)
  {
    this(paramSocketLike.mSocket, paramLeakyBufferedInputStream);
  }
  
  public InputStream getInput()
    throws IOException
  {
    return this.mLeakyInput.leakBufferAndStream();
  }
  
  public OutputStream getOutput()
    throws IOException
  {
    return this.mSocket.getOutputStream();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.facebook.stetho.server.SocketLike
 * JD-Core Version:    0.7.0.1
 */