package btmsdkobf;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class hj
  extends Handler
{
  hj(hi paramhi, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    hw localhw = (hw)paramMessage.obj;
    ba localba = new ba();
    localba.df = -11050000;
    localba.dd = paramMessage.what;
    if (localhw != null) {
      localba.bM = localhw.a;
    }
    eh.h("SharkProtocolQueue", "接收超时：seq: " + localba.dd + " cmdId: " + localba.bM);
    hi.a(this.a, localba);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.hj
 * JD-Core Version:    0.7.0.1
 */