import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ycb
  implements View.OnClickListener
{
  ycb(ybt paramybt) {}
  
  public void onClick(View paramView)
  {
    wja.bcO = true;
    if ((this.this$0.sessionInfo.cZ == 1001) || (this.this$0.sessionInfo.cZ == 10002)) {
      anot.a(this.this$0.app, "CliOper", "", "", "0X800514F", "0X800514F", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      anot.a(this.this$0.app, "CliOper", "", "", "Two_call", "Clk_aio_right", 0, 0, String.valueOf(0), "", "", "");
      wmj.a(this.this$0.app, this.this$0.mActivity, this.this$0.sessionInfo, true, null, this.this$0);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.this$0.sessionInfo.cZ == 1010) {
        anot.a(this.this$0.app, "CliOper", "", "", "0X80049C6", "0X80049C6", 0, 0, "", "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ycb
 * JD-Core Version:    0.7.0.1
 */