package com.tencent.moai.proxycat.udp;

import android.util.Log;
import com.tencent.moai.proxycat.selectable.Readable;
import com.tencent.moai.proxycat.transport.Proxy;
import com.tencent.moai.proxycat.util.IPConfig;
import com.tencent.moai.proxycat.util.Logger;
import java.io.IOException;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.concurrent.TimeUnit;

public class UDPProxy
  extends Proxy<DatagramChannel, UDPSession>
  implements Readable
{
  private static final String TAG = "UdpProxy";
  private static final int UDP_SESSION_MAX_COUNT = 20;
  private static final long UDP_SESSION_TIMEOUT_MS = TimeUnit.SECONDS.toMillis(30L);
  private final ByteBuffer buffer = ByteBuffer.allocate(65535);
  
  public UDPProxy()
    throws IOException
  {
    super(20, UDP_SESSION_TIMEOUT_MS);
  }
  
  public DatagramChannel createChannel(Selector paramSelector)
    throws IOException
  {
    DatagramChannel localDatagramChannel = DatagramChannel.open();
    localDatagramChannel.configureBlocking(false);
    localDatagramChannel.socket().bind(new InetSocketAddress(0));
    localDatagramChannel.register(paramSelector, 1, this);
    return localDatagramChannel;
  }
  
  public UDPSession createSession(int paramInt1, InetAddress paramInetAddress, int paramInt2)
    throws IOException
  {
    return new UDPSession(this, this.selector, paramInt1, paramInetAddress, paramInt2);
  }
  
  public void onReadable(SelectionKey paramSelectionKey)
  {
    this.buffer.clear();
    do
    {
      try
      {
        paramSelectionKey = (InetSocketAddress)((DatagramChannel)paramSelectionKey.channel()).receive(this.buffer);
        if (paramSelectionKey == null) {
          return;
        }
      }
      catch (IOException paramSelectionKey)
      {
        Logger.e("UdpProxy", Log.getStackTraceString(paramSelectionKey));
        return;
      }
      paramSelectionKey = (UDPSession)getSession(paramSelectionKey.getPort());
    } while (paramSelectionKey == null);
    Logger.d("UdpProxy", "Accepted from vpn " + paramSelectionKey.getSourcePort() + " remote:" + paramSelectionKey.getRemoteAddress() + ":" + paramSelectionKey.getRemotePort());
    this.buffer.flip();
    try
    {
      paramSelectionKey.send(this.buffer);
      return;
    }
    catch (IOException localIOException)
    {
      Logger.e("UdpProxy", Log.getStackTraceString(localIOException));
      finishSession(paramSelectionKey.getSourcePort());
    }
  }
  
  public UDPSession pickSession(int paramInt1, InetAddress paramInetAddress, int paramInt2)
    throws IOException
  {
    return (UDPSession)super.pickSession(paramInt1, paramInetAddress, paramInt2);
  }
  
  public int port()
  {
    return ((DatagramChannel)this.localServerChannel).socket().getLocalPort();
  }
  
  public void receive(DatagramChannel paramDatagramChannel, UDPSession paramUDPSession)
  {
    this.buffer.clear();
    try
    {
      paramDatagramChannel.receive(this.buffer);
      this.buffer.flip();
      return;
    }
    catch (IOException paramDatagramChannel)
    {
      try
      {
        paramDatagramChannel = new InetSocketAddress(IPConfig.UDP_TO_VPN_ADDRESS, paramUDPSession.getSourcePort());
        ((DatagramChannel)this.localServerChannel).send(this.buffer, paramDatagramChannel);
        Logger.d("UdpProxy", "Send packet to vpn " + paramUDPSession.getSourcePort());
        paramUDPSession.finish();
        return;
      }
      catch (IOException paramDatagramChannel)
      {
        Logger.e("UdpProxy", Log.getStackTraceString(paramDatagramChannel));
        finishSession(paramUDPSession.getSourcePort());
      }
      paramDatagramChannel = paramDatagramChannel;
      Logger.e("UdpProxy", Log.getStackTraceString(paramDatagramChannel));
      finishSession(paramUDPSession.getSourcePort());
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.proxycat.udp.UDPProxy
 * JD-Core Version:    0.7.0.1
 */