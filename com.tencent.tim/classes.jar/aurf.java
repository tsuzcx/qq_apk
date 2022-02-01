import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;
import mqq.os.MqqHandler;

public class aurf
  extends MqqHandler
{
  private WeakReference<Handler.Callback> mWeakReferCallBack;
  
  public aurf(Handler.Callback paramCallback)
  {
    this.mWeakReferCallBack = new WeakReference(paramCallback);
  }
  
  public aurf(Looper paramLooper, Handler.Callback paramCallback)
  {
    super(paramLooper);
    this.mWeakReferCallBack = new WeakReference(paramCallback);
  }
  
  public aurf(Looper paramLooper, Handler.Callback paramCallback, boolean paramBoolean)
  {
    super(paramLooper, null, paramBoolean);
    this.mWeakReferCallBack = new WeakReference(paramCallback);
  }
  
  public void handleMessage(Message paramMessage)
  {
    Handler.Callback localCallback = (Handler.Callback)this.mWeakReferCallBack.get();
    if (localCallback != null) {
      localCallback.handleMessage(paramMessage);
    }
  }
  
  public String toString()
  {
    Handler.Callback localCallback = (Handler.Callback)this.mWeakReferCallBack.get();
    return super.toString() + " " + localCallback;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aurf
 * JD-Core Version:    0.7.0.1
 */