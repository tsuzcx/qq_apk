import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.handlers.FrameworkHandler.1.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class lgc
  implements View.OnClickListener
{
  lgc(lgb paramlgb) {}
  
  public void onClick(View paramView)
  {
    this.this$0.nv(false);
    ThreadManager.executeOnSubThread(new FrameworkHandler.1.1(this));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lgc
 * JD-Core Version:    0.7.0.1
 */