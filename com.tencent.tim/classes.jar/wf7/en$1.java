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
    switch (paramMessage.what)
    {
    }
    en.a locala;
    do
    {
      return;
      paramMessage = (Object[])paramMessage.obj;
      locala = (en.a)paramMessage[0];
    } while (locala.oi == null);
    locala.oi.a(((Integer)paramMessage[1]).intValue(), locala.gV, ((Integer)paramMessage[2]).intValue(), ((Integer)paramMessage[3]).intValue(), locala.og);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wf7.en.1
 * JD-Core Version:    0.7.0.1
 */