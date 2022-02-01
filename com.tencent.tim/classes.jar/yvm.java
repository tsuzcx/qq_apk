import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import com.tencent.mobileqq.activity.contact.recommendtroop.TroopRecommendFriendFragment;

public class yvm
  implements yvt.a
{
  public yvm(TroopRecommendFriendFragment paramTroopRecommendFriendFragment) {}
  
  public void a(View paramView, RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if (!(paramViewHolder instanceof yuz)) {
      return;
    }
    paramView = ((yuz)paramViewHolder).a;
    apuh.a(TroopRecommendFriendFragment.a(this.a), TroopRecommendFriendFragment.a(this.a), paramView.uin, TroopRecommendFriendFragment.a(this.a), TroopRecommendFriendFragment.a(this.a));
  }
  
  public boolean a(View paramView, RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yvm
 * JD-Core Version:    0.7.0.1
 */