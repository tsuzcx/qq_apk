package com.tencent.qqmail.utilities.timer;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

public class TextChangeTimer
{
  private static final int TIMER_ID = 9;
  private Handler mHandler = new InnerHandler(this, Looper.getMainLooper());
  private OnTextChangeListener mListener;
  private TinyTimer textChangedSaveTimer = null;
  
  public void release()
  {
    stopTextChangedTimer();
    this.textChangedSaveTimer = null;
  }
  
  public void startTextChangedTimer(OnTextChangeListener paramOnTextChangeListener)
  {
    stopTextChangedTimer();
    this.mListener = paramOnTextChangeListener;
    if (this.textChangedSaveTimer == null) {
      this.textChangedSaveTimer = new TinyTimer();
    }
    this.textChangedSaveTimer.RunOnce(this.mHandler, 9, 400L);
  }
  
  public void stopTextChangedTimer()
  {
    if (this.textChangedSaveTimer != null) {
      this.textChangedSaveTimer.StopTimer();
    }
    this.mListener = null;
  }
  
  static final class InnerHandler
    extends Handler
  {
    private WeakReference<TextChangeTimer> mOuter;
    
    public InnerHandler(TextChangeTimer paramTextChangeTimer, Looper paramLooper)
    {
      super();
      this.mOuter = new WeakReference(paramTextChangeTimer);
    }
    
    public void handleMessage(Message paramMessage)
    {
      TextChangeTimer localTextChangeTimer = (TextChangeTimer)this.mOuter.get();
      if (localTextChangeTimer == null) {}
      while ((9 != paramMessage.what) || (localTextChangeTimer.mListener == null)) {
        return;
      }
      localTextChangeTimer.mListener.onTextChange();
    }
  }
  
  public static abstract interface OnTextChangeListener
  {
    public abstract void onTextChange();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.timer.TextChangeTimer
 * JD-Core Version:    0.7.0.1
 */