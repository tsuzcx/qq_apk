package com.huawei.hms.support.api.client;

import com.huawei.hms.core.aidl.IMessageEntity;

public abstract class Result
  implements IMessageEntity
{
  private Status status = Status.FAILURE;
  
  public Status getStatus()
  {
    return this.status;
  }
  
  public void setStatus(Status paramStatus)
  {
    if (paramStatus == null) {
      return;
    }
    this.status = paramStatus;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hms.support.api.client.Result
 * JD-Core Version:    0.7.0.1
 */