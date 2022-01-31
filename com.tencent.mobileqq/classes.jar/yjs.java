import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT_WRITE.CertifiedAccountWrite.StDelFeedRsp;
import android.app.Activity;
import com.tencent.biz.subscribe.event.SubscribeFeedsEvent;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.widget.QQToast;

class yjs
  implements yvn<CertifiedAccountWrite.StDelFeedRsp>
{
  yjs(yjq paramyjq) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, CertifiedAccountWrite.StDelFeedRsp paramStDelFeedRsp)
  {
    if (this.a.a == null) {
      return;
    }
    if ((!paramBoolean) || (paramLong != 0L))
    {
      QQToast.a(this.a.a, 1, alpo.a(2131715028), 0).a();
      return;
    }
    yej.a().a(new SubscribeFeedsEvent(yjq.a(this.a).a.id.get(), 3));
    this.a.a.finish();
    QQToast.a(this.a.a, alpo.a(2131715024), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yjs
 * JD-Core Version:    0.7.0.1
 */