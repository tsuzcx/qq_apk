import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class xkm
  extends Handler
{
  xkm(xkl paramxkl, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (this.a.a) {
      return;
    }
    xkl.a(this.a, this.a.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xkm
 * JD-Core Version:    0.7.0.1
 */