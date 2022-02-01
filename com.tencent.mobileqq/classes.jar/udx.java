import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.tencent.biz.pubaccount.weishi_new.WSRecommendFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class udx
  implements View.OnClickListener
{
  public udx(WSRecommendFragment paramWSRecommendFragment) {}
  
  public void onClick(View paramView)
  {
    WSRecommendFragment.a(this.a).b();
    ((une)this.a.b()).a(true, true, "");
    ((une)this.a.b()).a("");
    WSRecommendFragment.a(this.a).setVisibility(8);
    this.a.c();
    uno.a(136, 1, null);
    unx.b(true);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     udx
 * JD-Core Version:    0.7.0.1
 */