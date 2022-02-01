import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.tencent.biz.pubaccount.weishi_new.WSFollowFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class uxi
  implements View.OnClickListener
{
  public uxi(WSFollowFragment paramWSFollowFragment) {}
  
  public void onClick(View paramView)
  {
    if (WSFollowFragment.a(this.a) != null) {
      WSFollowFragment.a(this.a).b();
    }
    ((via)this.a.b()).a(true, true);
    WSFollowFragment.a(this.a).setVisibility(8);
    this.a.c();
    vjx.a(136, 1, null);
    vkf.b(true);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uxi
 * JD-Core Version:    0.7.0.1
 */