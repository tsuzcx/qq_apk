import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.ChatBackgroundSettingActivity;
import java.util.ArrayList;

public class aca
  extends Handler
{
  public aca(ChatBackgroundSettingActivity paramChatBackgroundSettingActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    if ((paramMessage.what == 1) && (this.a.a.size() == 0)) {
      this.a.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     aca
 * JD-Core Version:    0.7.0.1
 */