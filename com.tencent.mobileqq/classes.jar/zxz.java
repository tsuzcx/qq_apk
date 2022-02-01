import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetMainPageRsp;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.VSBaseRequest;

class zxz
  implements VSDispatchObserver.onVSRspCallBack<CertifiedAccountRead.StGetMainPageRsp>
{
  zxz(zxy paramzxy, zpw paramzpw) {}
  
  public void a(VSBaseRequest paramVSBaseRequest, boolean paramBoolean, long paramLong, String paramString, CertifiedAccountRead.StGetMainPageRsp paramStGetMainPageRsp)
  {
    if (this.jdField_a_of_type_Zpw != null) {
      this.jdField_a_of_type_Zpw.a(new Object[] { Boolean.valueOf(paramBoolean), Long.valueOf(paramLong), paramString, paramStGetMainPageRsp });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zxz
 * JD-Core Version:    0.7.0.1
 */