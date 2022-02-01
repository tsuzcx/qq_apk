package com.huawei.hms.support.api.transport;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.support.api.client.ApiClient;

public abstract interface DatagramTransport
{
  public abstract void post(ApiClient paramApiClient, a parama);
  
  public abstract void send(ApiClient paramApiClient, a parama);
  
  public static abstract interface a
  {
    public abstract void a(int paramInt, IMessageEntity paramIMessageEntity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hms.support.api.transport.DatagramTransport
 * JD-Core Version:    0.7.0.1
 */