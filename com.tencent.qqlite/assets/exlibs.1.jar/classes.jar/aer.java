import com.tencent.mobileqq.activity.ChatSettingActivity;
import com.tencent.mobileqq.app.MessageObserver;

public class aer
  extends MessageObserver
{
  public aer(ChatSettingActivity paramChatSettingActivity) {}
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if (!ChatSettingActivity.b(this.a)) {
      return;
    }
    ChatSettingActivity.c(this.a, false);
    ChatSettingActivity.d(this.a);
    if (paramBoolean)
    {
      if ((paramString != null) && (paramString.equals(ChatSettingActivity.c(this.a)))) {
        ChatSettingActivity.b(this.a, true);
      }
      ChatSettingActivity.b(this.a);
      return;
    }
    ChatSettingActivity.a(this.a, 2131363415, 1);
  }
  
  protected void b(boolean paramBoolean, String paramString)
  {
    if (!ChatSettingActivity.b(this.a)) {
      return;
    }
    ChatSettingActivity.c(this.a, false);
    ChatSettingActivity.d(this.a);
    if (paramBoolean)
    {
      if ((paramString != null) && (paramString.equals(ChatSettingActivity.c(this.a)))) {
        ChatSettingActivity.b(this.a, false);
      }
      ChatSettingActivity.b(this.a);
      return;
    }
    ChatSettingActivity.a(this.a, 2131363415, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     aer
 * JD-Core Version:    0.7.0.1
 */