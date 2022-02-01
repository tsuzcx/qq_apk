import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.RecommendFriendActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class vqw
  implements View.OnClickListener
{
  public vqw(RecommendFriendActivity paramRecommendFriendActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vqw
 * JD-Core Version:    0.7.0.1
 */