import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class xph
  extends Handler
{
  xph(xpg paramxpg, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == xpg.bVS) {
      this.a.refresh();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xph
 * JD-Core Version:    0.7.0.1
 */