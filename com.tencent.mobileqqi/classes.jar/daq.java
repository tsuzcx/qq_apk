import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.PublicAccountActivity;
import com.tencent.widget.XListView;
import java.lang.ref.WeakReference;

public class daq
  extends Handler
{
  private WeakReference a;
  
  public daq(PublicAccountActivity paramPublicAccountActivity)
  {
    this.a = new WeakReference(paramPublicAccountActivity);
  }
  
  public void handleMessage(Message paramMessage)
  {
    PublicAccountActivity localPublicAccountActivity = (PublicAccountActivity)this.a.get();
    if (localPublicAccountActivity == null) {
      return;
    }
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1: 
      localPublicAccountActivity.a.B();
      return;
    case 2: 
      localPublicAccountActivity.a.B();
      localPublicAccountActivity.a(1, localPublicAccountActivity.getString(2131562097));
      return;
    }
    localPublicAccountActivity.a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     daq
 * JD-Core Version:    0.7.0.1
 */