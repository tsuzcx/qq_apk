package btmsdkobf;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class ha
  extends Handler
{
  ha(db paramdb, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    hh localhh;
    do
    {
      return;
      paramMessage = (Object[])paramMessage.obj;
      localhh = (hh)paramMessage[0];
      if (localhh.b <= 0) {
        break;
      }
    } while (localhh.k == null);
    localhh.k.a(localhh.a, localhh.b, localhh.l, ((Integer)paramMessage[1]).intValue(), ((Integer)paramMessage[2]).intValue(), ((Integer)paramMessage[3]).intValue(), localhh.h);
    return;
    localhh.j.onFinish(localhh.l, ((Integer)paramMessage[1]).intValue(), ((Integer)paramMessage[2]).intValue(), ((Integer)paramMessage[3]).intValue(), localhh.g);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.ha
 * JD-Core Version:    0.7.0.1
 */