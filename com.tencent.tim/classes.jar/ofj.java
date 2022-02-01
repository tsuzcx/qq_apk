import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.weishi_new.WSHomeFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ofj
  implements View.OnClickListener
{
  public ofj(WSHomeFragment paramWSHomeFragment) {}
  
  public void onClick(View paramView)
  {
    WSHomeFragment.a(this.this$0);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ofj
 * JD-Core Version:    0.7.0.1
 */