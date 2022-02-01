import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class umw
  extends Handler
{
  umw(umv paramumv, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    umv.a(this.a);
    umv.a(this.a).sendEmptyMessageDelayed(2, 1100L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     umw
 * JD-Core Version:    0.7.0.1
 */