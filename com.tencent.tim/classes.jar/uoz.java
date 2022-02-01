import com.tencent.mobileqq.activity.ChatSettingActivity;
import com.tencent.qphone.base.util.QLog;

public class uoz
  extends achq
{
  public uoz(ChatSettingActivity paramChatSettingActivity) {}
  
  protected void L(boolean paramBoolean, String paramString)
  {
    if (!ChatSettingActivity.c(this.this$0)) {
      return;
    }
    ChatSettingActivity.c(this.this$0, false);
    ChatSettingActivity.g(this.this$0);
    if (QLog.isColorLevel()) {
      QLog.d(this.this$0.aLY, 2, "onInsertIntoBlackList, isSuccess=" + paramBoolean);
    }
    if (paramBoolean)
    {
      if ((paramString != null) && (paramString.equals(ChatSettingActivity.d(this.this$0)))) {
        ChatSettingActivity.a(this.this$0, true);
      }
      if (QLog.isColorLevel()) {
        QLog.d(this.this$0.aLY, 2, "onInsertIntoBlackList, mIsShield=" + ChatSettingActivity.a(this.this$0));
      }
      ChatSettingActivity.b(this.this$0);
      return;
    }
    ChatSettingActivity.a(this.this$0, 2131720207, 1);
  }
  
  protected void M(boolean paramBoolean, String paramString)
  {
    if (!ChatSettingActivity.c(this.this$0)) {
      return;
    }
    ChatSettingActivity.c(this.this$0, false);
    if (QLog.isColorLevel()) {
      QLog.d(this.this$0.aLY, 2, "onRemoveFromBlackList, isSuccess=" + paramBoolean);
    }
    ChatSettingActivity.g(this.this$0);
    if (paramBoolean)
    {
      if ((paramString != null) && (paramString.equals(ChatSettingActivity.d(this.this$0)))) {
        ChatSettingActivity.a(this.this$0, false);
      }
      if (QLog.isColorLevel()) {
        QLog.d(this.this$0.aLY, 2, "onRemoveFromBlackList, mIsShield=" + ChatSettingActivity.a(this.this$0));
      }
      ChatSettingActivity.b(this.this$0);
      return;
    }
    ChatSettingActivity.a(this.this$0, 2131720207, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uoz
 * JD-Core Version:    0.7.0.1
 */