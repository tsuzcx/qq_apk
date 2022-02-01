import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.subscribe.fragments.SubscribeMultiPicFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class zxh
  implements View.OnClickListener
{
  public zxh(SubscribeMultiPicFragment paramSubscribeMultiPicFragment) {}
  
  public void onClick(View paramView)
  {
    if (SubscribeMultiPicFragment.a(this.a) != null) {
      this.a.a(SubscribeMultiPicFragment.a(this.a).a(1));
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zxh
 * JD-Core Version:    0.7.0.1
 */