package wf7;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class ei$1
  extends Handler
{
  ei$1(ei paramei, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 1) {
      return;
    }
    ei.a(this.mu);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     wf7.ei.1
 * JD-Core Version:    0.7.0.1
 */