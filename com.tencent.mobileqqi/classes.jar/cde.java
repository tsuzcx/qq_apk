import android.text.TextUtils;
import com.tencent.mobileqq.activity.ChatSettingActivity;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.model.FriendManager;

public class cde
  extends CardObserver
{
  public cde(ChatSettingActivity paramChatSettingActivity) {}
  
  protected void a(boolean paramBoolean, Object paramObject)
  {
    if ((paramObject instanceof Card)) {}
    for (paramObject = (Card)paramObject;; paramObject = null)
    {
      if ((paramBoolean) && (paramObject != null))
      {
        if ((ChatSettingActivity.a(this.a) == 0) && (ChatSettingActivity.a(this.a).equals(paramObject.uin)))
        {
          String str = ((FriendManager)this.a.b.getManager(8)).b(ChatSettingActivity.a(this.a));
          if ((!TextUtils.isEmpty(str)) && (!str.equals(ChatSettingActivity.f(this.a)))) {
            ChatSettingActivity.c(this.a, str);
          }
        }
        if ((this.a.a != null) && (!TextUtils.isEmpty(ChatSettingActivity.a(this.a))) && (ChatSettingActivity.a(this.a).equals(paramObject.uin))) {
          ChatSettingActivity.a(this.a, ChatSettingActivity.a(this.a, ChatSettingActivity.a(this.a)), this.a.a);
        }
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     cde
 * JD-Core Version:    0.7.0.1
 */