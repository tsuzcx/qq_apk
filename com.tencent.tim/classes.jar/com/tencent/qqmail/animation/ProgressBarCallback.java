package com.tencent.qqmail.animation;

public class ProgressBarCallback
{
  private int bindCode = -1;
  private boolean finish = false;
  private IBeforeCallback onBefore;
  private ICompleteCallback onComplete;
  private IProgressCallback onProgress;
  private IScheduleCallback onSchedule;
  private int progress = 0;
  private int schedule = 0;
  private String tag = "";
  
  public IBeforeCallback getBeforeCallback()
  {
    return this.onBefore;
  }
  
  public int getCode()
  {
    return this.bindCode;
  }
  
  public ICompleteCallback getCompleteCallback()
  {
    return this.onComplete;
  }
  
  public int getProgress()
  {
    return this.progress;
  }
  
  public IProgressCallback getProgressCallback()
  {
    return this.onProgress;
  }
  
  public int getSchedule()
  {
    return this.schedule;
  }
  
  public IScheduleCallback getScheduleCallback()
  {
    return this.onSchedule;
  }
  
  public String getTag()
  {
    return this.tag;
  }
  
  public void handleBefore()
  {
    if (this.onBefore != null) {
      this.onBefore.run();
    }
  }
  
  public void handleComplete(int paramInt)
  {
    if (this.onComplete != null) {
      this.onComplete.run(paramInt);
    }
  }
  
  public void handleProgress(int paramInt)
  {
    if (this.onProgress != null) {
      this.onProgress.run(paramInt);
    }
  }
  
  public void handleSchedule(int paramInt)
  {
    if (this.onSchedule != null) {
      this.onSchedule.run(paramInt);
    }
  }
  
  public boolean isTaskFinish()
  {
    return this.finish;
  }
  
  public void setBeforeCallback(IBeforeCallback paramIBeforeCallback)
  {
    this.onBefore = paramIBeforeCallback;
  }
  
  public void setCode(int paramInt)
  {
    this.bindCode = paramInt;
  }
  
  public void setCompleteCallback(ICompleteCallback paramICompleteCallback)
  {
    this.onComplete = paramICompleteCallback;
  }
  
  public void setProgress(int paramInt)
  {
    this.progress = paramInt;
  }
  
  public void setProgressCallback(IProgressCallback paramIProgressCallback)
  {
    this.onProgress = paramIProgressCallback;
  }
  
  public void setSchedule(int paramInt)
  {
    this.schedule = paramInt;
  }
  
  public void setScheduleCallback(IScheduleCallback paramIScheduleCallback)
  {
    this.onSchedule = paramIScheduleCallback;
  }
  
  public void setTag(String paramString)
  {
    this.tag = paramString;
  }
  
  public void setTaskFinish(boolean paramBoolean)
  {
    this.finish = paramBoolean;
  }
  
  public static abstract interface IBeforeCallback
  {
    public abstract void run();
  }
  
  public static abstract interface ICompleteCallback
  {
    public abstract void run(int paramInt);
  }
  
  public static abstract interface IProgressCallback
  {
    public abstract void run(int paramInt);
  }
  
  public static abstract interface IScheduleCallback
  {
    public abstract void run(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.animation.ProgressBarCallback
 * JD-Core Version:    0.7.0.1
 */