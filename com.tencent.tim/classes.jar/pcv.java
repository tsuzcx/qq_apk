import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class pcv
  extends Handler
{
  pcv(pcu parampcu, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage == null) {
      return;
    }
    switch (paramMessage.what)
    {
    default: 
      return;
    case 4097: 
      pcu.a(this.this$0);
      return;
    }
    pcu.b(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pcv
 * JD-Core Version:    0.7.0.1
 */