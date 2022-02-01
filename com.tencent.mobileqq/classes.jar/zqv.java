import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.subscribe.account_folder.recommend_banner.FollowedRecommendBannerView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class zqv
  implements View.OnClickListener
{
  public zqv(FollowedRecommendBannerView paramFollowedRecommendBannerView) {}
  
  public void onClick(View paramView)
  {
    FollowedRecommendBannerView.a(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zqv
 * JD-Core Version:    0.7.0.1
 */