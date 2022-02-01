package com.tencent.android.tpns.mqtt.internal.websocket;

import com.tencent.android.tpns.mqtt.MqttException;
import com.tencent.android.tpns.mqtt.internal.TCPNetworkModule;
import com.tencent.android.tpns.mqtt.logging.Logger;
import com.tencent.android.tpns.mqtt.logging.LoggerFactory;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PipedInputStream;
import java.nio.ByteBuffer;
import javax.net.SocketFactory;

public class WebSocketNetworkModule
  extends TCPNetworkModule
{
  private static final String CLASS_NAME = "WebSocketNetworkModule";
  private static final Logger log = LoggerFactory.getLogger("com.tencent.android.tpns.mqtt.internal.nls.logcat", "WebSocketNetworkModule");
  private String host;
  private ByteArrayOutputStream outputStream = new ExtendedByteArrayOutputStream(this);
  private PipedInputStream pipedInputStream;
  private int port;
  ByteBuffer recievedPayload;
  private String uri;
  private WebSocketReceiver webSocketReceiver;
  
  public WebSocketNetworkModule(SocketFactory paramSocketFactory, String paramString1, String paramString2, int paramInt, String paramString3)
  {
    super(paramSocketFactory, paramString2, paramInt, paramString3);
    this.uri = paramString1;
    this.host = paramString2;
    this.port = paramInt;
    this.pipedInputStream = new PipedInputStream();
    log.setResourceName(paramString3);
  }
  
  public InputStream getInputStream()
    throws IOException
  {
    return this.pipedInputStream;
  }
  
  public OutputStream getOutputStream()
    throws IOException
  {
    return this.outputStream;
  }
  
  public String getServerURI()
  {
    return "ws://" + this.host + ":" + this.port;
  }
  
  InputStream getSocketInputStream()
    throws IOException
  {
    return super.getInputStream();
  }
  
  OutputStream getSocketOutputStream()
    throws IOException
  {
    return super.getOutputStream();
  }
  
  public void start()
    throws IOException, MqttException
  {
    super.start();
    new WebSocketHandshake(getSocketInputStream(), getSocketOutputStream(), this.uri, this.host, this.port).execute();
    this.webSocketReceiver = new WebSocketReceiver(getSocketInputStream(), this.pipedInputStream);
    this.webSocketReceiver.start("webSocketReceiver");
  }
  
  public void stop()
    throws IOException
  {
    byte[] arrayOfByte = new WebSocketFrame((byte)8, true, "1000".getBytes()).encodeFrame();
    getSocketOutputStream().write(arrayOfByte);
    getSocketOutputStream().flush();
    if (this.webSocketReceiver != null) {
      this.webSocketReceiver.stop();
    }
    super.stop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpns.mqtt.internal.websocket.WebSocketNetworkModule
 * JD-Core Version:    0.7.0.1
 */