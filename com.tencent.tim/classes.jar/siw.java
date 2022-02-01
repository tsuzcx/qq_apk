import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT_WRITE.CertifiedAccountWrite.StDelFeedRsp;
import android.app.Activity;
import com.tencent.biz.subscribe.event.SubscribeFeedsEvent;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.widget.QQToast;

class siw
  implements rxc.a<CertifiedAccountWrite.StDelFeedRsp>
{
  siw(siu paramsiu) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, CertifiedAccountWrite.StDelFeedRsp paramStDelFeedRsp)
  {
    if (this.this$0.s == null) {
      return;
    }
    if ((!paramBoolean) || (paramLong != 0L))
    {
      QQToast.a(this.this$0.s, 1, acfp.m(2131715066), 0).show();
      return;
    }
    rwv.a().a(new SubscribeFeedsEvent(siu.a(this.this$0).mFeed.id.get(), 3));
    this.this$0.s.finish();
    QQToast.a(this.this$0.s, acfp.m(2131715062), 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     siw
 * JD-Core Version:    0.7.0.1
 */