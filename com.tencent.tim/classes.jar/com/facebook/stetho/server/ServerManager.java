package com.facebook.stetho.server;

public class ServerManager
{
  private static final String THREAD_PREFIX = "StethoListener";
  private final LocalSocketServer mServer;
  private volatile boolean mStarted;
  
  public ServerManager(LocalSocketServer paramLocalSocketServer)
  {
    this.mServer = paramLocalSocketServer;
  }
  
  private void startServer(LocalSocketServer paramLocalSocketServer)
  {
    new ServerManager.1(this, "StethoListener-" + paramLocalSocketServer.getName(), paramLocalSocketServer).start();
  }
  
  public void start()
  {
    if (this.mStarted) {
      throw new IllegalStateException("Already started");
    }
    this.mStarted = true;
    startServer(this.mServer);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.facebook.stetho.server.ServerManager
 * JD-Core Version:    0.7.0.1
 */