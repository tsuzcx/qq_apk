import NS_CERTIFIED_ACCOUNT_WRITE.CertifiedAccountWrite.StDoTipOffRsp;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.VSBaseRequest;
import com.tencent.qphone.base.util.QLog;

class zjp
  implements VSDispatchObserver.onVSRspCallBack<CertifiedAccountWrite.StDoTipOffRsp>
{
  zjp(zjo paramzjo) {}
  
  public void a(VSBaseRequest paramVSBaseRequest, boolean paramBoolean, long paramLong, String paramString, CertifiedAccountWrite.StDoTipOffRsp paramStDoTipOffRsp)
  {
    paramBoolean = true;
    if (paramLong == 0L)
    {
      QLog.w("FeedbackSheetHelper", 1, "DoTipOffRequest success");
      if (this.a.a != null)
      {
        paramVSBaseRequest = this.a.a;
        if (paramLong != 0L) {
          break label76;
        }
      }
    }
    for (;;)
    {
      paramVSBaseRequest.a(paramBoolean);
      return;
      QLog.w("FeedbackSheetHelper", 1, "DoTipOffRequest failed retCode:" + paramLong);
      break;
      label76:
      paramBoolean = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zjp
 * JD-Core Version:    0.7.0.1
 */