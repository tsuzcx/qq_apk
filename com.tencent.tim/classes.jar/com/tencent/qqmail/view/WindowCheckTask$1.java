package com.tencent.qqmail.view;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

class WindowCheckTask$1
  extends Handler
{
  WindowCheckTask$1(WindowCheckTask paramWindowCheckTask, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  private void handleResult(boolean paramBoolean, long paramLong)
  {
    if (paramBoolean) {}
    try
    {
      Log.d("tagorewang:WindowCheckTask", "target view is obscured");
      if (WindowCheckTask.access$000(this.this$0) == null) {
        return;
      }
      WindowCheckTask.access$000(this.this$0).onCallbackWhenObscured();
      return;
    }
    catch (Exception localException)
    {
      Log.w("tagorewang:WindowCheckTask", "onPostExecute err: ", localException);
    }
    Log.w("tagorewang:WindowCheckTask", "target view is brought to front");
    if (WindowCheckTask.access$000(this.this$0) != null)
    {
      WindowCheckTask.access$000(this.this$0).onCallbackWhenBroughtToFront(paramLong);
      return;
    }
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    if (paramMessage.arg1 != 0) {}
    for (boolean bool = true;; bool = false)
    {
      handleResult(bool, paramMessage.arg2);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.view.WindowCheckTask.1
 * JD-Core Version:    0.7.0.1
 */