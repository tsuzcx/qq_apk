package com.tencent.mobileqq.msf.sdk.handler;

import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;

public abstract interface INotifyHandler
  extends IMsfHandler
{
  public abstract void onRecvNotify(long paramLong, FromServiceMsg paramFromServiceMsg);
  
  public abstract void onRegisterNotifyResp(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg);
  
  public abstract void onUnRegisterNotifyResp(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.handler.INotifyHandler
 * JD-Core Version:    0.7.0.1
 */