import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StComment;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StReply;
import NS_CERTIFIED_ACCOUNT_WRITE.CertifiedAccountWrite.StDoReplyRsp;
import com.tencent.mobileqq.pb.PBStringField;
import com.tribe.async.dispatch.Dispatcher;

class sco
  implements rxc.a<CertifiedAccountWrite.StDoReplyRsp>
{
  sco(sci paramsci, CertifiedAccountMeta.StReply paramStReply, CertifiedAccountMeta.StComment paramStComment) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, CertifiedAccountWrite.StDoReplyRsp paramStDoReplyRsp)
  {
    if ((paramStDoReplyRsp != null) && (this.jdField_b_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StReply != null)) {
      paramStDoReplyRsp.reply.id.set(this.jdField_b_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StReply.id.get());
    }
    pmi.a().dispatch(this.a.a(new Object[] { Integer.valueOf(6), Long.valueOf(paramLong), paramString, paramStDoReplyRsp, this.jdField_b_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment, Integer.valueOf(this.a.hashCode()) }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sco
 * JD-Core Version:    0.7.0.1
 */