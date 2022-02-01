package com.tencent.mobileqq.msf.sdk;

import android.os.Handler;
import android.os.RemoteException;
import com.tencent.mobileqq.msf.sdk.report.c;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.IMsfServiceCallbacker.Stub;
import com.tencent.qphone.base.remote.ServiceMsgWrapper;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

class r
  extends IMsfServiceCallbacker.Stub
{
  r(q paramq) {}
  
  public boolean isBinderAlive()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSF.D.ProxyNew", 2, "isBinderAlive");
    }
    return super.isBinderAlive();
  }
  
  public void onFirstPkgResp(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, int paramInt1, int paramInt2, int paramInt3)
    throws RemoteException
  {
    int i = paramFromServiceMsg.getRequestSsoSeq();
    if (QLog.isColorLevel()) {
      QLog.d("MSF.D.ProxyNew", 2, "receive first res package, , thread id = " + Thread.currentThread().getId() + ", ssoSeq = " + i + ", index = " + paramInt1 + ", length = " + paramFromServiceMsg.getWupBuffer().length + ", packageLength = " + paramInt2 + ", totalLength = " + paramInt3);
    }
    paramToServiceMsg = new ServiceMsgWrapper(paramToServiceMsg, paramFromServiceMsg, paramInt3);
    paramToServiceMsg.buildFromMsgWupBuffer(paramInt1, paramFromServiceMsg.getWupBuffer());
    q.a(this.a).put(Integer.valueOf(i), paramToServiceMsg);
    q.b(this.a).postDelayed(new j(q.a(this.a), i), 20000L);
  }
  
  public void onNextPkgResp(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
    throws RemoteException
  {
    boolean bool = true;
    Integer localInteger = Integer.valueOf(paramInt1);
    ServiceMsgWrapper localServiceMsgWrapper = (ServiceMsgWrapper)q.a(this.a).get(localInteger);
    StringBuilder localStringBuilder;
    if ((QLog.isColorLevel()) || (localServiceMsgWrapper == null))
    {
      if (localServiceMsgWrapper != null) {
        break label190;
      }
      paramInt1 = 1;
      localStringBuilder = new StringBuilder().append("receive next res package, , thread id = ").append(Thread.currentThread().getId()).append(", ssoSeq = ").append(localInteger).append(", index = ").append(paramInt2).append(", length = ").append(paramArrayOfByte.length).append(", resServiceMsgWrapper = null ");
      if (localServiceMsgWrapper != null) {
        break label195;
      }
    }
    for (;;)
    {
      QLog.d("MSF.D.ProxyNew", paramInt1, bool);
      if (localServiceMsgWrapper != null)
      {
        localServiceMsgWrapper.buildFromMsgWupBuffer(paramInt2, paramArrayOfByte);
        if (localServiceMsgWrapper.isFinishTransported())
        {
          q.a(this.a, localServiceMsgWrapper.getToServiceMsg(), localServiceMsgWrapper.getFromServiceMsg());
          c.a().onReceiveResp(localServiceMsgWrapper.getToServiceMsg(), localServiceMsgWrapper.getFromServiceMsg());
          q.a(this.a).remove(localInteger);
        }
      }
      return;
      label190:
      paramInt1 = 2;
      break;
      label195:
      bool = false;
    }
  }
  
  public void onReceiveFirstPkgPushResp(FromServiceMsg paramFromServiceMsg, int paramInt1, int paramInt2, int paramInt3)
    throws RemoteException
  {
    int i = paramFromServiceMsg.getRequestSsoSeq();
    if (QLog.isColorLevel()) {
      QLog.d("MSF.D.ProxyNew", 2, "receive first push package, , thread id = " + Thread.currentThread().getId() + ", ssoSeq = " + i + ", index = " + paramInt1 + ", length = " + paramFromServiceMsg.getWupBuffer().length + ", packageLength = " + paramInt2 + ", totalLength = " + paramInt3);
    }
    ServiceMsgWrapper localServiceMsgWrapper = new ServiceMsgWrapper(null, paramFromServiceMsg, paramInt3);
    localServiceMsgWrapper.buildFromMsgWupBuffer(paramInt1, paramFromServiceMsg.getWupBuffer());
    q.c(this.a).put(Integer.valueOf(i), localServiceMsgWrapper);
    q.b(this.a).postDelayed(new j(q.c(this.a), i), 20000L);
  }
  
  public void onReceiveNextPkgPushResp(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
    throws RemoteException
  {
    boolean bool = true;
    Integer localInteger = Integer.valueOf(paramInt1);
    ServiceMsgWrapper localServiceMsgWrapper = (ServiceMsgWrapper)q.c(this.a).get(localInteger);
    StringBuilder localStringBuilder;
    if ((QLog.isColorLevel()) || (localServiceMsgWrapper == null))
    {
      if (localServiceMsgWrapper != null) {
        break label180;
      }
      paramInt1 = 1;
      localStringBuilder = new StringBuilder().append("receive next push package, , thread id = ").append(Thread.currentThread().getId()).append(", ssoSeq = ").append(localInteger).append(", index = ").append(paramInt2).append(", length = ").append(paramArrayOfByte.length).append(", resServiceMsgWrapper = null ");
      if (localServiceMsgWrapper != null) {
        break label185;
      }
    }
    for (;;)
    {
      QLog.d("MSF.D.ProxyNew", paramInt1, bool);
      if (localServiceMsgWrapper != null)
      {
        localServiceMsgWrapper.buildFromMsgWupBuffer(paramInt2, paramArrayOfByte);
        if (localServiceMsgWrapper.isFinishTransported())
        {
          q.a(this.a, localServiceMsgWrapper.getFromServiceMsg());
          c.a().onRecvServicePushResp(localServiceMsgWrapper.getFromServiceMsg());
          q.c(this.a).remove(localInteger);
        }
      }
      return;
      label180:
      paramInt1 = 2;
      break;
      label185:
      bool = false;
    }
  }
  
  public void onReceivePushResp(FromServiceMsg paramFromServiceMsg)
    throws RemoteException
  {
    q.a(this.a, paramFromServiceMsg);
    c.a().onRecvServicePushResp(paramFromServiceMsg);
  }
  
  public void onResponse(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
    throws RemoteException
  {
    q.a(this.a, paramToServiceMsg, paramFromServiceMsg);
    c.a().onReceiveResp(paramToServiceMsg, paramFromServiceMsg);
  }
  
  public boolean pingBinder()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSF.D.ProxyNew", 2, "pingBinder");
    }
    return super.pingBinder();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.r
 * JD-Core Version:    0.7.0.1
 */