import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.subscribe.fragments.SubscribeVideoDetailFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class zxt
  implements View.OnClickListener
{
  public zxt(SubscribeVideoDetailFragment paramSubscribeVideoDetailFragment) {}
  
  public void onClick(View paramView)
  {
    this.a.onBackEvent();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zxt
 * JD-Core Version:    0.7.0.1
 */