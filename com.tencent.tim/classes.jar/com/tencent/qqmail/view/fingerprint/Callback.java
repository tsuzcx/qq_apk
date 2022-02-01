package com.tencent.qqmail.view.fingerprint;

public abstract interface Callback
{
  public abstract void onAuthenticated();
  
  public abstract void onError();
  
  public abstract boolean onFail();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.view.fingerprint.Callback
 * JD-Core Version:    0.7.0.1
 */