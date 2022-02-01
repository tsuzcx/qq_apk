import android.content.Intent;
import android.view.View;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatSettingActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.ProfileCardMoreActivity;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import mqq.os.MqqHandler;

public class vmj
  implements ausj.a
{
  public vmj(ProfileCardMoreActivity paramProfileCardMoreActivity, String paramString, ausj paramausj) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.val$actionSheet.superDismiss();
      return;
      anot.a(this.this$0.app, "CliOper", "", "", "P_prof", "Pp_more_delete", ProfileActivity.eP(this.this$0.e.bJa), 0, Integer.toString(ProfileActivity.a(this.this$0.e)), "", "", "");
      if (aqiw.isNetSupport(BaseApplication.getContext()))
      {
        ((FriendListHandler)this.this$0.app.getBusinessHandler(1)).d(this.Ub, (byte)2);
        paramView = this.this$0.app.getHandler(ChatActivity.class);
        if (paramView != null) {
          paramView.sendMessage(paramView.obtainMessage(16711681, this.Ub));
        }
        paramView = this.this$0.app.getHandler(ChatSettingActivity.class);
        if (paramView != null) {
          paramView.sendMessage(paramView.obtainMessage(16711681, this.Ub));
        }
        if (this.this$0.L == null) {
          this.this$0.L = new Intent();
        }
        this.this$0.L.putExtra("finchat", true);
        this.this$0.setResult(-1, this.this$0.L);
        if (aqft.rj(this.Ub)) {
          anot.a(this.this$0.app, "dc00898", "", "", "0X8007FDF", "0X8007FDF", 0, 0, "", "", "", "");
        }
        this.this$0.finish();
      }
      else
      {
        this.this$0.cf(2131692480, 1);
        continue;
        if (aqft.rj(this.Ub)) {
          anot.a(this.this$0.app, "dc00898", "", "", "0X8007FE0", "0X8007FE0", 0, 0, "", "", "", "");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vmj
 * JD-Core Version:    0.7.0.1
 */