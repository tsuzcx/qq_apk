import com.tencent.biz.subscribe.account_folder.recommend_banner.RecommendBannerItemView;
import com.tencent.biz.subscribe.event.RecommendFeedbackEvent;

class rzx
  implements sgs.b
{
  rzx(rzw paramrzw) {}
  
  public void onResult(boolean paramBoolean)
  {
    if (paramBoolean) {
      rwv.a().a(new RecommendFeedbackEvent(RecommendBannerItemView.a(this.a.this$0)));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rzx
 * JD-Core Version:    0.7.0.1
 */