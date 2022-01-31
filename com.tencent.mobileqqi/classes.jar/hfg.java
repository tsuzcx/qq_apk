import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.widget.CameraFrameLayout;

public class hfg
  extends Handler
{
  public hfg(CameraFrameLayout paramCameraFrameLayout) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1: 
      CameraFrameLayout.a(this.a, paramMessage.arg1);
      return;
    }
    CameraFrameLayout.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     hfg
 * JD-Core Version:    0.7.0.1
 */