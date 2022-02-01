package com.tencent.tpns.mqttchannel.core.a;

import com.tencent.tpns.mqttchannel.core.common.b.b.a;
import com.tencent.tpns.mqttchannel.services.BaseMqttClientService;

public class a
  extends b.a
{
  private BaseMqttClientService a;
  
  public a(BaseMqttClientService paramBaseMqttClientService)
  {
    this.a = paramBaseMqttClientService;
  }
  
  public void a()
  {
    this.a.onConnectionLost();
  }
  
  public void a(com.tencent.tpns.mqttchannel.core.common.a.a parama)
  {
    this.a.onMessageArrived(parama.b(), parama.c());
  }
  
  public void a(boolean paramBoolean)
  {
    this.a.onConnectComplete(paramBoolean);
  }
  
  public void b()
  {
    this.a.onHeartBeat();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tpns.mqttchannel.core.a.a
 * JD-Core Version:    0.7.0.1
 */