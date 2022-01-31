import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.biz.subscribe.account_folder.recommend_banner.RecommendBannerItemView;
import com.tencent.mobileqq.pb.PBStringField;

public class vwt
  implements View.OnLongClickListener
{
  public vwt(RecommendBannerItemView paramRecommendBannerItemView) {}
  
  public boolean onLongClick(View paramView)
  {
    if (RecommendBannerItemView.a(this.a) == null) {
      return false;
    }
    wdu.a(this.a.getContext(), RecommendBannerItemView.a(this.a), new vwu(this), new vwv(this));
    if (RecommendBannerItemView.a(this.a)) {
      wye.a(RecommendBannerItemView.a(this.a).id.get(), "auth_discover", "reco_press", 0, 0, new String[] { "", String.valueOf(RecommendBannerItemView.a(this.a)), RecommendBannerItemView.a(this.a).nick.get(), RecommendBannerItemView.a(this.a).desc.get() });
    }
    for (;;)
    {
      return true;
      wye.a(RecommendBannerItemView.a(this.a).id.get(), "auth_page", "recom_remove", 0, 0, new String[] { "", RecommendBannerItemView.a(this.a) + "", RecommendBannerItemView.a(this.a).nick.get() });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     vwt
 * JD-Core Version:    0.7.0.1
 */