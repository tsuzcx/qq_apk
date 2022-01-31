import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class zgn
  extends Handler
{
  zgn(zgm paramzgm, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if ((paramMessage.what == 203) && ((paramMessage.obj instanceof Bundle)))
    {
      paramMessage = (Bundle)paramMessage.obj;
      zgm.a(this.a, paramMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     zgn
 * JD-Core Version:    0.7.0.1
 */