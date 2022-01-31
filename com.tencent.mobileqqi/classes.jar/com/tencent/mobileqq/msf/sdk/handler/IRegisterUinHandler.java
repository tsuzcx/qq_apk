package com.tencent.mobileqq.msf.sdk.handler;

import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;

public abstract interface IRegisterUinHandler
  extends IMsfHandler
{
  public abstract void onRegQueryAccountResp(int paramInt, byte[] paramArrayOfByte, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg);
  
  public abstract void onRegisterCommitMobileResp(int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg);
  
  public abstract void onRegisterCommitPassResp(int paramInt, String paramString, byte[] paramArrayOfByte, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg);
  
  public abstract void onRegisterCommitSmsCodeResp(int paramInt, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg);
  
  public abstract void onRegisterQuerySmsStatResp(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg);
  
  public abstract void onRegisterSendResendSmsreqResp(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.handler.IRegisterUinHandler
 * JD-Core Version:    0.7.0.1
 */