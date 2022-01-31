import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import com.tencent.biz.subscribe.comment.CommentBottomBar;
import com.tencent.qphone.base.util.QLog;

class wle
  implements wtn
{
  wle(wkx paramwkx, CertifiedAccountMeta.StFeed paramStFeed) {}
  
  public void a(int paramInt)
  {
    QLog.d(wkx.jdField_a_of_type_JavaLangString, 2, "count:" + paramInt);
    if ((wkx.n(this.jdField_a_of_type_Wkx) != null) && (paramInt == 1))
    {
      if (wtm.a().a(wkx.o(this.jdField_a_of_type_Wkx), "subscribe_sp_key_show_praise_guide") != 0) {
        break label90;
      }
      if ((this.jdField_a_of_type_Wkx.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar != null) && (!this.jdField_a_of_type_Wkx.jdField_a_of_type_ComTencentBizSubscribeCommentCommentBottomBar.a())) {
        this.jdField_a_of_type_Wkx.f();
      }
    }
    label90:
    while ((wtm.a().a(wkx.p(this.jdField_a_of_type_Wkx), "subscribe_sp_key_show_follow_guide") != 0) || (wiw.a(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed))) {
      return;
    }
    this.jdField_a_of_type_Wkx.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wle
 * JD-Core Version:    0.7.0.1
 */