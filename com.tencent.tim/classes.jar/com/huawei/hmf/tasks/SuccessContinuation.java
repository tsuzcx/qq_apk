package com.huawei.hmf.tasks;

public abstract interface SuccessContinuation<TResult, TContinuationResult>
{
  public abstract Task<TContinuationResult> then(TResult paramTResult)
    throws Exception;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hmf.tasks.SuccessContinuation
 * JD-Core Version:    0.7.0.1
 */