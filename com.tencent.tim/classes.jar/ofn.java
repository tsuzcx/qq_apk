import UserGrowth.stPublisherRsp;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.weishi_new.WSHomeFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ofn
  implements View.OnClickListener
{
  public ofn(WSHomeFragment paramWSHomeFragment, stPublisherRsp paramstPublisherRsp) {}
  
  public void onClick(View paramView)
  {
    WSHomeFragment.a(this.this$0, this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ofn
 * JD-Core Version:    0.7.0.1
 */