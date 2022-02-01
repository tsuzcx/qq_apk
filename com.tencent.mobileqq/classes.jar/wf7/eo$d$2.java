package wf7;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class eo$d$2
  extends Handler
{
  eo$d$2(eo.d paramd, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 1) {
      return;
    }
    ae localae = new ae();
    localae.cc = -10000017;
    localae.ca = paramMessage.arg1;
    localae.bH = paramMessage.arg2;
    eo.d.a(this.oY, localae);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     wf7.eo.d.2
 * JD-Core Version:    0.7.0.1
 */