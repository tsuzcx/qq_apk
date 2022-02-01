import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class auru
  extends Handler
{
  private WeakReference<Handler.Callback> mWeakReferCallBack;
  
  public auru(Handler.Callback paramCallback)
  {
    this.mWeakReferCallBack = new WeakReference(paramCallback);
  }
  
  public auru(Looper paramLooper, Handler.Callback paramCallback)
  {
    super(paramLooper);
    this.mWeakReferCallBack = new WeakReference(paramCallback);
  }
  
  public void handleMessage(Message paramMessage)
  {
    Handler.Callback localCallback = (Handler.Callback)this.mWeakReferCallBack.get();
    if (localCallback != null) {
      localCallback.handleMessage(paramMessage);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("WeakReferenceHandler", 2, "handleMessage cb is null! handler = " + this);
  }
  
  public String toString()
  {
    Object localObject = (Handler.Callback)this.mWeakReferCallBack.get();
    StringBuilder localStringBuilder = new StringBuilder().append("WH");
    if (localObject != null) {}
    for (localObject = localObject.toString();; localObject = "None callback") {
      return (String)localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     auru
 * JD-Core Version:    0.7.0.1
 */