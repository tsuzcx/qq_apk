import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;
import mqq.os.MqqHandler;

public class aqgw
  extends MqqHandler
{
  private final WeakReference<Handler.Callback> callbackRef;
  
  public aqgw(Handler.Callback paramCallback)
  {
    this.callbackRef = new WeakReference(paramCallback);
  }
  
  public aqgw(Looper paramLooper, Handler.Callback paramCallback)
  {
    super(paramLooper);
    this.callbackRef = new WeakReference(paramCallback);
  }
  
  public void handleMessage(Message paramMessage)
  {
    Handler.Callback localCallback = (Handler.Callback)this.callbackRef.get();
    if (localCallback != null) {
      localCallback.handleMessage(paramMessage);
    }
  }
  
  public String toString()
  {
    Handler.Callback localCallback = (Handler.Callback)this.callbackRef.get();
    return super.toString() + " " + localCallback;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqgw
 * JD-Core Version:    0.7.0.1
 */