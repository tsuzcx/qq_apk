import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetFeedDetailRsp;
import com.tencent.biz.subscribe.comment.CommentBottomBar;
import com.tencent.biz.subscribe.fragments.SubscribeHybirdFragment;
import com.tencent.mobileqq.widget.QQToast;

public class sek
  implements scw.c
{
  public sek(SubscribeHybirdFragment paramSubscribeHybirdFragment) {}
  
  public void a(CertifiedAccountRead.StGetFeedDetailRsp paramStGetFeedDetailRsp, boolean paramBoolean, long paramLong, String paramString)
  {
    if ((paramStGetFeedDetailRsp == null) || (paramStGetFeedDetailRsp.feed.get() == null))
    {
      QQToast.a(this.a.getHostActivity(), acfp.m(2131715059), 0).show();
      return;
    }
    SubscribeHybirdFragment.a(this.a, paramStGetFeedDetailRsp, paramLong, paramString);
  }
  
  public void yk(int paramInt)
  {
    SubscribeHybirdFragment.a(this.a).el(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sek
 * JD-Core Version:    0.7.0.1
 */