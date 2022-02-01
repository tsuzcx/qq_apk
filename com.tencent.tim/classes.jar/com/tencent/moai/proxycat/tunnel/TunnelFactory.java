package com.tencent.moai.proxycat.tunnel;

import java.io.IOException;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;

public class TunnelFactory
{
  public static LocalTunnel getLocalTunnel(Selector paramSelector, SocketChannel paramSocketChannel)
  {
    return new LocalTunnel(paramSelector, paramSocketChannel);
  }
  
  public static RemoteTunnel getRemoteTunnel(Selector paramSelector)
    throws IOException
  {
    return new RemoteTunnel(paramSelector);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.proxycat.tunnel.TunnelFactory
 * JD-Core Version:    0.7.0.1
 */