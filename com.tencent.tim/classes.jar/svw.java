import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class svw
  extends Handler
{
  svw(svv paramsvv, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if ((paramMessage.what == 203) && ((paramMessage.obj instanceof Bundle)))
    {
      paramMessage = (Bundle)paramMessage.obj;
      svv.a(this.this$0, paramMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     svw
 * JD-Core Version:    0.7.0.1
 */