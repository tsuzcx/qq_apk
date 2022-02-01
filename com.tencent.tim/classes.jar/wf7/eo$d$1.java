package wf7;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class eo$d$1
  extends Handler
{
  eo$d$1(eo.d paramd, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    eq localeq = (eq)paramMessage.obj;
    ae localae = new ae();
    localae.cc = -11050000;
    localae.ca = paramMessage.what;
    if (localeq != null) {
      localae.bH = localeq.md;
    }
    eo.d.a(this.oY, localae);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wf7.eo.d.1
 * JD-Core Version:    0.7.0.1
 */