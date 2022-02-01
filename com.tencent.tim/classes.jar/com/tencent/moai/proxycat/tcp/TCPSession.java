package com.tencent.moai.proxycat.tcp;

import android.util.Log;
import com.tencent.moai.proxycat.ProxyVPNService;
import com.tencent.moai.proxycat.transport.Session;
import com.tencent.moai.proxycat.tunnel.LocalTunnel;
import com.tencent.moai.proxycat.tunnel.RemoteTunnel;
import com.tencent.moai.proxycat.tunnel.TunnelFactory;
import com.tencent.moai.proxycat.util.Logger;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;

public class TCPSession
  extends Session
{
  private static final String TAG = "TcpProxySession";
  private volatile boolean accepted;
  private LocalTunnel localTunnel;
  private InetAddress originalRemoteAddress;
  private int originalRemotePort;
  private RemoteTunnel remoteTunnel;
  
  public TCPSession(Selector paramSelector, int paramInt1, InetAddress paramInetAddress, int paramInt2)
  {
    super(paramSelector, paramInt1, paramInetAddress, paramInt2);
  }
  
  public void begin(SocketChannel paramSocketChannel)
  {
    this.accepted = true;
    try
    {
      this.localTunnel = TunnelFactory.getLocalTunnel(this.selector, paramSocketChannel);
      this.remoteTunnel = TunnelFactory.getRemoteTunnel(this.selector);
      this.localTunnel.setBrother(this.remoteTunnel);
      this.remoteTunnel.setBrother(this.localTunnel);
      if (ProxyVPNService.getInstance().protect(this.remoteTunnel.socket()))
      {
        this.remoteTunnel.setRemoteAddress(new InetSocketAddress(getRemoteAddress(), getRemotePort()));
        this.remoteTunnel.connect();
        return;
      }
    }
    catch (IOException paramSocketChannel)
    {
      Logger.e("TcpProxySession", Log.getStackTraceString(paramSocketChannel));
      finish();
      return;
    }
    finish();
  }
  
  public void finish()
  {
    super.finish();
    if (this.localTunnel != null) {
      this.localTunnel.close();
    }
    if (this.remoteTunnel != null) {
      this.remoteTunnel.close();
    }
  }
  
  public InetAddress getOriginalRemoteAddress()
  {
    return this.originalRemoteAddress;
  }
  
  public int getOriginalRemotePort()
  {
    return this.originalRemotePort;
  }
  
  public boolean isAccepted()
  {
    return this.accepted;
  }
  
  public void setOriginalRemoteAddress(InetAddress paramInetAddress)
  {
    this.originalRemoteAddress = paramInetAddress;
  }
  
  public void setOriginalRemotePort(int paramInt)
  {
    this.originalRemotePort = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.proxycat.tcp.TCPSession
 * JD-Core Version:    0.7.0.1
 */