import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;

class thr
  implements Handler.Callback
{
  thr(thq paramthq) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
    case 0: 
    case 1: 
      do
      {
        do
        {
          return true;
          thq.a(this.a, false);
          thq.a(this.a).removeMessages(0);
        } while (thq.a(this.a) == null);
        thq.a(this.a).a(true);
        return true;
        thq.a(this.a, false);
        thq.a(this.a).removeMessages(1);
      } while (thq.a(this.a) == null);
      thq.a(this.a).a(false);
      return true;
    }
    thq.a(this.a, true);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     thr
 * JD-Core Version:    0.7.0.1
 */