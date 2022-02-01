package com.tencent.moai.proxycat.tunnel;

import com.tencent.moai.proxycat.util.Logger;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;

public class LocalTunnel
  extends Tunnel
{
  private static final String TAG = "LocalTunnel";
  
  public LocalTunnel(Selector paramSelector, SocketChannel paramSocketChannel)
  {
    super(paramSelector, paramSocketChannel);
  }
  
  protected ByteBuffer afterReceiving(ByteBuffer paramByteBuffer)
  {
    Logger.d("LocalTunnel", "afterReceiving:" + this.channel.socket().getLocalAddress());
    return paramByteBuffer;
  }
  
  protected void afterRemaining()
  {
    Logger.d("LocalTunnel", "afterRemaining:" + this.channel.socket().getLocalAddress());
  }
  
  protected void afterSending()
  {
    Logger.d("LocalTunnel", "after:" + this.channel.socket().getLocalAddress());
  }
  
  protected void beforeReceiving()
  {
    Logger.d("LocalTunnel", "beforeReceiving:" + this.channel.socket().getLocalAddress());
  }
  
  protected void beforeRemaining()
  {
    Logger.d("LocalTunnel", "beforeRemaining:" + this.channel.socket().getLocalAddress());
  }
  
  protected ByteBuffer beforeSending(ByteBuffer paramByteBuffer)
  {
    Logger.d("LocalTunnel", "beforeSending:" + this.channel.socket().getLocalAddress());
    return paramByteBuffer;
  }
  
  protected void onClose()
  {
    Logger.d("LocalTunnel", "onClose:" + this.channel.socket().getLocalAddress());
  }
  
  protected void onConnected()
  {
    Logger.d("LocalTunnel", "onConnected:" + this.channel.socket().getLocalAddress());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.proxycat.tunnel.LocalTunnel
 * JD-Core Version:    0.7.0.1
 */