package com.tencent.qqmail.ftn.request;

public abstract interface FtnRequest
{
  public abstract void abort();
  
  public abstract void goOn();
  
  public abstract boolean isAborted();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.request.FtnRequest
 * JD-Core Version:    0.7.0.1
 */