import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.contact.recommendtroop.TroopRecommendFriendFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class yvn
  implements View.OnClickListener
{
  public yvn(TroopRecommendFriendFragment paramTroopRecommendFriendFragment, yva paramyva) {}
  
  public void onClick(View paramView)
  {
    TroopRecommendFriendFragment.a(this.a, TroopRecommendFriendFragment.a(this.a), this.b.uin, TroopRecommendFriendFragment.a(this.a));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yvn
 * JD-Core Version:    0.7.0.1
 */