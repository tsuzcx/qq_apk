package com.tencent.qqmail.view;

import android.os.Handler;
import android.os.Message;
import android.widget.ProgressBar;
import com.nineoldandroids.animation.ObjectAnimator;

public class ProgressHandler
  extends Handler
{
  public static final int PROGRESS_GONE = 1;
  public static final int PROGRESS_PROCESS = 0;
  private ObjectAnimator animator;
  private int dstProgressIndex;
  private int duration;
  private ProgressBar progressBar;
  
  public ProgressHandler(ProgressBar paramProgressBar)
  {
    this.progressBar = paramProgressBar;
  }
  
  public int getDstProgressIndex()
  {
    return this.dstProgressIndex;
  }
  
  public int getDuration()
  {
    return this.duration;
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 0: 
      this.dstProgressIndex = paramMessage.arg1;
      this.duration = paramMessage.arg2;
      this.progressBar.setVisibility(0);
      if ((this.animator != null) && (this.animator.isRunning())) {
        this.animator.cancel();
      }
      this.animator = ObjectAnimator.ofInt(this.progressBar, "progress", new int[] { this.dstProgressIndex });
      this.animator.setDuration(this.duration);
      this.animator.addListener(new ProgressHandler.1(this));
      this.animator.start();
      return;
    }
    this.dstProgressIndex = 0;
    this.duration = 0;
    this.progressBar.setProgress(0);
    this.progressBar.setVisibility(8);
    if ((this.animator != null) && (this.animator.isRunning())) {
      this.animator.cancel();
    }
    this.animator = ObjectAnimator.ofInt(this.progressBar, "progress", new int[] { 0 });
    this.animator.setDuration(0L);
    this.animator.removeAllListeners();
  }
  
  public void postProgressHandler(int paramInt1, int paramInt2, int paramInt3)
  {
    Message localMessage = new Message();
    localMessage.what = paramInt1;
    localMessage.arg1 = paramInt2;
    localMessage.arg2 = paramInt3;
    sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.view.ProgressHandler
 * JD-Core Version:    0.7.0.1
 */