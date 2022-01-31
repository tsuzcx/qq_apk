package wf7;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class eo$1
  extends Handler
{
  eo$1(eo parameo, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    eo.c localc;
    do
    {
      return;
      paramMessage = (Object[])paramMessage.obj;
      localc = (eo.c)paramMessage[0];
      if (localc.ob <= 0) {
        break;
      }
    } while (localc.oO == null);
    localc.oO.a(localc.nL, localc.ob, localc.oP, ((Integer)paramMessage[1]).intValue(), ((Integer)paramMessage[2]).intValue(), ((Integer)paramMessage[3]).intValue(), localc.oN);
    return;
    localc.oi.a(localc.oP, ((Integer)paramMessage[1]).intValue(), ((Integer)paramMessage[2]).intValue(), ((Integer)paramMessage[3]).intValue(), localc.og);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     wf7.eo.1
 * JD-Core Version:    0.7.0.1
 */