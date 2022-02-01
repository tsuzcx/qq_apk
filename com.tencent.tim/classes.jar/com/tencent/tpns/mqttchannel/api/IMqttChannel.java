package com.tencent.tpns.mqttchannel.api;

import org.json.JSONObject;

public abstract interface IMqttChannel
{
  public abstract void bindAccount(String paramString, OnMqttCallback paramOnMqttCallback);
  
  public abstract void getConnectState(OnMqttCallback paramOnMqttCallback);
  
  public abstract void ping(OnMqttCallback paramOnMqttCallback);
  
  public abstract void sendPublishData(String paramString1, String paramString2, OnMqttCallback paramOnMqttCallback);
  
  public abstract void sendRequest(String paramString, JSONObject paramJSONObject, OnMqttCallback paramOnMqttCallback);
  
  public abstract void startConnect(OnMqttCallback paramOnMqttCallback);
  
  public abstract void stopConnect(OnMqttCallback paramOnMqttCallback);
  
  public abstract void subscrbie(String paramString, OnMqttCallback paramOnMqttCallback);
  
  public abstract void unBindAccount(OnMqttCallback paramOnMqttCallback);
  
  public abstract void unSubscrbie(String paramString, OnMqttCallback paramOnMqttCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tpns.mqttchannel.api.IMqttChannel
 * JD-Core Version:    0.7.0.1
 */