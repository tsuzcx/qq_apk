package com.huawei.hms.support.api;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.support.api.transport.DatagramTransport.a;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;

class PendingResultImpl$2
  implements DatagramTransport.a
{
  PendingResultImpl$2(PendingResultImpl paramPendingResultImpl, AtomicBoolean paramAtomicBoolean) {}
  
  public void a(int paramInt, IMessageEntity paramIMessageEntity)
  {
    if (!this.a.get()) {
      PendingResultImpl.a(this.b, paramInt, paramIMessageEntity);
    }
    PendingResultImpl.a(this.b).countDown();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hms.support.api.PendingResultImpl.2
 * JD-Core Version:    0.7.0.1
 */