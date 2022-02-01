package com.tencent.moai.proxycat.udp;

import android.util.Log;
import com.tencent.moai.proxycat.selectable.Readable;
import com.tencent.moai.proxycat.transport.Session;
import com.tencent.moai.proxycat.util.Logger;
import java.io.IOException;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;

public class UDPSession
  extends Session
  implements Readable
{
  private static final String TAG = "UdpProxySession";
  private final DatagramChannel serverChannel;
  private final UDPProxy udpProxy;
  
  public UDPSession(UDPProxy paramUDPProxy, Selector paramSelector, int paramInt1, InetAddress paramInetAddress, int paramInt2)
    throws IOException
  {
    super(paramSelector, paramInt1, paramInetAddress, paramInt2);
    this.udpProxy = paramUDPProxy;
    this.serverChannel = DatagramChannel.open();
    this.serverChannel.configureBlocking(false);
    this.serverChannel.socket().bind(new InetSocketAddress(0));
  }
  
  public void finish()
  {
    try
    {
      this.serverChannel.close();
      return;
    }
    catch (IOException localIOException)
    {
      Logger.e("UdpProxySession", Log.getStackTraceString(localIOException));
    }
  }
  
  public void onReadable(SelectionKey paramSelectionKey)
  {
    this.udpProxy.receive((DatagramChannel)paramSelectionKey.channel(), this);
    Logger.d("UdpProxySession", "Receive packet from remote " + socket().getLocalAddress() + ":" + socket().getLocalPort());
  }
  
  public void send(ByteBuffer paramByteBuffer)
    throws IOException
  {
    this.serverChannel.register(this.selector, 1, this);
    this.serverChannel.send(paramByteBuffer, new InetSocketAddress(getRemoteAddress(), getRemotePort()));
    Logger.d("UdpProxySession", "Send packet to remote " + getRemoteAddress() + ":" + getRemotePort());
  }
  
  public DatagramSocket socket()
  {
    return this.serverChannel.socket();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.proxycat.udp.UDPSession
 * JD-Core Version:    0.7.0.1
 */