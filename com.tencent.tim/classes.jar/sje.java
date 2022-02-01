import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import com.tencent.biz.subscribe.widget.relativevideo.BlankRecommendItemView;
import com.tencent.biz.subscribe.widget.textview.FollowTextView.a;
import com.tencent.mobileqq.pb.PBStringField;

public class sje
  implements FollowTextView.a
{
  public sje(BlankRecommendItemView paramBlankRecommendItemView, CertifiedAccountMeta.StUser paramStUser) {}
  
  public void a(boolean paramBoolean, CertifiedAccountMeta.StFeed paramStFeed)
  {
    String str = this.f.id.get();
    if (paramBoolean) {}
    for (paramStFeed = "blank_content_follow";; paramStFeed = "blank_content_unfollow")
    {
      sqn.c(str, "auth_follow", paramStFeed, 0, 0, new String[] { "", BlankRecommendItemView.a(this.a) + "", this.f.nick.get(), "" });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sje
 * JD-Core Version:    0.7.0.1
 */