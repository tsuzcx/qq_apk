import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.phone.BaseActivityView;
import java.lang.ref.WeakReference;

public class wtf
  extends Handler
{
  private WeakReference a;
  
  public wtf(BaseActivityView paramBaseActivityView)
  {
    this.a = new WeakReference(paramBaseActivityView);
  }
  
  public void handleMessage(Message paramMessage)
  {
    boolean bool = true;
    BaseActivityView localBaseActivityView = (BaseActivityView)this.a.get();
    if (localBaseActivityView == null) {
      return;
    }
    switch (paramMessage.what)
    {
    default: 
      throw new RuntimeException("Unknown message: " + paramMessage.what);
    case 1: 
      int i = paramMessage.arg1;
      if (paramMessage.arg2 == 1) {}
      for (;;)
      {
        localBaseActivityView.b(i, bool);
        return;
        bool = false;
      }
    case 2: 
      localBaseActivityView.f();
      return;
    }
    localBaseActivityView.i();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wtf
 * JD-Core Version:    0.7.0.1
 */