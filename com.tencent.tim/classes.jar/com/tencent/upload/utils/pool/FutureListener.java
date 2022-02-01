package com.tencent.upload.utils.pool;

public abstract interface FutureListener<T>
{
  public abstract void onFutureDone(Future<T> paramFuture);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.upload.utils.pool.FutureListener
 * JD-Core Version:    0.7.0.1
 */