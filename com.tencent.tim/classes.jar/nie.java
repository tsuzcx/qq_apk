import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame.11.1;
import com.tencent.biz.pubaccount.readinjoy.view.RecommendFeedsDiandianEntranceManager;
import com.tencent.biz.pubaccount.readinjoy.view.widget.reddot.ColorBandVideoEntranceButton;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class nie
  implements View.OnClickListener
{
  public nie(ReadinjoyTabFrame paramReadinjoyTabFrame) {}
  
  public void onClick(View paramView)
  {
    ReadinjoyTabFrame.a(this.this$0).postDelayed(new ReadinjoyTabFrame.11.1(this, paramView), 300L);
    if ((!RecommendFeedsDiandianEntranceManager.a().FB()) && (!awit.aMQ())) {
      RecommendFeedsDiandianEntranceManager.a().aXW();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nie
 * JD-Core Version:    0.7.0.1
 */