import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetMainPageRsp;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.VSBaseRequest;
import com.tencent.qphone.base.util.QLog;

final class zqi
  implements VSDispatchObserver.onVSRspCallBack<CertifiedAccountRead.StGetMainPageRsp>
{
  public void a(VSBaseRequest paramVSBaseRequest, boolean paramBoolean, long paramLong, String paramString, CertifiedAccountRead.StGetMainPageRsp paramStGetMainPageRsp)
  {
    if ((paramBoolean) && (paramLong == 0L))
    {
      if (paramStGetMainPageRsp != null) {
        zqh.a((CertifiedAccountMeta.StUser)paramStGetMainPageRsp.user.get());
      }
    }
    else {
      return;
    }
    QLog.w(zqh.class.getSimpleName(), 1, "getPuinUser empty");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zqi
 * JD-Core Version:    0.7.0.1
 */