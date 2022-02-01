package com.tencent.android.tpns.mqtt.internal;

import com.tencent.android.tpns.mqtt.MqttException;
import com.tencent.android.tpns.mqtt.logging.Logger;
import com.tencent.android.tpns.mqtt.logging.LoggerFactory;
import java.io.IOException;
import java.net.Socket;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class SSLNetworkModule
  extends TCPNetworkModule
{
  private static final String CLASS_NAME = "SSLNetworkModule";
  private static final Logger log = LoggerFactory.getLogger("com.tencent.android.tpns.mqtt.internal.nls.logcat", "SSLNetworkModule");
  private String[] enabledCiphers;
  private int handshakeTimeoutSecs;
  private String host;
  private HostnameVerifier hostnameVerifier;
  private int port;
  
  public SSLNetworkModule(SSLSocketFactory paramSSLSocketFactory, String paramString1, int paramInt, String paramString2)
  {
    super(paramSSLSocketFactory, paramString1, paramInt, paramString2);
    this.host = paramString1;
    this.port = paramInt;
    log.setResourceName(paramString2);
  }
  
  public String[] getEnabledCiphers()
  {
    return this.enabledCiphers;
  }
  
  public HostnameVerifier getSSLHostnameVerifier()
  {
    return this.hostnameVerifier;
  }
  
  public String getServerURI()
  {
    return "ssl://" + this.host + ":" + this.port;
  }
  
  public void setEnabledCiphers(String[] paramArrayOfString)
  {
    this.enabledCiphers = paramArrayOfString;
    if ((this.socket != null) && (paramArrayOfString != null))
    {
      if (log.isLoggable(5))
      {
        String str1 = "";
        int i = 0;
        while (i < paramArrayOfString.length)
        {
          String str2 = str1;
          if (i > 0) {
            str2 = str1 + ",";
          }
          str1 = str2 + paramArrayOfString[i];
          i += 1;
        }
        log.fine("SSLNetworkModule", "setEnabledCiphers", "260", new Object[] { str1 });
      }
      ((SSLSocket)this.socket).setEnabledCipherSuites(paramArrayOfString);
    }
  }
  
  public void setSSLHostnameVerifier(HostnameVerifier paramHostnameVerifier)
  {
    this.hostnameVerifier = paramHostnameVerifier;
  }
  
  public void setSSLhandshakeTimeout(int paramInt)
  {
    super.setConnectTimeout(paramInt);
    this.handshakeTimeoutSecs = paramInt;
  }
  
  public void start()
    throws IOException, MqttException
  {
    super.start();
    setEnabledCiphers(this.enabledCiphers);
    int i = this.socket.getSoTimeout();
    this.socket.setSoTimeout(this.handshakeTimeoutSecs * 1000);
    ((SSLSocket)this.socket).startHandshake();
    if (this.hostnameVerifier != null)
    {
      SSLSession localSSLSession = ((SSLSocket)this.socket).getSession();
      this.hostnameVerifier.verify(this.host, localSSLSession);
    }
    this.socket.setSoTimeout(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpns.mqtt.internal.SSLNetworkModule
 * JD-Core Version:    0.7.0.1
 */