package com.tencent.mobileqq.msf.sdk;

import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;

public class MsfMessagePair
{
  public FromServiceMsg fromServiceMsg;
  public ToServiceMsg toServiceMsg;
  
  public MsfMessagePair(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    this.toServiceMsg = paramToServiceMsg;
    this.fromServiceMsg = paramFromServiceMsg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.MsfMessagePair
 * JD-Core Version:    0.7.0.1
 */