import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.app.SVIPHandler;
import com.tencent.mobileqq.app.SVIPHandler.OrderListener;
import com.tencent.qphone.base.util.QLog;
import java.util.WeakHashMap;

public class cvw
  extends Handler
{
  public cvw(SVIPHandler paramSVIPHandler, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    synchronized (this.a.a)
    {
      SVIPHandler.OrderListener localOrderListener = (SVIPHandler.OrderListener)this.a.a.remove(Integer.valueOf(paramMessage.arg1));
      if (QLog.isColorLevel()) {
        QLog.d("vip", 2, "Order buble id timeout");
      }
      if (localOrderListener != null)
      {
        SVIPHandler.a(this.a, true);
        localOrderListener.a(-1, paramMessage.arg2, null, null, null, null);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cvw
 * JD-Core Version:    0.7.0.1
 */