import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class xas
  extends Handler
{
  xas(xar paramxar, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (this.a.a) {
      return;
    }
    xar.a(this.a, this.a.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xas
 * JD-Core Version:    0.7.0.1
 */