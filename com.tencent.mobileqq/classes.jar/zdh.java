import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.subscribe.fragments.SubscribeBaseFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class zdh
  implements View.OnClickListener
{
  zdh(zdg paramzdg) {}
  
  public void onClick(View paramView)
  {
    if ((this.a.a() instanceof SubscribeBaseFragment)) {
      ((SubscribeBaseFragment)this.a.a()).a(this.a.a(2));
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zdh
 * JD-Core Version:    0.7.0.1
 */