import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.biz.subscribe.account_folder.recommend_banner.RecommendBannerItemView;
import com.tencent.mobileqq.pb.PBStringField;

public class rzw
  implements View.OnLongClickListener
{
  public rzw(RecommendBannerItemView paramRecommendBannerItemView) {}
  
  public boolean onLongClick(View paramView)
  {
    if (RecommendBannerItemView.a(this.this$0) == null) {
      return false;
    }
    sgs.a(this.this$0.getContext(), RecommendBannerItemView.a(this.this$0), new rzx(this), new rzy(this));
    if (RecommendBannerItemView.a(this.this$0)) {
      sqn.b(RecommendBannerItemView.a(this.this$0).id.get(), "auth_discover", "reco_press", 0, 0, new String[] { "", String.valueOf(RecommendBannerItemView.a(this.this$0)), RecommendBannerItemView.a(this.this$0).nick.get(), RecommendBannerItemView.a(this.this$0).desc.get() });
    }
    for (;;)
    {
      return true;
      sqn.b(RecommendBannerItemView.a(this.this$0).id.get(), "auth_page", "recom_remove", 0, 0, new String[] { "", RecommendBannerItemView.a(this.this$0) + "", RecommendBannerItemView.a(this.this$0).nick.get() });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rzw
 * JD-Core Version:    0.7.0.1
 */