package com.tencent.richmediabrowser.listener;

public abstract interface IDownloadEventListener
{
  public abstract void notifyProgress(String paramString, int paramInt);
  
  public abstract void notifyResult(String paramString, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.richmediabrowser.listener.IDownloadEventListener
 * JD-Core Version:    0.7.0.1
 */