package com.tencent.moai.proxycat.tunnel;

import android.util.Log;
import com.tencent.moai.proxycat.selectable.Connectable;
import com.tencent.moai.proxycat.selectable.Readable;
import com.tencent.moai.proxycat.selectable.Writable;
import com.tencent.moai.proxycat.util.Logger;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;

public abstract class Tunnel
  implements Connectable, Readable, Writable
{
  private static final String TAG = "Tunnel";
  protected Tunnel brother;
  protected ByteBuffer buffer = ByteBuffer.allocate(65535);
  protected final SocketChannel channel;
  protected boolean closed;
  protected ByteBuffer remainBuffer = ByteBuffer.allocate(65535);
  protected InetSocketAddress remoteAddress;
  protected final Selector selector;
  
  public Tunnel(Selector paramSelector, SocketChannel paramSocketChannel)
  {
    this.selector = paramSelector;
    this.channel = paramSocketChannel;
  }
  
  protected abstract ByteBuffer afterReceiving(ByteBuffer paramByteBuffer);
  
  protected abstract void afterRemaining();
  
  protected abstract void afterSending();
  
  protected abstract void beforeReceiving();
  
  protected abstract void beforeRemaining();
  
  protected abstract ByteBuffer beforeSending(ByteBuffer paramByteBuffer);
  
  public void beginReceiving()
  {
    if (this.closed) {
      return;
    }
    beforeReceiving();
    try
    {
      this.channel.configureBlocking(false);
      this.channel.register(this.selector, 1, this);
      Logger.d("Tunnel", "register OP_READ:" + this.remoteAddress);
      return;
    }
    catch (IOException localIOException)
    {
      Logger.e("Tunnel", Log.getStackTraceString(localIOException));
      close();
    }
  }
  
  public boolean beginSending(ByteBuffer paramByteBuffer)
  {
    if (this.closed) {
      return false;
    }
    paramByteBuffer = beforeSending(paramByteBuffer);
    try
    {
      int i;
      do
      {
        if (!paramByteBuffer.hasRemaining()) {
          break;
        }
        i = this.channel.write(paramByteBuffer);
      } while (i != 0);
      afterSending();
      if (paramByteBuffer.hasRemaining())
      {
        this.remainBuffer.clear();
        this.remainBuffer.put(paramByteBuffer);
        this.remainBuffer.flip();
        try
        {
          this.channel.register(this.selector, 4, this);
          Logger.d("Tunnel", "register OP_WRITE:" + this.remoteAddress);
          return false;
        }
        catch (ClosedChannelException paramByteBuffer)
        {
          Logger.e("Tunnel", Log.getStackTraceString(paramByteBuffer));
          close();
          return false;
        }
      }
      return true;
    }
    catch (IOException paramByteBuffer)
    {
      Logger.e("Tunnel", Log.getStackTraceString(paramByteBuffer));
      return false;
    }
  }
  
  public void close()
  {
    if (this.closed) {
      return;
    }
    this.closed = true;
    try
    {
      this.channel.close();
      if (this.brother != null) {
        this.brother.close();
      }
      this.remainBuffer = null;
      this.buffer = null;
      this.brother = null;
      onClose();
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        Logger.e("Tunnel", Log.getStackTraceString(localIOException));
      }
    }
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
      Logger.e("Tunnel", Log.getStackTraceString(localIOException));
      close();
    }
  }
  
  protected abstract void onClose();
  
  protected abstract void onConnected();
  
  public void onConnectible(SelectionKey paramSelectionKey)
  {
    try
    {
      if (this.channel.finishConnect())
      {
        onConnected();
        return;
      }
      close();
      return;
    }
    catch (IOException paramSelectionKey)
    {
      Logger.e("Tunnel", Log.getStackTraceString(paramSelectionKey));
      close();
    }
  }
  
  public void onReadable(SelectionKey paramSelectionKey)
  {
    if (this.closed) {}
    do
    {
      do
      {
        return;
        this.buffer.clear();
        try
        {
          int i = this.channel.read(this.buffer);
          if (i == -1)
          {
            close();
            return;
          }
        }
        catch (Exception paramSelectionKey)
        {
          Logger.e("Tunnel", Log.getStackTraceString(paramSelectionKey));
          close();
          return;
        }
        this.buffer.flip();
      } while (!this.buffer.hasRemaining());
      this.buffer = afterReceiving(this.buffer);
    } while ((!this.buffer.hasRemaining()) || (this.brother.beginSending(this.buffer)));
    paramSelectionKey.cancel();
  }
  
  public void onWritable(SelectionKey paramSelectionKey)
  {
    if (this.closed) {
      return;
    }
    beforeRemaining();
    try
    {
      while ((this.remainBuffer.hasRemaining()) && (this.channel.write(this.remainBuffer) != 0)) {}
      paramSelectionKey.cancel();
      this.brother.beginReceiving();
    }
    catch (IOException paramSelectionKey)
    {
      for (;;)
      {
        Logger.e("Tunnel", Log.getStackTraceString(paramSelectionKey));
        close();
      }
    }
    afterRemaining();
  }
  
  public void setBrother(Tunnel paramTunnel)
  {
    this.brother = paramTunnel;
  }
  
  public void setRemoteAddress(InetSocketAddress paramInetSocketAddress)
  {
    this.remoteAddress = paramInetSocketAddress;
  }
  
  public Socket socket()
  {
    return this.channel.socket();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.proxycat.tunnel.Tunnel
 * JD-Core Version:    0.7.0.1
 */