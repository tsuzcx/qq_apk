package com.google.android.exoplayer2.ext.mediaplayer;

import android.os.Handler;

public class Repeater
{
  private Handler delayedHandler;
  private RepeatListener listener;
  private PollRunnable pollRunnable = new PollRunnable(null);
  private int repeatDelay = 1000;
  private volatile boolean repeaterRunning = false;
  
  Repeater(Handler paramHandler)
  {
    this.delayedHandler = paramHandler;
  }
  
  void setRepeatListener(RepeatListener paramRepeatListener)
  {
    this.listener = paramRepeatListener;
  }
  
  void setRepeaterDelay(int paramInt)
  {
    this.repeatDelay = paramInt;
  }
  
  void start()
  {
    if (!this.repeaterRunning)
    {
      this.repeaterRunning = true;
      this.pollRunnable.performPoll();
    }
  }
  
  void stop()
  {
    this.repeaterRunning = false;
  }
  
  class PollRunnable
    implements Runnable
  {
    private PollRunnable() {}
    
    void performPoll()
    {
      Repeater.this.delayedHandler.postDelayed(Repeater.this.pollRunnable, Repeater.this.repeatDelay);
    }
    
    public void run()
    {
      if (Repeater.this.listener != null) {
        Repeater.this.listener.onUpdate();
      }
      if (Repeater.this.repeaterRunning) {
        performPoll();
      }
    }
  }
  
  static abstract interface RepeatListener
  {
    public abstract void onUpdate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.ext.mediaplayer.Repeater
 * JD-Core Version:    0.7.0.1
 */