import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class xni
  extends Handler
{
  xni(xnh paramxnh, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if ((paramMessage.what == 203) && ((paramMessage.obj instanceof Bundle)))
    {
      paramMessage = (Bundle)paramMessage.obj;
      xnh.a(this.a, paramMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     xni
 * JD-Core Version:    0.7.0.1
 */