import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT_WRITE.CertifiedAccountWrite.StDelFeedRsp;
import android.app.Activity;
import com.tencent.biz.subscribe.event.SubscribeFeedsEvent;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.widget.QQToast;

class yof
  implements zac<CertifiedAccountWrite.StDelFeedRsp>
{
  yof(yod paramyod) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, CertifiedAccountWrite.StDelFeedRsp paramStDelFeedRsp)
  {
    if (this.a.a == null) {
      return;
    }
    if ((!paramBoolean) || (paramLong != 0L))
    {
      QQToast.a(this.a.a, 1, alud.a(2131715040), 0).a();
      return;
    }
    yiw.a().a(new SubscribeFeedsEvent(yod.a(this.a).a.id.get(), 3));
    this.a.a.finish();
    QQToast.a(this.a.a, alud.a(2131715036), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yof
 * JD-Core Version:    0.7.0.1
 */