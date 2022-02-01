import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StComment;
import NS_CERTIFIED_ACCOUNT_WRITE.CertifiedAccountWrite.StDoCommentRsp;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.VSBaseRequest;
import com.tencent.mobileqq.pb.PBStringField;
import com.tribe.async.dispatch.Dispatcher;

class zuk
  implements VSDispatchObserver.onVSRspCallBack<CertifiedAccountWrite.StDoCommentRsp>
{
  zuk(zug paramzug, CertifiedAccountMeta.StComment paramStComment) {}
  
  public void a(VSBaseRequest paramVSBaseRequest, boolean paramBoolean, long paramLong, String paramString, CertifiedAccountWrite.StDoCommentRsp paramStDoCommentRsp)
  {
    if ((paramStDoCommentRsp != null) && (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment != null)) {
      paramStDoCommentRsp.comment.id.set(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment.id.get());
    }
    wad.a().dispatch(this.jdField_a_of_type_Zug.a(new Object[] { Integer.valueOf(5), Long.valueOf(paramLong), paramString, paramStDoCommentRsp, Integer.valueOf(this.jdField_a_of_type_Zug.hashCode()) }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zuk
 * JD-Core Version:    0.7.0.1
 */