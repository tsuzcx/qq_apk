import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class avnf
  extends Handler
{
  avnf(avnd paramavnd, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 100001)
    {
      avnd.b(this.b);
      avnd.a(this.b).sendEmptyMessageDelayed(100001, 1000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avnf
 * JD-Core Version:    0.7.0.1
 */