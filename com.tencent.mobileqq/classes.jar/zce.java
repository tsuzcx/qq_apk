import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.subscribe.account_folder.recommend_banner.RecommendBannerItemView;
import com.tencent.biz.subscribe.event.RecommendFeedbackEvent;

class zce
  implements zjr
{
  zce(zcd paramzcd) {}
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      SimpleEventBus.getInstance().dispatchEvent(new RecommendFeedbackEvent(RecommendBannerItemView.a(this.a.a)));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zce
 * JD-Core Version:    0.7.0.1
 */