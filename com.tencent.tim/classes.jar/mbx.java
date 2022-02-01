import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentHeaderFriendRecommend;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class mbx
  implements View.OnClickListener
{
  public mbx(ComponentHeaderFriendRecommend paramComponentHeaderFriendRecommend, List paramList, int paramInt) {}
  
  public void onClick(View paramView)
  {
    ComponentHeaderFriendRecommend.a(this.b, ((Long)this.hL.get(this.val$pos)).longValue());
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mbx
 * JD-Core Version:    0.7.0.1
 */