package com.tencent.component.network.utils.thread;

public abstract interface FutureListener<T>
{
  public abstract void onFutureBegin(Future<T> paramFuture);
  
  public abstract void onFutureDone(Future<T> paramFuture);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.component.network.utils.thread.FutureListener
 * JD-Core Version:    0.7.0.1
 */