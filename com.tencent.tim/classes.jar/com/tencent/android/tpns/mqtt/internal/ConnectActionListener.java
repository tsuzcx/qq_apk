package com.tencent.android.tpns.mqtt.internal;

import com.tencent.android.tpns.mqtt.IMqttActionListener;
import com.tencent.android.tpns.mqtt.IMqttToken;
import com.tencent.android.tpns.mqtt.MqttAsyncClient;
import com.tencent.android.tpns.mqtt.MqttCallbackExtended;
import com.tencent.android.tpns.mqtt.MqttClientPersistence;
import com.tencent.android.tpns.mqtt.MqttConnectOptions;
import com.tencent.android.tpns.mqtt.MqttException;
import com.tencent.android.tpns.mqtt.MqttPersistenceException;
import com.tencent.android.tpns.mqtt.MqttToken;

public class ConnectActionListener
  implements IMqttActionListener
{
  private MqttAsyncClient client;
  private ClientComms comms;
  private MqttCallbackExtended mqttCallbackExtended;
  private MqttConnectOptions options;
  private int originalMqttVersion;
  private MqttClientPersistence persistence;
  private boolean reconnect;
  private IMqttActionListener userCallback;
  private Object userContext;
  private MqttToken userToken;
  
  public ConnectActionListener(MqttAsyncClient paramMqttAsyncClient, MqttClientPersistence paramMqttClientPersistence, ClientComms paramClientComms, MqttConnectOptions paramMqttConnectOptions, MqttToken paramMqttToken, Object paramObject, IMqttActionListener paramIMqttActionListener, boolean paramBoolean)
  {
    this.persistence = paramMqttClientPersistence;
    this.client = paramMqttAsyncClient;
    this.comms = paramClientComms;
    this.options = paramMqttConnectOptions;
    this.userToken = paramMqttToken;
    this.userContext = paramObject;
    this.userCallback = paramIMqttActionListener;
    this.originalMqttVersion = paramMqttConnectOptions.getMqttVersion();
    this.reconnect = paramBoolean;
  }
  
  public void connect()
    throws MqttPersistenceException
  {
    MqttToken localMqttToken = new MqttToken(this.client.getClientId());
    localMqttToken.setActionCallback(this);
    localMqttToken.setUserContext(this);
    this.persistence.open(this.client.getClientId(), this.client.getServerURI());
    if (this.options.isCleanSession()) {
      this.persistence.clear();
    }
    if (this.options.getMqttVersion() == 0) {
      this.options.setMqttVersion(4);
    }
    try
    {
      this.comms.connect(this.options, localMqttToken);
      return;
    }
    catch (Throwable localThrowable)
    {
      onFailure(localMqttToken, localThrowable);
    }
  }
  
  public void onFailure(IMqttToken paramIMqttToken, Throwable paramThrowable)
  {
    int i = this.comms.getNetworkModules().length;
    int j = this.comms.getNetworkModuleIndex();
    if ((j + 1 < i) || ((this.originalMqttVersion == 0) && (this.options.getMqttVersion() == 4)))
    {
      if (this.originalMqttVersion == 0) {
        if (this.options.getMqttVersion() == 4) {
          this.options.setMqttVersion(3);
        }
      }
      for (;;)
      {
        try
        {
          connect();
          return;
        }
        catch (MqttPersistenceException paramThrowable)
        {
          onFailure(paramIMqttToken, paramThrowable);
          return;
        }
        this.options.setMqttVersion(4);
        this.comms.setNetworkModuleIndex(j + 1);
        continue;
        this.comms.setNetworkModuleIndex(j + 1);
      }
    }
    if (this.originalMqttVersion == 0) {
      this.options.setMqttVersion(0);
    }
    if ((paramThrowable instanceof MqttException)) {}
    for (paramIMqttToken = (MqttException)paramThrowable;; paramIMqttToken = new MqttException(paramThrowable))
    {
      this.userToken.internalTok.markComplete(null, paramIMqttToken);
      this.userToken.internalTok.notifyComplete();
      this.userToken.internalTok.setClient(this.client);
      if (this.userCallback == null) {
        break;
      }
      this.userToken.setUserContext(this.userContext);
      this.userCallback.onFailure(this.userToken, paramThrowable);
      return;
    }
  }
  
  public void onSuccess(IMqttToken paramIMqttToken)
  {
    if (this.originalMqttVersion == 0) {
      this.options.setMqttVersion(0);
    }
    this.userToken.internalTok.markComplete(paramIMqttToken.getResponse(), null);
    this.userToken.internalTok.notifyComplete();
    this.userToken.internalTok.setClient(this.client);
    this.comms.notifyConnect();
    if (this.userCallback != null)
    {
      this.userToken.setUserContext(this.userContext);
      this.userCallback.onSuccess(this.userToken);
    }
    if (this.mqttCallbackExtended != null)
    {
      paramIMqttToken = this.comms.getNetworkModules()[this.comms.getNetworkModuleIndex()].getServerURI();
      this.mqttCallbackExtended.connectComplete(this.reconnect, paramIMqttToken);
    }
  }
  
  public void setMqttCallbackExtended(MqttCallbackExtended paramMqttCallbackExtended)
  {
    this.mqttCallbackExtended = paramMqttCallbackExtended;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpns.mqtt.internal.ConnectActionListener
 * JD-Core Version:    0.7.0.1
 */