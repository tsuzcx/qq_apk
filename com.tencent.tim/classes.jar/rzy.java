import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import com.tencent.biz.subscribe.account_folder.recommend_banner.RecommendBannerItemView;
import com.tencent.mobileqq.pb.PBStringField;

class rzy
  implements sgs.a
{
  rzy(rzw paramrzw) {}
  
  public void ut(boolean paramBoolean)
  {
    String str2 = RecommendBannerItemView.a(this.a.this$0).id.get();
    StringBuilder localStringBuilder = new StringBuilder().append("recom_");
    if (paramBoolean)
    {
      str1 = "cancel";
      sqn.b(str2, "auth_page", str1, 0, 0, new String[] { "", RecommendBannerItemView.a(this.a.this$0) + "", RecommendBannerItemView.a(this.a.this$0).nick.get() });
      if (RecommendBannerItemView.a(this.a.this$0))
      {
        str2 = RecommendBannerItemView.a(this.a.this$0).id.get();
        localStringBuilder = new StringBuilder().append("reco_");
        if (!paramBoolean) {
          break label252;
        }
      }
    }
    label252:
    for (String str1 = "cancel";; str1 = "dislike")
    {
      sqn.b(str2, "auth_discover", str1, 0, 0, new String[] { "", String.valueOf(RecommendBannerItemView.a(this.a.this$0)), RecommendBannerItemView.a(this.a.this$0).nick.get(), RecommendBannerItemView.a(this.a.this$0).desc.get() });
      return;
      str1 = "dislike";
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rzy
 * JD-Core Version:    0.7.0.1
 */