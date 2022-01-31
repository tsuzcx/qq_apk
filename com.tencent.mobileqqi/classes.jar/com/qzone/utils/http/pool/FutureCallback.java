package com.qzone.utils.http.pool;

public abstract interface FutureCallback<T>
{
  public abstract void cancelled();
  
  public abstract void completed(T paramT);
  
  public abstract void failed(Exception paramException);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.qzone.utils.http.pool.FutureCallback
 * JD-Core Version:    0.7.0.1
 */