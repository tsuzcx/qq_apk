package tmsdk.common.d.a.b;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class F
  extends Handler
{
  F(z paramz, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    z.a(this.a, -50004, 0, paramMessage.what, 0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.common.d.a.b.F
 * JD-Core Version:    0.7.0.1
 */