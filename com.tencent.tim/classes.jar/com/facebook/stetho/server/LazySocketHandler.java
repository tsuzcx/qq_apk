package com.facebook.stetho.server;

import android.net.LocalSocket;
import java.io.IOException;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class LazySocketHandler
  implements SocketHandler
{
  @Nullable
  private SocketHandler mSocketHandler;
  private final SocketHandlerFactory mSocketHandlerFactory;
  
  public LazySocketHandler(SocketHandlerFactory paramSocketHandlerFactory)
  {
    this.mSocketHandlerFactory = paramSocketHandlerFactory;
  }
  
  @Nonnull
  private SocketHandler getSocketHandler()
  {
    try
    {
      if (this.mSocketHandler == null) {
        this.mSocketHandler = this.mSocketHandlerFactory.create();
      }
      SocketHandler localSocketHandler = this.mSocketHandler;
      return localSocketHandler;
    }
    finally {}
  }
  
  public void onAccepted(LocalSocket paramLocalSocket)
    throws IOException
  {
    getSocketHandler().onAccepted(paramLocalSocket);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.facebook.stetho.server.LazySocketHandler
 * JD-Core Version:    0.7.0.1
 */