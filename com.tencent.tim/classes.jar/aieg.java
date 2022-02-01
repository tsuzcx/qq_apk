import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.ViewGroup;
import android.widget.ProgressBar;

class aieg
  extends Handler
{
  aieg(aidx paramaidx, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (aidx.a(this.a).getVisibility() != 0) {}
    int i;
    do
    {
      return;
      i = paramMessage.arg1;
    } while ((i < aidx.b(this.a)) || (i > 100));
    aidx.b(this.a, i);
    aidx.a(this.a).setProgress(aidx.b(this.a));
    paramMessage = Message.obtain();
    if (aidx.b(this.a) >= 90) {
      i += 1;
    }
    for (;;)
    {
      paramMessage.arg1 = i;
      sendMessageDelayed(paramMessage, 500L);
      return;
      i += 4;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aieg
 * JD-Core Version:    0.7.0.1
 */