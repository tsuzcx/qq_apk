import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class zfq
  extends Handler
{
  zfq(zfn paramzfn, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (!(paramMessage.obj instanceof bekq)) {}
    while (paramMessage.what != 204) {
      return;
    }
    this.a.a((bekq)paramMessage.obj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     zfq
 * JD-Core Version:    0.7.0.1
 */