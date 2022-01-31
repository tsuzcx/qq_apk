package btmsdkobf;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class hk
  extends Handler
{
  hk(hi paramhi, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    ba localba = new ba();
    localba.df = -10000017;
    localba.dd = paramMessage.arg1;
    localba.bM = paramMessage.arg2;
    eh.h("SharkProtocolQueue", "[time_out]发送请求超时： seq: " + localba.dd + " cmdId: " + localba.bM);
    hi.a(this.a, localba);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.hk
 * JD-Core Version:    0.7.0.1
 */