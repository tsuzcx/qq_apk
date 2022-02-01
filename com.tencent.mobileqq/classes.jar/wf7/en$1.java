package wf7;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class en$1
  extends Handler
{
  en$1(en paramen, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 11) {
      return;
    }
    paramMessage = (Object[])paramMessage.obj;
    en.a locala = (en.a)paramMessage[0];
    if (locala.oi != null) {
      locala.oi.a(((Integer)paramMessage[1]).intValue(), locala.gV, ((Integer)paramMessage[2]).intValue(), ((Integer)paramMessage[3]).intValue(), locala.og);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     wf7.en.1
 * JD-Core Version:    0.7.0.1
 */