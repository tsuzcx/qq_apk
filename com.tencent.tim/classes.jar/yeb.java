import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class yeb
  implements View.OnClickListener
{
  yeb(ydz paramydz) {}
  
  public void onClick(View paramView)
  {
    wja.bcO = true;
    int i;
    switch (this.a.sessionInfo.cZ)
    {
    default: 
      i = 0;
    }
    for (;;)
    {
      anot.a(this.a.app, "CliOper", "", "", "Two_call", "Clk_aio_right", 0, 0, String.valueOf(i), "", "", "");
      wmj.a(this.a.app, this.a.mActivity, this.a.sessionInfo, true, null, this.a);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      i = 1;
      continue;
      i = 2;
      continue;
      i = 3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yeb
 * JD-Core Version:    0.7.0.1
 */