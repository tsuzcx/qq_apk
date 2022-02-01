import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.TroopAssisSettingActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.os.MqqHandler;

class aaht
  implements View.OnClickListener
{
  aaht(aahb paramaahb) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent(aahb.a(this.this$0), TroopAssisSettingActivity.class);
    aahb.a(this.this$0).startActivityForResult(localIntent, 9001);
    aahb.a(this.this$0).sendEmptyMessageDelayed(1, 1000L);
    anot.a(aahb.a(this.this$0).app, "P_CliOper", "Grp_msg", "", "Msglist", "Clk_setmsg", 0, 0, "", "", "", "");
    anot.c(aahb.a(this.this$0).app, "dc00898", "", "", "0X8009EE2", "0X8009EE2", 17, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aaht
 * JD-Core Version:    0.7.0.1
 */