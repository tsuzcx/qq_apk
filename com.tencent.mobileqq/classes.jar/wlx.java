import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class wlx
  extends Handler
{
  wlx(wlw paramwlw, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (this.a.a) {
      return;
    }
    wlw.a(this.a, this.a.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wlx
 * JD-Core Version:    0.7.0.1
 */