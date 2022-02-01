import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.widget.AntiphingToast;
import java.util.TimerTask;

public class hfe
  extends TimerTask
{
  public hfe(AntiphingToast paramAntiphingToast) {}
  
  public void run()
  {
    Message localMessage = new Message();
    localMessage.what = 1;
    this.a.a.sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     hfe
 * JD-Core Version:    0.7.0.1
 */