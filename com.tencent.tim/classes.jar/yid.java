import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class yid
  implements View.OnClickListener
{
  yid(yic paramyic) {}
  
  public void onClick(View paramView)
  {
    yic.a(this.a).ciA();
    ChatActivityUtils.a(yic.a(this.a), yic.a(this.a), yic.a(this.a).cZ, yic.a(this.a).aTl, true, true, null, null);
    anot.a(yic.a(this.a), "CliOper", "", "", "0X8003F00", "0X8003F00", 0, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yid
 * JD-Core Version:    0.7.0.1
 */