import android.os.Handler;
import android.os.Looper;
import android.os.Message;

final class aqfq
  extends Handler
{
  aqfq(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1: 
      aqfp.access$000();
      return;
    }
    aqfp.access$100();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqfq
 * JD-Core Version:    0.7.0.1
 */