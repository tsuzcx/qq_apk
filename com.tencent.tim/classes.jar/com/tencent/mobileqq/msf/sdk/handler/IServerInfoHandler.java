package com.tencent.mobileqq.msf.sdk.handler;

import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;

public abstract interface IServerInfoHandler
  extends IMsfHandler
{
  public abstract void onReportResp(int paramInt1, int paramInt2, String paramString, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.handler.IServerInfoHandler
 * JD-Core Version:    0.7.0.1
 */