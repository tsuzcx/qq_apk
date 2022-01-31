package com.weiyun.sdk;

public abstract interface IWyTaskManager
{
  public abstract Task createDownloadTask(String paramString1, String paramString2, long paramLong1, long paramLong2, Object paramObject);
  
  public abstract Task createUploadTask(String paramString, Object paramObject);
  
  public abstract Task findDownloadTask(String paramString);
  
  public abstract Task findUploadTask(String paramString);
  
  public abstract boolean submitTask(Task paramTask);
  
  public static abstract interface DownloadTask
    extends IWyTaskManager.Task
  {
    public abstract String getFilePath();
  }
  
  public static abstract interface Task
  {
    public abstract boolean addListener(IWyTaskManager.TaskListener paramTaskListener);
    
    public abstract boolean cancel();
    
    public abstract Object getContext();
    
    public abstract void removeListener(IWyTaskManager.TaskListener paramTaskListener);
  }
  
  public static abstract interface TaskListener
  {
    public abstract void onCanceled(IWyTaskManager.Task paramTask, Object paramObject);
    
    public abstract void onFailed(IWyTaskManager.Task paramTask, Object paramObject, IWyFileSystem.WyErrorStatus paramWyErrorStatus);
    
    public abstract void onProgressChange(IWyTaskManager.Task paramTask, Object paramObject, long paramLong1, long paramLong2);
    
    public abstract void onStarted(IWyTaskManager.Task paramTask, Object paramObject);
    
    public abstract void onSucceed(IWyTaskManager.Task paramTask, Object paramObject);
  }
  
  public static abstract interface UploadTask
    extends IWyTaskManager.Task
  {
    public abstract String getFileId();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.weiyun.sdk.IWyTaskManager
 * JD-Core Version:    0.7.0.1
 */