import NS_CERTIFIED_ACCOUNT_WRITE.CertifiedAccountWrite.StDoLikeRsp;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.VSBaseRequest;
import com.tribe.async.dispatch.Dispatcher;

class zuo
  implements VSDispatchObserver.onVSRspCallBack<CertifiedAccountWrite.StDoLikeRsp>
{
  zuo(zug paramzug) {}
  
  public void a(VSBaseRequest paramVSBaseRequest, boolean paramBoolean, long paramLong, String paramString, CertifiedAccountWrite.StDoLikeRsp paramStDoLikeRsp)
  {
    wad.a().dispatch(this.a.a(new Object[] { Integer.valueOf(7), Long.valueOf(paramLong), paramString, paramStDoLikeRsp }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zuo
 * JD-Core Version:    0.7.0.1
 */