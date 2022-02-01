import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.tencent.biz.pubaccount.weishi_new.WSRecommendFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class udv
  implements View.OnClickListener
{
  public udv(WSRecommendFragment paramWSRecommendFragment) {}
  
  public void onClick(View paramView)
  {
    WSRecommendFragment.a(this.a).b();
    ((umg)this.a.b()).a(true, true, "");
    ((umg)this.a.b()).a("");
    WSRecommendFragment.a(this.a).setVisibility(8);
    this.a.c();
    umq.a(136, 1, null);
    umw.b(true);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     udv
 * JD-Core Version:    0.7.0.1
 */