import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.tencent.biz.pubaccount.weishi_new.WSRecommendFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ogb
  implements View.OnClickListener
{
  public ogb(WSRecommendFragment paramWSRecommendFragment) {}
  
  public void onClick(View paramView)
  {
    WSRecommendFragment.a(this.this$0).YW();
    ((omy.a)this.this$0.b()).b(true, true, "");
    ((omy.a)this.this$0.b()).pL("");
    WSRecommendFragment.a(this.this$0).setVisibility(8);
    this.this$0.showLoading(false);
    ond.a(136, 1, null);
    ong.qT(true);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ogb
 * JD-Core Version:    0.7.0.1
 */