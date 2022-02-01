package wf7;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class em$3
  extends Handler
{
  em$3(em paramem, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    if (paramMessage.what != 1) {
      return;
    }
    em.b(this.nm, (em.d)paramMessage.obj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wf7.em.3
 * JD-Core Version:    0.7.0.1
 */