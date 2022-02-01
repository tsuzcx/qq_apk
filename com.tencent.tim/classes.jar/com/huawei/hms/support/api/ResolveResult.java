package com.huawei.hms.support.api;

import com.huawei.hms.support.api.client.Result;

public class ResolveResult<T>
  extends Result
{
  private T entity;
  
  public ResolveResult()
  {
    this.entity = null;
  }
  
  public ResolveResult(T paramT)
  {
    this.entity = paramT;
  }
  
  public T getValue()
  {
    return this.entity;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hms.support.api.ResolveResult
 * JD-Core Version:    0.7.0.1
 */