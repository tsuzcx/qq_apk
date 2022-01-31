import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class xmi
  extends Handler
{
  xmi(xmf paramxmf, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (!(paramMessage.obj instanceof bchg)) {}
    while (paramMessage.what != 204) {
      return;
    }
    this.a.a((bchg)paramMessage.obj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     xmi
 * JD-Core Version:    0.7.0.1
 */