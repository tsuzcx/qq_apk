import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class uks
  extends Handler
{
  private ukq a;
  
  uks(Looper paramLooper, ukq paramukq)
  {
    super(paramLooper);
    this.a = paramukq;
  }
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1: 
      ukq.a(this.a);
      return;
    }
    ukq.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uks
 * JD-Core Version:    0.7.0.1
 */