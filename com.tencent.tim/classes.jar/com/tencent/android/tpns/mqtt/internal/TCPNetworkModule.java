package com.tencent.android.tpns.mqtt.internal;

import com.tencent.android.tpns.mqtt.MqttException;
import com.tencent.android.tpns.mqtt.logging.Logger;
import com.tencent.android.tpns.mqtt.logging.LoggerFactory;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.InetSocketAddress;
import java.net.Socket;
import javax.net.SocketFactory;
import javax.net.ssl.SSLSocketFactory;

public class TCPNetworkModule
  implements NetworkModule
{
  private static final String CLASS_NAME = "TCPNetworkModule";
  private static final Logger log = LoggerFactory.getLogger("com.tencent.android.tpns.mqtt.internal.nls.logcat", "TCPNetworkModule");
  private int conTimeout;
  private SocketFactory factory;
  private String host;
  private int port;
  protected Socket socket;
  protected Socket tempsocket;
  
  public TCPNetworkModule(SocketFactory paramSocketFactory, String paramString1, int paramInt, String paramString2)
  {
    log.setResourceName(paramString2);
    this.factory = paramSocketFactory;
    this.host = paramString1;
    this.port = paramInt;
  }
  
  public InputStream getInputStream()
    throws IOException
  {
    return this.socket.getInputStream();
  }
  
  public OutputStream getOutputStream()
    throws IOException
  {
    return this.socket.getOutputStream();
  }
  
  public String getServerURI()
  {
    return "tcp://" + this.host + ":" + this.port;
  }
  
  public void setConnectTimeout(int paramInt)
  {
    this.conTimeout = paramInt;
  }
  
  public void start()
    throws IOException, MqttException
  {
    try
    {
      InetSocketAddress localInetSocketAddress = new InetSocketAddress(this.host, this.port);
      if ((this.factory instanceof SSLSocketFactory))
      {
        this.tempsocket = new Socket();
        this.tempsocket.connect(localInetSocketAddress, this.conTimeout * 1000);
        this.socket = ((SSLSocketFactory)this.factory).createSocket(this.tempsocket, this.host, this.port, true);
        return;
      }
      this.socket = this.factory.createSocket();
      this.socket.connect(localInetSocketAddress, this.conTimeout * 1000);
      return;
    }
    catch (ConnectException localConnectException)
    {
      log.fine("TCPNetworkModule", "start", "250", null, localConnectException);
      throw new MqttException(32103, localConnectException);
    }
  }
  
  public void stop()
    throws IOException
  {
    if (this.socket != null)
    {
      this.socket.shutdownInput();
      this.socket.close();
    }
    if (this.tempsocket != null) {}
    try
    {
      this.tempsocket.shutdownInput();
      this.tempsocket.close();
      return;
    }
    catch (Throwable localThrowable) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpns.mqtt.internal.TCPNetworkModule
 * JD-Core Version:    0.7.0.1
 */