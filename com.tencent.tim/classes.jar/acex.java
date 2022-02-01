import android.app.Dialog;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class acex
  implements View.OnClickListener
{
  public acex(FrameHelperActivity paramFrameHelperActivity, QQAppInterface paramQQAppInterface, FragmentActivity paramFragmentActivity) {}
  
  public void onClick(View paramView)
  {
    anot.a(this.val$app, "CliOper", "", "", "Quit", "Setting_Quit", 0, 0, "2", "", "", "");
    if (SettingCloneUtil.readValue(this.val$app.getApplication(), this.val$app.getAccount(), null, "pcactive_config", false)) {
      this.val$app.startPCActivePolling(this.val$app.getAccount(), "logout");
    }
    this.this$0.a(this.f, this.val$app);
    if ((FrameHelperActivity.a(this.this$0) != null) && (FrameHelperActivity.a(this.this$0).isShowing())) {
      FrameHelperActivity.a(this.this$0).dismiss();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acex
 * JD-Core Version:    0.7.0.1
 */