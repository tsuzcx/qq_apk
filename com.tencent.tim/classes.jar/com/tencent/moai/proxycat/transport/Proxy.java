package com.tencent.moai.proxycat.transport;

import java.io.IOException;
import java.net.InetAddress;
import java.nio.channels.SelectableChannel;
import java.nio.channels.Selector;

public abstract class Proxy<C extends SelectableChannel, S extends Session>
{
  protected C localServerChannel;
  protected Selector selector;
  private final long sessionTimeout;
  private final SessionMap<S> sessions;
  
  public Proxy(int paramInt, long paramLong)
  {
    this.sessionTimeout = paramLong;
    this.sessions = new Proxy.1(this, paramInt);
  }
  
  public void close()
    throws IOException
  {
    this.sessions.clear();
    this.localServerChannel.close();
  }
  
  public abstract C createChannel(Selector paramSelector)
    throws IOException;
  
  public abstract S createSession(int paramInt1, InetAddress paramInetAddress, int paramInt2)
    throws IOException;
  
  public S finishSession(int paramInt)
  {
    Session localSession = (Session)this.sessions.get(paramInt);
    this.sessions.remove(paramInt);
    return localSession;
  }
  
  public S getSession(int paramInt)
  {
    return (Session)this.sessions.get(paramInt);
  }
  
  public boolean isRunning()
  {
    return this.localServerChannel.isOpen();
  }
  
  public S pickSession(int paramInt1, InetAddress paramInetAddress, int paramInt2)
    throws IOException
  {
    paramInetAddress = createSession(paramInt1, paramInetAddress, paramInt2);
    this.sessions.put(paramInt1, paramInetAddress);
    return paramInetAddress;
  }
  
  public abstract int port();
  
  public boolean shouldRecycleSession(S paramS)
  {
    return System.currentTimeMillis() - paramS.lastActive >= this.sessionTimeout;
  }
  
  public void start(Selector paramSelector)
    throws IOException
  {
    this.selector = paramSelector;
    this.localServerChannel = createChannel(paramSelector);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.proxycat.transport.Proxy
 * JD-Core Version:    0.7.0.1
 */