package com.huawei.hms.common.api;

import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.support.api.client.Result;
import com.huawei.hms.support.api.client.Status;

public class BooleanResult
  extends Result
{
  private final Status myStatus;
  private final boolean resultValue;
  
  public BooleanResult(Status paramStatus, boolean paramBoolean)
  {
    Preconditions.checkNotNull(paramStatus, "status cannot be null");
    this.myStatus = paramStatus;
    this.resultValue = paramBoolean;
  }
  
  public final boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1;
    if (this == paramObject) {
      bool1 = true;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (!(paramObject instanceof BooleanResult));
      paramObject = (BooleanResult)paramObject;
      if (this.resultValue == paramObject.getValue()) {
        break;
      }
      bool1 = bool2;
    } while (!this.myStatus.equals(paramObject.getStatus()));
    return true;
  }
  
  public Status getStatus()
  {
    return this.myStatus;
  }
  
  public boolean getValue()
  {
    return this.resultValue;
  }
  
  public final int hashCode()
  {
    int i = 0;
    if (this.resultValue) {
      i = 1;
    }
    return i + (this.myStatus.hashCode() + 127) * 77;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hms.common.api.BooleanResult
 * JD-Core Version:    0.7.0.1
 */