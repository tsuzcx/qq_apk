import android.os.Handler;
import android.os.Message;
import android.widget.FrameLayout;
import com.tencent.mobileqq.widget.AntiphingToast;

public class exg
  extends Handler
{
  public exg(AntiphingToast paramAntiphingToast) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1) {
      this.a.a(0.0F, 0 - AntiphingToast.a(this.a).getHeight(), true);
    }
    super.handleMessage(paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     exg
 * JD-Core Version:    0.7.0.1
 */