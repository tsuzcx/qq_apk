import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class xgr
  extends Handler
{
  xgr(xgq paramxgq, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (this.a.a) {
      return;
    }
    xgq.a(this.a, this.a.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xgr
 * JD-Core Version:    0.7.0.1
 */