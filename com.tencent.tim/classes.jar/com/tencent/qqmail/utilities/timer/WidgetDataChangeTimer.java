package com.tencent.qqmail.utilities.timer;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

public class WidgetDataChangeTimer
{
  private static final int TIMER_ID = 9;
  private Handler mHandler = new InnerHandler(this, Looper.getMainLooper());
  private OnDataChangeListener mListener;
  private TinyTimer widgetDataChangeTimer = null;
  
  public void release()
  {
    stopWidgetDataChangeTimer();
    this.widgetDataChangeTimer = null;
  }
  
  public void startWidgetDataChangeTimer(OnDataChangeListener paramOnDataChangeListener, long paramLong)
  {
    stopWidgetDataChangeTimer();
    this.mListener = paramOnDataChangeListener;
    if (this.widgetDataChangeTimer == null) {
      this.widgetDataChangeTimer = new TinyTimer();
    }
    this.widgetDataChangeTimer.RunOnce(this.mHandler, 9, paramLong);
  }
  
  public void stopWidgetDataChangeTimer()
  {
    if (this.widgetDataChangeTimer != null) {
      this.widgetDataChangeTimer.StopTimer();
    }
    this.mListener = null;
  }
  
  static final class InnerHandler
    extends Handler
  {
    private WeakReference<WidgetDataChangeTimer> mOuter;
    
    public InnerHandler(WidgetDataChangeTimer paramWidgetDataChangeTimer, Looper paramLooper)
    {
      super();
      this.mOuter = new WeakReference(paramWidgetDataChangeTimer);
    }
    
    public void handleMessage(Message paramMessage)
    {
      WidgetDataChangeTimer localWidgetDataChangeTimer = (WidgetDataChangeTimer)this.mOuter.get();
      if (localWidgetDataChangeTimer == null) {}
      while ((9 != paramMessage.what) || (localWidgetDataChangeTimer.mListener == null)) {
        return;
      }
      localWidgetDataChangeTimer.mListener.notifyDataChange();
    }
  }
  
  public static abstract interface OnDataChangeListener
  {
    public abstract void notifyDataChange();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.timer.WidgetDataChangeTimer
 * JD-Core Version:    0.7.0.1
 */