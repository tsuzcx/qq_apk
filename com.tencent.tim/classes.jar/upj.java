import android.view.View;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatSettingActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import mqq.os.MqqHandler;

public class upj
  implements ausj.a
{
  public upj(ChatSettingActivity paramChatSettingActivity, String paramString, ausj paramausj) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.val$actionSheet.superDismiss();
      return;
      if (aqiw.isNetSupport(BaseApplication.getContext()))
      {
        ((FriendListHandler)this.this$0.app.getBusinessHandler(1)).d(this.Ub, (byte)2);
        paramView = this.this$0.app.getHandler(ChatActivity.class);
        if (paramView != null)
        {
          paramView.removeMessages(16711681);
          paramView.sendMessage(paramView.obtainMessage(16711681, this.Ub));
        }
        anot.a(this.this$0.app, "CliOper", "", "", "AIO", "AIO_delete_frd", 0, 0, "", "", "", "");
        if (aqft.rj(this.Ub)) {
          anot.a(this.this$0.app, "dc00898", "", "", "0X8007FDF", "0X8007FDF", 0, 0, "", "", "", "");
        }
        this.this$0.finish();
      }
      else
      {
        ChatSettingActivity.a(this.this$0, 2131692480, 1);
        continue;
        if (aqft.rj(this.Ub)) {
          anot.a(this.this$0.app, "dc00898", "", "", "0X8007FE0", "0X8007FE0", 0, 0, "", "", "", "");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     upj
 * JD-Core Version:    0.7.0.1
 */