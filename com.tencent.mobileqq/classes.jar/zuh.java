import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetFeedDetailRsp;
import NS_COMM.COMM.StCommonExt;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.VSBaseRequest;

class zuh
  implements VSDispatchObserver.onVSRspCallBack<CertifiedAccountRead.StGetFeedDetailRsp>
{
  zuh(zug paramzug, COMM.StCommonExt paramStCommonExt) {}
  
  public void a(VSBaseRequest paramVSBaseRequest, boolean paramBoolean, long paramLong, String paramString, CertifiedAccountRead.StGetFeedDetailRsp paramStGetFeedDetailRsp)
  {
    zug.a(this.jdField_a_of_type_Zug, paramBoolean, paramLong, paramString, paramStGetFeedDetailRsp, this.jdField_a_of_type_NS_COMMCOMM$StCommonExt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zuh
 * JD-Core Version:    0.7.0.1
 */