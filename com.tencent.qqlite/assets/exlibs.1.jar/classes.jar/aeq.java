import android.text.TextUtils;
import com.tencent.mobileqq.activity.ChatSettingActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ShieldListObserver;
import com.tencent.mobileqq.managers.ShieldMsgManger;
import java.util.List;

public class aeq
  extends ShieldListObserver
{
  public aeq(ChatSettingActivity paramChatSettingActivity) {}
  
  protected void a(boolean paramBoolean, List paramList)
  {
    if (!ChatSettingActivity.b(this.a)) {}
    do
    {
      return;
      ChatSettingActivity.c(this.a, false);
      ChatSettingActivity.d(this.a);
    } while (!paramBoolean);
    paramList = (ShieldMsgManger)this.a.app.getManager(15);
    if ((paramList != null) && (!TextUtils.isEmpty(ChatSettingActivity.c(this.a)))) {
      ChatSettingActivity.b(this.a, paramList.a(ChatSettingActivity.c(this.a)));
    }
    ChatSettingActivity.b(this.a);
  }
  
  protected void b(boolean paramBoolean, List paramList)
  {
    if (!ChatSettingActivity.b(this.a)) {
      return;
    }
    ChatSettingActivity.c(this.a, false);
    ChatSettingActivity.d(this.a);
    if (paramBoolean)
    {
      paramList = (ShieldMsgManger)this.a.app.getManager(15);
      if ((paramList != null) && (!TextUtils.isEmpty(ChatSettingActivity.c(this.a)))) {
        ChatSettingActivity.b(this.a, paramList.a(ChatSettingActivity.c(this.a)));
      }
      ChatSettingActivity.b(this.a);
      return;
    }
    ChatSettingActivity.a(this.a, 2131363416, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     aeq
 * JD-Core Version:    0.7.0.1
 */