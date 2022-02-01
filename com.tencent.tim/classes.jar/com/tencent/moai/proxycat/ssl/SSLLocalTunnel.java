package com.tencent.moai.proxycat.ssl;

import android.util.Log;
import com.tencent.moai.proxycat.tunnel.LocalTunnel;
import com.tencent.moai.proxycat.util.Logger;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;

public class SSLLocalTunnel
  extends LocalTunnel
{
  private static final String TAG = "SSLLocalTunnel";
  private ByteBuffer decryptedBuffer = ByteBuffer.allocate(65545);
  private ByteBuffer encryptedBuffer = ByteBuffer.allocate(65545);
  
  public SSLLocalTunnel(Selector paramSelector, SocketChannel paramSocketChannel)
  {
    super(paramSelector, paramSocketChannel);
  }
  
  public ByteBuffer afterReceiving(ByteBuffer paramByteBuffer)
  {
    try
    {
      SSLManager.getInstance().doUnwrap(paramByteBuffer, this.decryptedBuffer);
      return super.afterReceiving(this.decryptedBuffer);
    }
    catch (IOException paramByteBuffer)
    {
      for (;;)
      {
        Logger.e("SSLLocalTunnel", Log.getStackTraceString(paramByteBuffer));
      }
    }
  }
  
  public ByteBuffer beforeSending(ByteBuffer paramByteBuffer)
  {
    try
    {
      SSLManager.getInstance().doWrap(paramByteBuffer, this.encryptedBuffer);
      return super.beforeSending(this.encryptedBuffer);
    }
    catch (IOException paramByteBuffer)
    {
      for (;;)
      {
        Logger.e("SSLLocalTunnel", Log.getStackTraceString(paramByteBuffer));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.proxycat.ssl.SSLLocalTunnel
 * JD-Core Version:    0.7.0.1
 */