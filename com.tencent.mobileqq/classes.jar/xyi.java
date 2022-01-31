import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import com.tencent.biz.subscribe.account_folder.recommend_banner.RecommendBannerItemView;
import com.tencent.mobileqq.pb.PBStringField;

class xyi
  implements yhe
{
  xyi(xyg paramxyg) {}
  
  public void a(boolean paramBoolean)
  {
    String str2 = RecommendBannerItemView.a(this.a.a).id.get();
    StringBuilder localStringBuilder = new StringBuilder().append("recom_");
    if (paramBoolean)
    {
      str1 = "cancel";
      yvu.a(str2, "auth_page", str1, 0, 0, new String[] { "", RecommendBannerItemView.a(this.a.a) + "", RecommendBannerItemView.a(this.a.a).nick.get() });
      if (RecommendBannerItemView.a(this.a.a))
      {
        str2 = RecommendBannerItemView.a(this.a.a).id.get();
        localStringBuilder = new StringBuilder().append("reco_");
        if (!paramBoolean) {
          break label252;
        }
      }
    }
    label252:
    for (String str1 = "cancel";; str1 = "dislike")
    {
      yvu.a(str2, "auth_discover", str1, 0, 0, new String[] { "", String.valueOf(RecommendBannerItemView.a(this.a.a)), RecommendBannerItemView.a(this.a.a).nick.get(), RecommendBannerItemView.a(this.a.a).desc.get() });
      return;
      str1 = "dislike";
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xyi
 * JD-Core Version:    0.7.0.1
 */