import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserDelegationActivity;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ahkq
  implements View.OnClickListener
{
  ahkq(ahki.b paramb) {}
  
  public void onClick(View paramView)
  {
    if (this.b.this$0.d == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      String str = this.b.this$0.d.mMsgUrl.trim();
      if (QLog.isColorLevel()) {
        QLog.e("ForwardOption.ForwardSdkBaseOption", 2, "gotoWeb " + str);
      }
      Intent localIntent = new Intent(this.b.this$0.mActivity, QQBrowserDelegationActivity.class);
      localIntent.putExtra("param_force_internal_browser", true);
      localIntent.putExtra("reqType", 7);
      localIntent.putExtra("hide_more_button", true);
      localIntent.putExtra("url", str);
      wgv.c(this.b.this$0.mActivity, localIntent, str);
      this.b.this$0.dnZ();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahkq
 * JD-Core Version:    0.7.0.1
 */