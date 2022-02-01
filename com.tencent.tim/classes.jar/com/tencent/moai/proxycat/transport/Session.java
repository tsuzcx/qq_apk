package com.tencent.moai.proxycat.transport;

import java.net.InetAddress;
import java.nio.channels.Selector;

public abstract class Session
{
  private volatile boolean finish = false;
  long lastActive = System.currentTimeMillis();
  private final InetAddress remoteAddress;
  private final int remotePort;
  protected final Selector selector;
  private final int sourcePort;
  
  public Session(Selector paramSelector, int paramInt1, InetAddress paramInetAddress, int paramInt2)
  {
    this.selector = paramSelector;
    this.sourcePort = paramInt1;
    this.remoteAddress = paramInetAddress;
    this.remotePort = paramInt2;
  }
  
  public void active()
  {
    this.lastActive = System.currentTimeMillis();
  }
  
  public void finish()
  {
    this.finish = true;
  }
  
  public InetAddress getRemoteAddress()
  {
    return this.remoteAddress;
  }
  
  public int getRemotePort()
  {
    return this.remotePort;
  }
  
  public int getSourcePort()
  {
    return this.sourcePort;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.proxycat.transport.Session
 * JD-Core Version:    0.7.0.1
 */