package com.huawei.hms.support.api;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.support.api.client.ResultCallback;
import com.huawei.hms.support.api.transport.DatagramTransport.a;

class PendingResultImpl$3
  implements DatagramTransport.a
{
  PendingResultImpl$3(PendingResultImpl paramPendingResultImpl, PendingResultImpl.a parama, ResultCallback paramResultCallback) {}
  
  public void a(int paramInt, IMessageEntity paramIMessageEntity)
  {
    PendingResultImpl.a(this.c, paramInt, paramIMessageEntity);
    this.a.a(this.b, PendingResultImpl.b(this.c));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hms.support.api.PendingResultImpl.3
 * JD-Core Version:    0.7.0.1
 */