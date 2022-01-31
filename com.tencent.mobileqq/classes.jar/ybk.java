import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StComment;
import NS_CERTIFIED_ACCOUNT_WRITE.CertifiedAccountWrite.StDoCommentRsp;
import com.tencent.mobileqq.pb.PBStringField;
import com.tribe.async.dispatch.Dispatcher;

class ybk
  implements yvn<CertifiedAccountWrite.StDoCommentRsp>
{
  ybk(ybg paramybg, CertifiedAccountMeta.StComment paramStComment) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, CertifiedAccountWrite.StDoCommentRsp paramStDoCommentRsp)
  {
    if ((paramStDoCommentRsp != null) && (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment != null)) {
      paramStDoCommentRsp.comment.id.set(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment.id.get());
    }
    uht.a().dispatch(this.jdField_a_of_type_Ybg.a(new Object[] { Integer.valueOf(5), Long.valueOf(paramLong), paramString, paramStDoCommentRsp, Integer.valueOf(this.jdField_a_of_type_Ybg.hashCode()) }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ybk
 * JD-Core Version:    0.7.0.1
 */