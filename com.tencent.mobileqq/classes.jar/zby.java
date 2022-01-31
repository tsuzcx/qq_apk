import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class zby
  extends Handler
{
  zby(zbx paramzbx, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if ((paramMessage.what == 203) && ((paramMessage.obj instanceof Bundle)))
    {
      paramMessage = (Bundle)paramMessage.obj;
      zbx.a(this.a, paramMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     zby
 * JD-Core Version:    0.7.0.1
 */