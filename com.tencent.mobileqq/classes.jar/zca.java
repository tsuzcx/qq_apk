import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.subscribe.account_folder.recommend_banner.RecommendBannerFeedItemView;
import com.tencent.biz.subscribe.event.RecommendFeedbackEvent;
import com.tencent.mobileqq.widget.QQToast;

public class zca
  implements zjr
{
  public zca(RecommendBannerFeedItemView paramRecommendBannerFeedItemView) {}
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      SimpleEventBus.getInstance().dispatchEvent(new RecommendFeedbackEvent(RecommendBannerFeedItemView.a(this.a)));
      return;
    }
    QQToast.a(this.a.getContext(), 2131718731, 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zca
 * JD-Core Version:    0.7.0.1
 */