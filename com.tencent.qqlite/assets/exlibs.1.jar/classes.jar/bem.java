import android.os.Handler;
import android.os.Message;
import android.view.View;
import com.tencent.mobileqq.activity.QQSetting;

public class bem
  extends Handler
{
  public bem(QQSetting paramQQSetting) {}
  
  public void handleMessage(Message paramMessage)
  {
    ((View)paramMessage.obj).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bem
 * JD-Core Version:    0.7.0.1
 */