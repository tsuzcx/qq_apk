import android.os.Handler;
import android.os.Message;
import android.widget.FrameLayout;
import com.tencent.mobileqq.widget.AntiphingToast;

public class hfc
  extends Handler
{
  public hfc(AntiphingToast paramAntiphingToast) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1) {
      this.a.a(0.0F, 0 - AntiphingToast.a(this.a).getHeight(), true);
    }
    super.handleMessage(paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     hfc
 * JD-Core Version:    0.7.0.1
 */