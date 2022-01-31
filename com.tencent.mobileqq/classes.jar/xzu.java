import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import com.tencent.biz.subscribe.comment.CommentBottomBar;
import com.tencent.qphone.base.util.QLog;

class xzu
  implements yic
{
  xzu(xzn paramxzn, CertifiedAccountMeta.StFeed paramStFeed) {}
  
  public void a(int paramInt)
  {
    QLog.d(xzn.jdField_a_of_type_JavaLangString, 2, "count:" + paramInt);
    if ((xzn.n(this.jdField_a_of_type_Xzn) != null) && (paramInt == 1))
    {
      if (yib.a().a(xzn.o(this.jdField_a_of_type_Xzn), "subscribe_sp_key_show_praise_guide") != 0) {
        break label90;
      }
      if ((this.jdField_a_of_type_Xzn.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar != null) && (!this.jdField_a_of_type_Xzn.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar.a())) {
        this.jdField_a_of_type_Xzn.f();
      }
    }
    label90:
    while ((yib.a().a(xzn.p(this.jdField_a_of_type_Xzn), "subscribe_sp_key_show_follow_guide") != 0) || (xxl.a(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed))) {
      return;
    }
    this.jdField_a_of_type_Xzn.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xzu
 * JD-Core Version:    0.7.0.1
 */