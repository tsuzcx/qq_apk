package com.tencent.tpns.mqttchannel.api;

public enum MqttConnectState
{
  private int a;
  
  private MqttConnectState(int paramInt)
  {
    this.a = paramInt;
  }
  
  public static MqttConnectState from(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return UNKOWN;
    case 0: 
      return DISCONNECTED;
    case 1: 
      return CONNECTED;
    case 2: 
      return CONNECTFAIL;
    case 3: 
      return CONNECTING;
    case 4: 
      return DISCONNECTING;
    }
    return SUBTOPICS;
  }
  
  public int getType()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tpns.mqttchannel.api.MqttConnectState
 * JD-Core Version:    0.7.0.1
 */