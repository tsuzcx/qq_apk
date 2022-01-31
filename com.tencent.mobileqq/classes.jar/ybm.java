import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StComment;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StReply;
import NS_CERTIFIED_ACCOUNT_WRITE.CertifiedAccountWrite.StDoReplyRsp;
import com.tencent.mobileqq.pb.PBStringField;
import com.tribe.async.dispatch.Dispatcher;

class ybm
  implements yvn<CertifiedAccountWrite.StDoReplyRsp>
{
  ybm(ybg paramybg, CertifiedAccountMeta.StReply paramStReply, CertifiedAccountMeta.StComment paramStComment) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, CertifiedAccountWrite.StDoReplyRsp paramStDoReplyRsp)
  {
    if ((paramStDoReplyRsp != null) && (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StReply != null)) {
      paramStDoReplyRsp.reply.id.set(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StReply.id.get());
    }
    uht.a().dispatch(this.jdField_a_of_type_Ybg.a(new Object[] { Integer.valueOf(6), Long.valueOf(paramLong), paramString, paramStDoReplyRsp, this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment, Integer.valueOf(this.jdField_a_of_type_Ybg.hashCode()) }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ybm
 * JD-Core Version:    0.7.0.1
 */