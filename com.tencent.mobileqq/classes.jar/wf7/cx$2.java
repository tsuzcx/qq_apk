package wf7;

import android.os.Looper;
import android.os.Message;

class cx$2
  extends bt
{
  cx$2(cx paramcx, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage != null)
    {
      int i = paramMessage.what;
      if (i != 0)
      {
        if (i != 1) {
          return;
        }
        this.jn.iZ = false;
        return;
      }
      paramMessage = this.jn;
      cx.a(paramMessage, paramMessage.jc, this.jn.jd, this.jn.je);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wf7.cx.2
 * JD-Core Version:    0.7.0.1
 */