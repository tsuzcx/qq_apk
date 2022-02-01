package com.tencent.mobileqq.msf.sdk.handler;

import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;

public abstract interface IMsfLifeCallbacker
{
  public abstract void onBindEnd(boolean paramBoolean);
  
  public abstract void onBindStart();
  
  public abstract void onReceiveResp(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg);
  
  public abstract void onRecvServicePushResp(FromServiceMsg paramFromServiceMsg);
  
  public abstract void onReqServiceConn();
  
  public abstract void onRespToApp(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg);
  
  public abstract void onSendMsg(ToServiceMsg paramToServiceMsg, boolean paramBoolean);
  
  public abstract void onSendToService(ToServiceMsg paramToServiceMsg, int paramInt);
  
  public abstract void onServiceConnected();
  
  public abstract void onServiceDisconnected();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.handler.IMsfLifeCallbacker
 * JD-Core Version:    0.7.0.1
 */