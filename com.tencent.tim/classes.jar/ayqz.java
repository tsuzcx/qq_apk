import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class ayqz
  extends Handler
{
  ayqz(ayqy paramayqy, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1000)
    {
      paramMessage = (String)paramMessage.obj;
      this.this$0.co(paramMessage);
    }
    while ((paramMessage.what != 1002) || (this.this$0.a == null)) {
      return;
    }
    this.this$0.a.eRh();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayqz
 * JD-Core Version:    0.7.0.1
 */