import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyFollowActivity;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyFollowActivity.1.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class kib
  implements View.OnClickListener
{
  public kib(ReadInJoyFollowActivity paramReadInJoyFollowActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.a.lP(true);
    ThreadManager.executeOnSubThread(new ReadInJoyFollowActivity.1.1(this));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kib
 * JD-Core Version:    0.7.0.1
 */