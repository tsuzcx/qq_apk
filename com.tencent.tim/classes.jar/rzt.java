import com.tencent.biz.subscribe.account_folder.recommend_banner.RecommendBannerFeedItemView;
import com.tencent.biz.subscribe.event.RecommendFeedbackEvent;
import com.tencent.mobileqq.widget.QQToast;

public class rzt
  implements sgs.b
{
  public rzt(RecommendBannerFeedItemView paramRecommendBannerFeedItemView) {}
  
  public void onResult(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      rwv.a().a(new RecommendFeedbackEvent(RecommendBannerFeedItemView.a(this.a)));
      return;
    }
    QQToast.a(this.a.getContext(), 2131720649, 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rzt
 * JD-Core Version:    0.7.0.1
 */