package wf7;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class eh$a
  extends Handler
{
  public eh$a(eh parameh, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 1) {
      return;
    }
    eh.a(this.ml);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     wf7.eh.a
 * JD-Core Version:    0.7.0.1
 */