import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StComment;
import NS_CERTIFIED_ACCOUNT_WRITE.CertifiedAccountWrite.StDoCommentRsp;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.VSBaseRequest;
import com.tencent.mobileqq.pb.PBStringField;
import com.tribe.async.dispatch.Dispatcher;

class zuj
  implements VSDispatchObserver.onVSRspCallBack<CertifiedAccountWrite.StDoCommentRsp>
{
  zuj(zug paramzug, CertifiedAccountMeta.StComment paramStComment) {}
  
  public void a(VSBaseRequest paramVSBaseRequest, boolean paramBoolean, long paramLong, String paramString, CertifiedAccountWrite.StDoCommentRsp paramStDoCommentRsp)
  {
    wad.a().dispatch(this.jdField_a_of_type_Zug.a(new Object[] { Integer.valueOf(3), Long.valueOf(paramLong), paramString, paramStDoCommentRsp, this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment.id.get(), Integer.valueOf(this.jdField_a_of_type_Zug.hashCode()) }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zuj
 * JD-Core Version:    0.7.0.1
 */