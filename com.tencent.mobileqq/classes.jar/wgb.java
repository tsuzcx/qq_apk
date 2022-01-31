import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT_WRITE.CertifiedAccountWrite.StDelFeedRsp;
import android.app.Activity;
import com.tencent.biz.subscribe.event.SubscribeFeedsEvent;
import com.tencent.mobileqq.pb.PBStringField;

class wgb
  implements wxx<CertifiedAccountWrite.StDelFeedRsp>
{
  wgb(wfz paramwfz) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, CertifiedAccountWrite.StDelFeedRsp paramStDelFeedRsp)
  {
    if (this.a.a == null) {
      return;
    }
    if ((!paramBoolean) || (paramLong != 0L))
    {
      bbmy.a(this.a.a, 1, ajjy.a(2131648856), 0).a();
      return;
    }
    wcj.a().a(new SubscribeFeedsEvent(wfz.a(this.a).a.id.get(), 3));
    this.a.a.finish();
    bbmy.a(this.a.a, ajjy.a(2131648852), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wgb
 * JD-Core Version:    0.7.0.1
 */