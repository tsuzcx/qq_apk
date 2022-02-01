import QQService.SvcDevLoginInfo;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.mobileqq.activity.LoginInfoActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class vgc
  implements View.OnClickListener
{
  public vgc(LoginInfoActivity paramLoginInfoActivity, Button paramButton, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if (!aqiw.isNetSupport(this.this$0)) {
      QQToast.a(this.this$0, this.this$0.getString(2131693404), 0).show(this.this$0.getTitleBarHeight());
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      anot.a(this.this$0.app, "CliOper", "", "", "My_eq", "Kick_off_PC", 0, 0, "", "", "", "");
      SvcDevLoginInfo localSvcDevLoginInfo = (SvcDevLoginInfo)this.dl.getTag();
      if (localSvcDevLoginInfo != null) {
        this.this$0.app.getSubAccountKey(this.this$0.app.getAccount(), this.this$0.app.getAccount(), new vgd(this, localSvcDevLoginInfo));
      } else {
        QQToast.a(this.this$0.getApplicationContext(), this.this$0.getString(2131696148), 0).show(this.this$0.getTitleBarHeight());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vgc
 * JD-Core Version:    0.7.0.1
 */