package com.huawei.hmf.tasks;

public abstract interface ExecuteResult<TResult>
{
  public abstract void cancel();
  
  public abstract void onComplete(Task<TResult> paramTask);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hmf.tasks.ExecuteResult
 * JD-Core Version:    0.7.0.1
 */