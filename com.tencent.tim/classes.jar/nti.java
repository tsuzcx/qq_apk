import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.viola.CommonSuspensionGestureLayout;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class nti
  implements View.OnClickListener
{
  public nti(CommonSuspensionGestureLayout paramCommonSuspensionGestureLayout) {}
  
  public void onClick(View paramView)
  {
    this.this$0.dr(0, 2);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nti
 * JD-Core Version:    0.7.0.1
 */