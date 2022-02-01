import android.text.TextUtils;
import com.tencent.mobileqq.activity.ChatSettingActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class uoy
  extends aclp
{
  public uoy(ChatSettingActivity paramChatSettingActivity) {}
  
  protected void t(boolean paramBoolean, List<Long> paramList)
  {
    if (!ChatSettingActivity.c(this.this$0))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.this$0.aLY, 2, "onAddShieldList, mShieldByThis=" + ChatSettingActivity.c(this.this$0));
      }
      return;
    }
    ChatSettingActivity.c(this.this$0, false);
    ChatSettingActivity.g(this.this$0);
    paramList = this.this$0;
    ChatSettingActivity localChatSettingActivity = this.this$0;
    if (paramBoolean) {}
    for (int i = 2131720219;; i = 2131720207)
    {
      QQToast.a(paramList, 2, localChatSettingActivity.getString(i), 0).show(this.this$0.getTitleBarHeight());
      if (QLog.isColorLevel()) {
        QLog.d(this.this$0.aLY, 2, "onAddShieldList, isSuccess=" + paramBoolean + ", mShieldByThis=" + ChatSettingActivity.c(this.this$0) + ", mShieldUin=" + ChatSettingActivity.d(this.this$0) + ", mIsShield=" + ChatSettingActivity.a(this.this$0));
      }
      if (!paramBoolean) {
        break;
      }
      paramList = (aizg)this.this$0.app.getManager(16);
      if ((paramList != null) && (!TextUtils.isEmpty(ChatSettingActivity.d(this.this$0)))) {
        ChatSettingActivity.a(this.this$0, paramList.nf(ChatSettingActivity.d(this.this$0)));
      }
      ChatSettingActivity.b(this.this$0);
      if (ChatSettingActivity.a(this.this$0))
      {
        this.this$0.mIsFollowed = false;
        ChatSettingActivity.a(this.this$0);
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d(this.this$0.aLY, 2, "onAddShieldList, mIsShield=" + ChatSettingActivity.a(this.this$0) + ", mIsFollowed=" + this.this$0.mIsFollowed);
      return;
    }
  }
  
  protected void u(boolean paramBoolean, List<Long> paramList)
  {
    if (!ChatSettingActivity.c(this.this$0)) {
      return;
    }
    ChatSettingActivity.c(this.this$0, false);
    ChatSettingActivity.g(this.this$0);
    paramList = this.this$0;
    ChatSettingActivity localChatSettingActivity = this.this$0;
    if (paramBoolean) {}
    for (int i = 2131720206;; i = 2131720205)
    {
      QQToast.a(paramList, 2, localChatSettingActivity.getString(i), 0).show(this.this$0.getTitleBarHeight());
      if (QLog.isColorLevel()) {
        QLog.d(this.this$0.aLY, 2, "onDeleteShieldList, isSuccess=" + paramBoolean);
      }
      if (!paramBoolean) {
        break;
      }
      paramList = (aizg)this.this$0.app.getManager(16);
      if ((paramList != null) && (!TextUtils.isEmpty(ChatSettingActivity.d(this.this$0)))) {
        ChatSettingActivity.a(this.this$0, paramList.nf(ChatSettingActivity.d(this.this$0)));
      }
      if (QLog.isColorLevel()) {
        QLog.d(this.this$0.aLY, 2, "onDeleteShieldList, mIsShield=" + ChatSettingActivity.a(this.this$0));
      }
      ChatSettingActivity.b(this.this$0);
      return;
    }
    ChatSettingActivity.a(this.this$0, 2131720205, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uoy
 * JD-Core Version:    0.7.0.1
 */