import android.os.Handler;
import android.os.Message;
import android.view.View;
import com.tencent.mobileqq.activity.ChatForEnterpriseActivity;

public class chf
  extends Handler
{
  public chf(ChatForEnterpriseActivity paramChatForEnterpriseActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    if (ChatForEnterpriseActivity.a(this.a).isShown()) {
      ChatForEnterpriseActivity.a(this.a).setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     chf
 * JD-Core Version:    0.7.0.1
 */