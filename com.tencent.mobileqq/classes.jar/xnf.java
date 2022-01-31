import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class xnf
  extends Handler
{
  xnf(xne paramxne, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if ((paramMessage.what == 203) && ((paramMessage.obj instanceof Bundle)))
    {
      paramMessage = (Bundle)paramMessage.obj;
      xne.a(this.a, paramMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     xnf
 * JD-Core Version:    0.7.0.1
 */