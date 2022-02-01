package com.tencent.qqmini.minigame.ui;

import android.support.annotation.NonNull;

public class LoadingStatus
{
  private String message = "";
  private float progress = 0.0F;
  
  public String getMessage()
  {
    return this.message;
  }
  
  public String getProcessInPercentage()
  {
    return (int)(this.progress * 100.0F) + "%";
  }
  
  public float getProgress()
  {
    return this.progress;
  }
  
  public boolean isInProgress()
  {
    return (this.progress > 0.0F) && (this.progress < 1.0F);
  }
  
  @NonNull
  public String toString()
  {
    return "LoadingStatus {progress=" + this.progress + "} ";
  }
  
  public static class Builder
  {
    private LoadingStatus mStatus = new LoadingStatus(null);
    
    public LoadingStatus build()
    {
      return this.mStatus;
    }
    
    public Builder setMessage(String paramString)
    {
      LoadingStatus.access$102(this.mStatus, paramString);
      return this;
    }
    
    public Builder setProgress(float paramFloat)
    {
      LoadingStatus.access$202(this.mStatus, paramFloat);
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.minigame.ui.LoadingStatus
 * JD-Core Version:    0.7.0.1
 */