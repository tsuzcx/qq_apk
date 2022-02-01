import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT_WRITE.CertifiedAccountWrite.StDelFeedRsp;
import android.app.Activity;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.VSBaseRequest;
import com.tencent.biz.subscribe.event.SubscribeFeedsEvent;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.widget.QQToast;

class zly
  implements VSDispatchObserver.onVSRspCallBack<CertifiedAccountWrite.StDelFeedRsp>
{
  zly(zlv paramzlv) {}
  
  public void a(VSBaseRequest paramVSBaseRequest, boolean paramBoolean, long paramLong, String paramString, CertifiedAccountWrite.StDelFeedRsp paramStDelFeedRsp)
  {
    if (this.a.a == null) {
      return;
    }
    if ((!paramBoolean) || (paramLong != 0L))
    {
      QQToast.a(this.a.a, 1, amtj.a(2131713682), 0).a();
      return;
    }
    SimpleEventBus.getInstance().dispatchEvent(new SubscribeFeedsEvent(zlv.a(this.a).a.id.get(), 3));
    this.a.a.finish();
    QQToast.a(this.a.a, amtj.a(2131713678), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zly
 * JD-Core Version:    0.7.0.1
 */