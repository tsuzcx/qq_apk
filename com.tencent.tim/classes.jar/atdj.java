import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.fpsreport.FPSSwipListView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tim.call.recent.RecentCallHelper.10.1;

public class atdj
  implements View.OnClickListener
{
  atdj(atdh paramatdh) {}
  
  public void onClick(View paramView)
  {
    atdh.a(this.this$0).setVisibility(8);
    atdh.a(this.this$0).removeHeaderView(atdh.a(this.this$0));
    anot.a(null, "CliOper", "", "", "0X800510E", "0X800510E", 0, 0, "", "", "", "");
    ThreadManager.post(new RecentCallHelper.10.1(this), 8, null, false);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atdj
 * JD-Core Version:    0.7.0.1
 */