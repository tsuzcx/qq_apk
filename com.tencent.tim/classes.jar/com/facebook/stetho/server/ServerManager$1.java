package com.facebook.stetho.server;

import com.facebook.stetho.common.LogUtil;
import java.io.IOException;

class ServerManager$1
  extends Thread
{
  ServerManager$1(ServerManager paramServerManager, String paramString, LocalSocketServer paramLocalSocketServer)
  {
    super(paramString);
  }
  
  public void run()
  {
    try
    {
      this.val$server.run();
      return;
    }
    catch (IOException localIOException)
    {
      LogUtil.e(localIOException, "Could not start Stetho server: %s", new Object[] { this.val$server.getName() });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.facebook.stetho.server.ServerManager.1
 * JD-Core Version:    0.7.0.1
 */