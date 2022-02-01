package com.huawei.hms.common.internal;

import com.huawei.hmf.tasks.TaskCompletionSource;

public class TaskApiCallWrapper<TResult>
  extends a
{
  private final TaskApiCall<? extends AnyClient, TResult> a;
  private final TaskCompletionSource<TResult> b;
  
  public TaskApiCallWrapper(TaskApiCall<? extends AnyClient, TResult> paramTaskApiCall, TaskCompletionSource<TResult> paramTaskCompletionSource)
  {
    super(1);
    this.a = paramTaskApiCall;
    this.b = paramTaskCompletionSource;
  }
  
  public TaskApiCall<? extends AnyClient, TResult> getTaskApiCall()
  {
    return this.a;
  }
  
  public TaskCompletionSource<TResult> getTaskCompletionSource()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hms.common.internal.TaskApiCallWrapper
 * JD-Core Version:    0.7.0.1
 */