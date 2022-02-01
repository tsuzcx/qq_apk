package com.tencent.moai.proxycat.tcp;

import android.util.Log;
import com.tencent.moai.proxycat.selectable.Acceptable;
import com.tencent.moai.proxycat.transport.Proxy;
import com.tencent.moai.proxycat.util.Logger;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.concurrent.TimeUnit;

public class TCPProxy
  extends Proxy<ServerSocketChannel, TCPSession>
  implements Acceptable
{
  private static final String TAG = "TCPProxy";
  private static final int TCP_SESSION_MAX_COUNT = 60;
  private static final long TCP_SESSION_TIMEOUT_MS = TimeUnit.SECONDS.toMillis(60L);
  
  public TCPProxy()
  {
    super(60, TCP_SESSION_TIMEOUT_MS);
  }
  
  private void beginTunnel(SocketChannel paramSocketChannel)
  {
    ((TCPSession)getSession(paramSocketChannel.socket().getPort())).begin(paramSocketChannel);
  }
  
  public ServerSocketChannel createChannel(Selector paramSelector)
    throws IOException
  {
    ServerSocketChannel localServerSocketChannel = ServerSocketChannel.open();
    localServerSocketChannel.configureBlocking(false);
    localServerSocketChannel.socket().bind(new InetSocketAddress(0));
    localServerSocketChannel.register(paramSelector, 16, this);
    return localServerSocketChannel;
  }
  
  public TCPSession createSession(int paramInt1, InetAddress paramInetAddress, int paramInt2)
    throws IOException
  {
    return new TCPSession(this.selector, paramInt1, paramInetAddress, paramInt2);
  }
  
  public void onAcceptable(SelectionKey paramSelectionKey)
  {
    try
    {
      paramSelectionKey = ((ServerSocketChannel)this.localServerChannel).accept();
      beginTunnel(paramSelectionKey);
      return;
    }
    catch (IOException paramSelectionKey)
    {
      Logger.e("TCPProxy", Log.getStackTraceString(paramSelectionKey));
    }
  }
  
  public TCPSession pickSession(int paramInt1, InetAddress paramInetAddress, int paramInt2)
    throws IOException
  {
    TCPSession localTCPSession2 = (TCPSession)getSession(paramInt1);
    TCPSession localTCPSession1;
    if ((localTCPSession2 != null) && (localTCPSession2.getRemoteAddress().equals(paramInetAddress)))
    {
      localTCPSession1 = localTCPSession2;
      if (localTCPSession2.getRemotePort() == paramInt2) {}
    }
    else
    {
      localTCPSession1 = (TCPSession)super.pickSession(paramInt1, paramInetAddress, paramInt2);
    }
    return localTCPSession1;
  }
  
  public int port()
  {
    return ((ServerSocketChannel)this.localServerChannel).socket().getLocalPort();
  }
  
  public boolean shouldRecycleSession(TCPSession paramTCPSession)
  {
    return (super.shouldRecycleSession(paramTCPSession)) && (!paramTCPSession.isAccepted());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.proxycat.tcp.TCPProxy
 * JD-Core Version:    0.7.0.1
 */