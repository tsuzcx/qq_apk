package com.tencent.android.tpns.mqtt;

import com.tencent.android.tpns.mqtt.util.Debug;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Properties;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;

public class MqttConnectOptions
{
  public static final boolean CLEAN_SESSION_DEFAULT = true;
  public static final int CONNECTION_TIMEOUT_DEFAULT = 30;
  public static final int KEEP_ALIVE_INTERVAL_DEFAULT = 60;
  public static final int MAX_INFLIGHT_DEFAULT = 10;
  public static final int MQTT_VERSION_3_1 = 3;
  public static final int MQTT_VERSION_3_1_1 = 4;
  public static final int MQTT_VERSION_DEFAULT = 0;
  protected static final int URI_TYPE_LOCAL = 2;
  protected static final int URI_TYPE_SSL = 1;
  protected static final int URI_TYPE_TCP = 0;
  protected static final int URI_TYPE_WS = 3;
  protected static final int URI_TYPE_WSS = 4;
  private int MqttVersion = 0;
  private boolean automaticReconnect = false;
  private boolean cleanSession = true;
  private int connectionTimeout = 30;
  private int keepAliveInterval = 60;
  private int maxInflight = 10;
  private char[] password;
  private String[] serverURIs = null;
  private SocketFactory socketFactory;
  private Properties sslClientProps = null;
  private HostnameVerifier sslHostnameVerifier = null;
  private String userName;
  private String willDestination = null;
  private MqttMessage willMessage = null;
  
  public static int validateURI(String paramString)
  {
    try
    {
      URI localURI = new URI(paramString);
      if ("ws".equals(localURI.getScheme())) {
        return 3;
      }
      if ("wss".equals(localURI.getScheme())) {
        return 4;
      }
      if ((localURI.getPath() == null) || (localURI.getPath().isEmpty()))
      {
        if ("tcp".equals(localURI.getScheme())) {
          return 0;
        }
      }
      else {
        throw new IllegalArgumentException(paramString);
      }
    }
    catch (URISyntaxException localURISyntaxException)
    {
      throw new IllegalArgumentException(paramString);
    }
    if ("ssl".equals(localURISyntaxException.getScheme())) {
      return 1;
    }
    if ("local".equals(localURISyntaxException.getScheme())) {
      return 2;
    }
    throw new IllegalArgumentException(paramString);
  }
  
  private void validateWill(String paramString, Object paramObject)
  {
    if ((paramString == null) || (paramObject == null)) {
      throw new IllegalArgumentException();
    }
    MqttTopic.validate(paramString, false);
  }
  
  public int getConnectionTimeout()
  {
    return this.connectionTimeout;
  }
  
  public Properties getDebug()
  {
    Properties localProperties = new Properties();
    localProperties.put("MqttVersion", new Integer(getMqttVersion()));
    localProperties.put("CleanSession", Boolean.valueOf(isCleanSession()));
    localProperties.put("ConTimeout", new Integer(getConnectionTimeout()));
    localProperties.put("KeepAliveInterval", new Integer(getKeepAliveInterval()));
    String str;
    if (getUserName() == null)
    {
      str = "null";
      localProperties.put("UserName", str);
      if (getWillDestination() != null) {
        break label154;
      }
      str = "null";
      label104:
      localProperties.put("WillDestination", str);
      if (getSocketFactory() != null) {
        break label162;
      }
      localProperties.put("SocketFactory", "null");
    }
    for (;;)
    {
      if (getSSLProperties() != null) {
        break label176;
      }
      localProperties.put("SSLProperties", "null");
      return localProperties;
      str = getUserName();
      break;
      label154:
      str = getWillDestination();
      break label104;
      label162:
      localProperties.put("SocketFactory", getSocketFactory());
    }
    label176:
    localProperties.put("SSLProperties", getSSLProperties());
    return localProperties;
  }
  
  public int getKeepAliveInterval()
  {
    return this.keepAliveInterval;
  }
  
  public int getMaxInflight()
  {
    return this.maxInflight;
  }
  
  public int getMqttVersion()
  {
    return this.MqttVersion;
  }
  
  public char[] getPassword()
  {
    return this.password;
  }
  
  public HostnameVerifier getSSLHostnameVerifier()
  {
    return this.sslHostnameVerifier;
  }
  
  public Properties getSSLProperties()
  {
    return this.sslClientProps;
  }
  
  public String[] getServerURIs()
  {
    return this.serverURIs;
  }
  
  public SocketFactory getSocketFactory()
  {
    return this.socketFactory;
  }
  
  public String getUserName()
  {
    return this.userName;
  }
  
  public String getWillDestination()
  {
    return this.willDestination;
  }
  
  public MqttMessage getWillMessage()
  {
    return this.willMessage;
  }
  
  public boolean isAutomaticReconnect()
  {
    return this.automaticReconnect;
  }
  
  public boolean isCleanSession()
  {
    return this.cleanSession;
  }
  
  public void setAutomaticReconnect(boolean paramBoolean)
  {
    this.automaticReconnect = paramBoolean;
  }
  
  public void setCleanSession(boolean paramBoolean)
  {
    this.cleanSession = paramBoolean;
  }
  
  public void setConnectionTimeout(int paramInt)
  {
    if (paramInt < 0) {
      throw new IllegalArgumentException();
    }
    this.connectionTimeout = paramInt;
  }
  
  public void setKeepAliveInterval(int paramInt)
    throws IllegalArgumentException
  {
    if (paramInt < 0) {
      throw new IllegalArgumentException();
    }
    this.keepAliveInterval = paramInt;
  }
  
  public void setMaxInflight(int paramInt)
  {
    if (paramInt < 0) {
      throw new IllegalArgumentException();
    }
    this.maxInflight = paramInt;
  }
  
  public void setMqttVersion(int paramInt)
    throws IllegalArgumentException
  {
    if ((paramInt != 0) && (paramInt != 3) && (paramInt != 4)) {
      throw new IllegalArgumentException();
    }
    this.MqttVersion = paramInt;
  }
  
  public void setPassword(char[] paramArrayOfChar)
  {
    this.password = paramArrayOfChar;
  }
  
  public void setSSLHostnameVerifier(HostnameVerifier paramHostnameVerifier)
  {
    this.sslHostnameVerifier = paramHostnameVerifier;
  }
  
  public void setSSLProperties(Properties paramProperties)
  {
    this.sslClientProps = paramProperties;
  }
  
  public void setServerURIs(String[] paramArrayOfString)
  {
    int i = 0;
    while (i < paramArrayOfString.length)
    {
      validateURI(paramArrayOfString[i]);
      i += 1;
    }
    this.serverURIs = paramArrayOfString;
  }
  
  public void setSocketFactory(SocketFactory paramSocketFactory)
  {
    this.socketFactory = paramSocketFactory;
  }
  
  public void setUserName(String paramString)
  {
    if ((paramString != null) && (paramString.trim().equals(""))) {
      throw new IllegalArgumentException();
    }
    this.userName = paramString;
  }
  
  public void setWill(MqttTopic paramMqttTopic, byte[] paramArrayOfByte, int paramInt, boolean paramBoolean)
  {
    paramMqttTopic = paramMqttTopic.getName();
    validateWill(paramMqttTopic, paramArrayOfByte);
    setWill(paramMqttTopic, new MqttMessage(paramArrayOfByte), paramInt, paramBoolean);
  }
  
  protected void setWill(String paramString, MqttMessage paramMqttMessage, int paramInt, boolean paramBoolean)
  {
    this.willDestination = paramString;
    this.willMessage = paramMqttMessage;
    this.willMessage.setQos(paramInt);
    this.willMessage.setRetained(paramBoolean);
    this.willMessage.setMutable(false);
  }
  
  public void setWill(String paramString, byte[] paramArrayOfByte, int paramInt, boolean paramBoolean)
  {
    validateWill(paramString, paramArrayOfByte);
    setWill(paramString, new MqttMessage(paramArrayOfByte), paramInt, paramBoolean);
  }
  
  public String toString()
  {
    return Debug.dumpProperties(getDebug(), "Connection options");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpns.mqtt.MqttConnectOptions
 * JD-Core Version:    0.7.0.1
 */