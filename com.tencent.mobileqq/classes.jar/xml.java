import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class xml
  extends Handler
{
  xml(xmi paramxmi, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (!(paramMessage.obj instanceof bcgs)) {}
    while (paramMessage.what != 204) {
      return;
    }
    this.a.a((bcgs)paramMessage.obj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     xml
 * JD-Core Version:    0.7.0.1
 */