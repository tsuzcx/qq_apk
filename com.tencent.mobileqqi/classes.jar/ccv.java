import com.tencent.mobileqq.activity.ChatSettingActivity;
import com.tencent.mobileqq.app.MessageObserver;

public class ccv
  extends MessageObserver
{
  public ccv(ChatSettingActivity paramChatSettingActivity) {}
  
  protected void b(boolean paramBoolean, String paramString)
  {
    if (!ChatSettingActivity.c(this.a)) {
      return;
    }
    ChatSettingActivity.c(this.a, false);
    ChatSettingActivity.e(this.a);
    if (paramBoolean)
    {
      if ((paramString != null) && (paramString.equals(ChatSettingActivity.d(this.a)))) {
        ChatSettingActivity.b(this.a, true);
      }
      ChatSettingActivity.c(this.a);
      return;
    }
    ChatSettingActivity.a(this.a, 2131562919, 1);
  }
  
  protected void c(boolean paramBoolean, String paramString)
  {
    if (!ChatSettingActivity.c(this.a)) {
      return;
    }
    ChatSettingActivity.c(this.a, false);
    ChatSettingActivity.e(this.a);
    if (paramBoolean)
    {
      if ((paramString != null) && (paramString.equals(ChatSettingActivity.d(this.a)))) {
        ChatSettingActivity.b(this.a, false);
      }
      ChatSettingActivity.c(this.a);
      return;
    }
    ChatSettingActivity.a(this.a, 2131562919, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     ccv
 * JD-Core Version:    0.7.0.1
 */