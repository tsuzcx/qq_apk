import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ncu
  implements View.OnClickListener
{
  ncu(ncs paramncs, Activity paramActivity) {}
  
  public void onClick(View paramView)
  {
    if (this.val$activity != null)
    {
      QLog.d("DailyFeedsDiandianEntranceManager", 2, "jump to recommend feeds");
      nen.aQ(this.val$activity);
      this.val$activity.overridePendingTransition(0, 2130772380);
      this.b.aVE();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ncu
 * JD-Core Version:    0.7.0.1
 */