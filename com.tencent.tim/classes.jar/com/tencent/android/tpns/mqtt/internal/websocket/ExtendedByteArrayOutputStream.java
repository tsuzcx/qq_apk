package com.tencent.android.tpns.mqtt.internal.websocket;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;

class ExtendedByteArrayOutputStream
  extends ByteArrayOutputStream
{
  final WebSocketNetworkModule webSocketNetworkModule;
  final WebSocketSecureNetworkModule webSocketSecureNetworkModule;
  
  ExtendedByteArrayOutputStream(WebSocketNetworkModule paramWebSocketNetworkModule)
  {
    this.webSocketNetworkModule = paramWebSocketNetworkModule;
    this.webSocketSecureNetworkModule = null;
  }
  
  ExtendedByteArrayOutputStream(WebSocketSecureNetworkModule paramWebSocketSecureNetworkModule)
  {
    this.webSocketNetworkModule = null;
    this.webSocketSecureNetworkModule = paramWebSocketSecureNetworkModule;
  }
  
  public void flush()
    throws IOException
  {
    try
    {
      Object localObject1 = ByteBuffer.wrap(toByteArray());
      reset();
      localObject1 = new WebSocketFrame((byte)2, true, ((ByteBuffer)localObject1).array()).encodeFrame();
      OutputStream localOutputStream = getSocketOutputStream();
      if (localOutputStream != null)
      {
        localOutputStream.write((byte[])localObject1);
        localOutputStream.flush();
      }
      return;
    }
    finally {}
  }
  
  OutputStream getSocketOutputStream()
    throws IOException
  {
    if (this.webSocketNetworkModule != null) {
      return this.webSocketNetworkModule.getSocketOutputStream();
    }
    if (this.webSocketSecureNetworkModule != null) {
      return this.webSocketSecureNetworkModule.getSocketOutputStream();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpns.mqtt.internal.websocket.ExtendedByteArrayOutputStream
 * JD-Core Version:    0.7.0.1
 */