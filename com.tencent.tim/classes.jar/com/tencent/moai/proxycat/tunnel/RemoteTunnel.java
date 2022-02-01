package com.tencent.moai.proxycat.tunnel;

import android.util.Base64;
import android.util.Log;
import com.tencent.moai.proxycat.ProxyCatManager;
import com.tencent.moai.proxycat.selectable.Connectable;
import com.tencent.moai.proxycat.util.Logger;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;

public class RemoteTunnel
  extends Tunnel
  implements Connectable
{
  private String TAG = "RemoteTunnel";
  
  public RemoteTunnel(Selector paramSelector)
    throws IOException
  {
    super(paramSelector, makeChannel());
  }
  
  private void beginReceive()
  {
    try
    {
      this.channel.configureBlocking(false);
      this.channel.register(this.selector, 1, new RemoteTunnel.1(this));
      return;
    }
    catch (Exception localException)
    {
      Logger.e(this.TAG, Log.getStackTraceString(localException));
      close();
    }
  }
  
  private void connectToHttpProxy()
  {
    beginReceive();
    Object localObject = "" + ProxyCatManager.getInstance().getProxyName() + ":" + ProxyCatManager.getInstance().getProxyPwd();
    localObject = "CONNECT accounts.google.com:443 HTTP/1.1\nHost: accounts.google.com:443\nProxy-Connection: keep-alive\nUser-Agent: Mozilla/5.0 (Linux; Android 7.0; MI 5 Build/NRD90M; wv) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.91 Mobile Safari/537.36\nProxy-Authorization: Basic " + Base64.encodeToString(((String)localObject).getBytes(), 2) + "\nContent-Length:0\n\n";
    Log.i(this.TAG, "connectToHttpProxy");
    localObject = ByteBuffer.wrap(((String)localObject).getBytes(), 0, ((String)localObject).getBytes().length);
    try
    {
      int i;
      do
      {
        if (!((ByteBuffer)localObject).hasRemaining()) {
          break;
        }
        i = this.channel.write((ByteBuffer)localObject);
      } while (i != 0);
      return;
    }
    catch (IOException localIOException)
    {
      Logger.e(this.TAG, Log.getStackTraceString(localIOException));
    }
  }
  
  private static SocketChannel makeChannel()
    throws IOException
  {
    SocketChannel localSocketChannel = SocketChannel.open();
    localSocketChannel.configureBlocking(false);
    localSocketChannel.socket().bind(new InetSocketAddress(0));
    return localSocketChannel;
  }
  
  protected ByteBuffer afterReceiving(ByteBuffer paramByteBuffer)
  {
    Logger.d(this.TAG, "afterReceiving:" + this.remoteAddress);
    return paramByteBuffer;
  }
  
  protected void afterRemaining()
  {
    Logger.d(this.TAG, "afterRemaining:" + this.remoteAddress);
  }
  
  protected void afterSending()
  {
    Logger.d(this.TAG, "afterSending:" + this.remoteAddress);
  }
  
  protected void beforeReceiving()
  {
    Logger.d(this.TAG, "beforeReceiving:" + this.remoteAddress);
  }
  
  protected void beforeRemaining()
  {
    Logger.d(this.TAG, "beforeRemaining:" + this.remoteAddress);
  }
  
  protected ByteBuffer beforeSending(ByteBuffer paramByteBuffer)
  {
    Logger.d(this.TAG, "beforeSending:" + this.remoteAddress);
    return paramByteBuffer;
  }
  
  public void connect()
  {
    try
    {
      this.channel.register(this.selector, 8, this);
      this.channel.connect(this.remoteAddress);
      return;
    }
    catch (IOException localIOException)
    {
      Logger.e(this.TAG, Log.getStackTraceString(localIOException));
      close();
    }
  }
  
  protected void onClose()
  {
    Logger.d(this.TAG, "onClose:" + this.remoteAddress);
  }
  
  protected void onConnected()
  {
    Logger.d(this.TAG, "onConnected:" + this.remoteAddress + " port " + this.channel.socket().getPort());
    if (this.remoteAddress.getAddress().getHostAddress().equals(ProxyCatManager.getInstance().getProxyIp()))
    {
      connectToHttpProxy();
      return;
    }
    beginReceiving();
    this.brother.beginReceiving();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.proxycat.tunnel.RemoteTunnel
 * JD-Core Version:    0.7.0.1
 */