package com.tencent.moai.mailsdk.callback;

public abstract interface FolderSyncExchangeCallBack
{
  public abstract void onSyncStatusError(int paramInt1, int paramInt2, String paramString);
  
  public abstract void onSyncStatusSuccess(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.callback.FolderSyncExchangeCallBack
 * JD-Core Version:    0.7.0.1
 */