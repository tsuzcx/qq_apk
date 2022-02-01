import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Pair;

class adxr
  extends Handler
{
  adxr(adxq paramadxq, Looper paramLooper)
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
    paramMessage = (Pair)paramMessage.obj;
    this.this$0.ao(((Long)paramMessage.first).longValue(), ((Long)paramMessage.second).longValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adxr
 * JD-Core Version:    0.7.0.1
 */