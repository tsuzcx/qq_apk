import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyChannelPanelFragment;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class niw
  implements View.OnClickListener
{
  public niw(ReadinjoyTabFrame paramReadinjoyTabFrame) {}
  
  public void onClick(View paramView)
  {
    PublicTransFragmentActivity.start(this.this$0.a(), ReadInJoyChannelPanelFragment.class);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     niw
 * JD-Core Version:    0.7.0.1
 */