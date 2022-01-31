import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT_WRITE.CertifiedAccountWrite.StDelFeedRsp;
import android.app.Activity;
import com.tencent.biz.subscribe.event.SubscribeFeedsEvent;
import com.tencent.mobileqq.pb.PBStringField;

class wuz
  implements xgu<CertifiedAccountWrite.StDelFeedRsp>
{
  wuz(wux paramwux) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, CertifiedAccountWrite.StDelFeedRsp paramStDelFeedRsp)
  {
    if (this.a.a == null) {
      return;
    }
    if ((!paramBoolean) || (paramLong != 0L))
    {
      bcql.a(this.a.a, 1, ajya.a(2131714656), 0).a();
      return;
    }
    wpt.a().a(new SubscribeFeedsEvent(wux.a(this.a).a.id.get(), 3));
    this.a.a.finish();
    bcql.a(this.a.a, ajya.a(2131714652), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wuz
 * JD-Core Version:    0.7.0.1
 */