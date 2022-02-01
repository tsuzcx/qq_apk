import android.view.View;
import com.tencent.mobileqq.activity.RecommendFriendActivity;
import com.tencent.widget.SwipListView.a;

public class vqx
  implements SwipListView.a
{
  public vqx(RecommendFriendActivity paramRecommendFriendActivity) {}
  
  public void onRightIconMenuHide(View paramView)
  {
    RecommendFriendActivity.a(this.a, true);
  }
  
  public void onRightIconMenuShow(View paramView)
  {
    RecommendFriendActivity.a(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vqx
 * JD-Core Version:    0.7.0.1
 */