package tmsdk.common.d.a.b;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class D
  extends Handler
{
  D(z paramz, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1: 
      paramMessage = (m)paramMessage.obj;
      z.a(this.a, paramMessage);
      return;
    }
    paramMessage = (n)paramMessage.obj;
    z.a(this.a, paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.common.d.a.b.D
 * JD-Core Version:    0.7.0.1
 */