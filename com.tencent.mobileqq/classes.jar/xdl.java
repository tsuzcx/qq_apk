import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class xdl
  extends Handler
{
  xdl(xdi paramxdi, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (!(paramMessage.obj instanceof bbds)) {}
    while (paramMessage.what != 204) {
      return;
    }
    this.a.a((bbds)paramMessage.obj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     xdl
 * JD-Core Version:    0.7.0.1
 */