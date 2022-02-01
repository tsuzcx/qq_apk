package com.huawei.hms.support.api.client;

import com.huawei.hms.common.api.OptionalPendingResult;
import com.huawei.hms.common.api.internal.OptionalPendingResultImpl;

public final class PendingResultsCreator
{
  public static PendingResult<Status> discardedPendingResult()
  {
    return new DiscardedPendingResult();
  }
  
  public static <R extends Result> PendingResult<R> discardedPendingResult(R paramR)
  {
    return new DiscardedPendingResult(paramR);
  }
  
  public static <R extends Result> OptionalPendingResult<R> instantPendingResult(R paramR)
  {
    return new OptionalPendingResultImpl(new InstantPendingResult(paramR));
  }
  
  public static PendingResult<Status> instantPendingResult(Status paramStatus)
  {
    return new InstantPendingResult(paramStatus);
  }
  
  public static class DiscardedPendingResult<R extends Result>
    extends EmptyPendingResult
  {
    public DiscardedPendingResult() {}
    
    public DiscardedPendingResult(R paramR)
    {
      setResult(paramR);
    }
    
    public boolean isCanceled()
    {
      return true;
    }
  }
  
  public static class InstantPendingResult<R extends Result>
    extends EmptyPendingResult
  {
    public InstantPendingResult(R paramR)
    {
      setResult(paramR);
    }
    
    public void cancel()
    {
      throw new IllegalStateException("cancel() is not available.");
    }
    
    public void setResultCallback(ResultCallback paramResultCallback)
    {
      paramResultCallback.onResult(getResult());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hms.support.api.client.PendingResultsCreator
 * JD-Core Version:    0.7.0.1
 */