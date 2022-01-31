import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class xei
  extends Handler
{
  xei(xeh paramxeh, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if ((paramMessage.what == 203) && ((paramMessage.obj instanceof Bundle)))
    {
      paramMessage = (Bundle)paramMessage.obj;
      xeh.a(this.a, paramMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     xei
 * JD-Core Version:    0.7.0.1
 */