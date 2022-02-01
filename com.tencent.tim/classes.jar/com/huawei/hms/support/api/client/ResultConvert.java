package com.huawei.hms.support.api.client;

import com.huawei.hms.common.internal.Preconditions;

public abstract class ResultConvert<R extends Result, S extends Result>
{
  public final PendingResult newFailedPendingResult(Status paramStatus)
  {
    Preconditions.checkNotNull(paramStatus, "The input status cannot be null");
    if (!paramStatus.isSuccess()) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool, "The input status must be call with success status");
      return new FailPendingResult(paramStatus);
    }
  }
  
  public Status onFailed(Status paramStatus)
  {
    Preconditions.checkNotNull(paramStatus, "The input status cannot be null");
    if (paramStatus.getStatusCode() != 0) {
      return paramStatus;
    }
    return Status.CoreException;
  }
  
  public abstract PendingResult onSuccess(Result paramResult);
  
  public class FailPendingResult
    extends EmptyPendingResult
  {
    public FailPendingResult(Status paramStatus)
    {
      setResult(paramStatus);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hms.support.api.client.ResultConvert
 * JD-Core Version:    0.7.0.1
 */