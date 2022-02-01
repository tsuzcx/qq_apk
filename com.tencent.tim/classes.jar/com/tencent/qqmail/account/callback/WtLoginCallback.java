package com.tencent.qqmail.account.callback;

public abstract interface WtLoginCallback
{
  public abstract void onError(int paramInt, String paramString1, String paramString2);
  
  public abstract void onSuccess(int paramInt, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.account.callback.WtLoginCallback
 * JD-Core Version:    0.7.0.1
 */