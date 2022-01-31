import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT_WRITE.CertifiedAccountWrite.StDelFeedRsp;
import android.app.Activity;
import com.tencent.biz.subscribe.event.SubscribeFeedsEvent;
import com.tencent.mobileqq.pb.PBStringField;

class wvc
  implements xgx<CertifiedAccountWrite.StDelFeedRsp>
{
  wvc(wva paramwva) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, CertifiedAccountWrite.StDelFeedRsp paramStDelFeedRsp)
  {
    if (this.a.a == null) {
      return;
    }
    if ((!paramBoolean) || (paramLong != 0L))
    {
      bcpw.a(this.a.a, 1, ajyc.a(2131714645), 0).a();
      return;
    }
    wpw.a().a(new SubscribeFeedsEvent(wva.a(this.a).a.id.get(), 3));
    this.a.a.finish();
    bcpw.a(this.a.a, ajyc.a(2131714641), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wvc
 * JD-Core Version:    0.7.0.1
 */