package com.tencent.mobileqq.highway.api;

import com.tencent.mobileqq.highway.segment.RequestAck;

public abstract interface RequestOps
{
  public abstract void SubmitAckRequest(RequestAck paramRequestAck);
  
  public abstract void cancelAckRequest(RequestAck paramRequestAck);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.highway.api.RequestOps
 * JD-Core Version:    0.7.0.1
 */