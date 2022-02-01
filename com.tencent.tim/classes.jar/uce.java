import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.AccountManageActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class uce
  implements View.OnClickListener
{
  public uce(AccountManageActivity paramAccountManageActivity) {}
  
  public void onClick(View paramView)
  {
    anot.a(this.this$0.app, "CliOper", "", "", "Quit", "Setting_Quit", 0, 0, "2", "", "", "");
    if (SettingCloneUtil.readValue(this.this$0.app.getApplication(), this.this$0.app.getAccount(), null, "pcactive_config", false)) {
      this.this$0.app.startPCActivePolling(this.this$0.app.getAccount(), "logout");
    }
    AccountManageActivity.a(this.this$0.getActivity(), this.this$0.app);
    if ((this.this$0.x != null) && (this.this$0.x.isShowing())) {
      this.this$0.x.dismiss();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uce
 * JD-Core Version:    0.7.0.1
 */