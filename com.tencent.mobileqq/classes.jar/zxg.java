import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.subscribe.fragments.SubscribeMultiPicFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class zxg
  implements View.OnClickListener
{
  public zxg(SubscribeMultiPicFragment paramSubscribeMultiPicFragment) {}
  
  public void onClick(View paramView)
  {
    this.a.onBackEvent();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zxg
 * JD-Core Version:    0.7.0.1
 */