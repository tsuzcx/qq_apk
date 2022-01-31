import android.os.Handler;
import com.tencent.mobileqq.activity.ChatForEnterpriseActivity;
import com.tencent.mobileqq.app.MessageObserver;

public class chg
  extends MessageObserver
{
  public chg(ChatForEnterpriseActivity paramChatForEnterpriseActivity) {}
  
  protected void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    ChatForEnterpriseActivity.a(this.a).sendEmptyMessage(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     chg
 * JD-Core Version:    0.7.0.1
 */