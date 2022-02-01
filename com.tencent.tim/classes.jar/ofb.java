import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.tencent.biz.pubaccount.weishi_new.WSFollowFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ofb
  implements View.OnClickListener
{
  public ofb(WSFollowFragment paramWSFollowFragment) {}
  
  public void onClick(View paramView)
  {
    if (WSFollowFragment.a(this.this$0) != null) {
      WSFollowFragment.a(this.this$0).YW();
    }
    ((olu)this.this$0.b()).ai(true, true);
    WSFollowFragment.a(this.this$0).setVisibility(8);
    this.this$0.showLoading(false);
    ond.a(136, 1, null);
    ong.qT(true);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ofb
 * JD-Core Version:    0.7.0.1
 */