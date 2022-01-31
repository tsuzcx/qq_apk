import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.PermisionPrivacyActivity;
import java.lang.ref.WeakReference;

public class dfe
  extends Handler
{
  private WeakReference a;
  
  public dfe(PermisionPrivacyActivity paramPermisionPrivacyActivity)
  {
    this.a = new WeakReference(paramPermisionPrivacyActivity);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if ((PermisionPrivacyActivity)this.a.get() == null) {
      return;
    }
    switch (paramMessage.what)
    {
    }
    throw new RuntimeException("Unknown message: " + paramMessage.what);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dfe
 * JD-Core Version:    0.7.0.1
 */