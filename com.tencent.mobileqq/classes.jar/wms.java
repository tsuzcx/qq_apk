import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StComment;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StReply;
import NS_CERTIFIED_ACCOUNT_WRITE.CertifiedAccountWrite.StDoReplyRsp;
import com.tencent.mobileqq.pb.PBStringField;
import com.tribe.async.dispatch.Dispatcher;

class wms
  implements xgu<CertifiedAccountWrite.StDoReplyRsp>
{
  wms(wmn paramwmn, CertifiedAccountMeta.StComment paramStComment, CertifiedAccountMeta.StReply paramStReply) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, CertifiedAccountWrite.StDoReplyRsp paramStDoReplyRsp)
  {
    stb.a().dispatch(this.jdField_a_of_type_Wmn.a(new Object[] { Integer.valueOf(4), Long.valueOf(paramLong), paramString, paramStDoReplyRsp, this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment, this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StReply.id.get(), Integer.valueOf(this.jdField_a_of_type_Wmn.hashCode()) }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wms
 * JD-Core Version:    0.7.0.1
 */